package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.ChatMessage
import org.junit.Assert.assertEquals
import org.junit.Test

class KickReplaySeekSyncTest {

    @Test
    fun anchorKeepsSeekTargetWhilePlayerReportsPreSeekPosition() {
        // Player.seekTo completes asynchronously: right after scrubbing 1:47 -> 0:32 the
        // player still reports 107s. The replay loops must use the 32s target or they
        // re-queue the old playhead's chat and the seek visibly does nothing.
        assertEquals(32_000L, resolveAnchoredReplayPosition(107_000L, 32_000L, 200L))
    }

    @Test
    fun anchorReleasesToPlayerOnceConverged() {
        assertEquals(32_400L, resolveAnchoredReplayPosition(32_400L, 32_000L, 200L))
    }

    @Test
    fun anchorExpiresWhenPlayerNeverConverges() {
        assertEquals(40_000L, resolveAnchoredReplayPosition(40_000L, 32_000L, 10_000L))
    }

    @Test
    fun anchorNullPassesPositionThrough() {
        assertEquals(40_000L, resolveAnchoredReplayPosition(40_000L, null, 0L))
    }

    @Test
    fun preloadKeepsLookbackBeforeSeekPoint() {
        val clipStart = 1_700_000_000_000L
        val messages = listOf(
            ChatMessage(id = "pre-clip", timestamp = clipStart - 5_000L),
            ChatMessage(id = "early", timestamp = clipStart + 5_000L),
            ChatMessage(id = "at-seek", timestamp = clipStart + 31_000L),
            ChatMessage(id = "future", timestamp = clipStart + 90_000L),
            ChatMessage(id = "no-timestamp", timestamp = null)
        )
        val result = filterKickPreloadMessages(
            messages = messages,
            playbackTimestampMs = clipStart + 32_000L,
            maxMessages = 200
        )
        assertEquals(listOf("pre-clip", "early", "at-seek", "no-timestamp"), result.map { it.id })
    }

    @Test
    fun preloadCapsToNewestMaxMessages() {
        val clipStart = 1_700_000_000_000L
        val messages = (0 until 10).map { index ->
            ChatMessage(id = "msg-$index", timestamp = clipStart + index * 1_000L)
        }
        val result = filterKickPreloadMessages(
            messages = messages,
            playbackTimestampMs = clipStart + 60_000L,
            maxMessages = 3
        )
        assertEquals(listOf("msg-7", "msg-8", "msg-9"), result.map { it.id })
    }
}
