package com.xtrakick.app.util.chat

import okhttp3.Dispatcher

/** Adjusts 7TV CDN request concurrency using recent image fetch outcomes. */
class StvCdnHealth(
    private val nowMs: () -> Long = System::currentTimeMillis,
    private val windowSize: Int = WINDOW_SIZE,
    private val minSamples: Int = MIN_SAMPLES,
    private val degradedFailureRatio: Double = DEGRADED_FAILURE_RATIO,
    private val recoveryStreak: Int = RECOVERY_STREAK,
    private val sampleTtlMs: Long = SAMPLE_TTL_MS,
) {
    private val window = ArrayDeque<Boolean>(windowSize)
    private var successStreak = 0
    private var lastSampleAtMs: Long? = null
    private var pacingDispatcher: Dispatcher? = null

    val degraded: Boolean
        get() = synchronized(this) {
            expireSamples(nowMs())
            isDegraded()
        }

    fun record(success: Boolean) = synchronized(this) {
        val now = nowMs()
        expireSamples(now)
        lastSampleAtMs = now
        if (window.size >= windowSize) window.removeFirst()
        window.addLast(success)
        successStreak = if (success) successStreak + 1 else 0
        if (successStreak >= recoveryStreak && isDegraded()) resetSamples()
        pacingDispatcher?.maxRequestsPerHost = requestLimit()
    }

    internal fun createDispatcher(): Dispatcher = synchronized(this) {
        expireSamples(nowMs())
        Dispatcher().apply { maxRequestsPerHost = requestLimit() }
            .also { pacingDispatcher = it }
    }

    private fun expireSamples(now: Long) {
        val sampledAtMs = lastSampleAtMs
        if (sampledAtMs != null && now - sampledAtMs > sampleTtlMs) {
            resetSamples()
            pacingDispatcher?.maxRequestsPerHost = FULL_PER_HOST
        }
    }

    private fun resetSamples() {
        lastSampleAtMs = null
        window.clear()
        successStreak = 0
    }

    private fun requestLimit(): Int = if (isDegraded()) DEGRADED_PER_HOST else FULL_PER_HOST

    private fun isDegraded(): Boolean {
        if (window.size < minSamples) return false
        val failures = window.count { !it }
        return failures >= (window.size * degradedFailureRatio).toInt().coerceAtLeast(1)
    }

    companion object {
        private const val WINDOW_SIZE = 24
        private const val MIN_SAMPLES = 10
        private const val DEGRADED_FAILURE_RATIO = 0.3
        private const val RECOVERY_STREAK = 5
        private const val SAMPLE_TTL_MS = 5 * 60 * 1000L

        internal const val CDN_HOST = "cdn.7tv.app"
        val DEFAULT = StvCdnHealth()

        private const val FULL_PER_HOST = 20
        private const val DEGRADED_PER_HOST = 5
    }
}
