# Twitch Removal Audit

This file inventories the remaining Twitch-related code, assets, strings, and naming in the repo so we can remove or rename them safely later.

## Status Summary

- There are still a few real Twitch leftovers:
  - Store metadata branding still says Twitch.
  - Twitch playlist/proxy defaults still exist.
  - Twitch IRC/EventSub/PubSub classes still exist.
  - Twitch ad-tag parsing still exists.
- A much larger chunk is now Kick-backed code that still uses Twitch-era names:
  - `GraphQLRepository`
  - `HelixRepository`
  - `gqlHeaders`
  - `helixHeaders`
  - `model/gql/**`
  - `model/helix/**`
- There is also third-party Twitch ecosystem support still present:
  - 7TV / `stv`
  - BetterTTV / FrankerFaceZ references in metadata
  - bits / cheer naming

## Recommended Cleanup Order

1. Remove user-facing Twitch branding and settings labels first.
2. Remove true Twitch transport code next:
   - IRC
   - EventSub
   - PubSub
   - Twitch HLS ad parsing / Twitch proxy defaults
3. Rename legacy abstractions that already call Kick:
   - `GraphQLRepository` to a Kick-specific API/query name
   - `HelixRepository` to a Kick REST API name
   - `getGQLHeaders()` / `getHelixHeaders()` to Kick names
4. Rename or replace Twitch models and GraphQL schema/package names.
5. Remove third-party Twitch ecosystem support only if product scope no longer needs it.

## Files And Functions

### Core Repositories

#### [app/src/main/java/com/github/andreyasadchy/xtra/repository/GraphQLRepository.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/repository/GraphQLRepository.kt)

Reason:
- Still named GraphQL.
- Still uses Apollo-generated query classes and `model.gql.*`.
- Posts to Kick now, so this is mainly a naming and structure cleanup.

Key functions:
- `sendQuery`
- `sendPersistedQuery`
- `loadQueryBadges`
- `loadQueryClipUrls`
- `loadQueryGame`
- `loadQueryGameBoxArt`
- `loadQuerySearchChannels`
- `loadQuerySearchGames`
- `loadQuerySearchStreams`
- `loadQuerySearchVideos`
- `loadQuerySelfFollowingGame`
- `loadQuerySelfFollowingUser`
- `loadQueryTag`
- `loadQueryTeam`
- `loadQueryTeamLiveMembers`
- `loadQueryTeamMembers`
- `loadQueryTopGames`
- `loadQueryTopStreams`
- `loadQueryUser`
- `loadQueryUserAbout`
- `loadQueryUserBadges`
- `loadQueryUserChannelPage`
- `loadQueryUserCheerEmotes`
- `loadQueryUserClips`
- `loadQueryUserEmotes`
- `loadQueryUserFollowedGames`
- `loadQueryUserFollowedStreams`
- `loadQueryUserFollowedUsers`
- `loadQueryUserMessageClicked`
- `loadQueryUserResultId`
- `loadQueryUserResultLogin`
- `loadQueryUserVideos`
- `loadQueryUsersLastBroadcast`
- `loadQueryUsersStream`
- `loadQueryUsersType`
- `loadQueryVideo`
- `loadClipUrls`
- `loadClipData`
- `loadClipVideo`
- `loadTag`
- `loadTopGames`
- `loadTopStreams`
- `loadGameStreams`
- `loadGameClips`
- `loadChannelSuggested`
- `loadChannelVideos`
- `loadChannelClips`
- `loadSearchChannels`
- `loadSearchGames`
- `loadSearchVideos`
- `loadFreeformTags`
- `loadGameTags`
- `loadChatBadges`
- `loadGlobalCheerEmotes`
- `loadChannelCheerEmotes`
- `loadVideoMessages`
- `loadVideoMessagesDownload`
- `loadVideoGames`
- `loadChannelViewerList`
- `loadViewerCount`
- `loadEmoteCard`
- `loadFollowedStreams`
- `loadFollowedChannels`
- `loadFollowedGames`
- `loadFollowUser`
- `loadUnfollowUser`
- `loadToggleNotificationsUser`
- `loadFollowGame`
- `loadUnfollowGame`
- `loadChannelPointsContext`
- `loadClaimPoints`
- `loadJoinRaid`
- `loadUserEmotes`
- `sendMessage`
- `sendAnnouncement`
- `banUser`
- `unbanUser`
- `updateChatColor`
- `updateChatSettings`
- `setFollowersOnlyMode`
- `setSlowMode`
- `createStreamMarker`
- `getModerators`
- `addModerator`
- `removeModerator`
- `startRaid`
- `cancelRaid`
- `getVips`
- `addVip`
- `removeVip`

Potential fixes:
- Rename file/class to something like `KickQueryRepository`.
- Replace `gql` package naming with neutral or Kick-specific naming.
- Split read queries from mutation/command code.
- Remove persisted-query/GQL terminology from public interfaces.

#### [app/src/main/java/com/github/andreyasadchy/xtra/repository/HelixRepository.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/repository/HelixRepository.kt)

Reason:
- Still named Helix.
- API surface is Twitch-shaped, but now points at Kick public endpoints.

Key functions:
- `getGames`
- `getTopGames`
- `getStreams`
- `getLivestreams`
- `getFollowedStreams`
- `getClips`
- `getVideos`
- `getUsers`
- `getSearchGames`
- `getSearchChannels`
- `getUserFollows`
- `getUserFollowers`
- `getUserEmotes`
- `getEmotesFromSet`
- `getGlobalBadges`
- `getChannelBadges`
- `getCheerEmotes`
- `getChatters`
- `createEventSubSubscription`
- `sendMessage`
- `sendAnnouncement`
- `banUser`
- `unbanUser`
- `deleteMessages`
- `getChatColor`
- `updateChatColor`
- `startCommercial`
- `updateChatSettings`
- `createStreamMarker`
- `addModerator`
- `removeModerator`
- `startRaid`
- `cancelRaid`
- `addVip`
- `removeVip`
- `sendWhisper`

Potential fixes:
- Rename file/class to something like `KickRestRepository`.
- Rename `helixHeaders` everywhere to a neutral Kick auth header name.
- Revisit endpoint semantics because many method names still encode Twitch concepts.

#### [app/src/main/java/com/github/andreyasadchy/xtra/repository/PlayerRepository.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/repository/PlayerRepository.kt)

Reason:
- Still contains Twitch-era chat/emote loading paths and 7TV support.

Key Twitch-related functions:
- `loadClipUrls`
- `sendMinuteWatched`
- `loadRecentMessages`
- `loadGlobalStvEmotes`
- `loadStvEmotes`
- `loadStvKickEmotes`
- `getStvUser`
- `sendStvPresence`
- `loadGlobalBadges`
- `loadChannelBadges`
- `loadCheerEmotes`
- `loadUserEmotes`
- `loadEmotesFromSet`

Potential fixes:
- Separate Kick-native emotes/badges from Twitch-named models.
- Decide whether 7TV stays.
- Rename `TwitchBadge`, `TwitchEmote`, and `CheerEmote` usage.

### Chat / Transport

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatReadIRC.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatReadIRC.kt)

Key functions:
- `start`
- `disconnect`

Potential fixes:
- Remove entirely if IRC fallback is no longer supported.
- Remove call sites from `ChatViewModel`.

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatWriteIRC.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatWriteIRC.kt)

Potential fixes:
- Remove entirely if IRC write path is no longer supported.

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/chat/EventSubWebSocket.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/chat/EventSubWebSocket.kt)

Key functions:
- `connect`
- `disconnect`
- listener callbacks:
  - `onConnect`
  - `onWelcomeMessage`
  - `onChatMessage`
  - `onUserNotice`
  - `onClearChat`
  - `onRoomState`
  - `onDisconnect`

Potential fixes:
- Remove if not needed.
- If retained for Kick, rename away from EventSub.

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/chat/EventSubUtils.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/chat/EventSubUtils.kt)

Key functions:
- `parseChatMessage`
- `parseUserNotice`
- `parseClearChat`
- `parseRoomState`

Potential fixes:
- Remove with EventSub transport if obsolete.
- Otherwise rename parser utilities to Kick-specific terms.

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/chat/PubSubUtils.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/chat/PubSubUtils.kt)

Key functions:
- `parsePlaybackMessage`
- `parseStreamInfo`
- `parseRewardMessage`
- `parsePointsEarned`
- `onRaidUpdate`
- `onPollUpdate`
- `onPredictionUpdate`

Potential fixes:
- Rename if this is really a Kick websocket topic parser.
- Remove if replaced by newer Kick realtime paths.

#### [app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt)

Reason:
- Central integration point for Twitch-era naming and fallback paths.

Notable Twitch-related functions:
- `startLive`
- `startReplay`
- `resumeLive`
- `resumeReplay`
- `reloadEmotes`
- `loadRecentMessages`
- `startLiveChat`
- `refreshKickChannelPointState`
- `stopLiveChat`
- `disconnect`
- `send`
- `startReplayChat`
- `startReplayChatLoad`
- `stopReplayChat`

Notable Twitch-related parameters / state:
- `gqlHeaders`
- `helixHeaders`
- `useApiChatMessages`
- `enableIntegrity`
- IRC/EventSub/PubSub transport fields

Potential fixes:
- Delete IRC/EventSub/PubSub branches once replacement is confirmed.
- Rename method params and prefs away from `gql` / `helix`.
- Split Kick chat flow from legacy Twitch-compatible flow.

### Helpers / Constants / Misc

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/KickApiHelper.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/KickApiHelper.kt)

Key Twitch-related functions:
- `addTokenPrefixGQL`
- `addTokenPrefixHelix`
- `getGQLHeaders`
- `getHelixHeaders`
- `isIntegrityTokenExpired`
- `getMessageIdString`
- `getNoticeString`

Potential fixes:
- Rename GQL/Helix helpers to Kick-specific names.
- Revisit `getNoticeString` because it still maps many IRC notice ids.

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/C.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/C.kt)

Twitch-related constants:
- `GQL`
- `GQL_PERSISTED_QUERY`
- `HELIX`
- `GQL_TOKEN`
- `GQL_TOKEN2`
- `GQL_TOKEN_WEB`
- `GQL_HEADERS`
- `INTEGRITY_EXPIRATION`
- `HELIX_CLIENT_ID`
- `HELIX_REDIRECT`
- `GQL_CLIENT_ID`
- `GQL_REDIRECT`
- `GQL_CLIENT_ID2`
- `GQL_REDIRECT2`
- `GQL_CLIENT_ID_WEB`
- `DEBUG_EVENTSUB_CHAT`
- `CHAT_PUBSUB_ENABLED`
- `CHAT_ENABLE_STV`
- `CHAT_SHOW_STV_BADGES`
- `CHAT_STV_LIVE_UPDATES`

Potential fixes:
- Replace with neutral names or Kick-native names.
- Migrate prefs carefully to avoid breaking existing installs.

#### [app/src/main/java/com/github/andreyasadchy/xtra/util/m3u8/PlaylistUtils.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/util/m3u8/PlaylistUtils.kt)

Key functions:
- `parseMediaPlaylist`
- `writeMediaPlaylist`

Potential fixes:
- Remove Twitch-specific ad-tag parsing logic if no longer needed.
- Revisit any `X-TV-TWITCH-AD` handling.

#### [app/src/main/java/com/github/andreyasadchy/xtra/ui/common/IntegrityDialog.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/ui/common/IntegrityDialog.kt)

Potential fixes:
- Remove if integrity token flow is Twitch-only legacy behavior.
- If still used for Kick, rename UI and prefs.

### Models

#### Direct Twitch/7TV model files

- [app/src/main/java/com/github/andreyasadchy/xtra/model/chat/TwitchBadge.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/chat/TwitchBadge.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/chat/TwitchEmote.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/chat/TwitchEmote.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/chat/CheerEmote.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/chat/CheerEmote.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/chat/StvBadge.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/chat/StvBadge.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/chat/StvUser.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/chat/StvUser.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/misc/StvResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/misc/StvResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/misc/StvGlobalResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/misc/StvGlobalResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/misc/StvChannelResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/misc/StvChannelResponse.kt)

Potential fixes:
- Rename Twitch models to neutral or Kick-native models.
- Decide whether 7TV support remains in scope.

#### Full legacy package trees

These are broad legacy naming footprints and should probably be handled as package-level refactors instead of one-off edits.

- `app/src/main/java/com/github/andreyasadchy/xtra/model/gql/**`
- `app/src/main/java/com/github/andreyasadchy/xtra/model/helix/**`
- `app/src/main/graphql/**`

Representative files:
- [app/src/main/java/com/github/andreyasadchy/xtra/model/gql/chat/BadgesResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/gql/chat/BadgesResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/gql/chat/GlobalCheerEmotesResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/gql/chat/GlobalCheerEmotesResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/gql/chat/ChannelCheerEmotesResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/gql/chat/ChannelCheerEmotesResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/helix/chat/BadgesResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/helix/chat/BadgesResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/helix/chat/CheerEmotesResponse.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/helix/chat/CheerEmotesResponse.kt)
- [app/src/main/java/com/github/andreyasadchy/xtra/model/helix/video/Video.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/java/com/github/andreyasadchy/xtra/model/helix/video/Video.kt)

Potential fixes:
- Move to `model.kick.api.*`, `model.kick.query.*`, or a neutral `model.api.*`.
- Regenerate Apollo outputs into a new package if GraphQL remains.

### Resources / UI / Metadata

#### Store metadata still branded as Twitch

Examples:
- [fastlane/metadata/android/en-US/short_description.txt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/fastlane/metadata/android/en-US/short_description.txt)
- [fastlane/metadata/android/en-US/full_description.txt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/fastlane/metadata/android/en-US/full_description.txt)
- Other locales under `fastlane/metadata/android/*/`

Potential fixes:
- Replace Twitch references in all locales.
- Remove BetterTTV / FrankerFaceZ references if no longer accurate.

#### Preferences and dialog resources

- [app/src/main/res/layout/dialog_integrity.xml](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/res/layout/dialog_integrity.xml)
- [app/src/main/res/xml/debug_preferences.xml](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/res/xml/debug_preferences.xml)
- [app/src/main/res/xml/playback_preferences.xml](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/res/xml/playback_preferences.xml)
- [app/src/main/res/xml/chat_preferences.xml](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/res/xml/chat_preferences.xml)
- [app/src/main/res/xml/advanced_preferences.xml](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/res/xml/advanced_preferences.xml)

Potential fixes:
- Remove `EventSub`, `GQL`, `Helix`, `integrity`, `PubSub`, `IRC`, `7TV` labels as appropriate.
- Replace Twitch proxy defaults like `api.ttv.lol`.

#### Localized strings

Many string files still contain:
- `api_helix_*`
- `api_gql_*`
- `use_eventsub_chat`
- `enable_pubsub`
- `irc_notice_*`
- `irc_msgid_*`
- `bits_reward_emote`
- `enable_stv`
- `show_stv_badges`
- `stv_live_updates`

Representative files:
- [app/src/main/res/values/strings.xml](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/res/values/strings.xml)
- locale variants under `app/src/main/res/values-*`

Potential fixes:
- If Twitch removal is full, plan a string-key migration rather than ad-hoc edits.
- Remove IRC-specific strings when IRC paths are deleted.

### GraphQL Documents

GraphQL docs still live under `app/src/main/graphql/` and carry Twitch-era query names.

Examples:
- [app/src/main/graphql/Badges.graphql](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/graphql/Badges.graphql)
- [app/src/main/graphql/UserCheerEmotes.graphql](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/graphql/UserCheerEmotes.graphql)
- [app/src/main/graphql/SearchStreams.graphql](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/graphql/SearchStreams.graphql)
- [app/src/main/graphql/TopStreams.graphql](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/graphql/TopStreams.graphql)
- [app/src/main/graphql/Video.graphql](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/graphql/Video.graphql)
- [app/src/main/graphql/schema.graphqls](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/main/graphql/schema.graphqls)

Potential fixes:
- If GraphQL remains part of the app, regenerate under a Kick or neutral package.
- If not, delete the entire `app/src/main/graphql/` tree and generated usages.

### Tests

Representative Twitch leftovers in tests:
- [app/src/test/java/com/github/andreyasadchy/xtra/ui/player/PlaybackProxyUtilsTest.kt](C:/Users/tibor/Downloads/New%20folder/Xtra%20_win/app/src/test/java/com/github/andreyasadchy/xtra/ui/player/PlaybackProxyUtilsTest.kt)

Potential fixes:
- Replace Twitch host fixtures like `usher.ttvnw.net`.
- Remove tests for deleted Twitch transport or proxy behavior.

## Package-Level Removal Candidates

These are strong candidates for staged deletion or rename passes:

- `app/src/main/java/com/github/andreyasadchy/xtra/repository/GraphQLRepository.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/repository/HelixRepository.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatReadIRC.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatWriteIRC.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/EventSubWebSocket.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/EventSubUtils.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/PubSubUtils.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/model/gql/**`
- `app/src/main/java/com/github/andreyasadchy/xtra/model/helix/**`
- `app/src/main/graphql/**`
- `fastlane/metadata/android/**`

## Practical Fix Plan

### Phase 1: Safe Renames / Branding

- Update store metadata to remove Twitch naming.
- Rename visible settings labels:
  - GQL
  - Helix
  - EventSub
  - PubSub
  - integrity
- Replace Twitch proxy defaults.

### Phase 2: Remove Dead Twitch Transports

- Delete IRC read/write classes if unused.
- Delete EventSub parser/socket if debug-only and obsolete.
- Delete PubSub parser if superseded by Kick realtime.
- Delete Twitch HLS ad parsing if no longer needed.

### Phase 3: Rename Core Abstractions

- `GraphQLRepository` -> Kick/Query repository
- `HelixRepository` -> Kick/REST repository
- `gqlHeaders` -> Kick query headers
- `helixHeaders` -> Kick auth/rest headers
- `TwitchBadge` / `TwitchEmote` / `CheerEmote` -> neutral or Kick-native names

### Phase 4: Package Refactor

- Move `model.gql` and `model.helix` to new packages.
- Rename `app/src/main/graphql` documents or remove them.
- Update all imports and generated package names.

## Notes

- Some names are only legacy labels now and do not prove a live Twitch network dependency.
- The two biggest examples are:
  - `GraphQLRepository`
  - `HelixRepository`
- Both currently talk to Kick endpoints, but their naming still makes the codebase look Twitch-coupled.
