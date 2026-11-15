package com.xtrakick.app.util.chat

import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.util.WeakHashMap

@RunWith(RobolectricTestRunner::class)
class ChatAnimatedFrameSchedulerTest {

    @Test
    fun collectedSingletonDoesNotCrashFrameInvalidation() {
        // Model a weak key disappearing between the collection size check and iteration.
        val dirtyViews = object : HashMap<View, Unit>() {
            override val keys: MutableSet<View>
                get() = object : AbstractMutableSet<View>() {
                    override val size = 1
                    override fun iterator(): MutableIterator<View> = mutableListOf<View>().iterator()
                    override fun add(element: View): Boolean = error("Read-only test keys")
                }
        }
        assertThrows(NoSuchElementException::class.java) { dirtyViews.keys.toList() }

        invalidationRunnable(dirtyViews).run()

        assertTrue(dirtyViews.isEmpty())
    }

    @Test
    fun survivingViewsAreInvalidatedOnceAndRemovedFromPendingFrame() {
        var invalidations = 0
        val first = object : View(RuntimeEnvironment.getApplication()) {
            override fun invalidate() { invalidations++ }
        }
        val second = object : View(RuntimeEnvironment.getApplication()) {
            override fun invalidate() { invalidations++ }
        }
        val dirtyViews = WeakHashMap<View, Unit>().apply {
            put(first, Unit)
            put(first, Unit)
            put(second, Unit)
        }
        val runnable = invalidationRunnable(dirtyViews)
        invalidations = 0

        runnable.run()
        assertEquals(2, invalidations)
        assertTrue(dirtyViews.isEmpty())

        runnable.run()
        assertEquals(2, invalidations)
    }

    private fun invalidationRunnable(dirtyViews: MutableMap<View, Unit>): Runnable {
        val schedulerClass = Class.forName(
            "com.xtrakick.app.util.chat.ChatAdapterUtils\$AnimatedFrameScheduler"
        )
        val constructor = schedulerClass.getDeclaredConstructor(View::class.java, Int::class.javaPrimitiveType)
        constructor.isAccessible = true
        val scheduler = constructor.newInstance(View(RuntimeEnvironment.getApplication()), 15)
        schedulerClass.getDeclaredField("dirtyViews").apply {
            isAccessible = true
            set(scheduler, dirtyViews)
        }
        return schedulerClass.getDeclaredField("invalidateRunnable").run {
            isAccessible = true
            get(scheduler) as Runnable
        }
    }
}
