package com.github.andreyasadchy.xtra.util.chat

import android.util.Log
import com.github.andreyasadchy.xtra.util.WebSocket
import com.github.andreyasadchy.xtra.util.WebSocketRuntime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.net.ssl.X509TrustManager

class KickPusherChatWebSocket(
    private val chatroomId: String,
    private val trustManager: X509TrustManager?,
    private val listener: Listener,
    private val debugLogging: Boolean = false,
) {
    private val tag = "KickRealtimeChat"
    private val appKey = "32cbd69e4b950bf97679"
    private val host = "ws-us2.pusher.com"
    private val channelName = "chatrooms.$chatroomId.v2"
    private var webSocket: WebSocket? = null

    interface Listener {
        suspend fun onConnect() {}
        suspend fun onChatEvent(eventName: String, messageJson: String) {}
        suspend fun onDisconnect(message: String, fullMsg: String?) {}
    }

    private fun buildSocketUrl(): String {
        return "wss://$host/app/$appKey?protocol=7&client=android&version=1.0&flash=false"
    }

    fun connect(coroutineScope: CoroutineScope): Job {
        val socketUrl = buildSocketUrl()
        if (debugLogging) {
            Log.d(tag, "connect host=$host channel=$channelName")
        }
        webSocket = WebSocket(socketUrl, trustManager, WebSocketListener())
        return coroutineScope.launch(Dispatchers.IO) {
            webSocket?.start()
        }
    }

    suspend fun disconnect(job: Job?) = withContext(Dispatchers.IO) {
        job?.cancel()
        webSocket?.disconnect()
    }

    private suspend fun subscribe() = withContext(Dispatchers.IO) {
        val payload = JSONObject().apply {
            put("event", "pusher:subscribe")
            put(
                "data",
                JSONObject().apply {
                    put("auth", "")
                    put("channel", channelName)
                }
            )
        }
        if (debugLogging) {
            Log.d(tag, "subscribe channel=$channelName")
        }
        webSocket?.write(payload.toString())
    }

    private fun parseJsonOrNull(raw: Any?): JSONObject? {
        return when (raw) {
            is JSONObject -> raw
            is String -> runCatching { JSONObject(raw) }.getOrNull()
            else -> null
        }
    }

    private inner class WebSocketListener : WebSocket.Listener {
        override suspend fun onConnect(webSocket: WebSocket) {
            // Wait for pusher connection established event.
        }

        override suspend fun onMessage(webSocket: WebSocket, message: String) {
            runCatching {
                val root = JSONObject(message)
                val event = root.optString("event")
                when (event) {
                    "pusher:connection_established" -> {
                        subscribe()
                    }
                    "pusher_internal:subscription_succeeded" -> {
                        if (debugLogging) {
                            Log.d(tag, "subscription_succeeded channel=${root.optString("channel")}")
                        }
                        WebSocketRuntime.onSubscriptionHealthy()
                        listener.onConnect()
                    }
                    "pusher:ping" -> {
                        webSocket.write("""{"event":"pusher:pong","data":{}}""")
                    }
                    "pusher:error" -> {
                        val dataObj = parseJsonOrNull(root.opt("data"))
                        Log.e(
                            tag,
                            "pusher_error channel=${root.optString("channel")} code=${dataObj?.opt("code")} message=${dataObj?.opt("message")} raw=${root.opt("data")}"
                        )
                    }
                    else -> {
                        if (event.startsWith("App\\Events\\")) {
                            val dataObj = parseJsonOrNull(root.opt("data"))
                            if (dataObj != null) {
                                if (debugLogging) {
                                    Log.d(tag, "chat_event event=$event channel=${root.optString("channel")}")
                                }
                                listener.onChatEvent(event, dataObj.toString())
                            }
                        } else if (debugLogging && event.isNotBlank()) {
                            Log.d(tag, "event=$event")
                        }
                    }
                }
            }.onFailure {
                if (debugLogging) {
                    Log.w(tag, "parse_error: ${it.message}")
                }
            }
        }

        override suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String?) {
            listener.onDisconnect(message, fullMsg)
        }
    }
}
