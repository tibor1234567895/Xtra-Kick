package com.xtrakick.app.ui.player

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AudioTransitionWatchdogTest {
    @Test
    fun firesOnceAfterGraceAndAnUnchangedPosition() {
        val watchdog = AudioTransitionWatchdog()
        watchdog.arm(nowMs = 0L)
        assertFalse(watchdog.onPosition(100L, 9_999L))
        assertFalse(watchdog.onPosition(100L, 10_000L))
        assertFalse(watchdog.onPosition(100L, 24_999L))
        assertTrue(watchdog.onPosition(100L, 25_000L))
        assertFalse(watchdog.isArmed())
        assertFalse(watchdog.onPosition(100L, 40_000L))
    }

    @Test
    fun bufferingClearsObservationWithoutDisarmingTransition() {
        val watchdog = AudioTransitionWatchdog(gracePeriodMs = 0L)
        watchdog.arm(nowMs = 0L)
        assertFalse(watchdog.onPosition(100L, 0L))
        watchdog.resetObservation()
        assertTrue(watchdog.isArmed())
        assertFalse(watchdog.onPosition(100L, 20_000L))
        assertFalse(watchdog.onPosition(100L, 34_999L))
        assertTrue(watchdog.onPosition(100L, 35_000L))
    }

    @Test
    fun progressAndUnavailableSamplesRestartTheStallWindow() {
        val watchdog = AudioTransitionWatchdog(gracePeriodMs = 0L)
        watchdog.arm(nowMs = 0L)
        assertFalse(watchdog.onPosition(0L, 0L))
        assertFalse(watchdog.onPosition(100L, 14_999L))
        assertFalse(watchdog.onPosition(-1L, 20_000L))
        assertFalse(watchdog.onPosition(100L, 35_000L))
        assertTrue(watchdog.onPosition(100L, 50_000L))
    }

    @Test
    fun switchingBackToVideoDisarmsTheWatchdog() {
        val watchdog = AudioTransitionWatchdog(gracePeriodMs = 0L)
        watchdog.arm(nowMs = 0L)
        assertFalse(watchdog.onPosition(100L, 0L))
        watchdog.disarm()
        assertFalse(watchdog.isArmed())
        assertFalse(watchdog.onPosition(100L, 30_000L))
    }
}
