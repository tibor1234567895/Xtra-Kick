package com.xtrakick.app.ui.view

import android.view.MotionEvent
import android.widget.FrameLayout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class ChatOnlyHeaderLayoutTest {
    private val context = RuntimeEnvironment.getApplication()
    private val header = ChatOnlyHeaderLayout(context, Robolectric.buildAttributeSet().build()).also {
        FrameLayout(context).addView(it)
    }
    private val distance = 100 * context.resources.displayMetrics.density

    private fun event(action: Int, y: Float, time: Long = 0L, x: Float = 0f): MotionEvent =
        MotionEvent.obtain(0, time, action, x, y, 0)

    @Test
    fun slowDragAfterHoldCompletes() {
        var completed: Boolean? = null
        var dragged = 0f
        header.onRelease = { completed = it }
        header.onDrag = { dragged = it }
        event(MotionEvent.ACTION_DOWN, 0f).also { header.onInterceptTouchEvent(it); it.recycle() }
        event(MotionEvent.ACTION_MOVE, distance, 2000).also {
            assertTrue(header.onInterceptTouchEvent(it))
            header.onTouchEvent(it)
            it.recycle()
        }
        event(MotionEvent.ACTION_UP, distance, 3000).also { header.onTouchEvent(it); it.recycle() }
        assertEquals(distance, dragged, 0.01f)
        assertEquals(true, completed)
    }

    @Test
    fun cancelledDragDoesNotExit() {
        var completed: Boolean? = null
        header.onRelease = { completed = it }
        event(MotionEvent.ACTION_DOWN, 0f).also { header.onInterceptTouchEvent(it); it.recycle() }
        event(MotionEvent.ACTION_MOVE, distance).also { header.onInterceptTouchEvent(it); it.recycle() }
        event(MotionEvent.ACTION_CANCEL, distance).also { header.onTouchEvent(it); it.recycle() }
        assertEquals(false, completed)
    }

    @Test
    fun horizontalSwipeRemainsWithChild() {
        event(MotionEvent.ACTION_DOWN, 0f).also { header.onInterceptTouchEvent(it); it.recycle() }
        event(MotionEvent.ACTION_MOVE, distance / 4, x = distance).also {
            assertFalse(header.onInterceptTouchEvent(it))
            it.recycle()
        }
    }
}
