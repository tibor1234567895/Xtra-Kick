package com.xtrakick.app.ui.view

import android.app.Application
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class PlayerLayoutTest {

    @Test
    fun minimizedLandscapeFitsVideoAndChildrenWithoutSideMargins() {
        val player = createPlayer()
        player.isMinimized = true

        measure(player, 2400, 1080)

        assertSize(player, 1920, 1080)
        assertSize(player.getChildAt(0), 1920, 1080)
    }

    @Test
    fun minimizedPlayerKeepsVideoAspectRatioAcrossRotation() {
        val player = createPlayer()
        player.isMinimized = true
        player.isPortrait = true

        measure(player, 1080, 2400)
        assertSize(player, 1080, 607)

        player.isPortrait = false
        measure(player, 2400, 1080)
        assertSize(player, 1920, 1080)

        player.isPortrait = true
        measure(player, 1080, 2400)
        assertSize(player, 1080, 607)
    }

    @Test
    fun maximizingRestoresFullLandscapeBounds() {
        val player = createPlayer()
        player.isMinimized = true
        measure(player, 2400, 1080)

        player.isMinimized = false
        measure(player, 2400, 1080)

        assertSize(player, 2400, 1080)
        assertSize(player.getChildAt(0), 2400, 1080)
    }

    @Test
    fun minimizedPlayerRemeasuresWhenVideoAspectRatioChanges() {
        val player = createPlayer()
        player.isMinimized = true
        measure(player, 2400, 1080)

        player.videoAspectRatio = 4f / 3f
        measure(player, 2400, 1080)

        assertSize(player, 1440, 1080)
        assertSize(player.getChildAt(0), 1440, 1080)
    }

    @Test
    fun invalidVideoAspectRatiosKeepLastValidSize() {
        val player = createPlayer()
        player.isMinimized = true
        player.videoAspectRatio = 0f
        player.videoAspectRatio = Float.NaN
        player.videoAspectRatio = Float.POSITIVE_INFINITY

        measure(player, 2400, 1080)

        assertSize(player, 1920, 1080)
    }

    @Test
    fun maximizedPortraitKeepsExistingWidescreenHeight() {
        val player = createPlayer()
        player.isPortrait = true
        player.videoAspectRatio = 4f / 3f

        measure(player, 1080, 2400)

        assertSize(player, 1080, 607)
    }

    private fun createPlayer(): PlayerLayout {
        val context = RuntimeEnvironment.getApplication()
        return PlayerLayout(context).apply {
            addView(View(context), FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))
        }
    }

    private fun measure(player: PlayerLayout, width: Int, height: Int) {
        player.measure(
            View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        )
    }

    private fun assertSize(view: View, width: Int, height: Int) {
        assertEquals(width, view.measuredWidth)
        assertEquals(height, view.measuredHeight)
    }
}
