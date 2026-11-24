package com.xtrakick.app.service

import android.os.Build
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.xtrakick.app.BuildConfig

class XtraFirebaseMessagingService : FirebaseMessagingService() {

    @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
    override fun onNewToken(token: String) {
        if (BuildConfig.DEBUG) return
        FcmDeliveryWorker.enqueueTokenSync(applicationContext, deduplicatePending = false)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val data = remoteMessage.data
        if (data["type"] != "stream_live" || data["user_id"]?.toLongOrNull() == null) return

        // Firebase can stop this service as soon as the callback returns.
        val work = OneTimeWorkRequestBuilder<FcmDeliveryWorker>()
            .setInputData(workDataOf(
                "user_id" to data["user_id"],
                "channel_id" to data["channel_id"],
                "channel_slug" to data["channel_slug"],
                "title" to data["title"],
                "description" to data["description"],
                "profile_picture" to data["profile_picture"],
                "start_time" to (data["start_time"] ?: data["started_at"]),
            ))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            work.setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
        }
        WorkManager.getInstance(applicationContext).enqueue(work.build())
    }
}
