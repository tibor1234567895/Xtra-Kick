package com.xtrakick.app.ui.saved

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import com.xtrakick.app.R
import com.xtrakick.app.ui.settings.SettingsViewModel
import com.xtrakick.app.util.getAlertDialogBuilder
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * Leftover-downloads cleanup flow for the Saved screens. Settings keeps its own
 * copy of this dialog; results here surface as Snackbars.
 */
class LeftoverFilesUi(
    private val fragment: Fragment,
    private val viewModel: SettingsViewModel,
) {
    private fun formatBytes(bytes: Long): String =
        android.text.format.Formatter.formatShortFileSize(fragment.requireContext(), bytes)

    /** Result toasts + rescan. Call once from onViewCreated on the hosting parent. */
    fun attachResultToasts() {
        fragment.viewLifecycleOwner.lifecycleScope.launch {
            fragment.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.leftoverRestored.collect { count ->
                        if (!fragment.isAdded) return@collect
                        Snackbar.make(
                            fragment.requireView(),
                            fragment.getString(R.string.leftover_files_restored, count),
                            Snackbar.LENGTH_LONG
                        ).show()
                        viewModel.scanLeftoverFiles()
                    }
                }
                launch {
                    viewModel.leftoverDeleted.collect { freed ->
                        if (!fragment.isAdded) return@collect
                        Snackbar.make(
                            fragment.requireView(),
                            fragment.getString(R.string.leftover_files_deleted, formatBytes(freed)),
                            Snackbar.LENGTH_LONG
                        ).show()
                        viewModel.scanLeftoverFiles()
                    }
                }
            }
        }
    }

    /** Scan on demand, then show the dialog (or a toast when clean). */
    fun open() {
        fragment.viewLifecycleOwner.lifecycleScope.launch {
            val found = try {
                viewModel.scanLeftoverFiles()
                viewModel.leftoverScan.first()
            } catch (_: Exception) {
                return@launch
            }
            if (!fragment.isAdded) return@launch
            if (found.isEmpty) {
                Toast.makeText(fragment.requireContext(), fragment.getString(R.string.leftover_files_none), Toast.LENGTH_SHORT).show()
                return@launch
            }
            showDialog(found)
        }
    }

    private fun showDialog(found: SettingsViewModel.LeftoverFiles) {
        val listed = found.names.take(12).joinToString("\n")
        val extra = (found.count - found.names.size).takeIf { it > 0 }?.let { "\n… (+$it more)" }.orEmpty()
        fragment.requireContext().getAlertDialogBuilder()
            .setTitle(fragment.getString(R.string.leftover_files))
            .setMessage(fragment.getString(R.string.leftover_files_message, found.count, formatBytes(found.bytes)))
            .apply {
                // Restore only handles app-storage entries; hide it when nothing is restorable.
                if (found.restorableCount > 0) {
                    setPositiveButton(fragment.getString(R.string.leftover_files_restore)) { _, _ ->
                        viewModel.importDownloads()
                    }
                }
            }
            .setNegativeButton(fragment.getString(android.R.string.cancel), null)
            .setNeutralButton(fragment.getString(R.string.leftover_files_delete)) { _, _ ->
                fragment.requireContext().getAlertDialogBuilder()
                    .setTitle(fragment.getString(R.string.leftover_files_delete))
                    .setMessage(fragment.getString(R.string.leftover_files_delete_confirm, found.count, formatBytes(found.bytes)) + "\n\n" + listed + extra)
                    .setPositiveButton(fragment.getString(R.string.yes)) { _, _ -> viewModel.deleteLeftoverFiles() }
                    .setNegativeButton(fragment.getString(android.R.string.cancel), null)
                    .show()
            }
            .show()
    }
}
