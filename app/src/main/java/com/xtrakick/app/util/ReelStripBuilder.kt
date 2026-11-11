package com.xtrakick.app.util

import com.xtrakick.app.model.kick.KickDailyRouletteItem

/**
 * Port of Kick web's `buildFixedReelStrip` (kick.com daily-rewards roulette, chunk
 * 2fak-f4t220l6.js): the claim response's roulette list is laid out twice plus one
 * extra copy of the first item, and the reel travels from `restIndex` to
 * the winner's tile position inside the second copy.
 *
 * Supports an optional [leadInCount] so that at `restIndex`, padding tiles exist to the
 * left of the center position, preventing an empty half-screen void when the reel first appears.
 */
object ReelStripBuilder {

    data class FixedReelStrip(
        val items: List<KickDailyRouletteItem>,
        val restIndex: Int,
        val targetIndex: Int,
    )

    /**
     * @param rewards the claim response's `roulette` entries
     * @param winningRewardId the authoritative winner id from the claim response
     * @param leadInCount number of lead-in padding tiles placed before the start position
     * @throws IllegalArgumentException when either list is empty or the winner id is unknown
     */
    fun buildFixedReelStrip(
        rewards: List<KickDailyRouletteItem>,
        winningRewardId: String,
        leadInCount: Int = 0,
    ): FixedReelStrip {
        if (rewards.isEmpty()) {
            throw IllegalArgumentException("[buildFixedReelStrip] rewards must not be empty")
        }
        val winnerIndex = rewards.indexOfFirst { it.id == winningRewardId }
        if (winnerIndex < 0) {
            throw IllegalArgumentException("[buildFixedReelStrip] Unknown winningRewardId: $winningRewardId")
        }
        val listLength = rewards.size
        val effectiveLeadIn = leadInCount.coerceAtLeast(0)
        val targetIndex = effectiveLeadIn + listLength + winnerIndex
        val items = buildList {
            if (effectiveLeadIn > 0) {
                for (i in 0 until effectiveLeadIn) {
                    val srcIndex = (listLength - effectiveLeadIn + i + listLength * 10) % listLength
                    val src = rewards[srcIndex]
                    add(src.copy(id = "${src.id}-leadin-$i"))
                }
            }
            addAll(rewards)
            addAll(rewards)
            val extra = rewards[0]
            add(extra.copy(id = "${extra.id}-duplicate"))
            if (effectiveLeadIn > 0) {
                for (i in 1..effectiveLeadIn) {
                    val srcIndex = i % listLength
                    val src = rewards[srcIndex]
                    add(src.copy(id = "${src.id}-leadout-$i"))
                }
            }
        }
        return FixedReelStrip(items, restIndex = effectiveLeadIn, targetIndex = targetIndex)
    }
}
