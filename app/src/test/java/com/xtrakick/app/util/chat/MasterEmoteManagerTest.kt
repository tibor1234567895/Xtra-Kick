package com.xtrakick.app.util.chat

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Rect
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class MasterEmoteManagerTest {

    private class FakeAnimatedDrawable(
        private val width: Int = 32,
        private val height: Int = 32,
    ) : Drawable(), Animatable {
        var startCount = 0
        var stopCount = 0
        var running = false
        var drawCount = 0
        var lastDrawnBounds: Rect? = null

        override fun start() {
            startCount++
            running = true
        }

        override fun stop() {
            stopCount++
            running = false
        }

        override fun isRunning(): Boolean = running

        override fun draw(canvas: Canvas) {
            drawCount++
            lastDrawnBounds = Rect(bounds)
        }

        override fun getIntrinsicWidth(): Int = width
        override fun getIntrinsicHeight(): Int = height

        override fun setAlpha(alpha: Int) {}
        override fun setColorFilter(colorFilter: ColorFilter?) {}
        @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
        override fun getOpacity(): Int = android.graphics.PixelFormat.TRANSLUCENT
    }

    @Before
    fun setUp() {
        MasterEmoteManager.clear()
    }

    @Test
    fun masterCalculatesCorrectBoundsAndDimensions() {
        val fake = FakeAnimatedDrawable(width = 120, height = 60)
        val key = ChatAdapterUtils.ChatImageKey(source = "https://example.com/emote.gif", targetHeight = 30, isEmote = true, isAnimated = true)
        val master = MasterAnimatedEmote(key, fake, targetHeight = 30, framesPerSecond = 15)

        assertEquals(120, master.intrinsicWidth)
        assertEquals(60, master.intrinsicHeight)
        assertEquals(Rect(0, 0, 60, 30), master.bounds)
    }

    @Test
    fun subscribingAndUnsubscribingTracksReferenceCount() {
        val fake = FakeAnimatedDrawable()
        val key = ChatAdapterUtils.ChatImageKey(source = "https://example.com/test.gif", targetHeight = 32, isEmote = true, isAnimated = true)
        val master = MasterAnimatedEmote(key, fake, targetHeight = 32, framesPerSecond = 15)
        val view = View(RuntimeEnvironment.getApplication())

        assertFalse(master.isRunning)
        assertEquals(0, master.activeSubscriberCount)

        master.subscribe(view)
        assertTrue(master.isRunning)
        assertEquals(1, master.activeSubscriberCount)

        // Multiple subscribes for the same view increment ref count
        master.subscribe(view)
        assertEquals(1, master.activeSubscriberCount)

        // First unsubscribe decrements ref count
        master.unsubscribe(view)
        assertEquals(1, master.activeSubscriberCount)

        // Second unsubscribe removes view
        master.unsubscribe(view)
        assertEquals(0, master.activeSubscriberCount)
    }

    @Test
    fun proxyDelegatesLifecycleToMaster() {
        val fake = FakeAnimatedDrawable()
        val key = ChatAdapterUtils.ChatImageKey(source = "https://example.com/proxy.gif", targetHeight = 32, isEmote = true, isAnimated = true)
        val master = MasterAnimatedEmote(key, fake, targetHeight = 32, framesPerSecond = 15)
        val view = View(RuntimeEnvironment.getApplication())
        val proxy = ProxyEmoteDrawable(master, view)

        assertEquals(master.bounds, proxy.bounds)
        assertEquals(master.intrinsicWidth, proxy.intrinsicWidth)
        assertEquals(master.intrinsicHeight, proxy.intrinsicHeight)

        proxy.start()
        assertTrue(master.isRunning)
        assertTrue(proxy.isRunning)
        assertEquals(1, master.activeSubscriberCount)

        proxy.stop()
        assertEquals(0, master.activeSubscriberCount)
    }

    @Test
    fun masterEmoteManagerCachesAndEvictsMasters() {
        val key1 = ChatAdapterUtils.ChatImageKey(source = "https://example.com/1.gif", targetHeight = 32, isEmote = true, isAnimated = true)
        val key2 = ChatAdapterUtils.ChatImageKey(source = "https://example.com/2.gif", targetHeight = 32, isEmote = true, isAnimated = true)

        val fake1 = FakeAnimatedDrawable()
        val fake2 = FakeAnimatedDrawable()

        val master1 = MasterEmoteManager.getOrCreateMaster(key1, fake1, 32, 15)
        val master2 = MasterEmoteManager.getOrCreateMaster(key2, fake2, 32, 15)

        assertSame(master1, MasterEmoteManager.getMaster(key1))
        assertSame(master2, MasterEmoteManager.getMaster(key2))
        assertEquals(2, MasterEmoteManager.activeMasterCount)

        MasterEmoteManager.clear()
        assertEquals(0, MasterEmoteManager.activeMasterCount)
        assertNull(MasterEmoteManager.getMaster(key1))
        assertNull(MasterEmoteManager.getMaster(key2))
    }
}
