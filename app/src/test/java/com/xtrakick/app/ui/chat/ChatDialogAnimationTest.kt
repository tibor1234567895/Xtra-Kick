package com.xtrakick.app.ui.chat

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.Animatable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.Random

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class ChatDialogAnimationTest {
    @Test
    fun detachingDialogsStopsAnimationsInsideNestedMessageRows() {
        checkDetachAnimations(animateGifs = true)
    }

    @Test
    fun detachingDialogsRespectsDisabledAnimations() {
        checkDetachAnimations(animateGifs = false)
    }

    private fun checkDetachAnimations(animateGifs: Boolean) {
        for (adapter in adapters(animateGifs)) {
            val recyclerView = RecyclerView(RuntimeEnvironment.getApplication())
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            adapter.onDetachedFromRecyclerView(recyclerView)
            val animations = List(2) { TestAnimation() }
            for ((index, animation) in animations.withIndex()) {
                val row = adapter.onCreateViewHolder(recyclerView, 0).itemView
                val drawable = if (index == 0) animation else LayerDrawable(arrayOf(animation))
                val text = SpannableString("emote").apply {
                    setSpan(ImageSpan(drawable), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                row.findViewById<TextView>(R.id.chatMessageText).setText(text, TextView.BufferType.SPANNABLE)
                recyclerView.addView(row)
                animation.start()
                assertTrue(animation.isRunning)
            }
            recyclerView.addView(View(recyclerView.context))
            adapter.onDetachedFromRecyclerView(recyclerView)
            adapter.onDetachedFromRecyclerView(recyclerView)

            for (animation in animations) {
                assertEquals(adapter.javaClass.simpleName, !animateGifs, animation.isRunning)
            }
        }
    }

    private fun adapters(animateGifs: Boolean): List<RecyclerView.Adapter<*>> = listOf(
        MessageClickedChatAdapter(
            sourceMessages = emptyList(),
            replyClick = {},
            localChatEmotes = emptyList(),
            thirdPartyEmotes = emptyList(),
            globalBadges = emptyList(),
            channelBadges = emptyList(),
            cheerEmotes = emptyList(),
            namePaints = emptyList(),
            stvBadges = emptyList(),
            personalEmoteSets = emptyMap(),
            stvUsers = emptyList(),
            enableTimestamps = false,
            timestampFormat = null,
            firstMsgVisibility = 2,
            firstChatMsg = "",
            redeemedChatMsg = "",
            redeemedNoMsg = "",
            rewardChatMsg = "",
            replyMessage = "",
            imageClick = { _, _, _, _, _, _, _ -> },
            useRandomColors = false,
            useReadableColors = false,
            isLightTheme = false,
            nameDisplay = null,
            useBoldNames = false,
            showNamePaints = false,
            showStvBadges = false,
            showKickBadges = false,
            showPersonalEmotes = false,
            enableAlternatingLineShadows = false,
            alternatingLineShadowStrength = 0,
            showSystemMessageEmotes = false,
            chatUrl = null,
            getEmoteBytes = null,
            fragment = Fragment(),
            backgroundColor = Color.BLACK,
            imageLibrary = null,
            messageTextSize = 14f,
            emoteSize = 28,
            badgeSize = 18,
            emoteQuality = "1",
            animateGifs = animateGifs,
            enableOverlayEmotes = false,
            random = Random(0),
            userColors = hashMapOf(),
            savedColors = hashMapOf(),
            savedLocalChatEmotes = mutableMapOf(),
            savedLocalBadges = mutableMapOf(),
            savedLocalCheerEmotes = mutableMapOf(),
            savedLocalEmotes = mutableMapOf(),
            loggedInUser = null,
            selectedMessage = null,
        ),
        ReplyClickedChatAdapter(
            messages = emptyList(),
            localChatEmotes = emptyList(),
            thirdPartyEmotes = emptyList(),
            globalBadges = emptyList(),
            channelBadges = emptyList(),
            cheerEmotes = emptyList(),
            namePaints = emptyList(),
            stvBadges = emptyList(),
            personalEmoteSets = emptyMap(),
            stvUsers = emptyList(),
            enableTimestamps = false,
            timestampFormat = null,
            firstMsgVisibility = 2,
            firstChatMsg = "",
            redeemedChatMsg = "",
            redeemedNoMsg = "",
            rewardChatMsg = "",
            replyMessage = "",
            imageClick = { _, _, _, _, _, _, _ -> },
            useRandomColors = false,
            useReadableColors = false,
            isLightTheme = false,
            nameDisplay = null,
            useBoldNames = false,
            showNamePaints = false,
            showStvBadges = false,
            showKickBadges = false,
            showPersonalEmotes = false,
            enableAlternatingLineShadows = false,
            alternatingLineShadowStrength = 0,
            showSystemMessageEmotes = false,
            chatUrl = null,
            getEmoteBytes = null,
            fragment = Fragment(),
            backgroundColor = Color.BLACK,
            imageLibrary = null,
            messageTextSize = 14f,
            emoteSize = 28,
            badgeSize = 18,
            emoteQuality = "1",
            animateGifs = animateGifs,
            enableOverlayEmotes = false,
            random = Random(0),
            userColors = hashMapOf(),
            savedColors = hashMapOf(),
            savedLocalChatEmotes = mutableMapOf(),
            savedLocalBadges = mutableMapOf(),
            savedLocalCheerEmotes = mutableMapOf(),
            savedLocalEmotes = mutableMapOf(),
            loggedInUser = null,
            selectedMessage = null,
        ),
    )

    private class TestAnimation : ColorDrawable(Color.WHITE), Animatable {
        private var running = false

        override fun start() {
            running = true
        }

        override fun stop() {
            running = false
        }

        override fun isRunning(): Boolean = running
    }
}
