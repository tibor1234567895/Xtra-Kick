package com.xtrakick.app.util.m3u8

import android.app.Application
import com.xtrakick.app.ui.download.parseDownloadPlaylistQualities
import com.xtrakick.app.ui.download.selectStreamQualityUrl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class PlaylistUtilsVariantsTest {
    private val baseUrl = "https://example.com/live/master.m3u8?token=master"

    private fun parse(tags: String) = PlaylistUtils.parseVariantUrls("#EXTM3U\n${tags.trimIndent()}\n", baseUrl)

    @Test
    fun subtitleLanguagesDoNotBecomeQualitiesOrShiftUrls() {
        val tags = """
            #EXT-X-MEDIA:TYPE=SUBTITLES,GROUP-ID="subs",NAME="English",LANGUAGE="en",URI="https://example.com/en.m3u8"
            #EXT-X-MEDIA:TYPE=SUBTITLES,GROUP-ID="subs",NAME="Portuguese",LANGUAGE="pt",URI="pt.m3u8"
            #EXT-X-MEDIA:TYPE=SUBTITLES,GROUP-ID="subs",NAME="Spanish",LANGUAGE="es",URI="es.m3u8"
            #EXT-X-MEDIA:TYPE=SUBTITLES,GROUP-ID="subs",NAME="French",LANGUAGE="fr",URI="fr.m3u8"
            #EXT-X-MEDIA:TYPE=SUBTITLES,GROUP-ID="subs",NAME="German",LANGUAGE="de",URI="de.m3u8"
            #EXT-X-STREAM-INF:BANDWIDTH=6000000,RESOLUTION=1920x1080,FRAME-RATE=59.94,CODECS="avc1.64002a,mp4a.40.2",SUBTITLES="subs"
            source.m3u8?token=video&part=1
            #EXT-X-STREAM-INF:BANDWIDTH=2000000,RESOLUTION=1280x720,CODECS="avc1.4d401f,mp4a.40.2",SUBTITLES="subs"
            /vod/720.m3u8
        """.trimIndent()
        val variants = parse(tags)

        assertEquals(listOf("1080p60", "720p"), variants.keys.map { it.first })
        assertEquals(listOf("https://example.com/live/source.m3u8?token=video&part=1", "https://example.com/vod/720.m3u8"), variants.values.toList())
        val choices = parseDownloadPlaylistQualities(RuntimeEnvironment.getApplication(), "#EXTM3U\n$tags\n", baseUrl)
        assertEquals(listOf("1080p60", "720p"), choices.values.map { it.first })
        assertEquals(variants.values.toList(), choices.values.map { it.second })
    }

    @Test
    fun missingCodecDoesNotShiftLaterCodecOrUrl() {
        val variants = parse("""
            #EXT-X-STREAM-INF:BANDWIDTH=1000000,RESOLUTION=854x480
            low.m3u8
            #EXT-X-STREAM-INF:BANDWIDTH=5000000,RESOLUTION=1920x1080,CODECS="av01.0.08M.08,mp4a.40.2"
            high.m3u8
        """)
        assertEquals("https://example.com/live/low.m3u8", variants["480p" to null])
        assertEquals("https://example.com/live/high.m3u8", variants["1080p" to "av01.0.08M.08,mp4a.40.2"])
    }

    @Test
    fun ivsLabelsAndAudioOnlyVariantsArePreserved() {
        val variants = parse("""
            #EXT-X-STREAM-INF:BANDWIDTH=160000,CODECS="mp4a.40.2",IVS-NAME="audio_only"
            audio.m3u8
            #EXT-X-STREAM-INF:BANDWIDTH=1000000,RESOLUTION=1280x720,FRAME-RATE=60,CODECS="avc1.4d401f,mp4a.40.2",IVS-NAME="720p60"
            720.m3u8
            #EXT-X-STREAM-INF:BANDWIDTH=6000000,RESOLUTION=1920x1080,CODECS="avc1.64002a,mp4a.40.2",IVS-NAME="Source"
            source.m3u8
        """)
        assertEquals(listOf("source", "720p60", "audio_only"), variants.keys.map { it.first })
        assertEquals("https://example.com/live/source.m3u8", variants.values.first())
        assertEquals("https://example.com/live/audio.m3u8", variants.values.last())
    }

    @Test
    fun ignoresAlternateAudioAndIframePlaylists() {
        val variants = parse("""
            #EXT-X-MEDIA:TYPE=AUDIO,GROUP-ID="audio",NAME="English",URI="audio.m3u8"
            #EXT-X-I-FRAME-STREAM-INF:BANDWIDTH=100000,RESOLUTION=1920x1080,URI="iframe.m3u8"
            #EXT-X-STREAM-INF:BANDWIDTH=1000000,RESOLUTION=1280x720,CODECS="avc1.4d401f,mp4a.40.2",AUDIO="audio"
            video.m3u8
        """)
        assertEquals(listOf("720p"), variants.keys.map { it.first })
        assertEquals(listOf("https://example.com/live/video.m3u8"), variants.values.toList())
    }

    @Test
    fun preservesDifferentCodecsAtSameResolution() {
        val tags = """
            #EXT-X-STREAM-INF:BANDWIDTH=1000000,RESOLUTION=1280x720,CODECS="avc1.4d401f,mp4a.40.2"
            h264.m3u8
            #EXT-X-STREAM-INF:BANDWIDTH=800000,RESOLUTION=1280x720,CODECS="hvc1.1.6.L93.B0,mp4a.40.2"
            h265.m3u8
        """.trimIndent()
        val variants = parse(tags)
        assertEquals(2, variants.size)
        assertEquals(setOf("avc1.4d401f,mp4a.40.2", "hvc1.1.6.L93.B0,mp4a.40.2"), variants.keys.map { it.second }.toSet())
        val choices = parseDownloadPlaylistQualities(RuntimeEnvironment.getApplication(), "#EXTM3U\n$tags\n", baseUrl)
        assertEquals(listOf("720p H.264", "720p H.265"), choices.keys.toList())
        assertEquals(choices.keys.toList(), choices.values.map { it.first })
        assertEquals(variants.values.toList(), choices.values.map { it.second })
    }

    @Test
    fun acceptsExtensionlessAndProtocolRelativeSignedVariantUrls() {
        val variants = parse("""
            #EXT-X-STREAM-INF:BANDWIDTH=1000000,RESOLUTION=1280x720
            //cdn.example.com/stream?token=a%2Fb&expires=123
        """)
        assertEquals("https://cdn.example.com/stream?token=a%2Fb&expires=123", variants.values.single())
    }

    @Test
    fun derivesAudioOnlyWithoutAnIvsLabel() {
        val variants = parse("""
            #EXT-X-STREAM-INF:BANDWIDTH=160000,CODECS="mp4a.40.2"
            audio.m3u8
        """)
        assertEquals(listOf("audio_only"), variants.keys.map { it.first })
    }

    @Test
    fun mediaPlaylistHasNoVariantChoices() {
        assertTrue(parse("""
            #EXT-X-TARGETDURATION:10
            #EXTINF:10,
            segment.ts
            #EXT-X-ENDLIST
        """).isEmpty())
    }

    @Test
    fun unrelatedNameAttributesAreNotQualityLabels() {
        val variants = parse("""
            #EXT-X-SESSION-DATA:DATA-ID="title",VALUE="NAME=English"
            #EXT-X-STREAM-INF:BANDWIDTH=1000000,RESOLUTION=1280x720,NAME="Untrusted label"
            video.m3u8
        """)
        assertEquals(listOf("720p"), variants.keys.map { it.first })
        assertFalse(variants.keys.any { it.first.contains("English") })
    }

    @Test
    fun recordingSelectsRequestedVariantIncludingAudioOnly() {
        val urls = linkedMapOf("source" to "source-url", "720p60" to "720-60-url", "720p" to "720-url", "480p" to "480-url", "audio_only" to "audio-url")
        assertEquals("source-url", selectStreamQualityUrl(urls, "source"))
        assertEquals("720-url", selectStreamQualityUrl(urls, "720p"))
        assertEquals("audio-url", selectStreamQualityUrl(urls, "audio_only"))
        assertEquals("720-url", selectStreamQualityUrl(urls, "720p30"))
        assertEquals("480-url", selectStreamQualityUrl(urls, "600p60"))
        assertEquals("480-url", selectStreamQualityUrl(urls, "160p"))
        assertEquals("source-url", selectStreamQualityUrl(urls, null))
    }

    @Test
    fun recordingHandlesAudioOnlyAndEmptyManifestsWithoutCrashing() {
        assertEquals("audio-url", selectStreamQualityUrl(mapOf("audio_only" to "audio-url"), "720p"))
        assertNull(selectStreamQualityUrl(emptyMap(), "720p"))
    }
}
