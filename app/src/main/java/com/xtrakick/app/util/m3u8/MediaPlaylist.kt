package com.xtrakick.app.util.m3u8

data class MediaPlaylist(
    val targetDuration: Int,
    val dateRanges: List<DateRange>,
    val initSegmentUri: String?,
    val segments: List<Segment>,
    val end: Boolean,
    /** True when any segment is covered by a non-NONE #EXT-X-KEY: this downloader cannot decrypt. */
    val encrypted: Boolean = false
)