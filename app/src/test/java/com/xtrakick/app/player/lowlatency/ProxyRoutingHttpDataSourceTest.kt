package com.xtrakick.app.player.lowlatency

import android.app.Application
import android.net.Uri
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.HttpDataSource
import androidx.media3.datasource.TransferListener
import androidx.media3.datasource.okhttp.OkHttpDataSource
import com.sun.net.httpserver.HttpServer
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URI
import java.util.concurrent.atomic.AtomicReference

@UnstableApi
@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class ProxyRoutingHttpDataSourceTest {

    @Test
    fun okHttpSelectsThePlaylistProxyAfterACrossHostRedirect() {
        val origin = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        val proxyServer = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        val redirectedUrl = "http://localhost:${origin.address.port}/live.m3u8"
        val proxiedUri = AtomicReference<URI>()
        val originAuth = AtomicReference<String?>()
        val redirectedAuth = AtomicReference<String?>()
        val body = "#EXTM3U\n".encodeToByteArray()
        origin.createContext("/start") { exchange ->
            originAuth.set(exchange.requestHeaders.getFirst("Authorization"))
            exchange.responseHeaders.set("Location", redirectedUrl)
            exchange.sendResponseHeaders(302, -1)
            exchange.close()
        }
        proxyServer.createContext("/") { exchange ->
            proxiedUri.set(exchange.requestURI)
            redirectedAuth.set(exchange.requestHeaders.getFirst("Authorization"))
            exchange.sendResponseHeaders(200, body.size.toLong())
            exchange.responseBody.use { it.write(body) }
        }
        val proxy = Proxy(Proxy.Type.HTTP, proxyServer.address)
        val client = OkHttpClient.Builder()
            .dns { listOf(InetAddress.getByAddress(byteArrayOf(127, 0, 0, 1))) }
            .followRedirects(false)
            .build()
        val proxyClient = client.newBuilder().proxy(proxy).build()
        val source = ProxyRoutingHttpDataSource.Factory(
            OkHttpDataSource.Factory(client), OkHttpDataSource.Factory(proxyClient), followPlaylistRedirects = true,
        ).setDefaultRequestProperties(mapOf("Authorization" to "Bearer fixture")).createDataSource()
        origin.start()
        proxyServer.start()
        try {
            val entryUrl = "http://127.0.0.1:${origin.address.port}/start"
            assertEquals(body.size.toLong(), source.open(DataSpec(Uri.parse(entryUrl))))
            assertEquals(URI(redirectedUrl), proxiedUri.get())
            assertEquals("Bearer fixture", originAuth.get())
            assertNull(redirectedAuth.get())
        } finally {
            source.close()
            client.connectionPool.evictAll()
            origin.stop(0)
            proxyServer.stop(0)
        }
    }

    private class RecordingHttpDataSource(
        private val responseCodeValue: Int = 200,
        private val failOpen: Boolean = false,
    ) : HttpDataSource {
        val openedUris = mutableListOf<Uri>()
        val listeners = mutableListOf<TransferListener>()
        val requestProps = mutableMapOf<String, String>()
        var closeCount = 0
        var lastUri: Uri? = null

        override fun addTransferListener(transferListener: TransferListener) {
            listeners += transferListener
        }

        override fun open(dataSpec: DataSpec): Long {
            openedUris += dataSpec.uri
            lastUri = dataSpec.uri
            if (failOpen) throw IOException("simulated open failure")
            return 42L
        }

        override fun read(buffer: ByteArray, offset: Int, length: Int): Int = -1

        override fun getUri(): Uri? = lastUri

        override fun getResponseCode(): Int = responseCodeValue

        override fun getResponseHeaders(): Map<String, List<String>> =
            mapOf("X-Code" to listOf(responseCodeValue.toString()))

        override fun close() {
            closeCount++
        }

        override fun setRequestProperty(name: String, value: String) {
            requestProps[name] = value
        }

        override fun clearRequestProperty(name: String) {
            requestProps.remove(name)
        }

        override fun clearAllRequestProperties() {
            requestProps.clear()
        }
    }

    private class RecordingFactory(val delegate: RecordingHttpDataSource) : HttpDataSource.Factory {
        val defaultProps = mutableMapOf<String, String>()

        override fun setDefaultRequestProperties(defaultRequestProperties: Map<String, String>): HttpDataSource.Factory {
            defaultProps.clear()
            defaultProps.putAll(defaultRequestProperties)
            return this
        }

        override fun createDataSource(): HttpDataSource = delegate
    }

    @Test
    fun routesPlaylistsToProxyAndSegmentsToPrimary() {
        val primary = RecordingHttpDataSource(responseCodeValue = 200)
        val proxy = RecordingHttpDataSource(responseCodeValue = 206)
        val dataSource = ProxyRoutingHttpDataSource.Factory(
            RecordingFactory(primary),
            RecordingFactory(proxy),
        ).createDataSource()

        val playlistUri = Uri.parse("https://edge.kick.com/live/master.m3u8?token=abc")
        val segmentUri = Uri.parse("https://edge.kick.com/live/seg001.ts")

        assertEquals(42L, dataSource.open(DataSpec(playlistUri)))
        assertEquals(206, dataSource.responseCode)
        assertEquals(playlistUri, dataSource.uri)
        dataSource.close()

        assertEquals(42L, dataSource.open(DataSpec(segmentUri)))
        assertEquals(200, dataSource.responseCode)
        assertEquals(segmentUri, dataSource.uri)
        dataSource.close()

        assertEquals(listOf(playlistUri), proxy.openedUris)
        assertEquals(listOf(segmentUri), primary.openedUris)
        assertEquals(1, proxy.closeCount)
        assertEquals(1, primary.closeCount)
    }

    @Test
    fun forwardsHeadersAndTransferListenersToBothDelegates() {
        val primary = RecordingHttpDataSource()
        val proxy = RecordingHttpDataSource()
        val primaryFactory = RecordingFactory(primary)
        val proxyFactory = RecordingFactory(proxy)

        val factory = ProxyRoutingHttpDataSource.Factory(primaryFactory, proxyFactory)
        factory.setDefaultRequestProperties(mapOf("User-Agent" to "XtraTest"))
        assertEquals(mapOf("User-Agent" to "XtraTest"), primaryFactory.defaultProps)
        assertEquals(mapOf("User-Agent" to "XtraTest"), proxyFactory.defaultProps)

        val dataSource = factory.createDataSource()
        val listener = object : TransferListener {
            override fun onTransferInitializing(source: DataSource, dataSpec: DataSpec, isNetwork: Boolean) = Unit
            override fun onTransferStart(source: DataSource, dataSpec: DataSpec, isNetwork: Boolean) = Unit
            override fun onBytesTransferred(source: DataSource, dataSpec: DataSpec, isNetwork: Boolean, bytesTransferred: Int) = Unit
            override fun onTransferEnd(source: DataSource, dataSpec: DataSpec, isNetwork: Boolean) = Unit
        }
        dataSource.addTransferListener(listener)
        assertEquals(1, primary.listeners.size)
        assertEquals(1, proxy.listeners.size)

        dataSource.setRequestProperty("X-Custom", "1")
        assertEquals("1", primary.requestProps["X-Custom"])
        assertEquals("1", proxy.requestProps["X-Custom"])

        dataSource.clearRequestProperty("X-Custom")
        assertEquals(null, primary.requestProps["X-Custom"])
        assertEquals(null, proxy.requestProps["X-Custom"])

        dataSource.setRequestProperty("A", "1")
        dataSource.clearAllRequestProperties()
        assertEquals(emptyMap<String, String>(), primary.requestProps)
        assertEquals(emptyMap<String, String>(), proxy.requestProps)
    }

    @Test
    fun closesActiveDelegateEvenAfterOpenFailure() {
        val primary = RecordingHttpDataSource()
        val proxy = RecordingHttpDataSource(failOpen = true)
        val dataSource = ProxyRoutingHttpDataSource.Factory(
            RecordingFactory(primary),
            RecordingFactory(proxy),
        ).createDataSource()

        val playlistUri = Uri.parse("https://edge.kick.com/live/master.m3u8")
        assertThrows(IOException::class.java) { dataSource.open(DataSpec(playlistUri)) }
        dataSource.close()

        assertEquals(1, proxy.closeCount)
        assertEquals(0, primary.closeCount)
    }
}
