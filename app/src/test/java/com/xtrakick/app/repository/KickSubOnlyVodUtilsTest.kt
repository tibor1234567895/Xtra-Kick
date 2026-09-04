package com.xtrakick.app.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KickSubOnlyVodUtilsTest {

    private val baseUrls = listOf("https://stream.kick.com/ivs/v1/196233775518")
    // 2026-08-27T21:03:59Z, taken from a real VOD replay start
    private val startMillis = 1787864639000L

    @Test
    fun extractIvsPaths_prefersThumbnailPathAndAddsChannelFallback() {
        val paths = KickSubOnlyVodUtils.extractIvsPaths(
            thumbnailUrl = "https://images.kick.com/video_thumbnails/ABC123/01a04509-5a60-7e1b-acdb-983cab9b8a10/thumbnail.jpg",
            channelId = "120906884",
            recordingIds = listOf("01a04509-5a60-7e1b-acdb-983cab9b8a10"),
        )
        assertEquals(
            listOf(
                KickSubOnlyVodUtils.IvsPath("ABC123", "01a04509-5a60-7e1b-acdb-983cab9b8a10"),
                KickSubOnlyVodUtils.IvsPath("120906884", "01a04509-5a60-7e1b-acdb-983cab9b8a10"),
            ),
            paths,
        )
    }

    @Test
    fun extractIvsPaths_parsesIvsStyleThumbnailPath() {
        val paths = KickSubOnlyVodUtils.extractIvsPaths(
            thumbnailUrl = "https://images.kick.com/ivs/v1/CH123/REC456/thumb.jpg",
            channelId = null,
            recordingIds = emptyList(),
        )
        assertEquals(listOf(KickSubOnlyVodUtils.IvsPath("CH123", "REC456")), paths)
    }

    @Test
    fun extractIvsPaths_stripsQueryString() {
        val paths = KickSubOnlyVodUtils.extractIvsPaths(
            thumbnailUrl = "https://images.kick.com/video_thumbnails/ABC123/REC456/thumb.jpg?width=320",
            channelId = null,
            recordingIds = emptyList(),
        )
        assertEquals(listOf(KickSubOnlyVodUtils.IvsPath("ABC123", "REC456")), paths)
    }

    @Test
    fun extractIvsPaths_fallsBackToChannelAndUuidShapedIds() {
        val paths = KickSubOnlyVodUtils.extractIvsPaths(
            thumbnailUrl = "https://files.kick.com/thumbs/other.jpg",
            channelId = "120906884",
            recordingIds = listOf("01a04509-5a60-7e1b-acdb-983cab9b8a10", "124377995", null),
        )
        assertEquals(
            listOf(KickSubOnlyVodUtils.IvsPath("120906884", "01a04509-5a60-7e1b-acdb-983cab9b8a10")),
            paths,
        )
    }

    @Test
    fun extractIvsPaths_emptyWhenNoUsableInput() {
        assertTrue(KickSubOnlyVodUtils.extractIvsPaths(null, null, listOf(null)).isEmpty())
        assertTrue(KickSubOnlyVodUtils.extractIvsPaths(" ", "124377995", listOf("124377995")).isEmpty())
    }

    @Test
    fun parseStartMillis_handlesInstantAndOffsetForms() {
        assertEquals(startMillis, KickSubOnlyVodUtils.parseStartMillis("2026-08-27T21:03:59Z"))
        assertEquals(1787857439000L, KickSubOnlyVodUtils.parseStartMillis("2026-08-27T21:03:59+02:00"))
        assertEquals(startMillis, KickSubOnlyVodUtils.parseStartMillis(" 2026-08-27T21:03:59Z "))
    }

    @Test
    fun parseStartMillis_nullForInvalidInput() {
        assertNull(KickSubOnlyVodUtils.parseStartMillis(null))
        assertNull(KickSubOnlyVodUtils.parseStartMillis(""))
        assertNull(KickSubOnlyVodUtils.parseStartMillis("not-a-date"))
    }

    @Test
    fun buildMasterPlaylistUrls_usesUnpaddedUtcBucket() {
        val urls = KickSubOnlyVodUtils.buildMasterPlaylistUrls(
            baseUrls,
            KickSubOnlyVodUtils.IvsPath("ABC123", "01a04509"),
            startMillis,
            offsetMinutes = 0,
        )
        assertEquals(
            listOf("https://stream.kick.com/ivs/v1/196233775518/ABC123/2026/8/27/21/3/01a04509/media/hls/master.m3u8"),
            urls,
        )
    }

    @Test
    fun buildMasterPlaylistUrls_appliesMinuteOffset() {
        val urls = KickSubOnlyVodUtils.buildMasterPlaylistUrls(
            baseUrls,
            KickSubOnlyVodUtils.IvsPath("ABC123", "01a04509"),
            startMillis,
            offsetMinutes = 1,
        )
        assertEquals(
            listOf("https://stream.kick.com/ivs/v1/196233775518/ABC123/2026/8/27/21/4/01a04509/media/hls/master.m3u8"),
            urls,
        )
    }

    @Test
    fun buildMasterPlaylistUrls_negativeOffsetCrossesMidnight() {
        val urls = KickSubOnlyVodUtils.buildMasterPlaylistUrls(
            baseUrls,
            KickSubOnlyVodUtils.IvsPath("ABC123", "01a04509"),
            startMillis = KickSubOnlyVodUtils.parseStartMillis("2026-08-28T00:02:00Z")!!,
            offsetMinutes = -5,
        )
        assertEquals(
            listOf("https://stream.kick.com/ivs/v1/196233775518/ABC123/2026/8/27/23/57/01a04509/media/hls/master.m3u8"),
            urls,
        )
    }

    @Test
    fun isUuidShaped_distinguishesSlugFromNumericId() {
        assertTrue(KickSubOnlyVodUtils.isUuidShaped("01a04509-5a60-7e1b-acdb-983cab9b8a10"))
        assertFalse(KickSubOnlyVodUtils.isUuidShaped("124377995"))
        assertFalse(KickSubOnlyVodUtils.isUuidShaped(null))
        assertFalse(KickSubOnlyVodUtils.isUuidShaped("  "))
    }

    @Test
    fun ivsBaseUrls_prioritizesWorkingCdnDistributions() {
        assertTrue(KickSubOnlyVodUtils.ivsBaseUrls.contains("https://stream.kick.com/3c81249a5ce0/ivs/v1/196233775518"))
        assertTrue(KickSubOnlyVodUtils.ivsBaseUrls.contains("https://stream.kick.com/0f3cb0ebce7/ivs/v1/196233775518"))
        assertFalse(KickSubOnlyVodUtils.ivsBaseUrls.contains("https://stream.kick.com/ivs/v1/196233775518"))
    }
}
