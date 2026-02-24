package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.util.WebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import javax.net.ssl.X509TrustManager

/**
 * WebSocket client for Kick live chat using the Pusher protocol.
 *
 * Subscribes to the `chatrooms.{chatroomId}.v2` channel and delivers raw
 * JSON message-event payloads to [Listener.onChatMessage].
 */
class KickChatWebSocket(
    private val chatroomId: String,
    private val trustManager: X509TrustManager?,
    private val listener: Listener,
) {
    private var webSocket: WebSocket? = null

    fun connect(coroutineScope: CoroutineScope): Job {
        webSocket = WebSocket(
            url = "$PUSHER_BASE_URL$PUSHER_APP_KEY$PUSHER_QUERY",
            trustManager = trustManager,
            listener = WebSocketListener(),
        )
        return coroutineScope.launch(Dispatchers.IO) {
            webSocket?.start()
        }
    }

    suspend fun disconnect(job: Job?) = withContext(Dispatchers.IO) {
        job?.cancel()
        webSocket?.disconnect()
    }

    interface Listener {
        suspend fun onConnect() {}
        suspend fun onChatMessage(messageData: String) {}
        suspend fun onDisconnect(message: String, fullMsg: String?) {}
    }

    private inner class WebSocketListener : WebSocket.Listener {
        override suspend fun onConnect(webSocket: WebSocket) {
            webSocket.write(
                """{"event":"pusher:subscribe","data":{"auth":"","channel":"chatrooms.$chatroomId.v2"}}"""
            )
            listener.onConnect()
        }

        override suspend fun onMessage(webSocket: WebSocket, message: String) {
            try {
                val root = json.parseToJsonElement(message) as? JsonObject ?: return
                val event = root["event"]?.jsonPrimitive?.content ?: return
                when (event) {
                    "pusher:ping" -> webSocket.write("""{"event":"pusher:pong","data":{}}""")
                    EVENT_CHAT_MESSAGE -> {
                        val data = root["data"]?.jsonPrimitive?.content ?: return
                        listener.onChatMessage(data)
                    }
                }
            } catch (_: Exception) {
            }
        }

        override suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String?) {
            listener.onDisconnect(message, fullMsg)
        }
    }

    companion object {
        /** Kick's Pusher application key (embedded in Kick's web client). */
        private const val PUSHER_APP_KEY = "eb1d5f283081a78b932c"
        private const val PUSHER_BASE_URL = "wss://ws-us2.pusher.com/app/"
        private const val PUSHER_QUERY = "?protocol=7&client=android&version=8.0.0&flash=false"

        /** Pusher event name for a new chat message. */
        const val EVENT_CHAT_MESSAGE = "App\\Events\\ChatMessageEvent"

        private val json = Json { ignoreUnknownKeys = true }
    }
}
