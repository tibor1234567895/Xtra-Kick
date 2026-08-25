package com.xtrakick.app.ui.multipov

import android.content.SharedPreferences
import com.xtrakick.app.util.AppConstants

/**
 * MultiPOV stream quality — applies to every tile unless bandwidth-saving forces
 * non-focused tiles to 480p.
 */
enum class MultiPovQuality(val prefValue: String, val maxHeight: Int?) {
    P360("360p", 360),
    P480("480p", 480),
    P720("720p", 720),
    P1080("1080p", 1080),
    SOURCE("source", null);

    fun labelRes(): Int = when (this) {
        P360 -> com.xtrakick.app.R.string.multipov_quality_360
        P480 -> com.xtrakick.app.R.string.multipov_quality_480
        P720 -> com.xtrakick.app.R.string.multipov_quality_720
        P1080 -> com.xtrakick.app.R.string.multipov_quality_1080
        SOURCE -> com.xtrakick.app.R.string.multipov_quality_source
    }

    companion object {
        const val DEFAULT_PREF = "source"

        fun fromPref(value: String?): MultiPovQuality {
            return entries.firstOrNull { it.prefValue.equals(value, ignoreCase = true) } ?: SOURCE
        }

        fun fromPrefs(prefs: SharedPreferences): MultiPovQuality {
            val raw = prefs.getString(AppConstants.MULTIPOV_QUALITY, null)
                ?: prefs.getString(AppConstants.MULTIPOV_SECONDARY_QUALITY, null) // migrate old key
            return fromPref(raw ?: DEFAULT_PREF)
        }
    }
}
