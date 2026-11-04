package com.xtrakick.app.util.m3u8

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.EOFException
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse

class PlaylistUtilsByteRangeTest {
    @Test
    fun byteRangesSurviveSavingAndSelectedWindows() {
        val playlist = parse("#EXTM3U\n#EXT-X-TARGETDURATION:2\n#EXT-X-BYTERANGE:100@50\n#EXTINF:2,\nasset.ts\n#EXT-X-BYTERANGE:200\n#EXTINF:2,\nasset.ts\n#EXT-X-ENDLIST\n")
        val output = ByteArrayOutputStream()
        PlaylistUtils.writeMediaPlaylist(playlist.copy(segments = playlist.segments.drop(1)), output)
        val saved = parse(output.toString("UTF-8"))
        assertEquals(150L, saved.segments.single().byteRangeStart)
        assertEquals(200L, saved.segments.single().byteRangeLength)
        assertTrue(output.toString("UTF-8").contains("#EXT-X-VERSION:4"))
    }

    @Test
    fun copySegmentExtractsTheExactRangeAndRejectsTruncation() {
        val segment = Segment("asset.ts", 2f, null, null, 2, 3)
        val output = ByteArrayOutputStream()
        PlaylistUtils.copySegment("abcdefgh".byteInputStream(), output, segment)
        assertEquals("cde", output.toString("UTF-8"))
        assertThrows(EOFException::class.java) {
            PlaylistUtils.copySegment("abc".byteInputStream(), ByteArrayOutputStream(), segment)
        }
    }

    @Test
    fun signedPlaylistPathsAndRelativeAssetsAreResolvedCorrectly() {
        assertTrue(PlaylistUtils.isHlsUrl("https://example.com/a.M3U8?token=secret#fragment"))
        assertFalse(PlaylistUtils.isHlsUrl("https://example.com/a.mp4?file=.m3u8"))
        assertEquals("https://example.com/segment.ts", PlaylistUtils.resolveUri("https://example.com/live/master.m3u8?token=x", "/segment.ts"))
        assertEquals("https://cdn.example.com/segment.ts", PlaylistUtils.resolveUri("https://example.com/live/master.m3u8", "//cdn.example.com/segment.ts"))
        assertEquals("https://example.com/segment.ts?token=x", PlaylistUtils.resolveUri("https://example.com/live/master.m3u8", "../segment.ts?token=x"))
    }

    @Test
    fun assetNamesAreStableAndSeparateSameBasenames() {
        assertEquals("segment.ts", PlaylistUtils.assetFileName("segment.ts"))
        val nested = PlaylistUtils.assetFileName("one/segment.ts")
        assertEquals(nested, PlaylistUtils.assetFileName("one/segment.ts"))
        assertFalse(nested == PlaylistUtils.assetFileName("two/segment.ts"))
        assertFalse(nested.contains('/'))
        assertFalse(PlaylistUtils.assetFileName("https://example.com/segment.ts?token=x").contains('?'))
    }

    private fun parse(text: String): MediaPlaylist =
        PlaylistUtils.parseMediaPlaylist(ByteArrayInputStream(text.toByteArray()))

    @Test
    fun `explicit offsets attach to following segments`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXT-X-TARGETDURATION:2
            #EXT-X-BYTERANGE:100@0
            #EXTINF:2.0,
            container.ts
            #EXT-X-BYTERANGE:200@100
            #EXTINF:2.0,
            container.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertEquals(2, playlist.segments.size)
        assertEquals(0L, playlist.segments[0].byteRangeStart)
        assertEquals(100L, playlist.segments[0].byteRangeLength)
        assertEquals(100L, playlist.segments[1].byteRangeStart)
        assertEquals(200L, playlist.segments[1].byteRangeLength)
    }

    @Test
    fun `missing offset continues from previous range end`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXT-X-TARGETDURATION:2
            #EXT-X-BYTERANGE:100@50
            #EXTINF:2.0,
            container.ts
            #EXT-X-BYTERANGE:200
            #EXTINF:2.0,
            container.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertEquals(150L, playlist.segments[1].byteRangeStart)
        assertEquals(200L, playlist.segments[1].byteRangeLength)
    }

    @Test
    fun `first bare range starts at zero`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXT-X-TARGETDURATION:2
            #EXT-X-BYTERANGE:100
            #EXTINF:2.0,
            container.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertEquals(0L, playlist.segments[0].byteRangeStart)
        assertEquals(100L, playlist.segments[0].byteRangeLength)
    }

    @Test
    fun `segments without byterange have null range`() {
        val playlist = parse(
            """
            #EXTM3U
            #EXT-X-TARGETDURATION:6
            #EXTINF:5.0,
            segment0.ts
            #EXTINF:5.0,
            segment1.ts
            #EXT-X-ENDLIST
            """.trimIndent()
        )
        assertEquals(2, playlist.segments.size)
        playlist.segments.forEach {
            assertNull(it.byteRangeStart)
            assertNull(it.byteRangeLength)
        }
    }
}
