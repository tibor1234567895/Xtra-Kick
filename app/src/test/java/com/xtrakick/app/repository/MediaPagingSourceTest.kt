package com.xtrakick.app.repository

import androidx.paging.PagingSource
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.repository.datasource.ChannelClipsDataSource
import com.xtrakick.app.repository.datasource.ChannelVideosDataSource
import com.xtrakick.app.repository.datasource.GameClipsDataSource
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class MediaPagingSourceTest {
    private val executor = Executors.newSingleThreadExecutor()
    private var status = 200
    private var repeatCursor = false
    private var omitDates = false
    private var lastSortQuery: String? = null
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        if (chain.request().url.encodedPath.endsWith("/clips")) {
            lastSortQuery = chain.request().url.queryParameter("sort")
        }
        val cursor = chain.request().url.queryParameter("cursor")
        val id = when (cursor) { null -> "first"; "second" -> "second"; else -> "third" }
        val next = if (cursor == null || repeatCursor) "second" else "third"
        val field = if (chain.request().url.encodedPath.endsWith("/clips")) "clips" else "videos"
        val day = when (id) { "first" -> "02"; "second" -> "04"; else -> "03" }
        val duration = when (id) { "first" -> 20; "second" -> 40; else -> 100 }
        val date = if (omitDates) "" else ",\"created_at\":\"2026-11-$day 10:00:00\""
        val items = if (field == "videos") (0 until 30).joinToString(",") { """{"id":"$id-$it","title":"$id"$date}""" }
            else """{"id":"$id","title":"$id","duration":$duration$date}"""
        Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(status).message("fixture")
            .body("""{"$field":[$items],"next_cursor":"$next"}""".toResponseBody("application/json".toMediaType())).build()
    }.build()
    private val context = RuntimeEnvironment.getApplication()
    private val json = Json { ignoreUnknownKeys = true }
    private val repository = KickRepository(context, client, null, executor, json,
        AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))

    private fun clipSources(sort: String? = null): List<PagingSource<String, Clip>> = listOf(
        ChannelClipsDataSource("1", "channel", sort, null, null, null, null, repository),
        GameClipsDataSource("1", "game", "Game", sort, null, null, null, null, repository)
    )

    private fun videos() = ChannelVideosDataSource("1", "channel", "all", "all", "time", repository)

    @After fun close() {
        client.connectionPool.evictAll()
        client.dispatcher.executorService.shutdownNow()
        executor.shutdownNow()
    }

    @Test fun reloadingAnAppendKeyReturnsTheSameClipPage() = runBlocking {
        for (source in clipSources()) {
            val first = source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
            val key = first.nextKey!!
            val second = source.load(PagingSource.LoadParams.Append(key, 20, false)) as PagingSource.LoadResult.Page
            val reloaded = source.load(PagingSource.LoadParams.Append(key, 20, false)) as PagingSource.LoadResult.Page
            assertEquals(listOf("second"), second.data.map { it.id })
            assertEquals(second.data.map { it.id }, reloaded.data.map { it.id })
            val refreshed = source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
            assertEquals(listOf("first"), refreshed.data.map { it.id })
        }
    }

    @Test fun reloadingAnAppendKeyReturnsTheSameVideoPage() = runBlocking {
        val source = videos()
        val first = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        val key = first.nextKey!!
        val second = source.load(PagingSource.LoadParams.Append(key, 30, false)) as PagingSource.LoadResult.Page
        val reloaded = source.load(PagingSource.LoadParams.Append(key, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(second.data.map { it.id }, reloaded.data.map { it.id })
        val refreshed = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(first.data.map { it.id }, refreshed.data.map { it.id })
    }

    @Test fun repeatedCursorsEndClipAndVideoPagination() = runBlocking {
        repeatCursor = true
        for (source in clipSources()) {
            val first = source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
            val second = source.load(PagingSource.LoadParams.Append(first.nextKey!!, 20, false)) as PagingSource.LoadResult.Page
            assertNull("A repeated cursor must not cause an endless append loop", second.nextKey)
        }
        val source = videos()
        val first = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        val second = source.load(PagingSource.LoadParams.Append(first.nextKey!!, 30, false)) as PagingSource.LoadResult.Page
        assertNull(second.nextKey)
    }

    @Test fun transientMediaFailuresRemainRetryable() = runBlocking {
        status = 503
        for (source in clipSources()) {
            assertTrue(source.load(PagingSource.LoadParams.Refresh(null, 20, false)) is PagingSource.LoadResult.Error)
        }
        assertTrue(videos().load(PagingSource.LoadParams.Refresh(null, 30, false)) is PagingSource.LoadResult.Error)
    }

    @Test fun clipsWithoutDatesRemainVisibleWhenNoDateRangeIsApplied() = runBlocking {
        omitDates = true
        for (source in clipSources()) {
            val page = source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
            assertEquals(listOf("first"), page.data.map { it.id })
        }
    }

    @Test fun clipSortOptionMapsToKickApiSortParameter() = runBlocking {
        for (source in clipSources(sort = "time")) {
            source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
            assertEquals("date", lastSortQuery)
        }
        for (source in clipSources(sort = "views")) {
            source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
            assertEquals("view", lastSortQuery)
        }
    }

    @Test fun recentClipSortingOrdersResultsAcrossServerPages() = runBlocking {
        for ((sort, expected) in listOf(
            "time" to listOf("second", "third", "first"),
            "duration" to listOf("third", "second", "first"),
        )) {
            for (source in clipSources(sort)) {
                val page = source.load(PagingSource.LoadParams.Refresh(null, 20, false)) as PagingSource.LoadResult.Page
                assertEquals(expected, page.data.map { it.id })
                assertEquals("date", lastSortQuery)
                assertNull(page.nextKey)
            }
        }
    }
}
