package com.xtrakick.app.util.chat

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

    @Test
    fun buildsPrivateLivestreamAndAccountChannelsWhenIdsPresent() {
        val privateChannels = KickPusherChatWebSocket.buildPrivateChannelNames(
            accountId = "98765",
            livestreamId = "124297944"
        )

        assertEquals(
            listOf(
                "private-channelpoints-98765",
                "private-userfeed.98765",
                "private-98765",
                "private-livestream.124297944"
            ),
            privateChannels
        )
        assertTrue(privateChannels.contains("private-livestream.124297944"))
    }

    @Test
    fun omitsMissingIdsInPrivateSubscriptions() {
        val onlyLivestream = KickPusherChatWebSocket.buildPrivateChannelNames(
            accountId = null,
            livestreamId = "124297944"
        )
        assertEquals(listOf("private-livestream.124297944"), onlyLivestream)

        val onlyAccount = KickPusherChatWebSocket.buildPrivateChannelNames(
            accountId = "98765",
            livestreamId = null
        )
        assertEquals(
            listOf(
                "private-channelpoints-98765",
                "private-userfeed.98765",
                "private-98765"
            ),
            onlyAccount
        )

        val empty = KickPusherChatWebSocket.buildPrivateChannelNames(
            accountId = "",
            livestreamId = ""
        )
        assertTrue(empty.isEmpty())
    }
}
