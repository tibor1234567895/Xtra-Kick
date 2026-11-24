package com.xtrakick.app.util

import android.app.Application
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.NotificationUser
import kotlinx.coroutines.async
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.net.ServerSocket
import java.util.concurrent.CountDownLatch
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.json.JSONObject

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class FcmSyncManagerTest {
    @Test fun onlyNewBackendCompletionIsCacheable() {
        fun response(code: Int, body: String) = Response.Builder()
            .request(Request.Builder().url("https://example.invalid").build())
            .protocol(Protocol.HTTP_1_1).code(code).message("fixture").body(body.toResponseBody()).build()

        assertFalse(response(200, """{"ok":true}""").use(::isCompleteRegistration))
        assertFalse(response(200, """{"complete":"true"}""").use(::isCompleteRegistration))
        assertFalse(response(503, """{"complete":true}""").use(::isCompleteRegistration))
        assertTrue(response(200, """{"complete":true}""").use(::isCompleteRegistration))
    }

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

    @Test fun queuedReconciliationUsesCurrentAlertsAndAccountAfterAnOlderUnsubscribe() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        val unsubscribeStarted = CompletableDeferred<Unit>()
        val releaseUnsubscribe = CountDownLatch(1)
        val paths = CopyOnWriteArrayList<String>()
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request()
            paths += request.url.encodedPath
            if (request.url.encodedPath.endsWith("/unsubscribe")) {
                unsubscribeStarted.complete(Unit)
                assertTrue(releaseUnsubscribe.await(5, TimeUnit.SECONDS))
            } else {
                val body = JSONObject(Buffer().also { request.body!!.writeTo(it) }.readUtf8())
                assertEquals("new-account", body.getString("kick_user_id"))
                assertEquals("42", body.getJSONArray("channel_ids").getString(0))
            }
            Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("fixture")
                .body("""{"ok":true,"complete":true}""".toResponseBody()).build()
        }.build()
        try {
            val manager = FcmSyncManager(context, database.notificationsDao(), okHttpClient = client)
            context.prefs().edit().putBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false).commit()
            suspend fun reconcile() = manager.reconcileSubscriptions("https://example.invalid", scheduleRetry = false) { "queue-token" }

            withTimeout(5_000L) {
                val first = async { reconcile() }
                unsubscribeStarted.await()
                val queued = async { reconcile() }
                withContext(Dispatchers.IO) { database.notificationsDao().insert(NotificationUser("42")) }
                context.tokenPrefs().edit().putString(AppConstants.USER_ID, "new-account").commit()
                context.prefs().edit().putBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, true).commit()
                releaseUnsubscribe.countDown()
                assertTrue(first.await())
                assertTrue(queued.await())
                assertTrue(reconcile())
            }
            assertEquals(listOf("/v1/fcm/unsubscribe", "/v1/fcm/subscribe"), paths)
        } finally {
            releaseUnsubscribe.countDown()
            context.tokenPrefs().edit().remove(AppConstants.USER_ID).commit()
            database.close()
            client.dispatcher.executorService.shutdownNow()
        }
    }
}
