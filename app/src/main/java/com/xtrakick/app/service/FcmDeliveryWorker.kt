package com.xtrakick.app.service

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import com.xtrakick.app.model.kick.KickLiveNotificationEvent
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.ui.widget.LiveChannelsWidgetProvider
import com.xtrakick.app.util.FcmSyncManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class FcmDeliveryWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted parameters: WorkerParameters,
    private val shownNotifications: ShownNotificationsRepository,
    private val fcmSyncManager: FcmSyncManager,
) : CoroutineWorker(context, parameters) {

    override suspend fun doWork(): Result {
        if (inputData.getBoolean(TOKEN_SYNC, false)) {
            // Fetch the current Firebase token when work runs. WorkManager need not store it.
            return when {
                fcmSyncManager.syncSubscriptions() -> Result.success()
                runAttemptCount < 3 -> Result.retry()
                else -> Result.failure()
            }
        }
        val event = liveEvent(inputData) ?: return Result.failure()
        shownNotifications.showLiveNotificationFromEvent(
            applicationContext, event, ShownNotificationsRepository.EVENT_SOURCE_FCM,
        )
        LiveChannelsWidgetProvider.notifyDataChanged(applicationContext)
        return Result.success()
    }

    companion object {
        internal const val TOKEN_SYNC = "token_sync"
        private val CHANNEL_SLUG = Regex("[A-Za-z0-9_-]{1,64}")

        internal fun liveEvent(data: Data): KickLiveNotificationEvent? {
            val userId = data.getString("user_id")?.toLongOrNull() ?: return null
            val slug = data.getString("channel_slug")?.trim()?.removePrefix("/")
                ?.takeIf(CHANNEL_SLUG::matches) ?: userId.toString()
            return KickLiveNotificationEvent(
                channelId = data.getString("channel_id")?.toLongOrNull(),
                userId = userId,
                title = data.getString("title"),
                description = data.getString("description"),
                path = "/$slug",
                profilePicture = data.getString("profile_picture"),
                startTime = data.getString("start_time"),
            )
        }
    }
}
