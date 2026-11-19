package com.xtrakick.app.ui.player

import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.Display
import android.view.Window
import com.xtrakick.app.util.AppConstants

/**
 * Caps the display refresh rate while the player screen is active: video and
 * the audio-only screen redraw little, and panel scan power scales with
 * refresh rate (90/120 Hz panels). Users who want the full panel rate —
 * e.g. chat-first scrollers — opt out via PLAYER_HIGH_REFRESH_RATE; with the
 * cap active the panel briefly returns to its native rate while the chat list
 * is being scrolled, then drops back to the cap after a short idle hold.
 */
class PlaybackRefreshRateController(
    private val prefs: () -> SharedPreferences,
    private val handler: Handler = Handler(Looper.getMainLooper()),
) {
    private var activeWindow: Window? = null
    private var originalModeId: Int = UNSET
    private var boostUntilMs: Long = 0L

    private val reapplyRunnable = Runnable {
        activeWindow?.let { onPlayerActive(it, minimized = false) }
    }

    /**
     * Applies the cap (or the boost if one is still holding) for the player window.
     * A docked mini player releases the cap: the panel is mostly browsed content
     * and scrolling it needs the native rate, same tradeoff as the chat boost.
     */
    fun onPlayerActive(window: Window, minimized: Boolean) {
        activeWindow = window
        boostUntilMs = 0L
        handler.removeCallbacks(reapplyRunnable)
        if (minimized) {
            restore(window)
        } else {
            applyForCurrentState(window)
        }
    }

    /** Called while the user scrolls in-window content: boost to the panel's native rate. */
    fun onScrollActivity(window: Window) {
        if (highRefreshPreferred() || capMode(window) == null) return
        activeWindow = window
        boostUntilMs = SystemClock.uptimeMillis() + BOOST_HOLD_MS
        ensureOriginal(window)
        applyMode(window, maxMode(window)?.modeId ?: return)
        handler.removeCallbacks(reapplyRunnable)
        handler.postDelayed(reapplyRunnable, BOOST_HOLD_MS + REAPPLY_SLACK_MS)
    }

    /** Restores the mode the app found when the player screen closes. */
    fun onPlayerInactive(window: Window) {
        if (activeWindow === window) activeWindow = null
        handler.removeCallbacks(reapplyRunnable)
        boostUntilMs = 0L
        restore(window)
    }

    private fun applyForCurrentState(window: Window) {
        if (highRefreshPreferred()) {
            restore(window)
            return
        }
        ensureOriginal(window)
        val boosted = SystemClock.uptimeMillis() < boostUntilMs
        val target = if (boosted) {
            maxMode(window)
        } else {
            capMode(window)
        }
        if (target == null) restore(window) else applyMode(window, target.modeId)
    }

    private fun highRefreshPreferred(): Boolean =
        prefs().getBoolean(AppConstants.PLAYER_HIGH_REFRESH_RATE, false)

    private fun ensureOriginal(window: Window) {
        if (originalModeId == UNSET) originalModeId = window.attributes.preferredDisplayModeId
    }

    private fun restore(window: Window) {
        ensureOriginal(window)
        applyMode(window, originalModeId)
    }

    private fun applyMode(window: Window, modeId: Int) {
        if (window.attributes.preferredDisplayModeId == modeId) return
        window.attributes = window.attributes.apply { preferredDisplayModeId = modeId }
    }

    private fun supportedModes(window: Window): List<Display.Mode>? {
        @Suppress("DEPRECATION")
        val display = window.decorView.display ?: window.windowManager.defaultDisplay
        val modes = display?.supportedModes?.filter { it.refreshRate > 0f && it.modeId != 0 }
        val current = display?.mode ?: return modes
        // Panels can expose mixed-resolution modes (e.g. FHD/QHD variants): only
        // consider modes matching the active resolution so the cap never switches it.
        return modes?.filter {
            it.physicalWidth == current.physicalWidth && it.physicalHeight == current.physicalHeight
        }
    }

    /** Lowest non-native refresh rate (≈60 Hz) that is still above the video rate. */
    private fun capMode(window: Window): Display.Mode? {
        val modes = supportedModes(window) ?: return null
        val native = modes.maxOfOrNull { it.refreshRate } ?: return null
        return modes
            .filter { it.refreshRate >= CAP_MIN_REFRESH_HZ && it.refreshRate < native - REFRESH_EPSILON_HZ }
            .minByOrNull { it.refreshRate }
    }

    private fun maxMode(window: Window): Display.Mode? =
        supportedModes(window)?.maxByOrNull { it.refreshRate }

    companion object {
        private const val UNSET = Int.MIN_VALUE
        private const val CAP_MIN_REFRESH_HZ = 55f
        private const val REFRESH_EPSILON_HZ = 0.5f
        private const val BOOST_HOLD_MS = 1_500L
        private const val REAPPLY_SLACK_MS = 100L
    }
}
