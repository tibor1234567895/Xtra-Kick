package com.xtrakick.app.ui.player

import android.app.PendingIntent
import android.content.Intent
import android.media.audiofx.DynamicsProcessing
import android.net.http.HttpEngine
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.ext.SdkExtensions
import android.util.Log
import androidx.annotation.OptIn
import androidx.core.content.edit
import androidx.core.net.toUri
import com.xtrakick.app.util.bundleOf
import androidx.media3.common.AudioAttributes
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.HttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsManifest
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist
import androidx.media3.exoplayer.hls.playlist.HlsPlaylist
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory
import androidx.media3.exoplayer.source.BehindLiveWindowException
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
import androidx.media3.exoplayer.upstream.ParsingLoadable
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import androidx.media3.session.SessionCommand
import androidx.media3.session.SessionResult
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.model.VideoPosition
import com.xtrakick.app.player.lowlatency.CronetDataSource
import com.xtrakick.app.player.lowlatency.HlsPlaylistParser
import com.xtrakick.app.player.lowlatency.HttpEngineDataSource
import com.xtrakick.app.player.lowlatency.OkHttpDataSource
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.chat.KickViewerWatchWebSocket
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import okhttp3.Credentials
import okhttp3.OkHttpClient
import org.chromium.net.CronetEngine
import org.json.JSONObject
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.ProxySelector
import java.net.SocketAddress
import java.net.URI
import java.util.Timer
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate


@OptIn(UnstableApi::class)
@AndroidEntryPoint
class PlaybackService : MediaSessionService() {

    private class StreamLoadErrorHandlingPolicy : DefaultLoadErrorHandlingPolicy(6) {
        override fun getRetryDelayMsFor(loadErrorInfo: LoadErrorHandlingPolicy.LoadErrorInfo): Long {
            val exception = loadErrorInfo.exception as? HttpDataSource.InvalidResponseCodeException
            if (exception?.responseCode == 403 || exception?.responseCode == 404) {
                return androidx.media3.common.C.TIME_UNSET
            }
            return super.getRetryDelayMsFor(loadErrorInfo)
        }
    }

    @Inject
    @JvmField
    var httpEngine: Lazy<HttpEngine>? = null

    @Inject
    @JvmField
    var cronetEngine: Lazy<CronetEngine>? = null

    @Inject
    lateinit var cronetExecutor: ExecutorService

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var playerRepository: PlayerRepository

    @Inject
    lateinit var offlineRepository: OfflineRepository

    @Inject
    lateinit var kickRepository: KickRepository

    @Inject
    @JvmField
    var trustManager: javax.net.ssl.X509TrustManager? = null

    private var mediaSession: MediaSession? = null
    private var dynamicsProcessing: DynamicsProcessing? = null
    private var background = false
    private var backgroundPrepareRetryCount = 0
    private var videoId: Long? = null
    private var offlineVideoId: Int? = null
    private lateinit var activeLatencyConfig: LiveLatencyConfig
    private var sleepTimer: Timer? = null
    private var sleepTimerEndTime = 0L
    private var lastSavedPosition: Long? = null
    private var savePositionTimer: Timer? = null
    private var idleStopTimer: Timer? = null
    private val kickViewerWatchScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var kickViewerWatch: KickViewerWatchWebSocket? = null
    private var kickViewerWatchJob: Job? = null
    private var activeKickChannelId: String? = null
    private var activeKickLivestreamId: String? = null
    private var activeKickChannelLogin: String? = null

    private fun startKickViewerWatchIfNeeded() {
        val channelId = activeKickChannelId?.takeIf { it.isNotBlank() }
        val livestreamId = activeKickLivestreamId?.takeIf { it.isNotBlank() }
        val channelLogin = activeKickChannelLogin?.takeIf { it.isNotBlank() }
        if (channelId == null && livestreamId == null && channelLogin == null) return
        if (kickViewerWatchJob?.isActive == true) return
        kickViewerWatch = KickViewerWatchWebSocket(
            kickRepository = kickRepository,
            channelId = channelId,
            livestreamId = livestreamId,
            channelLogin = channelLogin,
            trustManager = trustManager,
            debugLogging = BuildConfig.DEBUG,
        ).also { watch ->
            kickViewerWatchJob = watch.start(kickViewerWatchScope)
        }
    }

    private fun stopKickViewerWatch() {
        val watch = kickViewerWatch ?: return
        kickViewerWatch = null
        kickViewerWatchJob?.cancel()
        kickViewerWatchJob = null
        kickViewerWatchScope.launch { watch.stop() }
    }

    /**
     * Stops the service when it has been left paused/idle/errored for 10 minutes,
     * mirroring upstream Xtra's idle auto-stop. SystemUI's persistent session
     * controller must not block the timer (verified on device: 17 controllers while
     * paused), so only a controller from this app's own UID — the in-app player
     * fragment, where the user may intentionally sit on a paused screen — defers it.
     */
    private fun startIdleTimerIfUnused() {
        if (idleStopTimer == null && mediaSession?.player?.isPlaying != true) {
            idleStopTimer = Timer().apply {
                schedule(600000) {
                    Handler(Looper.getMainLooper()).post {
                        // Playback may have resumed between scheduling and this post
                        // (stopIdleTimer cancels the timer, not an already-queued runnable).
                        if (mediaSession?.player?.isPlaying == true) {
                            idleStopTimer = null
                            return@post
                        }
                        if (hasOwnAppController()) {
                            // In-app controller still bound (user parked on the player):
                            // re-arm so we stop once they leave.
                            idleStopTimer = null
                            startIdleTimerIfUnused()
                        } else {
                            savePosition()
                            pauseAllPlayersAndStopSelf()
                        }
                    }
                }
            }
        }
    }

    private fun hasOwnAppController(): Boolean {
        val session = mediaSession ?: return false
        return session.connectedControllers.any { it.uid == Process.myUid() }
    }

    private fun stopIdleTimer() {
        idleStopTimer?.cancel()
        idleStopTimer = null
    }

    private fun isBufferDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && prefs().getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)
    }

    private fun logBufferDebug(message: String) {
        if (isBufferDebugEnabled()) {
            Log.d(TAG, message)
        }
    }

    override fun onCreate() {
        super.onCreate()
        activeLatencyConfig = LiveLatencySettings.resolve(prefs())
        val player = ExoPlayer.Builder(this).apply {
            setLoadControl(LiveLatencySettings.toLoadControl(activeLatencyConfig))
            setAudioAttributes(AudioAttributes.DEFAULT, prefs().getBoolean(AppConstants.PLAYER_AUDIO_FOCUS, true))
            setHandleAudioBecomingNoisy(prefs().getBoolean(AppConstants.PLAYER_HANDLE_AUDIO_BECOMING_NOISY, true))
            setSeekBackIncrementMs((prefs().getString(AppConstants.PLAYER_REWIND, "10")?.toLongOrNull() ?: 10) * 1000)
            setSeekForwardIncrementMs((prefs().getString(AppConstants.PLAYER_FORWARD, "10")?.toLongOrNull() ?: 10) * 1000)
        }.build()
        logBufferDebug(
            "PlaybackService created with latency=${LiveLatencySettings.describe(activeLatencyConfig)}"
        )
        player.addListener(
            object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    logBufferDebug(
                        "playbackState=${playbackStateName(playbackState)} " +
                            "playWhenReady=${player.playWhenReady} isPlaying=${player.isPlaying} " +
                            "background=$background " +
                            "mediaItemPresent=${player.currentMediaItem != null}"
                    )
                }

                override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
                    logBufferDebug(
                        "playWhenReadyChanged playWhenReady=$playWhenReady reason=$reason " +
                            "background=$background"
                    )
                }

                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    logBufferDebug(
                        "isPlayingChanged isPlaying=$isPlaying " +
                            "background=$background " +
                            "currentPosition=${player.currentPosition}"
                    )
                    if (isPlaying) {
                        backgroundPrepareRetryCount = 0
                        startKickViewerWatchIfNeeded()
                        stopIdleTimer()
                        if (savePositionTimer == null && (videoId != null || offlineVideoId != null)) {
                            savePositionTimer = Timer().apply {
                                scheduleAtFixedRate(30000, 30000) {
                                    Handler(Looper.getMainLooper()).post {
                                        updateSavedPosition()
                                    }
                                }
                            }
                        }
                    } else {
                        stopKickViewerWatch()
                        savePositionTimer?.cancel()
                        savePositionTimer = null
                        updateSavedPosition()
                        startIdleTimerIfUnused()
                    }
                }

                override fun onPlayerError(error: PlaybackException) {
                    logPlayerError(error)
                    val httpCode = httpResponseCode(error)
                    if (httpCode == 404 && videoId == null && offlineVideoId == null) {
                        DiagnosticLogger.w(TAG, "stream 404 terminal error in service, stopping playback")
                        player.clearMediaItems()
                        player.stop()
                        if (!background) {
                            // Foreground: the fragment shows its own ended overlay and
                            // will bind a fresh session on retry — release this one so
                            // the notification/session don't outlive the dead stream.
                            pauseAllPlayersAndStopSelf()
                        }
                        return
                    }
                    if (!background && videoId == null && offlineVideoId == null && !isBehindLiveWindowError(error)) {
                        // Foreground live-stream error: the fragment owns recovery (restart,
                        // fresh-URL retry, offline overlay, network-restored restart) via
                        // its still-bound MediaController. But playWhenReady stays true on
                        // an errored player, and plain pause() leaves the service in the
                        // foreground for Media3's FGS timeout — use the documented
                        // immediate teardown instead. VOD/offline playback is excluded:
                        // those keep the old behavior (fragment-side handling only).
                        DiagnosticLogger.w(TAG, "foreground live playerError terminal, stopping foreground service")
                        pauseAllPlayersAndStopSelf()
                        return
                    }
                    if (background) {
                        if (isBehindLiveWindowError(error)) {
                            DiagnosticLogger.w(
                                TAG,
                                "behindLiveWindow recovery start background=$background " +
                                    "state=${playbackStateName(player.playbackState)} playWhenReady=${player.playWhenReady} " +
                                    "isPlaying=${player.isPlaying} mediaItemPresent=${player.currentMediaItem != null}"
                            )
                            player.seekToDefaultPosition()
                            player.playWhenReady = true
                            player.prepare()
                            Handler(Looper.getMainLooper()).postDelayed({
                                DiagnosticLogger.w(
                                    TAG,
                                    "behindLiveWindow recovery followup background=$background " +
                                        "state=${playbackStateName(player.playbackState)} playWhenReady=${player.playWhenReady} " +
                                        "isPlaying=${player.isPlaying} error=${player.playerError?.errorCodeName}"
                                )
                            }, 5000L)
                            return
                        }
                        // Cap prepare() retries so a persistent error (DNS down, 5xx,
                        // timeouts) can't loop error→prepare forever in the background.
                        if (backgroundPrepareRetryCount >= BACKGROUND_PREPARE_MAX_RETRIES) {
                            DiagnosticLogger.w(
                                TAG,
                                "background playerError recovery exhausted after $backgroundPrepareRetryCount prepare() retries, stopping playback"
                            )
                            pauseAllPlayersAndStopSelf()
                            return
                        }
                        backgroundPrepareRetryCount += 1
                        DiagnosticLogger.w(
                            TAG,
                            "background playerError recovery via prepare retry=$backgroundPrepareRetryCount " +
                                "code=${error.errorCodeName} " +
                                "state=${playbackStateName(player.playbackState)} playWhenReady=${player.playWhenReady}"
                        )
                        player.prepare()
                    }
                }

                override fun onAudioSessionIdChanged(audioSessionId: Int) {
                    dynamicsProcessing?.let {
                        it.release()
                        dynamicsProcessing = null
                    }
                    if (prefs().getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR, false)) {
                        reinitializeDynamicsProcessing(audioSessionId)
                    }
                }
            }
        )
        mediaSession = MediaSession.Builder(
            this,
            player
        ).apply {
            setSessionActivity(
                PendingIntent.getActivity(
                    this@PlaybackService,
                    REQUEST_CODE_RESUME,
                    Intent(this@PlaybackService, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        action = MainActivity.INTENT_OPEN_PLAYER
                    },
                    PendingIntent.FLAG_IMMUTABLE
                )
            )
            setCallback(
                object : MediaSession.Callback {
                    override fun onConnect(session: MediaSession, controller: MediaSession.ControllerInfo): MediaSession.ConnectionResult {
                        val connectionResult = super.onConnect(session, controller)
                        val sessionCommands = connectionResult.availableSessionCommands.buildUpon().apply {
                            add(SessionCommand(START_STREAM, Bundle.EMPTY))
                            add(SessionCommand(START_VIDEO, Bundle.EMPTY))
                            add(SessionCommand(START_CLIP, Bundle.EMPTY))
                            add(SessionCommand(START_OFFLINE_VIDEO, Bundle.EMPTY))
                            add(SessionCommand(TOGGLE_DYNAMICS_PROCESSING, Bundle.EMPTY))
                            add(SessionCommand(SET_SLEEP_TIMER, Bundle.EMPTY))
                            add(SessionCommand(GET_QUALITIES, Bundle.EMPTY))
                            add(SessionCommand(GET_DURATION, Bundle.EMPTY))
                            add(SessionCommand(GET_ERROR_CODE, Bundle.EMPTY))
                            add(SessionCommand(GET_MEDIA_PLAYLIST, Bundle.EMPTY))
                            add(SessionCommand(GET_MULTIVARIANT_PLAYLIST, Bundle.EMPTY))
                        }.build()
                        val playerCommands = Player.Commands.Builder()
                            .addAllCommands()
                            .build()
                        return MediaSession.ConnectionResult.accept(sessionCommands, playerCommands)
                    }

                    override fun onCustomCommand(session: MediaSession, controller: MediaSession.ControllerInfo, customCommand: SessionCommand, args: Bundle): ListenableFuture<SessionResult> {
                        return when (customCommand.customAction) {
                            START_STREAM -> {
                                val uri = customCommand.customExtras.getString(URI)
                                val title = customCommand.customExtras.getString(TITLE)
                                val channelName = customCommand.customExtras.getString(CHANNEL_NAME)
                                val channelLogo = customCommand.customExtras.getString(CHANNEL_LOGO)
                                stopKickViewerWatch()
                                val isKick = customCommand.customExtras.getBoolean(IS_KICK_STREAM, false)
                                    || customCommand.customExtras.getString(IS_KICK_STREAM).equals(AppConstants.KICK, ignoreCase = true)
                                activeKickChannelId = customCommand.customExtras.getString(CHANNEL_ID)?.takeIf { isKick }
                                activeKickLivestreamId = customCommand.customExtras.getString(LIVESTREAM_ID)?.takeIf { isKick }
                                activeKickChannelLogin = customCommand.customExtras.getString(CHANNEL_LOGIN)?.takeIf { isKick }
                                if (session.player.isPlaying) {
                                    startKickViewerWatchIfNeeded()
                                }
                                logBufferDebug(
                                    "START_STREAM received channel=$channelName uriPresent=${!uri.isNullOrBlank()}"
                                )
                                DiagnosticLogger.i(
                                    TAG,
                                    "START_STREAM service received channel=$channelName " +
                                        "background=$background " +
                                        "${summarizePlaybackUri(uri)}"
                                )
                                // mark the media3 engine as the last used one so the
                                // headset-button resume receiver stays out of the way
                                prefs().edit { putString(AppConstants.LAST_PLAYBACK_ENGINE, "media3") }
                                stopIdleTimer()
                                videoId = null
                                offlineVideoId = null
                                // A new stream gets its own full retry budget: a partial
                                // count from the previous stream must not shorten it.
                                backgroundPrepareRetryCount = 0
                                val proxyHost = prefs().getString(AppConstants.PROXY_HOST, null)
                                val proxyPort = prefs().getString(AppConstants.PROXY_PORT, null)?.toIntOrNull()
                                val proxyUser = prefs().getString(AppConstants.PROXY_USER, null)
                                val proxyPassword = prefs().getString(AppConstants.PROXY_PASSWORD, null)
                                val proxyMultivariantPlaylist = prefs().getBoolean(AppConstants.PROXY_MULTIVARIANT_PLAYLIST, false)
                                val validProxyConfiguration = PlaybackProxyUtils.isValidProxyConfiguration(proxyHost, proxyPort)
                                val streamLatencyConfig = activeLatencyConfig
                                logBufferDebug("Starting live stream with lowLatencyHls=true latency=${LiveLatencySettings.describe(streamLatencyConfig)}")
                                if (proxyMultivariantPlaylist && !validProxyConfiguration) {
                                    PlaybackProxyUtils.logInvalidProxyConfiguration("playback_service", proxyHost, proxyPort)
                                }
                                val multivariantPlaylistProxyClient = if (proxyMultivariantPlaylist && validProxyConfiguration) {
                                    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(proxyHost, proxyPort!!))
                                    okHttpClient.newBuilder().apply {
                                        proxySelector(
                                            object : ProxySelector() {
                                                override fun select(u: URI): List<Proxy> {
                                                    return PlaybackProxyUtils.selectProxy(u, proxy, "multivariant")
                                                }

                                                override fun connectFailed(u: URI, sa: SocketAddress, e: IOException) {}
                                            }
                                        )
                                        if (!proxyUser.isNullOrBlank() && !proxyPassword.isNullOrBlank()) {
                                            proxyAuthenticator { _, response ->
                                                response.request.newBuilder().header(
                                                    "Proxy-Authorization", Credentials.basic(proxyUser, proxyPassword)
                                                ).build()
                                            }
                                        }
                                    }.build()
                                } else null
                                val networkLibrary = prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
                                player.setMediaSource(
                                    HlsMediaSource.Factory(
                                        DefaultDataSource.Factory(
                                            this@PlaybackService,
                                            when {
                                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                                    HttpEngineDataSource.Factory(httpEngine!!.get(), cronetExecutor, multivariantPlaylistProxyClient, null) { false }
                                                }
                                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                                    CronetDataSource.Factory(cronetEngine!!.get(), cronetExecutor, multivariantPlaylistProxyClient, null) { false }
                                                }
                                                else -> {
                                                    OkHttpDataSource.Factory(multivariantPlaylistProxyClient ?: okHttpClient, null) { false }
                                                }
                                            }.apply {
                                                prefs().getString(AppConstants.PLAYER_STREAM_HEADERS, null)?.let {
                                                    try {
                                                        val json = JSONObject(it)
                                                        hashMapOf<String, String>().apply {
                                                            json.keys().forEach { key ->
                                                                put(key, json.optString(key))
                                                            }
                                                        }
                                                    } catch (e: Exception) {
                                                        null
                                                    }
                                                }?.let {
                                                    setDefaultRequestProperties(it)
                                                }
                                            }
                                        )
                                    ).apply {
                                        setPlaylistParserFactory(CustomHlsPlaylistParserFactory())
                                        setLoadErrorHandlingPolicy(StreamLoadErrorHandlingPolicy())
                                    }.createMediaSource(
                                        MediaItem.Builder().apply {
                                            setMediaId(uri.orEmpty())
                                            setUri(uri?.toUri())
                                            setLiveConfiguration(LiveLatencySettings.toLiveConfiguration(streamLatencyConfig))
                                            setMediaMetadata(
                                                MediaMetadata.Builder().apply {
                                                    setTitle(title)
                                                    setArtist(channelName)
                                                    setArtworkUri(channelLogo?.toUri())
                                                }.build()
                                            )
                                        }.build()
                                    )
                                )
                                session.player.volume = prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(1f)
                                session.player.prepare()
                                session.player.playWhenReady = true
                                Handler(Looper.getMainLooper()).postDelayed({
                                    val errorName = session.player.playerError?.errorCodeName
                                    val followupMessage =
                                        "START_STREAM service followup channel=$channelName ${summarizePlaybackUri(uri)} " +
                                            "state=${playbackStateName(session.player.playbackState)} " +
                                            "playWhenReady=${session.player.playWhenReady} isPlaying=${session.player.isPlaying} " +
                                            "error=$errorName"
                                    if (errorName != null) {
                                        DiagnosticLogger.w(TAG, followupMessage)
                                    } else {
                                        DiagnosticLogger.i(TAG, followupMessage)
                                    }
                                }, 5000L)
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
                            }
                            START_VIDEO -> {
                                val uri = customCommand.customExtras.getString(URI)
                                val title = customCommand.customExtras.getString(TITLE)
                                val channelName = customCommand.customExtras.getString(CHANNEL_NAME)
                                val channelLogo = customCommand.customExtras.getString(CHANNEL_LOGO)
                                stopKickViewerWatch()
                                activeKickChannelId = null
                                activeKickLivestreamId = null
                                activeKickChannelLogin = null
                                val newId = customCommand.customExtras.getLong(VIDEO_ID).takeIf { it != 0L }
                                val position = if (videoId == newId && session.player.currentMediaItem != null) {
                                    session.player.currentPosition
                                } else {
                                    customCommand.customExtras.getLong(PLAYBACK_POSITION)
                                }
                                // mark the media3 engine as the last used one so the
                                // headset-button resume receiver stays out of the way
                                prefs().edit { putString(AppConstants.LAST_PLAYBACK_ENGINE, "media3") }
                                stopIdleTimer()
                                videoId = newId
                                offlineVideoId = null
                                // A new item gets its own full retry budget.
                                if (backgroundPrepareRetryCount > 0) backgroundPrepareRetryCount = 0
                                val networkLibrary = prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
                                player.setMediaSource(
                                    HlsMediaSource.Factory(
                                        DefaultDataSource.Factory(
                                            this@PlaybackService,
                                            when {
                                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                                    HttpEngineDataSource.Factory(httpEngine!!.get(), cronetExecutor, null, null) { false }
                                                }
                                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                                    CronetDataSource.Factory(cronetEngine!!.get(), cronetExecutor, null, null) { false }
                                                }
                                                else -> {
                                                    OkHttpDataSource.Factory(okHttpClient, null) { false }
                                                }
                                            }
                                        )
                                    ).apply {
                                        setPlaylistParserFactory(CustomHlsPlaylistParserFactory())
                                    }.createMediaSource(
                                        MediaItem.Builder().apply {
                                            setMediaId(uri.orEmpty())
                                            setUri(uri?.toUri())
                                            setMediaMetadata(
                                                MediaMetadata.Builder().apply {
                                                    setTitle(title)
                                                    setArtist(channelName)
                                                    setArtworkUri(channelLogo?.toUri())
                                                }.build()
                                            )
                                        }.build()
                                    )
                                )
                                session.player.volume = prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(prefs().getFloat(AppConstants.PLAYER_SPEED, 1f))
                                session.player.prepare()
                                session.player.playWhenReady = true
                                session.player.seekTo(position)
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
                            }
                            START_CLIP -> {
                                val uri = customCommand.customExtras.getString(URI)
                                val title = customCommand.customExtras.getString(TITLE)
                                val channelName = customCommand.customExtras.getString(CHANNEL_NAME)
                                val channelLogo = customCommand.customExtras.getString(CHANNEL_LOGO)
                                stopKickViewerWatch()
                                activeKickChannelId = null
                                activeKickLivestreamId = null
                                activeKickChannelLogin = null
                                videoId = null
                                offlineVideoId = null
                                prefs().edit { putString(AppConstants.LAST_PLAYBACK_ENGINE, "media3") }
                                stopIdleTimer()
                                // A new item gets its own full retry budget.
                                if (backgroundPrepareRetryCount > 0) backgroundPrepareRetryCount = 0
                                val networkLibrary = prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
                                val dataSourceFactory = DefaultDataSource.Factory(
                                    this@PlaybackService,
                                    when {
                                        networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                            HttpEngineDataSource.Factory(httpEngine!!.get(), cronetExecutor, null, null) { false }
                                        }
                                        networkLibrary == "Cronet" && cronetEngine != null -> {
                                            CronetDataSource.Factory(cronetEngine!!.get(), cronetExecutor, null, null) { false }
                                        }
                                        else -> {
                                            OkHttpDataSource.Factory(okHttpClient, null) { false }
                                        }
                                    }
                                )
                                val mediaItem = MediaItem.Builder().apply {
                                    setMediaId(uri.orEmpty())
                                    setUri(uri?.toUri())
                                    setMediaMetadata(
                                        MediaMetadata.Builder().apply {
                                            setTitle(title)
                                            setArtist(channelName)
                                            setArtworkUri(channelLogo?.toUri())
                                        }.build()
                                    )
                                }.build()
                                player.trackSelectionParameters = player.trackSelectionParameters.buildUpon().apply {
                                    setTrackTypeDisabled(androidx.media3.common.C.TRACK_TYPE_VIDEO, false)
                                    clearOverridesOfType(androidx.media3.common.C.TRACK_TYPE_VIDEO)
                                }.build()
                                val mediaSource = if (uri?.contains(".m3u8", ignoreCase = true) == true) {
                                    HlsMediaSource.Factory(dataSourceFactory).apply {
                                        setPlaylistParserFactory(CustomHlsPlaylistParserFactory())
                                    }.createMediaSource(mediaItem)
                                } else {
                                    ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
                                }
                                player.setMediaSource(mediaSource)
                                session.player.volume = prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(prefs().getFloat(AppConstants.PLAYER_SPEED, 1f))
                                session.player.prepare()
                                session.player.playWhenReady = true
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
                            }
                            START_OFFLINE_VIDEO -> {
                                val uri = customCommand.customExtras.getString(URI)
                                val title = customCommand.customExtras.getString(TITLE)
                                val channelName = customCommand.customExtras.getString(CHANNEL_NAME)
                                val channelLogo = customCommand.customExtras.getString(CHANNEL_LOGO)
                                stopKickViewerWatch()
                                activeKickChannelId = null
                                activeKickLivestreamId = null
                                activeKickChannelLogin = null
                                val newId = customCommand.customExtras.getInt(VIDEO_ID).takeIf { it != 0 }
                                val position = if (offlineVideoId == newId && session.player.currentMediaItem != null) {
                                    session.player.currentPosition
                                } else {
                                    customCommand.customExtras.getLong(PLAYBACK_POSITION)
                                }
                                prefs().edit { putString(AppConstants.LAST_PLAYBACK_ENGINE, "media3") }
                                stopIdleTimer()
                                videoId = null
                                offlineVideoId = newId
                                // A new item gets its own full retry budget.
                                if (backgroundPrepareRetryCount > 0) backgroundPrepareRetryCount = 0
                                session.player.setMediaItem(
                                    MediaItem.Builder().apply {
                                        setMediaId(uri.orEmpty())
                                        setUri(uri?.toUri())
                                        setMediaMetadata(
                                            MediaMetadata.Builder().apply {
                                                setTitle(title)
                                                setArtist(channelName)
                                                setArtworkUri(channelLogo?.toUri())
                                            }.build()
                                        )
                                    }.build()
                                )
                                session.player.volume = prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(prefs().getFloat(AppConstants.PLAYER_SPEED, 1f))
                                session.player.prepare()
                                session.player.playWhenReady = true
                                session.player.seekTo(position)
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
                            }
                            TOGGLE_DYNAMICS_PROCESSING -> {
                                if (dynamicsProcessing?.enabled == true) {
                                    dynamicsProcessing?.enabled = false
                                } else {
                                    if (dynamicsProcessing == null) {
                                        reinitializeDynamicsProcessing(player.audioSessionId)
                                    } else {
                                        dynamicsProcessing?.enabled = true
                                    }
                                }
                                val enabled = dynamicsProcessing?.enabled
                                prefs().edit { putBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR, enabled == true) }
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                    RESULT to enabled
                                )))
                            }
                            SET_SLEEP_TIMER -> {
                                val duration = customCommand.customExtras.getLong(DURATION)
                                background = duration != -1L
                                val endTime = sleepTimerEndTime
                                sleepTimer?.cancel()
                                sleepTimerEndTime = 0L
                                if (duration > 0L) {
                                    sleepTimer = Timer().apply {
                                        schedule(duration) {
                                            Handler(Looper.getMainLooper()).post {
                                                savePosition()
                                                mediaSession?.player?.clearMediaItems()
                                                pauseAllPlayersAndStopSelf()
                                            }
                                        }
                                    }
                                    sleepTimerEndTime = System.currentTimeMillis() + duration
                                }
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                    RESULT to endTime
                                )))
                            }
                            GET_QUALITIES -> {
                                val playlist = (session.player.currentManifest as? HlsManifest)?.multivariantPlaylist
                                if (BuildConfig.DEBUG) {
                                    Log.d(
                                        "KickVodQuality",
                                        "service manifest variants=${playlist?.variants?.size ?: 0} " +
                                            "labels=${playlist?.variants?.map { it.format.label }} " +
                                            "videoGroups=${playlist?.videos?.map { "${it.groupId}:${it.name}" }} " +
                                            "urls=${playlist?.variants?.map { it.url.toString() }}"
                                    )
                                }
                                val names = playlist?.variants
                                    ?.map { it.format.label }
                                    ?.takeIf { labels -> labels.size == playlist.variants.size && labels.all { !it.isNullOrBlank() } }
                                    ?.map { it!! }
                                    ?.toTypedArray()
                                if (!names.isNullOrEmpty()) {
                                    if (BuildConfig.DEBUG) {
                                        Log.d("KickVodQuality", "service usingLabels=${names.toList()}")
                                    }
                                    Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                        NAMES to names,
                                        CODECS to playlist.variants.map { it.format.codecs }.toTypedArray(),
                                        BITRATES to playlist.variants.map { it.format.bitrate }.toIntArray(),
                                        URLS to playlist.variants.map { it.url.toString() }.toTypedArray(),
                                    )))
                                } else {
                                    val variants = playlist?.variants?.mapNotNull { variant ->
                                        val name = playlist.videos.find { it.groupId == variant.videoGroupId }?.name
                                            ?: variant.url.toString()
                                                .substringBeforeLast("/")
                                                .substringAfterLast("/")
                                                .takeIf { it.isNotBlank() && it != "hls" }
                                        name?.let { variant to it }
                                    }
                                    if (BuildConfig.DEBUG) {
                                        Log.d("KickVodQuality", "service usingFallback=${variants?.map { it.second }}")
                                    }
                                    Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                        NAMES to variants?.map { it.second }?.toTypedArray(),
                                        CODECS to variants?.map { it.first.format.codecs }?.toTypedArray(),
                                        BITRATES to variants?.map { it.first.format.bitrate }?.toIntArray(),
                                        URLS to variants?.map { it.first.url.toString() }?.toTypedArray(),
                                    )))
                                }
                            }
                            GET_DURATION -> {
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                    RESULT to (session.player.currentManifest as? HlsManifest)?.mediaPlaylist?.durationUs?.div(1000)
                                )))
                            }
                            GET_ERROR_CODE -> {
                                // HLS wraps chunk failures two or three levels deep, so only
                                // inspecting the direct cause returned null here — the caller
                                // read 0 and blind-restarted with the same expired URL instead
                                // of refreshing it on 403 or reporting stream-end on 404. The
                                // chain walker below was already present, used only for logging.
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                    RESULT to session.player.playerError?.let { httpResponseCode(it) },
                                )))
                            }
                            GET_MEDIA_PLAYLIST -> {
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                    RESULT to (session.player.currentManifest as? HlsManifest)?.mediaPlaylist?.tags?.toTypedArray()
                                )))
                            }
                            GET_MULTIVARIANT_PLAYLIST -> {
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS, bundleOf(
                                    RESULT to (session.player.currentManifest as? HlsManifest)?.multivariantPlaylist?.tags?.toTypedArray()
                                )))
                            }
                            else -> super.onCustomCommand(session, controller, customCommand, args)
                        }
                    }
                }
            )
        }.build()
    }

    private fun reinitializeDynamicsProcessing(audioSessionId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
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
        }
    }

    private fun savePosition() {
        mediaSession?.player?.let { player ->
            if (!player.currentTracks.isEmpty && prefs().getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                val position = player.currentPosition
                val vid = videoId
                val offId = offlineVideoId
                kickViewerWatchScope.launch {
                    if (vid != null) {
                        playerRepository.saveVideoPosition(VideoPosition(vid, position))
                    } else if (offId != null) {
                        offlineRepository.updateVideoPosition(offId, position)
                    }
                }
            }
        }
    }

    private fun updateSavedPosition() {
        mediaSession?.player?.let { player ->
            if (!player.currentTracks.isEmpty && prefs().getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                val currentPosition = player.currentPosition
                val savedPosition = lastSavedPosition
                if (savedPosition == null || currentPosition - savedPosition !in 0..2000) {
                    lastSavedPosition = currentPosition
                    val vid = videoId
                    val offId = offlineVideoId
                    kickViewerWatchScope.launch {
                        if (vid != null) {
                            playerRepository.saveVideoPosition(VideoPosition(vid, currentPosition))
                        } else if (offId != null) {
                            offlineRepository.updateVideoPosition(offId, currentPosition)
                        }
                    }
                }
            }
        }
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? = mediaSession

    override fun onTaskRemoved(rootIntent: Intent?) {
        savePosition()
        mediaSession?.player?.clearMediaItems()
        pauseAllPlayersAndStopSelf()
    }

    override fun onDestroy() {
        kickViewerWatchJob?.cancel()
        kickViewerWatchJob = null
        kickViewerWatch = null
        kickViewerWatchScope.cancel()
        sleepTimer?.cancel()
        sleepTimer = null
        savePositionTimer?.cancel()
        savePositionTimer = null
        idleStopTimer?.cancel()
        idleStopTimer = null
        dynamicsProcessing?.release()
        dynamicsProcessing = null
        mediaSession?.run {
            player.release()
            release()
            mediaSession = null
        }
        super.onDestroy()
    }

    private fun logPlayerError(error: PlaybackException) {
        val responseCode = httpResponseCode(error)
        val message = "playerError code=${error.errorCode} name=${error.errorCodeName} " +
            "http=$responseCode background=$background " +
            "message=${error.message}"
        if (responseCode == 403 || responseCode == 404 || isBehindLiveWindowError(error)) {
            DiagnosticLogger.w(TAG, message)
        } else {
            DiagnosticLogger.e(TAG, message, error)
        }
    }

    private fun httpResponseCode(error: Throwable): Int? {
        var cause: Throwable? = error
        while (cause != null) {
            if (cause is HttpDataSource.InvalidResponseCodeException) {
                return cause.responseCode
            }
            cause = cause.cause
        }
        return null
    }

    private fun summarizePlaybackUri(uri: String?): String {
        if (uri.isNullOrBlank()) {
            return "uri=missing"
        }
        return runCatching {
            val parsed = uri.toUri()
            val query = parsed.query
            "uriHost=${parsed.host ?: "unknown"} uriPath=${parsed.path ?: "unknown"} " +
                "queryPresent=${!query.isNullOrBlank()} queryHash=${query.shortHash()} uriHash=${uri.shortHash()}"
        }.getOrDefault("uri=unparseable uriHash=${uri.shortHash()}")
    }

    private fun String?.shortHash(): String {
        return if (isNullOrBlank()) {
            "none"
        } else {
            Integer.toHexString(hashCode())
        }
    }

    private fun isBehindLiveWindowError(error: PlaybackException): Boolean {
        var cause: Throwable? = error
        while (cause != null) {
            if (cause is BehindLiveWindowException) {
                return true
            }
            cause = cause.cause
        }
        return false
    }

    class CustomHlsPlaylistParserFactory(): HlsPlaylistParserFactory {
        override fun createPlaylistParser(): ParsingLoadable.Parser<HlsPlaylist> {
            return HlsPlaylistParser()
        }

        override fun createPlaylistParser(multivariantPlaylist: HlsMultivariantPlaylist, previousMediaPlaylist: HlsMediaPlaylist?): ParsingLoadable.Parser<HlsPlaylist> {
            return HlsPlaylistParser(multivariantPlaylist, previousMediaPlaylist)
        }
    }

    companion object {
        private const val TAG = "PlaybackService"
        const val START_STREAM = "startStream"
        const val START_VIDEO = "startVideo"
        const val START_CLIP = "startClip"
        const val START_OFFLINE_VIDEO = "startOfflineVideo"
        const val TOGGLE_DYNAMICS_PROCESSING = "toggleDynamicsProcessing"
        const val SET_SLEEP_TIMER = "setSleepTimer"
        const val GET_QUALITIES = "getQualities"
        const val GET_DURATION = "getDuration"
        const val GET_ERROR_CODE = "getErrorCode"
        const val GET_MEDIA_PLAYLIST = "getMediaPlaylist"
        const val GET_MULTIVARIANT_PLAYLIST = "getMultivariantPlaylist"

        const val RESULT = "result"
        const val URI = "uri"
        const val VIDEO_ID = "videoId"
        const val PLAYBACK_POSITION = "playbackPosition"
        const val TITLE = "title"
        const val CHANNEL_NAME = "channelName"
        const val CHANNEL_LOGO = "channelLogo"
        const val CHANNEL_ID = "channelId"
        const val CHANNEL_LOGIN = "channelLogin"
        const val LIVESTREAM_ID = "livestreamId"
        const val IS_KICK_STREAM = "isKickStream"
        const val DURATION = "duration"
        const val NAMES = "names"
        const val CODECS = "codecs"
        const val BITRATES = "bitrates"
        const val URLS = "urls"

        const val REQUEST_CODE_RESUME = 2

        /** Max background error→prepare() recovery attempts before giving up. */
        private const val BACKGROUND_PREPARE_MAX_RETRIES = 5

        private fun playbackStateName(playbackState: Int): String {
            return when (playbackState) {
                Player.STATE_IDLE -> "IDLE"
                Player.STATE_BUFFERING -> "BUFFERING"
                Player.STATE_READY -> "READY"
                Player.STATE_ENDED -> "ENDED"
                else -> playbackState.toString()
            }
        }
    }
}
