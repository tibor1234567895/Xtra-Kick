package com.xtrakick.app.model.kick.api.chat

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ChatUsersResponse(
    val data: List<User>,
    val pagination: Pagination? = null,
) {
    @Serializable
    class User(
        @SerialName("user_id")
        val channelId: String? = null,
        @SerialName("user_login")
        val channelLogin: String? = null,
        @SerialName("user_name")
        val channelName: String? = null,
    )
}