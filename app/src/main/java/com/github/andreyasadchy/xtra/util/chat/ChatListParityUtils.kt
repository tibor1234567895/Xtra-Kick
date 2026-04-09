package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.ChatMessage

data class ChatParityRebindRange(
    val start: Int,
    val count: Int,
)

object ChatListParityUtils {

    fun rebindRangeAfterPrepend(insertedCount: Int, totalCountAfterInsert: Int): ChatParityRebindRange? {
        if (insertedCount <= 0 || insertedCount % 2 == 0) {
            return null
        }
        val count = totalCountAfterInsert - insertedCount
        return count.takeIf { it > 0 }?.let { ChatParityRebindRange(start = insertedCount, count = it) }
    }

    fun rebindRangeAfterHeadRemoval(removedCount: Int, totalCountAfterRemoval: Int): ChatParityRebindRange? {
        if (removedCount <= 0 || removedCount % 2 == 0 || totalCountAfterRemoval <= 0) {
            return null
        }
        return ChatParityRebindRange(start = 0, count = totalCountAfterRemoval)
    }

    fun resolveVisualParityPosition(messages: List<ChatMessage>, position: Int): Int {
        if (position <= 0 || messages.isEmpty()) {
            return 0
        }
        val cappedPosition = position.coerceAtMost(messages.lastIndex)
        var visualPosition = 0
        for (index in 1..cappedPosition) {
            if (!sharesVisualBlockWithPrevious(messages, index)) {
                visualPosition += 1
            }
        }
        return visualPosition
    }

    fun shouldDrawDividerAbove(messages: List<ChatMessage>, position: Int): Boolean {
        return position > 0 && !sharesVisualBlockWithPrevious(messages, position)
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
