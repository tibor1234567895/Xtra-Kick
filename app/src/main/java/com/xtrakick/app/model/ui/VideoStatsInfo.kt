package com.xtrakick.app.model.ui

data class VideoStatsInfo(
    val resolution: String? = null,
    val viewportResolution: String? = null,
    val downloadBitrate: String? = null,
    val bandwidthEstimate: String? = null,
    val fps: String? = null,
    val skippedFrames: String? = null,
    val bufferSize: String? = null,
    val latencyToBroadcaster: String? = null,
    val codecs: String? = null,
    val protocol: String = "HLS",
    val backendVersion: String? = null
) {
    fun toClipboardText(): String {
        val sb = java.lang.StringBuilder()
        sb.appendLine("=== Xtra Video Stats ===")
        resolution?.let { sb.appendLine("Resolution: $it") }
        viewportResolution?.let { sb.appendLine("Viewport Resolution: $it") }
        downloadBitrate?.let { sb.appendLine("Download Bitrate: $it") }
        bandwidthEstimate?.let { sb.appendLine("Bandwidth Estimate: $it") }
        fps?.let { sb.appendLine("FPS: $it") }
        skippedFrames?.let { sb.appendLine("Skipped Frames: $it") }
        bufferSize?.let { sb.appendLine("Buffer Size: $it") }
        latencyToBroadcaster?.let { sb.appendLine("Latency To Broadcaster: $it") }
        codecs?.let { sb.appendLine("Codecs: $it") }
        sb.appendLine("Protocol: $protocol")
        backendVersion?.let { sb.appendLine("Backend Version: $it") }
        return sb.toString().trimEnd()
    }
}
