package com.xtrakick.app.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KickEventsResponse(val data: KickEventsData = KickEventsData())

@Serializable
data class KickEventsData(val events: List<KickEvent> = emptyList())

@Serializable
data class KickEvent(
    val id: String,
    val slug: String,
    val title: String,
    val phase: String? = null,
    val category: KickCategory? = null,
    @SerialName("num_livestreams") val numLivestreams: Int = 0,
    val languages: List<String> = emptyList(),
)

@Serializable
data class KickEventStreamsResponse(val data: KickEventStreamsData = KickEventStreamsData())

@Serializable
data class KickEventStreamsData(
    val streams: List<KickEventStream> = emptyList(),
    @SerialName("next_cursor") val nextCursor: String? = null,
)

@Serializable
data class KickEventStream(
    val channel: KickChannelSummary,
    val user: KickEventUser,
    val livestream: KickEventLivestream,
)

@Serializable
data class KickEventUser(
    val username: String? = null,
    @SerialName("profile_picture_url") val profilePictureUrl: String? = null,
    @SerialName("profile_picture") val profilePicture: String? = null,
    @SerialName("profile_pic") val profilePic: String? = null,
    @SerialName("profilepic") val profilepic: String? = null,
) {
    val effectiveProfilePictureUrl: String?
        get() = profilePictureUrl?.takeIf { it.isNotBlank() }
            ?: profilePicture?.takeIf { it.isNotBlank() }
            ?: profilePic?.takeIf { it.isNotBlank() }
            ?: profilepic?.takeIf { it.isNotBlank() }
}

@Serializable
data class KickEventLivestream(
    val id: String? = null,
    val title: String? = null,
    val language: String? = null,
    @SerialName("is_mature") val isMature: Boolean? = null,
    @SerialName("show_view_count") val showViewCount: Boolean = true,
    @SerialName("view_count") val viewCount: Int? = null,
    val thumbnail: KickThumbnail? = null,
)
