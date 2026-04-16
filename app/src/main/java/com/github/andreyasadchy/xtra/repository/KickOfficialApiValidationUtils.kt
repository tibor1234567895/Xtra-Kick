package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionRequestItem
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardCreateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardUpdateRequest

internal object KickOfficialApiValidationUtils {
    const val REWARD_TITLE_MAX_LENGTH = 50
    const val REWARD_DESCRIPTION_MAX_LENGTH = 200
    const val REWARD_MIN_COST = 1
    const val REDEMPTION_ACTION_MAX_IDS = 25

    val EVENT_NAMES = listOf(
        "chat.message.sent",
        "channel.followed",
        "channel.subscription.renewal",
        "channel.subscription.gifts",
        "channel.subscription.new",
        "channel.reward.redemption.updated",
        "livestream.status.updated",
        "livestream.metadata.updated",
        "moderation.banned",
        "kicks.gifted",
    )

    val REDEMPTION_STATUSES = listOf("pending", "accepted", "rejected")

    fun validateCreateReward(input: KickOfficialRewardCreateRequest) {
        require(input.title.isNotBlank()) { "Reward title is required." }
        require(input.title.length <= REWARD_TITLE_MAX_LENGTH) {
            "Reward title must be at most $REWARD_TITLE_MAX_LENGTH characters."
        }
        require(input.description.isNullOrEmpty() || input.description.length <= REWARD_DESCRIPTION_MAX_LENGTH) {
            "Reward description must be at most $REWARD_DESCRIPTION_MAX_LENGTH characters."
        }
        require(input.cost >= REWARD_MIN_COST) {
            "Reward cost must be at least $REWARD_MIN_COST."
        }
    }

    fun validateUpdateReward(input: KickOfficialRewardUpdateRequest) {
        require(
            input.title != null ||
                input.cost != null ||
                input.description != null ||
                input.backgroundColor != null ||
                input.isEnabled != null ||
                input.isPaused != null ||
                input.isUserInputRequired != null ||
                input.shouldRedemptionsSkipRequestQueue != null
        ) { "At least one reward field must be updated." }
        input.title?.let {
            require(it.isNotBlank()) { "Reward title cannot be blank." }
            require(it.length <= REWARD_TITLE_MAX_LENGTH) {
                "Reward title must be at most $REWARD_TITLE_MAX_LENGTH characters."
            }
        }
        input.description?.let {
            require(it.length <= REWARD_DESCRIPTION_MAX_LENGTH) {
                "Reward description must be at most $REWARD_DESCRIPTION_MAX_LENGTH characters."
            }
        }
        input.cost?.let {
            require(it >= REWARD_MIN_COST) {
                "Reward cost must be at least $REWARD_MIN_COST."
            }
        }
    }

    fun validateRedemptionActionIds(ids: List<String>) {
        require(ids.isNotEmpty()) { "Select at least one redemption." }
        require(ids.size <= REDEMPTION_ACTION_MAX_IDS) {
            "You can only manage up to $REDEMPTION_ACTION_MAX_IDS redemptions at once."
        }
        require(ids.distinct().size == ids.size) { "Redemption ids must be unique." }
        require(ids.all { it.isNotBlank() }) { "Redemption ids cannot be blank." }
    }

    fun validateEventSubscriptionCreate(events: List<KickEventSubscriptionRequestItem>) {
        require(events.isNotEmpty()) { "Select at least one event subscription." }
        require(events.all { it.name in EVENT_NAMES }) { "Unknown event selected." }
    }
}
