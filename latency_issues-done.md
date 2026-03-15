# GitHub issue drafts: live latency and broken buffer preset UI

## 1) Live stream latency stays 11–14 seconds behind official app / desktop

**Suggested labels:** bug, playback, latency, enhancement  
**Suggested priority:** high

### Title
Live streams stay ~11–14s behind official app/desktop even with low-buffer presets

### Body

#### Description
Live streams in Xtra-Kick are consistently around **11–14 seconds behind** the official Kick app and desktop/browser playback.

This delay appears to persist even after trying the available buffer presets and custom buffer values.

#### Reproduction
1. Open the same live stream in:
   - Xtra-Kick on Android
   - the official Kick app or desktop/browser
2. Compare the same visual/audio event between the two players.
3. Change buffer presets and/or enter custom values.
4. Observe that Xtra-Kick still remains roughly 11–14 seconds behind.

#### Actual behavior
- Xtra-Kick remains significantly behind the official player.
- Changing buffer presets does not materially reduce the live delay.

#### Expected behavior
- Live latency should be much closer to the official app/desktop player.
- Low-latency-oriented settings should have a visible effect.

#### Suspected cause
This looks like a **core playback-path issue**, not just a bad preset choice.

In the current fork, `ExoPlayerService` builds ExoPlayer with `DefaultLoadControl.Builder().setBufferDurationsMs(...)` using the raw buffer prefs (`PLAYER_BUFFER_MIN`, `PLAYER_BUFFER_MAX`, `PLAYER_BUFFER_PLAYBACK`, `PLAYER_BUFFER_REBUFFER`). That only tunes local buffering behavior. It does **not** by itself configure a lower-latency live HLS path. In the forked service code I could verify, I do not see the upstream-style live configuration being applied there. citeturn739985view0turn739985view1

By contrast, upstream Xtra’s `PlaybackService` uses `HlsMediaSource`, installs `CustomHlsPlaylistParserFactory()`, and sets `MediaItem.LiveConfiguration` including `setTargetOffsetMs(...)` as well as live playback speed controls. That is the kind of low-latency live plumbing that would be expected to reduce live delay. citeturn739985view2turn739985view3

#### Proposed fix
- Port the upstream low-latency live playback path into the Kick live-stream path:
  - use `HlsMediaSource`
  - add `CustomHlsPlaylistParserFactory()`
  - apply `MediaItem.LiveConfiguration`
  - wire `PLAYER_LIVE_TARGET_OFFSET`, `PLAYER_LIVE_MIN_SPEED`, and `PLAYER_LIVE_MAX_SPEED` into Kick live playback
- Verify that live streams are actually using the low-latency path, not only generic load-control buffers.
- Add logging/debug info showing:
  - current live offset
  - target offset
  - whether the low-latency HLS path is active

#### Acceptance criteria
- Live streams in Xtra-Kick are materially closer to official app/desktop latency.
- Changing live-latency settings has a measurable effect.
- Debug info confirms that live target offset is being applied.

#### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/ExoPlayerService.kt`
- Upstream reference: `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/PlaybackService.kt`

---

## 2) Buffer preset selection does not populate raw values and UI stays “Not Set”

**Suggested labels:** bug, settings, playback, ui  
**Suggested priority:** high

### Title
Selecting a buffer preset does not populate buffer values; settings remain “Not Set”

### Body

#### Description
Choosing a buffer preset does not populate/update the individual numeric buffer settings in the UI.

The fields for:
- minimum buffer
- maximum buffer
- playback buffer
- rebuffer buffer

continue to show **“Not Set”** even after selecting a preset.

#### Reproduction
1. Open player/buffer settings.
2. Select any buffer preset.
3. Look at the individual buffer fields.
4. Observe that they still show **“Not Set”** instead of concrete values.
5. Start a live stream and compare latency behavior before/after changing presets.

#### Actual behavior
- Preset selection does not populate the per-setting values in the UI.
- The selected preset appears to have little or no effect on live latency.

#### Expected behavior
- Selecting a preset should write concrete values into the individual buffer settings.
- The settings screen should reflect those actual values immediately.
- Playback should use those stored values.

#### Suspected cause
`ExoPlayerService` reads the raw string prefs directly:
- `PLAYER_BUFFER_MIN` (default `15000`)
- `PLAYER_BUFFER_MAX` (default `50000`)
- `PLAYER_BUFFER_PLAYBACK` (default `2000`)
- `PLAYER_BUFFER_REBUFFER` (default `2000`) citeturn739985view0turn739985view1

That means if the preset UI is only storing a preset name/index, but **not writing those four raw pref keys**, the player will continue using existing/default values. That would also explain why the UI still shows “Not Set” and why latency does not materially improve. This issue body is based on the observed behavior plus the verified service-side pref reads. citeturn739985view0turn739985view1

#### Proposed fix
- When a preset is selected, immediately write the corresponding values to:
  - `PLAYER_BUFFER_MIN`
  - `PLAYER_BUFFER_MAX`
  - `PLAYER_BUFFER_PLAYBACK`
  - `PLAYER_BUFFER_REBUFFER`
- Refresh the settings summary so the UI shows the concrete stored values instead of “Not Set”.
- Consider adding a “Restore preset defaults” action that explicitly fills the numeric fields.
- Add a debug summary showing the exact values the player will use.

#### Acceptance criteria
- After selecting a preset, all four numeric buffer fields update immediately.
- Reopening settings shows the same saved values.
- The service uses the same values shown in the UI.
- Users can tell whether a preset actually changed playback parameters.

#### Relevant files
- `app/src/main/java/com/github/andreyasadchy/xtra/ui/player/ExoPlayerService.kt`
- Settings UI file(s) that manage player/buffer preferences
