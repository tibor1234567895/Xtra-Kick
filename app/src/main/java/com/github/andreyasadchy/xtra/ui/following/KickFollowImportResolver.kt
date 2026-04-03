package com.github.andreyasadchy.xtra.ui.following

import android.util.Log

internal const val KICK_HOME_URL = "https://kick.com/"
internal const val KICK_LOGIN_URL = "https://id.kick.com/en/login"
internal const val KICK_FOLLOWING_URL = "https://kick.com/following/channels"

internal data class KickFollowImportResolution(
    val waitingForManualLogin: Boolean,
    val shouldAttemptImport: Boolean = false,
    val navigateTo: String? = null,
)

internal object KickFollowImportResolver {

    private const val LOG_TAG = "KickFollowResolver"

    fun isKickHomeUrl(url: String): Boolean {
        return url.equals(KICK_HOME_URL, ignoreCase = true) ||
            url.equals("https://kick.com", ignoreCase = true)
    }

    fun resolve(
        url: String,
        waitingForManualLogin: Boolean,
        importAttempted: Boolean,
        importCompleted: Boolean,
        kickCookieHeader: String?,
    ): KickFollowImportResolution? {
        Log.i(
            LOG_TAG,
            "resolve: url=$url waitingForManualLogin=$waitingForManualLogin importAttempted=$importAttempted importCompleted=$importCompleted",
        )
        if (!isKickImportUrl(url) || importCompleted || importAttempted) {
            Log.i(LOG_TAG, "resolve: skipped due to url/import state")
            return null
        }
        if (isKickLoginUrl(url)) {
            Log.i(LOG_TAG, "resolve: login url detected")
            return KickFollowImportResolution(waitingForManualLogin = true)
        }
        val hasWebsiteSession = hasKickWebsiteSession(kickCookieHeader)
        val onFollowingPage = isKickFollowingUrl(url)
        Log.i(LOG_TAG, "resolve: hasWebsiteSession=$hasWebsiteSession onFollowingPage=$onFollowingPage")
        if (waitingForManualLogin) {
            if (!onFollowingPage) {
                Log.i(LOG_TAG, "resolve: still waiting manual login on non-following page")
                return KickFollowImportResolution(waitingForManualLogin = true)
            }
            return if (hasWebsiteSession) {
                Log.i(LOG_TAG, "resolve: manual login complete, attempting import")
                KickFollowImportResolution(
                    waitingForManualLogin = false,
                    shouldAttemptImport = true,
                )
            } else {
                Log.i(LOG_TAG, "resolve: following page without confirmed website session")
                KickFollowImportResolution(
                    waitingForManualLogin = true,
                )
            }
        }
        if (!hasWebsiteSession) {
            return if (onFollowingPage) {
                Log.i(LOG_TAG, "resolve: no website session while on following page")
                KickFollowImportResolution(waitingForManualLogin = true)
            } else {
                Log.i(LOG_TAG, "resolve: navigating to following page to trigger login/session")
                KickFollowImportResolution(
                    waitingForManualLogin = true,
                    navigateTo = KICK_FOLLOWING_URL,
                )
            }
        }
        return if (onFollowingPage) {
            Log.i(LOG_TAG, "resolve: session confirmed on following page, attempt import")
            KickFollowImportResolution(
                waitingForManualLogin = false,
                shouldAttemptImport = true,
            )
        } else {
            Log.i(LOG_TAG, "resolve: session confirmed but not on following page, navigating")
            KickFollowImportResolution(
                waitingForManualLogin = false,
                navigateTo = KICK_FOLLOWING_URL,
            )
        }
    }

    fun isKickLoginUrl(url: String): Boolean {
        return url.startsWith(KICK_LOGIN_URL, ignoreCase = true) ||
            url.startsWith("https://id.kick.com/", ignoreCase = true)
    }

    fun isKickFollowingUrl(url: String): Boolean {
        return url.startsWith(KICK_FOLLOWING_URL, ignoreCase = true)
    }

    fun isKickImportUrl(url: String): Boolean {
        return url.startsWith("https://kick.com", ignoreCase = true) ||
            url.startsWith("https://id.kick.com/", ignoreCase = true)
    }

    fun hasKickWebsiteSession(cookieHeader: String?): Boolean {
        if (cookieHeader.isNullOrBlank()) {
            Log.i(LOG_TAG, "hasKickWebsiteSession: cookie header is blank")
            return false
        }
        val cookieNames = cookieHeader.split(';')
            .asSequence()
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .map { it.substringBefore('=').trim().lowercase() }
            .toSet()
        val hasSessionCookie = cookieNames.any { it == "xsrf-token" || it.endsWith("_session") }
        Log.i(LOG_TAG, "hasKickWebsiteSession: cookieNames=$cookieNames hasSessionCookie=$hasSessionCookie")
        return hasSessionCookie
    }
}
