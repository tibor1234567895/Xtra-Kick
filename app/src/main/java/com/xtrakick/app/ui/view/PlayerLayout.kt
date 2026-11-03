package com.xtrakick.app.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class PlayerLayout : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var isPortrait = false

    var isMinimized = false
        set(value) {
            if (field != value) {
                field = value
                requestLayout()
            }
        }

    var videoAspectRatio = 16f / 9f
        set(value) {
            if (value.isFinite() && value > 0f && field != value) {
                field = value
                if (isMinimized) requestLayout()
            }
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (isMinimized) {
            val playerWidth = minOf(measuredWidth, (measuredHeight * videoAspectRatio).toInt())
            val playerHeight = (playerWidth / videoAspectRatio).toInt()
            super.onMeasure(
                MeasureSpec.makeMeasureSpec(playerWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(playerHeight, MeasureSpec.EXACTLY)
            )
        } else if (isPortrait) {
            val playerHeight = (measuredWidth / (16f / 9f)).toInt()
            super.onMeasure(
                widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(playerHeight, MeasureSpec.EXACTLY)
            )
        }
    }
}
