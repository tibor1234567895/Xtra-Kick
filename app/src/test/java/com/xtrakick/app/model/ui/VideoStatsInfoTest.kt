package com.xtrakick.app.model.ui

import org.junit.Assert.assertTrue
import org.junit.Test

class VideoStatsInfoTest {

    @Test
    fun toClipboardText_includesAllAvailableFields() {
        val stats = VideoStatsInfo(
            resolution = "1920×1080",
            viewportResolution = "930×523",
            downloadBitrate = "8278 Kbps",
            bandwidthEstimate = "15200 Kbps",
            fps = "60 (live: 59.8)",
            skippedFrames = "16 / 1000",
            bufferSize = "1.92 sec.",
            latencyToBroadcaster = "2.02 sec.",
            codecs = "avc1.64002A,mp4a.40.2",
            protocol = "HLS",
            backendVersion = "Amazon IVS 1.55.0"
        )

        val text = stats.toClipboardText()

        assertTrue(text.contains("Resolution: 1920×1080"))
        assertTrue(text.contains("Viewport Resolution: 930×523"))
        assertTrue(text.contains("Download Bitrate: 8278 Kbps"))
        assertTrue(text.contains("Bandwidth Estimate: 15200 Kbps"))
        assertTrue(text.contains("FPS: 60 (live: 59.8)"))
        assertTrue(text.contains("Skipped Frames: 16 / 1000"))
        assertTrue(text.contains("Buffer Size: 1.92 sec."))
        assertTrue(text.contains("Latency To Broadcaster: 2.02 sec."))
        assertTrue(text.contains("Codecs: avc1.64002A,mp4a.40.2"))
        assertTrue(text.contains("Protocol: HLS"))
        assertTrue(text.contains("Backend Version: Amazon IVS 1.55.0"))
    }
}
