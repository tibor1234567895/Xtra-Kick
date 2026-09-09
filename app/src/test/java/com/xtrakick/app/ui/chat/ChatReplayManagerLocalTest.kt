package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.ChatMessage
import org.junit.Assert.assertEquals
import org.junit.Test

class ChatReplayManagerLocalTest {
    @Test
    fun seekIncludesFirstMessageInDuplicateTimestampBucket() {
        val messages = listOf(1000L, 2000L, 2000L, 3000L).map { ChatMessage(timestamp = it) }
        assertEquals(0, ChatReplayManagerLocal.messageLowerBound(messages, 0))
        assertEquals(1, ChatReplayManagerLocal.messageLowerBound(messages, 2000))
        assertEquals(3, ChatReplayManagerLocal.messageLowerBound(messages, 2001))
        assertEquals(4, ChatReplayManagerLocal.messageLowerBound(messages, 4000))
        assertEquals(0, ChatReplayManagerLocal.messageLowerBound(emptyList(), 4000))
    }
}
