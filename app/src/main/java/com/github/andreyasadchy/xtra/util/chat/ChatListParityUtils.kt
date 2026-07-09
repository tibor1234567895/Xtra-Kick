package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.ChatMessage

data class ChatParityRebindRange(
    val start: Int,
    val count: Int,
)

object ChatListParityUtils {

    /**
     * With stable [ChatMessage.visualParitySlot] values, head removal never invalidates
     * existing row colors, so no adapter rebind is required.
     */
    fun rebindRangeAfterPrepend(insertedCount: Int, totalCountAfterInsert: Int): ChatParityRebindRange? {
        // Stable slots are assigned on bind/resolve; existing rows keep their parity.
        return null
    }

    /**
     * With stable [ChatMessage.visualParitySlot] values, odd head removals must not flip
     * backgrounds of rows the user is still looking at while scrolled up.
     */
    fun rebindRangeAfterHeadRemoval(removedCount: Int, totalCountAfterRemoval: Int): ChatParityRebindRange? {
        return null
    }

    fun appendPositionAfterHeadRemoval(lastIndexAfterAppend: Int, removedCount: Int): Int {
        return if (removedCount > 0) {
            lastIndexAfterAppend.coerceAtLeast(0)
        } else {
            lastIndexAfterAppend
        }
    }

    fun resolveVisualParityPosition(messages: List<ChatMessage>, position: Int): Int {
        if (position < 0 || messages.isEmpty()) {
            return 0
        }
        ensureVisualParitySlots(messages)
        val cappedPosition = position.coerceAtMost(messages.lastIndex)
        return messages[cappedPosition].visualParitySlot ?: 0
    }

    fun shouldDrawDividerAbove(messages: List<ChatMessage>, position: Int): Boolean {
        return position > 0 && !sharesVisualBlockWithPrevious(messages, position)
    }

    /**
     * Assigns [ChatMessage.visualParitySlot] for any messages that do not have one yet.
     * Existing slots are never rewritten, so head trims leave visible row colors stable.
     */
    fun ensureVisualParitySlots(messages: List<ChatMessage>) {
        if (messages.isEmpty()) {
            return
        }
        if (messages.all { it.visualParitySlot != null }) {
            return
        }

        val firstAssigned = messages.indexOfFirst { it.visualParitySlot != null }
        if (firstAssigned < 0) {
            assignForwardFrom(messages, startIndex = 0, startSlot = 0)
            return
        }

        if (firstAssigned > 0) {
            assignBackwardBefore(messages, firstAssigned)
        }

        var index = 0
        while (index < messages.size) {
            if (messages[index].visualParitySlot != null) {
                index++
                continue
            }
            val previousSlot = messages.getOrNull(index - 1)?.visualParitySlot
            if (previousSlot != null) {
                assignForwardFrom(
                    messages,
                    startIndex = index,
                    startSlot = nextSlot(messages, index, previousSlot),
                )
            } else {
                val nextAssigned = (index until messages.size).firstOrNull { messages[it].visualParitySlot != null }
                if (nextAssigned != null) {
                    assignBackwardBefore(messages, nextAssigned)
                } else {
                    assignForwardFrom(messages, startIndex = index, startSlot = 0)
                }
            }
            index++
        }
    }

    private fun assignForwardFrom(messages: List<ChatMessage>, startIndex: Int, startSlot: Int) {
        var slot = startSlot
        for (index in startIndex until messages.size) {
            val message = messages[index]
            if (message.visualParitySlot != null) {
                slot = (message.visualParitySlot ?: slot) + 1
                continue
            }
            if (index > 0 && sharesVisualBlockWithPrevious(messages, index)) {
                message.visualParitySlot = messages[index - 1].visualParitySlot ?: slot
            } else {
                message.visualParitySlot = slot
            }
            slot = (message.visualParitySlot ?: slot) + 1
        }
    }

    private fun assignBackwardBefore(messages: List<ChatMessage>, firstAssignedIndex: Int) {
        for (index in firstAssignedIndex downTo 1) {
            val previous = messages[index - 1]
            if (previous.visualParitySlot != null) {
                continue
            }
            val currentSlot = messages[index].visualParitySlot ?: continue
            previous.visualParitySlot = if (sharesVisualBlockWithPrevious(messages, index)) {
                currentSlot
            } else {
                currentSlot - 1
            }
        }
    }

    private fun nextSlot(messages: List<ChatMessage>, index: Int, previousSlot: Int): Int {
        return if (sharesVisualBlockWithPrevious(messages, index)) {
            previousSlot
        } else {
            previousSlot + 1
        }
    }

    private fun sharesVisualBlockWithPrevious(messages: List<ChatMessage>, position: Int): Boolean {
        if (position <= 0 || position > messages.lastIndex) {
            return false
        }
        val previous = messages[position - 1]
        val current = messages[position]
        return previous.isReply &&
            !current.isReply &&
            belongsToReplyPreview(previous, current)
    }

    private fun belongsToReplyPreview(replyPreview: ChatMessage, replyMessage: ChatMessage): Boolean {
        val previewThreadParentId = replyPreview.reply?.threadParentId?.takeIf { it.isNotBlank() } ?: return false
        val messageThreadParentId = replyMessage.reply?.threadParentId?.takeIf { it.isNotBlank() } ?: return false
        if (previewThreadParentId != messageThreadParentId) {
            return false
        }
        return when {
            replyPreview.timestamp != null && replyMessage.timestamp != null -> replyPreview.timestamp == replyMessage.timestamp
            !replyPreview.fullMsg.isNullOrBlank() && !replyMessage.fullMsg.isNullOrBlank() -> replyPreview.fullMsg == replyMessage.fullMsg
            else -> true
        }
    }
}
