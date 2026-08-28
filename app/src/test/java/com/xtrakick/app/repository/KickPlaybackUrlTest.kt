package com.xtrakick.app.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickPlaybackUrlTest {

    @Test
    fun parsesRootPlaybackUrl() {
        val json = """
        {
            "playback_url": "https://stream.kick.com/ivs/v1/master.m3u8?token=jwt123"
        }
        """.trimIndent()

        val url = KickRepository.parsePlaybackUrlResponse(json)
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8?token=jwt123", url)
    }

    @Test
    fun parsesNestedDataPlaybackUrl() {
        val json = """
        {
            "data": {
                "playback_url": "https://stream.kick.com/ivs/v1/master.m3u8?token=auth_token_456"
            }
        }
        """.trimIndent()

        val url = KickRepository.parsePlaybackUrlResponse(json)
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8?token=auth_token_456", url)
    }

    @Test
    fun parsesAlternativeKeysInPayload() {
        val jsonUrl = """{"url": "https://stream.kick.com/hls/test.m3u8"}"""
        assertEquals("https://stream.kick.com/hls/test.m3u8", KickRepository.parsePlaybackUrlResponse(jsonUrl))

        val jsonPlaylist = """{"data": {"playlist_url": "https://stream.kick.com/hls/playlist.m3u8"}}"""
        assertEquals("https://stream.kick.com/hls/playlist.m3u8", KickRepository.parsePlaybackUrlResponse(jsonPlaylist))

        val jsonHls = """{"hls_url": "https://stream.kick.com/hls/master.m3u8"}"""
        assertEquals("https://stream.kick.com/hls/master.m3u8", KickRepository.parsePlaybackUrlResponse(jsonHls))

        val jsonPlaybackUrlCamel = """{"playbackUrl": "https://stream.kick.com/hls/camel.m3u8"}"""
        assertEquals("https://stream.kick.com/hls/camel.m3u8", KickRepository.parsePlaybackUrlResponse(jsonPlaybackUrlCamel))
    }

    @Test
    fun parsesDirectStringData() {
        val json = """{"data": "https://stream.kick.com/ivs/v1/master.m3u8"}"""
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8", KickRepository.parsePlaybackUrlResponse(json))
    }

    @Test
    fun returnsNullForInvalidOrMissingPlaybackUrl() {
        assertNull(KickRepository.parsePlaybackUrlResponse(""))
        assertNull(KickRepository.parsePlaybackUrlResponse("   "))
        assertNull(KickRepository.parsePlaybackUrlResponse("{}"))
        assertNull(KickRepository.parsePlaybackUrlResponse("""{"status": 200, "message": "ok"}"""))
        assertNull(KickRepository.parsePlaybackUrlResponse("""{"data": {}}"""))
        assertNull(KickRepository.parsePlaybackUrlResponse("""{"playback_url": "not-a-valid-url"}"""))
        assertNull(KickRepository.parsePlaybackUrlResponse("""{"data": "invalid-protocol://stream.kick.com"}"""))
        assertNull(KickRepository.parsePlaybackUrlResponse("not valid json"))
    }

    @Test
    fun trimsWhitespaceFromParsedPlaybackUrl() {
        val json = """
        {
            "playback_url": "  https://stream.kick.com/ivs/v1/master.m3u8?token=jwt_trimmed \n"
        }
        """.trimIndent()

        val url = KickRepository.parsePlaybackUrlResponse(json)
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8?token=jwt_trimmed", url)
    }

    @Test
    fun fallsThroughWhenPriorCandidateIsNullOrNonHttp() {
        val jsonWithNull = """
        {
            "playback_url": null,
            "data": {
                "playback_url": "https://stream.kick.com/ivs/v1/master.m3u8?token=fallback_123"
            }
        }
        """.trimIndent()
        assertEquals("https://stream.kick.com/ivs/v1/master.m3u8?token=fallback_123", KickRepository.parsePlaybackUrlResponse(jsonWithNull))

        val jsonWithInvalidUrl = """
        {
            "playback_url": "ftp://not-supported",
            "url": "https://stream.kick.com/hls/secondary.m3u8"
        }
        """.trimIndent()
        assertEquals("https://stream.kick.com/hls/secondary.m3u8", KickRepository.parsePlaybackUrlResponse(jsonWithInvalidUrl))
    }
}
