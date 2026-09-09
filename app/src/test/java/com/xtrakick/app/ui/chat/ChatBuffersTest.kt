package com.xtrakick.app.ui.chat

import java.lang.management.ManagementFactory
import java.util.concurrent.TimeUnit
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatBuffersTest {
    @Test
    fun clearReturnsVisibleCountAndRemovesMutedRawMessages() {
        val raw = ArrayDeque(listOf("visible", "muted"))
        val visible = ArrayDeque(listOf("visible"))

        assertEquals(1, clearChatBuffers(raw, visible))
        assertTrue(raw.isEmpty())
        assertTrue(visible.isEmpty())
        assertEquals(0, clearChatBuffers(raw, visible))
    }

    @Test
    fun clearWaitsForRawBufferWithoutHoldingVisibleBuffer() {
        val raw = ArrayDeque(listOf("message"))
        val visible = ArrayDeque(listOf("message"))
        val worker = Thread { clearChatBuffers(raw, visible) }.apply { isDaemon = true }
        try {
            synchronized(raw) {
                worker.start()
                val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                while (worker.state != Thread.State.BLOCKED && System.nanoTime() < deadline) {
                    Thread.yield()
                }
                assertEquals(Thread.State.BLOCKED, worker.state)
                val info = ManagementFactory.getThreadMXBean()
                    .getThreadInfo(longArrayOf(worker.threadId()), true, false)[0]
                assertEquals(System.identityHashCode(raw), info.lockInfo.identityHashCode)
                assertFalse(info.lockedMonitors.any { it.identityHashCode == System.identityHashCode(visible) })
            }
        } finally {
            worker.join(5_000)
        }
        assertFalse(worker.isAlive)
        assertTrue(raw.isEmpty())
        assertTrue(visible.isEmpty())
    }
}
