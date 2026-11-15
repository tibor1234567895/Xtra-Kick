package com.xtrakick.app.util

import com.xtrakick.app.util.NetworkUtils.useCancellable
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException
import java.net.ServerSocket
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class NetworkUtilsTest {
    @Test
    fun downloadDeadlineCancelsTheConcreteRequest() = runBlocking {
        var cancellations = 0
        val error = runCatching {
            NetworkUtils.awaitDownloadRequest<Unit>(timeoutMs = 10) { continuation, _ ->
                val cancel: () -> Unit = {
                    cancellations++
                    continuation.resumeWithException(IOException("Timed out"))
                }
                cancel
            }
        }.exceptionOrNull()
        assertTrue(error is IOException)
        assertEquals(1, cancellations)
    }

    @Test
    fun cancelledDownloadWaitsForTerminalCallbackBeforeReturning() = runBlocking {
        val started = CompletableDeferred<Continuation<Unit>>()
        val cancellationRequested = CompletableDeferred<Unit>()
        val transfer = launch {
            NetworkUtils.awaitDownloadRequest<Unit> { continuation, _ ->
                started.complete(continuation)
                val cancel: () -> Unit = { cancellationRequested.complete(Unit); Unit }
                cancel
            }
        }
        withTimeout(5_000L) {
            val terminal = started.await()
            transfer.cancel()
            cancellationRequested.await()
            assertFalse(transfer.isCompleted)
            terminal.resume(Unit)
            transfer.join()
        }
    }

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
