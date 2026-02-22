package com.github.andreyasadchy.xtra.util

import android.net.Uri
import android.util.Base64
import java.security.MessageDigest
import java.security.SecureRandom

object KickPkceHelper {

    private const val VERIFIER_LENGTH = 64
    private const val STATE_LENGTH = 24
    private const val ALLOWED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~"
    private val random = SecureRandom()

    fun generateCodeVerifier(length: Int = VERIFIER_LENGTH): String {
        return buildString(length.coerceIn(43, 128)) {
            repeat(length.coerceIn(43, 128)) {
                append(ALLOWED[random.nextInt(ALLOWED.length)])
            }
        }
    }

    fun generateState(length: Int = STATE_LENGTH): String {
        return buildString(length.coerceAtLeast(12)) {
            repeat(length.coerceAtLeast(12)) {
                append(ALLOWED[random.nextInt(ALLOWED.length)])
            }
        }
    }

    fun codeChallenge(verifier: String): String {
        val digest = MessageDigest.getInstance("SHA-256").digest(verifier.toByteArray())
        return Base64.encodeToString(digest, Base64.NO_WRAP or Base64.NO_PADDING or Base64.URL_SAFE)
    }

    fun buildAuthorizeUrl(clientId: String, redirectUri: String, scopes: String, state: String, codeChallenge: String): String {
        return Uri.Builder()
            .scheme("https")
            .authority("id.kick.com")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter("response_type", "code")
            .appendQueryParameter("client_id", clientId)
            .appendQueryParameter("redirect_uri", redirectUri)
            .appendQueryParameter("scope", scopes)
            .appendQueryParameter("state", state)
            .appendQueryParameter("code_challenge", codeChallenge)
            .appendQueryParameter("code_challenge_method", "S256")
            .build()
            .toString()
    }
}
