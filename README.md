# Xtra Kick (Android)

Xtra Kick is an Android app for browsing and watching streams.

Kick live streams now use Amazon IVS by default for lower-latency playback, with automatic fallback to the standard Media3/Exo playback path if IVS cannot start. You can change this in `Settings > Player > Kick live stream engine`.

## Status and disclaimer

This project is in alpha/pre-alpha.
Use it at your own risk.
The maintainer is not responsible for damage, data loss, account issues, or other problems caused by using this software.

## Repository layout

- `app/`: Android application module.
- `app/src/main/java/com/github/andreyasadchy/xtra/`: Kotlin/Java source.
- `app/src/main/res/`: Android resources.
- `app/src/main/graphql/`: Apollo GraphQL operations.
- `app/schemas/`: Room schema snapshots.
- `fastlane/`: release automation files.

## Requirements

- Java 21
- Android SDK (API 36)
- Android build-tools
- `adb` (optional, for installing from CLI)

## Setup

1. Copy env template:

```bash
cp .env.example .env
```

2. Configure `.env` values:

- `KICK_CLIENT_ID`
- `KICK_OAUTH_BACKEND_BASE_URL`

3. Ensure `local.properties` contains your SDK path:

```properties
sdk.dir=/path/to/Android/Sdk
```

## Build

Run from repository root.

If you are working on a Windows checkout, run builds from the Windows side. Do not use `./gradlew` from WSL against the `/mnt/c/...` copy of the repo.

```bash
gradlew.bat assembleDebug
gradlew.bat assembleRelease
```

## Test and checks

```bash
gradlew.bat testDebugUnitTest
gradlew.bat lint
```

## Install debug APK (optional)

```bash
adb install -r -t app/build/outputs/apk/debug/app-debug.apk
```

## Tech stack

- Kotlin + AndroidX
- Material Components
- Hilt
- Room
- Apollo GraphQL
- Media3 ExoPlayer
- OkHttp / Cronet

## License

GNU AGPL v3.0. See `LICENSE`.
