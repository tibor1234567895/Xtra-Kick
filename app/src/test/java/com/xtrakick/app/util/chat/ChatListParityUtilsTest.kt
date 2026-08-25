package com.xtrakick.app.util.chat

import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.Reply
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatListParityUtilsTest {

    // The two tests that used to live here only asserted that rebindRangeAfterPrepend and
    // rebindRangeAfterHeadRemoval returned null — the functions were unconditional no-ops and
    // have been deleted. The stable-slot behaviour they were meant to protect is covered by
    // headRemovalKeepsExistingMessageParityStable and
    // prependAssignsSlotsRelativeToExistingMessagesWithoutChangingThem below.

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
    fun appendTimeSlotAssignmentMatchesTheFullSweep() {
        // assignSlotForAppendedMessage exists so the O(size) sweep stays off the bind path. It
        // has to agree with the sweep exactly, or rows would alternate differently depending on
        // which code path happened to assign them.
        val incremental = mutableListOf<ChatMessage>()
        val swept = mutableListOf<ChatMessage>()
        repeat(6) { index ->
            incremental.add(ChatMessage(id = "m$index", message = "m$index"))
            ChatListParityUtils.assignSlotForAppendedMessage(incremental)
            swept.add(ChatMessage(id = "m$index", message = "m$index"))
            ChatListParityUtils.ensureVisualParitySlots(swept)
        }

        assertEquals(
            swept.map { it.visualParitySlot },
            incremental.map { it.visualParitySlot },
        )
    }

    @Test
    fun appendTimeSlotAssignmentSharesTheBlockWithAReplyPreview() {
        val messages = mutableListOf<ChatMessage>(
            ChatMessage(id = "first", message = "first"),
            ChatMessage(
                isReply = true,
                reply = Reply(threadParentId = "parent-1", message = "hello"),
                timestamp = 1000L,
                fullMsg = "reply-one"
            ),
        )
        ChatListParityUtils.ensureVisualParitySlots(messages)
        val previewSlot = messages[1].visualParitySlot

        // The reply body belongs to the same visual block as its preview, so appending it must
        // reuse the preview's slot rather than advance to the next one.
        messages.add(
            ChatMessage(
                id = "message-1",
                message = "reply-one",
                reply = Reply(threadParentId = "parent-1", message = "hello"),
                timestamp = 1000L,
                fullMsg = "reply-one"
            )
        )
        ChatListParityUtils.assignSlotForAppendedMessage(messages)

        assertEquals(previewSlot, messages[2].visualParitySlot)
    }

    @Test
    fun resolveVisualParityPositionStillAssignsSlotsForUnassignedRows() {
        // The fast path in resolveVisualParityPosition returns early for rows that already have
        // a slot; rows that do not must still fall through to the sweep.
        val messages = mutableListOf(
            ChatMessage(id = "a", message = "a"),
            ChatMessage(id = "b", message = "b"),
        )

        assertEquals(1, ChatListParityUtils.resolveVisualParityPosition(messages, 1))
        assertEquals(0, messages[0].visualParitySlot)
        assertEquals(1, messages[1].visualParitySlot)
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
