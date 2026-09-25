package com.xtrakick.app.ui.multipov

import android.animation.ValueAnimator
import android.content.Context
import android.content.SharedPreferences
import android.graphics.SurfaceTexture
import android.net.Uri
import android.view.Surface
import android.view.TextureView
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.content.edit
import androidx.annotation.OptIn
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.common.util.UnstableApi
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.PlayerException
import com.amazonaws.ivs.player.Quality
import com.xtrakick.app.util.AppConstants as AppC

/**
 * IVS-native MultiPOV playback: one Amazon IVS player per slot.
 *
 * Differences vs. the solo player stack:
 * - Networking, buffers, and low-latency edge behavior are owned by the IVS SDK
 *   (low-latency mode on, auto quality) instead of hand-rolled Exo config.
 * - Thumbs quality caps become IVS auto-max-quality ceilings; focused stays auto.
 * - Any IVS playback error is treated as a possibly-stale URL and routed into
 *   the existing 403 re-resolve flow (2 tries, cooldown-aware in the ViewModel).
 * - No DynamicsProcessing compressor in this spike: IVS owns the audio path.
 *   The enabled flag + global pref sync are preserved so solo stays in sync.
 */
@OptIn(UnstableApi::class)
class MultiPovIvsPlaybackController(
    private val context: Context,
    private val prefs: SharedPreferences,
    private val onLoadState: (key: String, state: MultiPovLoadState) -> Unit,
    private val onHttpError: (key: String, responseCode: Int, url: String?) -> Unit = { _, _, _ -> },
) {
    private val players = linkedMapOf<String, Player>()
    private val playerListeners = linkedMapOf<String, Player.Listener>()
    /** TextureView so each tile clips correctly (SurfaceView bleeds across neighbors). */
    private val surfaces = linkedMapOf<String, TextureView>()
    private val aspectFrames = linkedMapOf<String, AspectRatioFrameLayout>()
    private val ivsSurfaces = linkedMapOf<String, Surface>()
    /** Which SurfaceTexture each handed-out Surface was built from. Retained
     * across tile reparents (reorder/layout/immersive) so playback never
     * blanks; only freed when the slot's player/view goes away for good. */
    private val surfaceTextures = linkedMapOf<String, SurfaceTexture>()
    /** Output was nulled while the Surface object itself is still reusable —
     * re-hand it on next attach. */
    private val surfaceNulled = mutableSetOf<String>()
    private val currentUrls = linkedMapOf<String, String>()
    /** Per-stream volume; only the focused tile is audible. */
    private val volumes = linkedMapOf<String, Float>()
    /** User-paused streams — not auto-resumed by ensurePlaying/resume helpers. */
    private val userPaused = mutableSetOf<String>()
    /** Slots that hit an error — not auto-resumed until retry. */
    private val errored = mutableSetOf<String>()
    /** Play requested and not paused (IVS has no playWhenReady flag). */
    private val playRequested = mutableSetOf<String>()
    /** Audio compressor preference per stream (flag only in IVS mode). */
    private val compressorEnabled = mutableMapOf<String, Boolean>()
    /** Quality for all streams (thumbs get capped, focused stays auto). */
    private var streamQuality: MultiPovQuality = MultiPovQuality.SOURCE
    /** Non-focused tiles capped to 480p when true. */
    private var bandwidthSaving: Boolean = false
    private var adaptiveMaxHeight: Int? = null
    private var focusedKey: String? = null
    private var focusAnimator: ValueAnimator? = null
    /** Last applied cap signature per slot — re-applying ceilings on every UI
     * render resets renditions and rebuffers healthy tiles. */
    private val appliedCapKeys = linkedMapOf<String, String>()
    private val defaultVolume: Float
        get() = (prefs.getInt(AppC.PLAYER_VOLUME, 100) / 100f).coerceIn(0f, 1f)

    fun setStreamQuality(quality: MultiPovQuality) {
        if (streamQuality == quality) return
        streamQuality = quality
        reapplyAllQualityCaps()
    }

    fun setBandwidthSaving(enabled: Boolean) {
        if (bandwidthSaving == enabled) return
        bandwidthSaving = enabled
        reapplyAllQualityCaps()
    }

    fun setAdaptiveMaxHeight(maxHeight: Int?) {
        if (adaptiveMaxHeight == maxHeight) return
        adaptiveMaxHeight = maxHeight
        reapplyAllQualityCaps()
    }

    fun setFocus(key: String?, crossfade: Boolean = true) {
        val targetVol = key?.let { volumeFor(it) } ?: defaultVolume
        if (key == focusedKey) {
            key?.let { runIvsOp(it) { p -> p.setVolume(targetVol) } }
            return
        }
        val previous = focusedKey
        focusedKey = key
        // Focus change only: re-cap quality on both sides.
        reapplyAllQualityCaps()
        // Don't seek on focus change — that re-buffers under multi-stream load.
        val shouldCrossfade = crossfade &&
            prefs.getBoolean(AppC.MULTIPOV_AUDIO_CROSSFADE, true) &&
            previous != null &&
            key != null &&
            players.containsKey(previous) &&
            players.containsKey(key)
        if (!shouldCrossfade) {
            focusAnimator?.cancel()
            players.forEach { (slotKey, player) ->
                runCatching { player.setVolume(if (slotKey == focusedKey) volumeFor(slotKey) else 0f) }
            }
            return
        }
        val fromPlayer = players[previous]
        val toPlayer = players[key]
        if (fromPlayer == null || toPlayer == null) {
            players.forEach { (slotKey, player) ->
                runCatching { player.setVolume(if (slotKey == focusedKey) volumeFor(slotKey) else 0f) }
            }
            return
        }
        focusAnimator?.cancel()
        // Live volumes follow an invariant (focused = volumeFor, others = 0),
        // so animate from tracked values instead of reading the player.
        val startFrom = volumeFor(previous)
        val startTo = 0f
        focusAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 180L
            interpolator = DecelerateInterpolator()
            addUpdateListener { anim ->
                val t = anim.animatedValue as Float
                runCatching { fromPlayer.setVolume(startFrom * (1f - t)) }
                runCatching { toPlayer.setVolume(startTo + (targetVol - startTo) * t) }
            }
            doOnEnd {
                players.forEach { (slotKey, player) ->
                    runCatching { player.setVolume(if (slotKey == focusedKey) volumeFor(slotKey) else 0f) }
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
        // Re-arming is cheap; the texture-identity check inside makes repeats no-ops.
        textureView.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
            override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
                attachTextureSurface(key, textureView)
            }

            override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) = Unit

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
                val retain = surfaces[key] === textureView && surfaceTextures[key] === surface
                if (!retain) {
                    detachTextureSurface(key)
                }
                // Retain on reparent (reorder / layout / immersive): the player
                // keeps decoding into the texture, so the tile never blanks.
                return !retain
            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture) = Unit
        }
        if (textureView.isAvailable) {
            attachTextureSurface(key, textureView)
        }
    }

    fun detachSurface(key: String) {
        surfaces.remove(key)
        detachTextureSurface(key)
        // Tile is gone for good: drop refs so the framework releases the
        // texture when the view detaches.
        ivsSurfaces.remove(key)?.let { runCatching { it.release() } }
        surfaceTextures.remove(key)
        surfaceNulled.remove(key)
        aspectFrames.remove(key)
    }

    fun ensurePlaying(key: String, url: String, focused: Boolean) {
        if (url.isBlank()) {
            onLoadState(key, MultiPovLoadState.Error("Missing playback URL"))
            return
        }
        val existing = players[key]
        if (existing != null) {
            if (currentUrls[key] == url) {
                if (focused) focusedKey = key
                if (focusAnimator?.isRunning != true) {
                    runCatching { existing.setVolume(if (focused) volumeFor(key) else 0f) }
                }
                applyQualityCap(existing, focused = focused, key = key)
                if (key !in errored && key !in userPaused) {
                    runCatching { existing.play() }
                    playRequested.add(key)
                }
                return
            }
            releasePlayer(key)
        }
        if (focused) focusedKey = key
        try {
            val player = Player.Factory.create(context.applicationContext).apply {
                setLogLevel(Player.LogLevel.ERROR)
                setLiveLowLatencyEnabled(true)
                setRebufferToLive(false)
                runCatching { setVolume(if (focused) volumeFor(key) else 0f) }
            }
            players[key] = player
            currentUrls[key] = url
            errored.remove(key)
            val listener = object : Player.Listener() {
                override fun onCue(cue: com.amazonaws.ivs.player.Cue) = Unit

                override fun onStateChanged(state: Player.State) {
                    if (players[key] !== player) return
                    when (state) {
                        Player.State.BUFFERING -> onLoadState(key, MultiPovLoadState.Loading)
                        Player.State.READY,
                        Player.State.PLAYING,
                        -> {
                            // SDK resets output volume on (re)start — keep muted tiles muted.
                            onLoadState(key, MultiPovLoadState.Ready)
                            assertFocusVolume(key, player)
                        }
                        Player.State.ENDED -> onLoadState(key, MultiPovLoadState.Offline)
                        else -> Unit
                    }
                }

                override fun onDurationChanged(duration: Long) = Unit

                override fun onRebuffering() {
                    if (players[key] !== player) return
                    onLoadState(key, MultiPovLoadState.Loading)
                }

                override fun onError(exception: PlayerException) {
                    if (players[key] !== player) return
                    // Don't fight an actively playing picture over a transient SDK error.
                    if (runCatching { player.state == Player.State.PLAYING }.getOrDefault(false)) return
                    errored.add(key)
                    playRequested.remove(key)
                    // Never show raw SDK payloads (JSON blobs, signed URLs) on the tile.
                    onLoadState(key, MultiPovLoadState.Error(friendlyErrorMessage(exception.errorMessage)))
                    // Route into the existing stale-URL re-resolve flow (2 tries, cooldown).
                    onHttpError(key, 403, currentUrls[key] ?: url)
                }

                override fun onSeekCompleted(position: Long) = Unit

                override fun onVideoSizeChanged(width: Int, height: Int) {
                    if (players[key] !== player) return
                    if (width > 0 && height > 0) {
                        aspectFrames[key]?.setAspectRatio(width.toFloat() / height.toFloat())
                    }
                }

                override fun onQualityChanged(quality: Quality) {
                    if (players[key] !== player) return
                    // Ladder arrived after load — thumbs caps can now apply.
                    applyQualityCap(player, focused = key == focusedKey, key = key)
                    assertFocusVolume(key, player)
                }
            }
            player.addListener(listener)
            playerListeners[key] = listener
            // First apply seeds the signature (or waits for the ladder).
            applyQualityCap(player, focused = focused, key = key)
            surfaces[key]?.let { attachTextureSurface(key, it) }
            onLoadState(key, MultiPovLoadState.Loading)
            if (key !in userPaused) {
                runCatching { player.load(Uri.parse(url)) }
                runCatching { player.play() }
                playRequested.add(key)
            } else {
                runCatching { player.load(Uri.parse(url)) }
            }
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
        errored.remove(key)
        releasePlayer(key)
        surfaces[key]?.let { attachSurface(key, it, aspectFrames[key]) }
        ensurePlaying(key, url, focused)
    }

    fun isPlaying(key: String?): Boolean {
        if (key == null) return false
        val player = players[key] ?: return false
        if (key in userPaused || key in errored) return false
        val state = runCatching { player.state }.getOrNull() ?: return false
        return state == Player.State.PLAYING ||
            (state == Player.State.BUFFERING && key in playRequested)
    }

    fun togglePlayPause(key: String?): Boolean {
        if (key == null) return false
        val player = players[key] ?: return false
        return if (key in userPaused || key !in playRequested) {
            userPaused.remove(key)
            errored.remove(key)
            runCatching { player.play() }
            playRequested.add(key)
            true
        } else {
            userPaused.add(key)
            playRequested.remove(key)
            runCatching { player.pause() }
            false
        }
    }

    fun setPaused(key: String?, paused: Boolean) {
        if (key == null) return
        val player = players[key] ?: return
        if (paused) {
            userPaused.add(key)
            playRequested.remove(key)
            runCatching { player.pause() }
        } else {
            userPaused.remove(key)
            errored.remove(key)
            runCatching { player.play() }
            playRequested.add(key)
        }
    }

    fun volumeFor(key: String): Float = volumes[key] ?: defaultVolume

    fun setVolume(key: String?, volume: Float) {
        if (key == null) return
        val v = volume.coerceIn(0f, 1f)
        volumes[key] = v
        if (key == focusedKey) {
            players[key]?.let { runCatching { it.setVolume(v) } }
        }
    }

    fun seekToLive(key: String?) {
        val player = key?.let { players[it] } ?: return
        runCatching {
            player.setRebufferToLive(true)
            val duration = player.duration
            if (duration > 0L) {
                player.seekTo(duration)
            } else {
                currentUrls[key]?.let { player.load(Uri.parse(it)) }
            }
            if (key !in userPaused) {
                player.play()
                playRequested.add(key)
            }
            errored.remove(key)
        }
    }

    fun getLiveOffsetMs(key: String?): Long? {
        val player = key?.let { players[it] } ?: return null
        val offset = runCatching { player.liveLatency }.getOrNull() ?: return null
        return if (offset > 0L) offset else null
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
        // Keep global pref in sync with the focused stream's choice (matches solo player).
        if (key == focusedKey) {
            prefs.edit { putBoolean(AppC.PLAYER_AUDIO_COMPRESSOR, next) }
        }
        return next
    }

    fun pauseSecondaries() {
        players.forEach { (key, player) ->
            if (key != focusedKey) {
                playRequested.remove(key)
                runCatching { player.pause() }
            }
        }
    }

    fun resumeSecondaries() {
        players.forEach { (key, player) ->
            if (key != focusedKey && key !in errored && key !in userPaused) {
                runCatching { player.play() }
                playRequested.add(key)
            }
        }
    }

    fun pauseAll() {
        playRequested.clear()
        players.values.forEach { runCatching { it.pause() } }
    }

    fun resumeAll() {
        players.forEach { (key, player) ->
            if (key !in errored && key !in userPaused) {
                runCatching { player.play() }
                playRequested.add(key)
            }
        }
    }

    fun releasePlayer(key: String) {
        playerListeners.remove(key)
        detachTextureSurface(key)
        surfaceNulled.remove(key)
        players.remove(key)?.let { player ->
            runCatching { player.setSurface(null) }
            // Release off the main thread; IVS release can block briefly.
            Thread({ runCatching { player.release() } }, "MultiPovIvsRelease").start()
        }
        ivsSurfaces.remove(key)?.let { runCatching { it.release() } }
        surfaceTextures.remove(key)?.let { texture ->
            // Retained textures are ours to free, but never under a live attached
            // view — that one releases via the framework path at next detach.
            val view = surfaces[key]
            if (view == null || !view.isAttachedToWindow) {
                runCatching { texture.release() }
            }
        }
        currentUrls.remove(key)
        playRequested.remove(key)
        appliedCapKeys.remove(key)
        // Keep volumes / pause / compressor prefs for the slot if re-added later this session.
        if (focusedKey == key) {
            focusedKey = null
        }
        reapplyAllQualityCaps()
    }

    fun releaseAll() {
        focusAnimator?.cancel()
        focusAnimator = null
        players.keys.toList().forEach { releasePlayer(it) }
        playerListeners.clear()
        surfaces.clear()
        aspectFrames.clear()
        ivsSurfaces.values.forEach { runCatching { it.release() } }
        ivsSurfaces.clear()
        surfaceTextures.clear()
        surfaceNulled.clear()
        currentUrls.clear()
        playRequested.clear()
        appliedCapKeys.clear()
        volumes.clear()
        userPaused.clear()
        errored.clear()
        compressorEnabled.clear()
        focusedKey = null
    }

    private fun runIvsOp(key: String, block: (Player) -> Unit) {
        try {
            players[key]?.let(block)
        } catch (_: Exception) {
        }
    }

    /** Focus invariant: focused tile at its volume, everything else silent.
     * Re-asserted on player events because the SDK resets volume on
     * (re)starts and rendition switches. */
    private fun assertFocusVolume(key: String, player: Player) {
        // Don't fight an in-flight crossfade — its doOnEnd re-asserts for all.
        if (focusAnimator?.isRunning == true) return
        runCatching { player.setVolume(if (key == focusedKey) volumeFor(key) else 0f) }
    }

    /**
     * Tile-safe error text: the SDK sometimes embeds JSON payloads and signed
     * URLs in its message. Show a short human line, never the raw blob.
     */
    private fun friendlyErrorMessage(raw: String): String {
        val trimmed = raw.trimStart()
        if (raw.contains("invalid_playsegments")) return "Stream unavailable right now"
        if (trimmed.startsWith("[{") || trimmed.startsWith("{")) return "Couldn't load this stream"
        val firstLine = raw.lineSequence().firstOrNull().orEmpty()
        // Strip embedded URLs (signed tokens must never reach the screen).
        val withoutUrls = firstLine.replace(Regex("https?://\\S+|/api/\\S+"), "").trim()
        return withoutUrls.take(120).ifBlank { "Couldn't load this stream" }
    }

    private fun attachTextureSurface(key: String, textureView: TextureView) {
        val player = players[key] ?: return
        val surfaceTexture = textureView.surfaceTexture ?: return
        val retained = surfaceTextures[key]
        if (retained != null && retained !== surfaceTexture) {
            // Reparent re-attach: the retained texture is still live — swap it
            // back over the empty framework-created one.
            if (runCatching { textureView.setSurfaceTexture(retained) }.isSuccess) {
                runCatching { surfaceTexture.release() }
                surfaceNulled.remove(key)
                return
            }
            // Swap refused: fall through and wire the fresh texture like new.
        }
        if (ivsSurfaces.containsKey(key) && surfaceTextures[key] === surfaceTexture) {
            if (surfaceNulled.remove(key)) {
                // Output was nulled: re-hand the same Surface; playback state untouched.
                ivsSurfaces[key]?.let { surface -> runCatching { player.setSurface(surface) } }
            }
            return
        }
        detachTextureSurface(key)
        // Superseded by a new texture: drop the old Surface object outright.
        ivsSurfaces.remove(key)?.let { runCatching { it.release() } }
        surfaceTextures.remove(key)
        surfaceNulled.remove(key)
        try {
            val surface = Surface(surfaceTexture)
            ivsSurfaces[key] = surface
            surfaceTextures[key] = surfaceTexture
            player.setSurface(surface)
        } catch (_: Exception) {
        }
    }

    private fun detachTextureSurface(key: String) {
        players[key]?.let { player ->
            runCatching { player.setSurface(null) }
        }
        // Keep the Surface object: it may still be reusable. Superseded/released
        // entries are dropped by the swap path, detachSurface and releasePlayer.
        if (ivsSurfaces.containsKey(key)) surfaceNulled.add(key)
    }

    private fun reapplyAllQualityCaps() {
        players.forEach { (key, player) ->
            applyQualityCap(player, focused = key == focusedKey, key = key)
        }
    }

    private fun applyQualityCap(player: Player, focused: Boolean, key: String? = null) {
        val capHeight = capHeightForSlot(focused = focused) ?: run {
            // Focused (or source selected): full auto ladder, no ceiling.
            if (key != null) {
                val signature = "auto|$focused"
                if (appliedCapKeys[key] == signature) return
                appliedCapKeys[key] = signature
            }
            runCatching {
                player.setAutoQualityMode(true)
                player.setAutoMaxQuality(null)
            }
            return
        }
        val ladder = runCatching { player.qualities }.getOrNull().orEmpty()
        if (ladder.isEmpty()) return // applied later from onQualityChanged
        val ceiling = ladder
            .filter { it.height in 1..capHeight }
            .maxWithOrNull(compareBy({ it.height }, { it.bitrate }))
            ?: ladder.minWithOrNull(compareBy({ it.height }, { it.bitrate }))
            ?: return
        if (key != null) {
            val signature = "cap|$focused|$capHeight|${ceiling.height}|${ceiling.bitrate}"
            if (appliedCapKeys[key] == signature) return
            appliedCapKeys[key] = signature
        }
        runCatching {
            player.setAutoQualityMode(true)
            player.setAutoMaxQuality(ceiling)
        }
    }

    /**
     * Default: [streamQuality] ceiling for every tile.
     * Bandwidth saving: non-focused capped to 480p; focused keeps [streamQuality].
     * Optional thermal/cellular adaptive cap still applies as a ceiling.
     */
    private fun capHeightForSlot(focused: Boolean): Int? {
        val selected = streamQuality.maxHeight
        if (focused && selected == null) return null
        val height = when {
            bandwidthSaving && !focused -> 480
            else -> selected ?: return null
        }
        val adaptive = adaptiveMaxHeight
        return if (adaptive != null) minOf(height, adaptive) else height
    }
}
