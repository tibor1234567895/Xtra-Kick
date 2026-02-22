# Kick OAuth Cutover Plan (Repo-Grounded, Revised)

## What Changed In This Revision
This document replaces the previous generic OAuth plan with a codebase-specific migration plan for this repository.

It adds:
- A concrete critique of gaps in the previous plan
- Current-state findings from this repo
- A safer execution order that keeps the app shippable at every phase
- Explicit file-level impact map
- Clear non-goals and rollback strategy

## Current Repo Findings (as of 2026-02-22)
1. Login and account state are currently Twitch-first and token-key specific.
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/login/LoginActivity.kt`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/AuthRepository.kt`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/util/TwitchApiHelper.kt`

2. Kick is already integrated for public browsing and chat-read fallback, but not OAuth token lifecycle.
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/KickRepository.kt`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt`

3. Logged-in checks are spread across many screens and rely on Twitch header/token helpers.
- Examples: `ChannelPagerFragment`, `GamePagerFragment`, `GamesFragment`, `PlayerFragment`, `ChatFragment`, `MainActivity`

4. Settings/token UI is Twitch-oriented and directly bound to legacy token keys.
- `Xtra/app/src/main/res/xml/api_token_preferences.xml`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/settings/SettingsActivity.kt`

5. No OAuth callback intent-filter is currently attached to `LoginActivity`.
- `Xtra/app/src/main/AndroidManifest.xml`

## Critique of Previous Plan
1. Scope underestimation
- The prior plan treated this as mostly `LoginActivity` + token prefs work.
- In reality, auth state and token usage are deeply coupled across UI/viewmodels/repositories.

2. Missing abstraction step
- Hard-swapping `TwitchApiHelper` checks to Kick without introducing an auth abstraction first will create brittle regressions.
- A provider-neutral `AuthState` helper is needed before broad refactors.

3. Risky immediate hard-cut wording
- "Remove Twitch login completely in this batch" is feasible only if gating and compatibility shims land first.
- Without an intermediate compatibility layer, many features can silently degrade.

4. Incomplete startup/migration strategy
- Existing migration logic in `MainActivity.migrateSettings()` must be versioned and extended.
- Prior plan did not define exact migration semantics for old prefs vs `tokenPrefs` keys.

5. Chat write path ambiguity
- The previous plan said "if endpoint exists"; endpoint does exist (`POST /public/v1/chat`).
- The repo still needs concrete implementation scope choice (user-only send first is sufficient).

6. Resource and localization blast radius not called out
- Renaming/removing token strings/preferences affects many localized resource files.
- Prior plan did not include a practical strategy (temporary English-only Kick labels + deferred i18n update, or full translation pass).

## Source-Validated OAuth/API Facts To Implement
(Validated from Kick docs during this review)
1. OAuth host: `https://id.kick.com`
2. Authorization endpoint: `GET /oauth/authorize` (PKCE required fields include `code_challenge`, `code_challenge_method=S256`)
3. Token endpoint: `POST /oauth/token` (authorization code + refresh flows)
4. Revoke endpoint: `POST /oauth/revoke`
5. Token introspect endpoint available at API host: `POST https://api.kick.com/public/v1/token/introspect`
6. Current user endpoint: `GET https://api.kick.com/public/v1/users`
7. Chat write endpoint exists: `POST https://api.kick.com/public/v1/chat` (scope `chat:write`)

## Goals
1. Replace Twitch login with Kick OAuth 2.1 Authorization Code + PKCE.
2. Preserve existing Kick browsing/playback/chat-read behavior.
3. Prevent silent failures: unsupported account actions must be explicitly disabled with clear UX.
4. Keep changes incremental and shippable at each phase.

## Non-Goals (This Batch)
1. Full replacement of every Twitch API feature with Kick equivalents.
2. Removal of all Twitch browsing/playback code.
3. New backend service for token mediation.

## Design Decisions
1. Keep `LoginActivity` class and navigation entrypoints to minimize UI/nav churn.
2. Add a new auth helper (`AuthStateHelper`), do not overload `TwitchApiHelper` with Kick logic.
3. Keep legacy Twitch token keys during transition; clear on explicit logout and one-time migration.
4. Implement Kick chat send in minimal form only (`type=user`) once OAuth is stable.

## Data Model and Key Changes
Add new constants in `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/util/C.kt`:
- `KICK_CLIENT_ID`
- `KICK_CLIENT_SECRET`
- `KICK_REDIRECT_URI`
- `KICK_SCOPES`
- `KICK_ACCESS_TOKEN`
- `KICK_REFRESH_TOKEN`
- `KICK_ACCESS_TOKEN_EXPIRES_AT`
- `KICK_USER_ID`
- `KICK_USER_LOGIN`

Add models under `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/model/kick/auth/`:
- `KickOAuthTokenResponse`
- `KickOAuthErrorResponse`
- `KickUsersResponse`
- `KickTokenIntrospectResponse`
- `KickChatSendRequest` / `KickChatSendResponse` (if implementing chat write in this batch)

## Implementation Plan

### Phase 0: Safety Rails and Baseline
1. Create a short-lived feature flag `kick_oauth_enabled` (default false in debug, true when rollout-ready).
2. Add instrumentation note for manual rollback path (disable flag to return to legacy login behavior until full cutover lands).
3. Add logging tags around login/auth transitions for QA.

Exit criteria:
- Build passes, no runtime behavior change with flag off.

### Phase 1: Kick Auth Repository Primitives
1. Extend `AuthRepository` with Kick methods (keep existing Twitch methods untouched for now):
- `exchangeKickAuthorizationCode(...)`
- `refreshKickToken(...)`
- `revokeKickToken(...)`
- `introspectKickToken(...)`
- `getKickCurrentUser(...)`

2. Add PKCE helper utility:
- `code_verifier` generation (43-128 chars)
- SHA-256 challenge base64url no padding
- state nonce generation

3. Add helper object `AuthStateHelper` with:
- `getKickBearerToken(context)`
- `isKickLoggedIn(context, nowEpochSeconds)`
- `clearKickAuth(context)`
- `clearLegacyTwitchAuth(context)`

Exit criteria:
- Unit tests for PKCE + token parsing + `isKickLoggedIn` edge cases pass.

### Phase 2: LoginActivity Conversion (Kick-Only Flow)
1. Replace WebView/header interception flow with external browser OAuth start.
2. Add deep-link intent filter to `LoginActivity` in `AndroidManifest.xml` for configured callback scheme/host.
3. Implement callback handling:
- validate `state`
- exchange code
- call `getKickCurrentUser`
- persist Kick tokens/user fields
- set `RESULT_OK`

4. Logout behavior:
- best-effort revoke access token (and refresh token if supported by token_hint)
- clear Kick keys
- clear legacy Twitch auth keys

Exit criteria:
- Fresh install login/logout works with Kick credentials from settings.

### Phase 3: Settings and Token Screen Migration
1. Update `api_token_preferences.xml` and `ApiTokenSettingsFragment` bindings to include Kick credentials/tokens/user fields.
2. Keep legacy Twitch fields hidden or moved to "legacy" section for one release to reduce migration risk.
3. Update strings for Kick wording in default `values/strings.xml` first.
4. Defer full localization sweep to follow-up unless release requires full translation parity.

Exit criteria:
- Users can configure Kick app credentials and inspect stored Kick auth state.

### Phase 4: Introduce Central Auth-State API and Refactor Call Sites
1. Add centralized `isLoggedIn` check via Kick auth helper.
2. Replace direct checks on `TwitchApiHelper.getGQLHeaders()/getHelixHeaders()` in high-impact surfaces first:
- `MainActivity`
- `ChannelPagerFragment`
- `GamePagerFragment`
- `GamesFragment`
- `Follow*` and `Saved*` pager fragments
- `ChatFragment` / `ChatViewModel`
- `PlayerFragment`

3. Keep Twitch request headers for existing Twitch API reads where still required, but decouple "auth state" UI from those keys.

Exit criteria:
- Login/logout menu state and account-required button gating are driven by Kick auth state consistently.

### Phase 5: Gate Unsupported Account Actions Explicitly
1. For actions still Twitch-only (follow/unfollow via account, moderation commands, notification mutation), disable with clear user message:
- "This account action is not implemented for Kick yet."
2. Do not silently no-op.
3. Preserve local-only alternatives where present (local follows/notifications).

Exit criteria:
- No account action silently fails when Kick-authenticated.

### Phase 6: Optional but Recommended - Kick Chat Write MVP
1. Implement `POST /public/v1/chat` in `KickRepository` or dedicated `KickChatRepository`.
2. Wire chat send path when Kick is preferred and token has `chat:write` scope.
3. Fallback: show explicit message if scope missing or endpoint call fails.

Exit criteria:
- Basic chat send works for Kick channels with proper scope.

### Phase 7: Startup Migration and Legacy Cleanup
1. Extend `MainActivity.migrateSettings()` with a new version step:
- move any existing manual Kick auth fields to canonical keys
- clear stale Twitch auth tokens (`TOKEN`, `GQL_TOKEN2`, `GQL_TOKEN_WEB`, `GQL_HEADERS`, integrity artifacts)
- preserve unrelated settings

2. Remove dead Twitch-login-only code after all references are gone and tests pass:
- WebView login internals in `LoginActivity`
- obsolete API-login selector usage tied only to Twitch login token capture

Exit criteria:
- Clean compile with no dead login branches.

## Impacted Files (Expected)
1. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/AuthRepository.kt`
2. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/KickRepository.kt` (if chat send added)
3. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/login/LoginActivity.kt`
4. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/settings/SettingsActivity.kt`
5. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/main/MainActivity.kt`
6. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/main/MainViewModel.kt`
7. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatFragment.kt`
8. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt`
9. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/*` fragments with login/logout menu actions
10. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/util/C.kt`
11. `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/util/` (new auth helper)
12. `Xtra/app/src/main/res/xml/api_token_preferences.xml`
13. `Xtra/app/src/main/res/values/strings.xml` (+ optionally localized variants)
14. `Xtra/app/src/main/AndroidManifest.xml`

## Test Plan

### Unit Tests
1. PKCE verifier/challenge generation.
2. OAuth URL builder param encoding and state presence.
3. Token/introspect/current-user parsing (success + error).
4. `AuthStateHelper.isKickLoggedIn` expiry behavior.

### Manual / Instrumentation
1. Fresh install:
- configure client id/secret/redirect/scopes
- complete OAuth callback
- verify Kick user/token fields stored

2. Restart with valid token:
- app remains logged in

3. Expired token:
- refresh attempted, else explicit relogin path

4. Logout:
- revoke best effort
- Kick + legacy Twitch auth keys cleared

5. Account actions:
- unsupported actions show explicit "not implemented" messaging

6. Regression:
- streams, games, search, channel, playback, Kick chat-read continue working

## Risks and Mitigations
1. Broad auth coupling regressions
- Mitigation: central auth helper introduced before wide refactor.

2. OAuth callback mismatch/misconfiguration
- Mitigation: validate redirect URI in settings UI and show explicit preflight errors.

3. Localization churn
- Mitigation: stage string changes; prioritize default locale correctness first.

4. Token security concerns (client secret in app prefs)
- Mitigation: document risk; support user-provided credentials only; avoid logging secrets.

## Rollback Strategy
1. Keep feature flag until full rollout validation is complete.
2. If severe regressions appear, disable Kick OAuth path and ship hotfix while retaining code.
3. Do not delete legacy code until Phase 7 exit criteria are met.

## Acceptance Criteria
1. No Twitch login flow is reachable in UI when feature flag is enabled for release.
2. Kick OAuth login/logout works end-to-end.
3. Kick identity and token lifecycle are persisted and refreshed correctly.
4. Unsupported account actions are explicitly disabled with clear messages.
5. Existing Kick browsing/playback/chat-read behavior remains stable.
6. App compiles and passes `./gradlew lint testDebugUnitTest`.

## References
1. Kick OAuth 2.1 docs: https://docs.kick.com/getting-started/generating-tokens-oauth2-flow
2. Kick scopes docs: https://docs.kick.com/getting-started/scopes
3. Kick Users + introspect docs: https://docs.kick.com/apis/users
4. Kick Chat docs: https://docs.kick.com/apis/chat
