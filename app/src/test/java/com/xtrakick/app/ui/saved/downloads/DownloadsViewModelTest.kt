package com.xtrakick.app.ui.saved.downloads

import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.OfflineRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowContentResolver
import java.io.File
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class DownloadsViewModelTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    private val repository = OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks())
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val viewModel = DownloadsViewModel(context, repository, scope)
    private val chatFile = File.createTempFile("download-chat", ".json", context.cacheDir)

    @After fun close() {
        scope.cancel()
        database.close()
        chatFile.delete()
    }

    @Test fun localFinalizationPreservesCheckpointAndIsIdempotent() = runBlocking {
        verifyFinalization(chatFile.absolutePath)
    }

    @Test fun sharedStorageFinalizationPreservesCheckpoint() = runBlocking {
        val provider = ChatProvider().apply {
            file = chatFile
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        verifyFinalization("content://download.chat.test/chat")
    }

    @Test fun separateScreensCannotFinalizeTheSameChatConcurrently() = runBlocking {
        val prefix = """{"messages":[{"content":"kept"}]"""
        chatFile.writeText(prefix)
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val secondEntered = CountDownLatch(1)
        val opens = AtomicInteger()
        val provider = ChatProvider().apply {
            file = chatFile
            beforeOpen = { mode ->
                if (mode == "rw") {
                    if (opens.incrementAndGet() == 2) secondEntered.countDown()
                    entered.countDown()
                    check(release.await(5, TimeUnit.SECONDS))
                }
            }
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        val video = OfflineVideo(chatUrl = "content://download.chat.test/chat", chatBytes = prefix.toByteArray().size.toLong(), live = true)
        video.id = repository.saveVideo(video).toInt()
        val secondScreen = DownloadsViewModel(context, repository, scope)
        try {
            viewModel.finishDownload(video)
            assertTrue(entered.await(5, TimeUnit.SECONDS))
            secondScreen.finishDownload(video)
            assertFalse("The second screen must wait until finalization finishes", secondEntered.await(200, TimeUnit.MILLISECONDS))
        } finally {
            release.countDown()
        }
        scope.coroutineContext[Job]!!.children.toList().joinAll()
        assertEquals(2, opens.get())
        assertEquals(prefix + "}", chatFile.readText())
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(video.id)!!.status)
    }

    private suspend fun verifyFinalization(url: String) {
        val prefix = """{"messages":[{"content":"keep this message"}]"""
        chatFile.writeText(prefix + "unfinished trailing data")
        val video = OfflineVideo(chatUrl = url, chatBytes = prefix.toByteArray().size.toLong(), live = true)
        video.id = repository.saveVideo(video).toInt()
        repeat(2) {
            repeat(2) { viewModel.finishDownload(video) }
            scope.coroutineContext[Job]!!.children.toList().joinAll()
            assertEquals(org.robolectric.shadows.ShadowLog.getLogsForTag("Downloads").joinToString { "${it.msg}: ${it.throwable}" },
                OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(video.id)!!.status)
            assertEquals(prefix + "}", chatFile.readText())
            assertEquals("keep this message", JSONObject(chatFile.readText()).getJSONArray("messages").getJSONObject(0).getString("content"))
            assertEquals(OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(video.id)!!.status)
        }
    }

    @Test fun failedFileFinalizationDoesNotMarkVideoCompleted() = runBlocking {
        val video = OfflineVideo(chatUrl = context.cacheDir.absolutePath, live = true)
        video.id = repository.saveVideo(video).toInt()
        viewModel.finishDownload(video)
        scope.coroutineContext[Job]!!.children.toList().joinAll()
        assertEquals(OfflineVideo.STATUS_PENDING, repository.getVideoById(video.id)!!.status)
    }

    class ChatProvider : ContentProvider() {
        lateinit var file: File
        var beforeOpen: ((String) -> Unit)? = null
        override fun onCreate() = true
        override fun openFile(uri: Uri, mode: String): ParcelFileDescriptor {
            beforeOpen?.invoke(mode)
            return ParcelFileDescriptor.open(file, ParcelFileDescriptor.parseMode(mode))
        }
        override fun getType(uri: Uri) = "application/json"
        override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? = null
        override fun insert(uri: Uri, values: ContentValues?): Uri? = null
        override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0
        override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0
    }
}
