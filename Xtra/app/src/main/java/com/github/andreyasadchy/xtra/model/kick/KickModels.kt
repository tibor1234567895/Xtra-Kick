package com.github.andreyasadchy.xtra.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
)

@Serializable
class KickUser(
    val id: Long? = null,
    val username: String? = null,
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
    val text: String? = null,
    val count: Int? = null,
)
