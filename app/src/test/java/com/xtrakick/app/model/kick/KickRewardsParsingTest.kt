package com.xtrakick.app.model.kick

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickRewardsParsingTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun parsesDataWrappedChallengesWithNumbersIdsAndWinner() {
        val root = json.parseToJsonElement(
            """
            {"data":[{"id":123,"recurrence":"daily","status":"claimable",
              "condition":{"threshold":30,"progress":30},
              "window":{"ends_at":"2026-08-27T00:02:00.000Z"},
              "winner":{"name":"Blue Emote","rarity":"rare","card_url":"https://ext.cdn.kick.com/card.png"}}],
             "message":"ok"}
            """.trimIndent(),
        )

        val challenges = KickRewardsParsing.parseChallenges(root)

        assertEquals(1, challenges.size)
        val challenge = challenges[0]
        assertEquals("123", challenge.id)
        assertEquals("daily", challenge.recurrence)
        assertEquals("claimable", challenge.status)
        assertEquals(30L, challenge.thresholdMinutes)
        assertEquals(30L, challenge.progressMinutes)
        assertEquals(0L, challenge.remainingMinutes)
        assertEquals("Blue Emote", challenge.winnerName)
        assertEquals("rare", challenge.winnerRarity)
        assertEquals("https://ext.cdn.kick.com/card.png", challenge.winnerCardUrl)
        assertEquals(KickRewardsParsing.parseIsoTimestampMs("2026-08-27T00:02:00.000Z"), challenge.endsAtEpochMs)
    }

    @Test
    fun parsesBareArrayEnvelopesToo() {
        val root = json.parseToJsonElement(
            """[{"id":"abc","status":"in_progress","condition":{"threshold":20,"progress":5}}]""",
        )

        val challenge = KickRewardsParsing.parseChallenges(root).single()

        assertEquals("abc", challenge.id)
        assertEquals(15L, challenge.remainingMinutes)
        assertNull(challenge.endsAtEpochMs)
        assertNull(challenge.winnerName)
    }

    @Test
    fun entriesWithoutIdsAreSkippedInsteadOfCrashing() {
        val root = json.parseToJsonElement("""{"data":[{"status":"claimable"},{"id":"42"}]}""")

        val challenges = KickRewardsParsing.parseChallenges(root)

        assertEquals(listOf("42"), challenges.map { it.id })
    }

    @Test
    fun parsesDailyClaimRouletteWinnerAndStreak() {
        val claimRoot = json.parseToJsonElement(
            """
            {"data":{"challenge_id":"daily-1","roulette":[
              {"id":"badge-1","item_url":"https://ext.cdn.kick.com/badge.png"},
              {"id":"emote-2","item_url":"https://ext.cdn.kick.com/emote.png"}],
              "winner":{"id":"emote-2","card_url":"https://ext.cdn.kick.com/card.png","rarity":"rare"}},
             "message":"success"}
            """.trimIndent(),
        )

        val result = KickRewardsParsing.parseDailyClaim(claimRoot)

        assertEquals("daily-1", result.challengeId)
        assertEquals(listOf("badge-1", "emote-2"), result.roulette.map { it.id })
        assertEquals("https://ext.cdn.kick.com/emote.png", result.roulette[1].itemUrl)
        assertEquals("emote-2", result.winner?.id)
        assertEquals("https://ext.cdn.kick.com/card.png", result.winner?.cardUrl)
        assertEquals("rare", result.winner?.rarity)

        val streakRoot = json.parseToJsonElement("""{"data":{"length_days":2},"message":"success"}""")
        assertEquals(2L, KickRewardsParsing.parseStreakLengthDays(streakRoot))
    }

    @Test
    fun winnerFallsBackThroughNameLikeKeysIncludingRewardWrapper() {
        val root = json.parseToJsonElement(
            """{"data":[{"id":1,"winner":{"emote_name":"Kappa"},"reward":{"title":"Gold Badge","rarity":"legendary"}}]}""",
        )

        val challenge = KickRewardsParsing.parseChallenges(root).single()

        assertEquals("Kappa", challenge.winnerName)
        assertNull(challenge.winnerRarity)
    }

    @Test
    fun parsesDropCampaignsWithNumericStringsAndFractions() {
        val root = json.parseToJsonElement(
            """
            {"data":[
              {"id":"camp1","name":"Lottery","status":"active","progress_units":"12.0",
               "rewards":[
                 {"id":"rw1","name":"Ticket","claimed":false,"required_units":10},
                 {"id":"rw2","name":"Done","claimed":false,"progress":1},
                 {"id":"rw3","name":"Taken","claimed":true,"required_units":10}]},
              {"id":"camp2","campaign_name":"Old Drop","status":"expired",
               "rewards":[{"id":"rw4","claimed":false,"required_units":1}]}
            ]}
            """.trimIndent(),
        )

        val campaigns = KickRewardsParsing.parseDropCampaigns(root)

        assertEquals(2, campaigns.size)
        val lottery = campaigns[0]
        assertEquals("camp1", lottery.id)
        assertEquals("Lottery", lottery.name)
        assertEquals(12L, lottery.progressUnits)
        assertEquals(3, lottery.rewards.size)
        assertEquals(false, lottery.rewards[0].claimed)
        assertEquals(10L, lottery.rewards[0].requiredUnits)
        assertEquals(1.0, lottery.rewards[1].progressFraction!!, 0.0)
        assertEquals(true, lottery.rewards[2].claimed)
        assertEquals("Old Drop", campaigns[1].name)
    }

    @Test
    fun isoTimestampVariantsAllParseAndGarbageYieldsNull() {
        assertEquals(1_793_289_720_000L > 0L, KickRewardsParsing.parseIsoTimestampMs("2026-08-27T00:02:00Z")!! > 0L)
        assertEquals(
            KickRewardsParsing.parseIsoTimestampMs("2026-08-27T00:02:00.000Z"),
            KickRewardsParsing.parseIsoTimestampMs("2026-08-27T02:02:00+02:00"),
        )
        assertNull(KickRewardsParsing.parseIsoTimestampMs(""))
        assertNull(KickRewardsParsing.parseIsoTimestampMs("not-a-date"))
    }
}
