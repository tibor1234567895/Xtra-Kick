package com.xtrakick.app.util.chat

import com.xtrakick.app.util.WebSocket
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.ByteArrayOutputStream

@RunWith(RobolectricTestRunner::class)
@Config(application = android.app.Application::class)
class KickCentrifugoChatWebSocketTest {

    @Test
    fun processesBatchedRecordsAfterRepliesAndMalformedRecords() = runBlocking {
        val events = mutableListOf<String>()
        val owner = KickCentrifugoChatWebSocket(
            chatroomId = "123", channelId = null,
            fetchConnectionUrl = { null }, fetchAuthToken = { null }, trustManager = null,
            listener = object : KickCentrifugoChatWebSocket.Listener {
                override suspend fun onConnect() { events += "connected" }
                override suspend fun onChatEvent(eventName: String, channelName: String?, messageJson: String) {
                    events += "$eventName:$messageJson"
                }
            },
        )
        val listenerClass = owner.javaClass.declaredClasses.single { it.simpleName == "WebSocketListener" }
        val constructor = listenerClass.declaredConstructors.single().apply { isAccessible = true }
        val listener = constructor.newInstance(owner) as WebSocket.Listener
        val socket = WebSocket("ws://localhost", null, listener)
        val output = ByteArrayOutputStream()
        socket.javaClass.getDeclaredField("outputStream").apply { isAccessible = true }.set(socket, output)
        socket.javaClass.getDeclaredField("socket").apply { isAccessible = true }.set(socket, java.net.Socket())

        listener.onMessage(socket, """
            {"subscribe":{}}
            broken
            {"push":{"channel":"chatrooms.123.v2","pub":{"data":{"event":"first","data":"line\nnext"}}}}
            {}
            {"push":{"channel":"chatrooms.123.v2","pub":{"data":{"event":"second","data":"last"}}}}
        """.trimIndent())

        assertEquals(listOf("connected", "first:line\nnext", "second:last"), events)
        assertEquals(8, output.size()) // One masked two-byte heartbeat frame.
    }

    @Test
    fun buildsCanonicalCentrifugoChannels() {
        val channels = KickCentrifugoChatWebSocket.buildChannelNames(
            chatroomId = "123",
            channelId = "456",
            publicChannelNames = listOf("drops_category_7")
        )

        assertEquals(
            listOf(
                "chatrooms.123.v2",
                "chatroom_123",
                "channel.456",
                "channel_456",
                "predictions-channel-456",
                "drops_category_7"
            ),
            channels
        )
    }

    @Test
    fun omitsChannelScopedSubscriptionsWhenChannelIdIsMissing() {
        val channels = KickCentrifugoChatWebSocket.buildChannelNames(
            chatroomId = "123",
            channelId = null
        )

        assertEquals(
            listOf(
                "chatrooms.123.v2",
                "chatroom_123"
            ),
            channels
        )
        assertTrue(channels.none { it.startsWith("channel.") || it.startsWith("channel_") })
    }

    @Test
    fun buildsPrivateCentrifugoChannelsWhenProvided() {
        val channels = KickCentrifugoChatWebSocket.buildChannelNames(
            chatroomId = "123",
            channelId = "456",
            publicChannelNames = listOf("drops_category_7"),
            privateChannelNames = listOf("private-channelpoints-999", "private-999")
        )

        assertEquals(
            listOf(
                "chatrooms.123.v2",
                "chatroom_123",
                "channel.456",
                "channel_456",
                "predictions-channel-456",
                "drops_category_7",
                "private-channelpoints-999",
                "private-999"
            ),
            channels
        )
    }

    @Test
    fun buildsPrivateLivestreamAndAccountChannelsWhenIdsPresent() {
        val privateChannels = KickCentrifugoChatWebSocket.buildPrivateChannelNames(
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
        val onlyLivestream = KickCentrifugoChatWebSocket.buildPrivateChannelNames(
            accountId = null,
            livestreamId = "124297944"
        )
        assertEquals(listOf("private-livestream.124297944"), onlyLivestream)

        val onlyAccount = KickCentrifugoChatWebSocket.buildPrivateChannelNames(
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

        val empty = KickCentrifugoChatWebSocket.buildPrivateChannelNames(
            accountId = "",
            livestreamId = ""
        )
        assertTrue(empty.isEmpty())
    }
}
