package com.github.andreyasadchy.xtra.ui.player

import android.content.Context
import android.view.ScaleGestureDetector
import android.view.View
import java.util.Locale
import kotlin.math.abs

/**
 * Shared pinch/pan video zoom used by the solo player and MultiPOV.
 * Matches the existing PlayerFragment behavior: pivot at top-left, focus-based
 * scale, viewport clamping, deadzone, and snap-back near 1x.
 */
class VideoZoomController(
    context: Context,
    private val host: Host,
) {
    interface Host {
        /** View that receives scale/translation (surface / texture / aspect frame). */
        fun getZoomView(): View?

        /** Parent viewport size the video is clamped into. */
        fun getViewportSize(): Pair<Int, Int>

        /**
         * Zoom view origin relative to the viewport (left/top).
         * For nested layouts this is usually parent.left + zoomView.left.
         */
        fun getZoomViewOriginInViewport(): Pair<Float, Float>

        /** Called after transforms change so hosts can mirror state if needed. */
        fun onZoomChanged(scale: Float, translationX: Float, translationY: Float) {}

        /** Solo player switches AspectRatioFrameLayout to ZOOM while scaled. */
        fun onZoomActiveChanged(active: Boolean) {}
    }

    var scale: Float = MIN_SCALE
        private set
    var translationX: Float = 0f
        private set
    var translationY: Float = 0f
        private set
    var gestureActive: Boolean = false
        private set

    private var gestureStartScale = 1f
    private var gestureStartSpan = 0f
    private var scaleDeadzonePassed = false
    private var lastFocusX = 0f
    private var lastFocusY = 0f
    private var panLastX = 0f
    private var panLastY = 0f
    /**
     * After a pinch ends, fingers are almost never lifted together. The remaining finger
     * then generates MOVE events without a fresh ACTION_DOWN, and pan would jump from
     * stale (often 0,0) coords. Require a re-anchor [beginPan] / first [panBy] first.
     */
    private var panNeedsReanchor = false
    var panMoved: Boolean = false
        private set

    val scaleDetector: ScaleGestureDetector = ScaleGestureDetector(
        context,
        object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
                gestureActive = true
                panNeedsReanchor = true
                panMoved = false
                gestureStartScale = scale
                gestureStartSpan = detector.currentSpan
                scaleDeadzonePassed = isZoomed()
                lastFocusX = detector.focusX
                lastFocusY = detector.focusY
                return true
            }

            override fun onScale(detector: ScaleGestureDetector): Boolean {
                if (!scaleDeadzonePassed) {
                    val spanRatio = if (gestureStartSpan > 0f) detector.currentSpan / gestureStartSpan else 1f
                    if (abs(spanRatio - 1f) < SCALE_DEADZONE_RATIO) {
                        lastFocusX = detector.focusX
                        lastFocusY = detector.focusY
                        return true
                    }
                    scaleDeadzonePassed = true
                }
                val oldScale = scale
                val newScale = (oldScale * detector.scaleFactor).coerceIn(MIN_SCALE, MAX_SCALE)
                if (newScale > MIN_SCALE + EPSILON) {
                    host.onZoomActiveChanged(true)
                }
                // When one finger lifts slightly early, focus jumps from the midpoint to the
                // remaining finger — ignore that as a pan so the image doesn't snap.
                val focusDx = detector.focusX - lastFocusX
                val focusDy = detector.focusY - lastFocusY
                if (abs(focusDx) <= MAX_FOCUS_STEP_PX && abs(focusDy) <= MAX_FOCUS_STEP_PX) {
                    translationX += focusDx * TWO_FINGER_PAN_MULTIPLIER
                    translationY += focusDy * TWO_FINGER_PAN_MULTIPLIER
                }
                if (newScale != oldScale && oldScale > 0f) {
                    val scaleChange = newScale / oldScale
                    val (originX, originY) = host.getZoomViewOriginInViewport()
                    translationX = scaledTranslation(
                        focus = detector.focusX,
                        viewStart = originX,
                        currentTranslation = translationX,
                        scaleChange = scaleChange,
                    )
                    translationY = scaledTranslation(
                        focus = detector.focusY,
                        viewStart = originY,
                        currentTranslation = translationY,
                        scaleChange = scaleChange,
                    )
                }
                scale = newScale
                lastFocusX = detector.focusX
                lastFocusY = detector.focusY
                clampAndApply()
                return true
            }

            override fun onScaleEnd(detector: ScaleGestureDetector) {
                when {
                    gestureStartScale > MIN_SCALE + EPSILON && scale <= MIN_SCALE + RESET_TOLERANCE -> {
                        reset(notifyActive = true)
                    }
                    scale <= MIN_SCALE + EPSILON -> {
                        reset(notifyActive = true)
                    }
                    else -> {
                        clampAndApply()
                    }
                }
                gestureActive = false
                // Leftover finger must re-anchor before one-finger pan can move the image.
                panNeedsReanchor = true
                panMoved = false
            }
        }
    )

    fun isZoomed(): Boolean = scale > MIN_SCALE + EPSILON

    fun formatScale(): String {
        return String.format(Locale.US, "%.1fx", scale.coerceIn(MIN_SCALE, MAX_SCALE))
    }

    fun beginPan(x: Float, y: Float) {
        panLastX = x
        panLastY = y
        panMoved = false
        panNeedsReanchor = false
    }

    fun panBy(x: Float, y: Float, touchSlop: Int): Boolean {
        if (!isZoomed()) return false
        // First sample after pinch (or without ACTION_DOWN): lock origin, do not translate.
        if (panNeedsReanchor) {
            beginPan(x, y)
            return true
        }
        val dx = x - panLastX
        val dy = y - panLastY
        if (abs(dx) > touchSlop || abs(dy) > touchSlop) {
            panMoved = true
        }
        translationX += dx
        translationY += dy
        panLastX = x
        panLastY = y
        clampAndApply()
        return true
    }

    fun reset(notifyActive: Boolean = true) {
        scale = MIN_SCALE
        translationX = 0f
        translationY = 0f
        panMoved = false
        panNeedsReanchor = false
        applyTransforms()
        if (notifyActive) {
            host.onZoomActiveChanged(false)
        }
    }

    fun clampAndApply() {
        clampTranslation()
        applyTransforms()
    }

    private fun applyTransforms() {
        val zoomView = host.getZoomView() ?: return
        zoomView.pivotX = 0f
        zoomView.pivotY = 0f
        zoomView.scaleX = scale
        zoomView.scaleY = scale
        zoomView.translationX = translationX
        zoomView.translationY = translationY
        host.onZoomChanged(scale, translationX, translationY)
    }

    private fun clampTranslation() {
        val zoomView = host.getZoomView() ?: run {
            translationX = 0f
            translationY = 0f
            return
        }
        val (viewportW, viewportH) = host.getViewportSize()
        val videoW = zoomView.width
        val videoH = zoomView.height
        if (videoW <= 0 || videoH <= 0 || viewportW <= 0 || viewportH <= 0) {
            translationX = 0f
            translationY = 0f
            return
        }
        val (originX, originY) = host.getZoomViewOriginInViewport()
        translationX = clampedTranslation(
            translation = translationX,
            viewStart = originX,
            viewSize = videoW.toFloat(),
            viewportSize = viewportW.toFloat(),
        )
        translationY = clampedTranslation(
            translation = translationY,
            viewStart = originY,
            viewSize = videoH.toFloat(),
            viewportSize = viewportH.toFloat(),
        )
    }

    private fun scaledTranslation(
        focus: Float,
        viewStart: Float,
        currentTranslation: Float,
        scaleChange: Float,
    ): Float {
        return focus - viewStart - ((focus - viewStart - currentTranslation) * scaleChange)
    }

    private fun clampedTranslation(
        translation: Float,
        viewStart: Float,
        viewSize: Float,
        viewportSize: Float,
    ): Float {
        val scaledSize = viewSize * scale
        return if (scaledSize <= viewportSize) {
            ((viewportSize - scaledSize) / 2f) - viewStart
        } else {
            translation.coerceIn(viewportSize - viewStart - scaledSize, -viewStart)
        }
    }

    companion object {
        const val MIN_SCALE = 1f
        const val MAX_SCALE = 8f
        private const val EPSILON = 0.01f
        private const val SCALE_DEADZONE_RATIO = 0.025f
        private const val RESET_TOLERANCE = 0.03f
        private const val TWO_FINGER_PAN_MULTIPLIER = 1.25f
        /** Ignore per-frame focus jumps larger than this (finger-up midpoint → single finger). */
        private const val MAX_FOCUS_STEP_PX = 96f
    }
}
