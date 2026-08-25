package com.xtrakick.app.ui.player

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Dummy MEDIA_BUTTON receiver so PackageManager.queryBroadcastReceivers(
 * Intent("android.intent.action.MEDIA_BUTTON")) returns this package.
 *
 * Volumee builds its InstalledMusicPlayers set via:
 *  - queryIntentActivities(MAIN + CATEGORY_APP_MUSIC)
 *  - queryIntentActivities(MAIN + CATEGORY_APP_BROWSER)
 *  - queryBroadcastReceivers(MEDIA_BUTTON)
 * Without any of those, MyNotificationListener filters out the StatusBarNotification
 * and shows "No player is active" even though MediaStyle is present.
 *
 * This receiver is intentionally no-op; actual media keys are handled by
 * IvsPlayerService's MediaSession (flags=3, VolumeProvider) and PlaybackService's
 * Media3 session.
 */
class MediaButtonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) = Unit
}
