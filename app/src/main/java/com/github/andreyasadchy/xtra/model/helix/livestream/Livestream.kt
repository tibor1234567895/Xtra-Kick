package com.github.andreyasadchy.xtra.model.helix.livestream

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Livestream(
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Long? = null,
    @SerialName("channel_id")
    val channelId: Long? = null,
    val slug: String? = null,
    @SerialName("stream_title")
    val streamTitle: String? = null,
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
    @SerialName("started_at")
    val startedAt: String? = null,
    val thumbnail: String? = null,
    @SerialName("profile_picture")
    val profilePicture: String? = null,
    val language: String? = null,
    @SerialName("custom_tags")
    val customTags: List<String>? = null,
    val category: Category? = null,
) {
    @Serializable
    class Category(
        val id: Long? = null,
        val name: String? = null,
    )
}
