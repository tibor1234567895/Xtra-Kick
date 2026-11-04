package com.xtrakick.app.ui.player

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class IvsCaptionTimelineTest {
    @Test fun mapsLongRunningStreamToPlayerPositionAndPreservesGaps() {
        val timeline = IvsCaptionTimeline()
        timeline.add("first", 123_000_000, 123_002_000, 500)
        timeline.add("second", 123_003_000, 123_004_000, 500)
        assertEquals("first", timeline.textAt(500))
        assertEquals("first", timeline.textAt(2499))
        assertNull(timeline.textAt(2500))
        assertEquals("second", timeline.textAt(3500))
        assertNull(timeline.textAt(4500))
        assertTrue(timeline.isEmpty)
    }

    @Test fun pauseKeepsCueAndClearDiscardsQueuedText() {
        val timeline = IvsCaptionTimeline()
        timeline.add("caption", 100, 1100, 200)
        repeat(5) { assertEquals("caption", timeline.textAt(200)) }
        timeline.clear()
        assertNull(timeline.textAt(200))
        timeline.add("new stream", 0, 1000, 0)
        assertEquals("new stream", timeline.textAt(0))
    }

    @Test fun ignoresInvalidDurations() {
        val timeline = IvsCaptionTimeline()
        timeline.add("invalid", 100, 99, 0)
        assertTrue(timeline.isEmpty)
    }
}
