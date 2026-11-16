package com.xtrakick.app.ui.player

import android.app.Application
import android.os.Bundle
import android.os.Looper
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.SurfaceHolder
import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import androidx.media3.session.MediaController
import androidx.media3.session.SessionCommand
import androidx.media3.session.SessionResult
import androidx.room.Room
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentPlayerBinding
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.BookmarksRepository
import com.xtrakick.app.repository.KickOfficialApiClient
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import kotlinx.serialization.json.Json
import kotlinx.coroutines.Job
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.shadow.api.Shadow
import org.robolectric.util.ReflectionHelpers
import java.util.concurrent.Executors

@OptIn(UnstableApi::class)
@Config(application = Application::class, shadows = [Media3FragmentTest.RecordingController::class])
@RunWith(RobolectricTestRunner::class)
class Media3FragmentTest {
    @Test
    fun unchangedMetadataKeepsTheActiveWatchSession() {
        var playing = false
        val owner = KickViewerWatchOwner(kick, null, isRewardsEnabled = { true }, isPlaying = { playing })
        val job = Job()
        try {
            owner.setMetadata("42", "123", "channel")
            owner.javaClass.getDeclaredField("job").apply { isAccessible = true }.set(owner, job)
            playing = true
            owner.setMetadata("42", "123", "channel")
            assertTrue(job.isActive)
            playing = false
            owner.setMetadata("43", "124", "other")
            assertTrue(job.isCancelled)
        } finally {
            owner.release()
        }
    }

    private val appContext = RuntimeEnvironment.getApplication()
    private val controller = Shadow.newInstanceOf(MediaController::class.java)
    private val playback = Shadow.extract<RecordingController>(controller)
    private val database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java).build()
    private val executor = Executors.newSingleThreadExecutor()
    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder().addInterceptor { error("Unexpected network request") }.build()
    private val auth = AuthRepository(null, null, executor, client, json)
    private val kick = KickRepository(
        appContext, client, null, executor, json, auth, KickOfficialApiClient(appContext, client, json),
    )
    private val publicApi = KickPublicApiRepository(null, null, executor, client, json)
    private val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
    private val notifications = NotificationUsersRepository(
        appContext, database.notificationsDao(), kick, dagger.Lazy { error("Unused FCM") },
    )
    private val playbackModel = PlayerViewModel(
        publicApi, kick, follows,
        ShownNotificationsRepository(appContext, database.shownNotificationsDao(), kick, publicApi, notifications, follows),
        notifications,
        PlayerRepository(
            appContext, null, null, executor, client, json, kick, publicApi,
            database.recentEmotes(), database.videoPositions(),
        ),
        BookmarksRepository(database.bookmarks(), database.videos()),
        OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks()),
    )
    private val fragment = Media3Fragment().apply {
        val prefs = appContext.prefs()
        prefs.edit()
            .putBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO, false)
            .putBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO_LOCKED, false)
            .putBoolean(AppConstants.PLAYER_DISABLE_BACKGROUND_VIDEO, false)
            .commit()
        ReflectionHelpers.setField(this, "prefs", prefs)
        ReflectionHelpers.setField(this, "viewModel\$delegate", lazyOf(playbackModel))
        ReflectionHelpers.setField(this, "controllerFuture", Futures.immediateFuture(controller))
        val themedContext = ContextThemeWrapper(appContext, R.style.BaseDarkTheme)
        ReflectionHelpers.setField(this, "_binding", FragmentPlayerBinding.inflate(LayoutInflater.from(themedContext)))
    }

    @After
    fun close() {
        database.close()
        executor.shutdownNow()
    }

    @Test
    fun chatOnlyReplayClockAdvancesAndSeeksWithoutPlayingVideo() {
        ReflectionHelpers.callInstanceMethod<Void>(fragment, "startChatOnlyClock",
            ReflectionHelpers.ClassParameter.from(Long::class.javaPrimitiveType, 30_000L))
        playbackModel.quality = "chat_only"
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(3))
        assertEquals(33_000L, fragment.getChatPosition())
        assertTrue(fragment.isChatPlaybackPlaying())
        fragment.seek(5_000L)
        assertEquals(5_000L, fragment.getChatPosition())
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(2))
        assertEquals(7_000L, fragment.getChatPosition())
        playbackModel.quality = "auto"
        assertEquals(fragment.getCurrentPosition(), fragment.getChatPosition())
    }

    private fun attachForModeChanges(target: PlayerFragment = fragment) {
        val activity = org.robolectric.Robolectric.buildActivity(androidx.fragment.app.FragmentActivity::class.java).get()
        val host = object : androidx.fragment.app.FragmentHostCallback<androidx.fragment.app.FragmentActivity>(
            activity, android.os.Handler(Looper.getMainLooper()), 0,
        ) {
            override fun onGetHost() = activity
        }
        ReflectionHelpers.setField(target, "mHost", host)
        PlayerFragment::class.java.superclass!!.getDeclaredField("componentContext").apply {
            isAccessible = true
            set(target, android.content.ContextWrapper(activity))
        }
        val binding = ReflectionHelpers.getField<FragmentPlayerBinding>(fragment, "_binding")
        ReflectionHelpers.setField(target, "mView", binding.root)
        target.arguments = Bundle()
        target.networkMonitor = com.xtrakick.app.util.NetworkMonitor(appContext)
    }

    @Test
    @Config(sdk = [28])
    fun restoringChatOnlyStopsPlaybackWithoutRestartingItsClock() {
        attachForModeChanges()
        playbackModel.quality = "chat_only"
        ReflectionHelpers.callInstanceMethod<Void>(fragment, "startChatOnlyClock",
            ReflectionHelpers.ClassParameter.from(Long::class.javaPrimitiveType, 30_000L))
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(3))
        fragment.changeQuality("chat_only")
        assertEquals(1, playback.stops)
        assertEquals(33_000L, fragment.getChatPosition())
        fragment.startStream("https://example.com/live.m3u8")
        assertEquals(2, playback.stops)
        assertTrue(playback.commands.isEmpty())
        assertEquals(33_000L, fragment.getChatPosition())
    }

    @Test
    @Config(sdk = [28])
    fun leavingRewoundChatOnlyForAudioOnlyPreservesAudioModeAndRecordingPosition() {
        attachForModeChanges()
        playbackModel.quality = "chat_only"
        playbackModel.isLiveRewound = true
        ReflectionHelpers.setField(fragment, "videoType", "stream")
        ReflectionHelpers.setField(fragment, "activePlaybackUrl", "https://example.com/recording.m3u8")
        ReflectionHelpers.callInstanceMethod<Void>(fragment, "startChatOnlyClock",
            ReflectionHelpers.ClassParameter.from(Long::class.javaPrimitiveType, 30_000L))
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(3))
        fragment.changeQuality("audio_only")
        assertTrue(playback.tracks.disabledTrackTypes.contains(androidx.media3.common.C.TRACK_TYPE_VIDEO))
        val binding = ReflectionHelpers.getField<FragmentPlayerBinding>(fragment, "_binding")
        assertEquals(android.view.View.GONE, binding.playerSurface.visibility)
        val command = playback.commands.single { it.customAction == PlaybackService.START_VIDEO }
        assertEquals("https://example.com/recording.m3u8", command.customExtras.getString(PlaybackService.URI))
        assertEquals(33_000L, command.customExtras.getLong(PlaybackService.PLAYBACK_POSITION))
        assertTrue(playback.playRequested)
    }

    @Test
    fun ivsChatOnlySeekUpdatesItsClockEvenWithAPendingPlayerSeek() {
        val ivs = IvsPlayerFragment()
        ReflectionHelpers.setField(ivs, "viewModel\$delegate", lazyOf(playbackModel))
        playbackModel.quality = "chat_only"
        ReflectionHelpers.setField(ivs, "pendingSeekPosition", 30_000L)
        ReflectionHelpers.callInstanceMethod<Void>(ivs, "startChatOnlyClock",
            ReflectionHelpers.ClassParameter.from(Long::class.javaPrimitiveType, 30_000L))
        ivs.seek(5_000L)
        assertEquals(5_000L, ivs.getChatPosition())
        assertNull(ReflectionHelpers.getField<Long?>(ivs, "pendingSeekPosition"))
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(2))
        assertEquals(7_000L, ivs.getChatPosition())
    }

    @Test
    fun changingChatOnlySpeedKeepsTheElapsedPositionAndUsesTheNewRate() {
        ReflectionHelpers.callInstanceMethod<Void>(fragment, "startChatOnlyClock",
            ReflectionHelpers.ClassParameter.from(Long::class.javaPrimitiveType, 30_000L))
        playbackModel.quality = "chat_only"
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(3))
        fragment.setPlaybackSpeed(2f)
        assertEquals(33_000L, fragment.getChatPosition())
        org.robolectric.shadows.ShadowSystemClock.advanceBy(java.time.Duration.ofSeconds(2))
        assertEquals(37_000L, fragment.getChatPosition())
    }

    @Test
    fun chatOnlyUsesFullHeightAndKeepsPlaybackActionsAccessibleAfterRotation() {
        val binding = ReflectionHelpers.getField<FragmentPlayerBinding>(fragment, "_binding")
        playbackModel.quality = "chat_only"
        binding.playerControls.title.text = "Current stream title"
        binding.playerControls.title.visibility = android.view.View.VISIBLE
        var openedChannel = false
        binding.playerControls.channel.setOnClickListener { openedChannel = true }
        val updateLayout = PlayerFragment::class.java.getDeclaredMethod(
            "updateChatOnlyLayout", Boolean::class.javaPrimitiveType,
        ).apply { isAccessible = true }

        for (portrait in listOf(true, false)) {
            binding.chatLayout.isPortrait = portrait
            updateLayout.invoke(fragment, false)
            binding.chatLayout.measure(
                android.view.View.MeasureSpec.makeMeasureSpec(1080, android.view.View.MeasureSpec.EXACTLY),
                android.view.View.MeasureSpec.makeMeasureSpec(1920, android.view.View.MeasureSpec.EXACTLY),
            )
            assertEquals(1920, binding.chatLayout.measuredHeight)
            assertEquals(android.view.View.GONE, binding.playerLayout.visibility)
            assertEquals(android.view.View.VISIBLE, binding.chatOnlyHeader.visibility)
            assertTrue(binding.chatOnlyWatch.hasOnClickListeners())
            assertTrue(binding.chatOnlySettings.hasOnClickListeners())
            assertEquals("Current stream title", binding.chatOnlyTitle.text.toString())
        }
        binding.chatOnlyChannel.performClick()
        assertTrue(openedChannel)
    }

    @Test
    fun destroyViewWithRegisteredSurfaceCallbackClearsBindingAndCanBeRepeated() {
        val callback = object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) = Unit
            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit
            override fun surfaceDestroyed(holder: SurfaceHolder) = Unit
        }
        val binding = ReflectionHelpers.getField<FragmentPlayerBinding>(fragment, "_binding")
        binding.playerSurface.holder.addCallback(callback)
        ReflectionHelpers.setField(fragment, "surfaceHolderCallback", callback)

        fragment.onDestroyView()

        assertNull(ReflectionHelpers.getField<Any?>(fragment, "surfaceHolderCallback"))
        assertNull(ReflectionHelpers.getField<Any?>(fragment, "_binding"))
        fragment.onDestroyView()
    }

    @Test
    fun playingSessionKeepsItsResumeRequestWhenTheAppStops() {
        fragment.onPause()
        assertTrue(controller.playWhenReady)
        fragment.onStop()

        assertFalse(controller.playWhenReady)
        assertTrue(playbackModel.resume)
    }

    @Test
    fun userPausedSessionDoesNotRequestResumeWhenTheAppStops() {
        playback.playRequested = false
        fragment.onPause()
        fragment.onStop()

        assertFalse(controller.playWhenReady)
        assertFalse(playbackModel.resume)
    }

    @Test
    fun backgroundAudioContinuesWithoutRequestingResume() {
        appContext.prefs().edit().putBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO, true).commit()
        fragment.onPause()
        fragment.onStop()

        assertTrue(controller.playWhenReady)
        assertFalse(playbackModel.resume)
        assertTrue(playbackModel.restoreQuality)
    }

    @Implements(MediaController::class, isInAndroidSdk = false)
    class RecordingController {
        var playRequested = true
        var stops = 0
        var tracks = androidx.media3.common.TrackSelectionParameters.DEFAULT
        val commands = mutableListOf<SessionCommand>()

        @Implementation
        fun getTrackSelectionParameters() = tracks

        @Implementation
        fun setTrackSelectionParameters(value: androidx.media3.common.TrackSelectionParameters) { tracks = value }

        @Implementation
        fun getCurrentMediaItem(): androidx.media3.common.MediaItem? = null

        @Implementation
        fun getPlaybackState() = androidx.media3.common.Player.STATE_IDLE

        @Implementation
        fun getBufferedPosition() = 0L

        @Implementation
        fun stop() { stops++; playRequested = false }

        @Implementation
        fun play() { playRequested = true }

        @Implementation
        fun setPlaybackSpeed(speed: Float) = Unit

        @Implementation
        fun isConnected() = true

        @Implementation
        fun getPlayWhenReady() = playRequested

        @Implementation
        fun getPlaybackParameters() = androidx.media3.common.PlaybackParameters.DEFAULT

        @Implementation
        fun getCurrentPosition() = 0L

        @Implementation
        fun getDuration() = 120_000L

        @Implementation
        fun isPlaying() = false

        @Implementation
        fun getApplicationLooper(): Looper = Looper.getMainLooper()

        @Implementation
        fun pause() {
            playRequested = false
        }

        @Implementation
        fun clearVideoSurface() = Unit

        @Implementation
        fun sendCustomCommand(command: SessionCommand, args: Bundle): ListenableFuture<SessionResult> {
            commands += command
            return Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
        }

        @Implementation
        fun release() = Unit
    }
}
