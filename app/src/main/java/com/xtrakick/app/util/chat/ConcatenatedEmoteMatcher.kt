package com.xtrakick.app.util.chat

import com.xtrakick.app.model.chat.Emote

internal class ConcatenatedEmoteMatcher(emotes: List<Emote>) {
    private val emoteByName = LinkedHashMap<String, Emote>()
    private val names: List<String>

    init {
        for (emote in emotes) {
            val name = emote.name?.takeIf(String::isNotBlank) ?: continue
            emoteByName.putIfAbsent(name, emote)
        }
        names = emoteByName.keys.sortedByDescending(String::length)
    }

    fun getExactEmote(name: String): Emote? = emoteByName[name]

    fun split(token: String): List<Emote>? {
        if (token.length < 2 || names.isEmpty()) return null
        val failed = BooleanArray(token.length + 1)
        val nextCandidate = IntArray(token.length + 1)
        val matches = ArrayList<Emote>()
        var position = 0

        while (true) {
            var matched = false
            while (nextCandidate[position] < names.size) {
                val name = names[nextCandidate[position]++]
                val end = position + name.length
                if (end > token.length || failed[end] || !token.startsWith(name, position)) continue
                matches.add(emoteByName.getValue(name))
                position = end
                if (position == token.length) return matches.takeIf { it.size > 1 }
                matched = true
                break
            }
            if (matched) continue
            failed[position] = true
            if (matches.isEmpty()) return null
            position -= matches.removeAt(matches.lastIndex).name!!.length
        }
    }
}

internal object ConcatenatedEmoteMatcherCache {
    private class Entry(
        val personalEmotes: List<Emote>,
        val thirdPartyEmotes: List<Emote>,
        val matcher: ConcatenatedEmoteMatcher,
    )

    private val entries = object : LinkedHashMap<String?, Entry>(16, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String?, Entry>?): Boolean = size > 16
    }

    fun get(setId: String?, personalEmotes: List<Emote>?, thirdPartyEmotes: List<Emote>): ConcatenatedEmoteMatcher =
        synchronized(thirdPartyEmotes) {
            synchronized(entries) {
                val personal = personalEmotes.orEmpty()
                val cached = entries[setId]
                if (cached != null &&
                    cached.personalEmotes.hasSameInstances(personal) &&
                    cached.thirdPartyEmotes.hasSameInstances(thirdPartyEmotes)
                ) {
                    return cached.matcher
                }
                val personalSnapshot = personal.toList()
                val thirdPartySnapshot = thirdPartyEmotes.toList()
                val matcher = ConcatenatedEmoteMatcher(personalSnapshot + thirdPartySnapshot)
                entries[setId] = Entry(personalSnapshot, thirdPartySnapshot, matcher)
                matcher
            }
        }

    // Emote equality compares names only; artwork and provider changes require identity checks.
    private fun List<Emote>.hasSameInstances(other: List<Emote>): Boolean =
        size == other.size && indices.all { this[it] === other[it] }
}
