package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.Badge
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.VideoChatMessage
import com.xtrakick.app.util.chat.ChatReplayPacing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlin.math.max

class ChatReplayManager(
    private val networkLibrary: String?,
    private val kickWebHeaders: Map<String, String>,
    private val json: Json,
    private val enableIntegrity: Boolean,
    private val videoId: String,
    private val startTime: Long,
    private val getCurrentPosition: () -> Long?,
    private val getCurrentSpeed: () -> Float?,
    private val coroutineScope: CoroutineScope,
    private val listener: Listener,
) {
    companion object {
        private const val LARGE_SEEK_THRESHOLD_MS = 20_000L
        private const val PRELOAD_WINDOW_MS = 180_000L
        private const val PRELOAD_MAX_MESSAGES = 200
        private const val MIN_SYNC_WAIT_MS = 16L
        private const val MAX_SYNC_WAIT_MS = 250L

        private fun shouldInsertFragmentSpace(builder: StringBuilder, fragmentText: String, currentIsEmote: Boolean, previousWasEmote: Boolean): Boolean {
            if (builder.isEmpty() || fragmentText.isEmpty()) return false
            val previousChar = builder.last()
            val nextChar = fragmentText.first()
            if (previousChar.isWhitespace() || nextChar.isWhitespace()) return false
            if (!(previousWasEmote || currentIsEmote)) return false
            if (previousChar in "([{" || nextChar in ".,!?;:)]}") return false
            return true
        }
    }

    private var cursor: String? = null
    private val list = mutableListOf<VideoChatMessage>()
    private var started = false
    private var isLoading = false
    private var loadJob: Job? = null
    private var messageJob: Job? = null
    private var lastCheckedPosition = 0L
    private var playbackSpeed: Float? = null
    var isActive = true

    /** Timestamp bucket currently being spread, in ms, or null when no bucket is in flight. */
    private var spreadBucketStartMs: Long? = null

    /** Running sub-second offset within [spreadBucketStartMs]. See [ChatReplayPacing]. */
    private var spreadStaggerMs = 0L

    private fun resetSpread() {
        spreadBucketStartMs = null
        spreadStaggerMs = 0L
    }

    /**
     * Number of queued messages sharing [offsetSeconds], counting from the head.
     *
     * Indexed access rather than iteration on purpose: [load] appends to [list] from
     * [Dispatchers.IO] while this runs on the replay job's dispatcher, and an iterator would be
     * open to ConcurrentModificationException. Appends only ever land past the range being read.
     */
    private fun queuedInBucket(offsetSeconds: Int): Int {
        var count = 0
        while (true) {
            val queued = list.getOrNull(count) ?: break
            if (queued.offsetSeconds != offsetSeconds) break
            count++
        }
        return count
    }

    fun start() {
        if (!started) {
            started = true
            val currentPosition = getCurrentPosition() ?: 0
            lastCheckedPosition = currentPosition
            playbackSpeed = getCurrentSpeed()
            list.clear()
            resetSpread()
            coroutineScope.launch {
                listener.clearMessages()
            }
            load(currentPosition + startTime, preload = true)
        }
    }

    fun stop() {
        loadJob?.cancel()
        messageJob?.cancel()
        isActive = false
    }

    private fun load(position: Long? = null, preload: Boolean = false) {
        isLoading = true
        loadJob = coroutineScope.launch(Dispatchers.IO) {
            // Kick VODs have no Twitch-style comment API: replay without a downloaded chat
            // file yields no messages. Downloaded-file playback uses ChatReplayManagerLocal.
            isLoading = false
        }
    }

    private fun VideoChatMessage.toChatMessage(): ChatMessage {
        return ChatMessage(
            id = id,
            userId = userId,
            userLogin = userLogin,
            userName = userName,
            message = message,
            color = color,
            emotes = emotes,
            badges = badges,
            bits = 0,
            timestamp = offsetSeconds?.times(1000L),
            fullMsg = fullMsg
        )
    }

    private fun startJob() {
        messageJob = coroutineScope.launch {
            while (isActive) {
                val message = list.firstOrNull() ?: break
                if (message.offsetSeconds != null) {
                    var currentPosition: Long
                    val bucketStart = message.offsetSeconds.times(1000L)
                    // Every message from the same second shares one target, so without a stagger
                    // the whole bucket goes out in a single pass of this loop.
                    if (bucketStart != spreadBucketStartMs) {
                        spreadBucketStartMs = bucketStart
                        spreadStaggerMs = 0L
                    }
                    val stagger = ChatReplayPacing.staggerForEmission(spreadStaggerMs)
                    val messageOffset = bucketStart + stagger
                    while (
                        (getCurrentPosition() ?: 0).let { position ->
                            lastCheckedPosition = position
                            currentPosition = position + startTime
                            currentPosition < messageOffset
                        }
                    ) {
                        delay(nextSyncDelay(messageOffset - currentPosition))
                    }
                    if (!isActive) {
                        break
                    }
                    listener.onChatMessage(message.toChatMessage())
                    // Counted before the head is removed below, so the just-emitted message is
                    // included - that is what [advanceStagger] expects.
                    spreadStaggerMs = ChatReplayPacing.advanceStagger(stagger, queuedInBucket(message.offsetSeconds))
                    if (list.size <= 25 && !cursor.isNullOrBlank() && !isLoading) {
                        load()
                    }
                } else if (!isActive) break
                list.remove(message)
            }
        }
    }

    private fun nextSyncDelay(positionDeltaMs: Long): Long {
        val speed = getCurrentSpeed()?.takeIf { it > 0f } ?: playbackSpeed?.takeIf { it > 0f } ?: 1f
        playbackSpeed = speed
        return max(positionDeltaMs.div(speed).toLong(), MIN_SYNC_WAIT_MS)
            .coerceAtMost(MAX_SYNC_WAIT_MS)
    }

    fun updatePosition(position: Long) {
        if (started && lastCheckedPosition != position) {
            if (position - lastCheckedPosition !in 0..LARGE_SEEK_THRESHOLD_MS) {
                loadJob?.cancel()
                messageJob?.cancel()
                list.clear()
                resetSpread()
                coroutineScope.launch {
                    listener.clearMessages()
                }
                load(position + startTime, preload = true)
            } else {
                messageJob?.cancel()
                startJob()
            }
            lastCheckedPosition = position
        }
    }

    fun updateSpeed(speed: Float) {
        if (started && playbackSpeed != speed) {
            playbackSpeed = speed
            messageJob?.cancel()
            startJob()
        }
    }

    interface Listener {
        suspend fun onChatMessage(message: ChatMessage) {}
        suspend fun onChatMessages(messages: List<ChatMessage>) {}
        suspend fun clearMessages() {}
        suspend fun getIntegrityToken() {}
    }
}
