package com.xtrakick.app.repository

import androidx.paging.PagingSource
import com.xtrakick.app.repository.datasource.SearchVideosDataSource
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
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickSearchPerformanceTest {
    private val context = RuntimeEnvironment.getApplication()
    private val json = Json { ignoreUnknownKeys = true }
    private val executor = Executors.newSingleThreadExecutor()
    private val requests = CopyOnWriteArrayList<Request>()
    private var slowChannelGate: CountDownLatch? = null
    private var failAlpha = false
    private var clipStatus = 200
    private var alphaVideoBody: String? = null
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        requests += request
        val path = request.url.encodedPath
        if (path == "/api/v2/channels/alphabeta/videos") slowChannelGate?.await(5, TimeUnit.SECONDS)
        val body = when (path) {
            "/multi_search" -> """{"results":[{"found":2,"hits":[
                {"document":{"id":"1","slug":"alpha"}},
                {"document":{"id":"2","slug":"alphabeta"}}]}]}"""
            "/api/v2/channels/alpha/videos" -> alphaVideoBody ?: if (request.url.queryParameter("cursor") == null) {
                """{"videos":[{"id":"v1","title":"alpha first","created_at":"2026-11-02 10:00:00"}],"next_cursor":"alpha-next"}"""
            } else {
                """{"videos":[{"id":"v1","title":"alpha duplicate"},{"id":"v3","title":"alpha next"}],"next_cursor":"alpha-next"}"""
            }
            "/api/v2/channels/alphabeta/videos" -> """{"videos":[{"id":"v2","title":"alphabeta video"}]}"""
            "/api/v2/categories/grand-theft-auto-v/clips" -> """{"clips":[]}"""
            else -> "{}"
        }
        val status = when {
            path == "/api/v2/channels/alpha/videos" && failAlpha -> 503
            path.endsWith("/clips") -> clipStatus
            else -> 200
        }
        Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(status).message("fixture")
            .body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()
    private val repository = KickRepository(context, client, null, executor, json,
        AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))

    @After fun close() {
        slowChannelGate?.countDown()
        executor.shutdownNow()
    }

    @Test fun videoSearchDisplaysTheFirstChannelWithoutWaitingForOtherChannelsAndPaginatesFairly() = runBlocking {
        val gate = CountDownLatch(1)
        slowChannelGate = gate
        val source = SearchVideosDataSource("alpha", repository, "Video request failed")
        val first = withTimeout(1_000) {
            source.load(PagingSource.LoadParams.Refresh(null, 30, false))
        } as PagingSource.LoadResult.Page
        assertEquals(listOf("v1"), first.data.map { it.id })
        assertFalse(requests.any { it.url.encodedPath.contains("alphabeta/videos") })
        gate.countDown()
        val second = source.load(PagingSource.LoadParams.Append(first.nextKey!!, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("v2"), second.data.map { it.id })
        val third = source.load(PagingSource.LoadParams.Append(second.nextKey!!, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("v3"), third.data.map { it.id })
        assertNull(third.nextKey)
        assertEquals(1, requests.count { it.url.encodedPath == "/multi_search" })
        val before = requests.size
        repository.getChannelVideosPage("alpha", "1", 30)
        assertEquals(before, requests.size)
    }

    @Test fun oneFailedVideoChannelDoesNotHideTheOthersAndCanBeRetried() = runBlocking {
        failAlpha = true
        val source = SearchVideosDataSource("alpha", repository, "Video request failed")
        val first = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("v2"), first.data.map { it.id })
        failAlpha = false
        val second = source.load(PagingSource.LoadParams.Append(first.nextKey!!, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("v1"), second.data.map { it.id })
    }

    @Test fun validEmptyClipsStopAfterOneCanonicalRequestAndErrorsDoNotProbeDeadRoutes() = runBlocking {
        val page = repository.getCategoryClipsPage("grand-theft-auto-v", "8", time = "today", cursor = "opaque+/=")
        assertNotNull(page)
        assertTrue(page!!.clips.isEmpty())
        val first = requests.single { it.url.encodedPath.endsWith("/clips") }
        assertEquals("/api/v2/categories/grand-theft-auto-v/clips", first.url.encodedPath)
        assertEquals("day", first.url.queryParameter("time"))
        assertEquals("opaque+/=", first.url.queryParameter("cursor"))
        clipStatus = 503
        assertNull(repository.getCategoryClipsPage("grand-theft-auto-v", "8"))
        assertEquals(2, requests.count { it.url.encodedPath.endsWith("/clips") })
        assertFalse(requests.any { it.url.encodedPath.contains("/subcategories/") })
    }

    @Test fun unrecognizedVideoPayloadIsNotCachedAndRetryCanRecover() = runBlocking {
        for (invalidBody in listOf("""{"error":"temporary failure"}""", "{}", "null")) {
            alphaVideoBody = invalidBody
            assertNull(repository.getChannelVideosPage("alpha"))
        }
        alphaVideoBody = null
        assertEquals(listOf("v1"), repository.getChannelVideosPage("alpha")!!.videos.map { it.id })
        assertEquals(4, requests.count { it.url.encodedPath.endsWith("alpha/videos") })
    }

    @Test fun recognizedEmptyVideoPagesAreCached() = runBlocking {
        for (emptyBody in listOf("[]", """{"videos":[]}""", """{"data":{"videos":[]}}""")) {
            alphaVideoBody = emptyBody
            val cursor = emptyBody
            assertTrue(repository.getChannelVideosPage("alpha", cursor = cursor)!!.videos.isEmpty())
            assertTrue(repository.getChannelVideosPage("alpha", cursor = cursor)!!.videos.isEmpty())
        }
        assertEquals(3, requests.count { it.url.encodedPath.endsWith("alpha/videos") })
    }
}
