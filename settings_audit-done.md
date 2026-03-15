# Settings Audit

## Findings
- No dead persisted settings remained in the active settings surface after tracing the keys into runtime consumers.
- The main cleanup was structural: page links and one-shot actions were mixed with persisted settings, and one key collision (`player_settings`) existed between a root navigation row and a real player control.
- Active settings are now grouped under `General`, `Appearance`, `Navigation`, `Chat`, `Player`, `Downloads`, and `Advanced`.
- Action and navigation entries now use `action_*` or `nav_*` keys so they are distinct from stored preference keys.
- The old Theme/UI pages are no longer part of the active hierarchy; they were reduced to redirects so they do not duplicate the real settings definitions.
- `chatWidth` was corrected to behave as a derived UI control for `landscape_chat_width` instead of persisting an unused duplicate value under its own preference key.

## Inventory
### Root
- Navigation: `nav_general_settings`, `nav_appearance_settings`, `nav_navigation_settings`, `nav_chat_settings`, `nav_player_overview`, `nav_download_settings`, `nav_advanced_settings`

### General
- Persisted: `ui_language`, `live_notifications_enabled`
- Actions/navigation: `action_check_updates`, `nav_update_settings`, `action_backup_settings`, `action_restore_settings`

### Appearance
- Persisted: `theme`, `ui_theme_follow_system`, `ui_theme_dark_on`, `ui_theme_dark_off`, `ui_theme_rounded_corners_v2`, `ui_theme_reduced_padding`, `ui_theme_compact_text`, `ui_theme_appbar_lift`, `ui_theme_bottom_nav_color`, `ui_theme_material3`, `ui_draw_behind_cutouts`, `columnsPortrait`, `columnsLandscape`, `compactStreamsV2`, `ui_name_display`, `ui_follow_button`, `ui_rounduserimage`, `ui_truncateviewcount`, `ui_uptime`, `ui_tags`, `ui_broadcasterscount`, `ui_bookmark_time_left`

### Navigation
- Persisted: `ui_startonfollowed`, `ui_followpager`, `ui_savedpager`, `ui_gamepager`, `ui_scrolltop`, `ui_store_recent_searches`
- Actions: `action_navigation_tab_list`, `action_following_tabs`, `action_saved_tabs`, `action_channel_tabs`, `action_game_tabs`, `action_search_tabs`, `action_delete_recent_searches`

### Chat
- Persisted: `chat_boldnames`, `chat_randomcolor`, `chat_theme_adapted_username_color`, `chat_timestamps`, `chat_timestamp_format`, `chat_image_library`, `chat_use_webp`, `chat_image_quality`, `chat_size_modifier`, `chat_text_size`, `chat_emote_size`, `chat_badge_size`, `chat_limit`, `chat_recent`, `chat_recent_limit`, `chat_translate`, `chat_translate_target`, `player_keep_chat_open`, `chat_use_websocket`, `chat_use_ssl`, `chat_show_paints`, `chat_show_stv_badges`, `chat_show_kick_badges`, `chat_show_personal_emotes`, `chat_stv_live_updates`, `chat_enable_stv`, `chat_enable_bttv`, `chat_enable_ffz`, `chat_show_usernotice`, `chat_show_clearmsg`, `chat_show_clearchat`, `chat_firstmsg_visibility`, `animatedGifEmotes`, `chat_zerowidth`, `chat_system_message_emotes`, `chat_disable`, `chat_delay_mode`, `chat_delay_custom_secs`, `chat_show_delay_indicator`, `chat_throttle_background`
- Actions/derived controls: `downloaded_languages`, `chatWidth`

### Player
- Persisted: `player_picture_in_picture`, `player_background_audio`, `player_background_audio_locked`
- Navigation: `nav_player_behavior`, `nav_player_button_settings`, `nav_player_menu_settings_root`, `nav_buffer_settings`

### Player Behavior
- Persisted: `player_disable_background_video`, `player_use_background_audio_track`, `player_background_audio_pip_closed`, `player_background_audio_pip_locked`, `player_keep_screen_on_when_paused`, `player_audio_focus`, `player_handle_audio_becoming_noisy`, `player_defaultquality`, `player_default_cellular_quality`, `player_kick_live_engine`, `player_rounded_corner_padding`, `player_move_freely`, `player_use_videopositions`
- Actions: `action_delete_video_positions`

### Player Controls
- Persisted: `player_minimize`, `player_download`, `player_follow`, `player_sleep`, `sleep_timer_use_time_picker`, `sleep_timer_lock`, `player_aspect`, `player_speedbutton`, `player_speed_list`, `player_settings`, `player_menu`, `player_gamesbutton`, `player_restart`, `player_seeklive`, `player_volumebutton`, `player_audio_compressor_button`, `player_mode`, `player_subtitles`, `player_chatbartoggle`, `player_chattoggle`, `player_fullscreen`, `player_doubletap`, `playerRewind`, `playerForward`, `player_channel`, `player_title`, `player_category`, `player_show_uptime`, `player_show_latency`, `player_viewerlist`, `player_viewericon`, `player_pause`
- Actions/navigation: `action_open_admin_settings`, `nav_player_menu_settings`

### Player Menu
- Persisted: `player_menu_quality`, `player_menu_speed`, `player_menu_viewer_list`, `player_menu_games`, `player_menu_download`, `player_menu_bookmark`, `player_menu_sleep`, `player_menu_aspect`, `player_menu_volume`, `player_menu_subtitles`, `player_menu_restart`, `player_menu_chat_bar`, `player_menu_chat_toggle`, `player_menu_reload_emotes`, `player_menu_chat_disconnect`

### Buffer
- Persisted: `player_latency_profile`, `player_buffer_min`, `player_buffer_max`, `player_buffer_playback`, `player_buffer_rebuffer`, `player_live_min_speed`, `player_live_max_speed`, `player_live_target_offset`

### Downloads
- Persisted: `download_playlist_to_file`, `download_wifi_only`, `download_concurrent_limit`, `download_stream_live_check`, `download_stream_offline_check`, `download_stream_start_wait`, `download_stream_end_wait`
- Actions: `action_import_app_downloads`

### Advanced
- Persisted: `player_stream_proxy`, `player_proxy_url`
- Navigation: `nav_proxy_settings`, `nav_playback_settings`, `nav_api_token_settings`, `nav_debug_settings`

### Proxy
- Persisted: `proxy_playback_access_token`, `proxy_multivariant_playlist`, `proxy_media_playlist`, `proxy_host`, `proxy_port`, `proxy_user`, `proxy_password`

### Playback
- Persisted: `player_hide_ads`, `token_supported_codecs`, `token_xdeviceid`, `token_random_deviceid`, `token_playertype`, `token_include_token_stream`, `player_stream_headers`, `token_playertype_video`, `token_include_token_video`, `token_skip_video_access_token`

### API Tokens
- Persisted: `api_login`, `kick_scopes`, `kick_user_id`, `kick_user_login`, `kick_access_token`, `kick_refresh_token`, `validate_tokens`

### Updates
- Persisted: `update_url`, `update_check_enabled`, `update_check_frequency`, `update_use_browser`

### Debug
- Persisted: `debug_chat_fullmsg`, `debug_api_commands`, `debug_api_chat_messages`, `debug_websocket_info`, `debug_kick_realtime_chat`, `debug_use_custom_playback_service`, `player`, `debug_eventsub_chat`, `debug_player_menu_playlist_tags`, `enable_integrity`, `use_webview_integrity`, `get_all_gql_headers`, `gql_headers`, `network_library`
- Actions: `action_api_settings`, `action_get_integrity_token`
