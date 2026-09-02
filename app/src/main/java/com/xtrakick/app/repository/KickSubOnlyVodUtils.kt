package com.xtrakick.app.repository

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

/**
 * URL reconstruction for Kick VODs whose playback_url is withheld by the web APIs
 * (subscriber-only replays). The underlying IVS recording on stream.kick.com is served
 * without authentication; its path embeds an IVS channel id and recording id (also
 * present in the VOD thumbnail path) and is bucketed by the UTC minute of the stream
 * start. The account id and distribution prefixes are reverse-engineered constants —
 * a Kick infrastructure change breaks resolution and requires updating them here.
 */
internal object KickSubOnlyVodUtils {

    private const val IVS_ACCOUNT_ID = "196233775518"

    val ivsBaseUrls: List<String> = listOf(
        "https://stream.kick.com/ivs/v1/$IVS_ACCOUNT_ID",
        "https://stream.kick.com/3c81249a5ce0/ivs/v1/$IVS_ACCOUNT_ID",
        "https://stream.kick.com/0f3cb0ebce7/ivs/v1/$IVS_ACCOUNT_ID",
    )

    // created_at and the recording's actual bucket minute can differ by rounding, so
    // the manifest is probed across a window of minutes around the stream start.
    val minuteOffsets: List<Int> = listOf(0, 1, -1, 2, -2, 3, -3, 4, -4, 5, -5)

    data class IvsPath(val ivsChannelId: String, val recordingId: String)

    /**
     * Candidate (ivsChannelId, recordingId) pairs, most reliable first: parsed from the
     * thumbnail path, falling back to the numeric channel id paired with slug-shaped
     * recording ids (the IVS path keys off the slug, not the numeric VOD id).
     */
    fun extractIvsPaths(thumbnailUrl: String?, channelId: String?, recordingIds: List<String?>): List<IvsPath> {
        val paths = mutableListOf<IvsPath>()
        fun add(ivsChannelId: String?, recordingId: String?) {
            val path = IvsPath(ivsChannelId?.trim().orEmpty(), recordingId?.trim().orEmpty())
            if (path.ivsChannelId.isNotBlank() && path.recordingId.isNotBlank() && paths.none { it == path }) {
                paths.add(path)
            }
        }
        thumbnailUrl?.trim()?.takeIf { it.isNotBlank() }?.let { thumbnail ->
            val segments = thumbnail.substringBefore('?').split('/')
            val thumbnailsIndex = segments.indexOf("video_thumbnails")
            if (thumbnailsIndex in 0..(segments.size - 3)) {
                add(segments[thumbnailsIndex + 1], segments[thumbnailsIndex + 2])
            }
            val ivsIndex = segments.indexOf("ivs")
            if (ivsIndex in 0..(segments.size - 4) && segments[ivsIndex + 1] == "v1") {
                add(segments[ivsIndex + 2], segments[ivsIndex + 3])
            }
        }
        channelId?.trim()?.takeIf { it.isNotBlank() }?.let { channel ->
            recordingIds.forEach { recordingId ->
                if (isUuidShaped(recordingId)) {
                    add(channel, recordingId)
                }
            }
        }
        return paths
    }

    /** Parses ISO-8601 timestamps ("2026-08-27T21:03:59Z", offsets accepted) to epoch ms. */
    fun parseStartMillis(input: String?): Long? {
        val trimmed = input?.trim().takeUnless { it.isNullOrBlank() } ?: return null
        return runCatching { Instant.parse(trimmed).toEpochMilli() }.getOrNull()
            ?: runCatching { OffsetDateTime.parse(trimmed).toInstant().toEpochMilli() }.getOrNull()
    }

    /**
     * Master playlist URLs for one minute bucket. The path segments are intentionally
     * unpadded, matching how IVS stores recordings (e.g. 2026/8/27/21/3).
     */
    fun buildMasterPlaylistUrls(baseUrls: List<String>, path: IvsPath, startMillis: Long, offsetMinutes: Int): List<String> {
        val bucket = Instant.ofEpochMilli(startMillis).atZone(ZoneOffset.UTC).plusMinutes(offsetMinutes.toLong())
        return baseUrls.map { base ->
            "$base/${path.ivsChannelId}/${bucket.year}/${bucket.monthValue}/${bucket.dayOfMonth}/" +
                "${bucket.hour}/${bucket.minute}/${path.recordingId}/media/hls/master.m3u8"
        }
    }

    /** True for slug-shaped recording ids (e.g. 01a04509-5a60-7e1b-acdb-983cab9b8a10). */
    fun isUuidShaped(value: String?): Boolean {
        val trimmed = value?.trim().takeUnless { it.isNullOrBlank() } ?: return false
        return trimmed.length >= 32 && trimmed.count { it == '-' } >= 4
    }
}
