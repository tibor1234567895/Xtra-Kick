package com.github.andreyasadchy.xtra.util.chat

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KickPusherChatWebSocketTest {

    @Test
    fun buildsCanonicalPusherChannelsOnly() {
        val channels = KickPusherChatWebSocket.buildChannelNames(
            chatroomId = "123",
            channelId = "456",
            publicChannelNames = listOf("drops_category_7")
        )

        assertEquals(
            listOf(
                "chatrooms.123.v2",
                "channel.456",
                "predictions-channel-456",
                "drops_category_7"
            ),
            channels
        )
        assertFalse(channels.contains("chatrooms.123"))
        assertFalse(channels.contains("chatroom_123"))
        assertFalse(channels.contains("channel_456"))
    }

    @Test
    fun omitsChannelScopedSubscriptionsWhenChannelIdIsMissing() {
        val channels = KickPusherChatWebSocket.buildChannelNames(
            chatroomId = "123",
            channelId = null
        )

        assertEquals(listOf("chatrooms.123.v2"), channels)
        assertTrue(channels.none { it.startsWith("channel.") || it.startsWith("predictions-channel-") })
    }
}
