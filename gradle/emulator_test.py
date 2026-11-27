"""Run QA APKs on one disposable x86_64 Android emulator."""

import argparse
from contextlib import ExitStack
import os
from pathlib import Path
import re
import shlex
import shutil
import subprocess
import sys
import time
from zipfile import BadZipFile, ZipFile


APP_PACKAGE = "com.github.andreyasadchy.xtrakick.test"
TEST_PACKAGE = APP_PACKAGE + ".instrumentation"
TEST_RUNNER = TEST_PACKAGE + "/androidx.test.runner.AndroidJUnitRunner"
ACTIVITY = APP_PACKAGE + "/com.xtrakick.app.ui.main.MainActivity"
SMOKE_TEST = "com.xtrakick.app.qa.AppSmokeTest"
FUNCTIONAL_TEST = "com.xtrakick.app.qa.AppFunctionalTest"
PROCESS_TEST = "com.xtrakick.app.qa.ProcessStateTest#verifyOnboardingAfterProcessRestart"
UPGRADE_TEST = "com.xtrakick.app.qa.UpgradeStateTest"
PLAYBACK_FIXTURE = Path(__file__).with_name("fixtures") / "qa-playback.mp4"
PLAYBACK_DEVICE_PATH = "/sdcard/Download/xtrakick-qa-playback.mp4"
NATIVE_LIBRARIES = {"lib/x86_64/libplayercore.so", "lib/x86_64/libglide-webp.so"}
APP_PATTERN = re.compile(r"(?<![\w.])" + re.escape(APP_PACKAGE) + r"(?=[\s:/,\]]|$)")
LOG_LIMIT = 64 * 1024
PNG_LIMIT = 2 * 1024 * 1024


class InfrastructureFailure(Exception):
    pass


class TestFailure(Exception):
    pass


def run(command, timeout=30):
    return subprocess.run(command, stdin=subprocess.DEVNULL, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                          timeout=timeout)


def decoded(output):
    return output.decode("utf-8", "replace")


def redacted(output):
    output = re.sub(r"(?i)\bhttps?://[^\s<>\"']+", "<url>", output)
    output = re.sub(r"(?i)\bBearer\s+\S+", "Bearer <redacted>", output)
    return re.sub(r"(?i)(\b(?:authorization|cookie|(?:access|refresh|session|client)?[-_ ]?token|"
                  r"password|secret|api[-_ ]?key)\s*[:=]\s*)\S+",
                  r"\1<redacted>", output)


def checked(result, operation):
    if result.returncode != 0:
        raise InfrastructureFailure(f"{operation} failed: {redacted(decoded(result.stdout))[:500]}")
    return decoded(result.stdout).strip()


def version_tool(executable):
    if executable:
        return executable
    if installed := shutil.which("aapt2"):
        return installed
    for variable in ("ANDROID_SDK_ROOT", "ANDROID_HOME"):
        if sdk := os.environ.get(variable):
            name = "aapt2.exe" if os.name == "nt" else "aapt2"
            candidates = list((Path(sdk) / "build-tools").glob(f"*/{name}"))
            if candidates:
                return str(max(candidates, key=lambda path: tuple(map(int, re.findall(r"\d+", path.parent.name)))))
    raise InfrastructureFailure("aapt2 was not found. Set ANDROID_HOME or pass --aapt2.")


def apk_version(aapt2, path, package, require_native=False):
    if not path.is_file():
        raise InfrastructureFailure(f"Missing APK: {path.name}")
    output = checked(run([aapt2, "dump", "badging", str(path)]), f"Inspecting {path.name}")
    info = re.search(r"^package: name='([^']+)' versionCode='(\d*)'", output, re.MULTILINE)
    if not info or info[1] != package:
        raise InfrastructureFailure(f"{path.name} must have package {package}.")
    if not info[2] and package != TEST_PACKAGE:
        raise InfrastructureFailure(f"{path.name} must declare a version code.")
    if require_native:
        try:
            with ZipFile(path) as apk:
                missing = NATIVE_LIBRARIES.difference(apk.namelist())
                if missing:
                    raise InfrastructureFailure(f"{path.name} is missing native libraries: {', '.join(sorted(missing))}.")
        except BadZipFile as error:
            raise InfrastructureFailure(f"{path.name} is not a valid APK archive.") from error
    # AGP's instrumentation APK omits versionCode, which Android reports as 0.
    return int(info[2] or 0)


def instrumentation_count(result):
    output = decoded(result.stdout)
    codes = list(map(int, re.findall(r"^INSTRUMENTATION_STATUS_CODE: (-?\d+)\s*$", output, re.MULTILINE)))
    finished = re.findall(r"^INSTRUMENTATION_CODE: (-?\d+)\s*$", output, re.MULTILINE)
    if re.search(r"Process (?:crashed|died)", output, re.IGNORECASE):
        raise TestFailure("The app process crashed or died during instrumentation.")
    if any(code < 0 for code in codes) or "FAILURES!!!" in output:
        raise TestFailure("Instrumentation reported failed or skipped tests.")
    runner_error = re.search(r"^INSTRUMENTATION_(?:FAILED|RESULT: shortMsg)", output, re.MULTILINE)
    if result.returncode or finished != ["-1"] or runner_error:
        raise InfrastructureFailure("Instrumentation did not report normal runner completion.")
    expected_count = re.search(r"\bOK \((\d+) tests?\)", output)
    passed = codes.count(0)
    if not expected_count or not passed or passed != int(expected_count[1]) or passed != codes.count(1):
        raise InfrastructureFailure("Instrumentation did not report a complete, non-empty test run.")
    return passed


def app_events(log):
    subject = re.compile(r"\bam_(?:anr|crash)\s*\(\s*\d+\):\s*\[\d+,\s*\d+,\s*([^,\]]+)")
    return "\n".join(
        line for line in log.splitlines()
        if (match := subject.search(line)) and match[1].split(":", 1)[0].strip() == APP_PACKAGE
    )


def app_crash_log(log):
    # Identify app PIDs only from Java and native process headers. Keep their stack lines.
    entries = []
    pids = set()
    for line in log.splitlines():
        entry = re.match(r"[A-Z]/[^()]+\(\s*(\d+)\):\s?(.*)", line)
        if entry:
            pid, message = entry.groups()
            entries.append((pid, line))
            if message.startswith(("Process:", "Cmdline:", "pid:")) and APP_PATTERN.search(message):
                pids.add(pid)
    return "\n".join(line for pid, line in entries if pid in pids)


class Emulator:
    def __init__(self, adb, serial):
        self.command = [adb, "-s", serial]
        self.configuration = {}
        self.results = []
        self.start = None

    def adb(self, *args, timeout=30):
        return run([*self.command, *map(str, args)], timeout)

    def shell(self, *args, timeout=30):
        return self.adb("shell", shlex.join(map(str, args)), timeout=timeout)

    def read(self, *args, timeout=30):
        return checked(self.shell(*args, timeout=timeout), " ".join(map(str, args)))

    def verify(self, api, page_size):
        self.configuration = {
            value: self.read("getprop", value)
            for value in ("ro.build.version.sdk", "ro.build.version.release", "ro.build.version.security_patch",
                          "ro.product.cpu.abi", "ro.product.cpu.abilist", "ro.kernel.qemu", "ro.boot.qemu",
                          "ro.build.version.extensions.s", "ro.build.version.extensions.t")
        }
        if "1" not in (self.configuration["ro.kernel.qemu"], self.configuration["ro.boot.qemu"]):
            raise InfrastructureFailure("ADB target is not an Android emulator.")
        if self.configuration["ro.build.version.sdk"] != str(api):
            raise InfrastructureFailure(f"Expected API {api}, found {self.configuration['ro.build.version.sdk']}.")
        if self.configuration["ro.product.cpu.abi"] != "x86_64":
            raise InfrastructureFailure("Emulator primary ABI must be x86_64.")
        # Prefer getconf PAGE_SIZE so emulated 16 KB x86_64 images (google_apis_ps16k) report 16384
        # rather than the underlying 4 KB x86_64 kernel page size; fall back to smaps on API 26-28.
        page_result = self.shell("getconf", "PAGE_SIZE")
        raw_page = decoded(page_result.stdout).strip()
        if page_result.returncode == 0 and raw_page.isdecimal():
            self.configuration["device_page_size"] = raw_page
        else:
            mapping = self.read("grep", "-m1", "^KernelPageSize:", "/proc/self/smaps")
            size = re.fullmatch(r"KernelPageSize:\s+(\d+)\s+kB", mapping)
            if not size:
                raise InfrastructureFailure("Could not read the Android guest page size.")
            self.configuration["device_page_size"] = str(int(size[1]) * 1024)
        if page_size and self.configuration["device_page_size"] != str(page_size):
            raise InfrastructureFailure(f"Expected page size {page_size}, found {self.configuration['device_page_size']}.")
        if self.read("getprop", "sys.boot_completed") != "1":
            raise InfrastructureFailure("Emulator has not completed boot.")
        self.start = self.read("date", "+%m-%d %H:%M:%S.000")

    def cleanup(self, command, *args):
        try:
            result = command(*args, timeout=15)
            if result.returncode:
                print(f"Cleanup failed ({args[0]}). Restart the disposable emulator before reusing it.", file=sys.stderr)
        except (OSError, subprocess.TimeoutExpired):
            print(f"Cleanup unavailable ({args[0]}). Restart the disposable emulator before reusing it.", file=sys.stderr)

    def go_offline(self, cleanup):
        if self.read("id", "-u") != "0":
            checked(self.adb("root"), "Rooting disposable emulator")
            checked(self.adb("wait-for-device", timeout=45), "Reconnecting after adb root")
            if self.read("id", "-u") != "0":
                raise InfrastructureFailure("A rootable AOSP or Google APIs image is required for network isolation.")
            cleanup.callback(self.cleanup, self.adb, "unroot")
        for command in ("iptables", "ip6tables"):
            chain = "XTRAKICK_QA"
            self.read(command, "-N", chain)
            cleanup.callback(self.cleanup, self.shell, command, "-X", chain)
            cleanup.callback(self.cleanup, self.shell, command, "-F", chain)
            self.read(command, "-A", chain, "-o", "lo", "-j", "RETURN")
            self.read(command, "-A", chain, "-j", "REJECT")
            self.read(command, "-I", "OUTPUT", "1", "-j", chain)
            cleanup.callback(self.cleanup, self.shell, command, "-D", "OUTPUT", "-j", chain)
        for radio, setting in (("wifi", "wifi_on"), ("data", "mobile_data")):
            old_value = self.read("settings", "get", "global", setting)
            restore = "enable" if old_value in ("1", "2") else "disable"
            cleanup.callback(self.cleanup, self.shell, "svc", radio, restore)
            self.read("svc", radio, "disable")
        self.configuration["network"] = "Wi-Fi and cellular disabled, non-loopback egress rejected"

    def ensure_clean(self, package):
        path = self.shell("pm", "path", package)
        if "package:" in decoded(path.stdout):
            raise InfrastructureFailure(f"{package} is already installed. Use a clean disposable emulator.")

    def install(self, path, package, version, cleanup, replace=False):
        flags = ["-t", "-r"] if replace else ["-t"]
        if not replace:
            cleanup.callback(self.cleanup, self.adb, "uninstall", package)
        result = self.adb("install", *flags, path, timeout=120)
        output = decoded(result.stdout)
        if result.returncode or "Success" not in output.splitlines():
            self.results.append(("install " + path.name, output))
            if "INSTALL_FAILED_" in output and "INSUFFICIENT_STORAGE" not in output:
                raise TestFailure(f"Android rejected {path.name}.")
            raise InfrastructureFailure(f"ADB could not install {path.name}.")
        info = self.read("dumpsys", "package", package)
        if not re.search(rf"\bversionCode={version}\b", info):
            raise InfrastructureFailure(f"Installed {package} does not show expected version code {version}.")
        print(f"Installed {package} version code {version}.", flush=True)

    def instrument(self, test, timeout, **extras):
        args = ["am", "instrument", "-w", "-r", "-e", "class", test]
        for key, value in extras.items():
            args.extend(("-e", key, str(value)))
        try:
            result = self.shell(*args, TEST_RUNNER, timeout=timeout)
        except subprocess.TimeoutExpired as error:
            self.results.append((test, decoded(error.stdout or b"")))
            if self.adb("get-state").stdout.strip() == b"device":
                raise TestFailure(f"{test} timed out after {timeout}s on a connected device.") from error
            raise InfrastructureFailure(f"ADB disconnected while running {test}.") from error
        self.results.append((test, decoded(result.stdout)))
        count = instrumentation_count(result)
        print(f"{test}: {count} passed", flush=True)
        if test == FUNCTIONAL_TEST and b"PiP check unsupported on this system image" in result.stdout:
            print("PiP check unsupported on this system image.", flush=True)

    def launch(self, stage):
        try:
            result = self.shell("am", "start", "-W", "-n", ACTIVITY, timeout=45)
        except subprocess.TimeoutExpired as error:
            self.results.append((stage, decoded(error.stdout or b"")))
            if self.adb("get-state").stdout.strip() == b"device":
                raise TestFailure(f"Launcher Activity did not respond within 45 seconds at {stage}.") from error
            raise InfrastructureFailure(f"ADB disconnected at {stage}.") from error
        output = decoded(result.stdout)
        self.results.append((stage, output))
        if result.returncode or not re.search(r"^Status: ok\s*$", output, re.MULTILINE):
            raise TestFailure(f"Launcher Activity did not start at {stage}.")
        return self.pid()

    def pid(self):
        result = self.shell("pidof", APP_PACKAGE)
        if result.returncode == 1 and not result.stdout.strip():
            return None
        pids = checked(result, "Finding QA app process").split()
        live = []
        for pid in pids:
            if not pid.isdecimal():
                raise InfrastructureFailure("pidof did not return the expected QA process ID.")
            stat = self.shell("cat", f"/proc/{pid}/stat")
            if stat.returncode and b"No such file" in stat.stdout:
                continue
            state = checked(stat, "Reading QA app process state").rpartition(") ")[2].split()
            if not state:
                raise InfrastructureFailure("Could not determine the QA process state.")
            if state[0] != "Z":
                live.append(pid)
        if len(live) > 1:
            raise InfrastructureFailure("Multiple live processes have the QA package name.")
        return next(iter(live), None)

    def relaunch(self):
        original = self.pid()
        if not original:
            raise TestFailure("The app did not keep running after launch.")
        self.read("am", "force-stop", "--user", "0", APP_PACKAGE)
        deadline = time.monotonic() + 5
        replacement = self.pid()
        while replacement == original:
            if time.monotonic() >= deadline:
                raise TestFailure("The original app process survived force-stop.")
            time.sleep(0.1)
            replacement = self.pid()
        # Oreo can resume the underlying launcher Activity as the foreground Settings task exits.
        if replacement is None:
            replacement = self.launch("cold launch after force-stop")
        if not replacement or replacement == original:
            raise TestFailure("App process was not recreated after force-stop.")
        print("Launcher Activity started in a new process after force-stop.", flush=True)

    def stage_playback_fixture(self, cleanup):
        if not PLAYBACK_FIXTURE.is_file():
            raise InfrastructureFailure("Missing local playback fixture.")
        if self.shell("test", "-e", PLAYBACK_DEVICE_PATH).returncode == 0:
            raise InfrastructureFailure("The disposable emulator already contains the playback fixture.")
        self.read("mkdir", "-p", PLAYBACK_DEVICE_PATH.rsplit("/", 1)[0])
        cleanup.callback(self.cleanup, self.shell, "rm", "-f", PLAYBACK_DEVICE_PATH)
        checked(self.adb("push", PLAYBACK_FIXTURE, PLAYBACK_DEVICE_PATH), "Copying the playback fixture")
        self.read("am", "broadcast", "-a", "android.intent.action.MEDIA_SCANNER_SCAN_FILE",
                  "-d", "file://" + PLAYBACK_DEVICE_PATH)

    def failure_events(self):
        if not self.start:
            return ""
        logs = self.read("logcat", "-b", "events", "-d", "-v", "brief", "-T", self.start,
                         "am_crash:I", "am_anr:I", "*:S")
        return app_events(logs)

    def crash_log(self):
        if not self.start:
            return ""
        return app_crash_log(self.read("logcat", "-b", "crash", "-d", "-v", "brief", "-T", self.start))

    def diagnostics(self, directory, reason, repro, include_device):
        directory.mkdir(parents=True, exist_ok=True)

        def save(name, contents):
            safe = redacted(contents).encode("utf-8", "replace")
            if len(safe) > LOG_LIMIT:
                safe = safe[:LOG_LIMIT // 2 - 32] + b"\n... truncated ...\n" + safe[-LOG_LIMIT // 2:]
            (directory / name).write_bytes(safe)

        save("reproduce.txt", f"{reason}\n\n{repro}\n")
        save("instrumentation.txt", "\n\n".join(f"### {name}\n{out}" for name, out in self.results))
        save("device.txt", "\n".join(f"{key}={val}" for key, val in self.configuration.items()))
        if not include_device:
            return
        commands = {
            "crash-anr-events.txt": self.failure_events,
            "crash-stack.txt": self.crash_log,
        }
        if int(self.configuration["ro.build.version.sdk"]) >= 30:
            commands["app-exit-info.txt"] = lambda: self.read("dumpsys", "activity", "exit-info", APP_PACKAGE)
        for filename, reader in commands.items():
            try:
                save(filename, reader() or "No entries for the QA package.\n")
            except (InfrastructureFailure, OSError, subprocess.TimeoutExpired) as error:
                save(filename, f"Capture unavailable: {error}\n")
        try:
            result = self.adb("exec-out", "cat", f"/data/data/{TEST_PACKAGE}/cache/qa-failure.png", timeout=10)
            if result.returncode or not result.stdout.startswith(b"\x89PNG\r\n\x1a\n"):
                result = self.adb("exec-out", "screencap", "-p", timeout=10)
            if not result.returncode and result.stdout.startswith(b"\x89PNG\r\n\x1a\n") and len(result.stdout) <= PNG_LIMIT:
                (directory / "screen.png").write_bytes(result.stdout)
            else:
                save("screen.txt", "Screenshot unavailable or larger than the 2 MiB capture limit.\n")
        except (OSError, subprocess.TimeoutExpired):
            save("screen.txt", "Screenshot capture was unavailable.\n")


def check_kvm():
    if not sys.platform.startswith("linux"):
        raise InfrastructureFailure("KVM preflight is supported on Linux hosts only.")
    import fcntl

    descriptor = os.open("/dev/kvm", os.O_RDWR)
    try:
        if fcntl.ioctl(descriptor, 0xAE00) != 12:  # Linux KVM_GET_API_VERSION
            raise InfrastructureFailure("Unexpected KVM API version.")
    finally:
        os.close(descriptor)
    print("KVM is accessible to the runner.")


def execute(args):
    emulator = Emulator(args.adb, args.serial)
    repro = shlex.join(["python3", "-B", "gradle/emulator_test.py", "--serial", args.serial, "--api", str(args.api),
                        "--app", args.app.name, "--test", args.test.name, "--suite", args.suite,
                        "--timeout", str(args.timeout), "--diagnostics", "qa-diagnostics"]
                       + (["--previous", args.previous.name] if args.previous else [])
                       + (["--native-page-size", str(args.native_page_size)] if args.native_page_size else []))
    with ExitStack() as cleanup:
        disposable = False
        try:
            aapt2 = version_tool(args.aapt2)
            current = apk_version(aapt2, args.app, APP_PACKAGE, require_native=True)
            test = apk_version(aapt2, args.test, TEST_PACKAGE)
            previous = None
            if args.previous:
                previous = apk_version(aapt2, args.previous, APP_PACKAGE, require_native=True)
                if previous >= current:
                    raise InfrastructureFailure("Upgrade fixture APK version code must be lower than the current APK.")
            emulator.verify(args.api, args.native_page_size)
            emulator.ensure_clean(APP_PACKAGE)
            emulator.ensure_clean(TEST_PACKAGE)
            emulator.go_offline(cleanup)
            disposable = True
            emulator.install(args.previous or args.app, APP_PACKAGE, previous if previous is not None else current, cleanup)
            emulator.install(args.test, TEST_PACKAGE, test, cleanup)
            installed = emulator.read("pm", "list", "instrumentation", TEST_PACKAGE)
            if f"instrumentation:{TEST_RUNNER} (target={TEST_PACKAGE})" not in installed:
                raise InfrastructureFailure("Instrumentation runner is missing or targets a different package.")
            if previous is not None:
                emulator.instrument(UPGRADE_TEST + "#seedSettingBeforeUpgrade", args.timeout,
                                    previousVersionCode=previous)
                emulator.install(args.app, APP_PACKAGE, current, cleanup, replace=True)
                emulator.instrument(UPGRADE_TEST + "#verifySettingAfterUpgrade", args.timeout,
                                    previousVersionCode=previous, expectedVersionCode=current)
                if emulator.read("pm", "clear", APP_PACKAGE) != "Success":
                    raise InfrastructureFailure("Could not reset QA app data for clean-start checks after upgrading.")
            emulator.instrument(SMOKE_TEST, args.timeout, expectedOffline="true")
            emulator.relaunch()
            emulator.instrument(PROCESS_TEST, args.timeout, expectedOffline="true")
            if args.suite == "functional":
                emulator.stage_playback_fixture(cleanup)
                emulator.instrument(FUNCTIONAL_TEST, args.timeout, expectedOffline="true")
            if emulator.failure_events() or emulator.crash_log():
                raise TestFailure("Android recorded a crash or ANR for the QA package.")
        except (InfrastructureFailure, TestFailure, OSError, subprocess.TimeoutExpired) as error:
            kind = "test failure" if isinstance(error, TestFailure) else "infrastructure failure"
            reason = redacted(str(error))
            # Filesystem/transport exceptions may contain local account or installation paths.
            if isinstance(error, (OSError, subprocess.TimeoutExpired)):
                reason = f"{type(error).__name__} while running the emulator harness."
            print(f"{kind}: {reason}", file=sys.stderr, flush=True)
            try:
                emulator.diagnostics(args.diagnostics, f"{kind}: {reason}",
                                     "Use a fresh emulator and substitute the APK paths.\n" + repro,
                                     include_device=disposable)
            except OSError:
                print("Could not write failure diagnostics.", file=sys.stderr)
            return 1 if isinstance(error, TestFailure) else 2
    print(f"Passed {args.suite} checks on API {args.api} x86_64.", flush=True)
    return 0


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check-kvm", action="store_true")
    parser.add_argument("--serial", default=os.environ.get("ANDROID_SERIAL"))
    parser.add_argument("--api", type=int, choices=range(26, 38))
    parser.add_argument("--app", type=Path)
    parser.add_argument("--test", type=Path)
    parser.add_argument("--previous", type=Path, help="Older APK signed with the same QA key")
    parser.add_argument("--suite", choices=("smoke", "functional"), default="smoke")
    parser.add_argument("--timeout", type=int, default=240, help="Seconds per instrumentation invocation")
    parser.add_argument("--native-page-size", type=int, choices=(4096, 16384))
    parser.add_argument("--diagnostics", type=Path, default=Path("qa-diagnostics"))
    parser.add_argument("--adb", default="adb")
    parser.add_argument("--aapt2")
    args = parser.parse_args()
    if args.check_kvm:
        try:
            check_kvm()
            return 0
        except (InfrastructureFailure, OSError) as error:
            print(f"infrastructure failure: KVM preflight: {error}", file=sys.stderr)
            return 2
    if not args.serial or not re.fullmatch(r"emulator-\d+", args.serial):
        parser.error("Pass the disposable emulator adb serial, such as --serial emulator-5554.")
    if args.api is None or not args.app or not args.test:
        parser.error("--api, --app and --test are required when running tests.")
    if not 30 <= args.timeout <= 900:
        parser.error("--timeout must be between 30 and 900 seconds.")
    return execute(args)


if __name__ == "__main__":
    sys.exit(main())
