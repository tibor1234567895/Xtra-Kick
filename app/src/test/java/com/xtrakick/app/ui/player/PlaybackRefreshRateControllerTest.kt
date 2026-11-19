package com.xtrakick.app.ui.player

import android.app.Activity
import android.app.Application
import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowDisplayManager

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class, sdk = [30])
class PlaybackRefreshRateControllerTest {
    @Test
    fun scrollingOnSingleModeDisplayPreservesTheWindowPreference() {
        val activity = Robolectric.buildActivity(Activity::class.java).setup().get()
        @Suppress("DEPRECATION")
        val display = activity.windowManager.defaultDisplay
        ShadowDisplayManager.setSupportedModes(display.displayId, display.mode)
        val controller = PlaybackRefreshRateController(
            prefs = { activity.getSharedPreferences("player", Context.MODE_PRIVATE) },
        )

        controller.onPlayerActive(activity.window, minimized = false)
        controller.onScrollActivity(activity.window)

        assertEquals(0, activity.window.attributes.preferredDisplayModeId)
    }
}
