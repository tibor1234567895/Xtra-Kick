package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.Emote
import org.junit.Assert.assertEquals
import org.junit.Test

class KickOutgoingEmotesTest {
    private val nativeEmotes = listOf(
        Emote(name = "collectiblesdanse", kickId = "101"),
        Emote(name = "Kappa", kickId = "102"),
        Emote(name = "channelHype", kickId = "103"),
    )

    @Test
    fun `collectible names become Kick inline tokens`() {
        assertEquals(
            "hello [emote:101:collectiblesdanse] ",
            encodeKickChatMessage("hello collectiblesdanse ", nativeEmotes),
        )
    }

    @Test
    fun `emotes only message encodes normal channel and collectible emotes`() {
        assertEquals(
            "[emote:102:Kappa] [emote:103:channelHype] [emote:101:collectiblesdanse] [emote:102:Kappa]",
            encodeKickChatMessage("Kappa channelHype collectiblesdanse Kappa", nativeEmotes),
        )
    }

    @Test
    fun `colon syntax matches official app including adjacent emotes and punctuation`() {
        assertEquals(
            "wow [emote:102:Kappa][emote:103:channelHype]! :unknown:",
            encodeKickChatMessage("wow :Kappa::channelHype:! :unknown:", nativeEmotes),
        )
    }

    @Test
    fun `existing inline tokens are preserved without double encoding`() {
        val content = "[emote:102:Kappa] [emote:999:Kappa] [emote:101:collectiblesdanse]"
        assertEquals(content, encodeKickChatMessage(content, nativeEmotes))
        val encoded = encodeKickChatMessage("Kappa collectiblesdanse", nativeEmotes)
        assertEquals(encoded, encodeKickChatMessage(encoded, nativeEmotes))
    }

    @Test
    fun `bare names only match whole whitespace delimited words`() {
        val content = "KappaExtra ExtraKappa Kappa! @Kappa https://example.com/Kappa name@Kappa.com"
        assertEquals(content, encodeKickChatMessage(content, nativeEmotes))
    }

    @Test
    fun `whitespace and unicode text are preserved`() {
        assertEquals(
            "😀\t[emote:102:Kappa]\n[emote:101:collectiblesdanse]  text",
            encodeKickChatMessage("😀\tKappa\ncollectiblesdanse  text", nativeEmotes),
        )
    }

    @Test
    fun `third party emotes stay text even when a native emote has the same name`() {
        val emotes = listOf(
            Emote(name = "Kappa", source = Emote.CHANNEL_STV),
            Emote(name = "SevenTV", source = Emote.GLOBAL_STV),
        ) + nativeEmotes
        assertEquals(
            "[emote:102:Kappa] SevenTV :SevenTV:",
            encodeKickChatMessage("Kappa SevenTV :SevenTV:", emotes),
        )
    }

    @Test
    fun `missing or invalid native ids and unknown names remain text`() {
        val emotes = listOf(
            Emote(name = "missing"),
            Emote(name = "zero", kickId = "0"),
            Emote(name = "negative", kickId = "-1"),
            Emote(name = "invalid", kickId = "abc"),
            Emote(name = "overflow", kickId = "999999999999999999999"),
            Emote(name = "SevenTV", source = Emote.CHANNEL_STV, kickId = "123"),
        )
        val content = "missing zero negative invalid overflow SevenTV unknown :unknown:"
        assertEquals(content, encodeKickChatMessage(content, emotes + nativeEmotes))
        assertEquals(content, encodeKickChatMessage(content, emptyList()))
    }

    @Test
    fun `names are case sensitive and support hyphens underscores and digits`() {
        val emotes = nativeEmotes + Emote(name = "emote_2-wave", kickId = "104")
        assertEquals(
            "kappa [emote:102:Kappa] [emote:104:emote_2-wave] [emote:104:emote_2-wave]",
            encodeKickChatMessage("kappa Kappa emote_2-wave :emote_2-wave:", emotes),
        )
    }
}
