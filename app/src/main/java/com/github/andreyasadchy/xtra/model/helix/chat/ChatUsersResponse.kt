package com.github.andreyasadchy.xtra.model.helix.chat

import com.github.andreyasadchy.xtra.model.helix.Pagination
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