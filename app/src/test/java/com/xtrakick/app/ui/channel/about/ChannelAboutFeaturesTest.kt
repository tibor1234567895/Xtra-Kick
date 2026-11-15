package com.xtrakick.app.ui.channel.about

import com.xtrakick.app.model.kick.KickChannelLink
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.model.kick.KickUser
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ChannelAboutFeaturesTest {
    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun clubHandlesAndExistingLinksProduceWebUrls() {
        assertEquals("https://club.com/westcol", ChannelAboutViewModel.normalizeSocialUrl("Club", "@westcol"))
        assertEquals("https://club.com/westcol", ChannelAboutViewModel.normalizeSocialUrl("Club", "club.com/westcol"))
        assertEquals("https://club.com/westcol", ChannelAboutViewModel.normalizeSocialUrl("Club", "https://club.com/westcol"))
        assertNull(ChannelAboutViewModel.normalizeSocialUrl("Club", "javascript:alert(1)"))
        assertNull(ChannelAboutViewModel.normalizeSocialUrl("Club", "file:///private/data"))
        assertNull(ChannelAboutViewModel.normalizeSocialUrl("Club", "intent://example.com"))
    }

    @Test
    fun channelUserAcceptsClubAndAccountCreationDate() {
        val user = json.decodeFromString<KickUser>("""{"username":"westcol","club":"westcol","created_at":"2023-05-30T03:50:35.000000Z"}""")
        assertEquals("westcol", user.club)
        assertEquals("2023-05-30T03:50:35.000000Z", user.createdAt)
        assertNull(json.decodeFromString<KickUser>("{}").club)
        val channel = json.decodeFromString<KickChannelResponse>("""{"chatroom":{"id":1,"created_at":"2023-01-27T01:24:44.000000Z"},"user":{"username":"westcol"}}""")
        assertEquals("2023-01-27T01:24:44.000000Z", channel.chatroom?.createdAt)
        assertNull(channel.user?.createdAt)
    }

    @Test
    fun panelResponsePreservesOrderImagesAndOptionalFields() {
        val panels = json.decodeFromString<List<KickChannelLink>>("""[
            {"id":2,"title":"Merch","link":"https://example.com/merch","image":{"url":"https://example.com/image.webp"},"order":1},
            {"id":1,"description":"About the channel","order":0}
        ]""")
        assertEquals("About the channel", panels.sortedBy { it.order }.first().description)
        assertEquals("https://example.com/image.webp", panels.first().image?.imageUrl)
        assertNull(panels.last().image)
        assertNull(panels.last().link)
    }
}
