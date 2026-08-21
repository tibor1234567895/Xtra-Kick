package com.github.andreyasadchy.xtra.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BackendRequestSignerTest {

    // Reference values generated with the backend's Node.js implementation
    // (server.js computeHmacSignature) so both sides stay in sync.
    private val secret = "bf5e39808213761d74b49a2c7817b6e0b7ac7950389c02532e2a273e5693a15f"

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
            "bab67859304ca0122086f434526d8a95ea93c6936019a129dc1c52d6ea75b160",
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
