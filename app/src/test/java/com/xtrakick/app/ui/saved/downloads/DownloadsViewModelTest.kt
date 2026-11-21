package com.xtrakick.app.ui.saved.downloads

import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.os.Bundle
import android.provider.DocumentsContract
import androidx.room.Room
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import androidx.work.Configuration
import androidx.work.WorkManager
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.DownloadFileCoordinator
import com.xtrakick.app.util.DownloadStorage
import com.xtrakick.app.util.m3u8.PlaylistUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
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
import java.util.concurrent.CopyOnWriteArrayList

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class DownloadsViewModelTest {
    @Test fun completedRecordingsHaveIndependentFileOwnershipFromTheCurrentRecording() = runBlocking {
        val old = OfflineVideo(live = true, channelLogin = "same", status = OfflineVideo.STATUS_DOWNLOADED)
        old.id = repository.saveVideo(old).toInt()
        val current = OfflineVideo(live = true, channelLogin = "same", status = OfflineVideo.STATUS_DOWNLOADING)
        current.id = repository.saveVideo(current).toInt()
        val started = CompletableDeferred<Unit>()
        val worker = scope.launch {
            repository.withVideoFiles(current, wait = true) {
                started.complete(Unit)
                awaitCancellation()
            }
        }
        try {
            withTimeout(5000) {
                started.await()
                assertEquals("converted", repository.withVideoFiles(old) { "converted" })
                repository.withVideoDeletion(old) { repository.deleteVideo(it, true) }
                assertTrue(worker.isActive)
                assertTrue(repository.getVideoById(current.id) != null)
            }
        } finally { worker.cancel(); worker.join() }
    }

    @Test fun deletingACompletedRecordingLeavesTheChannelsNextWorkEnqueued() = runBlocking {
        initializeWorkManager()
        val old = OfflineVideo(live = true, channelLogin = "same", status = OfflineVideo.STATUS_DOWNLOADED)
        old.id = repository.saveVideo(old).toInt()
        val request = androidx.work.OneTimeWorkRequestBuilder<com.xtrakick.app.ui.download.StreamDownloadWorker>()
            .setInitialDelay(1, TimeUnit.DAYS).build()
        val workManager = WorkManager.getInstance(context)
        workManager.enqueueUniqueWork("same", androidx.work.ExistingWorkPolicy.KEEP, request)
            .result.get(5, TimeUnit.SECONDS)
        viewModel.delete(old, keepFiles = true)
        withTimeout(5000) { while (repository.getVideoById(old.id) != null) delay(10) }
        assertEquals(androidx.work.WorkInfo.State.ENQUEUED,
            workManager.getWorkInfoById(request.id).get(5, TimeUnit.SECONDS)!!.state)
        workManager.cancelUniqueWork("same").result.get(5, TimeUnit.SECONDS)
        Unit
    }

    @Test
    fun deletionWaitsForWriterCleanupAndRejectsQueuedWriters() = runBlocking {
        val coordinator = DownloadFileCoordinator()
        val started = CompletableDeferred<Unit>()
        val cleanupStarted = CompletableDeferred<Unit>()
        val finishCleanup = CompletableDeferred<Unit>()
        val writer = launch {
            coordinator.use("video:1", deleting = false, wait = true) {
                started.complete(Unit)
                try {
                    awaitCancellation()
                } finally {
                    withContext(NonCancellable) {
                        cleanupStarted.complete(Unit)
                        finishCleanup.await()
                    }
                }
            }
        }
        started.await()
        val deletion = async {
            coordinator.use("video:1", deleting = true, wait = true) { "deleted" }
        }
        cleanupStarted.await()
        val queued = async(start = kotlinx.coroutines.CoroutineStart.UNDISPATCHED) {
            coordinator.use("video:1", deleting = false, wait = true) { "must not run" }
        }
        assertFalse(deletion.isCompleted)
        finishCleanup.complete(Unit)
        assertEquals("deleted", deletion.await())
        assertEquals(null, queued.await())
        writer.join()
    }

    @Test
    fun canceledDeletionLetsQueuedWriterProceed() = runBlocking {
        val coordinator = DownloadFileCoordinator()
        val cleanupStarted = CompletableDeferred<Unit>()
        val finishCleanup = CompletableDeferred<Unit>()
        val writer = launch(start = kotlinx.coroutines.CoroutineStart.UNDISPATCHED) {
            coordinator.use("video:1", deleting = false, wait = true) {
                try {
                    awaitCancellation()
                } finally {
                    withContext(NonCancellable) {
                        cleanupStarted.complete(Unit)
                        finishCleanup.await()
                    }
                }
            }
        }
        val deletion = async {
            coordinator.use("video:1", deleting = true, wait = true) { error("Deletion should not start") }
        }
        cleanupStarted.await()
        val queued = async(start = kotlinx.coroutines.CoroutineStart.UNDISPATCHED) {
            coordinator.use("video:1", deleting = false, wait = true) { "resumed" }
        }
        try {
            deletion.cancel()
            deletion.join()
        } finally {
            finishCleanup.complete(Unit)
        }
        assertEquals("resumed", queued.await())
        writer.join()
    }

    @Test
    fun statusWriteFromAnOldRowPreservesPlaybackPositionAndChatProgress() = runBlocking {
        val video = OfflineVideo(url = chatFile.path)
        video.id = repository.saveVideo(video).toInt()
        val stale = repository.getVideoById(video.id)!!
        repository.updateVideoPosition(video.id, 1234L)
        repository.updateChatDownloadProgress(repository.getVideoById(video.id)!!.apply {
            chatBytes = 99L
            chatProgress = 7
        })
        repository.updateStatus(stale.apply { status = OfflineVideo.STATUS_DOWNLOADED })
        val saved = repository.getVideoById(video.id)!!
        assertEquals(1234L, saved.lastWatchPosition)
        assertEquals(99L, saved.chatBytes)
        assertEquals(7, saved.chatProgress)
    }

    @Test fun sharedStorageDeletionCannotRemoveAnAssetInAnotherContainer() = runBlocking {
        initializeWorkManager()
        val playlistUri = "content://download.chat.test/document/primary%3AVOD%2Fvideo.m3u8"
        val localAssetUri = "content://download.chat.test/document/primary%3AVOD%2Fasset.ts"
        val foreignAssetUri = "content://download.chat.test/document/primary%3AOther%2Fshared.ts"
        chatFile.writeText("#EXTM3U\n#EXTINF:1,\nasset.ts\n#EXTINF:1,\n$foreignAssetUri\n#EXT-X-ENDLIST\n")
        val provider = ChatProvider().apply {
            files = mapOf(playlistUri to chatFile)
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        val video = OfflineVideo(url = playlistUri)
        video.id = repository.saveVideo(video).toInt()
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { while (repository.getVideoById(video.id) != null) delay(10) }
        assertFalse("References outside this download container are not owned by this deletion", Uri.parse(foreignAssetUri) in provider.deletedUris)
        assertTrue(Uri.parse(localAssetUri) in provider.deletedUris)
        assertTrue(Uri.parse(playlistUri) in provider.deletedUris)
    }

    @Test fun sharedStorageSegmentDeletionFailureRetainsThePlaylistForRetry() = runBlocking {
        initializeWorkManager()
        val playlistUri = "content://download.chat.test/document/primary%3AVOD%2Fvideo.m3u8"
        val assetUri = Uri.parse("content://download.chat.test/document/primary%3AVOD%2Fasset.ts")
        chatFile.writeText("#EXTM3U\n#EXTINF:1,\nasset.ts\n#EXT-X-ENDLIST\n")
        val assetFile = File(context.cacheDir, "retained-segment.ts").apply { writeText("video data") }
        val provider = ChatProvider().apply {
            files = mapOf(playlistUri to chatFile, assetUri.toString() to assetFile)
            beforeDelete = { if (it == assetUri) throw SecurityException("Provider denied deletion") }
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        val video = OfflineVideo(url = playlistUri, status = OfflineVideo.STATUS_DOWNLOADED, progress = 1, maxProgress = 1)
        video.id = repository.saveVideo(video).toInt()
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { scope.coroutineContext[Job]!!.children.toList().joinAll() }
        val retained = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, retained.status)
        assertEquals(1, retained.progress)
        assertEquals(1, retained.maxProgress)
        assertFalse(Uri.parse(playlistUri) in provider.deletedUris)

        provider.beforeDelete = null
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { while (repository.getVideoById(video.id) != null) delay(10) }
        assertTrue(Uri.parse(playlistUri) in provider.deletedUris)
    }

    @Test fun interruptedDeletionKeepsAnIncompletePlaylistAvailableForRepair() = runBlocking {
        val directory = File(context.cacheDir, "interrupted-deletion").apply { mkdirs() }
        File(directory, "first.ts").writeText("first segment")
        val manifest = File(directory, "video.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:1,\nfirst.ts\n#EXTINF:1,\nmissing.ts\n#EXT-X-ENDLIST\n")
        }
        val video = OfflineVideo(url = manifest.path, status = OfflineVideo.STATUS_DELETING, progress = 1, maxProgress = 2)
        withTimeout(5000) { scope.coroutineContext[Job]!!.children.toList().joinAll() }
        video.id = repository.saveVideo(video).toInt()
        DownloadsViewModel(context, repository, scope)
        withTimeout(5000) { scope.coroutineContext[Job]!!.children.toList().joinAll() }

        val recovered = repository.getVideoById(video.id)!!
        assertEquals(OfflineVideo.STATUS_PENDING, recovered.status)
        assertEquals(0, recovered.progress)
        assertTrue(manifest.isFile)
    }

    @Test fun interruptedSingleFileDeletionOnlyRestoresCompletionWhenItWasRecorded() = runBlocking {
        withTimeout(5000) { scope.coroutineContext[Job]!!.children.toList().joinAll() }
        val pendingFile = File(context.cacheDir, "partial-deletion.mp4").apply { writeText("partial") }
        val completedFile = File(context.cacheDir, "complete-deletion.mp4").apply { writeText("complete") }
        val source = "https://example.invalid/video.mp4"
        val pending = OfflineVideo(url = pendingFile.path, sourceUrl = source, progress = 50, bytes = 7L, status = OfflineVideo.STATUS_DELETING)
        val completed = OfflineVideo(url = completedFile.path, sourceUrl = source, status = OfflineVideo.STATUS_DELETING_COMPLETED)
        pending.id = repository.saveVideo(pending).toInt()
        completed.id = repository.saveVideo(completed).toInt()
        DownloadsViewModel(context, repository, scope)
        withTimeout(5000) { scope.coroutineContext[Job]!!.children.toList().joinAll() }

        val recovered = repository.getVideoById(pending.id)!!
        assertEquals(OfflineVideo.STATUS_PENDING, recovered.status)
        assertEquals(0, recovered.progress)
        assertEquals(0L, recovered.bytes)
        assertEquals("partial", pendingFile.readText())
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(completed.id)!!.status)
        assertEquals("complete", completedFile.readText())
    }

    @Test fun safPlaylistIntactCheckUsesBatchedDirectorySizesWithoutOpeningEverySegment() {
        val playlistUri = "content://download.chat.test/document/primary%3AVOD%2Fvideo.m3u8"
        val firstUri = "content://download.chat.test/document/primary%3AVOD%2Ffirst.ts"
        val middleUri = "content://download.chat.test/document/primary%3AVOD%2Fmiddle.ts"
        val lastUri = "content://download.chat.test/document/primary%3AVOD%2Flast.ts"
        chatFile.writeText("#EXTM3U\n#EXTINF:1,\nfirst.ts\n#EXTINF:1,\nmiddle.ts\n#EXTINF:1,\nlast.ts\n#EXT-X-ENDLIST\n")
        val firstFile = File(context.cacheDir, "batched-first.ts").apply { writeText("first") }
        val openedUris = CopyOnWriteArrayList<String>()
        val provider = ChatProvider().apply {
            files = mapOf(playlistUri to chatFile, firstUri to firstFile)
            childRows = listOf(
                "primary:VOD/first.ts" to 5L,
                "primary:VOD/middle.ts" to 6L,
                "primary:VOD/last.ts" to 4L,
            )
            beforeOpenUri = { openedUris.add(it.toString()) }
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)

        assertTrue(DownloadStorage.isOutputIntact(context, playlistUri))
        assertEquals(listOf(playlistUri, firstUri), openedUris)
        assertFalse(middleUri in openedUris)
        assertFalse(lastUri in openedUris)

        provider.childRows = listOf(
            "primary:VOD/first.ts" to 5L,
            "primary:VOD/middle.ts" to 0L,
            "primary:VOD/last.ts" to 4L,
        )
        assertFalse(DownloadStorage.isOutputIntact(context, playlistUri))

        // MediaStore-backed authorities / msd: document IDs can keep stale non-zero sizes after raw deletion.
        assertTrue(DownloadStorage.childDocumentSizes(context, Uri.parse("content://com.android.providers.downloads.documents/document/msd%3A123")).isEmpty())
        assertTrue(DownloadStorage.childDocumentSizes(context, Uri.parse("content://download.chat.test/document/msd%3A123")).isEmpty())
        assertTrue(DownloadStorage.childDocumentSizes(context, Uri.parse("content://download.chat.test/tree/primary%3AVOD")).isEmpty())
    }

    @Test fun opaqueSharedPlaylistChecksAllReferencedAssetsAndRefusesUnverifiedDeletion() = runBlocking {
        val playlist = "content://download.chat.test/document/playlist-token"
        val first = "content://download.chat.test/document/first-token"
        val second = "content://download.chat.test/document/second-token"
        chatFile.writeText("#EXTM3U\n#EXTINF:1,\n$first\n#EXTINF:1,\n$second\n#EXT-X-ENDLIST\n")
        val firstFile = File(context.cacheDir, "opaque-first.ts").apply { writeText("first") }
        val secondFile = File(context.cacheDir, "opaque-second.ts")
        val provider = ChatProvider().apply {
            files = mapOf(playlist to chatFile, first to firstFile, second to secondFile)
            mimeTypes = mapOf(playlist to "application/vnd.apple.mpegurl")
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        assertTrue(DownloadStorage.isPlaylist(context, playlist))
        assertFalse(DownloadStorage.isOutputIntact(context, playlist))
        secondFile.writeText("second")
        assertTrue(DownloadStorage.isOutputIntact(context, playlist))

        initializeWorkManager()
        val video = OfflineVideo(url = playlist, status = OfflineVideo.STATUS_DOWNLOADED)
        video.id = repository.saveVideo(video).toInt()
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { scope.coroutineContext[Job]!!.children.toList().joinAll() }
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, repository.getVideoById(video.id)!!.status)
        assertTrue(provider.deletedUris.isEmpty())
    }

    @Test fun cancellingAMoveRestoresItsStatusAndKeepsTheSourceReference() = runBlocking {
        val sourceUri = "content://download.chat.test/document/primary%3AVOD%2Fvideo.mp4"
        chatFile.writeText("video data")
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val provider = ChatProvider().apply {
            files = mapOf(sourceUri to chatFile)
            beforeOpenUri = { uri ->
                if (uri.toString() == sourceUri) {
                    entered.countDown()
                    check(release.await(5, TimeUnit.SECONDS))
                }
            }
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        val video = OfflineVideo(url = sourceUri, status = OfflineVideo.STATUS_DOWNLOADED)
        video.id = repository.saveVideo(video).toInt()
        val job = viewModel.viewModelScope.coroutineContext[Job]!!
        viewModel.moveToAppStorage(File(context.cacheDir, "cancelled-move").path, video)
        try {
            assertTrue(entered.await(5, TimeUnit.SECONDS))
            ViewModelStore().apply { put("downloads", viewModel) }.clear()
        } finally {
            release.countDown()
        }
        withTimeout(5000) { job.join() }
        val saved = repository.getVideoById(video.id)!!
        assertEquals(sourceUri, saved.url)
        assertEquals(OfflineVideo.STATUS_DOWNLOADED, saved.status)
    }

    @Test fun failedSharedStorageMoveKeepsTheSourceVideoReference() = runBlocking {
        verifyFailedMove(hls = false)
    }

    @Test fun failedSharedStorageSegmentMoveKeepsTheSourcePlaylistReference() = runBlocking {
        verifyFailedMove(hls = true)
    }

    @Test fun successfulSharedStorageMoveCopiesARepeatedAssetOnceAndKeepsByteRanges() = runBlocking {
        val sourceUri = "content://download.chat.test/document/primary%3AVOD%2Fvideo.m3u8"
        val assetUri = "content://download.chat.test/document/primary%3AVOD%2Fasset.ts"
        val asset = File(context.cacheDir, "move-asset.ts").apply { writeText("abcdefgh") }
        chatFile.writeText("#EXTM3U\n#EXTINF:1,\n#EXT-X-BYTERANGE:3@1\n$assetUri\n#EXTINF:1,\n#EXT-X-BYTERANGE:2@5\n$assetUri\n#EXT-X-ENDLIST\n")
        val opens = AtomicInteger()
        val provider = ChatProvider().apply {
            files = mapOf(sourceUri to chatFile, assetUri to asset)
            beforeOpenUri = { if (it.toString() == assetUri) opens.incrementAndGet() }
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        val video = OfflineVideo(url = sourceUri, status = OfflineVideo.STATUS_DOWNLOADED)
        video.id = repository.saveVideo(video).toInt()
        viewModel.moveToAppStorage(File(context.cacheDir, "successful-move").path, video)
        withTimeout(5000) { while (repository.getVideoById(video.id)?.url == sourceUri) delay(10) }
        val saved = PlaylistUtils.parseMediaPlaylist(File(repository.getVideoById(video.id)!!.url!!).inputStream())
        assertEquals(listOf(1L, 5L), saved.segments.map { it.byteRangeStart })
        assertEquals(listOf(3L, 2L), saved.segments.map { it.byteRangeLength })
        assertEquals("abcdefgh", File(saved.segments.first().uri).readText())
        assertEquals("Byte ranges share one physical copy", 1, opens.get())
    }

    @Test fun deletingLastPlaylistPreservesAConvertedVideoInTheSameContainer() = runBlocking {
        initializeWorkManager()
        val directory = File(context.cacheDir, "mixed-downloads").apply { mkdirs() }
        val asset = File(directory, "asset.ts").apply { writeText("segment") }
        val converted = File(directory, "converted.mp4").apply { writeText("another download") }
        val playlist = File(directory, "first.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:1,\n${asset.path}\n#EXT-X-ENDLIST\n")
        }
        val video = OfflineVideo(url = playlist.path)
        video.id = repository.saveVideo(video).toInt()
        repository.saveVideo(OfflineVideo(url = converted.path))
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { while (repository.getVideoById(video.id) != null) delay(10) }
        assertEquals("another download", converted.readText())
        assertFalse(asset.exists())
        assertFalse(playlist.exists())
    }

    private suspend fun verifyFailedMove(hls: Boolean) {
        val sourceUri = "content://download.chat.test/document/primary%3AVOD%2Fvideo.${if (hls) "m3u8" else "mp4"}"
        val attemptedCopy = CountDownLatch(1)
        val provider = ChatProvider().apply {
            files = if (hls) {
                chatFile.writeText("#EXTM3U\n#EXTINF:1,\ncontent://download.chat.test/document/primary%3AVOD%2Fmissing.ts\n#EXT-X-ENDLIST\n")
                mapOf(sourceUri to chatFile)
            } else emptyMap()
            beforeOpenUri = { uri -> if (uri.toString() != sourceUri || !hls) attemptedCopy.countDown() }
            attachInfo(this@DownloadsViewModelTest.context, ProviderInfo().apply { authority = "download.chat.test" })
        }
        ShadowContentResolver.registerProviderInternal("download.chat.test", provider)
        val video = OfflineVideo(url = sourceUri, status = OfflineVideo.STATUS_DOWNLOADED)
        video.id = repository.saveVideo(video).toInt()
        viewModel.moveToAppStorage(File(context.cacheDir, "failed-move-$hls").path, video)
        assertTrue(attemptedCopy.await(5, TimeUnit.SECONDS))
        withTimeout(5000) {
            while (repository.getVideoById(video.id)?.status == OfflineVideo.STATUS_MOVING) delay(10)
        }
        assertEquals("A failed copy must leave the source as the playable download", sourceUri, repository.getVideoById(video.id)!!.url)
    }

    @Test fun assetOwnershipProtectsInitializationSegmentsAndEncodedDocumentNames() {
        val selected = PlaylistUtils.parseMediaPlaylist(
            "#EXTM3U\n#EXT-X-MAP:URI=\"content://provider/document/primary%3AVOD%2Finit.mp4\"\n#EXTINF:1,\ncontent://provider/document/primary%3AVOD%2Fvideo%20part.ts\n#EXTINF:1,\nunique.ts\n".byteInputStream()
        )
        val sibling = PlaylistUtils.parseMediaPlaylist(
            "#EXTM3U\n#EXT-X-MAP:URI=\"init.mp4\"\n#EXTINF:2,\nvideo part.ts\n".byteInputStream()
        )
        assertEquals(listOf("unique.ts"), PlaylistUtils.unsharedAssetUris(selected, listOf(sibling)))
        assertEquals(3, PlaylistUtils.unsharedAssetUris(selected, emptyList()).size)
        assertTrue(PlaylistUtils.unsharedAssetUris(selected, listOf(null)).isEmpty())
    }

    @Test fun conversionPreservesAnAssetReferencedByAnotherByteRangePlaylist() = runBlocking {
        val directory = File(context.cacheDir, "shared-conversion").apply { mkdirs() }
        val asset = File(directory, "asset.ts").apply { writeText("abcdefgh") }
        val playlist = File(directory, "first.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:1,\n#EXT-X-BYTERANGE:3@1\nasset.ts\n#EXTINF:1,\n#EXT-X-BYTERANGE:2@5\nasset.ts\n#EXT-X-ENDLIST\n")
        }
        val sibling = File(directory, "second.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:2,\n#EXT-X-BYTERANGE:2@0\nasset.ts\n#EXT-X-ENDLIST\n")
        }
        val video = OfflineVideo(url = playlist.path, downloadPath = directory.parent, downloadDate = 6)
        video.id = repository.saveVideo(video).toInt()
        repository.saveVideo(OfflineVideo(url = sibling.path))
        viewModel.convertToFile(video)
        withTimeout(5000) {
            while (repository.getVideoById(video.id)?.url == playlist.path) delay(10)
        }
        assertEquals("bcdfg", File(repository.getVideoById(video.id)!!.url!!).readText())
        assertTrue("The other download still needs the original asset", asset.exists())
        assertTrue(sibling.exists())
    }

    @Test fun deletionProtectsSharedByteRangesAndRemovesRelativeExclusiveAssets() = runBlocking {
        verifySharedDeletion(relative = true)
    }

    @Test fun deletionProtectsAbsoluteAssetsEvenWhenSegmentMetadataDiffers() = runBlocking {
        verifySharedDeletion(relative = false)
    }

    private suspend fun verifySharedDeletion(relative: Boolean) {
        initializeWorkManager()
        val directory = File(context.cacheDir, "shared-deletion-$relative").apply { mkdirs() }
        val shared = File(directory, "shared.ts").apply { writeText("abcdefgh") }
        val unique = File(directory, "unique.ts").apply { writeText("only first") }
        val outside = File(context.cacheDir, "outside-$relative.ts").apply { writeText("unrelated") }
        val sharedUri = if (relative) shared.name else shared.path
        val uniqueUri = if (relative) unique.name else unique.path
        val playlist = File(directory, "first.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:1,\n#EXT-X-BYTERANGE:3@1\n$sharedUri\n#EXTINF:1,\n$uniqueUri\n#EXTINF:1,\n${outside.path}\n#EXT-X-ENDLIST\n")
        }
        val sibling = File(directory, "second.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:2,\n#EXT-X-BYTERANGE:2@0\n$sharedUri\n#EXT-X-ENDLIST\n")
        }
        val video = OfflineVideo(url = playlist.path)
        video.id = repository.saveVideo(video).toInt()
        repository.saveVideo(OfflineVideo(url = sibling.path))
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { while (repository.getVideoById(video.id) != null) delay(10) }
        assertTrue("A different byte range still owns this file", shared.exists())
        assertFalse("Exclusive relative and absolute assets must be removed", unique.exists())
        assertTrue("A playlist must not delete files outside its directory", outside.exists())
        assertFalse(playlist.exists())
        assertTrue(sibling.exists())
    }

    @Test fun deletionKeepsAssetsWhenAnotherPlaylistCannotBeRead() = runBlocking {
        initializeWorkManager()
        val directory = File(context.cacheDir, "unknown-owner").apply { mkdirs() }
        val asset = File(directory, "asset.ts").apply { writeText("keep") }
        val playlist = File(directory, "first.m3u8").apply {
            writeText("#EXTM3U\n#EXTINF:1,\n${asset.path}\n#EXT-X-ENDLIST\n")
        }
        File(directory, "second.m3u8").writeText("unreadable playlist content")
        val video = OfflineVideo(url = playlist.path)
        video.id = repository.saveVideo(video).toInt()
        viewModel.delete(video, keepFiles = false)
        withTimeout(5000) { while (repository.getVideoById(video.id) != null) delay(10) }
        assertTrue("Ownership is unknown, so retain the asset", asset.exists())
        assertFalse(playlist.exists())
    }

    private fun initializeWorkManager() {
        if (runCatching { WorkManager.getInstance(context) }.isFailure) {
            WorkManager.initialize(context, Configuration.Builder().build())
        }
    }

    @Test
    fun conversionCopiesByteRangesBeforeDeletingTheSharedAsset() = runBlocking {
        val directory = File(context.cacheDir, "range-conversion").apply { mkdirs() }
        File(directory, "asset.ts").writeText("abcdefgh")
        val playlist = File(directory, "video.m3u8").apply {
            writeText("#EXTM3U\n#EXT-X-TARGETDURATION:1\n#EXTINF:1,\n#EXT-X-BYTERANGE:3@1\nasset.ts\n#EXTINF:1,\n#EXT-X-BYTERANGE:2@5\nasset.ts\n#EXT-X-ENDLIST\n")
        }
        val video = OfflineVideo(url = playlist.path, downloadPath = directory.parent, downloadDate = 5)
        video.id = repository.saveVideo(video).toInt()
        viewModel.convertToFile(video)
        kotlinx.coroutines.withTimeout(5000) {
            while (repository.getVideoById(video.id)?.url == playlist.path) kotlinx.coroutines.delay(10)
        }
        val converted = repository.getVideoById(video.id)!!
        assertEquals("bcdfg", File(converted.url!!).readText())
    }
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
        var files: Map<String, File>? = null
        var mimeTypes: Map<String, String> = emptyMap()
        var childRows: List<Pair<String, Long>>? = null
        var beforeOpen: ((String) -> Unit)? = null
        var beforeOpenUri: ((Uri) -> Unit)? = null
        var beforeDelete: ((Uri) -> Unit)? = null
        val deletedUris = CopyOnWriteArrayList<Uri>()
        override fun onCreate() = true
        override fun openFile(uri: Uri, mode: String): ParcelFileDescriptor {
            beforeOpen?.invoke(mode)
            beforeOpenUri?.invoke(uri)
            val target = files?.let { it[uri.toString()] ?: throw java.io.FileNotFoundException(uri.toString()) } ?: file
            return ParcelFileDescriptor.open(target, ParcelFileDescriptor.parseMode(mode))
        }
        override fun getType(uri: Uri) = mimeTypes[uri.toString()] ?: "application/json"
        @Suppress("DEPRECATION")
        override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
            check(method == "android:deleteDocument")
            extras?.getParcelable<Uri>("uri")?.let {
                beforeDelete?.invoke(it)
                deletedUris.add(it)
            }
            return Bundle()
        }
        override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {
            val rows = childRows ?: return null
            if (!uri.path.orEmpty().endsWith("/children")) return null
            return MatrixCursor(arrayOf(DocumentsContract.Document.COLUMN_DOCUMENT_ID, DocumentsContract.Document.COLUMN_SIZE)).apply {
                rows.forEach { (id, size) -> addRow(arrayOf<Any>(id, size)) }
            }
        }
        override fun insert(uri: Uri, values: ContentValues?): Uri? = null
        override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0
        override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0
    }
}
