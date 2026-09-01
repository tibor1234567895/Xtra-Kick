package com.xtrakick.app.util

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.xtrakick.app.ui.main.LiveNotificationWorker
import java.util.concurrent.TimeUnit

private const val LIVE_NOTIFICATIONS_WORK_NAME = "live_notifications"

/**
 * Schedules the live-notifications polling backup. [reenqueue] replaces an existing
 * schedule so an updated subscription list is picked up promptly; pass false to keep
 * any existing schedule (app-start self-heal).
 */
fun enqueueLiveNotificationsPollingWork(context: Context, reenqueue: Boolean = true) {
    WorkManager.getInstance(context).enqueueUniquePeriodicWork(
        LIVE_NOTIFICATIONS_WORK_NAME,
        if (reenqueue) ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE else ExistingPeriodicWorkPolicy.KEEP,
        PeriodicWorkRequestBuilder<LiveNotificationWorker>(15, TimeUnit.MINUTES)
            .setInitialDelay(if (reenqueue) 1 else 0, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()
    )
}

fun cancelLiveNotificationsPollingWork(context: Context) {
    WorkManager.getInstance(context).cancelUniqueWork(LIVE_NOTIFICATIONS_WORK_NAME)
}
