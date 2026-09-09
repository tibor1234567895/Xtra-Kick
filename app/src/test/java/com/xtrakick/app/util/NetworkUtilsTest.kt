package com.xtrakick.app.util

import com.xtrakick.app.util.NetworkUtils.useCancellable
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.ServerSocket
import kotlin.concurrent.thread

class NetworkUtilsTest {
    @Test
    fun cancellationClosesSocketWhileReadingBody() = runBlocking {
        ServerSocket(0).use { server ->
            val bodyStarted = CompletableDeferred<Unit>()
            val disconnected = CompletableDeferred<Int>()
            val peer = thread(isDaemon = true) {
                server.accept().use { socket ->
                    socket.soTimeout = 5000
                    val input = socket.getInputStream().bufferedReader()
                    while (!input.readLine().isNullOrEmpty()) { }
                    socket.getOutputStream().apply {
                        write("HTTP/1.1 200 OK\r\nContent-Length: 100\r\n\r\nx".toByteArray())
                        flush()
                    }
                    disconnected.complete(input.read())
                }
            }
            val client = OkHttpClient()
            try {
                val transfer = async(Dispatchers.IO) {
                    client.newCall(Request.Builder().url("http://127.0.0.1:${server.localPort}").build())
                        .useCancellable {
                            bodyStarted.complete(Unit)
                            it.body.string()
                        }
                }
                withTimeout(5000) {
                    bodyStarted.await()
                    transfer.cancelAndJoin()
                    assertEquals(-1, disconnected.await())
                }
            } finally {
                client.connectionPool.evictAll()
                client.dispatcher.executorService.shutdownNow()
                peer.join(1000)
            }
        }
    }
}
