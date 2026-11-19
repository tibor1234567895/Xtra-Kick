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
    @Test fun transferProgressDoesNotMarkAnOpenResponseComplete() {
        assertEquals(50, VideoDownloadWorker.transferProgress(50L, 100L, 100))
        assertEquals(99, VideoDownloadWorker.transferProgress(100L, 100L, 100))
        assertEquals(99, VideoDownloadWorker.transferProgress(200L, 100L, 100))
        assertEquals(50, VideoDownloadWorker.transferProgress(3_000_000_000L, 6_000_000_000L, 100))
        assertNull(VideoDownloadWorker.transferProgress(10L, -1L, 100))
        assertNull(VideoDownloadWorker.transferProgress(10L, 100L, 0))
    }

    @Test fun chatOffsetsKeepPreClipHistoryBeforeTheStart() {
        val start = java.time.Instant.parse("2026-11-09T20:26:55.001Z").toEpochMilli()
        val message = com.xtrakick.app.model.kick.KickMessage(createdAt = "2026-11-09T20:26:55Z")
        assertEquals(-1, worker(0).getKickChatOffsetSeconds(message, start))
        val laterMessage = com.xtrakick.app.model.kick.KickMessage(createdAt = "2026-11-09T20:27:00Z")
        assertEquals(4, worker(0).getKickChatOffsetSeconds(laterMessage, start))
    }

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

    private fun worker(id: Int, forceChatRedownload: Boolean = false): VideoDownloadWorker {
        val executor = Executor { it.run() }
        val factory = object : WorkerFactory() {
            override fun createWorker(appContext: Context, workerClassName: String, workerParameters: WorkerParameters): ListenableWorker? = null
        }
        val params = WorkerParameters(UUID.randomUUID(), Data.Builder()
            .putInt(VideoDownloadWorker.KEY_VIDEO_ID, id)
            .putBoolean(VideoDownloadWorker.KEY_FORCE_CHAT_REDOWNLOAD, forceChatRedownload)
            .build(),
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

    // ---- Issue #150: resume-state classification for single-file rows ----

    private fun routeChunked(path: String, body: () -> String) {
        server.createContext(path) { exchange ->
            requests.computeIfAbsent(path) { AtomicInteger() }.incrementAndGet()
            val bytes = body().toByteArray()
            exchange.sendResponseHeaders(200, 0)
            exchange.responseBody.use { it.write(bytes) }
        }
    }

    private fun routeEmpty(path: String) {
        server.createContext(path) { exchange ->
            requests.computeIfAbsent(path) { AtomicInteger() }.incrementAndGet()
            exchange.sendResponseHeaders(200, -1)
        }
    }

    private fun playlistOf(vararg segments: String, initUri: String? = null): String = buildString {
        append("#EXTM3U\n#EXT-X-TARGETDURATION:1\n")
        initUri?.let { append("#EXT-X-MAP:URI=\"$initUri\"\n") }
        segments.forEach { append("#EXTINF:1,\n$it\n") }
        append("#EXT-X-ENDLIST\n")
    }

    private suspend fun seedSingleFileRow(
        playlistPath: String, url: String,
        progress: Int, maxProgress: Int, bytes: Long, status: Int, date: Long,
    ): OfflineVideo {
        val video = OfflineVideo(
            sourceUrl = "http://127.0.0.1:${server.address.port}$playlistPath",
            downloadPath = root.path, downloadDate = date, playlistToFile = true, status = status,
        )
        video.id = repository.saveVideo(video).toInt()
        video.url = url
        video.bytes = bytes
        video.maxProgress = maxProgress
        repository.updateVideoPlaylist(video)
        video.progress = progress
        repository.updateProgress(video)
        return video
    }

    @Test fun consistentSingleFileResumeAppendsOnlyMissingSegments() = runBlocking {
        route("/resume.m3u8") { playlistOf("s0.ts", "s1.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val partial = File(root, "partial-resume.ts").apply { writeText("XY") }
        val video = seedSingleFileRow("/resume.m3u8", partial.path, progress = 1, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_PENDING, date = 20)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals(2, stored.progress)
        assertEquals(2, stored.maxProgress)
        assertEquals("XYBB", File(stored.url!!).readText())
        assertEquals(1, requests["/s1.ts"]!!.get())
        assertNull(requests["/s0.ts"])
    }

    @Test fun driftedPlaylistOnInterruptedRowResetsAndRedownloadsTheWholeRange() = runBlocking {
        route("/drift.m3u8") { playlistOf("s0.ts", "s1.ts", "s2.ts", "s3.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        route("/s2.ts") { "CC" }
        route("/s3.ts") { "DD" }
        server.start()
        val partial = File(root, "partial-drift.ts").apply { writeText("XY") }
        val video = seedSingleFileRow("/drift.m3u8", partial.path, progress = 1, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_PENDING, date = 21)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals(4, stored.progress)
        assertEquals(4, stored.maxProgress)
        assertEquals("AABBCCDD", File(stored.url!!).readText())
    }

    @Test fun inflatedCounterOnInterruptedRowResetsAndRedownloadsTheWholeRange() = runBlocking {
        route("/inflated.m3u8") { playlistOf("s0.ts", "s1.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val partial = File(root, "partial-inflated.ts").apply { writeText("XY") }
        val video = seedSingleFileRow("/inflated.m3u8", partial.path, progress = 5, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_PENDING, date = 22)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals(2, stored.progress)
        assertEquals(2, stored.maxProgress)
        assertEquals("AABB", File(stored.url!!).readText())
    }

    @Test fun finalizedRowKeepsItsFileAndSkipsTheVideoPhase() = runBlocking {
        route("/final.m3u8") { playlistOf("s0.ts", "s1.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val finished = File(root, "finalized.ts").apply { writeText("XY") }
        val video = seedSingleFileRow("/final.m3u8", finished.path, progress = 2, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_DOWNLOADED, date = 23)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals("XY", File(stored.url!!).readText())
        assertNull(requests["/s0.ts"])
        assertNull(requests["/s1.ts"])
    }

    @Test fun finalizedRowWithEmptyOutputIsRebuilt() = runBlocking {
        route("/repair.m3u8") { playlistOf("s0.ts", "s1.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val empty = File(root, "broken-finalized.ts").apply { writeText("") }
        val video = seedSingleFileRow("/repair.m3u8", empty.path, progress = 2, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_DOWNLOADED, date = 24)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals(2, stored.progress)
        assertEquals(2, stored.maxProgress)
        assertEquals("AABB", File(stored.url!!).readText())
    }

    @Test fun emptySegmentResponseFailsTheRunAndKeepsCountersUntouched() = runBlocking {
        route("/empty-seg.m3u8") { playlistOf("s0.ts", "s1.ts") }
        routeEmpty("/s0.ts")
        route("/s1.ts") { "BB" }
        server.start()
        val video = OfflineVideo(sourceUrl = "http://127.0.0.1:${server.address.port}/empty-seg.m3u8",
            downloadPath = root.path, downloadDate = 25, playlistToFile = true)
        video.id = repository.saveVideo(video).toInt()
        assertEquals(ListenableWorker.Result.failure(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_PENDING, stored.status)
        assertEquals(0, stored.progress)
        assertEquals(1, requests["/s0.ts"]!!.get())
    }

    @Test fun chunkedInitSegmentIsCountedFromActualBytes() = runBlocking {
        route("/chunked.m3u8") { playlistOf("s0.ts", "s1.ts", initUri = "/init.mp4") }
        routeChunked("/init.mp4") { "INITDATA" }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val video = OfflineVideo(sourceUrl = "http://127.0.0.1:${server.address.port}/chunked.m3u8",
            downloadPath = root.path, downloadDate = 26, playlistToFile = true)
        video.id = repository.saveVideo(video).toInt()
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals("INITDATAAABB", File(stored.url!!).readText())
        assertEquals(File(stored.url!!).length(), stored.bytes)
    }

    @Test fun resetWithInitSegmentRebuildsTheContainerAndPersistsCounters() = runBlocking {
        route("/reset-init.m3u8") { playlistOf("s0.ts", "s1.ts", "s2.ts", "s3.ts", initUri = "/init.mp4") }
        route("/init.mp4") { "INITDATA" }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        route("/s2.ts") { "CC" }
        route("/s3.ts") { "DD" }
        server.start()
        val partial = File(root, "partial-reset-init.ts").apply { writeText("XY") }
        val video = seedSingleFileRow("/reset-init.m3u8", partial.path, progress = 1, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_PENDING, date = 27)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals(4, stored.progress)
        assertEquals(4, stored.maxProgress)
        assertEquals("INITDATAAABBCCDD", File(stored.url!!).readText())
        assertEquals(File(stored.url!!).length(), stored.bytes)
    }

    @Test fun convertedPlaylistRowKeepsItsFileAndSkipsTheVideoPhase() = runBlocking {
        route("/converted.m3u8") { playlistOf("s0.ts", "s1.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val converted = File(root, "converted.mp4").apply { writeText("XY") }
        val video = OfflineVideo(
            sourceUrl = "http://127.0.0.1:${server.address.port}/converted.m3u8",
            downloadPath = root.path, downloadDate = 28, playlistToFile = false, status = OfflineVideo.STATUS_PENDING,
        )
        video.id = repository.saveVideo(video).toInt()
        video.url = converted.path
        video.bytes = 2L
        video.maxProgress = 100
        repository.updateVideoPlaylist(video)
        video.progress = 0
        repository.updateProgress(video)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals("XY", File(stored.url!!).readText())
        assertNull(requests["/s0.ts"])
        assertNull(requests["/s1.ts"])
    }

    @Test fun redownloadChatOnIntactMovedRowKeepsTheFile() = runBlocking {
        route("/moved.m3u8") { playlistOf("s0.ts", "s1.ts") }
        route("/s0.ts") { "AA" }
        route("/s1.ts") { "BB" }
        server.start()
        val moved = File(root, "moved.ts").apply { writeText("XY") }
        // redownloadChat flips finalized rows to STATUS_PENDING before enqueueing,
        // and moved rows keep progress=0/maxProgress=100 from the move operation.
        val video = seedSingleFileRow("/moved.m3u8", moved.path, progress = 0, maxProgress = 100, bytes = 2L, status = OfflineVideo.STATUS_PENDING, date = 29)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id, forceChatRedownload = true).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals("XY", File(stored.url!!).readText())
        assertNull(requests["/s0.ts"])
        assertNull(requests["/s1.ts"])
    }

    @Test fun failedPlaylistFetchKeepsCompletedRowDownloaded() = runBlocking {
        // A completed row whose stored source URL has expired: the rebuild dies at
        // the playlist fetch, before the video phase touches anything — the intact
        // output must keep the row DOWNLOADED instead of downgrading it to Pending.
        route("/expired.m3u8", 404) { "gone" }
        server.start()
        val finished = File(root, "completed-intact.ts").apply { writeText("XY") }
        val video = seedSingleFileRow("/expired.m3u8", finished.path, progress = 2, maxProgress = 2, bytes = 2L, status = OfflineVideo.STATUS_DOWNLOADED, date = 31)
        assertEquals(ListenableWorker.Result.failure(), worker(video.id).doWork())
        val stored = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, stored.status)
        assertEquals("XY", File(stored.url!!).readText())
    }

    @Test fun redownloadingChatNeverFetchesTheMovedMp4() = runBlocking {
        route("/clip.mp4", status = 403) { "expired" }
        server.start()
        val clip = File(root, "moved.mp4").apply { writeText("saved clip") }
        val video = seedSingleFileRow("/clip.mp4", clip.path, progress = 0, maxProgress = 100,
            bytes = clip.length(), status = OfflineVideo.STATUS_PENDING, date = 30)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id, forceChatRedownload = true).doWork())
        assertEquals("saved clip", clip.readText())
        assertNull(requests["/clip.mp4"])
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(video.id)!!.status)
    }

    @Test fun missingConvertedVideoStaysPending() = runBlocking {
        route("/converted.m3u8") { playlistOf("s0.ts") }
        server.start()
        val output = File(root, "missing-converted.mp4")
        val video = OfflineVideo(
            sourceUrl = "http://127.0.0.1:${server.address.port}/converted.m3u8",
            url = output.path, downloadPath = root.path, downloadDate = 31,
            playlistToFile = false, status = OfflineVideo.STATUS_PENDING,
        )
        video.id = repository.saveVideo(video).toInt()
        assertEquals(ListenableWorker.Result.failure(), worker(video.id).doWork())
        assertEquals(OfflineVideo.STATUS_PENDING, repository.getVideoById(video.id)!!.status)
        assertNull(requests["/s0.ts"])
    }

    @Test fun missingMp4IsDownloadedDespiteCompletedCounters() = runBlocking {
        route("/clip.mp4") { "restored clip" }
        server.start()
        val output = File(root, "missing.mp4")
        val video = seedSingleFileRow("/clip.mp4", output.path, progress = 100, maxProgress = 100,
            bytes = 12L, status = OfflineVideo.STATUS_PENDING, date = 32)
        assertEquals(failures(), ListenableWorker.Result.success(), worker(video.id).doWork())
        assertEquals("restored clip", output.readText())
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(video.id)!!.status)
    }

    @Test fun failedInitSegmentAfterPlaylistRewriteKeepsDownloadPending() = runBlocking {
        route("/rebuild.m3u8") { playlistOf("s0.ts", initUri = "init.mp4") }
        route("/init.mp4", status = 503) { "unavailable" }
        server.start()
        val output = File(root, "rebuild.m3u8").apply { writeText(playlistOf("old.ts")) }
        val video = OfflineVideo(
            sourceUrl = "http://127.0.0.1:${server.address.port}/rebuild.m3u8",
            url = output.path, downloadPath = root.path, downloadDate = 33,
            playlistToFile = false, status = OfflineVideo.STATUS_DOWNLOADED, progress = 1, maxProgress = 1,
        )
        video.id = repository.saveVideo(video).toInt()
        assertEquals(ListenableWorker.Result.failure(), worker(video.id).doWork())
        assertEquals(OfflineVideo.STATUS_PENDING, repository.getVideoById(video.id)!!.status)
    }
}
