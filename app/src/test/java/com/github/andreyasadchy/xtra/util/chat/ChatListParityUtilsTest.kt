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
    fun prependRequiresRebindWhenInsertedCountIsOdd() {
        assertEquals(
            ChatParityRebindRange(start = 3, count = 5),
            ChatListParityUtils.rebindRangeAfterPrepend(insertedCount = 3, totalCountAfterInsert = 8)
        )
    }

    @Test
    fun prependSkipsRebindWhenInsertedCountIsEven() {
        assertNull(
            ChatListParityUtils.rebindRangeAfterPrepend(insertedCount = 2, totalCountAfterInsert = 8)
        )
    }

    @Test
    fun headRemovalRequiresRebindWhenRemovedCountIsOdd() {
        assertEquals(
            ChatParityRebindRange(start = 0, count = 6),
            ChatListParityUtils.rebindRangeAfterHeadRemoval(removedCount = 1, totalCountAfterRemoval = 6)
        )
    }

    @Test
    fun headRemovalSkipsRebindWhenRemovedCountIsEven() {
        assertNull(
            ChatListParityUtils.rebindRangeAfterHeadRemoval(removedCount = 2, totalCountAfterRemoval = 6)
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
}
