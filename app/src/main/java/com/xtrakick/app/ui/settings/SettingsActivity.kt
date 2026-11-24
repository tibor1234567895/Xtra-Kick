package com.xtrakick.app.ui.settings

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import com.xtrakick.app.ui.login.LoginActivity
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.provider.Settings
import android.text.format.Formatter
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.core.os.LocaleListCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.withResumed
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.SeekBarPreference
import androidx.preference.SwitchPreferenceCompat
import androidx.preference.forEach
import androidx.recyclerview.widget.ItemTouchHelper
import com.xtrakick.app.ui.view.SafeLinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.service.FcmDeliveryWorker
import com.xtrakick.app.R
import com.xtrakick.app.SettingsNavGraphDirections
import com.xtrakick.app.util.AppUpdateDialogHelper
import com.xtrakick.app.databinding.ActivitySettingsBinding
import com.xtrakick.app.model.kick.KickEventSubscription
import com.xtrakick.app.model.kick.KickEventSubscriptionRequestItem
import com.xtrakick.app.model.ui.SettingsDragListItem
import com.xtrakick.app.repository.KickOfficialApiValidationUtils
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.ui.main.RewardClaimScheduler
import com.xtrakick.app.ui.common.BaseStateActivity
import com.xtrakick.app.ui.common.CompactDialogs.constrainSheets
import com.xtrakick.app.ui.following.KickFollowImportDialog
import com.xtrakick.app.ui.player.LiveLatencySettings
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.AppConstants
import kotlin.math.max
import kotlin.math.roundToInt
import com.xtrakick.app.util.BatteryOptimizationHelper
import com.xtrakick.app.util.CrashReports
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.KickOAuthConfig
import com.xtrakick.app.util.applyTheme
import com.xtrakick.app.util.chat.ChatBackgroundUtils
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.getProxyPassword
import com.xtrakick.app.util.observeAppUpdateResults
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.setProxyPassword
import com.xtrakick.app.util.tokenPrefs
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Collections
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : BaseStateActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private var changed = false
    var searchItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeAppUpdateResults()
        supportFragmentManager.constrainSheets()
        if (savedInstanceState?.getBoolean(KEY_CHANGED) == true) {
            setResult()
        }
        applyTheme()
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ignoreCutouts = prefs().getBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            binding.toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
            }
            val cutoutInsets = if (ignoreCutouts) {
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            } else {
                insets
            }
            binding.appBar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = cutoutInsets.left
                rightMargin = cutoutInsets.right
            }
            binding.navHostFragment.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = cutoutInsets.left
                rightMargin = cutoutInsets.right
            }
            windowInsets
        }
        val navController = (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
        val appBarConfiguration = AppBarConfiguration(setOf(), fallbackOnNavigateUpListener = {
            onBackPressedDispatcher.onBackPressed()
            true
        })
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    navController.navigate(SettingsNavGraphDirections.actionGlobalSettingsSearchFragment())
                    true
                }
                else -> false
            }
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            private var job: Job? = null

            override fun onQueryTextSubmit(query: String): Boolean {
                (supportFragmentManager.findFragmentById(R.id.navHostFragment)?.childFragmentManager?.fragments?.getOrNull(0) as? SettingsSearchFragment)?.search(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                job?.cancel()
                if (newText.isNotEmpty()) {
                    job = lifecycleScope.launch {
                        delay(750)
                        withResumed {
                            (supportFragmentManager.findFragmentById(R.id.navHostFragment)?.childFragmentManager?.fragments?.getOrNull(0) as? SettingsSearchFragment)?.search(newText)
                        }
                    }
                } else {
                    (supportFragmentManager.findFragmentById(R.id.navHostFragment)?.childFragmentManager?.fragments?.getOrNull(0) as? SettingsSearchFragment)?.search(newText)
                }
                return false
            }
        })
    }

    fun showDragListDialog(list: List<SettingsDragListItem>, prefKey: String, title: CharSequence?) {
        val listAdapter = SettingsDragListAdapter()
        val itemTouchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                    Collections.swap(list, viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
                    listAdapter.notifyItemMoved(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

                override fun isLongPressDragEnabled(): Boolean {
                    return false
                }
            }
        )
        listAdapter.itemTouchHelper = itemTouchHelper
        val recyclerView = RecyclerView(this).apply {
            layoutManager = SafeLinearLayoutManager(this@SettingsActivity)
            adapter = listAdapter
            val padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10F, resources.displayMetrics).toInt()
            setPadding(0, padding, 0, 0)
        }
        listAdapter.setDefault = { item ->
            list.find { it.default }?.let { previous ->
                previous.default = false
                recyclerView.findViewHolderForAdapterPosition(
                    list.indexOf(previous)
                )?.itemView?.findViewById<ImageButton>(R.id.setAsDefault)?.let {
                    it.setImageResource(R.drawable.outline_home_black_24)
                    it.isClickable = true
                }
            }
            item.default = true
        }
        itemTouchHelper.attachToRecyclerView(recyclerView)
        listAdapter.submitList(list)
        getAlertDialogBuilder()
            .setTitle(title)
            .setView(recyclerView)
            .setPositiveButton(getString(android.R.string.ok)) { _, _ ->
                prefs().edit {
                    putString(prefKey, listAdapter.currentList.joinToString(",") {
                        "${it.key}:${if (it.default) "1" else "0"}:${if (it.enabled) "1" else "0"}"
                    })
                    setResult()
                }
            }
            .setNegativeButton(getString(android.R.string.cancel), null)
            .show()
    }

    internal fun showSearchView(showSearch: Boolean) {
        with(binding) {
            if (showSearch) {
                toolbar.menu.findItem(R.id.search).isVisible = false
                searchView.visibility = View.VISIBLE
            } else {
                toolbar.menu.findItem(R.id.search).isVisible = true
                searchView.setQuery(null, false)
                searchView.visibility = View.GONE
            }
        }
    }

    internal fun setResult() {
        if (!changed) {
            changed = true
            setResult(RESULT_OK)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(KEY_CHANGED, changed)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val KEY_CHANGED = "changed"
    }

    class SettingsFragment : MaterialPreferenceFragment() {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            updateAccountSummary()
            findPreference<Preference>("nav_api_token_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalApiTokenSettingsFragment())
                true
            }
            findPreference<Preference>("nav_appearance_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalAppearanceSettingsFragment())
                true
            }
            findPreference<Preference>("nav_player_overview")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerOverviewFragment())
                true
            }
            findPreference<Preference>("nav_chat_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalChatSettingsFragment())
                true
            }
            findPreference<Preference>("nav_notifications_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalNotificationsSettingsFragment())
                true
            }
            findPreference<Preference>("nav_download_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalDownloadSettingsFragment())
                true
            }
            findPreference<Preference>("nav_advanced_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalAdvancedSettingsFragment())
                true
            }
            findPreference<Preference>("action_open_supported_links")?.let { pref ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    pref.setOnPreferenceClickListener {
                        val pkgUri = "package:${requireContext().packageName}".toUri()
                        val openByDefault = Intent(Settings.ACTION_APP_OPEN_BY_DEFAULT_SETTINGS, pkgUri)
                        try {
                            startActivity(openByDefault)
                        } catch (_: ActivityNotFoundException) {
                            runCatching {
                                startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, pkgUri))
                            }
                        }
                        true
                    }
                } else {
                    pref.isVisible = false
                }
            }
        }

        override fun onResume() {
            super.onResume()
            updateAccountSummary()
        }

        private fun updateAccountSummary() {
            findPreference<Preference>("nav_api_token_settings")?.apply {
                val context = requireContext()
                val username = context.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)?.takeIf { it.isNotBlank() }
                summary = when {
                    username != null -> getString(R.string.logged_in_as_summary, username)
                    AuthStateHelper.hasUnreadableKickSession(context) -> getString(R.string.kick_session_unavailable)
                    else -> getString(R.string.log_in_to_kick_summary)
                }
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class NotificationsSettingsFragment : MaterialPreferenceFragment() {
        private val viewModel: SettingsViewModel by activityViewModels()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.notifications_preferences, rootKey)
            findPreference<SwitchPreferenceCompat>(AppConstants.LIVE_NOTIFICATIONS_ENABLED)?.setOnPreferenceChangeListener { _, newValue ->
                val context = requireContext()
                val enabled = newValue as Boolean
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                    ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
                }
                context.prefs().edit { putBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, enabled) }
                if (!BuildConfig.DEBUG) {
                    FcmDeliveryWorker.enqueueTokenSync(context, deduplicatePending = false)
                }
                viewModel.toggleNotifications(
                    enabled = enabled,
                    networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), true),
                    kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(requireContext())
                )
                if (enabled) {
                    BatteryOptimizationHelper.maybePrompt(requireActivity())
                }
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.LIVE_NOTIFICATIONS_POLLING_BACKUP)?.setOnPreferenceChangeListener { _, newValue ->
                viewModel.togglePollingBackup(enabled = newValue as Boolean)
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.KICK_DAILY_REWARDS_ENABLED)?.setOnPreferenceChangeListener { _, newValue ->
                val enabled = newValue as Boolean
                if (!enabled) {
                    RewardClaimScheduler.disable(requireContext().applicationContext)
                } else if (requireContext().prefs().getBoolean(AppConstants.REWARD_AUTO_CLAIM_ENABLED, false)) {
                    RewardClaimScheduler.enable(requireContext().applicationContext)
                }
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.REWARD_AUTO_CLAIM_ENABLED)?.setOnPreferenceChangeListener { _, newValue ->
                if (newValue == true) {
                    RewardClaimScheduler.enable(requireContext().applicationContext)
                } else {
                    RewardClaimScheduler.disable(requireContext().applicationContext)
                }
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.REWARD_CLAIM_NOTIFICATIONS_ENABLED)?.setOnPreferenceChangeListener { _, _ ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                    ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
                }
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    /**
     * res/xml/multipov_preferences.xml was authored but never registered in
     * settings_nav_graph.xml, so its eight preferences — all of which ARE read at runtime by
     * MultiPovFragment — were stranded at their code defaults with
     * no way for the user to reach them.
     */
    class MultiPovSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.multipov_preferences, rootKey)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class AppearanceSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.appearance_preferences, rootKey)
            findPreference<ListPreference>(AppConstants.APP_LANGUAGE)?.apply {
                isPersistent = false
                val appLocales = AppCompatDelegate.getApplicationLocales()
                val current = if (appLocales.isEmpty) "system" else appLocales.toLanguageTags()
                val primaryLang = if (!appLocales.isEmpty) appLocales[0]?.language else null
                value = when {
                    findIndexOfValue(current) >= 0 -> current
                    primaryLang != null && findIndexOfValue(primaryLang) >= 0 -> primaryLang
                    else -> "system"
                }
                onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                    // No setResult() here: setApplicationLocales already relaunches every
                    // activity (config change on 13+, AppCompat ActivityRecreator below).
                    // Marking the settings result too would make MainActivity recreate a
                    // second time right after the locale relaunch — a visible multi-second
                    // freeze of the whole UI while the player rebuilds.
                    val locales = if (newValue == "system") {
                        LocaleListCompat.getEmptyLocaleList()
                    } else {
                        LocaleListCompat.forLanguageTags(newValue.toString())
                    }
                    AppCompatDelegate.setApplicationLocales(locales)
                    true
                }
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                findPreference<ListPreference>(AppConstants.THEME)?.apply {
                    setEntries(R.array.themeNoDynamicEntries)
                    setEntryValues(R.array.themeNoDynamicValues)
                }
                findPreference<ListPreference>(AppConstants.UI_THEME_DARK_ON)?.apply {
                    setEntries(R.array.themeNoDynamicEntries)
                    setEntryValues(R.array.themeNoDynamicValues)
                }
                findPreference<ListPreference>(AppConstants.UI_THEME_DARK_OFF)?.apply {
                    setEntries(R.array.themeNoDynamicEntries)
                    setEntryValues(R.array.themeNoDynamicValues)
                }
            }
            val recreateListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.changed = true
                requireActivity().recreate()
                true
            }
            val resultListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<ListPreference>(AppConstants.THEME)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_THEME_FOLLOW_SYSTEM)?.onPreferenceChangeListener = recreateListener
            findPreference<ListPreference>(AppConstants.UI_THEME_DARK_ON)?.onPreferenceChangeListener = recreateListener
            findPreference<ListPreference>(AppConstants.UI_THEME_DARK_OFF)?.onPreferenceChangeListener = recreateListener
            findPreference<ListPreference>(AppConstants.UI_THEME_ROUNDED_CORNERS)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_THEME_REDUCED_PADDING)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_THEME_COMPACT_TEXT)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_THEME_APPBAR_LIFT)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_THEME_BOTTOM_NAV_COLOR)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_THEME_MATERIAL3)?.onPreferenceChangeListener = recreateListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_DRAW_BEHIND_CUTOUTS)?.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    onPreferenceChangeListener = recreateListener
                } else {
                    isVisible = false
                }
            }
            findPreference<ListPreference>(AppConstants.PORTRAIT_COLUMN_COUNT)?.onPreferenceChangeListener = resultListener
            findPreference<ListPreference>(AppConstants.LANDSCAPE_COLUMN_COUNT)?.onPreferenceChangeListener = resultListener
            findPreference<ListPreference>(AppConstants.COMPACT_STREAMS)?.onPreferenceChangeListener = resultListener
            findPreference<ListPreference>(AppConstants.UI_NAME_DISPLAY)?.onPreferenceChangeListener = resultListener
            findPreference<ListPreference>(AppConstants.UI_FOLLOW_BUTTON)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.FOLLOW_MODE_REMEMBERED)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_ROUNDUSERIMAGE)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_TRUNCATEVIEWCOUNT)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_UPTIME)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_BROADCASTERSCOUNT)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_BOOKMARK_TIME_LEFT)?.onPreferenceChangeListener = resultListener
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class NavigationSettingsFragment : MaterialPreferenceFragment() {
        private val viewModel: SettingsViewModel by activityViewModels()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.navigation_preferences, rootKey)
            val changeListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<ListPreference>(AppConstants.UI_STARTONFOLLOWED)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_FOLLOWPAGER)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_SAVEDPAGER)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_GAMEPAGER)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_SCROLLTOP)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_STORE_RECENT_SEARCHES)?.onPreferenceChangeListener = changeListener
            findPreference<ListPreference>(AppConstants.FOLLOWED_LIVE_AUTO_REFRESH_INTERVAL)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.FOLLOWED_LIVE_REFRESH_ON_RETURN)?.onPreferenceChangeListener = changeListener
            findPreference<Preference>("action_navigation_tab_list")?.setOnPreferenceClickListener { preference ->
                val tabList = resolveTabList(AppConstants.UI_NAVIGATION_TAB_LIST, AppConstants.DEFAULT_NAVIGATION_TAB_LIST)
                val tabs = tabList.map {
                    val split = it.split(':')
                    SettingsDragListItem(
                        key = split[0],
                        text = when (split[0]) {
                            "0" -> getString(R.string.games)
                            "1" -> getString(R.string.popular)
                            "2" -> getString(R.string.following)
                            "3" -> getString(R.string.saved)
                            else -> getString(R.string.popular)
                        },
                        default = split[1] != "0",
                        enabled = split[2] != "0",
                    )
                }
                (requireActivity() as? SettingsActivity)?.showDragListDialog(tabs, AppConstants.UI_NAVIGATION_TAB_LIST, preference.title)
                true
            }
            findPreference<Preference>("action_following_tabs")?.setOnPreferenceClickListener { preference ->
                val tabList = resolveTabList(AppConstants.UI_FOLLOWING_TABS, AppConstants.DEFAULT_FOLLOWING_TABS)
                val tabs = tabList.map {
                    val split = it.split(':')
                    SettingsDragListItem(
                        key = split[0],
                        text = when (split[0]) {
                            "0" -> getString(R.string.games)
                            "1" -> getString(R.string.live)
                            "2" -> getString(R.string.channels)
                            else -> getString(R.string.live)
                        },
                        default = split[1] != "0",
                        enabled = split[2] != "0",
                    )
                }
                (requireActivity() as? SettingsActivity)?.showDragListDialog(tabs, AppConstants.UI_FOLLOWING_TABS, preference.title)
                true
            }
            findPreference<Preference>("action_saved_tabs")?.setOnPreferenceClickListener { preference ->
                val tabList = resolveTabList(AppConstants.UI_SAVED_TABS, AppConstants.DEFAULT_SAVED_TABS)
                val tabs = tabList.map {
                    val split = it.split(':')
                    SettingsDragListItem(
                        key = split[0],
                        text = when (split[0]) {
                            "0" -> getString(R.string.bookmarks)
                            "1" -> getString(R.string.downloads)
                            "2" -> getString(R.string.filters)
                            else -> getString(R.string.downloads)
                        },
                        default = split[1] != "0",
                        enabled = split[2] != "0",
                    )
                }
                (requireActivity() as? SettingsActivity)?.showDragListDialog(tabs, AppConstants.UI_SAVED_TABS, preference.title)
                true
            }
            findPreference<Preference>("action_channel_tabs")?.setOnPreferenceClickListener { preference ->
                val tabList = resolveTabList(AppConstants.UI_CHANNEL_TABS, AppConstants.DEFAULT_CHANNEL_TABS)
                val tabs = tabList.map {
                    val split = it.split(':')
                    SettingsDragListItem(
                        key = split[0],
                        text = when (split[0]) {
                            "0" -> getString(R.string.suggested)
                            "1" -> getString(R.string.videos)
                            "2" -> getString(R.string.clips)
                            "3" -> getString(R.string.chat)
                            "4" -> getString(R.string.about)
                            else -> getString(R.string.videos)
                        },
                        default = split[1] != "0",
                        enabled = split[2] != "0",
                    )
                }
                (requireActivity() as? SettingsActivity)?.showDragListDialog(tabs, AppConstants.UI_CHANNEL_TABS, preference.title)
                true
            }
            findPreference<Preference>("action_game_tabs")?.setOnPreferenceClickListener { preference ->
                val tabList = resolveTabList(AppConstants.UI_GAME_TABS, AppConstants.DEFAULT_GAME_TABS)
                val tabs = tabList.map {
                    val split = it.split(':')
                    SettingsDragListItem(
                        key = split[0],
                        text = when (split[0]) {
                            "1" -> getString(R.string.live)
                            "2" -> getString(R.string.clips)
                            else -> getString(R.string.live)
                        },
                        default = split[1] != "0",
                        enabled = split[2] != "0",
                    )
                }
                (requireActivity() as? SettingsActivity)?.showDragListDialog(tabs, AppConstants.UI_GAME_TABS, preference.title)
                true
            }
            findPreference<Preference>("action_search_tabs")?.setOnPreferenceClickListener { preference ->
                val tabList = resolveTabList(AppConstants.UI_SEARCH_TABS, AppConstants.DEFAULT_SEARCH_TABS)
                val tabs = tabList.map {
                    val split = it.split(':')
                    SettingsDragListItem(
                        key = split[0],
                        text = when (split[0]) {
                            "0" -> getString(R.string.videos)
                            "1" -> getString(R.string.streams)
                            "2" -> getString(R.string.channels)
                            "3" -> getString(R.string.games)
                            else -> getString(R.string.channels)
                        },
                        default = split[1] != "0",
                        enabled = split[2] != "0",
                    )
                }
                (requireActivity() as? SettingsActivity)?.showDragListDialog(tabs, AppConstants.UI_SEARCH_TABS, preference.title)
                true
            }
            findPreference<Preference>("action_delete_recent_searches")?.setOnPreferenceClickListener {
                requireActivity().getAlertDialogBuilder()
                    .setMessage(getString(R.string.delete_recent_searches_message))
                    .setPositiveButton(getString(R.string.yes)) { _, _ ->
                        viewModel.deleteRecentSearches()
                    }
                    .setNegativeButton(getString(R.string.no), null)
                    .show()
                true
            }
        }

        private fun resolveTabList(prefKey: String, defaultValue: String): List<String> {
            val defaultTabs = defaultValue.split(',')
            val tabPref = requireContext().prefs().getString(prefKey, null)
            if (tabPref == null) return defaultTabs
            val validKeys = defaultTabs.map { it.first() }.toSet()
            val list = tabPref.split(',').filter { it.firstOrNull() in validKeys }.toMutableList()
            defaultTabs.forEachIndexed { index, item ->
                if (list.none { it.firstOrNull() == item.first() }) {
                    list.add(index.coerceAtMost(list.size), item)
                }
            }
            return list
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class PlayerOverviewFragment : MaterialPreferenceFragment() {
        private val viewModel: SettingsViewModel by activityViewModels()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_overview_preferences, rootKey)
            val changeListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            listOf(
                AppConstants.PLAYER_DEFAULTQUALITY,
                AppConstants.PLAYER_DEFAULT_CELLULAR_QUALITY,
                AppConstants.PLAYER_LOCK_QUALITY,
                AppConstants.PLAYER_KICK_LIVE_ENGINE,
                AppConstants.PLAYER_AUDIO_FOCUS,
                AppConstants.PLAYER_HANDLE_AUDIO_BECOMING_NOISY,
                AppConstants.PLAYER_KEEP_SCREEN_ON_WHEN_PAUSED,
                AppConstants.PLAYER_USE_VIDEOPOSITIONS
            ).forEach { key ->
                findPreference<Preference>(key)?.onPreferenceChangeListener = changeListener
            }
            findPreference<Preference>("action_delete_video_positions")?.setOnPreferenceClickListener {
                requireActivity().getAlertDialogBuilder()
                    .setMessage(getString(R.string.delete_video_positions_message))
                    .setPositiveButton(getString(R.string.yes)) { _, _ ->
                        viewModel.deletePositions()
                    }
                    .setNegativeButton(getString(R.string.no), null)
                    .show()
                true
            }
            findPreference<Preference>("nav_player_background_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerBackgroundSettingsFragment())
                true
            }
            findPreference<Preference>("nav_player_button_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerButtonSettingsFragment())
                true
            }
            findPreference<Preference>("nav_multipov_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalMultiPovSettingsFragment())
                true
            }
            findPreference<Preference>("nav_player_menu_settings_root")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerMenuSettingsFragment())
                true
            }
            findPreference<Preference>("nav_buffer_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalBufferSettingsFragment())
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class PlayerBackgroundFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_background_preferences, rootKey)
            val changeListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            val isPipSupported = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
                requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
            listOf(
                AppConstants.PLAYER_PICTURE_IN_PICTURE,
                AppConstants.PIP_SHOW_AUDIO_ONLY,
                AppConstants.PIP_SHOW_MUTE,
                AppConstants.PIP_REDUCED_VOLUME_LEVEL,
                AppConstants.PIP_UNMUTE_ON_FULLSCREEN,
                AppConstants.PLAYER_BACKGROUND_AUDIO_PIP_CLOSED,
                AppConstants.PLAYER_BACKGROUND_AUDIO_PIP_LOCKED
            ).forEach { key ->
                findPreference<Preference>(key)?.apply {
                    isVisible = isPipSupported
                    if (isPipSupported) onPreferenceChangeListener = changeListener
                }
            }
            listOf(
                AppConstants.PLAYER_BACKGROUND_AUDIO,
                AppConstants.PLAYER_BACKGROUND_AUDIO_LOCKED,
                AppConstants.PLAYER_DISABLE_BACKGROUND_VIDEO,
                AppConstants.PLAYER_AUDIO_SAVER_RUNG
            ).forEach { key ->
                findPreference<Preference>(key)?.onPreferenceChangeListener = changeListener
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class AdvancedSettingsFragment : MaterialPreferenceFragment() {
        private val viewModel: SettingsViewModel by activityViewModels()
        private var updateDownloadDialog: AppUpdateDialogHelper.UpdateDownloadDialog? = null
        private var backupResultLauncher: ActivityResultLauncher<Intent>? = null
        private var restoreResultLauncher: ActivityResultLauncher<Intent>? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            backupResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.data?.let {
                        viewModel.backupSettings(it.toString())
                    }
                }
            }
            restoreResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val list = mutableListOf<String>()
                    result.data?.clipData?.let { clipData ->
                        for (i in 0 until clipData.itemCount) {
                            clipData.getItemAt(i).uri?.let { uri ->
                                runCatching {
                                    requireContext().contentResolver.takePersistableUriPermission(
                                        uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
                                    )
                                }
                                list.add(uri.toString())
                            }
                        }
                    } ?: result.data?.data?.let { uri ->
                        runCatching {
                            requireContext().contentResolver.takePersistableUriPermission(
                                uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
                            )
                        }
                        list.add(uri.toString())
                    }
                    viewModel.restoreSettings(
                        list = list,
                        networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                        kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), true),
                        kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(requireContext())
                    )
                }
            }
        }

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.advanced_preferences, rootKey)
            for (key in listOf(AppConstants.USAGE_STATS_ENABLED, AppConstants.CRASH_REPORTS_ENABLED)) {
                findPreference<Preference>(key)?.setOnPreferenceChangeListener { _, value ->
                    if (value == false) {
                        requireContext().prefs().edit().putBoolean(key, false).apply()
                        CrashReports.clear(requireContext())
                    }
                    true
                }
            }
            val changeListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<Preference>("nav_navigation_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalNavigationSettingsFragment())
                true
            }
            findPreference<Preference>("action_check_updates")?.setOnPreferenceClickListener {
                val lastInstallTime = requireContext().tokenPrefs().getLong(AppConstants.UPDATE_LAST_INSTALL_TIME, 0L)
                viewModel.checkUpdates(
                    requireContext().prefs().getString(AppConstants.UPDATE_URL, null) ?: "https://api.github.com/repos/tibor1234567895/Xtra-Kick/releases/tags/latest",
                    lastInstallTime
                )
                true
            }
            findPreference<Preference>("nav_update_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalUpdateSettingsFragment())
                true
            }
            findPreference<Preference>("action_backup_settings")?.setOnPreferenceClickListener {
                val date = java.text.SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.US).format(java.util.Date())
                backupResultLauncher?.launch(Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "application/zip"
                    putExtra(Intent.EXTRA_TITLE, "xtrakick_backup_$date.zip")
                })
                true
            }
            findPreference<Preference>("action_restore_settings")?.setOnPreferenceClickListener {
                restoreResultLauncher?.launch(Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
                    type = "*/*"
                    putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                })
                true
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_STREAM_PROXY)?.onPreferenceChangeListener = changeListener
            findPreference<EditTextPreference>(AppConstants.PLAYER_PROXY_URL)?.onPreferenceChangeListener = changeListener
            findPreference<Preference>("nav_proxy_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalProxySettingsFragment())
                true
            }
            findPreference<Preference>("nav_playback_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlaybackSettingsFragment())
                true
            }
            findPreference<Preference>("nav_developer_settings")?.let { developerPreference ->
                // The developer token screen shows live access/refresh tokens in
                // plain editable fields. It must not be reachable in a shipped build.
                if (BuildConfig.DEBUG) {
                    developerPreference.setOnPreferenceClickListener {
                        requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                        findNavController().navigate(SettingsNavGraphDirections.actionGlobalDeveloperSettingsFragment())
                        true
                    }
                } else {
                    developerPreference.isVisible = false
                }
            }
            findPreference<Preference>("nav_debug_settings")?.let { debugPreference ->
                // Debug Settings can swap the entire playback stack and the search
                // implementation. It must not be reachable in a shipped build.
                if (BuildConfig.DEBUG) {
                    debugPreference.setOnPreferenceClickListener {
                        requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                        findNavController().navigate(SettingsNavGraphDirections.actionGlobalDebugSettingsFragment())
                        true
                    }
                } else {
                    // Release keeps the full debug stack (playback/search swaps)
                    // hidden, but crash + diagnostic log export stays reachable
                    // with verbose toggles defaulting to off.
                    debugPreference.title = getString(R.string.customize_debug_logs)
                    debugPreference.summary = getString(R.string.customize_debug_logs_summary)
                    debugPreference.isVisible = true
                    debugPreference.setOnPreferenceClickListener {
                        requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                        findNavController().navigate(SettingsNavGraphDirections.actionGlobalDebugLogSettingsFragment())
                        true
                    }
                }
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.backupStatus.collectLatest { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                    }
                }
            }
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.restoreStatus.collectLatest { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                    }
                }
            }
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.updateInfo.collectLatest { updateInfo ->
                        viewModel.consumeUpdateInfo()
                        if (updateInfo != null) {
                            AppUpdateDialogHelper.showUpdateDialog(
                                context = requireContext(),
                                updateInfo = updateInfo,
                                onUpdate = {
                                    if (BuildConfig.DEBUG || requireContext().prefs().getBoolean(AppConstants.UPDATE_USE_BROWSER, false)) {
                                        try {
                                            val intent = Intent(Intent.ACTION_VIEW, updateInfo.downloadUrl.toUri()).apply {
                                                addCategory(Intent.CATEGORY_BROWSABLE)
                                            }
                                            startActivity(intent)
                                        } catch (e: ActivityNotFoundException) {
                                            Toast.makeText(requireContext(), R.string.no_browser_found, Toast.LENGTH_LONG).show()
                                        }
                                    } else {
                                        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.UPSIDE_DOWN_CAKE &&
                                            !requireContext().packageManager.canRequestPackageInstalls()
                                        ) {
                                            try {
                                                val intent = Intent(
                                                    Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                                                    Uri.parse("package:${requireContext().packageName}")
                                                )
                                                startActivity(intent)
                                                return@showUpdateDialog
                                            } catch (_: ActivityNotFoundException) {
                                            }
                                        }
                                        viewModel.downloadUpdate(updateInfo.downloadUrl, updateInfo.size)
                                    }
                                },
                                onRemindLater = {},
                                onSkip = {
                                    requireContext().tokenPrefs().edit {
                                        putLong(AppConstants.UPDATE_SKIPPED_RELEASE_TIME, updateInfo.updatedAt)
                                        putLong(AppConstants.UPDATE_LAST_CHECKED, updateInfo.updatedAt)
                                    }
                                }
                            )
                        } else {
                            Toast.makeText(requireContext(), R.string.no_updates_found, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.updateDownloadProgress.collectLatest { progress ->
                        if (progress != null) {
                            val dialog = updateDownloadDialog
                                ?: AppUpdateDialogHelper.showDownloadDialog(requireContext(), progress) {
                                    viewModel.cancelUpdateDownload()
                                }.also { updateDownloadDialog = it }
                            dialog.update(progress)
                        } else {
                            updateDownloadDialog?.dismiss()
                            updateDownloadDialog = null
                        }
                    }
                }
            }
        }

        override fun onDestroyView() {
            updateDownloadDialog?.dismiss()
            updateDownloadDialog = null
            super.onDestroyView()
        }
    }

    class ChatSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.chat_preferences, rootKey)
            findPreference<SeekBarPreference>("chatWidth")?.apply {
                isPersistent = false
                val stored = requireContext().prefs().getInt(AppConstants.LANDSCAPE_CHAT_WIDTH, 30)
                val percent = if (stored > 100) {
                    val maxDimension = max(resources.displayMetrics.widthPixels, resources.displayMetrics.heightPixels)
                    ((stored * 100f) / maxDimension).roundToInt().coerceIn(min, max).also { migrated ->
                        requireContext().prefs().edit { putInt(AppConstants.LANDSCAPE_CHAT_WIDTH, migrated) }
                    }
                } else {
                    stored.coerceIn(min, max)
                }
                value = percent
                setOnPreferenceChangeListener { _, newValue ->
                    (requireActivity() as? SettingsActivity)?.setResult()
                    val newPercent = (newValue as Int).coerceIn(min, max)
                    requireContext().prefs().edit { putInt(AppConstants.LANDSCAPE_CHAT_WIDTH, newPercent) }
                    true
                }
            }
            findPreference<SeekBarPreference>(AppConstants.CHAT_ALTERNATING_LINE_SHADOW_STRENGTH)?.apply {
                val storedStrength = requireContext().prefs()
                    .getInt(AppConstants.CHAT_ALTERNATING_LINE_SHADOW_STRENGTH, ChatBackgroundUtils.DEFAULT_ALTERNATING_LINE_SHADOW_STRENGTH)
                    .coerceIn(min, max)
                if (value != storedStrength) {
                    value = storedStrength
                }
            }
            findPreference<Preference>("nav_muted_users")?.setOnPreferenceClickListener {
                MutedUsersDialog().show(childFragmentManager, "muted_users")
                true
            }
            val delayModePref = findPreference<ListPreference>(AppConstants.CHAT_DELAY_MODE)
            val customDelayPref = findPreference<SeekBarPreference>(AppConstants.CHAT_DELAY_CUSTOM_SECS)
            val delayIndicatorPref = findPreference<SwitchPreferenceCompat>(AppConstants.CHAT_SHOW_DELAY_INDICATOR)
            fun updateDelayDependents(mode: String?) {
                val activeMode = mode ?: "0"
                customDelayPref?.isEnabled = activeMode == "2"
                delayIndicatorPref?.isEnabled = activeMode != "0"
            }
            updateDelayDependents(delayModePref?.value ?: requireContext().prefs().getString(AppConstants.CHAT_DELAY_MODE, "0"))
            delayModePref?.setOnPreferenceChangeListener { _, newValue ->
                updateDelayDependents(newValue?.toString())
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class PlayerButtonSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_button_preferences, rootKey)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_ROUNDED_CORNER_PADDING)?.isVisible = false
            }
            listOf(AppConstants.PLAYER_REWIND, AppConstants.PLAYER_FORWARD).forEach { key ->
                findPreference<EditTextPreference>(key)?.apply {
                    summary = getString(R.string.seconds_full, requireContext().prefs().getString(key, "10"))
                    setOnPreferenceChangeListener { _, newValue ->
                        val parsed = newValue?.toString()?.trim()?.toLongOrNull() ?: return@setOnPreferenceChangeListener false
                        if (parsed !in 1L..300L) return@setOnPreferenceChangeListener false
                        summary = getString(R.string.seconds_full, parsed.toString())
                        true
                    }
                    setOnBindEditTextListener {
                        it.inputType = InputType.TYPE_CLASS_NUMBER
                        it.setSelection(it.text.length)
                    }
                }
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_AUDIO_COMPRESSOR_BUTTON)?.isVisible = false
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class PlayerMenuSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_menu_preferences, rootKey)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class BufferSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            val prefs = requireContext().prefs()
            LiveLatencySettings.materializeProfileValues(prefs)
            setPreferencesFromResource(R.xml.buffer_preferences, rootKey)
            bindLatencyPreferences()
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }

        private fun bindLatencyPreferences() {
            val prefs = requireContext().prefs()
            syncLatencyPreferenceValues()
            findPreference<ListPreference>(AppConstants.PLAYER_LATENCY_PROFILE)?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                val profile = newValue?.toString() ?: LiveLatencySettings.DEFAULT_PROFILE
                LiveLatencySettings.applyPreset(prefs, profile)
                syncLatencyPreferenceValues()
                true
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_IVS_LATENCY_CATCHUP)?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, _ ->
                true
            }
            latencyEditKeys.forEach { key ->
                findPreference<EditTextPreference>(key)?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, _ ->
                    true
                }
            }
        }

        private fun syncLatencyPreferenceValues() {
            val prefs = requireContext().prefs()
            latencyEditKeys.forEach { key ->
                findPreference<EditTextPreference>(key)?.text = prefs.getString(key, "")
            }
        }

        companion object {
            private val latencyEditKeys = arrayOf(
                AppConstants.PLAYER_BUFFER_MIN,
                AppConstants.PLAYER_BUFFER_MAX,
                AppConstants.PLAYER_BUFFER_PLAYBACK,
                AppConstants.PLAYER_BUFFER_REBUFFER,
                AppConstants.PLAYER_LIVE_MIN_SPEED,
                AppConstants.PLAYER_LIVE_MAX_SPEED,
                AppConstants.PLAYER_LIVE_TARGET_OFFSET
            )
        }
    }

    class ProxySettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.proxy_preferences, rootKey)
            findPreference<EditTextPreference>(AppConstants.PROXY_PORT)?.setOnBindEditTextListener { editText ->
                editText.inputType = InputType.TYPE_CLASS_NUMBER
                editText.setSelection(editText.text.length)
            }
            findPreference<EditTextPreference>(AppConstants.PROXY_PASSWORD)?.apply {
                isPersistent = false
                text = requireContext().getProxyPassword()
                setOnPreferenceChangeListener { _, newValue ->
                    val updated = newValue?.toString()
                    requireContext().setProxyPassword(updated)
                    text = updated.orEmpty()
                    false
                }
                setOnBindEditTextListener { editText ->
                    editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    editText.setSelection(editText.text.length)
                }
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class PlaybackSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.playback_preferences, rootKey)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    @AndroidEntryPoint
    class ApiTokenSettingsFragment : MaterialPreferenceFragment() {
        private var authResultLauncher: ActivityResultLauncher<Intent>? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            authResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    updateAuthHeader()
                    (requireActivity() as? SettingsActivity)?.setResult()
                }
            }
        }

        private fun updateAuthHeader() {
            val context = requireContext()
            val username = context.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)?.takeIf { it.isNotBlank() }
            val isLoggedIn = AuthStateHelper.isKickLoggedIn(context)
            findPreference<Preference>("action_kick_auth_toggle")?.apply {
                if (isLoggedIn) {
                    title = username ?: getString(R.string.kick_account)
                    summary = getString(R.string.tap_to_log_out)
                } else if (AuthStateHelper.hasUnreadableKickSession(context)) {
                    title = getString(R.string.kick_account)
                    summary = getString(R.string.kick_session_unavailable)
                } else if (username != null) {
                    title = username
                    summary = getString(R.string.token_expired)
                } else {
                    title = getString(R.string.log_in)
                    summary = getString(R.string.log_in_to_kick_summary)
                }
            }
            findPreference<Preference>("action_kick_import_follows")?.apply {
                isEnabled = isLoggedIn
                summary = if (isLoggedIn) {
                    getString(R.string.import_kick_follows_summary)
                } else {
                    getString(R.string.login_to_import_follows)
                }
            }
        }

        override fun onResume() {
            super.onResume()
            updateAuthHeader()
        }

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.api_token_preferences, rootKey)
            updateAuthHeader()
            findPreference<Preference>("action_kick_auth_toggle")?.setOnPreferenceClickListener {
                val context = requireContext()
                val username = context.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)?.takeIf { it.isNotBlank() }
                val isLoggedIn = AuthStateHelper.isKickLoggedIn(context)
                if (isLoggedIn || AuthStateHelper.hasUnreadableKickSession(context)) {
                    context.getAlertDialogBuilder().apply {
                        setTitle(getString(R.string.logout_title))
                        setMessage(
                            if (isLoggedIn && username != null) getString(R.string.logout_msg, username)
                            else getString(R.string.logout_saved_session_msg)
                        )
                        setNegativeButton(getString(R.string.no), null)
                        setPositiveButton(getString(R.string.yes)) { _, _ ->
                            authResultLauncher?.launch(
                                Intent(context, LoginActivity::class.java).putExtra(AppConstants.LOGIN_LOGOUT_ONLY, true)
                            )
                        }
                    }.show()
                } else {
                    authResultLauncher?.launch(Intent(context, LoginActivity::class.java))
                }
                true
            }
            findPreference<Preference>("action_kick_import_follows")?.setOnPreferenceClickListener {
                if (AuthStateHelper.isKickLoggedIn(requireContext())) {
                    KickFollowImportDialog().show(childFragmentManager, "kick_follow_import")
                } else {
                    Toast.makeText(requireContext(), R.string.log_in, Toast.LENGTH_SHORT).show()
                }
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    @AndroidEntryPoint
    class DeveloperSettingsFragment : MaterialPreferenceFragment() {
        @Inject
        lateinit var kickRepository: KickRepository

        private val eventScopes = setOf("events:subscribe")

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.developer_preferences, rootKey)
            findPreference<SwitchPreferenceCompat>(AppConstants.VALIDATE_TOKENS)?.onPreferenceChangeListener =
                Preference.OnPreferenceChangeListener { _, _ ->
                    (requireActivity() as? SettingsActivity)?.setResult()
                    true
                }
            findPreference<EditTextPreference>(AppConstants.KICK_USER_ID)?.apply {
                isPersistent = false
                text = requireContext().tokenPrefs().getString(AppConstants.KICK_USER_ID, null)
                setOnPreferenceChangeListener { _, newValue ->
                    requireContext().tokenPrefs().edit {
                        putString(AppConstants.KICK_USER_ID, newValue.toString())
                    }
                    true
                }
            }
            findPreference<EditTextPreference>(AppConstants.KICK_USER_LOGIN)?.apply {
                isPersistent = false
                text = requireContext().tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)
                setOnPreferenceChangeListener { _, newValue ->
                    requireContext().tokenPrefs().edit {
                        putString(AppConstants.KICK_USER_LOGIN, newValue.toString())
                    }
                    true
                }
            }
            findPreference<EditTextPreference>(AppConstants.KICK_ACCESS_TOKEN)?.apply {
                isPersistent = false
                text = requireContext().tokenPrefs().getString(AppConstants.KICK_ACCESS_TOKEN, null)
                setOnPreferenceChangeListener { _, newValue ->
                    requireContext().tokenPrefs().edit {
                        putString(AppConstants.KICK_ACCESS_TOKEN, newValue.toString())
                    }
                    true
                }
            }
            findPreference<EditTextPreference>(AppConstants.KICK_REFRESH_TOKEN)?.apply {
                isPersistent = false
                text = requireContext().tokenPrefs().getString(AppConstants.KICK_REFRESH_TOKEN, null)
                setOnPreferenceChangeListener { _, newValue ->
                    requireContext().tokenPrefs().edit {
                        putString(AppConstants.KICK_REFRESH_TOKEN, newValue.toString())
                    }
                    true
                }
            }
            findPreference<Preference>("action_kick_manage_event_subscriptions")?.setOnPreferenceClickListener {
                openKickEventSubscriptionsManager()
                true
            }
        }

        private fun currentNetworkLibrary(): String? {
            return requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        }

        private fun toastError(throwable: Throwable) {
            Toast.makeText(requireContext(), throwable.message ?: getString(R.string.connection_error), Toast.LENGTH_LONG).show()
        }

        private fun requireKickScopes(requiredScopes: Set<String>): Boolean {
            if (!AuthStateHelper.isKickLoggedIn(requireContext())) {
                Toast.makeText(requireContext(), R.string.log_in, Toast.LENGTH_LONG).show()
                return false
            }
            val scopes = requireContext().prefs().getString(AppConstants.KICK_SCOPES, null)
            if (!KickOAuthConfig.hasScopes(scopes, requiredScopes)) {
                val label = requiredScopes.sorted().joinToString(" ")
                val messageRes = if (requiredScopes.size > 1) {
                    R.string.kick_scope_required_multiple
                } else {
                    R.string.kick_scope_required
                }
                Toast.makeText(requireContext(), getString(messageRes, label), Toast.LENGTH_LONG).show()
                return false
            }
            return true
        }

        private fun openKickEventSubscriptionsManager() {
            if (!requireKickScopes(eventScopes)) return
            viewLifecycleOwner.lifecycleScope.launch {
                runCatching {
                    kickRepository.getKickEventSubscriptions(currentNetworkLibrary())
                }.onSuccess(::showKickEventSubscriptionsDialog)
                    .onFailure(::toastError)
            }
        }

        private fun showKickEventSubscriptionsDialog(subscriptions: List<KickEventSubscription>) {
            val labels = subscriptions.map {
                buildString {
                    append(it.event ?: "?")
                    append(" v")
                    append(it.version ?: 1)
                    it.broadcasterUserId?.let { broadcasterId ->
                        append(" • ")
                        append(broadcasterId)
                    }
                }
            }.toTypedArray()
            val builder = requireContext().getAlertDialogBuilder()
                .setTitle(getString(R.string.kick_manage_event_subscriptions))
                .setMessage(
                    buildString {
                        append(getString(R.string.kick_event_subscription_webhook_notice))
                        if (labels.isEmpty()) {
                            append("\n\n")
                            append(getString(R.string.kick_subscriptions_empty))
                        }
                    }
                )
                .setPositiveButton(getString(R.string.kick_event_subscription_create)) { _, _ ->
                    showKickEventCreateDialog()
                }
                .setNegativeButton(getString(R.string.close), null)
            if (labels.isNotEmpty()) {
                builder.setItems(labels) { _, which ->
                    showKickEventSubscriptionDeleteDialog(listOf(subscriptions[which]))
                }
                builder.setNeutralButton(getString(R.string.kick_event_subscription_delete)) { _, _ ->
                    showKickEventSubscriptionDeleteDialog(subscriptions)
                }
            } else {
                builder.setNeutralButton(getString(R.string.refresh)) { _, _ ->
                    openKickEventSubscriptionsManager()
                }
            }
            builder.show()
        }

        private fun showKickEventCreateDialog() {
            if (!requireKickScopes(eventScopes)) return
            val options = KickOfficialApiValidationUtils.EVENT_NAMES.toTypedArray()
            val checked = BooleanArray(options.size)
            requireContext().getAlertDialogBuilder()
                .setTitle(getString(R.string.kick_select_events))
                .setMultiChoiceItems(options, checked) { _, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton(getString(R.string.kick_event_subscription_create)) { _, _ ->
                    val selected = checked.indices.mapNotNull { index ->
                        options.getOrNull(index)?.takeIf { checked[index] }?.let { KickEventSubscriptionRequestItem(it) }
                    }
                    if (selected.isEmpty()) {
                        Toast.makeText(requireContext(), R.string.kick_no_selection, Toast.LENGTH_SHORT).show()
                        return@setPositiveButton
                    }
                    val broadcasterInput = EditText(requireContext()).apply {
                        hint = getString(R.string.api_user_id)
                        inputType = android.text.InputType.TYPE_CLASS_NUMBER
                    }
                    requireContext().getAlertDialogBuilder()
                        .setTitle(getString(R.string.api_user_id))
                        .setMessage(getString(R.string.kick_event_subscription_webhook_notice))
                        .setView(broadcasterInput)
                        .setPositiveButton(getString(R.string.save)) { _, _ ->
                            val broadcasterUserId = broadcasterInput.text.toString().trim().toLongOrNull()
                            viewLifecycleOwner.lifecycleScope.launch {
                                runCatching {
                                    kickRepository.createKickEventSubscriptions(
                                        networkLibrary = currentNetworkLibrary(),
                                        events = selected,
                                        broadcasterUserId = broadcasterUserId,
                                    )
                                }.onSuccess { results ->
                                    val failures = results.filter { !it.error.isNullOrBlank() }
                                    if (failures.isNotEmpty()) {
                                        Toast.makeText(
                                            requireContext(),
                                            failures.joinToString("\n") { "${it.name ?: "?"}: ${it.error}" },
                                            Toast.LENGTH_LONG
                                        ).show()
                                    } else {
                                        Toast.makeText(requireContext(), R.string.kick_subscriptions_updated, Toast.LENGTH_SHORT).show()
                                    }
                                    openKickEventSubscriptionsManager()
                                }.onFailure(::toastError)
                            }
                        }
                        .setNegativeButton(getString(R.string.close), null)
                        .show()
                }
                .setNegativeButton(getString(R.string.close), null)
                .show()
        }

        private fun showKickEventSubscriptionDeleteDialog(subscriptions: List<KickEventSubscription>) {
            val labels = subscriptions.map {
                buildString {
                    append(it.event ?: "?")
                    append(" v")
                    append(it.version ?: 1)
                    append(" • ")
                    append(it.id ?: "?")
                }
            }.toTypedArray()
            val checked = BooleanArray(labels.size)
            requireContext().getAlertDialogBuilder()
                .setTitle(getString(R.string.kick_select_subscriptions))
                .setMultiChoiceItems(labels, checked) { _, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton(getString(R.string.kick_event_subscription_delete)) { _, _ ->
                    val ids = checked.indices.mapNotNull { index ->
                        subscriptions.getOrNull(index)?.id?.takeIf { checked[index] }
                    }
                    if (ids.isEmpty()) {
                        Toast.makeText(requireContext(), R.string.kick_no_selection, Toast.LENGTH_SHORT).show()
                        return@setPositiveButton
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        runCatching {
                            kickRepository.deleteKickEventSubscriptions(currentNetworkLibrary(), ids)
                        }.onSuccess {
                            Toast.makeText(requireContext(), R.string.kick_subscriptions_updated, Toast.LENGTH_SHORT).show()
                            openKickEventSubscriptionsManager()
                        }.onFailure(::toastError)
                    }
                }
                .setNegativeButton(getString(R.string.close), null)
                .show()
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }

    class DownloadSettingsFragment : MaterialPreferenceFragment() {
        private val viewModel: SettingsViewModel by activityViewModels()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.download_preferences, rootKey)
            findPreference<Preference>("action_import_app_downloads")?.setOnPreferenceClickListener {
                viewModel.importDownloads()
                true
            }
            findPreference<Preference>("action_leftover_files")?.setOnPreferenceClickListener {
                showLeftoverFilesDialog()
                true
            }
        }

        /** Cached so the dialog does not have to re-scan on tap. */
        private var leftover: SettingsViewModel.LeftoverFiles? = null

        private fun formatBytes(bytes: Long): String =
            android.text.format.Formatter.formatShortFileSize(requireContext(), bytes)

        private fun showLeftoverFilesDialog() {
            val found = leftover ?: return
            if (found.isEmpty) {
                Toast.makeText(requireContext(), getString(R.string.leftover_files_none), Toast.LENGTH_SHORT).show()
                return
            }
            requireContext().getAlertDialogBuilder()
                .setTitle(getString(R.string.leftover_files))
                .setMessage(getString(R.string.leftover_files_message, found.count, formatBytes(found.bytes)))
                // Restore only handles app-storage entries; shared-folder leftovers
                // support delete only, so hide it when nothing is restorable.
                .apply {
                    if (found.restorableCount > 0) {
                        // Restore is the non-destructive option, so it gets the affirmative button.
                        setPositiveButton(getString(R.string.leftover_files_restore)) { _, _ ->
                            viewModel.importDownloads()
                        }
                    }
                }
                .setNegativeButton(getString(android.R.string.cancel), null)
                .setNeutralButton(getString(R.string.leftover_files_delete)) { _, _ ->
                    val listed = found.names.take(12).joinToString("\n")
                    val extra = (found.count - found.names.size).takeIf { it > 0 }?.let { "\n… (+$it more)" }.orEmpty()
                    requireContext().getAlertDialogBuilder()
                        .setTitle(getString(R.string.leftover_files_delete))
                        .setMessage(getString(R.string.leftover_files_delete_confirm, found.count, formatBytes(found.bytes)) + "\n\n" + listed + extra)
                        .setPositiveButton(getString(R.string.yes)) { _, _ -> viewModel.deleteLeftoverFiles() }
                        .setNegativeButton(getString(android.R.string.cancel), null)
                        .show()
                }
                .show()
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                        viewModel.leftoverScan.collect { result ->
                            leftover = result
                            findPreference<Preference>("action_leftover_files")?.summary = if (result.isEmpty) {
                                getString(R.string.leftover_files_none)
                            } else {
                                getString(R.string.leftover_files_summary, result.count, formatBytes(result.bytes))
                            }
                        }
                    }
                    launch {
                        viewModel.leftoverRestored.collect { count ->
                            Toast.makeText(requireContext(), getString(R.string.leftover_files_restored, count), Toast.LENGTH_LONG).show()
                            viewModel.scanLeftoverFiles()
                        }
                    }
                    launch {
                        viewModel.leftoverDeleted.collect { freed ->
                            Toast.makeText(requireContext(), getString(R.string.leftover_files_deleted, formatBytes(freed)), Toast.LENGTH_LONG).show()
                            viewModel.scanLeftoverFiles()
                        }
                    }
                }
            }
            viewModel.scanLeftoverFiles()
            setupStandardListBehavior()
        }
    }

    class UpdateSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.update_preferences, rootKey)
            findPreference<SwitchPreferenceCompat>("update_check_enabled")?.setOnPreferenceChangeListener { _, newValue ->
                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.UPSIDE_DOWN_CAKE &&
                    newValue == true &&
                    !requireContext().prefs().getBoolean(AppConstants.UPDATE_USE_BROWSER, false) &&
                    !requireContext().packageManager.canRequestPackageInstalls()
                ) {
                    try {
                        val intent = Intent(
                            Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                            Uri.parse("package:${requireContext().packageName}")
                        )
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {

                    }
                }
                true
            }
            findPreference<ListPreference>("update_check_frequency")?.apply {
                if (value == null) {
                    value = "1"
                }
            }
            findPreference<SwitchPreferenceCompat>("update_use_browser")?.setOnPreferenceChangeListener { _, newValue ->
                val switchingToInAppUpdates = Build.VERSION.SDK_INT == Build.VERSION_CODES.UPSIDE_DOWN_CAKE && newValue == false
                if (switchingToInAppUpdates &&
                    requireContext().prefs().getBoolean(AppConstants.UPDATE_CHECK_ENABLED, true) &&
                    !requireContext().packageManager.canRequestPackageInstalls()
                ) {
                    try {
                        val intent = Intent(
                            Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                            Uri.parse("package:${requireContext().packageName}")
                        )
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {

                    }
                }
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupStandardListBehavior()
        }
    }
}
