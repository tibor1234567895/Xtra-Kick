# Xtra-Kick battery and thermal issues

This file contains GitHub-ready issue drafts based on a static code review of the repo.

Suggested common labels:
- `bug`
- `performance`
- `battery`
- `android`
- `chat`

---

## 1) Chat fragment should be lazy-started or suspended when chat UI is hidden

**Suggested labels:** `bug`, `performance`, `battery`, `chat`  
**Suggested priority:** High

### Summary
`PlayerFragment` toggles chat visibility from gestures/UI state, but `ChatFragment` starts live/replay chat work in initialization/lifecycle paths. This suggests the app may continue doing chat network/render work even when the user has hidden the chat pane instead of fully stopping it.

### Problem
When users are just watching video, hidden chat should not keep sockets, polling, parsing, emote loading, or message rendering alive. This is a likely source of extra battery drain and heat.

### Evidence
- `PlayerFragment` shows/hides chat by changing layout/visibility state.
- `ChatFragment` starts chat-related work during lifecycle startup and resumes it again in `onResume()`.
- Stop logic is tied to fragment lifecycle, not simply to the chat being hidden.

### Proposed fix
- Only create/start `ChatFragment` when the user explicitly opens chat.
- When chat is hidden, pause or fully stop chat session activity instead of only changing visibility/layout.
- Reconnect chat only when the pane becomes visible again.

### Acceptance criteria
- Hiding chat stops active chat work.
- Reopening chat reconnects cleanly.
- Watching a stream with chat hidden uses materially less CPU/network than with chat visible.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/PlayerFragment.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatFragment.kt`

---

## 2) Reduce Kick replay chat timer frequency to lower CPU wakeups and battery drain

**Suggested labels:** `bug`, `performance`, `battery`, `chat`  
**Suggested priority:** High

### Summary
`ChatViewModel` uses `kickReplayPollIntervalMs = 2_000L` and `kickReplayEmitIntervalMs = 250L` for Kick replay chat. That means frequent polling plus four emit ticks per second during replay/VOD/clip playback.

### Problem
This is a strong candidate for battery drain and thermals on VODs/clips, especially when combined with video playback and emote rendering.

### Evidence
- Replay polling interval is set to 2 seconds.
- Replay emit interval is set to 250 ms.
- Replay handling runs continuously while active.

### Proposed fix
- Increase the emit interval.
- Poll less aggressively.
- Prefer player-position-driven batching over fixed high-frequency timers.
- Consider a low-power mode for replay chat.

### Acceptance criteria
- Replay chat remains usable and reasonably synchronized.
- CPU wakeups drop during Kick replay playback.
- VOD/clip playback with replay chat enabled runs cooler than before.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt`

---

## 3) Replay chat queue operations are inefficient in a hot loop

**Suggested labels:** `bug`, `performance`, `battery`, `chat`  
**Suggested priority:** High

### Summary
The Kick replay chat path appears to sort pending messages and later remove items from the front of a list with `removeAt(0)`. This is an inefficient pattern for a hot path that runs frequently.

### Problem
Sorting and front-removal from an array-backed list in a tight replay loop adds avoidable CPU work and contributes to thermals during VOD/clip playback.

### Proposed fix
- Replace the pending replay message list with a `Deque`, min-heap, or other queue structure that supports efficient front removal.
- Avoid repeated full sorts where incremental ordering would suffice.

### Acceptance criteria
- Replay queue management no longer relies on `removeAt(0)` in steady-state processing.
- Replay chat CPU cost drops under heavy message load.
- Functional behavior remains unchanged.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt`

---

## 4) Move heavy chat message preparation off RecyclerView bind path

**Suggested labels:** `bug`, `performance`, `battery`, `ui`  
**Suggested priority:** High

### Summary
`ChatAdapter.onBindViewHolder()` calls `ChatAdapterUtils.prepareChatMessage(...)` for each visible row, and that path can also trigger translation-related work when translate-all is enabled. This puts expensive work directly in the scrolling/render path.

### Problem
Busy chat means lots of binds. Doing translation, span construction, emote resolution, and image-related work during bind increases jank, CPU usage, and heat.

### Proposed fix
- Precompute and cache formatted chat payloads before binding.
- Make translation a one-time async pipeline keyed by message ID.
- Keep `onBindViewHolder()` limited to displaying already-prepared data.

### Acceptance criteria
- Scrolling/binding no longer triggers translation starts.
- Rebinding the same messages does not repeat formatting work unnecessarily.
- CPU usage during busy chat drops measurably.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatAdapter.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatAdapterUtils.kt`

---

## 5) Disable animated emotes by default on mobile or gate them behind power/performance settings

**Suggested labels:** `enhancement`, `performance`, `battery`, `chat`  
**Suggested priority:** Medium-High

### Summary
`ChatFragment` enables animated emotes from prefs with a default of `true`, and `ChatAdapter.onViewAttachedToWindow()` starts `Animatable` drawables for visible rows.

### Problem
Animated emotes increase CPU/GPU work and can significantly amplify heating on active livestream chats.

### Proposed fix
- Change the default to off on phones.
- Auto-disable animations when chat is hidden.
- Add a battery-saver toggle that disables animated emotes and similar chat effects.

### Acceptance criteria
- New installs default to a lower-power animated-emote setting on mobile.
- Animated emotes stop when chat is hidden or power saver is enabled.
- Users can still opt back in manually.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatFragment.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatAdapter.kt`

---

## 6) Replace full chat list refreshes with more granular updates

**Suggested labels:** `bug`, `performance`, `ui`, `chat`  
**Suggested priority:** Medium

### Summary
`ChatFragment` uses broad adapter invalidation paths such as `notifyDataSetChanged()` and `notifyItemRangeChanged(0, size)`, which can force large portions of the list to rebind.

### Problem
Large-scale list invalidation is expensive when each row already has nontrivial formatting and image work. It can create unnecessary redraws and extra heat during active chat.

### Proposed fix
- Use payload-based updates where possible.
- Only update rows that actually changed.
- Avoid full-list invalidation for settings/state toggles unless absolutely necessary.

### Acceptance criteria
- Chat updates are granular.
- Large bursts of chat do not cause broad list rebinds.
- Rendering cost during active chat decreases.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatFragment.kt`

---

## 7) Add a low-power chat profile for third-party emotes and live enrichment features

**Suggested labels:** `enhancement`, `performance`, `battery`, `chat`  
**Suggested priority:** Medium

### Summary
Third-party chat enrichment appears to be enabled by default in multiple places, including BTTV/FFZ/7TV-related loading and live update paths. The view model also manages several realtime/chat-related websocket components.

### Problem
Even if each feature is reasonable on its own, the default combination can be too expensive on phones: video playback + live chat + emote enrichment + animations + extra realtime channels.

### Proposed fix
- Add a “Low power chat” preset.
- Default mobile installs to a conservative feature set.
- Let users opt into more expensive chat enrichments individually.

### Acceptance criteria
- There is a one-tap low-power chat preset.
- The preset disables the highest-cost chat enrichments by default.
- Battery/thermal behavior improves noticeably on long viewing sessions.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatViewModel.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatFragment.kt`

---

## 8) Move translate-all work out of chat bind-time message preparation

**Suggested labels:** `bug`, `performance`, `battery`, `translation`  
**Suggested priority:** Medium-High

### Summary
When translate-all is enabled and no cached translation exists yet, chat message preparation can trigger translation-related work from the rendering pipeline.

### Problem
Translation and language-detection/model-download-related work should not begin from RecyclerView binding. Under load, this can amplify CPU usage and UI churn.

### Proposed fix
- Queue translation once per message ID outside the bind path.
- Cache results aggressively.
- Only bind already-translated or already-queued state.

### Acceptance criteria
- Binding a row never triggers new translation work.
- The same message is not translated repeatedly on rebind.
- Busy translated chats perform better and run cooler.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/util/chat/ChatAdapterUtils.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/chat/ChatFragment.kt`

---

## 9) Add a battery-saver playback preset for lower-latency tradeoffs

**Suggested labels:** `enhancement`, `performance`, `battery`, `player`  
**Suggested priority:** Medium

### Summary
The player is tuned for responsive playback, and chat load compounds the cost. A dedicated battery-saver playback mode would let users trade some immediacy for better thermals and longer viewing sessions.

### Problem
On phones, normal playback overhead becomes much more expensive when combined with live chat, animated emotes, and frequent replay timers.

### Proposed fix
- Add a battery-saver playback preset with less aggressive live offset and update behavior.
- Surface it in settings and optionally auto-enable it under system power saver.

### Acceptance criteria
- Users can enable a battery-saver playback mode.
- The mode reduces thermal load during extended sessions.
- Playback remains stable and acceptable for mobile viewing.

### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/ExoPlayerFragment.kt`
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/ExoPlayerService.kt`

---

## Notes
These drafts are based on static inspection and are best used as engineering triage items. For the highest-signal confirmation, profile the following scenarios on-device:
- stream with chat hidden vs visible
- stream with animated emotes on vs off
- Kick VOD/clip with replay chat on vs off
- translate-all on vs off
