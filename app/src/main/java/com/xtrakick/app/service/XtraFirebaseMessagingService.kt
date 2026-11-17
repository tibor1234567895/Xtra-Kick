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
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class XtraFirebaseMessagingService : FirebaseMessagingService() {

    private companion object {
        private val CHANNEL_SLUG_REGEX = Regex("[A-Za-z0-9_-]{1,64}")
    }

    @Inject
    lateinit var shownNotificationsRepository: ShownNotificationsRepository

    @Inject
    lateinit var fcmSyncManager: FcmSyncManager

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        serviceScope.launch {
            fcmSyncManager.syncSubscriptions(token)
        }
    }

    override fun onDestroy() {
        serviceScope.cancel()
        super.onDestroy()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data = remoteMessage.data
        val type = data["type"] ?: return
        if (type == "stream_live") {
            val channelId = data["channel_id"]?.toLongOrNull()
            val userId = data["user_id"]?.toLongOrNull() ?: return
            // The payload slug becomes a navigation path: accept only well-formed
            // channel slugs and fall back to the user id otherwise.
            val channelSlug = data["channel_slug"]?.trim()?.removePrefix("/")
                ?.takeIf { it.matches(CHANNEL_SLUG_REGEX) } ?: userId.toString()
            val title = data["title"]
            val description = data["description"]
            val profilePicture = data["profile_picture"]
            val startTime = data["start_time"] ?: data["started_at"]

            val event = KickLiveNotificationEvent(
                channelId = channelId,
                userId = userId,
                title = title,
                description = description,
                path = "/$channelSlug",
                profilePicture = profilePicture,
                startTime = startTime,
            )

            serviceScope.launch {
                shownNotificationsRepository.showLiveNotificationFromEvent(
                    applicationContext,
                    event,
                    ShownNotificationsRepository.EVENT_SOURCE_FCM,
                )
                com.xtrakick.app.ui.widget.LiveChannelsWidgetProvider.notifyDataChanged(applicationContext)
            }
        }
    }
}
