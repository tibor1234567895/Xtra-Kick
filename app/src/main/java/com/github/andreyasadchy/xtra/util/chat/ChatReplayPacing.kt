package com.github.andreyasadchy.xtra.util.chat

/**
 * Paces VOD chat replay inside a single timestamp bucket.
 *
 * Kick reports each video comment's position as whole seconds (contentOffsetSeconds), and
 * downloaded chat files inherit that resolution, so every message from the same second carries an
 * identical target position. The replay loop waits for the target and then emits, which means a
 * whole second's traffic used to reach the adapter in one pass. On a busy VOD that is dozens of
 * rows at once, and because the list auto-scrolls to the newest row, everything above the last
 * screenful scrolled by unread.
 *
 * Spreading a bucket across the second it covers costs no accuracy that the source data actually
 * carries - the true sub-second times are simply not in the response - and turns each burst back
 * into a readable stream.
 *
 * Buckets are grouped by equal timestamps, so this never spreads messages that already have
 * distinct positions: those form buckets of one and keep their own timing.
 */
object ChatReplayPacing {

    /** Width of a timestamp bucket, and so the window a bucket's messages are spread across. */
    const val SPREAD_WINDOW_MS = 1000L

    /**
     * Floor on the gap between two emissions, roughly one frame at 60Hz. Anything tighter cannot
     * be perceived as separate arrivals, and it keeps the tail of a bucket off the next bucket's
     * boundary.
     */
    const val MIN_SPACING_MS = 16L

    /**
     * Clamps a stagger into the bucket it belongs to.
     *
     * A bucket whose messages are split across two API pages keeps growing after its first
     * messages have already gone out, which can drive the running stagger to the end of the
     * window. Clamping keeps those late arrivals inside their own bucket instead of pushing them
     * into the next one.
     */
    fun staggerForEmission(staggerMs: Long, windowMs: Long = SPREAD_WINDOW_MS): Long {
        return staggerMs.coerceIn(0L, (windowMs - MIN_SPACING_MS).coerceAtLeast(0L))
    }

    /**
     * Stagger for the next message in the bucket, spreading whatever is left of the window over
     * the messages still queued in it.
     *
     * [remainingInWindow] counts the messages still queued for this bucket *including* the one
     * just emitted, so an evenly sized bucket comes out evenly spaced. Recomputing from what is
     * actually left on every emission makes this self-correcting - a bucket that grows mid-flight
     * just gets smaller steps - and the result never moves backwards.
     */
    fun advanceStagger(
        currentStaggerMs: Long,
        remainingInWindow: Int,
        windowMs: Long = SPREAD_WINDOW_MS,
    ): Long {
        if (remainingInWindow <= 1) {
            return windowMs
        }
        val room = (windowMs - currentStaggerMs).coerceAtLeast(0L)
        return (currentStaggerMs + room / remainingInWindow).coerceAtMost(windowMs)
    }

    /**
     * How many of a bucket's messages to release per tick, for a loop that polls every
     * [tickIntervalMs], so the bucket is spread over the window it covers instead of going out all
     * at once.
     *
     * Rounds up, which guarantees the release rate keeps up with the bucket: there are at least
     * `windowMs / tickIntervalMs` ticks in a window, and `ceil(size / ticks) * ticks >= size`. Never
     * returns less than one, so a quiet second is not held back.
     */
    fun perTickRelease(bucketSize: Int, tickIntervalMs: Long, windowMs: Long = SPREAD_WINDOW_MS): Int {
        if (bucketSize <= 0) {
            return 1
        }
        val ticksPerWindow = (windowMs / tickIntervalMs.coerceAtLeast(1L)).coerceAtLeast(1L)
        return (((bucketSize + ticksPerWindow - 1) / ticksPerWindow).toInt()).coerceAtLeast(1)
    }
}
