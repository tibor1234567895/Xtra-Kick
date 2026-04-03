package com.github.andreyasadchy.xtra.util.m3u8

import java.io.InputStream
import java.io.OutputStream
import java.util.regex.Pattern

object PlaylistUtils {
    fun parseMediaPlaylist(input: InputStream): MediaPlaylist {
        var targetDuration = 10
        val dateRanges = mutableListOf<DateRange>()
        var programDateTime: String? = null
        var initSegmentUri: String? = null
        val segments = mutableListOf<Segment>()
        var segmentInfo: Pair<Float, String?>? = null
        var end = false
        input.bufferedReader().forEachLine { line ->
            if (line.isNotBlank()) {
                if (line.startsWith('#')) {
                    when {
                        line.startsWith("#EXT-X-TARGETDURATION") -> {
                            val matcher = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b").matcher(line)
                            if (matcher.find()) {
                                matcher.group(1)?.toIntOrNull()?.let { targetDuration = it }
                            }
                        }
                        line.startsWith("#EXT-X-DATERANGE") -> {
                            val id = Pattern.compile("ID=\"(.+?)\"").matcher(line).let { if (it.find()) it.group(1) else null }
                            val startDate = Pattern.compile("START-DATE=\"(.+?)\"").matcher(line).let { if (it.find()) it.group(1) else null }
                            if (id != null && startDate != null) {
                                dateRanges.add(DateRange(
                                    id = id,
                                    rangeClass = Pattern.compile("CLASS=\"(.+?)\"").matcher(line).let { if (it.find()) it.group(1) else null },
                                    startDate = startDate,
                                    endDate = Pattern.compile("END-DATE=\"(.+?)\"").matcher(line).let { if (it.find()) it.group(1) else null },
                                    duration = Pattern.compile("DURATION=(.+?)").matcher(line).let { if (it.find()) it.group(1)?.toFloatOrNull() else null },
                                    plannedDuration = Pattern.compile("PLANNED-DURATION=(.+?)").matcher(line).let { if (it.find()) it.group(1)?.toFloatOrNull() else null },
                                    ad = Pattern.compile("X-TV-TWITCH-AD-.+?=\"(.+?)\"").matcher(line).let { if (it.find()) it.group(1) else null } != null
                                ))
                            }
                        }
                        line.startsWith("#EXT-X-PROGRAM-DATE-TIME") -> {
                            programDateTime = line.substringAfter("#EXT-X-PROGRAM-DATE-TIME:")
                        }
                        line.startsWith("#EXT-X-MAP") -> {
                            val matcher = Pattern.compile("URI=\"(.+?)\"").matcher(line)
                            if (matcher.find()) {
                                matcher.group(1)?.let { initSegmentUri = it }
                            }
                        }
                        line.startsWith("#EXTINF") -> {
                            val durationMatcher = Pattern.compile("#EXTINF:([\\d.]+)\\b").matcher(line)
                            if (durationMatcher.find()) {
                                durationMatcher.group(1)?.toFloatOrNull()?.let { duration ->
                                    val titleMatcher = Pattern.compile("#EXTINF:[\\d.]+\\b,(.+)").matcher(line)
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
        return MediaPlaylist(targetDuration, dateRanges, initSegmentUri, segments, end)
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