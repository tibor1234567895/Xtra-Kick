# Repository Guidelines

## Project Structure & Module Organization
Primary development happens in `Xtra/` (Android Gradle project). Key paths:
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/`: Kotlin/Java source (feature UI, repositories, DI, DB).
- `Xtra/app/src/main/res/`: layouts, drawables, navigation, localized strings.
- `Xtra/app/src/main/graphql/`: Apollo GraphQL operations and schema inputs.
- `Xtra/app/schemas/`: Room schema snapshots.
- `Xtra/.github/workflows/android.yml`: CI release build workflow.

Artifacts at repo root (`Xtra-Kick(alpha).apk`, `Xtra-Kick(Alpha).apk_Decompiler.com/`) are outputs/reference material; treat them as generated and avoid manual source edits there.

## Build, Test, and Development Commands
Run commands from `Xtra/`:
- **MANDATORY DEFAULT FLOW (repo root):** `./scripts/wsl_build_install.sh`
  - This is the primary build/install path and should be used first for routine validation.
  - Use direct Gradle commands only when this script is not suitable for the specific task.
- **MANDATORY BACKUP FLOW (repo root):** `./scripts/backup_both_windows.sh`
  - This is the primary backup path and should be used to sync both repos in one run.
  - It runs Windows PowerShell from WSL and performs:
    - Full backup push to private repo (`private/main`).
    - Public app-only sync push (contents of `Xtra/` to public `origin/main` root).
  - Optional commit message: `./scripts/backup_both_windows.sh "backup before release"`.
- Preferred local deploy flow from repo root: `./scripts/wsl_build_install.sh` (builds debug APK in WSL workspace and installs to connected phone via ADB).
- `./gradlew assembleDebug`: build a local debug APK.
- `./gradlew assembleRelease`: build release APK (matches CI task).
- `./gradlew lint`: run Android Lint checks.
- `./gradlew testDebugUnitTest`: run JVM unit tests.
- `./gradlew clean`: clear Gradle build outputs.
- Post-build install shortcut (Termux, unique filename): `APK=~/storage/downloads/app-debug-$(date +%Y%m%d-%H%M%S).apk && cp -f app/build/outputs/apk/debug/app-debug.apk "$APK" && termux-open "$APK"`.
- If available, run `termux-media-scan "$APK"` before `termux-open` to reduce stale-package parse errors on some devices.

CI uses Java 21 and Gradle wrapper, so keep local environment aligned.

## Coding Style & Naming Conventions
- Language/style baseline: Kotlin official style (`kotlin.code.style=official`).
- Use 4-space indentation; rely on Android Studio/IntelliJ formatter.
- Class/file names: `PascalCase` (for example `ChatViewModel.kt`, `HelixRepository.kt`).
- Methods/variables: `camelCase`; constants in `UPPER_SNAKE_CASE`.
- Keep package structure feature-oriented (for example `ui/chat`, `repository`, `db`, `model`).

## Testing Guidelines
There are currently no committed `app/src/test` or `app/src/androidTest` suites. For new behavior:
- Add unit tests under `app/src/test/java/...` using `*Test.kt` naming.
- Add instrumentation tests under `app/src/androidTest/java/...` when Android framework behavior is involved.
- Run `./gradlew testDebugUnitTest lint` before opening a PR.

## Commit & Pull Request Guidelines
Recent history favors short, imperative commit subjects (for example `fix login`, `chat fixes`), occasionally with issue/PR refs like `(#872)`.
- Keep subject lines concise and action-focused.
- One logical change per commit.
- PRs should include: what changed, why, test evidence (commands run), and screenshots for UI changes.
- Link related issues and note migration/config impacts when applicable.
