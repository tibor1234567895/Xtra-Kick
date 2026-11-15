package com.xtrakick.app.ui.following

import com.xtrakick.app.repository.KickRepository.KickFollowedChannel
import java.io.IOException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class KickFollowSyncTest {
    @Test
    fun discardingAStagedSnapshotAllowsAnImmediateReplacementFetch() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.version++
        assertFalse(fixture.sync.applyPendingNow())
        fixture.sync.requestSync()!!.join()
        assertEquals(2, fixture.fetchCount)
        fixture.sync.refreshNow()
        assertEquals(1, fixture.applied.size)
    }
    @Test
    fun localEditsBypassTheBackgroundGateForAnInvalidStagedSnapshot() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.version++
        fixture.sync.requestSync()!!.join()
        assertEquals(2, fixture.fetchCount)
        assertEquals(0, fixture.applied.size)
    }

    private class Fixture(scope: CoroutineScope) {
        var session: KickFollowSync.Session? = KickFollowSync.Session("one", "token")
        var version = 0L
        var clock = 0L
        var fetchCount = 0
        var response: suspend () -> List<KickFollowedChannel> = { listOf(KickFollowedChannel("streamer")) }
        var beforeCommit: () -> Unit = {}
        val applied = mutableListOf<List<KickFollowedChannel>>()
        val sync = KickFollowSync(scope, { session }, { version }, {
            fetchCount++
            response()
        }, { channels, canApply ->
            beforeCommit()
            if (canApply()) {
                applied += channels
                version++
                true
            } else false
        }, { clock }, {})
    }

    @Test
    fun stagesWhileVisibleAndAppliesOnceAfterLeaving() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        assertEquals(0, fixture.applied.size)
        fixture.sync.setFollowingVisible(false)
        yield()
        assertEquals(1, fixture.applied.size)
        fixture.sync.setFollowingVisible(true)
        fixture.sync.setFollowingVisible(false)
        yield()
        assertEquals(1, fixture.applied.size)
    }

    @Test
    fun explicitRefreshAppliesStagedSnapshotWithoutFetchingAgain() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.sync.refreshNow()
        assertEquals(1, fixture.fetchCount)
        assertEquals(1, fixture.applied.size)
    }

    @Test
    fun concurrentTriggersShareRequestAndSuccessHasCooldown() = runBlocking {
        val fixture = Fixture(this)
        val gate = CompletableDeferred<List<KickFollowedChannel>>()
        fixture.response = { gate.await() }
        val first = fixture.sync.requestSync()!!
        yield()
        assertSame(first, fixture.sync.requestSync())
        gate.complete(emptyList())
        first.join()
        assertEquals(null, fixture.sync.requestSync())
        fixture.clock = KickFollowSync.BACKGROUND_SYNC_INTERVAL_MS + 1L
        fixture.sync.requestSync()!!.join()
        assertEquals(2, fixture.fetchCount)
    }

    @Test
    fun accountSwitchAndLogoutDiscardResultsInFlight() = runBlocking {
        for (nextSession in listOf(null, KickFollowSync.Session("two", "other"), KickFollowSync.Session("one", "new-token"))) {
            val fixture = Fixture(this)
            val gate = CompletableDeferred<List<KickFollowedChannel>>()
            fixture.response = { gate.await() }
            val job = fixture.sync.requestSync()!!
            yield()
            fixture.session = nextSession
            gate.complete(listOf(KickFollowedChannel("old-account")))
            job.join()
            fixture.sync.setFollowingVisible(false)
            yield()
            assertEquals(0, fixture.applied.size)
        }
    }

    @Test
    fun localEditInvalidatesFetchedAndStagedSnapshots() = runBlocking {
        val fixture = Fixture(this)
        val gate = CompletableDeferred<List<KickFollowedChannel>>()
        fixture.response = { gate.await() }
        val job = fixture.sync.requestSync()!!
        yield()
        fixture.version++
        gate.complete(emptyList())
        job.join()
        fixture.sync.setFollowingVisible(false)
        yield()
        assertEquals(0, fixture.applied.size)

        fixture.sync.setFollowingVisible(true)
        fixture.sync.requestSync()!!.join()
        fixture.version++
        fixture.sync.setFollowingVisible(false)
        yield()
        assertEquals(0, fixture.applied.size)
    }

    @Test
    fun failureKeepsSavedFollowsAndBacksOff() = runBlocking {
        val fixture = Fixture(this)
        fixture.response = { throw IOException("unavailable") }
        fixture.sync.requestSync()!!.join()
        assertEquals(null, fixture.sync.requestSync())
        fixture.clock = 60_001L
        fixture.sync.requestSync()!!.join()
        fixture.clock = 120_002L
        assertEquals(null, fixture.sync.requestSync())
        assertEquals(2, fixture.fetchCount)
        assertEquals(0, fixture.applied.size)
    }

    @Test
    fun returningBeforeCommitKeepsSnapshotStaged() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.beforeCommit = { fixture.sync.setFollowingVisible(true) }
        fixture.sync.setFollowingVisible(false)
        yield()
        assertEquals(0, fixture.applied.size)
        fixture.beforeCommit = {}
        fixture.sync.refreshNow()
        assertEquals(1, fixture.applied.size)
    }

    @Test
    fun loggedOutDoesNotFetch() = runBlocking {
        val fixture = Fixture(this)
        fixture.session = null
        assertEquals(null, fixture.sync.requestSync())
        assertEquals(0, fixture.fetchCount)
    }

    @Test
    fun existingImportDiscardsPendingSnapshotAndPreventsDuplicateFetch() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.sync.beginImport()
        assertEquals(null, fixture.sync.requestSync(force = true))
        fixture.sync.refreshNow()
        fixture.sync.setFollowingVisible(false)
        yield()
        assertEquals(0, fixture.applied.size)
        fixture.sync.endImport()
        fixture.sync.requestSync()!!.join()
        assertEquals(2, fixture.fetchCount)
        assertEquals(1, fixture.applied.size)
    }

    @Test
    fun subsequentRefreshWithoutPendingSnapshotDoesNotFetchAgainWithinCooldown() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.sync.refreshNow()
        assertEquals(1, fixture.fetchCount)
        assertEquals(1, fixture.applied.size)

        // Second refresh 30 seconds later (within 10-minute cooldown)
        fixture.clock = 30_000L
        fixture.sync.refreshNow()
        assertEquals(1, fixture.fetchCount)
        assertEquals(1, fixture.applied.size)
    }

    @Test
    fun refreshAfterCooldownExpiresFetchesAgain() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        fixture.sync.refreshNow()
        assertEquals(1, fixture.fetchCount)
        assertEquals(1, fixture.applied.size)

        // Move clock past 5-minute manual cooldown
        fixture.clock = KickFollowSync.MANUAL_REFRESH_COOLDOWN_MS + 1L
        fixture.sync.refreshNow()
        assertEquals(2, fixture.fetchCount)
        assertEquals(2, fixture.applied.size)
    }

    @Test
    fun manualRefreshAllowsSyncWhileBackgroundSyncWaitsForLongerInterval() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        assertEquals(1, fixture.fetchCount)

        // Advance 10 minutes: past manual cooldown (5 min) but well within background sync interval (1 hour)
        fixture.clock = 10L * 60_000L
        assertEquals(null, fixture.sync.requestSync(force = false))
        assertEquals(1, fixture.fetchCount)

        // Manual refresh allows sync
        fixture.sync.refreshNow()
        assertEquals(2, fixture.fetchCount)
    }

    @Test
    fun applyPendingNowAppliesStagedSnapshotWithoutNetwork() = runBlocking {
        val fixture = Fixture(this)
        fixture.sync.requestSync()!!.join()
        assertEquals(1, fixture.fetchCount)
        assertEquals(0, fixture.applied.size)

        assertTrue(fixture.sync.applyPendingNow())
        assertEquals(1, fixture.applied.size)
        assertEquals(1, fixture.fetchCount)

        assertFalse(fixture.sync.applyPendingNow())
        assertEquals(1, fixture.applied.size)
        assertEquals(1, fixture.fetchCount)
    }
}
