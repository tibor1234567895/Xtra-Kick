package com.xtrakick.app.util.chat

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Rect
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.View

/**
 * Lightweight, zero-decode proxy drawable used in chat spans.
 *
 * All instances of the same animated emote share a single [MasterAnimatedEmote].
 * The proxy forwards drawing to the master at its current animation frame and
 * subscribes/unsubscribes its host [View] on lifecycle start/stop.
 */
class ProxyEmoteDrawable internal constructor(
    internal val master: MasterAnimatedEmote,
    private val hostView: View,
) : Drawable(), Animatable {

    init {
        bounds.set(master.bounds)
    }

    override fun draw(canvas: Canvas) {
        master.draw(canvas, bounds)
    }

    override fun getIntrinsicWidth(): Int = master.intrinsicWidth
    override fun getIntrinsicHeight(): Int = master.intrinsicHeight

    override fun setAlpha(alpha: Int) {
        // Chat spans render with default alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        // Chat spans render without color filter
    }

    @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
    override fun getOpacity(): Int = master.opacity

    override fun start() {
        master.subscribe(hostView)
    }

    override fun stop() {
        master.unsubscribe(hostView)
    }

    override fun isRunning(): Boolean = master.isRunning

    override fun mutate(): Drawable = this
}
