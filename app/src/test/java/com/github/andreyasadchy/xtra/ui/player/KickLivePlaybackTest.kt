package com.github.andreyasadchy.xtra.ui.player

import com.github.andreyasadchy.xtra.util.C
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KickLivePlaybackTest {

    @Test
    fun shouldUseIvsOnlyForKickWhenEnabled() {
        assertTrue(
            KickLivePlayback.shouldUseIvs(
                streamSource = C.KICK,
                enginePreference = KickLivePlayback.ENGINE_IVS,
                forceStandardEngine = false
            )
        )
        assertFalse(
            KickLivePlayback.shouldUseIvs(
                streamSource = C.KICK,
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
                streamSource = C.KICK,
                enginePreference = KickLivePlayback.ENGINE_IVS,
                forceStandardEngine = true
            )
        )
    }
}
