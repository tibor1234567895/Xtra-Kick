package com.xtrakick.app.ui.player

import android.app.Application
import android.os.Looper
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.SimpleBasePlayer
import androidx.media3.common.Timeline
import androidx.media3.common.util.UnstableApi
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@androidx.annotation.OptIn(UnstableApi::class)
@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class MediaNotificationPlayerTest {
    @Test
    fun hidingLiveNotificationProgressPreservesTheDvrTimelineAndPosition() {
        var showSeekbar = false
        val player = MediaNotificationPlayer(TestPlayer(live = true)) { showSeekbar }

        assertEquals(C.TIME_UNSET, player.duration)
        assertEquals(180_000L, player.currentPosition)
        assertEquals(240_000L, player.currentTimeline.getWindow(0, Timeline.Window()).durationMs)
        showSeekbar = true
        assertEquals(240_000L, player.duration)
    }

    @Test
    fun liveNotificationPreferenceDoesNotHideVodDuration() {
        val player = MediaNotificationPlayer(TestPlayer(live = false)) { false }
        assertEquals(240_000L, player.duration)
        assertEquals(180_000L, player.currentPosition)
    }

    @Test
    fun vodCommandsFilterPlaylistSkipsAndRepeatAndEnableSeekBackAndForward() {
        val testPlayer = TestPlayer(live = false)
        val player = MediaNotificationPlayer(testPlayer) { false }

        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_TO_PREVIOUS))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_TO_NEXT))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_TO_NEXT_MEDIA_ITEM))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SET_REPEAT_MODE))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SET_SHUFFLE_MODE))

        assertTrue(player.isCommandAvailable(Player.COMMAND_SEEK_BACK))
        assertTrue(player.isCommandAvailable(Player.COMMAND_SEEK_FORWARD))

        // Initial position is 180_000L (3 minutes in).
        // ExoPlayer's default seekToPrevious would reset to 0L.
        // MediaNotificationPlayer.seekToPrevious safely delegates to seekBack(), seeking to 175_000L.
        player.seekToPrevious()
        assertEquals(listOf(175_000L), testPlayer.seekPositions)

        player.seekToPreviousMediaItem()
        assertEquals(listOf(175_000L, 175_000L), testPlayer.seekPositions)

        player.seekToNext()
        assertEquals(listOf(175_000L, 175_000L, 195_000L), testPlayer.seekPositions)

        player.seekToNextMediaItem()
        assertEquals(listOf(175_000L, 175_000L, 195_000L, 195_000L), testPlayer.seekPositions)

        player.seekForward()
        assertEquals(listOf(175_000L, 175_000L, 195_000L, 195_000L, 195_000L), testPlayer.seekPositions)
    }

    @Test
    fun liveCommandsStripSeekForwardAndPreventNextSeeking() {
        val testPlayer = TestPlayer(live = true)
        val player = MediaNotificationPlayer(testPlayer) { false }

        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_FORWARD))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_TO_PREVIOUS))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_TO_NEXT))

        player.seekToPrevious()
        assertTrue(testPlayer.seekPositions.isEmpty())

        player.seekToPreviousMediaItem()
        assertTrue(testPlayer.seekPositions.isEmpty())

        player.seekToNext()
        assertTrue(testPlayer.seekPositions.isEmpty())

        player.seekToNextMediaItem()
        assertTrue(testPlayer.seekPositions.isEmpty())

        player.seekForward()
        assertTrue(testPlayer.seekPositions.isEmpty())
    }

    @Test
    fun idlePlayerWithoutUnderlyingSeekCommandsDoesNotAdvertiseSeek() {
        val idlePlayer = TestPlayer(live = false, seekable = false)
        val player = MediaNotificationPlayer(idlePlayer) { false }

        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_BACK))
        assertFalse(player.isCommandAvailable(Player.COMMAND_SEEK_FORWARD))
    }

    private class TestPlayer(live: Boolean, seekable: Boolean = true) : SimpleBasePlayer(Looper.getMainLooper()) {
        val seekPositions = mutableListOf<Long>()

        override fun handleSeek(mediaItemIndex: Int, positionMs: Long, seekCommand: Int): ListenableFuture<*> {
            seekPositions.add(positionMs)
            return Futures.immediateVoidFuture()
        }

        private val playbackState = State.Builder()
            .setAvailableCommands(Player.Commands.Builder().apply {
                add(Player.COMMAND_GET_TIMELINE)
                add(Player.COMMAND_GET_CURRENT_MEDIA_ITEM)
                if (seekable) {
                    add(Player.COMMAND_SEEK_TO_PREVIOUS)
                    add(Player.COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM)
                    add(Player.COMMAND_SEEK_TO_NEXT)
                    add(Player.COMMAND_SEEK_TO_NEXT_MEDIA_ITEM)
                    add(Player.COMMAND_SET_REPEAT_MODE)
                    add(Player.COMMAND_SET_SHUFFLE_MODE)
                    add(Player.COMMAND_SEEK_IN_CURRENT_MEDIA_ITEM)
                    add(Player.COMMAND_SEEK_BACK)
                    add(Player.COMMAND_SEEK_FORWARD)
                }
            }.build())
            .setPlaylist(listOf(MediaItemData.Builder("test")
                .setDurationUs(240_000_000L)
                .setLiveConfiguration(if (live) MediaItem.LiveConfiguration.UNSET else null)
                .build()))
            .setContentPositionMs(180_000L)
            .build()

        override fun getState(): State = playbackState
    }
}
