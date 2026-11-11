package com.xtrakick.app.ui.main

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.PathInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.core.view.doOnNextLayout
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.target.Target
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogKickDailyRewardBinding
import com.xtrakick.app.databinding.ItemRewardCardPageBinding
import com.xtrakick.app.databinding.ItemRewardOddsPillBinding
import com.xtrakick.app.databinding.ItemRouletteReelSlotBinding
import com.xtrakick.app.model.kick.KickChallengeDropTableItem
import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDailyClaimResult
import com.xtrakick.app.model.kick.KickDailyRewardWinner
import com.xtrakick.app.model.kick.KickDailyRouletteItem
import com.xtrakick.app.model.kick.KickRewardsParsing
import com.xtrakick.app.repository.KickRewardsPolicy
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.ReelStripBuilder
import com.xtrakick.app.util.RouletteAnimationAssets
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import kotlin.coroutines.resume
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

@AndroidEntryPoint
class KickDailyRewardDialog : BottomSheetDialogFragment() {

    @Inject
    lateinit var rewardsRepository: KickRewardsRepository

    private var _binding: DialogKickDailyRewardBinding? = null
    private val binding get() = _binding!!
    private var challenges: List<KickDailyChallenge> = emptyList()
    private var selectedChallengeId: String? = null
    private val selectedChallenge: KickDailyChallenge?
        get() = challenges.firstOrNull { it.id == selectedChallengeId } ?: challenges.firstOrNull()
    private var lastKnownStreak: Long? = null
    private var shareCardUrl: String? = null
    private var pollJob: Job? = null
    private var isClaiming = false
    private var pendingStreakPop = false
    private val cardAdapter = ChallengeCardAdapter()
    private val preloadedDrawables = ConcurrentHashMap<String, Drawable>()

    // Roulette phase-machine animators and stage players (released in onStop/onDestroyView)
    private var reelAnimator: ValueAnimator? = null
    private var handoffAnimator: ValueAnimator? = null
    private var entranceAnimator: ValueAnimator? = null
    private var tiltAnimator: ValueAnimator? = null
    private var streakPopAnimator: ObjectAnimator? = null
    private var unboxPlayer: ExoPlayer? = null
    private var backgroundPlayer: ExoPlayer? = null
    private var unboxPlayerView: PlayerView? = null
    private var backgroundPlayerView: PlayerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogKickDailyRewardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view.parent as? View)?.setBackgroundColor(Color.TRANSPARENT)
        binding.closeButton.setOnClickListener { dismiss() }
        binding.claimButton.setOnClickListener { claimReward() }
        binding.shareButton.setOnClickListener { shareReward() }
        if (BuildConfig.DEBUG) {
            binding.claimButton.setOnLongClickListener {
                selectedChallenge?.let { ch -> simulateClaim(ch) }
                true
            }
        }
        setupCardViewPager()
    }

    private fun setupCardViewPager() {
        val pager = binding.cardViewPager
        pager.adapter = cardAdapter
        pager.offscreenPageLimit = 1
        pager.clipChildren = false
        pager.clipToPadding = false
        (pager.getChildAt(0) as? RecyclerView)?.apply {
            clipChildren = false
            clipToPadding = false
            overScrollMode = View.OVER_SCROLL_NEVER
        }
        val pageMarginPx = (8 * resources.displayMetrics.density).toInt()
        val peekMarginPx = (20 * resources.displayMetrics.density).toInt()
        pager.setPadding(peekMarginPx, 0, peekMarginPx, 0)
        pager.setPageTransformer(MarginPageTransformer(pageMarginPx))

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position in challenges.indices && !isClaiming) {
                    val newChallenge = challenges[position]
                    if (selectedChallengeId != newChallenge.id) {
                        selectedChallengeId = newChallenge.id
                        updateChallengeChips(challenges)
                        renderChallengeDetails(newChallenge, lastKnownStreak)
                    }
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)?.let { sheet ->
            val behavior = BottomSheetBehavior.from(sheet)
            behavior.skipCollapsed = true
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        startRewardsPolling()
    }

    override fun onStop() {
        stopRewardsPolling()
        releaseStagePlayers()
        super.onStop()
    }

    override fun onDestroyView() {
        stopRewardsPolling()
        reelAnimator?.cancel()
        reelAnimator = null
        handoffAnimator?.cancel()
        handoffAnimator = null
        entranceAnimator?.cancel()
        entranceAnimator = null
        tiltAnimator?.cancel()
        tiltAnimator = null
        streakPopAnimator?.cancel()
        streakPopAnimator = null
        releaseStagePlayers()
        preloadedDrawables.clear()
        _binding = null
        super.onDestroyView()
    }

    private fun startRewardsPolling() {
        pollJob?.cancel()
        pollJob = lifecycleScope.launch {
            // A claim animation in flight owns the card page; start polling without clobbering it
            if (!isClaiming) {
                loadReward(isPeriodicRefresh = false)
            }
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

    private suspend fun loadReward(isPeriodicRefresh: Boolean = false, keepActiveCardView: Boolean = false) {
        if (!isPeriodicRefresh) {
            showLoading()
        }
        if (!rewardsRepository.canAttemptClaims()) {
            if (!isPeriodicRefresh && isAdded && _binding != null) {
                showLoadError(R.string.daily_reward_login_required)
            }
            return
        }
        val fetchedChallenges = try {
            rewardsRepository.getDailyChallenges()
        } catch (e: Exception) {
            com.xtrakick.app.util.DiagnosticLogger.w("KickRewards", "getDailyChallenges failed: ${e.message}", e)
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
        lastKnownStreak = streak

        val sorted = KickRewardsPolicy.sortChallenges(fetchedChallenges)
        challenges = sorted
        if (sorted.none { it.id == selectedChallengeId }) {
            selectedChallengeId = sorted.firstOrNull()?.id
        }

        if (!keepActiveCardView) {
            cardAdapter.notifyDataSetChanged()

            val peekMarginPx = if (sorted.size > 1) (20 * resources.displayMetrics.density).toInt() else 0
            binding.cardViewPager.setPadding(peekMarginPx, 0, peekMarginPx, 0)

            val selectedIndex = sorted.indexOfFirst { it.id == selectedChallengeId }.coerceAtLeast(0)
            if (binding.cardViewPager.currentItem != selectedIndex) {
                binding.cardViewPager.setCurrentItem(selectedIndex, false)
            }

            updateChallengeChips(sorted)
            renderChallengeDetails(selectedChallenge, streak)
        } else {
            // Keep the active claimed card and celebrate view intact without clobbering images or interrupting 3D tilt
            updateChallengeChips(sorted)
            val isDailyRewardTab = selectedChallenge?.featured != true
            val showStreak = isDailyRewardTab && (streak != null && streak > 0)
            binding.streakContainer.isVisible = showStreak
            if (showStreak) {
                val days = streak.coerceAtMost(Int.MAX_VALUE.toLong()).toInt()
                binding.streakText.text = resources.getQuantityString(R.plurals.daily_reward_streak, days, days)
            }
            if (pendingStreakPop) {
                pendingStreakPop = false
                if (showStreak) startStreakPop(binding.streakText)
            }
        }
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
        currentBinding.challengeTabsScroll.isVisible = false
        currentBinding.activePeriodContainer.isVisible = false
        currentBinding.streakContainer.isVisible = false
        currentBinding.watchProgress.isVisible = false
        currentBinding.progressText.isVisible = false
        currentBinding.cardViewPager.isVisible = false
        currentBinding.oddsScroll.isVisible = false
        currentBinding.winnerRarityText.isVisible = false
        currentBinding.shareButton.isVisible = false
        currentBinding.resetText.isVisible = false
        currentBinding.statusText.setText(messageRes)
        currentBinding.claimButton.apply {
            isVisible = true
            isEnabled = true
            backgroundTintList = ColorStateList.valueOf(COLOR_KICK_GREEN)
            setTextColor(Color.BLACK)
            iconTint = ColorStateList.valueOf(Color.BLACK)
            if (messageRes == R.string.daily_reward_login_required) {
                setText(R.string.log_in)
                setOnClickListener {
                    dismiss()
                    startActivity(Intent(requireContext(), com.xtrakick.app.ui.login.LoginActivity::class.java))
                }
            } else {
                setText(R.string.retry)
                setOnClickListener { lifecycleScope.launch { loadReward() } }
            }
        }
    }

    private fun challengeTitle(challenge: KickDailyChallenge): String =
        challenge.name?.takeIf { it.isNotBlank() }
            ?: if (challenge.recurrence.equals("daily", ignoreCase = true)) {
                getString(R.string.daily_reward_claim_title)
            } else {
                challenge.recurrence?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.US) else it.toString() }
                    ?: getString(R.string.daily_reward_claim_title)
            }

    private fun updateChallengeChips(challengeList: List<KickDailyChallenge>) {
        val currentBinding = _binding ?: return
        if (challengeList.size <= 1) {
            currentBinding.challengeTabsScroll.isVisible = false
            return
        }
        currentBinding.challengeTabsScroll.isVisible = true
        val chipGroup = currentBinding.challengeChips

        val sameChips = chipGroup.childCount == challengeList.size && (0 until chipGroup.childCount).all { i ->
            (chipGroup.getChildAt(i) as? Chip)?.tag == challengeList[i].id
        }

        if (sameChips) {
            for (i in 0 until chipGroup.childCount) {
                val chip = chipGroup.getChildAt(i) as? Chip ?: continue
                val ch = challengeList[i]
                val isChecked = (ch.id == selectedChallengeId)
                chip.isChecked = isChecked
                updateChipIcon(chip, ch)
                if (isChecked) {
                    currentBinding.challengeTabsScroll.post {
                        currentBinding.challengeTabsScroll.smoothScrollTo((chip.left - 40).coerceAtLeast(0), 0)
                    }
                }
            }
            return
        }

        chipGroup.removeAllViews()
        val currentContext = context ?: return
        for (i in challengeList.indices) {
            val ch = challengeList[i]
            val chip = Chip(currentContext).apply {
                tag = ch.id
                text = challengeTitle(ch)
                isCheckable = true
                isChecked = (ch.id == selectedChallengeId)
                updateChipIcon(this, ch)
                setOnClickListener {
                    if (selectedChallengeId != ch.id) {
                        selectedChallengeId = ch.id
                        binding.cardViewPager.setCurrentItem(i, true)
                        renderChallengeDetails(ch, lastKnownStreak)
                    }
                }
            }
            chipGroup.addView(chip)
        }
    }

    private fun updateChipIcon(chip: Chip, ch: KickDailyChallenge) {
        val isClaimable = ch.status.equals(KickRewardsPolicy.STATUS_CLAIMABLE, ignoreCase = true)
        chip.isChipIconVisible = isClaimable
        if (isClaimable && chip.chipIcon == null) {
            chip.chipIcon = ContextCompat.getDrawable(chip.context, R.drawable.baseline_card_giftcard_claimable_24)
        }
    }

    private fun renderChallengeDetails(dailyChallenge: KickDailyChallenge?, streak: Long?) {
        val currentBinding = _binding ?: return
        if (!isAdded) return
        currentBinding.loadingIndicator.isVisible = false
        currentBinding.contentGroup.isVisible = true
        currentBinding.cardViewPager.isVisible = true
        currentBinding.shareButton.isVisible = false
        currentBinding.winnerRarityText.isVisible = false
        currentBinding.resetText.isVisible = false

        currentBinding.titleText.text = dailyChallenge?.let { challengeTitle(it) }
            ?: getString(R.string.daily_reward_claim_title)

        // Server description
        val desc = dailyChallenge?.description?.takeIf { it.isNotBlank() }
        currentBinding.descriptionText.text = desc ?: getString(R.string.daily_reward_description)

        // Event active period
        val activeEndsAt = dailyChallenge?.activePeriodEndsAtEpochMs
        if (activeEndsAt != null) {
            val formatted = SimpleDateFormat("dd MMM, HH:mm z", Locale.US).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date(activeEndsAt))
            currentBinding.activePeriodText.text = getString(R.string.event_reward_ends, formatted)
            currentBinding.activePeriodContainer.isVisible = true
        } else {
            currentBinding.activePeriodContainer.isVisible = false
        }

        // Drop table odds pills
        populateDropTablePills(dailyChallenge?.dropTable.orEmpty())

        // Streak (only shown for regular daily challenge, not featured/seasonal)
        val isDailyRewardTab = dailyChallenge?.featured != true
        val showStreak = isDailyRewardTab && (streak != null && streak > 0)
        currentBinding.streakContainer.isVisible = showStreak
        if (showStreak) {
            val days = streak.coerceAtMost(Int.MAX_VALUE.toLong()).toInt()
            currentBinding.streakText.text = resources.getQuantityString(R.plurals.daily_reward_streak, days, days)
        }
        // Consume exactly once: fires right when the refreshed streak text lands after a claim
        if (pendingStreakPop) {
            pendingStreakPop = false
            if (showStreak) startStreakPop(currentBinding.streakText)
        }

        // Watch progress
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

        val action = dailyChallenge?.let(KickRewardsPolicy::decide)
        when (action) {
            KickRewardsPolicy.DailyAction.CLAIM_NOW -> {
                currentBinding.statusText.setText(R.string.daily_reward_ready)
                currentBinding.claimButton.apply {
                    isVisible = true
                    isEnabled = true
                    setText(R.string.daily_reward_claim)
                    backgroundTintList = ColorStateList.valueOf(COLOR_KICK_GREEN)
                    setTextColor(Color.BLACK)
                    iconTint = ColorStateList.valueOf(Color.BLACK)
                    setOnClickListener { claimReward() }
                }
            }
            KickRewardsPolicy.DailyAction.WATCH_IN_PROGRESS -> {
                val remaining = dailyChallenge.remainingMinutes
                currentBinding.statusText.text = remaining?.let {
                    getString(R.string.daily_reward_watch_remaining, it)
                } ?: getString(R.string.daily_reward_unavailable)
                currentBinding.claimButton.apply {
                    isVisible = true
                    isEnabled = false
                    setText(R.string.daily_reward_claim)
                    backgroundTintList = ColorStateList.valueOf(COLOR_KICK_GREEN_DISABLED)
                    setTextColor(Color.BLACK)
                    iconTint = ColorStateList.valueOf(Color.BLACK)
                }
            }
            KickRewardsPolicy.DailyAction.ALREADY_CLAIMED -> {
                currentBinding.statusText.setText(R.string.daily_reward_already_claimed)
                currentBinding.claimButton.isVisible = false
                showKnownWinnerDetails(dailyChallenge)
            }
            else -> {
                currentBinding.statusText.setText(R.string.daily_reward_unavailable)
                currentBinding.claimButton.isVisible = false
            }
        }
    }

    private fun populateDropTablePills(dropTable: List<KickChallengeDropTableItem>) {
        val currentBinding = _binding ?: return
        currentBinding.oddsContainer.removeAllViews()
        if (dropTable.isEmpty()) {
            currentBinding.oddsScroll.isVisible = false
            return
        }
        currentBinding.oddsScroll.isVisible = true
        val inflater = layoutInflater
        for (item in dropTable) {
            val pillBinding = ItemRewardOddsPillBinding.inflate(inflater, currentBinding.oddsContainer, false)
            val titleRarity = item.rarity.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
            }
            pillBinding.oddsLabel.text = "$titleRarity ${item.percentageFormatted}"
            val color = rarityColor(item.rarity)
            pillBinding.rarityDot.background?.mutate()?.setTint(color)
            currentBinding.oddsContainer.addView(pillBinding.root)
        }
    }

    private fun rarityColor(rarity: String): Int = when (rarity.lowercase(Locale.ROOT)) {
        "mythic" -> 0xFFEC4899.toInt()     // Pink / Magenta
        "legendary" -> 0xFFF59E0B.toInt()  // Amber / Gold
        "epic" -> 0xFFA855F7.toInt()       // Purple
        "rare" -> 0xFF38BDF8.toInt()       // Sky Blue
        "uncommon" -> 0xFF53FC18.toInt()   // Kick Green
        else -> 0xFF9E9E9E.toInt()         // Common / Grey
    }

    private fun showKnownWinnerDetails(dailyChallenge: KickDailyChallenge?) {
        if (dailyChallenge == null) return
        val currentBinding = _binding ?: return
        val isDailyRewardTab = dailyChallenge.featured != true
        val streak = lastKnownStreak
        currentBinding.streakContainer.isVisible = isDailyRewardTab && (streak != null && streak > 0)
        currentBinding.watchProgress.isVisible = false
        currentBinding.progressText.isVisible = false
        val winner = dailyChallenge.winnerName
        val rarity = dailyChallenge.winnerRarity
        val label = listOfNotNull(winner, rarity?.rarityLabel()).joinToString(" - ")
        currentBinding.winnerRarityText.isVisible = label.isNotBlank()
        currentBinding.winnerRarityText.text = label
        rarity?.let { currentBinding.winnerRarityText.setTextColor(rarityColor(it)) }

        val isStandardDaily = dailyChallenge.recurrence.equals("daily", ignoreCase = true) && !dailyChallenge.featured
        val prefKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_CARD_URL else "${AppConstants.REWARD_LAST_DAILY_CARD_URL}_${dailyChallenge.id}"
        val savedCardUrl = context?.prefs()?.getString(prefKey, null)
        shareCardUrl = safeRewardImageUrl(dailyChallenge.winnerCardUrl)
            ?: safeRewardImageUrl(savedCardUrl)
        currentBinding.shareButton.isVisible = shareCardUrl != null && hasShareUsername()
    }

    private fun renderResetTime(dailyChallenge: KickDailyChallenge?) {
        val currentBinding = _binding ?: return
        val resetAt = dailyChallenge?.endsAtEpochMs ?: return
        val formatted = SimpleDateFormat("MMM d, hh:mm a", Locale.US).format(Date(resetAt))
        val isStandardDaily = dailyChallenge.recurrence.equals("daily", ignoreCase = true) && !dailyChallenge.featured
        currentBinding.resetText.text = if (isStandardDaily) {
            getString(R.string.daily_reward_reset, formatted)
        } else if (dailyChallenge.featured) {
            getString(R.string.seasonal_crate_reset, formatted)
        } else {
            getString(R.string.event_reward_ends, formatted)
        }
        currentBinding.resetText.isVisible = true
    }

    private fun claimReward() {
        val activeChallenge = selectedChallenge ?: return
        val currentBinding = _binding ?: return
        isClaiming = true
        currentBinding.cardViewPager.isUserInputEnabled = false
        currentBinding.claimButton.isEnabled = false
        currentBinding.claimButton.animate().alpha(0.5f).setDuration(200L).start()
        currentBinding.statusText.setText(R.string.daily_reward_claiming)
        lifecycleScope.launch {
            val result = try {
                rewardsRepository.claimDailyChallenge(activeChallenge.id)
            } catch (e: Exception) {
                com.xtrakick.app.util.DiagnosticLogger.w("KickRewards", "claimDailyChallenge failed: ${e.message}", e)
                isClaiming = false
                _binding?.let { b ->
                    b.statusText.setText(R.string.daily_reward_claim_failed)
                    b.claimButton.isEnabled = true
                    b.claimButton.alpha = 1f
                    b.cardViewPager.isUserInputEnabled = true
                }
                return@launch
            }
            if (!isAdded || _binding == null) {
                isClaiming = false
                return@launch
            }
            val currentContext = context ?: return@launch
            recordClaim(currentContext, activeChallenge, result)
            animateClaimSequence(activeChallenge, result, isSimulated = false)
        }
    }

    private fun simulateClaim(challenge: KickDailyChallenge) {
        if (!BuildConfig.DEBUG || isClaiming) return
        val currentBinding = _binding ?: return
        isClaiming = true
        currentBinding.cardViewPager.isUserInputEnabled = false
        currentBinding.claimButton.isEnabled = false
        currentBinding.claimButton.animate().alpha(0.5f).setDuration(200L).start()
        currentBinding.statusText.setText(R.string.daily_reward_claiming)

        lifecycleScope.launch {
            // Debug sim is 1:1 claim data shape, unlimited retries: replay the persisted JSON of
            // the last real claim; a synthesized representative claim only covers the first run
            // before any real claim stored its payload.
            val replayed = lastRealClaimOrNull()
            val result: KickDailyClaimResult
            val toastMessage: String
            if (replayed != null) {
                result = replayed
                toastMessage = "[Debug] Replaying last real claim (${replayed.roulette.size} reel tiles)..."
            } else {
                val winnerRarity = challenge.winnerRarity ?: challenge.dropTable.firstOrNull()?.rarity ?: "common"
                val winnerUrl = challenge.winnerCardUrl
                    ?: FALLBACK_ROULETTE_URLS.first()
                // Representative daily-claim data: a long reel with the winner inside it, so the
                // debug spin travel matches what kick.com's real claim responses carry
                val mockWinnerIndex = 7
                val mockRoulette = (0 until 14).map { index ->
                    KickDailyRouletteItem(
                        id = "item-${index + 1}",
                        itemUrl = if (index == mockWinnerIndex) {
                            winnerUrl
                        } else {
                            FALLBACK_ROULETTE_URLS[index % FALLBACK_ROULETTE_URLS.size]
                        },
                    )
                }
                result = KickDailyClaimResult(
                    challengeId = challenge.id,
                    roulette = mockRoulette,
                    winner = KickDailyRewardWinner(
                        id = "item-${mockWinnerIndex + 1}",
                        cardUrl = winnerUrl,
                        rarity = winnerRarity,
                    ),
                )
                toastMessage = "[Debug] No usable real claim stored yet (event crates claim with no reel data) — simulating representative claim..."
            }

            context?.let { ctx ->
                Toast.makeText(ctx, toastMessage, Toast.LENGTH_SHORT).show()
            }

            animateClaimSequence(challenge, result, isSimulated = true)
        }
    }

    /** Preloads all candidate roulette and winner assets into memory/disk cache concurrently. */
    private fun startPreloadingRouletteAssets(
        context: Context,
        urls: List<String>,
        tileWidth: Int,
        tileHeight: Int,
        winnerUrl: String,
    ): kotlinx.coroutines.Deferred<Unit> = lifecycleScope.async(Dispatchers.IO) {
        val appContext = context.applicationContext ?: return@async
        urls.map { url ->
            async {
                val isWinnerCard = (url == winnerUrl)
                val targetW = if (isWinnerCard) Target.SIZE_ORIGINAL else tileWidth
                val targetH = if (isWinnerCard) Target.SIZE_ORIGINAL else tileHeight
                runCatching {
                    val drawable = Glide.with(appContext)
                        .asDrawable()
                        .load(buildKickGlideUrl(url))
                        .dontTransform()
                        .submit(targetW, targetH)
                        .get()
                    if (drawable != null) {
                        preloadedDrawables[url] = drawable
                    }
                }
            }
        }.awaitAll()
    }

    /**
     * 1:1 port of the kick.com daily-reward claim animation (chunk `2fak-f4t220l6.js`):
     *
     *  openBox   — unbox.webm one-shot replaces the idle crate seamlessly without black flash
     *  NEAR      — during its last 1000ms the reel appears and starts spinning; crate fades 300ms
     *  spin      — reel travels restIndex → targetIndex at 3.5 tiles/s, cubic-bezier(0.18, 0.58, 0.12, 1)
     *  landing   — winner tile shrinks slightly (180ms) then pops out punchily (320ms, overshoot)
     *  handoff   — reel fades + squishes smoothly into the full-size winner card
     *  celebrate — card entrance, 3D perspective tilt 23° X/Y 3s × 5 cycles, streak count pop
     *
     * Every failure degrades to showing the winner immediately, never blocks the reward.
     */
    private suspend fun animateClaimSequence(
        activeChallenge: KickDailyChallenge,
        result: KickDailyClaimResult,
        isSimulated: Boolean = false,
    ) {
        val currentBinding = _binding ?: run {
            isClaiming = false
            return
        }
        currentBinding.streakContainer.isVisible = false
        currentBinding.watchProgress.isVisible = false
        currentBinding.progressText.isVisible = false
        currentBinding.statusText.setText(R.string.daily_reward_claiming)

        val winner = result.winner
        val winnerUrl = safeRewardImageUrl(winner?.cardUrl) ?: FALLBACK_ROULETTE_URLS.first()
        shareCardUrl = safeRewardImageUrl(winner?.cardUrl)

        val refreshAfterClaim = !isSimulated

        val itemBinding = if (isAdded) getActiveCardViewHolder()?.itemBinding else null
        if (itemBinding == null) {
            celebrate(activeChallenge, winner, refreshAfterClaim)
            return
        }

        if (isReducedMotionEnabled()) {
            itemBinding.rouletteContainer.isVisible = false
            showRewardImage(itemBinding.rewardImage, winnerUrl)
            celebrate(activeChallenge, winner, refreshAfterClaim)
            return
        }

        val appContext = context ?: run {
            celebrate(activeChallenge, winner, refreshAfterClaim)
            return
        }

        // Measure tile dimensions for preloading and layout
        val containerWidth = currentBinding.cardViewPager.width.takeIf { it > 0 }
            ?: resources.displayMetrics.widthPixels
        val density = resources.displayMetrics.density
        val gapPx = (REEL_GAP_DP * density).roundToInt()
        val tileWidth = ((containerWidth - 2f * gapPx) / VISIBLE_TILES).roundToInt()
        val tileHeight = (tileWidth * REEL_TILE_H_RATIO).roundToInt()

        // Extract all candidate image URLs and warm them up in memory/disk cache concurrently
        val rouletteUrls = result.roulette.mapNotNull { safeRewardImageUrl(it.itemUrl) }
        val effectiveRouletteUrls = if (rouletteUrls.isNotEmpty()) rouletteUrls else FALLBACK_ROULETTE_URLS
        val allUrlsToPreload = (effectiveRouletteUrls + listOfNotNull(winnerUrl, safeRewardImageUrl(winner?.thumbnailUrl)) + FALLBACK_ROULETTE_URLS).distinct()
        val preloadJob = startPreloadingRouletteAssets(appContext, allUrlsToPreload, tileWidth, tileHeight, winnerUrl)

        // ---- Phase: openBox — prepare stage and keep crate image visible until unbox video renders ----
        itemBinding.reelBackgroundVideo.isVisible = false
        itemBinding.rouletteStrip.isVisible = false
        val container = itemBinding.rouletteContainer
        container.isVisible = true
        container.alpha = 1f
        container.scaleX = 1f
        container.scaleY = 1f
        itemBinding.stageUnboxVideo.alpha = 1f
        currentBinding.loadingIndicator.isVisible = false

        // Fade out claim button cleanly during the unboxing sequence
        currentBinding.claimButton.animate().alpha(0f).setDuration(250L).withEndAction {
            currentBinding.claimButton.isVisible = false
            currentBinding.claimButton.alpha = 1f
        }.start()

        startStagePlayers(appContext, itemBinding, safeRewardImageUrl(activeChallenge.unboxAnimationUrl))

        val nearFired = awaitOpenBoxNearComplete()
        itemBinding.rewardImage.isVisible = false
        if (isClaimHostGone()) {
            isClaiming = false
            return
        }

        // Await in-flight image preloads (majority already completed during the ~1.7s unbox playback)
        withTimeoutOrNull(1200L) { preloadJob.await() }

        if (!nearFired) {
            // Unbox video missing/ended before the spin window — reveal the reward directly
            releaseStagePlayers()
            container.isVisible = false
            showRewardImage(itemBinding.rewardImage, winnerUrl)
            celebrate(activeChallenge, winner, refreshAfterClaim)
            return
        }

        if (result.roulette.isEmpty()) {
            // Event-crate claims (e.g. Trick or Treat) return an empty roulette: play the burst beat, then reveal directly
            showReelBackgroundBeat(itemBinding)
            delay(NEAR_COMPLETE_MS)
            if (isClaimHostGone()) {
                isClaiming = false
                return
            }
            runHandoff(itemBinding, winnerUrl)
            if (isClaimHostGone()) {
                isClaiming = false
                return
            }
            celebrate(activeChallenge, winner, refreshAfterClaim)
            return
        }

        val strip = runCatching {
            ReelStripBuilder.buildFixedReelStrip(
                rewards = result.roulette,
                winningRewardId = winner?.id ?: result.roulette.first().id,
                leadInCount = 2,
            )
        }.getOrElse {
            ReelStripBuilder.buildFixedReelStrip(result.roulette, result.roulette.first().id, leadInCount = 2)
        }

        runReelPhase(itemBinding, strip, winnerUrl, tileWidth, tileHeight, gapPx)
        if (isClaimHostGone()) {
            isClaiming = false
            return
        }
        celebrate(activeChallenge, winner, refreshAfterClaim)
    }

    /** Waits for the unbox video's last 1000ms (kick.com's NEAR trigger). Degrades on failure. */
    private suspend fun awaitOpenBoxNearComplete(): Boolean {
        var sawPlayback = false
        val deadline = System.currentTimeMillis() + UNBOX_WAIT_TIMEOUT_MS
        while (isAdded && _binding != null && System.currentTimeMillis() < deadline) {
            delay(UNBOX_POLL_INTERVAL_MS)
            val player = unboxPlayer ?: break
            when (player.playbackState) {
                Player.STATE_READY, Player.STATE_BUFFERING -> sawPlayback = true
                Player.STATE_ENDED -> return false
                Player.STATE_IDLE -> if (sawPlayback) return false
            }
            val durationMs = player.duration.takeIf { it > 0 } ?: DEFAULT_UNBOX_DURATION_MS
            if (durationMs - player.currentPosition <= NEAR_COMPLETE_MS) return true
        }
        return false
    }

    /** Spin → landing → handoff chain; mounts the strip once the reel stage is laid out. */
    private suspend fun runReelPhase(
        itemBinding: ItemRewardCardPageBinding,
        strip: ReelStripBuilder.FixedReelStrip,
        winnerUrl: String,
        tileWidth: Int,
        tileHeight: Int,
        gapPx: Int,
    ) {
        val container = itemBinding.rouletteContainer
        val stripView = itemBinding.rouletteStrip

        stripView.isVisible = true
        stripView.alpha = 0f
        showReelBackgroundBeat(itemBinding)

        val containerWidth = container.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels

        stripView.removeAllViews()
        val inflater = LayoutInflater.from(context)
        val tiles = mutableListOf<View>()
        strip.items.forEach { item ->
            val slotBinding = ItemRouletteReelSlotBinding.inflate(inflater, stripView, false)
            (slotBinding.root.layoutParams as? LinearLayout.LayoutParams)?.apply {
                width = tileWidth
                height = tileHeight
                marginEnd = gapPx
            }
            val itemImageUrl = safeRewardImageUrl(item.itemUrl)
            val cached = itemImageUrl?.let { preloadedDrawables[it] }
            if (cached != null) {
                val drawable = cached.constantState?.newDrawable(resources) ?: cached
                slotBinding.slotImage.setImageDrawable(drawable)
                if (drawable is Animatable) {
                    drawable.start()
                }
            } else if (itemImageUrl != null) {
                Glide.with(this@KickDailyRewardDialog)
                    .load(buildKickGlideUrl(itemImageUrl))
                    .fallback(R.drawable.ic_kick_gem)
                    .error(R.drawable.ic_kick_gem)
                    .dontTransform()
                    .into(slotBinding.slotImage)
            } else {
                slotBinding.slotImage.setImageResource(R.drawable.ic_kick_gem)
            }
            stripView.addView(slotBinding.root)
            tiles.add(slotBinding.root)
        }

        val pitch = tileWidth + gapPx
        val invPitch = 1f / pitch
        val halfTileWidth = tileWidth / 2f
        val centerX = containerWidth / 2f
        val restX = centerX - halfTileWidth - strip.restIndex * pitch
        val targetX = centerX - halfTileWidth - strip.targetIndex * pitch
        val winnerIndex = strip.targetIndex.coerceIn(tiles.indices)
        stripView.translationX = restX

        fun updateTileTransforms(x: Float) {
            for (i in tiles.indices) {
                val tile = tiles[i]
                val tileCenter = tile.left + x + halfTileWidth
                val distance = abs(tileCenter - centerX)
                val fraction = (1f - distance * invPitch).coerceIn(0f, 1f)
                val scale = SIDE_TILE_SCALE + (CENTER_TILE_SCALE - SIDE_TILE_SCALE) * fraction
                tile.scaleX = scale
                tile.scaleY = scale
                tile.alpha = 0.55f + 0.45f * fraction
            }
        }

        // One layout pass so the per-tile scale formula sees real positions
        stripView.awaitNextLayout()
        if (isClaimHostGone()) {
            isClaiming = false
            return
        }

        // Apply starting tile transforms before becoming visible
        updateTileTransforms(restX)
        stripView.animate().alpha(1f).setDuration(CRATE_FADE_MS).start()

        // Spin: |targetIndex - restIndex| tiles at 3.5 tiles/s, cubic-bezier(0.18, 0.58, 0.12, 1)
        val spinDurationMs =
            ((strip.targetIndex - strip.restIndex).coerceAtLeast(0) / SPIN_TILES_PER_SECOND * 1000f).roundToLong()
        val spinAnimator = ValueAnimator.ofFloat(restX, targetX).apply {
            duration = spinDurationMs
            interpolator = SPIN_EASING
            addUpdateListener { va ->
                if (!isAdded || _binding == null) {
                    va.cancel()
                    return@addUpdateListener
                }
                val x = va.animatedValue as Float
                stripView.translationX = x
                updateTileTransforms(x)
            }
        }
        reelAnimator = spinAnimator
        spinAnimator.awaitCompletion()

        if (isClaimHostGone()) {
            isClaiming = false
            return
        }

        // Landing: dim non-winning tiles so winner commands attention
        for (i in tiles.indices) {
            if (i != winnerIndex) {
                tiles[i].animate().alpha(0.2f).setDuration(250L).start()
            }
        }

        // Punchy winner pop: shrink 1.2 -> 0.95 (180ms), then pop 0.95 -> 1.35 (320ms, overshoot)
        val winnerTile = tiles[winnerIndex]
        scaleAnimator(winnerTile, CENTER_TILE_SCALE, LANDING_SHRINK_SCALE, LANDING_SHRINK_MS, LANDING_SHRINK_EASING).awaitCompletion()

        if (isClaimHostGone()) {
            isClaiming = false
            return
        }

        scaleAnimator(winnerTile, LANDING_SHRINK_SCALE, LANDING_GROW_SCALE, LANDING_GROW_MS, LANDING_GROW_EASING).awaitCompletion()

        if (isClaimHostGone()) {
            isClaiming = false
            return
        }

        delay(180L)

        // Handoff: seamless morph into full-size winner card
        runHandoff(itemBinding, winnerUrl)
    }

    /** Fades out unbox crate, revealing the already-looping glitch-particle background video. */
    private fun showReelBackgroundBeat(itemBinding: ItemRewardCardPageBinding) {
        itemBinding.stageUnboxVideo.animate().alpha(0f).setDuration(CRATE_FADE_MS).start()
    }

    /** Handoff: stage fades + squishes while the winner card morphs smoothly from the tile pop. */
    private suspend fun runHandoff(itemBinding: ItemRewardCardPageBinding, winnerUrl: String) {
        val container = itemBinding.rouletteContainer
        val imageView = itemBinding.rewardImage

        val cachedWinner = preloadedDrawables[winnerUrl]
        if (cachedWinner != null) {
            val drawable = cachedWinner.constantState?.newDrawable(resources) ?: cachedWinner
            imageView.setImageDrawable(drawable)
            if (drawable is Animatable) {
                drawable.start()
            }
        } else {
            showRewardImage(imageView, winnerUrl)
        }
        imageView.isVisible = true
        imageView.alpha = 0f
        imageView.scaleX = LANDING_GROW_SCALE
        imageView.scaleY = LANDING_GROW_SCALE
        imageView.rotationX = 0f
        imageView.rotationY = 0f

        val handoff = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = HANDOFF_MS
            interpolator = HANDOFF_EASING
            addUpdateListener { va ->
                if (!isAdded || _binding == null) {
                    va.cancel()
                    return@addUpdateListener
                }
                val fraction = va.animatedValue as Float
                container.alpha = 1f - fraction
                val stageScale = 1f - 0.08f * fraction
                container.scaleX = stageScale
                container.scaleY = stageScale

                imageView.alpha = fraction
                val cardScale = LANDING_GROW_SCALE - (LANDING_GROW_SCALE - 1f) * fraction
                imageView.scaleX = cardScale
                imageView.scaleY = cardScale
            }
        }
        handoffAnimator = handoff
        handoff.awaitCompletion()
        if (isClaimHostGone()) {
            isClaiming = false
            return
        }

        container.isVisible = false
        container.alpha = 1f
        container.scaleX = 1f
        container.scaleY = 1f
        imageView.alpha = 1f
        imageView.scaleX = 1f
        imageView.scaleY = 1f

        // Web starts the card tilt right as the reel hands off (~700ms after HO started)
        startCardTilt(imageView)
        releaseStagePlayers()
    }

    private fun celebrate(
        activeChallenge: KickDailyChallenge,
        winner: KickDailyRewardWinner?,
        refresh: Boolean,
    ) {
        val currentBinding = _binding ?: run {
            isClaiming = false
            return
        }
        val rarity = winner?.rarity?.rarityLabel()
        val rarityColor = winner?.rarity?.let { rarityColor(it) } ?: COLOR_KICK_GREEN
        currentBinding.winnerRarityText.isVisible = rarity != null
        currentBinding.winnerRarityText.text = rarity?.let { getString(R.string.daily_reward_rarity, it) }
        currentBinding.winnerRarityText.setTextColor(rarityColor)
        currentBinding.statusText.setText(R.string.daily_reward_claimed)
        currentBinding.claimButton.isVisible = false
        currentBinding.shareButton.isVisible = shareCardUrl != null && hasShareUsername()
        currentBinding.cardViewPager.isUserInputEnabled = true
        currentBinding.loadingIndicator.isVisible = false
        isClaiming = false

        // Update in-memory active challenge so it reflects claimed status immediately
        val updatedChallenge = activeChallenge.copy(
            status = KickRewardsPolicy.STATUS_CLAIMED,
            winnerName = winner?.id,
            winnerRarity = winner?.rarity,
            winnerCardUrl = winner?.cardUrl ?: shareCardUrl,
        )
        challenges = challenges.map { if (it.id == activeChallenge.id) updatedChallenge else it }

        if (refresh) {
            pendingStreakPop = true
            lifecycleScope.launch {
                loadReward(isPeriodicRefresh = true, keepActiveCardView = true)
            }
        }
    }

    private fun startStagePlayers(
        appContext: Context,
        itemBinding: ItemRewardCardPageBinding,
        unboxServerUrl: String?,
    ) {
        releaseStagePlayers()
        val unboxUri = RouletteAnimationAssets.unboxSourceUri(appContext, unboxServerUrl)
        val defaultUri = RouletteAnimationAssets.unboxSourceUri(appContext, null)
        var usingDefaultUnbox = unboxUri == defaultUri
        var firstFrameRendered = false
        unboxPlayer = ExoPlayer.Builder(appContext).build().apply {
            setMediaItem(MediaItem.fromUri(unboxUri))
            volume = 0f
            repeatMode = Player.REPEAT_MODE_OFF
            playWhenReady = true
            itemBinding.stageUnboxVideo.player = this
            addListener(object : Player.Listener {
                override fun onRenderedFirstFrame() {
                    if (!firstFrameRendered) {
                        firstFrameRendered = true
                        itemBinding.rewardImage.isVisible = false
                    }
                }
                override fun onPlayerError(error: PlaybackException) {
                    // Server-hosted video unplayable — swap once to kick.com's own unbox.webm
                    if (!usingDefaultUnbox) {
                        usingDefaultUnbox = true
                        setMediaItem(MediaItem.fromUri(defaultUri))
                        prepare()
                    }
                }
            })
            prepare()
        }
        unboxPlayerView = itemBinding.stageUnboxVideo
        // Buffers & loops seamlessly underneath the unbox video; surface ready for the spin handoff
        backgroundPlayer = ExoPlayer.Builder(appContext).build().apply {
            setMediaItem(MediaItem.fromUri(RouletteAnimationAssets.backgroundSourceUri(appContext)))
            volume = 0f
            repeatMode = Player.REPEAT_MODE_ONE
            playWhenReady = true
            itemBinding.reelBackgroundVideo.player = this
            prepare()
        }
        backgroundPlayerView = itemBinding.reelBackgroundVideo
        itemBinding.reelBackgroundVideo.isVisible = true
    }

    private fun releaseStagePlayers() {
        unboxPlayerView?.player = null
        backgroundPlayerView?.player = null
        unboxPlayer?.release()
        unboxPlayer = null
        backgroundPlayer?.release()
        backgroundPlayer = null
        unboxPlayerView = null
        backgroundPlayerView = null
    }

    private fun isReducedMotionEnabled(): Boolean {
        val currentContext = context ?: return false
        return Settings.Global.getFloat(
            currentContext.contentResolver,
            Settings.Global.ANIMATOR_DURATION_SCALE,
            1f,
        ) == 0f
    }

    /** True when the claim animation lost its host (fragment detached or view destroyed). */
    private fun isClaimHostGone(): Boolean = !isAdded || _binding == null

    private fun getActiveCardViewHolder(): ChallengeCardAdapter.CardViewHolder? {
        val pager = _binding?.cardViewPager ?: return null
        val recyclerView = pager.getChildAt(0) as? RecyclerView ?: return null
        return recyclerView.findViewHolderForAdapterPosition(pager.currentItem) as? ChallengeCardAdapter.CardViewHolder
    }

    /** Loads the winner card image onto the stage (mounted above the fading reel). */
    private fun showRewardImage(imageView: ImageView, url: String) {
        if (!isAdded) return
        imageView.isVisible = true
        imageView.animate().cancel()
        imageView.rotationX = 0f
        imageView.rotationY = 0f
        val cached = preloadedDrawables[url]
        if (cached != null) {
            val drawable = cached.constantState?.newDrawable(resources) ?: cached
            imageView.setImageDrawable(drawable)
            if (drawable is Animatable) {
                drawable.start()
            }
        } else {
            Glide.with(this)
                .load(buildKickGlideUrl(url))
                .fallback(R.drawable.ic_kick_gem)
                .error(R.drawable.ic_kick_gem)
                .dontTransform()
                .into(imageView)
        }
    }

    /** kick.com entrance: card scales 1.5 → 1 over 700ms, bezier(0.45, 0.05, 0.55, 0.95). */
    private fun startCardEntrance(imageView: ImageView) {
        entranceAnimator?.cancel()
        imageView.scaleX = CARD_ENTRANCE_INITIAL_SCALE
        imageView.scaleY = CARD_ENTRANCE_INITIAL_SCALE
        entranceAnimator = scaleAnimator(
            imageView,
            CARD_ENTRANCE_INITIAL_SCALE,
            1f,
            CARD_ENTRANCE_MS,
            CARD_ENTRANCE_EASING,
        )
        entranceAnimator?.start()
    }

    /** kick.com tilt: 23° on X/Y for 3s × 5 cycles (ease-in-out segments, camera at 800px). */
    private fun startCardTilt(imageView: ImageView) {
        tiltAnimator?.cancel()
        imageView.cameraDistance = TILT_CAMERA_DISTANCE * resources.displayMetrics.density
        tiltAnimator = ValueAnimator.ofFloat(0f, 2f).apply {
            duration = TILT_DURATION_MS
            repeatCount = TILT_REPEAT_COUNT
            interpolator = LinearInterpolator()
            addUpdateListener { va ->
                if (!isAdded || _binding == null) {
                    va.cancel()
                    return@addUpdateListener
                }
                val phase = va.animatedValue as Float
                // 0° → 23° (first half), 23° → 0° (second half), eased per segment
                val eased = smoothstep(if (phase <= 1f) phase else phase - 1f)
                val angle = TILT_MAX_ANGLE * if (phase <= 1f) eased else 1f - eased
                imageView.rotationX = angle
                imageView.rotationY = angle
            }
        }
        tiltAnimator?.start()
    }

    private fun smoothstep(x: Float): Float = x * x * (3f - 2f * x)

    /** kick.com streak-count pop: 1 → 1.5 → 0.92 → 1.14 → 0.98 → 1 with tiny lift. */
    private fun startStreakPop(text: TextView) {
        streakPopAnimator?.cancel()
        val density = resources.displayMetrics.density
        val fractions = floatArrayOf(0f, 0.22f, 0.48f, 0.70f, 0.86f, 1f)
        fun keyframes(vararg values: Float): Array<Keyframe> =
            values.mapIndexed { index, value ->
                Keyframe.ofFloat(fractions[index], value).apply {
                    if (index < fractions.lastIndex) interpolator = DecelerateInterpolator()
                }
            }.toTypedArray()

        streakPopAnimator = ObjectAnimator.ofPropertyValuesHolder(
            text,
            PropertyValuesHolder.ofKeyframe("scaleX", *keyframes(1f, 1.5f, 0.92f, 1.14f, 0.98f, 1f)),
            PropertyValuesHolder.ofKeyframe("scaleY", *keyframes(1f, 1.5f, 0.92f, 1.14f, 0.98f, 1f)),
            PropertyValuesHolder.ofKeyframe(
                "translationY",
                *keyframes(0f, -3f * density, 0f, -1f * density, 0f, 0f),
            ),
        ).apply {
            duration = STREAK_POP_MS
            start()
        }
    }

    /** Resumes when the animator finishes or is cancelled; cancelling the coroutine cancels it. */
    private suspend fun Animator.awaitCompletion() {
        suspendCancellableCoroutine<Unit> { continuation ->
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    if (continuation.isActive) continuation.resume(Unit)
                }
            })
            continuation.invokeOnCancellation { cancel() }
            start()
        }
    }

    /** Animates a single view's uniform scaleX/scaleY; start it via `awaitCompletion()` or `start()`. */
    private fun scaleAnimator(
        view: View,
        from: Float,
        to: Float,
        durationMs: Long,
        easing: TimeInterpolator,
    ): ValueAnimator = ValueAnimator.ofFloat(from, to).apply {
        duration = durationMs
        interpolator = easing
        addUpdateListener { va ->
            if (!isAdded || _binding == null) {
                va.cancel()
                return@addUpdateListener
            }
            val scale = va.animatedValue as Float
            view.scaleX = scale
            view.scaleY = scale
        }
    }

    private suspend fun View.awaitNextLayout() {
        suspendCancellableCoroutine<Unit> { continuation ->
            doOnNextLayout {
                if (continuation.isActive) continuation.resume(Unit)
            }
        }
    }

    private fun buildKickGlideUrl(url: String): GlideUrl {
        return GlideUrl(url) {
            if (url.contains(".kick.com", ignoreCase = true)) {
                KICK_IMAGE_HEADERS
            } else {
                BASE_IMAGE_HEADERS
            }
        }
    }

    /** Loads the persisted JSON of the last real claim so the debug sim replays the exact data shape. */
    private fun lastRealClaimOrNull(): KickDailyClaimResult? {
        val json = context?.prefs()?.getString(AppConstants.REWARD_LAST_CLAIM_RESULT, null)
            ?.takeIf { it.isNotBlank() } ?: return null
        return runCatching {
            KickRewardsParsing.parseDailyClaim(Json.parseToJsonElement(json))
        }.getOrNull()
            ?.takeIf { it.roulette.isNotEmpty() && it.winner != null }
    }

    private fun recordClaim(context: Context, activeChallenge: KickDailyChallenge, result: KickDailyClaimResult) {
        val now = System.currentTimeMillis()
        val isStandardDaily = activeChallenge.recurrence.equals("daily", ignoreCase = true) && !activeChallenge.featured
        val rarityKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_RARITY else "${AppConstants.REWARD_LAST_DAILY_RARITY}_${activeChallenge.id}"
        val cardKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_CARD_URL else "${AppConstants.REWARD_LAST_DAILY_CARD_URL}_${activeChallenge.id}"
        // Raw claim payload for the debug sim's 1:1 replay (simulated claims never hit this path)
        val claimJson = runCatching { result.toJsonElement().toString() }.getOrNull()

        context.prefs().edit {
            putLong(AppConstants.REWARD_LAST_CLAIM_AT, now)
            claimJson?.let { putString(AppConstants.REWARD_LAST_CLAIM_RESULT, it) }
            result.winner?.rarity?.let { putString(rarityKey, it) }
            result.winner?.cardUrl?.let { putString(cardKey, it) }
            if (isStandardDaily) {
                val resetAt = KickRewardsPolicy.resetTimeMs(activeChallenge, now)
                putLong(AppConstants.REWARD_DAILY_CLAIMED_UNTIL, resetAt)
                remove(AppConstants.REWARD_DAILY_BACKOFF_UNTIL)
            }
        }
        if (isStandardDaily && context.prefs().getBoolean(AppConstants.REWARD_AUTO_CLAIM_ENABLED, false)) {
            val resetAt = KickRewardsPolicy.resetTimeMs(activeChallenge, now)
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

    private fun shareUsername(context: Context): String? = context.tokenPrefs()
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

    inner class ChallengeCardAdapter : RecyclerView.Adapter<ChallengeCardAdapter.CardViewHolder>() {

        inner class CardViewHolder(val itemBinding: ItemRewardCardPageBinding) :
            RecyclerView.ViewHolder(itemBinding.root) {

            fun bind(ch: KickDailyChallenge) {
                itemBinding.rouletteContainer.isVisible = false
                itemBinding.rouletteContainer.alpha = 1f
                itemBinding.rouletteContainer.scaleX = 1f
                itemBinding.rouletteContainer.scaleY = 1f
                itemBinding.rouletteStrip.removeAllViews()
                itemBinding.rouletteStrip.isVisible = true
                itemBinding.reelBackgroundVideo.isVisible = true
                itemBinding.stageUnboxVideo.alpha = 1f
                itemBinding.rewardImage.isVisible = true
                itemBinding.rewardImage.alpha = 1f
                itemBinding.rewardImage.scaleX = 1f
                itemBinding.rewardImage.scaleY = 1f

                val isClaimed = ch.status.equals(KickRewardsPolicy.STATUS_CLAIMED, ignoreCase = true)
                val isStandardDaily = ch.recurrence.equals("daily", ignoreCase = true) && !ch.featured
                val prefKey = if (isStandardDaily) AppConstants.REWARD_LAST_DAILY_CARD_URL else "${AppConstants.REWARD_LAST_DAILY_CARD_URL}_${ch.id}"
                val savedCardUrl = context?.prefs()?.getString(prefKey, null)

                val imageUrl = if (isClaimed) {
                    safeRewardImageUrl(ch.winnerCardUrl) ?: safeRewardImageUrl(savedCardUrl)
                } else {
                    safeRewardImageUrl(ch.idleAnimationUrl)
                }

                if (imageUrl != null) {
                    val cached = preloadedDrawables[imageUrl]
                    if (cached != null) {
                        val drawable = cached.constantState?.newDrawable(resources) ?: cached
                        itemBinding.rewardImage.setImageDrawable(drawable)
                        if (drawable is Animatable) {
                            drawable.start()
                        }
                    } else {
                        Glide.with(this@KickDailyRewardDialog)
                            .load(buildKickGlideUrl(imageUrl))
                            .dontTransform()
                            .into(itemBinding.rewardImage)
                    }
                } else {
                    Glide.with(this@KickDailyRewardDialog).clear(itemBinding.rewardImage)
                    itemBinding.rewardImage.setImageDrawable(null)
                }

                if (BuildConfig.DEBUG) {
                    itemBinding.rewardCard.setOnLongClickListener {
                        simulateClaim(ch)
                        true
                    }
                } else {
                    itemBinding.rewardCard.setOnLongClickListener(null)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
            val itemBinding = ItemRewardCardPageBinding.inflate(layoutInflater, parent, false)
            return CardViewHolder(itemBinding)
        }

        override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
            holder.bind(challenges[position])
        }

        override fun getItemCount(): Int = challenges.size
    }

    companion object {
        private const val TAG = "kick_daily_reward"
        private const val COLOR_KICK_GREEN = 0xFF53FC18.toInt()
        private const val COLOR_KICK_GREEN_DISABLED = 0x4D53FC18.toInt()

        // --- kick.com daily-rewards roulette constants, decoded from minified chunks & tuned for fluid mobile feel ---
        private const val VISIBLE_TILES = 3                 // el
        private const val REEL_GAP_DP = 8f                  // ei
        private const val REEL_TILE_H_RATIO = 160f / 120f   // tile height = width * 160/120
        private const val SPIN_TILES_PER_SECOND = 3.5f      // eo
        private const val CENTER_TILE_SCALE = 1.2f          // ep
        private const val SIDE_TILE_SCALE = 0.8f            // eg
        private const val LANDING_SHRINK_MS = 180L
        private const val LANDING_GROW_MS = 320L
        private const val LANDING_SHRINK_SCALE = 0.95f
        private const val LANDING_GROW_SCALE = 1.35f
        private const val HANDOFF_MS = 420L                 // M
        private const val CRATE_FADE_MS = 300L
        private const val CARD_ENTRANCE_MS = 700L           // k
        private const val CARD_ENTRANCE_INITIAL_SCALE = 1.5f // y
        private const val TILT_DURATION_MS = 3000L          // Q
        private const val TILT_REPEAT_COUNT = 4             // c=5 cycles: first run + 4 replays
        private const val TILT_MAX_ANGLE = 23f
        private const val TILT_CAMERA_DISTANCE = 800f
        private const val STREAK_POP_MS = 700L
        private const val NEAR_COMPLETE_MS = 1000L          // T: reel starts in the unbox's last second
        private const val UNBOX_POLL_INTERVAL_MS = 50L
        private const val UNBOX_WAIT_TIMEOUT_MS = 15_000L   // bail out if the video never gets NEAR
        private const val DEFAULT_UNBOX_DURATION_MS = 2680L

        private val SPIN_EASING = PathInterpolator(0.18f, 0.58f, 0.12f, 1f)
        private val LANDING_SHRINK_EASING = PathInterpolator(0.4f, 0f, 0.6f, 1f)
        private val LANDING_GROW_EASING = PathInterpolator(0.15f, 0.85f, 0.35f, 1.2f)
        private val HANDOFF_EASING = PathInterpolator(0.2f, 0.8f, 0.3f, 1f)
        private val CARD_ENTRANCE_EASING = PathInterpolator(0.45f, 0.05f, 0.55f, 0.95f)

        private val FALLBACK_ROULETTE_URLS = listOf(
            "https://files.kick.com/emotes/37217/fullsize",
            "https://files.kick.com/emotes/37218/fullsize",
            "https://files.kick.com/emotes/37219/fullsize",
            "https://files.kick.com/emotes/37220/fullsize",
            "https://files.kick.com/emotes/29015/fullsize",
        )

        private val BASE_IMAGE_HEADERS = mapOf(
            "User-Agent" to "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36"
        )
        private val KICK_IMAGE_HEADERS = mapOf(
            "User-Agent" to "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36",
            "Referer" to "https://kick.com/"
        )

        fun show(fragmentManager: FragmentManager) {
            if (fragmentManager.findFragmentByTag(TAG) == null) {
                KickDailyRewardDialog().show(fragmentManager, TAG)
            }
        }
    }
}
