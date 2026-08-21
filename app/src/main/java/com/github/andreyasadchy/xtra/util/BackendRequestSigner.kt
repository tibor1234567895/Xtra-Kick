package com.github.andreyasadchy.xtra.util

import java.net.URI
import java.security.MessageDigest
import java.util.UUID
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object BackendRequestSigner {

    const val HEADER_TIMESTAMP = "X-Auth-Timestamp"
    const val HEADER_NONCE = "X-Auth-Nonce"
    const val HEADER_SIGNATURE = "X-Auth-Signature"

    fun sign(secret: String, method: String, url: String, body: ByteArray?): Map<String, String> {
        if (secret.isBlank()) return emptyMap()
        return signWithParts(
            secret = secret,
            method = method,
            url = url,
            body = body,
            timestamp = (System.currentTimeMillis() / 1000).toString(),
            nonce = UUID.randomUUID().toString(),
        )
    }

    internal fun signWithParts(
        secret: String,
        method: String,
        url: String,
        body: ByteArray?,
        timestamp: String,
        nonce: String,
    ): Map<String, String> {
        if (secret.isBlank()) return emptyMap()
        val pathname = URI(url).rawPath.orEmpty().ifEmpty { "/" }
        val bodySha256 = MessageDigest.getInstance("SHA-256")
            .digest(body ?: ByteArray(0))
            .joinToString("") { "%02x".format(it) }
        val canonical = "$timestamp\n$nonce\n${method.uppercase()}\n$pathname\n$bodySha256"
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(SecretKeySpec(secret.toByteArray(), "HmacSHA256"))
        val signature = mac.doFinal(canonical.toByteArray()).joinToString("") { "%02x".format(it) }
        return mapOf(
            HEADER_TIMESTAMP to timestamp,
            HEADER_NONCE to nonce,
            HEADER_SIGNATURE to signature,
        )
    }
}
