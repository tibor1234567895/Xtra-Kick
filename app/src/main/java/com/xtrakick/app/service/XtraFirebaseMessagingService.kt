package com.xtrakick.app.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.xtrakick.app.model.kick.KickLiveNotificationEvent
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.FcmSyncManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class XtraFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var shownNotificationsRepository: ShownNotificationsRepository

    @Inject
    lateinit var fcmSyncManager: FcmSyncManager

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        serviceScope.launch {
            fcmSyncManager.syncSubscriptions(token)
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data = remoteMessage.data
        val type = data["type"] ?: return
        if (type == "stream_live") {
            val channelId = data["channel_id"]?.toLongOrNull()
            val userId = data["user_id"]?.toLongOrNull() ?: return
            val channelSlug = data["channel_slug"]?.trim()?.removePrefix("/") ?: userId.toString()
            val title = data["title"]
            val description = data["description"]
            val profilePicture = data["profile_picture"]

            val event = KickLiveNotificationEvent(
                channelId = channelId,
                userId = userId,
                title = title,
                description = description,
                path = "/$channelSlug",
                profilePicture = profilePicture,
            )

            serviceScope.launch {
                shownNotificationsRepository.showLiveNotificationFromEvent(
                    applicationContext,
                    event,
                    ShownNotificationsRepository.EVENT_SOURCE_FCM,
                )
            }
        }
    }
}
