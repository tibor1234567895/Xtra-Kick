## Title
Add Amazon IVS Android Player as an opt-in live-stream engine for Kick livestreams, with ExoPlayer fallback for VOD/clips/offline

## Summary
Kick livestreams appear to use an IVS-backed low-latency HLS path with prefetch-style playlists (`EXT-X-PREFETCH`) rather than standard Apple LL-HLS (`EXT-X-PART`, `EXT-X-PRELOAD-HINT`, etc.).

This app should support a hybrid playback model:

- **Amazon IVS Android Player SDK** for **Kick livestreams only**
- **ExoPlayer / Media3** for:
  - VOD
  - clips
  - offline/local playback
  - any non-live or unsupported path

This should be user-controllable and should fail over cleanly to ExoPlayer if IVS playback cannot start.

## Problem
Current live playback through ExoPlayer works, but latency remains significantly higher than the official Kick app/web player. Buffer tuning alone does not solve this because the bottleneck appears to be the **live playback path itself**, not just local buffering.

## Proposed solution
Implement a **hybrid player architecture**.

### Routing rules
- If content is **Kick + livestream** and the user enabled IVS live playback:
  - use **Amazon IVS Android Player**
- Otherwise:
  - use **ExoPlayer**

### Fallback rules
If IVS initialization or playback fails:
- log the failure
- optionally notify the user
- automatically fall back to ExoPlayer

## Suggested implementation

### 1) Add a player abstraction
Introduce a small shared interface so UI/controller code is not tied directly to ExoPlayer APIs.

Example responsibilities:
- attach/detach player view
- load media
- play/pause/stop/release
- mute/unmute
- seek
- query live state/current position

### 2) Add separate player engines
Create two implementations:
- `ExoAppPlayer`
- `IvsAppPlayer`

### 3) Add a player factory/router
Centralize engine selection based on:
- provider/source
- content type
- live vs VOD/clip
- user preference

### 4) Keep ExoPlayer path intact
Do not replace ExoPlayer globally in the first phase. Add IVS only for Kick live and preserve Exo as the existing default for everything else.

### 5) Add user setting
Add a setting such as:

**Live stream player**
- Auto (recommended)
- Amazon IVS for live streams
- ExoPlayer only

Recommended behavior:
- `Auto` or `Amazon IVS for live streams`: Kick live uses IVS, others use Exo
- `ExoPlayer only`: everything uses Exo

## Why this approach
This gives the best chance of closing the latency gap on Kick live streams while minimizing regressions for VOD/clips/offline playback.

## Acceptance criteria
- Kick livestreams can be played with Amazon IVS Player when enabled
- VOD/clips/offline playback continue using ExoPlayer
- If IVS playback fails, the app falls back to ExoPlayer automatically
- User can force ExoPlayer-only mode
- Live latency for Kick streams is materially lower with IVS than with ExoPlayer
- Existing non-live playback behavior is unchanged

## Notes
- This should be treated as a **live-stream-specific engine**, not a global player replacement in the first iteration
- A later follow-up can decide whether broader migration away from Media3/ExoPlayer is worthwhile

## Suggested labels
`enhancement` `player` `livestream` `latency` `kick`

## Suggested priority
High