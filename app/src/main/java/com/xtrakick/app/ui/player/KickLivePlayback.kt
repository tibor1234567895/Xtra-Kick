package com.xtrakick.app.ui.player

import com.amazonaws.ivs.player.Quality
import com.xtrakick.app.util.AppConstants
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.roundToInt

object KickLivePlayback {
    const val ENGINE_EXO_ONLY = "exo_only"
    const val ENGINE_IVS = "ivs_kick_live"

    fun shouldUseIvs(streamSource: String?, enginePreference: String?, forceStandardEngine: Boolean): Boolean {
        return !forceStandardEngine &&
                streamSource.equals(AppConstants.KICK, true) &&
                enginePreference == ENGINE_IVS
    }

    fun qualityKey(quality: Quality): String {
        val height = quality.height
        val frameRate = quality.framerate.roundToInt().takeIf { it > 0 }
        return when {
            height > 0 && frameRate != null -> "${height}p$frameRate"
            height > 0 -> "${height}p"
            !quality.name.isNullOrBlank() -> quality.name
            else -> quality.toString()
        }
    }

    fun bitrateLabel(quality: Quality): String? {
        return quality.bitrate.takeIf { it > 0 }?.let { bitrate ->
            "${(bitrate / 1_000_000f).let { mbps -> "%.1f".format(mbps) }} Mbps"
        }
    }

    fun qualityLabel(quality: Quality): String {
        val key = qualityKey(quality)
        val bitrate = bitrateLabel(quality)?.let { " $it" } ?: ""
        return "$key$bitrate".trim()
    }

    data class AudioSaverCandidate(val key: String, val height: Int, val bitrate: Int)

    /**
     * Audio-saver ceiling: 480p keeps source audio on STANDARD ladders (360p drops
     * to 64 kbps, 160p to 48 kbps). Falls back to highest below 480p, else lowest.
     */
    fun selectAudioSaverKey(candidates: List<AudioSaverCandidate>): String? {
        if (candidates.isEmpty()) return null
        candidates.filter { it.height == 480 }.maxByOrNull { it.bitrate }?.let { return it.key }
        candidates.filter { it.height in 1..479 }
            .sortedWith(compareByDescending<AudioSaverCandidate> { it.height }.thenByDescending { it.bitrate })
            .firstOrNull()?.let { return it.key }
        return candidates.sortedWith(compareBy<AudioSaverCandidate> { it.height }.thenBy { it.bitrate }).first().key
    }

    const val BITRATE_1080P_60 = 8_000_000
    const val BITRATE_1080P = 6_000_000
    const val BITRATE_720P_60 = 4_500_000
    const val BITRATE_720P = 3_000_000
    const val BITRATE_480P = 1_500_000
    const val BITRATE_360P = 800_000
    const val BITRATE_160P = 350_000

    private val observedBitrates = ConcurrentHashMap<String, Int>()

    fun recordBitrate(qualityKey: String, bitrate: Int) {
        if (bitrate > 0 && qualityKey.isNotBlank()) {
            observedBitrates[qualityKey.trim().lowercase()] = bitrate
        }
    }

    /**
     * Resolves an initial starting bitrate (bps) for adaptive mode startup hint.
     * Prevents IVS Player from defaulting to the lowest rendition ladder (e.g. 480p)
     * during the initial 2-3s before bandwidth estimation settles.
     */
    fun resolveInitialBitrate(qualityKey: String?): Int {
        val cleanKey = qualityKey?.trim()?.lowercase() ?: return BITRATE_1080P_60
        observedBitrates[cleanKey]?.let { return it }

        return when {
            cleanKey.contains("source") || cleanKey.startsWith("1080p60") -> BITRATE_1080P_60
            cleanKey.startsWith("1080") -> BITRATE_1080P
            cleanKey.startsWith("720p60") -> BITRATE_720P_60
            cleanKey.startsWith("720") -> BITRATE_720P
            cleanKey.startsWith("480") -> BITRATE_480P
            cleanKey.startsWith("360") -> BITRATE_360P
            cleanKey.startsWith("160") -> BITRATE_160P
            cleanKey == "auto" -> BITRATE_1080P_60
            else -> BITRATE_1080P_60
        }
    }

    /**
     * Minimum forward buffer required to safely trigger an adaptive step-up to target quality.
     * Tied to the user's active rebuffer threshold (min 1,500ms).
     */
    fun minRecoveryBufferMs(rebufferMs: Int?): Long {
        return (rebufferMs?.toLong() ?: 1_500L).coerceAtLeast(1_500L)
    }

    /**
     * Checks if current bandwidth estimate exceeds the target rendition's bitrate with
     * a 25% safety overhead (e.g. 10 Mbps for an 8 Mbps stream).
     */
    fun hasSufficientBandwidth(bandwidthEstimateBps: Long, targetBitrateBps: Int): Boolean {
        if (bandwidthEstimateBps <= 0L || targetBitrateBps <= 0) return true
        return bandwidthEstimateBps >= (targetBitrateBps * 1.25).toLong()
    }

    /**
     * Determines if forward buffer is deep enough (at least 2x rebuffer threshold, min 3,000ms)
     * to safely allow latency catch-up acceleration even while downscaled.
     */
    fun isBufferSafeForDownscaledCatchup(forwardBufferMs: Long, rebufferMs: Int?): Boolean {
        val safeThreshold = ((rebufferMs ?: 1_500) * 2L).coerceAtLeast(3_000L)
        return forwardBufferMs >= safeThreshold
    }

    /**
     * Kick AWS IVS HLS chunks are delivered in ~1.5s–2.0s GOP segments.
     * The newest playable frame on the CDN is roughly 1.5s behind real-time broadcasting.
     */
    const val KICK_LIVE_EDGE_FLOOR_MS = 1_500L

    /**
     * Estimates the forward buffer for an unseeked live stream where position is 0.
     * Buffer ahead of playhead is the distance between playhead latency and the chunk generation edge.
     */
    fun estimateLiveForwardBufferMs(
        latencyMs: Long?,
        rebufferMs: Int,
        maxBufferMs: Int
    ): Long {
        if (latencyMs == null || latencyMs <= 0L) {
            return rebufferMs.toLong()
        }
        return (latencyMs - KICK_LIVE_EDGE_FLOOR_MS).coerceIn(0L, maxBufferMs.toLong())
    }

    @androidx.annotation.VisibleForTesting
    fun clearBitrateCache() {
        observedBitrates.clear()
    }
}
