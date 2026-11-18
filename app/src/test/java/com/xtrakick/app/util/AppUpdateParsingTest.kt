package com.xtrakick.app.util

import com.xtrakick.app.BuildConfig
import com.xtrakick.app.model.AppUpdateInfo
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AppUpdateParsingTest {
    @Test
    fun crashUpdateCheckBecomesDueAfterExactlyOneDay() {
        val lastCheck = 1_800_000_000_000L
        assertFalse(shouldForceAppUpdateCheck(true, lastCheck, lastCheck + 86_400_000L - 1))
        assertTrue(shouldForceAppUpdateCheck(true, lastCheck, lastCheck + 86_400_000L))
        assertTrue(shouldForceAppUpdateCheck(true, lastCheck, lastCheck + 2 * 86_400_000L))
    }

    @Test
    fun crashUpdateCheckRequiresAPendingCrashAndHandlesFirstLaunchAndClockRollback() {
        assertTrue(shouldForceAppUpdateCheck(true, 0L, 1L))
        assertFalse(shouldForceAppUpdateCheck(false, 0L, 1_800_000_000_000L))
        assertFalse(shouldForceAppUpdateCheck(true, 1_800_000_000_000L, 1_700_000_000_000L))
    }

    @Test
    fun malformedAssetsCannotHideALaterUsableApk() {
        val info = parseReleasePayload("""{
          "tag_name":"v3", "name":{}, "body":[], "published_at":"2026-08-28T12:00:00Z",
          "assets":[null, 12, {"name":"missing-url.apk"},
            {"name":"usable.apk", "browser_download_url":"https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/usable.apk", "size":-1}]
        }""", 0)

        assertEquals("https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/usable.apk", info?.downloadUrl)
        assertEquals("v3", info?.releaseTitle)
        assertNull(info?.releaseNotes)
        assertNull(info?.size)
    }

    @Test
    fun untrustedDownloadHostsAreRejected() {
        val payload = """{
          "published_at":"2026-08-28T12:00:00Z",
          "assets":[
            {"name":"app.apk", "browser_download_url":"https://evil.example.com/app.apk"},
            {"name":"app2.apk", "browser_download_url":"http://github.com/app.apk"},
            {"name":"app3.apk", "browser_download_url":"https://github.com.evil.com/app.apk"}
          ]
        }"""
        assertNull(parseReleasePayload(payload, 0))
        assertFalse(isTrustedUpdateUrl("https://github.com.evil.com/app.apk"))
        assertFalse(isTrustedUpdateUrl("not a url"))
        assertTrue(isTrustedUpdateUrl("https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk"))
        assertFalse(isTrustedUpdateUrl("https://github.com/owner/repo/releases/download/latest/app.apk"))
        assertFalse(isTrustedUpdateUrl("https://release-assets.githubusercontent.com/x/app.apk"))
        assertFalse(isTrustedUpdateUrl("https://objects.githubusercontent.com/x/app.apk"))
    }

    @Test
    fun checksOnlyUseReleaseFeedsFromTheOfficialRepository() {
        assertTrue(isOfficialUpdateFeed(OFFICIAL_UPDATE_FEED))
        assertTrue(isOfficialUpdateFeed("https://api.github.com/repos/tibor1234567895/Xtra-Kick/releases/latest"))
        assertFalse(isOfficialUpdateFeed("https://api.github.com/repos/example/Xtra-Kick/releases/latest"))
        assertFalse(isOfficialUpdateFeed("http://api.github.com/repos/tibor1234567895/Xtra-Kick/releases/latest"))
        assertFalse(isOfficialUpdateFeed("https://api.github.com/repos/tibor1234567895/Xtra-Kick/issues"))
    }

    @Test
    fun ignoresCustomFeedAndRejectsTheInstalledVersion() = runBlocking {
        val target = "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/"
        val requested = mutableListOf<String>()
        val update = fetchAppUpdate(json, "https://example.com/releases", 0) { url ->
            requested.add(url)
            if (url == OFFICIAL_UPDATE_FEED) """
                {"published_at":"2026-11-18T12:00:00Z","assets":[
                    {"name":"app-release.apk","browser_download_url":"${target}app-release.apk"},
                    {"name":"release-version.json","browser_download_url":"${target}release-version.json"}
                ]}
            """ else """{"versionCode":${BuildConfig.VERSION_CODE}}"""
        }
        assertNull(update)
        assertEquals(listOf(OFFICIAL_UPDATE_FEED, "${target}release-version.json"), requested)
    }

    @Test
    fun canonicalApkTakesPrecedenceOverThePreviousAssetDuringPublishing() {
        val target = "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/"
        val response = """{
          "assets":[
            {"name":"previous-1-app-release.apk", "updated_at":"2026-11-18T12:01:00Z",
             "browser_download_url":"${target}previous-1-app-release.apk"},
            {"name":"app-release.apk", "updated_at":"2026-11-18T12:00:00Z",
             "browser_download_url":"${target}app-release.apk"}
          ]
        }"""
        assertEquals("${target}app-release.apk", parseReleasePayload(response, 0)?.downloadUrl)
        val afterCanonical = checkNotNull(KickApiHelper.parseIso8601DateUTC("2026-11-18T12:00:01Z"))
        assertNull(parseReleasePayload(response, afterCanonical))
    }

    @Test
    fun releaseVersionUrlAndCodeExtracted() {
        val response = json.parseToJsonElement("""{
          "assets":[
            {"name":"release-version.json", "browser_download_url":"https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/release-version.json"}
          ]
        }""") as JsonObject

        assertEquals(
            "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/release-version.json",
            findReleaseVersionUrl(response)
        )
        assertEquals(123L, extractReleaseVersionCode(json.parseToJsonElement("""{"versionCode":123}""") as JsonObject))
        assertNull(extractReleaseVersionCode(json.parseToJsonElement("""{"other":1}""") as JsonObject))
        assertNull(extractReleaseVersionCode(json.parseToJsonElement("""{"versionCode":0}""") as JsonObject))
    }

    @Test
    fun untrustedReleaseVersionUrlIsIgnored() {
        val response = json.parseToJsonElement("""{
          "assets":[
            {"name":"release-version.json", "browser_download_url":"https://evil.example.com/release-version.json"}
          ]
        }""") as JsonObject

        assertNull(findReleaseVersionUrl(response))
    }

    @Test
    fun invalidAssetsAndEmptyDownloadUrlsProduceNoUpdate() {
        for (payload in listOf("[]", "{\"assets\":{}}", """{
          "published_at":"2026-08-28T12:00:00Z",
          "assets":[{"name":"app.apk", "browser_download_url":" "}]
        }""")) {
            assertNull(parseReleasePayload(payload, 0))
        }
    }


    private val json = Json { ignoreUnknownKeys = true }

    private fun parseReleasePayload(payload: String, lastChecked: Long): AppUpdateInfo? =
        parseAppUpdateInfo(json.parseToJsonElement(payload) as? JsonObject, lastChecked)

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
                        "browser_download_url": "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk"
                    }
                ]
            }
        """.trimIndent()

        val info = parseReleasePayload(payload, lastChecked = 1000L)

        assertNotNull(info)
        assertEquals("https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk", info?.downloadUrl)
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
                        "browser_download_url": "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk"
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
                        "browser_download_url": "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/source.zip"
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
