# Windows Build And Deploy Rules

## Absolute Rule

- Never run Gradle builds from WSL.
- Never run `adb` from WSL.
- Never compile, install, uninstall, launch, or debug the Android app through the WSL layer.
- Always use Windows `cmd.exe` for every build step and every `adb` step.

If you are inside WSL, you must still invoke the commands through `cmd.exe /c "..."`.

## Required Procedure

Use this exact sequence when you need to compile, install, and open the app:

1. Build with Windows `cmd.exe`:

```bat
cmd.exe /c "cd /d C:\Users\tibor\Downloads\New folder\Xtra _win && gradlew.bat :app:assembleDebug"
```

2. Install with Windows `adb`:

```bat
cmd.exe /c "cd /d C:\Users\tibor\Downloads\New folder\Xtra _win && adb install -r app\build\outputs\apk\debug\app-debug.apk"
```

3. Launch with Windows `adb`:

```bat
cmd.exe /c "adb shell am start -n com.github.andreyasadchy.xtrakick.test/com.github.andreyasadchy.xtra.ui.main.MainActivity"
```

## Notes

- The current debug build installs as package `com.github.andreyasadchy.xtrakick.test`.
- Do not replace the Windows commands above with Linux shell equivalents.
- Do not use `./gradlew` for Android builds in this workspace.
- Do not use `adb` directly from the WSL shell in this workspace.
