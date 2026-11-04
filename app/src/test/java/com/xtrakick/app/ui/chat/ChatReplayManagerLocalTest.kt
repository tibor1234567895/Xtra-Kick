package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.ChatMessage
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class ChatReplayManagerLocalTest {
    @Test
    fun pauseStopsCurrentBucketUntilPlaybackResumes() = runBlocking {
        var position = 0L
        var playing = true
        val emitted = mutableListOf<String?>()
        val scope = CoroutineScope(coroutineContext + Job())
        val replay = ChatReplayManagerLocal({ position }, { 1f }, scope,
            object : ChatReplayManager.Listener {
                override suspend fun onChatMessage(message: ChatMessage) {
                    emitted.add(message.id)
                    if (emitted.size == 1) playing = false
                }
            }, isPlaybackPlaying = { playing })
        try {
            replay.setMessages(List(20) { ChatMessage(id = it.toString(), timestamp = 1000) }, 0)
            replay.startLoad()
            delay(25)
            position = 1500
            withTimeout(2000) { while (emitted.isEmpty()) delay(10) }
            delay(80)
            assertEquals(listOf("0"), emitted)
            position = 3000
            playing = true
            withTimeout(2000) { while (emitted.size < 20) delay(10) }
            assertEquals((0..19).map(Int::toString), emitted)
        } finally {
            replay.stop()
            scope.cancel()
        }
    }
    @Test
    fun seekIncludesFirstMessageInDuplicateTimestampBucket() {
        val messages = listOf(1000L, 2000L, 2000L, 3000L).map { ChatMessage(timestamp = it) }
        assertEquals(0, ChatReplayManagerLocal.messageLowerBound(messages, 0))
        assertEquals(1, ChatReplayManagerLocal.messageLowerBound(messages, 2000))
        assertEquals(3, ChatReplayManagerLocal.messageLowerBound(messages, 2001))
        assertEquals(4, ChatReplayManagerLocal.messageLowerBound(messages, 4000))
        assertEquals(0, ChatReplayManagerLocal.messageLowerBound(emptyList(), 4000))
    }

    @Test
    fun dueMessagesPopInBulkInsteadOfStreaming() {
        val messages = listOf(1000L, 2000L, 2000L, 3000L).map { ChatMessage(timestamp = it) }
        assertEquals(0, ChatReplayManagerLocal.messageUpperBound(messages, 0))
        assertEquals(1, ChatReplayManagerLocal.messageUpperBound(messages, 1000))
        assertEquals(3, ChatReplayManagerLocal.messageUpperBound(messages, 2000))
        assertEquals(4, ChatReplayManagerLocal.messageUpperBound(messages, 3000))
        assertEquals(0, ChatReplayManagerLocal.messageUpperBound(emptyList(), 4000))
    }
}
