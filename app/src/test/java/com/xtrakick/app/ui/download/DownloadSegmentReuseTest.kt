package com.xtrakick.app.ui.download

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DownloadSegmentReuseTest {
    @Test
    fun knownReadableSegmentIsReused() {
        assertTrue(canReuseDownloadedTrack("one.ts", setOf("one.ts")) { true })
    }

    @Test
    fun missingKnownSegmentMustBeDownloaded() {
        assertFalse(canReuseDownloadedTrack("one.ts", setOf("one.ts")) { false })
    }

    @Test
    fun unknownSegmentDoesNotProbeStorage() {
        assertFalse(canReuseDownloadedTrack("new.ts", setOf("one.ts")) { error("Unexpected storage probe") })
    }
}
