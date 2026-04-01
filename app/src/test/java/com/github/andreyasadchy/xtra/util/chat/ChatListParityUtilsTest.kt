package com.github.andreyasadchy.xtra.util.chat

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
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
}
