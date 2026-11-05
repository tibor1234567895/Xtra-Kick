package com.xtrakick.app.ui.chat

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.xtrakick.app.model.chat.Image
import com.xtrakick.app.util.chat.ChatAdapterUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class ChatImageBindingTest {
    @Test
    fun lateImagesCannotReplaceReboundTextIncludingRowsWithoutImages() {
        checkLateImage { _, textView ->
            ChatAdapterUtils.beginImageBinding(textView)
            textView.text = "new message"
        }
    }

    @Test
    fun recyclingInvalidatesPendingImages() {
        checkLateImage { _, textView -> ChatAdapterUtils.clearImageBinding(textView) }
    }

    @Test
    fun removingFragmentInvalidatesPendingImagesBeforeDrawableAccess() {
        checkLateImage { fragment, _ ->
            fragment.parentFragmentManager.beginTransaction().remove(fragment).commitNow()
        }
    }

    @Test
    fun currentBindingStillReceivesImageUpdates() {
        checkLateImage(expectUpdate = true) { _, _ -> }
    }

    @Test
    fun failedLoadsCannotClearReboundText() {
        checkLateImage(drawable = null) { _, textView ->
            ChatAdapterUtils.beginImageBinding(textView)
            textView.text = "new message"
        }
    }

    @Test
    fun lateOverlayCannotCompleteAnObsoleteMessage() {
        checkLateImage(withOverlay = true) { _, textView ->
            ChatAdapterUtils.beginImageBinding(textView)
            textView.text = "new message"
        }
    }

    private fun checkLateImage(
        expectUpdate: Boolean = false,
        drawable: Drawable? = ColorDrawable(Color.WHITE),
        withOverlay: Boolean = false,
        changeBinding: (Fragment, TextView) -> Unit,
    ) {
        val activityController = Robolectric.buildActivity(FragmentActivity::class.java).setup()
        val activity = activityController.get()
        val fragment = Fragment()
        activity.supportFragmentManager.beginTransaction().add(fragment, "chat").commitNow()
        val textView = TextView(activity).apply { text = "original" }
        val image = Image(url1x = "https://example.invalid/emote", isEmote = true, start = 0, end = 1)
        if (withOverlay) {
            image.overlayEmote = Image(url1x = "https://example.invalid/overlay", isEmote = true, start = 0, end = 1)
        }
        val coordinatorField = ChatAdapterUtils::class.java.getDeclaredField("chatImageCoordinator").apply { isAccessible = true }
        @Suppress("UNCHECKED_CAST")
        val coordinator = coordinatorField.get(ChatAdapterUtils) as ChatAdapterUtils.RequestCoordinator<ChatAdapterUtils.ChatImageKey, Drawable>
        coordinator.clear()
        try {
            lateinit var complete: (Drawable?) -> Unit
            coordinator.load(
                key = ChatAdapterUtils.chatImageKeyForTest(image, "1", 28)!!,
                startLoad = { complete = it },
                callback = {},
            )
            var completeOverlay: ((Drawable?) -> Unit)? = null
            image.overlayEmote?.let { overlay ->
                coordinator.load(
                    key = ChatAdapterUtils.chatImageKeyForTest(overlay, "1", 28)!!,
                    startLoad = { completeOverlay = it },
                    callback = {},
                )
            }
            var updates = 0
            ChatAdapterUtils.beginImageBinding(textView)
            ChatAdapterUtils.loadImages(
                fragment = fragment,
                itemView = textView,
                bind = { updates++; textView.text = it },
                images = listOf(image),
                imagePaint = null,
                userName = null,
                userNameStartIndex = null,
                backgroundColor = Color.BLACK,
                imageLibrary = null,
                builder = SpannableStringBuilder("."),
                emoteSize = 28,
                badgeSize = 18,
                emoteQuality = "1",
                animateGifs = false,
                enableOverlayEmotes = false,
            )
            if (withOverlay) complete(drawable)
            changeBinding(fragment, textView)
            val expectedText = textView.text.toString()
            if (withOverlay) completeOverlay!!(drawable) else complete(drawable)

            assertEquals(if (expectUpdate) 1 else 0, updates)
            assertEquals(if (expectUpdate) "." else expectedText, textView.text.toString())
        } finally {
            coordinator.clear()
            activityController.pause().stop().destroy()
        }
    }
}
