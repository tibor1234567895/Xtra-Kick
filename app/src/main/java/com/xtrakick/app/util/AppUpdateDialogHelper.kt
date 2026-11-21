package com.xtrakick.app.util

import android.content.Context
import android.text.format.Formatter
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogAppUpdateBinding
import com.xtrakick.app.databinding.DialogUpdateDownloadBinding
import com.xtrakick.app.model.AppUpdateInfo

data class UpdateDownloadProgress(val bytesRead: Long, val totalBytes: Long?)

object AppUpdateDialogHelper {

    private val GIT_SHA_PREFIX = Regex("^[0-9a-fA-F]{7,10}\\s+")
    private val MARKDOWN_HEADER = Regex("^#+\\s*")
    private val LIST_PREFIX = Regex("^[\\*\\-\\•]\\s*")

    fun formatChangelog(rawNotes: String?, defaultDescription: String): String {
        if (rawNotes.isNullOrBlank()) return defaultDescription

        val lines = rawNotes.lines()
            .map { it.trim() }
            .map { line ->
                var cleaned = line
                cleaned = GIT_SHA_PREFIX.replace(cleaned, "")
                cleaned = MARKDOWN_HEADER.replace(cleaned, "")
                cleaned = LIST_PREFIX.replace(cleaned, "")
                cleaned.trim()
            }
            .filter { line ->
                line.isNotBlank() &&
                    !line.startsWith("Merge branch ", ignoreCase = true) &&
                    !line.startsWith("Merge pull request ", ignoreCase = true) &&
                    !line.contains("into integrate-dependabot", ignoreCase = true) &&
                    !line.contains("Active Changelog:", ignoreCase = true) &&
                    !line.startsWith("Release build ", ignoreCase = true) &&
                    !line.matches(Regex("^[\\s\\-_=*]+$"))
            }

        if (lines.isEmpty()) return defaultDescription

        return lines.joinToString("\n") { "• $it" }
    }

    fun showUpdateDialog(
        context: Context,
        updateInfo: AppUpdateInfo,
        onUpdate: () -> Unit,
        onRemindLater: () -> Unit,
        onSkip: () -> Unit,
    ): AlertDialog {
        val binding = DialogAppUpdateBinding.inflate(LayoutInflater.from(context))

        val title = updateInfo.releaseTitle?.takeIf { it.isNotBlank() }
            ?: context.getString(R.string.update_available)
        binding.updateTitle.text = title

        val sizeText = updateInfo.size?.takeIf { it > 0 }?.let {
            Formatter.formatShortFileSize(context, it)
        }
        binding.updateSubtitle.text = if (sizeText != null) {
            context.getString(R.string.update_available) + " • " + sizeText
        } else {
            context.getString(R.string.update_available)
        }

        val defaultDesc = context.getString(R.string.update_dialog_default_description)
        binding.changelogText.text = formatChangelog(updateInfo.releaseNotes, defaultDesc)

        val dialog = context.getAlertDialogBuilder()
            .setView(binding.root)
            .setCancelable(true)
            .create()

        binding.closeButton.setOnClickListener {
            onRemindLater()
            dialog.dismiss()
        }

        binding.updateButton.setOnClickListener {
            dialog.dismiss()
            onUpdate()
        }

        binding.remindLaterButton.setOnClickListener {
            onRemindLater()
            dialog.dismiss()
        }

        binding.skipButton.setOnClickListener {
            onSkip()
            dialog.dismiss()
        }

        dialog.setOnShowListener {
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

        dialog.show()
        return dialog
    }

    class UpdateDownloadDialog internal constructor(
        private val context: Context,
        private val binding: DialogUpdateDownloadBinding,
        private val dialog: AlertDialog,
        private val formattedTotal: String?,
    ) {
        private var lastPercent = -1
        private var lastFormattedRead: String? = null

        fun update(progress: UpdateDownloadProgress) {
            val total = progress.totalBytes
            if (formattedTotal == null || total == null || total <= 0L) return

            val formattedRead = Formatter.formatFileSize(context, progress.bytesRead)
            if (formattedRead != lastFormattedRead) {
                lastFormattedRead = formattedRead
                binding.textView.text = context.getString(
                    R.string.downloading_update_progress,
                    formattedRead,
                    formattedTotal,
                )
            }
            val percent = ((progress.bytesRead * 100L) / total).toInt().coerceIn(0, 100)
            if (percent != lastPercent) {
                lastPercent = percent
                binding.progressBar.setProgressCompat(percent, true)
            }
        }

        fun dismiss() {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
    }

    fun showDownloadDialog(
        context: Context,
        initial: UpdateDownloadProgress,
        onCancel: () -> Unit,
    ): UpdateDownloadDialog {
        val binding = DialogUpdateDownloadBinding.inflate(LayoutInflater.from(context))
        val formattedTotal = initial.totalBytes?.takeIf { it > 0L }?.let {
            Formatter.formatFileSize(context, it)
        }
        // Must configure indeterminate mode BEFORE the LinearProgressIndicator becomes visible.
        binding.progressBar.isIndeterminate = formattedTotal == null
        if (formattedTotal != null) {
            binding.progressBar.max = 100
        } else {
            binding.textView.text = context.getString(R.string.downloading_update)
        }

        val dialog = context.getAlertDialogBuilder()
            .setView(binding.root)
            .setNegativeButton(context.getString(android.R.string.cancel)) { _, _ ->
                onCancel()
            }
            .setOnCancelListener {
                onCancel()
            }
            .create()

        val handle = UpdateDownloadDialog(context, binding, dialog, formattedTotal)
        handle.update(initial)
        dialog.show()
        return handle
    }
}
