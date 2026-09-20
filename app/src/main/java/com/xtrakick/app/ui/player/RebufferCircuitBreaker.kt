package com.xtrakick.app.ui.player

/**
 * Counts playback stalls in a rolling window and decides when automated
 * recovery (fresh-URL reload) is warranted.
 *
 * A single stall is normal on a live network; a cluster of them means the
 * session is stuck (stale URL, wedged estimator, drifted live edge) and
 * waiting it out only grows latency debt. After triggering, further triggers
 * are suppressed for [cooldownMs] so recovery attempts can't loop.
 *
 * Pure Kotlin (uptime millis in, decision out) so it stays unit-testable.
 */
class RebufferCircuitBreaker(
    private val windowMs: Long = 60_000L,
    private val threshold: Int = 3,
    private val cooldownMs: Long = 90_000L,
) {
    private val stalls = ArrayDeque<Long>()
    private var lastTriggerMs: Long? = null

    /**
     * Records a stall observed at [nowMs] (e.g. `SystemClock.uptimeMillis()`).
     * Returns true when automated recovery should run now.
     */
    fun record(nowMs: Long): Boolean {
        while (stalls.isNotEmpty() && nowMs - stalls.first() > windowMs) {
            stalls.removeFirst()
        }
        stalls.addLast(nowMs)
        if (stalls.size < threshold) return false
        val last = lastTriggerMs
        if (last != null && nowMs - last < cooldownMs) return false
        lastTriggerMs = nowMs
        return true
    }

    /** Clears recorded stalls (fresh session / successful recovery). */
    fun reset() {
        stalls.clear()
        lastTriggerMs = null
    }
}
