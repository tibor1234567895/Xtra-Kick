package com.xtrakick.app.ui.settings

import androidx.lifecycle.ViewModelStore
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.KickOfficialApiClient
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.repository.RecentSearchRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.File
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class SettingsLeftoverFilesTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    private val executor = Executors.newSingleThreadExecutor()
    private val client = OkHttpClient()
    private val json = Json { ignoreUnknownKeys = true }
    private val auth = AuthRepository(null, null, executor, client, json)
    private val kick = KickRepository(context, client, null, executor, json, auth, KickOfficialApiClient(context, client, json))
    private val publicApi = KickPublicApiRepository(null, null, executor, client, json)
    private val offline = OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks())
    private val player = PlayerRepository(context, null, null, executor, client, json, kick, publicApi,
        database.recentEmotes(), database.videoPositions())
    private val follows = LocalFollowChannelRepository(database.localFollowsChannel(), database)
    private val notifications = NotificationUsersRepository(context, database.notificationsDao(), kick, dagger.Lazy { error("Unused FCM") })
    private val shown = ShownNotificationsRepository(context, database.shownNotificationsDao(), kick, publicApi, notifications, follows)
    private val model = SettingsViewModel(context, player, offline, RecentSearchRepository(database.recentSearchDao()), shown,
        notifications, database, null, null, executor, client, json)
    private val store = ViewModelStore().apply { put("settings", model) }
    private val directory = File(context.getExternalFilesDirs(".downloads").first(), "mixed-container").apply { mkdirs() }

    @After fun close() {
        store.clear()
        database.close()
        executor.shutdownNow()
        directory.deleteRecursively()
    }

    @Test fun anUnreferencedPlaylistCannotMakeAReferencedConvertedVideoDisposable() = runBlocking {
        File(directory, "orphan.m3u8").writeText("#EXTM3U\n")
        val converted = File(directory, "converted.mp4").apply { writeText("saved video") }
        offline.saveVideo(OfflineVideo(url = converted.path))
        val result = async(start = CoroutineStart.UNDISPATCHED) { withTimeout(5000) { model.leftoverScan.first() } }
        model.scanLeftoverFiles()
        assertEquals(0, result.await().count)
    }

    @Test fun aReferencedChatFileAlsoProtectsItsContainer() = runBlocking {
        File(directory, "orphan.m3u8").writeText("#EXTM3U\n")
        val chat = File(directory, "video_chat.json").apply { writeText("{}") }
        offline.saveVideo(OfflineVideo(chatUrl = chat.path))
        val result = async(start = CoroutineStart.UNDISPATCHED) { withTimeout(5000) { model.leftoverScan.first() } }
        model.scanLeftoverFiles()
        assertEquals(0, result.await().count)
    }

    @Test fun aContainerWithNoLibraryReferencesCanStillBeFound() = runBlocking {
        File(directory, "orphan.m3u8").writeText("#EXTM3U\n")
        val result = async(start = CoroutineStart.UNDISPATCHED) { withTimeout(5000) { model.leftoverScan.first() } }
        model.scanLeftoverFiles()
        assertEquals(listOf(directory.name), result.await().names)
    }
}
