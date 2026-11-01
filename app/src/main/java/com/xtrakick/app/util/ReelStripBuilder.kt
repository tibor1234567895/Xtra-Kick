package com.xtrakick.app.util

import com.xtrakick.app.model.kick.KickDailyRouletteItem

/**
 * Port of Kick web's `buildFixedReelStrip` (kick.com daily-rewards roulette, chunk
 * 2fak-f4t220l6.js): the claim response's roulette list is laid out twice plus one
 * extra copy of the first item, and the reel travels from `restIndex` (always 0) to
 * the winner's tile position inside the second copy.
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
     * @throws IllegalArgumentException when either list is empty or the winner id is unknown
     */
    fun buildFixedReelStrip(
        rewards: List<KickDailyRouletteItem>,
        winningRewardId: String,
    ): FixedReelStrip {
        if (rewards.isEmpty()) {
            throw IllegalArgumentException("[buildFixedReelStrip] rewards must not be empty")
        }
        val winnerIndex = rewards.indexOfFirst { it.id == winningRewardId }
        if (winnerIndex < 0) {
            throw IllegalArgumentException("[buildFixedReelStrip] Unknown winningRewardId: $winningRewardId")
        }
        val listLength = rewards.size
        val targetIndex = listLength + winnerIndex
        val items = buildList {
            addAll(rewards)
            addAll(rewards)
            val extra = rewards[0]
            add(extra.copy(id = "${extra.id}-duplicate"))
        }
        return FixedReelStrip(items, restIndex = 0, targetIndex)
    }
}
