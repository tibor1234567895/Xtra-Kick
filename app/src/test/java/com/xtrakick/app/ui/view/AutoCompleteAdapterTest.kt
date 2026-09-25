package com.xtrakick.app.ui.view

import com.xtrakick.app.model.chat.Chatter
import com.xtrakick.app.model.chat.Emote
import org.junit.Assert.assertEquals
import org.junit.Test

class AutoCompleteAdapterTest {

    @Test
    fun getMatchRank_exactMatchReturnsZero() {
        assertEquals(0, AutoCompleteAdapter.getMatchRank("hi", "hi"))
        assertEquals(0, AutoCompleteAdapter.getMatchRank("HI", "hi"))
        assertEquals(0, AutoCompleteAdapter.getMatchRank("hi", "HI"))
    }

    @Test
    fun getMatchRank_prefixMatchReturnsOne() {
        assertEquals(1, AutoCompleteAdapter.getMatchRank("hi", "highfive"))
        assertEquals(1, AutoCompleteAdapter.getMatchRank("hi", "history"))
        assertEquals(1, AutoCompleteAdapter.getMatchRank("hi", "hiss"))
    }

    @Test
    fun getMatchRank_substringMatchReturnsTwo() {
        assertEquals(2, AutoCompleteAdapter.getMatchRank("hi", "this"))
        assertEquals(2, AutoCompleteAdapter.getMatchRank("hi", "whitepeepoHappy"))
    }

    @Test
    fun getMatchRank_shortQueryRejectsUnrelatedSubsequence() {
        // Query "hi" (length 2 < 3) must NOT match "TheVoices", "hospital", or long memes
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hi", "TheVoices"))
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hi", "hospital"))
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hi", "MeHavingToCleanDuringTheParty"))
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hi", "MonkaHellWatchesWidePeepoHappySmokes"))
    }

    @Test
    fun getMatchRank_longerQuerySupportsFuzzyMatch() {
        // Query length >= 3 allows subsequence match at rank 3
        assertEquals(3, AutoCompleteAdapter.getMatchRank("hsp", "hospital"))
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("xyz", "hospital"))
    }

    @Test
    fun getMatchRank_fuzzyTierCatchesSubstitutionsAndTranspositions() {
        // "heilo" is not a subsequence of "hello" (no 'i'), but edit distance is 1
        assertEquals(4, AutoCompleteAdapter.getMatchRank("heilo", "hello"))
        // "teh" -> "the" is a transposition
        assertEquals(4, AutoCompleteAdapter.getMatchRank("teh", "the"))
        assertEquals(4, AutoCompleteAdapter.getMatchRank("HEILO", "hello"))
    }

    @Test
    fun getMatchRank_fuzzyTierRespectsDistanceCap() {
        // Query length 3 allows at most 1 edit
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hxl", "hello"))
        // Length difference beyond cap is rejected without scanning
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hixyz", "hi"))
    }

    @Test
    fun getMatchRank_shortQueryNeverFuzzyMatches() {
        // 2-char queries keep the old strict behavior (prefix/contains only)
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("ho", "ha"))
        assertEquals(-1, AutoCompleteAdapter.getMatchRank("hx", "hi"))
    }

    @Test
    fun sortingOrdersExactFirstThenShortestPrefixThenSubstring() {
        val emotes = listOf(
            Emote(name = "TheVoices"),
            Emote(name = "whitepeepoHappy"),
            Emote(name = "highfive"),
            Emote(name = "hi"),
            Emote(name = "hiss"),
            Emote(name = "hospital")
        )

        val result = AutoCompleteAdapter.rankAndSort(emotes, ':', "hi").map { it.name }
        assertEquals(listOf("hi", "hiss", "highfive", "whitepeepoHappy"), result)
    }

    @Test
    fun rankAndSort_boostsRecentEmotesWithinSameRank() {
        val emotes = listOf(
            Emote(name = "hi"),
            Emote(name = "hiss"),
            Emote(name = "highfive")
        )

        val result = AutoCompleteAdapter.rankAndSort(
            emotes, ':', "h", recentNames = setOf("highfive")
        ).map { it.name }
        assertEquals(listOf("highfive", "hi", "hiss"), result)
    }

    @Test
    fun rankAndSort_recencyNeverOverridesMatchRank() {
        val emotes = listOf(
            Emote(name = "hiss"),        // prefix match (rank 1)
            Emote(name = "whitepeepoHappy") // substring match (rank 2), recent
        )

        val result = AutoCompleteAdapter.rankAndSort(
            emotes, ':', "hi", recentNames = setOf("whitepeepohappy")
        ).map { it.name }
        assertEquals(listOf("hiss", "whitepeepoHappy"), result)
    }

    @Test
    fun chatterMatchingRespectsRankAndLength() {
        val chatters = listOf(
            Chatter("johnny_bravo"),
            Chatter("john"),
            Chatter("cool_john"),
            Chatter("johnny")
        )

        val result = AutoCompleteAdapter.rankAndSort(chatters, '@', "john").map { it.name }
        assertEquals(listOf("john", "johnny", "johnny_bravo", "cool_john"), result)
    }
}
