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
        val body = if (chain.request().url.encodedPath == "/api/v1/clips/working") {
            """{"data":{"id":"working","playback_url":"https://clips.kick.com/working/playlist.m3u8"}}"""
        } else {
            """{"data":[]}"""
        }
        Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(200).message("fixture")
            .body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()
    private val auth = AuthRepository(null, null, executor, client, json)
    private val kick = KickRepository(context, client, null, executor, json, auth, KickOfficialApiClient(context, client, json))
    private val publicApi = KickPublicApiRepository(null, null, executor, client, json)
    private val player = PlayerRepository(context, null, null, executor, client, json, kick, publicApi,
        database.recentEmotes(), database.videoPositions())
    private val viewModel = MainViewModel(context, publicApi, kick, player,
        OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks()), auth,
        null, null, executor, client, json, dagger.Lazy { error("Unused FCM") }, KickAccountMutedUsersStore(kick))
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

    private suspend fun loadClip(id: String) {
        viewModel.loadClip(id, "OkHttp", emptyMap(), emptyMap(), false)
        withTimeout(5_000) {
            while (viewModel.viewModelScope.coroutineContext[Job]!!.children.any { it.isActive }) {
                shadowOf(Looper.getMainLooper()).idle()
                delay(5)
            }
        }
    }
}
