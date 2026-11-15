package com.xtrakick.app.util.chat

import com.xtrakick.app.util.WebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.net.ssl.X509TrustManager
import kotlin.random.Random

class ChatReadWebSocket(
    private val channelLogin: String,
    private val trustManager: X509TrustManager?,
    private val listener: Listener,
) {
    private var webSocket: WebSocket? = null
    private var connectionScope: CoroutineScope? = null
    private var pingTimer: Job? = null
    private var pongTimer: Job? = null

    fun connect(coroutineScope: CoroutineScope): Job {
        webSocket = WebSocket("wss://chat.kick.com", trustManager, WebSocketListener())
        return coroutineScope.launch(Dispatchers.IO) {
            connectionScope = this
            try {
                webSocket?.start()
            } finally {
                pingTimer?.cancel()
                pongTimer?.cancel()
                connectionScope = null
            }
        }
    }

    suspend fun disconnect(job: Job?) = withContext(Dispatchers.IO) {
        pingTimer?.cancel()
        pongTimer?.cancel()
        job?.cancel()
        webSocket?.disconnect()
    }

    private fun startPingTimer() {
        pingTimer?.cancel()
        pingTimer = connectionScope?.launch {
            delay(270_000L)
            webSocket?.write("PING")
            startPongTimer()
        }
    }

    private fun startPongTimer() {
        pongTimer?.cancel()
        pongTimer = connectionScope?.launch {
            delay(10_000L)
            webSocket?.disconnect()
        }
    }

    interface Listener {
        suspend fun onConnect() {}
        suspend fun onChatMessage(message: String, userNotice: Boolean) {}
        suspend fun onClearMessage(message: String) {}
        suspend fun onClearChat(message: String) {}
        suspend fun onNotice(message: String) {}
        suspend fun onRoomState(message: String) {}
        suspend fun onUserState(message: String) {}
        suspend fun onDisconnect(message: String, fullMsg: String?) {}
    }

    private inner class WebSocketListener : WebSocket.Listener {
        override suspend fun onConnect(webSocket: WebSocket) {
            webSocket.write("CAP REQ :kick.com/tags kick.com/commands")
            webSocket.write("NICK justinfan${Random.nextInt(1000, 10000)}")
            webSocket.write("JOIN #$channelLogin")
            listener.onConnect()
            pingTimer?.cancel()
            pongTimer?.cancel()
            startPingTimer()
        }

        override suspend fun onMessage(webSocket: WebSocket, message: String) {
            message.removeSuffix("\r\n").split("\r\n").forEach {
                it.run {
                    when {
                        contains("PRIVMSG") -> listener.onChatMessage(this, false)
                        contains("USERNOTICE") -> listener.onChatMessage(this, true)
                        contains("CLEARMSG") -> listener.onClearMessage(this)
                        contains("CLEARCHAT") -> listener.onClearChat(this)
                        contains("NOTICE") -> listener.onNotice(this)
                        contains("ROOMSTATE") -> listener.onRoomState(this)
                        contains("USERSTATE") -> listener.onUserState(this)
                        startsWith("PING") -> {
                            webSocket.write("PONG")
                        }
                        startsWith("PONG") -> {
                            pingTimer?.cancel()
                            pongTimer?.cancel()
                            startPingTimer()
                        }
                        startsWith("RECONNECT") -> {
                            pingTimer?.cancel()
                            pongTimer?.cancel()
                            webSocket.disconnect()
                        }
                    }
                }
            }
        }

        override suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String?) {
            pingTimer?.cancel()
            pongTimer?.cancel()
            listener.onDisconnect(message, fullMsg)
        }
    }
}