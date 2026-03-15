package com.github.andreyasadchy.xtra.util.chat

import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import kotlin.math.roundToInt

object ChatBackgroundUtils {
    const val DEFAULT_ALTERNATING_LINE_SHADOW_STRENGTH = 3
    const val MAX_ALTERNATING_LINE_SHADOW_STRENGTH = 10
    private const val DARK_SURFACE_LUMINANCE_THRESHOLD = 0.35
    private const val MAX_LIGHT_ROW_TINT_ALPHA = 0.06f
    private const val MAX_DARK_ROW_TINT_ALPHA = 0.10f
    private const val MAX_LIGHT_DIVIDER_ALPHA = 0.16f
    private const val MAX_DARK_DIVIDER_ALPHA = 0.28f

    @ColorInt
    fun resolveMessageBackgroundColor(
        @ColorInt surfaceColor: Int,
        @ColorInt overlayColor: Int?,
        alternatingLineShadowEnabled: Boolean,
        alternatingLineShadowStrength: Int,
        position: Int,
    ): Int {
        val highlightedColor = overlayColor?.let { ColorUtils.compositeColors(it, surfaceColor) } ?: surfaceColor
        if (!alternatingLineShadowEnabled || position % 2 == 0) {
            return highlightedColor
        }
        val strengthFraction = alternatingLineShadowStrength.coerceIn(0, MAX_ALTERNATING_LINE_SHADOW_STRENGTH).toFloat() / MAX_ALTERNATING_LINE_SHADOW_STRENGTH.toFloat()
        if (strengthFraction <= 0f) {
            return highlightedColor
        }
        val luminance = ColorUtils.calculateLuminance(highlightedColor)
        val tintBaseColor = if (luminance < DARK_SURFACE_LUMINANCE_THRESHOLD) {
            android.graphics.Color.WHITE
        } else {
            android.graphics.Color.BLACK
        }
        val maxAlpha = if (luminance < DARK_SURFACE_LUMINANCE_THRESHOLD) {
            MAX_DARK_ROW_TINT_ALPHA
        } else {
            MAX_LIGHT_ROW_TINT_ALPHA
        }
        val tintAlpha = (strengthFraction * maxAlpha * 255f).roundToInt().coerceIn(0, 255)
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(tintBaseColor, tintAlpha), highlightedColor)
    }

    @ColorInt
    fun resolveDividerColor(
        @ColorInt surfaceColor: Int,
        dividerStrength: Int,
    ): Int {
        val strengthFraction = dividerStrength.coerceIn(0, MAX_ALTERNATING_LINE_SHADOW_STRENGTH).toFloat() / MAX_ALTERNATING_LINE_SHADOW_STRENGTH.toFloat()
        if (strengthFraction <= 0f) {
            return ColorUtils.setAlphaComponent(surfaceColor, 0)
        }
        val luminance = ColorUtils.calculateLuminance(surfaceColor)
        val dividerBaseColor = if (luminance < DARK_SURFACE_LUMINANCE_THRESHOLD) {
            android.graphics.Color.WHITE
        } else {
            android.graphics.Color.BLACK
        }
        val maxAlpha = if (luminance < DARK_SURFACE_LUMINANCE_THRESHOLD) {
            MAX_DARK_DIVIDER_ALPHA
        } else {
            MAX_LIGHT_DIVIDER_ALPHA
        }
        val alpha = (strengthFraction * maxAlpha * 255f).roundToInt().coerceIn(0, 255)
        return ColorUtils.setAlphaComponent(dividerBaseColor, alpha)
    }
}
