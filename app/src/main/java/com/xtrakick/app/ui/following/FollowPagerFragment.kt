package com.xtrakick.app.ui.following

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentMediaPagerBinding
import com.xtrakick.app.ui.common.FragmentHost
import com.xtrakick.app.ui.common.Scrollable
import com.xtrakick.app.ui.common.Sortable
import com.xtrakick.app.ui.login.LoginActivity
import com.xtrakick.app.ui.main.KickDailyRewardDialog
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.ui.search.SearchPagerFragmentDirections
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.reduceDragSensitivity
import com.xtrakick.app.util.observeLift
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.xtrakick.app.ui.notifications.NotificationChannelsFragmentDirections
import android.graphics.Color
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.color.MaterialColors
import com.xtrakick.app.repository.KickRewardsPolicy
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.NotificationPermissionHelper
import kotlinx.coroutines.flow.merge

@AndroidEntryPoint
class FollowPagerFragment : Fragment(), Scrollable, FragmentHost, KickFollowImportDialog.CallbackListener {

    @Inject
    lateinit var kickFollowImporter: KickFollowImporter

    @Inject
    lateinit var localFollowChannelRepository: LocalFollowChannelRepository

    @Inject
    lateinit var rewardsRepository: KickRewardsRepository

    private var _binding: FragmentMediaPagerBinding? = null
    private val binding get() = _binding!!
    private var firstLaunch = true
    private var stopObservingLift: (() -> Unit)? = null

    override val currentFragment: Fragment?
        get() = childFragmentManager.findFragmentByTag("f${binding.viewPager.currentItem}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firstLaunch = savedInstanceState == null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMediaPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    kickFollowImporter.importState.collect { state ->
                        when (state) {
                            is KickFollowImportState.Importing -> {
                                if (!AuthStateHelper.isKickLoggedIn(requireContext())) {
                                    importProgressContainer.visibility = View.GONE
                                    importProgressContainer.setOnClickListener(null)
                                } else {
                                    importProgressContainer.setOnClickListener(null)
                                    if (importProgressContainer.visibility != View.VISIBLE) {
                                        importProgressContainer.alpha = 0f
                                        importProgressContainer.visibility = View.VISIBLE
                                        importProgressContainer.animate()
                                            .alpha(1f)
                                            .setDuration(180L)
                                            .setInterpolator(DecelerateInterpolator())
                                            .start()
                                    }
                                    importProgressBar.visibility = View.VISIBLE
                                    if (state.count > 0) {
                                        importProgressText.text = getString(R.string.importing_kick_follows_progress, state.count)
                                    } else {
                                        importProgressText.text = getString(R.string.importing_kick_follows)
                                    }
                                }
                            }
                            is KickFollowImportState.Success -> {
                                if (state.count > 0) {
                                    importProgressBar.visibility = View.GONE
                                    importProgressText.text = getString(R.string.import_kick_followed_success, state.count)
                                    delay(2500L)
                                    importProgressContainer.animate()
                                        .alpha(0f)
                                        .setDuration(180L)
                                        .setInterpolator(DecelerateInterpolator())
                                        .withEndAction {
                                            importProgressContainer.visibility = View.GONE
                                            importProgressContainer.alpha = 1f
                                        }
                                        .start()
                                    activity?.let { act ->
                                        if (NotificationPermissionHelper.shouldPromptContextual(act)) {
                                            (act as? MainActivity)?.requestNotificationPermissionWithPrimer()
                                        }
                                    }
                                } else {
                                    importProgressContainer.visibility = View.GONE
                                }
                                updateNotificationBanner()
                            }
                            is KickFollowImportState.NeedsManualImport -> {
                                if (!AuthStateHelper.isKickLoggedIn(requireContext())) {
                                    importProgressContainer.visibility = View.GONE
                                    importProgressContainer.setOnClickListener(null)
                                } else {
                                    importProgressBar.visibility = View.GONE
                                    importProgressText.text = getString(R.string.import_kick_followed_manual_hint)
                                    importProgressContainer.visibility = View.VISIBLE
                                    importProgressContainer.alpha = 1f
                                    importProgressContainer.setOnClickListener {
                                        KickFollowImportDialog().show(childFragmentManager, "kick_follow_import")
                                    }
                                }
                            }
                            is KickFollowImportState.Error,
                            is KickFollowImportState.Idle -> {
                                importProgressContainer.visibility = View.GONE
                                importProgressContainer.setOnClickListener(null)
                            }
                        }
                    }
                }
            }

            val activity = requireActivity() as MainActivity
            val navController = findNavController()
            val isLoggedIn = com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())
            toolbar.navigationIcon = AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_notifications_none_black_24)
                ?.mutate()
                ?.apply { setTint(MaterialColors.getColor(requireContext(), androidx.appcompat.R.attr.colorControlNormal, Color.WHITE)) }
            toolbar.navigationContentDescription = getString(R.string.live_notification_channels)
            toolbar.setNavigationOnClickListener {
                findNavController().navigate(NotificationChannelsFragmentDirections.actionGlobalNotificationChannelsFragment())
            }

            val isRewardsEnabled = requireContext().prefs().getBoolean(AppConstants.KICK_DAILY_REWARDS_ENABLED, true)
            toolbar.menu.findItem(R.id.login).title = if (isLoggedIn) getString(R.string.log_out) else getString(R.string.log_in)
            toolbar.menu.findItem(R.id.importKickFollowed)?.isVisible = isLoggedIn
            updateDailyRewardMenuButton()
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    rewardsRepository.dailyChallengesFlow.collect {
                        updateDailyRewardMenuButton()
                    }
                }
            }
            toolbar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.search -> {
                        findNavController().navigate(SearchPagerFragmentDirections.actionGlobalSearchPagerFragment())
                        true
                    }
                    R.id.settings -> {
                        activity.launchSettings()
                        true
                    }
                    R.id.login -> {
                        if (isLoggedIn) {
                            activity.getAlertDialogBuilder().apply {
                                setTitle(getString(R.string.logout_title))
                                requireContext().tokenPrefs().getString(AppConstants.USERNAME, null)?.let { setMessage(getString(R.string.logout_msg, it)) }
                                setNegativeButton(getString(R.string.no), null)
                                setPositiveButton(getString(R.string.yes)) { _, _ -> activity.logoutResultLauncher?.launch(Intent(activity, LoginActivity::class.java).putExtra(AppConstants.LOGIN_LOGOUT_ONLY, true)) }
                            }.show()
                        } else {
                            activity.loginResultLauncher?.launch(Intent(activity, LoginActivity::class.java))
                        }
                        true
                    }
                    R.id.importKickFollowed -> {
                        KickFollowImportDialog().show(childFragmentManager, "kick_follow_import")
                        true
                    }
                    R.id.dailyReward -> {
                        KickDailyRewardDialog.show(parentFragmentManager)
                        true
                    }
                    else -> false
                }
            }
            val tabList = requireContext().prefs().getString(AppConstants.UI_FOLLOWING_TABS, null).let { tabPref ->
                val defaultTabs = AppConstants.DEFAULT_FOLLOWING_TABS.split(',')
                if (tabPref != null) {
                    val list = tabPref.split(',').filter { item ->
                        defaultTabs.find { it.first() == item.first() } != null
                    }.toMutableList()
                    defaultTabs.forEachIndexed { index, item ->
                        if (list.find { it.first() == item.first() } == null) {
                            list.add(index, item)
                        }
                    }
                    list
                } else defaultTabs
            }
            val tabs = tabList.mapNotNull {
                val split = it.split(':')
                val key = split[0]
                val enabled = split[2] != "0"
                if (enabled) {
                    key
                } else {
                    null
                }
            }
            if (tabs.size <= 1) {
                tabLayout.visibility = View.GONE
            } else {
                if (tabs.size >= 5) {
                    tabLayout.tabGravity = TabLayout.GRAVITY_CENTER
                    tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
                }
            }
            val adapter = FollowPagerAdapter(this@FollowPagerFragment, tabs)
            viewPager.adapter = adapter
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    viewPager.doOnLayout {
                        childFragmentManager.findFragmentByTag("f${position}")?.let { fragment ->
                            if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                                fragment.view?.findViewById<RecyclerView>(R.id.recyclerView)?.let {
                                    stopObservingLift?.invoke()
                                    stopObservingLift = appBar.observeLift(it)
                                }
                            } else {
                                appBar.setLiftable(false)
                                appBar.background = null
                            }
                            if (fragment is Sortable) {
                                fragment.setupSortBar(sortBar)
                            } else {
                                sortBar.root.visibility = View.GONE
                            }
                        }
                    }
                }
            })
            if (firstLaunch) {
                val defaultItem = tabList.find { it.split(':')[1] != "0" }?.split(':')[0] ?: "1"
                viewPager.setCurrentItem(
                    tabs.indexOf(defaultItem).takeIf { it != -1 } ?: tabs.indexOf("1").takeIf { it != -1 } ?: 0,
                    false
                )
                firstLaunch = false
            }
            viewPager.offscreenPageLimit = 1
            viewPager.reduceDragSensitivity()
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (tabs.getOrNull(position)) {
                    "0" -> getString(R.string.games)
                    "1" -> getString(R.string.live)
                    "2" -> getString(R.string.channels)
                    else -> getString(R.string.live)
                }
            }.attach()
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    topMargin = insets.top
                }
                windowInsets
            }

            btnEnableNotifications.setOnClickListener {
                activity.requestNotificationPermissionWithPrimer(forcePrompt = true)
            }
            btnDismissNotificationBanner.setOnClickListener {
                val ctx = context ?: return@setOnClickListener
                NotificationPermissionHelper.markBannerDismissed(ctx)
                notificationPermissionBanner.visibility = View.GONE
            }
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    merge(localFollowChannelRepository.followsChanged, AuthStateHelper.authStateChanged).collect {
                        val isLoggedIn = AuthStateHelper.isKickLoggedIn(requireContext())
                        if (!isLoggedIn) {
                            kickFollowImporter.resetState()
                            importProgressContainer.visibility = View.GONE
                            importProgressContainer.setOnClickListener(null)
                        }
                        updateNotificationBanner()
                    }
                }
            }
            updateNotificationBanner()
        }
    }

    private fun updateNotificationBanner() {
        val context = context ?: return
        if (_binding == null) return
        if (NotificationPermissionHelper.hasPermission(context) ||
            NotificationPermissionHelper.isBannerDismissed(context)
        ) {
            binding.notificationPermissionBanner.visibility = View.GONE
            return
        }
        viewLifecycleOwner.lifecycleScope.launch {
            val hasFollows = localFollowChannelRepository.loadFollows().isNotEmpty()
            if (_binding != null && isAdded) {
                binding.notificationPermissionBanner.visibility = if (hasFollows) View.VISIBLE else View.GONE
            }
        }
    }

    override fun scrollToTop() {
        binding.appBar.setExpanded(true, true)
        (currentFragment as? Scrollable)?.scrollToTop()
    }

    override fun onKickFollowImportFinished(importedCount: Int) {
        childFragmentManager.fragments.forEach { fragment ->
            (fragment as? com.xtrakick.app.ui.common.IntegrityDialog.CallbackListener)
                ?.onIntegrityDialogCallback("refresh")
        }
    }

    override fun onResume() {
        super.onResume()
        _binding?.let { b ->
            updateDailyRewardMenuButton()
            updateNotificationBanner()
            if (AuthStateHelper.isKickLoggedIn(requireContext()) && requireContext().prefs().getBoolean(AppConstants.KICK_DAILY_REWARDS_ENABLED, true)) {
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                    rewardsRepository.refreshDailyChallenges()
                }
            }
        }
    }

    private fun updateDailyRewardMenuButton() {
        val b = _binding ?: return
        val context = context ?: return
        val isLoggedIn = AuthStateHelper.isKickLoggedIn(context)
        val isRewardsEnabled = context.prefs().getBoolean(AppConstants.KICK_DAILY_REWARDS_ENABLED, true)
        val menuItem = b.toolbar.menu.findItem(R.id.dailyReward) ?: return
        menuItem.isVisible = isLoggedIn && isRewardsEnabled
        if (!menuItem.isVisible) return

        val isClaimable = KickRewardsPolicy.hasClaimableChallenge(rewardsRepository.dailyChallengesFlow.value)
        if (isClaimable) {
            menuItem.setIcon(R.drawable.baseline_card_giftcard_claimable_24)
            menuItem.iconTintList = null
        } else {
            menuItem.setIcon(R.drawable.baseline_card_giftcard_black_24)
            menuItem.iconTintList = MaterialColors.getColorStateListOrNull(context, androidx.appcompat.R.attr.colorControlNormal)
        }
    }

    override fun onDestroyView() {
        stopObservingLift?.invoke()
        stopObservingLift = null
        super.onDestroyView()
        _binding = null
    }
}
