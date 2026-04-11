package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Emote
import com.github.andreyasadchy.xtra.model.chat.Reply
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatAdapterUtilsTest {

    @Test
    fun highlightsReplyDirectedAtLoggedInUser() {
        val chatMessage = ChatMessage(
            userLogin = "someoneelse",
            userName = "SomeoneElse",
            message = "thanks",
            reply = Reply(
                threadParentId = "parent-1",
                userLogin = "Tibor",
                userName = "Tibor",
                message = "hello"
            )
        )

        assertTrue(ChatAdapterUtils.isMessageHighlightedForLoggedInUser(chatMessage, "tibor"))
    }

    @Test
    fun doesNotHighlightUsersOwnReply() {
        val chatMessage = ChatMessage(
            userLogin = "tibor",
            userName = "Tibor",
            message = "self reply",
            reply = Reply(
                threadParentId = "parent-1",
                userLogin = "tibor",
                userName = "Tibor",
                message = "hello"
            )
        )

        assertFalse(ChatAdapterUtils.isMessageHighlightedForLoggedInUser(chatMessage, "tibor"))
    }

    @Test
    fun doesNotHighlightSyntheticReplyPreviewRow() {
        val previewRow = ChatMessage(
            isReply = true,
            reply = Reply(
                threadParentId = "parent-1",
                userLogin = "tibor",
                userName = "Tibor",
                message = "hello"
            )
        )

        assertFalse(ChatAdapterUtils.isMessageHighlightedForLoggedInUser(previewRow, "tibor"))
    }

    @Test
    fun splitsConcatenatedThirdPartyEmoteRuns() {
        val emotes = listOf(
            Emote(name = "dasmehdiDRIVE"),
            Emote(name = "berryybooSip"),
        )

        val result = ChatAdapterUtils.splitConcatenatedThirdPartyEmotes(
            "dasmehdiDRIVEberryybooSipberryybooSip",
            emotes
        )

        assertEquals(listOf("dasmehdiDRIVE", "berryybooSip", "berryybooSip"), result?.map { it.name })
    }

    @Test
    fun doesNotSplitPlainTextIntoThirdPartyEmotes() {
        val result = ChatAdapterUtils.splitConcatenatedThirdPartyEmotes(
            "UNDERSTOOD",
            listOf(Emote(name = "cat"), Emote(name = "dog"))
        )

        assertNull(result)
    }
}
