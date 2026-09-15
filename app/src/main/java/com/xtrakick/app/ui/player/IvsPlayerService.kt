package com.xtrakick.app.ui.player

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.KeyguardManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ServiceInfo
import android.graphics.Bitmap
import android.graphics.drawable.Icon
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaMetadata
import android.media.audiofx.DynamicsProcessing
import android.media.session.MediaSession
import android.media.session.PlaybackState
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.PowerManager
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import androidx.annotation.OptIn
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.media3.common.util.BitmapLoader
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSourceBitmapLoader
import androidx.media3.session.CacheBitmapLoader
import androidx.media3.session.DefaultMediaNotificationProvider
import com.xtrakick.app.BuildConfig
import com.amazonaws.ivs.player.MediaPlayer
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.PlayerException
import com.amazonaws.ivs.player.Source
import com.xtrakick.app.R
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.net.ssl.X509TrustManager

@OptIn(UnstableApi::class)
@AndroidEntryPoint
class IvsPlayerService : Service() {

    @Inject
    lateinit var kickRepository: KickRepository

    @Inject
    @JvmField
    var trustManager: X509TrustManager? = null

    private fun playerDebugLog(message: String) {
        if (BuildConfig.DEBUG && prefs().getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)) {
            Log.d(TAG, message)
        }
    }

    private fun playerDebugWarn(message: String) {
        if (BuildConfig.DEBUG && prefs().getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)) {
            Log.w(TAG, message)
        }
    }

    var player: Player? = null
        private set

    var title: String? = null
        private set
    var channelName: String? = null
        private set
    var channelLogo: String? = null
        private set
    var currentUrl: String? = null
        private set

    private var session: MediaSession? = null
    private var notificationManager: NotificationManager? = null
    private var applicationHandler: Handler? = null
    private var bitmapLoader: BitmapLoader? = null
    private var metadataBitmapCallback: FutureCallback<Bitmap>? = null
    private var notificationBitmapCallback: FutureCallback<Bitmap>? = null
    private var backgroundPlaybackEnabled = false
    private var hasStablePlayback = false
    private var playbackRequested = false
    private var retryCount = 0
    private var startedAtMs = 0L
    private var surfaceAttached = false
    private var suspendedByFocusLoss = false
    private var deadStreamWatchdog: Runnable? = null
    private var wakeLock: PowerManager.WakeLock? = null
    private var wifiLock: WifiManager.WifiLock? = null
    private var wifiLockSafetyRunnable: Runnable? = null
    private var dynamicsProcessing: DynamicsProcessing? = null

    /**
     * Serializes every player mutation (load/play/pause/seek/volume/surface) onto one
     * thread: the IVS engine fires callbacks on its own threads, so touching the player
     * from main + callbacks concurrently races load/play/seek ordering into rebuffering.
     */
    private val playerExecutor = Executors.newSingleThreadExecutor { runnable ->
        Thread(runnable, "IvsPlayerOp")
    }

    fun runPlayerOp(opName: String, block: (Player) -> Unit) {
        val current = player ?: return
        try {
            playerExecutor.execute {
                try {
                    block(current)
                } catch (e: Exception) {
                    playerDebugWarn("player op $opName failed: ${e.message}")
                }
            }
        } catch (e: Exception) {
            playerDebugWarn("player op $opName rejected: ${e.message}")
        }
    }

    /**
     * Warms an IVS source (playlists fetched, nothing playing). A later [playStream] or
     * backoff retry for the same URL swaps it in via loadSource(), saving 1-2 playlist
     * round trips. Capped; evicted on tune-away/stop/destroy.
     */
    private val preloadedSources = LinkedHashMap<String, Source>()

    fun preloadStream(url: String) {
        if (url.isBlank()) return
        runPlayerOp("preload") { player ->
            val mediaPlayer = player as? MediaPlayer ?: return@runPlayerOp
            synchronized(preloadedSources) {
                if (preloadedSources.containsKey(url)) return@runPlayerOp
            }
            try {
                mediaPlayer.preload(
                    Uri.parse(url),
                    object : Source.Listener {
                        override fun onLoad(source: Source) {
                            synchronized(preloadedSources) {
                                val existing = preloadedSources.put(url, source)
                                if (existing != null && existing !== source) {
                                    releaseSourceQuietly(existing)
                                }
                                while (preloadedSources.size > MAX_PRELOADED_SOURCES) {
                                    val oldest = preloadedSources.keys.firstOrNull()
                                    val removed = oldest?.let { preloadedSources.remove(it) }
                                    if (removed != null) releaseSourceQuietly(removed) else break
                                }
                            }
                            playerDebugLog("preloaded url=$url")
                        }

                        override fun onError(error: Source.LoadError) {
                            playerDebugLog(
                                "preload failed url=$url type=${error.errorType} code=${error.code} message=${error.message}"
                            )
                        }
                    }
                )
            } catch (e: Exception) {
                playerDebugWarn("preload failed: ${e.message}")
            }
        }
    }

    /** Player-executor only. True when a warm source was used. */
    private fun usePreloadedSource(player: Player, url: String): Boolean {
        val cached = synchronized(preloadedSources) { preloadedSources[url] } ?: return false
        val mediaPlayer = player as? MediaPlayer ?: return false
        return try {
            mediaPlayer.loadSource(cached)
            playerDebugLog("playStream using preloaded source url=$url")
            true
        } catch (e: Exception) {
            playerDebugWarn("preloaded loadSource failed, falling back to load: ${e.message}")
            synchronized(preloadedSources) {
                if (preloadedSources[url] === cached) preloadedSources.remove(url)
            }
            releaseSourceQuietly(cached)
            false
        }
    }

    /** Thread-safe; call on the player executor to keep load/play ordering. */
    private fun evictPreloadedSources() {
        val evicted = synchronized(preloadedSources) {
            val all = preloadedSources.values.toList()
            preloadedSources.clear()
            all
        }
        evicted.forEach(::releaseSourceQuietly)
    }

    private fun releaseSourceQuietly(source: Source) {
        try {
            source.release()
        } catch (_: Exception) {
        }
    }
    private val watchOwner by lazy {
        KickViewerWatchOwner(
            kickRepository = kickRepository,
            trustManager = trustManager,
            debugLogging = BuildConfig.DEBUG,
            isRewardsEnabled = { prefs().getBoolean(AppConstants.KICK_DAILY_REWARDS_ENABLED, true) },
            isPlaying = { player?.state == Player.State.PLAYING },
        )
    }
    private val rewardsPreferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        if (key == AppConstants.KICK_DAILY_REWARDS_ENABLED) {
            watchOwner.onRewardsToggle(prefs().getBoolean(AppConstants.KICK_DAILY_REWARDS_ENABLED, true))
        }
    }

    private fun startKickViewerWatchIfNeeded() {
        watchOwner.startIfNeeded()
    }

    private fun stopKickViewerWatch() {
        watchOwner.stop()
    }

    fun setKickViewerMetadata(channelId: String?, livestreamId: String?, channelLogin: String?) {
        watchOwner.setMetadata(channelId, livestreamId, channelLogin)
    }
    private var dynamicsProcessingAudioSessionId: Int? = null
    private var audioManager: AudioManager? = null
    private var audioFocusRequest: AudioFocusRequest? = null
    private var idleStopRunnable: Runnable? = null
    private val liveSeekbarTicker: Runnable = object : Runnable {
        override fun run() {
            val ivsPlayer = player
            if (ivsPlayer != null && ivsPlayer.state == Player.State.PLAYING && ivsPlayer.duration <= 0L &&
                startedAtMs > 0L && prefs().getBoolean(AppConstants.PLAYER_SHOW_STREAM_NOTIFICATION_SEEKBAR, true)
            ) {
                // keep the synthetic live timeline (stream uptime) in sync with the session
                updatePlaybackState()
                updateMetadata()
                applicationHandler?.postDelayed(this, 30_000L)
            }
        }
    }
    private val audioFocusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        when (focusChange) {
            AudioManager.AUDIOFOCUS_LOSS -> {
                // Permanent loss: clear the request so the idle timer can reclaim the
                // service and a later AUDIOFOCUS_GAIN doesn't auto-resume. Restore the
                // volume first — CAN_DUCK may have ducked it, and a manual resume from
                // the notification would otherwise play at 20%.
                suspendedByFocusLoss = false
                val restoreVolume = prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
                runPlayerOp("audiofocus-loss-volume") { it.setVolume(restoreVolume) }
                pause(clearPlaybackRequest = true)
                updatePlaybackState()
                updateNotification()
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                suspendedByFocusLoss = true
                pause(clearPlaybackRequest = false)
                updatePlaybackState()
                updateNotification()
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> {
                val duckedVolume = (prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f) * 0.2f
                runPlayerOp("audiofocus-duck") { it.setVolume(duckedVolume) }
            }
            AudioManager.AUDIOFOCUS_GAIN -> {
                suspendedByFocusLoss = false
                val restoreVolume = prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
                runPlayerOp("audiofocus-gain-volume") { it.setVolume(restoreVolume) }
                if (playbackRequested) {
                    play()
                    updatePlaybackState()
                    updateNotification()
                }
            }
        }
    }

    private fun requestAudioFocus(): Boolean {
        if (!prefs().getBoolean(AppConstants.PLAYER_AUDIO_FOCUS, true)) {
            return true
        }
        val am = audioManager ?: (getSystemService(Context.AUDIO_SERVICE) as AudioManager).also { audioManager = it }
        val focusRequest = audioFocusRequest ?: AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            .setAcceptsDelayedFocusGain(false)
            .setOnAudioFocusChangeListener(audioFocusChangeListener)
            .build().also { audioFocusRequest = it }
        val result = am.requestAudioFocus(focusRequest)
        return result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    private fun abandonAudioFocus() {
        val am = audioManager ?: return
        audioFocusRequest?.let { am.abandonAudioFocusRequest(it) }
    }

    private fun isDeviceLockedOrScreenOff(): Boolean {
        try {
            val powerManager = getSystemService(Context.POWER_SERVICE) as? PowerManager
            if (powerManager?.isInteractive == false) return true
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as? KeyguardManager
            if (keyguardManager?.isKeyguardLocked == true) return true
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                if (keyguardManager?.isDeviceLocked == true) return true
            }
        } catch (_: Exception) {
        }
        return false
    }

    private fun acquirePlaybackLocks() {
        // Only hold locks while actively playing/buffering — safety timeout on both
        // (re-acquired on each state change while playback continues).
        wakeLock?.takeUnless { it.isHeld }?.acquire(WAKE_LOCK_TIMEOUT_MS)
        wifiLock?.takeUnless { it.isHeld }?.acquire()
        armWifiLockSafetyTimeout()
    }

    private fun releasePlaybackLocks() {
        disarmWifiLockSafetyTimeout()
        wakeLock?.takeIf { it.isHeld }?.release()
        wifiLock?.takeIf { it.isHeld }?.release()
    }

    /**
     * WifiLock (unlike WakeLock) has no acquire(timeout) overload, so schedule the
     * same 10-minute fallback manually: keep re-arming while playback is active,
     * release when the player is stuck anywhere else.
     */
    private fun armWifiLockSafetyTimeout() {
        disarmWifiLockSafetyTimeout()
        val runnable = Runnable {
            wifiLockSafetyRunnable = null
            val state = player?.state
            if (state == Player.State.PLAYING || state == Player.State.BUFFERING) {
                armWifiLockSafetyTimeout()
            } else {
                releasePlaybackLocks()
            }
        }
        wifiLockSafetyRunnable = runnable
        applicationHandler?.postDelayed(runnable, WAKE_LOCK_TIMEOUT_MS)
    }

    private fun disarmWifiLockSafetyTimeout() {
        wifiLockSafetyRunnable?.let { applicationHandler?.removeCallbacks(it) }
        wifiLockSafetyRunnable = null
    }

    private fun syncLocksWithState(state: Player.State) {
        // Battery optimization: tie locks strictly to playback state.
        // Hold only while PLAYING or BUFFERING; release on PAUSE/READY/ENDED.
        if (state == Player.State.PLAYING || state == Player.State.BUFFERING) {
            acquirePlaybackLocks()
        } else {
            // When playbackRequested is still true but player is READY (paused),
            // we still release — explicit play() will re-acquire.
            if (state == Player.State.READY || state == Player.State.ENDED) {
                releasePlaybackLocks()
            }
        }
    }

    @Suppress("DEPRECATION")
    override fun onCreate() {
        super.onCreate()
        prefs().registerOnSharedPreferenceChangeListener(rewardsPreferenceChangeListener)
        wakeLock = (getSystemService(Context.POWER_SERVICE) as PowerManager).newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "IvsPlayerService:WakeLock"
        ).apply {
            setReferenceCounted(false)
        }
        wifiLock = (applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager).let { wifiManager ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL_LOW_LATENCY, "IvsPlayerService:WifiLock")
            } else {
                @Suppress("DEPRECATION")
                wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, "IvsPlayerService:WifiLock")
            }
        }.apply {
            setReferenceCounted(false)
        }
        val ivsPlayer = Player.Factory.create(this).apply {
            setLogLevel(Player.LogLevel.ERROR)
            setLiveLowLatencyEnabled(true)
            setRebufferToLive(false)
            setVolume(prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f)
        }
        player = ivsPlayer
        ivsPlayer.addListener(
            object : Player.Listener() {
                override fun onCue(cue: com.amazonaws.ivs.player.Cue) = Unit

                override fun onStateChanged(state: Player.State) {
                    if (state == Player.State.PLAYING) {
                        hasStablePlayback = true
                        retryCount = 0
                        suspendedByFocusLoss = false
                        startKickViewerWatchIfNeeded()
                        requestAudioFocus()
                    } else {
                        stopKickViewerWatch()
                    }
                    if (state == Player.State.READY && playbackRequested && !suspendedByFocusLoss) {
                        player?.play()
                    }
                    if (state == Player.State.ENDED && boundClients == 0) {
                        // Unbound session (background/headset-restored) ended — tear down
                        // instead of leaving a stale "playing" notification behind. A still
                        // bound fragment (in-app, incl. audio-only) keeps its ended-state UI.
                        playerDebugWarn("stream ended in background — stopping playback")
                        stopPlaybackForGood()
                        return
                    }
                    syncDeadStreamWatchdog()
                    syncLocksWithState(state)
                    if (state == Player.State.READY || state == Player.State.PLAYING) {
                        syncDynamicsProcessingWithPreference()
                    }
                    playerDebugLog(
                        "state=$state backgroundPlaybackEnabled=$backgroundPlaybackEnabled " +
                            "surfaceAttached=$surfaceAttached urlPresent=${!currentUrl.isNullOrBlank()}"
                    )
                    if (state == Player.State.BUFFERING) {
                        playerDebugLog(
                            "buffering liveLatency=${ivsPlayer.liveLatency} " +
                                "buffered=${ivsPlayer.bufferedPosition} position=${ivsPlayer.position} " +
                                "bwEstimate=${ivsPlayer.bandwidthEstimate}"
                        )
                    }
                    if (state == Player.State.PLAYING) {
                        applicationHandler?.removeCallbacks(liveSeekbarTicker)
                        applicationHandler?.post(liveSeekbarTicker)
                    } else {
                        applicationHandler?.removeCallbacks(liveSeekbarTicker)
                    }
                    updatePlaybackState()
                    updateMetadata()
                    updateNotification()
                }

                override fun onDurationChanged(duration: Long) {
                    updateMetadata()
                    updateNotification()
                }

                override fun onRebuffering() {
                    // Resume in place; jumping to live just re-stalls on weak networks.
                    runPlayerOp("rebuffer-stay") { it.setRebufferToLive(false) }
                    playerDebugLog(
                        "rebuffering liveLatency=${ivsPlayer.liveLatency} " +
                            "buffered=${ivsPlayer.bufferedPosition} position=${ivsPlayer.position} " +
                            "bwEstimate=${ivsPlayer.bandwidthEstimate}"
                    )
                }

                override fun onError(exception: PlayerException) {
                    playerDebugWarn(
                        "error code=${exception.code} type=${exception.errorType} source=${exception.source} " +
                            "backgroundPlaybackEnabled=$backgroundPlaybackEnabled message=${exception.errorMessage}"
                    )
                    updatePlaybackState(error = true)
                    updateNotification()
                    val retryUrl = currentUrl
                    // Blind same-URL retries from the service while unbound in background;
                    // when a fragment is bound it handles errors (fresh-URL reload / engine fallback).
                    val fragmentHandlesRecovery = boundClients > 0
                    if (!fragmentHandlesRecovery && !retryUrl.isNullOrBlank() && retryCount < 2) {
                        retryCount += 1
                        // Back off: instant reloads re-enter BUFFERING on a depleted
                        // connection and burn the ABR bandwidth estimate just collected.
                        val delayMs = 1_000L * retryCount
                        playerDebugLog("onError in background, retrying count=$retryCount in ${delayMs}ms url=$retryUrl")
                        // Preload now; the delayed retry below is enqueued behind it on
                        // the same FIFO executor, so it swaps the warm source.
                        preloadStream(retryUrl)
                        applicationHandler?.postDelayed({
                            if (currentUrl == retryUrl) {
                                runPlayerOp("background-retry") {
                                    it.setLiveLowLatencyEnabled(true)
                                    it.setRebufferToLive(false)
                                    if (!usePreloadedSource(it, retryUrl)) {
                                        it.load(Uri.parse(retryUrl))
                                    }
                                    it.play()
                                }
                            }
                        }, delayMs)
                    } else {
                        releasePlaybackLocks()
                        if (!surfaceAttached) {
                            // Background playback failed for good — stop instead of
                            // leaving a dead ERROR-state notification up.
                            stopPlaybackForGood()
                        }
                    }
                }

                override fun onSeekCompleted(position: Long) = Unit

                override fun onVideoSizeChanged(width: Int, height: Int) = Unit

                override fun onQualityChanged(quality: com.amazonaws.ivs.player.Quality) = Unit
            }
        )
        val rewindMs = (prefs().getString(AppConstants.PLAYER_REWIND, "10")?.toLongOrNull() ?: 10) * 1000
        val fastForwardMs = (prefs().getString(AppConstants.PLAYER_FORWARD, "10")?.toLongOrNull() ?: 10) * 1000
        session = MediaSession(this, TAG).apply {
            // Volumee and other external controllers filter on flags. Without these
            // dumpsys shows flags=0 and Volumee shows "No player is active".
            // Use LOCAL playback (not REMOTE) — REMOTE makes SystemUI show a
            // casting/remote-volume icon near the slider (see screenshots).
            setFlags(MediaSession.FLAG_HANDLES_MEDIA_BUTTONS or MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS)
            setPlaybackToLocal(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            setCallback(
                object : MediaSession.Callback() {
                    override fun onPlay() {
                        play()
                        updatePlaybackState()
                        updateNotification()
                    }

                    override fun onPause() {
                        pause(clearPlaybackRequest = true)
                        updatePlaybackState()
                        updateNotification()
                    }

                    override fun onStop() {
                        playbackRequested = false
                        abandonAudioFocus()
                        runPlayerOp("session-stop-pause") { it.pause() }
                        releasePlaybackLocks()
                        clearLastPlaybackRequestIfCurrent()
                        updatePlaybackState()
                        updateNotification()
                        stopSelf()
                    }

                    override fun onSeekTo(pos: Long) {
                        runPlayerOp("session-seek") { it.seekTo(pos) }
                    }

                    override fun onSkipToNext() {
                        runPlayerOp("session-skip-next") { it.seekTo(it.position + fastForwardMs) }
                    }

                    override fun onSkipToPrevious() {
                        runPlayerOp("session-skip-prev") { it.seekTo((it.position - rewindMs).coerceAtLeast(0L)) }
                    }

                    override fun onFastForward() {
                        onSkipToNext()
                    }

                    override fun onRewind() {
                        onSkipToPrevious()
                    }

                    override fun onMediaButtonEvent(mediaButtonEvent: Intent): Boolean {
                        // Let the framework dispatch to onPlay/onPause/onSkip etc. via PlaybackState.
                        // Returning false allows the default handling which posts the matching callback.
                        return super.onMediaButtonEvent(mediaButtonEvent)
                    }
                }
            )
            isActive = true
        }
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channelId = getString(R.string.notification_playback_channel_id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && notificationManager?.getNotificationChannel(channelId) == null) {
            notificationManager?.createNotificationChannel(
                NotificationChannel(
                    channelId,
                    ContextCompat.getString(this, R.string.notification_playback_channel_title),
                    NotificationManager.IMPORTANCE_LOW
                ).apply {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                        setShowBadge(false)
                    }
                }
            )
        }
        applicationHandler = Handler(Looper.getMainLooper())
        playerDebugLog("service created")
    }

    fun playStream(
        url: String,
        title: String?,
        channelName: String?,
        channelLogo: String?,
        streamStartedAtMs: Long? = null,
        channelId: String? = null,
        livestreamId: String? = null,
        channelLogin: String? = null,
    ) {
        this.currentUrl = url
        this.title = title
        this.channelName = channelName
        this.channelLogo = channelLogo
        setKickViewerMetadata(channelId, livestreamId, channelLogin)
        this.startedAtMs = streamStartedAtMs ?: 0L
        saveLastPlaybackRequest(url, title, channelName, channelLogo, startedAtMs, channelId, livestreamId, channelLogin)
        hasStablePlayback = false
        retryCount = 0
        releaseDynamicsProcessing()
        playerDebugLog("playStream channel=$channelName title=$title")
        playbackRequested = true
        suspendedByFocusLoss = false
        disarmDeadStreamWatchdog()
        disarmIdleStop()
        requestAudioFocus()
        // Don't acquire locks pre-emptively — wait for BUFFERING/PLAYING callback.
        runPlayerOp("playStream-load-play") {
            it.setLiveLowLatencyEnabled(true)
            it.setRebufferToLive(false)
            it.setVolume(prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f)
            if (!usePreloadedSource(it, url)) {
                evictPreloadedSources()
                it.load(Uri.parse(url))
            }
            it.play()
        }
        updatePlaybackState()
        updateMetadata()
        updateNotification()
    }

    fun updateChannelLogo(logo: String?) {
        val clean = logo?.takeIf { it.isNotBlank() } ?: return
        if (this.channelLogo != clean) {
            this.channelLogo = clean
            updateMetadata()
            updateNotification()
        }
    }

    private fun saveLastPlaybackRequest(
        url: String,
        title: String?,
        channelName: String?,
        channelLogo: String?,
        startedAtMs: Long,
        channelId: String?,
        livestreamId: String?,
        channelLogin: String?,
    ) {
        try {
            prefs().edit {
                putString(AppConstants.LAST_PLAYBACK_ENGINE, "ivs")
                putString(AppConstants.LAST_PLAYBACK_URL, url)
                putString(AppConstants.LAST_PLAYBACK_TITLE, title)
                putString(AppConstants.LAST_PLAYBACK_CHANNEL_NAME, channelName)
                putString(AppConstants.LAST_PLAYBACK_CHANNEL_LOGO, channelLogo)
                putLong(AppConstants.LAST_PLAYBACK_STARTED_AT_MS, startedAtMs)
                putString(LAST_PLAYBACK_CHANNEL_ID, channelId)
                putString(LAST_PLAYBACK_LIVESTREAM_ID, livestreamId)
                putString(LAST_PLAYBACK_CHANNEL_LOGIN, channelLogin)
            }
        } catch (_: Exception) {
        }
    }

    private fun clearLastPlaybackRequestIfCurrent() {
        if (prefs().getString(AppConstants.LAST_PLAYBACK_URL, null) == currentUrl) {
            try {
                prefs().edit {
                    remove(AppConstants.LAST_PLAYBACK_URL)
                    remove(AppConstants.LAST_PLAYBACK_TITLE)
                    remove(AppConstants.LAST_PLAYBACK_CHANNEL_NAME)
                    remove(AppConstants.LAST_PLAYBACK_CHANNEL_LOGO)
                    remove(AppConstants.LAST_PLAYBACK_STARTED_AT_MS)
                    remove(LAST_PLAYBACK_CHANNEL_ID)
                    remove(LAST_PLAYBACK_LIVESTREAM_ID)
                    remove(LAST_PLAYBACK_CHANNEL_LOGIN)
                }
            } catch (_: Exception) {
            }
        }
    }

    /**
     * Restores the last playback request after the service process was killed
     * (e.g. headset PLAY button received while nothing is playing).
     */
    private fun restoreFromSavedRequest(): Boolean {
        val prefs = prefs()
        val url = prefs.getString(AppConstants.LAST_PLAYBACK_URL, null)
        if (url.isNullOrBlank()) return false
        if (!currentUrl.isNullOrBlank()) return false
        playStream(
            url = url,
            title = prefs.getString(AppConstants.LAST_PLAYBACK_TITLE, null),
            channelName = prefs.getString(AppConstants.LAST_PLAYBACK_CHANNEL_NAME, null),
            channelLogo = prefs.getString(AppConstants.LAST_PLAYBACK_CHANNEL_LOGO, null),
            streamStartedAtMs = if (prefs.getLong(AppConstants.LAST_PLAYBACK_STARTED_AT_MS, 0L) > 0L) {
                prefs.getLong(AppConstants.LAST_PLAYBACK_STARTED_AT_MS, 0L)
            } else {
                null
            },
            channelId = prefs.getString(LAST_PLAYBACK_CHANNEL_ID, null),
            livestreamId = prefs.getString(LAST_PLAYBACK_LIVESTREAM_ID, null),
            channelLogin = prefs.getString(LAST_PLAYBACK_CHANNEL_LOGIN, null),
        )
        return true
    }

    /**
     * Stops the service when it has been left paused/idle for 10 minutes without
     * playback being requested (mirrors upstream Xtra's idle auto-stop).
     */
    private fun armIdleStop() {
        if (idleStopRunnable == null && !playbackRequested && boundClients == 0) {
            val runnable = Runnable {
                idleStopRunnable = null
                if (!playbackRequested) {
                    stopSelf()
                }
            }
            idleStopRunnable = runnable
            applicationHandler?.postDelayed(runnable, 600_000L)
        }
    }

    private fun disarmIdleStop() {
        idleStopRunnable?.let { applicationHandler?.removeCallbacks(it) }
        idleStopRunnable = null
    }

    /**
     * Background playback only: if the player sits in READY/IDLE while background
     * playback is requested, the stream went offline (IVS reports READY instead of
     * an error) and nothing will ever play — tear the service down after a grace
     * period instead of leaving a ghost "playing" notification behind. ENDED
     * streams are torn down regardless of the background setting since a finished
     * live stream cannot resume. The pause-for-app-leave path (background setting
     * off, auto-resume on return) is excluded because it has already reached
     * PLAYING in this session ([hasStablePlayback]); a READY/IDLE session that never
     * played and has no bound fragment is a headset/media-button restore of an
     * already-offline stream and IS a candidate.
     */
    private fun syncDeadStreamWatchdog() {
        if (!isDeadStreamCandidate()) {
            disarmDeadStreamWatchdog()
            return
        }
        if (deadStreamWatchdog != null) return
        val runnable = Runnable {
            deadStreamWatchdog = null
            if (isDeadStreamCandidate()) {
                playerDebugWarn("dead stream watchdog: stopping background playback state=${player?.state}")
                stopPlaybackForGood()
            }
        }
        deadStreamWatchdog = runnable
        applicationHandler?.postDelayed(runnable, DEAD_STREAM_TIMEOUT_MS)
    }

    private fun isDeadStreamCandidate(): Boolean {
        val state = player?.state ?: return false
        if (surfaceAttached || boundClients > 0 || suspendedByFocusLoss || !playbackRequested) return false
        return state == Player.State.ENDED ||
            ((state == Player.State.READY || state == Player.State.IDLE) &&
                (backgroundPlaybackEnabled || !hasStablePlayback))
    }

    private fun disarmDeadStreamWatchdog() {
        deadStreamWatchdog?.let { applicationHandler?.removeCallbacks(it) }
        deadStreamWatchdog = null
    }

    /** Stops for good and clears the resume entry so a headset PLAY won't restart a dead stream. */
    private fun stopPlaybackForGood() {
        clearLastPlaybackRequestIfCurrent()
        stopPlayback()
    }

    fun attachSurface(surface: android.view.Surface?) {
        surfaceAttached = surface != null
        runPlayerOp("attachSurface attached=$surfaceAttached") { it.setSurface(surface) }
        playerDebugLog("attachSurface attached=$surfaceAttached")
        // The stream may already be dead (READY/IDLE/ENDED) from while the surface
        // was attached; no state change will fire after detach, so re-evaluate here.
        syncDeadStreamWatchdog()
    }

    fun setBackgroundPlaybackEnabled(enabled: Boolean) {
        backgroundPlaybackEnabled = enabled
        playerDebugLog("setBackgroundPlaybackEnabled enabled=$enabled")
        updateNotification()
    }

    fun isBackgroundPlaybackEnabled(): Boolean = backgroundPlaybackEnabled

    fun isPlaybackRequested(): Boolean = playbackRequested

    fun play() {
        playbackRequested = true
        suspendedByFocusLoss = false
        disarmDeadStreamWatchdog()
        disarmIdleStop()
        requestAudioFocus()
        // Locks will be acquired on PLAYING/BUFFERING state change.
        runPlayerOp("play") { it.play() }
        // If player is already in PLAYING/BUFFERING, acquire now; otherwise wait for callback.
        player?.state?.let { syncLocksWithState(it) }
        updatePlaybackState()
        updateNotification()
    }

    fun pause(clearPlaybackRequest: Boolean) {
        if (clearPlaybackRequest) {
            playbackRequested = false
            abandonAudioFocus()
        }
        disarmDeadStreamWatchdog()
        runPlayerOp("pause") { it.pause() }
        releasePlaybackLocks()
        armIdleStop()
        updatePlaybackState()
        updateNotification()
    }

    fun resetForReload() {
        backgroundPlaybackEnabled = false
        playbackRequested = false
        disarmDeadStreamWatchdog()
        abandonAudioFocus()
        runPlayerOp("reset-pause") {
            it.pause()
            // A fresh URL is about to arrive; drop any warm source for the stale one.
            evictPreloadedSources()
        }
        releasePlaybackLocks()
        updatePlaybackState()
        updateNotification()
    }

    fun toggleDynamicsProcessing(): Boolean {
        val enabled = !prefs().getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR, false)
        prefs().edit { putBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR, enabled) }
        syncDynamicsProcessingWithPreference()
        return enabled
    }

    fun stopPlayback() {
        watchOwner.clearMetadata()
        backgroundPlaybackEnabled = false
        playbackRequested = false
        suspendedByFocusLoss = false
        disarmDeadStreamWatchdog()
        surfaceAttached = false
        abandonAudioFocus()
        // Queued behind in-flight load/play so play() can't resurrect after stop.
        runPlayerOp("stop") {
            try {
                it.setSurface(null)
            } catch (_: Exception) {
            }
            try {
                it.pause()
            } catch (_: Exception) {
            }
            evictPreloadedSources()
        }
        releasePlaybackLocks()
        updatePlaybackState()
        updateNotification()
        stopSelf()
    }

    private fun updatePlaybackState(error: Boolean = false) {
        val ivsPlayer = player ?: return
        val live = !error && ivsPlayer.duration <= 0L
        val showSeekbar = prefs().getBoolean(AppConstants.PLAYER_SHOW_STREAM_NOTIFICATION_SEEKBAR, true)
        val liveDuration = if (live && startedAtMs > 0L) {
            (System.currentTimeMillis() - startedAtMs).coerceAtLeast(0L)
        } else {
            0L
        }
        val state = when {
            error -> PlaybackState.STATE_ERROR
            ivsPlayer.state == Player.State.PLAYING -> PlaybackState.STATE_PLAYING
            ivsPlayer.state == Player.State.BUFFERING -> PlaybackState.STATE_BUFFERING
            ivsPlayer.state == Player.State.READY && playbackRequested -> PlaybackState.STATE_PLAYING
            ivsPlayer.state == Player.State.READY -> PlaybackState.STATE_PAUSED
            ivsPlayer.state == Player.State.ENDED -> PlaybackState.STATE_STOPPED
            else -> if (playbackRequested) PlaybackState.STATE_PLAYING else PlaybackState.STATE_PAUSED
        }
        session?.setPlaybackState(
            PlaybackState.Builder().apply {
                setState(
                    state,
                    when {
                        live && showSeekbar && liveDuration > 0L -> liveDuration
                        live -> -1L
                        else -> ivsPlayer.position
                    },
                    if (state == PlaybackState.STATE_PLAYING) ivsPlayer.playbackRate else 0f
                )
                setActions(
                    PlaybackState.ACTION_STOP or
                        PlaybackState.ACTION_PLAY or
                        PlaybackState.ACTION_PAUSE or
                        PlaybackState.ACTION_SKIP_TO_NEXT or
                        PlaybackState.ACTION_SKIP_TO_PREVIOUS or
                        PlaybackState.ACTION_FAST_FORWARD or
                        PlaybackState.ACTION_REWIND or
                        PlaybackState.ACTION_PLAY_PAUSE or
                        (if (!live || (showSeekbar && liveDuration > 0L)) PlaybackState.ACTION_SEEK_TO else 0L)
                )
            }.build()
        )
    }

    private fun updateMetadata() {
        val bitmap = channelLogo?.let { channelLogo ->
            val loader = bitmapLoader ?: CacheBitmapLoader(DataSourceBitmapLoader.Builder(this).build()).also { bitmapLoader = it }
            loader.loadBitmap(Uri.parse(channelLogo)).let { bitmapFuture ->
                metadataBitmapCallback = null
                if (bitmapFuture.isDone) {
                    try {
                        bitmapFuture.get()
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    val callback = object : FutureCallback<Bitmap> {
                        override fun onSuccess(result: Bitmap) {
                            if (this == metadataBitmapCallback) {
                                setMetadata(result)
                            }
                        }

                        override fun onFailure(t: Throwable) = Unit
                    }
                    metadataBitmapCallback = callback
                    applicationHandler?.let { Futures.addCallback(bitmapFuture, callback, it::post) }
                    null
                }
            }
        }
        setMetadata(bitmap)
    }

    private fun setMetadata(bitmap: Bitmap?) {
        player?.let { player ->
            val showSeekbar = prefs().getBoolean(AppConstants.PLAYER_SHOW_STREAM_NOTIFICATION_SEEKBAR, true)
            val live = player.duration <= 0L
            val liveDuration = if (live && startedAtMs > 0L) {
                (System.currentTimeMillis() - startedAtMs).coerceAtLeast(0L)
            } else {
                -1L
            }
            session?.setMetadata(
                MediaMetadata.Builder().apply {
                    putText(MediaMetadata.METADATA_KEY_TITLE, title)
                    putText(MediaMetadata.METADATA_KEY_ARTIST, channelName)
                    if (bitmap != null) {
                        putBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON, bitmap)
                        putBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART, bitmap)
                    }
                    // expose the stream uptime as a synthetic timeline so system UI
                    // can render a seekbar for live streams too
                    putLong(
                        MediaMetadata.METADATA_KEY_DURATION,
                        when {
                            player.duration > 0L -> player.duration
                            live && showSeekbar && liveDuration > 0L -> liveDuration
                            else -> -1L
                        }
                    )
                }.build()
            )
        }
    }

    private fun updateNotification() {
        val bitmap = channelLogo?.let { channelLogo ->
            val loader = bitmapLoader ?: CacheBitmapLoader(DataSourceBitmapLoader.Builder(this).build()).also { bitmapLoader = it }
            loader.loadBitmap(Uri.parse(channelLogo)).let { bitmapFuture ->
                notificationBitmapCallback = null
                if (bitmapFuture.isDone) {
                    try {
                        bitmapFuture.get()
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    val callback = object : FutureCallback<Bitmap> {
                        override fun onSuccess(result: Bitmap) {
                            if (this == notificationBitmapCallback) {
                                sendNotification(result)
                            }
                        }

                        override fun onFailure(t: Throwable) = Unit
                    }
                    notificationBitmapCallback = callback
                    applicationHandler?.let { Futures.addCallback(bitmapFuture, callback, it::post) }
                    null
                }
            }
        }
        sendNotification(bitmap)
    }

    private fun sendNotification(bitmap: Bitmap?) {
        val ivsPlayer = player ?: return
        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, getString(R.string.notification_playback_channel_id))
        } else {
            @Suppress("DEPRECATION")
            Notification.Builder(this)
        }.apply {
            setContentTitle(title)
            setContentText(channelName)
            setSmallIcon(R.drawable.notification_icon)
            if (bitmap != null) {
                setLargeIcon(bitmap)
            }
            setVisibility(Notification.VISIBILITY_PUBLIC)
            setOnlyAlertOnce(true)
            setOngoing(ivsPlayer.state == Player.State.PLAYING || ivsPlayer.state == Player.State.BUFFERING)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setCategory(Notification.CATEGORY_TRANSPORT)
            }
            setStyle(
                Notification.MediaStyle()
                    .setMediaSession(session?.sessionToken)
                    .setShowActionsInCompactView(0)
            )
            setContentIntent(
                PendingIntent.getActivity(
                    this@IvsPlayerService,
                    REQUEST_CODE_RESUME,
                    Intent(this@IvsPlayerService, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        action = MainActivity.INTENT_OPEN_PLAYER
                    },
                    PendingIntent.FLAG_IMMUTABLE
                )
            )
            addAction(
                Notification.Action.Builder(
                    Icon.createWithResource(
                        this@IvsPlayerService,
                        if (ivsPlayer.state == Player.State.PLAYING) {
                            androidx.media3.session.R.drawable.media3_icon_pause
                        } else {
                            androidx.media3.session.R.drawable.media3_icon_play
                        }
                    ),
                    ContextCompat.getString(
                        this@IvsPlayerService,
                        if (ivsPlayer.state == Player.State.PLAYING) R.string.pause else R.string.resume
                    ),
                    PendingIntent.getService(
                        this@IvsPlayerService,
                        REQUEST_CODE_PLAY_PAUSE,
                        Intent(this@IvsPlayerService, IvsPlayerService::class.java).apply {
                            action = INTENT_PLAY_PAUSE
                        },
                        PendingIntent.FLAG_IMMUTABLE
                    )
                ).build()
            )
        }.build()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK)
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            if (Intent.ACTION_MEDIA_BUTTON == intent.action) {
                val keyEvent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT, KeyEvent::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT)
                }
                if (keyEvent != null && keyEvent.action == KeyEvent.ACTION_DOWN) {
                    when (keyEvent.keyCode) {
                        KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, KeyEvent.KEYCODE_HEADSETHOOK -> {
                            val ivsPlayer = player
                            if (ivsPlayer?.state == Player.State.PLAYING) {
                                pause(clearPlaybackRequest = true)
                            } else {
                                if (ivsPlayer?.state == Player.State.READY || ivsPlayer?.state == Player.State.ENDED || playbackRequested) {
                                    play()
                                } else if (!restoreFromSavedRequest()) {
                                    // See KEYCODE_MEDIA_PLAY: startForegroundService
                                    // requires the service to go foreground here.
                                    stopPlayback()
                                    return START_NOT_STICKY
                                }
                            }
                            updatePlaybackState()
                            updateNotification()
                        }
                        KeyEvent.KEYCODE_MEDIA_PLAY -> {
                            val ivsPlayer = player
                            if (ivsPlayer?.state == Player.State.READY || ivsPlayer?.state == Player.State.ENDED || playbackRequested) {
                                play()
                            } else if (!restoreFromSavedRequest()) {
                                // Started via startForegroundService (headset PLAY with
                                // the process dead) and nothing to restore: the service
                                // must still enter the foreground within the system
                                // timeout or the app crashes — post the idle state.
                                stopPlayback()
                                return START_NOT_STICKY
                            }
                            updatePlaybackState()
                            updateNotification()
                        }
                        KeyEvent.KEYCODE_MEDIA_PAUSE, KeyEvent.KEYCODE_MEDIA_STOP -> {
                            pause(clearPlaybackRequest = true)
                            if (keyEvent.keyCode == KeyEvent.KEYCODE_MEDIA_STOP) {
                                clearLastPlaybackRequestIfCurrent()
                            }
                            updatePlaybackState()
                            updateNotification()
                        }
                        KeyEvent.KEYCODE_MEDIA_NEXT, KeyEvent.KEYCODE_MEDIA_FAST_FORWARD -> {
                            val fastForwardMs = (prefs().getString(AppConstants.PLAYER_FORWARD, "10")?.toLongOrNull() ?: 10) * 1000
                            runPlayerOp("media-next") { it.seekTo(it.position + fastForwardMs) }
                        }
                        KeyEvent.KEYCODE_MEDIA_PREVIOUS, KeyEvent.KEYCODE_MEDIA_REWIND -> {
                            val rewindMs = (prefs().getString(AppConstants.PLAYER_REWIND, "10")?.toLongOrNull() ?: 10) * 1000
                            runPlayerOp("media-prev") { it.seekTo((it.position - rewindMs).coerceAtLeast(0L)) }
                        }
                    }
                }
            } else when (intent.action) {
                INTENT_PLAY_PAUSE -> {
                    val ivsPlayer = player
                    if (ivsPlayer?.state == Player.State.PLAYING) {
                        pause(clearPlaybackRequest = true)
                    } else {
                        play()
                    }
                    updatePlaybackState()
                    updateNotification()
                }
                INTENT_RESUME_BACKGROUND_IF_LOCKED -> {
                    // Late SCREEN_OFF arrived after onStop paused for "unlocked PiP".
                    // Only resume audio when the device is actually locked/off now.
                    if (isDeviceLockedOrScreenOff() && !currentUrl.isNullOrBlank()) {
                        val state = player?.state
                        if (state != null && state != Player.State.PLAYING && state != Player.State.ENDED) {
                            playerDebugLog("late screen-off resume state=$state background=$backgroundPlaybackEnabled")
                            backgroundPlaybackEnabled = true
                            play()
                            updatePlaybackState()
                            updateNotification()
                        }
                    }
                }
            }
        }
        return START_STICKY
    }

    private var boundClients = 0

    override fun onBind(intent: Intent?): IBinder {
        boundClients += 1
        disarmIdleStop()
        return ServiceBinder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        boundClients = (boundClients - 1).coerceAtLeast(0)
        // No state change will fire just because the fragment left; re-evaluate the
        // dead-stream watchdog so an already-dead stream cannot ride along unwatched.
        syncDeadStreamWatchdog()
        if (!backgroundPlaybackEnabled && !playbackRequested) {
            stopSelf()
        }
        return super.onUnbind(intent)
    }

    inner class ServiceBinder : Binder() {
        fun getService() = this@IvsPlayerService
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        if (!backgroundPlaybackEnabled) {
            stopPlayback()
        }
    }

    private fun syncDynamicsProcessingWithPreference() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            return
        }
        if (!prefs().getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR, false)) {
            dynamicsProcessing?.enabled = false
            return
        }
        val audioSessionId = player?.audioSessionId?.takeIf { it > 0 } ?: return
        if (dynamicsProcessingAudioSessionId != audioSessionId || dynamicsProcessing == null) {
            reinitializeDynamicsProcessing(audioSessionId)
        } else if (dynamicsProcessing?.enabled != true) {
            dynamicsProcessing?.enabled = true
        }
    }

    private fun reinitializeDynamicsProcessing(audioSessionId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            releaseDynamicsProcessing()
            dynamicsProcessing = DynamicsProcessing(0, audioSessionId, null).apply {
                for (channelIdx in 0 until channelCount) {
                    for (bandIdx in 0 until getMbcByChannelIndex(channelIdx).bandCount) {
                        setMbcBandByChannelIndex(
                            channelIdx,
                            bandIdx,
                            getMbcBandByChannelIndex(channelIdx, bandIdx).apply {
                                attackTime = 0f
                                releaseTime = 0.25f
                                ratio = 1.6f
                                threshold = -50f
                                kneeWidth = 40f
                                preGain = 0f
                                postGain = 10f
                            }
                        )
                    }
                }
                enabled = true
            }
            dynamicsProcessingAudioSessionId = audioSessionId
        }
    }

    private fun releaseDynamicsProcessing() {
        dynamicsProcessing?.release()
        dynamicsProcessing = null
        dynamicsProcessingAudioSessionId = null
    }

    override fun onDestroy() {
        watchOwner.release()
        metadataBitmapCallback = null
        notificationBitmapCallback = null
        applicationHandler?.removeCallbacksAndMessages(null)
        wifiLockSafetyRunnable = null
        notificationManager?.cancel(NOTIFICATION_ID)
        session?.release()
        abandonAudioFocus()
        releaseDynamicsProcessing()
        // Pause when active, wait up to 1s for a safe release state, then detach
        // and release. Releasing straight from PLAYING/BUFFERING stalls the next load.
        val doomed = player
        player = null
        playerExecutor.shutdownNow()
        Thread({
            val target = doomed ?: return@Thread
            try {
                try {
                    val state = target.state
                    if (state == Player.State.PLAYING || state == Player.State.BUFFERING) {
                        target.pause()
                    }
                } catch (_: Exception) {
                }
                val deadline = SystemClock.uptimeMillis() + SAFE_RELEASE_WAIT_MS
                while (SystemClock.uptimeMillis() < deadline) {
                    val state = try {
                        target.state
                    } catch (_: Exception) {
                        null
                    } ?: break
                    if (state == Player.State.IDLE ||
                        state == Player.State.READY ||
                        state == Player.State.ENDED
                    ) {
                        break
                    }
                    try {
                        Thread.sleep(SAFE_RELEASE_POLL_MS)
                    } catch (_: InterruptedException) {
                        break
                    }
                }
                try {
                    target.setSurface(null)
                } catch (_: Exception) {
                }
                evictPreloadedSources()
                try {
                    target.release()
                } catch (_: Exception) {
                }
            } catch (_: Exception) {
            }
        }, "IvsPlayerRelease").start()
        releasePlaybackLocks()
        wakeLock = null
        wifiLock = null
        prefs().unregisterOnSharedPreferenceChangeListener(rewardsPreferenceChangeListener)
        super.onDestroy()
    }

    companion object {
        private const val TAG = "IvsPlayerService"
        private const val NOTIFICATION_ID = DefaultMediaNotificationProvider.DEFAULT_NOTIFICATION_ID
        private const val REQUEST_CODE_RESUME = 0
        private const val REQUEST_CODE_PLAY_PAUSE = 1
        private const val INTENT_PLAY_PAUSE = "com.xtrakick.app.IVS_PLAY_PAUSE"
        const val INTENT_RESUME_BACKGROUND_IF_LOCKED = "com.xtrakick.app.IVS_RESUME_BACKGROUND_IF_LOCKED"
        private const val LAST_PLAYBACK_CHANNEL_ID = "last_playback_channel_id"
        private const val LAST_PLAYBACK_LIVESTREAM_ID = "last_playback_livestream_id"
        private const val LAST_PLAYBACK_CHANNEL_LOGIN = "last_playback_channel_login"

        /** Safety timeout — locks are explicitly released on pause/stop, this is fallback only. */
        private const val WAKE_LOCK_TIMEOUT_MS = 10L * 60L * 1000L

        /** Grace period before a background READY/IDLE player is declared a dead stream. */
        private const val DEAD_STREAM_TIMEOUT_MS = 30_000L

        /** Cap on warm sources held for preload → loadSource swaps. */
        private const val MAX_PRELOADED_SOURCES = 2

        /** Pre-release wait budget for reaching a safe player state. */
        private const val SAFE_RELEASE_WAIT_MS = 1_000L
        private const val SAFE_RELEASE_POLL_MS = 50L
    }
}
