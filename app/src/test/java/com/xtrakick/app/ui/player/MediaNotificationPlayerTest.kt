package com.xtrakick.app.ui.player

import android.app.Application
import android.os.Looper
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.SimpleBasePlayer
import androidx.media3.common.Timeline
import androidx.media3.common.util.UnstableApi
import org.junit.Assert.assertEquals
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

    private class TestPlayer(live: Boolean) : SimpleBasePlayer(Looper.getMainLooper()) {
        private val playbackState = State.Builder()
            .setAvailableCommands(Player.Commands.Builder()
                .add(Player.COMMAND_GET_TIMELINE).add(Player.COMMAND_GET_CURRENT_MEDIA_ITEM).build())
            .setPlaylist(listOf(MediaItemData.Builder("test")
                .setDurationUs(240_000_000L)
                .setLiveConfiguration(if (live) MediaItem.LiveConfiguration.UNSET else null)
                .build()))
            .setContentPositionMs(180_000L)
            .build()

        override fun getState(): State = playbackState
    }
}
