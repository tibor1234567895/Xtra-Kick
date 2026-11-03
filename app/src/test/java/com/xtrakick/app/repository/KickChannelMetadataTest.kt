package com.xtrakick.app.repository

import android.os.Looper
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelStore
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.kick.KickCategory
import com.xtrakick.app.model.kick.KickChannelLivestream
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.model.kick.KickThumbnail
import com.xtrakick.app.model.kick.KickUser
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.repository.datasource.GameStreamsDataSource
import com.xtrakick.app.repository.datasource.StreamsDataSource
import androidx.paging.PagingSource
import com.xtrakick.app.ui.game.GamePagerViewModel
import com.xtrakick.app.ui.search.games.GameSearchViewModel
import com.xtrakick.app.util.AuthStateHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.util.concurrent.Executors
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickChannelMetadataTest {
    private val json = Json { ignoreUnknownKeys = true }
    private val executor = Executors.newSingleThreadExecutor()
    private val requestedPaths = CopyOnWriteArrayList<String>()
    private var failEventBrowse = false
    private var eventBrowseGate: CountDownLatch? = null
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        requestedPaths += chain.request().url.encodedPath
        if (chain.request().url.encodedPath == "/api/v1/events/browse") eventBrowseGate?.await(5, TimeUnit.SECONDS)
        if (failEventBrowse && chain.request().url.encodedPath == "/api/v1/events/browse") {
            throw java.io.IOException("Event metadata unavailable")
        }
        val body = when (chain.request().url.encodedPath) {
            "/api/search" -> if (chain.request().url.queryParameter("searched_word") == "gta") {
                """{"categories":[{"id":8,"slug":"grand-theft-auto-v","name":"GTA","viewers":99000},
                {"id":13155,"slug":"grand-theft-auto-vi","name":"GTA VI","viewers":0}]}"""
            } else {
                """{"categories":[{"id":1552,"slug":"counter-strike-2","name":"Counter-Strike 2","viewers":30000}]}"""
            }
            "/stream/livestreams/en" -> """
                {"data":[{"id":17,"channel_id":101487073,"language":"English",
                "channel":{"id":101487073,"slug":"eslcs"},
                "categories":[{"id":1552,"slug":"counter-strike-2","name":"Counter-Strike 2"}]}]}
            """
            "/api/v1/events/browse" -> """
                {"data":{"events":[
                {"id":"iem","slug":"iem-beijing","title":"IEM Beijing","phase":"live","num_livestreams":2,"category":{"id":1552}},
                {"id":"justice","slug":"justice-city","title":"JUSTICE CITY","phase":"live","num_livestreams":2,"category":{"id":8,"name":"Grand Theft Auto V (GTA)","slug":"grand-theft-auto-v"}}]}}
            """
            "/api/v1/events/justice/streams" -> """
                {"data":{"streams":[
                {"channel":{"id":500,"slug":"meesi_h"},"user":{"username":"Meesi_H"},
                "livestream":{"id":"justice-a","language":"ar","view_count":718}},
                {"channel":{"id":501,"slug":"chichiland"},"user":{"username":"Chichiland"},
                "livestream":{"id":"justice-b","language":"hi","view_count":30}}]}}
            """
            "/api/v1/events/iem/streams" -> if (chain.request().url.queryParameter("cursor") == null) {
                """{"data":{"next_cursor":"second","streams":[{
                "channel":{"id":99,"slug":"other"},"user":{"username":"Other"},"livestream":{"id":"other-stream"}}]}}"""
            } else {
                """{"data":{"streams":[{
                "channel":{"id":101487073,"slug":"eslcs"},"user":{"username":"ESLCS"},"livestream":{"id":"esl-stream"}}]}}"""
            }
            "/api/v2/channels/guest-test" -> """
                {"id":42,"user_id":43,"slug":"guest-test","livestream":{
                "id":17,"language":"English","is_mature":true,"tags":["Drops"]}}
            """
            "/api/v2/channels/guest-test/livestream" -> """
                {"data":{"id":17,"viewer_count":50,"categories":[{
                "id":8,"name":"Test game","slug":"test-game"}],
                "thumbnail":{"url":"https://example.com/live.jpg"}}}
            """
            else -> """{"id":8,"slug":"test-game","name":"Test game","viewers":42,"tags":["Action","Shooter"]}"""
        }
        Response.Builder()
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .code(200)
            .message("OK")
            .body(body.toResponseBody("application/json".toMediaType()))
            .build()
    }.build()
    private lateinit var repository: KickRepository

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        repository = KickRepository(
            context, client, null, executor, json,
            AuthRepository(null, null, executor, client, json),
            KickOfficialApiClient(context, client, json),
        )
    }

    @After
    fun tearDown() {
        executor.shutdownNow()
    }

    @Test
    fun directoryLoadsEventLabelsWithoutFollowingOrOpeningAChannelAndCachesMembership() = runBlocking {
        val firstPage = repository.getLivestreams(page = 1, limit = 30, subcategory = "counter-strike-2")
        withTimeout(5_000) { repository.channelEventTitles.first { it["101487073"] == "IEM Beijing" } }
        val stream = repository.toStream(firstPage.data.single())
        assertEquals("IEM Beijing", stream.eventTitle)
        assertTrue(stream.tags.orEmpty().contains("IEM Beijing"))
        assertEquals("101487073", stream.channelId)
        repository.getLivestreams(page = 2, limit = 30, subcategory = "counter-strike-2")
        assertEquals(1, requestedPaths.count { it == "/api/v1/events/browse" })
        assertEquals(2, requestedPaths.count { it == "/api/v1/events/iem/streams" })
        assertFalse(requestedPaths.any { it.contains("unrelated") || it.contains("/channels/") })
    }

    @Test
    fun missingEventMetadataDoesNotPreventDirectoryStreamsFromLoading() = runBlocking {
        failEventBrowse = true
        val response = repository.getLivestreams(page = 1, limit = 30)
        assertEquals("eslcs", response.data.single().channel?.slug)
        assertNull(repository.toStream(response.data.single()).eventTitle)
    }

    @Test
    fun missingEventIndexDoesNotBlockLanguageTagsInGlobalOrCategoryLists() = runBlocking {
        failEventBrowse = true
        val global = StreamsDataSource("VIEWER_COUNT", arrayOf("English"), emptyArray(), repository, listOf("kick"))
            .load(PagingSource.LoadParams.Refresh(null, 30, false))
        val category = GameStreamsDataSource("1552", "counter-strike-2", "Counter-Strike 2", null, null,
            "VIEWER_COUNT", listOf("English"), repository, listOf("kick"))
            .load(PagingSource.LoadParams.Refresh(null, 30, false))
        assertTrue(global is PagingSource.LoadResult.Page)
        assertTrue(category is PagingSource.LoadResult.Page)
        assertEquals("eslcs", (global as PagingSource.LoadResult.Page).data.single().channelLogin)
        assertEquals("eslcs", (category as PagingSource.LoadResult.Page).data.single().channelLogin)
    }

    @Test
    fun slowEventMetadataDoesNotBlockDirectoryResultsAndPublishesLabelsAfterward() = runBlocking<Unit> {
        val gate = CountDownLatch(1)
        eventBrowseGate = gate
        try {
            val response = withTimeout(1_000) { repository.getLivestreams(1, 30) }
            assertEquals("eslcs", response.data.single().channel?.slug)
            assertTrue(repository.channelEventTitles.value.isEmpty())
            gate.countDown()
            withTimeout(5_000) { repository.channelEventTitles.first { it["101487073"] == "IEM Beijing" } }
        } finally {
            gate.countDown()
        }
    }

    private fun justiceCitySource(tags: List<String>?, languages: List<String>? = null) = GameStreamsDataSource(
        gameId = "8", gameSlug = "grand-theft-auto-v", gameName = "Grand Theft Auto V (GTA)",
        gqlQueryLanguages = null, gqlLanguages = languages, gqlSort = "VIEWER_COUNT",
        tags = tags, kickRepository = repository, apiPref = listOf("kick"),
    )

    @Test
    fun clickingEventFilterLoadsItsParticipantsWithoutScanningDirectoryAndClearingRestoresDirectory() = runBlocking {
        val result = justiceCitySource(listOf("JUSTICE CITY")).load(PagingSource.LoadParams.Refresh(null, 60, false))
        assertTrue(result is PagingSource.LoadResult.Page)
        val page = result as PagingSource.LoadResult.Page
        assertEquals(listOf("meesi_h", "chichiland"), page.data.map { it.channelLogin })
        assertTrue(page.data.all { it.eventTitle == "JUSTICE CITY" })
        assertNull(page.nextKey)
        assertFalse(requestedPaths.any { it == "/stream/livestreams/en" })
        assertEquals(1, requestedPaths.count { it == "/api/v1/events/justice/streams" })

        val arabic = justiceCitySource(listOf("JUSTICE CITY"), listOf("AR"))
            .load(PagingSource.LoadParams.Refresh(null, 60, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("meesi_h"), arabic.data.map { it.channelLogin })
        val english = justiceCitySource(listOf("JUSTICE CITY"), listOf("EN"))
            .load(PagingSource.LoadParams.Refresh(null, 60, false)) as PagingSource.LoadResult.Page
        assertTrue(english.data.isEmpty())
        assertEquals(1, requestedPaths.count { it == "/api/v1/events/justice/streams" })

        justiceCitySource(null).load(PagingSource.LoadParams.Refresh(null, 30, false))
        assertTrue(requestedPaths.any { it == "/stream/livestreams/en" })
    }

    @Test
    fun globalDirectoryEventFilterUsesTheSameDirectPathAndHonorsViewerSort() = runBlocking {
        val source = StreamsDataSource("VIEWER_COUNT_ASC", arrayOf("JUSTICE CITY"), emptyArray(), repository, listOf("kick"))
        val result = source.load(PagingSource.LoadParams.Refresh(null, 60, false)) as PagingSource.LoadResult.Page
        assertEquals(listOf("chichiland", "meesi_h"), result.data.map { it.channelLogin })
        assertFalse(requestedPaths.any { it == "/stream/livestreams/en" })
        assertNull(result.nextKey)
    }

    @Test
    fun parsesStreamAndCategoryTagsAlongWithLanguageAndMaturity() {
        val stream = repository.parseChannelLivestream(json.parseToJsonElement("""
            {"data":{"id":17,"language":"English","is_mature":true,
            "tags":[" Drops ","Drops","",null,123,true],
            "categories":[{"id":8,"name":"Test game","tags":["Action","Shooter"]}]}}
        """))!!

        assertEquals(listOf("Drops"), stream.tags)
        assertEquals("English", stream.language)
        assertEquals(true, stream.isMature)
        assertEquals(listOf("Action", "Shooter"), stream.category?.tags)
    }

    @Test
    fun acceptsCustomTagsAndLanguageCodeWithoutInventingAbsentMetadata() {
        val stream = repository.parseChannelLivestream(json.parseToJsonElement("""
            {"livestream":{"custom_tags":["Competitive"],"language_code":"tr","is_mature":false}}
        """))!!
        assertEquals(listOf("Competitive"), stream.tags)
        assertEquals("tr", stream.language)
        assertEquals(false, stream.isMature)

        val partial = repository.parseChannelLivestream(json.parseToJsonElement("""{"id":17}"""))!!
        assertNull(partial.tags)
        assertNull(partial.language)
        assertNull(partial.isMature)
    }

    @Test
    fun nestedChannelResponseAlsoAcceptsAlternateTagAndLanguageKeys() {
        val channel = json.decodeFromString<KickChannelResponse>("""
            {"slug":"test","livestream":{"id":17,"custom_tags":["Drops"],"language_code":"en"}}
        """)
        assertEquals(listOf("en", "Drops"), repository.toStream(channel).tags)
    }

    @Test
    fun partialEnrichmentKeepsMetadataFromTheSameBroadcast() {
        val original = KickChannelLivestream(
            id = 17, title = "Original title", viewerCount = 42,
            category = KickCategory(id = 8, name = "Test game", slug = "test-game"),
            tags = listOf("Drops"), language = "English", isMature = true,
        )
        val enriched = KickChannelLivestream(id = 17, thumbnail = KickThumbnail(url = "https://example.com/live.jpg"))
        val stream = repository.toStream(KickChannelResponse(slug = "test", livestream = original), enriched)

        assertEquals(listOf("English", "18+", "Drops"), stream.tags)
        assertEquals("Original title", stream.title)
        assertEquals(42, stream.viewerCount)
        assertEquals("Test game", stream.gameName)
        assertEquals("https://example.com/live.jpg", stream.thumbnailUrl)
    }

    @Test
    fun explicitEmptyTagsAndFalseMaturityReplaceOlderValues() {
        val original = KickChannelLivestream(id = 17, tags = listOf("Old tag"), isMature = true)
        val replacement = repository.parseChannelLivestream(json.parseToJsonElement("""
            {"id":17,"tags":[],"is_mature":false,"language":"Turkish"}
        """))!!
        val stream = repository.toStream(KickChannelResponse(livestream = original), replacement)
        assertEquals(listOf("Turkish"), stream.tags)
        assertFalse(stream.tags.orEmpty().contains("18+"))
    }

    @Test
    fun aNewBroadcastDoesNotInheritPreviousBroadcastMetadata() {
        val original = KickChannelLivestream(id = 17, title = "Old title", tags = listOf("Old tag"), isMature = true)
        val stream = repository.toStream(
            KickChannelResponse(livestream = original),
            KickChannelLivestream(id = 18, viewerCount = 0),
        )
        assertNull(stream.tags)
        assertNull(stream.title)
        assertEquals(0, stream.viewerCount)
    }

    @Test
    fun profileImageSkipsBlankVariantsAndUsesProfilePicture() {
        assertEquals("https://example.com/avatar.jpg", KickUser(
            profilePic = " ", profilePicV2 = "", profilePicture = "https://example.com/avatar.jpg",
        ).profileImage)
        assertNull(KickUser(profilePic = "", profilePicV2 = " ").profileImage)
    }

    @Test
    fun signedOutLocalFollowRetainsTagsThroughLivestreamEnrichment() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        assertFalse(AuthStateHelper.isKickLoggedIn(context))
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        try {
            val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
            follows.saveFollow(LocalFollowChannel(userLogin = "guest-test"))
            val loader = FollowedLiveStreamsRepository(
                context, follows, KickPublicApiRepository(null, null, executor, client, json), repository, json,
            )
            val stream = withTimeout(5_000) {
                loader.loadLiveFollowed(forceRefresh = true, allowPerChannelFallback = true).items.single()
            }
            assertEquals(listOf("English", "18+", "Drops"), stream.tags)
            assertEquals("Test game", stream.gameName)
            assertEquals(50, stream.viewerCount)
        } finally {
            database.close()
        }
    }

    @Test
    fun gameDetailsRetainFetchedCategoryTags() = runBlocking {
        val database = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.getApplication(), AppDatabase::class.java).build()
        val store = ViewModelStore()
        try {
            val viewModel = GamePagerViewModel(
                repository,
                KickPublicApiRepository(null, null, executor, client, json),
                LocalFollowGameRepository(database.localFollowsGame()),
                null, null, executor, client,
                SavedStateHandle(mapOf("gameSlug" to "test-game", "gameName" to "Test game")),
            )
            store.put("game", viewModel)
            viewModel.loadGame("OkHttp", emptyMap(), emptyMap(), false)
            withTimeout(5_000) {
                while (viewModel.game.value?.viewersCount != 42) {
                    shadowOf(Looper.getMainLooper()).idle()
                    delay(10)
                }
            }
            assertEquals(listOf("Action", "Shooter"), viewModel.game.value?.tags?.map { it.name })
            assertTrue(viewModel.game.value?.tags?.all { it.id != null } == true)
        } finally {
            store.clear()
            database.close()
        }
    }

    @Test
    fun gameSearchSharesOneViewerLookupPerQueryAndDistinguishesUnknownCountsFromRealZero() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        val store = ViewModelStore()
        try {
            val viewModel = GameSearchViewModel(context, RecentSearchRepository(database.recentSearchDao()), repository)
            store.put("search", viewModel)
            viewModel.setQuery("gta")
            val populated = async { viewModel.resolveViewersCount(Game(gameId = "8")) }
            val empty = async { viewModel.resolveViewersCount(Game(gameId = "13155")) }
            val unknown = async { viewModel.resolveViewersCount(Game(gameId = "999")) }
            withTimeout(5_000) {
                while (!populated.isCompleted || !empty.isCompleted || !unknown.isCompleted) {
                    shadowOf(Looper.getMainLooper()).idle()
                    delay(10)
                }
            }
            assertEquals(99000, populated.await())
            assertEquals(0, empty.await())
            assertNull(unknown.await())
            assertEquals(1, requestedPaths.count { it == "/api/search" })

            viewModel.setQuery("counter strike")
            val changed = async { viewModel.resolveViewersCount(Game(gameId = "1552")) }
            withTimeout(5_000) {
                while (!changed.isCompleted) {
                    shadowOf(Looper.getMainLooper()).idle()
                    delay(10)
                }
            }
            assertEquals(30000, changed.await())
            assertEquals(2, requestedPaths.count { it == "/api/search" })
        } finally {
            store.clear()
            database.close()
        }
    }
}
