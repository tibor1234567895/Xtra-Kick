package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.util.chat.ChatReplayPacing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.max

class ChatReplayManagerLocal(
    private val getCurrentPosition: () -> Long?,
    private val getCurrentSpeed: () -> Float?,
    private val coroutineScope: CoroutineScope,
    private val listener: ChatReplayManager.Listener,
) {
    companion object {
        private const val LARGE_SEEK_THRESHOLD_MS = 20_000L
        private const val PRELOAD_WINDOW_MS = 300_000L
        private const val PRELOAD_MAX_AGE_MS = 90_000L
        private const val PRELOAD_MAX_MESSAGES = 200
        private const val MIN_SYNC_WAIT_MS = 16L
        private const val MAX_SYNC_WAIT_MS = 250L
    }

    private var messages: List<ChatMessage> = emptyList()
    private var startTime = 0L
    private val list = mutableListOf<ChatMessage>()
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
     * Number of queued messages sharing [timestamp], counting from the head.
     *
     * Indexed access rather than iteration on purpose: [load] appends to [list] from
     * [Dispatchers.IO] while this runs on the replay job's dispatcher, and an iterator would be
     * open to ConcurrentModificationException. Appends only ever land past the range being read.
     */
    private fun queuedInBucket(timestamp: Long): Int {
        var count = 0
        while (true) {
            val queued = list.getOrNull(count) ?: break
            if (queued.timestamp != timestamp) break
            count++
        }
        return count
    }

    fun setMessages(newMessages: List<ChatMessage>, newStartTime: Long) {
        messages = newMessages
        startTime = newStartTime
        if (started) {
            start()
        }
    }

    fun startLoad() {
        val currentPosition = getCurrentPosition() ?: 0
        isActive = true
        if (!started) {
            started = true
            if (messages.isNotEmpty()) {
                start()
            }
        }
    }

    fun start() {
        isActive = true
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

    fun stop() {
        loadJob?.cancel()
        messageJob?.cancel()
        isActive = false
    }

    private fun load(position: Long, preload: Boolean = false) {
        isLoading = true
        loadJob = coroutineScope.launch(Dispatchers.IO) {
            try {
                val preloadMessages = if (preload) {
                    messages.filter { message ->
                        message.timestamp?.let { timestamp ->
                            timestamp in max(position - PRELOAD_MAX_AGE_MS, 0L) until position
                        } == true
                    }
                        .takeLast(PRELOAD_MAX_MESSAGES)
                } else {
                    emptyList()
                }
                val queuedMessages = messages.filter { message ->
                    message.timestamp?.let { timestamp ->
                        timestamp >= position
                    } == true
                }
                messageJob?.cancel()
                list.addAll(queuedMessages)
                isLoading = false
                if (preloadMessages.isNotEmpty()) {
                    listener.onChatMessages(preloadMessages)
                }
                startJob()
            } catch (_: Exception) {
                isLoading = false
            }
        }
    }

    private fun startJob() {
        messageJob = coroutineScope.launch {
            while (isActive) {
                val message = list.firstOrNull() ?: break
                if (message.timestamp != null) {
                    var currentPosition: Long
                    val bucketStart = message.timestamp
                    // Downloaded chat inherits Kick's whole-second offsets, so every message from
                    // the same second shares one target and the bucket would otherwise go out in
                    // a single pass of this loop.
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
                    listener.onChatMessage(
                        ChatMessage(
                            id = message.id,
                            userId = message.userId,
                            userLogin = message.userLogin,
                            userName = message.userName,
                            message = message.message,
                            color = message.color,
                            emotes = message.emotes,
                            badges = message.badges,
                            isAction = message.isAction,
                            isFirst = message.isFirst,
                            bits = message.bits,
                            systemMsg = message.systemMsg,
                            msgId = message.msgId,
                            reward = message.reward,
                            reply = message.reply,
                            isReply = message.isReply,
                            replyParent = message.replyParent,
                            timestamp = message.timestamp,
                            fullMsg = message.fullMsg
                        )
                    )
                    // Counted before the head is removed below, so the just-emitted message is
                    // included - that is what [advanceStagger] expects.
                    spreadStaggerMs = ChatReplayPacing.advanceStagger(stagger, queuedInBucket(message.timestamp))
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
        if (started && messages.isNotEmpty() && lastCheckedPosition != position) {
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
        if (started && messages.isNotEmpty() && playbackSpeed != speed) {
            playbackSpeed = speed
            messageJob?.cancel()
            startJob()
        }
    }
}
