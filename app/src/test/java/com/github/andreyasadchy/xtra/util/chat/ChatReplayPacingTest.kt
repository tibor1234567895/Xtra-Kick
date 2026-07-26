package com.github.andreyasadchy.xtra.util.chat

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatReplayPacingTest {

    /**
     * Walks a bucket the way the replay loop does: emit at the current stagger, then advance using
     * the count of messages still queued for the bucket including the one just emitted.
     */
    private fun emissionOffsets(bucketSize: Int): List<Long> {
        val offsets = mutableListOf<Long>()
        var stagger = 0L
        for (index in 0 until bucketSize) {
            val emitted = ChatReplayPacing.staggerForEmission(stagger)
            offsets += emitted
            stagger = ChatReplayPacing.advanceStagger(emitted, bucketSize - index)
        }
        return offsets
    }

    @Test
    fun evenBucketIsSpreadEvenlyAcrossTheWindow() {
        assertEquals(listOf(0L, 250L, 500L, 750L), emissionOffsets(4))
    }

    @Test
    fun singleMessageBucketFiresOnTheSecondBoundary() {
        // A quiet second must not be delayed at all.
        assertEquals(listOf(0L), emissionOffsets(1))
    }

    @Test
    fun everyEmissionStaysInsideItsOwnBucket() {
        for (bucketSize in 1..80) {
            val offsets = emissionOffsets(bucketSize)
            assertEquals(bucketSize, offsets.size)
            assertTrue(
                "bucket of $bucketSize produced $offsets",
                offsets.all { it in 0 until ChatReplayPacing.SPREAD_WINDOW_MS },
            )
        }
    }

    @Test
    fun offsetsNeverMoveBackwards() {
        for (bucketSize in 1..80) {
            val offsets = emissionOffsets(bucketSize)
            assertEquals(offsets.sorted(), offsets)
        }
    }

    @Test
    fun bucketThatGrowsMidFlightKeepsAdvancing() {
        // Messages for one second can arrive across two API pages, so the queue grows after the
        // first few have already gone out. The stagger has to keep moving forward regardless.
        var stagger = ChatReplayPacing.advanceStagger(0L, 2)
        assertEquals(500L, stagger)

        // Four more turn up for the same second.
        val next = ChatReplayPacing.advanceStagger(ChatReplayPacing.staggerForEmission(stagger), 5)
        assertTrue("expected $next > 500", next > 500L)
        assertTrue(next < ChatReplayPacing.SPREAD_WINDOW_MS)
    }

    @Test
    fun staggerIsClampedIntoTheWindow() {
        val clamped = ChatReplayPacing.staggerForEmission(ChatReplayPacing.SPREAD_WINDOW_MS + 5_000L)
        assertEquals(ChatReplayPacing.SPREAD_WINDOW_MS - ChatReplayPacing.MIN_SPACING_MS, clamped)
        assertEquals(0L, ChatReplayPacing.staggerForEmission(-50L))
    }

    @Test
    fun perTickReleaseSpreadsABucketAcrossTheWindowsTicks() {
        // 1000ms window, 150ms tick = 6 whole ticks, so 30 messages go out 5 at a time.
        assertEquals(5, ChatReplayPacing.perTickRelease(30, tickIntervalMs = 150L))
        assertEquals(1, ChatReplayPacing.perTickRelease(1, tickIntervalMs = 150L))
        assertEquals(1, ChatReplayPacing.perTickRelease(6, tickIntervalMs = 150L))
        assertEquals(2, ChatReplayPacing.perTickRelease(7, tickIntervalMs = 150L))
    }

    @Test
    fun perTickReleaseNeverFallsBehindTheBucket() {
        // The release rate has to drain a bucket within its own window, or replay drifts further
        // behind the video every second.
        val tick = 150L
        val ticksPerWindow = ChatReplayPacing.SPREAD_WINDOW_MS / tick
        for (bucketSize in 1..500) {
            val perTick = ChatReplayPacing.perTickRelease(bucketSize, tick)
            assertTrue(
                "bucket $bucketSize: $perTick per tick x $ticksPerWindow ticks < $bucketSize",
                perTick * ticksPerWindow >= bucketSize,
            )
        }
    }

    @Test
    fun perTickReleaseHandlesDegenerateInputs() {
        assertEquals(1, ChatReplayPacing.perTickRelease(0, tickIntervalMs = 150L))
        assertEquals(1, ChatReplayPacing.perTickRelease(-5, tickIntervalMs = 150L))
        // A tick at least as long as the window can only ever release the whole bucket at once.
        assertEquals(30, ChatReplayPacing.perTickRelease(30, tickIntervalMs = 1_000L))
        assertEquals(30, ChatReplayPacing.perTickRelease(30, tickIntervalMs = 5_000L))
        // A non-positive tick is clamped to 1ms, which is a whole window's worth of ticks, so the
        // bucket spreads as finely as it can rather than collapsing back into a burst.
        assertEquals(1, ChatReplayPacing.perTickRelease(30, tickIntervalMs = 0L))
    }

    @Test
    fun exhaustedBucketAdvancesToTheWindowEdge() {
        // The last message of a bucket parks the running stagger at the boundary, so anything that
        // shows up late for that second is clamped rather than leaking into the next second.
        assertEquals(ChatReplayPacing.SPREAD_WINDOW_MS, ChatReplayPacing.advanceStagger(750L, 1))
    }
}
