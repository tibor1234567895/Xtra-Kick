package com.xtrakick.app.util.chat

import android.net.Uri
import android.util.Log
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.WebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.IOException
import javax.net.ssl.X509TrustManager
import kotlin.coroutines.cancellation.CancellationException

/** Maintains Kick's viewer watch presence for an actively playing live stream. */
class KickViewerWatchWebSocket(
    private val kickRepository: KickRepository,
    private val channelId: String,
    private val livestreamId: String?,
    private val channelLogin: String?,
    private val trustManager: X509TrustManager?,
    private val debugLogging: Boolean = false,
) {
    private val tag = "KickViewerWatch"
    private val writeMutex = Mutex()
    private var webSocket: WebSocket? = null
    private var socketJob: Job? = null
    private var heartbeatJob: Job? = null
    private var currentViewersHeartbeatJob: Job? = null
    private var rewardsPollJob: Job? = null
    private var parentScope: CoroutineScope? = null
    private var resolvedLivestreamId: String? = null

    fun start(scope: CoroutineScope): Job {
        parentScope = scope
        val job = scope.launch(Dispatchers.IO) {
            val activeLivestreamId = runCatching {
                livestreamId?.takeIf { it.isNotBlank() }
                    ?: channelLogin?.takeIf { it.isNotBlank() }?.let {
                        kickRepository.getChannelLivestream(it, forceRefresh = true)?.id?.toString()
                    }
            }.getOrNull()?.takeIf { it.isNotBlank() }

            if (activeLivestreamId.isNullOrBlank()) {
                Log.w(tag, "Kick numeric livestream id could not be resolved")
                return@launch
            }

            resolvedLivestreamId = activeLivestreamId
            startCurrentViewersHeartbeat(activeLivestreamId)
            startRewardsPolling()

            if (kickRepository.hasUsableKickWebsiteSession()) {
                val socket = runCatching {
                    val token = kickRepository.getKickViewerSocketToken()
                    val socketUrl = "wss://websockets.kick.com/viewer/v1/connect?token=${Uri.encode(token)}"
                    WebSocket(
                        socketUrl,
                        trustManager,
                        ViewerListener(),
                        headers = mapOf("Origin" to "https://kick.com"),
                        sendPings = false,
                    )
                }.onFailure {
                    if (it !is CancellationException) {
                        Log.w(tag, "viewer socket failed to initialize: ${it.message}")
                    }
                }.getOrNull()

                if (socket != null) {
                    webSocket = socket
                    runCatching { socket.start() }
                } else {
                    while (isActive) {
                        delay(60_000L)
                    }
                }
            } else {
                while (isActive) {
                    delay(60_000L)
                }
            }
        }
        job.invokeOnCompletion {
            currentViewersHeartbeatJob?.cancel()
            currentViewersHeartbeatJob = null
            rewardsPollJob?.cancel()
            rewardsPollJob = null
            heartbeatJob?.cancel()
            heartbeatJob = null
        }
        socketJob = job
        return job
    }

    suspend fun stop() = withContext(Dispatchers.IO) {
        currentViewersHeartbeatJob?.cancel()
        currentViewersHeartbeatJob = null
        rewardsPollJob?.cancel()
        rewardsPollJob = null
        heartbeatJob?.cancel()
        heartbeatJob = null
        socketJob?.cancel()
        socketJob = null
        webSocket?.disconnect()
        webSocket = null
    }

    private fun startCurrentViewersHeartbeat(livestreamId: String) {
        currentViewersHeartbeatJob?.cancel()
        currentViewersHeartbeatJob = parentScope?.launch(Dispatchers.IO) {
            while (isActive) {
                runCatching {
                    kickRepository.pingCurrentViewers(livestreamId)
                }.onFailure {
                    if (debugLogging) Log.w(tag, "current-viewers ping failed: ${it.message}")
                }
                delay(CURRENT_VIEWERS_INTERVAL_MS)
            }
        }
    }

    private fun startRewardsPolling() {
        if (!kickRepository.hasUsableKickWebsiteSession()) return
        rewardsPollJob?.cancel()
        rewardsPollJob = parentScope?.launch(Dispatchers.IO) {
            while (isActive) {
                delay(REWARDS_POLL_INTERVAL_MS)
                if (!kickRepository.hasUsableKickWebsiteSession()) break
                runCatching {
                    kickRepository.executeKickWebSessionRequest("https://web.kick.com/api/v1/gamification/challenges")
                }.onFailure {
                    if (debugLogging) Log.w(tag, "rewards cadence poll failed: ${it.message}")
                }
            }
        }
    }

    private suspend fun send(socket: WebSocket, payload: String) {
        writeMutex.withLock {
            runCatching { socket.write(payload) }
                .onFailure { if (debugLogging) Log.w(tag, "viewer socket write failed: ${it.message}") }
        }
    }

    private suspend fun sendWatchEvent(socket: WebSocket) {
        val activeLivestreamId = resolvedLivestreamId ?: return
        send(socket, buildWatchEvent(channelId, activeLivestreamId).toString())
    }

    private suspend fun sendHandshake(socket: WebSocket) {
        send(socket, buildChannelHandshake(channelId).toString())
    }

    private fun startHeartbeat(socket: WebSocket) {
        heartbeatJob?.cancel()
        heartbeatJob = parentScope?.launch(Dispatchers.IO) {
            var watchElapsedMs = 0L
            var pingElapsedMs = 0L
            while (isActive) {
                delay(HEARTBEAT_INTERVAL_MS)
                sendHandshake(socket)
                watchElapsedMs += HEARTBEAT_INTERVAL_MS
                pingElapsedMs += HEARTBEAT_INTERVAL_MS
                if (pingElapsedMs >= PING_INTERVAL_MS) {
                    send(socket, PING)
                    pingElapsedMs = 0L
                }
                if (watchElapsedMs >= WATCH_EVENT_INTERVAL_MS) {
                    sendWatchEvent(socket)
                    watchElapsedMs = 0L
                }
            }
        }
    }

    private inner class ViewerListener : WebSocket.Listener {
        override suspend fun onConnect(webSocket: WebSocket) {
            if (debugLogging) Log.i(tag, "viewer socket connected channel=$channelId livestream=$resolvedLivestreamId")
            sendWatchEvent(webSocket)
            sendHandshake(webSocket)
            startHeartbeat(webSocket)
        }

        override suspend fun onMessage(webSocket: WebSocket, message: String) {
            val type = runCatching { JSONObject(message).optString("type") }.getOrNull().orEmpty()
            if (type == "ping") {
                send(webSocket, PONG)
            } else if (debugLogging && type.isNotBlank() && type != "pong") {
                Log.d(tag, "viewer socket event type=$type")
            }
        }

        override suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String?) {
            heartbeatJob?.cancel()
            heartbeatJob = null
            if (debugLogging) Log.w(tag, "viewer socket disconnected: ${message.take(160)}")
        }
    }

    companion object {
        private const val HEARTBEAT_INTERVAL_MS = 15_000L
        private const val PING_INTERVAL_MS = 30_000L
        private const val WATCH_EVENT_INTERVAL_MS = 120_000L
        const val CURRENT_VIEWERS_INTERVAL_MS = 60_000L
        const val REWARDS_POLL_INTERVAL_MS = 120_000L
        private const val PING = "{\"type\":\"ping\"}"
        private const val PONG = "{\"type\":\"pong\"}"

        fun buildWatchEvent(channelId: String, livestreamId: String): JSONObject = JSONObject().apply {
            put("type", "user_event")
            put("data", JSONObject().apply {
                put("message", JSONObject().apply {
                    put("name", "tracking.user.watch.livestream")
                    put("channel_id", channelId.toLongOrNull() ?: channelId)
                    put("livestream_id", livestreamId.toLongOrNull() ?: livestreamId)
                })
            })
        }

        fun buildChannelHandshake(channelId: String): JSONObject = JSONObject().apply {
            put("type", "channel_handshake")
            put("data", JSONObject().apply {
                put("message", JSONObject().apply { put("channelId", channelId) })
            })
        }
    }
}
