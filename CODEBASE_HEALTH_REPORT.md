# Codebase Health Report

Date: 2026-04-03
Scope: verified against `:app:lintDebug`

## Executive Summary

- Verified status: `:app:lintDebug` fails.
- Current lint totals: 73 errors, 176 warnings.
- Primary failing categories confirmed in the current run:
  - `NewApi`
  - `UnsafeOptInUsageError`
  - `MissingTranslation`
- Additional warning-heavy areas include accessibility, manifest hygiene, hardcoded text, typography, and dependency/version-catalog maintenance.

Report source:

- `app/build/intermediates/lint_intermediate_text_report/debug/lintReportDebug/lint-results-debug.txt`

## Verified High Priority Findings

### 1) New API usage conflicts with `minSdk 23`

- The project sets `minSdk = 23` in `app/build.gradle.kts`.
- Lint currently reports hard errors for APIs requiring API 24+, API 26+, or Android S extension level 7.

Confirmed examples:

- `app/src/main/java/com/github/andreyasadchy/xtra/repository/AuthRepository.kt`
  - `HttpEngine` / `UrlRequest` calls require Android S extension level 7.
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt`
  - `PriorityQueue()` requires API 24+.
  - `Instant.ofEpochMilli()` requires API 26+ or desugaring support.
- `app/src/main/java/com/github/andreyasadchy/xtra/repository/KickRepository.kt`
  - `HashMap.putIfAbsent()` requires API 24+.
- `app/src/main/java/com/github/andreyasadchy/xtra/repository/datasource/SearchStreamsDataSource.kt`
  - `HashMap.putIfAbsent()` requires API 24+.
- `app/src/main/java/com/github/andreyasadchy/xtra/repository/datasource/SearchVideosDataSource.kt`
  - `HashMap.putIfAbsent()` requires API 24+.

### 2) Missing Media3 opt-in annotations fail lint

- `LiveLatencySettings.kt` currently triggers `UnsafeOptInUsageError`.
- The affected code uses Media3 APIs that require `@androidx.media3.common.util.UnstableApi` or equivalent `@OptIn`.

Confirmed file:

- `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/LiveLatencySettings.kt`

### 3) Missing translations are a major part of the current lint failure

- `MissingTranslation` is not just informational here; it contributes to the failing error count.
- Many newer strings in the default `values/strings.xml` file are missing in multiple locale folders.

Confirmed examples include strings related to:

- chat delay settings
- player latency profiles
- Kick import flow
- login/logout toasts
- IVS fallback behavior
- debug actions

Primary file:

- `app/src/main/res/values/strings.xml`

### 4) Lint gate is currently red

- The module fails `:app:lintDebug`.
- Current output: `73 errors, 176 warnings`.
- Generated report path:
  - `app/build/intermediates/lint_intermediate_text_report/debug/lintReportDebug/lint-results-debug.txt`

## Verified Medium Priority Findings

### 5) Release build still uses the debug signing config

- `app/build.gradle.kts` assigns the release build type to `signingConfigs.getByName("debug")`.
- This may be acceptable for local/internal usage, but it is risky if this configuration is reused in a production release pipeline.

### 6) Accessibility lint suppression is broad

- `app/build.gradle.kts` disables `ContentDescription` globally.
- This does not cause the current lint failure, but it can hide real accessibility regressions.

### 7) Additional accessibility warnings exist even with that suppression

- Current lint still reports accessibility-related warnings such as:
  - `ClickableViewAccessibility`
  - `LabelFor`

Confirmed examples:

- `app/src/main/java/com/github/andreyasadchy/xtra/ui/following/KickWebSessionManager.kt`
- `app/src/main/res/layout/dialog_video_download.xml`
- `app/src/main/res/layout/fragment_game.xml`
- `app/src/main/res/layout/fragment_media.xml`
- `app/src/main/res/layout/storage_selection.xml`

## Verified Lower Priority Findings

### 8) Dependency and build hygiene warnings are present

- Lint reports outdated dependencies in `gradle/libs.versions.toml`.
- Lint also reports `UseTomlInstead` warnings for dependencies still declared inline in `app/build.gradle.kts`.

### 9) Miscellaneous UI and resource warnings remain

- Current warnings also include:
  - `HardcodedText`
  - `SetTextI18n`
  - `TypographyEllipsis`
  - `PrivateResource`
  - `AlwaysShowAction`
  - `SmallSp`

These are not currently build-blocking by themselves, but they contribute to overall codebase health debt.

## Not Verified In This Pass

The following were not re-run as part of this report update and should be treated as unverified until checked directly:

- compile diagnostics beyond what `lintDebug` touched
- unit test pass/fail counts
- specific test failure root causes
- runtime behavior claims such as import/login/scrape flow performance or correctness

## Suggested Next Steps

1. Fix the `NewApi` errors first by adding proper API guards, replacing API-24-only collection calls, and handling `HttpEngine` availability more defensively.
2. Add the required Media3 `UnstableApi` opt-in annotations in `LiveLatencySettings.kt`.
3. Resolve or intentionally suppress the current `MissingTranslation` errors for newly added strings.
4. Re-run `:app:lintDebug`.
5. If broader health validation is needed, then separately run:
   - `:app:testDebugUnitTest`
   - a clean compile/build validation task

## Current Status

- The codebase currently compiles far enough for lint analysis to run, but lint quality gates are failing.
- The most immediate blockers are API compatibility, Media3 opt-in coverage, and missing translations.
