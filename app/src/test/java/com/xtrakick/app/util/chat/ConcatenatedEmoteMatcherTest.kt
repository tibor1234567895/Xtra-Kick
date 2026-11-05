package com.xtrakick.app.util.chat

import com.xtrakick.app.model.chat.Emote
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test
import kotlin.random.Random

class ConcatenatedEmoteMatcherTest {
    @Test
    fun backtracksWhenLongestPrefixCannotCompleteTheToken() {
        val matcher = ConcatenatedEmoteMatcher(listOf(Emote(name = "abc"), Emote(name = "ab"), Emote(name = "cd")))

        assertEquals(listOf("ab", "cd"), matcher.split("abcd")?.map { it.name })
        assertNull(matcher.split("abcde"))
    }

    @Test
    fun keepsExactTokensAndFirstDuplicatePrecedence() {
        val first = Emote(name = "cat")
        val matcher = ConcatenatedEmoteMatcher(listOf(Emote(), Emote(name = " "), first, Emote(name = "cat")))

        assertNull(matcher.split("cat"))
        assertSame(first, matcher.split("catcat")?.first())
        assertNull(ConcatenatedEmoteMatcher(listOf(Emote(name = "a"), Emote(name = "aa"))).split("aa"))
    }

    @Test
    fun longRunsUseBoundedStackAndLinearResultStorage() {
        val emote = Emote(name = "a")
        val result = ConcatenatedEmoteMatcher(listOf(emote)).split("a".repeat(50_000))!!

        assertEquals(50_000, result.size)
        assertSame(emote, result.first())
        assertSame(emote, result.last())
        assertNull(ConcatenatedEmoteMatcher(listOf(emote)).split("a".repeat(50_000) + "b"))
    }

    @Test
    fun matchesOriginalLongestFirstSearchAcrossRandomInputs() {
        val random = Random(42)
        repeat(2_000) {
            val emotes = List(random.nextInt(8)) {
                Emote(name = List(random.nextInt(1, 5)) { "abc"[random.nextInt(3)] }.joinToString(""))
            }
            val token = List(random.nextInt(20)) { "abc"[random.nextInt(3)] }.joinToString("")
            val expected = referenceSplit(token, emotes)
            val actual = ConcatenatedEmoteMatcher(emotes).split(token)

            assertEquals("token=$token", expected?.size, actual?.size)
            if (expected != null && actual != null) {
                expected.zip(actual).forEach { (before, after) -> assertSame(before, after) }
            }
        }
    }

    @Test
    fun cacheDetectsMiddleReplacementAndNewArtworkWithTheSameName() {
        val emotes = mutableListOf(Emote(name = "first"), Emote(name = "middle"), Emote(name = "last"))
        val initial = ConcatenatedEmoteMatcherCache.get("middle-update", null, emotes)
        assertSame(initial, ConcatenatedEmoteMatcherCache.get("middle-update", null, emotes.toList()))

        val renamed = Emote(name = "changed")
        emotes[1] = renamed
        val updated = ConcatenatedEmoteMatcherCache.get("middle-update", null, emotes)
        assertNull(updated.getExactEmote("middle"))
        assertSame(renamed, updated.getExactEmote("changed"))

        val newArtwork = Emote(name = "changed", url1x = "https://example.invalid/new.webp")
        emotes[1] = newArtwork
        assertSame(newArtwork, ConcatenatedEmoteMatcherCache.get("middle-update", null, emotes).getExactEmote("changed"))
    }

    @Test
    fun cacheTracksPersonalEmoteVisibilityReplacementAndDuplicateOrder() {
        val personal = Emote(name = "shared")
        val channel = Emote(name = "shared")
        val visible = ConcatenatedEmoteMatcherCache.get("personal-update", listOf(personal), listOf(channel))
        assertSame(personal, visible.getExactEmote("shared"))

        val hidden = ConcatenatedEmoteMatcherCache.get("personal-update", null, listOf(channel))
        assertNotSame(visible, hidden)
        assertSame(channel, hidden.getExactEmote("shared"))

        val replacement = Emote(name = "personal")
        val updated = ConcatenatedEmoteMatcherCache.get("personal-update", listOf(replacement), listOf(channel))
        assertSame(replacement, updated.getExactEmote("personal"))

        val reordered = ConcatenatedEmoteMatcherCache.get("duplicates", null, listOf(personal, channel))
        assertSame(personal, reordered.getExactEmote("shared"))
        assertSame(channel, ConcatenatedEmoteMatcherCache.get("duplicates", null, listOf(channel, personal)).getExactEmote("shared"))
    }

    private fun referenceSplit(token: String, emotes: List<Emote>): List<Emote>? {
        if (token.length < 2) return null
        val byName = LinkedHashMap<String, Emote>()
        emotes.forEach { emote -> emote.name?.takeIf(String::isNotBlank)?.let { byName.putIfAbsent(it, emote) } }
        val names = byName.keys.sortedByDescending(String::length)
        val memo = HashMap<Int, List<Emote>?>()
        fun resolve(index: Int): List<Emote>? {
            if (index == token.length) return emptyList()
            if (memo.containsKey(index)) return memo[index]
            for (name in names) {
                if (!token.startsWith(name, index)) continue
                val suffix = resolve(index + name.length) ?: continue
                return (listOf(byName.getValue(name)) + suffix).also { memo[index] = it }
            }
            memo[index] = null
            return null
        }
        return resolve(0)?.takeIf { it.size > 1 }
    }
}
