package com.xtrakick.app.ui.following

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
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
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.xtrakick.app.ui.notifications.NotificationChannelsFragmentDirections
import android.graphics.Color
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.color.MaterialColors

@AndroidEntryPoint
class FollowPagerFragment : Fragment(), Scrollable, FragmentHost, KickFollowImportDialog.CallbackListener {

    @Inject
    lateinit var kickFollowImporter: KickFollowImporter

    private var _binding: FragmentMediaPagerBinding? = null
    private val binding get() = _binding!!
    private var firstLaunch = true

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
                                importProgressContainer.alpha = 1f
                                importProgressContainer.visibility = View.VISIBLE
                                importProgressBar.visibility = View.VISIBLE
                                if (state.count > 0) {
                                    importProgressText.text = getString(R.string.importing_kick_follows_progress, state.count)
                                } else {
                                    importProgressText.text = getString(R.string.importing_kick_follows)
                                }
                            }
                            is KickFollowImportState.Success -> {
                                if (state.count > 0) {
                                    importProgressBar.visibility = View.GONE
                                    importProgressText.text = getString(R.string.import_kick_followed_success, state.count)
                                    delay(2500L)
                                    importProgressContainer.animate()
                                        .alpha(0f)
                                        .setDuration(300)
                                        .withEndAction {
                                            importProgressContainer.visibility = View.GONE
                                            importProgressContainer.alpha = 1f
                                        }
                                        .start()
                                } else {
                                    importProgressContainer.visibility = View.GONE
                                }
                            }
                            is KickFollowImportState.Error,
                            is KickFollowImportState.Idle -> {
                                importProgressContainer.visibility = View.GONE
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

            toolbar.menu.findItem(R.id.login).title = if (isLoggedIn) getString(R.string.log_out) else getString(R.string.log_in)
            toolbar.menu.findItem(R.id.importKickFollowed)?.isVisible = isLoggedIn
            toolbar.menu.findItem(R.id.dailyReward)?.isVisible = isLoggedIn
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
                                    appBar.setLiftOnScrollTargetView(it)
                                    it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                                            super.onScrolled(recyclerView, dx, dy)
                                            appBar.isLifted = recyclerView.canScrollVertically(-1)
                                        }
                                    })
                                    it.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
                                        appBar.isLifted = it.canScrollVertically(-1)
                                    }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
