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
    fun parsesSeasonalAndFeaturedChallengeWithCustomName() {
        val root = json.parseToJsonElement(
            """
            {"data":[{"id":"halloween-1","name":"Halloween Crate","featured":true,"recurrence":"seasonal","status":"in_progress",
              "condition":{"threshold":60,"progress":25},
              "window":{"ends_at":"2026-11-01T00:00:00.000Z"}}]}
            """.trimIndent(),
        )

        val challenge = KickRewardsParsing.parseChallenges(root).single()
        assertEquals("halloween-1", challenge.id)
        assertEquals("Halloween Crate", challenge.name)
        assertEquals(true, challenge.featured)
        assertEquals("seasonal", challenge.recurrence)
        assertEquals("in_progress", challenge.status)
        assertEquals(35L, challenge.remainingMinutes)
    }

    @Test
    fun parsesAnimationsDropTableAndActivePeriod() {
        val root = json.parseToJsonElement(
            """
            {"data":[{
              "id":"halloween-crate",
              "name":"Trick or Treat",
              "description":"Claim your Trick or Treat for a chance to win big!",
              "animations":{
                "idle_url":"https://static.kick.com/rewards/halloween-2610/idle",
                "unbox_url":"https://static.kick.com/rewards/halloween-2610/unbox"
              },
              "drop_table":[
                {"rarity":"common","weighting":500},
                {"rarity":"uncommon","weighting":300},
                {"rarity":"rare","weighting":197},
                {"rarity":"mythic","weighting":3}
              ],
              "active_period":{"ends_at":"2026-11-01T00:00:00Z","starts_at":"2026-10-26T00:00:00Z"},
              "condition":{"progress":2,"threshold":180}
            }]}
            """.trimIndent(),
        )

        val challenge = KickRewardsParsing.parseChallenges(root).single()
        assertEquals("Trick or Treat", challenge.name)
        assertEquals("Claim your Trick or Treat for a chance to win big!", challenge.description)
        assertEquals("https://static.kick.com/rewards/halloween-2610/idle.gif", challenge.idleAnimationUrl)
        assertEquals("https://static.kick.com/rewards/halloween-2610/unbox.gif", challenge.unboxAnimationUrl)
        assertEquals(KickRewardsParsing.parseIsoTimestampMs("2026-11-01T00:00:00Z"), challenge.activePeriodEndsAtEpochMs)

        assertEquals(4, challenge.dropTable.size)
        assertEquals("common", challenge.dropTable[0].rarity)
        assertEquals("50%", challenge.dropTable[0].percentageFormatted)
        assertEquals("uncommon", challenge.dropTable[1].rarity)
        assertEquals("30%", challenge.dropTable[1].percentageFormatted)
        assertEquals("rare", challenge.dropTable[2].rarity)
        assertEquals("19.7%", challenge.dropTable[2].percentageFormatted)
        assertEquals("mythic", challenge.dropTable[3].rarity)
        assertEquals("0.3%", challenge.dropTable[3].percentageFormatted)
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
    fun parsesTrickOrTreatWithEmptyCardUrlAndThumbnailUrlFallback() {
        val root = json.parseToJsonElement(
            """
            {"data":[{
              "active_period":{"ends_at":"2026-11-01T00:00:00Z","starts_at":"2026-10-24T00:00:00Z"},
              "animations":{
                "idle_url":"https://static.kick.com/rewards/halloween-2610/idle",
                "unbox_url":"https://static.kick.com/rewards/halloween-2610/unbox"
              },
              "claimed_at":"2026-10-29T17:14:38.405311Z",
              "condition":{"progress":180,"threshold":180,"type":"watch_time_minutes"},
              "description":"Claim your Trick or Treat for a chance to win big! Exclusive prizes are up for grabs.",
              "drop_table":[{"rarity":"common","weighting":500},{"rarity":"uncommon","weighting":300}],
              "featured":true,
              "id":"01a16227-e181-727c-ac25-a441263e2e4a",
              "name":"Trick or Treat",
              "recurrence":"daily",
              "status":"claimed",
              "window":{"ends_at":"2026-10-30T00:00:00Z","starts_at":"2026-10-29T00:00:00Z"},
              "winner":{
                "card_url":"",
                "id":"01a16236-6075-7169-8586-62b8aadc0403",
                "rarity":"rare",
                "thumbnail_url":"https://content.kick.com/public/rewards/thumbnails/01a16236-22b5-7b17-9e40-26f7299f9403.webp"
              }
            }]}
            """.trimIndent(),
        )

        val challenge = KickRewardsParsing.parseChallenges(root).single()
        assertEquals("01a16227-e181-727c-ac25-a441263e2e4a", challenge.id)
        assertEquals("Trick or Treat", challenge.name)
        assertEquals(true, challenge.featured)
        assertEquals("claimed", challenge.status)
        assertEquals("rare", challenge.winnerRarity)
        assertEquals(
            "https://content.kick.com/public/rewards/thumbnails/01a16236-22b5-7b17-9e40-26f7299f9403.webp",
            challenge.winnerCardUrl,
        )
        assertEquals(
            "https://content.kick.com/public/rewards/thumbnails/01a16236-22b5-7b17-9e40-26f7299f9403.webp",
            challenge.winnerThumbnailUrl,
        )
    }

    @Test
    fun parsesClaimResultWithEmptyCardUrlAndThumbnailUrlFallback() {
        val root = json.parseToJsonElement(
            """
            {"data":{
              "challenge_id":"01a16227-e181-727c-ac25-a441263e2e4a",
              "roulette":[{"id":"r1","thumbnail_url":"https://content.kick.com/reel1.webp"}],
              "winner":{
                "card_url":"",
                "id":"01a16236-6075-7169-8586-62b8aadc0403",
                "rarity":"rare",
                "thumbnail_url":"https://content.kick.com/public/rewards/thumbnails/pumpkin.webp"
              }
            }}
            """.trimIndent(),
        )

        val result = KickRewardsParsing.parseDailyClaim(root)
        assertEquals("01a16227-e181-727c-ac25-a441263e2e4a", result.challengeId)
        assertEquals("https://content.kick.com/reel1.webp", result.roulette.single().itemUrl)
        assertEquals("https://content.kick.com/public/rewards/thumbnails/pumpkin.webp", result.winner?.cardUrl)
        assertEquals("https://content.kick.com/public/rewards/thumbnails/pumpkin.webp", result.winner?.thumbnailUrl)
        assertEquals("rare", result.winner?.rarity)
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

    @Test
    fun parsesAllDropCampaignsWithProgressMerge() {
        val root = json.parseToJsonElement(
            """
            {
              "data": [
                {
                  "id": "camp-cod",
                  "name": "Modern Warfare 4",
                  "status": "active",
                  "starts_at": "2026-10-23T00:00:00Z",
                  "ends_at": "2026-11-23T00:00:00Z",
                  "connect_url": "https://kick.com/connect",
                  "url": "https://kick.com/category/call-of-duty-modern-warfare-4",
                  "rule": { "id": 1, "name": "Watch to redeem" },
                  "category": {
                    "id": 14138,
                    "name": "Call of Duty: Modern Warfare 4",
                    "slug": "call-of-duty-modern-warfare-4",
                    "image_url": "https://files.kick.com/banner.png",
                    "banner_image_url": "https://files.kick.com/wide_banner.png"
                  },
                  "organization": {
                    "id": "org-kick",
                    "name": "KICK",
                    "logo_url": "https://ext.kick.com/logo.png",
                    "url": "https://about.kick.com/",
                    "restricted": false
                  },
                  "channels": ["streamer1", "streamer2"],
                  "rewards": [
                    {
                      "id": "rw-1",
                      "name": "Ghost Badge",
                      "required_units": 3000,
                      "category_id": 14138,
                      "organization_id": "org-kick",
                      "image_url": "drops/reward-image/ghost.png"
                    }
                  ]
                }
              ]
            }
            """.trimIndent(),
        )

        val userProgress = listOf(
            KickDropCampaign(
                id = "camp-cod",
                name = "Modern Warfare 4",
                status = "active",
                progressUnits = 1500L,
                rewards = listOf(
                    KickDropReward(
                        id = "rw-1",
                        name = "Ghost Badge",
                        claimed = false,
                        requiredUnits = 3000L,
                        progressFraction = 0.5,
                    ),
                ),
            ),
        )

        val campaigns = KickRewardsParsing.parseAllDropCampaigns(root, userProgress)
        assertEquals(1, campaigns.size)
        val campaign = campaigns[0]
        assertEquals("camp-cod", campaign.id)
        assertEquals("Modern Warfare 4", campaign.name)
        assertEquals(true, campaign.isActive)
        assertEquals(false, campaign.isUpcoming)
        assertEquals("Call of Duty: Modern Warfare 4", campaign.category?.name)
        assertEquals("KICK", campaign.organization?.name)
        assertEquals(listOf("streamer1", "streamer2"), campaign.channels)

        assertEquals(1, campaign.rewards.size)
        val reward = campaign.rewards[0]
        assertEquals("rw-1", reward.id)
        assertEquals("Ghost Badge", reward.name)
        assertEquals("https://ext.cdn.kick.com/drops/reward-image/ghost.png", reward.resolvedImageUrl)
        assertEquals(1500L, reward.currentUnits)
        assertEquals(0.5, reward.progressFraction, 0.001)
        assertEquals(false, reward.claimed)
        assertEquals(false, reward.isClaimable)
        assertEquals(true, campaign.hasProgress)
        assertEquals(true, campaign.isChannelSpecific)
        assertEquals(false, campaign.isCategoryWide)
        assertEquals(2, campaign.participatingChannels.size)
        assertEquals("streamer1", campaign.participatingChannels[0].slug)
    }

    @Test
    fun parsesCampaignWithObjectChannelsAndLivestreams() {
        val root = json.parseToJsonElement(
            """
            {
              "data": [
                {
                  "id": "camp-partner",
                  "name": "Partner Exclusive Event",
                  "status": "active",
                  "channels": [
                    {
                      "slug": "trainwreckstv",
                      "user": {
                        "username": "Trainwreck",
                        "profile_picture": "https://cdn.kick.com/train.png"
                      }
                    }
                  ],
                  "rewards": []
                }
              ]
            }
            """.trimIndent(),
        )

        val campaigns = KickRewardsParsing.parseAllDropCampaigns(root)
        assertEquals(1, campaigns.size)
        val campaign = campaigns[0]
        assertEquals(true, campaign.isChannelSpecific)
        assertEquals(listOf("trainwreckstv"), campaign.channels)
        assertEquals(1, campaign.participatingChannels.size)
        assertEquals("trainwreckstv", campaign.participatingChannels[0].slug)
        assertEquals("Trainwreck", campaign.participatingChannels[0].username)
        assertEquals("https://cdn.kick.com/train.png", campaign.participatingChannels[0].profilePicture)

        // Test parsing campaign livestreams endpoint response
        val livestreamsRoot = json.parseToJsonElement(
            """
            {
              "data": [
                {
                  "id": "live-1",
                  "channel": {
                    "slug": "trainwreckstv",
                    "user": {
                      "username": "Trainwreck",
                      "profile_picture": "https://cdn.kick.com/train.png"
                    }
                  }
                }
              ]
            }
            """.trimIndent(),
        )
        val liveChannels = KickRewardsParsing.parseCampaignLivestreams(livestreamsRoot)
        assertEquals(1, liveChannels.size)
        assertEquals("trainwreckstv", liveChannels[0].slug)
        assertEquals(true, liveChannels[0].isLive)
    }

    @Test
    fun parsesCollectiblesInventoryWithOddsAndRarity() {
        val root = json.parseToJsonElement(
            """
            {
              "data": [
                {
                  "id": "col-1",
                  "name": "Unikorn Emote",
                  "rarity": "mythic",
                  "owned": true,
                  "card_url": "https://content.kick.com/cards/unikorn.webp",
                  "thumbnail_url": "https://content.kick.com/thumb/unikorn.webp",
                  "unlocked_at": "2026-10-25T12:00:00Z",
                  "drop_table": [
                    { "rarity": "common", "weighting": 500 },
                    { "rarity": "mythic", "weighting": 5 }
                  ]
                },
                {
                  "id": "col-2",
                  "name": "Standard Kappa",
                  "rarity": "common",
                  "owned": false,
                  "card_url": "https://content.kick.com/cards/kappa.webp"
                }
              ]
            }
            """.trimIndent(),
        )

        val collectibles = KickRewardsParsing.parseCollectibles(root)
        assertEquals(2, collectibles.size)

        val mythic = collectibles[0]
        assertEquals("col-1", mythic.id)
        assertEquals("Unikorn Emote", mythic.name)
        assertEquals("mythic", mythic.rarity)
        assertEquals(0, mythic.rarityRank)
        assertEquals(true, mythic.owned)
        assertEquals("https://content.kick.com/cards/unikorn.webp?width=300&format=png", mythic.resolvedCardUrl)
        assertEquals(2, mythic.dropTable.size)

        val common = collectibles[1]
        assertEquals("col-2", common.id)
        assertEquals("common", common.rarity)
        assertEquals(5, common.rarityRank)
        assertEquals(false, common.owned)
    }

    @Test
    fun parsesUserLevelAndProgression() {
        val root = json.parseToJsonElement(
            """
            {
              "data": {
                "level": 14,
                "current_xp": 1450,
                "next_level_xp": 2000,
                "progress_percentage": 72.5
              }
            }
            """.trimIndent(),
        )

        val userLevel = KickRewardsParsing.parseUserLevel(root)
        assertEquals(14, userLevel?.level)
        assertEquals(1450L, userLevel?.currentXp)
        assertEquals(2000L, userLevel?.nextLevelXp)
        assertEquals(72.5, userLevel?.progressPercentage ?: 0.0, 0.001)
    }
}
