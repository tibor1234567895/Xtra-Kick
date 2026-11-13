import json
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch
from urllib.error import HTTPError, URLError

import release_version as version


class ReleaseVersionTest(unittest.TestCase):
    def setUp(self):
        self.directory = tempfile.TemporaryDirectory()
        self.addCleanup(self.directory.cleanup)
        self.cache = Path(self.directory.name) / "version.json"

    def test_ci_runs_advance_and_rerunning_the_same_run_keeps_its_code(self):
        self.assertEqual(213, version.ci_code(92))
        self.assertEqual(214, version.ci_code(93))
        self.assertEqual(version.ci_code(92), version.ci_code(92))
        for run in (0, -1, version.MAX_VERSION_CODE):
            with self.assertRaises(ValueError):
                version.ci_code(run)

    @patch.object(version, "published_code", return_value=213)
    def test_repeated_local_builds_reuse_the_published_code(self, published):
        self.assertEqual(213, version.local_code(self.cache))
        self.assertEqual(213, version.local_code(self.cache))
        self.assertEqual({"versionCode": 213}, json.loads(self.cache.read_text()))

    @patch.object(version, "published_code", side_effect=[213, 214])
    def test_a_new_published_release_refreshes_the_local_cache(self, published):
        self.assertEqual(213, version.local_code(self.cache))
        self.assertEqual(214, version.local_code(self.cache))
        self.assertEqual(214, version.local_code(self.cache, offline=True))

    @patch.object(version, "published_code", side_effect=URLError("offline"))
    def test_network_failure_uses_the_last_published_code(self, published):
        version.write_metadata(self.cache, 213)
        self.assertEqual(213, version.local_code(self.cache))

    @patch.object(version, "published_code")
    def test_offline_mode_never_contacts_github(self, published):
        version.write_metadata(self.cache, 213)
        self.assertEqual(213, version.local_code(self.cache, offline=True))
        published.assert_not_called()

    @patch.object(version, "published_code", side_effect=URLError("offline"))
    def test_missing_or_corrupt_cache_fails_instead_of_inventing_a_code(self, published):
        with self.assertRaises(ValueError):
            version.local_code(self.cache)
        with self.assertRaises(ValueError):
            version.local_code(self.cache, offline=True)
        self.cache.write_text("invalid", encoding="utf-8")
        with self.assertRaises(ValueError):
            version.local_code(self.cache, offline=True)

    def test_metadata_rejects_invalid_version_codes(self):
        for code in (True, "213", None, 0, -1, version.MAX_VERSION_CODE + 1):
            with self.assertRaises(ValueError):
                version.read_metadata(json.dumps({"versionCode": code}))

    @patch.object(version, "fetch_text", return_value='{"versionCode": 213}')
    def test_published_metadata_is_used_without_consulting_source_defaults(self, fetch):
        self.assertEqual(213, version.published_code())
        fetch.assert_called_once_with(version.METADATA_URL)

    @patch.object(version, "fetch_text")
    def test_legacy_release_can_bootstrap_the_first_cache(self, fetch):
        fetch.side_effect = [
            HTTPError(version.METADATA_URL, 404, "missing", None, None),
            'versionCode = 121\nversionName = "2.54.0"\n',
        ]
        self.assertEqual(121, version.published_code())

    @patch.object(version, "fetch_text")
    def test_new_releases_without_metadata_cannot_use_the_debug_default(self, fetch):
        fetch.side_effect = [
            HTTPError(version.METADATA_URL, 404, "missing", None, None),
            'versionCode = 122\nversionName = "2.55.0"\n',
        ]
        with self.assertRaises(ValueError):
            version.published_code()

    @patch.object(version, "fetch_text", side_effect=HTTPError(version.METADATA_URL, 503, "unavailable", None, None))
    def test_server_errors_do_not_trigger_legacy_bootstrap(self, fetch):
        with self.assertRaises(HTTPError):
            version.published_code()
        fetch.assert_called_once()


if __name__ == "__main__":
    unittest.main()
