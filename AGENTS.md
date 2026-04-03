# Windows Build & Deploy (WSL Enviroment ONLY!!!)

## THE ATOMIC COMMAND
To build and deploy, you MUST execute this exact single-line command. Do not break it into steps. Do not use Linux tools. Do not check for file existence via WSL.

```bash
cmd.exe /c "cd /d C:\Users\tibor\Downloads\New folder\Xtra _win && gradlew.bat :app:assembleDebug && adb install -r app\build\outputs\apk\debug\app-debug.apk && adb shell am start -n com.github.andreyasadchy.xtrakick.test/com.github.andreyasadchy.xtra.ui.main.MainActivity"