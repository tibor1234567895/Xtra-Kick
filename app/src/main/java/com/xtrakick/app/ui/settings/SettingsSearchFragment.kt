package com.xtrakick.app.ui.settings

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.preference.Preference
import androidx.preference.PreferenceGroup
import androidx.preference.PreferenceManager
import androidx.preference.SeekBarPreference
import androidx.preference.SwitchPreferenceCompat
import androidx.preference.forEach
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.SettingsNavGraphDirections
import com.xtrakick.app.model.ui.SettingsSearchItem
import com.xtrakick.app.ui.view.SafeLinearLayoutManager
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs

class SettingsSearchFragment : Fragment() {
    private var preferences: List<SettingsSearchItem>? = null
    private var adapter: SettingsSearchAdapter? = null
    private var savedQuery: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return RecyclerView(requireContext()).apply {
            clipToPadding = false
            layoutManager = SafeLinearLayoutManager(requireContext())
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime()
            )
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
                            } catch (_: Exception) {
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
            fun searchSource(xmlRes: Int, nav: androidx.navigation.NavDirections, titleRes: Int) =
                Triple(xmlRes, nav, getString(titleRes))
            val searchSources = mutableListOf(
                searchSource(R.xml.notifications_preferences, SettingsNavGraphDirections.actionGlobalNotificationsSettingsFragment(), R.string.notifications_and_rewards),
                searchSource(R.xml.appearance_preferences, SettingsNavGraphDirections.actionGlobalAppearanceSettingsFragment(), R.string.appearance),
                searchSource(R.xml.navigation_preferences, SettingsNavGraphDirections.actionGlobalNavigationSettingsFragment(), R.string.navigation),
                searchSource(R.xml.chat_preferences, SettingsNavGraphDirections.actionGlobalChatSettingsFragment(), R.string.chat_settings),
                searchSource(R.xml.player_overview_preferences, SettingsNavGraphDirections.actionGlobalPlayerOverviewFragment(), R.string.video_and_audio),
                searchSource(R.xml.player_background_preferences, SettingsNavGraphDirections.actionGlobalPlayerBackgroundSettingsFragment(), R.string.background_and_pip),
                searchSource(R.xml.player_button_preferences, SettingsNavGraphDirections.actionGlobalPlayerButtonSettingsFragment(), R.string.player_buttons),
                searchSource(R.xml.player_menu_preferences, SettingsNavGraphDirections.actionGlobalPlayerMenuSettingsFragment(), R.string.player_menu_settings),
                searchSource(R.xml.multipov_preferences, SettingsNavGraphDirections.actionGlobalMultiPovSettingsFragment(), R.string.multipov_settings),
                searchSource(R.xml.buffer_preferences, SettingsNavGraphDirections.actionGlobalBufferSettingsFragment(), R.string.buffer_settings),
                searchSource(R.xml.download_preferences, SettingsNavGraphDirections.actionGlobalDownloadSettingsFragment(), R.string.download_settings),
                searchSource(R.xml.advanced_preferences, SettingsNavGraphDirections.actionGlobalAdvancedSettingsFragment(), R.string.system_and_advanced),
                searchSource(R.xml.proxy_preferences, SettingsNavGraphDirections.actionGlobalProxySettingsFragment(), R.string.proxy_settings),
                searchSource(R.xml.playback_preferences, SettingsNavGraphDirections.actionGlobalPlaybackSettingsFragment(), R.string.stream_parameters),
                searchSource(R.xml.api_token_preferences, SettingsNavGraphDirections.actionGlobalApiTokenSettingsFragment(), R.string.account),
                searchSource(R.xml.update_preferences, SettingsNavGraphDirections.actionGlobalUpdateSettingsFragment(), R.string.update_settings),
            )
            // Debug Settings can swap the entire playback stack and the search
            // implementation. It must not be reachable in a shipped build.
            // The log-only screen is safe and always searchable.
            searchSources.add(searchSource(R.xml.debug_log_preferences, SettingsNavGraphDirections.actionGlobalDebugLogSettingsFragment(), R.string.customize_debug_logs))
            if (BuildConfig.DEBUG) {
                searchSources.add(searchSource(R.xml.debug_preferences, SettingsNavGraphDirections.actionGlobalDebugSettingsFragment(), R.string.debug_settings))
                // The developer token screen exposes live tokens and must stay
                // out of release search results.
                searchSources.add(searchSource(R.xml.developer_preferences, SettingsNavGraphDirections.actionGlobalDeveloperSettingsFragment(), R.string.developer_tokens))
            }
            fun collectPreferences(pref: Preference, navDirections: androidx.navigation.NavDirections, location: String) {
                if (!BuildConfig.DEBUG && (pref.key == "nav_developer_settings" || pref.key == "nav_debug_settings")) {
                    return
                }
                if (pref is PreferenceGroup) {
                    pref.forEach { child ->
                        collectPreferences(child, navDirections, location)
                    }
                    return
                }
                when (pref) {
                    is SwitchPreferenceCompat -> {
                        list.add(SettingsSearchItem(
                            navDirections = navDirections,
                            location = location,
                            key = pref.key,
                            title = pref.title,
                            summary = pref.summary,
                            value = if (pref.isChecked) {
                                getString(R.string.enabled_setting)
                            } else {
                                getString(R.string.disabled_setting)
                            }
                        ))
                    }
                    is SeekBarPreference -> {
                        list.add(SettingsSearchItem(
                            navDirections = navDirections,
                            location = location,
                            key = pref.key,
                            title = pref.title,
                            summary = pref.summary,
                            value = pref.value.toString()
                        ))
                    }
                    else -> {
                        list.add(SettingsSearchItem(
                            navDirections = navDirections,
                            location = location,
                            key = pref.key,
                            title = pref.title,
                            summary = pref.summary,
                        ))
                    }
                }
            }
            searchSources.forEach { item ->
                preferenceManager.inflateFromResource(requireContext(), item.first, null).let { root ->
                    collectPreferences(root, item.second, item.third)
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
