package com.github.andreyasadchy.xtra.ui.player

import android.app.PendingIntent
import android.content.Intent
import android.media.audiofx.DynamicsProcessing
import android.net.http.HttpEngine
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ext.SdkExtensions
import android.util.Log
import androidx.annotation.OptIn
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.media3.common.AudioAttributes
import androidx.media3.common.ForwardingSimpleBasePlayer
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.MimeTypes
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.TrackSelectionParameters
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
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.model.VideoPosition
import com.github.andreyasadchy.xtra.player.lowlatency.CronetDataSource
import com.github.andreyasadchy.xtra.player.lowlatency.HlsPlaylistParser
import com.github.andreyasadchy.xtra.player.lowlatency.HttpEngineDataSource
import com.github.andreyasadchy.xtra.player.lowlatency.OkHttpDataSource
import com.github.andreyasadchy.xtra.repository.OfflineRepository
import com.github.andreyasadchy.xtra.repository.PlayerRepository
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.DiagnosticLogger
import com.github.andreyasadchy.xtra.util.prefs
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
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

    private var mediaSession: MediaSession? = null
    private var dynamicsProcessing: DynamicsProcessing? = null
    private var background = false
    private var videoId: Long? = null
    private var offlineVideoId: Int? = null
    private var backgroundHandoffMode = false
    private lateinit var activeLatencyConfig: LiveLatencyConfig
    private var sleepTimer: Timer? = null
    private var sleepTimerEndTime = 0L
    private var lastSavedPosition: Long? = null
    private var savePositionTimer: Timer? = null

    private fun isBufferDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && prefs().getBoolean(C.DEBUG_PLAYER_BUFFER_LOGS, false)
    }

    private fun logBufferDebug(message: String) {
        if (isBufferDebugEnabled()) {
            Log.d(TAG, message)
        }
    }

    override fun onCreate() {
        super.onCreate()
        backgroundHandoffMode = prefs().getBoolean(KEY_BACKGROUND_HANDOFF_PENDING, false)
        prefs().edit { remove(KEY_BACKGROUND_HANDOFF_PENDING) }
        activeLatencyConfig = if (backgroundHandoffMode) {
            LiveLatencySettings.preset(LiveLatencySettings.PROFILE_STABLE)
        } else {
            LiveLatencySettings.resolve(prefs())
        }
        val player = ExoPlayer.Builder(this).apply {
            setLoadControl(LiveLatencySettings.toLoadControl(activeLatencyConfig))
            setAudioAttributes(AudioAttributes.DEFAULT, prefs().getBoolean(C.PLAYER_AUDIO_FOCUS, false))
            setHandleAudioBecomingNoisy(prefs().getBoolean(C.PLAYER_HANDLE_AUDIO_BECOMING_NOISY, true))
            setSeekBackIncrementMs(prefs().getString(C.PLAYER_REWIND, "10000")?.toLongOrNull() ?: 10000)
            setSeekForwardIncrementMs(prefs().getString(C.PLAYER_FORWARD, "10000")?.toLongOrNull() ?: 10000)
        }.build()
        logBufferDebug(
            "PlaybackService created with latency=${LiveLatencySettings.describe(activeLatencyConfig)} " +
                "backgroundHandoffMode=$backgroundHandoffMode"
        )
        player.addListener(
            object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    logBufferDebug(
                        "playbackState=${playbackStateName(playbackState)} " +
                            "playWhenReady=${player.playWhenReady} isPlaying=${player.isPlaying} " +
                            "background=$background backgroundHandoffMode=$backgroundHandoffMode " +
                            "mediaItemPresent=${player.currentMediaItem != null}"
                    )
                }

                override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
                    logBufferDebug(
                        "playWhenReadyChanged playWhenReady=$playWhenReady reason=$reason " +
                            "background=$background backgroundHandoffMode=$backgroundHandoffMode"
                    )
                }

                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    logBufferDebug(
                        "isPlayingChanged isPlaying=$isPlaying " +
                            "background=$background backgroundHandoffMode=$backgroundHandoffMode " +
                            "currentPosition=${player.currentPosition}"
                    )
                    if (isPlaying) {
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
                        savePositionTimer?.cancel()
                        savePositionTimer = null
                        updateSavedPosition()
                    }
                }

                override fun onPlayerError(error: PlaybackException) {
                    logPlayerError(error)
                    if (background) {
                        if (isBehindLiveWindowError(error)) {
                            DiagnosticLogger.w(
                                TAG,
                                "behindLiveWindow recovery start background=$background backgroundHandoffMode=$backgroundHandoffMode " +
                                    "state=${playbackStateName(player.playbackState)} playWhenReady=${player.playWhenReady} " +
                                    "isPlaying=${player.isPlaying} mediaItemPresent=${player.currentMediaItem != null}"
                            )
                            player.seekToDefaultPosition()
                            player.playWhenReady = true
                            player.prepare()
                            Handler(Looper.getMainLooper()).postDelayed({
                                DiagnosticLogger.w(
                                    TAG,
                                    "behindLiveWindow recovery followup background=$background backgroundHandoffMode=$backgroundHandoffMode " +
                                        "state=${playbackStateName(player.playbackState)} playWhenReady=${player.playWhenReady} " +
                                        "isPlaying=${player.isPlaying} error=${player.playerError?.errorCodeName}"
                                )
                            }, 5000L)
                            return
                        }
                        DiagnosticLogger.w(
                            TAG,
                            "background playerError recovery via prepare code=${error.errorCodeName} " +
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
                    if (prefs().getBoolean(C.PLAYER_AUDIO_COMPRESSOR, false)) {
                        reinitializeDynamicsProcessing(audioSessionId)
                    }
                }
            }
        )
        mediaSession = MediaSession.Builder(
            this,
            object : ForwardingSimpleBasePlayer(player) {
                override fun getState(): State {
                    val state = super.getState()
                    return state
                        .buildUpon()
                        .setAvailableCommands(
                            state.availableCommands.buildUpon()
                                .add(COMMAND_SEEK_TO_NEXT)
                                .add(COMMAND_SEEK_IN_CURRENT_MEDIA_ITEM)
                                .build()
                        )
                        .build()
                }

                override fun handleSeek(mediaItemIndex: Int, positionMs: Long, seekCommand: Int): ListenableFuture<*> {
                    return when (seekCommand) {
                        COMMAND_SEEK_TO_NEXT, COMMAND_SEEK_TO_NEXT_MEDIA_ITEM -> {
                            player.seekForward()
                            Futures.immediateVoidFuture()
                        }
                        COMMAND_SEEK_TO_PREVIOUS, COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM -> {
                            player.seekBack()
                            Futures.immediateVoidFuture()
                        }
                        else -> super.handleSeek(mediaItemIndex, positionMs, seekCommand)
                    }
                }
            }
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
                        return MediaSession.ConnectionResult.accept(sessionCommands, connectionResult.availablePlayerCommands)
                    }

                    override fun onCustomCommand(session: MediaSession, controller: MediaSession.ControllerInfo, customCommand: SessionCommand, args: Bundle): ListenableFuture<SessionResult> {
                        return when (customCommand.customAction) {
                            START_STREAM -> {
                                val uri = customCommand.customExtras.getString(URI)
                                val title = customCommand.customExtras.getString(TITLE)
                                val channelName = customCommand.customExtras.getString(CHANNEL_NAME)
                                val channelLogo = customCommand.customExtras.getString(CHANNEL_LOGO)
                                val disableVideo = customCommand.customExtras.getBoolean(DISABLE_VIDEO)
                                logBufferDebug(
                                    "START_STREAM received channel=$channelName disableVideo=$disableVideo " +
                                        "backgroundHandoffMode=$backgroundHandoffMode uriPresent=${!uri.isNullOrBlank()}"
                                )
                                DiagnosticLogger.i(
                                    TAG,
                                    "START_STREAM service received channel=$channelName disableVideo=$disableVideo " +
                                        "background=$background backgroundHandoffMode=$backgroundHandoffMode " +
                                        "${summarizePlaybackUri(uri)}"
                                )
                                videoId = null
                                offlineVideoId = null
                                val proxyHost = prefs().getString(C.PROXY_HOST, null)
                                val proxyPort = prefs().getString(C.PROXY_PORT, null)?.toIntOrNull()
                                val proxyUser = prefs().getString(C.PROXY_USER, null)
                                val proxyPassword = prefs().getString(C.PROXY_PASSWORD, null)
                                val proxyMultivariantPlaylist = prefs().getBoolean(C.PROXY_MULTIVARIANT_PLAYLIST, false)
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
                                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
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
                                                prefs().getString(C.PLAYER_STREAM_HEADERS, null)?.let {
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
                                            setUri(uri?.toUri())
                                            setMimeType(MimeTypes.APPLICATION_M3U8)
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
                                session.player.trackSelectionParameters = session.player.trackSelectionParameters
                                    .buildUpon()
                                    .setTrackTypeDisabled(androidx.media3.common.C.TRACK_TYPE_VIDEO, disableVideo)
                                    .build()
                                session.player.volume = prefs().getInt(C.PLAYER_VOLUME, 100) / 100f
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
                                val newId = customCommand.customExtras.getLong(VIDEO_ID).takeIf { it != 0L }
                                val position = if (videoId == newId && session.player.currentMediaItem != null) {
                                    session.player.currentPosition
                                } else {
                                    customCommand.customExtras.getLong(PLAYBACK_POSITION)
                                }
                                videoId = newId
                                offlineVideoId = null
                                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
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
                                session.player.volume = prefs().getInt(C.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(prefs().getFloat(C.PLAYER_SPEED, 1f))
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
                                videoId = null
                                offlineVideoId = null
                                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
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
                                    setUri(uri?.toUri())
                                    if (uri?.contains(".m3u8", ignoreCase = true) == true) {
                                        setMimeType(MimeTypes.APPLICATION_M3U8)
                                    }
                                    setMediaMetadata(
                                        MediaMetadata.Builder().apply {
                                            setTitle(title)
                                            setArtist(channelName)
                                            setArtworkUri(channelLogo?.toUri())
                                        }.build()
                                    )
                                }.build()
                                val mediaSource = if (uri?.contains(".m3u8", ignoreCase = true) == true) {
                                    HlsMediaSource.Factory(dataSourceFactory).apply {
                                        setPlaylistParserFactory(CustomHlsPlaylistParserFactory())
                                    }.createMediaSource(mediaItem)
                                } else {
                                    ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
                                }
                                player.setMediaSource(mediaSource)
                                session.player.volume = prefs().getInt(C.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(prefs().getFloat(C.PLAYER_SPEED, 1f))
                                session.player.prepare()
                                session.player.playWhenReady = true
                                Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
                            }
                            START_OFFLINE_VIDEO -> {
                                val uri = customCommand.customExtras.getString(URI)
                                val title = customCommand.customExtras.getString(TITLE)
                                val channelName = customCommand.customExtras.getString(CHANNEL_NAME)
                                val channelLogo = customCommand.customExtras.getString(CHANNEL_LOGO)
                                val newId = customCommand.customExtras.getInt(VIDEO_ID).takeIf { it != 0 }
                                val position = if (offlineVideoId == newId && session.player.currentMediaItem != null) {
                                    session.player.currentPosition
                                } else {
                                    customCommand.customExtras.getLong(PLAYBACK_POSITION)
                                }
                                videoId = null
                                offlineVideoId = newId
                                session.player.setMediaItem(
                                    MediaItem.Builder().apply {
                                        setUri(uri)
                                        setMediaMetadata(
                                            MediaMetadata.Builder().apply {
                                                setTitle(title)
                                                setArtist(channelName)
                                                setArtworkUri(channelLogo?.toUri())
                                            }.build()
                                        )
                                    }.build()
                                )
                                session.player.volume = prefs().getInt(C.PLAYER_VOLUME, 100) / 100f
                                session.player.setPlaybackSpeed(prefs().getFloat(C.PLAYER_SPEED, 1f))
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
                                prefs().edit { putBoolean(C.PLAYER_AUDIO_COMPRESSOR, enabled == true) }
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
            if (!player.currentTracks.isEmpty && prefs().getBoolean(C.PLAYER_USE_VIDEOPOSITIONS, true)) {
                videoId?.let {
                    runBlocking {
                        playerRepository.saveVideoPosition(VideoPosition(it, player.currentPosition))
                    }
                } ?:
                offlineVideoId?.let {
                    runBlocking {
                        offlineRepository.updateVideoPosition(it, player.currentPosition)
                    }
                }
            }
        }
    }

    private fun updateSavedPosition() {
        mediaSession?.player?.let { player ->
            if (!player.currentTracks.isEmpty && prefs().getBoolean(C.PLAYER_USE_VIDEOPOSITIONS, true)) {
                val currentPosition = player.currentPosition
                val savedPosition = lastSavedPosition
                if (savedPosition == null || currentPosition - savedPosition !in 0..2000) {
                    lastSavedPosition = currentPosition
                    videoId?.let {
                        runBlocking {
                            playerRepository.saveVideoPosition(VideoPosition(it, currentPosition))
                        }
                    } ?:
                    offlineVideoId?.let {
                        runBlocking {
                            offlineRepository.updateVideoPosition(it, currentPosition)
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
        sleepTimer?.cancel()
        sleepTimer = null
        savePositionTimer?.cancel()
        savePositionTimer = null
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
            "http=$responseCode background=$background backgroundHandoffMode=$backgroundHandoffMode " +
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
        const val DISABLE_VIDEO = "disableVideo"
        const val KEY_BACKGROUND_HANDOFF_PENDING = "playbackService.backgroundHandoffPending"
        const val DURATION = "duration"
        const val NAMES = "names"
        const val CODECS = "codecs"
        const val URLS = "urls"

        const val REQUEST_CODE_RESUME = 2

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
