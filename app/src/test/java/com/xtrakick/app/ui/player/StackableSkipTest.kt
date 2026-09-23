package com.xtrakick.app.ui.player

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class StackableSkipTest {

    @Test
    fun testSequentialForwardSkipsAccumulateDelta() {
        var state: StackableSkipState? = null
        val basePos = 30_000L // 30s
        val stepMs = 10_000L // 10s

        // Tap 1
        state = calculateStackableSkip(state, basePos, isForward = true, stepMs = stepMs)
        assertNotNull(state)
        assertEquals(30_000L, state!!.basePositionMs)
        assertEquals(10_000L, state.accumulatedDeltaMs)
        assertEquals(40_000L, state.targetPositionClamped(durationMs = 300_000L))

        // Tap 2
        state = calculateStackableSkip(state, basePos, isForward = true, stepMs = stepMs)
        assertNotNull(state)
        assertEquals(30_000L, state!!.basePositionMs)
        assertEquals(20_000L, state.accumulatedDeltaMs)
        assertEquals(50_000L, state.targetPositionClamped(durationMs = 300_000L))

        // Tap 12 (skipping 2 minutes in total)
        for (i in 3..12) {
            state = calculateStackableSkip(state, basePos, isForward = true, stepMs = stepMs)
        }
        assertNotNull(state)
        assertEquals(30_000L, state!!.basePositionMs)
        assertEquals(120_000L, state.accumulatedDeltaMs)
        assertEquals(150_000L, state.targetPositionClamped(durationMs = 300_000L))
    }

    @Test
    fun testSequentialBackwardSkipsAccumulateDelta() {
        var state: StackableSkipState? = null
        val basePos = 60_000L
        val stepMs = 10_000L

        // Tap 1 rewind
        state = calculateStackableSkip(state, basePos, isForward = false, stepMs = stepMs)
        assertNotNull(state)
        assertEquals(60_000L, state!!.basePositionMs)
        assertEquals(-10_000L, state.accumulatedDeltaMs)
        assertEquals(50_000L, state.targetPositionClamped(durationMs = 300_000L))

        // Tap 2 rewind
        state = calculateStackableSkip(state, basePos, isForward = false, stepMs = stepMs)
        assertNotNull(state)
        assertEquals(-20_000L, state!!.accumulatedDeltaMs)
        assertEquals(40_000L, state.targetPositionClamped(durationMs = 300_000L))
    }

    @Test
    fun testReversingDirectionSubtractsAndCancelsWhenZero() {
        var state: StackableSkipState? = null
        val basePos = 50_000L
        val stepMs = 10_000L

        // Forward 2 taps (+20s)
        state = calculateStackableSkip(state, basePos, isForward = true, stepMs = stepMs)
        state = calculateStackableSkip(state, basePos, isForward = true, stepMs = stepMs)
        assertEquals(20_000L, state?.accumulatedDeltaMs)

        // Rewind 1 tap (+10s)
        state = calculateStackableSkip(state, basePos, isForward = false, stepMs = stepMs)
        assertNotNull(state)
        assertEquals(10_000L, state?.accumulatedDeltaMs)

        // Rewind 1 more tap (0s -> cancelled)
        state = calculateStackableSkip(state, basePos, isForward = false, stepMs = stepMs)
        assertNull(state)
    }

    @Test
    fun testTargetPositionClampedAtBoundaries() {
        val durationMs = 100_000L // 100s

        // Near end: 95s + 20s forward -> clamped to 100s
        val stateNearEnd = StackableSkipState(basePositionMs = 95_000L, accumulatedDeltaMs = 20_000L)
        assertEquals(100_000L, stateNearEnd.targetPositionClamped(durationMs))

        // Near start: 5s - 20s rewind -> clamped to 0s
        val stateNearStart = StackableSkipState(basePositionMs = 5_000L, accumulatedDeltaMs = -20_000L)
        assertEquals(0L, stateNearStart.targetPositionClamped(durationMs))
    }

    @Test
    fun testFormatSkipButtonLabels() {
        // Default state (delta = 0): both buttons show default seconds
        assertEquals("10", formatSkipButtonLabel(accumulatedDeltaMs = 0L, defaultSeconds = 10L, isForwardButton = true))
        assertEquals("10", formatSkipButtonLabel(accumulatedDeltaMs = 0L, defaultSeconds = 10L, isForwardButton = false))

        // Forward stacking (+120s): forward button clears internal text, rewind button stays default
        assertEquals("", formatSkipButtonLabel(accumulatedDeltaMs = 120_000L, defaultSeconds = 10L, isForwardButton = true))
        assertEquals("10", formatSkipButtonLabel(accumulatedDeltaMs = 120_000L, defaultSeconds = 10L, isForwardButton = false))

        // Rewind stacking (-30s): rewind button clears internal text, forward button stays default
        assertEquals("", formatSkipButtonLabel(accumulatedDeltaMs = -30_000L, defaultSeconds = 10L, isForwardButton = false))
        assertEquals("10", formatSkipButtonLabel(accumulatedDeltaMs = -30_000L, defaultSeconds = 10L, isForwardButton = true))
    }

    @Test
    fun testFormatSkipBadgeLabels() {
        assertEquals("", formatSkipBadgeLabel(accumulatedDeltaMs = 0L))
        assertEquals("+10s", formatSkipBadgeLabel(accumulatedDeltaMs = 10_000L))
        assertEquals("+120s", formatSkipBadgeLabel(accumulatedDeltaMs = 120_000L))
        assertEquals("+190s", formatSkipBadgeLabel(accumulatedDeltaMs = 190_000L))
        assertEquals("-10s", formatSkipBadgeLabel(accumulatedDeltaMs = -10_000L))
        assertEquals("-30s", formatSkipBadgeLabel(accumulatedDeltaMs = -30_000L))
    }
}
