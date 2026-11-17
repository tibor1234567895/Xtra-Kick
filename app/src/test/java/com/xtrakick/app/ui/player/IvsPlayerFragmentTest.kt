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
import androidx.room.Room
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.Quality
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.KickOfficialApiClient
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
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
import java.lang.reflect.Field
import java.lang.reflect.Proxy
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class IvsPlayerFragmentTest {

    @Test
    fun playbackServicesReceiveTaskRemovalCallbacks() {
        val context = RuntimeEnvironment.getApplication()
        for (service in listOf(IvsPlayerService::class.java, PlaybackService::class.java)) {
            val info = context.packageManager.getServiceInfo(android.content.ComponentName(context, service), 0)
            assertEquals(0, info.flags and android.content.pm.ServiceInfo.FLAG_STOP_WITH_TASK)
        }
    }

    @Test
    fun skipsWhileReplayLoadsAdjustThePendingPosition() {
        val fragment = IvsPlayerFragment()
        ReflectionHelpers.setField(fragment, "pendingSeekPosition", 570_000L)
        assertEquals(570_000L, fragment.getCurrentPosition())
        fragment.seek(fragment.getCurrentPosition()!! - 30_000L)
        assertEquals(540_000L, fragment.getCurrentPosition())
        fragment.seek(fragment.getCurrentPosition()!! + 10_000L)
        assertEquals(550_000L, fragment.getCurrentPosition())
    }

    @Test
    fun rewindUsesResolvedStartTimeAndRejectsUnknownTimeline() {
        assertEquals(570_000L, PlayerFragment.liveRewindTargetPosition(30L, 1_000_000L, 1_600_000L, null))
        assertEquals(90_000L, PlayerFragment.liveRewindTargetPosition(30L, null, 1_600_000L, 120_000L))
        assertNull(PlayerFragment.liveRewindTargetPosition(30L, null, 1_600_000L, null))
        assertNull(PlayerFragment.liveRewindTargetPosition(30L, 1_700_000L, 1_600_000L, 0L))
        assertEquals(0L, PlayerFragment.liveRewindTargetPosition(-1L, null, 1_600_000L, null))
        assertEquals(0L, PlayerFragment.liveRewindTargetPosition(300L, null, 1_600_000L, 120_000L))
    }

    @Test
    fun replayLoadDisablesLivePoliciesAndReturningLiveRestoresThem() {
        val service = Robolectric.buildService(IvsPlayerService::class.java).get()
        val context = RuntimeEnvironment.getApplication()
        val executor = Executors.newSingleThreadExecutor()
        val json = Json { ignoreUnknownKeys = true }
        val client = OkHttpClient.Builder().addInterceptor { error("Unexpected network request") }.build()
        val auth = AuthRepository(null, null, executor, client, json)
        val kick = KickRepository(
            context, client, null, executor, json, auth,
            KickOfficialApiClient(context, client, json),
        )
        service.kickRepository = kick
        service.rewardsRepository = KickRewardsRepository(kick, json)
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        val publicApi = KickPublicApiRepository(null, null, executor, client, json)
        val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
        val notifications = NotificationUsersRepository(
            context, database.notificationsDao(), kick, dagger.Lazy { error("Unused FCM") },
        )
        service.shownNotificationsRepository = ShownNotificationsRepository(
            context, database.shownNotificationsDao(), kick, publicApi, notifications, follows,
        )
        val calls = mutableListOf<Pair<String, Any?>>()
        val player = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, args ->
            when (method.name) {
                "setLiveLowLatencyEnabled", "setRebufferToLive", "load", "play" -> {
                    calls += method.name to args?.firstOrNull()
                    null
                }
                "getState" -> Player.State.READY
                "getDuration", "getPosition", "getBufferedPosition", "getLiveLatency" -> 0L
                "getPlaybackRate" -> 1f
                else -> null
            }
        } as Player
        ReflectionHelpers.setField(service, "player", player)
        try {
            service.playStream("https://example.com/replay.m3u8", null, null, null, isLiveRewound = true)
            org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
            assertEquals(listOf("setLiveLowLatencyEnabled" to false, "setRebufferToLive" to false), calls.take(2))
            assertTrue(calls.any { it.first == "load" })
            assertTrue(calls.any { it.first == "play" })

            calls.clear()
            service.enterChatOnly()
            org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
            assertFalse(service.isPlaybackRequested())
            service.play()
            org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
            assertFalse(calls.any { it.first == "play" })

            calls.clear()
            service.playStream("https://example.com/live.m3u8", null, null, null)
            org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
            assertEquals(listOf("setLiveLowLatencyEnabled" to true, "setRebufferToLive" to true), calls.take(2))
        } finally {
            ReflectionHelpers.getField<Handler>(service, "playerHandler").removeCallbacksAndMessages(null)
            executor.shutdownNow()
            database.close()
        }
    }

    @Test
    fun sdkOperationsFromOtherThreadsRunOnMainAndStalePostsAreDiscarded() {
        val service = Robolectric.buildService(IvsPlayerService::class.java).get()
        val calls = mutableListOf<Looper?>()
        val player = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            if (method.name == "play") calls += Looper.myLooper()
            null
        } as Player
        ReflectionHelpers.setField(service, "player", player)
        val sender = Thread { service.runPlayerOp("test") { it.play() } }
        sender.start()
        sender.join(1_000L)
        org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(listOf(Looper.getMainLooper()), calls)

        service.runPlayerOp("stale") { it.play() }
        ReflectionHelpers.setField(service, "player", null)
        org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(1, calls.size)
    }

    @Test
    fun terminalSdkReleaseRunsOnTheSameMainLooper() {
        val service = Robolectric.buildService(IvsPlayerService::class.java).get()
        val calls = mutableListOf<Pair<String, Looper?>>()
        val player = Proxy.newProxyInstance(Player::class.java.classLoader, arrayOf(Player::class.java)) { _, method, _ ->
            calls += method.name to Looper.myLooper()
            if (method.name == "getState") Player.State.READY else null
        } as Player
        IvsPlayerService::class.java.getDeclaredMethod("releasePlayer", Player::class.java).apply {
            isAccessible = true
        }.invoke(service, player)
        org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertTrue(calls.any { it.first == "release" })
        assertTrue(calls.all { it.second == Looper.getMainLooper() })
    }

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
            ReflectionHelpers.getField<Handler>(service, "playerHandler").removeCallbacksAndMessages(null)
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

            org.robolectric.Shadows.shadowOf(Looper.getMainLooper()).idle()
            assertEquals(listOf(quality, true), qualityArguments.get(5, TimeUnit.SECONDS))
        } finally {
            ReflectionHelpers.getField<Handler>(service, "playerHandler").removeCallbacksAndMessages(null)
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

    private fun createTestIvsPlayerService(): Pair<IvsPlayerService, AppDatabase> {
        val service = Robolectric.buildService(IvsPlayerService::class.java).get()
        val context = RuntimeEnvironment.getApplication()
        val executor = Executors.newSingleThreadExecutor()
        val json = Json { ignoreUnknownKeys = true }
        val client = OkHttpClient.Builder().addInterceptor { error("Unexpected network request") }.build()
        val auth = AuthRepository(null, null, executor, client, json)
        val kick = KickRepository(
            context, client, null, executor, json, auth,
            KickOfficialApiClient(context, client, json),
        )
        service.kickRepository = kick
        service.rewardsRepository = KickRewardsRepository(kick, json)
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        val publicApi = KickPublicApiRepository(null, null, executor, client, json)
        val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
        val notifications = NotificationUsersRepository(
            context, database.notificationsDao(), kick, dagger.Lazy { error("Unused FCM") },
        )
        service.shownNotificationsRepository = ShownNotificationsRepository(
            context, database.shownNotificationsDao(), kick, publicApi, notifications, follows,
        )
        return service to database
    }

    private fun playbackRequestedField(): Field {
        return IvsPlayerService::class.java.getDeclaredField("playbackRequested").apply {
            isAccessible = true
        }
    }

    @Test
    fun taskRemovedStopsPlaybackEvenWhenBackgroundPlaybackWasEnabled() {
        val (service, db) = createTestIvsPlayerService()
        try {
            service.setBackgroundPlaybackEnabled(true)
            val field = playbackRequestedField()
            field.setBoolean(service, true)

            service.onTaskRemoved(null)

            assertFalse(service.isBackgroundPlaybackEnabled())
            assertFalse(field.getBoolean(service))
        } finally {
            db.close()
        }
    }

    @Test
    fun taskRemovedPreservesPlaybackWhenPipDismissedWithBackgroundAudio() {
        val (service, db) = createTestIvsPlayerService()
        try {
            service.setBackgroundPlaybackEnabled(true)
            val field = playbackRequestedField()
            field.setBoolean(service, true)
            service.markPipDismissedWithBackgroundAudio()

            service.onTaskRemoved(null)

            assertTrue(service.isBackgroundPlaybackEnabled())
            assertTrue(field.getBoolean(service))
            assertEquals(0L, service.pipDismissedWithBackgroundAudioAtMs)
        } finally {
            db.close()
        }
    }

    @Test
    fun taskRemovedStopsPlaybackWhenPipDismissHandoffExpired() {
        val (service, db) = createTestIvsPlayerService()
        try {
            service.setBackgroundPlaybackEnabled(true)
            val field = playbackRequestedField()
            field.setBoolean(service, true)
            service.pipDismissedWithBackgroundAudioAtMs = SystemClock.elapsedRealtime() - 60_000

            service.onTaskRemoved(null)

            assertFalse(service.isBackgroundPlaybackEnabled())
            assertFalse(field.getBoolean(service))
        } finally {
            db.close()
        }
    }
}
