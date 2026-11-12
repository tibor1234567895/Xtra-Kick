package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickBrowseLivestream
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.model.kick.KickLivestream
import com.xtrakick.app.util.KickApiHelper
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.time.Instant
import java.util.Locale
import java.util.TimeZone

@Config(application = android.app.Application::class, sdk = [26, 35], qualifiers = "en-rUS")
@RunWith(RobolectricTestRunner::class)
class Issue125RegressionTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun kickLivestreamDeserializesCustomTagsAndLanguageCode() {
        val payload = """
            {
                "id": 12345,
                "session_title": "Grand Theft Auto V",
                "custom_tags": ["English", "Drops", "RP"],
                "language_code": "en",
                "viewer_count": 500
            }
        """.trimIndent()

        val decoded = json.decodeFromString<KickLivestream>(payload)

        assertEquals(listOf("English", "Drops", "RP"), decoded.tags)
        assertEquals("en", decoded.language)
        assertEquals("Grand Theft Auto V", decoded.title)
    }

    @Test
    fun kickBrowseLivestreamDeserializesCustomTagsAndLanguageCode() {
        val payload = """
            {
                "id": "browse_12345",
                "title": "Chill stream",
                "custom_tags": ["Chill", "Music"],
                "language_code": "es",
                "channel": {
                    "id": 999,
                    "slug": "streamer"
                }
            }
        """.trimIndent()

        val decoded = json.decodeFromString<KickBrowseLivestream>(payload)

        assertEquals(listOf("Chill", "Music"), decoded.tags)
        assertEquals("es", decoded.language)
        assertEquals("Chill stream", decoded.title)
    }

    @Test
    fun kickChannelResponseDeserializesPreviousLivestreams() {
        val payload = """
            {
                "id": 1225149,
                "user_id": 1267209,
                "slug": "teststreamer",
                "previous_livestreams": [
                    {
                        "id": 987654,
                        "session_title": "Past Broadcast",
                        "created_at": "2026-11-10T15:30:00.000000Z",
                        "viewer_count": 1200
                    }
                ]
            }
        """.trimIndent()

        val decoded = json.decodeFromString<KickChannelResponse>(payload)

        assertNotNull(decoded.previousLivestreams)
        assertEquals(1, decoded.previousLivestreams?.size)
        assertEquals(987654L, decoded.previousLivestreams?.first()?.id)
        assertEquals("Past Broadcast", decoded.previousLivestreams?.first()?.title)
        assertEquals("2026-11-10T15:30:00.000000Z", decoded.previousLivestreams?.first()?.createdAt)
    }

    @Test
    fun relativeTimeFloorsElapsedUnitsAtBoundaries() {
        val now = Instant.parse("2026-11-12T13:58:00Z").toEpochMilli()
        val cases = listOf(
            0L to "0 minutes ago",
            59_999L to "0 minutes ago",
            60_000L to "1 minute ago",
            119_999L to "1 minute ago",
            120_000L to "2 minutes ago",
            3_599_999L to "59 minutes ago",
            3_600_000L to "1 hour ago",
            7_199_999L to "1 hour ago",
            7_200_000L to "2 hours ago",
            86_399_999L to "23 hours ago",
            86_400_000L to "1 day ago",
            518_399_999L to "5 days ago",
            518_400_000L to "6 days ago",
        )
        for ((elapsed, expected) in cases) {
            val date = Instant.ofEpochMilli(now - elapsed).toString()
            assertEquals("Elapsed milliseconds: $elapsed", expected, KickApiHelper.formatRelativeTimeString(date, now))
        }
    }

    @Test
    fun relativeDaysIgnoreMidnightAndDaylightSavingChanges() {
        val originalZone = TimeZone.getDefault()
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Ljubljana"))
            val now = Instant.parse("2026-10-25T23:30:00Z").toEpochMilli()
            assertEquals("1 day ago", KickApiHelper.formatRelativeTimeString("2026-10-24T23:30:00Z", now))
            assertEquals("5 days ago", KickApiHelper.formatRelativeTimeString("2026-10-20T00:31:00Z", now))
        } finally {
            TimeZone.setDefault(originalZone)
        }
    }

    @Test
    fun olderDatesKeepTheActualCalendarDate() {
        val originalZone = TimeZone.getDefault()
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
            val now = Instant.parse("2026-11-12T13:58:00Z").toEpochMilli()
            assertEquals("Nov 1, 2026", KickApiHelper.formatRelativeTimeString("2026-11-01T18:00:00Z", now))
            assertEquals("Nov 5, 2026", KickApiHelper.formatRelativeTimeString("2026-11-05T13:58:00Z", now))
        } finally {
            TimeZone.setDefault(originalZone)
        }
    }

    @Test
    fun relativeTimeUsesEachSupportedLocale() {
        val originalLocale = Locale.getDefault()
        try {
            val now = Instant.parse("2026-11-12T13:58:00Z").toEpochMilli()
            val expectedByLocale = mapOf(
                "en" to "5 days ago",
                "de" to "vor 5 Tagen",
                "es" to "hace 5 días",
                "pt-BR" to "há 5 dias",
                "tr" to "5 gün önce",
            )
            for ((language, expected) in expectedByLocale) {
                Locale.setDefault(Locale.forLanguageTag(language))
                assertEquals(language, expected, KickApiHelper.formatRelativeTimeString("2026-11-06T14:50:53Z", now))
            }
        } finally {
            Locale.setDefault(originalLocale)
        }
    }

    @Test
    fun relativeTimeRejectsInvalidOrFutureDates() {
        val now = Instant.parse("2026-11-12T13:58:00Z").toEpochMilli()
        assertNull(KickApiHelper.formatRelativeTimeString("invalid", now))
        assertNull(KickApiHelper.formatRelativeTimeString("2026-11-12T13:58:01Z", now))
    }
}
