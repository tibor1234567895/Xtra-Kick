package com.xtrakick.app.ui.player

import kotlin.math.abs

data class StackableSkipState(
    val basePositionMs: Long,
    val accumulatedDeltaMs: Long,
) {
    fun targetPositionClamped(durationMs: Long?): Long =
        if (durationMs != null && durationMs > 0L) {
            (basePositionMs + accumulatedDeltaMs).coerceIn(0L, durationMs)
        } else {
            (basePositionMs + accumulatedDeltaMs).coerceAtLeast(0L)
        }
}

fun calculateStackableSkip(
    currentState: StackableSkipState?,
    currentPlaybackPositionMs: Long,
    isForward: Boolean,
    stepMs: Long
): StackableSkipState? {
    val base = currentState?.basePositionMs ?: currentPlaybackPositionMs
    val currentDelta = currentState?.accumulatedDeltaMs ?: 0L
    val newDelta = if (isForward) currentDelta + stepMs else currentDelta - stepMs
    if (newDelta == 0L) {
        return null
    }
    return StackableSkipState(basePositionMs = base, accumulatedDeltaMs = newDelta)
}

fun formatSkipBadgeLabel(accumulatedDeltaMs: Long): String {
    val seconds = abs(accumulatedDeltaMs) / 1000L
    return when {
        accumulatedDeltaMs > 0L -> "+${seconds}s"
        accumulatedDeltaMs < 0L -> "-${seconds}s"
        else -> ""
    }
}

fun formatSkipButtonLabel(accumulatedDeltaMs: Long, defaultSeconds: Long, isForwardButton: Boolean): String {
    if (accumulatedDeltaMs == 0L) {
        return defaultSeconds.toString()
    }
    val isActiveButton = (accumulatedDeltaMs > 0L && isForwardButton) || (accumulatedDeltaMs < 0L && !isForwardButton)
    return if (isActiveButton) "" else defaultSeconds.toString()
}
