package com.xtrakick.app.ui.chat

import android.os.Looper
import android.os.SystemClock
import androidx.lifecycle.ViewModelStore
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.repository.*
import com.xtrakick.app.util.tokenPrefs
import com.xtrakick.app.ui.player.PlayerViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors
import java.time.Duration

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class ChatLoadingTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    private val executor = Executors.newSingleThreadExecutor()
    private val json = Json { ignoreUnknownKeys = true }
    private val requests = CopyOnWriteArrayList<Request>()
    private var historyMode = "empty"
    private val message = """{"id":"m1","content":"hello","created_at":"2026-11-02T10:00:00Z","sender":{"id":43,"username":"tester"}}"""
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        requests += request
        val path = request.url.encodedPath
        var status = 200
        val body = when {
            path == "/api/v2/channels/quiet" -> """{"id":42,"user_id":43,"slug":"quiet","chatroom":{"id":9}}"""
            path == "/api/v2/channels/quiet/livestream" -> """{"data":{"id":17,"viewer_count":21}}"""
            path == "/api/v1/chat/42/history" -> when (historyMode) {
                "error" -> { status = 503; "{}" }
                "malformed" -> if (request.url.host == "web.kick.com") "{}" else """{"data":{"messages":[$message]}}"""
                else -> """{"data":{"messages":[]}}"""
            }
            path == "/api/v2/channels/42/messages" -> """{"messages":[$message]}"""
            else -> "{}"
        }
        Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(status).message("fixture")
            .body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()
    private val kick = KickRepository(context, client, null, executor, json,
        AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))
    private val publicApi = KickPublicApiRepository(null, null, executor, client, json)
    private val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
    private val notifications = NotificationUsersRepository(context, database.notificationsDao(), kick, dagger.Lazy { error("Unused FCM") })
    private val shown = ShownNotificationsRepository(context, database.shownNotificationsDao(), kick, publicApi, notifications, follows)
    private val player = PlayerRepository(context, null, null, executor, client, json, kick, publicApi, database.recentEmotes(), database.videoPositions())
    private val viewModel = ChatViewModel(context, publicApi, kick, MutedChatUsersRepository(database.mutedChatUsers()),
        KickAccountMutedUsersStore(kick), player, shown, null, json)
    private val store = ViewModelStore().apply { put("chat", viewModel) }

    @After fun close() {
        store.clear()
        shadowOf(Looper.getMainLooper()).idle()
        database.close()
        context.tokenPrefs().edit().clear().commit()
        executor.shutdownNow()
    }

    private suspend fun finish(job: Job) = withTimeout(5_000) {
        while (job.isActive) {
            shadowOf(Looper.getMainLooper()).idle()
            delay(5)
        }
        job.join()
    }

    @Test fun verifiedEmptyChatStopsWithoutProbingOtherIdsOrEndpointFamilies() = runBlocking {
        finish(viewModel.loadRecentMessages("OkHttp", "quiet", "43"))
        assertTrue(viewModel.chatMessages.isEmpty())
        assertEquals(listOf("/api/v1/chat/42/history"), requests.map { it.url.encodedPath }
            .filter { it.startsWith("/api/v1/chat/") || it.endsWith("/messages") })
    }

    @Test fun failedHistoryStillUsesRecentMessagesFallbackWithTheCanonicalId() = runBlocking {
        historyMode = "error"
        finish(viewModel.loadRecentMessages("OkHttp", "quiet", "43"))
        assertEquals(listOf("hello"), viewModel.chatMessages.mapNotNull { it.message })
        assertEquals(2, requests.count { it.url.encodedPath == "/api/v1/chat/42/history" })
        assertEquals(1, requests.count { it.url.encodedPath == "/api/v2/channels/42/messages" })
        assertFalse(requests.any { it.url.encodedPath in listOf("/api/v1/chat/43/history", "/api/v1/chat/9/history",
            "/api/v2/channels/43/messages", "/api/v2/channels/9/messages") })
    }

    @Test fun malformedHistoryIsNotAcceptedAsAQuietChannel() = runBlocking {
        historyMode = "malformed"
        finish(viewModel.loadRecentMessages("OkHttp", "quiet", "43"))
        assertEquals(listOf("hello"), viewModel.chatMessages.mapNotNull { it.message })
        assertEquals(2, requests.count { it.url.encodedPath == "/api/v1/chat/42/history" })
        assertFalse(requests.any { it.url.encodedPath.endsWith("/messages") })
    }

    @Test fun viewerPollingWaitsForStaleWebSocketCountsAndStopsForVideos() = runBlocking {
        val model = PlayerViewModel(publicApi, kick, follows, shown, notifications, null, null, executor, client,
            player, BookmarksRepository(database.bookmarks(), database.videos()),
            OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks()))
        store.put("player", model)
        model.loadStream("42", "quiet", 10, false, "OkHttp", emptyMap(), emptyMap(), false)
        withTimeout(5_000) {
            while (model.stream.value == null) {
                shadowOf(Looper.getMainLooper()).idle()
                delay(5)
            }
        }
        assertFalse(requests.any { it.url.encodedPath.endsWith("/livestream") })
        shadowOf(Looper.getMainLooper()).idleFor(Duration.ofSeconds(30))
        model.onWebSocketViewerCount(SystemClock.elapsedRealtime())
        shadowOf(Looper.getMainLooper()).idleFor(Duration.ofSeconds(30))
        assertFalse(requests.any { it.url.encodedPath.endsWith("/livestream") })
        shadowOf(Looper.getMainLooper()).idleFor(Duration.ofSeconds(60))
        withTimeout(5_000) {
            while (model.viewerCountUpdate.value == null) {
                shadowOf(Looper.getMainLooper()).idle()
                delay(5)
            }
        }
        assertEquals(21, model.viewerCountUpdate.value)
        assertEquals(1, requests.count { it.url.encodedPath.endsWith("/livestream") })
        model.loadVideo("OkHttp", emptyMap(), null, "kick", "42", "quiet", null, null, false)
        shadowOf(Looper.getMainLooper()).idleFor(Duration.ofMinutes(3))
        assertEquals(1, requests.count { it.url.encodedPath.endsWith("/livestream") })
    }
}
