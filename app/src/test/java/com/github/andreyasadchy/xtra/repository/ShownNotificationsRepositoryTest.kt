package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.ShownNotificationsRepository.Companion.SUMMARY_NOTIFICATION_ID
import com.github.andreyasadchy.xtra.repository.ShownNotificationsRepository.Companion.notificationIdFor
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ShownNotificationsRepositoryTest {

    @Test
    fun distinctChannelsGetDistinctIds() {
        val a = Stream(channelId = "101941", channelLogin = "52chains")
        val b = Stream(channelId = "2733273", channelLogin = "kyliebitkin")

        assertNotEquals(notificationIdFor(a), notificationIdFor(b))
    }

    @Test
    fun idIsStableForTheSameChannel() {
        val first = Stream(channelId = "101941", channelLogin = "52chains", title = "before")
        val second = Stream(channelId = "101941", channelLogin = "52chains", title = "after")

        assertEquals(notificationIdFor(first), notificationIdFor(second))
    }

    @Test
    fun nullChannelIdDoesNotCollapseToZero() {
        // The regression: `null.hashCode()` is 0, which was also the group summary's id, so a
        // null-channelId stream replaced the summary instead of appearing beside it.
        val stream = Stream(channelId = null, channelLogin = "52chains")

        assertNotEquals(0, notificationIdFor(stream))
        assertNotEquals(SUMMARY_NOTIFICATION_ID, notificationIdFor(stream))
    }

    @Test
    fun twoNullChannelIdStreamsDoNotShareAnId() {
        // Both used to hash to 0, so with FLAG_UPDATE_CURRENT the second overwrote the first's
        // PendingIntent extras and tapping one opened the other.
        val a = Stream(channelId = null, channelLogin = "52chains")
        val b = Stream(channelId = null, channelLogin = "kyliebitkin")

        assertNotEquals(notificationIdFor(a), notificationIdFor(b))
    }

    @Test
    fun fallsBackToStreamIdWhenChannelIdAndLoginAreBothNull() {
        val a = Stream(channelId = null, channelLogin = null, id = "stream-1")
        val b = Stream(channelId = null, channelLogin = null, id = "stream-2")

        assertNotEquals(0, notificationIdFor(a))
        assertNotEquals(notificationIdFor(a), notificationIdFor(b))
    }

    @Test
    fun summaryIdIsNotZero() {
        // The summary used to be posted with literal 0, which is exactly what a null channelId
        // hashes to. Any sentinel is fine as long as it is not 0.
        assertNotEquals(0, SUMMARY_NOTIFICATION_ID)
    }
}
