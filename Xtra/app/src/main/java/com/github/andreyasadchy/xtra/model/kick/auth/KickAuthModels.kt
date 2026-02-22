package com.github.andreyasadchy.xtra.model.kick.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KickOAuthTokenResponse(
    @SerialName("access_token")
    val accessToken: String? = null,
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("expires_in")
    val expiresIn: Long? = null,
    @SerialName("token_type")
    val tokenType: String? = null,
    val scope: String? = null,
)

@Serializable
data class KickOAuthErrorResponse(
    val error: String? = null,
    @SerialName("error_description")
    val errorDescription: String? = null,
)

@Serializable
data class KickUsersResponse(
    val data: List<KickUserData> = emptyList(),
)

@Serializable
data class KickUserData(
    val id: String? = null,
    val name: String? = null,
    @SerialName("channel_slug")
    val channelSlug: String? = null,
)

@Serializable
data class KickTokenIntrospectResponse(
    val active: Boolean = false,
    @SerialName("exp")
    val expiresAt: Long? = null,
    @SerialName("client_id")
    val clientId: String? = null,
    @SerialName("user_id")
    val userId: String? = null,
    @SerialName("username")
    val userName: String? = null,
    val scope: String? = null,
)

@Serializable
data class KickChatSendRequest(
    @SerialName("broadcaster_user_id")
    val broadcasterUserId: Int,
    val content: String,
    val type: String = "user",
)

@Serializable
data class KickChatSendResponse(
    val status: String? = null,
    val message: String? = null,
)
