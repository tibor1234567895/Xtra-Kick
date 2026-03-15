package com.github.andreyasadchy.xtra.util.chat

import androidx.core.graphics.ColorUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class ChatBackgroundUtilsTest {

    @Test
    fun alternatingShadowOnlyAppliesToOddRows() {
        val surfaceColor = 0xFF202020.toInt()

        assertEquals(
            surfaceColor,
            ChatBackgroundUtils.resolveMessageBackgroundColor(
                surfaceColor = surfaceColor,
                overlayColor = null,
                alternatingLineShadowEnabled = true,
                alternatingLineShadowStrength = 3,
                position = 0,
            )
        )
    }

    @Test
    fun alternatingShadowStacksOnTopOfMessageHighlight() {
        val surfaceColor = 0xFF202020.toInt()
        val overlayColor = 0x80680E0E.toInt()
        val highlighted = ColorUtils.compositeColors(overlayColor, surfaceColor)
        val expected = ColorUtils.compositeColors(0x1AFFFFFF, highlighted)

        assertEquals(
            expected,
            ChatBackgroundUtils.resolveMessageBackgroundColor(
                surfaceColor = surfaceColor,
                overlayColor = overlayColor,
                alternatingLineShadowEnabled = true,
                alternatingLineShadowStrength = 10,
                position = 1,
            )
        )
    }

    @Test
    fun alternatingShadowDarkensLightRows() {
        val surfaceColor = 0xFFF0F0F0.toInt()
        val expected = ColorUtils.compositeColors(0x1A000000, surfaceColor)

        assertEquals(
            expected,
            ChatBackgroundUtils.resolveMessageBackgroundColor(
                surfaceColor = surfaceColor,
                overlayColor = null,
                alternatingLineShadowEnabled = true,
                alternatingLineShadowStrength = 10,
                position = 1,
            )
        )
    }

    @Test
    fun alternatingShadowClampsLegacyValuesToNewRange() {
        val surfaceColor = 0xFF202020.toInt()
        val clamped = ChatBackgroundUtils.resolveMessageBackgroundColor(
            surfaceColor = surfaceColor,
            overlayColor = null,
            alternatingLineShadowEnabled = true,
            alternatingLineShadowStrength = 10,
            position = 1,
        )

        assertEquals(
            clamped,
            ChatBackgroundUtils.resolveMessageBackgroundColor(
                surfaceColor = surfaceColor,
                overlayColor = null,
                alternatingLineShadowEnabled = true,
                alternatingLineShadowStrength = 40,
                position = 1,
            )
        )
    }
}
