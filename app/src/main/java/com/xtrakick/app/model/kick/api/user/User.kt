package com.xtrakick.app.model.kick.api.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class User(
    @SerialName("id")
    private val rawId: String? = null,
    @SerialName("user_id")
    private val rawUserId: Long? = null,
    @SerialName("login")
    private val rawLogin: String? = null,
    @SerialName("name")
    private val rawName: String? = null,
    @SerialName("channel_slug")
    private val rawChannelSlug: String? = null,
    @SerialName("username")
    private val rawUsername: String? = null,
    @SerialName("display_name")
    val channelName: String? = null,
    val type: String? = null,
    @SerialName("broadcaster_type")
    val broadcasterType: String? = null,
    @SerialName("profile_image_url")
    private val rawProfileImageUrl: String? = null,
    @SerialName("profile_picture")
    private val rawProfilePicture: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
) {
    val channelId: String?
        get() = rawUserId?.toString() ?: rawId

    val channelLogin: String?
        get() = rawChannelSlug ?: rawLogin ?: rawUsername ?: rawName

    val profileImageUrl: String?
        get() = rawProfilePicture ?: rawProfileImageUrl
}