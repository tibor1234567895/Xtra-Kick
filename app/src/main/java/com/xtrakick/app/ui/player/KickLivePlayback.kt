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

    @androidx.annotation.VisibleForTesting
    fun clearBitrateCache() {
        observedBitrates.clear()
    }
}
