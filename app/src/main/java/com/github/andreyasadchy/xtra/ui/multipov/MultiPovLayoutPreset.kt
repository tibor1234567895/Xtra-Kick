package com.github.andreyasadchy.xtra.ui.multipov

import com.github.andreyasadchy.xtra.util.C

/**
 * Grid arrangements for MultiPOV.
 * Primary layouts enlarge the first slot; [MultiPovViewModel.rotateSlotOrder] / make-primary change that seat.
 */
enum class MultiPovLayoutPreset(val prefValue: String) {
    EQUAL(C.MULTIPOV_LAYOUT_EQUAL),
    PRIMARY_TOP(C.MULTIPOV_LAYOUT_PRIMARY_TOP),
    PRIMARY_LEFT(C.MULTIPOV_LAYOUT_PRIMARY_LEFT);

    fun next(): MultiPovLayoutPreset {
        val all = entries
        return all[(ordinal + 1) % all.size]
    }

    fun labelRes(): Int = when (this) {
        EQUAL -> com.github.andreyasadchy.xtra.R.string.multipov_layout_equal
        PRIMARY_TOP -> com.github.andreyasadchy.xtra.R.string.multipov_layout_primary_top
        PRIMARY_LEFT -> com.github.andreyasadchy.xtra.R.string.multipov_layout_primary_left
    }

    companion object {
        fun fromPref(value: String?): MultiPovLayoutPreset {
            return when (value) {
                C.MULTIPOV_LAYOUT_PRIMARY,
                C.MULTIPOV_LAYOUT_PRIMARY_TOP -> PRIMARY_TOP
                C.MULTIPOV_LAYOUT_PRIMARY_LEFT -> PRIMARY_LEFT
                else -> EQUAL
            }
        }

        fun fromPrefs(prefs: android.content.SharedPreferences): MultiPovLayoutPreset {
            return fromPref(prefs.getString(C.MULTIPOV_LAYOUT, C.MULTIPOV_LAYOUT_EQUAL))
        }
    }
}
