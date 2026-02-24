# Xtra Kick (Android)

Xtra Kick is an Android client for browsing and watching streams, built on top of the Xtra codebase.

## Status and disclaimer

This project is currently in alpha/pre-alpha state.
Use it at your own risk. You are responsible for any consequences of using it, and the maintainer is not liable for any damage, data loss, account issues, or other problems.

## What this repository contains

- `app/`: Android application module.
- `app/src/main/java/com/github/andreyasadchy/xtra/`: app source code.
- `app/src/main/res/`: Android resources.
- `app/src/main/graphql/`: Apollo GraphQL operations.
- `app/schemas/`: Room schema snapshots.
- `fastlane/`: release automation metadata.

## Requirements

- Linux/WSL or macOS shell environment.
- Java 21.
- Android SDK (platform + build tools for API 36).
- `adb` available on `PATH` for device install flows.

## Local setup

1. Copy environment template:

```bash
cp .env.example .env
```

2. Set required values in `.env` (or via system env / Gradle properties):

- `KICK_CLIENT_ID`
- `KICK_OAUTH_BACKEND_BASE_URL`

3. Ensure `local.properties` points to your Android SDK (`sdk.dir=...`) if not already configured.

## Build and install (default flow)

From repo root:

```bash
./scripts/wsl_build_install.sh
```

What it does:

- Syncs `Xtra/` into a fast WSL workdir.
- Builds `:app:assembleDebug`.
- Installs debug APK to the first online ADB device (or provided serial).
- Launches the installed app.

Useful options:

```bash
./scripts/wsl_build_install.sh --serial <device-id>
./scripts/wsl_build_install.sh --task :app:assembleRelease
./scripts/wsl_build_install.sh --skip-sync
```

## Direct Gradle commands

Run from `Xtra/`:

```bash
./gradlew assembleDebug
./gradlew assembleRelease
./gradlew lint
./gradlew testDebugUnitTest
./gradlew clean
```

## Backup / sync flow

From repo root:

```bash
./scripts/backup_both_windows.sh
```

This script triggers Windows PowerShell automation to:

- Push a full backup to the private repository (`private/main`).
- Push app-only sync (`Xtra/` contents) to public `origin/main` root.

You can pass an inline backup message:

```bash
./scripts/backup_both_windows.sh "backup before release"
```

## Tech stack

- Kotlin + AndroidX
- Material Components
- Hilt (dependency injection)
- Room
- Apollo GraphQL
- Media3 ExoPlayer
- OkHttp / Cronet

## License

Licensed under GNU AGPL v3.0. See `LICENSE`.
