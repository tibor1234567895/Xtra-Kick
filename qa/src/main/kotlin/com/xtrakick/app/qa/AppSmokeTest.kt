package com.xtrakick.app.qa

import android.Manifest
import android.view.accessibility.AccessibilityEvent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import java.util.regex.Pattern
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AppSmokeTest {
    private val app = TestApp()

    @get:Rule
    val screenshot = failureScreenshot(app)

    @Before
    fun requireIsolatedEmulatorNetwork() {
        app.requireOffline()
    }

    @Test
    fun coldLaunchSupportsContinuingAsGuest() {
        // The remaining tests start with the onboarding choice made in this fresh install.
        app.launchHome()
        app.continueAsGuest()
        app.requireObject(app.id("rootTopFragment").selected(true))
    }

    @Test
    fun downloadsRemainUsableAfterBackgroundAndRotationWhileOffline() {
        app.launchHome()
        app.openDownloads()
        val downloads = app.label("downloads").hasAncestor(app.id("tabLayout"))
        app.requireObject(downloads)
        app.requireObject(app.id("nothingHere").text(app.string("nothing_here")))

        app.device.pressHome()
        assertTrue("Home did not background the app", app.device.wait(Until.gone(app.id("navBar")), TestApp.UI_TIMEOUT_MS))
        app.launchHome(resetTask = false)
        app.requireObject(downloads)
        app.requireObject(app.id("nothingHere"))

        try {
            app.device.setOrientationLandscape()
            app.await("The emulator did not rotate to landscape") { app.device.displayWidth > app.device.displayHeight }
            app.requireObject(downloads).click()
            app.requireObject(app.label("downloads").hasAncestor(app.id("tabLayout")).selected(true))
        } finally {
            try {
                app.device.setOrientationPortrait()
            } finally {
                app.device.unfreezeRotation()
            }
        }
        app.await("The emulator did not return to portrait") { app.device.displayWidth < app.device.displayHeight }
        app.requireObject(app.id("nothingHere"))
    }

    @Test
    @SdkSuppress(minSdkVersion = 33)
    fun notificationDenialKeepsSettingsResponsive() {
        assertFalse(app.permissionGranted(Manifest.permission.POST_NOTIFICATIONS))
        app.launchHome()
        app.openSettings()
        app.requirePreference("notifications_and_rewards").click()
        app.requireSettingsScreen("notifications_and_rewards")
        app.requirePreference("live_notifications").click()

        val denyButton = By.res(Pattern.compile("com\\.(?:android|google\\.android)\\.permissioncontroller:id/permission_deny_button"))
        app.requireObject(denyButton).click()
        assertTrue(app.device.wait(Until.gone(denyButton), TestApp.UI_TIMEOUT_MS))
        assertFalse(app.permissionGranted(Manifest.permission.POST_NOTIFICATIONS))
        app.device.wait(Until.findObject(app.label("battery_optimization_later")), 2_000L)?.click()
        app.requirePreference("live_notifications")
        app.device.pressBack()
        app.requireSettingsScreen("settings")
        app.requirePreference("notifications_and_rewards")
    }

    @Test
    fun searchQueryCanBeEnteredAndClearedFromCategories() {
        app.launchHome()
        app.requireObject(app.id("rootGamesFragment")).click()
        app.requireObject(app.id("rootGamesFragment").selected(true))
        app.requireObject(app.id("search")).click()

        val query = "qa offline channel"
        app.requireObject(app.id("search_src_text")).text = query
        app.requireObject(app.id("search_src_text").text(query))
        app.requireObject(app.id("search_close_btn")).click()
        assertTrue(app.device.wait(Until.gone(app.id("search_src_text").text(query)), TestApp.UI_TIMEOUT_MS))
        app.requireObject(app.id("search_src_text"))
    }

    @Test
    @Suppress("DEPRECATION")
    fun settingsPersistAndUpdateCheckReportsOfflineFailure() {
        app.launchHome()
        app.openAdvancedSettings()
        val check = app.requirePreference("check_updates")
        val failureMessage = app.string("update_check_failed")
        val toast = app.instrumentation.uiAutomation.executeAndWaitForEvent(
            { check.click() },
            { event ->
                event.eventType == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED &&
                    event.packageName?.toString() == app.context.packageName &&
                    event.text.any { it.toString() == failureMessage }
            },
            TestApp.UI_TIMEOUT_MS,
        )
        toast.recycle()

        app.openUpdateSettings()
        app.enableBrowserUpdates()

        app.launchHome()
        app.openAdvancedSettings()
        app.openUpdateSettings()
        app.requireBrowserUpdatesEnabled()
    }
}
