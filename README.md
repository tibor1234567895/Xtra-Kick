# Xtra-Kick

An unofficial Android app for browsing and watching Kick streams. Forked from Xtra (a Twitch client) and rebuilt around Kick.

This is a small personal project maintained by one developer in occasional spare time, primarily for personal use. It is alpha software: it may be unstable, break at any time, or stop working entirely if Kick changes their service. You are welcome to use it, but please keep in mind there are no plans for scheduled updates or new features. Use it at your own risk. The maintainer is not responsible for damage, data loss, account issues, or any other problems caused by using this app.

## Compatibility

- Android 8.0 or newer is required.
- Release APKs include both 64-bit ARM (`arm64-v8a`) and 32-bit ARM (`armeabi-v7a`) libraries in one download.
- Debug builds default to ARM64. For architecture testing, override with `-PTARGET_ABI=armeabi-v7a` or `-PTARGET_ABI=arm64-v8a,armeabi-v7a`.

## What it can do

### Playback

- Watch live streams with low latency using the Amazon IVS player by default, with automatic fallback to Media3/ExoPlayer if IVS cannot start. The engine can be switched in settings.
- Watch VODs and clips.
- Quality selection including source, specific resolutions, and audio-only mode, with separate default quality for cellular data.
- Picture-in-picture, background playback, floating mini-player, fullscreen, pinch-to-zoom, playback speed, sleep timer, and an audio compressor toggle.
- Configurable live latency profiles (lowest, balanced, stable) and buffer overrides.
- Optional playlist proxy support for streams.

### Chat

- Real-time Kick chat over websocket. Reading works anonymously without an account (with an unobtrusive guest sign-in prompt in the input bar and a hide/show toggle in the player menu); sending requires logging in with Kick OAuth.
- Message sending and replies for logged-in users, plus moderator slash commands (/ban, /timeout, /clear). Note that the moderation commands are implemented but not yet verified against a real moderator account.
- Kick native emotes and badges plus 7TV emotes and badges, with an emote picker, search, autocomplete, and recent emotes.
- Message history on join, VOD chat replay synced to playback, deleted message markers, mention highlights, optional timestamps, and extensive appearance settings.
- Polls, predictions, channel points, raids, and pinned messages where supported.

### Browsing

- Live streams, categories, and clips browsing with sorting and language filters.
- Search across streams, channels, categories, and videos with recent search history.
- Channel pages with VODs, clips, about info, follower counts, verified badges, and social links.
- First-launch welcome dialog explaining app capabilities and security architecture.

### Follows and notifications

- Local follows for channels and categories stored on your device, not on Kick.
- Automatic follow import from kick.com upon login, with manual import dialog fallback.
- Notifications when followed channels go live, backed by contextual Android 13+ permission primers when following and a dismissible banner in the Following feed.

### Downloads and extras

- Kick daily reward challenges, streaks, and watch time tracking.
- Download live streams, VODs, and clips for offline viewing, with resume support.
- Bookmarks for VODs.
- Multi-view: watch several streams at once in a grid.
- Themes including dark, AMOLED black, Material You dynamic color, and layout customization.
- Multi-language UI support (English and Spanish) with in-app language selection (Settings → Appearance → App language) and system per-app language integration on Android 13+.

## Limitations

- Unofficial. Everything relies on Kick's public API, website endpoints, and undocumented interfaces. Any of these can change or break without notice.
- Logging in with your Kick account via official OAuth 2.0 PKCE web authorization works out of the box in the signed release APK. When building from source yourself, you need to configure your own OAuth client ID and backend URL. Without login you cannot send chat or use authenticated features.
- Some features depend on unofficial endpoints that are less reliable than official ones.
- Limited UI translations (English and Spanish supported). Streams, videos, and clips can also be filtered by broadcast language using the browse filters.
- No Chromecast support.

## Security notes

- Login uses OAuth 2.0 with PKCE against Kick's authorization server, routed through a small backend service operated by the maintainer. The backend is open source: [Xtra-Kick-OAuth-Backend](https://github.com/tibor1234567895/Xtra-Kick-OAuth-Backend). Tokens are stored locally and refreshed automatically; logout revokes them.
- Follow import and web authorization run in WebViews restricted to kick.com and id.kick.com origins only.
- The app sends one anonymous daily usage ping. No account or activity data is included. You can turn it off in Settings → Advanced → Privacy.
- The app is not affiliated with or endorsed by Kick. You use your account at your own discretion.

## License

GNU AGPL v3.0. See `LICENSE`.
