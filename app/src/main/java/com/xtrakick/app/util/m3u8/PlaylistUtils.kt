package com.xtrakick.app.util.m3u8

import android.net.Uri
import androidx.annotation.OptIn
import androidx.media3.common.C
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist
import com.xtrakick.app.player.lowlatency.HlsPlaylistParser
import java.io.InputStream
import java.io.OutputStream
import java.io.File
import java.util.regex.Pattern
import java.net.URI
import java.io.EOFException
import java.security.MessageDigest
import kotlin.math.roundToInt

object PlaylistUtils {
    fun isHlsUrl(url: String): Boolean = URI(url).path.orEmpty().endsWith(".m3u8", ignoreCase = true)

    fun resolveUri(playlistUrl: String, uri: String): String = URI(playlistUrl).resolve(uri).toString()

    internal fun localAssetName(uri: String): String = Uri.decode(uri).substringAfterLast('/').substringAfterLast('\\')

    internal fun unsharedAssetUris(playlist: MediaPlaylist, siblings: List<MediaPlaylist?>): List<String> {
        val seenNames = HashSet<String>()
        for (sibling in siblings) {
            // An unreadable sibling may own any of these files. Retain them until ownership is known.
            if (sibling == null || sibling.segments.isEmpty()) return emptyList()
            sibling.initSegmentUri?.let { seenNames.add(localAssetName(it)) }
            for (segment in sibling.segments) seenNames.add(localAssetName(segment.uri))
        }
        return buildList {
            playlist.initSegmentUri?.let { if (seenNames.add(localAssetName(it))) add(it) }
            for (segment in playlist.segments) {
                if (seenNames.add(localAssetName(segment.uri))) add(segment.uri)
            }
        }
    }

    internal fun localAssetFile(directory: File, uri: String): File? {
        val parsed = Uri.parse(uri)
        val rawFile = File(uri)
        val file = when {
            rawFile.isAbsolute -> rawFile
            parsed.scheme == null -> File(directory, uri)
            parsed.scheme == "file" -> parsed.path?.let(::File) ?: return null
            else -> return null
        }.canonicalFile
        return file.takeIf { it.parentFile == directory.canonicalFile }
    }

    fun assetFileName(uri: String): String {
        val parsed = URI(uri)
        val name = parsed.path.orEmpty().substringAfterLast('/').ifBlank { "segment" }
            .replace(Regex("[^a-zA-Z0-9._-]"), "_")
        if (!parsed.isAbsolute && parsed.path == name && parsed.rawQuery == null && name != "." && name != "..") return name
        val hash = MessageDigest.getInstance("SHA-256").digest(uri.toByteArray())
            .take(8).joinToString("") { "%02x".format(it) }
        return "${hash}_${name.takeLast(100)}"
    }

    fun copySegment(input: InputStream, output: OutputStream, segment: Segment) {
        val length = segment.byteRangeLength
        if (length == null) {
            input.copyTo(output)
            return
        }
        var skip = requireNotNull(segment.byteRangeStart)
        require(skip >= 0 && length > 0) { "Invalid HLS byte range" }
        while (skip > 0) {
            val skipped = input.skip(skip)
            if (skipped > 0) skip -= skipped else {
                if (input.read() == -1) throw EOFException("HLS byte range starts past the end of the asset")
                skip--
            }
        }
        var remaining = length
        val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
        while (remaining > 0) {
            val read = input.read(buffer, 0, minOf(buffer.size.toLong(), remaining).toInt())
            if (read == -1) throw EOFException("Incomplete HLS byte range")
            output.write(buffer, 0, read)
            remaining -= read
        }
    }

    @OptIn(UnstableApi::class)
    fun parseVariantUrls(playlist: String, playlistUrl: String): Map<Pair<String, String?>, String> {
        val master = HlsPlaylistParser().parse(Uri.parse(playlistUrl), playlist.byteInputStream())
            as? HlsMultivariantPlaylist ?: return emptyMap()
        val urls = linkedMapOf<Pair<String, String?>, String>()
        for (variant in master.variants) {
            val format = variant.format
            if (format.roleFlags and C.ROLE_FLAG_TRICK_PLAY != 0) continue
            val name = format.label?.takeIf { it.isNotBlank() } ?: when {
                format.height > 0 -> "${format.height}p" + if (format.frameRate > 30) format.frameRate.roundToInt() else ""
                Util.getCodecsOfType(format.codecs, C.TRACK_TYPE_AUDIO) != null &&
                        Util.getCodecsOfType(format.codecs, C.TRACK_TYPE_VIDEO) == null -> "audio_only"
                else -> "source"
            }
            val quality = when {
                name.equals("source", true) -> "source"
                name.startsWith("audio", true) -> "audio_only"
                else -> name
            }
            urls.putIfAbsent(quality to format.codecs, variant.url.toString())
        }
        return urls.entries.sortedWith(
            compareByDescending<Map.Entry<Pair<String, String?>, String>> { it.key.first == "source" }
                .thenByDescending { it.key.first.substringBefore('p', "").toIntOrNull() }
                .thenByDescending { it.key.first.substringAfter('p', "").takeWhile { c -> c.isDigit() }.toIntOrNull() }
        ).associate { it.toPair() }
    }

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
    private val byteRangePattern = Pattern.compile("#EXT-X-BYTERANGE:(\\d+)(?:@(\\d+))?\\b")

    fun parseMediaPlaylist(input: InputStream): MediaPlaylist {
        var targetDuration = 10
        val dateRanges = mutableListOf<DateRange>()
        var programDateTime: String? = null
        var initSegmentUri: String? = null
        var encrypted = false
        val segments = mutableListOf<Segment>()
        var segmentInfo: Pair<Float, String?>? = null
        var pendingByteRange: Pair<Long, Long>? = null
        var byteRangeCursor = 0L
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
                        line.startsWith("#EXT-X-BYTERANGE:") -> {
                            // Applies to the next segment URI. A missing @offset
                            // continues where the previous range ended (0 for the first).
                            val matcher = byteRangePattern.matcher(line)
                            if (matcher.find()) {
                                matcher.group(1)?.toLongOrNull()?.let { length ->
                                    val offset = matcher.group(2)?.toLongOrNull() ?: byteRangeCursor
                                    pendingByteRange = Pair(offset, length)
                                    byteRangeCursor = offset + length
                                }
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
                        segments.add(Segment(line, it.first, it.second, programDateTime, pendingByteRange?.first, pendingByteRange?.second))
                        segmentInfo = null
                        pendingByteRange = null
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
            val version = when {
                playlist.initSegmentUri != null -> 6
                playlist.segments.any { it.byteRangeLength != null } -> 4
                else -> 3
            }
            writer.write("#EXT-X-VERSION:$version")
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
                writer.write("#EXTINF:${it.duration},${it.title.orEmpty()}")
                it.byteRangeLength?.let { length ->
                    val offset = requireNotNull(it.byteRangeStart)
                    require(length > 0 && offset >= 0) { "Invalid HLS byte range" }
                    writer.newLine()
                    writer.write("#EXT-X-BYTERANGE:$length@$offset")
                }
                writer.newLine()
                writer.write(it.uri)
            }
            writer.newLine()
            writer.write("#EXT-X-ENDLIST")
        }
    }
}
