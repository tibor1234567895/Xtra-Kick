package com.xtrakick.app.ui.player

import com.xtrakick.app.util.AppConstants
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
}
