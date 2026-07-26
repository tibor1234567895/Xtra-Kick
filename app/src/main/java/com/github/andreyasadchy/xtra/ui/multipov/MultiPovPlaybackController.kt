package com.github.andreyasadchy.xtra.ui.multipov

import android.animation.ValueAnimator
import android.content.Context
import android.content.SharedPreferences
import android.media.audiofx.DynamicsProcessing
import android.os.Build
import android.view.TextureView
import android.view.animation.DecelerateInterpolator
import androidx.annotation.OptIn
import androidx.core.animation.doOnEnd
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.VideoSize
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.HttpDataSource
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.source.BehindLiveWindowException
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import androidx.media3.ui.AspectRatioFrameLayout
import com.github.andreyasadchy.xtra.player.lowlatency.OkHttpDataSource
import com.github.andreyasadchy.xtra.ui.player.LiveLatencyConfig
import com.github.andreyasadchy.xtra.ui.player.LiveLatencySettings
import com.github.andreyasadchy.xtra.ui.player.PlaybackService
import com.github.andreyasadchy.xtra.util.C as AppC
import okhttp3.OkHttpClient
import org.json.JSONObject
import kotlin.math.max

/**
 * Multi-stream playback favors stability over lowest latency:
 * - Sit further behind the live edge so N concurrent HLS clients have headroom
 * - Quality selector applies to all tiles; bandwidth-saving forces secondaries to 480p
 * - Mute secondaries by disabling their audio tracks
 * - Track constraints only re-applied when caps actually change
 */
@OptIn(UnstableApi::class)
class MultiPovPlaybackController(
    private val context: Context,
    private val okHttpClient: OkHttpClient,
    private val prefs: SharedPreferences,
    private val onLoadState: (key: String, state: MultiPovLoadState) -> Unit,
    private val onHttpError: (key: String, responseCode: Int, url: String?) -> Unit = { _, _, _ -> },
) {
    private val players = linkedMapOf<String, ExoPlayer>()
    private val trackSelectors = linkedMapOf<String, DefaultTrackSelector>()
    /** Last applied constraint signature per slot — avoids thrashing on every UI render. */
    private val appliedConstraintKeys = linkedMapOf<String, String>()
    /** TextureView so each tile clips correctly (SurfaceView bleeds across neighbors). */
    private val surfaces = linkedMapOf<String, TextureView>()
    private val aspectFrames = linkedMapOf<String, AspectRatioFrameLayout>()
    /** Per-stream volume (focused stream only is audible). Defaults to global player volume. */
    private val volumes = linkedMapOf<String, Float>()
    /** User-paused streams — not auto-resumed by ensurePlaying/resume helpers. */
    private val userPaused = mutableSetOf<String>()
    /** Audio compressor enabled per stream (focused stream's session is active). */
    private val compressorEnabled = mutableMapOf<String, Boolean>()
    private val dynamicsByKey = linkedMapOf<String, DynamicsProcessing>()
    /** Quality for all streams (unless bandwidth saving forces secondaries to 480p). */
    private var streamQuality: MultiPovQuality = MultiPovQuality.SOURCE
    /** Non-focused tiles locked to 480p when true. */
    private var bandwidthSaving: Boolean = false
    private var adaptiveMaxHeight: Int? = null
    private var focusedKey: String? = null
    private var focusAnimator: ValueAnimator? = null
    private val defaultVolume: Float
        get() = (prefs.getInt(AppC.PLAYER_VOLUME, 100) / 100f).coerceIn(0f, 1f)

    /**
     * Solo latency prefs are too aggressive for N concurrent Kick HLS clients (underruns /
     * streams that never leave buffering). MultiPOV uses a derived mid profile:
     * much closer than the old hard-coded 12–16s, but safer than solo ~1s "lowest".
     */
    private val soloLatency: LiveLatencyConfig = LiveLatencySettings.resolve(prefs)
    private val multipovFocusedTargetMs: Long =
        max(soloLatency.targetOffsetMs * 2L, 3_500L).coerceAtMost(5_500L)
    private val multipovSecondaryTargetMs: Long = multipovFocusedTargetMs + 2_000L
    /** One-shot live-edge correction per player (repeated seeks thrash MediaCodec). */
    private val liveSnapDone = mutableSetOf<String>()
    private val lastBehindLiveRecoveryMs = mutableMapOf<String, Long>()

    fun setStreamQuality(quality: MultiPovQuality) {
        if (streamQuality == quality) return
        streamQuality = quality
        reapplyAllTrackConstraints()
    }

    fun setBandwidthSaving(enabled: Boolean) {
        if (bandwidthSaving == enabled) return
        bandwidthSaving = enabled
        reapplyAllTrackConstraints()
    }

    fun setAdaptiveMaxHeight(maxHeight: Int?) {
        if (adaptiveMaxHeight == maxHeight) return
        adaptiveMaxHeight = maxHeight
        reapplyAllTrackConstraints()
    }

    fun setFocus(key: String?, crossfade: Boolean = true) {
        val targetVol = key?.let { volumeFor(it) } ?: defaultVolume
        if (key == focusedKey) {
            players[key]?.volume = targetVol
            return
        }
        val previous = focusedKey
        focusedKey = key
        // Focus change only: re-cap quality + enable audio on new focus / disable on old.
        players.forEach { (slotKey, player) ->
            applyTrackConstraints(player, focused = slotKey == focusedKey, key = slotKey)
        }
        // Compressor follows focus (one active DynamicsProcessing session).
        previous?.let { releaseCompressor(it) }
        key?.let { if (compressorEnabled[it] == true) attachCompressor(it) }
        // Don't seek on every focus change — that re-flushes decoders under multi-stream load.
        val shouldCrossfade = crossfade &&
            prefs.getBoolean(AppC.MULTIPOV_AUDIO_CROSSFADE, true) &&
            previous != null &&
            key != null &&
            players.containsKey(previous) &&
            players.containsKey(key)
        if (!shouldCrossfade) {
            focusAnimator?.cancel()
            players.forEach { (slotKey, player) ->
                player.volume = if (slotKey == focusedKey) volumeFor(slotKey) else 0f
            }
            return
        }
        val fromPlayer = players[previous]
        val toPlayer = players[key]
        if (fromPlayer == null || toPlayer == null) {
            players.forEach { (slotKey, player) ->
                player.volume = if (slotKey == focusedKey) volumeFor(slotKey) else 0f
            }
            return
        }
        focusAnimator?.cancel()
        val startFrom = fromPlayer.volume
        val startTo = toPlayer.volume
        focusAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 180L
            interpolator = DecelerateInterpolator()
            addUpdateListener { anim ->
                val t = anim.animatedValue as Float
                fromPlayer.volume = startFrom * (1f - t)
                toPlayer.volume = startTo + (targetVol - startTo) * t
            }
            doOnEnd {
                players.forEach { (slotKey, player) ->
                    player.volume = if (slotKey == focusedKey) volumeFor(slotKey) else 0f
                }
            }
            start()
        }
    }

    fun attachSurface(key: String, textureView: TextureView, aspectFrame: AspectRatioFrameLayout? = null) {
        surfaces[key] = textureView
        if (aspectFrame != null) {
            aspectFrames[key] = aspectFrame
            aspectFrame.setAspectRatio(16f / 9f)
        }
        players[key]?.setVideoTextureView(textureView)
    }

    fun detachSurface(key: String) {
        val texture = surfaces.remove(key)
        val player = players[key]
        if (player != null && texture != null) {
            player.clearVideoTextureView(texture)
        } else {
            player?.clearVideoSurface()
        }
        aspectFrames.remove(key)
    }

    fun ensurePlaying(key: String, url: String, focused: Boolean) {
        if (url.isBlank()) {
            onLoadState(key, MultiPovLoadState.Error("Missing playback URL"))
            return
        }
        val existing = players[key]
        if (existing != null) {
            val currentUri = existing.currentMediaItem?.localConfiguration?.uri?.toString()
            if (currentUri == url) {
                if (focused) focusedKey = key
                if (focusAnimator?.isRunning != true) {
                    existing.volume = if (focused) volumeFor(key) else 0f
                }
                // Only touch track params if focus/caps actually need a change.
                applyTrackConstraints(existing, focused = focused, key = key)
                if (existing.playerError == null) {
                    if (existing.playbackState == Player.STATE_IDLE) {
                        existing.prepare()
                    }
                    // Honor user pause — don't force-play a stream the user stopped.
                    if (key !in userPaused) {
                        existing.playWhenReady = true
                    }
                }
                return
            }
            releasePlayer(key)
        }
        if (focused) focusedKey = key
        try {
            val trackSelector = DefaultTrackSelector(context).apply {
                parameters = buildTrackParams(
                    base = buildUponParameters(),
                    focused = focused,
                    key = key,
                )
            }
            val player = createPlayer(trackSelector = trackSelector)
            player.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
            player.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    when (playbackState) {
                        Player.STATE_IDLE -> Unit
                        Player.STATE_BUFFERING -> onLoadState(key, MultiPovLoadState.Loading)
                        Player.STATE_READY -> {
                            onLoadState(key, MultiPovLoadState.Ready)
                            // One-shot only — repeating seek on every READY was thrashing decoders.
                            if (key == focusedKey) maybeSnapToLiveEdge(key, once = true)
                        }
                        Player.STATE_ENDED -> onLoadState(key, MultiPovLoadState.Offline)
                    }
                }

                override fun onVideoSizeChanged(videoSize: VideoSize) {
                    if (videoSize.height > 0) {
                        val ratio = videoSize.width * videoSize.pixelWidthHeightRatio / videoSize.height
                        aspectFrames[key]?.setAspectRatio(ratio)
                    }
                }

                override fun onAudioSessionIdChanged(audioSessionId: Int) {
                    if (compressorEnabled[key] == true && key == focusedKey) {
                        attachCompressor(key, audioSessionId)
                    }
                }

                override fun onPlayerError(error: PlaybackException) {
                    // Live window slid past our position — jump back, but rate-limit to avoid seek storms.
                    if (isBehindLiveWindow(error)) {
                        recoverBehindLiveWindow(key)
                        return
                    }
                    // Walk the cause chain: HLS nests chunk failures two or three levels deep,
                    // so the direct cause is rarely the InvalidResponseCodeException and the
                    // expired-URL recovery below never fired.
                    val responseCode = httpResponseCode(error)
                    if (responseCode == 403 || responseCode == 404) {
                        val failedUrl = players[key]?.currentMediaItem?.localConfiguration?.uri?.toString() ?: url
                        onLoadState(key, MultiPovLoadState.Error("URL expired (HTTP $responseCode)"))
                        onHttpError(key, responseCode, failedUrl)
                        return
                    }
                    val message = when (error.errorCode) {
                        PlaybackException.ERROR_CODE_DECODER_INIT_FAILED,
                        PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED,
                        PlaybackException.ERROR_CODE_DECODING_FAILED ->
                            "Decoder unavailable"
                        else -> error.message ?: "Playback error"
                    }
                    onLoadState(key, MultiPovLoadState.Error(message))
                }
            })
            val httpFactory = OkHttpDataSource.Factory(okHttpClient, null) { false }
                .setDefaultRequestProperties(kickPlaybackHeaders())
            val dataSourceFactory = DefaultDataSource.Factory(context, httpFactory)
            val mediaSource = HlsMediaSource.Factory(dataSourceFactory)
                .setPlaylistParserFactory(PlaybackService.CustomHlsPlaylistParserFactory())
                // Full prep waits for first segments so we don't start with an empty buffer.
                .setAllowChunklessPreparation(false)
                .createMediaSource(
                    MediaItem.Builder()
                        .setUri(url.toUri())
                        .setMimeType(MimeTypes.APPLICATION_M3U8)
                        .setLiveConfiguration(liveConfigurationFor(focused = focused))
                        .build()
                )
            player.setMediaSource(mediaSource)
            player.volume = if (focused) volumeFor(key) else 0f
            player.prepare()
            player.playWhenReady = key !in userPaused
            players[key] = player
            trackSelectors[key] = trackSelector
            // Seed signature so the next ensurePlaying/render doesn't immediately re-set params.
            appliedConstraintKeys[key] = constraintSignature(focused = focused, key = key)
            surfaces[key]?.let { player.setVideoTextureView(it) }
            if (focused && compressorEnabled[key] == true) {
                attachCompressor(key)
            }
            onLoadState(key, MultiPovLoadState.Loading)
            // New stream steals bandwidth — re-cap everyone once.
            reapplyAllTrackConstraints()
        } catch (e: Exception) {
            onLoadState(key, MultiPovLoadState.Error(e.message ?: "Failed to start player"))
        }
    }

    fun retry(key: String, url: String?, focused: Boolean) {
        if (url.isNullOrBlank()) {
            onLoadState(key, MultiPovLoadState.Error("Missing playback URL"))
            return
        }
        userPaused.remove(key)
        releasePlayer(key)
        ensurePlaying(key, url, focused)
    }

    fun isPlaying(key: String?): Boolean {
        if (key == null) return false
        val player = players[key] ?: return false
        return player.playWhenReady && player.playbackState != Player.STATE_IDLE &&
            player.playbackState != Player.STATE_ENDED && key !in userPaused
    }

    fun togglePlayPause(key: String?): Boolean {
        if (key == null) return false
        val player = players[key] ?: return false
        return if (key in userPaused || !player.playWhenReady) {
            userPaused.remove(key)
            player.playWhenReady = true
            true
        } else {
            userPaused.add(key)
            player.playWhenReady = false
            false
        }
    }

    fun setPaused(key: String?, paused: Boolean) {
        if (key == null) return
        val player = players[key] ?: return
        if (paused) {
            userPaused.add(key)
            player.playWhenReady = false
        } else {
            userPaused.remove(key)
            player.playWhenReady = true
        }
    }

    fun volumeFor(key: String): Float = volumes[key] ?: defaultVolume

    fun setVolume(key: String?, volume: Float) {
        if (key == null) return
        val v = volume.coerceIn(0f, 1f)
        volumes[key] = v
        if (key == focusedKey) {
            players[key]?.volume = v
        }
    }

    fun seekToLive(key: String?) {
        val player = key?.let { players[it] } ?: return
        player.seekToDefaultPosition()
        if (key !in userPaused) player.playWhenReady = true
    }

    fun getLiveOffsetMs(key: String?): Long? {
        val player = key?.let { players[it] } ?: return null
        if (!player.isCurrentMediaItemLive) return null
        val offset = player.currentLiveOffset
        return if (offset >= 0) offset else null
    }

    fun isCompressorEnabled(key: String?): Boolean {
        if (key == null) return false
        return compressorEnabled[key]
            ?: prefs.getBoolean(AppC.PLAYER_AUDIO_COMPRESSOR, false)
    }

    fun toggleCompressor(key: String?): Boolean {
        if (key == null) return false
        val next = !isCompressorEnabled(key)
        compressorEnabled[key] = next
        if (key == focusedKey) {
            if (next) attachCompressor(key) else releaseCompressor(key)
        }
        // Keep global pref in sync with the focused stream's choice (matches solo player).
        if (key == focusedKey) {
            prefs.edit { putBoolean(AppC.PLAYER_AUDIO_COMPRESSOR, next) }
        }
        return next
    }

    fun pauseSecondaries() {
        players.forEach { (key, player) ->
            if (key != focusedKey) {
                player.playWhenReady = false
            }
        }
    }

    fun resumeSecondaries() {
        players.forEach { (key, player) ->
            if (key != focusedKey && player.playerError == null && key !in userPaused) {
                player.playWhenReady = true
            }
        }
    }

    fun pauseAll() {
        players.values.forEach { it.playWhenReady = false }
    }

    fun resumeAll() {
        players.forEach { (key, player) ->
            if (player.playerError == null && key !in userPaused) {
                player.playWhenReady = true
            }
        }
    }

    fun releasePlayer(key: String) {
        releaseCompressor(key)
        val texture = surfaces[key]
        players.remove(key)?.let { player ->
            if (texture != null) {
                player.clearVideoTextureView(texture)
            } else {
                player.clearVideoSurface()
            }
            player.release()
        }
        trackSelectors.remove(key)
        appliedConstraintKeys.remove(key)
        surfaces.remove(key)
        aspectFrames.remove(key)
        liveSnapDone.remove(key)
        lastBehindLiveRecoveryMs.remove(key)
        // Keep volumes / pause / compressor prefs for the slot if re-added later this session.
        if (focusedKey == key) {
            focusedKey = null
        }
        reapplyAllTrackConstraints()
    }

    fun releaseAll() {
        focusAnimator?.cancel()
        focusAnimator = null
        players.keys.toList().forEach { releasePlayer(it) }
        surfaces.clear()
        aspectFrames.clear()
        trackSelectors.clear()
        appliedConstraintKeys.clear()
        volumes.clear()
        userPaused.clear()
        compressorEnabled.clear()
        liveSnapDone.clear()
        lastBehindLiveRecoveryMs.clear()
        dynamicsByKey.values.forEach { runCatching { it.release() } }
        dynamicsByKey.clear()
        focusedKey = null
    }

    private fun attachCompressor(key: String, sessionId: Int? = null) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) return
        val player = players[key] ?: return
        val audioSessionId = sessionId ?: player.audioSessionId
        if (audioSessionId == 0) return
        releaseCompressor(key)
        runCatching {
            dynamicsByKey[key] = DynamicsProcessing(0, audioSessionId, null).apply {
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
                            },
                        )
                    }
                }
                enabled = true
            }
        }
    }

    private fun releaseCompressor(key: String) {
        dynamicsByKey.remove(key)?.let { runCatching { it.release() } }
    }

    /**
     * MultiPOV load control: enough headroom for several concurrent HLS clients.
     * Not as huge as the old 12s/45s (which forced multi-second delay), not as tight as solo "lowest".
     */
    private fun createPlayer(trackSelector: DefaultTrackSelector): ExoPlayer {
        val minB = max(soloLatency.minBufferMs * 2, 6_000).coerceAtMost(12_000)
        val maxB = max(soloLatency.maxBufferMs * 2, 18_000).coerceAtMost(32_000).coerceAtLeast(minB)
        val playbackB = max(soloLatency.playbackBufferMs, 1_500).coerceAtMost(3_000)
        val rebufferB = max(soloLatency.rebufferMs, 2_500).coerceAtMost(5_000)
        val loadControl = DefaultLoadControl.Builder()
            .setBufferDurationsMs(minB, maxB, playbackB, rebufferB)
            .setPrioritizeTimeOverSizeThresholds(true)
            .setBackBuffer(minB, /* retainBackBufferFromKeyframe = */ true)
            .build()
        return ExoPlayer.Builder(context)
            .setTrackSelector(trackSelector)
            .setLoadControl(loadControl)
            .setAudioAttributes(AudioAttributes.DEFAULT, false)
            .setHandleAudioBecomingNoisy(prefs.getBoolean(AppC.PLAYER_HANDLE_AUDIO_BECOMING_NOISY, true))
            .build()
    }

    /**
     * Focused ~3.5–5.5s target (vs solo ~1s / old multipov 12s).
     * Secondaries a bit further; mild catch-up only on focused.
     */
    private fun liveConfigurationFor(focused: Boolean): MediaItem.LiveConfiguration {
        val targetMs = if (focused) multipovFocusedTargetMs else multipovSecondaryTargetMs
        return MediaItem.LiveConfiguration.Builder()
            .setTargetOffsetMs(targetMs)
            .setMinPlaybackSpeed(1.0f)
            .setMaxPlaybackSpeed(if (focused) 1.08f else 1.02f)
            .build()
    }

    private fun maybeSnapToLiveEdge(key: String, once: Boolean) {
        if (once && key in liveSnapDone) return
        val player = players[key] ?: return
        if (!player.isCurrentMediaItemLive) return
        val offset = player.currentLiveOffset
        if (offset < 0) return
        // Wider tolerance than solo — avoid seek storms under multi-stream load.
        val limit = multipovFocusedTargetMs + 8_000L
        if (offset > limit) {
            liveSnapDone.add(key)
            player.seekToDefaultPosition()
            if (key !in userPaused) {
                player.playWhenReady = true
            }
        } else if (once) {
            liveSnapDone.add(key)
        }
    }

    private fun recoverBehindLiveWindow(key: String) {
        val now = android.os.SystemClock.elapsedRealtime()
        val last = lastBehindLiveRecoveryMs[key] ?: 0L
        if (now - last < BEHIND_LIVE_RECOVERY_COOLDOWN_MS) {
            onLoadState(key, MultiPovLoadState.Loading)
            return
        }
        lastBehindLiveRecoveryMs[key] = now
        val p = players[key] ?: return
        p.seekToDefaultPosition()
        p.prepare()
        if (key !in userPaused) p.playWhenReady = true
        onLoadState(key, MultiPovLoadState.Loading)
    }

    private fun kickPlaybackHeaders(): Map<String, String> {
        val headers = linkedMapOf(
            "Origin" to "https://kick.com",
            "Referer" to "https://kick.com/",
            "User-Agent" to "Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36",
            "Accept" to "*/*",
        )
        prefs.getString(AppC.PLAYER_STREAM_HEADERS, null)?.let { raw ->
            runCatching {
                val json = JSONObject(raw)
                json.keys().forEach { key ->
                    val value = json.optString(key)
                    if (key.isNotBlank() && value.isNotBlank()) {
                        headers[key] = value
                    }
                }
            }
        }
        return headers
    }

    private fun reapplyAllTrackConstraints() {
        players.forEach { (key, player) ->
            applyTrackConstraints(player, focused = key == focusedKey, key = key)
        }
    }

    private fun applyTrackConstraints(player: ExoPlayer, focused: Boolean, key: String) {
        val signature = constraintSignature(focused = focused, key = key)
        if (appliedConstraintKeys[key] == signature) return
        appliedConstraintKeys[key] = signature

        val selector = trackSelectors[key] ?: return
        selector.parameters = buildTrackParams(
            base = selector.buildUponParameters(),
            focused = focused,
            key = key,
        )
    }

    private fun constraintSignature(focused: Boolean, key: String): String {
        val maxHeight = maxHeightForSlot(focused = focused)
        val maxBitrate = maxBitrateForHeight(maxHeight)
        return "$focused|$maxHeight|$maxBitrate|${streamQuality.prefValue}|$bandwidthSaving|$adaptiveMaxHeight"
    }

    private fun buildTrackParams(
        base: DefaultTrackSelector.Parameters.Builder,
        focused: Boolean,
        key: String,
    ): DefaultTrackSelector.Parameters {
        val maxHeight = maxHeightForSlot(focused = focused)
        val maxBitrate = maxBitrateForHeight(maxHeight)
        // Secondaries: drop audio entirely (volume 0 still downloaded audio before).
        return base
            .setMaxVideoSize(Int.MAX_VALUE, maxHeight)
            .setMaxVideoBitrate(maxBitrate)
            .setForceHighestSupportedBitrate(false)
            .setAllowVideoMixedMimeTypeAdaptiveness(true)
            .setTrackTypeDisabled(C.TRACK_TYPE_AUDIO, !focused)
            .build()
    }

    /**
     * Default: [streamQuality] for every tile.
     * Bandwidth saving: non-focused forced to 480p; focused keeps [streamQuality].
     * Optional thermal/cellular adaptive cap still applies as a ceiling.
     */
    private fun maxHeightForSlot(focused: Boolean): Int {
        val selected = streamQuality.maxHeight ?: Int.MAX_VALUE
        val height = when {
            bandwidthSaving && !focused -> 480
            else -> selected
        }
        val adaptive = adaptiveMaxHeight
        return if (adaptive != null) minOf(height, adaptive) else height
    }

    private fun maxBitrateForHeight(maxHeight: Int): Int {
        return when {
            maxHeight <= 360 -> 900_000
            maxHeight <= 480 -> 1_800_000
            maxHeight <= 720 -> 3_500_000
            maxHeight <= 1080 -> 6_000_000
            else -> Int.MAX_VALUE
        }
    }

    private fun isBehindLiveWindow(error: PlaybackException): Boolean {
        var cause: Throwable? = error.cause
        while (cause != null) {
            if (cause is BehindLiveWindowException) return true
            cause = cause.cause
        }
        return false
    }

    /** Same shape as [isBehindLiveWindow]: HLS nests the HTTP failure inside a loader error. */
    private fun httpResponseCode(error: PlaybackException): Int? {
        var cause: Throwable? = error
        while (cause != null) {
            if (cause is HttpDataSource.InvalidResponseCodeException) {
                return cause.responseCode
            }
            cause = cause.cause
        }
        return null
    }

    companion object {
        /** Avoid seek→flush storms when several players hit BehindLiveWindow together. */
        private const val BEHIND_LIVE_RECOVERY_COOLDOWN_MS = 5_000L
    }
}
