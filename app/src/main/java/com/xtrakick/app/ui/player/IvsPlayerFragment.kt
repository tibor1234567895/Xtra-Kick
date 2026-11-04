package com.xtrakick.app.ui.player

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.SystemClock
import android.text.format.DateUtils
import android.util.Log
import android.view.SurfaceHolder
import android.view.View
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.core.content.edit
import androidx.core.view.isVisible
import androidx.media3.common.util.UnstableApi
import com.amazonaws.ivs.player.Cue
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.PlayerException
import com.amazonaws.ivs.player.Quality
import com.amazonaws.ivs.player.TextCue
import com.amazonaws.ivs.player.TextTrack
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.VideoStatsInfo
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.getAlertDialogBuilder
import java.util.Locale
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.NetworkMonitor

@OptIn(UnstableApi::class)
class IvsPlayerFragment : PlayerFragment() {

    private var playbackService: IvsPlayerService? = null
    private var serviceConnection: ServiceConnection? = null
    private val player: Player?
        get() = playbackService?.player
    private var displayedCaption: String? = null
    private val captionTimeline = IvsCaptionTimeline()
    private val updateCaptionsAction = object : Runnable {
        override fun run() {
            val binding = bindingOrNull ?: return
            val text = captionTimeline.textAt(player?.position ?: 0L)
            if (text != displayedCaption) {
                displayedCaption = text
                binding.subtitleView.setCues(text?.let {
                    listOf(androidx.media3.common.text.Cue.Builder().setText(it).build())
                } ?: emptyList())
            }
            if (!captionTimeline.isEmpty) binding.subtitleView.postDelayed(this, 100L)
        }
    }
    private var playerListener: Player.Listener? = null
    private var surfaceHolderCallback: SurfaceHolder.Callback? = null
    private var surfaceCreated = false
    private val updateProgressAction = Runnable { if (view != null) updateProgress() }
    private val qualitiesByKey = linkedMapOf<String, Quality>()
    private var maxLadderQuality: Quality? = null
    private var currentUrl: String? = null
    private var recoveryInProgress = false
    private var sameUrlRetryAttempted = false
    private var resumeOnStart = false
    private var backgroundAudioTransitionRequested = false
    private var backgroundSaverApplied = false
    private var isCatchingUp = false
    private var pendingAutomaticQualityLog: String? = null
    private var pendingAutomaticQualityTransport: NetworkMonitor.NetworkType? = null
    private var lastBufferRecoveryTimeMs = 0L
    private val rebufferBreaker = RebufferCircuitBreaker()
    private var networkLossGraceRunnable: Runnable? = null
    private var networkPauseApplied = false
    private var lastBandwidthKbps: Long? = null
    private var pendingQualityNudge: Quality? = null
    private var qualityNudgeSafetyRunnable: Runnable? = null
    private var downscaleRecoveryTicks = 0
    private var lastQualityNudgeTimeMs = 0L
    private var qualityAppliedForCurrentStream = false
    private var pendingSeekPosition: Long? = null

    private fun isQualityLockEnabled(): Boolean {
        return prefs.getBoolean(AppConstants.PLAYER_LOCK_QUALITY, false)
    }

    private fun playerDebugLog(message: String) {
        if (BuildConfig.DEBUG && prefs.getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)) {
            Log.d(TAG, message)
        }
    }

    private fun playerDebugWarn(message: String) {
        if (BuildConfig.DEBUG && prefs.getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)) {
            Log.w(TAG, message)
        }
    }

    /**
     * Serializes player mutations onto the service executor (direct call when unbound),
     * so fragment touches can't race the service's load/play on another thread.
     */
    private fun runIvsOp(opName: String, block: (Player) -> Unit) {
        val service = playbackService
        if (service != null) {
            service.runPlayerOp(opName, block)
        } else {
            try {
                player?.let(block)
            } catch (e: Exception) {
                playerDebugWarn("player op $opName failed: ${e.message}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            resumeOnStart = savedInstanceState.getBoolean(KEY_RESUME_ON_START, false)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_RESUME_ON_START, resumeOnStart)
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.restoreQuality) {
            viewModel.restoreQuality = false
            val targetQuality = viewModel.previousQuality ?: viewModel.qualities.keys.firstOrNull { it != AUDIO_ONLY_QUALITY }
            changeQuality(targetQuality)
        }
        if (player != null && viewModel.quality != null && viewModel.quality != AUTO_QUALITY && !backgroundSaverApplied) {
            val lockQuality = isQualityLockEnabled()
            if (lockQuality && player?.isAutoQualityMode == true) {
                changeQuality(viewModel.quality)
            } else if (!lockQuality && player?.isAutoQualityMode == false) {
                applyQualityCeiling("quality-unlock", qualitiesByKey[viewModel.quality])
            }
        }
        if (surfaceCreated && viewModel.quality != AUDIO_ONLY_QUALITY) {
            attachSurfaceIfAvailable()
        }
        if (resumeOnStart && player?.state != Player.State.PLAYING) {
            playbackService?.let { resumePlaybackOrReload(it, "onResume") }
        }
        if (serviceConnection != null) {
            startIvsService(Intent(requireContext(), IvsPlayerService::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        val callback = object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                surfaceCreated = true
                val service = playbackService
                if (viewModel.quality != AUDIO_ONLY_QUALITY) {
                    service?.attachSurface(holder.surface)
                }
                if (resumeOnStart && player?.state != Player.State.PLAYING) {
                    service?.let { resumePlaybackOrReload(it, "surfaceCreated") }
                }
                clearFreezeFrame()
                updatePlayingState()
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                surfaceCreated = false
                playbackService?.attachSurface(null)
            }
        }
        binding.playerSurface.holder.addCallback(callback)
        surfaceHolderCallback = callback
        if (binding.playerSurface.holder.surface?.isValid == true) {
            surfaceCreated = true
        }
        val connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                if (view == null) {
                    return
                }
                val binder = service as IvsPlayerService.ServiceBinder
                val boundService = binder.getService()
                playbackService = boundService
                boundService.setKickViewerMetadata(
                    channelId = requireArguments().getString(KEY_CHANNEL_ID)
                        .takeIf { requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) },
                    livestreamId = requireArguments().getString(KEY_STREAM_ID)
                        .takeIf { requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) },
                    channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)
                        .takeIf { requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) },
                )
                // Prefer this fragment's own URL/args over the reused service's URL:
                // after stopPlayback() clears it, a fresh fragment falls through to
                // its own resolve instead of briefly resuming the previous stream.
                currentUrl = currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL) ?: boundService.currentUrl
                boundService.setBackgroundPlaybackEnabled(false)
                if (surfaceCreated && viewModel.quality != AUDIO_ONLY_QUALITY) {
                    boundService.attachSurface(binding.playerSurface.holder.surface)
                }
                if (viewModel.quality == AUDIO_ONLY_QUALITY) {
                    binding.playerSurface.visibility = View.GONE
                    applyAudioSaverCeiling()
                } else {
                    binding.playerSurface.visibility = View.VISIBLE
                }
                restoreForegroundCeiling()
                val listener = object : Player.Listener() {
                    override fun onTextTracksChanged(tracks: List<TextTrack>) {
                        if (bindingOrNull == null) return
                        toggleSubtitles(prefs.getBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, false))
                    }

                    override fun onTextTrackChanged(track: TextTrack?) {
                        clearCaptions()
                        setSubtitlesButton()
                    }

                    override fun onCue(cue: Cue) {
                        if (cue !is TextCue || !prefs.getBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, false)) return
                        val selected = player?.textTrack ?: return
                        if (cue.trackId != null && cue.trackId != selected.id) return
                        val subtitleView = bindingOrNull?.subtitleView ?: return
                        captionTimeline.add(cue.text, cue.startTime, cue.endTime, player?.position ?: 0L)
                        subtitleView.removeCallbacks(updateCaptionsAction)
                        updateCaptionsAction.run()
                    }

                    override fun onDurationChanged(duration: Long) {
                        binding.playerControls.progressBar.setDuration(duration.coerceAtLeast(0L))
                        if (duration > 0L) {
                            binding.playerControls.duration.text = DateUtils.formatElapsedTime(duration / 1000)
                            pendingSeekPosition?.let { pos ->
                                pendingSeekPosition = null
                                seek(pos.coerceIn(0L, duration))
                            }
                        }
                        updateProgress()
                    }

                    override fun onStateChanged(state: Player.State) {
                        if (state == Player.State.READY) toggleSubtitles(prefs.getBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, false))
                        if (state == Player.State.IDLE || state == Player.State.ENDED) clearCaptions()
                        setSubtitlesButton()
                        binding.bufferingIndicator.isVisible = state == Player.State.BUFFERING
                        if (state == Player.State.READY || state == Player.State.PLAYING) {
                            pendingSeekPosition?.let { pos ->
                                val dur = player?.duration ?: 0L
                                if (dur > 0L) {
                                    pendingSeekPosition = null
                                    seek(pos.coerceIn(0L, dur))
                                } else if (state == Player.State.PLAYING) {
                                    pendingSeekPosition = null
                                    seek(pos)
                                }
                            }
                        }
                        if (state != Player.State.PLAYING) {
                            resetCatchupState()
                        }
                        if (state == Player.State.BUFFERING) {
                            downscaleRecoveryTicks = 0
                            val bufferingPlayer = player
                            if (bufferingPlayer != null) {
                                playerDebugLog(
                                    "fragment buffering liveLatency=${bufferingPlayer.liveLatency} " +
                                        "buffered=${bufferingPlayer.bufferedPosition} " +
                                        "position=${bufferingPlayer.position}"
                                )
                            }
                            // A lone stall is normal; a cluster after playback started means
                            // the session is stuck (stale URL, wedged estimator) —
                            // reload with a fresh URL.
                            if (!recoveryInProgress &&
                                lastBufferRecoveryTimeMs > 0L &&
                                rebufferBreaker.record(SystemClock.uptimeMillis())
                            ) {
                                playerDebugLog("repeated rebuffering, reloading with fresh URL")
                                reloadIvsLiveStreamWithFreshUrl("repeated rebuffering")
                            }
                        } else if (state == Player.State.PLAYING) {
                            clearFreezeFrame()
                            lastBufferRecoveryTimeMs = SystemClock.uptimeMillis()
                        } else if ((state == Player.State.READY || state == Player.State.ENDED) &&
                            playbackService?.isPlaybackRequested() == false &&
                            lastPausedTimestampMs == 0L
                        ) {
                            noteStreamPaused()
                            captureFreezeFrame()
                        }
                        if (state == Player.State.READY || state == Player.State.PLAYING) {
                            if (!viewModel.loaded.value) {
                                viewModel.loaded.value = true
                            }
                            populateQualities()
                        }
                        updatePlayingState()
                    }

                    override fun onError(exception: PlayerException) {
                        playerDebugWarn(
                            "IVS playback error code=${exception.code} type=${exception.errorType} source=${exception.source} session=${player?.sessionId}: ${exception.errorMessage}"
                        )
                        if (isStreamOfflineError(exception)) {
                            handleIvsStreamOffline()
                        } else {
                            retryIvsPlayback(showMessage = true)
                        }
                    }

                    override fun onRebuffering() {
                        binding.bufferingIndicator.isVisible = true
                        resetCatchupState()
                        downscaleRecoveryTicks = 0
                        cancelQualityNudge()
                    }

                    override fun onSeekCompleted(position: Long) {
                        updateProgress()
                    }

                    override fun onVideoSizeChanged(width: Int, height: Int) = Unit

                    override fun onQualityChanged(quality: Quality) {
                        playerDebugLog("IVS onQualityChanged -> ${quality.name} (${quality.width}x${quality.height}, ${quality.bitrate} bps) saverApplied=$backgroundSaverApplied")
                        val nudgeTarget = pendingQualityNudge
                        if (nudgeTarget != null && (quality == nudgeTarget || quality.name == nudgeTarget.name)) {
                            cancelQualityNudge()
                            playerDebugLog("IVS quality transition fulfilled: reached ${quality.name}, re-arming auto ceiling")
                            runIvsOp("quality-nudge-rearm") {
                                it.setAutoQualityMode(true)
                                val autoMax = if (viewModel.quality == AUTO_QUALITY) null else nudgeTarget
                                it.setAutoMaxQuality(autoMax)
                            }
                        }
                        if (automaticQualityChangeInProgress) {
                            val key = qualitiesByKey.entries.find { it.value == quality }?.key
                            if (key != null) {
                                viewModel.quality = key
                                if (pendingAutomaticQualityLog == key) {
                                    val transport = pendingAutomaticQualityTransport
                                    pendingAutomaticQualityLog = null
                                    pendingAutomaticQualityTransport = null
                                    logAutomaticQualityChange(key, transport)
                                } else if (pendingAutomaticQualityLog != null) {
                                    pendingAutomaticQualityLog = null
                                    pendingAutomaticQualityTransport = null
                                }
                            }
                        }
                        setQualityText()
                    }
                }
                player?.addListener(listener)
                toggleSubtitles(prefs.getBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, false))
                playerListener = listener
                if (resumeOnStart && player?.state != Player.State.PLAYING) {
                    resumePlaybackOrReload(boundService, "onServiceConnected")
                } else if (player?.state == Player.State.PLAYING) {
                    clearFreezeFrame()
                }
                if (!recoveryInProgress) {
                    recoverEmptyIvsServiceIfNeeded()
                }
                if (player?.state == Player.State.READY || player?.state == Player.State.PLAYING || player?.state == Player.State.BUFFERING) {
                    if (!viewModel.loaded.value) {
                        viewModel.loaded.value = true
                    }
                    populateQualities()
                }
                updatePlayingState()
                if ((isInitialized || !enableNetworkCheck) && !viewModel.started) {
                    startPlayer()
                }
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                playbackService = null
            }
        }
        serviceConnection = connection
        val intent = Intent(requireContext(), IvsPlayerService::class.java)
        startIvsService(intent)
        requireContext().bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private fun startIvsService(intent: Intent): Boolean {
        return try {
            requireContext().startService(intent)
            true
        } catch (e: Exception) {
            if (!isBackgroundServiceStartDenied(e)) {
                DiagnosticLogger.w(TAG, "Failed to start IvsPlayerService", e)
                return false
            }
            DiagnosticLogger.w(
                TAG,
                "IVS service start denied (proceeding with bindService) " +
                    "foreground=${lifecycle.currentState} urlPresent=${!requireArguments().getString(KEY_RESOLVED_STREAM_URL).isNullOrBlank()}",
                e
            )
            false
        }
    }

    private fun isBackgroundServiceStartDenied(error: Throwable): Boolean {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            error.javaClass.name == "android.app.BackgroundServiceStartNotAllowedException") ||
            (error is IllegalStateException && error.message?.contains("Not allowed to start service", ignoreCase = true) == true)
    }

    override fun initialize() {
        if (player != null && !viewModel.started) {
            startPlayer()
        }
        super.initialize()
    }

    private fun updatePlayingState() {
        val state = player?.state ?: Player.State.IDLE
        val isPlaying = state == Player.State.PLAYING
        binding.bufferingIndicator.isVisible = state == Player.State.BUFFERING
        with(binding.playerControls) {
            if (isPlaying) {
                playPause.setImageResource(R.drawable.baseline_pause_black_48)
                if (videoType == STREAM && !prefs.getBoolean(AppConstants.PLAYER_PAUSE, false)) {
                    playPause.visibility = View.GONE
                } else {
                    playPause.visibility = View.VISIBLE
                }
            } else {
                playPause.setImageResource(R.drawable.baseline_play_arrow_black_48)
                playPause.visibility = View.VISIBLE
            }
            val duration = player?.duration?.takeIf { it > 0 } ?: 0L
            progressBar.setDuration(duration)
        }
        setPipActions(isPlaying)
        controllerAutoHide = isPlaying
        if (!prefs.getBoolean(AppConstants.PLAYER_KEEP_SCREEN_ON_WHEN_PAUSED, false) && canEnterPictureInPicture()) {
            view?.keepScreenOn = isPlaying
        }
        updateProgress()
        if (isPlaying) {
            sameUrlRetryAttempted = false
            rescheduleHideController()
        }
        if (videoType != STREAM && useController) {
            showController()
        }
    }

    private fun populateQualities() {
        val ivsPlayer = player ?: return
        val availableQualities = ivsPlayer.qualities
            .sortedWith(compareByDescending<Quality> { it.height }.thenByDescending { it.framerate }.thenByDescending { it.bitrate })
        qualitiesByKey.clear()
        maxLadderQuality = availableQualities.firstOrNull()
        val map = linkedMapOf<String, Pair<String, String?>>()
        map[AUTO_QUALITY] = getString(R.string.auto) to null
        availableQualities.forEach { quality ->
            val baseKey = KickLivePlayback.qualityKey(quality)
            // disambiguate variants sharing a name with the bitrate, e.g. "720p 2.5 Mbps"
            val key = if (qualitiesByKey.containsKey(baseKey)) {
                val bitrateSuffix = KickLivePlayback.bitrateLabel(quality)
                val suffixed = if (bitrateSuffix != null) "$baseKey $bitrateSuffix" else baseKey
                generateSequence(suffixed) { "$it+" }.first { !qualitiesByKey.containsKey(it) }
            } else {
                baseKey
            }
            qualitiesByKey[key] = quality
            map[key] = KickLivePlayback.qualityLabel(quality) to null
            if (quality.bitrate > 0) {
                KickLivePlayback.recordBitrate(key, quality.bitrate)
                if (key != baseKey) KickLivePlayback.recordBitrate(baseKey, quality.bitrate)
            }
        }
        map[AUDIO_ONLY_QUALITY] = getString(R.string.audio_only) to null
        if (map != viewModel.qualities) {
            val previousQuality = viewModel.quality
            viewModel.qualities = map
            // Preserve an explicit manual selection across ladder refreshes
            // (e.g. post-rebuffer repopulate). Only fall back to default when
            // the current key vanished; otherwise re-applying the same quality
            // would flicker renditions after every stall.
            if (previousQuality == null || !map.containsKey(previousQuality)) {
                setDefaultQuality()
            } else {
                viewModel.quality = previousQuality
            }
            changePlayerMode()
            val shouldApply = !qualityAppliedForCurrentStream ||
                viewModel.quality != previousQuality ||
                !qualitiesByKey.containsKey(previousQuality) ||
                (viewModel.quality != AUTO_QUALITY && ivsPlayer.isAutoQualityMode) ||
                (isQualityLockEnabled() && viewModel.quality != AUTO_QUALITY)
            if (shouldApply) {
                qualityAppliedForCurrentStream = true
                changeQuality(viewModel.quality)
            } else {
                setQualityText()
            }
        } else if (!qualityAppliedForCurrentStream && viewModel.quality != null) {
            qualityAppliedForCurrentStream = true
            changeQuality(viewModel.quality)
        }
    }

    override fun startStream(url: String?) {
        clearCaptions()
        val resolvedUrl = url?.takeIf { it.isNotBlank() } ?: return
        hideOfflineOverlay()
        recoveryInProgress = false
        qualityAppliedForCurrentStream = false
        backgroundSaverApplied = false
        cancelQualityNudge()
        lastQualityNudgeTimeMs = 0L
        if (currentUrl != resolvedUrl) {
            sameUrlRetryAttempted = false
        }
        currentUrl = resolvedUrl
        requireArguments().putString(KEY_RESOLVED_STREAM_URL, resolvedUrl)
        rebufferBreaker.reset()
        lastBandwidthKbps = null
        lastBufferRecoveryTimeMs = 0L
        viewModel.playlistUrl = null
        viewModel.loaded.value = false
        binding.playerSurface.visibility = View.VISIBLE
        binding.playerControls.progressBar.setDuration(0L)
        binding.playerControls.duration.text = null
        binding.playerControls.position.text = null
        attachSurfaceIfAvailable()
        val preferredQuality = resolvePreferredQualityForCurrentNetwork()
        val initialBitrate = KickLivePlayback.resolveInitialBitrate(preferredQuality)
        playbackService?.playStream(
            url = resolvedUrl,
            title = requireArguments().getString(KEY_TITLE),
            channelName = requireArguments().getString(KEY_CHANNEL_NAME),
            channelLogo = requireArguments().getString(KEY_CHANNEL_LOGO),
            streamStartedAtMs = requireArguments().getString(KEY_STARTED_AT)?.let { KickApiHelper.parseIso8601DateUTC(it) },
            channelId = requireArguments().getString(KEY_CHANNEL_ID)
                .takeIf { requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) },
            livestreamId = requireArguments().getString(KEY_STREAM_ID)
                .takeIf { requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) },
            channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)
                .takeIf { requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) },
            initialBitrate = initialBitrate,
        )
        updatePlayingState()
    }

    override fun updateChannelLogo(logo: String?) {
        val clean = logo?.takeIf { it.isNotBlank() } ?: return
        playbackService?.updateChannelLogo(clean)
    }

    override fun updateStreamStartedAt(startedAt: String) {
        KickApiHelper.parseIso8601DateUTC(startedAt)?.let { playbackService?.updateStreamStartedAt(it) }
    }

    override fun getCurrentPosition(): Long? = player?.position

    override fun pausePlaybackForOverlay() {
        player?.pause()
    }

    override fun resumePlaybackAfterOverlay() {
        player?.play()
    }

    override fun getCurrentSpeed(): Float? = player?.playbackRate
    override fun isPlaybackPlaying() = player?.state == Player.State.PLAYING

    override fun getCurrentVolume(): Float? = player?.volume

    override fun playPause() {
        when (player?.state) {
            Player.State.PLAYING -> {
                noteStreamPaused()
                captureFreezeFrame()
                playbackService?.pause(clearPlaybackRequest = true)
            }
            Player.State.READY,
            Player.State.ENDED -> {
                if (!isPausedLiveStreamStale() || !reloadIvsLiveStreamWithFreshUrl("stale pause resume")) {
                    playbackService?.play()
                }
            }
            Player.State.IDLE -> {
                if (!reloadIvsLiveStreamWithFreshUrl("idle play")) {
                    currentUrl?.let { startStream(it) } ?: playbackService?.play()
                }
            }
            else -> {
                val url = currentUrl ?: resolveStreamUrl()
                if (!url.isNullOrBlank()) {
                    if (!reloadIvsLiveStreamWithFreshUrl("unresponsive play")) {
                        startStream(url)
                    }
                }
            }
        }
        updatePlayingState()
    }

    override fun seek(position: Long) {
        clearCaptions()
        runIvsOp("fragment-seek") { it.seekTo(position) }
        activeChatFragment()?.seekTo(position)
    }

    override fun getDuration(): Long? = player?.duration?.takeIf { it > 0L }

    override fun switchLiveToVod(vodUrl: String, targetPositionMs: Long, startedAtStr: String?) {
        if (viewModel.isLiveRewound) {
            seek(targetPositionMs)
            return
        }
        if (currentUrl != null) {
            viewModel.liveStreamUrl = currentUrl
        }
        viewModel.isLiveRewound = true
        player?.setRebufferToLive(false)
        pendingSeekPosition = targetPositionMs
        startStream(vodUrl)
        updateLiveRewindUi(isRewound = true)
        val effectiveStart = startedAtStr ?: requireArguments().getString(KEY_STARTED_AT) ?: viewModel.stream.value?.startedAt
        activeChatFragment()?.startLiveRewind(effectiveStart, targetPositionMs)
    }

    override fun returnLiveEdge() {
        val liveUrl = viewModel.liveStreamUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL)
        viewModel.isLiveRewound = false
        pendingSeekPosition = null
        player?.setRebufferToLive(true)
        if (!liveUrl.isNullOrBlank()) {
            startStream(liveUrl)
        } else {
            reloadKickStreamWithFreshResolvedUrl(reason = "return-to-live")
        }
        updateLiveRewindUi(isRewound = false)
        activeChatFragment()?.returnToLiveChat()
    }

    override fun seekToLivePosition() {
        clearCaptions()
        if (viewModel.isLiveRewound) {
            returnLiveEdge()
            context?.let {
                Toast.makeText(it, R.string.syncing_to_live, Toast.LENGTH_SHORT).show()
            }
            return
        }
        val ivsPlayer = player ?: return
        // A fresh load starts a couple segments back, so reloading near-live lands
        // FURTHER from the edge (e.g. 1.7s -> 2.4s). Skip unless genuinely behind.
        val latency = ivsPlayer.liveLatency.takeIf { it > 0L }
        val target = LiveLatencySettings.resolve(prefs).targetOffsetMs
        if (ivsPlayer.duration <= 0L && latency != null && latency <= target + GO_LIVE_SKIP_THRESHOLD_MS) {
            context?.let {
                Toast.makeText(it, R.string.ivs_already_live, Toast.LENGTH_SHORT).show()
            }
            return
        }
        // Only an explicit tap jumps to live; auto paths always resume in place.
        ivsPlayer.setRebufferToLive(true)
        resetCatchupState()
        val duration = ivsPlayer.duration
        if (duration > 0L) {
            ivsPlayer.seekTo(duration)
        } else {
            currentUrl?.let { ivsPlayer.load(Uri.parse(it)) }
            playbackService?.play()
        }
        context?.let {
            Toast.makeText(it, R.string.syncing_to_live, Toast.LENGTH_SHORT).show()
        }
    }

    override fun setPlaybackSpeed(speed: Float) {
        runIvsOp("fragment-set-rate") { it.setPlaybackRate(speed) }
    }

    override fun changeVolume(volume: Float) {
        runIvsOp("fragment-set-volume") { it.setVolume(volume) }
        prefs.edit { putInt(AppConstants.PLAYER_VOLUME, (volume * 100f).toInt()) }
        super.changeVolume(volume)
    }

    override fun updateProgress() {
        with(binding.playerControls) {
            val latency = if (viewModel.isLiveRewound) null else player?.liveLatency?.takeIf { it > 0L }
            val catchupEnabled = prefs.getBoolean(AppConstants.PLAYER_IVS_LATENCY_CATCHUP, true)
            val latencyConfig = LiveLatencySettings.resolve(prefs)
            val targetOffsetMs = latencyConfig.targetOffsetMs
            updateLatency(latency, targetOffsetMs)

            val ivsPlayer = player
            if (ivsPlayer != null && ivsPlayer.state == Player.State.PLAYING) {
                if (binding.bufferingIndicator.isVisible) {
                    binding.bufferingIndicator.isVisible = false
                }
                val currentPosition = ivsPlayer.position
                val bufferedPosition = ivsPlayer.bufferedPosition
                val forwardBufferMs = (bufferedPosition - currentPosition).coerceAtLeast(0L)
                val now = SystemClock.uptimeMillis()

                val targetQuality = getTargetQuality()
                val isDownscaled = isDownscaled(ivsPlayer.quality, targetQuality)

                // Option A: Auto-recovery watchdog when downscaled in adaptive mode
                if (ivsPlayer.isAutoQualityMode &&
                    isDownscaled &&
                    targetQuality != null &&
                    !backgroundSaverApplied &&
                    !isQualityLockEnabled()
                ) {
                    val minRecoveryBufferMs = KickLivePlayback.minRecoveryBufferMs(latencyConfig.rebufferMs)
                    val isBufferHealthy = forwardBufferMs >= minRecoveryBufferMs
                    val hasSufficientBandwidth = KickLivePlayback.hasSufficientBandwidth(
                        bandwidthEstimateBps = ivsPlayer.bandwidthEstimate,
                        targetBitrateBps = targetQuality.bitrate
                    )

                    if (isBufferHealthy && hasSufficientBandwidth) {
                        downscaleRecoveryTicks++
                        val cooldownElapsed = (now - lastQualityNudgeTimeMs) >= QUALITY_RECOVERY_COOLDOWN_MS
                        if (downscaleRecoveryTicks >= DOWNSCALE_RECOVERY_REQUIRED_TICKS &&
                            cooldownElapsed &&
                            pendingQualityNudge == null
                        ) {
                            downscaleRecoveryTicks = 0
                            lastQualityNudgeTimeMs = now
                            playerDebugLog(
                                "IVS auto-recovery: buffer=${forwardBufferMs}ms (min ${minRecoveryBufferMs}ms), " +
                                    "bw=${ivsPlayer.bandwidthEstimate / 1000}kbps -> nudging up to ${targetQuality.name}"
                            )
                            nudgeQualityToTarget(targetQuality)
                        }
                    } else {
                        downscaleRecoveryTicks = 0
                    }
                } else {
                    downscaleRecoveryTicks = 0
                }

                if (catchupEnabled && latency != null) {
                    val isInGracePeriod = (now - lastBufferRecoveryTimeMs) < LiveLatencySettings.REBUFFER_GRACE_PERIOD_MS
                    // Only the lowest-latency profile may exceed 1.08x (max 1.12x).
                    val profile = prefs.getString(AppConstants.PLAYER_LATENCY_PROFILE, LiveLatencySettings.DEFAULT_PROFILE)
                    val maxSpeed = LiveLatencySettings.maxIvsCatchupSpeed(profile, latencyConfig.maxPlaybackSpeed)

                    val desiredSpeed = LiveLatencySettings.calculateIvsCatchupSpeed(
                        latencyMs = latency,
                        targetOffsetMs = targetOffsetMs,
                        forwardBufferMs = forwardBufferMs,
                        isInGracePeriod = isInGracePeriod,
                        maxSpeedLimit = maxSpeed,
                        isCurrentlyCatchingUp = isCatchingUp,
                        minSpeedLimit = latencyConfig.minPlaybackSpeed
                    )

                    // Coordinate catch-up with resolution recovery:
                    // Avoid depleting thin buffers while downscaled from a manual target quality.
                    // However, if forward buffer is comfortably deep (at least 2x rebuffer threshold, min 3000ms),
                    // or if playing on Auto, catch-up can safely run.
                    val shouldHoldCatchupForResolution = viewModel.quality != AUTO_QUALITY &&
                        isDownscaled &&
                        !KickLivePlayback.isBufferSafeForDownscaledCatchup(forwardBufferMs, latencyConfig.rebufferMs)
                    val speedToApply = if (shouldHoldCatchupForResolution) {
                        null
                    } else {
                        desiredSpeed
                    }

                    if (speedToApply != null) {
                        if (ivsPlayer.playbackRate != speedToApply) {
                            playerDebugLog("IVS catch-up: latency=${latency}ms buf=${forwardBufferMs}ms -> setting speed to ${speedToApply}x")
                            runIvsOp("fragment-catchup-rate") { it.setPlaybackRate(speedToApply) }
                            isCatchingUp = true
                        }
                    } else {
                        if (isCatchingUp) {
                            playerDebugLog("IVS catch-up: latency=${latency}ms buf=${forwardBufferMs}ms target (~${targetOffsetMs}ms), restoring speed to 1.0x")
                        }
                        resetCatchupState()
                    }
                } else {
                    resetCatchupState()
                }
            } else {
                downscaleRecoveryTicks = 0
                resetCatchupState()
            }

            val currentPosition = ivsPlayer?.position ?: 0L
            if (viewModel.isLiveRewound && currentPosition > 0L) {
                activeChatFragment()?.updatePosition(currentPosition)
            }

            if (root.isVisible && !progressBar.isPressed) {
                val dur = ivsPlayer?.duration ?: 0L
                progressBar.setPosition(currentPosition)
                progressBar.setBufferedPosition(ivsPlayer?.bufferedPosition ?: 0L)
                if (dur > 0L) {
                    progressBar.setDuration(dur)
                    duration.text = DateUtils.formatElapsedTime(dur / 1000)
                }
                position.text = if (currentPosition > 0L) {
                    DateUtils.formatElapsedTime(currentPosition / 1000)
                } else {
                    null
                }
            }
            root.removeCallbacks(updateProgressAction)
            if (ivsPlayer?.state == Player.State.PLAYING || ivsPlayer?.state == Player.State.BUFFERING) {
                root.postDelayed(updateProgressAction, 500L)
            }
        }
    }

    override fun getVideoStats(): VideoStatsInfo? {
        val ivsPlayer = player ?: return null
        if (view == null) return null
        val q = ivsPlayer.quality
        val stats = ivsPlayer.statistics

        val downloadRes = if (q.width > 0 && q.height > 0) "${q.width}×${q.height}" else null
        val renderRes = downloadRes
        val viewportRes = if (binding.playerSurface.width > 0 && binding.playerSurface.height > 0) {
            "${binding.playerSurface.width}×${binding.playerSurface.height}"
        } else null

        val bitrateBps = stats.videoBitRate.takeIf { it > 0 } ?: q.bitrate.takeIf { it > 0 }
        val downloadBitrate = bitrateBps?.let { "${it / 1000} Kbps" }

        val bw = ivsPlayer.bandwidthEstimate.takeIf { it > 0 }
        val bandwidthEstimate = bw?.let {
            // SDK reports bits/sec. The raw estimate measures burst capacity
            // and swings wildly (1M-192M seen on one link), so smooth it into
            // a usable trend gauge instead of displaying every spike raw.
            val bwKbps = it / 1000
            val smoothed = lastBandwidthKbps?.let { last ->
                (last * SMOOTHED_BANDWIDTH_OLD_WEIGHT + bwKbps * (1f - SMOOTHED_BANDWIDTH_OLD_WEIGHT)).toLong()
            } ?: bwKbps
            lastBandwidthKbps = smoothed
            "$smoothed Kbps"
        }

        val liveFps = stats.frameRate.takeIf { it > 0 }
        val targetFps = q.framerate.takeIf { it > 0 }
        val fpsBase = when {
            liveFps != null && targetFps != null -> "${targetFps.toInt()} (live: $liveFps)"
            targetFps != null -> "${targetFps.toInt()}"
            liveFps != null -> "$liveFps"
            else -> null
        }
        // Surface catch-up so latency paydown is visible in stats, not mystery.
        val fpsStr = if (isCatchingUp && fpsBase != null) {
            val rate = ivsPlayer.playbackRate
            "$fpsBase @${String.format(Locale.US, "%.2f", rate)}x"
        } else {
            fpsBase
        }

        val dropped = stats.droppedFrames
        val decoded = stats.decodedFrames
        val skippedStr = if (decoded > 0) "$dropped / $decoded" else "$dropped"

        val pos = ivsPlayer.position
        val buf = ivsPlayer.bufferedPosition
        val bufferMs = (buf - pos).coerceAtLeast(0L)
        val bufferStr = String.format(Locale.US, "%.2f sec.", bufferMs / 1000.0)

        val latMs = ivsPlayer.liveLatency.takeIf { it > 0 }
        val latStr = latMs?.let { String.format(Locale.US, "%.2f sec.", it / 1000.0) }

        val codecs = q.codecs.takeIf { it.isNotBlank() }
        val backendVersion = "Amazon IVS ${ivsPlayer.version}"

        return VideoStatsInfo(
            resolution = downloadRes,
            viewportResolution = viewportRes,
            downloadBitrate = downloadBitrate,
            bandwidthEstimate = bandwidthEstimate,
            fps = fpsStr,
            skippedFrames = skippedStr,
            bufferSize = bufferStr,
            latencyToBroadcaster = latStr,
            codecs = codecs,
            protocol = "HLS",
            backendVersion = backendVersion
        )
    }

    override fun changeQuality(selectedQuality: String?) {
        if (selectedQuality == AUDIO_ONLY_QUALITY) {
            startAudioOnly()
            viewModel.restoreQuality = false
            return
        }
        val wasAudioOnly = viewModel.quality == AUDIO_ONLY_QUALITY
        if (!wasAudioOnly) {
            viewModel.previousQuality = viewModel.quality
        } else {
            // Explicit choice sticks across lock/unlock and background returns.
            viewModel.restoreQuality = false
        }
        viewModel.quality = selectedQuality
        if (wasAudioOnly) {
            exitAudioOnlyMode()
        }
        if (player == null) return
        // A manual pick acts as a ceiling over adaptive mode (like the official
        // app): the player may dip below on trouble and climbs back on its own
        // instead of stalling on a locked rendition.
        when (selectedQuality) {
            AUTO_QUALITY -> {
                cancelQualityNudge()
                applyQualityCeiling("quality-auto", null)
            }
            else -> qualitiesByKey[selectedQuality]?.let { targetQuality ->
                if (isQualityLockEnabled()) {
                    applyQualityCeiling("quality-lock", targetQuality)
                } else {
                    val activeQuality = player?.quality
                    val isDifferent = activeQuality == null || activeQuality.name != targetQuality.name

                    if (isDifferent && !wasAudioOnly && player?.state == Player.State.PLAYING) {
                        // Smooth adaptive transition: switches at buffer boundary without flushing,
                        // immediately sets ceiling, and re-arms ABR when target is reached.
                        nudgeQualityToTarget(targetQuality)
                    } else {
                        applyQualityCeiling("quality-ceiling", targetQuality)
                    }
                }
            }
        }
        persistSelectedQuality(selectedQuality)
        setQualityText()
    }

    private fun getTargetQuality(): Quality? {
        return if (viewModel.quality == AUTO_QUALITY) maxLadderQuality else qualitiesByKey[viewModel.quality]
    }

    private fun isDownscaled(activeQuality: Quality, targetQuality: Quality?): Boolean {
        return targetQuality != null && activeQuality.bitrate in 1 until targetQuality.bitrate
    }

    override fun resolveQualityDisplayText(): String? {
        val configuredText = viewModel.qualities[viewModel.quality]?.first ?: return null
        val ivsPlayer = player ?: return configuredText
        if (!ivsPlayer.isAutoQualityMode) return configuredText

        val activeKey = KickLivePlayback.qualityKey(ivsPlayer.quality)
        val isDownscaled = isDownscaled(ivsPlayer.quality, getTargetQuality())

        return when {
            viewModel.quality == AUTO_QUALITY && activeKey.isNotBlank() -> "$configuredText ($activeKey)"
            isDownscaled -> "$configuredText (Playing: $activeKey)"
            else -> configuredText
        }
    }

    override fun resolveQualityDialogItems(): List<String> {
        val baseItems = viewModel.qualities.values.map { it.first }
        val ivsPlayer = player ?: return baseItems
        if (!ivsPlayer.isAutoQualityMode || viewModel.quality == AUTO_QUALITY) return baseItems

        val selectedIndex = viewModel.qualities.keys.indexOf(viewModel.quality)
        if (selectedIndex < 0) return baseItems

        val activeQuality = ivsPlayer.quality
        if (!isDownscaled(activeQuality, getTargetQuality())) return baseItems

        val activeKey = KickLivePlayback.qualityKey(activeQuality)
        return baseItems.mapIndexed { index, itemText ->
            if (index == selectedIndex) "$itemText (Currently: $activeKey)" else itemText
        }
    }

    override fun onNetworkTypeChanged(type: NetworkMonitor.NetworkType) {
        val previous = previousNetworkType
        previousNetworkType = type
        if (previous == null || previous == type || videoType != STREAM) return
        if (type == NetworkMonitor.NetworkType.OTHER || type == NetworkMonitor.NetworkType.NONE || type == NetworkMonitor.NetworkType.UNKNOWN) return
        if (previous == NetworkMonitor.NetworkType.OTHER || previous == NetworkMonitor.NetworkType.NONE || previous == NetworkMonitor.NetworkType.UNKNOWN) return
        val isCellular = type == NetworkMonitor.NetworkType.CELLULAR
        val preferredQuality = resolvePreferredQuality(isCellular) ?: return
        val activeQuality = player?.quality
        val targetQuality = getTargetQuality()
        val isDownscaled = activeQuality != null && targetQuality != null && isDownscaled(activeQuality, targetQuality)
        if (preferredQuality != viewModel.quality || (!isCellular && isDownscaled)) {
            pendingAutomaticQualityLog = preferredQuality
            pendingAutomaticQualityTransport = type
            runAutomaticQualityChange {
                changeQuality(preferredQuality)
            }
        }
    }

    private fun persistSelectedQuality(selectedQuality: String?) {
        if (automaticQualityChangeInProgress) {
            return
        }
        val defaultQualityPref = if (networkMonitor.isCellular) AppConstants.PLAYER_DEFAULT_CELLULAR_QUALITY else AppConstants.PLAYER_DEFAULTQUALITY
        if (prefs.getString(defaultQualityPref, "saved") == "saved") {
            prefs.edit { putString(AppConstants.PLAYER_QUALITY, selectedQuality) }
        }
    }

    override fun startAudioOnly() {
        super.startAudioOnly()
        if (viewModel.quality != AUDIO_ONLY_QUALITY) {
            backgroundAudioTransitionRequested = true
            viewModel.restoreQuality = true
            viewModel.previousQuality = viewModel.quality
            viewModel.quality = AUDIO_ONLY_QUALITY
            playbackService?.attachSurface(null)
            binding.playerSurface.visibility = View.GONE
        }
        applyAudioSaverCeiling()
        changePlayerMode()
        setQualityText()
    }

    /**
     * Applies quality ceiling or hard-locks quality if player_lock_quality is enabled.
     * Audio-saver ceiling always stays in ABR to conserve bandwidth in the background.
     */
    private fun applyQualityCeiling(opName: String, target: Quality?) {
        cancelQualityNudge()
        val shouldLock = isQualityLockEnabled() &&
            target != null &&
            viewModel.quality != AUTO_QUALITY &&
            !backgroundSaverApplied &&
            opName != "audio-saver-ceiling" &&
            opName != "foreground-ceiling-restore"

        if (shouldLock) {
            playerDebugLog("IVS quality hard-lock ($opName): setting ${target.name} (${target.bitrate} bps)")
            runIvsOp(opName) {
                it.setAutoQualityMode(false)
                it.setQuality(target)
            }
        } else {
            runIvsOp(opName) {
                if (!it.isAutoQualityMode) {
                    it.setAutoQualityMode(true)
                }
                it.setAutoMaxQuality(target)
            }
        }
    }

    /** Caps IVS ABR at the 480p saver rung: same source, so no reload or rebuffer. */
    private fun applyAudioSaverCeiling(deferred: Boolean = false): Boolean {
        val saver = KickLivePlayback.selectAudioSaverKey(
            qualitiesByKey.map { (key, quality) ->
                KickLivePlayback.AudioSaverCandidate(key, quality.height, quality.bitrate)
            }
        )?.let { qualitiesByKey[it] } ?: return false
        playerDebugLog("applyAudioSaverCeiling target saver=${saver.name} (${saver.bitrate} bps) deferred=$deferred")
        val service = playbackService
        if (service != null) {
            if (deferred) {
                service.scheduleBackgroundAudioSaver(saver)
            } else {
                service.runPlayerOp("audio-saver-ceiling") {
                    if (!it.isAutoQualityMode) {
                        it.setAutoQualityMode(true)
                    }
                    it.setAutoMaxQuality(saver)
                }
            }
        }
        return true
    }

    /** Restores the user's ceiling after a background saver stint, climbing smoothly. */
    private fun restoreForegroundCeiling() {
        backgroundSaverApplied = false
        val service = playbackService ?: return
        lastQualityNudgeTimeMs = SystemClock.uptimeMillis()
        playerDebugLog("restoreForegroundCeiling restoring to viewModel.quality=${viewModel.quality}")
        if (viewModel.quality == AUDIO_ONLY_QUALITY) {
            applyAudioSaverCeiling()
            return
        }
        val target = if (viewModel.quality == AUTO_QUALITY) null else qualitiesByKey[viewModel.quality]
        service.restoreForegroundQuality(target, isQualityLockEnabled())
    }

    override fun toggleAudioCompressor() {
        val enabled = playbackService?.toggleDynamicsProcessing()
        if (enabled == true) {
            binding.playerControls.audioCompressor.setImageResource(R.drawable.baseline_audio_compressor_on_24dp)
        } else {
            binding.playerControls.audioCompressor.setImageResource(R.drawable.baseline_audio_compressor_off_24dp)
        }
    }

    override fun downloadVideo() {
        Toast.makeText(requireContext(), R.string.ivs_feature_not_supported, Toast.LENGTH_SHORT).show()
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode)
        updatePlayingState()
    }

    private fun clearCaptions() {
        captionTimeline.clear()
        displayedCaption = null
        bindingOrNull?.subtitleView?.apply {
            removeCallbacks(updateCaptionsAction)
            setCues(emptyList())
        }
    }

    override fun setSubtitlesButton() {
        val controls = bindingOrNull?.playerControls ?: return
        val available = !player?.textTracks.isNullOrEmpty()
        val isEnabled = available && prefs.getBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, false)
        controls.subtitles.isVisible = available && prefs.getBoolean(AppConstants.PLAYER_SUBTITLES, false)
        controls.subtitles.setImageResource(if (isEnabled) androidx.media3.ui.R.drawable.exo_ic_subtitle_on else androidx.media3.ui.R.drawable.exo_ic_subtitle_off)
        controls.subtitles.setOnClickListener { showSubtitleSelection() }
        (childFragmentManager.findFragmentByTag("closeOnPip") as? PlayerSettingsDialog)?.setSubtitles(available)
    }

    override fun toggleSubtitles(enabled: Boolean) {
        clearCaptions()
        val tracks = player?.textTracks.orEmpty()
        val language = prefs.getString(AppConstants.PLAYER_CAPTION_LANGUAGE, Locale.getDefault().language)
        player?.textTrack = if (enabled) tracks.find { it.languageTag == language }
            ?: tracks.find { it.languageTag == "en" } ?: tracks.firstOrNull() else null
        setSubtitlesButton()
    }

    override fun showSubtitleSelection() {
        val tracks = player?.textTracks.orEmpty()
        if (tracks.isEmpty()) return
        val labels = listOf(getString(R.string.hide_subtitles)) + tracks.map {
            Locale.forLanguageTag(it.languageTag).getDisplayLanguage(Locale.getDefault()).ifBlank { it.label }
        }
        val selected = if (prefs.getBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, false)) {
            val current = player?.textTrack
            if (current != null) {
                tracks.indexOf(current) + 1
            } else {
                val savedLang = prefs.getString(AppConstants.PLAYER_CAPTION_LANGUAGE, Locale.getDefault().language)
                val idx = tracks.indexOfFirst { it.languageTag == savedLang }
                if (idx >= 0) idx + 1 else 1
            }
        } else {
            0
        }
        requireContext().getAlertDialogBuilder()
            .setTitle(R.string.subtitles)
            .setSingleChoiceItems(labels.toTypedArray(), selected) { dialog, index ->
                prefs.edit {
                    putBoolean(AppConstants.PLAYER_SUBTITLES_ENABLED, index > 0)
                    if (index > 0) putString(AppConstants.PLAYER_CAPTION_LANGUAGE, tracks[index - 1].languageTag)
                }
                clearCaptions()
                player?.textTrack = tracks.getOrNull(index - 1)
                setSubtitlesButton()
                dialog.dismiss()
            }.show()
    }

    override fun showPlaylistTags(mediaPlaylist: Boolean) {
        Toast.makeText(requireContext(), R.string.ivs_feature_not_supported, Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        clearCaptions()
        clearFreezeFrame()
        cancelQualityNudge()
        lastQualityNudgeTimeMs = 0L
        backgroundSaverApplied = false
        cancelNetworkLossGrace()
        networkPauseApplied = false
        bindingOrNull?.playerControls?.root?.removeCallbacks(updateProgressAction)
        val service = playbackService
        val ivsPlayer = service?.player
        resetCatchupState()
        playerListener?.let { ivsPlayer?.removeListener(it) }
        playerListener = null
        surfaceHolderCallback?.let { bindingOrNull?.playerSurface?.holder?.removeCallback(it) }
        surfaceHolderCallback = null
        service?.attachSurface(null)
        service?.stopPlayback()
        serviceConnection?.let {
            try {
                requireContext().unbindService(it)
            } catch (_: IllegalArgumentException) {
            }
        }
        serviceConnection = null
        playbackService = null
        context?.let { IvsPlayerService.stopService(it) }
    }

    override fun onStop() {
        clearCaptions()
        super.onStop()
        if (shouldClosePlaybackAfterPipDismiss()) {
            close()
            (activity as? MainActivity)?.closePlayer()
            clearPipDismissState()
            return
        }
        binding.playerControls.root.removeCallbacks(updateProgressAction)
        cancelQualityNudge()
        cancelNetworkLossGrace()
        networkPauseApplied = false
        val ivsPlayer = player
        resetCatchupState()
        val shouldKeepPlaying = ivsPlayer?.let { shouldContinueIvsInBackground(it) } ?: false
        playerDebugLog(
            "onStop state=${ivsPlayer?.state} shouldKeepPlaying=$shouldKeepPlaying urlPresent=${!currentUrl.isNullOrBlank()} recoveryInProgress=$recoveryInProgress"
        )
        if (ivsPlayer != null) {
            // Detach explicitly: the system may destroy the surface only after
            // onStop, when playbackService is already null and the surface callback
            // can no longer reach the service (leaving surfaceAttached stale-true).
            playbackService?.attachSurface(null)
            if (shouldKeepPlaying) {
                lastBackgroundPauseAtMs = 0L
                playbackService?.setBackgroundPlaybackEnabled(true)
                if (prefs.getBoolean("player_use_background_audio_track", false)) {
                    prefs.edit {
                        putBoolean(AppConstants.PLAYER_DISABLE_BACKGROUND_VIDEO, true)
                        remove("player_use_background_audio_track")
                    }
                }
                backgroundSaverApplied =
                    prefs.getBoolean(AppConstants.PLAYER_DISABLE_BACKGROUND_VIDEO, true) &&
                        applyAudioSaverCeiling(deferred = false)
                resumeOnStart = false
            } else {
                playbackService?.setBackgroundPlaybackEnabled(false)
                resumeOnStart = playbackService?.isPlaybackRequested() == true
                if (ivsPlayer.state == Player.State.PLAYING) {
                    playbackService?.pause(clearPlaybackRequest = false)
                    updatePlayingState()
                }
                if (resumeOnStart) {
                    noteBackgroundPause()
                    DiagnosticLogger.i(
                        TAG,
                        "IVS onStop paused shouldKeep=false resumeOnStart=true locked=${isScreenLockedOrOff()} " +
                            "pip=${activity?.isInPictureInPictureMode}"
                    )
                }
            }
            backgroundAudioTransitionRequested = false
            playerListener?.let { ivsPlayer.removeListener(it) }
            playerListener = null
        }
        serviceConnection?.let { requireContext().unbindService(it) }
        serviceConnection = null
        playbackService = null
        clearPipDismissState()
    }

    override fun onScreenOffWhileStopped() {
        if (!resumeOnStart || !isAdded) return
        val url = currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL)
        if (url.isNullOrBlank()) return
        // Service survived paused (playbackRequested kept). Nudge it to resume
        // audio now that the device is confirmed locked/off.
        try {
            DiagnosticLogger.i(TAG, "IVS late screen-off resume pip=${activity?.isInPictureInPictureMode}")
            requireContext().startService(
                Intent(requireContext(), IvsPlayerService::class.java).apply {
                    action = IvsPlayerService.INTENT_RESUME_BACKGROUND_IF_LOCKED
                }
            )
            resumeOnStart = false
        } catch (e: Exception) {
            DiagnosticLogger.w(TAG, "IVS late screen-off resume failed: ${e.message}")
        }
    }

    override fun onDestroyView() {
        clearCaptions()
        binding.playerControls.root.removeCallbacks(updateProgressAction)
        surfaceHolderCallback?.let { binding.playerSurface.holder.removeCallback(it) }
        surfaceHolderCallback = null
        super.onDestroyView()
    }

    override fun onNetworkRestored() {
        cancelNetworkLossGrace()
        // Only a sustained outage pauses + reloads. Brief validation flaps
        // (roam, revalidation, doze) ride through inside the IVS SDK.
        if (networkPauseApplied) {
            networkPauseApplied = false
            if (isResumed && videoType == STREAM && currentUrl != null) {
                startStream(currentUrl)
            }
        }
    }

    override fun onNetworkLost() {
        if (videoType == STREAM && isResumed && playbackService?.isBackgroundPlaybackEnabled() != true) {
            cancelNetworkLossGrace()
            val runnable = Runnable {
                networkLossGraceRunnable = null
                if (!isAdded) return@Runnable
                networkPauseApplied = true
                player?.pause()
                updatePlayingState()
            }
            networkLossGraceRunnable = runnable
            view?.postDelayed(runnable, NETWORK_LOSS_GRACE_MS)
        }
    }

    private fun cancelNetworkLossGrace() {
        networkLossGraceRunnable?.let { view?.removeCallbacks(it) }
        networkLossGraceRunnable = null
    }

    private fun isStreamOfflineError(exception: PlayerException): Boolean {
        val msg = exception.errorMessage.orEmpty()
        val errorType = exception.errorType.name
        return exception.code == 404 ||
            msg.contains("404") ||
            msg.contains("ErrorNotAvailable", ignoreCase = true) ||
            msg.contains("Failed to load playlist", ignoreCase = true) ||
            errorType.contains("MasterPlaylist", ignoreCase = true) ||
            errorType.contains("ErrorNotAvailable", ignoreCase = true) ||
            errorType.contains("NOT_AVAILABLE", ignoreCase = true)
    }

    private fun handleIvsStreamOffline() {
        if (!isAdded) return
        recoveryInProgress = false
        sameUrlRetryAttempted = false
        playbackService?.stopPlayback()
        if (!reloadIvsLiveStreamWithFreshUrl("offline check")) {
            // A playlist load failure while offline is a connection loss, not the stream ending.
            val isOffline = networkMonitor.networkType.value == NetworkMonitor.NetworkType.NONE
            showOfflineOverlay(if (isOffline) R.string.no_connection else R.string.stream_ended)
        }
    }

    private fun retryIvsPlayback(showMessage: Boolean) {
        val resolvedUrl = currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL)
        if (recoveryInProgress || !isAdded || resolvedUrl.isNullOrBlank()) {
            playerDebugLog(
                "retryIvsPlayback ignored recoveryInProgress=$recoveryInProgress isAdded=$isAdded urlPresent=${!resolvedUrl.isNullOrBlank()}"
            )
            return
        }
        resumeOnStart = false
        recoveryInProgress = true
        playerDebugLog(
            "retryIvsPlayback showMessage=$showMessage stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)} resolvedUrlPresent=true"
        )
        if (reloadIvsLiveStreamWithFreshUrl("playback error")) {
            DiagnosticLogger.i(
                TAG,
                "IVS playback error recovery: retrying IVS with fresh Kick URL stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)}"
            )
            return
        }
        if (!sameUrlRetryAttempted && !resolvedUrl.isNullOrBlank()) {
            sameUrlRetryAttempted = true
            DiagnosticLogger.i(
                TAG,
                "IVS playback error recovery: retrying same URL in IVS stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)}"
            )
            startStream(resolvedUrl)
            return
        }
        recoveryInProgress = false
        sameUrlRetryAttempted = false
        playbackService?.stopPlayback()
        val isOffline = networkMonitor.networkType.value == NetworkMonitor.NetworkType.NONE
        showOfflineOverlay(if (isOffline) R.string.no_connection else R.string.stream_ended)
    }

    private fun resolveStreamUrl(): String? =
        currentPlaybackUrl() ?: currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL)

    private fun resumePlaybackOrReload(service: IvsPlayerService, reason: String) {
        val ivsPlayer = player
        if (ivsPlayer?.state == Player.State.IDLE) {
            if (!reloadIvsLiveStreamWithFreshUrl(reason)) {
                val url = resolveStreamUrl()
                if (!url.isNullOrBlank()) {
                    startStream(url)
                } else {
                    service.play()
                }
            }
        } else {
            service.play()
        }
        resumeOnStart = false
        clearFreezeFrame()
        updatePlayingState()
    }

    private fun recoverEmptyIvsServiceIfNeeded() {
        if (!viewModel.started || player?.state != Player.State.IDLE || recoveryInProgress) {
            return
        }
        val url = resolveStreamUrl()
        DiagnosticLogger.i(
            TAG,
            "IVS resumed with empty service stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)} " +
                "urlPresent=${!url.isNullOrBlank()}"
        )
        if (!url.isNullOrBlank()) {
            if (!reloadIvsLiveStreamWithFreshUrl("empty service recovery")) {
                startStream(url)
            }
        } else {
            updatePlayingState()
        }
    }

    private fun reloadIvsLiveStreamWithFreshUrl(reason: String): Boolean {
        val resolvedUrl = resolveStreamUrl()
        if (resolvedUrl.isNullOrBlank()) {
            return false
        }
        binding.playerSurface.visibility = View.VISIBLE
        attachSurfaceIfAvailable()
        val started = reloadKickStreamWithFreshResolvedUrl(
            stalePlaybackUrl = resolvedUrl,
            reason = "IVS $reason",
            delayMs = 0L
        )
        if (started) {
            recoveryInProgress = true
            resumeOnStart = false
            playbackService?.resetForReload()
        }
        return started
    }

    private fun shouldContinueIvsInBackground(player: Player): Boolean {
        return !currentUrl.isNullOrBlank() &&
            player.state != Player.State.ENDED &&
            if (backgroundAudioTransitionRequested) {
                true
            } else {
                playbackService?.isPlaybackRequested() == true &&
                    shouldContinuePlaybackInBackground()
            }
    }

    private fun exitAudioOnlyMode() {
        binding.playerSurface.visibility = View.VISIBLE
        attachSurfaceIfAvailable()
        changePlayerMode()
        updatePlayingState()
    }

    private fun attachSurfaceIfAvailable() {
        val surface = binding.playerSurface.holder.surface
        if (surfaceCreated && surface?.isValid == true) {
            playbackService?.attachSurface(surface)
        }
    }

    private fun resetCatchupState() {
        if (!isCatchingUp) return
        isCatchingUp = false
        runIvsOp("fragment-catchup-reset") { it.setPlaybackRate(1.0f) }
    }

    private fun nudgeQualityToTarget(targetQuality: Quality) {
        cancelQualityNudge()
        pendingQualityNudge = targetQuality
        playerDebugLog("IVS quality nudge: stepping up to ${targetQuality.name} (${targetQuality.bitrate} bps)")
        runIvsOp("quality-nudge") {
            // Keep queued video while the new rendition is fetched.
            it.setAutoMaxQuality(targetQuality)
            it.setQuality(targetQuality, true)
        }
        val runnable = Runnable {
            qualityNudgeSafetyRunnable = null
            if (pendingQualityNudge == targetQuality) {
                playerDebugLog("IVS quality nudge safety timeout: re-arming auto ceiling for ${targetQuality.name}")
                pendingQualityNudge = null
                runIvsOp("quality-nudge-safety-timeout") {
                    it.setAutoQualityMode(true)
                    val autoMax = if (viewModel.quality == AUTO_QUALITY) null else targetQuality
                    it.setAutoMaxQuality(autoMax)
                }
            }
        }
        qualityNudgeSafetyRunnable = runnable
        view?.postDelayed(runnable, QUALITY_NUDGE_SAFETY_TIMEOUT_MS)
    }

    private fun cancelQualityNudge() {
        qualityNudgeSafetyRunnable?.let { view?.removeCallbacks(it) }
        qualityNudgeSafetyRunnable = null
        pendingQualityNudge = null
        downscaleRecoveryTicks = 0
    }

    companion object {
        private const val TAG = "IvsPlayerFragment"
        private const val KEY_RESUME_ON_START = "resume_on_start"
        // Reloads start a couple segments back; skip when already near-live.
        private const val GO_LIVE_SKIP_THRESHOLD_MS = 2_000L
        // Brief VALIDATED-capability flaps recover on their own; only pause the
        // player when the loss outlasts this grace period.
        private const val NETWORK_LOSS_GRACE_MS = 4_000L
        // Weight of the previous value when smoothing the jumpy SDK bandwidth
        // estimate into a readable trend.
        private const val SMOOTHED_BANDWIDTH_OLD_WEIGHT = 0.7f
        private const val QUALITY_NUDGE_SAFETY_TIMEOUT_MS = 5_000L
        private const val DOWNSCALE_RECOVERY_REQUIRED_TICKS = 5
        private const val QUALITY_RECOVERY_COOLDOWN_MS = 8_000L

        fun newInstance(item: Stream, resolvedUrl: String?, forceStandardLiveEngine: Boolean): IvsPlayerFragment {
            return IvsPlayerFragment().apply {
                arguments = getStreamArguments(item, resolvedUrl, forceStandardLiveEngine)
            }
        }
    }
}
