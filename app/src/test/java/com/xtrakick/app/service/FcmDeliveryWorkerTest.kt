package com.xtrakick.app.service

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.google.firebase.messaging.RemoteMessage
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, application = Application::class)
class FcmDeliveryWorkerTest {
    @Test
    fun deliveryRemainsScheduledAfterFirebaseServiceIsDestroyed() {
        val context = RuntimeEnvironment.getApplication()
        WorkManager.initialize(context, Configuration.Builder().build())
        val service = Robolectric.buildService(XtraFirebaseMessagingService::class.java).create()
        val message = RemoteMessage.Builder("test")
            .addData("type", "stream_live")
            .addData("user_id", "12")
            .build()

        service.get().onMessageReceived(message)
        service.destroy()

        val deliveryWork = WorkManager.getInstance(context)
            .getWorkInfosByTag(FcmDeliveryWorker::class.java.name)
            .get(5, TimeUnit.SECONDS)
        assertEquals(1, deliveryWork.size)
        assertNotEquals(WorkInfo.State.CANCELLED, deliveryWork.single().state)
    }

    @Test
    fun buildsLiveEventFromPersistedDeliveryData() {
        val event = FcmDeliveryWorker.liveEvent(workDataOf(
            "user_id" to "12",
            "channel_id" to "34",
            "channel_slug" to " /channel-name ",
            "start_time" to "2026-11-18T12:00:00Z",
        ))
        assertEquals(12L, event?.userId)
        assertEquals(34L, event?.channelId)
        assertEquals("/channel-name", event?.path)
        assertEquals("2026-11-18T12:00:00Z", event?.startTime)
    }

    @Test
    fun rejectsMissingUserIdAndFallsBackFromInvalidSlug() {
        assertNull(FcmDeliveryWorker.liveEvent(workDataOf("channel_slug" to "channel")))
        val event = FcmDeliveryWorker.liveEvent(workDataOf("user_id" to "12", "channel_slug" to "channel/extra"))
        assertEquals("/12", event?.path)
    }
}
