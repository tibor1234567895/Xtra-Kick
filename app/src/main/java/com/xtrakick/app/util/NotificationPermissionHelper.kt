package com.xtrakick.app.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import com.xtrakick.app.R

object NotificationPermissionHelper {

    const val PREF_NOTIFICATION_PRIMER_SHOWN = "notification_permission_primer_shown"
    const val PREF_FOLLOWING_BANNER_DISMISSED = "notification_following_banner_dismissed"

    fun hasPermission(context: Context): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return true
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun shouldPromptContextual(context: Context): Boolean {
        if (hasPermission(context)) return false
        return !context.prefs().getBoolean(PREF_NOTIFICATION_PRIMER_SHOWN, false)
    }

    fun markPrimerShown(context: Context) {
        context.prefs().edit().putBoolean(PREF_NOTIFICATION_PRIMER_SHOWN, true).apply()
    }

    fun isBannerDismissed(context: Context): Boolean {
        return context.prefs().getBoolean(PREF_FOLLOWING_BANNER_DISMISSED, false)
    }

    fun markBannerDismissed(context: Context) {
        context.prefs().edit().putBoolean(PREF_FOLLOWING_BANNER_DISMISSED, true).apply()
    }

    fun showPrimerDialog(
        activity: Activity,
        onAccept: () -> Unit,
        onDecline: (() -> Unit)? = null,
    ) {
        if (activity.isFinishing || activity.isDestroyed) return
        markPrimerShown(activity)
        activity.getAlertDialogBuilder()
            .setTitle(R.string.notification_permission_primer_title)
            .setMessage(R.string.notification_permission_primer_message)
            .setPositiveButton(R.string.action_enable) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                onAccept()
            }
            .setNegativeButton(R.string.action_not_now) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                onDecline?.invoke()
            }
            .show()
    }

    fun requestWithPrimerIfNeeded(
        activity: Activity,
        launcher: ActivityResultLauncher<String>,
        forcePrompt: Boolean = false,
    ) {
        if (hasPermission(activity)) return
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return

        if (forcePrompt || shouldPromptContextual(activity)) {
            showPrimerDialog(
                activity = activity,
                onAccept = {
                    launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            )
        } else {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}
