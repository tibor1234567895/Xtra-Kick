package com.github.andreyasadchy.xtra.ui.following

internal const val KICK_HOME_URL = "https://kick.com/"
internal const val KICK_LOGIN_URL = "https://kick.com/login"
internal const val KICK_FOLLOWING_URL = "https://kick.com/following/channels"

internal data class KickFollowImportResolution(
    val waitingForManualLogin: Boolean,
    val shouldAttemptImport: Boolean = false,
    val navigateTo: String? = null,
)

internal object KickFollowImportResolver {

    fun resolve(
        url: String,
        waitingForManualLogin: Boolean,
        importAttempted: Boolean,
        importCompleted: Boolean,
        kickCookieHeader: String?,
    ): KickFollowImportResolution? {
        if (!isKickImportUrl(url) || importCompleted || importAttempted) {
            return null
        }
        if (isKickLoginUrl(url)) {
            return KickFollowImportResolution(waitingForManualLogin = true)
        }
        val hasWebsiteSession = hasKickWebsiteSession(kickCookieHeader)
        val onFollowingPage = isKickFollowingUrl(url)
        if (waitingForManualLogin) {
            if (!hasWebsiteSession) {
                return if (onFollowingPage) {
                    KickFollowImportResolution(waitingForManualLogin = true)
                } else {
                    KickFollowImportResolution(
                        waitingForManualLogin = true,
                        navigateTo = KICK_FOLLOWING_URL,
                    )
                }
            }
            return if (onFollowingPage) {
                KickFollowImportResolution(
                    waitingForManualLogin = false,
                    shouldAttemptImport = true,
                )
            } else {
                KickFollowImportResolution(
                    waitingForManualLogin = false,
                    navigateTo = KICK_FOLLOWING_URL,
                )
            }
        }
        if (!hasWebsiteSession) {
            return if (onFollowingPage) {
                KickFollowImportResolution(waitingForManualLogin = true)
            } else {
                KickFollowImportResolution(
                    waitingForManualLogin = true,
                    navigateTo = KICK_FOLLOWING_URL,
                )
            }
        }
        return if (onFollowingPage) {
            KickFollowImportResolution(
                waitingForManualLogin = false,
                shouldAttemptImport = true,
            )
        } else {
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
            return false
        }
        val cookieNames = cookieHeader.split(';')
            .asSequence()
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .map { it.substringBefore('=').trim().lowercase() }
            .toSet()
        return cookieNames.any { it == "xsrf-token" || it.endsWith("_session") }
    }
}
