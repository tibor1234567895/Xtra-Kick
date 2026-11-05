package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.auth.KickBackendRefreshRequest
import java.net.ServerSocket
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class AuthRepositoryCancellationTest {
    @Test
    fun cancellingUserLookupAbortsTheRequest() = checkCancellation {
        it.getKickCurrentUser("OkHttp", "test-token")
    }

    @Test
    fun cancellingTokenRefreshAbortsTheRequest() = checkCancellation {
        it.refreshKickToken("OkHttp", "https://example.invalid", KickBackendRefreshRequest("test-refresh"))
    }

    private fun checkCancellation(fetch: suspend (AuthRepository) -> Unit) = runBlocking {
        ServerSocket(0).use { server ->
            val started = CompletableDeferred<Unit>()
            val release = CountDownLatch(1)
            val peer = thread(isDaemon = true) {
                server.accept().use { socket ->
                    val input = socket.getInputStream().bufferedReader()
                    while (!input.readLine().isNullOrEmpty()) { }
                    started.complete(Unit)
                    release.await(5, TimeUnit.SECONDS)
                }
            }
            val executor = Executors.newSingleThreadExecutor()
            val client = OkHttpClient.Builder().addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().url("http://127.0.0.1:${server.localPort}/").build())
            }.build()
            val repository = AuthRepository(null, null, executor, client, Json { ignoreUnknownKeys = true })
            val request = async { fetch(repository) }
            try {
                withTimeout(3000) { started.await() }
                withTimeout(1000) { request.cancelAndJoin() }
            } finally {
                release.countDown()
                request.cancelAndJoin()
                peer.join(1000)
                client.connectionPool.evictAll()
                client.dispatcher.executorService.shutdownNow()
                executor.shutdownNow()
            }
        }
    }
}
