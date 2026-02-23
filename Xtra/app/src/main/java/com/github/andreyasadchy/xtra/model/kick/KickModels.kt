package com.github.andreyasadchy.xtra.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
class KickLivestreamsResponse(
    @SerialName("current_page")
    val currentPage: Int? = null,
    @SerialName("next_page_url")
    val nextPageUrl: String? = null,
    val data: List<KickLivestream> = emptyList(),
)

@Serializable
class KickLivestream(
    val id: Long? = null,
    @SerialName("channel_id")
    val channelId: Long? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("session_title")
    val title: String? = null,
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
    val thumbnail: KickThumbnail? = null,
    val tags: List<String>? = null,
    val channel: KickChannelSummary? = null,
    val categories: List<KickCategory>? = null,
)

@Serializable
class KickSubcategoriesResponse(
    @SerialName("current_page")
    val currentPage: Int? = null,
    @SerialName("next_page_url")
    val nextPageUrl: String? = null,
    val data: List<KickSubcategory> = emptyList(),
)

@Serializable
class KickSubcategory(
    val id: Long? = null,
    @SerialName("category_id")
    val categoryId: Long? = null,
    val name: String? = null,
    val slug: String? = null,
    val viewers: Int? = null,
    val banner: KickBanner? = null,
)

@Serializable
class KickChannelResponse(
    val id: Long? = null,
    @SerialName("user_id")
    val userId: Long? = null,
    val slug: String? = null,
    @SerialName("playback_url")
    val playbackUrl: String? = null,
    @SerialName("followers_count")
    val followersCount: Int? = null,
    @SerialName("banner_image")
    val bannerImage: KickBanner? = null,
    @SerialName("recent_categories")
    val recentCategories: List<KickSubcategory>? = null,
    @SerialName("subscriber_badges")
    val subscriberBadges: List<KickChannelBadge>? = null,
    @SerialName("founder_badges")
    val founderBadges: List<KickChannelBadge>? = null,
    val badges: List<KickChannelBadge>? = null,
    val chatroom: KickChatroom? = null,
    val livestream: KickChannelLivestream? = null,
    val user: KickUser? = null,
)

@Serializable
class KickChannelSummary(
    val id: Long? = null,
    val slug: String? = null,
    @SerialName("playback_url")
    val playbackUrl: String? = null,
    val user: KickUser? = null,
)

@Serializable
class KickChannelLivestream(
    val id: Long? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("session_title")
    val title: String? = null,
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
    @SerialName("playback_url")
    val playbackUrl: String? = null,
    val thumbnail: KickThumbnail? = null,
    val category: KickCategory? = null,
)

@Serializable
class KickCategory(
    val id: Long? = null,
    val name: String? = null,
    val slug: String? = null,
)

@Serializable
class KickThumbnail(
    val src: String? = null,
)

@Serializable
class KickBanner(
    val url: String? = null,
)

@Serializable
class KickChatroom(
    val id: Long? = null,
    val badges: List<KickChannelBadge>? = null,
    @SerialName("subscriber_badges")
    val subscriberBadges: List<KickChannelBadge>? = null,
    @SerialName("founder_badges")
    val founderBadges: List<KickChannelBadge>? = null,
)

@Serializable
class KickChannelBadge(
    val type: String? = null,
    @SerialName("badge_type")
    val badgeType: String? = null,
    val text: String? = null,
    val name: String? = null,
    val slug: String? = null,
    val count: Int? = null,
    val months: Int? = null,
    val level: Int? = null,
    val tier: Int? = null,
    val version: Int? = null,
    @SerialName("badge_image")
    val badgeImage: JsonElement? = null,
    @SerialName("badge_image_url")
    val badgeImageUrl: String? = null,
    val image: JsonElement? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    val icon: JsonElement? = null,
    @SerialName("icon_url")
    val iconUrl: String? = null,
    val url: String? = null,
    val src: String? = null,
)

@Serializable
class KickUser(
    val id: Long? = null,
    val username: String? = null,
    val bio: String? = null,
    val instagram: String? = null,
    val twitter: String? = null,
    val youtube: String? = null,
    val discord: String? = null,
    val tiktok: String? = null,
    val facebook: String? = null,
    @SerialName("profilepic")
    val profilePic: String? = null,
    @SerialName("profile_picture")
    val profilePicture: String? = null,
) {
    val profileImage: String?
        get() = profilePic ?: profilePicture
}

@Serializable
class KickMessagesEnvelope(
    val data: KickMessagesData? = null,
)

@Serializable
class KickMessagesData(
    val messages: List<KickMessage> = emptyList(),
    val cursor: String? = null,
)

@Serializable
class KickMessage(
    val id: String? = null,
    @SerialName("chat_id")
    val chatId: Long? = null,
    @SerialName("user_id")
    val userId: Long? = null,
    val content: String? = null,
    val message: String? = null,
    val text: String? = null,
    val body: String? = null,
    val type: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val sender: KickMessageSender? = null,
)

@Serializable
class KickMessageSender(
    val id: Long? = null,
    val slug: String? = null,
    val username: String? = null,
    val role: String? = null,
    @SerialName("is_super_admin")
    val isSuperAdmin: Boolean? = null,
    @SerialName("is_verified")
    val isVerified: Boolean? = null,
    val verified: Boolean? = null,
    @SerialName("follower_badges")
    val followerBadges: List<String>? = null,
    @SerialName("is_founder")
    val isFounder: Boolean? = null,
    @SerialName("months_subscribed")
    val monthsSubscribed: Int? = null,
    @SerialName("subscriptions_count")
    val subscriptionsCount: Int? = null,
    @SerialName("quantity_gifted")
    val quantityGifted: Int? = null,
    val identity: KickMessageIdentity? = null,
)

@Serializable
class KickMessageIdentity(
    val color: String? = null,
    val badges: List<KickMessageBadge>? = null,
)

@Serializable
class KickMessageBadge(
    val type: String? = null,
    @SerialName("badge_type")
    val badgeType: String? = null,
    val text: String? = null,
    val name: String? = null,
    val slug: String? = null,
    val count: Int? = null,
    val months: Int? = null,
    val level: Int? = null,
    val tier: Int? = null,
    val version: Int? = null,
    val active: Boolean? = null,
    @SerialName("badge_image")
    val badgeImage: JsonElement? = null,
    @SerialName("badge_image_url")
    val badgeImageUrl: String? = null,
    @SerialName("badge_url")
    val badgeUrl: String? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("icon_url")
    val iconUrl: String? = null,
    val url: String? = null,
    val src: String? = null,
    val image: JsonElement? = null,
    val icon: JsonElement? = null,
)
