package com.github.andreyasadchy.xtra.ui.chat

import com.github.andreyasadchy.xtra.model.chat.ChatMessage
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
        private const val PRELOAD_WINDOW_MS = 180_000L
        private const val PRELOAD_MAX_MESSAGES = 200
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

    fun setMessages(newMessages: List<ChatMessage>, newStartTime: Long) {
        messages = newMessages
        startTime = newStartTime
        if (started) {
            start()
        }
    }

    fun startLoad() {
        if (!started) {
            started = true
            if (messages.isNotEmpty()) {
                start()
            }
        }
    }

    fun start() {
        val currentPosition = getCurrentPosition() ?: 0
        lastCheckedPosition = currentPosition
        playbackSpeed = getCurrentSpeed()
        list.clear()
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
                            timestamp in max(position - PRELOAD_WINDOW_MS, 0L) until position
                        } == true
                    }.takeLast(PRELOAD_MAX_MESSAGES)
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
            } catch (e: Exception) {

            }
        }
    }

    private fun startJob() {
        messageJob = coroutineScope.launch {
            while (isActive) {
                val message = list.firstOrNull() ?: break
                if (message.timestamp != null) {
                    var currentPosition: Long
                    val messageOffset = message.timestamp
                    while (
                        (getCurrentPosition() ?: 0).let { position ->
                            lastCheckedPosition = position
                            currentPosition = position + startTime
                            currentPosition < messageOffset
                        }
                    ) {
                        delay(max((messageOffset - currentPosition).div(playbackSpeed ?: 1f).toLong(), 0))
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
                            fullMsg = message.fullMsg
                        )
                    )
                } else if (!isActive) break
                list.remove(message)
            }
        }
    }

    fun updatePosition(position: Long) {
        if (started && messages.isNotEmpty() && lastCheckedPosition != position) {
            if (position - lastCheckedPosition !in 0..LARGE_SEEK_THRESHOLD_MS) {
                loadJob?.cancel()
                messageJob?.cancel()
                list.clear()
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
