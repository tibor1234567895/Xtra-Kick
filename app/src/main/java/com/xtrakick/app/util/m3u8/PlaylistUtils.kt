package com.xtrakick.app.util.m3u8

import java.io.InputStream
import java.io.OutputStream
import java.util.regex.Pattern

object PlaylistUtils {
    private val targetDurationPattern = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b")
    private val dateRangeIdPattern = Pattern.compile("ID=\"(.+?)\"")
    private val startDatePattern = Pattern.compile("START-DATE=\"(.+?)\"")
    private val rangeClassPattern = Pattern.compile("CLASS=\"(.+?)\"")
    private val endDatePattern = Pattern.compile("END-DATE=\"(.+?)\"")
    private val durationPattern = Pattern.compile("DURATION=(.+?)")
    private val plannedDurationPattern = Pattern.compile("PLANNED-DURATION=(.+?)")
    private val uriPattern = Pattern.compile("URI=\"(.+?)\"")
    private val encryptionMethodPattern = Pattern.compile("METHOD=([A-Za-z0-9\\-]+)")
    private val segmentDurationPattern = Pattern.compile("#EXTINF:([\\d.]+)\\b")
    private val segmentTitlePattern = Pattern.compile("#EXTINF:[\\d.]+\\b,(.+)")

    fun parseMediaPlaylist(input: InputStream): MediaPlaylist {
        var targetDuration = 10
        val dateRanges = mutableListOf<DateRange>()
        var programDateTime: String? = null
        var initSegmentUri: String? = null
        var encrypted = false
        val segments = mutableListOf<Segment>()
        var segmentInfo: Pair<Float, String?>? = null
        var end = false
        input.bufferedReader().forEachLine { line ->
            if (line.isNotBlank()) {
                if (line.startsWith('#')) {
                    when {
                        line.startsWith("#EXT-X-TARGETDURATION") -> {
                            val matcher = targetDurationPattern.matcher(line)
                            if (matcher.find()) {
                                matcher.group(1)?.toIntOrNull()?.let { targetDuration = it }
                            }
                        }
                        line.startsWith("#EXT-X-DATERANGE") -> {
                            val id = dateRangeIdPattern.matcher(line).let { if (it.find()) it.group(1) else null }
                            val startDate = startDatePattern.matcher(line).let { if (it.find()) it.group(1) else null }
                            if (id != null && startDate != null) {
                                dateRanges.add(DateRange(
                                    id = id,
                                    rangeClass = rangeClassPattern.matcher(line).let { if (it.find()) it.group(1) else null },
                                    startDate = startDate,
                                    endDate = endDatePattern.matcher(line).let { if (it.find()) it.group(1) else null },
                                    duration = durationPattern.matcher(line).let { if (it.find()) it.group(1)?.toFloatOrNull() else null },
                                    plannedDuration = plannedDurationPattern.matcher(line).let { if (it.find()) it.group(1)?.toFloatOrNull() else null },
                                    ad = line.contains("AD", ignoreCase = true)
                                ))
                            }
                        }
                        line.startsWith("#EXT-X-PROGRAM-DATE-TIME") -> {
                            programDateTime = line.substringAfter("#EXT-X-PROGRAM-DATE-TIME:")
                        }
                        line.startsWith("#EXT-X-MAP") -> {
                            val matcher = uriPattern.matcher(line)
                            if (matcher.find()) {
                                matcher.group(1)?.let { initSegmentUri = it }
                            }
                        }
                        line.startsWith("#EXT-X-KEY") -> {
                            // METHOD=NONE means unencrypted; anything else (AES-128, SAMPLE-AES, ...)
                            // requires decryption this downloader does not implement.
                            val matcher = encryptionMethodPattern.matcher(line)
                            if (matcher.find() && matcher.group(1) != "NONE") {
                                encrypted = true
                            }
                        }
                        line.startsWith("#EXTINF") -> {
                            val durationMatcher = segmentDurationPattern.matcher(line)
                            if (durationMatcher.find()) {
                                durationMatcher.group(1)?.toFloatOrNull()?.let { duration ->
                                    val titleMatcher = segmentTitlePattern.matcher(line)
                                    val title = if (titleMatcher.find()) {
                                        titleMatcher.group(1)
                                    } else null
                                    segmentInfo = Pair(duration, title)
                                }
                            }
                        }
                        line.startsWith("#EXT-X-ENDLIST") -> {
                            end = true
                        }
                    }
                } else {
                    segmentInfo?.let {
                        segments.add(Segment(line, it.first, it.second, programDateTime))
                        segmentInfo = null
                    }
                }
            }
        }
        return MediaPlaylist(targetDuration, dateRanges, initSegmentUri, segments, end, encrypted)
    }

    fun writeMediaPlaylist(playlist: MediaPlaylist, output: OutputStream) {
        output.bufferedWriter().use { writer ->
            writer.write("#EXTM3U")
            writer.newLine()
            writer.write("#EXT-X-VERSION:${if (playlist.initSegmentUri != null) 6 else 3}")
            writer.newLine()
            writer.write("#EXT-X-PLAYLIST-TYPE:EVENT")
            writer.newLine()
            writer.write("#EXT-X-TARGETDURATION:${playlist.targetDuration}")
            writer.newLine()
            writer.write("#EXT-X-MEDIA-SEQUENCE:0")
            if (playlist.initSegmentUri != null) {
                writer.newLine()
                writer.write("#EXT-X-MAP:URI=\"${playlist.initSegmentUri}\"")
            }
            playlist.segments.forEach {
                writer.newLine()
                writer.write("#EXTINF:${it.duration}")
                writer.newLine()
                writer.write(it.uri)
            }
            writer.newLine()
            writer.write("#EXT-X-ENDLIST")
        }
    }
}
