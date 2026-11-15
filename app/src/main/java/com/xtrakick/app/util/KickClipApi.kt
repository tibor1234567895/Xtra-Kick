package com.xtrakick.app.util

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put
import java.io.IOException

/**
 * Client-side helpers for Kick's clip-creation API (the same endpoints the official app
 * uses). Limits mirror the official app's constants: duration 15-180s (default 30),
 * title max 50 chars.
 */
object KickClipApi {

    const val CLIP_MIN_LENGTH_SECONDS = 15
    const val CLIP_MAX_LENGTH_SECONDS = 180
    const val CLIP_DEFAULT_LENGTH_SECONDS = 30
    const val CLIP_TITLE_MAX_LENGTH = 50

    /** A server-cut temporary clip returned by `POST /api/v1/clips`. */
    data class TemporaryClip(
        val id: String,
        val previewUrl: String?,
        val sourceDurationSeconds: Int?,
    )

    /** A finalized clip with public URL ready for sharing. */
    data class FinalizedClip(
        val id: String,
        val title: String,
        val clipUrl: String,
        val channelLogin: String?,
    )

    fun buildInitiateClipBody(videoId: String, positionSeconds: Long? = null): String {
        val trimmed = videoId.trim()
        if (trimmed.isEmpty()) {
            throw IOException("Video id is required for clip creation")
        }
        return buildJsonObject {
            put("video_id", trimmed)
            if (positionSeconds != null && positionSeconds > 0L) {
                put("position", positionSeconds.coerceAtMost(Int.MAX_VALUE.toLong()).toInt())
            }
        }.toString()
    }

    fun buildFinalizeClipBody(title: String?, startSeconds: Int, durationSeconds: Int): String {
        val finalTitle = title?.trim()?.takeIf { it.isNotEmpty() } ?: "Clip"
        val start = startSeconds.coerceAtLeast(0)
        val duration = durationSeconds.coerceIn(CLIP_MIN_LENGTH_SECONDS, CLIP_MAX_LENGTH_SECONDS)
        return buildJsonObject {
            put("title", finalTitle)
            put("trim_start", start)
            put("trim_duration", duration)
        }.toString()
    }

    /**
     * Chooses the (start, duration) window inside a temporary clip's source so the saved
     * clip ends at the moment of the initiate call ("last N seconds" semantics), clamped
     * to the official app's limits and to whatever the server actually recorded.
     * [fromStart] selects preview zero for a positioned request. Duration never drops
     * below the official minimum: for a source that short the server rejects
     * the finalize, which surfaces as a creation error instead of a crash.
     */
    fun computeClipRange(sourceDurationSeconds: Int?, requestedDurationSeconds: Int, fromStart: Boolean = false): Pair<Int, Int> {
        val maxBySource = sourceDurationSeconds?.coerceAtLeast(0)
        val upperBound = if (maxBySource != null) minOf(CLIP_MAX_LENGTH_SECONDS, maxBySource) else CLIP_MAX_LENGTH_SECONDS
        val duration = requestedDurationSeconds
            .coerceAtLeast(CLIP_MIN_LENGTH_SECONDS)
            .coerceAtMost(maxOf(upperBound, CLIP_MIN_LENGTH_SECONDS))
        val start = if (fromStart) 0 else maxBySource?.let { (it - duration).coerceAtLeast(0) } ?: 0
        return start to duration
    }

    fun clampTitle(title: String?): String? {
        return title?.trim()?.takeIf { it.isNotEmpty() }?.take(CLIP_TITLE_MAX_LENGTH)
    }

    /**
     * Parses the initiate response. The official client expects the temporary clip
     * fields directly on the payload; nested `data`/`clip` objects are accepted too so
     * a small server-side shape change doesn't break creation outright.
     */
    fun parseTemporaryClip(rawJson: String): TemporaryClip? {
        if (rawJson.isBlank()) return null
        val root = runCatching { Json.Default.parseToJsonElement(rawJson).jsonObject }.getOrNull() ?: return null
        val candidates = generateSequence(root) { current ->
            (current["data"] as? JsonObject) ?: (current["clip"] as? JsonObject)
        }.take(3)
        for (candidate in candidates) {
            val clip = parseTemporaryClipObject(candidate) ?: continue
            return clip
        }
        return null
    }

    /**
     * Parses the finalize response, extracting the public clip URL and title, falling
     * back to standard kick.com slug patterns if the API returns a minimal 200 payload.
     */
    fun parseFinalizedClip(
        rawJson: String?,
        fallbackClipId: String,
        fallbackTitle: String,
        channelLogin: String?,
    ): FinalizedClip {
        val root = runCatching {
            rawJson?.takeIf { it.isNotBlank() }?.let { Json.Default.parseToJsonElement(it).jsonObject }
        }.getOrNull()
        val data = (root?.get("data") as? JsonObject) ?: (root?.get("clip") as? JsonObject) ?: root
        val id = data?.stringOrNull("id") ?: data?.stringOrNull("clip_id") ?: fallbackClipId
        val slug = data?.stringOrNull("slug") ?: id
        val serverClipUrl = data?.stringOrNull("clip_url") ?: data?.stringOrNull("url")
        val clipUrl = serverClipUrl ?: if (!channelLogin.isNullOrBlank()) {
            "https://kick.com/$channelLogin/clips/$slug"
        } else {
            "https://kick.com/clips/$slug"
        }
        val title = data?.stringOrNull("title") ?: fallbackTitle
        return FinalizedClip(id = id, title = title, clipUrl = clipUrl, channelLogin = channelLogin)
    }

    private fun parseTemporaryClipObject(root: JsonObject): TemporaryClip? {
        val id = root.stringOrNull("id") ?: return null
        return TemporaryClip(
            id = id,
            previewUrl = root.stringOrNull("preview_url"),
            sourceDurationSeconds = root.intOrNull("source_duration"),
        )
    }

    private fun JsonObject.stringOrNull(key: String): String? {
        return (this[key] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
    }

    private fun JsonObject.intOrNull(key: String): Int? {
        val primitive = this[key] as? JsonPrimitive ?: return null
        return primitive.contentOrNull?.toDoubleOrNull()?.toInt()
    }
}
