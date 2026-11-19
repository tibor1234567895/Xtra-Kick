package com.xtrakick.app.util.chat

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StvCdnHealthTest {

    private var nowMs = 0L

    private fun health() = StvCdnHealth(nowMs = { nowMs })

    private fun record(h: StvCdnHealth, successes: Int, failures: Int) {
        repeat(successes) { h.record(true) }
        repeat(failures) { h.record(false) }
    }

    @Test
    fun `not degraded below the minimum sample count`() {
        val h = health()
        record(h, successes = 3, failures = 4)
        assertFalse(h.degraded)
    }

    @Test
    fun `degrades after a burst of failures`() {
        val h = health()
        record(h, successes = 0, failures = 10)
        assertTrue(h.degraded)
    }

    @Test
    fun `stays healthy when failures stay below the ratio`() {
        val h = health()
        record(h, successes = 20, failures = 4)
        assertFalse(h.degraded)
    }

    @Test
    fun `degrades when failures cross the ratio in the rolling window`() {
        val h = health()
        record(h, successes = 14, failures = 10)
        assertTrue(h.degraded)
    }

    @Test
    fun `recovers after a streak of consecutive successes`() {
        val h = health()
        record(h, successes = 0, failures = 10)
        assertTrue(h.degraded)
        record(h, successes = 5, failures = 0)
        assertFalse(h.degraded)
    }

    @Test
    fun `a single success does not flip the degraded state`() {
        val h = health()
        record(h, successes = 0, failures = 10)
        h.record(true)
        assertTrue(h.degraded)
    }

    @Test
    fun `samples expire after the ttl of silence`() {
        val h = health()
        record(h, successes = 0, failures = 10)
        assertTrue(h.degraded)
        nowMs += 6 * 60 * 1000L
        assertFalse(h.degraded)
    }

    @Test
    fun `new samples after silence start with the full dispatcher limit`() {
        val h = health()
        val dispatcher = h.createDispatcher()
        record(h, successes = 0, failures = 10)
        assertEquals(5, dispatcher.maxRequestsPerHost)
        nowMs += 6 * 60 * 1000L
        h.record(false)
        assertFalse(h.degraded)
        assertEquals(20, dispatcher.maxRequestsPerHost)
    }

    @Test
    fun `recovery restores the dispatcher limit on the fifth success`() {
        val h = health()
        val dispatcher = h.createDispatcher()
        record(h, successes = 0, failures = 10)
        record(h, successes = 4, failures = 0)
        assertEquals(5, dispatcher.maxRequestsPerHost)
        h.record(true)
        assertEquals(20, dispatcher.maxRequestsPerHost)
    }

    @Test
    fun `window keeps the most recent samples`() {
        val h = health()
        record(h, successes = 18, failures = 0)
        assertFalse(h.degraded)
        // Oldest successes fall out of the 24-slot window one by one as failures arrive;
        // at 24 slots the degraded ratio needs 8 failures, so 8 new failures must flip it.
        repeat(8) { h.record(false) }
        assertTrue(h.degraded)
    }
}
