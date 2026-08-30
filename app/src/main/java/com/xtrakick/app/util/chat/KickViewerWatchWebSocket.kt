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
    private val channelId: String?,
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
    private var parentScope: CoroutineScope? = null
    private var resolvedLivestreamId: String? = null
    private var resolvedChannelId: String? = null

    fun start(scope: CoroutineScope): Job {
        parentScope = scope
        val job = scope.launch(Dispatchers.IO) {
            val resolvedLivestream = if (!channelLogin.isNullOrBlank()) {
                runCatching {
                    kickRepository.getChannelLivestream(channelLogin, forceRefresh = false)
                }.getOrNull()
            } else null

            val resolvedChannel = if (!channelLogin.isNullOrBlank() && (channelId.isNullOrBlank() || resolvedLivestream == null)) {
                runCatching {
                    kickRepository.getChannel(channelLogin, prefetchBadgeCatalog = false, forceRefresh = false)
                }.getOrNull()
            } else null

            val activeLivestreamId = resolvedLivestream?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: resolvedChannel?.livestream?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: livestreamId?.takeIf { it.isNotBlank() && it != channelId }
                ?: livestreamId?.takeIf { it.isNotBlank() }

            val activeChannelId = resolvedChannel?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: channelId?.toLongOrNull()?.toString()
                ?: channelId?.takeIf { it.isNotBlank() }

            if (activeLivestreamId.isNullOrBlank()) {
                Log.w(tag, "Kick numeric livestream id could not be resolved for channel=$channelLogin")
                return@launch
            }

            val effectiveChannelId = activeChannelId ?: channelId?.takeIf { it.isNotBlank() } ?: activeLivestreamId
            resolvedLivestreamId = activeLivestreamId
            resolvedChannelId = effectiveChannelId

            if (debugLogging) {
                Log.i(tag, "starting viewer watch presence channel=$effectiveChannelId livestream=$activeLivestreamId channelLogin=$channelLogin")
            }
            startCurrentViewersHeartbeat(activeLivestreamId)

            while (isActive) {
                if (!kickRepository.hasUsableKickWebsiteSession()) {
                    delay(30_000L)
                    continue
                }

                val token = runCatching {
                    kickRepository.getKickViewerSocketToken()
                }.onFailure {
                    if (it !is CancellationException && debugLogging) {
                        Log.w(tag, "viewer socket token fetch failed: ${it.message}")
                    }
                }.getOrNull()

                if (token.isNullOrBlank()) {
                    delay(10_000L)
                    continue
                }

                val socketUrl = "wss://websockets.kick.com/viewer/v1/connect?token=${Uri.encode(token)}"
                val socket = WebSocket(
                    url = socketUrl,
                    trustManager = trustManager,
                    listener = ViewerListener(effectiveChannelId, activeLivestreamId),
                    headers = mapOf(
                        "Origin" to "https://kick.com",
                        "User-Agent" to kickRepository.kickWebUserAgent,
                    ),
                    sendPings = false,
                )
                webSocket = socket

                try {
                    socket.start()
                } catch (e: CancellationException) {
                    throw e
                } catch (e: Throwable) {
                    if (debugLogging) {
                        Log.w(tag, "viewer socket session ended: ${e.message}")
                    }
                } finally {
                    webSocket = null
                    heartbeatJob?.cancel()
                    heartbeatJob = null
                }

                if (isActive) {
                    delay(3_000L)
                }
            }
        }
        job.invokeOnCompletion {
            currentViewersHeartbeatJob?.cancel()
            currentViewersHeartbeatJob = null
            heartbeatJob?.cancel()
            heartbeatJob = null
        }
        socketJob = job
        return job
    }

    suspend fun stop() = withContext(Dispatchers.IO) {
        currentViewersHeartbeatJob?.cancel()
        currentViewersHeartbeatJob = null
        heartbeatJob?.cancel()
        heartbeatJob = null
        socketJob?.cancel()
        socketJob = null
        val socket = webSocket
        val channel = resolvedChannelId
        webSocket = null
        if (socket != null) {
            if (!channel.isNullOrBlank()) {
                runCatching { socket.write(buildDisconnectionMessage(channel).toString()) }
            }
            socket.disconnect()
        }
    }

    private fun startCurrentViewersHeartbeat(livestreamId: String) {
        currentViewersHeartbeatJob?.cancel()
        currentViewersHeartbeatJob = parentScope?.launch(Dispatchers.IO) {
            while (isActive) {
                runCatching {
                    val result = kickRepository.pingCurrentViewers(livestreamId)
                    if (debugLogging) {
                        Log.d(tag, "current-viewers ping sent for $livestreamId result=${result?.take(80)}")
                    }
                }.onFailure {
                    if (debugLogging) {
                        Log.w(tag, "current-viewers ping failed for $livestreamId: ${it.message}")
                    }
                }
                delay(CURRENT_VIEWERS_INTERVAL_MS)
            }
        }
    }

    private suspend fun send(socket: WebSocket, payload: String) {
        writeMutex.withLock {
            runCatching { socket.write(payload) }
                .onFailure { if (debugLogging) Log.w(tag, "viewer socket write failed: ${it.message}") }
        }
    }

    private suspend fun sendWatchEvent(socket: WebSocket, channelId: String, livestreamId: String) {
        val payload = buildWatchEvent(channelId, livestreamId).toString()
        if (debugLogging) {
            Log.d(tag, "viewer socket sending watch event: channelId=$channelId livestreamId=$livestreamId")
        }
        send(socket, payload)
    }

    private suspend fun sendHandshake(socket: WebSocket, channelId: String) {
        val payload = buildChannelHandshake(channelId).toString()
        if (debugLogging) {
            Log.d(tag, "viewer socket sending channel handshake: channelId=$channelId")
        }
        send(socket, payload)
    }

    private fun startHeartbeat(socket: WebSocket, channelId: String, livestreamId: String) {
        heartbeatJob?.cancel()
        heartbeatJob = parentScope?.launch(Dispatchers.IO) {
            var watchElapsedMs = 0L
            var pingElapsedMs = 0L
            while (isActive) {
                delay(HEARTBEAT_INTERVAL_MS)
                sendHandshake(socket, channelId)
                watchElapsedMs += HEARTBEAT_INTERVAL_MS
                pingElapsedMs += HEARTBEAT_INTERVAL_MS
                if (pingElapsedMs >= PING_INTERVAL_MS) {
                    if (debugLogging) Log.d(tag, "viewer socket sending ping")
                    send(socket, PING)
                    pingElapsedMs = 0L
                }
                if (watchElapsedMs >= WATCH_EVENT_INTERVAL_MS) {
                    sendWatchEvent(socket, channelId, livestreamId)
                    watchElapsedMs = 0L
                }
            }
        }
    }

    private inner class ViewerListener(
        private val channelId: String,
        private val livestreamId: String,
    ) : WebSocket.Listener {
        override suspend fun onConnect(webSocket: WebSocket) {
            if (debugLogging) {
                Log.i(tag, "viewer socket connected channel=$channelId livestream=$livestreamId")
            }
            sendHandshake(webSocket, channelId)
            send(webSocket, PING)
            sendWatchEvent(webSocket, channelId, livestreamId)
            startHeartbeat(webSocket, channelId, livestreamId)
        }

        override suspend fun onMessage(webSocket: WebSocket, message: String) {
            if (debugLogging) {
                Log.d(tag, "viewer socket onMessage: $message")
            }
            val type = runCatching { JSONObject(message).optString("type") }.getOrNull().orEmpty()
            if (type == "ping") {
                if (debugLogging) Log.d(tag, "viewer socket sending pong")
                send(webSocket, PONG)
            }
        }

        override suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String?) {
            heartbeatJob?.cancel()
            heartbeatJob = null
            if (debugLogging) {
                Log.w(tag, "viewer socket disconnected: ${message.take(160)}")
            }
        }
    }

    companion object {
        private const val HEARTBEAT_INTERVAL_MS = 15_000L
        private const val PING_INTERVAL_MS = 30_000L
        private const val WATCH_EVENT_INTERVAL_MS = 60_000L
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
                    put("vod_id", JSONObject.NULL)
                })
            })
        }

        fun buildChannelHandshake(channelId: String): JSONObject = JSONObject().apply {
            put("type", "channel_handshake")
            put("data", JSONObject().apply {
                put("message", JSONObject().apply { put("channelId", channelId) })
            })
        }

        fun buildDisconnectionMessage(channelId: String): JSONObject = JSONObject().apply {
            put("type", "channel_disconnect")
            put("data", JSONObject().apply {
                put("message", JSONObject().apply { put("channelId", channelId) })
            })
        }
    }
}
