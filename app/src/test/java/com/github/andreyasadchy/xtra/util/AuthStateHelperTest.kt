package com.github.andreyasadchy.xtra.util

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
}
