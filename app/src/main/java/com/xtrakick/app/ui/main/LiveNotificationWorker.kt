package com.xtrakick.app.ui.main

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Inject

@HiltWorker
class LiveNotificationWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted parameters: WorkerParameters,
) : CoroutineWorker(context, parameters) {

    @Inject
    lateinit var shownNotifications: ShownNotificationsRepository

    @Inject
    lateinit var notificationUsersRepository: NotificationUsersRepository

    override suspend fun doWork(): Result {
        // Android 13+ silently drops notify() without POST_NOTIFICATIONS while the dedupe DB
        // below still advances — the stream session would be marked "shown" without the user
        // ever seeing anything (GitHub #44/#58). Defer instead; retry next window.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            return Result.success()
        }
        val streams = shownNotifications.getNewKickStreams(
            notificationUsersRepository = notificationUsersRepository,
        )
        if (streams.isNotEmpty()) {
            shownNotifications.showLiveNotifications(applicationContext, streams)
        }
        return Result.success().also {
            // Staleness marker for diagnostics: Settings can compare this against
            // LIVE_NOTIFICATIONS_ENABLED to detect OEM-killed background polling.
            context.prefs().edit { putLong(AppConstants.LIVE_NOTIFICATIONS_LAST_SUCCESS, System.currentTimeMillis()) }
        }
    }
}
