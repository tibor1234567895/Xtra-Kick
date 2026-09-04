package com.xtrakick.app.util

import java.net.URI
import java.net.URLDecoder
import java.util.Locale

sealed class KickLink {
    data class Video(
        val videoId: String,
        val channelLogin: String? = null,
        val offsetMs: Long? = null,
    ) : KickLink()

    data class Clip(
        val clipId: String,
        val channelLogin: String? = null,
    ) : KickLink()

    data class User(
        val channelLogin: String,
    ) : KickLink()

    data class Category(
        val slug: String,
        val tag: String? = null,
    ) : KickLink()

    data class Tag(
        val tag: String,
    ) : KickLink()

    object DirectoryAll : KickLink()
    object Directory : KickLink()
}

object KickLinkRouter {

    private val RESERVED_SEGMENTS = setOf(
        "about",
        "privacy-policy",
        "terms-of-service",
        "community-guidelines",
        "dmca",
        "cookie-policy",
        "settings",
        "search",
        "browse",
        "directory",
        "categories",
        "category",
        "tags",
        "videos",
        "video",
        "clips",
        "clip",
        "help",
        "support",
        "press",
        "careers",
        "login",
        "signup",
        "auth",
        "api",
        "favicon.ico",
        "robots.txt"
    )

    fun parse(rawUrl: String?): KickLink? {
        val trimmed = rawUrl?.trim().takeUnless { it.isNullOrBlank() } ?: return null
        val normalized = when {
            trimmed.startsWith("//") -> "https:$trimmed"
            !trimmed.contains("://") -> "https://$trimmed"
            else -> trimmed
        }

        val (host, rawPath, rawQuery) = try {
            val uri = URI(normalized.replace(" ", "%20"))
            if (uri.host != null) {
                Triple(uri.host, uri.path.orEmpty(), uri.rawQuery)
            } else {
                extractHostPathQueryFallback(normalized)
            }
        } catch (_: Exception) {
            extractHostPathQueryFallback(normalized)
        } ?: return null

        if (!isKickHost(host)) return null
        if (rawPath.contains("..")) return null

        val segments = rawPath.split('/')
            .mapNotNull { rawSegment ->
                val segment = rawSegment.substringBefore('?').substringBefore('#')
                if (segment.isBlank() || segment == "." || segment == "..") null
                else runCatching { URLDecoder.decode(segment, "UTF-8") }.getOrDefault(segment)
            }

        val query = rawQuery ?: normalized.substringAfter('?', "").takeIf { it.isNotEmpty() }
        val params = extractQueryParams(query)

        return route(host = host.lowercase(Locale.ROOT), segments = segments, params = params)
    }

    private fun isKickHost(host: String?): Boolean {
        if (host.isNullOrBlank()) return false
        val cleanHost = host.substringAfterLast('@').substringBefore(':').lowercase(Locale.ROOT)
        return cleanHost == "kick.com" || (cleanHost.endsWith(".kick.com") && cleanHost.length > 9)
    }

    private fun extractHostPathQueryFallback(url: String): Triple<String?, String, String?>? {
        val noScheme = url.substringAfter("://")
        val hostAndRest = noScheme.substringBefore('?')
        val rawHost = hostAndRest.substringBefore('/')
        val host = rawHost.substringAfterLast('@').substringBefore(':').takeIf { it.isNotBlank() } ?: return null
        val path = if (hostAndRest.contains('/')) "/" + hostAndRest.substringAfter('/') else ""
        val query = if (url.contains('?')) url.substringAfter('?').substringBefore('#') else null
        return Triple(host, path, query)
    }

    private fun extractQueryParams(queryString: String?): Map<String, String> {
        if (queryString.isNullOrBlank()) return emptyMap()
        val params = mutableMapOf<String, String>()
        for (pair in queryString.split('&')) {
            val eqIndex = pair.indexOf('=')
            if (eqIndex > 0) {
                val key = pair.substring(0, eqIndex).lowercase(Locale.ROOT)
                val value = pair.substring(eqIndex + 1)
                val decoded = runCatching { URLDecoder.decode(value, "UTF-8") }.getOrDefault(value)
                params[key] = decoded
            }
        }
        return params
    }

    private fun route(host: String, segments: List<String>, params: Map<String, String>): KickLink? {
        if (host == "clips.kick.com") {
            val clipId = segments.lastOrNull()?.takeIf { it.isNotBlank() && isValidIdentifier(it) }
            return clipId?.let { KickLink.Clip(clipId = it) }
        }

        if (segments.isEmpty()) return null

        val firstLower = segments[0].lowercase(Locale.ROOT)

        if (firstLower == "directory") {
            return if (segments.size >= 2 && segments[1].equals("all", ignoreCase = true)) {
                KickLink.DirectoryAll
            } else {
                KickLink.Directory
            }
        }

        if (firstLower == "category" || firstLower == "categories") {
            val slug = segments.lastOrNull()
            if (!slug.isNullOrBlank() && !slug.equals("category", ignoreCase = true) && !slug.equals("categories", ignoreCase = true) && isValidIdentifier(slug)) {
                val tag = params["tl"]?.takeIf { isSafeString(it) }
                return KickLink.Category(slug = slug, tag = tag)
            }
            return null
        }

        if (firstLower == "tags") {
            val tag = segments.getOrNull(1)
            return tag?.takeIf { it.isNotBlank() && isSafeString(it) }?.let { KickLink.Tag(tag = it) }
        }

        val videoSegmentIndex = segments.indexOfFirst {
            it.equals("videos", ignoreCase = true) || it.equals("video", ignoreCase = true)
        }
        if (videoSegmentIndex != -1 && videoSegmentIndex + 1 < segments.size) {
            val videoId = segments[videoSegmentIndex + 1]
            if (videoId.isNotBlank() && isValidIdentifier(videoId)) {
                val channel = if (videoSegmentIndex > 0) segments[0] else null
                return KickLink.Video(
                    videoId = videoId,
                    channelLogin = channel?.takeUnless { it.lowercase(Locale.ROOT) in RESERVED_SEGMENTS || !isValidIdentifier(it) },
                    offsetMs = extractOffsetMs(params)
                )
            }
        }

        val clipSegmentIndex = segments.indexOfFirst {
            it.equals("clips", ignoreCase = true) || it.equals("clip", ignoreCase = true)
        }
        if (clipSegmentIndex != -1 && clipSegmentIndex + 1 < segments.size) {
            val clipId = segments[clipSegmentIndex + 1]
            if (clipId.isNotBlank() && isValidIdentifier(clipId)) {
                val channel = if (clipSegmentIndex > 0) segments[0] else null
                return KickLink.Clip(
                    clipId = clipId,
                    channelLogin = channel?.takeUnless { it.lowercase(Locale.ROOT) in RESERVED_SEGMENTS || !isValidIdentifier(it) }
                )
            }
        }

        if (firstLower !in RESERVED_SEGMENTS && isValidIdentifier(segments[0])) {
            return KickLink.User(channelLogin = segments[0])
        }

        return null
    }

    private fun extractOffsetMs(params: Map<String, String>): Long? {
        val timeParam = params["t"] ?: params["time"] ?: return null
        val durationSec = KickApiHelper.getDuration(timeParam)
        return if (durationSec != null && durationSec >= 0) durationSec * 1000L else null
    }

    private fun isValidIdentifier(id: String): Boolean {
        return id.none { it == '/' || it == '\\' || it.isWhitespace() || it.isISOControl() }
    }

    private fun isSafeString(text: String): Boolean {
        return text.none { it.isISOControl() }
    }
}
