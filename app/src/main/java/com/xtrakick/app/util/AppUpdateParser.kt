package com.xtrakick.app.util

import com.xtrakick.app.BuildConfig
import com.xtrakick.app.model.AppUpdateInfo
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.longOrNull
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

private val OFFICIAL_REPOSITORY = listOf("tibor1234567895", "Xtra-Kick")
private val OFFICIAL_FEED_PATH = listOf("repos") + OFFICIAL_REPOSITORY + "releases"
internal const val OFFICIAL_UPDATE_FEED =
    "https://api.github.com/repos/tibor1234567895/Xtra-Kick/releases/tags/latest"

internal fun isOfficialUpdateFeed(url: String): Boolean {
    val parsed = url.toHttpUrlOrNull() ?: return false
    val path = parsed.pathSegments
    if (!parsed.isHttps || parsed.host != "api.github.com" || parsed.port != 443 ||
        parsed.username.isNotEmpty() || parsed.password.isNotEmpty() ||
        path.take(4) != OFFICIAL_FEED_PATH
    ) return false
    val release = path.drop(4)
    return release == listOf("latest") || (release.size == 2 && release[0] == "tags" && release[1].isNotBlank())
}

internal suspend fun fetchAppUpdate(
    json: Json,
    configuredFeed: String,
    lastChecked: Long,
    loadText: suspend (String) -> String?,
): AppUpdateInfo? {
    val feed = configuredFeed.takeIf(::isOfficialUpdateFeed) ?: OFFICIAL_UPDATE_FEED
    val response = loadText(feed)?.let { json.parseToJsonElement(it) as? JsonObject } ?: return null
    val candidate = parseAppUpdateInfo(response, lastChecked) ?: return null
    val remoteCode = try {
        findReleaseVersionUrl(response)
            ?.let { loadText(it) }
            ?.let { json.parseToJsonElement(it) as? JsonObject }
            ?.let(::extractReleaseVersionCode)
    } catch (error: Exception) {
        if (error is CancellationException) throw error
        DiagnosticLogger.w("AppUpdate", "Could not load release version, using the release timestamp", error)
        null
    }
    return candidate.takeIf { remoteCode == null || remoteCode > BuildConfig.VERSION_CODE }
}

internal fun isTrustedUpdateUrl(url: String): Boolean {
    val parsed = url.trim().toHttpUrlOrNull() ?: return false
    val path = parsed.pathSegments
    return parsed.isHttps && parsed.host == "github.com" && parsed.port == 443 &&
        parsed.username.isEmpty() && parsed.password.isEmpty() && parsed.query == null &&
        path.size == 6 && path.take(2) == OFFICIAL_REPOSITORY &&
        path[2] == "releases" && path[3] == "download" &&
        path.drop(4).all { it.isNotBlank() && '/' !in it && '\\' !in it }
}

/**
 * The CI workflow uploads release-version.json ({"versionCode": N}) next to the
 * APK. Returns its trusted download URL so the update check can compare
 * version codes instead of asset timestamps.
 */
internal fun findReleaseVersionUrl(response: JsonObject): String? {
    val assets = response["assets"] as? JsonArray ?: return null
    for (element in assets) {
        val asset = element as? JsonObject ?: continue
        if (asset.text("name") != "release-version.json") continue
        val url = asset.text("browser_download_url")?.takeIf(String::isNotBlank) ?: continue
        if (isTrustedUpdateUrl(url)) return url
    }
    return null
}

internal fun extractReleaseVersionCode(response: JsonObject): Long? =
    (response["versionCode"] as? JsonPrimitive)?.longOrNull?.takeIf { it > 0 }

internal fun parseAppUpdateInfo(response: JsonObject?, lastChecked: Long): AppUpdateInfo? {
    response ?: return null
    val assets = response["assets"] as? JsonArray ?: return null
    var newest: AppUpdateInfo? = null
    for (element in assets) {
        val asset = element as? JsonObject ?: continue
        if (asset.text("content_type") != "application/vnd.android.package-archive" &&
            asset.text("name")?.endsWith(".apk") != true
        ) continue
        val url = asset.text("browser_download_url")?.takeIf(String::isNotBlank) ?: continue
        if (!isTrustedUpdateUrl(url)) continue
        val updatedAt = asset.text("updated_at")?.let(KickApiHelper::parseIso8601DateUTC)
            ?: response.text("published_at")?.let(KickApiHelper::parseIso8601DateUTC)
            ?: response.text("created_at")?.let(KickApiHelper::parseIso8601DateUTC)
            ?: continue
        val canonical = asset.text("name") == "app-release.apk"
        val candidate = AppUpdateInfo(
            downloadUrl = url,
            size = (asset["size"] as? JsonPrimitive)?.longOrNull?.takeIf { it >= 0 },
            updatedAt = updatedAt,
            releaseTitle = response.text("name") ?: response.text("tag_name"),
            releaseNotes = response.text("body"),
        )
        if (canonical) return candidate.takeIf { updatedAt > lastChecked }
        if (updatedAt > (newest?.updatedAt ?: lastChecked)) newest = candidate
    }
    return newest
}

internal fun shouldForceAppUpdateCheck(hasPendingCrash: Boolean, lastForcedCheck: Long, now: Long): Boolean =
    hasPendingCrash && (lastForcedCheck == 0L || now - lastForcedCheck >= 86_400_000L)

private fun JsonObject.text(key: String): String? = (this[key] as? JsonPrimitive)?.contentOrNull
