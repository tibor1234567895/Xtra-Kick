package com.xtrakick.app.ui.main

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.xtrakick.app.R
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

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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
            val channelId = context.getString(R.string.notification_live_channel_id)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (notificationManager.getNotificationChannel(channelId) == null) {
                    notificationManager.createNotificationChannel(
                        NotificationChannel(
                            channelId,
                            ContextCompat.getString(context, R.string.notification_live_channel_title),
                            NotificationManager.IMPORTANCE_DEFAULT
                        )
                    )
                }
            }
            streams.forEach {
                val notification = NotificationCompat.Builder(context, channelId).apply {
                    setGroup(GROUP_KEY)
                    setContentTitle(ContextCompat.getString(context, R.string.live_notification).format(
                        if (it.channelLogin != null && !it.channelLogin.equals(it.channelName, true)) {
                            when (context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                                "0" -> "${it.channelName}(${it.channelLogin})"
                                "1" -> it.channelName
                                else -> it.channelLogin
                            }
                        } else {
                            it.channelName
                        }
                    ))
                    setContentText(it.title)
                    setSmallIcon(R.drawable.notification_icon)
                    setAutoCancel(true)
                    setContentIntent(
                        PendingIntent.getActivity(
                            context,
                            ShownNotificationsRepository.notificationIdFor(it),
                            Intent(context, MainActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                                action = MainActivity.INTENT_LIVE_NOTIFICATION
                                putExtra(MainActivity.KEY_VIDEO, it)
                            },
                            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                        )
                    )
                }.build()
                notificationManager.notify(ShownNotificationsRepository.notificationIdFor(it), notification)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val notification = NotificationCompat.Builder(context, channelId).apply {
                    setGroup(GROUP_KEY)
                    setSmallIcon(R.drawable.notification_icon)
                    setGroupSummary(true)
                }.build()
                notificationManager.notify(ShownNotificationsRepository.SUMMARY_NOTIFICATION_ID, notification)
            }
        }
        return Result.success().also {
            // Staleness marker for diagnostics: Settings can compare this against
            // LIVE_NOTIFICATIONS_ENABLED to detect OEM-killed background polling.
            context.prefs().edit { putLong(AppConstants.LIVE_NOTIFICATIONS_LAST_SUCCESS, System.currentTimeMillis()) }
        }
    }

    companion object {
        const val GROUP_KEY = "com.xtrakick.app.LIVE_NOTIFICATIONS"
    }
}
