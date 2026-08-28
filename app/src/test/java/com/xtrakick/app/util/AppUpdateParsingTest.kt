package com.xtrakick.app.util

import com.xtrakick.app.model.AppUpdateInfo
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AppUpdateParsingTest {

    private val json = Json { ignoreUnknownKeys = true }

    private fun parseReleasePayload(payload: String, lastChecked: Long): AppUpdateInfo? {
        val response = json.decodeFromString<JsonObject>(payload)
        val releaseNotes = response["body"]?.jsonPrimitive?.contentOrNull
        val releaseTitle = response["name"]?.jsonPrimitive?.contentOrNull ?: response["tag_name"]?.jsonPrimitive?.contentOrNull

        return response["assets"]?.jsonArray?.find {
            val asset = it.jsonObject
            asset["content_type"]?.jsonPrimitive?.contentOrNull == "application/vnd.android.package-archive" ||
                (asset["name"]?.jsonPrimitive?.contentOrNull)?.endsWith(".apk") == true
        }?.jsonObject?.let { obj ->
            val updatedAt = obj["updated_at"]?.jsonPrimitive?.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }
                ?: response["published_at"]?.jsonPrimitive?.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }
                ?: response["created_at"]?.jsonPrimitive?.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }
            val downloadUrl = obj["browser_download_url"]?.jsonPrimitive?.contentOrNull
            val size = obj["size"]?.jsonPrimitive?.longOrNull

            if (updatedAt != null && downloadUrl != null && updatedAt > lastChecked) {
                AppUpdateInfo(
                    downloadUrl = downloadUrl,
                    size = size,
                    updatedAt = updatedAt,
                    releaseTitle = releaseTitle,
                    releaseNotes = releaseNotes
                )
            } else null
        }
    }

    @Test
    fun parseReleaseWithApkAssetAndChangelog() {
        val payload = """
            {
                "tag_name": "latest",
                "name": "v2.55.0 - Performance & Bug Fixes",
                "body": "### Changes\n- Fixed in-app updater\n- Chat performance enhancements",
                "published_at": "2026-08-28T12:00:00Z",
                "assets": [
                    {
                        "name": "app-release.apk",
                        "content_type": "application/vnd.android.package-archive",
                        "size": 25000000,
                        "updated_at": "2026-08-28T12:05:00Z",
                        "browser_download_url": "https://github.com/downloads/app-release.apk"
                    }
                ]
            }
        """.trimIndent()

        val info = parseReleasePayload(payload, lastChecked = 1000L)

        assertNotNull(info)
        assertEquals("https://github.com/downloads/app-release.apk", info?.downloadUrl)
        assertEquals(25000000L, info?.size)
        assertEquals("v2.55.0 - Performance & Bug Fixes", info?.releaseTitle)
        assertEquals("### Changes\n- Fixed in-app updater\n- Chat performance enhancements", info?.releaseNotes)
        assertTrue((info?.updatedAt ?: 0L) > 1000L)
    }

    @Test
    fun parseReleaseOlderThanLastCheckedReturnsNull() {
        val payload = """
            {
                "tag_name": "latest",
                "name": "v2.55.0",
                "body": "Notes",
                "assets": [
                    {
                        "name": "app-release.apk",
                        "content_type": "application/vnd.android.package-archive",
                        "size": 25000000,
                        "updated_at": "2026-08-20T12:05:00Z",
                        "browser_download_url": "https://github.com/downloads/app-release.apk"
                    }
                ]
            }
        """.trimIndent()

        // 2026-08-25 UTC is after 2026-08-20 UTC
        val lastChecked = KickApiHelper.parseIso8601DateUTC("2026-08-25T12:00:00Z") ?: 0L
        val info = parseReleasePayload(payload, lastChecked = lastChecked)

        assertNull(info)
    }

    @Test
    fun parseReleaseWithoutApkAssetReturnsNull() {
        val payload = """
            {
                "tag_name": "latest",
                "name": "v2.55.0",
                "body": "Notes",
                "assets": [
                    {
                        "name": "source.zip",
                        "content_type": "application/zip",
                        "size": 12345,
                        "updated_at": "2026-08-28T12:05:00Z",
                        "browser_download_url": "https://github.com/downloads/source.zip"
                    }
                ]
            }
        """.trimIndent()

        val info = parseReleasePayload(payload, lastChecked = 0L)
        assertNull(info)
    }

    @Test
    fun frequencyCalculationDoesNotOverflowForLargeDays() {
        val frequencyDays30 = 30L
        val frequencyMs = frequencyDays30 * 86_400_000L

        // 30 days in ms = 2,592,000,000 ms, which exceeds 32-bit Int.MAX_VALUE (2,147,483,647)
        assertTrue(frequencyMs > Int.MAX_VALUE)
        assertEquals(2_592_000_000L, frequencyMs)
    }

    @Test
    fun startupFrequencyZeroTriggersImmediately() {
        val frequencyDays = "0".toLongOrNull() ?: 0L
        val lastCheckTimestamp = 100_000_000L
        val now = 100_000_010L

        val shouldCheck = frequencyDays <= 0L || (lastCheckTimestamp + frequencyDays * 86_400_000L < now)
        assertTrue(shouldCheck)
    }

    @Test
    fun mockUpdateGeneratesValidAppUpdateInfo() {
        val now = System.currentTimeMillis()
        val mockTime = now + 86_400_000L
        val lastChecked = now

        assertTrue(mockTime > lastChecked)

        val mockInfo = AppUpdateInfo(
            downloadUrl = "https://github.com/tibor1234567895/Xtra-Kick/releases/latest",
            size = 25_000_000L,
            updatedAt = mockTime,
            releaseTitle = "v99.0.0 (Debug Test Update)",
            releaseNotes = "### Simulated Release Notes\n- Verified in-app updater startup checks"
        )

        assertEquals("https://github.com/tibor1234567895/Xtra-Kick/releases/latest", mockInfo.downloadUrl)
        assertEquals("v99.0.0 (Debug Test Update)", mockInfo.releaseTitle)
        assertTrue(mockInfo.updatedAt > lastChecked)
    }

    @Test
    fun formatChangelogFiltersNoiseAndFormatsBullets() {
        val raw = """
            e781408 chore: clean compiler warnings
            8583ae6 build: compile against Android SDK 37
            08f17da Merge branch 'validate-pr-54'
            1623e86 Merge branch 'validate-pr-49' into integrate-dependabot
            Active Changelog: https://github.com/tibor1234567895/Xtra-Kick/commits/main
            Release build 2026-08-28 11:19:59 UTC
        """.trimIndent()

        val formatted = AppUpdateDialogHelper.formatChangelog(raw, "Default Description")
        val expected = "• chore: clean compiler warnings\n• build: compile against Android SDK 37"

        assertEquals(expected, formatted)
    }

    @Test
    fun formatChangelogFallsBackWhenEmptyOrOnlyNoise() {
        val noiseOnly = """
            08f17da Merge branch 'validate-pr-54'
            Active Changelog: https://github.com/tibor1234567895/Xtra-Kick/commits/main
        """.trimIndent()

        val fallback = AppUpdateDialogHelper.formatChangelog(noiseOnly, "Default Description")
        assertEquals("Default Description", fallback)

        val nullFallback = AppUpdateDialogHelper.formatChangelog(null, "Default Description")
        assertEquals("Default Description", nullFallback)
    }
}
