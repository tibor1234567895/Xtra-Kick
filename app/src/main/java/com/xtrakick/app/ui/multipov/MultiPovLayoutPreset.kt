package com.xtrakick.app.ui.multipov

import com.xtrakick.app.util.AppConstants

/**
 * Grid arrangements for MultiPOV.
 * Primary layouts enlarge the first slot; [MultiPovViewModel.rotateSlotOrder] / make-primary change that seat.
 */
enum class MultiPovLayoutPreset(val prefValue: String) {
    EQUAL(AppConstants.MULTIPOV_LAYOUT_EQUAL),
    PRIMARY_TOP(AppConstants.MULTIPOV_LAYOUT_PRIMARY_TOP),
    PRIMARY_LEFT(AppConstants.MULTIPOV_LAYOUT_PRIMARY_LEFT);

    fun next(): MultiPovLayoutPreset {
        val all = entries
        return all[(ordinal + 1) % all.size]
    }

    fun labelRes(): Int = when (this) {
        EQUAL -> com.xtrakick.app.R.string.multipov_layout_equal
        PRIMARY_TOP -> com.xtrakick.app.R.string.multipov_layout_primary_top
        PRIMARY_LEFT -> com.xtrakick.app.R.string.multipov_layout_primary_left
    }

    companion object {
        fun fromPref(value: String?): MultiPovLayoutPreset {
            return when (value) {
                AppConstants.MULTIPOV_LAYOUT_PRIMARY,
                AppConstants.MULTIPOV_LAYOUT_PRIMARY_TOP -> PRIMARY_TOP
                AppConstants.MULTIPOV_LAYOUT_PRIMARY_LEFT -> PRIMARY_LEFT
                else -> EQUAL
            }
        }

        fun fromPrefs(prefs: android.content.SharedPreferences): MultiPovLayoutPreset {
            return fromPref(prefs.getString(AppConstants.MULTIPOV_LAYOUT, AppConstants.MULTIPOV_LAYOUT_EQUAL))
        }
    }
}
