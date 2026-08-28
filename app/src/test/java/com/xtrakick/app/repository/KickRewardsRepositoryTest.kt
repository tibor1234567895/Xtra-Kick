package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickDailyChallenge
import org.junit.Assert.assertEquals
import org.junit.Test

class KickRewardsRepositoryTest {

    @Test
    fun verifiesConfiguredRewardsPollIntervalIs120Seconds() {
        assertEquals(120_000L, KickRewardsRepository.REWARDS_POLL_INTERVAL_MS)
    }

    @Test
    fun verifiesChallengeCountdownProgression() {
        val challenge = KickDailyChallenge(
            id = "daily_1",
            status = "in_progress",
            recurrence = "daily",
            thresholdMinutes = 15,
            progressMinutes = 5,
            endsAtEpochMs = System.currentTimeMillis() + 3_600_000L,
            winnerName = null,
            winnerRarity = null,
            winnerCardUrl = null
        )

        assertEquals(10L, challenge.remainingMinutes)
        assertEquals(KickRewardsPolicy.DailyAction.WATCH_IN_PROGRESS, KickRewardsPolicy.decide(challenge))

        val claimableChallenge = KickDailyChallenge(
            id = "daily_1",
            status = "claimable",
            recurrence = "daily",
            thresholdMinutes = 15,
            progressMinutes = 15,
            endsAtEpochMs = System.currentTimeMillis() + 3_600_000L,
            winnerName = null,
            winnerRarity = null,
            winnerCardUrl = null
        )

        assertEquals(0L, claimableChallenge.remainingMinutes)
        assertEquals(KickRewardsPolicy.DailyAction.CLAIM_NOW, KickRewardsPolicy.decide(claimableChallenge))

        val claimedChallenge = KickDailyChallenge(
            id = "daily_1",
            status = "claimed",
            recurrence = "daily",
            thresholdMinutes = 15,
            progressMinutes = 15,
            endsAtEpochMs = System.currentTimeMillis() + 3_600_000L,
            winnerName = "Emote Pack",
            winnerRarity = "rare",
            winnerCardUrl = "https://kick.com/rewards/card.png"
        )
        assertEquals(0L, claimedChallenge.remainingMinutes)
        assertEquals(KickRewardsPolicy.DailyAction.ALREADY_CLAIMED, KickRewardsPolicy.decide(claimedChallenge))

        val overProgressChallenge = KickDailyChallenge(
            id = "daily_1",
            status = "in_progress",
            recurrence = "daily",
            thresholdMinutes = 15,
            progressMinutes = 20,
            endsAtEpochMs = null,
            winnerName = null,
            winnerRarity = null,
            winnerCardUrl = null
        )
        assertEquals(0L, overProgressChallenge.remainingMinutes)
    }
}
