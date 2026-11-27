package com.xtrakick.app.qa

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UpgradeStateTest {
    private val app = TestApp()

    @get:Rule
    val screenshot = failureScreenshot(app)

    @Test
    fun seedSettingBeforeUpgrade() {
        assertEquals("Installed previous package version", requireVersionArgument("previousVersionCode"), app.versionCode())
        app.launchHome()
        app.continueAsGuest()
        app.openAdvancedSettings()
        app.openUpdateSettings()
        app.enableBrowserUpdates()
    }

    @Test
    fun verifySettingAfterUpgrade() {
        val previous = requireVersionArgument("previousVersionCode")
        val expected = requireVersionArgument("expectedVersionCode")
        assertTrue("Replacement must be newer than the previous APK", expected > previous)
        assertEquals("Installed package version", expected, app.versionCode())
        app.launchHome()
        app.openAdvancedSettings()
        app.openUpdateSettings()
        app.requireBrowserUpdatesEnabled()
    }

    private fun requireVersionArgument(name: String): Long =
        checkNotNull(TestApp.argument(name)?.toLongOrNull()) { "Missing instrumentation argument: $name" }
}
