package com.github.andreyasadchy.xtra.model.helix.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class User(
    @SerialName("id")
    val channelId: String? = null,
    @SerialName("login")
    val channelLogin: String? = null,
    @SerialName("display_name")
    val channelName: String? = null,
    val type: String? = null,
    @SerialName("broadcaster_type")
    val broadcasterType: String? = null,
    @SerialName("profile_image_url")
    val profileImageUrl: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
)