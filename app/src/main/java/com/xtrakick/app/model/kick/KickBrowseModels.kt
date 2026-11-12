package com.xtrakick.app.model.kick

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
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
@OptIn(ExperimentalSerializationApi::class)
data class KickBrowseLivestream(
    val id: String,
    val title: String? = null,
    @JsonNames("language_code") val language: String? = null,
    @SerialName("is_mature") val isMature: Boolean? = null,
    @SerialName("viewer_count") val viewerCount: Int? = null,
    @SerialName("show_view_count") val showViewCount: Boolean = true,
    @SerialName("start_time") val startTime: String? = null,
    @JsonNames("custom_tags") val tags: List<String>? = null,
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
            user = KickUser(username = channel.username ?: channel.slug, profilePicV2 = channel.effectiveProfilePic)),
    )
}

@Serializable
data class KickBrowseChannel(
    val id: Long,
    val slug: String,
    val username: String? = null,
    @SerialName("profile_pic") val profilePic: String? = null,
    @SerialName("profile_picture") val profilePicture: String? = null,
    @SerialName("profilepic") val profilepic: String? = null,
    @SerialName("profilePic") val profilePicCamelCase: String? = null,
) {
    val effectiveProfilePic: String?
        get() = profilePic?.takeIf { it.isNotBlank() }
            ?: profilePicture?.takeIf { it.isNotBlank() }
            ?: profilepic?.takeIf { it.isNotBlank() }
            ?: profilePicCamelCase?.takeIf { it.isNotBlank() }
}

@Serializable
data class KickBrowseLanguageCodes(val data: List<String> = emptyList())
