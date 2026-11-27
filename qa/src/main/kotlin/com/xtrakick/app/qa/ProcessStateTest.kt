package com.xtrakick.app.qa

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProcessStateTest {
    private val app = TestApp()

    @get:Rule
    val screenshot = failureScreenshot(app)

    @Test
    fun verifyOnboardingAfterProcessRestart() {
        if (!app.device.hasObject(app.id("navBar"))) app.launchHome(resetTask = false)
        app.openAdvancedSettings()
        app.openUpdateSettings()
        app.requireBrowserUpdatesEnabled()
    }
}
