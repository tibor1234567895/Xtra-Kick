import hashlib
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
        self.remote = {path.name: {"id": index, "name": path.name} for index, path in enumerate(self.paths, 1)}
        self.fail_upload = False
        self.fail_metadata_promotion = False
        self.bad_metadata_digest = False
        for path in self.paths:
            path.write_bytes(path.name.encode())

    def publish(self):
        with (
            patch.object(publish_release, "latest_release", return_value={"id": 10}),
            patch.object(publish_release, "assets", side_effect=lambda _: self.remote.copy()),
            patch.object(publish_release, "gh", side_effect=self.gh),
            patch.object(publish_release, "rename", side_effect=self.rename),
        ):
            publish_release.publish("219", "head", "notes.txt", self.paths)

    def gh(self, *args):
        if args[:2] == ("release", "upload"):
            if self.fail_upload:
                raise subprocess.CalledProcessError(1, args)
            for index, path in enumerate(map(Path, args[4:]), 3):
                digest = hashlib.sha256(path.read_bytes()).hexdigest()
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
        elif args[:2] != ("release", "edit"):
            self.fail(f"Unexpected command: {args}")

    def rename(self, asset, name):
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
