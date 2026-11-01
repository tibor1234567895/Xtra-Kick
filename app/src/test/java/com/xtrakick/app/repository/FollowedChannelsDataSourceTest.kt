package com.xtrakick.app.repository

import androidx.paging.PagingSource
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.datasource.FollowedChannelsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.joinAll
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
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class FollowedChannelsDataSourceTest {
    private val executor = Executors.newSingleThreadExecutor()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val now = AtomicLong(0)
    private val requests = AtomicInteger()
    private lateinit var database: AppDatabase
    private lateinit var localFollows: LocalFollowChannelRepository
    private lateinit var repository: KickRepository
    private var response: (Request) -> Response = { request -> avatarResponse(request) }

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        localFollows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
        val json = Json { ignoreUnknownKeys = true }
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request()
            if (request.url.encodedPath.startsWith("/api/v2/channels/")) {
                requests.incrementAndGet()
                response(request)
            } else {
                avatarResponse(request, body = "{}")
            }
        }.build()
        repository = KickRepository(
            context, client, null, executor, json,
            AuthRepository(null, null, executor, client, json),
            KickOfficialApiClient(context, client, json),
        )
    }

    @After
    fun tearDown() {
        runBlocking {
            scope.cancel()
            scope.coroutineContext[Job]!!.join()
        }
        database.close()
        executor.shutdownNow()
    }

    @Test
    fun failedAvatarFetchRetriesAfterCooldownAndPopulatesTheList() = runBlocking {
        localFollows.saveFollow(LocalFollowChannel(userLogin = "retry-avatar"))
        response = { request ->
            if (requests.get() == 1) avatarResponse(request, status = 500) else avatarResponse(request)
        }
        load()
        awaitFetches()
        assertEquals(1, requests.get())
        assertNull(localFollows.loadFollows().single().channelLogo)

        load()
        awaitFetches()
        assertEquals(1, requests.get())

        now.set(60_001)
        load()
        awaitFetches()
        assertEquals(2, requests.get())
        assertEquals("https://example.com/avatar.jpg", localFollows.loadFollows().single().channelLogo)

        val rows = load() as PagingSource.LoadResult.Page<Int, User>
        assertEquals("https://example.com/avatar.jpg", rows.data.single().profileImageUrl)
        assertEquals(2, requests.get())
    }

    @Test
    fun successfulButIncompleteResponseCanBeRefetchedAfterCooldown() = runBlocking {
        localFollows.saveFollow(LocalFollowChannel(userLogin = "missing-avatar"))
        response = { request ->
            if (requests.get() == 1) avatarResponse(request, body = """{"slug":"missing-avatar","user":{}}""")
            else avatarResponse(request)
        }
        load()
        awaitFetches()
        assertNull(localFollows.loadFollows().single().channelLogo)
        now.set(60_001)
        load()
        awaitFetches()
        assertEquals(2, requests.get())
        assertEquals("https://example.com/avatar.jpg", localFollows.loadFollows().single().channelLogo)
    }

    @Test
    fun refreshDuringFetchDoesNotDuplicateRequestsOrOverwriteFollowChanges() = runBlocking {
        val started = CountDownLatch(1)
        val release = CountDownLatch(1)
        localFollows.saveFollow(LocalFollowChannel(userId = "1001", userLogin = "inflight-avatar", sourceMask = 1))
        response = { request ->
            started.countDown()
            check(release.await(5, TimeUnit.SECONDS))
            avatarResponse(request)
        }
        try {
            load()
            assertTrue(started.await(5, TimeUnit.SECONDS))
            localFollows.loadFollows().single().let {
                it.userLogin = "INFLIGHT-AVATAR"
                it.sourceMask = 3
                localFollows.updateFollow(it)
            }
            load()
            assertEquals(1, requests.get())
        } finally {
            release.countDown()
        }
        awaitFetches()
        val follow = localFollows.loadFollows().single()
        assertEquals(3, follow.sourceMask)
        assertEquals("https://example.com/avatar.jpg", follow.channelLogo)
    }

    @Test
    fun cancelledOwnerDoesNotLeaveAnAvatarPermanentlyReserved() = runBlocking {
        localFollows.saveFollow(LocalFollowChannel(userLogin = "cancelled-avatar"))
        val cancelled = CoroutineScope(Job().apply { cancel() })
        load(cancelled)
        load()
        awaitFetches()
        assertEquals(1, requests.get())
        assertEquals("https://example.com/avatar.jpg", localFollows.loadFollows().single().channelLogo)
    }

    @Test
    fun cancellationReleasesReservationsForChannelsNotYetFetched() = runBlocking {
        val started = CountDownLatch(1)
        val release = CountDownLatch(1)
        val owner = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        localFollows.saveFollow(LocalFollowChannel(userLogin = "cancel-first"))
        localFollows.saveFollow(LocalFollowChannel(userLogin = "cancel-pending"))
        response = { request ->
            if (request.url.encodedPath.endsWith("/cancel-first")) {
                started.countDown()
                check(release.await(5, TimeUnit.SECONDS))
            }
            avatarResponse(request)
        }
        try {
            load(owner)
            assertTrue(started.await(5, TimeUnit.SECONDS))
        } finally {
            owner.cancel()
            release.countDown()
            withTimeout(5_000) { owner.coroutineContext[Job]!!.join() }
        }
        load()
        awaitFetches()
        assertEquals(2, requests.get())
        assertEquals("https://example.com/avatar.jpg", localFollows.getFollow(null, "cancel-pending")?.channelLogo)
    }

    private suspend fun load(owner: CoroutineScope = scope): PagingSource.LoadResult<Int, User> =
        FollowedChannelsDataSource(
            sort = "login", order = "asc", localFollowsChannel = localFollows,
            kickRepository = repository, avatarScope = owner, elapsedTimeMs = now::get,
        ).load(PagingSource.LoadParams.Refresh(key = null, loadSize = 15, placeholdersEnabled = false))

    private suspend fun awaitFetches() {
        withTimeout(5_000) {
            scope.coroutineContext[Job]!!.children.toList().joinAll()
        }
    }

    private fun avatarResponse(
        request: Request,
        status: Int = 200,
        body: String = """{"user":{"profilepic":" ","profile_pic":"","profile_picture":"https://example.com/avatar.jpg"}}""",
    ): Response = Response.Builder()
        .request(request)
        .protocol(Protocol.HTTP_1_1)
        .code(status)
        .message(if (status == 200) "OK" else "Temporary failure")
        .body(body.toResponseBody("application/json".toMediaType()))
        .build()
}
