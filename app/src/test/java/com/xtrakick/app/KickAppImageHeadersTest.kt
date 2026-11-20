package com.xtrakick.app

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KickAppImageHeadersTest {

    @Test
    fun classifyKickImageUrlMatchesExactHttpsHostsOnly() {
        assertEquals(
            KickApp.KickImageHostTier.AUTHENTICATED_THUMBNAIL,
            KickApp.classifyKickImageUrl("https://stream.kick.com/thumbnails/livestream/123/thumb.jpg")
        )
        assertEquals(
            KickApp.KickImageHostTier.AUTHENTICATED_THUMBNAIL,
            KickApp.classifyKickImageUrl("https://images.kick.com/video_thumbnails/abc/480.webp")
        )
        assertEquals(
            KickApp.KickImageHostTier.PUBLIC_CDN,
            KickApp.classifyKickImageUrl("https://ext.cdn.kick.com/badges/vip.svg")
        )
        assertEquals(
            KickApp.KickImageHostTier.PUBLIC_CDN,
            KickApp.classifyKickImageUrl("https://files.kick.com/images/user/123/profile.webp")
        )
    }

    @Test
    fun classifyKickImageUrlRejectsPlaintextHttpAndSpoofedSubstrings() {
        // Plaintext HTTP must never receive session cookies or Bearer tokens
        assertNull(KickApp.classifyKickImageUrl("http://stream.kick.com/thumbnails/livestream/123/thumb.jpg"))
        assertNull(KickApp.classifyKickImageUrl("http://images.kick.com/video_thumbnails/abc/480.webp"))
        assertNull(KickApp.classifyKickImageUrl("http://files.kick.com/images/user/123/profile.webp"))

        // Substring spoofing in query, path, or userinfo
        assertNull(KickApp.classifyKickImageUrl("https://evil.example/img?ref=https://stream.kick.com/a.jpg"))
        assertNull(KickApp.classifyKickImageUrl("https://evil.example/https://images.kick.com/a.jpg"))
        assertNull(KickApp.classifyKickImageUrl("https://stream.kick.com@evil.example/a.jpg"))
        assertNull(KickApp.classifyKickImageUrl("https://stream.kick.com.evil.example/a.jpg"))
        assertNull(KickApp.classifyKickImageUrl("https://notstream.kick.com/a.jpg"))
    }

    @Test
    fun canFollowKickImageRedirectBlocksCrossHostExfiltrationForAuthenticatedOrigins() {
        val original = "https://images.kick.com/video_thumbnails/abc/480.webp"
        assertTrue(KickApp.canFollowKickImageRedirect(original, "https://stream.kick.com/thumbnails/1.webp"))
        assertFalse(KickApp.canFollowKickImageRedirect(original, "http://images.kick.com/video_thumbnails/abc/480.webp"))
        assertFalse(KickApp.canFollowKickImageRedirect(original, "https://files.kick.com/images/1.webp"))
        assertFalse(KickApp.canFollowKickImageRedirect(original, "https://evil.example/collect"))
        assertFalse(KickApp.canFollowKickImageRedirect(original, null))

        // Unauthenticated requests are allowed to follow standard CDN redirects
        val publicUrl = "https://cdn.7tv.app/emote/123/4x.webp"
        assertTrue(KickApp.canFollowKickImageRedirect(publicUrl, "https://other-cdn.example/emote.webp"))
    }
}
