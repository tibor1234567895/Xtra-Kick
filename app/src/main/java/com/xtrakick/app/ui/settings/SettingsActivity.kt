package com.xtrakick.app.ui.settings

import android.Manifest
import android.annotation.SuppressLint
import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.ext.SdkExtensions
import android.provider.Settings
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.content.edit
import androidx.core.content.FileProvider
import androidx.core.content.res.use
import androidx.core.net.toUri
import androidx.core.os.LocaleListCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.core.widget.NestedScrollView
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
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
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceManager
import androidx.preference.SeekBarPreference
import androidx.preference.SwitchPreferenceCompat
import androidx.preference.forEach
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.SettingsNavGraphDirections
import com.xtrakick.app.databinding.ActivitySettingsBinding
import com.xtrakick.app.model.kick.KickEventSubscription
import com.xtrakick.app.model.kick.KickEventSubscriptionRequestItem
import com.xtrakick.app.model.ui.SettingsDragListItem
import com.xtrakick.app.model.ui.SettingsSearchItem
import com.xtrakick.app.repository.KickOfficialApiValidationUtils
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.ui.player.IvsPlayerService
import com.xtrakick.app.ui.player.LiveLatencySettings
import com.xtrakick.app.ui.player.PlaybackService
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.KickOAuthConfig
import com.xtrakick.app.util.applyTheme
import com.xtrakick.app.util.chat.ChatBackgroundUtils
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.chromium.net.CronetProvider
import java.util.Collections
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private var changed = false
    var searchItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            layoutManager = LinearLayoutManager(this@SettingsActivity)
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

    private fun showSearchView(showSearch: Boolean) {
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

    private fun getSelectedSearchItem(): String? {
        return searchItem?.also {
            searchItem = null
        }
    }

    private fun setResult() {
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
            findPreference<Preference>("nav_general_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalGeneralSettingsFragment())
                true
            }
            findPreference<Preference>("nav_appearance_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalAppearanceSettingsFragment())
                true
            }
            findPreference<Preference>("nav_navigation_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalNavigationSettingsFragment())
                true
            }
            findPreference<Preference>("nav_chat_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalChatSettingsFragment())
                true
            }
            findPreference<Preference>("nav_player_overview")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerOverviewFragment())
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
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class GeneralSettingsFragment : MaterialPreferenceFragment() {

        private val viewModel: SettingsViewModel by activityViewModels()
        private var backupResultLauncher: ActivityResultLauncher<Intent>? = null
        private var restoreResultLauncher: ActivityResultLauncher<Intent>? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            backupResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    result.data?.data?.let {
                        viewModel.backupSettings(it.toString())
                    }
                }
            }
            restoreResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val list = mutableListOf<String>()
                    result.data?.clipData?.let { clipData ->
                        for (i in 0 until clipData.itemCount) {
                            clipData.getItemAt(i).uri?.toString()?.let(list::add)
                        }
                    } ?: result.data?.data?.toString()?.let(list::add)
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
            setPreferencesFromResource(R.xml.general_preferences, rootKey)
            findPreference<ListPreference>(AppConstants.UI_LANGUAGE)?.apply {
                val lang = AppCompatDelegate.getApplicationLocales()
                if (lang.isEmpty) {
                    setValueIndex(findIndexOfValue("auto"))
                } else {
                    try {
                        setValueIndex(findIndexOfValue(lang.toLanguageTags()))
                    } catch (e: Exception) {
                        try {
                            setValueIndex(findIndexOfValue(
                                lang.toLanguageTags().substringBefore("-").let {
                                    when (it) {
                                        "id" -> "in"
                                        "pt" -> "pt-BR"
                                        "zh" -> "zh-TW"
                                        else -> it
                                    }
                                }
                            ))
                        } catch (e: Exception) {
                            setValueIndex(findIndexOfValue("en"))
                        }
                    }
                }
                setOnPreferenceChangeListener { _, value ->
                    AppCompatDelegate.setApplicationLocales(
                        LocaleListCompat.forLanguageTags(
                            if (value.toString() == "auto") null else value.toString()
                        )
                    )
                    (requireActivity() as? SettingsActivity)?.setResult()
                    true
                }
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.LIVE_NOTIFICATIONS_ENABLED)?.setOnPreferenceChangeListener { _, newValue ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                    ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
                }
                viewModel.toggleNotifications(
                    enabled = newValue as Boolean,
                    networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), true),
                    kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(requireContext())
                )
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            findPreference<Preference>("action_check_updates")?.setOnPreferenceClickListener {
                viewModel.checkUpdates(
                    requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    requireContext().prefs().getString(AppConstants.UPDATE_URL, null) ?: "https://api.github.com/repos/tibor1234567895/Xtra-Kick/releases/tags/latest",
                    requireContext().tokenPrefs().getLong(AppConstants.UPDATE_LAST_CHECKED, 0)
                )
                true
            }
            findPreference<Preference>("nav_update_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalUpdateSettingsFragment())
                true
            }
            findPreference<Preference>("action_backup_settings")?.setOnPreferenceClickListener {
                backupResultLauncher?.launch(Intent(Intent.ACTION_OPEN_DOCUMENT_TREE))
                true
            }
            findPreference<Preference>("action_restore_settings")?.setOnPreferenceClickListener {
                restoreResultLauncher?.launch(Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "*/*"
                    putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                })
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.updateUrl.collectLatest { updateUrl ->
                        if (updateUrl != null) {
                            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.UPSIDE_DOWN_CAKE &&
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
                            requireActivity().getAlertDialogBuilder()
                                .setTitle(getString(R.string.update_available))
                                .setMessage(getString(R.string.update_message))
                                .setPositiveButton(getString(R.string.yes)) { _, _ ->
                                    if (requireContext().prefs().getBoolean(AppConstants.UPDATE_USE_BROWSER, false)) {
                                        try {
                                            val intent = Intent(Intent.ACTION_VIEW, updateUrl.toUri()).apply {
                                                addCategory(Intent.CATEGORY_BROWSABLE)
                                            }
                                            startActivity(intent)
                                            requireContext().tokenPrefs().edit {
                                                putLong(AppConstants.UPDATE_LAST_CHECKED, System.currentTimeMillis())
                                            }
                                        } catch (e: ActivityNotFoundException) {
                                            Toast.makeText(requireContext(), R.string.no_browser_found, Toast.LENGTH_LONG).show()
                                        }
                                    } else {
                                        viewModel.downloadUpdate(requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), updateUrl)
                                    }
                                }
                                .setNegativeButton(getString(R.string.no), null)
                                .show()
                        } else {
                            Toast.makeText(requireContext(), R.string.no_updates_found, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    /**
     * res/xml/multipov_preferences.xml was authored but never registered in
     * settings_nav_graph.xml, so its eight preferences — all of which ARE read at runtime by
     * MultiPovFragment / MultiPovPlaybackController — were stranded at their code defaults with
     * no way for the user to reach them.
     */
    class MultiPovSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.multipov_preferences, rootKey)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class AppearanceSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.appearance_preferences, rootKey)
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
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_ROUNDUSERIMAGE)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_TRUNCATEVIEWCOUNT)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_UPTIME)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_TAGS)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_BROADCASTERSCOUNT)?.onPreferenceChangeListener = resultListener
            findPreference<SwitchPreferenceCompat>(AppConstants.UI_BOOKMARK_TIME_LEFT)?.onPreferenceChangeListener = resultListener
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
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
            findPreference<Preference>("action_navigation_tab_list")?.setOnPreferenceClickListener { preference ->
                val tabList = requireContext().prefs().getString(AppConstants.UI_NAVIGATION_TAB_LIST, null).let { tabPref ->
                    val defaultTabs = AppConstants.DEFAULT_NAVIGATION_TAB_LIST.split(',')
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
                val tabList = requireContext().prefs().getString(AppConstants.UI_SAVED_TABS, null).let { tabPref ->
                    val defaultTabs = AppConstants.DEFAULT_SAVED_TABS.split(',')
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
                val tabList = requireContext().prefs().getString(AppConstants.UI_CHANNEL_TABS, null).let { tabPref ->
                    val defaultTabs = AppConstants.DEFAULT_CHANNEL_TABS.split(',')
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
                val tabList = requireContext().prefs().getString(AppConstants.UI_GAME_TABS, null).let { tabPref ->
                    val defaultTabs = AppConstants.DEFAULT_GAME_TABS.split(',')
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
                val tabList = requireContext().prefs().getString(AppConstants.UI_SEARCH_TABS, null).let { tabPref ->
                    val defaultTabs = AppConstants.DEFAULT_SEARCH_TABS.split(',')
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

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class PlayerOverviewFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_overview_preferences, rootKey)
            val changeListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
                true
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O || !requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_PICTURE_IN_PICTURE)?.isVisible = false
            } else {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_PICTURE_IN_PICTURE)?.onPreferenceChangeListener = changeListener
            }
            findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_BACKGROUND_AUDIO)?.onPreferenceChangeListener = changeListener
            findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_BACKGROUND_AUDIO_LOCKED)?.onPreferenceChangeListener = changeListener
            findPreference<Preference>("nav_player_behavior")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerSettingsFragment())
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
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class AdvancedSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.advanced_preferences, rootKey)
            val changeListener = Preference.OnPreferenceChangeListener { _, _ ->
                (requireActivity() as? SettingsActivity)?.setResult()
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
            findPreference<Preference>("nav_api_token_settings")?.apply {
                val username = requireContext().tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)?.takeIf { it.isNotBlank() }
                summary = if (username != null) getString(R.string.logout_msg, username) else getString(R.string.not_logged_in)
                setOnPreferenceClickListener {
                    requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                    findNavController().navigate(SettingsNavGraphDirections.actionGlobalApiTokenSettingsFragment())
                    true
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
                    debugPreference.isVisible = false
                }
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class ChatSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.chat_preferences, rootKey)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                findPreference<ListPreference>(AppConstants.CHAT_IMAGE_LIBRARY)?.apply {
                    setEntries(R.array.imageLibraryEntriesNoWebp)
                    setEntryValues(R.array.imageLibraryValuesNoWebp)
                }
            }
            findPreference<SeekBarPreference>("chatWidth")?.apply {
                isPersistent = false
                val width = resources.displayMetrics.widthPixels
                val height = resources.displayMetrics.heightPixels
                val maxDimension = if (height > width) height else width
                val storedWidth = requireContext().prefs().getInt(AppConstants.LANDSCAPE_CHAT_WIDTH, (maxDimension * (30 / 100f)).toInt())
                value = ((storedWidth * 100f) / maxDimension).toInt().coerceIn(min, max)
                setOnPreferenceChangeListener { _, newValue ->
                    (requireActivity() as? SettingsActivity)?.setResult()
                    val chatWidth = (maxDimension * ((newValue as Int) / 100f)).toInt()
                    requireContext().prefs().edit { putInt(AppConstants.LANDSCAPE_CHAT_WIDTH, chatWidth) }
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
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class PlayerSettingsFragment : MaterialPreferenceFragment() {
        private val viewModel: SettingsViewModel by activityViewModels()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_preferences, rootKey)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O || !requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_BACKGROUND_AUDIO_PIP_CLOSED)?.isVisible = false
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_BACKGROUND_AUDIO_PIP_LOCKED)?.isVisible = false
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_ROUNDED_CORNER_PADDING)?.isVisible = false
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
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class PlayerButtonSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_button_preferences, rootKey)
            findPreference<SwitchPreferenceCompat>("sleep_timer_lock")?.setOnPreferenceChangeListener { _, newValue ->
                if (newValue == true) {
                    val devicePolicyManager = requireContext().getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
                    val admin = ComponentName(requireContext(), DeviceAdminReceiver::class.java)
                    if (!devicePolicyManager.isAdminActive(admin)) {
                        startActivity(
                            Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, admin)
                            }
                        )
                    }
                }
                true
            }
            findPreference<Preference>("action_open_admin_settings")?.setOnPreferenceClickListener {
                startActivity(Intent().setComponent(ComponentName("com.android.settings", "com.android.settings.DeviceAdminSettings")))
                true
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                findPreference<SwitchPreferenceCompat>(AppConstants.PLAYER_AUDIO_COMPRESSOR_BUTTON)?.isVisible = false
            }
            findPreference<Preference>("nav_player_menu_settings")?.setOnPreferenceClickListener {
                requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.setExpanded(true)
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalPlayerMenuSettingsFragment())
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class PlayerMenuSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.player_menu_preferences, rootKey)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class BufferSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            val prefs = requireContext().prefs()
            if (LiveLatencySettings.materializeProfileValues(prefs)) {
                (requireActivity() as? SettingsActivity)?.setResult()
                stopPlaybackServices()
            }
            setPreferencesFromResource(R.xml.buffer_preferences, rootKey)
            bindLatencyPreferences()
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }

        private fun bindLatencyPreferences() {
            val prefs = requireContext().prefs()
            val settingsActivity = requireActivity() as? SettingsActivity
            syncLatencyPreferenceValues()
            findPreference<ListPreference>(AppConstants.PLAYER_LATENCY_PROFILE)?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                val profile = newValue?.toString() ?: LiveLatencySettings.DEFAULT_PROFILE
                LiveLatencySettings.applyPreset(prefs, profile)
                settingsActivity?.setResult()
                syncLatencyPreferenceValues()
                stopPlaybackServices()
                true
            }
            latencyEditKeys.forEach { key ->
                findPreference<EditTextPreference>(key)?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, _ ->
                    settingsActivity?.setResult()
                    stopPlaybackServices()
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

        private fun stopPlaybackServices() {
            requireContext().stopService(Intent(requireContext(), PlaybackService::class.java))
            requireContext().stopService(Intent(requireContext(), IvsPlayerService::class.java))
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
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class PlaybackSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.playback_preferences, rootKey)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    @AndroidEntryPoint
    class ApiTokenSettingsFragment : MaterialPreferenceFragment() {
        @Inject
        lateinit var kickRepository: KickRepository

        private val eventScopes = setOf("events:subscribe")

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.api_token_preferences, rootKey)
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
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
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
                // Restore is the non-destructive option, so it gets the affirmative button.
                .setPositiveButton(getString(R.string.leftover_files_restore)) { _, _ ->
                    viewModel.importDownloads()
                }
                .setNegativeButton(getString(android.R.string.cancel), null)
                .setNeutralButton(getString(R.string.leftover_files_delete)) { _, _ ->
                    requireContext().getAlertDialogBuilder()
                        .setTitle(getString(R.string.leftover_files_delete))
                        .setMessage(getString(R.string.leftover_files_delete_confirm, found.count, formatBytes(found.bytes)))
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
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
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
            findPreference<EditTextPreference>("update_check_frequency")?.apply {
                summary = getString(R.string.update_check_frequency_summary, text)
                setOnPreferenceChangeListener { _, newValue ->
                    summary = getString(R.string.update_check_frequency_summary, newValue)
                    true
                }
            }
            findPreference<SwitchPreferenceCompat>("update_use_browser")?.setOnPreferenceChangeListener { _, newValue ->
                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.UPSIDE_DOWN_CAKE &&
                    newValue == false &&
                    requireContext().prefs().getBoolean(AppConstants.UPDATE_CHECK_ENABLED, false) &&
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
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    @AndroidEntryPoint
    class DebugSettingsFragment : MaterialPreferenceFragment() {
        @Inject
        lateinit var localFollowChannelRepository: LocalFollowChannelRepository

        @Inject
        lateinit var notificationUsersRepository: NotificationUsersRepository

        @Inject
        lateinit var shownNotificationsRepository: ShownNotificationsRepository

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.debug_preferences, rootKey)
            findPreference<Preference>("action_customize_debug_logs")?.setOnPreferenceClickListener {
                findNavController().navigate(SettingsNavGraphDirections.actionGlobalDebugLogSettingsFragment())
                true
            }
            findPreference<Preference>("action_force_kick_token_expiry")?.setOnPreferenceClickListener {
                requireContext().tokenPrefs().edit {
                    putLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, (System.currentTimeMillis() / 1000L) - 3600L)
                }
                Toast.makeText(requireContext(), R.string.debug_force_kick_token_expiry_done, Toast.LENGTH_LONG).show()
                true
            }
            findPreference<Preference>("action_api_settings")?.setOnPreferenceClickListener { preference ->
                var newId = 1000
                val view = LinearLayout(requireContext()).apply {
                    id = R.id.layout
                    orientation = LinearLayout.VERTICAL
                }
                val list = listOf(
                    Triple(getString(R.string.games), AppConstants.API_PREFS_GAMES, AppConstants.DEFAULT_API_PREFS_GAMES),
                    Triple(getString(R.string.streams), AppConstants.API_PREFS_STREAMS, AppConstants.DEFAULT_API_PREFS_STREAMS),
                    Triple(getString(R.string.followed_games), AppConstants.API_PREFS_FOLLOWED_GAMES, AppConstants.DEFAULT_API_PREFS_FOLLOWED_GAMES),
                    Triple(getString(R.string.followed_streams), AppConstants.API_PREFS_FOLLOWED_STREAMS, AppConstants.DEFAULT_API_PREFS_FOLLOWED_STREAMS),
                    Triple(getString(R.string.followed_channels), AppConstants.API_PREFS_FOLLOWED_CHANNELS, AppConstants.DEFAULT_API_PREFS_FOLLOWED_CHANNELS),
                    Triple(getString(R.string.channel_videos), AppConstants.API_PREFS_CHANNEL_VIDEOS, AppConstants.DEFAULT_API_PREFS_CHANNEL_VIDEOS),
                    Triple(getString(R.string.channel_clips), AppConstants.API_PREFS_CHANNEL_CLIPS, AppConstants.DEFAULT_API_PREFS_CHANNEL_CLIPS),
                    Triple(getString(R.string.game_streams), AppConstants.API_PREFS_GAME_STREAMS, AppConstants.DEFAULT_API_PREFS_GAME_STREAMS),
                    Triple(getString(R.string.game_clips), AppConstants.API_PREFS_GAME_CLIPS, AppConstants.DEFAULT_API_PREFS_GAME_CLIPS),
                    Triple(getString(R.string.search_videos), AppConstants.API_PREFS_SEARCH_VIDEOS, AppConstants.DEFAULT_API_PREFS_SEARCH_VIDEOS),
                    Triple(getString(R.string.search_streams), AppConstants.API_PREFS_SEARCH_STREAMS, AppConstants.DEFAULT_API_PREFS_SEARCH_STREAMS),
                    Triple(getString(R.string.search_games), AppConstants.API_PREFS_SEARCH_GAMES, AppConstants.DEFAULT_API_PREFS_SEARCH_GAMES),
                ).map { item ->
                    newId++
                    view.addView(TextView(requireContext()).apply {
                        text = item.first
                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply {
                            val horizontalMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, resources.displayMetrics).toInt()
                            val verticalMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics).toInt()
                            setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin)
                        }
                        context.obtainStyledAttributes(intArrayOf(com.google.android.material.R.attr.textAppearanceTitleMedium)).use {
                            TextViewCompat.setTextAppearance(this, it.getResourceId(0, 0))
                        }
                    })
                    val prefKey = item.second
                    val list = (requireContext().prefs().getString(prefKey, null) ?: item.third).split(',').mapNotNull {
                        val split = it.split(':')
                        if (split.getOrNull(0) != AppConstants.KICK) return@mapNotNull null
                        SettingsDragListItem(
                            key = split[0],
                            text = when (split[0]) {
                                "3" -> getString(R.string.api_kick)
                                else -> getString(R.string.api_kick)
                            },
                            default = false,
                            enabled = split.getOrNull(1) != "0",
                        )
                    }
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
                    val recyclerView = RecyclerView(requireContext()).apply {
                        id = newId
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = listAdapter
                    }
                    itemTouchHelper.attachToRecyclerView(recyclerView)
                    listAdapter.submitList(list)
                    view.addView(recyclerView)
                    prefKey to listAdapter
                }
                requireContext().getAlertDialogBuilder()
                    .setTitle(preference.title)
                    .setView(NestedScrollView(requireContext()).apply {
                        addView(view)
                        val padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, resources.displayMetrics).toInt()
                        setPadding(0, padding, 0, 0)
                    })
                    .setPositiveButton(getString(android.R.string.ok)) { _, _ ->
                        requireContext().prefs().edit {
                            list.forEach { item ->
                                putString(item.first, item.second.currentList.joinToString(",") {
                                    "${it.key}:${if (it.enabled) "1" else "0"}"
                                })
                            }
                            (requireActivity() as? SettingsActivity)?.setResult()
                        }
                    }
                    .setNegativeButton(getString(android.R.string.cancel), null)
                    .show()
                true
            }
            findPreference<Preference>("action_delete_all_followed_channels")?.setOnPreferenceClickListener {
                requireActivity().getAlertDialogBuilder()
                    .setTitle(getString(R.string.debug_delete_all_followed_channels))
                    .setMessage(getString(R.string.debug_delete_all_followed_channels_message))
                    .setPositiveButton(getString(R.string.yes)) { _, _ ->
                        viewLifecycleOwner.lifecycleScope.launch {
                            localFollowChannelRepository.deleteAllFollows()
                            notificationUsersRepository.deleteAllUsers()
                            shownNotificationsRepository.deleteAll()
                            Toast.makeText(requireContext(), getString(R.string.debug_delete_all_followed_channels_done), Toast.LENGTH_LONG).show()
                        }
                    }
                    .setNegativeButton(getString(android.R.string.cancel), null)
                    .show()
                true
            }
            findPreference<EditTextPreference>("gql_headers")?.apply {
                isPersistent = false
                text = requireContext().tokenPrefs().getString(AppConstants.GQL_HEADERS, null)
                setOnPreferenceChangeListener { _, newValue ->
                    requireContext().tokenPrefs().edit {
                        putString(AppConstants.GQL_HEADERS, newValue.toString())
                    }
                    true
                }
            }
            val httpEngine = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7
            val cronet = CronetProvider.getAllProviders(requireContext()).any { it.isEnabled }
            if (!httpEngine || !cronet) {
                findPreference<ListPreference>(AppConstants.NETWORK_LIBRARY)?.apply {
                    when {
                        !httpEngine && !cronet -> {
                            isVisible = false
                        }
                        !cronet -> {
                            setEntries(R.array.networkLibraryEntriesNoCronet)
                            setEntryValues(R.array.networkLibraryEntriesNoCronet)
                        }
                        else -> {
                            setEntries(R.array.networkLibraryEntriesNoHttpEngine)
                            setEntryValues(R.array.networkLibraryEntriesNoHttpEngine)
                        }
                    }
                }
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class DebugLogSettingsFragment : MaterialPreferenceFragment() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.debug_log_preferences, rootKey)
            findPreference<Preference>("action_clear_diagnostic_log")?.setOnPreferenceClickListener {
                DiagnosticLogger.clear(requireContext())
                Toast.makeText(requireContext(), R.string.diagnostic_log_clear_done, Toast.LENGTH_SHORT).show()
                true
            }
            findPreference<Preference>("action_share_diagnostic_log")?.setOnPreferenceClickListener {
                val exportFile = DiagnosticLogger.exportFile(requireContext())
                if (exportFile == null) {
                    Toast.makeText(requireContext(), R.string.diagnostic_log_share_empty, Toast.LENGTH_SHORT).show()
                } else {
                    val uri = FileProvider.getUriForFile(
                        requireContext(),
                        "${requireContext().packageName}.diagnostic-file-provider",
                        exportFile
                    )
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_STREAM, uri)
                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    }
                    startActivity(Intent.createChooser(intent, getString(R.string.diagnostic_log_share_title)))
                }
                true
            }
            findPreference<Preference>("action_test_diagnostic_log")?.setOnPreferenceClickListener {
                DiagnosticLogger.testEntry()
                Toast.makeText(requireContext(), R.string.diagnostic_log_test_done, Toast.LENGTH_SHORT).show()
                true
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    listView.let {
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
            }
            (requireActivity() as? SettingsActivity)?.getSelectedSearchItem()?.let { scrollToPreference(it) }
        }
    }

    class SettingsSearchFragment : Fragment() {
        private var preferences: List<SettingsSearchItem>? = null
        private var adapter: SettingsSearchAdapter? = null
        private var savedQuery: String? = null

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return RecyclerView(requireContext()).apply {
                clipToPadding = false
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        @SuppressLint("RestrictedApi")
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                view.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
                if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                    (view as RecyclerView).let {
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
            }
            (requireActivity() as? SettingsActivity)?.showSearchView(true)
            adapter = SettingsSearchAdapter(this).also {
                it.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {

                    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                        it.unregisterAdapterDataObserver(this)
                        it.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                                try {
                                    if (positionStart == 0) {
                                        (view as RecyclerView).scrollToPosition(0)
                                    }
                                } catch (e: Exception) {

                                }
                            }
                        })
                    }
                })
            }
            (view as RecyclerView).adapter = adapter
            if (preferences == null) {
                val list = mutableListOf<SettingsSearchItem>()
                val preferenceManager = PreferenceManager(requireContext())
                listOf(
                    Triple(R.xml.general_preferences, SettingsNavGraphDirections.actionGlobalGeneralSettingsFragment(), getString(R.string.general)),
                    Triple(R.xml.appearance_preferences, SettingsNavGraphDirections.actionGlobalAppearanceSettingsFragment(), getString(R.string.appearance)),
                    Triple(R.xml.navigation_preferences, SettingsNavGraphDirections.actionGlobalNavigationSettingsFragment(), getString(R.string.navigation)),
                    Triple(R.xml.chat_preferences, SettingsNavGraphDirections.actionGlobalChatSettingsFragment(), getString(R.string.chat_settings)),
                    Triple(R.xml.player_overview_preferences, SettingsNavGraphDirections.actionGlobalPlayerOverviewFragment(), getString(R.string.player_settings)),
                    Triple(R.xml.player_preferences, SettingsNavGraphDirections.actionGlobalPlayerSettingsFragment(), getString(R.string.player_behavior)),
                    Triple(R.xml.player_button_preferences, SettingsNavGraphDirections.actionGlobalPlayerButtonSettingsFragment(), getString(R.string.player_buttons)),
                    Triple(R.xml.player_menu_preferences, SettingsNavGraphDirections.actionGlobalPlayerMenuSettingsFragment(), getString(R.string.player_menu_settings)),
                    Triple(R.xml.buffer_preferences, SettingsNavGraphDirections.actionGlobalBufferSettingsFragment(), getString(R.string.buffer_settings)),
                    Triple(R.xml.download_preferences, SettingsNavGraphDirections.actionGlobalDownloadSettingsFragment(), getString(R.string.download_settings)),
                    Triple(R.xml.advanced_preferences, SettingsNavGraphDirections.actionGlobalAdvancedSettingsFragment(), getString(R.string.advanced)),
                    Triple(R.xml.proxy_preferences, SettingsNavGraphDirections.actionGlobalProxySettingsFragment(), getString(R.string.proxy_settings)),
                    Triple(R.xml.playback_preferences, SettingsNavGraphDirections.actionGlobalPlaybackSettingsFragment(), getString(R.string.playback_settings)),
                    Triple(R.xml.api_token_preferences, SettingsNavGraphDirections.actionGlobalApiTokenSettingsFragment(), getString(R.string.api_token_settings)),
                    Triple(R.xml.update_preferences, SettingsNavGraphDirections.actionGlobalUpdateSettingsFragment(), getString(R.string.update_settings)),
                    Triple(R.xml.debug_preferences, SettingsNavGraphDirections.actionGlobalDebugSettingsFragment(), getString(R.string.debug_settings)),
                    Triple(R.xml.debug_log_preferences, SettingsNavGraphDirections.actionGlobalDebugLogSettingsFragment(), getString(R.string.customize_debug_logs)),
                ).forEach { item ->
                    preferenceManager.inflateFromResource(requireContext(), item.first, null).forEach {
                        when (it) {
                            is SwitchPreferenceCompat -> {
                                list.add(SettingsSearchItem(
                                    navDirections = item.second,
                                    location = item.third,
                                    key = it.key,
                                    title = it.title,
                                    summary = it.summary,
                                    value = if (it.isChecked) {
                                        getString(R.string.enabled_setting)
                                    } else {
                                        getString(R.string.disabled_setting)
                                    }
                                ))
                            }
                            is SeekBarPreference -> {
                                list.add(SettingsSearchItem(
                                    navDirections = item.second,
                                    location = item.third,
                                    key = it.key,
                                    title = it.title,
                                    summary = it.summary,
                                    value = it.value.toString()
                                ))
                            }
                            is PreferenceCategory -> {}
                            else -> {
                                list.add(SettingsSearchItem(
                                    navDirections = item.second,
                                    location = item.third,
                                    key = it.key,
                                    title = it.title,
                                    summary = it.summary,
                                ))
                            }
                        }
                    }
                }
                preferences = list
            }
            requireActivity().findViewById<SearchView>(R.id.searchView)?.let {
                savedQuery?.let { query -> it.setQuery(query, true) }
                it.requestFocus()
                WindowCompat.getInsetsController(requireActivity().window, it).show(WindowInsetsCompat.Type.ime())
            }
        }

        fun search(query: String) {
            savedQuery = query
            if (query.isNotBlank()) {
                preferences?.filter { it.title?.contains(query, true) == true || it.summary?.contains(query, true) == true }?.let { list ->
                    adapter?.submitList(list)
                }
            } else {
                adapter?.submitList(emptyList())
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            (requireActivity() as? SettingsActivity)?.showSearchView(false)
        }
    }
}
