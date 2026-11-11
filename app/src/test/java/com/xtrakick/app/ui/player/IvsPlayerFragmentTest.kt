package com.xtrakick.app.ui.player

import android.app.Application
import android.content.ContextWrapper
import android.content.res.Configuration
import android.media.MediaMetadata
import android.media.session.MediaSession
import android.media.session.PlaybackState
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.SurfaceHolder
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentHostCallback
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.Quality
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.shadow.api.Shadow
import org.robolectric.shadows.ShadowMediaSession
import org.robolectric.util.ReflectionHelpers
import java.lang.reflect.Proxy
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class IvsPlayerFragmentTest {

    @Test
    @Config(shadows = [RecordingMediaSession::class])
    fun lateStartTimeReplacesFiniteSdkDurationWithoutAdvertisingLiveSeeking() {
        val context = RuntimeEnvironment.getApplication()
        val service = Robolectric.buildService(IvsPlayerService::class.java).get()
        val session = MediaSession(context, "live-timing-test")
        val published = Shadow.extract<RecordingMediaSession>(session)
        val player = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            when (method.name) {
                "getDuration" -> 240_000L
                "getPosition" -> 0L
                "getState" -> Player.State.PLAYING
                "getPlaybackRate" -> 1f
                else -> null
            }
        } as Player
        ReflectionHelpers.setField(service, "player", player)
        ReflectionHelpers.setField(service, "session", session)
        ReflectionHelpers.setField(service, "currentUrl", "https://example.com/live.m3u8")
        val start = System.currentTimeMillis() - 44 * 60_000L

        try {
            service.updateStreamStartedAt(start)
            val metadata = requireNotNull(published.metadata)
            val state = requireNotNull(published.state)
            assertTrue(metadata.getLong(MediaMetadata.METADATA_KEY_DURATION) >= 44 * 60_000L)
            assertTrue(state.position >= 44 * 60_000L)
            val seekActions = PlaybackState.ACTION_SEEK_TO or
                PlaybackState.ACTION_SKIP_TO_NEXT or PlaybackState.ACTION_SKIP_TO_PREVIOUS
            assertEquals(0L, state.actions and seekActions)

            context.prefs().edit().putBoolean(AppConstants.PLAYER_SHOW_STREAM_NOTIFICATION_SEEKBAR, false).commit()
            service.updateStreamStartedAt(start - 1)
            assertEquals(-1L, requireNotNull(published.metadata).getLong(MediaMetadata.METADATA_KEY_DURATION))
        } finally {
            session.release()
            ReflectionHelpers.getField<ExecutorService>(service, "playerExecutor").shutdownNow()
        }
    }

    @Implements(MediaSession::class)
    class RecordingMediaSession : ShadowMediaSession() {
        var metadata: MediaMetadata? = null
            private set
        var state: PlaybackState? = null
            private set

        @Implementation
        fun setMetadata(value: MediaMetadata?) {
            metadata = value
        }

        @Implementation
        fun setPlaybackState(value: PlaybackState?) {
            state = value
        }
    }

    @Test
    fun qualityRecoverySwitchPreservesTheBufferedVideo() {
        val quality = Quality::class.java.declaredConstructors.single().apply {
            isAccessible = true
        }.newInstance(
            "1080p60", "avc1", "source", "source", "source", emptyArray<String>(),
            9_000_000, 1920, 1080, 60f, false
        ) as Quality
        val qualityArguments = CompletableFuture<List<Any?>>()
        val player = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, args ->
            if (method.name == "setQuality") qualityArguments.complete(args.orEmpty().toList())
            null
        } as Player
        val service = IvsPlayerService()
        IvsPlayerService::class.java.getDeclaredField("player").apply {
            isAccessible = true
            set(service, player)
        }
        val fragment = IvsPlayerFragment()
        PlayerFragment::class.java.getDeclaredField("prefs").apply {
            isAccessible = true
            set(fragment, RuntimeEnvironment.getApplication().prefs())
        }
        IvsPlayerFragment::class.java.getDeclaredField("playbackService").apply {
            isAccessible = true
            set(fragment, service)
        }

        try {
            IvsPlayerFragment::class.java.getDeclaredMethod("nudgeQualityToTarget", Quality::class.java).apply {
                isAccessible = true
            }.invoke(fragment, quality)

            assertEquals(listOf(quality, true), qualityArguments.get(5, TimeUnit.SECONDS))
        } finally {
            val executor = IvsPlayerService::class.java.getDeclaredField("playerExecutor").apply {
                isAccessible = true
            }.get(service) as ExecutorService
            executor.shutdownNow()
        }
    }

    @Test
    fun activityPipExitDoesNotDiscardStateNeededByThePlayersStopHandler() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).get()
        val fragment = IvsPlayerFragment()
        val pipState = PlayerFragment::class.java.getDeclaredField("wasInPictureInPictureMode").apply {
            isAccessible = true
            setBoolean(fragment, true)
        }
        MainActivity::class.java.getDeclaredField("playerFragment").apply {
            isAccessible = true
            set(activity, fragment)
        }

        activity.onPictureInPictureModeChanged(false, Configuration())

        assertTrue(pipState.getBoolean(fragment))
    }

    @Test
    fun genuinePipDismissalIsNotMistakenForScreenLockWhenNoUserLeaveHintWasDelivered() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).get()
        val fragment = IvsPlayerFragment()
        val host = object : FragmentHostCallback<MainActivity>(activity, Handler(Looper.getMainLooper()), 0) {
            override fun onGetHost() = activity
        }
        Fragment::class.java.getDeclaredField("mHost").apply {
            isAccessible = true
            set(fragment, host)
        }
        PlayerFragment::class.java.superclass!!.getDeclaredField("componentContext").apply {
            isAccessible = true
            set(fragment, ContextWrapper(activity))
        }
        PlayerFragment::class.java.getDeclaredField("wasInPictureInPictureMode").apply {
            isAccessible = true
            setBoolean(fragment, true)
        }
        PlayerFragment::class.java.getDeclaredField("pipEnteredAtMs").apply {
            isAccessible = true
            setLong(fragment, SystemClock.uptimeMillis())
        }
        SystemClock.sleep(1_000)
        val screenLocked = PlayerFragment::class.java.getDeclaredMethod("isScreenLockedOrOff").apply {
            isAccessible = true
        }

        assertFalse(screenLocked.invoke(fragment) as Boolean)
        val screenOff = PlayerFragment::class.java.getDeclaredField("isScreenOff").apply {
            isAccessible = true
            setBoolean(fragment, true)
        }
        assertTrue(screenLocked.invoke(fragment) as Boolean)
        screenOff.setBoolean(fragment, false)
        fragment.clearPipDismissState()
        assertTrue(screenLocked.invoke(fragment) as Boolean)
    }

    @Test
    fun closeWithoutViewStillClearsSurfaceCallbackAndCanBeRepeated() {
        val fragment = IvsPlayerFragment()
        val callbackField = IvsPlayerFragment::class.java.getDeclaredField("surfaceHolderCallback").apply {
            isAccessible = true
        }
        callbackField.set(fragment, object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) = Unit
            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit
            override fun surfaceDestroyed(holder: SurfaceHolder) = Unit
        })

        fragment.close()

        assertNull(callbackField.get(fragment))
        fragment.close()
    }

    @Test
    fun computeEffectiveBufferMsReturnsZeroWhenBufferingOrIdle() {
        val fragment = IvsPlayerFragment()
        val computeMethod = IvsPlayerFragment::class.java.getDeclaredMethod(
            "computeEffectiveBufferMs",
            Player::class.java,
            Long::class.javaPrimitiveType
        ).apply { isAccessible = true }

        val bufferingPlayer = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            when (method.name) {
                "getState" -> Player.State.BUFFERING
                "getPosition" -> 0L
                "getBufferedPosition" -> 8_000_000L
                else -> null
            }
        } as Player

        val idlePlayer = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            when (method.name) {
                "getState" -> Player.State.IDLE
                "getPosition" -> 10_000L
                "getBufferedPosition" -> 12_000L
                else -> null
            }
        } as Player

        assertEquals(0L, computeMethod.invoke(fragment, bufferingPlayer, 2_280L))
        assertEquals(0L, computeMethod.invoke(fragment, idlePlayer, 2_280L))
    }

    @Test
    fun computeEffectiveBufferMsReturnsFallbackOnlyWhenLivePositionIsUnseekedOrRawBufferIsHuge() {
        val fragment = IvsPlayerFragment()
        PlayerFragment::class.java.getDeclaredField("videoType").apply {
            isAccessible = true
            set(fragment, PlayerFragment.STREAM)
        }
        val computeMethod = IvsPlayerFragment::class.java.getDeclaredMethod(
            "computeEffectiveBufferMs",
            Player::class.java,
            Long::class.javaPrimitiveType
        ).apply { isAccessible = true }

        val unseekedLivePlayer = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            when (method.name) {
                "getState" -> Player.State.PLAYING
                "getPosition" -> 0L
                "getBufferedPosition" -> 8_108_000L
                else -> null
            }
        } as Player

        val normalLivePlayer = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            when (method.name) {
                "getState" -> Player.State.PLAYING
                "getPosition" -> 32_000L
                "getBufferedPosition" -> 33_500L
                else -> null
            }
        } as Player

        assertEquals(1_000L, computeMethod.invoke(fragment, unseekedLivePlayer, 1_000L))
        assertEquals(1_500L, computeMethod.invoke(fragment, normalLivePlayer, 1_000L))
    }

    @Test
    fun goLiveSkipThresholdMatchesCatchupDriftThreshold() {
        assertEquals(LiveLatencySettings.CATCHUP_DRIFT_THRESHOLD_MS, IvsPlayerFragment.GO_LIVE_SKIP_THRESHOLD_MS)
    }
}
