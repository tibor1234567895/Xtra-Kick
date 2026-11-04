package com.xtrakick.app.repository

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.xtrakick.app.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class, sdk = [28])
@RunWith(RobolectricTestRunner::class)
class LiveNotificationAppearanceTest {
    private val context = RuntimeEnvironment.getApplication()
    private val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val channelId = "live-test"

    @Test
    fun singleLiveAlertIsNotHiddenBehindAnArtworkFreeSummary() {
        post(1)
        ShownNotificationsRepository.updateLiveNotificationGroup(context, manager, channelId)
        val notifications = manager.activeNotifications
        assertEquals(1, notifications.size)
        assertNull(notifications.single().notification.group)
    }

    @Test
    fun multipleAlertsAreGroupedAndRemainingSingleAlertSurvivesSummaryRemoval() {
        post(1)
        post(2)
        ShownNotificationsRepository.updateLiveNotificationGroup(context, manager, channelId)
        assertEquals(3, manager.activeNotifications.size)
        assertTrue(manager.activeNotifications.all { it.notification.group == ShownNotificationsRepository.GROUP_KEY })

        manager.cancel(1)
        ShownNotificationsRepository.updateLiveNotificationGroup(context, manager, channelId)
        assertEquals(2, manager.activeNotifications.single().id)
        assertNull(manager.activeNotifications.single().notification.group)
    }

    @Test
    fun groupingIncludesNotificationsThatHaveNotReachedTheActiveListYet() {
        manager.createNotificationChannel(NotificationChannel(channelId, "Live", NotificationManager.IMPORTANCE_DEFAULT))
        val pending = (1..2).associateWith { id ->
            NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.notification_icon).setContentTitle("Channel $id").build()
        }

        ShownNotificationsRepository.updateLiveNotificationGroup(context, manager, channelId, pending)

        assertEquals(3, manager.activeNotifications.size)
        assertTrue(manager.activeNotifications.all { it.notification.group == ShownNotificationsRepository.GROUP_KEY })
    }

    @Test
    fun groupingDoesNotChangeOtherNotificationChannels() {
        post(1)
        ShownNotificationsRepository.updateLiveNotificationGroup(context, manager, "different-channel")
        assertEquals(1, manager.activeNotifications.size)
        assertEquals(0, manager.activeNotifications.single().notification.flags and android.app.Notification.FLAG_GROUP_SUMMARY)
    }

    private fun post(id: Int) {
        manager.createNotificationChannel(NotificationChannel(channelId, "Live", NotificationManager.IMPORTANCE_DEFAULT))
        manager.notify(id, NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.notification_icon).setContentTitle("Channel $id").build())
    }
}
