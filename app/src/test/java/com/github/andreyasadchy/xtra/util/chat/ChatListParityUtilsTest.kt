package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Reply
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatListParityUtilsTest {

    @Test
    fun prependDoesNotRequireRebindWithStableSlots() {
        assertNull(
            ChatListParityUtils.rebindRangeAfterPrepend(insertedCount = 3, totalCountAfterInsert = 8)
        )
        assertNull(
            ChatListParityUtils.rebindRangeAfterPrepend(insertedCount = 2, totalCountAfterInsert = 8)
        )
    }

    @Test
    fun headRemovalDoesNotRequireRebindWithStableSlots() {
        assertNull(
            ChatListParityUtils.rebindRangeAfterHeadRemoval(removedCount = 1, totalCountAfterRemoval = 6)
        )
        assertNull(
            ChatListParityUtils.rebindRangeAfterHeadRemoval(removedCount = 2, totalCountAfterRemoval = 6)
        )
    }

    @Test
    fun appendAfterHeadRemovalUsesPostRemovalPosition() {
        assertEquals(
            99,
            ChatListParityUtils.appendPositionAfterHeadRemoval(lastIndexAfterAppend = 99, removedCount = 1)
        )
    }

    @Test
    fun appendWithoutHeadRemovalUsesInsertedTailPosition() {
        assertEquals(
            100,
            ChatListParityUtils.appendPositionAfterHeadRemoval(lastIndexAfterAppend = 100, removedCount = 0)
        )
    }

    @Test
    fun replyPreviewAndReplyMessageShareVisualParity() {
        val messages = listOf(
            ChatMessage(
                isReply = true,
                reply = Reply(threadParentId = "parent-1", message = "hello"),
                timestamp = 1000L,
                fullMsg = "reply-one"
            ),
            ChatMessage(
                id = "message-1",
                message = "reply-one",
                reply = Reply(threadParentId = "parent-1", message = "hello"),
                timestamp = 1000L,
                fullMsg = "reply-one"
            ),
            ChatMessage(
                id = "message-2",
                message = "next"
            )
        )

        assertEquals(0, ChatListParityUtils.resolveVisualParityPosition(messages, 0))
        assertEquals(0, ChatListParityUtils.resolveVisualParityPosition(messages, 1))
        assertEquals(1, ChatListParityUtils.resolveVisualParityPosition(messages, 2))
    }

    @Test
    fun dividerIsHiddenInsideReplyBlock() {
        val messages = listOf(
            ChatMessage(
                isReply = true,
                reply = Reply(threadParentId = "parent-1", message = "hello"),
                timestamp = 1000L,
                fullMsg = "reply-one"
            ),
            ChatMessage(
                id = "message-1",
                message = "reply-one",
                reply = Reply(threadParentId = "parent-1", message = "hello"),
                timestamp = 1000L,
                fullMsg = "reply-one"
            ),
            ChatMessage(
                id = "message-2",
                message = "next"
            )
        )

        assertFalse(ChatListParityUtils.shouldDrawDividerAbove(messages, 1))
        assertTrue(ChatListParityUtils.shouldDrawDividerAbove(messages, 2))
    }

    @Test
    fun headRemovalKeepsExistingMessageParityStable() {
        val messages = mutableListOf(
            ChatMessage(id = "a", message = "a"),
            ChatMessage(id = "b", message = "b"),
            ChatMessage(id = "c", message = "c"),
            ChatMessage(id = "d", message = "d"),
        )
        // Assign initial slots.
        assertEquals(0, ChatListParityUtils.resolveVisualParityPosition(messages, 0))
        assertEquals(1, ChatListParityUtils.resolveVisualParityPosition(messages, 1))
        assertEquals(2, ChatListParityUtils.resolveVisualParityPosition(messages, 2))
        assertEquals(3, ChatListParityUtils.resolveVisualParityPosition(messages, 3))

        val slotB = messages[1].visualParitySlot
        val slotC = messages[2].visualParitySlot
        val slotD = messages[3].visualParitySlot

        // Odd head removal used to flip every remaining row's position-based parity.
        messages.removeAt(0)

        assertEquals(slotB, ChatListParityUtils.resolveVisualParityPosition(messages, 0))
        assertEquals(slotC, ChatListParityUtils.resolveVisualParityPosition(messages, 1))
        assertEquals(slotD, ChatListParityUtils.resolveVisualParityPosition(messages, 2))
        assertEquals(slotB, messages[0].visualParitySlot)
        assertEquals(slotC, messages[1].visualParitySlot)
        assertEquals(slotD, messages[2].visualParitySlot)
    }

    @Test
    fun appendAfterHeadRemovalContinuesAlternatingFromLastStableSlot() {
        val messages = mutableListOf(
            ChatMessage(id = "a", message = "a"),
            ChatMessage(id = "b", message = "b"),
            ChatMessage(id = "c", message = "c"),
        )
        ChatListParityUtils.ensureVisualParitySlots(messages)
        messages.removeAt(0)
        messages.add(ChatMessage(id = "d", message = "d"))

        assertEquals(1, ChatListParityUtils.resolveVisualParityPosition(messages, 0)) // b
        assertEquals(2, ChatListParityUtils.resolveVisualParityPosition(messages, 1)) // c
        assertEquals(3, ChatListParityUtils.resolveVisualParityPosition(messages, 2)) // d
    }

    @Test
    fun prependAssignsSlotsRelativeToExistingMessagesWithoutChangingThem() {
        val existing = mutableListOf(
            ChatMessage(id = "c", message = "c"),
            ChatMessage(id = "d", message = "d"),
        )
        ChatListParityUtils.ensureVisualParitySlots(existing)
        val slotC = existing[0].visualParitySlot
        val slotD = existing[1].visualParitySlot

        val prepended = listOf(
            ChatMessage(id = "a", message = "a"),
            ChatMessage(id = "b", message = "b"),
        )
        val messages = (prepended + existing).toMutableList()
        ChatListParityUtils.ensureVisualParitySlots(messages)

        assertEquals(slotC, messages[2].visualParitySlot)
        assertEquals(slotD, messages[3].visualParitySlot)
        assertEquals(slotC!! - 2, messages[0].visualParitySlot)
        assertEquals(slotC - 1, messages[1].visualParitySlot)
    }
}
