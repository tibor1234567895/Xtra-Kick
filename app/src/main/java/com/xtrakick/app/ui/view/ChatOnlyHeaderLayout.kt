package com.xtrakick.app.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.LinearLayout
import kotlin.math.abs

class ChatOnlyHeaderLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    var onDrag: ((Float) -> Unit)? = null
    var onRelease: ((Boolean) -> Unit)? = null
    private val touchSlop = ViewConfiguration.get(context).scaledTouchSlop
    private var startX = 0f
    private var startY = 0f
    private var dragging = false

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.rawX
                startY = event.rawY
                dragging = false
            }
            MotionEvent.ACTION_MOVE -> {
                val dy = event.rawY - startY
                if (dy > touchSlop && dy > abs(event.rawX - startX)) {
                    dragging = true
                    parent.requestDisallowInterceptTouchEvent(true)
                    return true
                }
            }
        }
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> return true
            MotionEvent.ACTION_MOVE -> {
                val dy = (event.rawY - startY).coerceAtLeast(0f)
                if (dragging || dy > touchSlop && dy > abs(event.rawX - startX)) {
                    dragging = true
                    parent.requestDisallowInterceptTouchEvent(true)
                    onDrag?.invoke(dy)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                parent.requestDisallowInterceptTouchEvent(false)
                if (dragging) {
                    onRelease?.invoke(event.actionMasked == MotionEvent.ACTION_UP &&
                        event.rawY - startY >= 64 * resources.displayMetrics.density)
                } else if (event.actionMasked == MotionEvent.ACTION_UP) {
                    performClick()
                }
                dragging = false
            }
        }
        return true
    }

    override fun performClick(): Boolean = super.performClick()
}
