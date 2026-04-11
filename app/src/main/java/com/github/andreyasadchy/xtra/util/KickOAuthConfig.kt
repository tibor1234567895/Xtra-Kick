package com.github.andreyasadchy.xtra.util

import android.content.Context
import com.github.andreyasadchy.xtra.BuildConfig

object KickOAuthConfig {

    const val DEFAULT_REDIRECT_URI = "https://localhost/callback"
    private const val DEFAULT_SCOPES = "user:read chat:write events:subscribe"
    private val REQUIRED_SCOPES = setOf("user:read", "chat:write")

    fun getClientId(context: Context): String? {
        val debugOverride = if (BuildConfig.DEBUG) {
            context.prefs().getString(C.KICK_DEBUG_CLIENT_ID_OVERRIDE, null)
        } else {
            null
        }
        return debugOverride?.takeIf { it.isNotBlank() }
            ?: BuildConfig.KICK_CLIENT_ID.takeIf { it.isNotBlank() }
            ?: context.prefs().getString(C.KICK_CLIENT_ID, null)?.takeIf { it.isNotBlank() }
    }

    fun getBackendBaseUrl(context: Context): String? {
        val debugOverride = if (BuildConfig.DEBUG) {
            context.prefs().getString(C.KICK_DEBUG_OAUTH_BACKEND_OVERRIDE, null)
        } else {
            null
        }
        return debugOverride?.takeIf { it.isNotBlank() }
            ?: BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.takeIf { it.isNotBlank() }
    }

    fun getRedirectUri(context: Context): String {
        val configured = context.prefs().getString(C.KICK_REDIRECT_URI, DEFAULT_REDIRECT_URI)
            ?.takeIf { it.isNotBlank() }
            ?: DEFAULT_REDIRECT_URI
        return configured.takeIf(::isHttpsRedirect) ?: DEFAULT_REDIRECT_URI
    }

    fun getConfiguredScopes(context: Context): String {
        return context.prefs().getString(C.KICK_SCOPES, DEFAULT_SCOPES)
            ?.trim()
            ?.takeIf { it.isNotBlank() }
            ?: DEFAULT_SCOPES
    }

    fun hasRequiredScopes(scopes: String?): Boolean {
        val parsed = parseScopes(scopes)
        return REQUIRED_SCOPES.all { parsed.contains(it) }
    }

    fun hasScopes(scopes: String?, requiredScopes: Set<String>): Boolean {
        val parsed = parseScopes(scopes)
        return requiredScopes.all(parsed::contains)
    }

    fun normalizeScopes(scopes: String?): String {
        val ordered = linkedSetOf<String>()
        REQUIRED_SCOPES.forEach { ordered.add(it) }
        parseScopes(scopes).forEach { ordered.add(it) }
        return ordered.joinToString(" ")
    }

    private fun parseScopes(scopes: String?): Set<String> {
        return scopes
            ?.trim()
            ?.split(Regex("\\s+"))
            ?.mapNotNull { it.trim().takeIf(String::isNotBlank) }
            ?.toSet()
            ?: emptySet()
    }

    private fun isHttpsRedirect(uri: String): Boolean {
        return runCatching { android.net.Uri.parse(uri) }
            .getOrNull()
            ?.let { parsed -> parsed.scheme.equals("https", true) && !parsed.host.isNullOrBlank() }
            ?: false
    }
}
