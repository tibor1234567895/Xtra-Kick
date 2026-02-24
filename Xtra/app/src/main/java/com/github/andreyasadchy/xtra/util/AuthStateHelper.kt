package com.github.andreyasadchy.xtra.util

import android.content.Context
import androidx.core.content.edit

object AuthStateHelper {

    fun isKickLoggedIn(context: Context, nowEpochSeconds: Long = System.currentTimeMillis() / 1000L): Boolean {
        val prefs = context.tokenPrefs()
        val token = prefs.getString(C.KICK_ACCESS_TOKEN, null)
        val user = prefs.getString(C.KICK_USER_LOGIN, null)
        val userId = prefs.getString(C.KICK_USER_ID, null)
        val expiresAt = prefs.getLong(C.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L)
        val notExpiredOrUnknown = expiresAt <= 0L || expiresAt > nowEpochSeconds + 30L
        return !token.isNullOrBlank() && notExpiredOrUnknown && (!user.isNullOrBlank() || !userId.isNullOrBlank())
    }

    fun getKickBearerToken(context: Context): String? {
        return context.tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null)?.takeIf { it.isNotBlank() }?.let { "Bearer $it" }
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
