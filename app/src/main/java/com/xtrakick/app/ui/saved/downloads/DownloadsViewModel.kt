package com.xtrakick.app.ui.saved.downloads

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.DocumentsContract
import android.util.JsonReader
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.work.NetworkType
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.DownloadStorage
import com.xtrakick.app.util.SafStorageUtils
import com.xtrakick.app.util.m3u8.PlaylistUtils
import com.xtrakick.app.util.m3u8.Segment
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import kotlin.math.max

@HiltViewModel
class DownloadsViewModel @Inject internal constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val repository: OfflineRepository,
    // Process-lifetime scope: file deletion must survive leaving the Downloads screen,
    // otherwise segment files are orphaned while the DB row still gets removed.
    private val externalScope: CoroutineScope,
) : ViewModel() {

    companion object {
        private val finishMutex = Mutex()

        // A normal SAF call takes milliseconds; anything still running at this
        // point is a hung provider call.
        private const val SAF_CALL_TIMEOUT_MS = 30_000L
    }

    var selectedVideo: OfflineVideo? = null
    private val videosInUse = java.util.concurrent.ConcurrentHashMap.newKeySet<Int>()
    private val currentDownloads = java.util.concurrent.ConcurrentHashMap.newKeySet<Int>()
    private val liveDownloads = java.util.concurrent.ConcurrentHashMap.newKeySet<String>()

    // Abandoned hung binder calls occupy their thread indefinitely; cap the
    // damage to a few slots so the shared Dispatchers.IO pool stays healthy.
    private val safCallDispatcher = Dispatchers.IO.limitedParallelism(8)

    init {
        externalScope.launch(Dispatchers.IO) { recoverInterruptedDeletions() }
    }

    val flow = Pager(
        PagingConfig(pageSize = 30, prefetchDistance = 3, initialLoadSize = 30),
    ) {
        repository.loadAllVideos()
    }.flow.cachedIn(viewModelScope)

    fun finishDownload(video: OfflineVideo) {
        externalScope.launch(Dispatchers.IO) {
            repository.withVideoFiles(video, wait = true) { video ->
                try {
                    finishMutex.withLock {
                        video.chatUrl?.let { url ->
                            val isShared = url.toUri().scheme == ContentResolver.SCHEME_CONTENT
                            if (isShared) {
                                applicationContext.contentResolver.openFileDescriptor(url.toUri(), "rw")!!.use {
                                    FileOutputStream(it.fileDescriptor).use { output ->
                                        output.channel.truncate(video.chatBytes)
                                    }
                                }
                            } else {
                                FileOutputStream(url, true).use { output ->
                                    output.channel.truncate(video.chatBytes)
                                }
                            }
                            if (isShared) {
                                applicationContext.contentResolver.openOutputStream(url.toUri(), "wa")!!.bufferedWriter()
                            } else {
                                FileOutputStream(url, true).bufferedWriter()
                            }.use { fileWriter ->
                                fileWriter.write("}")
                            }
                        }
                        repository.updateStatus(video.apply {
                            status = OfflineVideo.STATUS_DOWNLOADED
                        })
                    }
                } catch (error: CancellationException) {
                    throw error
                } catch (error: Exception) {
                    DiagnosticLogger.e("Downloads", "Could not finalize downloaded chat", error)
                }
            }
        }
    }

    fun checkLiveDownloadStatus(channelLogin: String) {
        if (liveDownloads.add(channelLogin)) {
            viewModelScope.launch(Dispatchers.IO) {
                WorkManager.getInstance(applicationContext).getWorkInfosForUniqueWorkFlow(channelLogin).collect { list ->
                    val work = list.lastOrNull()
                    when {
                        work == null || work.state.isFinished -> {
                            repository.getLiveDownload(channelLogin)?.let { video ->
                                if (video.status == OfflineVideo.STATUS_DOWNLOADING || video.status == OfflineVideo.STATUS_BLOCKED || video.status == OfflineVideo.STATUS_QUEUED || video.status == OfflineVideo.STATUS_QUEUED_WIFI || video.status == OfflineVideo.STATUS_WAITING_FOR_STREAM) {
                                    repository.updateStatus(video.apply {
                                        status = OfflineVideo.STATUS_PENDING
                                    })
                                }
                            }
                            cancel()
                        }
                        work.state == WorkInfo.State.ENQUEUED -> {
                            repository.getLiveDownload(channelLogin)?.let { video ->
                                repository.updateStatus(video.apply {
                                    status = if (work.constraints.requiredNetworkType == NetworkType.UNMETERED) {
                                        OfflineVideo.STATUS_QUEUED_WIFI
                                    } else {
                                        OfflineVideo.STATUS_QUEUED
                                    }
                                })
                            }
                        }
                        work.state == WorkInfo.State.BLOCKED -> {
                            repository.getLiveDownload(channelLogin)?.let { video ->
                                repository.updateStatus(video.apply {
                                    status = OfflineVideo.STATUS_BLOCKED
                                })
                            }
                        }
                    }
                }
            }.invokeOnCompletion {
                liveDownloads.remove(channelLogin)
            }
        }
    }

    fun checkDownloadStatus(videoId: Int) {
        if (currentDownloads.add(videoId)) {
            viewModelScope.launch(Dispatchers.IO) {
                WorkManager.getInstance(applicationContext).getWorkInfosByTagFlow(videoId.toString()).collect { list ->
                    val work = list.firstOrNull { !it.state.isFinished } ?: list.lastOrNull()
                    when {
                        work == null || work.state.isFinished -> {
                            repository.getVideoById(videoId)?.let { video ->
                                if (video.status == OfflineVideo.STATUS_DOWNLOADING || video.status == OfflineVideo.STATUS_BLOCKED || video.status == OfflineVideo.STATUS_QUEUED || video.status == OfflineVideo.STATUS_QUEUED_WIFI || video.status == OfflineVideo.STATUS_CONVERTING || video.status == OfflineVideo.STATUS_MOVING || video.status == OfflineVideo.STATUS_DELETING) {
                                    repository.updateStatus(video.apply {
                                        status = if (video.status == OfflineVideo.STATUS_DOWNLOADING &&
                                            work?.state == WorkInfo.State.SUCCEEDED && video.progress == video.maxProgress) {
                                            OfflineVideo.STATUS_DOWNLOADED
                                        } else OfflineVideo.STATUS_PENDING
                                    })
                                }
                            }
                            cancel()
                        }
                        work.state == WorkInfo.State.ENQUEUED -> {
                            repository.getVideoById(videoId)?.let { video ->
                                repository.updateStatus(video.apply {
                                    status = if (work.constraints.requiredNetworkType == NetworkType.UNMETERED) {
                                        OfflineVideo.STATUS_QUEUED_WIFI
                                    } else {
                                        OfflineVideo.STATUS_QUEUED
                                    }
                                })
                            }
                        }
                        work.state == WorkInfo.State.BLOCKED -> {
                            repository.getVideoById(videoId)?.let { video ->
                                repository.updateStatus(video.apply {
                                    status = OfflineVideo.STATUS_BLOCKED
                                })
                            }
                        }
                    }
                }
            }.invokeOnCompletion {
                currentDownloads.remove(videoId)
            }
        }
    }

    fun convertToFile(video: OfflineVideo) {
        val videoUrl = video.url
        if (videoUrl != null && videosInUse.add(video.id)) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.withVideoFiles(video, wait = true) { video ->
                    val videoUrl = video.url ?: return@withVideoFiles
                    var succeeded = false
                    try {
                        repository.updateOperationProgress(video.apply {
                            progress = 0
                            maxProgress = 100
                            status = OfflineVideo.STATUS_CONVERTING
                        })
                        if (videoUrl.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
                            val oldPlaylist = runCatching {
                                applicationContext.contentResolver.openInputStream(videoUrl.toUri())?.use {
                                    PlaylistUtils.parseMediaPlaylist(it)
                                }
                            }.getOrNull()

                            if (oldPlaylist == null || oldPlaylist.segments.isEmpty()) {
                                DiagnosticLogger.e("DownloadsViewModel", "convertToFile: cannot parse playlist for $videoUrl")
                                repository.updateStatus(video.apply { status = OfflineVideo.STATUS_PENDING })
                                return@withVideoFiles
                            }

                            val extension = oldPlaylist.segments.firstOrNull()?.uri?.substringAfterLast(".")?.substringBefore("?")?.takeIf { it.isNotBlank() } ?: "mp4"
                            val videoFileName = DownloadStorage.singleFileNameFor(video, extension)

                            val oldVideoDirectoryUri = videoUrl.substringBeforeLast("%2F")
                            val oldDirectoryUri = oldVideoDirectoryUri.substringBeforeLast("%2F", oldVideoDirectoryUri.substringBeforeLast("%3A") + "%3A")

                            val newVideoFileUri: Uri = runCatching {
                                // Write next to the playlist container, not the tree root,
                                // so chat/info sidecars stay together in per-VOD subfolders.
                                runCatching {
                                    DocumentsContract.createDocument(applicationContext.contentResolver, oldVideoDirectoryUri.toUri(), "video/mp4", videoFileName)
                                }.getOrNull() ?: run {
                                    val targetTreeUri = video.downloadPath?.takeIf { it.toUri().scheme == ContentResolver.SCHEME_CONTENT }?.toUri()
                                    if (targetTreeUri != null) {
                                        SafStorageUtils.getOrCreateFile(applicationContext, targetTreeUri, videoFileName, "video/mp4")
                                    } else {
                                        SafStorageUtils.getOrCreateFile(applicationContext, oldDirectoryUri.toUri(), videoFileName, "video/mp4")
                                    }
                                }
                            }.getOrElse {
                                val created = DocumentsContract.createDocument(applicationContext.contentResolver, oldDirectoryUri.toUri(), "video/mp4", videoFileName)
                                created ?: (oldDirectoryUri.removeSuffix("%2F") + "%2F" + videoFileName).toUri()
                            }

                            val playlists = repository.getPlaylists().mapNotNull { v ->
                                v.url?.takeIf {
                                    it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                            && it.substringBeforeLast("%2F") == oldVideoDirectoryUri
                                            && it != videoUrl
                                }
                            }
                            val siblings = playlists.map { uri ->
                                runCatching {
                                    applicationContext.contentResolver.openInputStream(uri.toUri())?.use {
                                        PlaylistUtils.parseMediaPlaylist(it)
                                    }
                                }.getOrNull()
                            }
                            val tracksToDelete = PlaylistUtils.unsharedAssetUris(oldPlaylist, siblings)
                                .mapTo(mutableSetOf(), PlaylistUtils::localAssetName)

                            repository.updateMaximumProgress(video.apply {
                                maxProgress = tracksToDelete.count()
                            })

                            (applicationContext.contentResolver.openOutputStream(newVideoFileUri, "wt")
                                ?: throw java.io.IOException("Cannot open converted video")).use { outputStream ->
                                if (oldPlaylist.initSegmentUri != null) {
                                    val oldFileUri = oldPlaylist.initSegmentUri
                                    (applicationContext.contentResolver.openInputStream(oldFileUri.toUri())
                                        ?: throw java.io.IOException("Missing initialization segment")).use { inputStream ->
                                        inputStream.copyTo(outputStream)
                                    }
                                }

                                oldPlaylist.segments.forEach { track ->
                                    val oldFileUri = track.uri
                                    (applicationContext.contentResolver.openInputStream(oldFileUri.toUri())
                                        ?: throw java.io.IOException("Missing media segment")).use { inputStream ->
                                        PlaylistUtils.copySegment(inputStream, outputStream, track)
                                    }
                                    repository.updateProgress(video.apply {
                                        progress += 1
                                    })
                                }
                            }

                            oldPlaylist.segments.distinctBy { it.uri }.forEach { track ->
                                if (PlaylistUtils.localAssetName(track.uri) in tracksToDelete) {
                                    runCatching { DocumentsContract.deleteDocument(applicationContext.contentResolver, track.uri.toUri()) }
                                }
                            }

                            repository.updateConvertedFiles(video.apply {
                                thumbnail.let {
                                    if (it == null || it == url || !File(it).exists()) {
                                        thumbnail = newVideoFileUri.toString()
                                    }
                                }
                                url = newVideoFileUri.toString()
                            })

                            // Converted file lives inside the same container now — delete only
                            // the old playlist, keep the folder with mp4 + sidecars.
                            runCatching {
                                DocumentsContract.deleteDocument(applicationContext.contentResolver, videoUrl.toUri())
                            }
                            succeeded = true
                        } else {
                            val oldPlaylistFile = File(videoUrl)
                            if (oldPlaylistFile.exists()) {
                                val oldVideoDirectory = oldPlaylistFile.parentFile
                                val oldDirectory = oldVideoDirectory?.parentFile
                                if (oldVideoDirectory != null && oldDirectory != null) {
                                    val oldPlaylist = runCatching {
                                        FileInputStream(oldPlaylistFile).use {
                                            PlaylistUtils.parseMediaPlaylist(it)
                                        }
                                    }.getOrNull()

                                    if (oldPlaylist == null || oldPlaylist.segments.isEmpty()) {
                                        DiagnosticLogger.e("DownloadsViewModel", "convertToFile: cannot parse local playlist for $videoUrl")
                                        repository.updateStatus(video.apply { status = OfflineVideo.STATUS_PENDING })
                                        return@withVideoFiles
                                    }

                                    val extension = oldPlaylist.segments.firstOrNull()?.uri?.substringAfterLast(".")?.substringBefore("?")?.takeIf { it.isNotBlank() } ?: "mp4"
                                    val videoFileName = DownloadStorage.singleFileNameFor(video, extension)
                                    // Keep converted file inside the same per-VOD container.
                                    val newVideoFile = File(oldVideoDirectory, videoFileName)
                                    val newVideoFileUri = newVideoFile.absolutePath

                                    val playlists = oldVideoDirectory.listFiles { it.extension == "m3u8" && it != oldPlaylistFile }
                                    val siblings = playlists?.map { file ->
                                        runCatching {
                                            file.inputStream().use(PlaylistUtils::parseMediaPlaylist)
                                        }.getOrNull()
                                    } ?: listOf(null)
                                    val tracksToDelete = PlaylistUtils.unsharedAssetUris(oldPlaylist, siblings)
                                        .mapTo(mutableSetOf(), PlaylistUtils::localAssetName)

                                    repository.updateMaximumProgress(video.apply {
                                        maxProgress = tracksToDelete.count()
                                    })

                                    FileOutputStream(newVideoFile).use { outputStream ->
                                        if (oldPlaylist.initSegmentUri != null) {
                                            val oldFile = File(oldVideoDirectory, oldPlaylist.initSegmentUri.substringAfterLast("%2F").substringAfterLast("/"))
                                            oldFile.inputStream().use { inputStream -> inputStream.copyTo(outputStream) }
                                        }

                                        oldPlaylist.segments.forEach { track ->
                                            val oldFile = File(oldVideoDirectory, track.uri.substringAfterLast("%2F").substringAfterLast("/"))
                                            oldFile.inputStream().use { inputStream -> PlaylistUtils.copySegment(inputStream, outputStream, track) }
                                            repository.updateProgress(video.apply {
                                                progress += 1
                                            })
                                        }
                                    }

                                    tracksToDelete.forEach { File(oldVideoDirectory, it).delete() }

                                    repository.updateConvertedFiles(video.apply {
                                        thumbnail.let {
                                            if (it == null || it == url || !File(it).exists()) {
                                                thumbnail = newVideoFileUri
                                            }
                                        }
                                        url = newVideoFileUri
                                    })

                                    oldPlaylistFile.delete()
                                    succeeded = true
                                }
                            }
                        }
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        Log.e("DownloadsViewModel", "convertToFile failed for video ${video.id}", e)
                        DiagnosticLogger.e("DownloadsViewModel", "convertToFile failed: ${e.message}")
                    } finally {
                        videosInUse.remove(video.id)
                        withContext(NonCancellable) {
                            repository.updateStatus(video.apply {
                                status = if (succeeded) OfflineVideo.STATUS_DOWNLOADED else OfflineVideo.STATUS_PENDING
                            })
                        }
                    }
                }
            }.invokeOnCompletion {
                videosInUse.remove(video.id)
            }
        }
    }

    fun moveToSharedStorage(newUri: Uri, video: OfflineVideo) {
        val videoUrl = video.url
        if (videoUrl != null && videosInUse.add(video.id)) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.withVideoFiles(video, wait = true) { video ->
                    val videoUrl = video.url ?: return@withVideoFiles
                    try {
                        repository.updateOperationProgress(video.apply {
                            progress = 0
                            maxProgress = 100
                            status = OfflineVideo.STATUS_MOVING
                        })
                        if (videoUrl.endsWith(".m3u8")) {
                            val oldPlaylistFile = File(videoUrl)
                            if (oldPlaylistFile.exists()) {
                                val oldVideoDirectory = oldPlaylistFile.parentFile
                                if (oldVideoDirectory != null) {
                                    val dirDoc = DownloadStorage.containerDoc(applicationContext, newUri, video)
                                    val playlistDocUri = SafStorageUtils.getOrCreateFileInDir(dirDoc, oldPlaylistFile.name, "application/x-mpegURL")
                                    val oldPlaylist = FileInputStream(oldPlaylistFile).use {
                                        PlaylistUtils.parseMediaPlaylist(it)
                                    }
                                    val segments = ArrayList<Segment>()
                                    oldPlaylist.segments.forEach { segment ->
                                        val segName = segment.uri.substringAfterLast("%2F").substringAfterLast("/")
                                        val segDocUri = SafStorageUtils.getOrCreateFileInDir(dirDoc, segName, "video/mp2t")
                                        segments.add(segment.copy(uri = segDocUri.toString()))
                                    }
                                    val newInitUri = oldPlaylist.initSegmentUri?.let { initUri ->
                                        val initName = initUri.substringAfterLast("%2F").substringAfterLast("/")
                                        SafStorageUtils.getOrCreateFileInDir(dirDoc, initName, "video/mp2t").toString()
                                    }
                                    (applicationContext.contentResolver.openOutputStream(playlistDocUri, "wt")
                                        ?: throw IOException("Cannot open destination playlist")).use {
                                        PlaylistUtils.writeMediaPlaylist(oldPlaylist.copy(
                                            initSegmentUri = newInitUri,
                                            segments = segments
                                        ), it)
                                    }
                                    val playlists = oldVideoDirectory.listFiles { it.extension == "m3u8" && it != oldPlaylistFile }
                                    val siblings = playlists?.map { file ->
                                        runCatching {
                                            file.inputStream().use(PlaylistUtils::parseMediaPlaylist)
                                        }.getOrNull()
                                    } ?: listOf(null)
                                    val tracksToDelete = PlaylistUtils.unsharedAssetUris(oldPlaylist, siblings)
                                        .mapTo(mutableSetOf(), PlaylistUtils::localAssetName)
                                    if (oldPlaylist.initSegmentUri != null && newInitUri != null) {
                                        val oldFile = File(oldVideoDirectory, oldPlaylist.initSegmentUri.substringAfterLast("%2F").substringAfterLast("/"))
                                        if (oldFile.exists()) {
                                            copyToSharedStorage(oldFile, newInitUri.toUri())
                                        } else {
                                            throw IOException("Missing initialization segment")
                                        }
                                    }
                                    repository.updateMaximumProgress(video.apply {
                                        maxProgress = tracksToDelete.count()
                                    })
                                    oldPlaylist.segments.withIndex().distinctBy { PlaylistUtils.localAssetName(it.value.uri) }.forEach { (index, track) ->
                                        val segDocUri = segments.getOrNull(index)?.uri?.toUri()
                                        val oldFile = File(oldVideoDirectory, track.uri.substringAfterLast("%2F").substringAfterLast("/"))
                                        copyToSharedStorage(oldFile, segDocUri ?: throw IOException("Missing segment destination"))
                                        repository.updateProgress(video.apply {
                                            progress += 1
                                        })
                                    }
                                    val oldChatFile = video.chatUrl?.let { uri -> File(uri).takeIf { it.exists() } }
                                    val newChatFileUri = oldChatFile?.let {
                                        SafStorageUtils.getOrCreateFileInDir(dirDoc, it.name, "application/json").toString()
                                    }
                                    if (oldChatFile != null && newChatFileUri != null) {
                                        copyToSharedStorage(oldChatFile, newChatFileUri.toUri())
                                    }
                                    val oldInfoFile = File(oldVideoDirectory, DownloadStorage.INFO_FILE_NAME).takeIf { it.exists() }
                                    if (oldInfoFile != null) {
                                        runCatching {
                                            val infoUri = SafStorageUtils.getOrCreateFileInDir(dirDoc, DownloadStorage.INFO_FILE_NAME, "application/json")
                                            applicationContext.contentResolver.openOutputStream(infoUri, "wt")?.use { outputStream ->
                                                oldInfoFile.inputStream().use { inputStream ->
                                                    inputStream.copyTo(outputStream)
                                                }
                                            }
                                        }
                                    }
                                    currentCoroutineContext().ensureActive()
                                    repository.updateStorageLocation(video.apply {
                                        thumbnail.let {
                                            if (it == null || it == url || !File(it).exists()) {
                                                segments.getOrNull(max(0, (segments.size / 2) - 1))?.uri?.let { trackUri ->
                                                    thumbnail = trackUri
                                                }
                                            }
                                        }
                                        url = playlistDocUri.toString()
                                        chatUrl = newChatFileUri
                                        downloadPath = newUri.toString()
                                    })
                                    tracksToDelete.forEach { File(oldVideoDirectory, it).delete() }
                                    oldPlaylistFile.delete()
                                    oldChatFile?.delete()
                                    File(oldVideoDirectory, DownloadStorage.INFO_FILE_NAME).takeIf { it.exists() }?.delete()
                                    DownloadStorage.deleteIfEmptyContainer(oldVideoDirectory, video.downloadPath)
                                }
                            }
                        } else {
                            val oldFile = File(videoUrl)
                            if (oldFile.exists()) {
                                val dirDoc = DownloadStorage.containerDoc(applicationContext, newUri, video)
                                val newFileUri = SafStorageUtils.getOrCreateFileInDir(dirDoc, oldFile.name, "video/mp4")
                                copyToSharedStorage(oldFile, newFileUri)
                                val oldChatFile = video.chatUrl?.let { uri -> File(uri).takeIf { it.exists() } }
                                val newChatFileUri = oldChatFile?.let {
                                    SafStorageUtils.getOrCreateFileInDir(dirDoc, it.name, "application/json").toString()
                                }
                                if (oldChatFile != null && newChatFileUri != null) {
                                    copyToSharedStorage(oldChatFile, newChatFileUri.toUri())
                                }
                                val oldInfoFile = oldFile.parentFile?.let { File(it, DownloadStorage.INFO_FILE_NAME) }?.takeIf { it.exists() }
                                if (oldInfoFile != null) {
                                    runCatching {
                                        val infoUri = SafStorageUtils.getOrCreateFileInDir(dirDoc, DownloadStorage.INFO_FILE_NAME, "application/json")
                                        applicationContext.contentResolver.openOutputStream(infoUri, "wt")?.use { outputStream ->
                                            oldInfoFile.inputStream().use { inputStream ->
                                                inputStream.copyTo(outputStream)
                                            }
                                        }
                                    }
                                }
                                currentCoroutineContext().ensureActive()
                                repository.updateStorageLocation(video.apply {
                                    thumbnail.let {
                                        if (it == null || it == url || !File(it).exists()) {
                                            thumbnail = newFileUri.toString()
                                        }
                                    }
                                    url = newFileUri.toString()
                                    chatUrl = newChatFileUri
                                    downloadPath = newUri.toString()
                                })
                                val oldParent = oldFile.parentFile
                                oldFile.delete()
                                oldChatFile?.delete()
                                oldInfoFile?.delete()
                                // deleteIfEmptyContainer never removes the storage root
                                // (".downloads" guard) — legacy flat parents survive.
                                oldParent?.let { DownloadStorage.deleteIfEmptyContainer(it, null) }
                            }
                        }
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        Log.e("DownloadsViewModel", "moveToSharedStorage failed for video ${video.id}", e)
                        DiagnosticLogger.e("DownloadsViewModel", "moveToSharedStorage failed: ${e.message}")
                    } finally {
                        videosInUse.remove(video.id)
                        withContext(NonCancellable) {
                            val intact = DownloadStorage.isOutputIntact(applicationContext, video.url)
                            repository.updateStatus(video.apply {
                                status = if (intact) OfflineVideo.STATUS_DOWNLOADED else OfflineVideo.STATUS_PENDING
                            })
                        }
                    }
                }
            }.invokeOnCompletion {
                videosInUse.remove(video.id)
            }
        }
    }

    fun moveToAppStorage(path: String, video: OfflineVideo) {
        val videoUrl = video.url
        if (videoUrl != null && videosInUse.add(video.id)) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.withVideoFiles(video, wait = true) { video ->
                    val videoUrl = video.url ?: return@withVideoFiles
                    try {
                        repository.updateOperationProgress(video.apply {
                            progress = 0
                            maxProgress = 100
                            status = OfflineVideo.STATUS_MOVING
                        })
                        if (videoUrl.endsWith(".m3u8")) {
                            val oldPlaylistFileName = Uri.decode(videoUrl.substringAfterLast("%2F"))
                            val oldVideoDirectoryUri = videoUrl.substringBeforeLast("%2F")
                            val newContainer = DownloadStorage.containerFile(path, video)
                            val newVideoDirectoryUri = newContainer.absolutePath
                            val newPlaylistFileUri = newVideoDirectoryUri + File.separator + oldPlaylistFileName
                            val oldPlaylist = runCatching {
                                applicationContext.contentResolver.openInputStream(videoUrl.toUri())?.use {
                                    PlaylistUtils.parseMediaPlaylist(it)
                                }
                            }.getOrNull()

                            if (oldPlaylist != null) {
                                val segments = ArrayList<Segment>()
                                oldPlaylist.segments.forEach { segment ->
                                    segments.add(segment.copy(uri = newVideoDirectoryUri + File.separator + Uri.decode(segment.uri.substringAfterLast("%2F").substringAfterLast("/"))))
                                }
                                FileOutputStream(newPlaylistFileUri).use {
                                    PlaylistUtils.writeMediaPlaylist(oldPlaylist.copy(
                                        initSegmentUri = oldPlaylist.initSegmentUri?.let { uri -> newVideoDirectoryUri + File.separator + Uri.decode(uri.substringAfterLast("%2F").substringAfterLast("/")) },
                                        segments = segments
                                    ), it)
                                }
                                val playlists = repository.getPlaylists().mapNotNull { v ->
                                    v.url?.takeIf {
                                        it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                                && it.substringBeforeLast("%2F") == oldVideoDirectoryUri
                                                && it != videoUrl
                                    }
                                }
                                val siblings = playlists.map { uri ->
                                    runCatching {
                                        applicationContext.contentResolver.openInputStream(uri.toUri())?.use {
                                            PlaylistUtils.parseMediaPlaylist(it)
                                        }
                                    }.getOrNull()
                                }
                                val tracksToDelete = PlaylistUtils.unsharedAssetUris(oldPlaylist, siblings)
                                    .mapTo(mutableSetOf(), PlaylistUtils::localAssetName)
                                if (oldPlaylist.initSegmentUri != null) {
                                    val oldFileName = oldPlaylist.initSegmentUri.substringAfterLast("%2F").substringAfterLast("/")
                                    val oldFileUri = "$oldVideoDirectoryUri%2F$oldFileName"
                                    val newFileUri = newVideoDirectoryUri + File.separator + Uri.decode(oldFileName)
                                    copyFromSharedStorage(oldFileUri.toUri(), File(newFileUri))
                                }
                                repository.updateMaximumProgress(video.apply {
                                    maxProgress = tracksToDelete.count()
                                })
                                oldPlaylist.segments.distinctBy { PlaylistUtils.localAssetName(it.uri) }.forEach { track ->
                                    val oldFileName = track.uri.substringAfterLast("%2F").substringAfterLast("/")
                                    val oldFileUri = "$oldVideoDirectoryUri%2F$oldFileName"
                                    val newFileUri = newVideoDirectoryUri + File.separator + Uri.decode(oldFileName)
                                    copyFromSharedStorage(oldFileUri.toUri(), File(newFileUri))
                                    repository.updateProgress(video.apply {
                                        progress += 1
                                    })
                                }
                                val oldChatUri = video.chatUrl
                                val oldChatFileName = oldChatUri?.substringAfterLast("%2F")?.substringAfterLast("/")?.substringAfterLast("%3A")?.let { Uri.decode(it) }
                                val newChatFileUri = oldChatFileName?.let { newVideoDirectoryUri + File.separator + it }
                                if (oldChatUri != null && newChatFileUri != null) {
                                    copyFromSharedStorage(oldChatUri.toUri(), File(newChatFileUri))
                                }
                                runCatching {
                                    val infoFileName = DownloadStorage.INFO_FILE_NAME
                                    val infoSource = "$oldVideoDirectoryUri%2F$infoFileName"
                                    runCatching {
                                        applicationContext.contentResolver.openInputStream(infoSource.toUri())?.use { inputStream ->
                                            FileOutputStream(newVideoDirectoryUri + File.separator + infoFileName).use { outputStream ->
                                                inputStream.copyTo(outputStream)
                                            }
                                        }
                                    }
                                }
                                currentCoroutineContext().ensureActive()
                                repository.updateStorageLocation(video.apply {
                                    thumbnail.let {
                                        if (it == null || it == url || !File(it).exists()) {
                                            thumbnail = newVideoDirectoryUri + File.separator + oldPlaylist.segments.getOrNull(
                                                max(0, (oldPlaylist.segments.size / 2) - 1)
                                            )?.uri?.substringAfterLast("%2F")?.substringAfterLast("/")?.let { Uri.decode(it) }
                                        }
                                    }
                                    url = newPlaylistFileUri
                                    chatUrl = newChatFileUri
                                    downloadPath = path
                                })
                                tracksToDelete.forEach { name ->
                                    runCatching {
                                        DocumentsContract.deleteDocument(applicationContext.contentResolver, "$oldVideoDirectoryUri%2F${Uri.encode(name)}".toUri())
                                    }
                                }
                                runCatching {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, videoUrl.toUri())
                                }
                                if (oldChatUri != null) {
                                    runCatching {
                                        DocumentsContract.deleteDocument(applicationContext.contentResolver, oldChatUri.toUri())
                                    }
                                }
                            }
                        } else {
                            val oldFileName = Uri.decode(videoUrl.substringAfterLast("%2F").substringAfterLast("/").substringAfterLast("%3A"))
                            val newContainer = DownloadStorage.containerFile(path, video)
                            val newFileUri = newContainer.absolutePath + File.separator + oldFileName
                            copyFromSharedStorage(videoUrl.toUri(), File(newFileUri))
                            val oldChatUri = video.chatUrl
                            val oldChatFileName = oldChatUri?.substringAfterLast("%2F")?.substringAfterLast("/")?.substringAfterLast("%3A")?.let { Uri.decode(it) }
                            val newChatFileUri = oldChatFileName?.let { newContainer.absolutePath + File.separator + it }
                            if (oldChatUri != null && newChatFileUri != null) {
                                copyFromSharedStorage(oldChatUri.toUri(), File(newChatFileUri))
                            }
                            runCatching {
                                val infoSource = "${videoUrl.substringBeforeLast("%2F")}%2F${DownloadStorage.INFO_FILE_NAME}"
                                applicationContext.contentResolver.openInputStream(infoSource.toUri())?.use { inputStream ->
                                    FileOutputStream(newContainer.absolutePath + File.separator + DownloadStorage.INFO_FILE_NAME).use { outputStream ->
                                        inputStream.copyTo(outputStream)
                                    }
                                }
                            }
                            currentCoroutineContext().ensureActive()
                            repository.updateStorageLocation(video.apply {
                                thumbnail.let {
                                    if (it == null || it == url || !File(it).exists()) {
                                        thumbnail = newFileUri
                                    }
                                }
                                url = newFileUri
                                chatUrl = newChatFileUri
                                downloadPath = path
                            })
                            runCatching {
                                DocumentsContract.deleteDocument(applicationContext.contentResolver, videoUrl.toUri())
                            }
                            if (oldChatUri != null) {
                                runCatching {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, oldChatUri.toUri())
                                }
                            }
                        }
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        Log.e("DownloadsViewModel", "moveToAppStorage failed for video ${video.id}", e)
                        DiagnosticLogger.e("DownloadsViewModel", "moveToAppStorage failed: ${e.message}")
                    } finally {
                        videosInUse.remove(video.id)
                        withContext(NonCancellable) {
                            val intact = DownloadStorage.isOutputIntact(applicationContext, video.url)
                            repository.updateStatus(video.apply {
                                status = if (intact) OfflineVideo.STATUS_DOWNLOADED else OfflineVideo.STATUS_PENDING
                            })
                        }
                    }
                }
            }.invokeOnCompletion {
                videosInUse.remove(video.id)
            }
        }
    }

    private fun copyFromSharedStorage(source: Uri, destination: File) {
        (applicationContext.contentResolver.openInputStream(source)
            ?: throw IOException("Cannot open source file")).use { input ->
            destination.outputStream().use { output -> input.copyTo(output) }
        }
    }

    private fun copyToSharedStorage(source: File, destination: Uri) {
        source.inputStream().use { input ->
            (applicationContext.contentResolver.openOutputStream(destination, "wt")
                ?: throw IOException("Cannot open destination file")).use { output -> input.copyTo(output) }
        }
    }

    fun updateChatUrl(newUri: Uri, video: OfflineVideo) {
        if (videosInUse.add(video.id)) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.withVideoFiles(video, wait = true) { video ->
                    var id: String? = null
                    var title: String? = null
                    var uploadDate: Long? = null
                    var channelId: String? = null
                    var channelLogin: String? = null
                    var channelName: String? = null
                    var gameId: String? = null
                    var gameSlug: String? = null
                    var gameName: String? = null
                    try {
                        applicationContext.contentResolver.openInputStream(newUri)?.bufferedReader()?.use { fileReader ->
                            JsonReader(fileReader).use { reader ->
                                reader.beginObject()
                                while (reader.hasNext()) {
                                    when (reader.nextName()) {
                                        "video" -> {
                                            reader.beginObject()
                                            while (reader.hasNext()) {
                                                when (reader.nextName()) {
                                                    "id" -> id = reader.nextString()
                                                    "title" -> title = reader.nextString()
                                                    "uploadDate" -> uploadDate = reader.nextLong()
                                                    "channelId" -> channelId = reader.nextString()
                                                    "channelLogin" -> channelLogin = reader.nextString()
                                                    "channelName" -> channelName = reader.nextString()
                                                    "gameId" -> gameId = reader.nextString()
                                                    "gameSlug" -> gameSlug = reader.nextString()
                                                    "gameName" -> gameName = reader.nextString()
                                                    else -> reader.skipValue()
                                                }
                                            }
                                            reader.endObject()
                                        }
                                        else -> reader.skipValue()
                                    }
                                }
                                reader.endObject()
                            }
                        }
                    } catch (e: Exception) {

                    }
                    repository.updateImportedChatMetadata(video.apply {
                        if (!title.isNullOrBlank()) this.name = title
                        if (!channelId.isNullOrBlank()) this.channelId = channelId
                        if (!channelLogin.isNullOrBlank()) this.channelLogin = channelLogin
                        if (!channelName.isNullOrBlank()) this.channelName = channelName
                        if (!gameId.isNullOrBlank()) this.gameId = gameId
                        if (!gameSlug.isNullOrBlank()) this.gameSlug = gameSlug
                        if (!gameName.isNullOrBlank()) this.gameName = gameName
                        if (uploadDate != null) this.uploadDate = uploadDate
                        if (!id.isNullOrBlank()) this.videoId = id
                        chatUrl = newUri.toString()
                    })
                }
            }.invokeOnCompletion {
                videosInUse.remove(video.id)
            }
        }
    }

    suspend fun redownloadChat(video: OfflineVideo) {
        if (!videosInUse.add(video.id)) {
            return
        }
        try {
            withContext(Dispatchers.IO) {
                repository.withVideoFiles(video, wait = true) { video ->
                    repository.resetChatProgress(video.apply {
                        chatProgress = 0
                        chatBytes = 0
                        chatOffsetSeconds = 0
                        status = OfflineVideo.STATUS_PENDING
                    })
                }
            }
        } finally {
            videosInUse.remove(video.id)
        }
    }

    fun delete(video: OfflineVideo, keepFiles: Boolean) {
        if (videosInUse.add(video.id)) {
            externalScope.launch(Dispatchers.IO) {
                repository.withVideoDeletion(video) { video ->
                    val videoUrl = video.url
                    val originalStatus = video.status
                    val originalProgress = video.progress
                    val originalMaxProgress = video.maxProgress
                    val activeRecording = video.status in setOf(
                        OfflineVideo.STATUS_DOWNLOADING, OfflineVideo.STATUS_WAITING_FOR_STREAM,
                        OfflineVideo.STATUS_QUEUED, OfflineVideo.STATUS_QUEUED_WIFI, OfflineVideo.STATUS_BLOCKED,
                    )
                    try {
                        repository.updateOperationProgress(video.apply {
                            progress = 0
                            maxProgress = 100
                            status = OfflineVideo.STATUS_DELETING
                        })
                        if (video.live) {
                            if (activeRecording) video.channelLogin?.let { WorkManager.getInstance(applicationContext).cancelUniqueWork(it) }
                        } else {
                            WorkManager.getInstance(applicationContext).cancelAllWorkByTag(video.id.toString())
                        }
                        if (videoUrl != null && !keepFiles) {
                            if (videoUrl.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
                                if (videoUrl.endsWith(".m3u8")) {
                                    val videoDirectoryUri = videoUrl.substringBeforeLast("%2F")
                                    val playlist = safCallWithTimeout {
                                        applicationContext.contentResolver.openInputStream(videoUrl.toUri())!!.use {
                                            PlaylistUtils.parseMediaPlaylist(it)
                                        }
                                    } ?: throw IOException("Cannot read download playlist")
                                    val playlists = repository.getPlaylists().mapNotNull { video ->
                                        video.url?.takeIf {
                                            it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                                    && it.substringBeforeLast("%2F") == videoDirectoryUri
                                                    && it != videoUrl
                                        }
                                    }
                                    val siblings = playlists.map { uri ->
                                        safCallWithTimeout {
                                            applicationContext.contentResolver.openInputStream(uri.toUri())?.use {
                                                PlaylistUtils.parseMediaPlaylist(it)
                                            }
                                        }?.takeIf { it.segments.isNotEmpty() }
                                            ?: throw IOException("Cannot read sibling download playlist")
                                    }
                                    val tracks = PlaylistUtils.unsharedAssetUris(playlist, siblings)
                                        .filter { uri ->
                                            when (uri.toUri().scheme) {
                                                null -> true
                                                ContentResolver.SCHEME_CONTENT -> uri.substringBeforeLast("%2F") == videoDirectoryUri
                                                else -> false
                                            }
                                        }
                                    repository.updateMaximumProgress(video.apply {
                                        maxProgress = tracks.size
                                    })
                                    val deletedCount = AtomicInteger(0)
                                    val providerFailures = AtomicInteger(0)
                                    val providerAbandoned = AtomicBoolean(false)
                                    coroutineScope {
                                        val deleteSemaphore = Semaphore(6)
                                        tracks.forEach { track ->
                                            launch {
                                                deleteSemaphore.withPermit {
                                                    if (providerAbandoned.get()) return@withPermit
                                                    val assetUri = if (track.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
                                                        track.toUri()
                                                    } else {
                                                        "$videoDirectoryUri%2F${Uri.encode(PlaylistUtils.localAssetName(track))}".toUri()
                                                    }
                                                    if (!deleteSharedDocument(assetUri)) {
                                                        if (providerFailures.incrementAndGet() >= 3) providerAbandoned.set(true)
                                                    } else {
                                                        val deleted = deletedCount.incrementAndGet()
                                                        // Batched Room writes: first segment + one per ~50 instead of one per segment.
                                                        if (deleted == 1 || deleted % 50 == 0 || deleted == tracks.size) {
                                                            repository.updateProgress(video.apply {
                                                                progress = deleted
                                                            })
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    check(deletedCount.get() == tracks.size) { "Could not delete all download segments" }
                                    video.chatUrl?.let { check(deleteSharedDocument(it.toUri())) }
                                    if (playlists.isEmpty()) {
                                        check(deleteSharedDocument("$videoDirectoryUri%2F${DownloadStorage.INFO_FILE_NAME}".toUri()))
                                    }
                                    check(deleteSharedDocument(videoUrl.toUri())) { "Could not delete download playlist" }
                                    if (playlists.isEmpty()) {
                                        safCallWithTimeout {
                                            SafStorageUtils.deleteIfEmptyDirectory(applicationContext, videoDirectoryUri.toUri())
                                        }
                                    }
                                } else {
                                    video.chatUrl?.let { check(deleteSharedDocument(it.toUri())) }
                                    // Sidecar + container: single files own their container
                                    // (no shared segments), so remove both when done. The
                                    // directory delete is a no-op when siblings remain.
                                    // Chat goes first — otherwise it pins the folder.
                                    val containerUri = DownloadStorage.containerOfUrl(videoUrl, video.downloadPath)
                                    if (containerUri != null && containerUri != videoUrl) {
                                        check(deleteSharedDocument("$containerUri%2F${DownloadStorage.INFO_FILE_NAME}".toUri()))
                                    }
                                    check(deleteSharedDocument(videoUrl.toUri())) { "Could not delete download file" }
                                    if (containerUri != null && containerUri != videoUrl) {
                                        safCallWithTimeout {
                                            SafStorageUtils.deleteIfEmptyDirectory(applicationContext, containerUri.toUri())
                                        }
                                    }
                                }
                            } else {
                                val playlistFile = File(videoUrl)
                                if (!playlistFile.exists()) {
                                    video.chatUrl?.let { File(it).delete() }
                                    repository.deleteVideo(video, keepFiles)
                                    return@withVideoDeletion
                                }
                                if (videoUrl.endsWith(".m3u8")) {
                                    val directory = playlistFile.parentFile
                                    if (directory != null) {
                                        val playlists = directory.listFiles { it.extension == "m3u8" && it != playlistFile }
                                        if (playlists != null) {
                                            val playlist = try {
                                                playlistFile.inputStream().use(PlaylistUtils::parseMediaPlaylist)
                                            } catch (error: Exception) {
                                                if (error is CancellationException) throw error
                                                DiagnosticLogger.e("Downloads", "Could not read playlist while deleting", error)
                                                null
                                            }
                                            val siblings = playlists.map {
                                                runCatching { it.inputStream().use(PlaylistUtils::parseMediaPlaylist) }.getOrNull()
                                            }
                                            val tracks = playlist?.let { PlaylistUtils.unsharedAssetUris(it, siblings) }.orEmpty()
                                                .mapNotNull { PlaylistUtils.localAssetFile(directory, it) }
                                            repository.updateMaximumProgress(video.apply {
                                                maxProgress = tracks.size
                                            })
                                            tracks.forEachIndexed { index, track ->
                                                track.delete()
                                                if ((index + 1) % 50 == 0 || index + 1 == tracks.size) {
                                                    repository.updateProgress(video.apply {
                                                        progress = index + 1
                                                    })
                                                }
                                            }
                                            playlistFile.delete()
                                            if (playlists.isEmpty()) {
                                                if (directory.listFiles()?.all { it.name == DownloadStorage.INFO_FILE_NAME } == true) {
                                                    File(directory, DownloadStorage.INFO_FILE_NAME).delete()
                                                }
                                                DownloadStorage.deleteIfEmptyContainer(directory, video.downloadPath)
                                            }
                                        }
                                    }
                                } else {
                                    val parent = playlistFile.parentFile
                                    playlistFile.delete()
                                    video.chatUrl?.let { File(it).delete() }
                                    // Single files own their container: drop the sidecar
                                    // and the folder with it (survives when siblings exist).
                                    parent?.let { File(it, DownloadStorage.INFO_FILE_NAME).takeIf { f -> f.exists() }?.delete() }
                                    parent?.let { DownloadStorage.deleteIfEmptyContainer(it, null) }
                                }
                                video.chatUrl?.let { File(it).delete() }
                            }
                        }
                        withContext(NonCancellable) { repository.deleteVideo(video, keepFiles) }
                    } catch (error: Exception) {
                        withContext(NonCancellable) {
                            repository.updateOperationProgress(video.apply {
                                progress = originalProgress
                                maxProgress = originalMaxProgress
                                status = if (activeRecording) OfflineVideo.STATUS_PENDING else originalStatus
                            })
                        }
                        if (error is CancellationException) throw error
                        DiagnosticLogger.e("Downloads", "Could not delete download", error)
                    }
                }
            }.invokeOnCompletion {
                videosInUse.remove(video.id)
            }
        }
    }

    private suspend fun deleteSharedDocument(uri: Uri): Boolean = safCallWithTimeout {
        try {
            DocumentsContract.deleteDocument(applicationContext.contentResolver, uri)
        } catch (_: FileNotFoundException) {
            true
        }
    } == true

    /**
     * Runs a blocking storage-provider call with a timeout. DocumentsContract and
     * ContentResolver binder calls cannot be interrupted once hung, so the call is
     * detached onto [externalScope] and abandoned when the timeout elapses — this
     * coroutine moves on and treats the call as failed instead of freezing deletion.
     */
    private suspend fun <T> safCallWithTimeout(block: suspend () -> T): T? {
        val deferred = externalScope.async(safCallDispatcher) {
            runCatching { block() }
        }
        return try {
            withTimeoutOrNull(SAF_CALL_TIMEOUT_MS) { deferred.await() }?.getOrNull()
        } catch (error: CancellationException) {
            if (!currentCoroutineContext().isActive) throw error
            null
        } finally {
            deferred.cancel()
        }
    }

    /**
     * Deletion marks rows STATUS_DELETING before touching files, so process death
     * mid-delete leaves them stuck with no retry path. Reset to DOWNLOADED so the
     * entry stays actionable; only drop the row when a plain file path is reliably
     * proven gone — DownloadStorage.exists() also returns false on provider
     * errors, so dropping content:// rows here could destroy intact entries.
     */
    private suspend fun recoverInterruptedDeletions() {
        val stuckVideos = try {
            repository.getDeletingVideos()
        } catch (error: Exception) {
            if (error is CancellationException) throw error
            DiagnosticLogger.e("Downloads", "Could not query interrupted deletions", error)
            return
        }
        stuckVideos.forEach { video ->
            try {
                repository.withVideoDeletion(video) { fresh ->
                    if (fresh.status != OfflineVideo.STATUS_DELETING) {
                        return@withVideoDeletion
                    }
                    val fileState = safCallWithTimeout { DownloadStorage.exists(applicationContext, fresh.url) }
                    val fileProvenGone = fileState == false && fresh.url?.toUri()?.scheme != ContentResolver.SCHEME_CONTENT
                    if (fileProvenGone) {
                        repository.deleteVideo(fresh, keepFiles = false)
                    } else {
                        repository.updateStatus(fresh.apply { status = OfflineVideo.STATUS_DOWNLOADED })
                    }
                }
            } catch (error: Exception) {
                if (error is CancellationException) throw error
                DiagnosticLogger.e("Downloads", "Could not recover interrupted deletion", error)
            }
        }
    }
}
