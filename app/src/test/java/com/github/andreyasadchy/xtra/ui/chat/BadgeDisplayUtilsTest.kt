package com.github.andreyasadchy.xtra.ui.chat

import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.StvBadge
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BadgeDisplayUtilsTest {

    @Test
    fun `normalize display badge id strips kick prefix and maps subscription badges`() {
        assertEquals("subscriber", normalizeDisplayBadgeId("kick:subscriber"))
        assertEquals("founder", normalizeDisplayBadgeId("kick:founder"))
        assertEquals("sub_gifter", normalizeDisplayBadgeId("kick:sub_gifter"))
        assertEquals("sub_gifter", normalizeDisplayBadgeId("kick:gift_subscriber"))
    }

    @Test
    fun `build badge display label appends versions for kick gifted and subscriber badges`() {
        assertEquals(
            "Sub Gifter 25",
            buildBadgeDisplayLabel(Badge(setId = "kick:sub_gifter", version = "25", title = "Sub Gifter"))
        )
        assertEquals(
            "Subscriber 6",
            buildBadgeDisplayLabel(Badge(setId = "kick:subscriber", version = "6", title = "Subscriber"))
        )
    }

    @Test
    fun `looks subscription related badge recognizes kick subscriber and founder badges`() {
        assertTrue(looksSubscriptionRelatedBadge(Badge(setId = "kick:subscriber", version = "5", title = "Subscriber")))
        assertTrue(looksSubscriptionRelatedBadge(Badge(setId = "kick:founder", version = "12", title = "Founder")))
        assertFalse(looksSubscriptionRelatedBadge(Badge(setId = "kick:vip", version = "1", title = "VIP")))
    }

    @Test
    fun `stv badge converts into display badge with image urls`() {
        val displayBadge = stvBadgeToDisplayBadge(
            StvBadge(
                id = "supporter",
                url1x = "https://example.com/1x.webp",
                url2x = "https://example.com/2x.webp",
                url3x = "https://example.com/3x.webp",
                url4x = "https://example.com/4x.webp",
                name = "7TV Supporter",
                format = "WEBP",
            )
        )

        assertEquals("7tv:supporter", displayBadge.setId)
        assertEquals("7TV Supporter", displayBadge.title)
        assertEquals("https://example.com/4x.webp", displayBadge.url4x)
    }
}
