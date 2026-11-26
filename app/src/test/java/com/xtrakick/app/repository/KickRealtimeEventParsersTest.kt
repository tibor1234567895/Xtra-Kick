package com.xtrakick.app.repository

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KickRealtimeEventParsersTest {
    private val parsers = KickRealtimeEventParsers(Json { ignoreUnknownKeys = true })

    @Test
    fun parsesPollUpdateEvent() {
        val payload = """
        {
            "options": [
                {"id": 1, "label": "Option A", "votes": 10},
                {"label": "Option B", "votes": 4}
            ],
            "remaining": 120
        }
        """.trimIndent()

        val poll = parsers.parseKickRealtimePollUpdate("App\\Events\\PollUpdateEvent", payload)

        assertEquals(2, poll?.choices?.size)
        assertEquals("Option A", poll?.choices?.firstOrNull()?.title)
        assertEquals(10, poll?.choices?.firstOrNull()?.totalVotes)
        assertEquals(14, poll?.totalVotes)
        assertEquals("ACTIVE", poll?.status)
        assertEquals(120_000, poll?.remainingMilliseconds)
    }

    @Test
    fun ignoresNonPollEvents() {
        assertNull(parsers.parseKickRealtimePollUpdate("SomethingElse", "{}"))
    }

    @Test
    fun parsesPollDeleteEventAsDeleted() {
        val poll = parsers.parseKickRealtimePollUpdate("App\\Events\\PollDeleteEvent", "{\"poll\": {\"id\": \"p9\"}}")

        assertEquals("p9", poll?.id)
        assertEquals("DELETED", poll?.status)
        assertFalse(poll?.isEnded() == true)
        assertFalse(poll?.isActive() == true)
    }

    @Test
    fun parsesPredictionUpdateWithStatusAndUserVote() {
        val payload = """
        {
            "id": "p1",
            "title": "Match winner",
            "status": "OPEN",
            "duration": 300,
            "outcomes": [
                {"id": "o1", "title": "Yes", "total_points": 100, "total_users": 2},
                {"id": "o2", "title": "No"}
            ],
            "user_vote": {"outcome_id": "o2", "total_vote_amount": 50}
        }
        """.trimIndent()

        val prediction = parsers.parseKickRealtimePredictionUpdate("PredictionCreated", payload)

        assertEquals("OPEN", prediction?.status)
        assertTrue(prediction?.isActive() == true)
        assertFalse(prediction?.isLocked() == true)
        assertEquals(300, prediction?.predictionWindowSeconds)
        assertEquals(2, prediction?.outcomes?.size)
        assertEquals(100, prediction?.outcomes?.firstOrNull()?.totalPoints)
        assertEquals("o2", prediction?.userVote?.outcomeId)
        assertEquals(50, prediction?.userVote?.totalVoteAmount)
    }

    @Test
    fun mapsPredictionEndEventsToStatus() {
        for (prefix in listOf("", "App\\Events\\")) {
            assertEquals("LOCKED", parsers.parseKickRealtimePredictionUpdate("${prefix}PredictionLocked", "{\"a\":1}")?.status)
            assertEquals("RESOLVED", parsers.parseKickRealtimePredictionUpdate("${prefix}PredictionEnded", "{\"a\":1}")?.status)
            assertEquals("RESOLVED", parsers.parseKickRealtimePredictionUpdate("${prefix}PredictionResolved", "{\"a\":1}")?.status)
            assertEquals("CANCELED", parsers.parseKickRealtimePredictionUpdate("${prefix}PredictionCancelled", "{\"a\":1}")?.status)
        }
    }

    @Test
    fun ignoresUnknownPredictionEvents() {
        assertNull(parsers.parseKickRealtimePredictionUpdate("OtherEvent", "{}"))
    }

    @Test
    fun parsesWebPollResponseWrappedInData() {
        val payload = """
        {
            "data": {
                "poll": {
                    "id": "p1",
                    "options": [{"id": 1, "title": "A", "votes": 3}],
                    "remaining": 30
                }
            }
        }
        """.trimIndent()

        val poll = parsers.parseKickWebPollResponse(payload)

        assertEquals("p1", poll?.id)
        assertEquals(1, poll?.choices?.size)
        assertEquals(30_000, poll?.remainingMilliseconds)
    }

    @Test
    fun parsesChannelMoveEventWithDefaults() {
        val payload = """
        {
            "channel": {"slug": "sourcechan", "id": "111"},
            "hosted": {
                "slug": "targetch",
                "username": "TargetCh",
                "id": "222",
                "viewers_count": 350,
                "countdown_seconds": 15,
                "profile_pic": "https://files.kick.com/img"
            }
        }
        """.trimIndent()

        val event = parsers.parseKickChannelMoveEvent("ChatMoveToSupportedChannelEvent", payload)

        assertEquals("targetch", event?.raid?.targetLogin)
        assertEquals("TargetCh", event?.raid?.targetName)
        assertEquals("222", event?.raid?.targetId)
        assertEquals(350, event?.raid?.viewerCount)
        assertEquals(15, event?.raid?.countdownSeconds)
        assertFalse(event?.raid?.openStream == true)
        assertTrue(event?.message.orEmpty().contains("sourcechan moved viewers to TargetCh with 350 viewers"))
        assertTrue(event?.raid?.raidId.orEmpty().startsWith("kick_move:222:"))
        assertEquals("https://files.kick.com/img", event?.raid?.targetProfileImage)
    }

    @Test
    fun channelMoveEventOpenStreamWhenNoCountdown() {
        val payload = """
        {
            "hosted": {"slug": "targetch", "username": "TargetCh", "id": "222"}
        }
        """.trimIndent()

        val event = parsers.parseKickChannelMoveEvent("ChatMoveToSupportedChannelEvent", payload)

        assertEquals(10, event?.raid?.countdownSeconds)
        assertFalse(event?.raid?.openStream == true)
    }

    @Test
    fun ignoresUnrelatedMoveEvents() {
        assertNull(parsers.parseKickChannelMoveEvent("SomeOtherEvent", "{}"))
    }

    @Test
    fun returnsNullForMalformedJson() {
        assertNull(parsers.parseKickRealtimePollUpdate("App\\Events\\PollUpdateEvent", "not json"))
        assertNull(parsers.parseKickRealtimeChannelPointsUpdate("PointsUpdated", "not json"))
    }

    @Test
    fun parsesChannelPointsUpdate() {
        val payload = """
        {
            "reason": "bet_win",
            "points": 150,
            "balance": 1000,
            "user_id": "77",
            "channel_id": "88"
        }
        """.trimIndent()

        val update = parsers.parseKickRealtimeChannelPointsUpdate("PointsUpdated", payload)

        assertEquals("bet_win", update?.reason)
        assertEquals(150, update?.points)
        assertEquals(1000, update?.balance)
        assertEquals("77", update?.userId)
        assertEquals("88", update?.channelId)
    }

    @Test
    fun ignoresNonPointsEvents() {
        assertNull(parsers.parseKickRealtimeChannelPointsUpdate("OtherEvent", "{}"))
    }

    @Test
    fun extractsNestedViewerCount() {
        val payload = """
        {
            "livestream": {
                "data": "{\"viewer_count\": 1234}"
            }
        }
        """.trimIndent()

        assertEquals(1234, parsers.parseKickLivestreamViewerCount("App\\Events\\LivestreamUpdated", payload))
    }

    @Test
    fun ignoresNonLivestreamViewerEvents() {
        assertNull(parsers.parseKickLivestreamViewerCount("OtherEvent", "{\"viewer_count\": 5}"))
        assertNull(parsers.parseKickLivestreamViewerCount(null, "{\"viewer_count\": 5}"))
    }

    @Test
    fun roomStateRefreshDecidesByEventNameAndPayload() {
        assertTrue(parsers.shouldRefreshRoomStateFromRealtimeEvent("ChatroomUpdatedEvent", "not json"))
        assertTrue(parsers.shouldRefreshRoomStateFromRealtimeEvent(null, "{\"slow_mode\": true}"))
        assertFalse(parsers.shouldRefreshRoomStateFromRealtimeEvent(null, "{}"))
        assertFalse(parsers.shouldRefreshRoomStateFromRealtimeEvent(null, "not json"))
    }
}
