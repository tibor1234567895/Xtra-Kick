package com.github.andreyasadchy.xtra.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickBadgeUrlSelectionUtilsTest {

    @Test
    fun `channel specific badges prefer catalog over generic message icon`() {
        val selection = selectKickBadgeUrl(
            isChannelSpecific = true,
            directImageUrl = "https://example.com/generic-gifter.png",
            catalogImageUrl = "https://example.com/gifter-44.png",
            inlineImageUrl = null
        )

        assertEquals("https://example.com/gifter-44.png", selection.imageUrl)
        assertEquals(KickBadgeUrlSourcePreference.CATALOG_CACHE, selection.source)
    }

    @Test
    fun `non channel specific badges still prefer direct message icon`() {
        val selection = selectKickBadgeUrl(
            isChannelSpecific = false,
            directImageUrl = "https://example.com/mod-live.png",
            catalogImageUrl = "https://example.com/mod-catalog.png",
            inlineImageUrl = null
        )

        assertEquals("https://example.com/mod-live.png", selection.imageUrl)
        assertEquals(KickBadgeUrlSourcePreference.MESSAGE_DIRECT, selection.source)
    }

    @Test
    fun `returns inline fallback when no message or catalog badge exists`() {
        val selection = selectKickBadgeUrl(
            isChannelSpecific = true,
            directImageUrl = null,
            catalogImageUrl = null,
            inlineImageUrl = "data:image/svg+xml;base64,abc"
        )

        assertEquals("data:image/svg+xml;base64,abc", selection.imageUrl)
        assertEquals(KickBadgeUrlSourcePreference.INLINE_FALLBACK, selection.source)
    }

    @Test
    fun `returns empty selection when no badge art is available`() {
        val selection = selectKickBadgeUrl(
            isChannelSpecific = true,
            directImageUrl = null,
            catalogImageUrl = null,
            inlineImageUrl = null
        )

        assertNull(selection.imageUrl)
        assertNull(selection.source)
    }
}
