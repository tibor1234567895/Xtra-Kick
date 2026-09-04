package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.api.livestream.Livestream
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.ShownNotificationsRepository.Companion.EVENT_DUPLICATE_WINDOW_MS
import com.xtrakick.app.repository.ShownNotificationsRepository.Companion.SUMMARY_NOTIFICATION_ID
import com.xtrakick.app.repository.ShownNotificationsRepository.Companion.isRequestedLivestream
import com.xtrakick.app.repository.ShownNotificationsRepository.Companion.notificationIdFor
import com.xtrakick.app.repository.ShownNotificationsRepository.Companion.shouldSuppressEvent
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
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

    @Test
    fun eventRoadAndCheckerRoadShareOneIdForTheSameChannel() {
        // The 52chains double: the event road used the raw channel id while the checker road
        // used the broadcaster user id, so one stream produced two shade rows. Both roads now
        // use the canonical broadcaster id, so the second post updates the first.
        val eventRoad = Stream(channelId = "103102", channelLogin = "52chains", title = "from chat")
        val checkerRoad = Stream(channelId = "103102", channelLogin = "52chains", title = "from poll")

        assertEquals(notificationIdFor(eventRoad), notificationIdFor(checkerRoad))
    }

    @Test
    fun requestedLivestreamMatchesBroadcasterId() {
        val live = Livestream(broadcasterUserId = 103102, slug = "52chains")

        assertTrue(isRequestedLivestream(live, setOf("103102"), setOf("52chains")))
    }

    @Test
    fun requestedLivestreamFallsBackToChannelIdAndSlug() {
        val byChannelId = Livestream(broadcasterUserId = null, channelId = 103102, slug = "other")
        val bySlug = Livestream(broadcasterUserId = 999, channelId = 888, slug = "52Chains")

        assertTrue(isRequestedLivestream(byChannelId, setOf("103102"), setOf("52chains")))
        assertTrue(isRequestedLivestream(bySlug, setOf("103102"), setOf("52chains")))
    }

    @Test
    fun unrequestedLivestreamIsDropped() {
        // A stranger's live response leaking into the poll must never notify, even though
        // the server returned it for this batch.
        val stranger = Livestream(broadcasterUserId = 58065, channelId = 58065, slug = "impulsespoon646")

        assertFalse(isRequestedLivestream(stranger, setOf("103102"), setOf("52chains")))
    }

    @Test
    fun sameSessionEventIsSuppressed() {
        val streamStart = 1_000_000L

        assertTrue(shouldSuppressEvent(existingStartedAt = streamStart, liveStartedAt = streamStart, nowMs = 2_000_000L))
        assertTrue(shouldSuppressEvent(existingStartedAt = streamStart + 1, liveStartedAt = streamStart, nowMs = 2_000_000L))
    }

    @Test
    fun restartedStreamPostsAgain() {
        assertFalse(shouldSuppressEvent(existingStartedAt = 1_000_000L, liveStartedAt = 2_000_000L, nowMs = 3_000_000L))
    }

    @Test
    fun unknownStartSuppressesOnlyRecentRows() {
        val now = 10_000_000L

        assertTrue(shouldSuppressEvent(existingStartedAt = now - 1_000L, liveStartedAt = null, nowMs = now))
        assertFalse(
            shouldSuppressEvent(
                existingStartedAt = now - EVENT_DUPLICATE_WINDOW_MS - 1L,
                liveStartedAt = null,
                nowMs = now,
            )
        )
    }

    @Test
    fun noStoredRowNeverSuppresses() {
        assertFalse(shouldSuppressEvent(existingStartedAt = null, liveStartedAt = 1_000_000L, nowMs = 2_000_000L))
        assertFalse(shouldSuppressEvent(existingStartedAt = null, liveStartedAt = null, nowMs = 2_000_000L))
    }
}
