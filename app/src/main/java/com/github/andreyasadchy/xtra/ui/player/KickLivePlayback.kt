package com.github.andreyasadchy.xtra.ui.player

import com.amazonaws.ivs.player.Quality
import com.github.andreyasadchy.xtra.util.C
import kotlin.math.roundToInt

object KickLivePlayback {
    const val ENGINE_EXO_ONLY = "exo_only"
    const val ENGINE_IVS = "ivs_kick_live"

    fun shouldUseIvs(streamSource: String?, enginePreference: String?, forceStandardEngine: Boolean): Boolean {
        return !forceStandardEngine &&
                streamSource.equals(C.KICK, true) &&
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

    fun qualityLabel(quality: Quality): String {
        val key = qualityKey(quality)
        val bitrate = quality.bitrate.takeIf { it > 0 }?.let { " ${(it / 1_000_000f).let { mbps -> "%.1f".format(mbps) }} Mbps" } ?: ""
        return "$key$bitrate".trim()
    }
}
