package com.xtrakick.app.ui.chat

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import coil3.ImageLoader
import coil3.decode.DataSource
import coil3.decode.ImageSource
import coil3.fetch.SourceFetchResult
import coil3.request.Options
import com.xtrakick.app.model.chat.Image
import com.xtrakick.app.ui.view.CenteredImageSpan
import com.xtrakick.app.util.LegacyAnimatedWebpDecoder
import com.xtrakick.app.util.chat.ChatAdapterUtils
import okio.Buffer
import okio.FileSystem
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class ChatImageBindingTest {
    @Test
    @Config(sdk = [27])
    fun legacyDecoderClaimsAnimatedWebpAndLeavesOtherFormatsUntouched() {
        val context = RuntimeEnvironment.getApplication()
        val loader = ImageLoader.Builder(context).build()
        val factory = LegacyAnimatedWebpDecoder()
        val options = Options(context)
        fun probe(flags: Int, animationExpected: Boolean) {
            val header = Buffer().writeUtf8("RIFF").writeIntLe(22).writeUtf8("WEBPVP8X")
                .writeIntLe(10).writeByte(flags).write(ByteArray(9))
            val size = header.size
            ImageSource(header, FileSystem.SYSTEM).use { source ->
                val decoder = factory.create(SourceFetchResult(source, "image/webp", DataSource.DISK), options, loader)
                if (animationExpected) assertNotNull(decoder) else assertNull(decoder)
                assertEquals(size, header.size)
            }
        }
        try {
            probe(2, animationExpected = true)
            probe(0, animationExpected = false)
        } finally {
            loader.shutdown()
        }
    }

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

    @Test
    fun loadImagesWithZeroOrNegativeSizesDoesNotCrash() {
        val activityController = Robolectric.buildActivity(FragmentActivity::class.java).setup()
        val activity = activityController.get()
        val fragment = Fragment()
        activity.supportFragmentManager.beginTransaction().add(fragment, "chat").commitNow()
        val textView = TextView(activity).apply { text = "original" }
        val image = Image(url1x = "https://example.invalid/emote", isEmote = true, start = 0, end = 1)
        ChatAdapterUtils.beginImageBinding(textView)
        ChatAdapterUtils.loadImages(
            fragment = fragment,
            itemView = textView,
            bind = { textView.text = it },
            images = listOf(image),
            imagePaint = null,
            userName = null,
            userNameStartIndex = null,
            backgroundColor = Color.BLACK,
            builder = SpannableStringBuilder("."),
            emoteSize = 0,
            badgeSize = -5,
            emoteQuality = "1",
            animateGifs = false,
            enableOverlayEmotes = false,
        )
        activityController.pause().stop().destroy()
    }

    @Test
    fun loadImagesWithDetachedFragmentDoesNotCrash() {
        val activityController = Robolectric.buildActivity(FragmentActivity::class.java).setup()
        val activity = activityController.get()
        val fragment = Fragment()
        activity.supportFragmentManager.beginTransaction().add(fragment, "chat").commitNow()
        val textView = TextView(activity).apply { text = "original" }
        val image = Image(url1x = "https://example.invalid/emote", isEmote = true, start = 0, end = 1)
        activity.supportFragmentManager.beginTransaction().remove(fragment).commitNow()
        ChatAdapterUtils.beginImageBinding(textView)
        ChatAdapterUtils.loadImages(
            fragment = fragment,
            itemView = textView,
            bind = { textView.text = it },
            images = listOf(image),
            imagePaint = null,
            userName = null,
            userNameStartIndex = null,
            backgroundColor = Color.BLACK,
            builder = SpannableStringBuilder("."),
            emoteSize = 28,
            badgeSize = 18,
            emoteQuality = "1",
            animateGifs = false,
            enableOverlayEmotes = false,
        )
        activityController.pause().stop().destroy()
    }

    @Test
    fun reserveImagePlaceholdersCoercesZeroOrNegativeSizes() {
        val builder = SpannableStringBuilder(". .")
        val emote = Image(url1x = "https://example.invalid/emote", isEmote = true, start = 0, end = 1)
        val badge = Image(url1x = "https://example.invalid/badge", isEmote = false, start = 2, end = 3)
        ChatAdapterUtils.reserveImagePlaceholders(
            builder = builder,
            images = listOf(emote, badge),
            emoteSize = 0,
            badgeSize = -10,
        )
        val spans = builder.getSpans(0, builder.length, CenteredImageSpan::class.java)
        assertEquals(2, spans.size)
        spans.forEach { span ->
            assertTrue(span.drawable.bounds.right >= 1)
            assertTrue(span.drawable.bounds.bottom >= 1)
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
