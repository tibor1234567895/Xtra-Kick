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
