package com.xtrakick.app.repository

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.net.ServerSocket
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickRequestCancellationTest {
    @Test fun abandonedChannelRequestClosesSocketAndCanBeRetried() = runBlocking {
        ServerSocket(0).use { server ->
            val started = CompletableDeferred<Unit>()
            val disconnected = CompletableDeferred<Int>()
            val peer = thread(isDaemon = true) {
                repeat(2) { attempt ->
                    server.accept().use { socket ->
                        socket.soTimeout = 5_000
                        val input = socket.getInputStream().bufferedReader()
                        while (!input.readLine().isNullOrEmpty()) { }
                        if (attempt == 0) {
                            socket.getOutputStream().apply {
                                write("HTTP/1.1 200 OK\r\nContent-Length: 100\r\n\r\n{".toByteArray())
                                flush()
                            }
                            started.complete(Unit)
                            disconnected.complete(input.read())
                        } else {
                            val body = """{"id":42,"slug":"cancel-test"}"""
                            socket.getOutputStream().apply {
                                write("HTTP/1.1 200 OK\r\nContent-Length: ${body.length}\r\nConnection: close\r\n\r\n$body".toByteArray())
                                flush()
                            }
                        }
                    }
                }
            }
            val executor = Executors.newSingleThreadExecutor()
            val client = client(server.localPort)
            try {
                val repository = repository(client, executor)
                val load = async(Dispatchers.IO) { repository.getChannel("cancel-test", prefetchBadgeCatalog = false) }
                withTimeout(5_000) {
                    started.await()
                    load.cancelAndJoin()
                    assertEquals(-1, disconnected.await())
                    assertEquals(42L, repository.getChannel("cancel-test", prefetchBadgeCatalog = false).id)
                }
            } finally {
                client.connectionPool.evictAll()
                client.dispatcher.executorService.shutdownNow()
                executor.shutdownNow()
                peer.join(1_000)
            }
        }
    }

    @Test fun cancellingOneSharedWaiterDoesNotCancelTheOwnersRequest() = runBlocking {
        ServerSocket(0).use { server ->
            val started = CompletableDeferred<Unit>()
            val release = CountDownLatch(1)
            val peer = thread(isDaemon = true) {
                server.accept().use { socket ->
                    val input = socket.getInputStream().bufferedReader()
                    while (!input.readLine().isNullOrEmpty()) { }
                    started.complete(Unit)
                    release.await(5, TimeUnit.SECONDS)
                    val body = """{"id":42,"slug":"shared-test"}"""
                    socket.getOutputStream().apply {
                        write("HTTP/1.1 200 OK\r\nContent-Length: ${body.length}\r\nConnection: close\r\n\r\n$body".toByteArray())
                        flush()
                    }
                }
            }
            val executor = Executors.newSingleThreadExecutor()
            val client = client(server.localPort)
            try {
                val repository = repository(client, executor)
                withTimeout(5_000) {
                    val owner = async { repository.getChannel("shared-test", prefetchBadgeCatalog = false) }
                    started.await()
                    val waiter = async { repository.getChannel("shared-test", prefetchBadgeCatalog = false) }
                    kotlinx.coroutines.yield()
                    waiter.cancelAndJoin()
                    assertTrue(owner.isActive)
                    release.countDown()
                    assertEquals(42L, owner.await().id)
                }
            } finally {
                release.countDown()
                client.connectionPool.evictAll()
                client.dispatcher.executorService.shutdownNow()
                executor.shutdownNow()
                peer.join(1_000)
            }
        }
    }

    private fun client(port: Int) = OkHttpClient.Builder().addInterceptor { chain ->
        if (chain.request().url.encodedPath in listOf("/api/v2/channels/cancel-test", "/api/v2/channels/shared-test")) {
            chain.proceed(chain.request().newBuilder().url("http://127.0.0.1:$port/").build())
        } else {
            Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(200).message("fixture")
                .body("{}".toResponseBody()).build()
        }
    }.build()

    private fun repository(client: OkHttpClient, executor: java.util.concurrent.ExecutorService): KickRepository {
        val context = RuntimeEnvironment.getApplication()
        val json = Json { ignoreUnknownKeys = true }
        return KickRepository(context, client, null, executor, json,
            AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))
    }
}
