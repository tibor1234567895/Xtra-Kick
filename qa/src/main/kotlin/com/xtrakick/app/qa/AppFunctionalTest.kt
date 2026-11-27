package com.xtrakick.app.qa

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.StaleObjectException
import androidx.test.uiautomator.Until
import java.util.regex.Pattern
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppFunctionalTest {
    private val app = TestApp()
    private val documentsUi = Pattern.compile("com\\.(?:android|google\\.android)\\.documentsui")

    @get:Rule
    val screenshot = failureScreenshot(app)

    @Test
    fun importedVideoPlaysOfflineAndSurvivesFullscreenAndPictureInPicture() {
        app.requireOffline()
        app.launchHome()
        app.openDownloads()
        app.requireObject(app.id("nothingHere"))

        openImportPicker()
        app.device.pressBack()
        app.requireObject(app.id("nothingHere"))

        openImportPicker()
        val fixture = By.text("xtrakick-qa-playback.mp4").pkg(documentsUi)
        val document = app.device.findObject(fixture) ?: run {
            clickRetryingStale(By.desc("Show roots").pkg(documentsUi))
            clickRetryingStale(By.text("Downloads").pkg(documentsUi))
            app.requireObject(fixture)
        }
        try {
            document.click()
        } catch (_: StaleObjectException) {
            clickRetryingStale(fixture)
        }

        val importedVideo = app.requireObject(app.id("title").hasAncestor(app.id("recyclerView")))
        importedVideo.click()
        showPlayerControls()
        app.requireObject(app.id("duration").text("00:30").hasAncestor(app.id("playerControls")))
        app.requireObject(app.id("position").text(Pattern.compile("00:(?:0[1-9]|[12][0-9])")))
        app.requireObject(app.id("playPause").desc(app.string("pause"))).click()
        app.requireObject(app.id("playPause").desc(app.string("resume")))

        val fullscreen = app.id("fullscreen").desc(app.string("fullscreen"))
        val exitFullscreen = app.id("fullscreen").desc(app.string("exit_fullscreen"))
        app.requireObject(fullscreen).click()
        app.await("Fullscreen did not rotate the offline player") { app.device.displayWidth > app.device.displayHeight }
        showPlayerControls()
        app.requireObject(exitFullscreen).click()
        app.await("Exiting fullscreen did not restore portrait") { app.device.displayWidth < app.device.displayHeight }

        showPlayerControls()
        app.requireObject(app.id("playPause").desc(app.string("resume"))).click()
        app.requireObject(app.id("playPause").desc(app.string("pause")))
        checkPictureInPicture()
        showPlayerControls()
        // The 30-second fixture may finish playing during PiP on slower emulators, switching Pause to Resume/Replay.
        app.requireObject(app.id("playPause"))
    }

    private fun openImportPicker() {
        app.openOverflow()
        app.requireObject(app.label("import_files")).click()
        app.requireObject(By.pkg(documentsUi).depth(0))
    }

    private fun clickRetryingStale(selector: BySelector) {
        repeat(3) { attempt ->
            try {
                app.requireObject(selector).click()
                return
            } catch (error: StaleObjectException) {
                if (attempt == 2) throw error
                app.device.waitForIdle(1_000L)
            }
        }
    }

    private fun showPlayerControls() {
        val playPause = app.id("playPause")
        // Opening, rotating, or leaving PiP can auto-show/fade controls right as a single tap arrives;
        // retry tapping the gesture surface until the controls settle visibly on screen.
        repeat(4) {
            app.dismissSystemDialogs()
            app.device.findObject(By.res("android", "ok").text("GOT IT"))?.click()
                ?: app.device.findObject(By.text("GOT IT"))?.click()
            if (app.device.wait(Until.hasObject(playPause), 1_500L) == true) return
            val video = app.requireObject(app.id("dragView"))
            val bounds = video.visibleBounds
            // Tap the video gesture surface away from the central play/pause button.
            app.device.click(bounds.centerX(), bounds.top + bounds.height() / 4)
            if (app.device.wait(Until.hasObject(playPause), 2_000L) == true) return
        }
        app.requireObject(playPause)
    }

    private fun checkPictureInPicture() {
        if (!app.context.packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            app.instrumentation.sendStatus(2, Bundle().apply {
                putString("stream", "PiP check unsupported on this system image\n")
            })
            return
        }

        app.device.pressHome()
        app.await("The offline player did not enter picture-in-picture") { hasPinnedActivity() }
        app.launchHome(resetTask = false)
        app.requireObject(app.id("playerLayout"))
        app.await("The offline player did not leave picture-in-picture") { !hasPinnedActivity() }
    }

    private fun hasPinnedActivity(): Boolean {
        // Android 8 calls the pinned root "Stack #4:"; later releases report mode=pinned / PinnedStack.
        val pinnedHeader = Regex("(?:\\bStack #4:|(?:windowing)?mode=pinned\\b|\\bPinnedStack\\b)", RegexOption.IGNORE_CASE)
        val sectionBoundary = Regex("^\\s*(?:Display #|Stack #|RootTask #|TaskDisplayArea\\b)")
        val component = "${TestApp.APP_PACKAGE}/"
        val tasks = app.device.executeShellCommand("dumpsys activity activities")
        var inPinnedSection = false
        var pinnedIndent = Int.MAX_VALUE
        for (line in tasks.lineSequence()) {
            val indent = line.indexOfFirst { !it.isWhitespace() }.let { if (it < 0) Int.MAX_VALUE else it }
            if (pinnedHeader.containsMatchIn(line)) {
                inPinnedSection = true
                pinnedIndent = indent
            } else if (inPinnedSection && indent <= pinnedIndent && sectionBoundary.containsMatchIn(line)) {
                inPinnedSection = false
            }
            if (inPinnedSection && component in line) return true
        }
        return false
    }
}
