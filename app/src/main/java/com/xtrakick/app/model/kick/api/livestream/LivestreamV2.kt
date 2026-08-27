package com.xtrakick.app.model.kick.api.livestream

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Item shape returned by GET /public/v1/users/livestreams ("endpoints.LivestreamV2" in the
 * official OpenAPI spec). Differs from the items of the deprecated /public/v1/livestreams
 * endpoint: the broadcaster is nested under [broadcasterUser], there is no channel_id, and
 * title/language/tags were renamed (stream_title/language/custom_tags → title/language_code/tags).
 */
@Serializable
class LivestreamV2(
    @SerialName("broadcaster_user")
    val broadcasterUser: BroadcasterUser? = null,
    val category: Category? = null,
    val channel: Channel? = null,
    @SerialName("has_mature_content")
    val hasMatureContent: Boolean? = null,
    val id: String? = null,
    @SerialName("language_code")
    val languageCode: String? = null,
    @SerialName("started_at")
    val startedAt: String? = null,
    val thumbnail: String? = null,
    val title: String? = null,
    @SerialName("viewer_count")
    val viewerCount: Int? = null,
) {
    @Serializable
    class BroadcasterUser(
        val id: Long? = null,
        val username: String? = null,
        @SerialName("profile_picture")
        val profilePicture: String? = null,
    )

    @Serializable
    class Category(
        val id: Long? = null,
        val name: String? = null,
        val thumbnail: String? = null,
    )

    @Serializable
    class Channel(
        val slug: String? = null,
    )
}

/** Maps the current endpoint's payload onto the legacy parse model its consumers rely on. */
internal fun LivestreamV2.toLegacyLivestream(): Livestream = Livestream(
    broadcasterUserId = broadcasterUser?.id,
    channelId = null,
    slug = channel?.slug,
    streamTitle = title,
    viewerCount = viewerCount,
    startedAt = startedAt,
    thumbnail = thumbnail,
    profilePicture = broadcasterUser?.profilePicture,
    language = languageCode,
    customTags = null,
    category = category?.let { Livestream.Category(id = it.id, name = it.name) },
)
