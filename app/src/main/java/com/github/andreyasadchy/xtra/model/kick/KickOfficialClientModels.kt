package com.github.andreyasadchy.xtra.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KickOfficialUser(
    val email: String? = null,
    val name: String? = null,
    @SerialName("channel_slug")
    val channelSlug: String? = null,
    @SerialName("profile_picture")
    val profilePicture: String? = null,
    @SerialName("user_id")
    val userId: Long? = null,
)

@Serializable
data class KickOfficialTokenIntrospect(
    val active: Boolean? = null,
    @SerialName("client_id")
    val clientId: String? = null,
    val exp: Long? = null,
    val scope: String? = null,
    @SerialName("token_type")
    val tokenType: String? = null,
)

@Serializable
data class KickOfficialCategory(
    val id: Long? = null,
    val name: String? = null,
    val thumbnail: String? = null,
    val tags: List<String> = emptyList(),
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
)

@Serializable
data class KickOfficialChannelStream(
    @SerialName("is_live")
    val isLive: Boolean? = null,
    @SerialName("is_mature")
    val isMature: Boolean? = null,
    val key: String? = null,
    val language: String? = null,
    @SerialName("start_time")
    val startTime: String? = null,
    val thumbnail: String? = null,
    val url: String? = null,
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
)

@Serializable
data class KickOfficialChannel(
    @SerialName("banner_picture")
    val bannerPicture: String? = null,
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long? = null,
    val category: KickOfficialCategory? = null,
    @SerialName("channel_description")
    val channelDescription: String? = null,
    val slug: String? = null,
    val stream: KickOfficialChannelStream? = null,
    @SerialName("stream_title")
    val streamTitle: String? = null,
    val thumbnail: String? = null,
    @SerialName("custom_tags")
    val customTags: List<String> = emptyList(),
)

@Serializable
data class KickOfficialLivestream(
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long? = null,
    val category: KickOfficialCategory? = null,
    @SerialName("channel_id")
    val channelId: Long? = null,
    @SerialName("has_mature_content")
    val hasMatureContent: Boolean? = null,
    val language: String? = null,
    val slug: String? = null,
    @SerialName("started_at")
    val startedAt: String? = null,
    @SerialName("stream_title")
    val streamTitle: String? = null,
    val thumbnail: String? = null,
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
    @SerialName("custom_tags")
    val customTags: List<String> = emptyList(),
)

@Serializable
data class KickOfficialLivestreamStats(
    @SerialName("total_count")
    val totalCount: Int? = null,
)

@Serializable
data class KickOfficialUpdateChannelRequest(
    @SerialName("category_id")
    val categoryId: Long? = null,
    @SerialName("custom_tags")
    val customTags: List<String>? = null,
    @SerialName("stream_title")
    val streamTitle: String? = null,
)

@Serializable
data class KickOfficialPostChatMessageRequest(
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long? = null,
    val content: String,
    @SerialName("reply_to_message_id")
    val replyToMessageId: String? = null,
    val type: String,
)

@Serializable
data class KickOfficialModerationBanRequest(
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long,
    val duration: Int? = null,
    val reason: String? = null,
    @SerialName("user_id")
    val userId: Long,
)

@Serializable
data class KickOfficialModerationDeleteBanRequest(
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long,
    @SerialName("user_id")
    val userId: Long,
)

@Serializable
data class KickOfficialGetLivestreamsRequest(
    @SerialName("broadcaster_user_id")
    val broadcasterUserIds: List<Long>? = null,
    val category: Long? = null,
    val language: String? = null,
    val limit: Int? = null,
    val sort: String? = null,
)

@Serializable
data class KickOfficialEventUser(
    @SerialName("is_anonymous")
    val isAnonymous: Boolean? = null,
    @SerialName("user_id")
    val userId: Long? = null,
    val username: String? = null,
    @SerialName("is_verified")
    val isVerified: Boolean? = null,
    @SerialName("profile_picture")
    val profilePicture: String? = null,
    @SerialName("channel_slug")
    val channelSlug: String? = null,
    val identity: KickOfficialEventIdentity? = null,
)

@Serializable
data class KickOfficialEventIdentity(
    @SerialName("username_color")
    val usernameColor: String? = null,
    val badges: List<KickOfficialEventBadge> = emptyList(),
)

@Serializable
data class KickOfficialEventBadge(
    val text: String? = null,
    val type: String? = null,
    val count: Int? = null,
)

@Serializable
data class KickOfficialReplyInfo(
    @SerialName("message_id")
    val messageId: String? = null,
    val content: String? = null,
    val sender: KickOfficialEventUser? = null,
)

@Serializable
data class KickOfficialChatMessageSentEvent(
    @SerialName("message_id")
    val messageId: String? = null,
    @SerialName("replies_to")
    val repliesTo: KickOfficialReplyInfo? = null,
    val broadcaster: KickOfficialEventUser? = null,
    val sender: KickOfficialEventUser? = null,
    val content: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
)

@Serializable
data class KickOfficialChannelFollowedEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val follower: KickOfficialEventUser? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
)

@Serializable
data class KickOfficialChannelSubscriptionEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val subscriber: KickOfficialEventUser? = null,
    val duration: Int? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("expires_at")
    val expiresAt: String? = null,
)

@Serializable
data class KickOfficialChannelSubscriptionGiftsEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val gifter: KickOfficialEventUser? = null,
    val subscriber: KickOfficialEventUser? = null,
    val giftees: List<KickOfficialEventUser> = emptyList(),
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("expires_at")
    val expiresAt: String? = null,
)

@Serializable
data class KickOfficialLivestreamStatusUpdatedEvent(
    val broadcaster: KickOfficialEventUser? = null,
    @SerialName("is_live")
    val isLive: Boolean? = null,
    val title: String? = null,
    @SerialName("started_at")
    val startedAt: String? = null,
    @SerialName("ended_at")
    val endedAt: String? = null,
)

@Serializable
data class KickOfficialLivestreamMetadata(
    val title: String? = null,
    val language: String? = null,
    @SerialName("has_mature_content")
    val hasMatureContent: Boolean? = null,
    val category: KickOfficialCategory? = null,
)

@Serializable
data class KickOfficialLivestreamMetadataUpdatedEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val metadata: KickOfficialLivestreamMetadata? = null,
)

@Serializable
data class KickOfficialBanMetadata(
    val reason: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("expires_at")
    val expiresAt: String? = null,
)

@Serializable
data class KickOfficialModerationBannedEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val moderator: KickOfficialEventUser? = null,
    @SerialName("banned_user")
    val bannedUser: KickOfficialEventUser? = null,
    val metadata: KickOfficialBanMetadata? = null,
)

@Serializable
data class KickOfficialRewardRedemptionUpdatedEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val redeemer: KickOfficialEventUser? = null,
    val reward: KickOfficialReward? = null,
    val redemption: KickRewardRedemption? = null,
)

@Serializable
data class KickOfficialKicksGiftedEvent(
    val broadcaster: KickOfficialEventUser? = null,
    val sender: KickOfficialEventUser? = null,
    val recipient: KickOfficialEventUser? = null,
    @SerialName("gifted_amount")
    val giftedAmount: Long? = null,
    val amount: Long? = null,
    @SerialName("pinned_time_seconds")
    val pinnedTimeSeconds: Int? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
)
