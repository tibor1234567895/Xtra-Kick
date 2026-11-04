package com.xtrakick.app.ui.player

import android.app.Application
import android.os.Bundle
import androidx.annotation.OptIn
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.session.MediaSession
import androidx.media3.session.SessionCommand
import androidx.media3.session.SessionCommands
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
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
        assertSame(defaults, result)
        assertFalse(result.availableSessionCommands.contains(SessionCommand(PlaybackService.START_OFFLINE_VIDEO, Bundle.EMPTY)))
        assertFalse(result.availablePlayerCommands.contains(Player.COMMAND_CHANGE_MEDIA_ITEMS))
        val rejected = MediaSession.ConnectionResult.reject()
        assertSame(rejected, playbackControllerConnection(rejected, 2000, 1000))
    }

    @Test fun ownAppRetainsCustomCommandsAndSystemDefaultsArePreserved() {
        val trusted = MediaSession.ConnectionResult.accept(SessionCommands.EMPTY,
            Player.Commands.Builder().add(Player.COMMAND_PLAY_PAUSE).build())
        assertSame(trusted, playbackControllerConnection(trusted, 2000, 1000))
        val own = playbackControllerConnection(trusted, 1000, 1000)
        assertTrue(own.availableSessionCommands.contains(SessionCommand(PlaybackService.START_VIDEO, Bundle.EMPTY)))
        assertTrue(own.availableSessionCommands.contains(SessionCommand(PlaybackService.GET_MEDIA_PLAYLIST, Bundle.EMPTY)))
        assertTrue(own.availablePlayerCommands.contains(Player.COMMAND_PLAY_PAUSE))
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
}
