package com.xtrakick.app.util

import android.app.Application
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withTimeout
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.net.ServerSocket
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class FcmSyncManagerTest {
    @Test fun transportPreservesTheSignedBodyAndHeadersAndReportsHttpFailures() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        val body = "{\"token\":\"test-token\",\"channel_ids\":[\"42\"]}".toByteArray()
        var status = 204
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request()
            assertEquals("POST", request.method)
            assertEquals("test-signature", request.header("X-Test-Signature"))
            assertEquals("application/json", request.header("Content-Type"))
            assertArrayEquals(body, Buffer().also { request.body!!.writeTo(it) }.readByteArray())
            Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(status).message("fixture")
                .body("".toResponseBody()).build()
        }.build()
        try {
            val manager = FcmSyncManager(context, database.notificationsDao(), okHttpClient = client)
            assertTrue(manager.postSubscriptionRequest("https://example.invalid/subscribe", body,
                mapOf("X-Test-Signature" to "test-signature")))
            status = 503
            assertFalse(manager.postSubscriptionRequest("https://example.invalid/subscribe", body,
                mapOf("X-Test-Signature" to "test-signature")))
        } finally {
            database.close()
            client.dispatcher.executorService.shutdownNow()
        }
    }

    @Test fun cancellingSubscriptionTransportClosesAStalledRequest() = runBlocking {
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
            val context = RuntimeEnvironment.getApplication()
            val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
            val manager = FcmSyncManager(context, database.notificationsDao())
            val request = async { manager.postSubscriptionRequest("http://127.0.0.1:${server.localPort}/", "{}".toByteArray(), emptyMap()) }
            try {
                withTimeout(3000) { started.await() }
                withTimeout(1000) { request.cancelAndJoin() }
            } finally {
                release.countDown()
                request.cancelAndJoin()
                peer.join(1000)
                database.close()
            }
        }
    }

    @Test fun subscriptionAndUnsubscriptionShareTheSameSerializationBoundary() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        try {
            val manager = FcmSyncManager(context, database.notificationsDao())
            val mutex = FcmSyncManager::class.java.getDeclaredField("subscriptionMutex")
                .apply { isAccessible = true }.get(manager) as Mutex
            mutex.lock()
            val sync = async { manager.syncSubscriptions("test-token") }
            val unsubscribe = async { manager.unsubscribe("test-token") }
            delay(50)
            assertFalse(sync.isCompleted)
            assertFalse(unsubscribe.isCompleted)
            mutex.unlock()
            withTimeout(2000) {
                // Debug operations leave the production subscription store alone.
                assertFalse(sync.await())
                assertFalse(unsubscribe.await())
            }
        } finally { database.close() }
    }
}
