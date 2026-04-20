package com.github.andreyasadchy.xtra.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class KickInlineGiftSubBadgeDataTest {

    @Test
    fun `selects closest lower gifted badge tier`() {
        assertEquals(
            KickInlineGiftSubBadgeData.forQuantity(25),
            KickInlineGiftSubBadgeData.forQuantity(44)
        )
        assertEquals(
            KickInlineGiftSubBadgeData.forQuantity(1000),
            KickInlineGiftSubBadgeData.forQuantity(1500)
        )
    }

    @Test
    fun `gifted badge tiers differ across ranges`() {
        assertNotEquals(
            KickInlineGiftSubBadgeData.forQuantity(1),
            KickInlineGiftSubBadgeData.forQuantity(44)
        )
        assertNotEquals(
            KickInlineGiftSubBadgeData.forQuantity(44),
            KickInlineGiftSubBadgeData.forQuantity(5000)
        )
    }
}
