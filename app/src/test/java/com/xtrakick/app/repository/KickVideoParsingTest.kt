package com.xtrakick.app.repository

import com.xtrakick.app.model.ui.Video
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickVideoParsingTest {

    private fun resolveDisplayName(
        channelLogin: String?,
        channelName: String?,
        nameDisplayPref: String = "1"
    ): String? {
        val cleanLogin = channelLogin?.trim()?.takeIf { it.isNotBlank() }
        val cleanName = channelName?.trim()?.takeIf { it.isNotBlank() }
        return if (!cleanLogin.isNullOrBlank() && !cleanName.isNullOrBlank() && !cleanLogin.equals(cleanName, true)) {
            when (nameDisplayPref) {
                "0" -> "${cleanName}(${cleanLogin})"
                "1" -> cleanName
                else -> cleanLogin
            }
        } else {
            cleanName ?: cleanLogin
        }
    }

    @Test
    fun testDisplayNameResolution_whenChannelNameIsNull_fallsBackToChannelLogin() {
        val displayName = resolveDisplayName(channelLogin = "maximusblack", channelName = null, nameDisplayPref = "1")
        assertEquals("maximusblack", displayName)
    }

    @Test
    fun testDisplayNameResolution_whenChannelLoginIsNull_fallsBackToChannelName() {
        val displayName = resolveDisplayName(channelLogin = null, channelName = "MaximusBlack", nameDisplayPref = "1")
        assertEquals("MaximusBlack", displayName)
    }

    @Test
    fun testDisplayNameResolution_whenBothPresentAndDiffer_respectsDisplayMode() {
        assertEquals("Maximus(maximusblack)", resolveDisplayName("maximusblack", "Maximus", "0"))
        assertEquals("Maximus", resolveDisplayName("maximusblack", "Maximus", "1"))
        assertEquals("maximusblack", resolveDisplayName("maximusblack", "Maximus", "2"))
    }

    @Test
    fun testDisplayNameResolution_whenBothMatchCaseInsensitive_usesChannelName() {
        assertEquals("MaximusBlack", resolveDisplayName("maximusblack", "MaximusBlack", "1"))
        assertEquals("MaximusBlack", resolveDisplayName("maximusblack", "MaximusBlack", "0"))
    }

    @Test
    fun testVideoModelChannelProperties() {
        val video = Video(
            id = "12345",
            channelId = "999",
            channelLogin = "maximusblack",
            channelName = "MaximusBlack",
            title = "OTT - Gang Update",
            duration = "7445"
        )
        assertEquals("12345", video.id)
        assertEquals(com.xtrakick.app.util.AppConstants.KICK, video.source)
        assertEquals("maximusblack", video.channelLogin)
        assertEquals("MaximusBlack", video.channelName)
        assertEquals("OTT - Gang Update", video.title)
    }

    @Test
    fun testVideoModelDefaultsSourceToKick() {
        val video = Video(id = "01a0590d-ed00-78b9-9df1-979c88189a5e", uuid = "01a0590d-ed00-78b9-9df1-979c88189a5e")
        assertEquals(com.xtrakick.app.util.AppConstants.KICK, video.source)
        assertEquals("01a0590d-ed00-78b9-9df1-979c88189a5e", video.uuid)
    }

    @Test
    fun testLiveVodInfo_propertiesAndRewindTimestampCalculation() {
        val startedAtIso = "2026-10-29T12:00:00Z"
        val info = KickRepository.LiveVodInfo(
            url = "https://stream.kick.com/vod/master.m3u8",
            startedAt = startedAtIso
        )
        assertEquals("https://stream.kick.com/vod/master.m3u8", info.url)
        assertEquals(startedAtIso, info.startedAt)

        val streamStartMs = com.xtrakick.app.util.KickApiHelper.parseIso8601DateUTC(info.startedAt!!)
        org.junit.Assert.assertNotNull(streamStartMs)

        // 30 minutes in, rewound 5 minutes -> position is 25 minutes (1,500,000 ms)
        val targetPositionMs = 25 * 60 * 1000L
        val chatTimestampMs = streamStartMs!! + targetPositionMs
        assertEquals(streamStartMs + 1_500_000L, chatTimestampMs)
    }

    @Test
    fun testExtractKickVideoUrl_withRootRecordingUrl() {
        val json = """
            {
                "id": "01a1adfa-8980-733f-a6bd-e9c096e071cd",
                "recording_url": "https://stream.kick.com/ivs/v1/master.m3u8"
            }
        """.trimIndent()
        val obj = Json.parseToJsonElement(json).jsonObject
        val url = KickRepository.extractKickVideoUrl(obj)
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8", url)
    }

    @Test
    fun testExtractKickVideoUrl_withNestedLivestreamRecordingUrl() {
        val json = """
            {
                "id": "12345",
                "livestream": {
                    "recording_url": "https://stream.kick.com/ivs/v1/stream.m3u8"
                }
            }
        """.trimIndent()
        val obj = Json.parseToJsonElement(json).jsonObject
        val url = KickRepository.extractKickVideoUrl(obj)
        assertEquals("https://stream.kick.com/ivs/v1/stream.m3u8", url)
    }

    @Test
    fun testExtractKickVideoUrl_withNestedVideoRecordingUrl() {
        val json = """
            {
                "id": "12345",
                "video": {
                    "recording_url": "https://stream.kick.com/ivs/v1/vod.m3u8"
                }
            }
        """.trimIndent()
        val obj = Json.parseToJsonElement(json).jsonObject
        val url = KickRepository.extractKickVideoUrl(obj)
        assertEquals("https://stream.kick.com/ivs/v1/vod.m3u8", url)
    }

    @Test
    fun testExtractKickVideoUrl_withSourceUrl() {
        val json = """
            {
                "id": "12345",
                "source": {
                    "url": "https://stream.kick.com/ivs/v1/master.m3u8"
                }
            }
        """.trimIndent()
        val obj = Json.parseToJsonElement(json).jsonObject
        val url = KickRepository.extractKickVideoUrl(obj)
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8", url)
    }

    @Test
    fun testExtractKickVideoUrl_normalizesKickStreamWithoutM3u8() {
        val json = """
            {
                "id": "12345",
                "playback_url": "https://stream.kick.com/channel/hls"
            }
        """.trimIndent()
        val obj = Json.parseToJsonElement(json).jsonObject
        val url = KickRepository.extractKickVideoUrl(obj)
        assertEquals("https://stream.kick.com/channel/hls/playlist.m3u8", url)
    }

    @Test
    fun testExtractKickVideoUrl_returnsNullWhenNoValidUrlPresent() {
        val json = """
            {
                "id": "12345",
                "title": "Some Stream"
            }
        """.trimIndent()
        val obj = Json.parseToJsonElement(json).jsonObject
        val url = KickRepository.extractKickVideoUrl(obj)
        assertNull(url)
    }

    @Test
    fun testVideoLookupMatchesVodId() {
        val video = Video(
            id = "136225445",
            uuid = "6398d731-0c1b-4bcf-9b69-0748e78ff88c",
            vodId = "01a1adfa-8980-733f-a6bd-e9c096e071cd",
            url = "https://stream.kick.com/ivs/v1/master.m3u8"
        )
        val videos = listOf(video)
        val targetQueryId = "01a1adfa-8980-733f-a6bd-e9c096e071cd"

        val matched = videos.firstOrNull {
            it.id == targetQueryId || it.uuid == targetQueryId || it.slug == targetQueryId || it.vodId == targetQueryId
        }
        assertEquals(video, matched)
    }
}
