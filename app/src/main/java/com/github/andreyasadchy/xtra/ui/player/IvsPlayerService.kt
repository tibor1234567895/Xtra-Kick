package com.github.andreyasadchy.xtra.ui.player

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.graphics.Bitmap
import android.graphics.drawable.Icon
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
import android.util.Log
import androidx.annotation.OptIn
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.media3.common.util.BitmapLoader
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSourceBitmapLoader
import androidx.media3.session.CacheBitmapLoader
import androidx.media3.session.DefaultMediaNotificationProvider
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.PlayerException
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures

@OptIn(UnstableApi::class)
class IvsPlayerService : Service() {

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
    private var retryCount = 0
    private var surfaceAttached = false
    private var wakeLock: PowerManager.WakeLock? = null
    private var wifiLock: WifiManager.WifiLock? = null
    private var dynamicsProcessing: DynamicsProcessing? = null
    private var dynamicsProcessingAudioSessionId: Int? = null

    override fun onCreate() {
        super.onCreate()
        wakeLock = (getSystemService(Context.POWER_SERVICE) as PowerManager).newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "IvsPlayerService:WakeLock"
        ).apply {
            setReferenceCounted(false)
            acquire()
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
            acquire()
        }
        val ivsPlayer = Player.Factory.create(this).apply {
            setLogLevel(Player.LogLevel.ERROR)
            setLiveLowLatencyEnabled(true)
            setRebufferToLive(true)
            setVolume(prefs().getInt(C.PLAYER_VOLUME, 100) / 100f)
        }
        player = ivsPlayer
        ivsPlayer.addListener(
            object : Player.Listener() {
                override fun onCue(cue: com.amazonaws.ivs.player.Cue) = Unit

                override fun onStateChanged(state: Player.State) {
                    if (state == Player.State.PLAYING) {
                        hasStablePlayback = true
                    }
                    if (state == Player.State.READY || state == Player.State.PLAYING) {
                        syncDynamicsProcessingWithPreference()
                    }
                    Log.d(
                        TAG,
                        "state=$state backgroundPlaybackEnabled=$backgroundPlaybackEnabled " +
                            "surfaceAttached=$surfaceAttached urlPresent=${!currentUrl.isNullOrBlank()}"
                    )
                    updatePlaybackState()
                    updateMetadata()
                    updateNotification()
                }

                override fun onDurationChanged(duration: Long) {
                    updateMetadata()
                    updateNotification()
                }

                override fun onRebuffering() = Unit

                override fun onError(exception: PlayerException) {
                    Log.w(
                        TAG,
                        "error code=${exception.code} type=${exception.errorType} source=${exception.source} " +
                            "backgroundPlaybackEnabled=$backgroundPlaybackEnabled message=${exception.errorMessage}"
                    )
                    updatePlaybackState(error = true)
                    updateNotification()
                    val retryUrl = currentUrl
                    if (!retryUrl.isNullOrBlank() && retryCount < 1 && !hasStablePlayback) {
                        retryCount += 1
                        ivsPlayer.load(Uri.parse(retryUrl))
                        ivsPlayer.play()
                    }
                }

                override fun onSeekCompleted(position: Long) = Unit

                override fun onVideoSizeChanged(width: Int, height: Int) = Unit

                override fun onQualityChanged(quality: com.amazonaws.ivs.player.Quality) = Unit
            }
        )
        session = MediaSession(this, TAG).apply {
            setCallback(
                object : MediaSession.Callback() {
                    override fun onPlay() {
                        player?.play()
                        updatePlaybackState()
                        updateNotification()
                    }

                    override fun onPause() {
                        player?.pause()
                        updatePlaybackState()
                        updateNotification()
                    }

                    override fun onStop() {
                        player?.pause()
                        updatePlaybackState()
                        updateNotification()
                        stopSelf()
                    }

                    override fun onSeekTo(pos: Long) {
                        player?.seekTo(pos)
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
        Log.d(TAG, "service created")
    }

    fun playStream(url: String, title: String?, channelName: String?, channelLogo: String?) {
        this.currentUrl = url
        this.title = title
        this.channelName = channelName
        this.channelLogo = channelLogo
        hasStablePlayback = false
        retryCount = 0
        releaseDynamicsProcessing()
        Log.d(TAG, "playStream channel=$channelName title=$title")
        player?.apply {
            setLiveLowLatencyEnabled(true)
            setRebufferToLive(true)
            setVolume(prefs().getInt(C.PLAYER_VOLUME, 100) / 100f)
            load(Uri.parse(url))
            play()
        }
        updateMetadata()
        updateNotification()
    }

    fun attachSurface(surface: android.view.Surface?) {
        surfaceAttached = surface != null
        player?.setSurface(surface)
        Log.d(TAG, "attachSurface attached=$surfaceAttached")
    }

    fun setBackgroundPlaybackEnabled(enabled: Boolean) {
        backgroundPlaybackEnabled = enabled
        Log.d(TAG, "setBackgroundPlaybackEnabled enabled=$enabled")
        updateNotification()
    }

    fun isBackgroundPlaybackEnabled(): Boolean = backgroundPlaybackEnabled

    fun toggleDynamicsProcessing(): Boolean {
        val enabled = !prefs().getBoolean(C.PLAYER_AUDIO_COMPRESSOR, false)
        prefs().edit { putBoolean(C.PLAYER_AUDIO_COMPRESSOR, enabled) }
        syncDynamicsProcessingWithPreference()
        return enabled
    }

    fun stopPlayback() {
        backgroundPlaybackEnabled = false
        surfaceAttached = false
        player?.setSurface(null)
        player?.pause()
        updatePlaybackState()
        updateNotification()
        stopSelf()
    }

    private fun updatePlaybackState(error: Boolean = false) {
        player?.let { player ->
            val live = !error && player.duration <= 0L
            val state = when (player.state) {
                Player.State.IDLE -> PlaybackState.STATE_NONE
                Player.State.BUFFERING -> PlaybackState.STATE_BUFFERING
                Player.State.READY -> PlaybackState.STATE_PAUSED
                Player.State.PLAYING -> PlaybackState.STATE_PLAYING
                Player.State.ENDED -> PlaybackState.STATE_STOPPED
            }
            session?.setPlaybackState(
                PlaybackState.Builder().apply {
                    setState(
                        state,
                        if (live) -1L else player.position,
                        if (player.state == Player.State.PLAYING) player.playbackRate else 0f
                    )
                    setActions(
                        PlaybackState.ACTION_STOP or
                            PlaybackState.ACTION_PLAY or
                            PlaybackState.ACTION_PAUSE or
                            PlaybackState.ACTION_PLAY_PAUSE or
                            (if (!live) PlaybackState.ACTION_SEEK_TO else 0L)
                    )
                }.build()
            )
        }
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
            session?.setMetadata(
                MediaMetadata.Builder().apply {
                    putText(MediaMetadata.METADATA_KEY_TITLE, title)
                    putText(MediaMetadata.METADATA_KEY_ARTIST, channelName)
                    if (bitmap != null) {
                        putBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON, bitmap)
                        putBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART, bitmap)
                    }
                    putLong(MediaMetadata.METADATA_KEY_DURATION, if (player.duration > 0L) player.duration else -1L)
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
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
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
        when (intent?.action) {
            INTENT_PLAY_PAUSE -> {
                val ivsPlayer = player
                if (ivsPlayer?.state == Player.State.PLAYING) {
                    ivsPlayer.pause()
                } else {
                    ivsPlayer?.play()
                }
                updatePlaybackState()
                updateNotification()
            }
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder = ServiceBinder()

    override fun onUnbind(intent: Intent?): Boolean {
        if (!backgroundPlaybackEnabled && player?.state != Player.State.PLAYING) {
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
        if (!prefs().getBoolean(C.PLAYER_AUDIO_COMPRESSOR, false)) {
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
        metadataBitmapCallback = null
        notificationBitmapCallback = null
        applicationHandler?.removeCallbacksAndMessages(null)
        notificationManager?.cancel(NOTIFICATION_ID)
        session?.release()
        releaseDynamicsProcessing()
        player?.release()
        player = null
        wakeLock?.takeIf { it.isHeld }?.release()
        wakeLock = null
        wifiLock?.takeIf { it.isHeld }?.release()
        wifiLock = null
        super.onDestroy()
    }

    companion object {
        private const val TAG = "IvsPlayerService"
        private const val NOTIFICATION_ID = DefaultMediaNotificationProvider.DEFAULT_NOTIFICATION_ID
        private const val REQUEST_CODE_RESUME = 0
        private const val REQUEST_CODE_PLAY_PAUSE = 1
        private const val INTENT_PLAY_PAUSE = "com.github.andreyasadchy.xtra.IVS_PLAY_PAUSE"
    }
}
