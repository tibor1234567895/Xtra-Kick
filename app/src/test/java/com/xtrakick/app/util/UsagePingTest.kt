package com.xtrakick.app.util

import android.app.Application
import com.xtrakick.app.ui.player.KickLivePlayback
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowSystemClock
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.time.Duration

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
        UsagePing.notePlaybackEnded(ivs)
        UsagePing.notePlaybackEnded(exo)
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

    private class Connection(
        private val status: Int = 204,
        private val acknowledged: Boolean = false,
        private val duringResponse: () -> Unit = {},
    ) : HttpURLConnection(URL("https://backend.invalid/v1/metrics/ping")) {
        val body = ByteArrayOutputStream()
        override fun connect() = Unit
        override fun disconnect() = Unit
        override fun usingProxy() = false
        override fun getOutputStream() = body
        override fun getResponseCode(): Int {
            duringResponse()
            return status
        }
        override fun getHeaderField(name: String?): String? =
            if (name.equals("X-Playback-Starts-Accepted", true) && acknowledged) "1" else null
    }
}
