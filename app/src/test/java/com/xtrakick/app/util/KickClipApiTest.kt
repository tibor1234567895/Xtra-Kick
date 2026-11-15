package com.xtrakick.app.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Test
import java.io.IOException

class KickClipApiTest {

    @Test
    fun initiateBodyIncludesStringVideoIdAndPosition() {
        val body = KickClipApi.buildInitiateClipBody("01a17413-f760-7067-aa90-2e6d458a1aa6", 4520L)
        assertEquals("""{"video_id":"01a17413-f760-7067-aa90-2e6d458a1aa6","position":4520}""", body)
    }

    @Test
    fun initiateBodyOmitsPositionWhenNullOrNotPositive() {
        assertEquals("""{"video_id":"01a17413-f760-7067-aa90-2e6d458a1aa6"}""", KickClipApi.buildInitiateClipBody("01a17413-f760-7067-aa90-2e6d458a1aa6", null))
        assertEquals("""{"video_id":"01a17413-f760-7067-aa90-2e6d458a1aa6"}""", KickClipApi.buildInitiateClipBody("01a17413-f760-7067-aa90-2e6d458a1aa6", 0L))
    }

    @Test
    fun initiateBodyRejectsEmptyVideoId() {
        assertThrows(IOException::class.java) { KickClipApi.buildInitiateClipBody("", 1L) }
        assertThrows(IOException::class.java) { KickClipApi.buildInitiateClipBody("   ", null) }
    }

    @Test
    fun finalizeBodyCarriesTitleStartAndDuration() {
        val body = KickClipApi.buildFinalizeClipBody("Big moment", 120, 60)
        assertEquals("""{"title":"Big moment","trim_start":120,"trim_duration":60}""", body)
    }

    @Test
    fun finalizeBodyFallsBackToDefaultTitleWhenBlank() {
        val body = KickClipApi.buildFinalizeClipBody("   ", 0, 30)
        assertEquals("""{"title":"Clip","trim_start":0,"trim_duration":30}""", body)
    }

    @Test
    fun positionedPreviewStartsAtTheWatchedMoment() {
        assertEquals(0 to 30, KickClipApi.computeClipRange(180, 30, fromStart = true))
        assertEquals(0 to 20, KickClipApi.computeClipRange(20, 30, fromStart = true))
        assertEquals(150 to 30, KickClipApi.computeClipRange(180, 30))
    }

    @Test
    fun computeRangeEndsAtLiveEdgeWhenSourceIsLongEnough() {
        val (start, duration) = KickClipApi.computeClipRange(sourceDurationSeconds = 300, requestedDurationSeconds = 90)
        assertEquals(210, start)
        assertEquals(90, duration)
    }

    @Test
    fun computeRangeClampsDurationToMaxLimit() {
        val (start, duration) = KickClipApi.computeClipRange(sourceDurationSeconds = 600, requestedDurationSeconds = 500)
        assertEquals(420, start)
        assertEquals(180, duration)
    }

    @Test
    fun computeRangeClampsDurationToShortSource() {
        val (start, duration) = KickClipApi.computeClipRange(sourceDurationSeconds = 40, requestedDurationSeconds = 90)
        assertEquals(0, start)
        assertEquals(40, duration)
    }

    @Test
    fun computeRangeDoesNotCrashOnSourceShorterThanMinimum() {
        val (start, duration) = KickClipApi.computeClipRange(sourceDurationSeconds = 5, requestedDurationSeconds = 30)
        assertEquals(0, start)
        assertEquals(15, duration)
    }

    @Test
    fun computeRangeFallsBackToZeroStartWithoutSourceDuration() {
        val (start, duration) = KickClipApi.computeClipRange(sourceDurationSeconds = null, requestedDurationSeconds = 60)
        assertEquals(0, start)
        assertEquals(60, duration)
    }

    @Test
    fun computeRangeEnforcesMinimumDuration() {
        val (start, duration) = KickClipApi.computeClipRange(sourceDurationSeconds = 300, requestedDurationSeconds = 5)
        assertEquals(15, duration)
        assertEquals(285, start)
    }

    @Test
    fun clampTitleTrimsShortensAndBlanks() {
        assertEquals("Hello", KickClipApi.clampTitle("  Hello  "))
        assertNull(KickClipApi.clampTitle("   "))
        assertEquals(50, KickClipApi.clampTitle("x".repeat(80))!!.length)
    }

    @Test
    fun parsesTemporaryClipFromFlatPayload() {
        val clip = KickClipApi.parseTemporaryClip(
            """{"id":"abc-123","preview_url":"https://clips.cdn.kick.com/tmp.m3u8","source_duration":240.5}"""
        )
        assertNotNull(clip)
        assertEquals("abc-123", clip!!.id)
        assertEquals("https://clips.cdn.kick.com/tmp.m3u8", clip.previewUrl)
        assertEquals(240, clip.sourceDurationSeconds)
    }

    @Test
    fun parsesTemporaryClipFromDataWrappedPayload() {
        val clip = KickClipApi.parseTemporaryClip(
            """{"data":{"id":987654,"preview_url":"https://clips.cdn.kick.com/p.mp4","source_duration":180}}"""
        )
        assertNotNull(clip)
        assertEquals("987654", clip!!.id)
        assertEquals("https://clips.cdn.kick.com/p.mp4", clip.previewUrl)
        assertEquals(180, clip.sourceDurationSeconds)
    }

    @Test
    fun parseTemporaryClipRejectsPayloadWithoutId() {
        assertNull(KickClipApi.parseTemporaryClip("""{"preview_url":"https://x"}"""))
        assertNull(KickClipApi.parseTemporaryClip("not json"))
        assertNull(KickClipApi.parseTemporaryClip(""))
    }

    @Test
    fun parseFinalizedClipExtractsUrlAndTitle() {
        val finalized = KickClipApi.parseFinalizedClip(
            rawJson = """{"data":{"id":"clip_123","title":"Nice shot","clip_url":"https://kick.com/streamer/clips/clip_123"}}""",
            fallbackClipId = "clip_default",
            fallbackTitle = "Fallback",
            channelLogin = "streamer",
        )
        assertEquals("clip_123", finalized.id)
        assertEquals("Nice shot", finalized.title)
        assertEquals("https://kick.com/streamer/clips/clip_123", finalized.clipUrl)
    }

    @Test
    fun parseFinalizedClipConstructsUrlWhenOmittedInResponse() {
        val finalized = KickClipApi.parseFinalizedClip(
            rawJson = """{"status":"ok"}""",
            fallbackClipId = "clip_456",
            fallbackTitle = "Fallback title",
            channelLogin = "xqc",
        )
        assertEquals("clip_456", finalized.id)
        assertEquals("Fallback title", finalized.title)
        assertEquals("https://kick.com/xqc/clips/clip_456", finalized.clipUrl)
    }
}
