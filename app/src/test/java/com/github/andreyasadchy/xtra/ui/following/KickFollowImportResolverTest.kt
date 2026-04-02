package com.github.andreyasadchy.xtra.ui.following

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KickFollowImportResolverTest {

    @Test
    fun redirectsUnauthenticatedHomeToFollowing() {
        val resolution = KickFollowImportResolver.resolve(
            url = KICK_HOME_URL,
            waitingForManualLogin = false,
            importAttempted = false,
            importCompleted = false,
            kickCookieHeader = "auth-token=abc123",
        )

        assertEquals(
            KickFollowImportResolution(
                waitingForManualLogin = true,
                navigateTo = KICK_FOLLOWING_URL,
            ),
            resolution
        )
    }

    @Test
    fun waitsOnLoginRouteWithoutImporting() {
        val resolution = KickFollowImportResolver.resolve(
            url = KICK_LOGIN_URL,
            waitingForManualLogin = true,
            importAttempted = false,
            importCompleted = false,
            kickCookieHeader = null,
        )

        assertEquals(
            KickFollowImportResolution(waitingForManualLogin = true),
            resolution
        )
    }

    @Test
    fun redirectsAuthenticatedHomeToFollowingBeforeImport() {
        val resolution = KickFollowImportResolver.resolve(
            url = KICK_HOME_URL,
            waitingForManualLogin = false,
            importAttempted = false,
            importCompleted = false,
            kickCookieHeader = "auth-token=abc123; XSRF-TOKEN=token; kick_session=session",
        )

        assertEquals(
            KickFollowImportResolution(
                waitingForManualLogin = false,
                navigateTo = KICK_FOLLOWING_URL,
            ),
            resolution
        )
    }

    @Test
    fun importsWhenAuthenticatedOnFollowingPage() {
        val resolution = KickFollowImportResolver.resolve(
            url = KICK_FOLLOWING_URL,
            waitingForManualLogin = true,
            importAttempted = false,
            importCompleted = false,
            kickCookieHeader = "XSRF-TOKEN=token; kick_session=session",
        )

        assertEquals(
            KickFollowImportResolution(
                waitingForManualLogin = false,
                shouldAttemptImport = true,
            ),
            resolution
        )
    }

    @Test
    fun ignoresPagesOnceImportAlreadyStarted() {
        val resolution = KickFollowImportResolver.resolve(
            url = KICK_FOLLOWING_URL,
            waitingForManualLogin = false,
            importAttempted = true,
            importCompleted = false,
            kickCookieHeader = "XSRF-TOKEN=token; kick_session=session",
        )

        assertNull(resolution)
    }

    @Test
    fun websiteSessionRequiresMoreThanAuthToken() {
        assertFalse(KickFollowImportResolver.hasKickWebsiteSession("auth-token=abc123"))
        assertTrue(KickFollowImportResolver.hasKickWebsiteSession("auth-token=abc123; XSRF-TOKEN=token"))
    }
}
