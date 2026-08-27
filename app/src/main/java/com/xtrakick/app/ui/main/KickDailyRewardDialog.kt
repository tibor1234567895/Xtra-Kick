package com.xtrakick.app.ui.main

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogKickDailyRewardBinding
import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDailyClaimResult
import com.xtrakick.app.repository.KickRewardsPolicy
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class KickDailyRewardDialog : DialogFragment() {

    @Inject
    lateinit var rewardsRepository: KickRewardsRepository

    private var _binding: DialogKickDailyRewardBinding? = null
    private val binding get() = _binding!!
    private var challenge: KickDailyChallenge? = null
    private var shareCardUrl: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogKickDailyRewardBinding.inflate(layoutInflater)
        binding.closeButton.setOnClickListener { dismiss() }
        binding.claimButton.setOnClickListener { claimReward() }
        binding.shareButton.setOnClickListener { shareReward() }
        lifecycleScope.launch { loadReward() }
        return requireContext().getAlertDialogBuilder()
            .setView(binding.root)
            .create()
    }

    private suspend fun loadReward() {
        showLoading()
        if (!rewardsRepository.canAttemptClaims()) {
            showLoadError(R.string.daily_reward_login_required)
            return
        }
        val dailyChallenge = try {
            KickRewardsPolicy.selectDaily(rewardsRepository.getDailyChallenges())
        } catch (_: Exception) {
            showLoadError(R.string.daily_reward_load_failed)
            return
        }
        val userId = requireContext().tokenPrefs()
            .getString(AppConstants.KICK_USER_ID, null)
            ?.takeIf { it.isNotBlank() }
        val streak = userId?.let { id ->
            runCatching { rewardsRepository.getDailyStreak(id) }.getOrNull()
        }
        challenge = dailyChallenge
        renderChallenge(dailyChallenge, streak)
    }

    private fun showLoading() {
        binding.loadingIndicator.isVisible = true
        binding.contentGroup.isVisible = false
    }

    private fun showLoadError(messageRes: Int) {
        binding.loadingIndicator.isVisible = false
        binding.contentGroup.isVisible = true
        binding.streakText.isVisible = false
        binding.watchProgress.isVisible = false
        binding.progressText.isVisible = false
        binding.rewardCard.isVisible = false
        binding.winnerRarityText.isVisible = false
        binding.shareButton.isVisible = false
        binding.resetText.isVisible = false
        binding.statusText.setText(messageRes)
        binding.claimButton.apply {
            isVisible = true
            isEnabled = true
            setText(R.string.retry)
            setOnClickListener { lifecycleScope.launch { loadReward() } }
        }
    }

    private fun renderChallenge(dailyChallenge: KickDailyChallenge?, streak: Long?) {
        binding.loadingIndicator.isVisible = false
        binding.contentGroup.isVisible = true
        binding.rewardCard.isVisible = false
        binding.shareButton.isVisible = false
        binding.winnerRarityText.isVisible = false
        binding.streakText.isVisible = streak != null
        streak?.coerceAtMost(Int.MAX_VALUE.toLong())?.toInt()?.let { days ->
            binding.streakText.text = resources.getQuantityString(R.plurals.daily_reward_streak, days, days)
        }

        val threshold = dailyChallenge?.thresholdMinutes
        val progress = dailyChallenge?.progressMinutes
        val hasProgress = threshold != null && threshold > 0 && progress != null
        binding.watchProgress.isVisible = hasProgress
        binding.progressText.isVisible = hasProgress
        if (hasProgress) {
            val max = threshold.coerceAtMost(Int.MAX_VALUE.toLong()).toInt()
            val current = progress.coerceIn(0, threshold).toInt()
            binding.watchProgress.max = max
            binding.watchProgress.setProgressCompat(current, true)
            binding.progressText.text = getString(R.string.daily_reward_watch_progress, progress, threshold)
        }
        renderResetTime(dailyChallenge)

        binding.claimButton.apply {
            isVisible = true
            setText(R.string.daily_reward_claim)
            setOnClickListener { claimReward() }
        }
        when (dailyChallenge?.let(KickRewardsPolicy::decide)) {
            KickRewardsPolicy.DailyAction.CLAIM_NOW -> {
                binding.statusText.setText(R.string.daily_reward_ready)
                binding.claimButton.isEnabled = true
            }
            KickRewardsPolicy.DailyAction.WATCH_IN_PROGRESS -> {
                binding.statusText.text = dailyChallenge.remainingMinutes?.let { remaining ->
                    getString(R.string.daily_reward_watch_remaining, remaining)
                } ?: getString(R.string.daily_reward_unavailable)
                binding.claimButton.isEnabled = false
            }
            KickRewardsPolicy.DailyAction.ALREADY_CLAIMED -> {
                binding.statusText.setText(R.string.daily_reward_already_claimed)
                binding.claimButton.isVisible = false
                showKnownWinner(dailyChallenge)
            }
            else -> {
                binding.statusText.setText(R.string.daily_reward_unavailable)
                binding.claimButton.isVisible = false
            }
        }
    }

    private fun showKnownWinner(dailyChallenge: KickDailyChallenge) {
        val winner = dailyChallenge.winnerName
        val rarity = dailyChallenge.winnerRarity
        val label = listOfNotNull(winner, rarity?.rarityLabel()).joinToString(" - ")
        binding.winnerRarityText.isVisible = label.isNotBlank()
        binding.winnerRarityText.text = label
        val savedCardUrl = requireContext().prefs().getString(AppConstants.REWARD_LAST_DAILY_CARD_URL, null)
        shareCardUrl = safeRewardImageUrl(dailyChallenge.winnerCardUrl)
            ?: safeRewardImageUrl(savedCardUrl)
        shareCardUrl?.let { cardUrl ->
            binding.rewardCard.isVisible = true
            showRewardImage(cardUrl, isWinner = true)
            binding.shareButton.isVisible = hasShareUsername()
        }
    }

    private fun renderResetTime(dailyChallenge: KickDailyChallenge?) {
        val resetAt = dailyChallenge?.endsAtEpochMs ?: return
        val formatted = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date(resetAt))
        binding.resetText.text = getString(R.string.daily_reward_reset, formatted)
        binding.resetText.isVisible = true
    }

    private fun claimReward() {
        val activeChallenge = challenge ?: return
        binding.claimButton.isEnabled = false
        binding.statusText.setText(R.string.daily_reward_claiming)
        binding.loadingIndicator.isVisible = true
        lifecycleScope.launch {
            val result = try {
                rewardsRepository.claimDailyChallenge(activeChallenge.id)
            } catch (_: Exception) {
                binding.loadingIndicator.isVisible = false
                binding.statusText.setText(R.string.daily_reward_claim_failed)
                binding.claimButton.isEnabled = true
                return@launch
            }
            recordClaim(activeChallenge, result)
            animateRoulette(result)
        }
    }

    private suspend fun animateRoulette(result: KickDailyClaimResult) {
        binding.loadingIndicator.isVisible = false
        binding.rewardCard.isVisible = true
        val rouletteItems = result.roulette.mapNotNull { item ->
            safeRewardImageUrl(item.itemUrl)?.let { item.id to it }
        }
        rouletteItems.forEach { (_, url) -> Glide.with(this).load(url).preload(240, 240) }
        if (rouletteItems.isNotEmpty()) {
            val steps = maxOf(18, rouletteItems.size * 2)
            repeat(steps) { step ->
                showRewardImage(rouletteItems[step % rouletteItems.size].second, isWinner = false)
                delay(70L + step * 6L)
            }
        }

        val winner = result.winner
        val winnerUrl = safeRewardImageUrl(winner?.cardUrl)
            ?: rouletteItems.firstOrNull { it.first == winner?.id }?.second
        winnerUrl?.let { showRewardImage(it, isWinner = true) }
        shareCardUrl = safeRewardImageUrl(winner?.cardUrl)
        val rarity = winner?.rarity?.rarityLabel()
        binding.winnerRarityText.isVisible = rarity != null
        binding.winnerRarityText.text = rarity?.let { getString(R.string.daily_reward_rarity, it) }
        binding.statusText.setText(R.string.daily_reward_claimed)
        binding.claimButton.isVisible = false
        binding.shareButton.isVisible = shareCardUrl != null && hasShareUsername()
    }

    private fun showRewardImage(url: String, isWinner: Boolean) {
        binding.rewardImage.animate().cancel()
        binding.rewardImage.alpha = if (isWinner) 0.2f else 0.45f
        Glide.with(this)
            .load(url)
            .fitCenter()
            .into(binding.rewardImage)
        binding.rewardImage.animate()
            .alpha(1f)
            .setDuration(if (isWinner) 320L else 90L)
            .start()
    }

    private fun recordClaim(activeChallenge: KickDailyChallenge, result: KickDailyClaimResult) {
        val now = System.currentTimeMillis()
        val resetAt = KickRewardsPolicy.resetTimeMs(activeChallenge, now)
        requireContext().prefs().edit {
            putLong(AppConstants.REWARD_DAILY_CLAIMED_UNTIL, resetAt)
            putLong(AppConstants.REWARD_LAST_CLAIM_AT, now)
            remove(AppConstants.REWARD_DAILY_BACKOFF_UNTIL)
            result.winner?.rarity?.let { putString(AppConstants.REWARD_LAST_DAILY_RARITY, it) }
            result.winner?.cardUrl?.let { putString(AppConstants.REWARD_LAST_DAILY_CARD_URL, it) }
        }
        if (requireContext().prefs().getBoolean(AppConstants.REWARD_AUTO_CLAIM_ENABLED, false)) {
            RewardClaimScheduler.followUp(requireContext(), resetAt - now)
        }
    }

    private fun shareReward() {
        val cardUrl = shareCardUrl ?: return
        val username = shareUsername() ?: return
        val shareUrl = Uri.Builder()
            .scheme("https")
            .authority("kick.com")
            .appendPath("rewards")
            .appendPath("share")
            .appendQueryParameter("img", cardUrl)
            .appendQueryParameter("u", username)
            .build()
            .toString()
        startActivity(
            Intent.createChooser(
                Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, shareUrl)
                },
                getString(R.string.share),
            ),
        )
    }

    private fun hasShareUsername(): Boolean = shareUsername() != null

    private fun shareUsername(): String? = requireContext().tokenPrefs()
            .getString(AppConstants.KICK_USER_LOGIN, null)
            ?.takeIf { it.isNotBlank() }
            ?: requireContext().tokenPrefs().getString(AppConstants.USERNAME, null)?.takeIf { it.isNotBlank() }

    private fun safeRewardImageUrl(value: String?): String? {
        val uri = value?.let(Uri::parse) ?: return null
        val host = uri.host?.lowercase(Locale.ROOT) ?: return null
        return value.takeIf {
            uri.scheme.equals("https", ignoreCase = true) &&
                (host == "kick.com" || host.endsWith(".kick.com"))
        }
    }

    private fun String.rarityLabel(): String = replaceFirstChar { first ->
        if (first.isLowerCase()) first.titlecase(Locale.getDefault()) else first.toString()
    }

    override fun onDestroy() {
        _binding?.let { currentBinding -> Glide.with(this).clear(currentBinding.rewardImage) }
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val TAG = "kick_daily_reward"

        fun show(fragmentManager: FragmentManager) {
            if (fragmentManager.findFragmentByTag(TAG) == null) {
                KickDailyRewardDialog().show(fragmentManager, TAG)
            }
        }
    }
}
