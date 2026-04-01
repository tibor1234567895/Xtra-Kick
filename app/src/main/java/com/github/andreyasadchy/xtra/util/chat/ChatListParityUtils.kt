package com.github.andreyasadchy.xtra.util.chat

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
}
