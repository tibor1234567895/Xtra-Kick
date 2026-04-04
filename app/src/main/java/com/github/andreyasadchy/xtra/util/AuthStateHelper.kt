package com.github.andreyasadchy.xtra.util

import android.content.Context
import androidx.core.content.edit

object AuthStateHelper {

    private const val ACCESS_TOKEN_EXPIRY_BUFFER_SECONDS = 30L

    fun isKickLoggedIn(context: Context, nowEpochSeconds: Long = System.currentTimeMillis() / 1000L): Boolean {
        val prefs = context.tokenPrefs()
        return isKickSessionAvailable(
            accessToken = prefs.getString(C.KICK_ACCESS_TOKEN, null),
            refreshToken = prefs.getString(C.KICK_REFRESH_TOKEN, null),
            user = prefs.getString(C.KICK_USER_LOGIN, null),
            userId = prefs.getString(C.KICK_USER_ID, null),
            expiresAt = prefs.getLong(C.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L),
            nowEpochSeconds = nowEpochSeconds,
        )
    }

    internal fun isKickSessionAvailable(
        accessToken: String?,
        refreshToken: String?,
        user: String?,
        userId: String?,
        expiresAt: Long,
        nowEpochSeconds: Long,
    ): Boolean {
        val hasIdentity = !user.isNullOrBlank() || !userId.isNullOrBlank()
        val hasAccessToken = !accessToken.isNullOrBlank()
        val hasRefreshToken = !refreshToken.isNullOrBlank()
        val accessTokenUsable = isKickAccessTokenUsable(expiresAt, nowEpochSeconds)
        return hasIdentity && ((hasAccessToken && accessTokenUsable) || hasRefreshToken)
    }

    internal fun isKickAccessTokenUsable(expiresAt: Long, nowEpochSeconds: Long): Boolean {
        return expiresAt <= 0L || expiresAt > nowEpochSeconds + ACCESS_TOKEN_EXPIRY_BUFFER_SECONDS
    }

    internal fun getKickBearerToken(
        accessToken: String?,
        expiresAt: Long,
        nowEpochSeconds: Long,
    ): String? {
        if (accessToken.isNullOrBlank()) {
            return null
        }
        if (!isKickAccessTokenUsable(expiresAt, nowEpochSeconds)) {
            return null
        }
        return "Bearer $accessToken"
    }

    fun getKickBearerToken(context: Context): String? {
        val nowEpochSeconds = System.currentTimeMillis() / 1000L
        return getKickBearerToken(
            accessToken = context.tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null),
            expiresAt = context.tokenPrefs().getLong(C.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L),
            nowEpochSeconds = nowEpochSeconds,
        )
    }

    fun hasPendingUnexpectedLogoutNotice(context: Context): Boolean {
        return context.tokenPrefs().getBoolean(C.KICK_UNEXPECTED_LOGOUT_PENDING, false)
    }

    fun markUnexpectedLogout(context: Context) {
        context.tokenPrefs().edit {
            putBoolean(C.KICK_UNEXPECTED_LOGOUT_PENDING, true)
        }
    }

    fun clearUnexpectedLogoutNotice(context: Context) {
        context.tokenPrefs().edit {
            remove(C.KICK_UNEXPECTED_LOGOUT_PENDING)
        }
    }

    fun clearKickAuth(context: Context) {
        context.tokenPrefs().edit {
            remove(C.KICK_ACCESS_TOKEN)
            remove(C.KICK_REFRESH_TOKEN)
            remove(C.KICK_ACCESS_TOKEN_EXPIRES_AT)
            remove(C.KICK_TOKEN_TYPE)
            remove(C.KICK_USER_ID)
            remove(C.KICK_USER_LOGIN)
            remove(C.KICK_AUTH_STATE)
            remove(C.KICK_PKCE_VERIFIER)
        }
    }

    fun clearLegacyTwitchAuth(context: Context) {
        context.tokenPrefs().edit {
            remove(C.TOKEN)
            remove(C.GQL_HEADERS)
            remove(C.GQL_TOKEN2)
            remove(C.GQL_TOKEN_WEB)
            remove(C.GQL_TOKEN)
            remove(C.USER_ID)
            remove(C.USERNAME)
            remove(C.INTEGRITY_EXPIRATION)
        }
        context.prefs().edit {
            remove(C.API_LOGIN)
            remove(C.HELIX_CLIENT_ID)
            remove(C.HELIX_REDIRECT)
            remove(C.GQL_CLIENT_ID)
            remove(C.GQL_REDIRECT)
            remove(C.GQL_CLIENT_ID2)
            remove(C.GQL_REDIRECT2)
            remove(C.GQL_CLIENT_ID_WEB)
            remove(C.CHAT_PUBSUB_ENABLED)
            remove(C.CHAT_POINTS_COLLECT)
            remove(C.CHAT_POINTS_NOTIFY)
            remove(C.CHAT_RAIDS_SHOW)
            remove(C.CHAT_RAIDS_AUTO_SWITCH)
            remove(C.CHAT_POLLS_SHOW)
            remove(C.CHAT_PREDICTIONS_SHOW)
            remove(C.DEBUG_EVENTSUB_CHAT)
            remove(C.GET_ALL_GQL_HEADERS)
        }
    }
}
