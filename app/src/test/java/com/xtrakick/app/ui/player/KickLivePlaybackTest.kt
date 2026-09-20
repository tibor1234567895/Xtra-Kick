package com.xtrakick.app.ui.player

import com.xtrakick.app.util.AppConstants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KickLivePlaybackTest {

    @Test
    fun shouldUseIvsOnlyForKickWhenEnabled() {
        assertTrue(
            KickLivePlayback.shouldUseIvs(
                streamSource = AppConstants.KICK,
                enginePreference = KickLivePlayback.ENGINE_IVS,
                forceStandardEngine = false
            )
        )
        assertFalse(
            KickLivePlayback.shouldUseIvs(
                streamSource = AppConstants.KICK,
                enginePreference = KickLivePlayback.ENGINE_EXO_ONLY,
                forceStandardEngine = false
            )
        )
        assertFalse(
            KickLivePlayback.shouldUseIvs(
                streamSource = null,
                enginePreference = KickLivePlayback.ENGINE_IVS,
                forceStandardEngine = false
            )
        )
    }

    @Test
    fun shouldUseIvsHonorsSessionFallbackFlag() {
        assertFalse(
            KickLivePlayback.shouldUseIvs(
                streamSource = AppConstants.KICK,
                enginePreference = KickLivePlayback.ENGINE_IVS,
                forceStandardEngine = true
            )
        )
    }

    @Test
    fun resolveInitialBitrateDefaultsToHighFor1080pAndSource() {
        assertEquals(KickLivePlayback.BITRATE_1080P_60, KickLivePlayback.resolveInitialBitrate("1080p60"))
        assertEquals(KickLivePlayback.BITRATE_1080P_60, KickLivePlayback.resolveInitialBitrate("Source"))
        assertEquals(KickLivePlayback.BITRATE_1080P_60, KickLivePlayback.resolveInitialBitrate("auto"))
        assertEquals(KickLivePlayback.BITRATE_1080P_60, KickLivePlayback.resolveInitialBitrate(null))
        assertEquals(KickLivePlayback.BITRATE_1080P, KickLivePlayback.resolveInitialBitrate("1080p30"))
    }

    @Test
    fun resolveInitialBitrateResolvesLowerResolutions() {
        assertEquals(KickLivePlayback.BITRATE_720P_60, KickLivePlayback.resolveInitialBitrate("720p60"))
        assertEquals(KickLivePlayback.BITRATE_720P, KickLivePlayback.resolveInitialBitrate("720p30"))
        assertEquals(KickLivePlayback.BITRATE_480P, KickLivePlayback.resolveInitialBitrate("480p30"))
        assertEquals(KickLivePlayback.BITRATE_360P, KickLivePlayback.resolveInitialBitrate("360p"))
        assertEquals(KickLivePlayback.BITRATE_160P, KickLivePlayback.resolveInitialBitrate("160p"))
    }

    @Test
    fun recordBitrateOverridesStaticDefaults() {
        KickLivePlayback.clearBitrateCache()
        try {
            KickLivePlayback.recordBitrate("1080p60", 8_500_000)
            assertEquals(8_500_000, KickLivePlayback.resolveInitialBitrate("1080p60"))

            KickLivePlayback.recordBitrate("720p60", 3_800_000)
            assertEquals(3_800_000, KickLivePlayback.resolveInitialBitrate("720p60"))
        } finally {
            KickLivePlayback.clearBitrateCache()
        }
    }
}
