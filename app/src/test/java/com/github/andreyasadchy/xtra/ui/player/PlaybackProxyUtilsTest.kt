package com.github.andreyasadchy.xtra.ui.player

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.net.URI

class PlaybackProxyUtilsTest {

    @Test
    fun shouldProxyPlaylistOnlyForM3u8Requests() {
        assertTrue(PlaybackProxyUtils.shouldProxyPlaylist(URI("https://usher.ttvnw.net/api/channel/hls/test.m3u8?sig=1")))
        assertTrue(PlaybackProxyUtils.shouldProxyPlaylist(URI("https://video-weaver.example.net/v1/playlist/chunked/index-dvr.m3u8")))
        assertFalse(PlaybackProxyUtils.shouldProxyPlaylist(URI("https://video-edge-47127a.sjc05.hls.live-video.net/segment123.ts")))
        assertFalse(PlaybackProxyUtils.shouldProxyPlaylist(URI("https://video-edge-47127a.sjc05.hls.live-video.net/segment123.m4s")))
    }

    @Test
    fun shouldRejectInvalidProxyEndpoints() {
        assertFalse(PlaybackProxyUtils.isValidProxyConfiguration(null, 8080))
        assertFalse(PlaybackProxyUtils.isValidProxyConfiguration("", 8080))
        assertFalse(PlaybackProxyUtils.isValidProxyConfiguration("0.0.0.0", 8080))
        assertFalse(PlaybackProxyUtils.isValidProxyConfiguration("localhost", 8080))
        assertFalse(PlaybackProxyUtils.isValidProxyConfiguration("127.0.0.1", 8080))
        assertFalse(PlaybackProxyUtils.isValidProxyConfiguration("proxy.example", 0))
        assertTrue(PlaybackProxyUtils.isValidProxyConfiguration("proxy.example", 8080))
    }
}
