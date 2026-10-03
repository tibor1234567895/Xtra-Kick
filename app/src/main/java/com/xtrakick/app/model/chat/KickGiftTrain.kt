package com.xtrakick.app.model.chat

/** Structured payload of a gifted-subs realtime event, before train merging. */
data class KickGiftTrainSnapshot(
    val gifterName: String? = null,
    val giftees: List<String> = emptyList(),
    val totalGifted: Int? = null,
)

/** A merged, time-boxed gift train rendered in the banner above the chat. */
data class KickGiftTrain(
    val gifterName: String?,
    val giftees: List<String>,
    val totalGifted: Int,
    val lastUpdatedAtMs: Long,
) {
    /** Bigger trains stay longer; a single gift clears quickly. */
    val displayDurationMs: Long
        get() = (BASE_DISPLAY_MS + PER_GIFT_MS * totalGifted).coerceAtMost(MAX_DISPLAY_MS)

    companion object {
        const val BASE_DISPLAY_MS = 4_000L
        const val PER_GIFT_MS = 1_000L
        const val MAX_DISPLAY_MS = 60_000L
    }
}
