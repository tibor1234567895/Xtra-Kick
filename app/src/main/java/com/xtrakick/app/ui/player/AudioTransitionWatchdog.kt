package com.xtrakick.app.ui.player

/** Detects a playback position that stops advancing after entering IVS audio-only mode. */
class AudioTransitionWatchdog(
    private val gracePeriodMs: Long = 10_000L,
    private val stallWindowMs: Long = 15_000L,
) {
    private var graceEndMs: Long? = null
    private var lastPositionMs = -1L
    private var lastProgressMs = 0L

    fun arm(nowMs: Long) {
        graceEndMs = nowMs + gracePeriodMs
        resetObservation()
    }

    fun resetObservation() {
        lastPositionMs = -1L
    }

    fun disarm() {
        graceEndMs = null
        resetObservation()
    }

    fun isArmed(): Boolean = graceEndMs != null

    /** Sample only while playing. Buffering or a suspended view should reset the observation. */
    fun onPosition(positionMs: Long, nowMs: Long): Boolean {
        val graceEnd = graceEndMs ?: return false
        if (nowMs < graceEnd) return false
        if (positionMs < 0L) {
            resetObservation()
            return false
        }
        if (positionMs != lastPositionMs) {
            lastPositionMs = positionMs
            lastProgressMs = nowMs
            return false
        }
        if (nowMs - lastProgressMs < stallWindowMs) return false
        disarm()
        return true
    }
}
