package com.xtrakick.app.util.chat

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.view.View
import java.util.Collections
import java.util.WeakHashMap

/**
 * Single master coordinator for an animated emote instance.
 *
 * Runs one underlying [Animatable] (Coil's AnimatedImageDrawable or Glide's GifDrawable),
 * and fans out invalidation ticks to all active subscriber [View]s through
 * [ChatAdapterUtils.requestInvalidate].
 */
internal class MasterAnimatedEmote(
    val key: ChatAdapterUtils.ChatImageKey,
    val delegate: Drawable,
    val targetHeight: Int,
    framesPerSecond: Int,
) : Drawable.Callback {

    val animatable: Animatable = delegate as Animatable
    val intrinsicWidth: Int
    val intrinsicHeight: Int
    val bounds: Rect
    val opacity: Int

    private var currentFps = framesPerSecond
    private val subscribers = Collections.synchronizedMap(WeakHashMap<View, Int>())
    private val mainHandler = Handler(Looper.getMainLooper())
    private var isDebounceScheduled = false
    private val debouncePauseRunnable = Runnable {
        isDebounceScheduled = false
        synchronized(this) {
            if (subscribers.isEmpty() && animatable.isRunning) {
                animatable.stop()
            }
        }
    }

    init {
        val rawWidth = delegate.intrinsicWidth.takeIf { it > 0 } ?: targetHeight
        val rawHeight = delegate.intrinsicHeight.takeIf { it > 0 } ?: targetHeight
        intrinsicWidth = rawWidth
        intrinsicHeight = rawHeight
        @Suppress("DEPRECATION")
        opacity = delegate.opacity

        val widthRatio = rawWidth.toFloat() / rawHeight.toFloat()
        val calculatedWidth = if (widthRatio == 1f) {
            targetHeight
        } else {
            (targetHeight * widthRatio).toInt().coerceAtLeast(1)
        }
        bounds = Rect(0, 0, calculatedWidth, targetHeight)
        delegate.bounds = bounds
        delegate.callback = this
    }

    val isRunning: Boolean
        get() = animatable.isRunning

    val activeSubscriberCount: Int
        get() = synchronized(this) { subscribers.size }

    fun updateFrameRate(fps: Int) {
        currentFps = fps
    }

    fun subscribe(view: View) {
        synchronized(this) {
            val currentCount = subscribers[view] ?: 0
            subscribers[view] = currentCount + 1
            if (isDebounceScheduled) {
                mainHandler.removeCallbacks(debouncePauseRunnable)
                isDebounceScheduled = false
            }
            if (!animatable.isRunning) {
                animatable.start()
            }
        }
    }

    fun unsubscribe(view: View) {
        synchronized(this) {
            val currentCount = subscribers[view] ?: 0
            if (currentCount <= 1) {
                subscribers.remove(view)
            } else {
                subscribers[view] = currentCount - 1
            }
            if (subscribers.isEmpty() && !isDebounceScheduled && animatable.isRunning) {
                isDebounceScheduled = true
                mainHandler.postDelayed(debouncePauseRunnable, DEBOUNCE_PAUSE_MS)
            }
        }
    }

    fun draw(canvas: Canvas, targetBounds: Rect = bounds) {
        if (delegate.bounds != targetBounds) {
            delegate.bounds = targetBounds
        }
        delegate.draw(canvas)
    }

    // --- Drawable.Callback ---

    override fun invalidateDrawable(who: Drawable) {
        synchronized(this) {
            for (view in subscribers.keys) {
                ChatAdapterUtils.requestInvalidate(view, currentFps)
            }
        }
    }

    override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
        mainHandler.postAtTime(what, who, `when`)
    }

    override fun unscheduleDrawable(who: Drawable, what: Runnable) {
        mainHandler.removeCallbacks(what, who)
    }

    fun release() {
        synchronized(this) {
            if (isDebounceScheduled) {
                mainHandler.removeCallbacks(debouncePauseRunnable)
                isDebounceScheduled = false
            }
            subscribers.clear()
            if (animatable.isRunning) {
                animatable.stop()
            }
            delegate.callback = null
        }
    }

    companion object {
        const val DEBOUNCE_PAUSE_MS = 2500L
    }
}
