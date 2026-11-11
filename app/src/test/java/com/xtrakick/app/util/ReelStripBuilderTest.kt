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
    fun buildsFixedStripWithLeadInPadding() {
        val strip = ReelStripBuilder.buildFixedReelStrip(items(12), "item-8", leadInCount = 2)
        // 2 lead-in + 24 (2 copies) + 1 extra + 2 lead-out = 29
        assertEquals(29, strip.items.size)
        assertEquals(2, strip.restIndex)
        assertEquals(21, strip.targetIndex) // 2 + 12 + 7
        // Effective travel is unchanged: 21 - 2 = 19
        assertEquals(19, strip.targetIndex - strip.restIndex)
        // Verify lead-in items wrap correctly from the end of rewards
        assertEquals("item-11-leadin-0", strip.items[0].id)
        assertEquals("item-12-leadin-1", strip.items[1].id)
        // Rest index points to the first reward
        assertEquals("item-1", strip.items[2].id)
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
