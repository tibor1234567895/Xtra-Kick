package com.github.andreyasadchy.xtra.model.chat

data class ChannelPointsSummary(
    val balance: Int? = null,
    val rewards: List<ChannelPointReward> = emptyList(),
    val rewardsAvailable: Boolean = false,
)
