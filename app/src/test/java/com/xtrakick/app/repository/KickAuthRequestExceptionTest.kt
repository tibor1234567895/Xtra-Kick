package com.xtrakick.app.repository

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException

class KickAuthRequestExceptionTest {

    @Test
    fun classifyMarksInvalidBackendUrl() {
        val error = KickAuthRequestException.classify(
            IllegalArgumentException("bad url"),
            isBackendRequest = true
        )

        assertTrue(error is KickAuthRequestException.InvalidBackendUrl)
    }

    @Test
    fun classifyMarksBackendUnavailableForConnectFailures() {
        val error = KickAuthRequestException.classify(
            ConnectException("failed to connect"),
            isBackendRequest = true
        )

        assertTrue(error is KickAuthRequestException.BackendUnavailable)
        assertTrue(KickAuthRequestException.isBackendUnavailable(error))
    }

    @Test
    fun classifyMarksBackendUnavailableForTimeouts() {
        val socketTimeout = KickAuthRequestException.classify(
            SocketTimeoutException("timeout"),
            isBackendRequest = true
        )
        val interruptedTimeout = KickAuthRequestException.classify(
            InterruptedIOException("timeout"),
            isBackendRequest = true
        )

        assertTrue(socketTimeout is KickAuthRequestException.BackendUnavailable)
        assertTrue(interruptedTimeout is KickAuthRequestException.BackendUnavailable)
    }

    @Test
    fun classifyPreservesHttpFailures() {
        val error = KickAuthRequestException.classify(
            KickAuthRequestException.HttpFailure(401),
            isBackendRequest = true
        )

        assertTrue(error is KickAuthRequestException.HttpFailure)
        assertTrue(KickAuthRequestException.isUnauthorized(error))
    }

    @Test
    fun classifyRecognizesHttp400AsUnauthorized() {
        val error = KickAuthRequestException.classify(
            KickAuthRequestException.HttpFailure(400),
            isBackendRequest = true
        )

        assertTrue(error is KickAuthRequestException.HttpFailure)
        assertTrue(KickAuthRequestException.isUnauthorized(error))
    }

    @Test
    fun classifyKeepsNonBackendIoErrorsGeneric() {
        val error = KickAuthRequestException.classify(
            IOException("network"),
            isBackendRequest = false
        )

        assertFalse(KickAuthRequestException.isBackendUnavailable(error))
        assertFalse(KickAuthRequestException.isUnauthorized(error))
    }

    @Test
    fun sessionUnusableOnSyntheticHttpFailure() {
        // App-raised failures (nothing to refresh with) always force a logout.
        val error = KickAuthRequestException.HttpFailure(401, synthetic = true)

        assertTrue(KickAuthRequestException.isSessionUnusable(error))
    }

    @Test
    fun sessionUnusableOnExplicitInvalidGrant() {
        val direct = KickAuthRequestException.HttpFailure(
            400,
            body = "{\"code\":\"invalid_grant\",\"message\":\"Kick OAuth grant is invalid\"}"
        )
        val wrapped = IOException(direct)

        assertTrue(KickAuthRequestException.isSessionUnusable(direct))
        assertTrue(KickAuthRequestException.isSessionUnusable(wrapped))
    }

    @Test
    fun sessionUsableOnBackendSignatureFailure() {
        // The backend returns 401 {code:"unauthorized"} for bad request
        // signatures/clocks: retryable, must NOT wipe the session.
        val error = KickAuthRequestException.HttpFailure(
            401,
            body = "{\"code\":\"unauthorized\",\"message\":\"Request signature is invalid\"}"
        )

        assertFalse(KickAuthRequestException.isSessionUnusable(error))
    }

    @Test
    fun sessionUsableOnServerRateLimitAndTransportFailures() {
        assertFalse(KickAuthRequestException.isSessionUnusable(
            KickAuthRequestException.HttpFailure(502, body = "{\"code\":\"upstream_unavailable\"}")
        ))
        assertFalse(KickAuthRequestException.isSessionUnusable(KickAuthRequestException.HttpFailure(429)))
        assertFalse(KickAuthRequestException.isSessionUnusable(IOException("network dropped")))
    }

    @Test
    fun sessionUnusableOnLegacyIllegalState401() {
        assertTrue(KickAuthRequestException.isSessionUnusable(IllegalStateException("401")))
        assertFalse(KickAuthRequestException.isSessionUnusable(IllegalStateException("403")))
    }
}
