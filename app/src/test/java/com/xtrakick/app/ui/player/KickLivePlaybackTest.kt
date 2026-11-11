package com.xtrakick.app.ui.player

import com.xtrakick.app.ui.multipov.MultiPovQuality
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
    fun resolveInitialBitrateMatchesAllMultiPovQualities() {
        assertEquals(KickLivePlayback.BITRATE_1080P_60, KickLivePlayback.resolveInitialBitrate(MultiPovQuality.SOURCE.prefValue))
        assertEquals(KickLivePlayback.BITRATE_1080P, KickLivePlayback.resolveInitialBitrate(MultiPovQuality.P1080.prefValue))
        assertEquals(KickLivePlayback.BITRATE_720P, KickLivePlayback.resolveInitialBitrate(MultiPovQuality.P720.prefValue))
        assertEquals(KickLivePlayback.BITRATE_480P, KickLivePlayback.resolveInitialBitrate(MultiPovQuality.P480.prefValue))
        assertEquals(KickLivePlayback.BITRATE_360P, KickLivePlayback.resolveInitialBitrate(MultiPovQuality.P360.prefValue))
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

    @Test
    fun selectAudioSaverPrefers480p() {
        val key = KickLivePlayback.selectAudioSaverKey(
            listOf(
                KickLivePlayback.AudioSaverCandidate("1080p60", 1080, 8_000_000),
                KickLivePlayback.AudioSaverCandidate("720p60", 720, 4_500_000),
                KickLivePlayback.AudioSaverCandidate("480p30", 480, 1_500_000),
                KickLivePlayback.AudioSaverCandidate("360p30", 360, 800_000),
                KickLivePlayback.AudioSaverCandidate("160p30", 160, 350_000),
            )
        )
        assertEquals("480p30", key)
    }

    @Test
    fun selectAudioSaverPicksBest480pVariant() {
        val key = KickLivePlayback.selectAudioSaverKey(
            listOf(
                KickLivePlayback.AudioSaverCandidate("480p30", 480, 1_300_000),
                KickLivePlayback.AudioSaverCandidate("480p30 1.5 Mbps", 480, 1_500_000),
                KickLivePlayback.AudioSaverCandidate("360p30", 360, 700_000),
            )
        )
        assertEquals("480p30 1.5 Mbps", key)
    }

    @Test
    fun selectAudioSaverFallsBackBelow480p() {
        val key = KickLivePlayback.selectAudioSaverKey(
            listOf(
                KickLivePlayback.AudioSaverCandidate("720p60", 720, 4_500_000),
                KickLivePlayback.AudioSaverCandidate("360p30", 360, 800_000),
                KickLivePlayback.AudioSaverCandidate("160p30", 160, 350_000),
            )
        )
        assertEquals("360p30", key)
    }

    @Test
    fun selectAudioSaverReturnsNullWhenEmpty() {
        assertEquals(null, KickLivePlayback.selectAudioSaverKey(emptyList()))
    }

    @Test
    fun minRecoveryBufferMsEnforces1500Floor() {
        assertEquals(1_500L, KickLivePlayback.minRecoveryBufferMs(1_000))
        assertEquals(1_500L, KickLivePlayback.minRecoveryBufferMs(1_500))
        assertEquals(2_000L, KickLivePlayback.minRecoveryBufferMs(2_000))
        assertEquals(1_500L, KickLivePlayback.minRecoveryBufferMs(null))
    }

    @Test
    fun hasSufficientBandwidthRequiresTwentyFivePercentOverhead() {
        val targetBitrate = 8_000_000 // 8 Mbps
        // Needs 10 Mbps (8 * 1.25)
        assertFalse(KickLivePlayback.hasSufficientBandwidth(9_900_000L, targetBitrate))
        assertTrue(KickLivePlayback.hasSufficientBandwidth(10_000_000L, targetBitrate))
        assertTrue(KickLivePlayback.hasSufficientBandwidth(250_000_000L, targetBitrate))

        // Unknown or zero estimate passes
        assertTrue(KickLivePlayback.hasSufficientBandwidth(0L, targetBitrate))
        assertTrue(KickLivePlayback.hasSufficientBandwidth(-1L, targetBitrate))
        assertTrue(KickLivePlayback.hasSufficientBandwidth(5_000_000L, 0))
    }

    @Test
    fun isBufferSafeForDownscaledCatchupRequiresDoubleRebufferAndThreeSecondsFloor() {
        // Balanced (1500ms): 2x = 3000ms
        assertFalse(KickLivePlayback.isBufferSafeForDownscaledCatchup(2_900L, 1_500))
        assertTrue(KickLivePlayback.isBufferSafeForDownscaledCatchup(3_000L, 1_500))

        // Lowest (1000ms): 2x = 2000ms, but floor is 3000ms
        assertFalse(KickLivePlayback.isBufferSafeForDownscaledCatchup(2_500L, 1_000))
        assertTrue(KickLivePlayback.isBufferSafeForDownscaledCatchup(3_000L, 1_000))

        // Stable (2000ms): 2x = 4000ms
        assertFalse(KickLivePlayback.isBufferSafeForDownscaledCatchup(3_500L, 2_000))
        assertTrue(KickLivePlayback.isBufferSafeForDownscaledCatchup(4_000L, 2_000))
    }

    @Test
    fun estimateLiveForwardBufferMsCalculatesHeadroomAboveChunkFloor() {
        // Normal live latency (2280ms) -> 2280 - 1500 = 780ms
        assertEquals(780L, KickLivePlayback.estimateLiveForwardBufferMs(2_280L, 1_500, 15_000))

        // Large drift (5000ms) -> 5000 - 1500 = 3500ms
        assertEquals(3_500L, KickLivePlayback.estimateLiveForwardBufferMs(5_000L, 1_500, 15_000))

        // Close to live edge (< 1500ms) clamps to 0L
        assertEquals(0L, KickLivePlayback.estimateLiveForwardBufferMs(1_400L, 1_500, 15_000))

        // Capped by max buffer
        assertEquals(8_000L, KickLivePlayback.estimateLiveForwardBufferMs(12_000L, 1_500, 8_000))

        // Null or invalid latency falls back to rebufferMs
        assertEquals(1_500L, KickLivePlayback.estimateLiveForwardBufferMs(null, 1_500, 15_000))
        assertEquals(1_500L, KickLivePlayback.estimateLiveForwardBufferMs(-1L, 1_500, 15_000))
    }
}
