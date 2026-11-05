package com.xtrakick.app.util

import com.xtrakick.app.model.AppUpdateInfo
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.longOrNull

internal fun parseAppUpdateInfo(response: JsonObject?, lastChecked: Long): AppUpdateInfo? {
    response ?: return null
    val assets = response["assets"] as? JsonArray ?: return null
    for (element in assets) {
        val asset = element as? JsonObject ?: continue
        if (asset.text("content_type") != "application/vnd.android.package-archive" &&
            asset.text("name")?.endsWith(".apk") != true
        ) continue
        val url = asset.text("browser_download_url")?.takeIf(String::isNotBlank) ?: continue
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

private fun JsonObject.text(key: String): String? = (this[key] as? JsonPrimitive)?.contentOrNull
