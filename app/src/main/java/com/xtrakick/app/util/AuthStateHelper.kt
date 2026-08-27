package com.xtrakick.app.util

import android.content.Context
import android.webkit.CookieManager
import android.webkit.WebStorage
import androidx.core.content.edit
import java.net.URLDecoder

object AuthStateHelper {

    private const val ACCESS_TOKEN_EXPIRY_BUFFER_SECONDS = 30L

    fun isKickLoggedIn(context: Context, nowEpochSeconds: Long = System.currentTimeMillis() / 1000L): Boolean {
        val prefs = context.tokenPrefs()
        return isKickSessionAvailable(
            accessToken = prefs.getString(AppConstants.KICK_ACCESS_TOKEN, null),
            refreshToken = prefs.getString(AppConstants.KICK_REFRESH_TOKEN, null),
            user = prefs.getString(AppConstants.KICK_USER_LOGIN, null),
            userId = prefs.getString(AppConstants.KICK_USER_ID, null),
            expiresAt = prefs.getLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L),
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
            accessToken = context.tokenPrefs().getString(AppConstants.KICK_ACCESS_TOKEN, null),
            expiresAt = context.tokenPrefs().getLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L),
            nowEpochSeconds = nowEpochSeconds,
        )
    }

    /** Flushes the WebView jar after login and reports whether Kick issued a session bearer. */
    fun captureKickWebsiteSession(): Boolean {
        val cookieManager = CookieManager.getInstance()
        runCatching { cookieManager.flush() }
        val cookieHeader = sequenceOf("https://kick.com", "https://web.kick.com")
            .mapNotNull { url -> runCatching { cookieManager.getCookie(url) }.getOrNull() }
            .firstOrNull { header -> extractKickSessionToken(header) != null }
        return cookieHeader?.let(::extractKickSessionToken) != null
    }

    internal fun extractKickSessionToken(cookieHeader: String?): String? {
        val rawValue = cookieHeader
            ?.split(';')
            ?: return null
        val encodedToken = rawValue
            .asSequence()
            .map { it.trim() }
            .firstOrNull { cookie ->
                cookie.substringBefore('=').trim().equals("session_token", ignoreCase = true)
            }
            ?.substringAfter('=')
            ?.takeIf { it.isNotBlank() }
            ?: return null
        return runCatching { URLDecoder.decode(encodedToken, Charsets.UTF_8.name()) }
            .getOrDefault(encodedToken)
            .takeIf { it.isNotBlank() && it.contains('|') }
    }

    internal fun selectKickWebsiteCookieHeader(vararg cookieHeaders: String?): String? {
        val availableHeaders = cookieHeaders.mapNotNull { it?.takeIf(String::isNotBlank) }
        return availableHeaders.firstOrNull { extractKickSessionToken(it) != null }
            ?: availableHeaders.firstOrNull()
    }

    fun hasPendingUnexpectedLogoutNotice(context: Context): Boolean {
        return context.tokenPrefs().getBoolean(AppConstants.KICK_UNEXPECTED_LOGOUT_PENDING, false)
    }

    fun markUnexpectedLogout(context: Context) {
        context.tokenPrefs().edit {
            putBoolean(AppConstants.KICK_UNEXPECTED_LOGOUT_PENDING, true)
        }
    }

    fun clearUnexpectedLogoutNotice(context: Context) {
        context.tokenPrefs().edit {
            remove(AppConstants.KICK_UNEXPECTED_LOGOUT_PENDING)
        }
    }

    fun clearKickAuth(context: Context) {
        context.tokenPrefs().edit {
            remove(AppConstants.KICK_ACCESS_TOKEN)
            remove(AppConstants.KICK_REFRESH_TOKEN)
            remove(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT)
            remove(AppConstants.KICK_TOKEN_TYPE)
            remove(AppConstants.KICK_USER_ID)
            remove(AppConstants.KICK_USER_LOGIN)
            remove(AppConstants.KICK_AUTH_STATE)
            remove(AppConstants.KICK_PKCE_VERIFIER)
        }
        clearWebViewSession()
    }

    /**
     * Clearing SharedPreferences alone left the kick.com session cookies on disk, so the next
     * person to open the follow-import dialog was silently signed in as the previous user —
     * and switching accounts was impossible without clearing app data.
     *
     * Only the follow-import flow and [com.xtrakick.app.ui.common.IntegrityDialog]
     * use the WebView cookie jar, so clearing all of it is safe here.
     */
    fun clearWebViewSession() {
        runCatching {
            CookieManager.getInstance().apply {
                removeAllCookies(null)
                flush()
            }
        }
        runCatching {
            WebStorage.getInstance().deleteAllData()
        }
    }

    fun clearLegacyWebAuth(context: Context) {
        context.tokenPrefs().edit {
            remove(AppConstants.TOKEN)
            remove(AppConstants.GQL_HEADERS)
            remove(AppConstants.GQL_TOKEN2)
            remove(AppConstants.GQL_TOKEN_WEB)
            remove(AppConstants.GQL_TOKEN)
            remove(AppConstants.USER_ID)
            remove(AppConstants.USERNAME)
            remove(AppConstants.INTEGRITY_EXPIRATION)
        }
        context.prefs().edit {
            remove(AppConstants.API_LOGIN)
            remove(AppConstants.HELIX_CLIENT_ID)
            remove(AppConstants.HELIX_REDIRECT)
            remove(AppConstants.GQL_CLIENT_ID)
            remove(AppConstants.GQL_REDIRECT)
            remove(AppConstants.GQL_CLIENT_ID2)
            remove(AppConstants.GQL_REDIRECT2)
            remove(AppConstants.GQL_CLIENT_ID_WEB)
            remove(AppConstants.CHAT_PUBSUB_ENABLED)
            remove(AppConstants.CHAT_POINTS_COLLECT)
            remove(AppConstants.CHAT_POINTS_NOTIFY)
            remove(AppConstants.CHAT_RAIDS_SHOW)
            remove(AppConstants.CHAT_RAIDS_AUTO_SWITCH)
            remove(AppConstants.CHAT_POLLS_SHOW)
            remove(AppConstants.CHAT_PREDICTIONS_SHOW)
            remove(AppConstants.DEBUG_EVENTSUB_CHAT)
            remove(AppConstants.GET_ALL_GQL_HEADERS)
        }
    }
}
