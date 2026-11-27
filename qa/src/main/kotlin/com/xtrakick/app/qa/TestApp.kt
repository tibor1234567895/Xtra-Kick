package com.xtrakick.app.qa

import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.Condition
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import java.util.regex.Pattern
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse

internal class TestApp {
    val instrumentation = InstrumentationRegistry.getInstrumentation()
    val context = instrumentation.context.createPackageContext(APP_PACKAGE, 0)
    val device = UiDevice.getInstance(instrumentation).apply { setCompressedLayoutHierarchy(false) }

    fun id(name: String): BySelector = By.res(Pattern.compile("[^:]+:id/${Pattern.quote(name)}")).pkg(context.packageName)

    fun string(name: String): String {
        val resources = context.resources
        val resourceId = resources.getIdentifier(name, "string", context.packageName)
            .takeIf { it != 0 } ?: resources.getIdentifier(name, "string", "com.xtrakick.app")
        check(resourceId != 0) { "App string is missing: $name" }
        return resources.getString(resourceId)
    }

    fun label(name: String): BySelector = By.text(string(name)).pkg(context.packageName)

    fun requireObject(selector: BySelector): UiObject2 =
        checkNotNull(device.wait(Until.findObject(selector), UI_TIMEOUT_MS)) { "Missing UI element: $selector" }

    fun await(message: String, condition: () -> Boolean) {
        check(device.wait(Condition<UiDevice, Boolean> { condition() }, UI_TIMEOUT_MS) == true) { message }
    }

    fun requireOffline() {
        assertEquals("The runner must isolate guest networking", "true", argument("expectedOffline"))
        val connectivity = checkNotNull(instrumentation.context.getSystemService(ConnectivityManager::class.java))
        val network = connectivity.getNetworkCapabilities(connectivity.activeNetwork)
        assertFalse("The emulator still has an active internet network", network?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true)
    }

    fun launchHome(resetTask: Boolean = true) {
        val activity = checkNotNull(context.packageManager.getLaunchIntentForPackage(APP_PACKAGE)?.component) {
            "No launcher activity for $APP_PACKAGE"
        }
        val flags = if (resetTask) "0x10008000" else "0x10000000"
        val result = device.executeShellCommand("am start -W -a android.intent.action.MAIN -c android.intent.category.LAUNCHER -f $flags -n ${activity.flattenToShortString()}")
        check(result.lineSequence().any { it.trim() == "Status: ok" }) { "Launcher failed: $result" }
    }

    fun continueAsGuest() {
        val welcomeTitle = label("welcome_title")
        val guest = id("btnContinueGuest")
        requireObject(welcomeTitle)
        val safeBottom = device.displayHeight - (device.displayHeight / 10)
        var button = device.findObject(guest)?.takeIf {
            it.visibleBounds.height() > 0 && it.visibleBounds.bottom <= safeBottom
        }
        repeat(5) {
            if (button != null) return@repeat
            val x = device.displayWidth / 2
            device.swipe(x, (device.displayHeight * 3) / 4, x, device.displayHeight / 4, 12)
            device.waitForIdle(2_000L)
            button = device.findObject(guest)?.takeIf {
                it.visibleBounds.height() > 0 && it.visibleBounds.bottom <= safeBottom
            }
        }
        val target = checkNotNull(button ?: device.findObject(guest)) {
            "The welcome dialog does not expose its Continue as Guest button"
        }
        target.click()
        check(device.wait(Until.gone(welcomeTitle), UI_TIMEOUT_MS) == true) { "The welcome dialog did not close" }
    }

    fun openOverflow() {
        requireObject(By.desc("More options").pkg(context.packageName)).click()
    }

    fun openSettings() {
        requireObject(id("navBar"))
        openOverflow()
        requireObject(label("settings")).click()
        requireSettingsScreen("settings")
        requirePreference("appearance")
    }

    fun openDownloads() {
        requireObject(id("savedPagerFragment")).click()
        requireObject(label("downloads").hasAncestor(id("tabLayout"))).click()
    }

    fun openAdvancedSettings() {
        openSettings()
        requirePreference("system_and_advanced").click()
        requireSettingsScreen("advanced")
    }

    fun openUpdateSettings() {
        requirePreference("update_settings").click()
        requireSettingsScreen("update_settings")
        requirePreference("auto_check_updates")
    }

    fun requireSettingsScreen(name: String) {
        requireObject(label(name).hasAncestor(id("toolbar")))
    }

    fun requirePreference(name: String): UiObject2 {
        val selector = By.res("android", "title").text(string(name)).hasAncestor(id("recycler_view"))
        device.wait(Until.findObject(selector), 2_000L)?.let { return it }
        val list = requireObject(id("recycler_view").scrollable(true))
        return checkNotNull(list.scrollUntil(Direction.DOWN, Until.findObject(selector))) {
            "Missing preference: $name"
        }
    }

    fun permissionGranted(permission: String): Boolean =
        context.packageManager.checkPermission(permission, APP_PACKAGE) == PackageManager.PERMISSION_GRANTED

    private fun browserUpdateSwitch(checked: Boolean): BySelector {
        val title = By.res("android", "title").text(string("update_using_browser"))
        val row = By.hasChild(By.res("android", "widget_frame")).hasDescendant(title)
        return By.checkable(true).checked(checked).hasAncestor(row)
    }

    fun enableBrowserUpdates() {
        requirePreference("update_using_browser")
        requireObject(browserUpdateSwitch(checked = false)).click()
        requireBrowserUpdatesEnabled()
    }

    fun requireBrowserUpdatesEnabled() {
        requirePreference("update_using_browser")
        requireObject(browserUpdateSwitch(checked = true))
    }

    @Suppress("DEPRECATION")
    fun versionCode(): Long {
        val info = context.packageManager.getPackageInfo(context.packageName, 0)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) info.longVersionCode else info.versionCode.toLong()
    }

    companion object {
        const val APP_PACKAGE = "com.github.andreyasadchy.xtrakick.test"
        const val UI_TIMEOUT_MS = 15_000L

        fun argument(name: String): String? = InstrumentationRegistry.getArguments().getString(name)
    }
}
