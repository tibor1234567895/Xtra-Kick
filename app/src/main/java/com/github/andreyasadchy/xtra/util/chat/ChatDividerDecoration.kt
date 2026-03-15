package com.github.andreyasadchy.xtra.util.chat

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class ChatDividerDecoration(
    @ColorInt dividerColor: Int,
    density: Float,
) : RecyclerView.ItemDecoration() {
    private val dividerHeightPx = (density.coerceAtLeast(1f)).roundToInt().coerceAtLeast(1)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = dividerColor
        style = Paint.Style.FILL
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (position != RecyclerView.NO_POSITION && position > 0 && paint.alpha > 0) {
            outRect.top = dividerHeightPx
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (paint.alpha == 0) return
        val left = parent.paddingLeft.toFloat()
        val right = (parent.width - parent.paddingRight).toFloat()
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            if (position == RecyclerView.NO_POSITION || position == 0) continue
            val top = (child.top - dividerHeightPx).toFloat()
            val bottom = child.top.toFloat()
            canvas.drawRect(left, top, right, bottom, paint)
        }
    }
}
