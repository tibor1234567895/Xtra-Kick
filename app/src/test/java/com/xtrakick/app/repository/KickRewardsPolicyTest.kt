package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDropCampaign
import com.xtrakick.app.model.kick.KickDropReward
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar
import java.util.TimeZone

class KickRewardsPolicyTest {

    private fun challenge(
        status: String? = "in_progress",
        recurrence: String? = "daily",
        endsAtEpochMs: Long? = null,
        thresholdMinutes: Long? = null,
        progressMinutes: Long? = null,
    ) = KickDailyChallenge(
        id = "1",
        status = status,
        recurrence = recurrence,
        thresholdMinutes = thresholdMinutes,
        progressMinutes = progressMinutes,
        endsAtEpochMs = endsAtEpochMs,
        winnerName = null,
        winnerRarity = null,
        winnerCardUrl = null,
    )

    private fun utcCalendar(year: Int, month: Int, day: Int, hour: Int, minute: Int): Calendar =
        Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
            clear()
            set(year, month - 1, day, hour, minute, 0)
        }

    @Test
    fun selectDailyPicksTheDailyRecurrenceAmongOthers() {
        val weekly = challenge(recurrence = "weekly")
        val daily = challenge(status = "claimable", recurrence = "daily")

        assertEquals(daily, KickRewardsPolicy.selectDaily(listOf(weekly, daily)))
    }

    @Test
    fun selectDailyReturnsNullWhenNoDailyExists() {
        assertNull(KickRewardsPolicy.selectDaily(listOf(challenge(recurrence = "weekly"))))
        assertNull(KickRewardsPolicy.selectDaily(emptyList()))
    }

    @Test
    fun decideMapsKnownStatusesAndIgnoresUnknownOnes() {
        assertEquals(KickRewardsPolicy.DailyAction.ALREADY_CLAIMED, KickRewardsPolicy.decide(challenge(status = "claimed")))
        assertEquals(KickRewardsPolicy.DailyAction.CLAIM_NOW, KickRewardsPolicy.decide(challenge(status = "claimable")))
        assertEquals(
            KickRewardsPolicy.DailyAction.WATCH_IN_PROGRESS,
            KickRewardsPolicy.decide(challenge(status = "in_progress")),
        )
        assertEquals(KickRewardsPolicy.DailyAction.IGNORE, KickRewardsPolicy.decide(challenge(status = "paused")))
        assertEquals(KickRewardsPolicy.DailyAction.IGNORE, KickRewardsPolicy.decide(challenge(status = null)))
    }

    @Test
    fun resetTimeAddsGraceToServerProvidedWindow() {
        val reset = KickRewardsPolicy.resetTimeMs(challenge(endsAtEpochMs = 1_787_000_000_000L), nowMillis = 0L)

        assertEquals(1_787_000_000_000L + KickRewardsPolicy.RESET_GRACE_MS, reset)
    }

    @Test
    fun fallbackResetIsTomorrowAt0002Utc() {
        val now = utcCalendar(2026, 8, 26, 18, 45).timeInMillis

        val expected = utcCalendar(2026, 8, 27, 0, 2).timeInMillis
        assertEquals(expected, KickRewardsPolicy.fallbackResetMs(now))

        // Just before midnight rolls over to the correct following day, 00:02 UTC.
        val lateNight = utcCalendar(2026, 8, 26, 23, 59).timeInMillis
        val expectedLate = utcCalendar(2026, 8, 27, 0, 2).timeInMillis
        assertEquals(expectedLate, KickRewardsPolicy.fallbackResetMs(lateNight))

        // Right before midnight UTC with a large local offset still resolves in UTC space.
        val justBeforeMidnight = utcCalendar(2026, 8, 26, 23, 58).timeInMillis
        assertEquals(expectedLate, KickRewardsPolicy.fallbackResetMs(justBeforeMidnight))
        assertEquals(expectedLate, KickRewardsPolicy.resetTimeMs(null, justBeforeMidnight))
    }

    @Test
    fun expiredAndEndedCampaignsAreInactive() {
        assertTrue(KickRewardsPolicy.isCampaignActive(KickDropCampaign("c1", null, "active", 0, emptyList())))
        assertTrue(KickRewardsPolicy.isCampaignActive(KickDropCampaign("c2", null, null, 0, emptyList())))
        assertFalse(KickRewardsPolicy.isCampaignActive(KickDropCampaign("c3", null, "expired", 0, emptyList())))
        assertFalse(KickRewardsPolicy.isCampaignActive(KickDropCampaign("c4", null, "Ended", 0, emptyList())))
    }

    @Test
    fun dropRewardIsEarnedOnlyWhenUnclaimedAndProgressReached() {
        val campaign = KickDropCampaign("c1", null, "active", progressUnits = 10, rewards = emptyList())

        assertTrue(
            KickRewardsPolicy.isRewardEarned(
                campaign,
                KickDropReward("r1", null, claimed = false, requiredUnits = 10, progressFraction = null),
            ),
        )
        assertTrue(
            KickRewardsPolicy.isRewardEarned(
                campaign,
                KickDropReward("r2", null, claimed = false, requiredUnits = null, progressFraction = 1.0),
            ),
        )
        assertFalse(
            KickRewardsPolicy.isRewardEarned(
                campaign,
                KickDropReward("r3", null, claimed = true, requiredUnits = 10, progressFraction = null),
            ),
        )
        assertFalse(
            KickRewardsPolicy.isRewardEarned(
                campaign,
                KickDropReward("r4", null, claimed = false, requiredUnits = 11, progressFraction = 0.9),
            ),
        )
        assertFalse(
            KickRewardsPolicy.isRewardEarned(
                campaign,
                KickDropReward("r5", null, claimed = false, requiredUnits = null, progressFraction = null),
            ),
        )
    }
}
