package com.github.andreyasadchy.xtra.ui.chat

import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.ChatEmote
import com.github.andreyasadchy.xtra.model.chat.VideoChatMessage
import com.github.andreyasadchy.xtra.repository.KickGraphQLRepository
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
    private val kickGraphQLRepository: KickGraphQLRepository,
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

    fun start() {
        if (!started) {
            started = true
            val currentPosition = getCurrentPosition() ?: 0
            lastCheckedPosition = currentPosition
            playbackSpeed = getCurrentSpeed()
            list.clear()
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
            try {
                val response = if (position != null) {
                    kickGraphQLRepository.loadVideoMessages(networkLibrary, kickWebHeaders, videoId, offset = position.div(1000).toInt())
                } else {
                    kickGraphQLRepository.loadVideoMessages(networkLibrary, kickWebHeaders, videoId, cursor = cursor)
                }
                if (enableIntegrity) {
                    response.errors?.find { it.message == "failed integrity check" }?.let {
                        listener.getIntegrityToken()
                        isLoading = false
                        return@launch
                    }
                }
                val comments = response.data!!.video.comments
                val messages = comments.edges.mapNotNull { comment ->
                    comment.node.let { item ->
                        item.message?.let { message ->
                            val chatMessage = StringBuilder()
                            var previousWasEmote = false
                            val emotes = message.fragments?.mapNotNull { fragment ->
                                fragment.text?.let { text ->
                                    val currentIsEmote = fragment.emote?.emoteID != null
                                    if (shouldInsertFragmentSpace(chatMessage, text, currentIsEmote, previousWasEmote)) {
                                        chatMessage.append(' ')
                                    }
                                    fragment.emote?.emoteID?.let { id ->
                                        ChatEmote(
                                            id = id,
                                            begin = chatMessage.codePointCount(0, chatMessage.length),
                                            end = chatMessage.codePointCount(0, chatMessage.length) + text.lastIndex
                                        )
                                    }.also {
                                        chatMessage.append(text)
                                        previousWasEmote = currentIsEmote
                                    }
                                }
                            }
                            val badges = message.userBadges?.mapNotNull { badge ->
                                badge.setID?.let { setId ->
                                    badge.version?.let { version ->
                                        Badge(
                                            setId = setId,
                                            version = version,
                                        )
                                    }
                                }
                            }
                            VideoChatMessage(
                                id = item.id,
                                offsetSeconds = item.contentOffsetSeconds,
                                userId = item.commenter?.id,
                                userLogin = item.commenter?.login,
                                userName = item.commenter?.displayName,
                                message = chatMessage.toString(),
                                color = message.userColor,
                                emotes = emotes,
                                badges = badges,
                                fullMsg = json.encodeToString(item)
                            )
                        }
                    }
                }
                val playbackPosition = position
                val preloadMessages = if (preload && playbackPosition != null) {
                    messages.filter { message ->
                        message.offsetSeconds?.times(1000L)?.let { offsetMs ->
                            offsetMs in max(playbackPosition - PRELOAD_WINDOW_MS, 0L) until playbackPosition
                        } == true
                    }.takeLast(PRELOAD_MAX_MESSAGES)
                } else {
                    emptyList()
                }
                val queuedMessages = if (playbackPosition != null) {
                    messages.filter { message ->
                        message.offsetSeconds?.times(1000L)?.let { offsetMs ->
                            offsetMs >= playbackPosition
                        } == true
                    }
                } else {
                    messages
                }
                messageJob?.cancel()
                list.addAll(queuedMessages)
                cursor = if (comments.pageInfo?.hasNextPage != false) comments.edges.lastOrNull()?.cursor else null
                isLoading = false
                if (preloadMessages.isNotEmpty()) {
                    listener.onChatMessages(preloadMessages.map { it.toChatMessage() })
                }
                startJob()
            } catch (e: Exception) {

            }
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
                    val messageOffset = message.offsetSeconds.times(1000)
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
