package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickChannelLivestream
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.model.kick.KickThumbnail
import com.xtrakick.app.util.KickApiHelper
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
class KickVideoThumbnailResolutionTest {

    private val context = RuntimeEnvironment.getApplication()
    private val json = Json { ignoreUnknownKeys = true }
    private val executor = Executors.newSingleThreadExecutor()
    private val requests = CopyOnWriteArrayList<Request>()
    private var failWebVideos = false
    private var startTimeOverride: String? = null
    private var useExplicitWebDurationSeconds = false

    private val v2Page1Body = """
        [
          {
            "id": 140270814,
            "channel_id": 668,
            "created_at": "2026-11-25 22:19:58",
            "start_time": "2026-11-25 22:19:55",
            "session_title": "Mega Day Stream",
            "is_live": false,
            "duration": 41017000,
            "source": "https://stream.kick.com/3c81249a5ce0/ivs/v1/196233775518/DsuAwCgUc9Bh/2026/11/25/22/19/grz1HiLuGURr/media/hls/master.m3u8",
            "thumbnail": {
              "src": "https://web.kick.com/api/v1/channels/668/thumbnail.jpeg?height=720"
            },
            "video": { "uuid": "6060da49-216a-4828-ac41-62d307ce8825" }
          },
          {
            "id": 140060512,
            "channel_id": 668,
            "created_at": "2026-11-24 20:50:34",
            "start_time": "2026-11-24 20:50:31",
            "session_title": "Live Now Recording",
            "is_live": true,
            "duration": 1200000,
            "source": "https://stream.kick.com/3c81249a5ce0/ivs/v1/196233775518/DsuAwCgUc9Bh/2026/11/24/20/50/liveRec/media/hls/master.m3u8",
            "thumbnail": {
              "src": "https://web.kick.com/api/v1/channels/668/thumbnail.jpeg?height=720"
            }
          }
        ]
    """.trimIndent()

    private val webVideosBody = """
        {
          "data": [
            {
              "id": "01a214cb-42f8-75cd-b00f-f083ea893dfd",
              "is_live": false,
              "start_time": "2026-11-25T22:19:55Z",
              "duration": 41017,
              "title": "Mega Day Stream",
              "thumbnail": {
                "frame_ms": 20508500,
                "src": "https://web.kick.com/api/v1/videos/01a214cb-42f8-75cd-b00f-f083ea893dfd/thumbnails/20508500.jpeg?cwt=signed1"
              }
            },
            {
              "id": "01a20f53-0dd8-717a-9448-de51354741b0",
              "is_live": true,
              "start_time": "2026-11-24T20:50:31Z",
              "duration": 1200,
              "title": "Live Now Recording",
              "thumbnail": {
                "src": "https://web.kick.com/api/v1/channels/668/thumbnail.jpeg"
              }
            }
          ]
        }
    """.trimIndent()

    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        requests += request
        val isWebVideos = request.url.host == "web.kick.com" && request.url.encodedPath == "/api/v1/channels/668/videos"
        val (status, body) = when {
            request.url.encodedPath == "/api/v2/channels/xqc/videos" -> 200 to
                (startTimeOverride?.let { v2Page1Body.replace("2026-11-25 22:19:55", it) } ?: v2Page1Body)
            isWebVideos && failWebVideos -> 503 to """{"error":"unavailable"}"""
            isWebVideos -> 200 to if (useExplicitWebDurationSeconds) {
                webVideosBody.replace("\"duration\":", "\"duration_seconds\":")
            } else {
                webVideosBody
            }
            else -> 404 to "{}"
        }
        Response.Builder()
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .code(status)
            .message("fixture")
            .body(body.toResponseBody("application/json".toMediaType()))
            .build()
    }.build()

    private val repository = KickRepository(
        context,
        client,
        null,
        executor,
        json,
        AuthRepository(null, null, executor, client, json),
        KickOfficialApiClient(context, client, json),
    )

    @After
    fun tearDown() {
        executor.shutdownNow()
    }

    @Test
    fun enrichesStaticChannelVodThumbnailsFromWebVideosAndPreservesLiveVodThumbnail() = runBlocking {
        val page = repository.getChannelVideosPage("xqc", limit = 20)!!
        val finished = page.videos.single { it.id == "140270814" }
        val live = page.videos.single { it.id == "140060512" }

        assertEquals(
            "https://web.kick.com/api/v1/videos/01a214cb-42f8-75cd-b00f-f083ea893dfd/thumbnails/20508500.jpeg?cwt=signed1",
            finished.thumbnailUrl,
        )
        assertNull(finished.vodId)
        assertEquals("https://web.kick.com/api/v1/channels/668/thumbnail.jpeg?height=720", live.thumbnailUrl)

        // Second page request reuses cached web.kick.com thumbnails.
        repository.getChannelVideosPage("xqc", limit = 20, cursor = "next-page")
        assertEquals(
            1,
            requests.count { it.url.host == "web.kick.com" && it.url.encodedPath == "/api/v1/channels/668/videos" },
        )
    }

    @Test
    fun matchesNearbyStartTimeUsingWebDurationInSeconds() = runBlocking {
        startTimeOverride = "2026-11-25 22:19:58"

        val video = repository.getChannelVideosPage("xqc")!!.videos.single { it.id == "140270814" }

        assertTrue(video.thumbnailUrl.orEmpty().startsWith("https://web.kick.com/api/v1/videos/"))
        assertEquals("41017", video.duration)
        assertNull(video.vodId)
    }

    @Test
    fun repeatedTitleAndDurationCannotMatchAnOlderBroadcast() = runBlocking {
        startTimeOverride = "2026-10-25 22:19:55"
        useExplicitWebDurationSeconds = true

        val video = repository.getChannelVideosPage("xqc")!!.videos.single { it.id == "140270814" }

        assertTrue(video.thumbnailUrl.orEmpty().endsWith("/media/thumbnails/thumb1.jpg"))
        assertNull(video.vodId)
    }

    @Test
    fun liveRewindSkipsWebThumbnailsWithoutAffectingTheVideoList() = runBlocking {
        val rewind = repository.getLiveVodInfo("xqc", "140060512")
        assertTrue(rewind?.url.orEmpty().endsWith("/liveRec/media/hls/master.m3u8"))
        assertFalse(requests.any { it.url.host == "web.kick.com" })

        val video = repository.getChannelVideosPage("xqc", limit = 5)!!.videos.single { it.id == "140270814" }
        assertTrue(video.thumbnailUrl.orEmpty().startsWith("https://web.kick.com/api/v1/videos/"))
    }

    @Test
    fun fallsBackToIvsVodThumbnailWhenWebVideosEndpointFails() = runBlocking {
        failWebVideos = true
        val page = repository.getChannelVideosPage("xqc", limit = 20)!!
        val finished = page.videos.single { it.id == "140270814" }

        assertEquals(
            "https://stream.kick.com/3c81249a5ce0/ivs/v1/196233775518/DsuAwCgUc9Bh/2026/11/25/22/19/grz1HiLuGURr/media/thumbnails/thumb1.jpg",
            finished.thumbnailUrl,
        )
    }

    @Test
    fun toStreamFallsBackToWebChannelThumbnailWhenV2ThumbnailIsNullOrBlockedStreamHost() {
        val channelNullThumb = KickChannelResponse(
            id = 26869410L,
            userId = 27894320L,
            slug = "absi",
            livestream = KickChannelLivestream(id = 140395815L, thumbnail = null),
        )
        val channelBlockedThumb = KickChannelResponse(
            id = 11853347L,
            slug = "maherco",
            livestream = KickChannelLivestream(
                id = 140490776L,
                thumbnail = KickThumbnail(url = "https://stream.kick.com/thumbnails/livestream/140490776/thumb0/video_thumbnail/thumb0.jpg"),
            ),
        )
        val offlineChannel = KickChannelResponse(
            id = 668L,
            slug = "xqc",
            livestream = null,
        )

        assertEquals(
            "https://web.kick.com/api/v1/channels/26869410/thumbnail.jpeg?height=720",
            repository.toStream(channelNullThumb).thumbnailUrl,
        )
        assertEquals(
            "https://web.kick.com/api/v1/channels/11853347/thumbnail.jpeg?height=720",
            repository.toStream(channelBlockedThumb).thumbnailUrl,
        )
        assertNull(repository.toStream(offlineChannel).thumbnailUrl)
    }

    @Test
    fun helperDetectsStaticChannelThumbnailsAndDropsDeadDefaultThumbnail() {
        assertTrue(KickApiHelper.isStaticKickChannelThumbnailUrl("https://web.kick.com/api/v1/channels/668/thumbnail.jpeg?height=720"))
        assertTrue(KickApiHelper.isStaticKickChannelThumbnailUrl("https://web.kick.com/api/v1/channels/668/thumbnail.jpeg"))
        assertFalse(KickApiHelper.isStaticKickChannelThumbnailUrl("https://web.kick.com/api/v1/videos/01a2/thumbnails/20508500.jpeg?cwt=abc"))

        assertNull(KickApiHelper.getTemplateUrl(null, "video"))
        assertNull(KickApiHelper.getTemplateUrl("", "game"))
        assertNull(KickApiHelper.getTemplateUrl("https://files.kick.com/images/default-thumbnail.png", "video"))

        assertEquals(
            "https://stream.kick.com/3c81249a5ce0/ivs/v1/196233775518/DsuAwCgUc9Bh/2026/11/25/22/19/grz1HiLuGURr/media/thumbnails/thumb1.jpg",
            KickApiHelper.deriveIvsVodThumbnailUrl(
                "https://stream.kick.com/3c81249a5ce0/ivs/v1/196233775518/DsuAwCgUc9Bh/2026/11/25/22/19/grz1HiLuGURr/media/hls/master.m3u8",
            ),
        )
        assertNull(KickApiHelper.deriveIvsVodThumbnailUrl("https://example.com/master.m3u8"))
        assertEquals("https://web.kick.com/api/v1/channels/668/thumbnail.jpeg?height=720", KickApiHelper.buildKickChannelThumbnailUrl("668"))
        assertNull(KickApiHelper.buildKickChannelThumbnailUrl("xqc"))
    }
}
