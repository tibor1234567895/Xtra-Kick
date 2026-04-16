package com.github.andreyasadchy.xtra.util.chat

import android.util.Log
import com.github.andreyasadchy.xtra.util.WebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.net.ssl.X509TrustManager

class KickPusherChatWebSocket(
    private val chatroomId: String,
    private val channelId: String?,
    private val publicChannelNames: List<String> = emptyList(),
    private val privateChannelNames: List<String> = emptyList(),
    private val authorizePrivateChannel: (suspend (channelName: String, socketId: String) -> String?)? = null,
    private val trustManager: X509TrustManager?,
    private val listener: Listener,
    private val debugLogging: Boolean = false,
) {
    private val tag = "KickRealtimeChat"
    private val appKey = "32cbd69e4b950bf97679"
    private val host = "ws-us2.pusher.com"
    private val channelNames = buildList {
        add("chatroom_$chatroomId")
        add("chatrooms.$chatroomId")
        add("chatrooms.$chatroomId.v2")
        channelId?.takeIf { it.isNotBlank() }?.let {
            add("channel_$it")
            add("channel.$it")
            add("predictions-channel-$it")
        }
        addAll(publicChannelNames)
    }
    private var webSocket: WebSocket? = null
    private var hasEmittedConnect = false

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
            Log.d(tag, "connect host=$host channels=$channelNames")
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

    private suspend fun subscribe(socketId: String?) = withContext(Dispatchers.IO) {
        channelNames.forEach { channelName ->
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
            Log.i(tag, "subscribe channel=$channelName")
            webSocket?.write(payload.toString())
        }
        privateChannelNames.forEach { channelName ->
            val auth = socketId?.let { authorizePrivateChannel?.invoke(channelName, it) }
            if (auth.isNullOrBlank()) {
                Log.w(tag, "private subscribe skipped channel=$channelName hasSocketId=${!socketId.isNullOrBlank()}")
                return@forEach
            }
            val payload = JSONObject().apply {
                put("event", "pusher:subscribe")
                put(
                    "data",
                    JSONObject().apply {
                        put("auth", auth)
                        put("channel", channelName)
                    }
                )
            }
            Log.i(tag, "subscribe private channel=$channelName")
            webSocket?.write(payload.toString())
        }
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
                val channel = root.optString("channel")
                val rawData = root.opt("data")
                val payload = when (rawData) {
                    is JSONObject -> rawData.toString()
                    is String -> rawData
                    else -> null
                }
                Log.i(
                    tag,
                    "pusher_message event=${event.ifBlank { "<blank>" }} channel=${channel.ifBlank { "<none>" }} payload=${payload?.take(300) ?: "<none>"}",
                )
                when (event) {
                    "pusher:connection_established" -> {
                        val dataObj = parseJsonOrNull(root.opt("data"))
                        subscribe(dataObj?.optString("socket_id"))
                    }
                    "pusher_internal:subscription_succeeded" -> {
                        Log.i(tag, "subscription_succeeded channel=${root.optString("channel")}")
                        if (!hasEmittedConnect) {
                            hasEmittedConnect = true
                            listener.onConnect()
                        }
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
                        if (!event.startsWith("pusher:") && !event.startsWith("pusher_internal:")) {
                            payload?.takeIf { it.isNotBlank() }?.let {
                                Log.i(tag, "chat_event event=$event channel=${root.optString("channel")}")
                                listener.onChatEvent(event, it)
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
            hasEmittedConnect = false
            listener.onDisconnect(message, fullMsg)
        }
    }
}
