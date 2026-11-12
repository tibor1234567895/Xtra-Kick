package com.xtrakick.app.repository

import java.io.IOException
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class KickFollowSnapshotTest {
    @Test
    fun acceptsExplicitEmptySnapshot() {
        assertEquals(emptyList<KickRepository.KickFollowedChannel>(),
            KickFollowSnapshot.parsePage("""{"channels":[],"nextCursor":null}""", requireComplete = true).channels)
    }

    @Test
    fun acceptsNumericPaginationCursor() {
        assertEquals("20", KickFollowSnapshot.parsePage("""{"channels":[],"nextCursor":20}""", requireComplete = true).nextCursor)
    }

    @Test
    fun acceptsTerminalPageWithOmittedCursor() {
        assertEquals(null, KickFollowSnapshot.parsePage("""{"channels":[{"channel_slug":"last"}]}""", requireComplete = true).nextCursor)
        assertEquals(emptyList<KickRepository.KickFollowedChannel>(), KickFollowSnapshot.parsePage("""{"channels":[]}""", requireComplete = true).channels)
    }

    @Test
    fun rejectsMissingListsInvalidPaginationAndMalformedEntries() {
        listOf(
            "{}", """{"data":[]}""", """{"channels":null,"nextCursor":null}""",
            """{"channels":[{}],"nextCursor":null}""", """{"channels":[null],"nextCursor":null}""",
            """{"channels":[],"nextCursor":false}""",
        ).forEach { payload ->
            assertThrows(IOException::class.java) { KickFollowSnapshot.parsePage(payload, requireComplete = true) }
        }
    }

    @Test
    fun collectsEveryPageBeforeReturning() = runBlocking {
        val cursors = mutableListOf<String?>()
        val channels = KickFollowSnapshot.collect { cursor ->
            cursors += cursor
            if (cursor == null) page("one", next = "next") else page("two")
        }
        assertEquals(listOf(null, "next"), cursors)
        assertEquals(listOf("one", "two"), channels.map { it.login })
    }

    @Test
    fun rejectsCursorCyclesEmptyMiddlePagesAndDuplicateChannels() {
        assertThrows(IOException::class.java) {
            runBlocking { KickFollowSnapshot.collect { cursor -> page(cursor ?: "first", next = "repeated") } }
        }
        assertThrows(IOException::class.java) {
            runBlocking { KickFollowSnapshot.collect { KickRepository.KickFollowedChannelsPage(emptyList(), "next") } }
        }
        assertThrows(IOException::class.java) {
            runBlocking { KickFollowSnapshot.collect { cursor -> page(if (cursor == null) "ONE" else "one", if (cursor == null) "next" else null) } }
        }
    }

    @Test
    fun propagatesFailureOnLaterPage() {
        assertThrows(IOException::class.java) {
            runBlocking {
                KickFollowSnapshot.collect { cursor ->
                    if (cursor == null) page("one", "next") else throw IOException("page failed")
                }
            }
        }
    }

    private fun page(login: String, next: String? = null) =
        KickRepository.KickFollowedChannelsPage(listOf(KickRepository.KickFollowedChannel(login)), next)
}
