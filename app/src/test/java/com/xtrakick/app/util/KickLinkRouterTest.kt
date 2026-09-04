package com.xtrakick.app.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KickLinkRouterTest {

    @Test
    fun testParseVod_withChannelAndUuid() {
        val link = KickLinkRouter.parse("https://kick.com/buddha/videos/01a068e3-9748-7889-8f65-6019c5de8156")
        assertNotNull(link)
        assertTrue(link is KickLink.Video)
        val video = link as KickLink.Video
        assertEquals("01a068e3-9748-7889-8f65-6019c5de8156", video.videoId)
        assertEquals("buddha", video.channelLogin)
        assertNull(video.offsetMs)
    }

    @Test
    fun testParseVod_withChannelAndTimestamp() {
        val link = KickLinkRouter.parse("https://kick.com/buddha/video/01a068e3-9748-7889-8f65-6019c5de8156?t=1h2m3s")
        assertNotNull(link)
        assertTrue(link is KickLink.Video)
        val video = link as KickLink.Video
        assertEquals("01a068e3-9748-7889-8f65-6019c5de8156", video.videoId)
        assertEquals("buddha", video.channelLogin)
        assertEquals(3723000L, video.offsetMs)
    }

    @Test
    fun testParseVod_withWwwAndMultipleQueryParams() {
        val link = KickLinkRouter.parse("https://www.kick.com/buddha/videos/01a068e3-9748-7889-8f65-6019c5de8156?ref=share&t=120")
        assertNotNull(link)
        assertTrue(link is KickLink.Video)
        val video = link as KickLink.Video
        assertEquals("01a068e3-9748-7889-8f65-6019c5de8156", video.videoId)
        assertEquals("buddha", video.channelLogin)
        assertEquals(120000L, video.offsetMs)
    }

    @Test
    fun testParseVod_directVideoPathNoChannel() {
        val link = KickLinkRouter.parse("https://kick.com/videos/01a068e3-9748-7889-8f65-6019c5de8156?time=45s")
        assertNotNull(link)
        assertTrue(link is KickLink.Video)
        val video = link as KickLink.Video
        assertEquals("01a068e3-9748-7889-8f65-6019c5de8156", video.videoId)
        assertNull(video.channelLogin)
        assertEquals(45000L, video.offsetMs)
    }

    @Test
    fun testParseVod_singularVideoPath() {
        val link = KickLinkRouter.parse("https://kick.com/video/12345")
        assertNotNull(link)
        assertTrue(link is KickLink.Video)
        val video = link as KickLink.Video
        assertEquals("12345", video.videoId)
        assertNull(video.channelLogin)
        assertNull(video.offsetMs)
    }

    @Test
    fun testParseClip_withChannelAndClipsPlural() {
        val link = KickLinkRouter.parse("https://kick.com/buddha/clips/clip_01M1Q12069V60NCX2HDB0CYVN4")
        assertNotNull(link)
        assertTrue(link is KickLink.Clip)
        val clip = link as KickLink.Clip
        assertEquals("clip_01M1Q12069V60NCX2HDB0CYVN4", clip.clipId)
        assertEquals("buddha", clip.channelLogin)
    }

    @Test
    fun testParseClip_withChannelAndClipSingular() {
        val link = KickLinkRouter.parse("https://kick.com/buddha/clip/clip_01M1Q12069V60NCX2HDB0CYVN4")
        assertNotNull(link)
        assertTrue(link is KickLink.Clip)
        val clip = link as KickLink.Clip
        assertEquals("clip_01M1Q12069V60NCX2HDB0CYVN4", clip.clipId)
        assertEquals("buddha", clip.channelLogin)
    }

    @Test
    fun testParseClip_withWww() {
        val link = KickLinkRouter.parse("https://www.kick.com/buddha/clips/clip_01M1Q12069V60NCX2HDB0CYVN4")
        assertNotNull(link)
        assertTrue(link is KickLink.Clip)
        val clip = link as KickLink.Clip
        assertEquals("clip_01M1Q12069V60NCX2HDB0CYVN4", clip.clipId)
        assertEquals("buddha", clip.channelLogin)
    }

    @Test
    fun testParseClip_clipsSubdomain() {
        val link = KickLinkRouter.parse("https://clips.kick.com/clip_01M1Q12069V60NCX2HDB0CYVN4")
        assertNotNull(link)
        assertTrue(link is KickLink.Clip)
        val clip = link as KickLink.Clip
        assertEquals("clip_01M1Q12069V60NCX2HDB0CYVN4", clip.clipId)
        assertNull(clip.channelLogin)
    }

    @Test
    fun testParseClip_directClipsPathNoChannel() {
        val link = KickLinkRouter.parse("https://kick.com/clips/clip_01M1Q12069V60NCX2HDB0CYVN4")
        assertNotNull(link)
        assertTrue(link is KickLink.Clip)
        val clip = link as KickLink.Clip
        assertEquals("clip_01M1Q12069V60NCX2HDB0CYVN4", clip.clipId)
        assertNull(clip.channelLogin)
    }

    @Test
    fun testParseUser_standardChannel() {
        val link = KickLinkRouter.parse("https://kick.com/buddha")
        assertNotNull(link)
        assertTrue(link is KickLink.User)
        val user = link as KickLink.User
        assertEquals("buddha", user.channelLogin)
    }

    @Test
    fun testParseUser_withWwwAndQuery() {
        val link = KickLinkRouter.parse("https://www.kick.com/xqc?ref=link")
        assertNotNull(link)
        assertTrue(link is KickLink.User)
        val user = link as KickLink.User
        assertEquals("xqc", user.channelLogin)
    }

    @Test
    fun testParseCategory_withTagQuery() {
        val link = KickLinkRouter.parse("https://kick.com/category/grand-theft-auto-v?tl=English")
        assertNotNull(link)
        assertTrue(link is KickLink.Category)
        val category = link as KickLink.Category
        assertEquals("grand-theft-auto-v", category.slug)
        assertEquals("English", category.tag)
    }

    @Test
    fun testParseCategory_categoriesPath() {
        val link = KickLinkRouter.parse("https://kick.com/categories/games/gta-v")
        assertNotNull(link)
        assertTrue(link is KickLink.Category)
        val category = link as KickLink.Category
        assertEquals("gta-v", category.slug)
        assertNull(category.tag)
    }

    @Test
    fun testParseTag() {
        val link = KickLinkRouter.parse("https://kick.com/tags/english")
        assertNotNull(link)
        assertTrue(link is KickLink.Tag)
        val tag = link as KickLink.Tag
        assertEquals("english", tag.tag)
    }

    @Test
    fun testParseTag_urlEncodedUtf8() {
        val link = KickLinkRouter.parse("https://kick.com/tags/%E6%97%A5%E6%9C%AC%E8%AA%9E")
        assertNotNull(link)
        assertTrue(link is KickLink.Tag)
        val tag = link as KickLink.Tag
        assertEquals("日本語", tag.tag)
    }

    @Test
    fun testParseDirectory_all() {
        val link = KickLinkRouter.parse("https://kick.com/directory/all")
        assertEquals(KickLink.DirectoryAll, link)
    }

    @Test
    fun testParseDirectory_root() {
        val link = KickLinkRouter.parse("https://kick.com/directory")
        assertEquals(KickLink.Directory, link)
    }

    @Test
    fun testParseReservedPaths_returnNull() {
        assertNull(KickLinkRouter.parse("https://kick.com/privacy-policy"))
        assertNull(KickLinkRouter.parse("https://kick.com/terms-of-service"))
        assertNull(KickLinkRouter.parse("https://kick.com/"))
        assertNull(KickLinkRouter.parse("https://kick.com"))
    }

    @Test
    fun testParseNonKickHost_returnsNull() {
        assertNull(KickLinkRouter.parse("https://twitch.tv/buddha"))
        assertNull(KickLinkRouter.parse("https://youtube.com/watch?v=123"))
    }

    @Test
    fun testParseHostSecurity_rejectsSpoofedDomains() {
        assertNull(KickLinkRouter.parse("https://badkick.com/buddha"))
        assertNull(KickLinkRouter.parse("https://evil-kick.com/buddha"))
        assertNull(KickLinkRouter.parse("https://kick.com.evil.com/buddha"))
        assertNull(KickLinkRouter.parse("https://notkick.com/buddha/videos/123"))
    }

    @Test
    fun testParseHostSecurity_acceptsPortAndUserInfo() {
        val linkPort = KickLinkRouter.parse("https://kick.com:443/buddha") as? KickLink.User
        assertNotNull(linkPort)
        assertEquals("buddha", linkPort?.channelLogin)

        val linkUser = KickLinkRouter.parse("https://user@kick.com/buddha") as? KickLink.User
        assertNotNull(linkUser)
        assertEquals("buddha", linkUser?.channelLogin)
    }

    @Test
    fun testParseSchemeLessAndProtocolRelative() {
        val link1 = KickLinkRouter.parse("kick.com/buddha") as? KickLink.User
        assertNotNull(link1)
        assertEquals("buddha", link1?.channelLogin)

        val link2 = KickLinkRouter.parse("//kick.com/buddha/videos/12345") as? KickLink.Video
        assertNotNull(link2)
        assertEquals("12345", link2?.videoId)
        assertEquals("buddha", link2?.channelLogin)
    }

    @Test
    fun testParsePathTraversalAndControlChars_rejected() {
        // Path traversal attempts
        val linkTraversal = KickLinkRouter.parse("https://kick.com/buddha/videos/../../etc")
        assertNull(linkTraversal)

        // Control characters in identifier
        val linkControl = KickLinkRouter.parse("https://kick.com/buddha\nlogin")
        assertNull(linkControl)
    }
}
