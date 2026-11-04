package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.repository.KickRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class ChatEmotePickerUtilsTest {

    @Test
    fun testBuildEmoteLookupMap_mergesSourcesWithPriority() {
        val userEmote = Emote(name = "Kappa", kickId = "1")
        val kickEmote = Emote(name = "Pog", kickId = "2")
        val kickGroup = KickRepository.KickEmoteGroup(id = "global", title = "Global", emotes = listOf(kickEmote))
        val sevenTvEmote = Emote(name = "OMEGALUL", kickId = "3", source = Emote.CHANNEL_STV)

        val lookup = ChatEmotePickerUtils.buildEmoteLookupMap(
            userEmotes = listOf(userEmote),
            kickEmoteGroups = listOf(kickGroup),
            sevenTvEmotes = listOf(sevenTvEmote),
        )

        assertEquals(3, lookup.size)
        assertEquals("1", lookup["Kappa"]?.kickId)
        assertEquals("2", lookup["Pog"]?.kickId)
        assertEquals("3", lookup["OMEGALUL"]?.kickId)
    }

    @Test
    fun testResolveRecentEmotes_ordersByUsedAtAndDeduplicates() {
        val lookup = mapOf(
            "Pog" to Emote(name = "Pog", kickId = "2"),
            "Kappa" to Emote(name = "Kappa", kickId = "1"),
        )
        val recent = listOf(
            RecentEmote("Pog", usedAt = 100L),
            RecentEmote("Kappa", usedAt = 200L),
            RecentEmote("Pog", usedAt = 50L),
            RecentEmote("Unknown", usedAt = 300L),
        )

        val resolved = ChatEmotePickerUtils.resolveRecentEmotes(recent, lookup)

        assertEquals(2, resolved.size)
        assertEquals("Kappa", resolved[0].name)
        assertEquals("Pog", resolved[1].name)
    }
}
