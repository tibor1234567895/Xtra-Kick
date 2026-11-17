package com.xtrakick.app.util

import com.xtrakick.app.model.AppUpdateInfo
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.longOrNull
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

/** Only release assets served by these HTTPS hosts may reach the APK installer. */
private val TRUSTED_UPDATE_HOSTS = setOf(
    "github.com",
    "objects.githubusercontent.com",
    "release-assets.githubusercontent.com",
)

internal fun isTrustedUpdateUrl(url: String): Boolean {
    val parsed = url.trim().toHttpUrlOrNull() ?: return false
    return parsed.isHttps && parsed.host in TRUSTED_UPDATE_HOSTS
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
    for (element in assets) {
        val asset = element as? JsonObject ?: continue
        if (asset.text("content_type") != "application/vnd.android.package-archive" &&
            asset.text("name")?.endsWith(".apk") != true
        ) continue
        val url = asset.text("browser_download_url")?.takeIf(String::isNotBlank) ?: continue
        // The update feed URL is a user-editable preference, so the APK URL must
        // never be followed blindly: the same-signature installer check is the
        // last line of defense, not the only one.
        if (!isTrustedUpdateUrl(url)) continue
        val updatedAt = asset.text("updated_at")?.let(KickApiHelper::parseIso8601DateUTC)
            ?: response.text("published_at")?.let(KickApiHelper::parseIso8601DateUTC)
            ?: response.text("created_at")?.let(KickApiHelper::parseIso8601DateUTC)
            ?: continue
        if (updatedAt <= lastChecked) continue
        return AppUpdateInfo(
            downloadUrl = url,
            size = (asset["size"] as? JsonPrimitive)?.longOrNull?.takeIf { it >= 0 },
            updatedAt = updatedAt,
            releaseTitle = response.text("name") ?: response.text("tag_name"),
            releaseNotes = response.text("body"),
        )
    }
    return null
}

internal fun shouldForceAppUpdateCheck(hasPendingCrash: Boolean, lastForcedCheck: Long, now: Long): Boolean =
    hasPendingCrash && (lastForcedCheck == 0L || now - lastForcedCheck >= 86_400_000L)

private fun JsonObject.text(key: String): String? = (this[key] as? JsonPrimitive)?.contentOrNull
