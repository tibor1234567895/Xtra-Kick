package com.xtrakick.app.util

import com.xtrakick.app.model.kick.KickDailyRouletteItem
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class ReelStripBuilderTest {

    private fun items(count: Int): List<KickDailyRouletteItem> =
        (1..count).map { KickDailyRouletteItem(id = "item-$it", itemUrl = "https://files.kick.com/emotes/$it/fullsize") }

    @Test
    fun buildsFixedStripFromClaimRoulette() {
        val strip = ReelStripBuilder.buildFixedReelStrip(items(12), "item-8")
        assertEquals(25, strip.items.size) // two full copies + duplicated first item
        assertEquals(0, strip.restIndex)
        assertEquals(19, strip.targetIndex) // listLength + winnerIndex (item-8 = index 7)
        assertEquals("item-1-duplicate", strip.items.last().id)
    }

    @Test
    fun duplicatedFirstItemTargetsSecondCopy() {
        val strip = ReelStripBuilder.buildFixedReelStrip(items(5), "item-2")
        assertEquals(11, strip.items.size)
        assertEquals(6, strip.targetIndex) // 5 + winnerIndex (item-2 = index 1)
    }

    @Test
    fun singleItemStripTargetsSecondCopy() {
        val strip = ReelStripBuilder.buildFixedReelStrip(items(1), "item-1")
        assertEquals(3, strip.items.size)
        assertEquals(1, strip.targetIndex)
    }

    @Test
    fun emptyRouletteRejected() {
        assertThrows(IllegalArgumentException::class.java) {
            ReelStripBuilder.buildFixedReelStrip(emptyList(), "item-1")
        }
    }

    @Test
    fun unknownWinnerRejected() {
        assertThrows(IllegalArgumentException::class.java) {
            ReelStripBuilder.buildFixedReelStrip(items(5), "item-99")
        }
    }
}
