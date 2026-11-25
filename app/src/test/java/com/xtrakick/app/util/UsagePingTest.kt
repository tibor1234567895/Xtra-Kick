package com.xtrakick.app.util

import android.app.Application
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.ui.player.KickLivePlayback
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowSystemClock
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.time.Duration
import java.time.Instant

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class)
class UsagePingTest {
    private val context = RuntimeEnvironment.getApplication()
    private val prefs get() = context.prefs()
    private val ivs = KickLivePlayback.ENGINE_IVS
    private val exo = KickLivePlayback.ENGINE_EXO_ONLY

    @Before
    @After
    fun reset() {
        prefs.edit().clear().commit()
        context.tokenPrefs().edit().clear().commit()
        UsagePing.notePlaybackEnded(ivs)
        UsagePing.notePlaybackEnded(exo)
        UsagePing.resetInteractionForTests()
    }

    @Test
    fun rapidContentChangesCountWhileBufferingAndLongPauseResumeDoNot() {
        UsagePing.notePlaybackStarted(context, exo, "clip-a")
        repeat(10) { UsagePing.notePlaybackStarted(context, exo, "clip-a") }
        ShadowSystemClock.advanceBy(Duration.ofMinutes(10))
        UsagePing.notePlaybackStarted(context, exo, "clip-a")
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
        UsagePing.notePlaybackStarted(context, exo, "clip-b")
        UsagePing.notePlaybackStarted(context, exo, "clip-a")
        assertEquals(3, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
    }

    @Test
    fun endingPlaybackAllowsTheSameContentToCountAgainAndEnginesAreIndependent() {
        UsagePing.notePlaybackStarted(context, ivs, "stream-a")
        UsagePing.notePlaybackStarted(context, exo, "stream-a")
        UsagePing.notePlaybackEnded(ivs)
        UsagePing.notePlaybackStarted(context, ivs, "stream-a")
        assertEquals(2, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS, 0))
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
    }

    @Test
    fun disabledStatisticsDoNotAccumulatePlaybackStarts() {
        prefs.edit().putBoolean(AppConstants.USAGE_STATS_ENABLED, false).commit()
        UsagePing.notePlaybackStarted(context, exo, "private-clip")
        assertEquals(0, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
    }

    @Test
    fun olderBackendPreservesPlaybackCountsUntilANewerBackendAcknowledgesThem() {
        UsagePing.notePlaybackStarted(context, ivs, "stream-a")
        UsagePing.notePlaybackStarted(context, exo, "clip-a")
        val oldBackend = Connection()
        UsagePing.sendOnce(context, "2026-11-13") { oldBackend }
        assertEquals("2026-11-13", prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null))
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS, 0))
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))

        val newBackend = Connection(acknowledged = true)
        UsagePing.sendOnce(context, "2026-11-14") { newBackend }
        val payload = Json.parseToJsonElement(newBackend.body.toString(Charsets.UTF_8)).jsonObject
        assertEquals(BuildConfig.VERSION_CODE.toString(), payload.getValue("b").jsonPrimitive.content)
        assertEquals("1", payload.getValue("si").jsonPrimitive.content)
        assertEquals("1", payload.getValue("se").jsonPrimitive.content)
        assertFalse(newBackend.body.toString(Charsets.UTF_8).contains("stream-a"))
        assertEquals(0, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS, 0))
        assertEquals(0, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
    }

    @Test
    fun acknowledgedPingKeepsPlaybackStartsRecordedWhileItWasInFlight() {
        UsagePing.notePlaybackStarted(context, exo, "clip-a")
        val backend = Connection(acknowledged = true) {
            UsagePing.notePlaybackStarted(context, exo, "clip-b")
        }
        UsagePing.sendOnce(context, "2026-11-13") { backend }
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
    }

    @Test
    fun unsuccessfulPingPreservesCountersEvenIfItContainsAnAcknowledgementHeader() {
        UsagePing.notePlaybackStarted(context, exo, "clip-a")
        UsagePing.sendOnce(context, "2026-11-13") { Connection(status = 503, acknowledged = true) }
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0))
        assertFalse(prefs.contains(AppConstants.USAGE_PING_LAST_DAY))
    }

    @Test
    fun rateLimitedPingKeepsCountersAndCanRetryAfterTheCooldown() {
        val day = "2026-11-22"
        prefs.edit().putInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 2)
            .putInt(AppConstants.USAGE_UNREPORTED_CRASHES, 1).commit()
        UsagePing.sendOnce(context, day) { Connection(status = 429, retryAfter = "60") }
        assertFalse(prefs.contains(AppConstants.USAGE_PING_LAST_DAY))
        assertEquals(2, prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0))
        assertEquals(1, prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0))
        assertFalse(UsagePing.shouldSendPing(context, day, isDebug = false, emulatorCheck = { false }))

        ShadowSystemClock.advanceBy(Duration.ofSeconds(60))
        assertTrue(UsagePing.shouldSendPing(context, day, isDebug = false, emulatorCheck = { false }))
        UsagePing.sendOnce(context, day) { Connection(acknowledged = true) }
        assertEquals(day, prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null))
        assertEquals(0, prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0))
        assertEquals(0, prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0))
    }

    @Test
    fun freshInstallDefersPingUntilUserInteractsWhileReturningInstallPingsImmediately() {
        assertFalse(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { false }))
        assertFalse(prefs.contains(AppConstants.USAGE_PING_SEED))

        UsagePing.noteUserInteraction(context)
        assertTrue(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { false }))
        assertFalse(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = true, emulatorCheck = { false }))

        prefs.edit().putBoolean(AppConstants.USAGE_STATS_ENABLED, false).commit()
        assertFalse(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { false }))
        prefs.edit().putBoolean(AppConstants.USAGE_STATS_ENABLED, true).commit()

        // Playback start also unlocks a deferred fresh-install ping (e.g. deep-link playback).
        UsagePing.resetInteractionForTests()
        assertFalse(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { false }))
        UsagePing.notePlaybackStarted(context, exo, "stream-deeplink")
        assertTrue(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { false }))

        // Returning install (seed already persisted) does not wait for user interaction.
        UsagePing.resetInteractionForTests()
        prefs.edit().putString(AppConstants.USAGE_PING_SEED, "0123456789abcdef0123456789abcdef").commit()
        assertTrue(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { false }))
    }

    @Test
    fun emulatorDetectionMatchesSdkEmulatorsAndAllowsRealDevices() {
        assertTrue(UsagePing.isLikelyEmulator(product = "SDK_GPHONE64_X86_64", fingerprint = "", hardware = "", model = ""))
        assertTrue(UsagePing.isLikelyEmulator(product = "", fingerprint = "", hardware = "ranchu", model = ""))
        assertTrue(UsagePing.isLikelyEmulator(product = "", fingerprint = "", hardware = "cutf_cvm", model = ""))
        assertTrue(UsagePing.isLikelyEmulator(product = "", fingerprint = "", hardware = "vbox86", model = ""))
        assertTrue(UsagePing.isLikelyEmulator(product = "", fingerprint = "generic/aosp/generic:14", hardware = "", model = ""))
        assertTrue(UsagePing.isLikelyEmulator(product = "", fingerprint = "", hardware = "", model = "Android SDK built for x86"))
        assertFalse(
            UsagePing.isLikelyEmulator(
                product = "CPH2449EEA",
                fingerprint = "OnePlus/CPH2449EEA/OP594DL1:15/UKQ1.230924.001/T.1a2b3c:user/release-keys",
                hardware = "qcom",
                model = "CPH2449",
            )
        )
        UsagePing.noteUserInteraction(context)
        assertFalse(UsagePing.shouldSendPing(context, today = "2026-11-21", isDebug = false, emulatorCheck = { true }))
    }

    @Test
    fun signedInFlagIncludedOnlyForKickOAuthSessions() {
        val signedOutConn = Connection()
        UsagePing.sendOnce(context, "2026-11-22") { signedOutConn }
        val signedOutPayload = Json.parseToJsonElement(signedOutConn.body.toString(Charsets.UTF_8)).jsonObject
        assertFalse(signedOutPayload.containsKey("li"))

        context.tokenPrefs().edit()
            .putString(AppConstants.KICK_USER_LOGIN, "tester")
            .putString(AppConstants.KICK_ACCESS_TOKEN, "kat_google")
            .putString(AppConstants.KICK_LOGIN_METHOD, AppConstants.KICK_LOGIN_METHOD_GOOGLE)
            .commit()
        val googleConn = Connection()
        UsagePing.sendOnce(context, "2026-11-23") { googleConn }
        val googlePayload = Json.parseToJsonElement(googleConn.body.toString(Charsets.UTF_8)).jsonObject
        assertFalse(googlePayload.containsKey("li"))

        context.tokenPrefs().edit()
            .clear()
            .putString(AppConstants.KICK_USER_LOGIN, "tester")
            .putString(AppConstants.KICK_ACCESS_TOKEN, "oauth_access")
            .putString(AppConstants.KICK_REFRESH_TOKEN, "oauth_refresh")
            .commit()
        val oauthConn = Connection()
        UsagePing.sendOnce(context, "2026-11-24") { oauthConn }
        val oauthPayload = Json.parseToJsonElement(oauthConn.body.toString(Charsets.UTF_8)).jsonObject
        assertEquals("true", oauthPayload.getValue("li").jsonPrimitive.content)
        assertFalse(oauthPayload.containsKey("ah"))
    }

    @Test
    fun playbackErrorsDeduplicateWithinCooldownAndReportWithAbiAndLanguage() {
        UsagePing.notePlaybackError(context)
        UsagePing.notePlaybackError(context)
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))

        ShadowSystemClock.advanceBy(Duration.ofSeconds(6))
        UsagePing.notePlaybackError(context)
        assertEquals(2, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))

        val conn = Connection(errorsAcknowledged = true)
        UsagePing.sendOnce(context, "2026-11-25") { conn }
        val payload = conn.payload()
        assertEquals("2", payload.getValue("pb").jsonObject.getValue("count").jsonPrimitive.content)
        assertTrue(payload.getValue("lang").jsonPrimitive.content.matches(Regex("[a-z]{2,3}")))
        assertEquals(0, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))
    }

    @Test
    fun olderBackendRetainsErrorsAndAcknowledgementKeepsNewErrors() {
        UsagePing.notePlaybackError(context)
        val legacy = Connection(acknowledged = true, playbackErrorAckOverride = "1")
        UsagePing.sendOnce(context, "2026-11-25") { legacy }
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))

        val backend = Connection(errorsAcknowledged = true) {
            ShadowSystemClock.advanceBy(Duration.ofSeconds(6))
            UsagePing.notePlaybackError(context)
        }
        UsagePing.sendOnce(context, "2026-11-26") { backend }
        assertEquals(legacy.payload().getValue("pb"), backend.payload().getValue("pb"))
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))
    }

    @Test
    fun lostResponseReusesThePersistedBatchAcrossDays() {
        UsagePing.notePlaybackError(context)
        val lost = Connection { throw IOException("Response lost") }
        UsagePing.sendOnce(context, "2026-11-30") { lost }
        val original = lost.payload().getValue("pb").jsonObject
        assertEquals("2026-11-30", original.getValue("date").jsonPrimitive.content)
        assertTrue(prefs.contains(AppConstants.USAGE_PLAYBACK_ERROR_BATCH))
        assertFalse(prefs.contains(AppConstants.USAGE_PING_LAST_DAY))

        ShadowSystemClock.advanceBy(Duration.ofSeconds(6))
        UsagePing.notePlaybackError(context)
        val recovered = Connection(errorsAcknowledged = true)
        UsagePing.sendOnce(context, "2026-12-01") { recovered }
        assertEquals(original, recovered.payload().getValue("pb"))
        assertEquals(1, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))
        assertFalse(prefs.contains(AppConstants.USAGE_PLAYBACK_ERROR_BATCH))

        val next = Connection(errorsAcknowledged = true)
        UsagePing.sendOnce(context, "2026-12-02") { next }
        val remaining = next.payload().getValue("pb").jsonObject
        assertFalse(original.getValue("id") == remaining.getValue("id"))
        assertEquals("1", remaining.getValue("count").jsonPrimitive.content)
        assertEquals(0, prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0))
    }

    @Test
    fun crashCoverageKeepsTheCrashDayAndBuildAcrossPings() {
        val crash = Instant.parse("2026-10-31T23:59:00Z")
        repeat(2) { UsagePing.noteCrash(context, crash) }
        for (day in listOf("2026-11-01", "2026-11-02", "2026-12-01")) {
            val backend = Connection()
            UsagePing.sendOnce(context, day) { backend }
            val payload = Json.parseToJsonElement(backend.body.toString(Charsets.UTF_8)).jsonObject
            val reports = payload.getValue("cb").jsonArray.map { it.jsonPrimitive.content }
            val report = "2026-10-31|${BuildConfig.VERSION_NAME}|${BuildConfig.VERSION_CODE}"
            assertEquals(if (day == "2026-12-01") emptyList() else listOf(report), reports)
            if (day == "2026-11-01") assertEquals("2", payload.getValue("c").jsonPrimitive.content)
            else assertFalse(payload.containsKey("c"))
        }
    }

    private class Connection(
        private val status: Int = 204,
        private val acknowledged: Boolean = false,
        private val retryAfter: String? = null,
        private val errorsAcknowledged: Boolean = false,
        private val playbackErrorAckOverride: String? = null,
        private val duringResponse: () -> Unit = {},
    ) : HttpURLConnection(URL("https://backend.invalid/v1/metrics/ping")) {
        val body = ByteArrayOutputStream()
        fun payload() = Json.parseToJsonElement(body.toString(Charsets.UTF_8)).jsonObject
        override fun connect() = Unit
        override fun disconnect() = Unit
        override fun usingProxy() = false
        override fun getOutputStream() = body
        override fun getResponseCode(): Int {
            duringResponse()
            return status
        }
        override fun getHeaderField(name: String?): String? = when {
            name.equals("X-Playback-Starts-Accepted", true) && acknowledged -> "1"
            name.equals("X-Playback-Errors-Accepted", true) -> playbackErrorAckOverride ?: if (errorsAcknowledged) {
                payload()["pb"]?.jsonObject?.get("id")?.jsonPrimitive?.content
            } else null
            name.equals("Retry-After", true) -> retryAfter
            else -> null
        }
    }
}
