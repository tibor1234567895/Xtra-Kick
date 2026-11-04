package com.xtrakick.app.util.chat

import android.util.Log
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.WebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.util.concurrent.atomic.AtomicInteger
import javax.net.ssl.X509TrustManager

class KickCentrifugoChatWebSocket(
    private val chatroomId: String,
    private val channelId: String?,
    private val publicChannelNames: List<String> = emptyList(),
    private val privateChannelNames: List<String> = emptyList(),
    private val fetchConnectionUrl: suspend () -> String?,
    private val fetchAuthToken: suspend () -> String?,
    private val fetchChannelToken: suspend (String) -> String? = { null },
    private val trustManager: X509TrustManager?,
    private val listener: Listener,
    private val debugLogging: Boolean = false,
) {
    companion object {
        const val DEFAULT_WS_URL = "wss://realtime.us-east-1.platform.kick.com/connection/websocket"

        fun buildChannelNames(
            chatroomId: String,
            channelId: String?,
            publicChannelNames: List<String> = emptyList(),
            privateChannelNames: List<String> = emptyList(),
        ): List<String> = buildList {
            add("chatrooms.$chatroomId.v2")
            add("chatroom_$chatroomId")
            channelId?.takeIf { it.isNotBlank() }?.let {
                add("channel.$it")
                add("channel_$it")
            }
            addAll(publicChannelNames)
            addAll(privateChannelNames)
        }

        fun buildPrivateChannelNames(
            accountId: String?,
            livestreamId: String?,
        ): List<String> = buildList {
            accountId?.takeIf { it.isNotBlank() }?.let {
                add("private-channelpoints-$it")
                add("private-userfeed.$it")
                add("private-$it")
            }
            livestreamId?.takeIf { it.isNotBlank() }?.let {
                add("private-livestream.$it")
            }
        }
    }

    interface Listener {
        suspend fun onConnect() {}
        suspend fun onChatEvent(eventName: String, channelName: String?, messageJson: String) {}
        suspend fun onDisconnect(message: String, fullMsg: String?) {}
    }

    private val tag = "KickCentrifugoChat"
    private var webSocket: WebSocket? = null
    private var hasEmittedConnect = false
    private val commandId = AtomicInteger(1)
    private val channelNames = buildChannelNames(chatroomId, channelId, publicChannelNames, privateChannelNames)

    fun connect(coroutineScope: CoroutineScope): Job {
        return coroutineScope.launch(Dispatchers.IO) {
            val resolvedUrl = runCatching { fetchConnectionUrl() }.getOrNull()?.takeIf { it.isNotBlank() } ?: DEFAULT_WS_URL
            if (debugLogging) {
                Log.d(tag, "connect url=$resolvedUrl channels=$channelNames")
            }
            webSocket = WebSocket(resolvedUrl, trustManager, WebSocketListener())
            webSocket?.start()
        }
    }

    suspend fun disconnect(job: Job?) = withContext(Dispatchers.IO) {
        job?.cancel()
        webSocket?.disconnect()
    }

    private suspend fun subscribeAll() = withContext(Dispatchers.IO) {
        channelNames.forEach { channelName ->
            val payload = JSONObject().apply {
                put("id", commandId.getAndIncrement())
                put(
                    "subscribe",
                    JSONObject().apply {
                        put("channel", channelName)
                        // Official app mints a per-subscription token; best-effort —
                        // subscribe without one if minting fails (as before).
                        val channelToken = runCatching { fetchChannelToken(channelName) }.getOrNull()
                        if (!channelToken.isNullOrBlank()) {
                            put("token", channelToken)
                        }
                    }
                )
            }
            if (debugLogging) {
                Log.i(tag, "subscribe channel=$channelName token=${payload.optJSONObject("subscribe")?.has("token") == true}")
            }
            webSocket?.write(payload.toString())
        }
    }

    private inner class WebSocketListener : WebSocket.Listener {
        override suspend fun onConnect(webSocket: WebSocket) {
            var token = runCatching { fetchAuthToken() }.getOrNull()
            if (token.isNullOrBlank()) {
                delay(500L)
                token = runCatching { fetchAuthToken() }.getOrNull()
            }
            if (token.isNullOrBlank()) {
                DiagnosticLogger.wIfForeground(tag, "failed to obtain fresh centrifugo token on connect")
                webSocket.disconnect()
                return
            }
            val connectCmd = JSONObject().apply {
                put("id", commandId.getAndIncrement())
                put(
                    "connect",
                    JSONObject().apply {
                        put("token", token)
                    }
                )
            }
            if (debugLogging) {
                Log.d(tag, "sending connect command")
            }
            webSocket.write(connectCmd.toString())
        }

        override suspend fun onMessage(webSocket: WebSocket, message: String) {
            if (message == "{}") {
                webSocket.write("{}")
                return
            }
            runCatching {
                val root = JSONObject(message)
                if (root.has("connect")) {
                    if (debugLogging) {
                        Log.i(tag, "centrifugo connection established")
                    }
                    subscribeAll()
                    return
                }
                if (root.has("subscribe")) {
                    if (debugLogging) {
                        Log.i(tag, "centrifugo subscription confirmed")
                    }
                    if (!hasEmittedConnect) {
                        hasEmittedConnect = true
                        listener.onConnect()
                    }
                    return
                }
                val push = root.optJSONObject("push")
                if (push != null) {
                    val channel = push.optString("channel")
                    val pub = push.optJSONObject("pub")
                    val pubData = pub?.optJSONObject("data")
                    if (pubData != null) {
                        val event = pubData.optString("event")
                        val rawData = pubData.opt("data")
                        val payload = when (rawData) {
                            is JSONObject -> rawData.toString()
                            is String -> rawData
                            null -> null
                            else -> rawData.toString()
                        }
                        if (event.isNotBlank() && !payload.isNullOrBlank()) {
                            if (debugLogging) {
                                Log.i(tag, "chat_event event=$event channel=$channel")
                            }
                            listener.onChatEvent(event, channel.takeIf { it.isNotBlank() }, payload)
                        }
                    }
                }
            }.onFailure {
                if (debugLogging) {
                    DiagnosticLogger.w(tag, "parse_error: ${it.message}", it)
                }
            }
        }

        override suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String?) {
            hasEmittedConnect = false
            listener.onDisconnect(message, fullMsg)
        }
    }
}
