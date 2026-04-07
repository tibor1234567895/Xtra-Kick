package com.github.andreyasadchy.xtra.util.chat

import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import kotlin.math.roundToInt

object ChatBackgroundUtils {
    data class DividerColors(
        @ColorInt val highlightColor: Int,
        @ColorInt val shadowColor: Int,
    )

    const val DEFAULT_ALTERNATING_LINE_SHADOW_STRENGTH = 3
    const val MAX_ALTERNATING_LINE_SHADOW_STRENGTH = 10
    private const val DARK_SURFACE_LUMINANCE_THRESHOLD = 0.35
    private const val MAX_LIGHT_ROW_TINT_ALPHA = 0.06f
    private const val MAX_DARK_ROW_TINT_ALPHA = 0.10f
    private const val MAX_LIGHT_DIVIDER_HIGHLIGHT_ALPHA = 0.06f
    private const val MAX_DARK_DIVIDER_HIGHLIGHT_ALPHA = 0.16f
    private const val MAX_LIGHT_DIVIDER_SHADOW_ALPHA = 0.18f
    private const val MAX_DARK_DIVIDER_SHADOW_ALPHA = 0.44f

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
    fun resolveDividerColors(
        @ColorInt surfaceColor: Int,
        dividerStrength: Int,
    ): DividerColors {
        val strengthFraction = dividerStrength.coerceIn(0, MAX_ALTERNATING_LINE_SHADOW_STRENGTH).toFloat() / MAX_ALTERNATING_LINE_SHADOW_STRENGTH.toFloat()
        if (strengthFraction <= 0f) {
            val transparent = ColorUtils.setAlphaComponent(surfaceColor, 0)
            return DividerColors(
                highlightColor = transparent,
                shadowColor = transparent,
            )
        }
        val luminance = ColorUtils.calculateLuminance(surfaceColor)
        val isDarkSurface = luminance < DARK_SURFACE_LUMINANCE_THRESHOLD
        val highlightBaseColor = android.graphics.Color.WHITE
        val shadowBaseColor = android.graphics.Color.BLACK
        val highlightMaxAlpha = if (isDarkSurface) {
            MAX_DARK_DIVIDER_HIGHLIGHT_ALPHA
        } else {
            MAX_LIGHT_DIVIDER_HIGHLIGHT_ALPHA
        }
        val shadowMaxAlpha = if (isDarkSurface) {
            MAX_DARK_DIVIDER_SHADOW_ALPHA
        } else {
            MAX_LIGHT_DIVIDER_SHADOW_ALPHA
        }
        val highlightAlpha = (strengthFraction * highlightMaxAlpha * 255f).roundToInt().coerceIn(0, 255)
        val shadowAlpha = (strengthFraction * shadowMaxAlpha * 255f).roundToInt().coerceIn(0, 255)
        return DividerColors(
            highlightColor = ColorUtils.setAlphaComponent(highlightBaseColor, highlightAlpha),
            shadowColor = ColorUtils.setAlphaComponent(shadowBaseColor, shadowAlpha),
        )
    }
}
