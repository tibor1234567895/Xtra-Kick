package com.xtrakick.app.repository

import androidx.paging.PagingSource
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.LocalFollowGame
import com.xtrakick.app.repository.datasource.FollowedGamesDataSource
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.Executors
import java.util.Collections

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class FollowedGamesDataSourceTest {
    private val executor = Executors.newSingleThreadExecutor()
    private lateinit var database: AppDatabase
    private lateinit var localFollowsGameRepository: LocalFollowGameRepository
    private lateinit var kickRepository: KickRepository
    private val endpointResponses = mutableMapOf<String, String>()
    private val requestedPaths = Collections.synchronizedList(mutableListOf<String>())
    private var subcategoriesJson = """
        {
            "current_page": 1,
            "data": [
                {
                    "id": 12,
                    "name": "Grand Theft Auto V (GTA)",
                    "slug": "grand-theft-auto-v",
                    "viewers": 85000,
                    "banner": {
                        "url": "https://files.kick.com/subcategories/banner/gta5.png"
                    },
                    "tags": ["Action", "Open World"]
                },
                {
                    "id": 45,
                    "name": "ASMR",
                    "slug": "asmr",
                    "viewers": 450,
                    "banner": {
                        "url": "https://files.kick.com/subcategories/banner/asmr_pink.png"
                    },
                    "tags": ["IRL"]
                }
            ]
        }
    """.trimIndent()

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        localFollowsGameRepository = LocalFollowGameRepository(database.localFollowsGame())

        val json = Json { ignoreUnknownKeys = true }
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request()
            val path = request.url.encodedPath
            requestedPaths.add(path)
            val body = endpointResponses[path] ?: subcategoriesJson.takeIf { path == "/api/v1/subcategories" }
            if (body != null) {
                Response.Builder()
                    .request(request)
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .message("OK")
                    .body(body.toResponseBody("application/json".toMediaType()))
                    .build()
            } else {
                Response.Builder()
                    .request(request)
                    .protocol(Protocol.HTTP_1_1)
                    .code(404)
                    .message("Not Found")
                    .body("{}".toResponseBody("application/json".toMediaType()))
                    .build()
            }
        }.build()

        kickRepository = KickRepository(
            context,
            client,
            null,
            executor,
            json,
            AuthRepository(null, null, executor, client, json),
            KickOfficialApiClient(context, client, json),
        )
    }

    @After
    fun tearDown() {
        database.close()
        executor.shutdown()
    }

    @Test
    fun `categories outside top list keep canonical request case`() = runBlocking {
        localFollowsGameRepository.saveFollow(LocalFollowGame(gameId = "92", gameSlug = "DayZ", gameName = "DayZ"))
        endpointResponses["/api/v1/subcategories/DayZ"] =
            """{"id":92,"slug":"DayZ","name":"DayZ","viewers":161,"tags":["Survival"]}"""

        val result = FollowedGamesDataSource(localFollowsGameRepository, kickRepository).load(
            PagingSource.LoadParams.Refresh(key = null, loadSize = 30, placeholdersEnabled = false)
        ) as PagingSource.LoadResult.Page

        assertEquals(161, result.data.single().viewersCount)
        assertEquals("Survival", result.data.single().tags!!.single().name)
        assertTrue(requestedPaths.contains("/api/v1/subcategories/DayZ"))
        assertTrue(!requestedPaths.contains("/api/v1/subcategories/dayz"))
        assertTrue(!requestedPaths.contains("/api/search"))
    }

    @Test
    fun `historical lowercase slugs recover by matching search category and update local follow`() = runBlocking {
        localFollowsGameRepository.saveFollow(
            LocalFollowGame(gameId = "93", gameSlug = "project-zomboid", gameName = "Project Zomboid")
        )
        endpointResponses["/api/search"] = """{"categories":[
            {"id":94,"slug":"Project-Zomboid-Modded","name":"Project Zomboid Modded","viewers":999},
            {"id":93,"slug":"Project-Zomboid","name":"Project Zomboid","viewers":190,"tags":["Horror"]}
        ]}"""
        endpointResponses["/api/v1/subcategories/Project-Zomboid"] =
            """{"id":93,"slug":"Project-Zomboid","name":"Project Zomboid","viewers":191,"tags":["Survival"]}"""

        val result = FollowedGamesDataSource(localFollowsGameRepository, kickRepository).load(
            PagingSource.LoadParams.Refresh(key = null, loadSize = 30, placeholdersEnabled = false)
        ) as PagingSource.LoadResult.Page

        assertEquals("Project-Zomboid", result.data.single().gameSlug)
        assertEquals(191, result.data.single().viewersCount)
        assertEquals("Survival", result.data.single().tags!!.single().name)
        assertEquals("Project-Zomboid", localFollowsGameRepository.loadFollows().single().gameSlug)
        assertTrue(requestedPaths.contains("/api/v1/subcategories/project-zomboid"))
        assertTrue(requestedPaths.contains("/api/v1/subcategories/Project-Zomboid"))
    }

    @Test
    fun `unrelated search results do not replace followed category`() = runBlocking {
        localFollowsGameRepository.saveFollow(
            LocalFollowGame(gameId = "93", gameSlug = "project-zomboid", gameName = "Project Zomboid")
        )
        endpointResponses["/api/search"] = """{"categories":[
            {"id":94,"slug":"Project-Zomboid-Modded","name":"Project Zomboid Modded","viewers":999,"tags":["Wrong"]}
        ]}"""

        val result = FollowedGamesDataSource(localFollowsGameRepository, kickRepository).load(
            PagingSource.LoadParams.Refresh(key = null, loadSize = 30, placeholdersEnabled = false)
        ) as PagingSource.LoadResult.Page

        assertEquals("93", result.data.single().gameId)
        assertEquals("project-zomboid", result.data.single().gameSlug)
        assertEquals(null, result.data.single().tags)
        assertEquals("project-zomboid", localFollowsGameRepository.loadFollows().single().gameSlug)
    }

    @Test
    fun `load syncs followed categories with live Kick artwork, viewers, and tags`() = runBlocking {
        // Insert GTA V and ASMR with outdated box art (one local file, one old url)
        localFollowsGameRepository.saveFollow(
            LocalFollowGame(
                gameId = "12",
                gameSlug = "grand-theft-auto-v",
                gameName = "Grand Theft Auto V (GTA)",
                boxArt = "/data/user/0/com.xtra/files/box_art/12"
            )
        )
        localFollowsGameRepository.saveFollow(
            LocalFollowGame(
                gameId = "45",
                gameSlug = "asmr",
                gameName = "ASMR",
                boxArt = "https://old-image.com/asmr_grey.png"
            )
        )

        val dataSource = FollowedGamesDataSource(localFollowsGameRepository, kickRepository)
        val result = dataSource.load(PagingSource.LoadParams.Refresh(key = null, loadSize = 30, placeholdersEnabled = false))

        assertTrue(result is PagingSource.LoadResult.Page)
        val page = result as PagingSource.LoadResult.Page
        assertEquals(2, page.data.size)

        val asmr = page.data.first { it.gameSlug == "asmr" }
        assertEquals("ASMR", asmr.gameName)
        assertEquals("https://files.kick.com/subcategories/banner/asmr_pink.png", asmr.boxArt)
        assertEquals(450, asmr.viewersCount)
        assertNotNull(asmr.tags)

        val gta = page.data.first { it.gameSlug == "grand-theft-auto-v" }
        assertEquals("Grand Theft Auto V (GTA)", gta.gameName)
        assertEquals("https://files.kick.com/subcategories/banner/gta5.png", gta.boxArt)
        assertEquals(85000, gta.viewersCount)

        // Verify Room DB was updated
        val dbFollows = localFollowsGameRepository.loadFollows()
        val gtaDb = dbFollows.first { it.gameSlug == "grand-theft-auto-v" }
        assertEquals("https://files.kick.com/subcategories/banner/gta5.png", gtaDb.boxArt)
        val asmrDb = dbFollows.first { it.gameSlug == "asmr" }
        assertEquals("https://files.kick.com/subcategories/banner/asmr_pink.png", asmrDb.boxArt)
    }

    @Test
    fun `load falls back gracefully to local database on network failure`() = runBlocking {
        localFollowsGameRepository.saveFollow(
            LocalFollowGame(
                gameId = "99",
                gameSlug = "offline-game",
                gameName = "Offline Game",
                boxArt = "https://cached-image.com/art.png"
            )
        )

        // Force a network failure by pointing to invalid json
        subcategoriesJson = "invalid-json"

        val dataSource = FollowedGamesDataSource(localFollowsGameRepository, kickRepository)
        val result = dataSource.load(PagingSource.LoadParams.Refresh(key = null, loadSize = 30, placeholdersEnabled = false))

        assertTrue(result is PagingSource.LoadResult.Page)
        val page = result as PagingSource.LoadResult.Page
        assertEquals(1, page.data.size)
        assertEquals("Offline Game", page.data[0].gameName)
        assertEquals("https://cached-image.com/art.png", page.data[0].boxArt)
    }
}
