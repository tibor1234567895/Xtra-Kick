package com.xtrakick.app.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

class AuthStateHelperTest {

    @Test
    fun expiredAccessTokenStaysLoggedInWhenRefreshTokenExists() {
        val loggedIn = AuthStateHelper.isKickSessionAvailable(
            accessToken = "access-token",
            refreshToken = "refresh-token",
            user = "impulsespoon646",
            userId = null,
            expiresAt = 1000L,
            nowEpochSeconds = 1000L,
        )

        assertTrue(loggedIn)
    }

    @Test
    fun expiredAccessTokenWithoutRefreshTokenIsLoggedOut() {
        val loggedIn = AuthStateHelper.isKickSessionAvailable(
            accessToken = "access-token",
            refreshToken = null,
            user = "impulsespoon646",
            userId = null,
            expiresAt = 1000L,
            nowEpochSeconds = 1000L,
        )

        assertFalse(loggedIn)
    }

    @Test
    fun sessionWithoutIdentityIsLoggedOut() {
        val loggedIn = AuthStateHelper.isKickSessionAvailable(
            accessToken = "access-token",
            refreshToken = "refresh-token",
            user = null,
            userId = null,
            expiresAt = 2000L,
            nowEpochSeconds = 1000L,
        )

        assertFalse(loggedIn)
    }

    @Test
    fun accessTokenExpiringWithinBufferIsNotUsable() {
        val usable = AuthStateHelper.isKickAccessTokenUsable(
            expiresAt = 1030L,
            nowEpochSeconds = 1000L,
        )

        assertFalse(usable)
    }

    @Test
    fun accessTokenOutsideBufferIsUsable() {
        val usable = AuthStateHelper.isKickAccessTokenUsable(
            expiresAt = 1031L,
            nowEpochSeconds = 1000L,
        )

        assertTrue(usable)
    }

    @Test
    fun bearerTokenReturnsNullWhenAccessTokenExpired() {
        val bearer = AuthStateHelper.getKickBearerToken(
            accessToken = "access-token",
            expiresAt = 1000L,
            nowEpochSeconds = 1000L,
        )

        assertNull(bearer)
    }

    @Test
    fun bearerTokenReturnedWhenAccessTokenUsable() {
        val bearer = AuthStateHelper.getKickBearerToken(
            accessToken = "access-token",
            expiresAt = 1100L,
            nowEpochSeconds = 1000L,
        )

        assertEquals("Bearer access-token", bearer)
    }

    @Test
    fun sessionTokenIsDecodedFromCookieHeader() {
        assertEquals(
            "420708377|token-value",
            AuthStateHelper.extractKickSessionToken("kick_session=opaque; session_token=420708377%7Ctoken-value"),
        )
    }

    @Test
    fun opaqueSessionTokenWithoutPipeIsAccepted() {
        val fixture = "EXAMPLE_OPAQUE_SESSION_TOKEN_WITHOUT_PIPE" // gitleaks:allow - synthetic test fixture, not a credential.
        assertEquals(
            fixture,
            AuthStateHelper.extractKickSessionToken(
                "kick_session=opaque; session_token=$fixture" // gitleaks:allow - synthetic test fixture, not a credential.
            ),
        )
    }

    @Test
    fun blankSessionTokenIsRejected() {
        assertNull(AuthStateHelper.extractKickSessionToken("kick_session=opaque; session_token=   "))
        assertNull(AuthStateHelper.extractKickSessionToken("kick_session=opaque"))
    }

    @Test
    fun staleGoogleFlagDetectedFromRefreshToken() {
        assertTrue(AuthStateHelper.isStaleGoogleLoginMethod(refreshToken = "refresh-token", expiresAt = 0L))
    }

    @Test
    fun staleGoogleFlagDetectedFromExpiry() {
        assertTrue(AuthStateHelper.isStaleGoogleLoginMethod(refreshToken = null, expiresAt = 1791039633L))
    }

    @Test
    fun genuineGoogleSessionIsNotStale() {
        assertFalse(AuthStateHelper.isStaleGoogleLoginMethod(refreshToken = null, expiresAt = 0L))
    }

    @Test
    fun cookieSelectionPrefersHeaderWithUsableSessionToken() {
        val selected = AuthStateHelper.selectKickWebsiteCookieHeader(
            "auth-token=oauth-token; kick_session=opaque",
            "session_token=420708377%7Ctoken-value; XSRF-TOKEN=xsrf",
        )

        assertEquals("session_token=420708377%7Ctoken-value; XSRF-TOKEN=xsrf", selected)
    }
}
