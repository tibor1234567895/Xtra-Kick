package com.xtrakick.app.ui.player

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.KeyEvent
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs

/**
 * MEDIA_BUTTON receiver with two jobs:
 *
 * 1. Keep PackageManager.queryBroadcastReceivers(
 *    Intent("android.intent.action.MEDIA_BUTTON")) returning this package so
 *    Volumee-style apps list the player (see the manifest comment).
 *
 * 2. Resume playback from headset/media-button PLAY keys after the service
 *    process was killed. The system delivers the key here when no service is
 *    alive to handle it; forward it to the last used engine service, which
 *    restores its saved playback request (IvsPlayerService) or no-ops.
 */
class MediaButtonReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_MEDIA_BUTTON) return
        val keyEvent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT, KeyEvent::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT)
        }
        if (keyEvent?.action != KeyEvent.ACTION_DOWN || keyEvent.repeatCount > 0) return
        when (keyEvent.keyCode) {
            KeyEvent.KEYCODE_MEDIA_PLAY,
            KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE,
            KeyEvent.KEYCODE_HEADSETHOOK,
            -> {
                val prefs = context.prefs()
                if (prefs.getString(AppConstants.LAST_PLAYBACK_ENGINE, null) == "ivs" &&
                    !prefs.getString(AppConstants.LAST_PLAYBACK_URL, null).isNullOrBlank()
                ) {
                    val resumeIntent = Intent(context, IvsPlayerService::class.java).apply {
                        action = Intent.ACTION_MEDIA_BUTTON
                        fillIn(intent, 0)
                    }
                    try {
                        context.startForegroundService(resumeIntent)
                    } catch (_: Exception) {
                        try {
                            context.startService(resumeIntent)
                        } catch (_: Exception) {
                        }
                    }
                }
            }
        }
    }
}
