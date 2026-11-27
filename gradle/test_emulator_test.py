import subprocess
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch
from zipfile import ZipFile

from emulator_test import (
    APP_PACKAGE,
    Emulator,
    InfrastructureFailure,
    NATIVE_LIBRARIES,
    TEST_PACKAGE,
    TestFailure,
    apk_version,
    app_crash_log,
    app_events,
    instrumentation_count,
    redacted,
)


def result(output, return_code=0):
    return subprocess.CompletedProcess(["adb"], return_code, stdout=output.encode())


class ApkMetadataTest(unittest.TestCase):
    def test_only_instrumentation_may_omit_the_version_code(self):
        with tempfile.TemporaryDirectory() as directory:
            apk = Path(directory) / "qa.apk"
            apk.touch()
            for package in (TEST_PACKAGE, APP_PACKAGE):
                with patch("emulator_test.run", return_value=result(f"package: name='{package}' versionCode=''")):
                    if package == TEST_PACKAGE:
                        self.assertEqual(apk_version("aapt2", apk, package), 0)
                    else:
                        with self.assertRaisesRegex(InfrastructureFailure, "must declare a version code"):
                            apk_version("aapt2", apk, package)

    def test_wrong_package_is_rejected_before_any_install(self):
        with tempfile.TemporaryDirectory() as directory:
            apk = Path(directory) / "qa.apk"
            apk.touch()
            with patch("emulator_test.run", return_value=result("package: name='unrelated.app' versionCode='2'")):
                with self.assertRaisesRegex(InfrastructureFailure, "must have package"):
                    apk_version("aapt2", apk, APP_PACKAGE)

    def test_both_native_libraries_are_required_on_x86_64(self):
        with tempfile.TemporaryDirectory() as directory:
            apk = Path(directory) / "qa.apk"
            with ZipFile(apk, "w") as archive:
                archive.writestr("lib/arm64-v8a/libplayercore.so", "wrong ABI")
            with patch("emulator_test.run", return_value=result(f"package: name='{APP_PACKAGE}' versionCode='2'")):
                with self.assertRaisesRegex(InfrastructureFailure, "missing native libraries"):
                    apk_version("aapt2", apk, APP_PACKAGE, require_native=True)
                with ZipFile(apk, "a") as archive:
                    for library in NATIVE_LIBRARIES:
                        archive.writestr(library, "fixture")
                self.assertEqual(apk_version("aapt2", apk, APP_PACKAGE, require_native=True), 2)


class InstrumentationResultTest(unittest.TestCase):
    def test_verify_uses_getconf_page_size_for_emulated_16k_and_falls_back_to_smaps(self):
        props = {
            "ro.build.version.sdk": "37",
            "ro.build.version.release": "17",
            "ro.build.version.security_patch": "2026-08-05",
            "ro.product.cpu.abi": "x86_64",
            "ro.product.cpu.abilist": "x86_64,arm64-v8a",
            "ro.kernel.qemu": "1",
            "ro.boot.qemu": "1",
            "ro.build.version.extensions.s": "",
            "ro.build.version.extensions.t": "",
            "sys.boot_completed": "1",
        }
        emulator = Emulator("adb", "emulator-5554")

        def fake_read(*args):
            if args[0] == "getprop":
                return props[args[1]]
            if args[0] == "date":
                return "11-27 20:00:00.000"
            if args[0] == "grep":
                return "KernelPageSize:        4 kB"
            raise AssertionError(f"Unexpected read: {args}")

        with patch.object(emulator, "read", side_effect=fake_read), \
                patch.object(emulator, "shell", return_value=result("16384\n")):
            emulator.verify(37, 16384)
            self.assertEqual(emulator.configuration["device_page_size"], "16384")

        props["ro.build.version.sdk"] = "26"
        with patch.object(emulator, "read", side_effect=fake_read), \
                patch.object(emulator, "shell", return_value=result("getconf: not found", return_code=127)):
            emulator.verify(26, 4096)
            self.assertEqual(emulator.configuration["device_page_size"], "4096")

    def test_pidof_can_include_a_zombie_after_force_stop(self):
        emulator = Emulator("adb", "emulator-5554")
        with patch.object(emulator, "shell", side_effect=[
            result("10 11"), result("10 (app) Z 1"), result("11 (app) S 1"),
        ]):
            self.assertEqual(emulator.pid(), "11")

    def test_force_stop_can_immediately_resume_activity_in_new_process(self):
        emulator = Emulator("adb", "emulator-5554")
        with patch.object(emulator, "pid", side_effect=["10", "11"]), patch.object(emulator, "read") as read:
            with patch.object(emulator, "launch") as launch:
                emulator.relaunch()
            launch.assert_not_called()
        read.assert_called_once_with("am", "force-stop", "--user", "0", APP_PACKAGE)

    def test_raw_runner_success_requires_positive_matching_test_count(self):
        output = (
            "INSTRUMENTATION_STATUS_CODE: 1\r\n"
            "INSTRUMENTATION_STATUS_CODE: 0\r\n"
            "INSTRUMENTATION_RESULT: stream=\r\n"
            "OK (1 test)\r\n"
            "INSTRUMENTATION_CODE: -1\r\n"
        )
        self.assertEqual(instrumentation_count(result(output)), 1)
        for damaged in (
            output.replace("1 test", "0 tests"),
            output.replace("1 test", "2 tests"),
            output.replace("STATUS_CODE: 0", "STATUS_CODE: 1"),
            output.rsplit("INSTRUMENTATION_CODE:", 1)[0],
            "INSTRUMENTATION_RESULT: stream=\nOK (0 tests)\nINSTRUMENTATION_CODE: -1\n",
        ):
            with self.subTest(damaged=damaged), self.assertRaises(InfrastructureFailure):
                instrumentation_count(result(damaged))
        with self.assertRaises(InfrastructureFailure):
            instrumentation_count(result(output, return_code=1))

    def test_test_failures_and_skips_fail_even_if_adb_exits_zero(self):
        for code in (-1, -2, -3, -4):
            with self.subTest(code=code), self.assertRaises(TestFailure):
                instrumentation_count(result(f"INSTRUMENTATION_STATUS_CODE: {code}\nINSTRUMENTATION_CODE: -1\n"))

    def test_process_crash_and_missing_runner_have_distinct_outcomes(self):
        with self.assertRaises(TestFailure):
            instrumentation_count(result("INSTRUMENTATION_RESULT: shortMsg=Process crashed."))
        with self.assertRaises(InfrastructureFailure):
            instrumentation_count(result("INSTRUMENTATION_FAILED: runner missing"))


class DiagnosticsTest(unittest.TestCase):
    def test_app_events_only_include_the_qa_process_and_its_children(self):
        actual = f"I/am_anr  (  812): [0,415,{APP_PACKAGE}:player,1,reason]"
        unrelated = f"I/am_crash(  812): [0,416,{APP_PACKAGE}.other,1,reason]"
        other_subject = f"I/am_anr  (  812): [0,415,other.app,1,mentions {APP_PACKAGE}]"
        self.assertEqual(app_events(f"{unrelated}\n{actual}\n{other_subject}\n"), actual)

    def test_crash_log_keeps_java_and_native_stacks_for_the_qa_process(self):
        java_header = f"E/AndroidRuntime(110): Process: {APP_PACKAGE}, PID: 110"
        native_header = f"F/DEBUG(140): pid: 115, tid: 120, name: example >>> {APP_PACKAGE} <<<"
        java_stack = "E/AndroidRuntime(110): at example.method(Example.java:1)"
        native_stack = "F/DEBUG(140): #00 pc 00000000 libplayercore.so"
        unrelated = "E/AndroidRuntime(300): Process: example.unrelated.app, PID: 300"
        self.assertEqual(
            app_crash_log("\n".join([java_header, unrelated, java_stack, native_header, native_stack])),
            "\n".join([java_header, java_stack, native_header, native_stack]),
        )

    def test_sensitive_values_and_url_queries_are_redacted(self):
        raw = "test failed for https://example.test/token?key=foo\nAuthorization: Bearer bar\ntoken=baz"
        safe = redacted(raw)
        for value in ("foo", "bar", "baz"):
            self.assertNotIn(value, safe)
