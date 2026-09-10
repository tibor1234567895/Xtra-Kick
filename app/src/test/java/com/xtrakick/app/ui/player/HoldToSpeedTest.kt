package com.xtrakick.app.ui.player

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HoldToSpeedTest {

    @Test
    fun armsWhenAllConditionsMet() {
        assertTrue(
            shouldArmHoldToSpeed(
                isMaximized = true,
                available = true,
                isVideoZoomed = false,
                zoomGestureActive = false,
                offlineOverlayVisible = false,
                scrubbing = false
            )
        )
    }

    @Test
    fun doesNotArmWhenMinimized() {
        assertFalse(
            shouldArmHoldToSpeed(
                isMaximized = false,
                available = true,
                isVideoZoomed = false,
                zoomGestureActive = false,
                offlineOverlayVisible = false,
                scrubbing = false
            )
        )
    }

    @Test
    fun doesNotArmOnUnsupportedTypes() {
        assertFalse(
            shouldArmHoldToSpeed(
                isMaximized = true,
                available = false,
                isVideoZoomed = false,
                zoomGestureActive = false,
                offlineOverlayVisible = false,
                scrubbing = false
            )
        )
    }

    @Test
    fun doesNotArmWhileZoomedOrZooming() {
        assertFalse(
            shouldArmHoldToSpeed(
                isMaximized = true,
                available = true,
                isVideoZoomed = true,
                zoomGestureActive = false,
                offlineOverlayVisible = false,
                scrubbing = false
            )
        )
        assertFalse(
            shouldArmHoldToSpeed(
                isMaximized = true,
                available = true,
                isVideoZoomed = false,
                zoomGestureActive = true,
                offlineOverlayVisible = false,
                scrubbing = false
            )
        )
    }

    @Test
    fun doesNotArmWhileOfflineOverlayOrScrubbing() {
        assertFalse(
            shouldArmHoldToSpeed(
                isMaximized = true,
                available = true,
                isVideoZoomed = false,
                zoomGestureActive = false,
                offlineOverlayVisible = true,
                scrubbing = false
            )
        )
        assertFalse(
            shouldArmHoldToSpeed(
                isMaximized = true,
                available = true,
                isVideoZoomed = false,
                zoomGestureActive = false,
                offlineOverlayVisible = false,
                scrubbing = true
            )
        )
    }

    @Test
    fun labelFormatsWholeAndFractionalFactors() {
        assertEquals("2x", formatHoldToSpeedLabel(2f))
        assertEquals("3x", formatHoldToSpeedLabel(3f))
        assertEquals("1.5x", formatHoldToSpeedLabel(1.5f))
        assertEquals("1.25x", formatHoldToSpeedLabel(1.25f))
    }

    @Test
    fun speedListSummaryCompactsToRangeAndCount() {
        assertEquals(
            "0.25x–8x · 11",
            com.xtrakick.app.ui.settings.compactSpeedListSummary("0.25\n0.5\n0.75\n1.0\n1.25\n1.5\n1.75\n2.0\n3.0\n4.0\n8.0")
        )
    }

    @Test
    fun speedListSummaryHandlesSingleAndBlank() {
        assertEquals("2x", com.xtrakick.app.ui.settings.compactSpeedListSummary("2.0"))
        assertEquals(null, com.xtrakick.app.ui.settings.compactSpeedListSummary("  "))
        assertEquals(null, com.xtrakick.app.ui.settings.compactSpeedListSummary(null))
    }
}
