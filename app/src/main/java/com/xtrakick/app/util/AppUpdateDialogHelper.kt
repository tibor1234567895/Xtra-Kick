package com.xtrakick.app.util

import android.content.Context
import android.text.format.Formatter
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogAppUpdateBinding
import com.xtrakick.app.model.AppUpdateInfo

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

        val dialog = MaterialAlertDialogBuilder(context)
            .setView(binding.root)
            .setCancelable(true)
            .create()

        binding.closeButton.setOnClickListener {
            onRemindLater()
            dialog.dismiss()
        }

        binding.updateButton.setOnClickListener {
            onUpdate()
            dialog.dismiss()
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
}
