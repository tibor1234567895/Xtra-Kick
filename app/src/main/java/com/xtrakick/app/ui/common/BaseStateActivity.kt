package com.xtrakick.app.ui.common

import android.app.Activity
import android.app.PictureInPictureParams
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.callKeyEventGuardListener
import com.xtrakick.app.util.restoreOversizedInstanceState
import com.xtrakick.app.util.saveOversizedInstanceState

/**
 * Keeps large AndroidX state in private storage rather than discarding navigation or exceeding Binder's limit,
 * protects against Android 12 PhoneFallbackEventHandler SecurityException, and guards against
 * setPictureInPictureParams lifecycle crashes.
 */
abstract class BaseStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState?.let { restoreOversizedInstanceState(this, it) }
        super.onCreate(savedInstanceState)

        // Protect DialogFragments from leaking unhandled KEYCODE_CALL / KEYCODE_ENDCALL to PhoneFallbackEventHandler
        supportFragmentManager.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
                    if (f is DialogFragment) {
                        f.dialog?.setOnKeyListener(callKeyEventGuardListener)
                    }
                }
            },
            true
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveOversizedInstanceState(this, outState)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        // Prevent Android 12 (API 31+) PhoneFallbackEventHandler crash on unhandled call button events.
        // Android 12 restricted BROADCAST_CLOSE_SYSTEM_DIALOGS to system apps. When KEYCODE_CALL or
        // KEYCODE_ENDCALL is unhandled, PhoneFallbackEventHandler tries to send CLOSE_SYSTEM_DIALOGS,
        // causing a fatal SecurityException in third-party apps.
        if (event.keyCode == KeyEvent.KEYCODE_CALL || event.keyCode == KeyEvent.KEYCODE_ENDCALL) {
            return true
        }
        return super.dispatchKeyEvent(event)
    }
}

/**
 * Safely sets Picture-in-Picture params. setPictureInPictureParams throws IllegalStateException
 * when the system server considers the activity out of a valid state (RESUMED or PAUSED, or
 * actively in PiP mode; AOSP ActivityClientController.java b/232589966) — typically when called
 * during STOPPING/STOPPED/DESTROYED or background transitions. Guards cover the common invalid
 * states up front; the expected exceptions are logged instead of crashing.
 */
fun Activity.safeSetPictureInPictureParams(params: PictureInPictureParams): Boolean {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return false
    if (isFinishing || isDestroyed) return false
    if (this is AppCompatActivity) {
        val state = lifecycle.currentState
        if (!state.isAtLeast(Lifecycle.State.STARTED) && !isInPictureInPictureMode) {
            return false
        }
    }
    return try {
        setPictureInPictureParams(params)
        true
    } catch (e: IllegalStateException) {
        DiagnosticLogger.w("BaseStateActivity", "safeSetPictureInPictureParams failed: ${e.message}", e)
        false
    } catch (e: IllegalArgumentException) {
        DiagnosticLogger.w("BaseStateActivity", "safeSetPictureInPictureParams failed: ${e.message}", e)
        false
    }
}
