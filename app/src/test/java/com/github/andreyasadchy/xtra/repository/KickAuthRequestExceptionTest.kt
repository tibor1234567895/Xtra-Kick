package com.github.andreyasadchy.xtra.repository

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
    fun classifyKeepsNonBackendIoErrorsGeneric() {
        val error = KickAuthRequestException.classify(
            IOException("network"),
            isBackendRequest = false
        )

        assertFalse(KickAuthRequestException.isBackendUnavailable(error))
        assertFalse(KickAuthRequestException.isUnauthorized(error))
    }
}
