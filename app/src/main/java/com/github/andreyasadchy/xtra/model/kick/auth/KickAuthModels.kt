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
    @SerialName("user_id")
    val id: Long? = null,
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
    val broadcasterUserId: Long,
    val content: String,
    val type: String = "user",
    @SerialName("reply_to_message_id")
    val replyToMessageId: String? = null,
)

@Serializable
data class KickBackendExchangeRequest(
    val code: String,
    val codeVerifier: String,
    val redirectUri: String,
)

@Serializable
data class KickBackendRefreshRequest(
    val refreshToken: String,
)

@Serializable
data class KickBackendRevokeRequest(
    val token: String,
    val tokenTypeHint: String? = null,
)

@Serializable
data class KickBackendIntrospectRequest(
    val token: String,
)

@Serializable
data class KickChatSendResponse(
    val data: KickChatSendData? = null,
    val status: String? = null,
    val message: String? = null,
)

@Serializable
data class KickChatSendData(
    @SerialName("is_sent")
    val isSent: Boolean? = null,
    @SerialName("message_id")
    val messageId: String? = null,
)
