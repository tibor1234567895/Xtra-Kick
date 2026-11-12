package com.xtrakick.app.repository

import android.webkit.CookieManager
import android.appwidget.AppWidgetManager
import android.widget.FrameLayout
import android.widget.TextView
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import com.xtrakick.app.R
import com.xtrakick.app.ui.widget.LiveChannelsRemoteViewsFactory
import com.xtrakick.app.ui.widget.LiveChannelsWidgetProvider
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.async
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
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class FollowedLiveStreamsRepositoryTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    private val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
    private val json = Json { ignoreUnknownKeys = true }
    private val executor = Executors.newSingleThreadExecutor()
    private val requests = CopyOnWriteArrayList<Request>()
    private val active = AtomicInteger()
    private val peak = AtomicInteger()
    private var publicStatus = 503
    private var channelStatus = 200
    private var channelGate: CountDownLatch? = null
    private var publicGate: CountDownLatch? = null
    private var publicEntered: CountDownLatch? = null
    private var cancelPublic = false
    private var officialLiveResponse = "[]"
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        requests += request
        val path = request.url.encodedPath
        var status = 200
        val body = when {
            path == "/api/v1/user/livestreams" -> officialLiveResponse
            path == "/public/v1/livestreams" -> {
                if (cancelPublic) throw kotlinx.coroutines.CancellationException("Refresh cancelled")
                publicEntered?.countDown()
                publicGate?.await(5, TimeUnit.SECONDS)
                status = publicStatus
                """{"data":[${(1..27).joinToString { """{"broadcaster_user_id":${1000 + it},"slug":"follow$it","viewer_count":$it}""" }}]}"""
            }
            path == "/public/v1/users/livestreams" -> {
                status = publicStatus
                """{"data":[]}"""
            }
            path.matches(Regex("/api/v2/channels/follow\\d+")) -> {
                status = channelStatus
                val index = path.substringAfterLast("follow").toInt()
                if (index > 4) channelGate?.await(5, TimeUnit.SECONDS)
                val count = active.incrementAndGet()
                peak.updateAndGet { maxOf(it, count) }
                try {
                    Thread.sleep(10)
                    """{"id":$index,"user_id":${1000 + index},"slug":"follow$index","livestream":{
                        "id":${2000 + index},"viewer_count":$index,"category":{"id":8,"name":"GTA"},
                        "thumbnail":{"url":"https://example.com/$index.jpg"}}}"""
                } finally {
                    active.decrementAndGet()
                }
            }
            path.endsWith("/event") -> """{"data":null}"""
            else -> """{"data":[]}"""
        }
        Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(status).message("fixture")
            .body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()

    private fun repository(): FollowedLiveStreamsRepository {
        val kick = KickRepository(context, client, null, executor, json,
            AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))
        val publicApi = KickPublicApiRepository(null, null, executor, client, json)
        return FollowedLiveStreamsRepository(context, follows, publicApi, kick, json)
    }

    private suspend fun addFollows() {
        for (index in 1..27) follows.saveFollow(LocalFollowChannel("${1000 + index}", "follow$index"))
    }

    @Test
    fun officialLiveDoesNotIntroduceUnimportedFollowsDuringVisit() = runBlocking {
        login("google")
        follows.saveFollow(LocalFollowChannel("1001", "follow1", sourceMask = 2))
        officialLiveResponse = """[
            {"id":2001,"channel":{"id":1,"slug":"follow1","user_id":1001}},
            {"id":2002,"channel":{"id":2,"slug":"follow2","user_id":1002}}
        ]"""
        assertEquals(listOf("follow1"), repository().loadLiveFollowed(true, true).items.map { it.channelLogin })
    }

    @Test
    fun previouslyLiveSavedChannelSurvivesExternalUnfollowUntilSyncApplies() = runBlocking {
        login("google")
        follows.saveFollow(LocalFollowChannel("1001", "follow1", sourceMask = 2))
        officialLiveResponse = """[{"id":2001,"channel":{"id":1,"slug":"follow1","user_id":1001}}]"""
        val loader = repository()
        loader.loadLiveFollowed(true, true)
        officialLiveResponse = "[]"
        assertEquals(listOf("follow1"), loader.loadLiveFollowed(true, true).items.map { it.channelLogin })
        assertTrue(requests.any { it.url.encodedPath == "/api/v2/channels/follow1" })
        follows.reconcileKickFollows(emptyList()) { true }
        assertTrue(loader.loadLiveFollowed(true, true).items.isEmpty())
    }

    private fun login(state: String) {
        context.tokenPrefs().edit().clear().commit()
        context.prefs().edit().clear().commit()
        CookieManager.getInstance().removeAllCookies(null)
        if (state in listOf("oauth", "combined", "expired")) {
            context.tokenPrefs().edit().putString(AppConstants.KICK_ACCESS_TOKEN, "fixture-token")
                .putLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, if (state == "expired") 1L else Long.MAX_VALUE).commit()
        } else if (state == "google") {
            context.tokenPrefs().edit().putString(AppConstants.KICK_ACCESS_TOKEN, "fixture-mobile-token")
                .putString(AppConstants.KICK_LOGIN_METHOD, AppConstants.KICK_LOGIN_METHOD_GOOGLE).commit()
        }
        if (state in listOf("web", "combined")) {
            CookieManager.getInstance().setCookie("https://kick.com", "session_token=fixture-session; Path=/")
        }
        requests.clear()
    }

    @After fun close() {
        channelGate?.countDown()
        publicGate?.countDown()
        login("logged-out")
        database.close()
        executor.shutdownNow()
    }

    @Test fun fallbackLoadsBeyondTwentyProgressivelyForEveryLoginMode() = runBlocking {
        addFollows()
        for (state in listOf("logged-out", "oauth", "web", "combined", "google", "expired")) {
            login(state)
            val partialSizes = mutableListOf<Int>()
            val result = repository().loadLiveFollowed(forceRefresh = true, allowPerChannelFallback = true) {
                partialSizes += it.size
            }
            assertEquals(state, 27, result.items.size)
            assertEquals(state, "follow27", result.items.first().channelLogin)
            assertTrue(state, partialSizes.any { it in 1..26 })
            assertEquals(state, 27, requests.count { it.url.encodedPath.matches(Regex("/api/v2/channels/follow\\d+")) })
            assertTrue(state, peak.get() <= 4)
        }
    }

    @Test fun successfulPublicBatchAvoidsPerChannelRequests() = runBlocking {
        addFollows()
        login("oauth")
        publicStatus = 200
        val result = repository().loadLiveFollowed(forceRefresh = true, allowPerChannelFallback = true)
        assertEquals(27, result.items.size)
        assertEquals(1, requests.count { it.url.encodedPath == "/public/v1/livestreams" })
        assertFalse(requests.any { it.url.encodedPath.startsWith("/api/v2/channels/follow") })
    }

    @Test fun rateLimitStopsFurtherFallbackBatches() = runBlocking {
        addFollows()
        login("logged-out")
        channelStatus = 429
        assertTrue(repository().loadLiveFollowed(forceRefresh = true, allowPerChannelFallback = true).items.isEmpty())
        assertEquals(4, requests.count { it.url.encodedPath.matches(Regex("/api/v2/channels/follow\\d+")) })
    }

    @Test fun cachedConsumersDoNotWaitForTheRestOfALargeFollowingRefresh() = runBlocking {
        addFollows()
        login("logged-out")
        val repository = repository()
        val firstBatch = CompletableDeferred<Unit>()
        val gate = CountDownLatch(1)
        channelGate = gate
        val refresh = async {
            repository.loadLiveFollowed(forceRefresh = true, allowPerChannelFallback = true) {
                if (it.size == 4) firstBatch.complete(Unit)
            }
        }
        try {
            withTimeout(5_000) { firstBatch.await() }
            val cached = withTimeout(1_000) { repository.loadLiveFollowed() }
            assertTrue(cached.fromCache)
            assertEquals(4, cached.items.size)
            assertTrue(refresh.isActive)
        } finally {
            gate.countDown()
        }
        assertEquals(27, refresh.await().items.size)
    }

    @Test fun widgetUsesFreshCacheAndOnlyExplicitRefreshForcesANetworkReload() = runBlocking {
        addFollows()
        login("oauth")
        publicStatus = 200
        val repository = repository()
        val loaded = repository.loadLiveFollowed(forceRefresh = true)
        loaded.items.forEach { it.profileImageUrl = "data:image/png;base64,invalid-test-image" }
        val factory = LiveChannelsRemoteViewsFactory(context, repository)
        try {
            // Playback prefetch runs independently; count the following-data request being tested.
            val before = requests.count { it.url.encodedPath == "/public/v1/livestreams" }
            factory.onDataSetChanged()
            assertEquals(before, requests.count { it.url.encodedPath == "/public/v1/livestreams" })
            assertEquals(27, factory.getCount())
            val row = factory.getViewAt(0)!!.apply(context, FrameLayout(context))
            assertEquals("follow27", row.findViewById<TextView>(R.id.widgetChannelName).text.toString())
            shadowOf(AppWidgetManager.getInstance(context)).createWidget(LiveChannelsWidgetProvider::class.java, R.layout.widget_live_channels)
            LiveChannelsWidgetProvider.notifyDataChanged(context, forceRefresh = true)
            factory.onDataSetChanged()
            assertEquals(2, requests.count { it.url.encodedPath == "/public/v1/livestreams" })
        } finally {
            factory.onDestroy()
            LiveChannelsWidgetProvider.consumeRefreshRequest()
        }
    }

    @Test fun widgetClearsOldAccountRowsWhenTheAccountChangesDuringRefresh() = runBlocking {
        login("oauth")
        for (index in 1..27) {
            follows.saveFollow(LocalFollowChannel("${1000 + index}", "follow$index", sourceMask = AppConstants.FOLLOW_SOURCE_MASK_KICK))
        }
        publicStatus = 200
        val repository = repository()
        repository.loadLiveFollowed(forceRefresh = true)
        val factory = LiveChannelsRemoteViewsFactory(context, repository)
        try {
            factory.onDataSetChanged()
            assertEquals(27, factory.getCount())
            shadowOf(AppWidgetManager.getInstance(context)).createWidget(LiveChannelsWidgetProvider::class.java, R.layout.widget_live_channels)
            LiveChannelsWidgetProvider.notifyDataChanged(context, forceRefresh = true)
            val entered = CountDownLatch(1).also { publicEntered = it }
            val release = CountDownLatch(1).also { publicGate = it }
            val refresh = async(kotlinx.coroutines.Dispatchers.IO) { factory.onDataSetChanged() }
            try {
                kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
                    assertTrue(entered.await(5, TimeUnit.SECONDS))
                }
                context.tokenPrefs().edit().putString(AppConstants.KICK_USER_ID, "new-account").commit()
                follows.clearKickFollows()
            } finally {
                release.countDown()
            }
            refresh.await()
            assertTrue(repository.peekCache().isEmpty())
            assertEquals(0, factory.getCount())
        } finally {
            factory.onDestroy()
            LiveChannelsWidgetProvider.consumeRefreshRequest()
        }
    }

    @Test fun widgetKeepsSameAccountCacheWhenRefreshFails() = runBlocking {
        addFollows()
        login("oauth")
        publicStatus = 200
        val repository = repository()
        repository.loadLiveFollowed(forceRefresh = true)
        val factory = LiveChannelsRemoteViewsFactory(context, repository)
        try {
            factory.onDataSetChanged()
            cancelPublic = true
            shadowOf(AppWidgetManager.getInstance(context)).createWidget(LiveChannelsWidgetProvider::class.java, R.layout.widget_live_channels)
            LiveChannelsWidgetProvider.notifyDataChanged(context, forceRefresh = true)
            factory.onDataSetChanged()
            assertEquals(27, factory.getCount())
        } finally {
            factory.onDestroy()
            LiveChannelsWidgetProvider.consumeRefreshRequest()
        }
    }
}
