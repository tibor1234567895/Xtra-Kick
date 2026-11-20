package com.xtrakick.app.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class ChatLayout : RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var isPortrait = false

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (isPortrait &&
            MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY &&
            MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY
        ) {
            val givenWidth = MeasureSpec.getSize(widthMeasureSpec)
            val givenHeight = MeasureSpec.getSize(heightMeasureSpec)
            val playerHeight = (givenWidth / (16f / 9f)).toInt()
            super.onMeasure(
                widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(givenHeight - playerHeight, MeasureSpec.EXACTLY)
            )
            return
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (isPortrait) {
            val playerHeight = (measuredWidth / (16f / 9f)).toInt()
            super.onMeasure(
                widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(measuredHeight - playerHeight, MeasureSpec.EXACTLY)
            )
        }
    }
}