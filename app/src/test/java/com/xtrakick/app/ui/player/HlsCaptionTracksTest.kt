package com.xtrakick.app.ui.player

import android.app.Application
import android.net.Uri
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist
import com.xtrakick.app.player.lowlatency.HlsPlaylistParser
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class HlsCaptionTracksTest {
    private fun parse(tags: String, attributes: String = ""): HlsMultivariantPlaylist {
        val master = "#EXTM3U\n$tags\n#EXT-X-STREAM-INF:BANDWIDTH=1000000$attributes\nvideo.m3u8\n"
        return HlsPlaylistParser().parse(Uri.parse("https://example.com/master.m3u8"), master.byteInputStream()) as HlsMultivariantPlaylist
    }

    @Test fun subtitleRenditionDoesNotInventEmbeddedCaptionTrack() {
        val playlist = parse("""#EXT-X-MEDIA:TYPE=SUBTITLES,GROUP-ID="subs",NAME="English",LANGUAGE="en",URI="en.m3u8"""", """,SUBTITLES="subs"""" )
        assertEquals(1, playlist.subtitles.size)
        assertEquals("en", playlist.subtitles.single().format.language)
        assertTrue(playlist.muxedCaptionFormats!!.isEmpty())
    }

    @Test fun preservesDeclaredEmbeddedCaptions() {
        val playlist = parse("""#EXT-X-MEDIA:TYPE=CLOSED-CAPTIONS,GROUP-ID="cc",NAME="English",LANGUAGE="en",INSTREAM-ID="CC1"""", """,CLOSED-CAPTIONS="cc"""" )
        assertEquals(1, playlist.muxedCaptionFormats!!.size)
        assertEquals("en", playlist.muxedCaptionFormats!!.single().language)
    }

    @Test fun respectsExplicitNoCaptionsAndAbsentDeclarations() {
        assertTrue(parse("", ",CLOSED-CAPTIONS=NONE").muxedCaptionFormats!!.isEmpty())
        assertTrue(parse("").muxedCaptionFormats!!.isEmpty())
    }
}
