package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.Emote
import org.junit.Assert.assertEquals
import org.junit.Test

class EmoteImageLoaderTest {
    @Test
    fun `native picker emotes start with the selected quality`() {
        val emote = Emote(url1x = "1x", url2x = "2x", url4x = "4x")
        assertEquals(listOf("4x"), EmoteImageLoader.pickerUrls(emote, "4"))
        assertEquals(listOf("2x"), EmoteImageLoader.pickerUrls(emote, "3"))
    }

    @Test
    fun `7TV picker emotes try selected quality before the warmed fallback`() {
        val channel = Emote(source = Emote.CHANNEL_STV, url1x = "1x", url2x = "2x", url4x = "4x")
        val personal = Emote(source = Emote.PERSONAL_STV, url1x = "1x", url2x = "2x", url4x = "4x")
        assertEquals(listOf("4x", "1x"), EmoteImageLoader.pickerUrls(channel, "4"))
        assertEquals(listOf("4x", "2x"), EmoteImageLoader.pickerUrls(personal, "4"))
        assertEquals(listOf("2x", "1x"), EmoteImageLoader.pickerUrls(personal, "2"))
        assertEquals(listOf("1x"), EmoteImageLoader.pickerUrls(personal, "1"))
    }
}
