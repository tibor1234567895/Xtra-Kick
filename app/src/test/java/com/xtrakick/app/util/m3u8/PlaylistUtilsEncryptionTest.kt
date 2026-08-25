package com.xtrakick.app.util.m3u8

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.ByteArrayInputStream

class PlaylistUtilsEncryptionTest {

    private fun parse(text: String): MediaPlaylist =
        PlaylistUtils.parseMediaPlaylist(ByteArrayInputStream(text.toByteArray()))

    @Test
    fun `aes-128 key marks playlist encrypted`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXT-X-TARGETDURATION:6
            #EXT-X-KEY:METHOD=AES-128,URI="https://example.com/key"
            #EXTINF:5.0,
            segment0.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertTrue(playlist.encrypted)
        assertEquals(1, playlist.segments.size)
    }

    @Test
    fun `method-none does not mark playlist encrypted`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXT-X-KEY:METHOD=NONE
            #EXTINF:5.0,
            segment0.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertFalse(playlist.encrypted)
    }

    @Test
    fun `playlist without key tag is unencrypted`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXTINF:5.0,
            segment0.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertFalse(playlist.encrypted)
    }

    @Test
    fun `key anywhere in playlist marks it encrypted`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXTINF:5.0,
            segment0.ts
            #EXT-X-KEY:METHOD=SAMPLE-AES,URI="skd://key65"
            #EXTINF:5.0,
            segment1.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertTrue(playlist.encrypted)
        assertEquals(2, playlist.segments.size)
    }
}
