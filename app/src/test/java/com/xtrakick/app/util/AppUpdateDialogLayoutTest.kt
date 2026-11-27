package com.xtrakick.app.util

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.xtrakick.app.R
import com.xtrakick.app.model.AppUpdateInfo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class, qualifiers = "w411dp-h915dp-xxhdpi")
class AppUpdateDialogLayoutTest {

    private fun mediumNotes(): String = """
        - Improve in-app updates and VOD thumbnails
        - Improve reliability of in-app update downloads and automatic update checks.
        - Improve VOD thumbnail loading so videos show their own thumbnails instead of a single placeholder.
    """.trimIndent()

    private fun longNotes(): String =
        (1..20).joinToString("\n") { "- Release note entry number $it with extra details" }

    private fun bottomRelativeToAncestor(view: View, ancestor: View): Int {
        var bottom = view.bottom
        var current = view.parent
        while (current is View && current !== ancestor) {
            bottom += current.top
            current = current.parent
        }
        return bottom
    }

    private fun measureDialogUsingRealWindowWidth(
        activity: AppCompatActivity,
        notes: String,
        themeRes: Int,
        material3Enabled: Boolean = true,
        releaseTitle: String = "Latest",
        maxViewportHeightPx: Int,
        expectScrollableChangelog: Boolean = false,
    ) {
        activity.prefs().edit().putBoolean(AppConstants.UI_THEME_MATERIAL3, material3Enabled).commit()
        activity.setTheme(themeRes)

        val info = AppUpdateInfo(
            downloadUrl = "https://example.test/app.apk",
            size = 14_000_000L,
            updatedAt = 1_700_000_000_000L,
            releaseTitle = releaseTitle,
            releaseNotes = notes,
        )

        val dialog = AppUpdateDialogHelper.showUpdateDialog(
            context = activity,
            updateInfo = info,
            onUpdate = {},
            onRemindLater = {},
            onSkip = {},
        )

        val window = dialog.window!!
        val windowBg = window.decorView.background as? ColorDrawable
        assertEquals(Color.TRANSPARENT, windowBg?.color)
        assertNull(dialog.findViewById<View>(androidx.appcompat.R.id.parentPanel)?.background)
        assertNull(dialog.findViewById<View>(androidx.appcompat.R.id.customPanel)?.background)
        assertNull(dialog.findViewById<View>(android.R.id.custom)?.background)

        val density = activity.resources.displayMetrics.density
        val dialogWidthPx = window.attributes.width
        assertTrue(
            "Expected explicit positive dialog window width, got $dialogWidthPx",
            dialogWidthPx > 0 && dialogWidthPx <= (440 * density).toInt(),
        )

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val decor = window.decorView
        val wSpec = View.MeasureSpec.makeMeasureSpec(dialogWidthPx, View.MeasureSpec.EXACTLY)
        val hSpec = View.MeasureSpec.makeMeasureSpec(maxViewportHeightPx, View.MeasureSpec.AT_MOST)
        decor.measure(wSpec, hSpec)
        decor.layout(0, 0, decor.measuredWidth, decor.measuredHeight)

        val contentLayout = dialog.findViewById<UpdateDialogContentLayout>(R.id.dialogContentLayout)!!
        val changelogScroll = dialog.findViewById<View>(R.id.changelogScrollView)!!
        val changelogText = dialog.findViewById<View>(R.id.changelogText)!!
        val buttonsLayout = dialog.findViewById<View>(R.id.buttonsLayout)!!
        val updateBtn = dialog.findViewById<View>(R.id.updateButton)!!
        val skipBtn = dialog.findViewById<View>(R.id.skipButton)!!
        val remindBtn = dialog.findViewById<View>(R.id.remindLaterButton)!!

        val buttonsBottomInDecor = bottomRelativeToAncestor(buttonsLayout, decor)
        assertTrue(
            "Dialog height (${decor.height}) exceeded usable viewport ($maxViewportHeightPx)",
            decor.height <= maxViewportHeightPx,
        )
        assertTrue(
            "buttonsLayout bottom ($buttonsBottomInDecor) clipped past decor height (${decor.height})",
            buttonsBottomInDecor <= decor.height - contentLayout.paddingBottom,
        )
        assertEquals(View.VISIBLE, updateBtn.visibility)
        assertEquals(View.VISIBLE, skipBtn.visibility)
        assertEquals(View.VISIBLE, remindBtn.visibility)
        assertTrue("updateButton height=${updateBtn.height}", updateBtn.height > 0)
        assertTrue("skipButton height=${skipBtn.height}", skipBtn.height > 0)
        assertTrue("remindLaterButton height=${remindBtn.height}", remindBtn.height > 0)
        if (expectScrollableChangelog) {
            assertTrue(
                "Long changelog should scroll inside bounded viewport: text=${changelogText.height}, scroll=${changelogScroll.height}",
                changelogText.height > changelogScroll.height,
            )
        }

        dialog.dismiss()
    }

    @Test
    fun updateDialogFitsAllButtonsInPortraitAcrossM3AndLegacyAppCompatThemes() {
        val activity = Robolectric.buildActivity(AppCompatActivity::class.java)
            .create()
            .start()
            .resume()
            .get()
        val density = activity.resources.displayMetrics.density
        val usablePortraitHeightPx = (850 * density).toInt()

        measureDialogUsingRealWindowWidth(
            activity = activity,
            notes = mediumNotes(),
            themeRes = R.style.BaseAmoledTheme,
            maxViewportHeightPx = usablePortraitHeightPx,
        )
        measureDialogUsingRealWindowWidth(
            activity = activity,
            notes = longNotes(),
            themeRes = R.style.BaseDarkTheme,
            maxViewportHeightPx = usablePortraitHeightPx,
            expectScrollableChangelog = true,
        )

        val legacyThemes = listOf(
            R.style.AppCompatDarkTheme,
            R.style.AppCompatLightTheme,
            R.style.AppCompatAmoledTheme,
            R.style.AppCompatBlueTheme,
        )
        for (themeRes in legacyThemes) {
            measureDialogUsingRealWindowWidth(
                activity = activity,
                notes = mediumNotes(),
                themeRes = themeRes,
                material3Enabled = false,
                maxViewportHeightPx = usablePortraitHeightPx,
            )
        }
    }

    @Test
    @Config(qualifiers = "w800dp-h276dp-land-xxhdpi")
    fun updateDialogFitsAllButtonsInTightLandscapeWith3ButtonNavLongNotesAndLargeFont() {
        val activity = Robolectric.buildActivity(AppCompatActivity::class.java)
            .create()
            .start()
            .resume()
            .get()
        val density = activity.resources.displayMetrics.density

        // 276dp simulates a 360dp landscape phone after subtracting 84dp 3-button nav + status bar.
        val tightLandscapeHeightPx = (276 * density).toInt()
        measureDialogUsingRealWindowWidth(
            activity = activity,
            notes = longNotes(),
            themeRes = R.style.BaseAmoledTheme,
            maxViewportHeightPx = tightLandscapeHeightPx,
            expectScrollableChangelog = true,
        )

        // Large accessibility font scale (1.5x) + 2-line release title on a 312dp usable landscape screen.
        RuntimeEnvironment.setQualifiers("w800dp-h312dp-land-xxhdpi")
        activity.resources.configuration.fontScale = 1.5f
        @Suppress("DEPRECATION")
        activity.resources.displayMetrics.scaledDensity = density * 1.5f
        measureDialogUsingRealWindowWidth(
            activity = activity,
            notes = longNotes(),
            themeRes = R.style.BaseAmoledTheme,
            releaseTitle = "v2.55.0 — Watch Time, Chat & Landscape Update Fixes",
            maxViewportHeightPx = (312 * density).toInt(),
            expectScrollableChangelog = true,
        )
    }

    @Test
    @Config(qualifiers = "w800dp-h360dp-land-xxhdpi")
    fun hostResizeRecomputesLandscapeAndPortraitMetricsOnLargeScreens() {
        val activity = Robolectric.buildActivity(AppCompatActivity::class.java)
            .create()
            .start()
            .resume()
            .get()
        val density = activity.resources.displayMetrics.density
        val hostDecor = activity.window.decorView
        hostDecor.layout(0, 0, (800 * density).toInt(), (360 * density).toInt())

        val dialog = AppUpdateDialogHelper.showUpdateDialog(
            context = activity,
            updateInfo = AppUpdateInfo(
                downloadUrl = "https://example.test/app.apk",
                size = 14_000_000L,
                updatedAt = 1_700_000_000_000L,
                releaseTitle = "Latest",
                releaseNotes = longNotes(),
            ),
            onUpdate = {},
            onRemindLater = {},
            onSkip = {},
        )

        val contentLayout = dialog.findViewById<UpdateDialogContentLayout>(R.id.dialogContentLayout)!!
        val landscapePaddingTop = contentLayout.paddingTop
        val landscapeMaxHeight = contentLayout.maxDialogHeightPx
        assertEquals((440 * density).toInt(), dialog.window!!.attributes.width)

        // Rotate to a >=440dp wide portrait screen (e.g. tablet/foldable 500x900dp).
        RuntimeEnvironment.setQualifiers("w500dp-h900dp-port-xxhdpi")
        hostDecor.layout(0, 0, (500 * density).toInt(), (900 * density).toInt())
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        assertTrue(
            "Portrait paddingTop (${contentLayout.paddingTop}) should expand beyond landscape ($landscapePaddingTop)",
            contentLayout.paddingTop > landscapePaddingTop,
        )
        assertTrue(
            "Portrait maxDialogHeightPx (${contentLayout.maxDialogHeightPx}) should expand beyond landscape ($landscapeMaxHeight)",
            contentLayout.maxDialogHeightPx > landscapeMaxHeight,
        )
        assertEquals((440 * density).toInt(), dialog.window!!.attributes.width)

        dialog.dismiss()
    }

    @Test
    fun lifecycleTeardownDismissDoesNotConsumePendingUpdateAcrossAsyncLooperDispatch() {
        val activity = Robolectric.buildActivity(AppCompatActivity::class.java)
            .create()
            .start()
            .resume()
            .get()
        val info = AppUpdateInfo(
            downloadUrl = "https://example.test/app.apk",
            size = 14_000_000L,
            updatedAt = 1_700_000_000_000L,
            releaseTitle = "Latest",
            releaseNotes = mediumNotes(),
        )

        var trackedDialog: AlertDialog? = null
        var dismissCallbacks = 0
        var consumedCount = 0

        trackedDialog = AppUpdateDialogHelper.showUpdateDialog(
            context = activity,
            updateInfo = info,
            onUpdate = {},
            onRemindLater = {},
            onSkip = {},
            onDismiss = { dismissed ->
                dismissCallbacks++
                if (trackedDialog === dismissed) {
                    trackedDialog = null
                    consumedCount++
                }
            },
        )

        // Simulate Activity.onDestroy / Fragment.onDestroyView clearing the reference before dismiss().
        val rotatingDialog = trackedDialog
        trackedDialog = null
        rotatingDialog?.dismiss()

        // Android posts Dialog.OnDismissListener asynchronously via Handler; drain the Looper to verify
        // that lifecycle teardown does not consume the pending update even after async delivery.
        assertEquals(0, dismissCallbacks)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(1, dismissCallbacks)
        assertEquals(0, consumedCount)

        // Now show again after recreation and verify a user-driven dismissal consumes it.
        trackedDialog = AppUpdateDialogHelper.showUpdateDialog(
            context = activity,
            updateInfo = info,
            onUpdate = {},
            onRemindLater = {},
            onSkip = {},
            onDismiss = { dismissed ->
                dismissCallbacks++
                if (trackedDialog === dismissed) {
                    trackedDialog = null
                    consumedCount++
                }
            },
        )

        trackedDialog!!.findViewById<View>(R.id.remindLaterButton)!!.performClick()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(2, dismissCallbacks)
        assertEquals(1, consumedCount)
        assertNull(trackedDialog)
    }
}
