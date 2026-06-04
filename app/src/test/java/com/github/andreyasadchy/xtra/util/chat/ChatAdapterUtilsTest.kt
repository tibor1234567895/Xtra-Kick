package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Emote
import com.github.andreyasadchy.xtra.model.chat.Image
import com.github.andreyasadchy.xtra.model.chat.Reply
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

class ChatAdapterUtilsTest {

    @Test
    fun highlightsReplyDirectedAtLoggedInUser() {
        val chatMessage = ChatMessage(
            userLogin = "someoneelse",
            userName = "SomeoneElse",
            message = "thanks",
            reply = Reply(
                threadParentId = "parent-1",
                userLogin = "currentuser",
                userName = "CurrentUser",
                message = "hello"
            )
        )

        assertTrue(ChatAdapterUtils.isMessageHighlightedForLoggedInUser(chatMessage, "currentuser"))
    }

    @Test
    fun doesNotHighlightUsersOwnReply() {
        val chatMessage = ChatMessage(
            userLogin = "currentuser",
            userName = "CurrentUser",
            message = "self reply",
            reply = Reply(
                threadParentId = "parent-1",
                userLogin = "currentuser",
                userName = "CurrentUser",
                message = "hello"
            )
        )

        assertFalse(ChatAdapterUtils.isMessageHighlightedForLoggedInUser(chatMessage, "currentuser"))
    }

    @Test
    fun doesNotHighlightSyntheticReplyPreviewRow() {
        val previewRow = ChatMessage(
            isReply = true,
            reply = Reply(
                threadParentId = "parent-1",
                userLogin = "currentuser",
                userName = "CurrentUser",
                message = "hello"
            )
        )

        assertFalse(ChatAdapterUtils.isMessageHighlightedForLoggedInUser(previewRow, "currentuser"))
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

    @Test
    fun usesSameChatImageKeyForKickFullsizeQualityAliases() {
        val image = Image(
            url1x = "https://files.kick.com/emotes/37217/fullsize",
            url2x = "https://files.kick.com/emotes/37217/fullsize",
            url3x = "https://files.kick.com/emotes/37217/fullsize",
            url4x = "https://files.kick.com/emotes/37217/fullsize",
            isEmote = true,
            isAnimated = true,
            start = 0,
            end = 1,
        )

        val key1x = ChatAdapterUtils.chatImageKeyForTest(image, "1", 30)
        val key4x = ChatAdapterUtils.chatImageKeyForTest(image, "4", 30)

        assertEquals(key1x, key4x)
    }

    @Test
    fun separatesChatImageKeysByDisplaySizeAndKind() {
        val emote = Image(
            url1x = "https://files.kick.com/emotes/37217/fullsize",
            isEmote = true,
            start = 0,
            end = 1,
        )
        val badge = Image(
            url1x = "https://files.kick.com/emotes/37217/fullsize",
            isEmote = false,
            start = 0,
            end = 1,
        )

        assertNotEquals(
            ChatAdapterUtils.chatImageKeyForTest(emote, "1", 30),
            ChatAdapterUtils.chatImageKeyForTest(emote, "1", 18),
        )
        assertNotEquals(
            ChatAdapterUtils.chatImageKeyForTest(emote, "1", 30),
            ChatAdapterUtils.chatImageKeyForTest(badge, "1", 30),
        )
    }

    @Test
    fun doesNotCreateChatImageKeyWithoutSource() {
        val image = Image(
            isEmote = true,
            start = 0,
            end = 1,
        )

        assertNull(ChatAdapterUtils.chatImageKeyForTest(image, "4", 30))
    }

    @Test
    fun coalescesInFlightRequestsForSameKey() {
        val coordinator = ChatAdapterUtils.RequestCoordinator<String, String>(10)
        val loaderCalls = AtomicInteger(0)
        val callbacks = mutableListOf<String?>()
        var complete: ((String?) -> Unit)? = null

        repeat(5) {
            coordinator.load(
                key = "same",
                startLoad = { callback ->
                    loaderCalls.incrementAndGet()
                    complete = callback
                },
                callback = callbacks::add,
            )
        }
        complete?.invoke("loaded")

        assertEquals(1, loaderCalls.get())
        assertEquals(listOf("loaded", "loaded", "loaded", "loaded", "loaded"), callbacks)
    }

    @Test
    fun failedInFlightRequestIsNotCached() {
        val coordinator = ChatAdapterUtils.RequestCoordinator<String, String>(10)
        val loaderCalls = AtomicInteger(0)
        val callbacks = mutableListOf<String?>()

        coordinator.load(
            key = "same",
            startLoad = { callback ->
                loaderCalls.incrementAndGet()
                callback(null)
            },
            callback = callbacks::add,
        )
        coordinator.load(
            key = "same",
            startLoad = { callback ->
                loaderCalls.incrementAndGet()
                callback("loaded")
            },
            callback = callbacks::add,
        )

        assertEquals(2, loaderCalls.get())
        assertEquals(listOf(null, "loaded"), callbacks)
    }
}
