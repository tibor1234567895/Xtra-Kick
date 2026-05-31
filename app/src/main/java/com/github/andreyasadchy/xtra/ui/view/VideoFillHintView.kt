package com.github.andreyasadchy.xtra.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class VideoFillHintView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
    }
    private val videoBounds = RectF()

    fun setVideoBounds(left: Float, top: Float, right: Float, bottom: Float) {
        videoBounds.set(left, top, right, bottom)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (videoBounds.isEmpty || width <= 0 || height <= 0) {
            return
        }
        val left = videoBounds.left.coerceIn(0f, width.toFloat())
        val top = videoBounds.top.coerceIn(0f, height.toFloat())
        val right = videoBounds.right.coerceIn(0f, width.toFloat())
        val bottom = videoBounds.bottom.coerceIn(0f, height.toFloat())
        canvas.drawRect(0f, 0f, width.toFloat(), top, paint)
        canvas.drawRect(0f, bottom, width.toFloat(), height.toFloat(), paint)
        canvas.drawRect(0f, top, left, bottom, paint)
        canvas.drawRect(right, top, width.toFloat(), bottom, paint)
    }
}
