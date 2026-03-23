package com.github.andreyasadchy.xtra.ui.player

import android.net.Uri
import android.util.Log
import com.github.andreyasadchy.xtra.BuildConfig
import java.net.Proxy
import java.net.URI

object PlaybackProxyUtils {
    private const val TAG = "PlaybackProxy"
    private val playlistExtensions = listOf(".m3u8")
    private val invalidProxyHosts = setOf("0.0.0.0", "localhost", "::1")

    @JvmStatic
    fun isValidProxyConfiguration(proxyHost: String?, proxyPort: Int?): Boolean {
        val host = proxyHost?.trim()?.lowercase().orEmpty()
        return host.isNotBlank() &&
            host !in invalidProxyHosts &&
            !host.startsWith("127.") &&
            proxyPort != null &&
            proxyPort in 1..65535
    }

    @JvmStatic
    fun shouldProxyPlaylist(uri: Uri?): Boolean {
        if (uri == null) {
            return false
        }
        val scheme = uri.scheme?.lowercase()
        if (scheme != "http" && scheme != "https") {
            return false
        }
        val path = uri.encodedPath?.lowercase().orEmpty()
        return playlistExtensions.any { path.endsWith(it) }
    }

    @JvmStatic
    fun shouldProxyPlaylist(uri: URI?): Boolean {
        if (uri == null) {
            return false
        }
        val scheme = uri.scheme?.lowercase()
        if (scheme != "http" && scheme != "https") {
            return false
        }
        val path = uri.rawPath?.lowercase().orEmpty()
        return playlistExtensions.any { path.endsWith(it) }
    }

    @JvmStatic
    fun selectProxy(uri: URI, proxy: Proxy, reason: String): List<Proxy> {
        val shouldUseProxy = shouldProxyPlaylist(uri)
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "route=${if (shouldUseProxy) "proxy" else "direct"} reason=$reason uri=$uri")
        }
        return if (shouldUseProxy) {
            listOf(proxy, Proxy.NO_PROXY)
        } else {
            listOf(Proxy.NO_PROXY)
        }
    }

    @JvmStatic
    fun logInvalidProxyConfiguration(reason: String, proxyHost: String?, proxyPort: Int?) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, "Ignoring invalid playback proxy for $reason host=$proxyHost port=$proxyPort")
        }
    }
}
