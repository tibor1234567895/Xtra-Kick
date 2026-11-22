package com.xtrakick.app.player.lowlatency

import android.net.Uri
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.HttpDataSource
import androidx.media3.datasource.TransferListener
import com.xtrakick.app.ui.player.PlaybackProxyUtils
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

/**
 * Lightweight [HttpDataSource] decorator that routes playlist requests matching
 * [PlaybackProxyUtils.shouldProxyPlaylist] through an optional [proxyFactory]
 * (typically an OkHttp proxy client) and sends all other traffic to [primaryFactory].
 */
@UnstableApi
class ProxyRoutingHttpDataSource private constructor(
    private val primary: HttpDataSource,
    private val proxy: HttpDataSource?,
    private val redirectDefaults: HttpDataSource.RequestProperties?,
) : HttpDataSource {

    private var active: HttpDataSource = primary
    private val redirectProperties = redirectDefaults?.let { HttpDataSource.RequestProperties() }

    private companion object {
        const val MAX_REDIRECTS = 20
        val redirectCodes = setOf(300, 301, 302, 303, 307, 308)
        val originCredentials = setOf("authorization", "proxy-authorization", "cookie")
    }

    class Factory(
        private val primaryFactory: HttpDataSource.Factory,
        private val proxyFactory: HttpDataSource.Factory? = null,
        followPlaylistRedirects: Boolean = false,
    ) : HttpDataSource.Factory {

        private val redirectDefaults = if (followPlaylistRedirects) HttpDataSource.RequestProperties() else null

        override fun setDefaultRequestProperties(defaultRequestProperties: Map<String, String>): Factory {
            if (redirectDefaults != null) {
                redirectDefaults.clearAndSet(defaultRequestProperties)
            } else {
                primaryFactory.setDefaultRequestProperties(defaultRequestProperties)
                proxyFactory?.setDefaultRequestProperties(defaultRequestProperties)
            }
            return this
        }

        override fun createDataSource(): HttpDataSource {
            return ProxyRoutingHttpDataSource(
                primary = primaryFactory.createDataSource(),
                proxy = proxyFactory?.createDataSource(),
                redirectDefaults = redirectDefaults,
            )
        }
    }

    override fun addTransferListener(transferListener: TransferListener) {
        primary.addTransferListener(transferListener)
        proxy?.addTransferListener(transferListener)
    }

    override fun open(dataSpec: DataSpec): Long {
        val defaults = redirectDefaults ?: return openHop(dataSpec)
        val headers = defaults.snapshot.toMutableMap().apply {
            redirectProperties?.let { putAll(it.snapshot) }
            putAll(dataSpec.httpRequestHeaders)
        }
        var request = dataSpec.withRequestHeaders(headers)
        var redirects = 0
        while (true) {
            try {
                return openHop(request)
            } catch (error: HttpDataSource.InvalidResponseCodeException) {
                if (error.responseCode !in redirectCodes || redirects >= MAX_REDIRECTS) throw error
                if (request.httpMethod != DataSpec.HTTP_METHOD_GET && request.httpMethod != DataSpec.HTTP_METHOD_HEAD) throw error
                val origin = request.uri.toString().toHttpUrlOrNull() ?: throw error
                val location = error.headerFields.entries.firstOrNull { it.key.equals("Location", ignoreCase = true) }
                    ?.value?.firstOrNull() ?: throw error
                val destination = origin.resolve(location) ?: throw error
                if (destination.host != origin.host || destination.port != origin.port || destination.scheme != origin.scheme) {
                    headers.keys.removeAll { it.lowercase() in originCredentials }
                }
                active.close()
                request = request.withUri(Uri.parse(destination.toString())).withRequestHeaders(headers)
                redirects++
            }
        }
    }

    private fun openHop(dataSpec: DataSpec): Long {
        val target = if (proxy != null && PlaybackProxyUtils.shouldProxyPlaylist(dataSpec.uri)) {
            proxy
        } else {
            primary
        }
        active = target
        return target.open(dataSpec)
    }

    override fun read(buffer: ByteArray, offset: Int, length: Int): Int = active.read(buffer, offset, length)

    override fun getUri(): Uri? = active.uri

    override fun getResponseCode(): Int = active.responseCode

    override fun getResponseHeaders(): Map<String, List<String>> = active.responseHeaders

    override fun close() {
        active.close()
    }

    override fun setRequestProperty(name: String, value: String) {
        if (redirectProperties != null) {
            redirectProperties.set(name, value)
            return
        }
        primary.setRequestProperty(name, value)
        proxy?.setRequestProperty(name, value)
    }

    override fun clearRequestProperty(name: String) {
        if (redirectProperties != null) {
            redirectProperties.remove(name)
            return
        }
        primary.clearRequestProperty(name)
        proxy?.clearRequestProperty(name)
    }

    override fun clearAllRequestProperties() {
        if (redirectProperties != null) {
            redirectProperties.clear()
            return
        }
        primary.clearAllRequestProperties()
        proxy?.clearAllRequestProperties()
    }
}
