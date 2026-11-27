package com.xtrakick.app.ui.main

import android.os.Looper
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.KickAccountMutedUsersStore
import com.xtrakick.app.repository.KickOfficialApiClient
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class MainViewModelTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    private val executor = Executors.newSingleThreadExecutor()
    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val path = chain.request().url.encodedPath
        val code = if (path.startsWith("/repos/") || path.endsWith("release-version.json")) updateFeedStatusCode else 200
        val body = when {
            path == "/api/v1/clips/working" ->
                """{"data":{"id":"working","playback_url":"https://clips.kick.com/working/playlist.m3u8"}}"""
            path.startsWith("/repos/") ->
                """{"published_at":"2026-11-18T12:00:00Z","assets":[
                    {"name":"app-release.apk","browser_download_url":"https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk"},
                    {"name":"release-version.json","browser_download_url":"https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/release-version.json"}
                ]}"""
            path.endsWith("release-version.json") ->
                """{"versionCode":$updateReleaseVersionCode}"""
            else ->
                """{"data":[]}"""
        }
        if (path.startsWith("/repos/")) updateFeedRequests++
        Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(code).message("fixture")
            .body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()
    private var updateFeedStatusCode = 200
    private var updateFeedRequests = 0
    private var updateReleaseVersionCode = BuildConfig.VERSION_CODE
    private val auth = AuthRepository(null, null, executor, client, json)
    private val kick = KickRepository(context, client, null, executor, json, auth, KickOfficialApiClient(context, client, json))
    private val publicApi = KickPublicApiRepository(null, null, executor, client, json)
    private val player = PlayerRepository(context, null, null, executor, client, json, kick,
        database.recentEmotes(), database.videoPositions())
    private val viewModel = MainViewModel(context, publicApi, kick, player,
        OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks()), auth,
        client, json, dagger.Lazy { error("Unused FCM") }, KickAccountMutedUsersStore(kick))
    private val store = ViewModelStore().apply { put("main", viewModel) }

    @After fun close() {
        store.clear()
        shadowOf(Looper.getMainLooper()).idle()
        database.close()
        executor.shutdownNow()
    }

    @Test fun openingClipAndClearingConsumedValueDoesNotReportLoadFailure() = runBlocking {
        val opened = mutableListOf<Clip>()
        val collector = launch(Dispatchers.Unconfined) {
            viewModel.clip.collect { clip ->
                if (clip != null) {
                    opened += clip
                    viewModel.clip.value = null
                }
            }
        }
        try {
            loadClip("working")

            assertEquals(listOf("working"), opened.map { it.id })
            assertNull(viewModel.clip.value)
            assertFalse(viewModel.clipLoadFailed.value)
        } finally {
            collector.cancel()
        }
    }

    @Test fun unavailableClipStillReportsLoadFailure() = runBlocking {
        loadClip("missing")

        assertNull(viewModel.clip.value)
        assertTrue(viewModel.clipLoadFailed.value)
    }

    @Test fun successfulLoadClearsPreviousFailure() = runBlocking {
        loadClip("missing")
        assertTrue(viewModel.clipLoadFailed.value)

        loadClip("working")

        assertEquals("working", viewModel.clip.value?.id)
        assertFalse(viewModel.clipLoadFailed.value)
    }

    @Test
    @Config(sdk = [26, 27, 28, 29, 30, 31, 32, 33])
    fun autoUpdateOffersNewerReleaseOnOlderAndroidWithHttpEnginePref() = runBlocking {
        context.prefs().edit().putString(AppConstants.NETWORK_LIBRARY, "HttpEngine").commit()
        updateReleaseVersionCode = BuildConfig.VERSION_CODE + 1

        viewModel.checkUpdatesIfNeeded()
        awaitViewModelChildren()

        assertEquals(1, updateFeedRequests)
        assertEquals(
            "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk",
            viewModel.updateInfo.replayCache.single()?.downloadUrl,
        )
    }

    @Test fun failedAutoUpdateCheckDoesNotStampTimestampAndRetriesAfterRecovery() = runBlocking {
        context.prefs().edit().putBoolean(AppConstants.UPDATE_CHECK_ENABLED, true)
            .putString(AppConstants.UPDATE_CHECK_FREQUENCY, "1").commit()
        context.tokenPrefs().edit().putLong(AppConstants.UPDATE_LAST_CHECK_TIMESTAMP, 0L).commit()

        updateFeedStatusCode = 500
        viewModel.checkUpdatesIfNeeded(now = 1_800_000_000_000L, elapsedRealtimeMs = 10_000L)
        awaitViewModelChildren()

        assertEquals(1, updateFeedRequests)
        assertEquals(0L, context.tokenPrefs().getLong(AppConstants.UPDATE_LAST_CHECK_TIMESTAMP, 0L))

        // Immediate retry without bypass is throttled by the short failure cooldown.
        viewModel.checkUpdatesIfNeeded(now = 1_800_000_001_000L, elapsedRealtimeMs = 11_000L)
        awaitViewModelChildren()
        assertEquals(1, updateFeedRequests)

        // Network reconnect (bypassFailureCooldown=true) retries immediately and stamps on success.
        updateFeedStatusCode = 200
        viewModel.checkUpdatesIfNeeded(bypassFailureCooldown = true, now = 1_800_000_002_000L, elapsedRealtimeMs = 12_000L)
        awaitViewModelChildren()

        assertEquals(2, updateFeedRequests)
        assertEquals(1_800_000_002_000L, context.tokenPrefs().getLong(AppConstants.UPDATE_LAST_CHECK_TIMESTAMP, 0L))

        // Next foreground resume within 24h does not re-check.
        viewModel.checkUpdatesIfNeeded(now = 1_800_000_060_000L, elapsedRealtimeMs = 70_000L)
        awaitViewModelChildren()
        assertEquals(2, updateFeedRequests)

        // Foreground resume after >24h re-checks without requiring Activity recreation.
        viewModel.checkUpdatesIfNeeded(now = 1_800_086_403_000L, elapsedRealtimeMs = 86_413_000L)
        awaitViewModelChildren()
        assertEquals(3, updateFeedRequests)

        // Forward clock skew (stored timestamp in the future) self-heals instead of locking out checks.
        context.tokenPrefs().edit().putLong(AppConstants.UPDATE_LAST_CHECK_TIMESTAMP, 1_900_000_000_000L).commit()
        viewModel.checkUpdatesIfNeeded(now = 1_800_086_500_000L, elapsedRealtimeMs = 86_510_000L)
        awaitViewModelChildren()
        assertEquals(4, updateFeedRequests)
        assertEquals(1_800_086_500_000L, context.tokenPrefs().getLong(AppConstants.UPDATE_LAST_CHECK_TIMESTAMP, 0L))
    }

    private suspend fun loadClip(id: String) {
        viewModel.loadClip(id)
        awaitViewModelChildren()
    }

    private suspend fun awaitViewModelChildren() {
        withTimeout(5_000) {
            while (viewModel.viewModelScope.coroutineContext[Job]!!.children.any { it.isActive }) {
                shadowOf(Looper.getMainLooper()).idle()
                delay(5)
            }
        }
    }
}
