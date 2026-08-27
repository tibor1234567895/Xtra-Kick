package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDropCampaign
import com.xtrakick.app.model.kick.KickDropReward
import java.util.Calendar
import java.util.TimeZone

/**
 * Pure decision logic for Kick's daily-reward/drops auto-claim flow, ported from the
 * "Kick Auto Claim Daily Reward+" userscript state machine. Kept Android-free so it can be
 * unit-tested on the JVM.
 */
object KickRewardsPolicy {

    const val STATUS_IN_PROGRESS = "in_progress"
    const val STATUS_CLAIMABLE = "claimable"
    const val STATUS_CLAIMED = "claimed"

    /** Grace period added on top of `window.ends_at` before treating the day as rolled over. */
    const val RESET_GRACE_MS = 60_000L

    /** Fallback wall-clock reset used when the API provides no `window.ends_at`: 00:02 UTC. */
    const val FALLBACK_RESET_HOUR = 0
    const val FALLBACK_RESET_MINUTE = 2

    enum class DailyAction {
        ALREADY_CLAIMED,
        CLAIM_NOW,
        WATCH_IN_PROGRESS,

        /** Unknown recurrence/status — do nothing rather than risk claiming the wrong thing. */
        IGNORE,
    }

    fun selectDaily(challenges: List<KickDailyChallenge>): KickDailyChallenge? =
        challenges.firstOrNull { it.recurrence.equals("daily", ignoreCase = true) }

    fun decide(challenge: KickDailyChallenge): DailyAction = when {
        challenge.status.equals(STATUS_CLAIMED, ignoreCase = true) -> DailyAction.ALREADY_CLAIMED
        challenge.status.equals(STATUS_CLAIMABLE, ignoreCase = true) -> DailyAction.CLAIM_NOW
        challenge.status.equals(STATUS_IN_PROGRESS, ignoreCase = true) -> DailyAction.WATCH_IN_PROGRESS
        else -> DailyAction.IGNORE
    }

    /**
     * When the daily reward comes back after being claimed: server-provided `ends_at` (+ grace)
     * or, when unknown, tomorrow 00:02 UTC.
     */
    fun resetTimeMs(challenge: KickDailyChallenge?, nowMillis: Long): Long {
        challenge?.endsAtEpochMs?.let { endsAt ->
            return endsAt + RESET_GRACE_MS
        }
        return fallbackResetMs(nowMillis)
    }

    fun fallbackResetMs(nowMillis: Long): Long {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
            timeInMillis = nowMillis
            add(Calendar.DAY_OF_MONTH, 1)
            set(Calendar.HOUR_OF_DAY, FALLBACK_RESET_HOUR)
            set(Calendar.MINUTE, FALLBACK_RESET_MINUTE)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }

    fun isCampaignActive(campaign: KickDropCampaign): Boolean {
        val status = campaign.status?.lowercase() ?: return true
        return status != "expired" && status != "ended"
    }

    /** Earned-but-unclaimed: reached `required_units` or hit a progress fraction of 1.0+. */
    fun isRewardEarned(campaign: KickDropCampaign, reward: KickDropReward): Boolean {
        if (reward.claimed) return false
        val unitsReached = reward.requiredUnits?.let { campaign.progressUnits >= it } ?: false
        val fractionComplete = reward.progressFraction?.let { it >= 1.0 } ?: false
        return unitsReached || fractionComplete
    }
}