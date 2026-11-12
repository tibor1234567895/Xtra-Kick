package com.xtrakick.app.repository

import com.xtrakick.app.model.ui.Clip
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
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickClipParsingTest {
    private val executor = Executors.newSingleThreadExecutor()
    private val sampleClipJson = """
    {
      "id": "clip_01M71HA6XBMT6BEQ1ACG6ZCX13",
      "livestream_id": "136925910",
      "category_id": "8",
      "channel_id": 668,
      "user_id": 106988558,
      "title": "fgnxtnfxgtfn",
      "clip_url": "https://clips.kick.com/clips/ce/clip_01M71HA6XBMT6BEQ1ACG6ZCX13/playlist.m3u8",
      "thumbnail_url": "https://clips.kick.com/clips/ce/clip_01M71HA6XBMT6BEQ1ACG6ZCX13/thumbnail.webp",
      "privacy": "public",
      "views": 12777,
      "duration": 63,
      "created_at": "2026-11-10T01:32:53.470151Z",
      "video_url": "https://clips.kick.com/clips/ce/clip_01M71HA6XBMT6BEQ1ACG6ZCX13/playlist.m3u8",
      "view_count": 12777,
      "category": {
        "id": 8,
        "name": "Grand Theft Auto V (GTA)",
        "slug": "grand-theft-auto-v"
      },
      "creator": {
        "id": 106988558,
        "username": "GUguGAgi69",
        "slug": "gugugagi69"
      },
      "channel": {
        "id": 668,
        "username": "xQc",
        "slug": "xqc",
        "profile_picture": "https://files.kick.com/images/user/676/profile_image/conversion/151f289a-5bff-4f31-b125-0c54c542519e-thumb.webp"
      }
    }
    """.trimIndent()

    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val url = chain.request().url.toString()
        val body = when {
            url.contains("/categories/") -> """{"clips":[$sampleClipJson]}"""
            url.contains("/clips/") -> """{"clip":$sampleClipJson}"""
            else -> """{}"""
        }
        Response.Builder()
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .code(200)
            .message("OK")
            .body(body.toResponseBody("application/json".toMediaType()))
            .build()
    }.build()

    private val context = RuntimeEnvironment.getApplication()
    private val json = Json { ignoreUnknownKeys = true }
    private val repository = KickRepository(
        context, client, null, executor, json,
        AuthRepository(null, null, executor, client, json),
        KickOfficialApiClient(context, client, json)
    )

    @After
    fun close() {
        client.connectionPool.evictAll()
        client.dispatcher.executorService.shutdownNow()
        executor.shutdownNow()
    }

    @Test
    fun normalizeDateHandlesKickTimestamps() {
        assertEquals("2026-11-12T14:30:00Z", repository.normalizeDate("2026-11-12T14:30:00"))
        assertEquals("2026-11-12T14:30:00Z", repository.normalizeDate("2026-11-12 14:30:00"))
        assertEquals("2026-11-12T14:30:00.123456Z", repository.normalizeDate("2026-11-12T14:30:00.123456Z"))
        assertEquals("2026-11-12T14:30:00+01:00", repository.normalizeDate("2026-11-12T14:30:00+01:00"))
        assertEquals(null, repository.normalizeDate(null))
        assertEquals(null, repository.normalizeDate(" "))
    }

    @Test
    fun categoryClipsPageExtractsChannelAndCreatorCorrectly() = runBlocking {
        val page = repository.getCategoryClipsPage(
            categorySlug = "grand-theft-auto-v",
            limit = 20
        )
        assertNotNull(page)
        assertEquals(1, page!!.clips.size)

        val clip: Clip = page.clips.first()
        assertEquals("clip_01M71HA6XBMT6BEQ1ACG6ZCX13", clip.id)
        assertEquals("fgnxtnfxgtfn", clip.title)
        assertEquals("668", clip.channelId)
        assertEquals("xQc", clip.channelName)
        assertEquals("xqc", clip.channelLogin)
        assertEquals(
            "https://files.kick.com/images/user/676/profile_image/conversion/151f289a-5bff-4f31-b125-0c54c542519e-thumb.webp",
            clip.channelLogo
        )
        assertEquals("106988558", clip.creatorId)
        assertEquals("GUguGAgi69", clip.creatorName)
        assertEquals("gugugagi69", clip.creatorLogin)
        assertEquals("Grand Theft Auto V (GTA)", clip.gameName)
        assertEquals(12777, clip.viewCount)
        assertEquals(63.0, clip.duration ?: 0.0, 0.001)
    }

    @Test
    fun singleClipExtractsChannelAndCreatorCorrectly() = runBlocking {
        val clip = repository.getClip("clip_01M71HA6XBMT6BEQ1ACG6ZCX13")
        assertNotNull(clip)
        assertEquals("clip_01M71HA6XBMT6BEQ1ACG6ZCX13", clip!!.id)
        assertEquals("fgnxtnfxgtfn", clip.title)
        assertEquals("668", clip.channelId)
        assertEquals("xQc", clip.channelName)
        assertEquals("xqc", clip.channelLogin)
        assertEquals(
            "https://files.kick.com/images/user/676/profile_image/conversion/151f289a-5bff-4f31-b125-0c54c542519e-thumb.webp",
            clip.channelLogo
        )
        assertEquals("106988558", clip.creatorId)
        assertEquals("GUguGAgi69", clip.creatorName)
        assertEquals("gugugagi69", clip.creatorLogin)
    }
}
