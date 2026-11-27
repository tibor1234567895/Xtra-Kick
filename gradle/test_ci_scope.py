import unittest
from unittest.mock import patch

import ci_scope


class TestScope(unittest.TestCase):
    def test_docs_only(self):
        self.assertEqual(ci_scope.classify(["README.md", "docs/guide with spaces.md"]), "docs")

    def test_small_graphic_or_jvm_test_change(self):
        self.assertEqual(ci_scope.classify([
            "app/src/main/res/drawable-hdpi/onboarding.webp", "app/src/test/java/UpdateTest.kt",
        ]), "small")

    def test_sensitive_paths_trigger_full_suite(self):
        for path in (
            ".github/workflows/ci.yml", "gradle/libs.versions.toml", "settings.gradle.kts",
            "app/build.gradle.kts", "app/proguard-rules.pro", "app/src/main/AndroidManifest.xml",
            "app/src/main/res/layout/player.xml", "app/src/main/res/values-de/strings.xml",
            "app/src/main/java/com/xtrakick/app/player/PlayerFragment.kt",
            "app/src/androidTest/java/StartupTest.kt", "build-logic/unknown.txt",
            "app/src/main/assets/welcome.md",
        ):
            with self.subTest(path=path):
                self.assertEqual(ci_scope.classify(["README.md", path]), "full")

    def test_missing_or_unavailable_base_fails_open_to_full(self):
        for base in (None, "0" * 40, "missing-test-scope-base"):
            with self.subTest(base=base):
                self.assertEqual(ci_scope.compare(base), "full")

    @patch("ci_scope.subprocess.run")
    def test_diff_does_not_hide_renamed_sources(self, git):
        git.return_value.stdout = b"app/src/main/Old.kt\0docs/archive.md\0"
        self.assertEqual(ci_scope.compare("base"), "full")
        self.assertIn("--no-renames", git.call_args.args[0])
