package com.xtrakick.app.ui.settings

import android.content.ClipData
import android.content.ClipboardManager
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.format.Formatter
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.content.edit
import androidx.core.content.res.use
import androidx.core.widget.NestedScrollView
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.xtrakick.app.KickApp
import com.xtrakick.app.R
import com.xtrakick.app.SettingsNavGraphDirections
import com.xtrakick.app.model.ui.SettingsDragListItem
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.ui.view.SafeLinearLayoutManager
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.HttpEngineAvailability
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Collections
import javax.inject.Inject

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
        findPreference<Preference>("action_reset_update_timestamps")?.setOnPreferenceClickListener {
            requireContext().tokenPrefs().edit {
                putLong(AppConstants.UPDATE_LAST_CHECKED, 0L)
                putLong(AppConstants.UPDATE_LAST_INSTALL_TIME, 0L)
                putLong(AppConstants.UPDATE_SKIPPED_RELEASE_TIME, 0L)
                putLong(AppConstants.UPDATE_LAST_CHECK_TIMESTAMP, 0L)
            }
            Toast.makeText(requireContext(), R.string.debug_reset_update_timestamps_success, Toast.LENGTH_SHORT).show()
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
                val items = (requireContext().prefs().getString(prefKey, null) ?: item.third).split(',').mapNotNull {
                    val split = it.split(':')
                    if (split.getOrNull(0) != AppConstants.KICK) return@mapNotNull null
                    SettingsDragListItem(
                        key = split[0],
                        text = getString(R.string.api_kick),
                        default = false,
                        enabled = split.getOrNull(1) != "0",
                    )
                }
                val listAdapter = SettingsDragListAdapter()
                val itemTouchHelper = ItemTouchHelper(
                    object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                            Collections.swap(items, viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
                            listAdapter.notifyItemMoved(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
                            return true
                        }

                        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit

                        override fun isLongPressDragEnabled(): Boolean = false
                    }
                )
                listAdapter.itemTouchHelper = itemTouchHelper
                val recyclerView = RecyclerView(requireContext()).apply {
                    id = newId
                    layoutManager = SafeLinearLayoutManager(requireContext())
                    adapter = listAdapter
                }
                itemTouchHelper.attachToRecyclerView(recyclerView)
                listAdapter.submitList(items)
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
        val app = requireActivity().application as? KickApp
        val httpEngine = HttpEngineAvailability.isAvailable && app?.isHttpEngineAvailable() == true
        val cronet = app?.isCronetAvailable() == true
        findPreference<ListPreference>(AppConstants.NETWORK_LIBRARY)?.apply {
            setOnPreferenceChangeListener { _, _ ->
                runCatching {
                    @OptIn(coil3.annotation.DelicateCoilApi::class)
                    coil3.SingletonImageLoader.reset()
                }
                true
            }
            if (!httpEngine || !cronet) {
                when {
                    !httpEngine && !cronet -> {
                        isVisible = false
                        if (value != "OkHttp") {
                            value = "OkHttp"
                        }
                    }
                    !cronet -> {
                        setEntries(R.array.networkLibraryEntriesNoCronet)
                        setEntryValues(R.array.networkLibraryEntriesNoCronet)
                        if (value == "Cronet") {
                            value = if (httpEngine) "HttpEngine" else "OkHttp"
                        }
                    }
                    else -> {
                        setEntries(R.array.networkLibraryEntriesNoHttpEngine)
                        setEntryValues(R.array.networkLibraryEntriesNoHttpEngine)
                        if (value == "HttpEngine") {
                            value = if (cronet) "Cronet" else "OkHttp"
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStandardListBehavior()
    }
}

class DebugLogSettingsFragment : MaterialPreferenceFragment() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.debug_log_preferences, rootKey)
        findPreference<Preference>("action_clear_diagnostic_log")?.setOnPreferenceClickListener {
            DiagnosticLogger.clear(requireContext())
            Toast.makeText(requireContext(), R.string.diagnostic_log_clear_done, Toast.LENGTH_SHORT).show()
            refreshDiagnosticSummary()
            true
        }
        findPreference<Preference>("action_share_diagnostic_log")?.setOnPreferenceClickListener {
            openDiagnosticLogViewer()
            true
        }
        findPreference<Preference>("action_test_diagnostic_log")?.setOnPreferenceClickListener {
            DiagnosticLogger.testEntry()
            Toast.makeText(requireContext(), R.string.diagnostic_log_test_done, Toast.LENGTH_SHORT).show()
            refreshDiagnosticSummary()
            true
        }
    }

    override fun onResume() {
        super.onResume()
        refreshDiagnosticSummary()
    }

    /** Live state under the View entry: size + entries, or empty. */
    private fun refreshDiagnosticSummary() {
        val pref = findPreference<Preference>("action_share_diagnostic_log") ?: return
        lifecycleScope.launch {
            val logView = withContext(Dispatchers.IO) {
                runCatching { DiagnosticLogger.readForView(requireContext()) }.getOrNull()
            }
            if (!isAdded) return@launch
            pref.summary = if (logView == null) {
                getString(R.string.diagnostic_log_share_empty)
            } else {
                getString(
                    R.string.diagnostic_log_status,
                    Formatter.formatShortFileSize(requireContext(), logView.totalBytes),
                    logView.entryCount,
                )
            }
        }
    }

    private fun openDiagnosticLogViewer() {
        lifecycleScope.launch {
            val logView = withContext(Dispatchers.IO) {
                runCatching { DiagnosticLogger.readForView(requireContext()) }.getOrNull()
            }
            if (!isAdded) return@launch
            if (logView == null) {
                Toast.makeText(requireContext(), R.string.diagnostic_log_share_empty, Toast.LENGTH_SHORT).show()
                return@launch
            }
            showDiagnosticLogDialog(logView)
        }
    }

    private fun showDiagnosticLogDialog(logView: DiagnosticLogger.DiagnosticLogView) {
        val context = requireContext()
        val density = resources.displayMetrics.density
        val status = TextView(context).apply {
            text = buildDiagnosticStatusText(logView)
        }
        val preview = TextView(context).apply {
            text = logView.preview
            typeface = Typeface.MONOSPACE
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
            setTextIsSelectable(true)
        }
        val scroll = NestedScrollView(context).apply {
            addView(preview)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (360f * density).toInt(),
            )
        }
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            addView(status)
            addView(scroll, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            ).apply { topMargin = (8f * density).toInt() })
            val padding = (20f * density).toInt()
            setPadding(padding, (4f * density).toInt(), padding, 0)
        }
        val dialog = context.getAlertDialogBuilder()
            .setTitle(R.string.diagnostic_log_share)
            .setView(container)
            .setPositiveButton(R.string.share) { _, _ ->
                shareDiagnosticLog()
            }
            .setNeutralButton(R.string.diagnostic_log_copy, null)
            .setNegativeButton(R.string.close, null)
            .create()

        dialog.setOnShowListener {
            val neutralBtn = dialog.getButton(DialogInterface.BUTTON_NEUTRAL)
            (neutralBtn as? MaterialButton)?.setIconResource(R.drawable.baseline_content_copy_24)
            neutralBtn?.setOnClickListener {
                copyDiagnosticLogToClipboard(logView)
            }
        }
        dialog.show()
    }

    private fun copyDiagnosticLogToClipboard(logView: DiagnosticLogger.DiagnosticLogView) {
        val context = context ?: return
        lifecycleScope.launch {
            val fullText = withContext(Dispatchers.IO) {
                runCatching { DiagnosticLogger.exportFile(context)?.readText() }.getOrNull()
            }?.takeIf { it.isNotBlank() } ?: logView.preview

            if (!isAdded) return@launch
            val clipboard = ContextCompat.getSystemService(context, ClipboardManager::class.java)
            if (clipboard != null) {
                val clip = ClipData.newPlainText("Xtra Diagnostic Log", fullText)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(context, R.string.diagnostic_log_copied, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buildDiagnosticStatusText(logView: DiagnosticLogger.DiagnosticLogView): String {
        val context = requireContext()
        val base = getString(
            R.string.diagnostic_log_status,
            Formatter.formatShortFileSize(context, logView.totalBytes),
            logView.entryCount,
        )
        return if (logView.truncated) {
            base + "\n" + getString(
                R.string.diagnostic_log_preview_truncated,
                (logView.preview.length / 1024).coerceAtLeast(1),
            )
        } else {
            base
        }
    }

    private fun shareDiagnosticLog() {
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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStandardListBehavior()
    }
}
