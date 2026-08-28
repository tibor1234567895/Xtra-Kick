package com.xtrakick.app.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KickLiveNotificationEvent(
    @SerialName("user_id") val userId: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val path: String? = null,
    @SerialName("profile_picture") val profilePicture: String? = null,
)
