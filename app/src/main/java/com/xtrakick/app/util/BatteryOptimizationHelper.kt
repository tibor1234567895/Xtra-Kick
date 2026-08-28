package com.xtrakick.app.util

import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.provider.Settings
import androidx.core.content.edit
import com.xtrakick.app.R

/**
 * Live notifications are a 15-minute WorkManager poll. On devices that battery-optimize the
 * app aggressively (Xiaomi/Huawei/Samsung/Oppo class), that poll is deferred for hours or
 * killed outright once the app leaves the foreground — which users report as "notifications
 * worked for a few days, then stopped" (GitHub issues #44/#58). Asking for the battery
 * optimization exemption once, when the user enables notifications, is the mitigation.
 *
 * Uses ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS (the list screen), which requires no
 * special manifest permission, rather than the direct ACTION_REQUEST_IGNORE_
 * BATTERY_OPTIMIZATIONS intent.
 */
object BatteryOptimizationHelper {

    fun isIgnoringBatteryOptimizations(context: Context): Boolean {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as? PowerManager
            ?: return true
        return powerManager.isIgnoringBatteryOptimizations(context.packageName)
    }

    /** One-time explainer; a no-op when the app is already exempt or was asked before. */
    fun maybePrompt(context: Context) {
        if (isIgnoringBatteryOptimizations(context)) return
        val preferences = context.prefs()
        if (preferences.getBoolean(AppConstants.BATTERY_OPT_PROMPT_SHOWN, false)) return
        preferences.edit { putBoolean(AppConstants.BATTERY_OPT_PROMPT_SHOWN, true) }
        context.getAlertDialogBuilder()
            .setTitle(R.string.battery_optimization_title)
            .setMessage(R.string.battery_optimization_message)
            .setNegativeButton(R.string.battery_optimization_later, null)
            .setPositiveButton(R.string.battery_optimization_open_settings) { _, _ ->
                runCatching {
                    context.startActivity(
                        Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    )
                }
            }
            .show()
    }
}
