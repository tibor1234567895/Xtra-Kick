package com.xtrakick.app.ui.player

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RebufferCircuitBreakerTest {

    @Test
    fun doesNotTriggerBelowThreshold() {
        val breaker = RebufferCircuitBreaker(windowMs = 60_000L, threshold = 3, cooldownMs = 90_000L)
        assertFalse(breaker.record(0L))
        assertFalse(breaker.record(10_000L))
    }

    @Test
    fun triggersOnClusterWithinWindow() {
        val breaker = RebufferCircuitBreaker(windowMs = 60_000L, threshold = 3, cooldownMs = 90_000L)
        assertFalse(breaker.record(0L))
        assertFalse(breaker.record(10_000L))
        assertTrue(breaker.record(20_000L))
    }

    @Test
    fun ignoresStallsSpreadBeyondWindow() {
        val breaker = RebufferCircuitBreaker(windowMs = 60_000L, threshold = 3, cooldownMs = 90_000L)
        assertFalse(breaker.record(0L))
        assertFalse(breaker.record(61_000L))
        assertFalse(breaker.record(122_000L))
    }

    @Test
    fun suppressesRetriggerDuringCooldown() {
        val breaker = RebufferCircuitBreaker(windowMs = 60_000L, threshold = 3, cooldownMs = 90_000L)
        breaker.record(0L)
        breaker.record(10_000L)
        assertTrue(breaker.record(20_000L))
        // Still clustered, but inside the cooldown after the first trigger.
        assertFalse(breaker.record(30_000L))
        assertFalse(breaker.record(40_000L))
    }

    @Test
    fun triggersAgainAfterCooldownWithFreshCluster() {
        val breaker = RebufferCircuitBreaker(windowMs = 60_000L, threshold = 3, cooldownMs = 90_000L)
        breaker.record(0L)
        breaker.record(10_000L)
        assertTrue(breaker.record(20_000L))
        assertFalse(breaker.record(200_000L))
        assertFalse(breaker.record(210_000L))
        assertTrue(breaker.record(220_000L))
    }

    @Test
    fun resetClearsHistory() {
        val breaker = RebufferCircuitBreaker(windowMs = 60_000L, threshold = 3, cooldownMs = 90_000L)
        breaker.record(0L)
        breaker.record(10_000L)
        breaker.reset()
        assertFalse(breaker.record(20_000L))
        assertFalse(breaker.record(30_000L))
    }
}
