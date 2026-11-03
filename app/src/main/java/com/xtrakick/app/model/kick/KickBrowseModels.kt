package com.xtrakick.app.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Locale

@Serializable
data class KickBrowseResponse(val data: KickBrowsePage)

@Serializable
data class KickBrowsePage(
    val livestreams: List<KickBrowseLivestream> = emptyList(),
    val pagination: KickBrowsePagination = KickBrowsePagination(),
)

@Serializable
data class KickBrowsePagination(@SerialName("next_cursor") val nextCursor: String? = null)

@Serializable
data class KickBrowseLivestream(
    val id: String,
    val title: String? = null,
    val language: String? = null,
    @SerialName("is_mature") val isMature: Boolean? = null,
    @SerialName("viewer_count") val viewerCount: Int? = null,
    @SerialName("show_view_count") val showViewCount: Boolean = true,
    @SerialName("start_time") val startTime: String? = null,
    val tags: List<String>? = null,
    val thumbnail: KickThumbnail? = null,
    val category: KickCategory? = null,
    val channel: KickBrowseChannel,
) {
    fun toLegacyLivestream(): KickLivestream = KickLivestream(
        language = language?.let { Locale.forLanguageTag(it).getDisplayLanguage(Locale.ENGLISH).ifBlank { it } },
        channelId = channel.id,
        title = title,
        viewerCount = viewerCount.takeIf { showViewCount },
        isMature = isMature,
        createdAt = startTime,
        tags = tags,
        thumbnail = thumbnail,
        categories = category?.let(::listOf),
        channel = KickChannelSummary(id = channel.id, slug = channel.slug,
            user = KickUser(username = channel.username, profilePicV2 = channel.profilePic)),
    )
}

@Serializable
data class KickBrowseChannel(
    val id: Long,
    val slug: String,
    val username: String? = null,
    @SerialName("profile_pic") val profilePic: String? = null,
)

@Serializable
data class KickBrowseLanguageCodes(val data: List<String> = emptyList())
