package com.xtrakick.app.ui.main

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.xtrakick.app.R
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs

/** Permission-guarded notifications for successful reward claims. */
internal object RewardClaimNotifier {

    internal const val NOTIFICATION_ID_DAILY = 40_001
    internal const val NOTIFICATION_ID_DROPS = 40_002

    private const val TEXT_MAX_CHARS = 80

    fun dailyClaimed(context: Context, rewardName: String?, rarity: String?) {
        notify(
            context = context,
            notificationId = NOTIFICATION_ID_DAILY,
            titleRes = R.string.reward_claim_daily_title,
            text = listOfNotNull(rewardName, rarity?.let { "($it)" }).joinToString(" "),
        )
    }

    fun dropsClaimed(context: Context, claimedSummaries: List<String>) {
        notify(
            context = context,
            notificationId = NOTIFICATION_ID_DROPS,
            titleRes = R.string.reward_claim_drops_title,
            text = claimedSummaries.joinToString(", "),
        )
    }

    private fun notify(context: Context, notificationId: Int, titleRes: Int, text: String) {
        if (!context.prefs().getBoolean(AppConstants.REWARD_CLAIM_NOTIFICATIONS_ENABLED, true)) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        val notificationManager = NotificationManagerCompat.from(context)
        val channelId = context.getString(R.string.reward_claim_channel_id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && notificationManager.getNotificationChannel(channelId) == null) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    channelId,
                    ContextCompat.getString(context, R.string.reward_claim_channel_title),
                    NotificationManager.IMPORTANCE_DEFAULT,
                ),
            )
        }
        val contentIntent = PendingIntent.getActivity(
            context,
            notificationId,
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            },
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT,
        )
        val notification = NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(R.drawable.notification_icon)
            setContentTitle(ContextCompat.getString(context, titleRes))
            setContentText(text.take(TEXT_MAX_CHARS))
            setStyle(NotificationCompat.BigTextStyle().bigText(text))
            setAutoCancel(true)
            setContentIntent(contentIntent)
        }.build()
        runCatching { notificationManager.notify(notificationId, notification) }
    }
}