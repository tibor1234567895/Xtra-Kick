import hashlib
import json
from pathlib import Path
import subprocess
import tempfile
import unittest
from unittest.mock import patch

import publish_release


class PublishReleaseTest(unittest.TestCase):
    def setUp(self):
        self.directory = tempfile.TemporaryDirectory()
        self.addCleanup(self.directory.cleanup)
        root = Path(self.directory.name)
        self.paths = [root / "app-release.apk", root / "release-version.json"]
        self.notes = root / "notes.txt"
        self.notes.write_text("Release notes", encoding="utf-8")
        self.remote = {path.name: {"id": index, "name": path.name} for index, path in enumerate(self.paths, 1)}
        self.uploaded = {}
        self.next_asset_id = 3
        self.tag_sha = "old"
        self.fail_upload = False
        self.fail_metadata_promotion = False
        self.bad_metadata_digest = False
        self.fail_draft = False
        self.refreshes_timestamp = True
        self.fail_republish_count = 0
        self.draft_set = False
        self.republished = False
        self.release = {"id": 10, "tag_name": "latest", "draft": False, "published_at": "2026-11-17T00:00:00Z"}
        for path in self.paths:
            path.write_bytes(path.name.encode())

    def publish(self, recover=False):
        with (
            patch.object(publish_release, "latest_release", return_value=self.release.copy()),
            patch.object(publish_release, "assets", side_effect=lambda _: self.remote.copy()),
            patch.object(publish_release, "gh", side_effect=self.gh),
            patch.object(publish_release, "rename", side_effect=self.rename),
            patch.object(publish_release.time, "sleep", return_value=None),
        ):
            if recover:
                return publish_release.recover_publication()
            publish_release.publish("219", "head", self.notes, self.paths)

    def gh(self, *args, input_text=None):
        if args[:2] == ("release", "upload"):
            if self.fail_upload:
                raise subprocess.CalledProcessError(1, args)
            for value in args[3:]:
                if value == "--clobber":
                    continue
                path = Path(value)
                index = self.next_asset_id
                self.next_asset_id += 1
                self.uploaded[index] = path.read_bytes()
                digest = hashlib.sha256(self.uploaded[index]).hexdigest()
                self.remote[path.name] = {
                    "id": index,
                    "name": path.name,
                    "state": "uploaded",
                    "digest": "sha256:mismatch" if self.bad_metadata_digest and index == 4 else f"sha256:{digest}",
                }
        elif args[:3] == ("api", "--method", "DELETE"):
            asset_id = int(args[3].rsplit("/", 1)[1])
            name = next(name for name, asset in self.remote.items() if asset["id"] == asset_id)
            del self.remote[name]
        elif args == ("api", "repos/{owner}/{repo}/releases/10"):
            return json.dumps(self.release)
        elif args == ("api", "repos/{owner}/{repo}/git/ref/tags/latest"):
            return json.dumps({"object": {"sha": self.tag_sha}})
        elif args[:4] == ("api", "--method", "PATCH", "repos/{owner}/{repo}/git/refs/tags/latest"):
            self.assertTrue(self.release["draft"])
            self.tag_sha = json.loads(input_text)["sha"]
        elif args[-2:] == ("-H", "Accept: application/octet-stream"):
            return self.uploaded[int(args[1].rsplit("/", 1)[1])].decode("utf-8")
        elif args[-2:] == ("-F", "draft=true"):
            self.assertIn(publish_release.RECOVERY_ASSET, self.remote)
            if self.fail_draft:
                raise subprocess.CalledProcessError(1, args)
            self.draft_set = True
            self.release["draft"] = True
            return json.dumps(self.release)
        elif args[:4] == ("api", "--method", "PATCH", "repos/{owner}/{repo}/releases/10"):
            self.assertEqual(json.loads(input_text),
                             {"draft": False, "name": "Latest", "body": "Release notes", "make_latest": "true"})
            if self.fail_republish_count > 0:
                self.fail_republish_count -= 1
                raise subprocess.CalledProcessError(1, args)
            self.assertEqual(self.tag_sha, "head")
            self.republished = True
            self.release["draft"] = False
            if self.refreshes_timestamp:
                self.release["published_at"] = "2026-11-19T00:00:00Z"
            return json.dumps(self.release)
        else:
            self.fail(f"Unexpected command: {args}")

    def rename(self, asset, name):
        self.assertTrue(self.release["draft"])
        self.assertIn(publish_release.RECOVERY_ASSET, self.remote)
        old = next(key for key, value in self.remote.items() if value["id"] == asset["id"])
        self.assertNotIn(name, self.remote)
        self.remote[name] = self.remote.pop(old) | {"name": name}
        self.assertTrue(any(key.endswith(".apk") for key in self.remote))
        if self.fail_metadata_promotion and asset["id"] == 4 and name == "release-version.json":
            raise subprocess.CalledProcessError(1, "rename")

    def test_upload_failure_preserves_public_assets(self):
        self.fail_upload = True
        with self.assertRaises(subprocess.CalledProcessError):
            self.publish()
        self.assertEqual(self.remote["app-release.apk"]["id"], 1)
        self.assertEqual(self.remote["release-version.json"]["id"], 2)
        self.assertNotIn(publish_release.RECOVERY_ASSET, self.remote)

    def test_digest_mismatch_preserves_public_assets(self):
        self.bad_metadata_digest = True
        with self.assertRaises(ValueError):
            self.publish()
        self.assertEqual(self.remote["app-release.apk"]["id"], 1)
        self.assertEqual(self.remote["release-version.json"]["id"], 2)

    def test_metadata_promotion_failure_restores_both_assets(self):
        self.fail_metadata_promotion = True
        with self.assertRaises(subprocess.CalledProcessError):
            self.publish()
        self.assertEqual(self.remote["app-release.apk"]["id"], 1)
        self.assertEqual(self.remote["release-version.json"]["id"], 2)

    def test_success_replaces_both_assets_at_the_existing_urls(self):
        self.publish()
        self.assertEqual({name: asset["id"] for name, asset in self.remote.items()},
                         {"app-release.apk": 3, "release-version.json": 4})
        self.assertTrue(self.draft_set)
        self.assertTrue(self.republished)

    def test_interrupted_swap_can_resume_after_the_old_manifest_is_renamed(self):
        rename = self.rename

        def interrupt_after_rename(asset, name):
            rename(asset, name)
            if name == "previous-2-release-version.json":
                raise KeyboardInterrupt

        with patch.object(self, "rename", side_effect=interrupt_after_rename):
            with self.assertRaises(KeyboardInterrupt):
                self.publish()
        self.assertEqual(self.remote["app-release.apk"]["id"], 3)
        self.assertNotIn("release-version.json", self.remote)
        self.assertTrue(self.release["draft"])
        journal = self.remote[publish_release.RECOVERY_ASSET]
        self.assertEqual(json.loads(self.uploaded[journal["id"]])["sha"], "head")

        self.publish(recover=True)
        self.assertEqual({name: asset["id"] for name, asset in self.remote.items()},
                         {"app-release.apk": 3, "release-version.json": 4})
        self.assertTrue(self.republished)

    def test_draft_failure_leaves_the_current_public_pair_in_place(self):
        self.fail_draft = True
        with self.assertRaises(subprocess.CalledProcessError):
            self.publish()
        self.assertEqual(self.remote["app-release.apk"]["id"], 1)
        self.assertEqual(self.remote["release-version.json"]["id"], 2)
        self.assertFalse(self.draft_set)
        self.assertFalse(self.republished)

    def test_republish_retry_on_transient_failure(self):
        self.fail_republish_count = 2
        self.publish()
        self.assertEqual({name: asset["id"] for name, asset in self.remote.items()},
                         {"app-release.apk": 3, "release-version.json": 4})
        self.assertTrue(self.draft_set)
        self.assertTrue(self.republished)

    def test_unchanged_timestamp_warns_after_confirming_publication(self):
        self.refreshes_timestamp = False
        with patch("sys.stdout") as output:
            self.publish()
        output.write.assert_any_call(
            "::warning::GitHub kept the previous release publication date (2026-11-17T00:00:00Z)."
        )
        self.assertFalse(self.release["draft"])

    def test_republish_raises_after_three_failures(self):
        self.fail_republish_count = 3
        with self.assertRaises(subprocess.CalledProcessError):
            self.publish()
        self.assertTrue(self.draft_set)
        self.assertFalse(self.republished)
        self.assertIn(publish_release.RECOVERY_ASSET, self.remote)
        self.publish(recover=True)
        self.assertFalse(self.release["draft"])

    def test_recovery_refuses_a_changed_asset(self):
        self.fail_republish_count = 3
        with self.assertRaises(subprocess.CalledProcessError):
            self.publish()
        self.remote["app-release.apk"]["id"] = 99
        with self.assertRaisesRegex(ValueError, "missing or has changed"):
            self.publish(recover=True)
        self.assertTrue(self.release["draft"])
        self.assertFalse(self.republished)

    def test_recovery_without_a_record_cannot_publish(self):
        self.assertFalse(self.publish(recover=True))
        self.assertFalse(self.republished)
