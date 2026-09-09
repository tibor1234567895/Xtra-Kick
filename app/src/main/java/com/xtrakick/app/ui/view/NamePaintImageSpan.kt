package com.xtrakick.app.ui.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.Drawable
import android.text.style.ReplacementSpan
import com.xtrakick.app.model.chat.NamePaint
import kotlin.math.ceil
import kotlin.math.max

class NamePaintImageSpan(
    private val name: String,
    private val shadows: List<NamePaint.Shadow>?,
    var backgroundColor: Int?,
    private val bottomBackgroundColor: Int,
    val drawable: Drawable,
) : ReplacementSpan() {
    private var maskBitmap: Bitmap? = null
    private var maskCanvas: Canvas? = null
    private val maskPaint = Paint()
    private val maskMode = PorterDuffXfermode(PorterDuff.Mode.SRC)

    override fun getSize(paint: Paint, text: CharSequence?, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        if (fm != null) {
            val paintFm = paint.fontMetrics
            fm.ascent = paintFm.ascent.toInt()
            fm.bottom = paintFm.bottom.toInt()
            fm.descent = paintFm.descent.toInt()
            fm.leading = paintFm.leading.toInt()
            fm.top = paintFm.top.toInt()
        }
        return paint.measureText(name).toInt()
    }

    override fun draw(canvas: Canvas, text: CharSequence?, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint) {
        val xOffset = x.toInt()
        val width = paint.measureText(name).toInt()
        val height = bottom - top
        val drawableWidth = drawable.intrinsicWidth
        val drawableHeight = drawable.intrinsicHeight
        if (width <= 0 || height <= 0 || drawableWidth <= 0 || drawableHeight <= 0) return
        val widthRatio = drawableWidth.toFloat() / drawableHeight.toFloat()
        val fullWidth: Int
        val fullHeight: Int
        if (height > drawableHeight) {
            val addedWidth = ceil((height - drawableHeight) * widthRatio).toInt()
            val newWidth = drawableWidth + addedWidth
            if (width > newWidth) {
                val addedHeight = ceil((width - newWidth) / widthRatio).toInt()
                fullWidth = xOffset + width
                fullHeight = bottom + addedHeight
            } else {
                fullWidth = xOffset + newWidth
                fullHeight = bottom
            }
        } else {
            if (width > drawableWidth) {
                val addedHeight = ceil((width - drawableWidth) / widthRatio).toInt()
                fullWidth = xOffset + width
                fullHeight = top + drawableHeight + addedHeight
            } else {
                fullWidth = xOffset + drawableWidth
                fullHeight = top + drawableHeight
            }
        }
        drawable.setBounds(xOffset, top, fullWidth, fullHeight)
        drawable.draw(canvas)
        val maskWidth = max(fullWidth - xOffset, 1)
        val maskHeight = max(fullHeight - top, 1)
        if (maskBitmap?.width != maskWidth || maskBitmap?.height != maskHeight) {
            maskBitmap = Bitmap.createBitmap(maskWidth, maskHeight, Bitmap.Config.ARGB_8888)
            maskCanvas = Canvas(requireNotNull(maskBitmap))
        }
        val maskBitmap = requireNotNull(maskBitmap)
        val maskCanvas = requireNotNull(maskCanvas)
        maskBitmap.eraseColor(android.graphics.Color.TRANSPARENT)
        maskPaint.set(paint)
        maskPaint.style = Paint.Style.FILL
        maskPaint.color = bottomBackgroundColor
        maskCanvas.drawPaint(maskPaint)
        backgroundColor?.let {
            maskPaint.color = it
            maskCanvas.drawPaint(maskPaint)
        }
        maskPaint.color = paint.color
        val yOffset = y.toFloat() - top
        shadows?.forEach {
            maskPaint.setShadowLayer(it.radius, it.xOffset, it.yOffset, it.color)
            maskCanvas.drawText(name, 0f, yOffset, maskPaint)
        }
        maskPaint.clearShadowLayer()
        maskPaint.xfermode = maskMode
        maskPaint.alpha = 0
        maskCanvas.drawText(name, 0f, yOffset, maskPaint)
        canvas.drawBitmap(maskBitmap, xOffset.toFloat(), top.toFloat(), paint)
    }
}
