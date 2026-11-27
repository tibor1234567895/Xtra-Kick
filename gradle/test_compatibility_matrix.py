import unittest

from compatibility_matrix import select


class TestCompatibilityMatrix(unittest.TestCase):
    def test_default_profiles(self):
        for profile, expected, suite in (
            ("smoke", [26], "smoke"),
            ("routine", [26, 30, 33, 36], "smoke"),
            ("extended", [*range(26, 38), 37], "functional"),
            ("release", [26, 30, 33, 36], "smoke"),
        ):
            with self.subTest(profile=profile):
                matrix, selected_suite, minified = select(profile, "", "auto")
                self.assertEqual([lane["sdk"] for lane in matrix["include"]], expected)
                self.assertEqual(selected_suite, suite)
                self.assertEqual(minified, profile == "release")

    def test_actual_package_and_duplicate_override(self):
        matrix, _, _ = select("release", "27, 37, 37-16k, 27", "smoke")
        self.assertEqual([lane["image"] for lane in matrix["include"]], ["27", "37.0", "37.0"])
        self.assertEqual([lane["target"] for lane in matrix["include"]], ["default", "default", "google_apis_ps16k"])
        self.assertEqual(matrix["include"][-1]["page_size"], 16384)

    def test_invalid_configuration_cannot_silently_reduce_coverage(self):
        for values in (("missing", "", "auto"), ("routine", "25", "auto"),
                       ("routine", "26,", "auto"), ("routine", "26", "unknown")):
            with self.subTest(values=values), self.assertRaises(ValueError):
                select(*values)
