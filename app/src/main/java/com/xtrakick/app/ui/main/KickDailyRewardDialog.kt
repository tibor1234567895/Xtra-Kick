package com.xtrakick.app.ui.main

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
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
    private var pollJob: Job? = null
    private var isClaiming = false

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogKickDailyRewardBinding.inflate(layoutInflater)
        binding.closeButton.setOnClickListener { dismiss() }
        binding.claimButton.setOnClickListener { claimReward() }
        binding.shareButton.setOnClickListener { shareReward() }
        return requireContext().getAlertDialogBuilder()
            .setView(binding.root)
            .create()
    }

    override fun onStart() {
        super.onStart()
        startRewardsPolling()
    }

    override fun onStop() {
        stopRewardsPolling()
        super.onStop()
    }

    override fun onDestroyView() {
        stopRewardsPolling()
        _binding?.let { currentBinding ->
            runCatching { Glide.with(this).clear(currentBinding.rewardImage) }
        }
        _binding = null
        super.onDestroyView()
    }

    private fun startRewardsPolling() {
        pollJob?.cancel()
        pollJob = lifecycleScope.launch {
            loadReward(isPeriodicRefresh = false)
            while (isActive) {
                delay(KickRewardsRepository.REWARDS_POLL_INTERVAL_MS)
                if (!isClaiming && isAdded && _binding != null) {
                    loadReward(isPeriodicRefresh = true)
                }
            }
        }
    }

    private fun stopRewardsPolling() {
        pollJob?.cancel()
        pollJob = null
    }

    private suspend fun loadReward(isPeriodicRefresh: Boolean = false) {
        if (!isPeriodicRefresh) {
            showLoading()
        }
        if (!rewardsRepository.canAttemptClaims()) {
            if (!isPeriodicRefresh && isAdded && _binding != null) {
                showLoadError(R.string.daily_reward_login_required)
            }
            return
        }
        val dailyChallenge = try {
            KickRewardsPolicy.selectDaily(rewardsRepository.getDailyChallenges())
        } catch (_: Exception) {
            if (!isPeriodicRefresh && isAdded && _binding != null) {
                showLoadError(R.string.daily_reward_load_failed)
            }
            return
        }
        if (!isAdded || _binding == null) return
        val currentContext = context ?: return
        val userId = currentContext.tokenPrefs()
            .getString(AppConstants.KICK_USER_ID, null)
            ?.takeIf { it.isNotBlank() }
        val streak = userId?.let { id ->
            runCatching { rewardsRepository.getDailyStreak(id) }.getOrNull()
        }
        challenge = dailyChallenge
        renderChallenge(dailyChallenge, streak)
    }

    private fun showLoading() {
        val currentBinding = _binding ?: return
        currentBinding.loadingIndicator.isVisible = true
        currentBinding.contentGroup.isVisible = false
    }

    private fun showLoadError(messageRes: Int) {
        val currentBinding = _binding ?: return
        currentBinding.loadingIndicator.isVisible = false
        currentBinding.contentGroup.isVisible = true
        currentBinding.streakText.isVisible = false
        currentBinding.watchProgress.isVisible = false
        currentBinding.progressText.isVisible = false
        currentBinding.rewardCard.isVisible = false
        currentBinding.winnerRarityText.isVisible = false
        currentBinding.shareButton.isVisible = false
        currentBinding.resetText.isVisible = false
        currentBinding.statusText.setText(messageRes)
        currentBinding.claimButton.apply {
            isVisible = true
            isEnabled = true
            setText(R.string.retry)
            setOnClickListener { lifecycleScope.launch { loadReward() } }
        }
    }

    private fun renderChallenge(dailyChallenge: KickDailyChallenge?, streak: Long?) {
        val currentBinding = _binding ?: return
        if (!isAdded) return
        currentBinding.loadingIndicator.isVisible = false
        currentBinding.contentGroup.isVisible = true
        currentBinding.rewardCard.isVisible = false
        currentBinding.shareButton.isVisible = false
        currentBinding.winnerRarityText.isVisible = false
        currentBinding.resetText.isVisible = false
        currentBinding.streakText.isVisible = streak != null
        streak?.coerceAtMost(Int.MAX_VALUE.toLong())?.toInt()?.let { days ->
            currentBinding.streakText.text = resources.getQuantityString(R.plurals.daily_reward_streak, days, days)
        }

        val threshold = dailyChallenge?.thresholdMinutes
        val progress = dailyChallenge?.progressMinutes
        val hasProgress = threshold != null && threshold > 0 && progress != null
        currentBinding.watchProgress.isVisible = hasProgress
        currentBinding.progressText.isVisible = hasProgress
        if (hasProgress) {
            val max = threshold.coerceAtMost(Int.MAX_VALUE.toLong()).toInt()
            val current = progress.coerceIn(0, threshold).toInt()
            currentBinding.watchProgress.max = max
            currentBinding.watchProgress.setProgressCompat(current, true)
            currentBinding.progressText.text = getString(R.string.daily_reward_watch_progress, progress, threshold)
        }
        renderResetTime(dailyChallenge)

        currentBinding.claimButton.apply {
            isVisible = true
            setText(R.string.daily_reward_claim)
            setOnClickListener { claimReward() }
        }
        when (dailyChallenge?.let(KickRewardsPolicy::decide)) {
            KickRewardsPolicy.DailyAction.CLAIM_NOW -> {
                currentBinding.statusText.setText(R.string.daily_reward_ready)
                currentBinding.claimButton.isEnabled = true
            }
            KickRewardsPolicy.DailyAction.WATCH_IN_PROGRESS -> {
                currentBinding.statusText.text = dailyChallenge.remainingMinutes?.let { remaining ->
                    getString(R.string.daily_reward_watch_remaining, remaining)
                } ?: getString(R.string.daily_reward_unavailable)
                currentBinding.claimButton.isEnabled = false
            }
            KickRewardsPolicy.DailyAction.ALREADY_CLAIMED -> {
                currentBinding.statusText.setText(R.string.daily_reward_already_claimed)
                currentBinding.claimButton.isVisible = false
                showKnownWinner(dailyChallenge)
            }
            else -> {
                currentBinding.statusText.setText(R.string.daily_reward_unavailable)
                currentBinding.claimButton.isVisible = false
            }
        }
    }

    private fun showKnownWinner(dailyChallenge: KickDailyChallenge) {
        val currentBinding = _binding ?: return
        val currentContext = context ?: return
        currentBinding.streakText.isVisible = false
        currentBinding.watchProgress.isVisible = false
        currentBinding.progressText.isVisible = false
        val winner = dailyChallenge.winnerName
        val rarity = dailyChallenge.winnerRarity
        val label = listOfNotNull(winner, rarity?.rarityLabel()).joinToString(" - ")
        currentBinding.winnerRarityText.isVisible = label.isNotBlank()
        currentBinding.winnerRarityText.text = label
        val savedCardUrl = currentContext.prefs().getString(AppConstants.REWARD_LAST_DAILY_CARD_URL, null)
        shareCardUrl = safeRewardImageUrl(dailyChallenge.winnerCardUrl)
            ?: safeRewardImageUrl(savedCardUrl)
        shareCardUrl?.let { cardUrl ->
            currentBinding.rewardCard.isVisible = true
            showRewardImage(cardUrl, isWinner = true)
            currentBinding.shareButton.isVisible = hasShareUsername()
        }
    }

    private fun renderResetTime(dailyChallenge: KickDailyChallenge?) {
        val currentBinding = _binding ?: return
        val resetAt = dailyChallenge?.endsAtEpochMs ?: return
        val formatted = SimpleDateFormat("MMM d, hh:mm a", Locale.US).format(Date(resetAt))
        currentBinding.resetText.text = getString(R.string.daily_reward_reset, formatted)
        currentBinding.resetText.isVisible = true
    }

    private fun claimReward() {
        val activeChallenge = challenge ?: return
        val currentBinding = _binding ?: return
        isClaiming = true
        currentBinding.claimButton.isEnabled = false
        currentBinding.statusText.setText(R.string.daily_reward_claiming)
        currentBinding.loadingIndicator.isVisible = true
        lifecycleScope.launch {
            val result = try {
                rewardsRepository.claimDailyChallenge(activeChallenge.id)
            } catch (_: Exception) {
                isClaiming = false
                _binding?.let { b ->
                    b.loadingIndicator.isVisible = false
                    b.statusText.setText(R.string.daily_reward_claim_failed)
                    b.claimButton.isEnabled = true
                }
                return@launch
            }
            if (!isAdded || _binding == null) {
                isClaiming = false
                return@launch
            }
            val currentContext = context ?: return@launch
            recordClaim(currentContext, activeChallenge, result)
            animateRoulette(result)
        }
    }

    private suspend fun animateRoulette(result: KickDailyClaimResult) {
        val currentBinding = _binding ?: return
        currentBinding.streakText.isVisible = false
        currentBinding.watchProgress.isVisible = false
        currentBinding.progressText.isVisible = false
        currentBinding.statusText.setText(R.string.daily_reward_claiming)

        val rouletteUrls = result.roulette.mapNotNull { safeRewardImageUrl(it.itemUrl) }
        val appContext = context?.applicationContext

        // 1. Preload all roulette drawables into memory first to avoid black flashes / on-the-fly network delays
        val preloadedDrawables: List<Drawable> = if (appContext != null && rouletteUrls.isNotEmpty()) {
            withContext(Dispatchers.IO) {
                rouletteUrls.mapNotNull { url ->
                    runCatching {
                        Glide.with(appContext)
                            .asDrawable()
                            .load(url)
                            .submit(240, 240)
                            .get()
                    }.getOrNull()
                }
            }
        } else {
            emptyList()
        }

        if (!isAdded || _binding == null) {
            isClaiming = false
            return
        }

        currentBinding.loadingIndicator.isVisible = false
        currentBinding.rewardCard.isVisible = true

        // 2. Smoothly cycle through in-memory drawables with easing deceleration curve
        if (preloadedDrawables.isNotEmpty()) {
            val totalSteps = maxOf(22, preloadedDrawables.size * 3)
            currentBinding.rewardImage.alpha = 1f
            for (step in 0 until totalSteps) {
                if (!isAdded || _binding == null) {
                    isClaiming = false
                    return
                }
                val drawable = preloadedDrawables[step % preloadedDrawables.size]
                currentBinding.rewardImage.setImageDrawable(drawable)

                // Deceleration curve: starts fast at 45ms and smoothly slows down to 220ms
                val progressFraction = step.toFloat() / totalSteps
                val delayMs = (45L + (progressFraction * progressFraction * 175L)).toLong()
                delay(delayMs)
            }
        }

        if (!isAdded || _binding == null) {
            isClaiming = false
            return
        }

        // 3. Reveal winner card with a smooth pop-in scale & fade animation
        val winner = result.winner
        val winnerUrl = safeRewardImageUrl(winner?.cardUrl)
        shareCardUrl = winnerUrl

        if (winnerUrl != null) {
            showRewardImage(winnerUrl, isWinner = true)
        }

        val rarity = winner?.rarity?.rarityLabel()
        _binding?.let { b ->
            b.winnerRarityText.isVisible = rarity != null
            b.winnerRarityText.text = rarity?.let { getString(R.string.daily_reward_rarity, it) }
            b.statusText.setText(R.string.daily_reward_claimed)
            b.claimButton.isVisible = false
            b.shareButton.isVisible = shareCardUrl != null && hasShareUsername()
        }
        isClaiming = false
    }

    private fun showRewardImage(url: String, isWinner: Boolean) {
        val currentBinding = _binding ?: return
        if (!isAdded) return
        currentBinding.rewardImage.animate().cancel()
        if (isWinner) {
            currentBinding.rewardImage.alpha = 0f
            currentBinding.rewardImage.scaleX = 0.85f
            currentBinding.rewardImage.scaleY = 0.85f
            Glide.with(this)
                .load(url)
                .fitCenter()
                .into(currentBinding.rewardImage)
            currentBinding.rewardImage.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(340L)
                .setInterpolator(OvershootInterpolator(1.2f))
                .start()
        } else {
            Glide.with(this)
                .load(url)
                .fitCenter()
                .into(currentBinding.rewardImage)
        }
    }

    private fun recordClaim(context: android.content.Context, activeChallenge: KickDailyChallenge, result: KickDailyClaimResult) {
        val now = System.currentTimeMillis()
        val resetAt = KickRewardsPolicy.resetTimeMs(activeChallenge, now)
        context.prefs().edit {
            putLong(AppConstants.REWARD_DAILY_CLAIMED_UNTIL, resetAt)
            putLong(AppConstants.REWARD_LAST_CLAIM_AT, now)
            remove(AppConstants.REWARD_DAILY_BACKOFF_UNTIL)
            result.winner?.rarity?.let { putString(AppConstants.REWARD_LAST_DAILY_RARITY, it) }
            result.winner?.cardUrl?.let { putString(AppConstants.REWARD_LAST_DAILY_CARD_URL, it) }
        }
        if (context.prefs().getBoolean(AppConstants.REWARD_AUTO_CLAIM_ENABLED, false)) {
            RewardClaimScheduler.followUp(context, resetAt - now)
        }
    }

    private fun shareReward() {
        val cardUrl = shareCardUrl ?: return
        val currentContext = context ?: return
        val username = shareUsername(currentContext) ?: return
        val shareUrl = Uri.Builder()
            .scheme("https")
            .authority("kick.com")
            .appendPath("rewards")
            .appendPath("share")
            .appendQueryParameter("img", cardUrl)
            .appendQueryParameter("u", username)
            .build()
            .toString()
        runCatching {
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
    }

    private fun hasShareUsername(): Boolean = context?.let { shareUsername(it) } != null

    private fun shareUsername(context: android.content.Context): String? = context.tokenPrefs()
            .getString(AppConstants.KICK_USER_LOGIN, null)
            ?.takeIf { it.isNotBlank() }
            ?: context.tokenPrefs().getString(AppConstants.USERNAME, null)?.takeIf { it.isNotBlank() }

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
        _binding?.let { currentBinding ->
            runCatching { Glide.with(this).clear(currentBinding.rewardImage) }
        }
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
