package com.xtrakick.app.ui.multipov

import com.xtrakick.app.util.AppConstants

/**
 * One row of the portrait grid: tiles in the row and its 16:9 height
 * factor (fraction of grid width × 9/16). Single source of truth — the
 * builder and the video-section height both derive from these rows.
 */
data class PortraitRow(val tilesInRow: Int, val heightFactor: Float)

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

    fun labelRes(isPortrait: Boolean = false): Int = when (this) {
        EQUAL -> com.xtrakick.app.R.string.multipov_layout_equal
        PRIMARY_TOP -> com.xtrakick.app.R.string.multipov_layout_primary_top
        PRIMARY_LEFT -> if (isPortrait) com.xtrakick.app.R.string.multipov_layout_stacked else com.xtrakick.app.R.string.multipov_layout_primary_left
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

        fun solvePortraitRows(count: Int, preset: MultiPovLayoutPreset): List<PortraitRow> {
            if (count <= 1) return listOf(PortraitRow(1, 1f))
            return when (preset) {
                // Large on top: full-width primary row, remaining streams in rows below.
                // For 2 streams: 1 on top (100%), 1 below (50% centered) -> 1.5f (~45% screen).
                // For 3 streams: 1 on top (100%), 2 below (50% each) -> 1.5f (~45% screen).
                PRIMARY_TOP -> {
                    val rest = count - 1
                    val cols = if (rest <= 2) 2 else if (rest == 3) 3 else 2
                    buildList {
                        add(PortraitRow(1, 1f))
                        var remaining = rest
                        while (remaining > 0) {
                            val inRow = minOf(cols, remaining)
                            add(PortraitRow(cols, 1f / cols))
                            remaining -= inRow
                        }
                    }
                }
                // Stacked (portrait) / Large on left (landscape):
                // In portrait, stacks streams full-width (100% width each).
                PRIMARY_LEFT -> {
                    List(count) { PortraitRow(1, 1f) }
                }
                // Equal tiles: uniform matrix.
                // 2 streams: 1 row with 2 side-by-side tiles (0.5f, ~18% screen).
                // 3-4 streams: 2x2 grid.
                else -> {
                    val cols = if (count >= 2) 2 else 1
                    val rows = (count + cols - 1) / cols
                    List(rows) { PortraitRow(cols, 1f / cols) }
                }
            }
        }
    }
}

