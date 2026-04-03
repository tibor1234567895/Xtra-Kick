# Windows Build & Deploy (WSL Environment Only)

## Setup
- Run commands through `cmd.exe /c` from the repo root at `C:\Users\tibor\Downloads\New folder\Xtra _win`.
- Do not use Linux tooling for builds or deploys.
- Do not split the verified debug build/deploy command into separate steps.
- Assume `adb` is already installed and available on `PATH`.
- The currently verified working branch is `codex/no-translate-test`.

## Atomic Debug Build + Install + Launch
Use this exact single-line command when asked to build and deploy the debug app:

```bash
cmd.exe /c "cd /d C:\Users\tibor\Downloads\New folder\Xtra _win && gradlew.bat :app:assembleDebug && adb install -r app\build\outputs\apk\debug\app-debug.apk && adb shell am start -n com.github.andreyasadchy.xtrakick.test/com.github.andreyasadchy.xtra.ui.main.MainActivity"
```

## Verified Arm64 Release Build
Use this exact single-line command when asked to build the size-check release APK for the current no-translate branch:

```bash
cmd.exe /c "cd /d C:\Users\tibor\Downloads\New folder\Xtra _win && set ORG_GRADLE_PROJECT_TARGET_ABI=arm64-v8a && gradlew.bat :app:assembleRelease"
```

The resulting release APK is written to `app\build\outputs\apk\release\app-release.apk`.
