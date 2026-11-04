package com.xtrakick.app.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.repository.KickRewardsPolicy
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Auto-claims Kick's daily reward roulette and finished drop campaigns, ported from the
 * behavior of the "Kick Auto Claim Daily Reward+" userscript: poll state, claim when ready
 * with human-like jitter, persist claimed-until/backoff markers, optionally notify.
 */
@HiltWorker
class RewardClaimWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted parameters: WorkerParameters,
    private val rewardsRepository: KickRewardsRepository,
) : CoroutineWorker(context, parameters) {

    override suspend fun doWork(): Result {
        val prefs = applicationContext.prefs()
        if (!prefs.getBoolean(AppConstants.KICK_DAILY_REWARDS_ENABLED, true) ||
            !prefs.getBoolean(AppConstants.REWARD_AUTO_CLAIM_ENABLED, false)
        ) {
            return Result.success()
        }
        if (!rewardsRepository.canAttemptClaims()) {
            Log.d(TAG, "no usable kick web session, skipping")
            return Result.success()
        }
        handleDailyClaim(prefs)
        handleDropClaims(prefs)
        return Result.success()
    }

    // ------------------------------------------------------------- daily reward

    private suspend fun handleDailyClaim(prefs: SharedPreferences) {
        val now = System.currentTimeMillis()
        if (now < prefs.getLong(AppConstants.REWARD_DAILY_BACKOFF_UNTIL, 0L)) return
        val claimedUntil = prefs.getLong(AppConstants.REWARD_DAILY_CLAIMED_UNTIL, 0L)
        if (now < claimedUntil) {
            RewardClaimScheduler.followUp(applicationContext, claimedUntil - now)
            return
        }
        val challenges = try {
            rewardsRepository.getDailyChallenges()
        } catch (e: Exception) {
            Log.w(TAG, "daily challenges fetch failed: ${e.message}")
            enterBackoff(prefs, AppConstants.REWARD_DAILY_BACKOFF_UNTIL)
            return
        }
        val claimable = challenges.firstOrNull { KickRewardsPolicy.decide(it) == KickRewardsPolicy.DailyAction.CLAIM_NOW }
        if (claimable != null) {
            claimDailyNow(prefs, claimable)
            return
        }
        val challenge = KickRewardsPolicy.selectDaily(challenges) ?: run {
            Log.i(TAG, "no daily challenge present")
            return
        }
        when (KickRewardsPolicy.decide(challenge)) {
            KickRewardsPolicy.DailyAction.ALREADY_CLAIMED -> markDailyClaimed(prefs, challenge)
            KickRewardsPolicy.DailyAction.CLAIM_NOW -> claimDailyNow(prefs, challenge)
            KickRewardsPolicy.DailyAction.WATCH_IN_PROGRESS -> onWatchInProgress(challenge)
            KickRewardsPolicy.DailyAction.IGNORE -> Log.i(TAG, "unexpected challenge status=${challenge.status}")
        }
    }

    private suspend fun markDailyClaimed(prefs: SharedPreferences, challenge: KickDailyChallenge) {
        val isStandardDaily = challenge.recurrence.equals("daily", ignoreCase = true) && !challenge.featured
        val reset = KickRewardsPolicy.resetTimeMs(challenge, System.currentTimeMillis())
        val nameKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_NAME else "${AppConstants.REWARD_LAST_DAILY_NAME}_${challenge.id}"
        val rarityKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_RARITY else "${AppConstants.REWARD_LAST_DAILY_RARITY}_${challenge.id}"
        val cardKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_CARD_URL else "${AppConstants.REWARD_LAST_DAILY_CARD_URL}_${challenge.id}"

        prefs.edit {
            challenge.winnerName?.let { putString(nameKey, it) }
            challenge.winnerRarity?.let { putString(rarityKey, it) }
            challenge.winnerCardUrl?.let { putString(cardKey, it) }
            if (isStandardDaily) {
                putLong(AppConstants.REWARD_DAILY_CLAIMED_UNTIL, reset)
            }
        }
        if (isStandardDaily) {
            Log.i(TAG, "daily already claimed, sleeping until $reset")
            RewardClaimScheduler.followUp(applicationContext, reset - System.currentTimeMillis())
        }
    }

    private suspend fun claimDailyNow(prefs: SharedPreferences, challenge: KickDailyChallenge) {
        delay(Random.nextLong(CLAIM_JITTER_MIN_MS, CLAIM_JITTER_MAX_MS))
        if (!applicationContext.prefs().getBoolean(AppConstants.REWARD_AUTO_CLAIM_ENABLED, false)) return
        val claimResult = try {
            rewardsRepository.claimDailyChallenge(challenge.id)
        } catch (e: Exception) {
            Log.w(TAG, "daily claim failed: ${e.message}")
            enterBackoff(prefs, AppConstants.REWARD_DAILY_BACKOFF_UNTIL)
            return
        }
        // Refresh for the reset window and human-readable winner name. The POST carries the
        // authoritative roulette winner and rarity.
        val refreshed = runCatching { rewardsRepository.getDailyChallenges() }.getOrNull()
            ?.let { challenges -> challenges.firstOrNull { it.id == challenge.id } ?: KickRewardsPolicy.selectDaily(challenges) }
        val outcome = refreshed ?: challenge
        val name = outcome.winnerName?.takeIf { it.isNotBlank() }
        val rarity = claimResult.winner?.rarity?.takeIf { it.isNotBlank() }
            ?: outcome.winnerRarity?.takeIf { it.isNotBlank() }
        val isStandardDaily = outcome.recurrence.equals("daily", ignoreCase = true) && !outcome.featured
        val reset = if (isStandardDaily) KickRewardsPolicy.resetTimeMs(outcome, System.currentTimeMillis()) else null
        val nameKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_NAME else "${AppConstants.REWARD_LAST_DAILY_NAME}_${challenge.id}"
        val rarityKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_RARITY else "${AppConstants.REWARD_LAST_DAILY_RARITY}_${challenge.id}"
        val cardKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_CARD_URL else "${AppConstants.REWARD_LAST_DAILY_CARD_URL}_${challenge.id}"

        prefs.edit {
            reset?.let { putLong(AppConstants.REWARD_DAILY_CLAIMED_UNTIL, it) }
            putString(nameKey, name)
            rarity?.let { putString(rarityKey, it) }
            claimResult.winner?.cardUrl?.let { putString(cardKey, it) }
            putLong(AppConstants.REWARD_LAST_CLAIM_AT, System.currentTimeMillis())
            remove(AppConstants.REWARD_DAILY_BACKOFF_UNTIL)
        }
        Log.i(TAG, "reward claimed name=$name rarity=$rarity isStandardDaily=$isStandardDaily reset=$reset")
        RewardClaimNotifier.dailyClaimed(applicationContext, name, rarity)
        if (isStandardDaily && reset != null) {
            RewardClaimScheduler.followUp(applicationContext, reset - System.currentTimeMillis())
        }
    }

    private fun onWatchInProgress(challenge: KickDailyChallenge) {
        val remaining = challenge.remainingMinutes ?: return
        Log.i(TAG, "daily locked, remaining watch-time: $remaining minutes")
        if (remaining in 1..NEAR_COMPLETION_WINDOW_MIN) {
            RewardClaimScheduler.followUp(
                applicationContext,
                (remaining + NEAR_COMPLETION_BUFFER_MIN) * 60_000L,
            )
        }
    }

    // ------------------------------------------------------------- drops

    private suspend fun handleDropClaims(prefs: SharedPreferences) {
        if (System.currentTimeMillis() < prefs.getLong(AppConstants.REWARD_DROPS_BACKOFF_UNTIL, 0L)) return
        val campaigns = try {
            rewardsRepository.getDropCampaigns()
        } catch (e: Exception) {
            Log.w(TAG, "drops fetch failed: ${e.message}")
            enterBackoff(prefs, AppConstants.REWARD_DROPS_BACKOFF_UNTIL)
            return
        }
        val claimed = mutableListOf<String>()
        for (campaign in campaigns.filter(KickRewardsPolicy::isCampaignActive)) {
            for (reward in campaign.rewards) {
                if (!KickRewardsPolicy.isRewardEarned(campaign, reward)) continue
                try {
                    rewardsRepository.claimDropReward(reward.id, campaign.id)
                    claimed += "\"${reward.name ?: reward.id}\" (${campaign.name ?: campaign.id})"
                    Log.i(TAG, "drop reward claimed: ${reward.name} from ${campaign.name}")
                } catch (e: Exception) {
                    Log.i(TAG, "drop claim rejected for ${reward.name}: ${e.message}")
                }
            }
        }
        if (claimed.isNotEmpty()) {
            prefs.edit {
                putLong(AppConstants.REWARD_LAST_CLAIM_AT, System.currentTimeMillis())
                remove(AppConstants.REWARD_DROPS_BACKOFF_UNTIL)
            }
            RewardClaimNotifier.dropsClaimed(applicationContext, claimed)
        }
    }

    private fun enterBackoff(prefs: SharedPreferences, key: String) {
        prefs.edit {
            putLong(key, System.currentTimeMillis() + ERROR_BACKOFF_MS)
        }
    }

    companion object {
        private const val TAG = "RewardClaimWorker"
        const val PERIODIC_WORK_NAME = "kick_reward_auto_claim"
        const val ONESHOT_WORK_NAME = "kick_reward_auto_claim_now"

        private const val CLAIM_JITTER_MIN_MS = 3_000L
        private const val CLAIM_JITTER_MAX_MS = 25_000L
        private const val ERROR_BACKOFF_MS = 30 * 60_000L
        private const val NEAR_COMPLETION_WINDOW_MIN = 15
        private const val NEAR_COMPLETION_BUFFER_MIN = 2L
    }
}
