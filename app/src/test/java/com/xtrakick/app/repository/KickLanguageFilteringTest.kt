package com.xtrakick.app.repository

import android.webkit.CookieManager
import androidx.paging.PagingSource
import com.xtrakick.app.model.kick.KickLivestream
import com.xtrakick.app.repository.datasource.GameStreamsDataSource
import com.xtrakick.app.repository.datasource.StreamsDataSource
import com.xtrakick.app.repository.datasource.SearchStreamsDataSource
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.tokenPrefs
import kotlinx.coroutines.runBlocking
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
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickLanguageFilteringTest {
    private val context = RuntimeEnvironment.getApplication()
    private val json = Json { ignoreUnknownKeys = true }
    private val executor = Executors.newSingleThreadExecutor()
    private val requests = CopyOnWriteArrayList<Request>()
    private var browseStatus = 200
    private var legacyHasNextPage = false
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        requests += request
        val body = when (request.url.encodedPath) {
            "/api/v1/livestreams/language-codes" -> """{"data":["en","en-IN","tr","de","fil","sr","fa","rm"]}"""
            "/api/v1/events/browse" -> """{"data":{"events":[{
                "id":"turkish-event","slug":"turkish-event","title":"Turkish event","phase":"live",
                "num_livestreams":2,"category":{"id":8},"languages":["tr"]}]}}"""
            "/api/v1/livestreams" -> when {
                request.url.queryParameterValues("language").contains("sr") ->
                    """{"data":{"livestreams":[${stream("serbian-one", 200, "sr", 8)}],"pagination":{}}}"""
                request.url.queryParameterValues("language").contains("rm") ->
                    """{"data":{"livestreams":[${stream("romansh-one", 201, "rm", 8)}],"pagination":{}}}"""
                request.url.queryParameter("after") == null ->
                    """{"data":{"livestreams":[
                    ${stream("one", 100, "en", 8, false)},
                    ${stream("wrong-language", 900, "tr", 8)},
                    ${stream("wrong-category", 901, "en", 1552, categorySlug = "just-chatting", categoryName = "Just Chatting")}
                    ],"pagination":{"next_cursor":"opaque+/cursor="}}}"""
                else ->
                    """{"data":{"livestreams":[${stream("one", 100, "en", 8)},${stream("two", 101, "en-IN", 8)}],"pagination":{}}}"""
            }
            "/stream/livestreams/en" -> if (legacyHasNextPage) {
                val page = request.url.queryParameter("page")
                """{"data":[{"channel_id":$page,"language":"English"}],"next_page_url":"https://kick.com/stream/livestreams/en?page=2"}"""
            } else {
                """{"data":[]}"""
            }
            else -> "{}"
        }
        Response.Builder().request(request).protocol(Protocol.HTTP_1_1)
            .code(if (request.url.encodedPath == "/api/v1/livestreams") browseStatus else 200)
            .message("fixture").body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()

    private fun stream(
        id: String,
        channelId: Long,
        language: String,
        category: Long,
        showViewers: Boolean = true,
        categorySlug: String = "grand-theft-auto-v",
        categoryName: String = "GTA",
    ) = """
        {"id":"$id","language":"$language","title":"Test stream","viewer_count":42,"show_view_count":$showViewers,
        "start_time":"2026-11-02T10:00:00Z","is_mature":true,"tags":["Drops"],
        "thumbnail":{"src":"https://images.kick.com/thumb.webp"},
        "channel":{"id":$channelId,"slug":"channel$channelId","username":"Channel $channelId","profile_pic":"https://files.kick.com/avatar.webp"},
        "category":{"id":$category,"name":"$categoryName","slug":"$categorySlug"}}
    """

    private fun repository() = KickRepository(context, client, null, executor, json,
        AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))

    private fun source(repository: KickRepository, languages: List<String>? = listOf("EN"), tags: List<String>? = null,
        sort: String = "VIEWER_COUNT") = GameStreamsDataSource(
        gameId = "8", gameSlug = "grand-theft-auto-v", gameName = "GTA", gqlQueryLanguages = null,
        gqlLanguages = languages, gqlSort = sort, tags = tags, kickRepository = repository, apiPref = listOf("kick"),
    )

    @After
    fun tearDown() {
        context.tokenPrefs().edit().clear().commit()
        CookieManager.getInstance().removeAllCookies(null)
        executor.shutdownNow()
    }

    @Test
    fun categoryLanguageFilterUsesOneBrowseRequestAndPreservesCursorIdentityAndPrivacy() = runBlocking {
        val source = source(repository())
        val first = source.load(PagingSource.LoadParams.Refresh(null, 60, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("channel100"), first.data.map { it.channelLogin })
        val item = first.data.single()
        assertEquals("one", item.id)
        assertEquals("100", item.channelId)
        assertEquals("https://files.kick.com/avatar.webp", item.profileImageUrl)
        assertEquals("https://images.kick.com/thumb.webp", item.thumbnailUrl)
        assertNull(item.viewerCount)
        assertTrue(item.tags.orEmpty().containsAll(listOf("English", "18+", "Drops")))
        assertEquals(2, first.nextKey)
        assertEquals(1, requests.count { it.url.encodedPath == "/api/v1/livestreams" })
        assertFalse(requests.any { it.url.encodedPath.startsWith("/stream/") || it.url.encodedPath.contains("/events/turkish-event/") })
        val request = requests.single { it.url.encodedPath == "/api/v1/livestreams" }
        assertEquals("8", request.url.queryParameter("category_id"))
        assertEquals(listOf("en", "en-IN"), request.url.queryParameterValues("language"))

        val second = source.load(PagingSource.LoadParams.Append(first.nextKey!!, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("channel101"), second.data.map { it.channelLogin })
        assertTrue(second.data.single().tags.orEmpty().contains("English (India)"))
        assertNull(second.nextKey)
        assertEquals("opaque+/cursor=", requests.last { it.url.encodedPath == "/api/v1/livestreams" }.url.queryParameter("after"))
        assertEquals(1, requests.count { it.url.encodedPath.endsWith("language-codes") })
    }

    @Test
    fun publicBrowseRequestIsIndependentOfEveryLoginStateIncludingExpiredTokens() = runBlocking {
        for (state in listOf("logged-out", "oauth", "web", "combined", "google_mobile", "expired")) {
            context.tokenPrefs().edit().clear().commit()
            CookieManager.getInstance().removeAllCookies(null)
            if (state in listOf("oauth", "combined", "google_mobile", "expired")) {
                context.tokenPrefs().edit().putString(AppConstants.KICK_ACCESS_TOKEN, "fixture-token")
                    .putLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, if (state == "expired") 1L else Long.MAX_VALUE)
                    .putString(AppConstants.KICK_LOGIN_METHOD, state).commit()
            }
            if (state in listOf("web", "combined")) {
                CookieManager.getInstance().setCookie("https://kick.com", "session_token=fixture-session; Path=/")
            }
            val result = source(repository()).load(PagingSource.LoadParams.Refresh(null, 30, false))
            assertTrue(state, result is PagingSource.LoadResult.Page)
            val request = requests.last { it.url.encodedPath == "/api/v1/livestreams" }
            assertNull(state, request.header("Authorization"))
            assertNull(state, request.header("Cookie"))
        }
    }

    @Test
    fun globalAndLanguageChipFiltersUseTheServerWhileOtherSortsAndUnknownCodesKeepTheirPath() = runBlocking {
        val repository = repository()
        val global = StreamsDataSource("VIEWER_COUNT", emptyArray(), arrayOf("EN", "TR"), repository, listOf("kick"))
        val result = global.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(3, result.data.size)
        val request = requests.last { it.url.encodedPath == "/api/v1/livestreams" }
        assertNull(request.url.queryParameter("category_id"))
        assertEquals(setOf("en", "en-IN", "tr"), request.url.queryParameterValues("language").toSet())
        source(repository, languages = null, tags = listOf("English")).load(PagingSource.LoadParams.Refresh(null, 30, false))
        assertEquals(2, requests.count { it.url.encodedPath == "/api/v1/livestreams" })
        for (sort in listOf("VIEWER_COUNT_ASC", "RECENT")) {
            source(repository, sort = sort).load(PagingSource.LoadParams.Refresh(null, 30, false))
        }
        source(repository, languages = listOf("OTHER")).load(PagingSource.LoadParams.Refresh(null, 30, false))
        assertEquals(2, requests.count { it.url.encodedPath == "/api/v1/livestreams" })
        assertEquals(3, requests.count { it.url.encodedPath == "/stream/livestreams/en" })
    }

    @Test
    fun failedFilteredPageCanRetryWithoutSwitchingToMixedLanguageDirectory() = runBlocking {
        val source = source(repository())
        browseStatus = 503
        assertTrue(source.load(PagingSource.LoadParams.Refresh(null, 30, false)) is PagingSource.LoadResult.Error)
        browseStatus = 200
        val result = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("channel100"), result.data.map { it.channelLogin })
        assertFalse(requests.any { it.url.encodedPath == "/stream/livestreams/en" })
    }

    @Test
    fun languageSearchTagsUseServerFilteringAndPreserveCursorPagination() = runBlocking {
        val source = SearchStreamsDataSource("English", repository(), false)
        val first = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("one", "wrong-category"), first.data.map { it.id })
        assertEquals("2", first.nextKey)
        val second = source.load(PagingSource.LoadParams.Append(first.nextKey!!, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("two"), second.data.map { it.id })
        assertNull(second.nextKey)
        assertEquals(2, requests.count { it.url.encodedPath == "/api/v1/livestreams" })
        assertFalse(requests.any { it.url.encodedPath == "/stream/livestreams/en" || it.url.host == "search.kick.com" })
    }

    @Test
    fun savedOtherLanguageFilterLoadsUnfilteredPages() = runBlocking {
        legacyHasNextPage = true
        val repository = repository()

        val popular = StreamsDataSource("VIEWER_COUNT", emptyArray(), arrayOf("OTHER"), repository, listOf("kick"))
        val popularFirst = popular.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("1"), popularFirst.data.map { it.channelId })
        assertEquals(2, popularFirst.nextKey)
        val popularSecond = popular.load(PagingSource.LoadParams.Append(popularFirst.nextKey!!, 30, false))
        assertTrue("Expected Page instead of error: $popularSecond", popularSecond is PagingSource.LoadResult.Page)

        val game = source(repository, languages = listOf("OTHER"))
        val gameFirst = game.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("1"), gameFirst.data.map { it.channelId })
        assertEquals(2, gameFirst.nextKey)
        val gameSecond = game.load(PagingSource.LoadParams.Append(gameFirst.nextKey!!, 30, false))
        assertTrue("Expected Page instead of error: $gameSecond", gameSecond is PagingSource.LoadResult.Page)
    }

    @Test
    fun obsoleteLanguagesDoNotOverrideValidSelections() = runBlocking {
        val source = StreamsDataSource(
            "VIEWER_COUNT", emptyArray(), arrayOf("OTHER", "NN", "MR", "EN_IN"), repository(), listOf("kick"),
        )
        val first = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertTrue(first.data.isEmpty())
        assertEquals(2, first.nextKey)
        val request = requests.single { it.url.encodedPath == "/api/v1/livestreams" }
        assertEquals(listOf("en-IN"), request.url.queryParameterValues("language"))
        val second = source.load(PagingSource.LoadParams.Append(2, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("two"), second.data.map { it.id })
    }

    @Test
    fun anAdvertisedLanguageOutsideTheBundledListWorksWithoutAnAppUpdate() = runBlocking {
        val repository = repository()
        val bundled = context.resources.getStringArray(com.xtrakick.app.R.array.gqlUserLanguageValues)
        assertFalse("RM" in bundled)
        assertTrue("rm" in repository.getBrowseLanguageCodes())
        val source = StreamsDataSource("VIEWER_COUNT", emptyArray(), arrayOf("RM"), repository, listOf("kick"))
        val result = source.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("romansh-one"), result.data.map { it.id })
    }

    @Test
    fun regionSpecificEnglishMatchesExplicitLanguageOnly() {
        val languages = listOf("EN_IN")
        assertTrue(StreamsDataSource.matchesFilters(KickLivestream(language = "English (India)"), languages, null))
        assertTrue(StreamsDataSource.matchesFilters(KickLivestream(language = "en-IN"), languages, null))
        assertFalse(StreamsDataSource.matchesFilters(KickLivestream(language = "English"), languages, null))
    }

    @Test
    fun expandedKickLanguageListMatchesPickerArraysAndFiltersServerSide() = runBlocking {
        val entries = context.resources.getStringArray(com.xtrakick.app.R.array.gqlUserLanguageEntries)
        val values = context.resources.getStringArray(com.xtrakick.app.R.array.gqlUserLanguageValues)
        assertEquals(entries.size, values.size)
        assertEquals(72, values.size)
        assertFalse("OTHER" in values)
        assertFalse("MR" in values)
        assertFalse("NN" in values)
        assertTrue("SR" in values)
        assertTrue("FA" in values)

        val popular = StreamsDataSource("VIEWER_COUNT", emptyArray(), arrayOf("SR"), repository(), listOf("kick"))
        val page = popular.load(PagingSource.LoadParams.Refresh(null, 30, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("serbian-one"), page.data.map { it.id })
    }
}
