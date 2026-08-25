package com.xtrakick.app.util.chat

import androidx.core.graphics.ColorUtils
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.roundToInt

// These cases compute their expected values with androidx ColorUtils, which delegates to
// android.graphics.Color. That class has no implementation on a plain JVM, so the test needs
// Robolectric to supply the framework.
// sdk pinned because Robolectric 4.14.1 supports up to API 35 while targetSdk is 36.
// These are pure colour-maths assertions, so the API level is irrelevant to what they check.
// application pinned to the stock Application: Robolectric would otherwise boot KickApp,
// which initialises Conscrypt and fails with UnsatisfiedLinkError on the JVM. Nothing here
// needs the real Application.
@Config(sdk = [35], application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
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
        // A light surface uses MAX_LIGHT_ROW_TINT_ALPHA (0.06) -> alpha 15, not the 0.10 used
        // for dark surfaces. This expectation predated that light/dark split and still asserted
        // 0x1A (26 ~ 0.10); the sibling clamp test passes because it uses a dark surface.
        val expectedAlpha = (0.06f * 255f).roundToInt()
        val expected = ColorUtils.compositeColors(
            ColorUtils.setAlphaComponent(android.graphics.Color.BLACK, expectedAlpha),
            surfaceColor,
        )

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
