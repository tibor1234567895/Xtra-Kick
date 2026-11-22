package com.xtrakick.app.ui.player

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import android.view.KeyEvent
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.SimpleBasePlayer
import androidx.media3.common.util.UnstableApi
import androidx.media3.session.CommandButton
import androidx.media3.session.MediaSession
import androidx.media3.session.SessionCommand
import androidx.media3.session.SessionCommands
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@OptIn(UnstableApi::class)
@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class PlaybackServiceSafetyTest {
    @Test fun otherAppsKeepTheirOriginalControllerPermissions() {
        val defaults = MediaSession.ConnectionResult.accept(SessionCommands.EMPTY,
            Player.Commands.Builder().add(Player.COMMAND_GET_CURRENT_MEDIA_ITEM).build())
        val result = playbackControllerConnection(defaults, 2000, 1000)
        assertNotSame(defaults, result)
        assertNull(result.mediaButtonPreferences)
        assertTrue(result.availableSessionCommands.contains(SessionCommand(PlaybackService.NOTIFICATION_SEEK_BACK, Bundle.EMPTY)))
        assertTrue(result.availableSessionCommands.contains(SessionCommand(PlaybackService.NOTIFICATION_SEEK_FORWARD, Bundle.EMPTY)))
        assertFalse(result.availableSessionCommands.contains(SessionCommand(PlaybackService.START_OFFLINE_VIDEO, Bundle.EMPTY)))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_CHANGE_MEDIA_ITEMS))
        val rejected = MediaSession.ConnectionResult.reject()
        assertSame(rejected, playbackControllerConnection(rejected, 2000, 1000))
    }

    @Test fun externalControllersStripTrackSkipsAndRepeatCommands() {
        val externalWithDisallowed = MediaSession.ConnectionResult.accept(
            SessionCommands.EMPTY,
            Player.Commands.Builder()
                .add(Player.COMMAND_PLAY_PAUSE)
                .add(Player.COMMAND_SEEK_TO_PREVIOUS)
                .add(Player.COMMAND_SEEK_TO_NEXT)
                .add(Player.COMMAND_SET_REPEAT_MODE)
                .add(Player.COMMAND_SET_SHUFFLE_MODE)
                .add(Player.COMMAND_SEEK_BACK)
                .add(Player.COMMAND_SEEK_FORWARD)
                .build()
        )
        val result = playbackControllerConnection(externalWithDisallowed, 2000, 1000)
        assertNotSame(externalWithDisallowed, result)
        assertTrue(result.availablePlayerCommands.contains(Player.COMMAND_PLAY_PAUSE))
        assertTrue(result.availablePlayerCommands.contains(Player.COMMAND_SEEK_BACK))
        assertTrue(result.availablePlayerCommands.contains(Player.COMMAND_SEEK_FORWARD))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_SEEK_TO_PREVIOUS))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_SEEK_TO_NEXT))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_SEEK_TO_NEXT_MEDIA_ITEM))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_SET_REPEAT_MODE))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_SET_SHUFFLE_MODE))
    }

    @Test fun ownAppRetainsCustomCommandsAndSystemDefaultsArePreserved() {
        val trusted = MediaSession.ConnectionResult.accept(SessionCommands.EMPTY,
            Player.Commands.Builder().add(Player.COMMAND_PLAY_PAUSE).build())
        val external = playbackControllerConnection(trusted, 2000, 1000)
        assertNotSame(trusted, external)
        assertTrue(external.availablePlayerCommands.contains(Player.COMMAND_PLAY_PAUSE))
        assertFalse(external.availableSessionCommands.contains(SessionCommand(PlaybackService.START_VIDEO, Bundle.EMPTY)))
        val own = playbackControllerConnection(trusted, 1000, 1000)
        assertTrue(own.availableSessionCommands.contains(SessionCommand(PlaybackService.START_VIDEO, Bundle.EMPTY)))
        assertTrue(own.availableSessionCommands.contains(SessionCommand(PlaybackService.GET_MEDIA_PLAYLIST, Bundle.EMPTY)))
        assertTrue(own.availableSessionCommands.contains(SessionCommand(PlaybackService.SET_PIP_DISMISSED_BACKGROUND_AUDIO, Bundle.EMPTY)))
        assertTrue(own.availablePlayerCommands.contains(Player.COMMAND_PLAY_PAUSE))
    }

    @Test
    fun freshPipDismissMarkIsConsumedOnTaskRemoved() {
        val service = PlaybackService()
        service.pipDismissedWithBackgroundAudioAtMs = SystemClock.elapsedRealtime()

        service.onTaskRemoved(null)

        assertEquals(0L, service.pipDismissedWithBackgroundAudioAtMs)
    }

    @Test
    fun expiredPipDismissMarkIsClearedOnTaskRemoved() {
        val service = Robolectric.buildService(PlaybackService::class.java).get()
        service.pipDismissedWithBackgroundAudioAtMs = SystemClock.elapsedRealtime() - 60_000

        service.onTaskRemoved(null)

        assertEquals(0L, service.pipDismissedWithBackgroundAudioAtMs)
    }

    @Test fun finalPositionWritesStayOrderedAndOutliveTheServiceScope() = runBlocking {
        val appScope = CoroutineScope(coroutineContext + Job())
        val serviceScope = CoroutineScope(coroutineContext + Job())
        val releaseFirst = CompletableDeferred<Unit>()
        val saved = mutableListOf<Long>()
        val writer = PlaybackPositionWriter(appScope)
        try {
            writer.enqueue { releaseFirst.await(); saved.add(10) }
            val finalWrite = writer.enqueue { saved.add(20) }
            serviceScope.cancel()
            delay(25)
            assertTrue(saved.isEmpty())
            releaseFirst.complete(Unit)
            finalWrite.join()
            assertEquals(listOf(10L, 20L), saved)
        } finally { appScope.cancel(); serviceScope.cancel() }
    }

    @Test
    fun mediaButtonEventsRouteToRelativeSeeksOnVodAndFilterDuplicates() {
        val player = MockButtonPlayer(live = false)

        val prevIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        )
        assertTrue(handleMediaButtonEvent(player, prevIntent))
        assertEquals(listOf(115_000L), player.seeks)

        // ACTION_UP is consumed but does not invoke duplicate seek
        val prevUpIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        )
        assertTrue(handleMediaButtonEvent(player, prevUpIntent))
        assertEquals(listOf(115_000L), player.seeks)

        // Long press repeat count > 0 does not trigger duplicate seeks
        val repeatIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(0L, 0L, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS, 1)
        )
        assertTrue(handleMediaButtonEvent(player, repeatIntent))
        assertEquals(listOf(115_000L), player.seeks)

        // KEYCODE_MEDIA_SKIP_BACKWARD seeks back
        val skipBackIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_SKIP_BACKWARD)
        )
        assertTrue(handleMediaButtonEvent(player, skipBackIntent))
        assertEquals(listOf(115_000L, 115_000L), player.seeks)

        // KEYCODE_MEDIA_NEXT and KEYCODE_MEDIA_SKIP_FORWARD seek forward (+15s default increment)
        val nextIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT)
        )
        assertTrue(handleMediaButtonEvent(player, nextIntent))
        assertEquals(listOf(115_000L, 115_000L, 135_000L), player.seeks)

        val skipFwdIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_SKIP_FORWARD)
        )
        assertTrue(handleMediaButtonEvent(player, skipFwdIntent))
        assertEquals(listOf(115_000L, 115_000L, 135_000L, 135_000L), player.seeks)
    }

    @Test
    fun mediaButtonEventsOnLiveStreamsConsumeKeysWithoutSeeking() {
        val player = MockButtonPlayer(live = true)

        val prevIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        )
        assertTrue(handleMediaButtonEvent(player, prevIntent))
        assertTrue(player.seeks.isEmpty())

        val nextIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT)
        )
        assertTrue(handleMediaButtonEvent(player, nextIntent))
        assertTrue(player.seeks.isEmpty())
    }

    @Test
    fun mediaButtonEventsUnhandledKeysFallThrough() {
        val player = MockButtonPlayer(live = false)
        val playPauseIntent = Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT,
            KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
        )
        assertFalse(handleMediaButtonEvent(player, playPauseIntent))
        assertTrue(player.seeks.isEmpty())
    }

    @Test
    fun notificationSeekButtonsExposeLabelledCustomCommands() {
        val buttons = notificationSeekButtons(30L, 30L, "Rewind 30 seconds", "Fast forward 30 seconds")

        assertEquals(2, buttons.size)
        assertEquals(CommandButton.ICON_SKIP_BACK_30, buttons[0].icon)
        assertEquals(CommandButton.ICON_SKIP_FORWARD_30, buttons[1].icon)
        assertEquals("Rewind 30 seconds", buttons[0].displayName)
        assertEquals("Fast forward 30 seconds", buttons[1].displayName)
        assertEquals(SessionCommand(PlaybackService.NOTIFICATION_SEEK_BACK, Bundle.EMPTY), buttons[0].sessionCommand)
        assertEquals(SessionCommand(PlaybackService.NOTIFICATION_SEEK_FORWARD, Bundle.EMPTY), buttons[1].sessionCommand)
        assertTrue(buttons[0].slots.contains(CommandButton.SLOT_BACK))
        assertTrue(buttons[1].slots.contains(CommandButton.SLOT_FORWARD))
    }

    @Test
    fun notificationSeekButtonsUseGenericIconsForArbitraryIntervals() {
        val buttons = notificationSeekButtons(7L, 45L, "Rewind", "Forward")

        assertEquals(CommandButton.ICON_REWIND, buttons[0].icon)
        assertEquals(CommandButton.ICON_FAST_FORWARD, buttons[1].icon)
    }

    @Test
    fun liveNotificationPublishesOnlyRewind() {
        val buttons = notificationSeekButtons(10, 10, "Rewind", "Fast forward", live = true)
        assertEquals(PlaybackService.NOTIFICATION_SEEK_BACK, buttons.single().sessionCommand?.customAction)
    }

    @Test
    fun notificationSeekCommandsRewindAndForwardVodButNeverForwardLive() {
        val vod = MockButtonPlayer(live = false)
        assertTrue(handleNotificationSeekCommand(vod, PlaybackService.NOTIFICATION_SEEK_BACK))
        assertEquals(listOf(115_000L), vod.seeks)
        assertTrue(handleNotificationSeekCommand(vod, PlaybackService.NOTIFICATION_SEEK_FORWARD))
        assertEquals(listOf(115_000L, 135_000L), vod.seeks)

        val live = MockButtonPlayer(live = true)
        assertTrue(handleNotificationSeekCommand(live, PlaybackService.NOTIFICATION_SEEK_BACK))
        assertTrue(handleNotificationSeekCommand(live, PlaybackService.NOTIFICATION_SEEK_FORWARD))
        assertEquals(listOf(115_000L), live.seeks)

        assertFalse(handleNotificationSeekCommand(vod, "unrelated"))
    }

    private class MockButtonPlayer(val live: Boolean) : SimpleBasePlayer(Looper.getMainLooper()) {
        val seeks = mutableListOf<Long>()

        override fun handleSeek(mediaItemIndex: Int, positionMs: Long, seekCommand: Int): ListenableFuture<*> {
            seeks.add(positionMs)
            return Futures.immediateVoidFuture()
        }

        private val playbackState = State.Builder()
            .setAvailableCommands(Player.Commands.Builder().addAllCommands().build())
            .setPlaylist(listOf(MediaItemData.Builder("test")
                .setDurationUs(240_000_000L)
                .setLiveConfiguration(if (live) MediaItem.LiveConfiguration.UNSET else null)
                .build()))
            .setContentPositionMs(120_000L)
            .build()

        override fun getState(): State = playbackState
    }
}
