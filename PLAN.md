# Kick Migration Plan (Xtra -> Xtra-Kick)

## 1. Project Context
- Goal: Convert Xtra from Twitch-focused behavior to Kick-focused behavior.
- Source available:
  - `Xtra/` (editable Kotlin project)
  - `Xtra-Kick(Alpha).apk_Decompiler.com/` (reference from old alpha)
- User constraints (agreed):
  - MVP first
  - No Kick auth/login for now
  - No backend server for now
  - Keep existing local data/settings where possible
  - Prioritize: livestreams, categories, search, channel/playback, basic chat

## 2. What We Verified (Network)
Validated against live Kick endpoints using `User-Agent: okhttp/5.0.0`:
- `GET /stream/livestreams/en` (top streams and subcategory streams)
- `GET /api/v1/subcategories` (categories)
- `GET /api/v2/channels/{slug}` (channel details, playback_url, chatroom)
- `GET /api/v2/channels/{id}/messages` (recent chat)

Notes:
- Old `search.kick.com/multi_search` flow from alpha is no longer reliable.
- Search in MVP is implemented via client-side filtering over paged results.
- Kick responses were sometimes blocked with generic headers; `okhttp/5.0.0` user-agent was required in tests.
- `api/v2/channels/{id}/messages` accepted channel IDs in tests; channel `chatroom.id` also appears available.

## 3. Implemented So Far

### 3.1 New Kick data layer
- Added models: `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/model/kick/KickModels.kt`
- Added repository: `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/KickRepository.kt`
  - Fetches streams/categories/channel/messages
  - Maps Kick payloads to app UI models (`Stream`, `Game`, `User`, `ChatMessage`)

### 3.2 API preference + constants
- Added `C.KICK = "3"` and made Kick-first defaults for key discovery/search flows in:
  - `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/util/C.kt`
- Added settings label `api_kick` in:
  - `Xtra/app/src/main/res/values/strings.xml`
  - `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/settings/SettingsActivity.kt`

### 3.3 Paging/DataSource integration (MVP screens)
Kick path (`C.KICK`) added to:
- `StreamsDataSource`
- `GamesDataSource`
- `GameStreamsDataSource`
- `SearchStreamsDataSource`
- `SearchGamesDataSource`
- `SearchChannelsDataSource`

Related ViewModels updated to inject `KickRepository`.

### 3.4 Channel + playback integration
- `ChannelPagerViewModel`: tries Kick channel/stream/user first, then old Twitch fallback.
- `PlayerViewModel`:
  - `loadStreamResult`: tries Kick playback URL first
  - `updateStream`: tries Kick channel stream first

### 3.5 Basic Kick chat integration
- `ChatViewModel` now supports a Kick polling mode:
  - starts when Kick is enabled in stream API preferences
  - polls Kick recent messages every ~2s
  - deduplicates message IDs
  - integrates with existing chat UI pipeline via mapped `ChatMessage`
- Existing Twitch websocket/IRC path remains as fallback.
- Kick chat message sending/auth path is NOT implemented in MVP (read-only chat behavior).

### 3.6 Followed streams + chatroom-id hardening
- Added Kick backend support to followed streams data flow:
  - `FollowedStreamsDataSource` can now load live Kick streams from locally followed channels.
  - Fallback API selection now iterates all enabled followed-stream backends, including Kick.
  - `FollowedStreamsViewModel` now injects `KickRepository`.
- Updated default followed-stream API preference to include Kick first:
  - `C.DEFAULT_API_PREFS_FOLLOWED_STREAMS = "3:1,0:1,1:1,2:1"`
- Hardened Kick chat polling to resolve and use `chatroom.id` when available:
  - `ChatViewModel` now resolves chat ID via channel slug before loading/polling messages.
  - Falls back to channel ID if chatroom resolution fails.

## 4. Current Blocker
Build could not be fully verified in this environment because Android SDK is not configured:
- Gradle error: missing `ANDROID_HOME` / `local.properties` (`sdk.dir`)

## 5. Remaining Work (Next Steps)

### 5.1 Immediate validation after SDK setup
1. Run: `./gradlew :app:compileDebugKotlin`
2. Fix any compile errors (imports/signatures/DI)
3. Build and install debug APK

### 5.2 Manual QA checklist (MVP)
1. Top streams load and paginate
2. Categories load and paginate
3. Game streams by selected category work
4. Search:
   - streams: returns filtered live channels
   - channels: returns unique filtered channels
   - categories: returns filtered categories
5. Channel page loads info correctly
6. Stream playback starts from Kick `playback_url`
7. Basic chat:
   - connects/polls
   - new messages append
   - no uncontrolled duplicate spam
8. Confirm no regressions when Twitch API backend is selected for the same screens.

### 5.3 Likely follow-up improvements
- Add “Kick mode” toggle instead of relying on API preference ordering
- Better search quality (if Kick exposes stable search endpoint later)
- Improve chat badge mapping (currently basic set/version mapping)
- Later phase: Kick auth/login, follow/subscription/notifications parity

### 5.4 Not Converted Yet (Known Gaps)
- Following pages are still partial:
  - followed streams now has Kick live lookup for locally followed channels (no Kick account follow sync).
  - followed channels/games/videos remain Twitch-first behavior.
- Videos/clips flows remain mostly Twitch paths.
- Account actions (follow/unfollow via Kick account, notification toggles on Kick backend) are not implemented.
- Chat write features (send message, reply, channel points interactions) remain Twitch-specific.
- Search is heuristic paging/filtering (scans limited number of pages), not true backend search.

## 6. Important Technical Decisions Recorded
- Kept Twitch architecture intact and inserted Kick as an additional backend path.
- Avoided backend dependency for MVP.
- Preserved existing preferences and local app storage behavior.
- Used conservative fallbacks to avoid breaking legacy Twitch code paths during migration.
- Chose low-risk fallback-first integration (Kick attempt, then existing Twitch path) for channel/player loading.
- Did not remove or rewrite Twitch modules yet; migration is additive in this phase.

## 7. Reference Files Modified
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/model/kick/KickModels.kt`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/KickRepository.kt`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/util/C.kt`
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/repository/datasource/*.kt` (6 files)
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/*ViewModel.kt` (top/games/game streams/search/channel/player/chat)
- `Xtra/app/src/main/java/com/github/andreyasadchy/xtra/ui/settings/SettingsActivity.kt`
- `Xtra/app/src/main/res/values/strings.xml`

---
Last updated: 2026-02-21 (local session)
