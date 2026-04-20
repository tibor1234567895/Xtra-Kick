package com.github.andreyasadchy.xtra.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KickEventSubscription(
    val id: String? = null,
    @SerialName("app_id")
    val appId: String? = null,
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long? = null,
    val event: String? = null,
    val version: Int? = null,
    val method: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null,
)

@Serializable
data class KickEventSubscriptionRequestItem(
    val name: String,
    val version: Int = 1,
)

@Serializable
data class KickEventSubscriptionCreateResult(
    val name: String? = null,
    val version: Int? = null,
    @SerialName("subscription_id")
    val subscriptionId: String? = null,
    val error: String? = null,
)

@Serializable
data class KickEventSubscriptionListResponse(
    val message: String? = null,
    val data: List<KickEventSubscription> = emptyList(),
)

@Serializable
data class KickEventSubscriptionCreateResponse(
    val message: String? = null,
    val data: List<KickEventSubscriptionCreateResult> = emptyList(),
)

@Serializable
data class KickOfficialReward(
    val id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val cost: Int? = null,
    @SerialName("background_color")
    val backgroundColor: String? = null,
    @SerialName("is_enabled")
    val isEnabled: Boolean? = null,
    @SerialName("is_paused")
    val isPaused: Boolean? = null,
    @SerialName("is_user_input_required")
    val isUserInputRequired: Boolean? = null,
    @SerialName("should_redemptions_skip_request_queue")
    val shouldRedemptionsSkipRequestQueue: Boolean? = null,
    @SerialName("can_manage")
    val canManage: Boolean? = null,
)

@Serializable
data class KickOfficialRewardsResponse(
    val message: String? = null,
    val data: List<KickOfficialReward> = emptyList(),
)

@Serializable
data class KickOfficialRewardResponse(
    val message: String? = null,
    val data: KickOfficialReward? = null,
)

@Serializable
data class KickOfficialRewardCreateRequest(
    val title: String,
    val cost: Int,
    val description: String? = null,
    @SerialName("background_color")
    val backgroundColor: String? = null,
    @SerialName("is_enabled")
    val isEnabled: Boolean? = null,
    @SerialName("is_user_input_required")
    val isUserInputRequired: Boolean? = null,
    @SerialName("should_redemptions_skip_request_queue")
    val shouldRedemptionsSkipRequestQueue: Boolean? = null,
)

@Serializable
data class KickOfficialRewardUpdateRequest(
    val title: String? = null,
    val cost: Int? = null,
    val description: String? = null,
    @SerialName("background_color")
    val backgroundColor: String? = null,
    @SerialName("is_enabled")
    val isEnabled: Boolean? = null,
    @SerialName("is_paused")
    val isPaused: Boolean? = null,
    @SerialName("is_user_input_required")
    val isUserInputRequired: Boolean? = null,
    @SerialName("should_redemptions_skip_request_queue")
    val shouldRedemptionsSkipRequestQueue: Boolean? = null,
)

@Serializable
data class KickRewardRedemptionRedeemer(
    @SerialName("user_id")
    val userId: Long? = null,
    val username: String? = null,
    @SerialName("channel_slug")
    val channelSlug: String? = null,
)

@Serializable
data class KickRewardRedemption(
    val id: String? = null,
    @SerialName("redeemed_at")
    val redeemedAt: String? = null,
    val redeemer: KickRewardRedemptionRedeemer? = null,
    val status: String? = null,
    @SerialName("user_input")
    val userInput: String? = null,
)

@Serializable
data class KickRewardRedemptionGroup(
    val reward: KickOfficialReward? = null,
    val redemptions: List<KickRewardRedemption> = emptyList(),
)

@Serializable
data class KickCursorPagination(
    @SerialName("next_cursor")
    val nextCursor: String? = null,
)

@Serializable
data class KickRewardRedemptionsResponse(
    val message: String? = null,
    val data: List<KickRewardRedemptionGroup> = emptyList(),
    val pagination: KickCursorPagination? = null,
)

data class KickRewardRedemptionsPage(
    val groups: List<KickRewardRedemptionGroup> = emptyList(),
    val nextCursor: String? = null,
)

@Serializable
data class KickRewardRedemptionBulkActionRequest(
    val ids: List<String>,
)

@Serializable
data class KickRewardRedemptionActionFailure(
    val id: String? = null,
    val reason: String? = null,
)

@Serializable
data class KickRewardRedemptionBulkActionResponse(
    val message: String? = null,
    val data: List<KickRewardRedemptionActionFailure> = emptyList(),
)
