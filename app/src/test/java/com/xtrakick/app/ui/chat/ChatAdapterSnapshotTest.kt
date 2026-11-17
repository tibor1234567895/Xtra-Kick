package com.xtrakick.app.ui.chat

import android.app.Application
import android.graphics.Color
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.model.chat.ChatMessage
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class)
class ChatAdapterSnapshotTest {
    @Test fun sourceMutationDoesNotChangeTheDisplayedCountOrRows() {
        val source = mutableListOf(ChatMessage(id = "one"), ChatMessage(id = "two"))
        val adapter = adapter(source)
        source.clear()
        assertEquals(2, adapter.itemCount)
        assertEquals(listOf("one", "two"), adapter.currentList.map { it.id })
    }

    @Test fun headTrimsResetsAndNewMessagesStayConsistentWhileScrolling() {
        val source = MutableList(100) { ChatMessage(id = "$it", message = "message $it") }
        val adapter = adapter(source)
        val rv = RecyclerView(RuntimeEnvironment.getApplication()).apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
        layout(rv)
        rv.scrollBy(0, 100)
        rv.fling(0, 1200)
        repeat(5) { round ->
            source.removeAt(0)
            source.add(ChatMessage(id = "new-$round", message = "new $round"))
            val snapshot = source.toList()
            adapter.submitList(snapshot)
            awaitList(adapter, snapshot)
            layout(rv)
            assertEquals(100, adapter.itemCount)
        }
        adapter.submitList(emptyList())
        awaitList(adapter, emptyList())
        source.clear()
        source.add(ChatMessage(id = "after-seek", message = "after seek"))
        adapter.submitList(source.toList())
        awaitList(adapter, source)
        layout(rv)
        assertEquals("after-seek", adapter.currentList.single().id)
        assertTrue(rv.childCount > 0)
        rv.stopScroll()
    }

    private fun layout(rv: RecyclerView) {
        rv.measure(View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY))
        rv.layout(0, 0, 500, 100)
    }

    private fun awaitList(adapter: ChatAdapter, expected: List<ChatMessage>) {
        val deadline = System.nanoTime() + 5_000_000_000L
        while (adapter.currentList != expected && System.nanoTime() < deadline) {
            Thread.sleep(5)
            shadowOf(Looper.getMainLooper()).idle()
        }
        assertEquals(expected, adapter.currentList)
    }

    private fun adapter(messages: List<ChatMessage>) = ChatAdapter(
        initialMessages = messages,
        localChatEmotes = emptyList(), thirdPartyEmotes = emptyList(), globalBadges = emptyList(),
        channelBadges = emptyList(), cheerEmotes = emptyList(), namePaints = emptyList(),
        stvBadges = emptyList(), personalEmoteSets = emptyMap(), stvUsers = emptyList(),
        enableTimestamps = false, timestampFormat = null, firstMsgVisibility = 2,
        firstChatMsg = "", redeemedChatMsg = "", redeemedNoMsg = "", rewardChatMsg = "", replyMessage = "",
        useRandomColors = false, useReadableColors = false, isLightTheme = false, nameDisplay = null,
        useBoldNames = false, showNamePaints = false, showStvBadges = false, showKickBadges = false,
        showPersonalEmotes = false, enableAlternatingLineShadows = false, alternatingLineShadowStrength = 0,
        showSystemMessageEmotes = false, chatUrl = null, getEmoteBytes = null, fragment = Fragment(),
        backgroundColor = Color.BLACK, dialogBackgroundColor = Color.BLACK, imageLibrary = null,
        messageTextSize = 14f, emoteSize = 28, badgeSize = 18, emoteQuality = "1", animateGifs = false,
        animatedEmoteFps = 15, enableOverlayEmotes = false, channelId = null, loggedInUser = null,
        messageClickListener = null, replyClickListener = null, replyModeClickListener = null, imageClickListener = null,
    )
}
