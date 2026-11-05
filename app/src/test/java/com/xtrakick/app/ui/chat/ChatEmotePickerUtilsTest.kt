package com.xtrakick.app.ui.chat

import android.app.Application
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.repository.KickRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
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

    @Test
    fun lookupKeepsFirstNamedEmoteInProviderOrder() {
        val user = Emote(name = "Shared", kickId = "user")
        val firstKick = Emote(name = "Kick", kickId = "first")
        val lookup = ChatEmotePickerUtils.buildEmoteLookupMap(
            userEmotes = listOf(Emote(name = null), user, Emote(name = "Shared", kickId = "duplicate")),
            kickEmoteGroups = listOf(
                group("one", "One", Emote(name = "Shared"), firstKick),
                group("two", "Two", Emote(name = null), Emote(name = "Kick", kickId = "second")),
            ),
            sevenTvEmotes = listOf(Emote(name = "Kick"), Emote(name = "7TV")),
        )

        assertEquals(listOf("Shared", "Kick", "7TV"), lookup.keys.toList())
        assertSame(user, lookup["Shared"])
        assertSame(firstKick, lookup["Kick"])
    }

    @Test
    fun blankQueryPreservesSectionOrderTitlesAndExpansion() {
        val context = RuntimeEnvironment.getApplication()
        val current = group("Channel", "Current channel", Emote(name = "Current"))
        val recent = listOf(Emote(name = "Recent"), Emote(name = "Recent"))
        val firstGlobal = Emote(name = "Shared", kickId = "first")
        val sections = ChatEmotePickerUtils.buildEmotePickerSections(
            context = context,
            resolvedRecentEmotes = recent,
            kickEmoteGroups = listOf(
                group("global", "Global", firstGlobal, Emote(name = null)),
                group("channel", "Duplicate current", Emote(name = "Excluded")),
                group("other", "Other channel", Emote(name = "Other"), Emote(name = "Other"), Emote(name = null)),
                group("old", "Collectibles", Emote(name = "Old collectible")),
                group("cOlLeCtIbLeS", "Collectible group", Emote(name = "Collectible")),
                group("emoji", "Emoji group", Emote(name = "Shared", kickId = "second"), Emote(name = "Emoji")),
                group("empty", "Empty"),
            ),
            currentKickGroup = current,
            sevenTvEmotes = listOf(Emote(name = "7TV"), Emote(name = "7TV")),
            query = " \t ",
        )

        assertEquals(
            listOf("recent", "kick-collectibles", "kick-current", "kick-other", "kick-global", "7tv"),
            sections.map { it.key },
        )
        assertEquals(
            listOf(
                context.getString(R.string.emote_section_recent),
                context.getString(R.string.emote_section_collectibles),
                "Current channel",
                "Other channel",
                context.getString(R.string.emote_section_global),
                "7TV",
            ),
            sections.map { it.title },
        )
        assertEquals(listOf(true, true, true, false, false, false), sections.map { it.expandedByDefault })
        assertEquals(recent, sections[0].emotes)
        assertEquals(listOf("Collectible"), sections[1].emotes.map { it.name })
        assertEquals(listOf("Other", null), sections[3].emotes.map { it.name })
        assertEquals(listOf(firstGlobal, Emote(name = "Emoji")), sections[4].emotes)
        assertSame(firstGlobal, sections[4].emotes.first())
        assertEquals(listOf("7TV"), sections[5].emotes.map { it.name })
    }

    @Test
    fun searchTrimsQueryMatchesIgnoringCaseAndHidesRecentAndEmptySections() {
        val current = group("channel", "Current", Emote(name = "matchCurrent"), Emote(name = "Hidden"))
        val groups = listOf(
            current,
            group("collectibles", "Collectibles", Emote(name = "MATCHcollectible")),
            group("other", "Other", Emote(name = null), Emote(name = "MatchOther"), Emote(name = "MatchOther")),
            group("hidden", "Hidden", Emote(name = "Hidden")),
            group("global", "Global", Emote(name = "MatchGlobal")),
            group("emojis", "Emojis", Emote(name = "MatchGlobal"), Emote(name = "MatchEmoji")),
        )
        val sections = ChatEmotePickerUtils.buildEmotePickerSections(
            context = RuntimeEnvironment.getApplication(),
            resolvedRecentEmotes = listOf(Emote(name = "MatchRecent")),
            kickEmoteGroups = groups,
            currentKickGroup = current,
            sevenTvEmotes = listOf(Emote(name = null), Emote(name = "Match7TV"), Emote(name = "Hidden")),
            query = " mAtCh ",
        )

        assertEquals(
            listOf("kick-collectibles", "kick-current", "kick-other", "kick-global", "7tv"),
            sections.map { it.key },
        )
        assertEquals(listOf(true, true, true, true, true), sections.map { it.expandedByDefault })
        assertEquals(
            listOf(
                listOf("MATCHcollectible"),
                listOf("matchCurrent"),
                listOf("MatchOther"),
                listOf("MatchGlobal", "MatchEmoji"),
                listOf("Match7TV"),
            ),
            sections.map { section -> section.emotes.map { it.name } },
        )
    }

    @Test
    fun currentCollectiblesGroupAppearsOnlyOnce() {
        val current = group("Collectibles", "Collectibles", Emote(name = "Collectible"))
        val sections = ChatEmotePickerUtils.buildEmotePickerSections(
            context = RuntimeEnvironment.getApplication(),
            resolvedRecentEmotes = emptyList(),
            kickEmoteGroups = listOf(current),
            currentKickGroup = current,
            sevenTvEmotes = emptyList(),
            query = "",
        )

        assertEquals(listOf("kick-current"), sections.map { it.key })
        assertEquals(current.emotes, sections.single().emotes)
    }

    @Test
    fun emptySourcesAndUnmatchedSearchProduceNoSections() {
        for (query in listOf("", "missing")) {
            val sections = ChatEmotePickerUtils.buildEmotePickerSections(
                context = RuntimeEnvironment.getApplication(),
                resolvedRecentEmotes = emptyList(),
                kickEmoteGroups = listOf(group("empty", "Empty")),
                currentKickGroup = null,
                sevenTvEmotes = emptyList(),
                query = query,
            )

            assertEquals(emptyList<EmotePickerSection>(), sections)
        }
    }

    private fun group(id: String, title: String, vararg emotes: Emote) =
        KickRepository.KickEmoteGroup(id = id, title = title, emotes = emotes.toList())
}
