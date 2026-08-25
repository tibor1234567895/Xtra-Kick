package com.github.andreyasadchy.xtra.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BackendRequestSignerTest {

    // Deliberately FAKE secret — never place the real backend HMAC secret in source.
    // The expected signature below is the reference value for this fake input, computed
    // with the canonical scheme shared with the backend's Node.js implementation
    // (server.js computeHmacSignature): HMAC-SHA256 over
    // "timestamp\nnonce\nMETHOD\npathname\nsha256hex(body)".
    private val secret = "test-secret-do-not-use-0001"

    @Test
    fun `signature matches backend reference implementation`() {
        val headers = BackendRequestSigner.signWithParts(
            secret = secret,
            method = "POST",
            url = "https://backend.example/v1/kick/oauth/exchange",
            body = """{"a":1}""".toByteArray(),
            timestamp = "1700000000",
            nonce = "test-nonce",
        )

        assertEquals("1700000000", headers[BackendRequestSigner.HEADER_TIMESTAMP])
        assertEquals("test-nonce", headers[BackendRequestSigner.HEADER_NONCE])
        assertEquals(
            "665ea01b2ef1abfce9a23bf010a5b7a84586ea91d83d4ee1f33bdc3f61206c39",
            headers[BackendRequestSigner.HEADER_SIGNATURE]
        )
    }

    @Test
    fun `blank secret produces no headers`() {
        val headers = BackendRequestSigner.sign("", "POST", "https://backend.example/v1/kick/oauth/exchange", null)
        assertTrue(headers.isEmpty())
    }

    @Test
    fun `live sign returns all three headers`() {
        val headers = BackendRequestSigner.sign(secret, "POST", "https://backend.example/v1/kick/oauth/refresh", "{}".toByteArray())
        assertTrue(headers.getValue(BackendRequestSigner.HEADER_TIMESTAMP).toLong() > 0)
        assertTrue(headers.getValue(BackendRequestSigner.HEADER_NONCE).isNotBlank())
        assertEquals(64, headers.getValue(BackendRequestSigner.HEADER_SIGNATURE).length)
    }
}
