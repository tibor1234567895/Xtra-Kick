package com.xtrakick.app.ui.download

import com.xtrakick.app.util.m3u8.Segment
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.util.concurrent.atomic.AtomicInteger

import org.junit.Assert.assertFalse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DownloadSegmentReuseTest {
    @Test fun longDownloadsUseBoundedWorkersAndPreserveWriteOrder() = runBlocking {
        val segments = List(10_000) { Segment("$it.ts", 2f, null, null) }
        val turn = MutableStateFlow(0)
        val active = AtomicInteger()
        val peak = AtomicInteger()
        val written = mutableListOf<Int>()
        val jobs = withTimeout(10_000) {
            downloadSegments(segments, 4) { index, _ ->
                val count = active.incrementAndGet()
                peak.updateAndGet { maxOf(it, count) }
                if (index == 0) delay(20)
                turn.first { it == index }
                written += index
                active.decrementAndGet()
                turn.update { it + 1 }
            }
        }
        assertEquals(4, jobs.size)
        assertEquals(4, peak.get())
        assertEquals((0 until 10_000).toList(), written)
    }

    @Test fun cancelledDownloadsStopQueuedSegments() = runBlocking {
        val started = CompletableDeferred<Unit>()
        val processed = AtomicInteger()
        val work = async {
            downloadSegments(List(10_000) { Segment("$it.ts", 2f, null, null) }, 3) { _, _ ->
                processed.incrementAndGet()
                started.complete(Unit)
                delay(Long.MAX_VALUE)
            }
        }
        started.await()
        work.cancelAndJoin()
        assertTrue(processed.get() in 1..3)
        assertTrue(downloadSegments(emptyList(), 3) { _, _ -> error("empty") }.isEmpty())
    }
    @Test
    fun knownReadableSegmentIsReused() {
        assertTrue(canReuseDownloadedTrack("one.ts", setOf("one.ts")) { true })
    }

    @Test
    fun missingKnownSegmentMustBeDownloaded() {
        assertFalse(canReuseDownloadedTrack("one.ts", setOf("one.ts")) { false })
    }

    @Test
    fun unknownSegmentDoesNotProbeStorage() {
        assertFalse(canReuseDownloadedTrack("new.ts", setOf("one.ts")) { error("Unexpected storage probe") })
    }
}
