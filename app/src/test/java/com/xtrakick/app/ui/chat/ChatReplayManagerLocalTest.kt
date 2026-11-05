package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.GiftedSubInfo
import com.xtrakick.app.model.chat.KicksDonation
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class ChatReplayManagerLocalTest {
    @Test
    fun emittedMessagesPreserveDeletionDonationAndGiftData() = runBlocking {
        var position = 0L
        val emitted = mutableListOf<ChatMessage>()
        val scope = CoroutineScope(coroutineContext + Job())
        val donation = KicksDonation(100, giftName = "Gift")
        val giftedSub = GiftedSubInfo("Gifter", count = 5, isCommunityGift = true)
        val replay = ChatReplayManagerLocal({ position }, { 1f }, scope, object : ChatReplayManager.Listener {
            override suspend fun onChatMessage(message: ChatMessage) { emitted += message }
        })
        try {
            replay.setMessages(listOf(ChatMessage(id = "event", timestamp = 1000, isDeleted = true,
                kicksDonation = donation, giftedSubInfo = giftedSub)), 0)
            replay.startLoad()
            delay(25)
            position = 2000
            withTimeout(2000) { while (emitted.isEmpty()) delay(5) }
            assertTrue(emitted.single().isDeleted)
            assertSame(donation, emitted.single().kicksDonation)
            assertSame(giftedSub, emitted.single().giftedSubInfo)
        } finally {
            replay.stop()
            scope.cancel()
        }
    }

    @Test
    fun stoppedReplayIgnoresSeekSpeedAndLateMessageLoadsUntilExplicitRestart() = runBlocking {
        var position = 0L
        val emitted = mutableListOf<String?>()
        val scope = CoroutineScope(coroutineContext + Job())
        val replay = ChatReplayManagerLocal({ position }, { 1f }, scope, object : ChatReplayManager.Listener {
            override suspend fun onChatMessage(message: ChatMessage) { emitted += message.id }
            override suspend fun onChatMessages(messages: List<ChatMessage>) { emitted += messages.map { it.id } }
        })
        try {
            replay.setMessages(listOf(ChatMessage(id = "old", timestamp = 1000)), 0)
            replay.startLoad()
            delay(25)
            replay.stop()
            position = 30_000
            replay.updatePosition(position)
            replay.updateSpeed(2f)
            replay.setMessages(listOf(ChatMessage(id = "new", timestamp = 1000)), 0)
            delay(50)
            assertFalse(replay.isActive)
            assertTrue(emitted.isEmpty())

            replay.startLoad()
            withTimeout(2000) { while (emitted.isEmpty()) delay(5) }
            assertTrue(replay.isActive)
            assertEquals(listOf("new"), emitted)
        } finally {
            replay.stop()
            scope.cancel()
        }
    }

    @Test
    fun stoppingBeforeQueuedLoadRunsAlsoCancelsItsClearEvent() = runBlocking {
        var clears = 0
        val scope = CoroutineScope(coroutineContext + Job())
        val replay = ChatReplayManagerLocal({ 0L }, { 1f }, scope, object : ChatReplayManager.Listener {
            override suspend fun clearMessages() { clears++ }
        })
        try {
            replay.setMessages(listOf(ChatMessage(timestamp = 1000)), 0)
            replay.startLoad()
            replay.stop()
            delay(25)
            assertEquals(0, clears)
        } finally {
            scope.cancel()
        }
    }

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
