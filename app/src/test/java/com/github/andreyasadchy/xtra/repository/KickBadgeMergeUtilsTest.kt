package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickMessageBadge
import org.junit.Assert.assertEquals
import org.junit.Test

class KickBadgeMergeUtilsTest {

    @Test
    fun `merge keeps richer gifted badge over generic badge of same type`() {
        val merged = mergeKickMessageBadges(
            existingBadges = listOf(KickMessageBadge(type = "sub_gifter", text = "Sub Gifter")),
            syntheticBadges = listOf(KickMessageBadge(type = "sub_gifter", text = "Sub Gifter", count = 44)),
            resolveType = { it.type },
            normalizeType = { it }
        )

        assertEquals(1, merged.size)
        assertEquals(44, merged.first().count)
    }

    @Test
    fun `merge keeps richer founder badge over generic founder badge`() {
        val merged = mergeKickMessageBadges(
            existingBadges = listOf(KickMessageBadge(type = "founder", text = "Founder")),
            syntheticBadges = listOf(KickMessageBadge(type = "founder", text = "Founder", count = 12)),
            resolveType = { it.type },
            normalizeType = { it }
        )

        assertEquals(1, merged.size)
        assertEquals(12, merged.first().count)
    }
}
