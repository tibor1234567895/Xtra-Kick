package com.xtrakick.app.util.chat

import android.net.Uri
import android.util.Log
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.util.WebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import org.json.JSONObject
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
    private val rewardsRepository: KickRewardsRepository? = null,
) {
    private val tag = "KickViewerWatch"
    private val writeMutex = Mutex()
    @Volatile
    private var webSocket: WebSocket? = null
    @Volatile
    private var socketJob: Job? = null
    @Volatile
    private var heartbeatJob: Job? = null
    @Volatile
    private var currentViewersHeartbeatJob: Job? = null
    @Volatile
    private var rewardsPollJob: Job? = null
    @Volatile
    private var parentScope: CoroutineScope? = null
    private var resolvedLivestreamId: String? = null
    @Volatile
    private var resolvedChannelId: String? = null
    @Volatile
    private var stopped = false

    fun start(scope: CoroutineScope): Job {
        stopped = false
        parentScope = scope
        val job = scope.launch(Dispatchers.IO) {
            if (!kickRepository.isDailyRewardsEnabled()) {
                if (debugLogging) {
                    Log.d(tag, "Kick daily rewards & watch telemetry disabled by user setting")
                }
                return@launch
            }

            val resolvedLivestream = if (!channelLogin.isNullOrBlank()) {
                runCatching {
                    kickRepository.getChannelLivestream(channelLogin, forceRefresh = true)
                }.onFailure { if (it is CancellationException) throw it }.getOrNull()
            } else null

            val resolvedChannel = if (!channelLogin.isNullOrBlank()) {
                runCatching {
                    kickRepository.getChannel(channelLogin, prefetchBadgeCatalog = false, forceRefresh = false)
                }.onFailure { if (it is CancellationException) throw it }.getOrNull()
            } else null

            val activeLivestreamId = resolvedLivestream?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: resolvedChannel?.livestream?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: livestreamId?.takeIf { it.isNotBlank() && it != channelId }

            val activeChannelId = resolvedChannel?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: channelId?.toLongOrNull()?.toString()
                ?: channelId?.takeIf { it.isNotBlank() }

            if (activeLivestreamId?.toLongOrNull()?.let { it > 0L } != true) {
                Log.w(tag, "Kick numeric livestream id could not be resolved for channel=$channelLogin")
                return@launch
            }

            val effectiveChannelId = activeChannelId?.takeIf { it.toLongOrNull()?.let { id -> id > 0L } == true }
                ?: run {
                    Log.w(tag, "Numeric channel id unavailable for channel=$channelLogin")
                    return@launch
                }
            resolvedLivestreamId = activeLivestreamId
            resolvedChannelId = effectiveChannelId

            if (stopped || !isActive) return@launch
            if (debugLogging) {
                Log.i(tag, "starting viewer watch presence channel=$effectiveChannelId livestream=$activeLivestreamId channelLogin=$channelLogin")
            }
            startCurrentViewersHeartbeat(activeLivestreamId)
            startRewardsPolling()

            if (BuildConfig.KICK_VIEWER_CLIENT_TOKEN.isBlank()) {
                // Debug builds can run the periodic rewards work without viewer socket credentials.
                awaitCancellation()
            }
            while (isActive && !stopped) {
                if (!kickRepository.hasUsableKickWebsiteSession()) {
                    delay(30_000L)
                    continue
                }

                val token = runCatching {
                    kickRepository.getKickViewerSocketToken()
                }.onFailure {
                    if (it is CancellationException) throw it
                    if (debugLogging) {
                        Log.w(tag, "viewer socket token fetch failed: ${it.message}")
                    }
                }.getOrNull()

                if (token.isNullOrBlank()) {
                    delay(10_000L)
                    continue
                }
                if (stopped || !isActive) break

                val socketUrl = "wss://websockets.kick.com/viewer/v1/connect?token=${Uri.encode(token)}"
                val socket = WebSocket(
                    url = socketUrl,
                    trustManager = trustManager,
                    listener = ViewerListener(effectiveChannelId, activeLivestreamId),
                    headers = mapOf(
                        "Origin" to "https://kick.com",
                        "User-Agent" to kickRepository.kickWebUserAgent,
                    ),
                    sendPings = true,
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
                    if (webSocket === socket) {
                        webSocket = null
                    }
                    heartbeatJob?.cancel()
                    heartbeatJob = null
                }

                if (isActive && !stopped) {
                    delay(3_000L)
                }
            }
        }
        job.invokeOnCompletion {
            currentViewersHeartbeatJob?.cancel()
            currentViewersHeartbeatJob = null
            heartbeatJob?.cancel()
            heartbeatJob = null
            rewardsPollJob?.cancel()
            rewardsPollJob = null
        }
        socketJob = job
        return job
    }

    suspend fun stop() = withContext(Dispatchers.IO) {
        stopped = true
        rewardsPollJob?.cancel()
        rewardsPollJob = null
        currentViewersHeartbeatJob?.cancel()
        currentViewersHeartbeatJob = null
        heartbeatJob?.cancel()
        heartbeatJob = null
        val socket = webSocket
        val channel = resolvedChannelId
        val runningJob = socketJob
        webSocket = null
        socketJob = null
        try {
            if (socket != null && !channel.isNullOrBlank()) {
                // The watchdog closes the transport even if a blocking write ignores cancellation.
                val watchdog = launch(start = CoroutineStart.UNDISPATCHED) {
                    delay(DISCONNECT_GRACE_MS)
                    runningJob?.cancel()
                }
                try {
                    withTimeoutOrNull(DISCONNECT_GRACE_MS) {
                        writeMutex.withLock {
                            runCatching { socket.write(buildDisconnectionMessage(channel).toString()) }
                        }
                    }
                } finally {
                    watchdog.cancel()
                }
            }
        } finally {
            runningJob?.cancel()
        }
    }

    private fun startRewardsPolling() {
        rewardsPollJob?.cancel()
        rewardsPollJob = parentScope?.launch(Dispatchers.IO) {
            while (isActive && !stopped) {
                delay(REWARDS_POLL_INTERVAL_MS)
                if (stopped) break
                if (!kickRepository.hasUsableKickWebsiteSession()) continue
                runCatching {
                    val raw = kickRepository.executeKickWebSessionRequest("https://web.kick.com/api/v1/gamification/challenges")
                    rewardsRepository?.updateChallengesFromRaw(raw)
                    if (debugLogging) {
                        Log.d(tag, "rewards cadence poll completed: ${raw.take(80)}")
                    }
                }.onFailure {
                    if (it is CancellationException) throw it
                    if (debugLogging) {
                        Log.w(tag, "rewards cadence poll failed: ${it.message}")
                    }
                }
            }
        }
    }

    private fun startCurrentViewersHeartbeat(livestreamId: String) {
        currentViewersHeartbeatJob?.cancel()
        currentViewersHeartbeatJob = parentScope?.launch(Dispatchers.IO) {
            while (isActive && !stopped) {
                runCatching {
                    val result = kickRepository.pingCurrentViewers(livestreamId)
                    if (debugLogging) {
                        Log.d(tag, "current-viewers ping sent for $livestreamId result=${result?.take(80)}")
                    }
                }.onFailure {
                    if (it is CancellationException) throw it
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
                .onFailure {
                    if (it is CancellationException) throw it
                    if (debugLogging) Log.w(tag, "viewer socket write failed: ${it.message}")
                }
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
        if (stopped || socketJob?.isActive != true || socket !== webSocket) return
        heartbeatJob = parentScope?.launch(Dispatchers.IO) {
            var watchElapsedMs = 0L
            var pingElapsedMs = 0L
            while (isActive && !stopped && socket === webSocket) {
                delay(HEARTBEAT_INTERVAL_MS)
                if (stopped || socket !== webSocket) break
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
            if (stopped || socketJob?.isActive != true || webSocket !== this@KickViewerWatchWebSocket.webSocket) return
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
        private const val DISCONNECT_GRACE_MS = 750L
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
