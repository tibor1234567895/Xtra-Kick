package com.xtrakick.app.util.chat

import org.junit.Assert.assertEquals
import org.junit.Test

class KickViewerWatchWebSocketTest {

    @Test
    fun buildsViewerWatchEventWithNumericIds() {
        val message = KickViewerWatchWebSocket.buildWatchEvent("114586", "124297944")
        val data = message.getJSONObject("data").getJSONObject("message")

        assertEquals("user_event", message.getString("type"))
        assertEquals("tracking.user.watch.livestream", data.getString("name"))
        assertEquals(114586, data.getInt("channel_id"))
        assertEquals(124297944, data.getInt("livestream_id"))
    }

    @Test
    fun buildsChannelHandshakeWithStringChannelId() {
        val message = KickViewerWatchWebSocket.buildChannelHandshake("114586")
        assertEquals("channel_handshake", message.getString("type"))
        assertEquals("114586", message.getJSONObject("data").getJSONObject("message").getString("channelId"))
    }
}
