package com.xtrakick.app.ui.multipov

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class MultiPovLayoutPresetTest {

    @Test
    fun solvePortraitRows_twoStreamsAllThreeModesDistinct() {
        val equalRows = MultiPovLayoutPreset.solvePortraitRows(2, MultiPovLayoutPreset.EQUAL)
        val primaryTopRows = MultiPovLayoutPreset.solvePortraitRows(2, MultiPovLayoutPreset.PRIMARY_TOP)
        val stackedRows = MultiPovLayoutPreset.solvePortraitRows(2, MultiPovLayoutPreset.PRIMARY_LEFT)

        // Equal tiles: 1 row with 2 side-by-side tiles (50/50, 0.5f height = ~18%)
        assertEquals(1, equalRows.size)
        assertEquals(2, equalRows[0].tilesInRow)
        assertEquals(0.5f, equalRows[0].heightFactor, 0.001f)

        // Large on top: 1 on top (100%), 1 below (50% centered) -> 1.5f height (~45%)
        assertEquals(2, primaryTopRows.size)
        assertEquals(1, primaryTopRows[0].tilesInRow)
        assertEquals(1f, primaryTopRows[0].heightFactor, 0.001f)
        assertEquals(2, primaryTopRows[1].tilesInRow)
        assertEquals(0.5f, primaryTopRows[1].heightFactor, 0.001f)

        // Stacked: 2 full-width rows (100% each) -> 2.0f height (~65%)
        assertEquals(2, stackedRows.size)
        assertEquals(1, stackedRows[0].tilesInRow)
        assertEquals(1f, stackedRows[0].heightFactor, 0.001f)
        assertEquals(1, stackedRows[1].tilesInRow)
        assertEquals(1f, stackedRows[1].heightFactor, 0.001f)

        // All 3 modes must be distinct
        assertNotEquals(equalRows, primaryTopRows)
        assertNotEquals(primaryTopRows, stackedRows)
        assertNotEquals(equalRows, stackedRows)
    }

    @Test
    fun solvePortraitRows_singleStreamAlwaysOneTile() {
        val equal = MultiPovLayoutPreset.solvePortraitRows(1, MultiPovLayoutPreset.EQUAL)
        val primaryTop = MultiPovLayoutPreset.solvePortraitRows(1, MultiPovLayoutPreset.PRIMARY_TOP)
        val stacked = MultiPovLayoutPreset.solvePortraitRows(1, MultiPovLayoutPreset.PRIMARY_LEFT)

        assertEquals(listOf(PortraitRow(1, 1f)), equal)
        assertEquals(listOf(PortraitRow(1, 1f)), primaryTop)
        assertEquals(listOf(PortraitRow(1, 1f)), stacked)
    }

    @Test
    fun solvePortraitRows_threeStreamsLayouts() {
        val equal = MultiPovLayoutPreset.solvePortraitRows(3, MultiPovLayoutPreset.EQUAL)
        val primaryTop = MultiPovLayoutPreset.solvePortraitRows(3, MultiPovLayoutPreset.PRIMARY_TOP)
        val stacked = MultiPovLayoutPreset.solvePortraitRows(3, MultiPovLayoutPreset.PRIMARY_LEFT)

        // 3 streams in Equal: 2x2 matrix (2 rows of 2 columns)
        assertEquals(2, equal.size)
        assertEquals(2, equal[0].tilesInRow)
        assertEquals(0.5f, equal[0].heightFactor, 0.001f)

        // 3 streams in Primary Top: 1 on top (full width), 2 below (half width)
        assertEquals(2, primaryTop.size)
        assertEquals(1, primaryTop[0].tilesInRow)
        assertEquals(1f, primaryTop[0].heightFactor, 0.001f)
        assertEquals(2, primaryTop[1].tilesInRow)
        assertEquals(0.5f, primaryTop[1].heightFactor, 0.001f)

        // 3 streams in Stacked: 3 full-width rows
        assertEquals(3, stacked.size)
        assertEquals(1, stacked[0].tilesInRow)
        assertEquals(1f, stacked[0].heightFactor, 0.001f)
    }
}
