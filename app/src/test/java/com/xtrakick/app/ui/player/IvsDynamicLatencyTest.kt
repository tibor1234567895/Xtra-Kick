package com.xtrakick.app.ui.player

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class IvsDynamicLatencyTest {

    private val targetOffsetMs = 850L // Lowest latency preset target
    private val healthyBufferMs = 1500L // Safe forward buffer

    @Test
    fun returnsNullWhenForwardBufferIsBelowSafeThreshold() {
        val speed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 2500L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = 500L, // below 750ms threshold
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = false
        )

        assertNull("Catch-up should be blocked when forward buffer is below 750ms", speed)
    }

    @Test
    fun returnsNullWhenInPostRebufferGracePeriod() {
        val speed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 3000L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = true, // in 5s grace period
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = false
        )

        assertNull("Catch-up should be blocked during the post-rebuffer grace period", speed)
    }

    @Test
    fun returnsNullWhenLatencyIsWithinDriftThresholdAndNotCatchingUp() {
        // Drift threshold is target (850) + 500 = 1350ms
        val speed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 1200L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = false
        )

        assertNull("Catch-up should not engage for minor drift within 500ms threshold", speed)
    }

    @Test
    fun engagesWithGentleSpeedForModerateDrift() {
        // Latency 1450ms -> drift = 600ms
        val speed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 1450L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = false
        )

        assertNotNull(speed)
        assertEquals(1.09f, speed!!, 0.001f)
    }

    @Test
    fun scalesProportionallyWithDriftAndRespectsMaxSpeedLimit() {
        // Latency 2850ms -> drift = 2000ms: 1.04 + (2000/1500 * 0.12) = 1.04 + 0.16 = 1.20, capped at maxSpeedLimit 1.15
        val moderateSpeed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 2850L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = true
        )
        assertNotNull(moderateSpeed)
        assertEquals(1.15f, moderateSpeed!!, 0.001f)

        // Latency 10000ms -> drift = 9150ms, should cap at maxSpeedLimit
        val cappedSpeed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 10000L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = false,
            maxSpeedLimit = 1.12f,
            isCurrentlyCatchingUp = true
        )
        assertNotNull(cappedSpeed)
        assertEquals(1.12f, cappedSpeed!!, 0.001f)
    }

    @Test
    fun maintainsHysteresisUntilTargetMarginIsReached() {
        // Target margin is 850 + 150 = 1000ms
        // While already catching up, latency of 1100ms should still return a catch-up speed
        val stillCatchingUp = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 1100L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = true
        )
        assertNotNull("Should continue catching up until target margin is reached", stillCatchingUp)

        // When latency drops to 950ms (<= 1000ms), it should return null to reset speed to 1.0x
        val targetReached = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 950L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = healthyBufferMs,
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = true
        )
        assertNull("Should reset to normal speed once target margin is reached", targetReached)
    }

    @Test
    fun dropsCatchupImmediatelyIfForwardBufferDepletesMidCatchup() {
        val speed = LiveLatencySettings.calculateIvsCatchupSpeed(
            latencyMs = 3000L,
            targetOffsetMs = targetOffsetMs,
            forwardBufferMs = 400L, // dropped mid-catchup
            isInGracePeriod = false,
            maxSpeedLimit = 1.15f,
            isCurrentlyCatchingUp = true
        )

        assertNull("Catch-up must immediately disengage if forward buffer dips below safe threshold", speed)
    }
}
