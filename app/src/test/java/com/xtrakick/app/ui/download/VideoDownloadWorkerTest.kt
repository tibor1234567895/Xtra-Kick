package com.xtrakick.app.ui.download

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.work.Data
import androidx.work.ForegroundUpdater
import androidx.work.ListenableWorker
import androidx.work.ProgressUpdater
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import androidx.work.WorkManager
import androidx.work.Configuration
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor
import com.google.common.util.concurrent.Futures
import com.sun.net.httpserver.HttpServer
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.util.m3u8.PlaylistUtils
import java.io.File
import java.net.InetSocketAddress
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class VideoDownloadWorkerTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    private val repository = OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks())
    private val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
    private val requests = ConcurrentHashMap<String, AtomicInteger>()
    private val root = File(context.cacheDir, "worker-test").apply { mkdirs() }

    private fun failures(): String = ShadowLog.getLogsForTag("VideoDownloadWorker")
        .joinToString("\n") { "${it.msg}\n${it.throwable?.stackTraceToString().orEmpty()}" }

    @Before fun initializeWorkManager() {
        if (runCatching { WorkManager.getInstance(context) }.isFailure) {
            WorkManager.initialize(context, Configuration.Builder().build())
        }
    }

    @After fun cleanup() { server.stop(0); database.close() }

    private fun worker(id: Int): VideoDownloadWorker {
        val executor = Executor { it.run() }
        val factory = object : WorkerFactory() {
            override fun createWorker(appContext: Context, workerClassName: String, workerParameters: WorkerParameters): ListenableWorker? = null
        }
        val params = WorkerParameters(UUID.randomUUID(), Data.Builder().putInt(VideoDownloadWorker.KEY_VIDEO_ID, id).build(),
            emptyList(), WorkerParameters.RuntimeExtras(), 0, 0, executor, Dispatchers.IO,
            WorkManagerTaskExecutor(executor), factory,
            ProgressUpdater { _, _, _ -> Futures.immediateFuture(null) },
            ForegroundUpdater { _, _, _ -> Futures.immediateFuture(null) })
        return VideoDownloadWorker(context, params).also {
            it.offlineRepository = repository
            it.okHttpClient = OkHttpClient()
        }
    }

    private fun route(path: String, status: Int = 200, body: () -> String) {
        server.createContext(path) { exchange ->
            requests.computeIfAbsent(path) { AtomicInteger() }.incrementAndGet()
            val bytes = body().toByteArray()
            exchange.sendResponseHeaders(status, bytes.size.toLong())
            exchange.responseBody.use { it.write(bytes) }
        }
    }

    @Test fun unsuccessfulFileResponseRemainsPending() = runBlocking {
        route("/expired.mp4", 403) { "access denied" }
        server.start()
        val video = OfflineVideo(sourceUrl = "http://127.0.0.1:${server.address.port}/expired.mp4", downloadPath = root.path)
        video.id = repository.saveVideo(video).toInt()
        assertEquals(ListenableWorker.Result.failure(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_PENDING, stored.status)
        assertEquals(0, stored.progress)
        assertEquals(1, requests["/expired.mp4"]!!.get())
    }

    @Test fun signedPlaylistDownloadsEachSharedAssetOnceAndKeepsOfflineRanges() = runBlocking {
        route("/master.m3u8") {
            "#EXTM3U\n#EXT-X-TARGETDURATION:1\n#EXT-X-MAP:URI=\"/init.mp4\"\n" +
                "#EXTINF:1,\n#EXT-X-BYTERANGE:4@0\n//127.0.0.1:${server.address.port}/asset.bin?signature=test\n" +
                "#EXTINF:1,\n#EXT-X-BYTERANGE:4@4\n//127.0.0.1:${server.address.port}/asset.bin?signature=test\n#EXT-X-ENDLIST\n"
        }
        route("/init.mp4") { "init" }
        route("/asset.bin") { "abcdefgh" }
        server.start()
        val video = OfflineVideo(sourceUrl = "http://127.0.0.1:${server.address.port}/master.m3u8?token=test",
            downloadPath = root.path, downloadDate = 1, playlistToFile = false)
        video.id = repository.saveVideo(video).toInt()
        val result = worker(video.id).doWork()
        assertEquals(failures(), ListenableWorker.Result.success(), result)
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals(2, stored.progress)
        assertEquals(1, requests["/asset.bin"]!!.get())
        assertEquals(1, requests["/init.mp4"]!!.get())
        val localFile = File(stored.url!!)
        val playlist = localFile.inputStream().use(PlaylistUtils::parseMediaPlaylist)
        assertEquals(listOf(0L, 4L), playlist.segments.map { it.byteRangeStart })
        assertEquals(listOf(4L, 4L), playlist.segments.map { it.byteRangeLength })
        assertEquals("abcdefgh", File(localFile.parentFile, playlist.segments.first().uri).readText())
        assertEquals("init", File(localFile.parentFile, playlist.initSegmentUri!!).readText())
    }

    @Test fun concatenationUsesExactRangesWhenTheServerIgnoresRangeHeaders() = runBlocking {
        route("/master.m3u8") {
            "#EXTM3U\n#EXT-X-TARGETDURATION:1\n#EXTINF:1,\n#EXT-X-BYTERANGE:3@1\nasset.ts\n#EXTINF:1,\n#EXT-X-BYTERANGE:2@5\nasset.ts\n#EXT-X-ENDLIST\n"
        }
        route("/asset.ts") { "abcdefgh" }
        server.start()
        val video = OfflineVideo(sourceUrl = "http://127.0.0.1:${server.address.port}/master.m3u8",
            downloadPath = root.path, downloadDate = 2, playlistToFile = true)
        video.id = repository.saveVideo(video).toInt()
        val result = worker(video.id).doWork()
        assertEquals(failures(), ListenableWorker.Result.success(), result)
        assertEquals("bcdfg", File(repository.getVideoById(video.id)!!.url!!).readText())
    }
}
