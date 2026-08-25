package com.xtrakick.app.ui.following

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
    fun staysOnManualLoginWhenStillMissingWebsiteSession() {
        val resolution = KickFollowImportResolver.resolve(
            url = KICK_HOME_URL,
            waitingForManualLogin = true,
            importAttempted = false,
            importCompleted = false,
            kickCookieHeader = "auth-token=abc123",
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

    @Test
    fun recognizesKickHomeUrlVariants() {
        assertTrue(KickFollowImportResolver.isKickHomeUrl("https://kick.com"))
        assertTrue(KickFollowImportResolver.isKickHomeUrl("https://kick.com/"))
        assertFalse(KickFollowImportResolver.isKickHomeUrl(KICK_FOLLOWING_URL))
    }

    @Test
    fun allowsOnlyKickOrigins() {
        assertTrue(KickFollowImportResolver.isAllowedImportOrigin("https://kick.com/following/channels"))
        assertTrue(KickFollowImportResolver.isAllowedImportOrigin("https://KICK.COM/"))
        assertTrue(KickFollowImportResolver.isAllowedImportOrigin("https://id.kick.com/en/login"))
        assertTrue(KickFollowImportResolver.isAllowedImportOrigin("https://web.kick.com/anything"))
    }

    @Test
    fun rejectsLookalikeAndInsecureOrigins() {
        // A prefix check would accept this one — the bridge must not be reachable from it.
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin("https://kick.com.evil.test/"))
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin("https://evilkick.com/"))
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin("http://kick.com/"))
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin("javascript:alert(1)"))
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin("about:blank"))
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin(""))
        assertFalse(KickFollowImportResolver.isAllowedImportOrigin(null))
    }
}
