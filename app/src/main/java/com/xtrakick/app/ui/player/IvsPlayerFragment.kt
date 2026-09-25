package com.xtrakick.app.ui.player

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
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
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.VideoStatsInfo
import java.util.Locale
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.NetworkMonitor

@OptIn(UnstableApi::class)
class IvsPlayerFragment : PlayerFragment() {

    private var playbackService: IvsPlayerService? = null
    private var serviceConnection: ServiceConnection? = null
    private val player: Player?
        get() = playbackService?.player
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

    override fun onStart() {
        super.onStart()
        val callback = object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                surfaceCreated = true
                playbackService?.attachSurface(holder.surface)
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
                if (surfaceCreated) {
                    boundService.attachSurface(binding.playerSurface.holder.surface)
                }
                val listener = object : Player.Listener() {
                    override fun onCue(cue: Cue) = Unit

                    override fun onDurationChanged(duration: Long) {
                        binding.playerControls.progressBar.setDuration(duration.coerceAtLeast(0L))
                        updateProgress()
                    }

                    override fun onStateChanged(state: Player.State) {
                        binding.bufferingIndicator.isVisible = state == Player.State.BUFFERING
                        if (state != Player.State.PLAYING) {
                            resetCatchupState()
                        }
                        if (state == Player.State.BUFFERING) {
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
                    }

                    override fun onSeekCompleted(position: Long) {
                        updateProgress()
                    }

                    override fun onVideoSizeChanged(width: Int, height: Int) = Unit

                    override fun onQualityChanged(quality: Quality) {
                        val nudgeTarget = pendingQualityNudge
                        if (nudgeTarget != null && (quality == nudgeTarget || quality.bitrate >= nudgeTarget.bitrate)) {
                            cancelQualityNudge()
                            playerDebugLog("IVS quality nudge fulfilled: reached ${quality.name}, re-arming auto ceiling")
                            runIvsOp("quality-nudge-rearm") {
                                it.setAutoQualityMode(true)
                                it.setAutoMaxQuality(nudgeTarget)
                            }
                        }
                        if (player?.isAutoQualityMode == false && nudgeTarget == null) {
                            val key = qualitiesByKey.entries.find { it.value == quality }?.key
                            if (key != null) {
                                viewModel.quality = key
                                setQualityText()
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
                        } else {
                            setQualityText()
                        }
                    }
                }
                player?.addListener(listener)
                playerListener = listener
                if (resumeOnStart && player?.state != Player.State.PLAYING) {
                    boundService.play()
                    resumeOnStart = false
                    updatePlayingState()
                }
                recoverEmptyIvsServiceIfNeeded()
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
        if (!startIvsService(intent)) {
            serviceConnection = null
            surfaceHolderCallback?.let { binding.playerSurface.holder.removeCallback(it) }
            surfaceHolderCallback = null
            fallbackToStandardPlayerAfterServiceStartDenied()
            return
        }
        requireContext().bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private fun startIvsService(intent: Intent): Boolean {
        return try {
            requireContext().startService(intent)
            true
        } catch (e: RuntimeException) {
            if (!isBackgroundServiceStartDenied(e)) {
                throw e
            }
            DiagnosticLogger.w(
                TAG,
                "IVS service start denied; falling back to standard player " +
                    "foreground=${lifecycle.currentState} urlPresent=${!requireArguments().getString(KEY_RESOLVED_STREAM_URL).isNullOrBlank()}",
                e
            )
            false
        }
    }

    private fun isBackgroundServiceStartDenied(error: RuntimeException): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            error.javaClass.name == "android.app.BackgroundServiceStartNotAllowedException"
    }

    private fun fallbackToStandardPlayerAfterServiceStartDenied() {
        val resolvedUrl = currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL)
        if (!isAdded || resolvedUrl.isNullOrBlank()) {
            return
        }
        Toast.makeText(requireContext(), R.string.ivs_fallback_to_standard_player, Toast.LENGTH_SHORT).show()
        requireArguments().putBoolean(KEY_FORCE_STANDARD_LIVE_ENGINE, true)
        (activity as? MainActivity)?.startStream(
            stream = getCurrentStream(),
            resolvedUrl = resolvedUrl,
            forceStandardLiveEngine = true
        )
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
            if (viewModel.quality != previousQuality || !qualitiesByKey.containsKey(previousQuality)) {
                changeQuality(viewModel.quality)
            } else {
                setQualityText()
            }
        }
    }

    override fun startStream(url: String?) {
        val resolvedUrl = url?.takeIf { it.isNotBlank() } ?: return
        hideOfflineOverlay()
        recoveryInProgress = false
        cancelQualityNudge()
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

    override fun getCurrentPosition(): Long? = player?.position

    override fun getCurrentSpeed(): Float? = player?.playbackRate

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
            else -> Unit
        }
        updatePlayingState()
    }

    override fun seek(position: Long) {
        runIvsOp("fragment-seek") { it.seekTo(position) }
    }

    override fun seekToLivePosition() {
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
            val latency = player?.liveLatency?.takeIf { it > 0L }
            val catchupEnabled = prefs.getBoolean(AppConstants.PLAYER_IVS_LATENCY_CATCHUP, true)
            val latencyConfig = if (catchupEnabled) LiveLatencySettings.resolve(prefs) else null
            val targetOffsetMs = latencyConfig?.targetOffsetMs
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

                val isDownscaled = isDownscaled(ivsPlayer.quality, getTargetQuality())

                if (catchupEnabled && latency != null && targetOffsetMs != null) {
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
                        isCurrentlyCatchingUp = isCatchingUp
                    )

                    // Coordinate catch-up with resolution recovery: do NOT accelerate playback
                    // while playing below the target resolution, so the buffer is not depleted.
                    val speedToApply = if (isDownscaled) null else desiredSpeed

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
                resetCatchupState()
            }

            if (root.isVisible && !progressBar.isPressed) {
                val currentPosition = ivsPlayer?.position ?: 0L
                progressBar.setPosition(currentPosition)
                progressBar.setBufferedPosition(ivsPlayer?.bufferedPosition ?: 0L)
                position.text = if (currentPosition > 0L) {
                    android.text.format.DateUtils.formatElapsedTime(currentPosition / 1000)
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
                runIvsOp("quality-auto") {
                    it.setAutoQualityMode(true)
                    it.setAutoMaxQuality(null)
                }
            }
            else -> qualitiesByKey[selectedQuality]?.let { targetQuality ->
                val activeQuality = player?.quality
                val isDownscaled = activeQuality != null && isDownscaled(activeQuality, targetQuality)
                if (isDownscaled) {
                    // Active resolution nudge: player is currently below targetQuality.
                    // Step up to targetQuality, then re-arm adaptive ceiling upon reaching it.
                    nudgeQualityToTarget(targetQuality)
                } else {
                    cancelQualityNudge()
                    runIvsOp("quality-ceiling") {
                        it.setAutoQualityMode(true)
                        it.setAutoMaxQuality(targetQuality)
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
        if (viewModel.quality == AUDIO_ONLY_QUALITY) {
            return
        }
        backgroundAudioTransitionRequested = true
        viewModel.restoreQuality = true
        viewModel.previousQuality = viewModel.quality
        viewModel.quality = AUDIO_ONLY_QUALITY
        playbackService?.attachSurface(null)
        binding.playerSurface.visibility = View.GONE
        changePlayerMode()
        setQualityText()
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

    override fun setSubtitlesButton() {
        binding.playerControls.subtitles.visibility = View.GONE
    }

    override fun showPlaylistTags(mediaPlaylist: Boolean) {
        Toast.makeText(requireContext(), R.string.ivs_feature_not_supported, Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        clearFreezeFrame()
        cancelQualityNudge()
        cancelNetworkLossGrace()
        networkPauseApplied = false
        binding.playerControls.root.removeCallbacks(updateProgressAction)
        val service = playbackService
        val ivsPlayer = service?.player
        resetCatchupState()
        playerListener?.let { ivsPlayer?.removeListener(it) }
        playerListener = null
        surfaceHolderCallback?.let { binding.playerSurface.holder.removeCallback(it) }
        surfaceHolderCallback = null
        service?.stopPlayback()
        serviceConnection?.let {
            try {
                requireContext().unbindService(it)
            } catch (_: IllegalArgumentException) {
            }
        }
        serviceConnection = null
        playbackService = null
    }

    override fun onStop() {
        super.onStop()
        if (shouldClosePlaybackAfterPipDismiss()) {
            close()
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
            if (shouldKeepPlaying) {
                lastBackgroundPauseAtMs = 0L
                playbackService?.setBackgroundPlaybackEnabled(true)
                playbackService?.attachSurface(null)
                resumeOnStart = false
            } else {
                playbackService?.setBackgroundPlaybackEnabled(false)
                // Detach explicitly: the system may destroy the surface only after
                // onStop, when playbackService is already null and the surface callback
                // can no longer reach the service (leaving surfaceAttached stale-true).
                playbackService?.attachSurface(null)
                resumeOnStart = playbackService?.isPlaybackRequested() == true
                if (ivsPlayer.state == Player.State.PLAYING) {
                    // resumeOnStart drives resume; a lingering request pins session to PLAYING.
                    playbackService?.pause(clearPlaybackRequest = true)
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
            showOfflineOverlay(R.string.stream_ended)
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
        if (reloadIvsLiveStreamWithFreshUrl("IVS error")) {
            DiagnosticLogger.w(
                TAG,
                "IVS playback error recovery: retrying IVS with fresh Kick URL stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)}"
            )
            return
        }
        if (!sameUrlRetryAttempted && !resolvedUrl.isNullOrBlank()) {
            sameUrlRetryAttempted = true
            DiagnosticLogger.w(
                TAG,
                "IVS playback error recovery: retrying same URL in IVS stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)}"
            )
            startStream(resolvedUrl)
            return
        }
        if (showMessage) {
            Toast.makeText(requireContext(), R.string.ivs_fallback_to_standard_player, Toast.LENGTH_SHORT).show()
        }
        DiagnosticLogger.w(
            TAG,
            "IVS playback error recovery: falling back to standard player stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)}"
        )
        playbackService?.stopPlayback()
        requireArguments().putBoolean(KEY_FORCE_STANDARD_LIVE_ENGINE, true)
        (activity as? MainActivity)?.startStream(
            stream = getCurrentStream(),
            resolvedUrl = resolvedUrl,
            forceStandardLiveEngine = true
        )
    }

    private fun recoverEmptyIvsServiceIfNeeded() {
        if (!viewModel.started || viewModel.loaded.value || player?.state != Player.State.IDLE) {
            return
        }
        DiagnosticLogger.w(
            TAG,
            "IVS resumed with empty service stream=${requireArguments().getString(KEY_CHANNEL_LOGIN)} " +
                "urlPresent=${!currentUrl.isNullOrBlank()}"
        )
        updatePlayingState()
    }

    private fun reloadIvsLiveStreamWithFreshUrl(reason: String): Boolean {
        val resolvedUrl = currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL)
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
            it.setQuality(targetQuality)
        }
        val runnable = Runnable {
            qualityNudgeSafetyRunnable = null
            if (pendingQualityNudge == targetQuality) {
                playerDebugLog("IVS quality nudge safety timeout: re-arming auto ceiling for ${targetQuality.name}")
                pendingQualityNudge = null
                runIvsOp("quality-nudge-safety-timeout") {
                    it.setAutoQualityMode(true)
                    it.setAutoMaxQuality(targetQuality)
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
    }

    companion object {
        private const val TAG = "IvsPlayerFragment"
        // Reloads start a couple segments back; skip when already near-live.
        private const val GO_LIVE_SKIP_THRESHOLD_MS = 2_000L
        // Brief VALIDATED-capability flaps recover on their own; only pause the
        // player when the loss outlasts this grace period.
        private const val NETWORK_LOSS_GRACE_MS = 4_000L
        // Weight of the previous value when smoothing the jumpy SDK bandwidth
        // estimate into a readable trend.
        private const val SMOOTHED_BANDWIDTH_OLD_WEIGHT = 0.7f
        private const val QUALITY_NUDGE_SAFETY_TIMEOUT_MS = 5_000L

        fun newInstance(item: Stream, resolvedUrl: String?, forceStandardLiveEngine: Boolean): IvsPlayerFragment {
            return IvsPlayerFragment().apply {
                arguments = getStreamArguments(item, resolvedUrl, forceStandardLiveEngine)
            }
        }
    }
}
