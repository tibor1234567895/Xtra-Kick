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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
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

    var selectedVideo: OfflineVideo? = null
    private val videosInUse = mutableListOf<OfflineVideo>()
    private val currentDownloads = mutableListOf<Int>()
    private val liveDownloads = mutableListOf<String>()

    val flow = Pager(
        PagingConfig(pageSize = 30, prefetchDistance = 3, initialLoadSize = 30),
    ) {
        repository.loadAllVideos()
    }.flow.cachedIn(viewModelScope)

    fun finishDownload(video: OfflineVideo) {
        video.chatUrl?.let { url ->
            val isShared = url.toUri().scheme == ContentResolver.SCHEME_CONTENT
            if (isShared) {
                applicationContext.contentResolver.openFileDescriptor(url.toUri(), "rw")!!.use {
                    FileOutputStream(it.fileDescriptor).use { output ->
                        output.channel.truncate(video.chatBytes)
                    }
                }
            } else {
                FileOutputStream(url).use { output ->
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
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateVideo(video.apply {
                status = OfflineVideo.STATUS_DOWNLOADED
            })
        }
    }

    fun checkLiveDownloadStatus(channelLogin: String) {
        if (!liveDownloads.contains(channelLogin)) {
            liveDownloads.add(channelLogin)
            viewModelScope.launch(Dispatchers.IO) {
                WorkManager.getInstance(applicationContext).getWorkInfosForUniqueWorkFlow(channelLogin).collect { list ->
                    val work = list.lastOrNull()
                    when {
                        work == null || work.state.isFinished -> {
                            repository.getLiveDownload(channelLogin)?.let { video ->
                                if (video.status == OfflineVideo.STATUS_DOWNLOADING || video.status == OfflineVideo.STATUS_BLOCKED || video.status == OfflineVideo.STATUS_QUEUED || video.status == OfflineVideo.STATUS_QUEUED_WIFI || video.status == OfflineVideo.STATUS_WAITING_FOR_STREAM) {
                                    repository.updateVideo(video.apply {
                                        status = OfflineVideo.STATUS_PENDING
                                    })
                                }
                            }
                            cancel()
                        }
                        work.state == WorkInfo.State.ENQUEUED -> {
                            repository.getLiveDownload(channelLogin)?.let { video ->
                                repository.updateVideo(video.apply {
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
                                repository.updateVideo(video.apply {
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
        if (!currentDownloads.contains(videoId)) {
            currentDownloads.add(videoId)
            viewModelScope.launch(Dispatchers.IO) {
                WorkManager.getInstance(applicationContext).getWorkInfosByTagFlow(videoId.toString()).collect { list ->
                    val work = list.lastOrNull()
                    when {
                        work == null || work.state.isFinished -> {
                            repository.getVideoById(videoId)?.let { video ->
                                if (video.status == OfflineVideo.STATUS_DOWNLOADING || video.status == OfflineVideo.STATUS_BLOCKED || video.status == OfflineVideo.STATUS_QUEUED || video.status == OfflineVideo.STATUS_QUEUED_WIFI || video.status == OfflineVideo.STATUS_CONVERTING || video.status == OfflineVideo.STATUS_MOVING || video.status == OfflineVideo.STATUS_DELETING) {
                                    repository.updateVideo(video.apply {
                                        status = OfflineVideo.STATUS_PENDING
                                    })
                                }
                            }
                            cancel()
                        }
                        work.state == WorkInfo.State.ENQUEUED -> {
                            repository.getVideoById(videoId)?.let { video ->
                                repository.updateVideo(video.apply {
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
                                repository.updateVideo(video.apply {
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
        if (!videosInUse.contains(video) && videoUrl != null) {
            videosInUse.add(video)
            viewModelScope.launch(Dispatchers.IO) {
                var succeeded = false
                try {
                    repository.updateVideo(video.apply {
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
                            repository.updateVideo(video.apply { status = OfflineVideo.STATUS_PENDING })
                            return@launch
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

                        val tracksToDelete = mutableListOf<String>()
                        oldPlaylist.segments.forEach { tracksToDelete.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                        val playlists = repository.getPlaylists().mapNotNull { v ->
                            v.url?.takeIf {
                                it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                        && it.substringBeforeLast("%2F") == oldVideoDirectoryUri
                                        && it != videoUrl
                            }
                        }
                        playlists.forEach { uri ->
                            runCatching {
                                applicationContext.contentResolver.openInputStream(uri.toUri())?.use {
                                    PlaylistUtils.parseMediaPlaylist(it)
                                }
                            }.getOrNull()?.let { p ->
                                p.segments.forEach { tracksToDelete.remove(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                            }
                        }

                        repository.updateVideo(video.apply {
                            maxProgress = tracksToDelete.count()
                        })

                        applicationContext.contentResolver.openOutputStream(newVideoFileUri, "wt")?.use { outputStream ->
                            if (oldPlaylist.initSegmentUri != null) {
                                val oldFileUri = oldPlaylist.initSegmentUri
                                runCatching {
                                    applicationContext.contentResolver.openInputStream(oldFileUri.toUri())?.use { inputStream ->
                                        inputStream.copyTo(outputStream)
                                    }
                                }.onFailure { e ->
                                    Log.w("DownloadsViewModel", "Failed to copy init segment $oldFileUri: ${e.message}")
                                }
                            }

                            oldPlaylist.segments.forEach { track ->
                                val oldFileUri = track.uri
                                val oldFileName = oldFileUri.substringAfterLast("%2F").substringAfterLast("/")
                                runCatching {
                                    applicationContext.contentResolver.openInputStream(oldFileUri.toUri())?.use { inputStream ->
                                        inputStream.copyTo(outputStream)
                                    }
                                }.onFailure { e ->
                                    Log.w("DownloadsViewModel", "Skipping missing segment $oldFileUri: ${e.message}")
                                }

                                if (tracksToDelete.contains(oldFileName)) {
                                    runCatching {
                                        DocumentsContract.deleteDocument(applicationContext.contentResolver, oldFileUri.toUri())
                                    }
                                }
                                repository.updateVideo(video.apply {
                                    progress += 1
                                })
                            }
                        }

                        repository.updateVideo(video.apply {
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
                                    repository.updateVideo(video.apply { status = OfflineVideo.STATUS_PENDING })
                                    return@launch
                                }

                                val extension = oldPlaylist.segments.firstOrNull()?.uri?.substringAfterLast(".")?.substringBefore("?")?.takeIf { it.isNotBlank() } ?: "mp4"
                                val videoFileName = DownloadStorage.singleFileNameFor(video, extension)
                                // Keep converted file inside the same per-VOD container.
                                val newVideoFile = File(oldVideoDirectory, videoFileName)
                                val newVideoFileUri = newVideoFile.absolutePath

                                val tracksToDelete = mutableListOf<String>()
                                oldPlaylist.segments.forEach { tracksToDelete.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                                val playlists = oldVideoDirectory.listFiles { it.extension == "m3u8" && it != oldPlaylistFile }
                                playlists?.forEach { file ->
                                    runCatching {
                                        val p = PlaylistUtils.parseMediaPlaylist(file.inputStream())
                                        p.segments.forEach { tracksToDelete.remove(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                                    }
                                }

                                repository.updateVideo(video.apply {
                                    maxProgress = tracksToDelete.count()
                                })

                                FileOutputStream(newVideoFile).use { outputStream ->
                                    if (oldPlaylist.initSegmentUri != null) {
                                        val oldFile = File(oldVideoDirectory, oldPlaylist.initSegmentUri.substringAfterLast("%2F").substringAfterLast("/"))
                                        if (oldFile.exists()) {
                                            runCatching {
                                                oldFile.inputStream().use { inputStream ->
                                                    inputStream.copyTo(outputStream)
                                                }
                                            }
                                        }
                                    }

                                    oldPlaylist.segments.forEach { track ->
                                        val oldFile = File(oldVideoDirectory, track.uri.substringAfterLast("%2F").substringAfterLast("/"))
                                        if (oldFile.exists()) {
                                            runCatching {
                                                oldFile.inputStream().use { inputStream ->
                                                    inputStream.copyTo(outputStream)
                                                }
                                            }
                                            if (tracksToDelete.contains(oldFile.name)) {
                                                oldFile.delete()
                                            }
                                        }
                                        repository.updateVideo(video.apply {
                                            progress += 1
                                        })
                                    }
                                }

                                repository.updateVideo(video.apply {
                                    thumbnail.let {
                                        if (it == null || it == url || !File(it).exists()) {
                                            thumbnail = newVideoFileUri
                                        }
                                    }
                                    url = newVideoFileUri
                                })

                                if (playlists?.isNotEmpty() == true) {
                                    oldPlaylistFile.delete()
                                } else {
                                    // Converted file is inside oldVideoDirectory now — keep folder,
                                    // delete only the playlist file (segments already pruned above).
                                    oldPlaylistFile.delete()
                                }
                                succeeded = true
                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.e("DownloadsViewModel", "convertToFile failed for video ${video.id}", e)
                    DiagnosticLogger.e("DownloadsViewModel", "convertToFile failed: ${e.message}")
                } finally {
                    videosInUse.remove(video)
                    repository.updateVideo(video.apply {
                        status = if (succeeded) OfflineVideo.STATUS_DOWNLOADED else OfflineVideo.STATUS_PENDING
                    })
                }
            }
        }
    }

    fun moveToSharedStorage(newUri: Uri, video: OfflineVideo) {
        val videoUrl = video.url
        if (!videosInUse.contains(video) && videoUrl != null) {
            videosInUse.add(video)
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    repository.updateVideo(video.apply {
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
                                applicationContext.contentResolver.openOutputStream(playlistDocUri, "wt")?.use {
                                    PlaylistUtils.writeMediaPlaylist(oldPlaylist.copy(
                                        initSegmentUri = newInitUri,
                                        segments = segments
                                    ), it)
                                }
                                val tracksToDelete = mutableListOf<String>()
                                oldPlaylist.segments.forEach { tracksToDelete.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                                val playlists = oldVideoDirectory.listFiles { it.extension == "m3u8" && it != oldPlaylistFile }
                                playlists?.forEach { file ->
                                    runCatching {
                                        val p = PlaylistUtils.parseMediaPlaylist(file.inputStream())
                                        p.segments.forEach { tracksToDelete.remove(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                                    }
                                }
                                if (oldPlaylist.initSegmentUri != null && newInitUri != null) {
                                    val oldFile = File(oldVideoDirectory, oldPlaylist.initSegmentUri.substringAfterLast("%2F").substringAfterLast("/"))
                                    if (oldFile.exists()) {
                                        runCatching {
                                            applicationContext.contentResolver.openOutputStream(newInitUri.toUri(), "wt")?.use { outputStream ->
                                                oldFile.inputStream().use { inputStream ->
                                                    inputStream.copyTo(outputStream)
                                                }
                                            }
                                        }
                                    }
                                }
                                repository.updateVideo(video.apply {
                                    maxProgress = tracksToDelete.count()
                                })
                                oldPlaylist.segments.forEachIndexed { index, track ->
                                    val segDocUri = segments.getOrNull(index)?.uri?.toUri()
                                    val oldFile = File(oldVideoDirectory, track.uri.substringAfterLast("%2F").substringAfterLast("/"))
                                    if (oldFile.exists() && segDocUri != null) {
                                        runCatching {
                                            applicationContext.contentResolver.openOutputStream(segDocUri, "wt")?.use { outputStream ->
                                                oldFile.inputStream().use { inputStream ->
                                                    inputStream.copyTo(outputStream)
                                                }
                                            }
                                            if (tracksToDelete.contains(oldFile.name)) {
                                                oldFile.delete()
                                            }
                                        }
                                    }
                                    repository.updateVideo(video.apply {
                                        progress += 1
                                    })
                                }
                                val oldChatFile = video.chatUrl?.let { uri -> File(uri).takeIf { it.exists() } }
                                val newChatFileUri = oldChatFile?.let {
                                    SafStorageUtils.getOrCreateFileInDir(dirDoc, it.name, "application/json").toString()
                                }
                                if (oldChatFile != null && newChatFileUri != null) {
                                    runCatching {
                                        applicationContext.contentResolver.openOutputStream(newChatFileUri.toUri(), "wt")?.use { outputStream ->
                                            oldChatFile.inputStream().use { inputStream ->
                                                inputStream.copyTo(outputStream)
                                            }
                                        }
                                    }
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
                                repository.updateVideo(video.apply {
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
                                if (playlists?.isNotEmpty() == true) {
                                    oldPlaylistFile.delete()
                                } else {
                                    oldVideoDirectory.deleteRecursively()
                                }
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
                            applicationContext.contentResolver.openOutputStream(newFileUri, "wt")?.use { outputStream ->
                                oldFile.inputStream().use { inputStream ->
                                    inputStream.copyTo(outputStream)
                                }
                            }
                            val oldChatFile = video.chatUrl?.let { uri -> File(uri).takeIf { it.exists() } }
                            val newChatFileUri = oldChatFile?.let {
                                SafStorageUtils.getOrCreateFileInDir(dirDoc, it.name, "application/json").toString()
                            }
                            if (oldChatFile != null && newChatFileUri != null) {
                                runCatching {
                                    applicationContext.contentResolver.openOutputStream(newChatFileUri.toUri(), "wt")?.use { outputStream ->
                                        oldChatFile.inputStream().use { inputStream ->
                                            inputStream.copyTo(outputStream)
                                        }
                                    }
                                }
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
                            repository.updateVideo(video.apply {
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
                } catch (e: Exception) {
                    Log.e("DownloadsViewModel", "moveToSharedStorage failed for video ${video.id}", e)
                    DiagnosticLogger.e("DownloadsViewModel", "moveToSharedStorage failed: ${e.message}")
                } finally {
                    videosInUse.remove(video)
                    repository.updateVideo(video.apply {
                        status = OfflineVideo.STATUS_DOWNLOADED
                    })
                }
            }
        }
    }

    fun moveToAppStorage(path: String, video: OfflineVideo) {
        val videoUrl = video.url
        if (!videosInUse.contains(video) && videoUrl != null) {
            videosInUse.add(video)
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    repository.updateVideo(video.apply {
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
                            val tracksToDelete = mutableListOf<String>()
                            oldPlaylist.segments.forEach { tracksToDelete.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                            val playlists = repository.getPlaylists().mapNotNull { v ->
                                v.url?.takeIf {
                                    it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                            && it.substringBeforeLast("%2F") == oldVideoDirectoryUri
                                            && it != videoUrl
                                }
                            }
                            playlists.forEach { uri ->
                                runCatching {
                                    val p = applicationContext.contentResolver.openInputStream(uri.toUri())?.use {
                                        PlaylistUtils.parseMediaPlaylist(it)
                                    }
                                    p?.segments?.forEach { tracksToDelete.remove(Uri.decode(it.uri.substringAfterLast("%2F").substringAfterLast("/"))) }
                                }
                            }
                            if (oldPlaylist.initSegmentUri != null) {
                                val oldFileName = oldPlaylist.initSegmentUri.substringAfterLast("%2F").substringAfterLast("/")
                                val oldFileUri = "$oldVideoDirectoryUri%2F$oldFileName"
                                val newFileUri = newVideoDirectoryUri + File.separator + Uri.decode(oldFileName)
                                runCatching {
                                    FileOutputStream(newFileUri).use { outputStream ->
                                        applicationContext.contentResolver.openInputStream(oldFileUri.toUri())?.use { inputStream ->
                                            inputStream.copyTo(outputStream)
                                        }
                                    }
                                }
                            }
                            repository.updateVideo(video.apply {
                                maxProgress = tracksToDelete.count()
                            })
                            oldPlaylist.segments.forEach { track ->
                                val oldFileName = track.uri.substringAfterLast("%2F").substringAfterLast("/")
                                val oldFileUri = "$oldVideoDirectoryUri%2F$oldFileName"
                                val newFileUri = newVideoDirectoryUri + File.separator + Uri.decode(oldFileName)
                                runCatching {
                                    FileOutputStream(newFileUri).use { outputStream ->
                                        applicationContext.contentResolver.openInputStream(oldFileUri.toUri())?.use { inputStream ->
                                            inputStream.copyTo(outputStream)
                                        }
                                    }
                                    if (tracksToDelete.contains(Uri.decode(oldFileName))) {
                                        DocumentsContract.deleteDocument(applicationContext.contentResolver, oldFileUri.toUri())
                                    }
                                }
                                repository.updateVideo(video.apply {
                                    progress += 1
                                })
                            }
                            val oldChatUri = video.chatUrl
                            val oldChatFileName = oldChatUri?.substringAfterLast("%2F")?.substringAfterLast("/")?.substringAfterLast("%3A")?.let { Uri.decode(it) }
                            val newChatFileUri = oldChatFileName?.let { newVideoDirectoryUri + File.separator + it }
                            if (oldChatUri != null && newChatFileUri != null) {
                                runCatching {
                                    FileOutputStream(newChatFileUri).use { outputStream ->
                                        applicationContext.contentResolver.openInputStream(oldChatUri.toUri())?.use { inputStream ->
                                            inputStream.copyTo(outputStream)
                                        }
                                    }
                                }
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
                            repository.updateVideo(video.apply {
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
                            if (playlists.isNotEmpty()) {
                                runCatching {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, videoUrl.toUri())
                                }
                            } else {
                                runCatching {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, oldVideoDirectoryUri.toUri())
                                }
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
                        runCatching {
                            FileOutputStream(newFileUri).use { outputStream ->
                                applicationContext.contentResolver.openInputStream(videoUrl.toUri())?.use { inputStream ->
                                    inputStream.copyTo(outputStream)
                                }
                            }
                        }
                        val oldChatUri = video.chatUrl
                        val oldChatFileName = oldChatUri?.substringAfterLast("%2F")?.substringAfterLast("/")?.substringAfterLast("%3A")?.let { Uri.decode(it) }
                        val newChatFileUri = oldChatFileName?.let { newContainer.absolutePath + File.separator + it }
                        if (oldChatUri != null && newChatFileUri != null) {
                            runCatching {
                                FileOutputStream(newChatFileUri).use { outputStream ->
                                    applicationContext.contentResolver.openInputStream(oldChatUri.toUri())?.use { inputStream ->
                                        inputStream.copyTo(outputStream)
                                    }
                                }
                            }
                        }
                        runCatching {
                            val infoSource = "${videoUrl.substringBeforeLast("%2F")}%2F${DownloadStorage.INFO_FILE_NAME}"
                            applicationContext.contentResolver.openInputStream(infoSource.toUri())?.use { inputStream ->
                                FileOutputStream(newContainer.absolutePath + File.separator + DownloadStorage.INFO_FILE_NAME).use { outputStream ->
                                    inputStream.copyTo(outputStream)
                                }
                            }
                        }
                        repository.updateVideo(video.apply {
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
                        // Best-effort removal of the now-empty source container
                        // (provider rejects non-empty deletes, so shared videos are safe).
                        runCatching {
                            DocumentsContract.deleteDocument(
                                applicationContext.contentResolver,
                                videoUrl.substringBeforeLast("%2F").toUri()
                            )
                        }
                    }
                } catch (e: Exception) {
                    Log.e("DownloadsViewModel", "moveToAppStorage failed for video ${video.id}", e)
                    DiagnosticLogger.e("DownloadsViewModel", "moveToAppStorage failed: ${e.message}")
                } finally {
                    videosInUse.remove(video)
                    repository.updateVideo(video.apply {
                        status = OfflineVideo.STATUS_DOWNLOADED
                    })
                }
            }
        }
    }

    fun updateChatUrl(newUri: Uri, video: OfflineVideo) {
        if (!videosInUse.contains(video)) {
            viewModelScope.launch(Dispatchers.IO) {
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
                repository.updateVideo(video.apply {
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
        }
    }

    fun redownloadChat(video: OfflineVideo) {
        if (videosInUse.contains(video)) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateVideo(video.apply {
                chatProgress = 0
                chatBytes = 0
                chatOffsetSeconds = 0
                status = OfflineVideo.STATUS_PENDING
            })
        }
    }

    fun delete(video: OfflineVideo, keepFiles: Boolean) {
        val videoUrl = video.url
        if (!videosInUse.contains(video)) {
            videosInUse.add(video)
            externalScope.launch(Dispatchers.IO) {
                repository.updateVideo(video.apply {
                    progress = 0
                    maxProgress = 100
                    status = OfflineVideo.STATUS_DELETING
                })
                if (video.live) {
                    video.channelLogin?.let { WorkManager.getInstance(applicationContext).cancelUniqueWork(it) }
                } else {
                    WorkManager.getInstance(applicationContext).cancelAllWorkByTag(video.id.toString())
                }
                if (videoUrl != null && !keepFiles) {
                    if (videoUrl.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
                        if (videoUrl.endsWith(".m3u8")) {
                            val videoDirectoryUri = videoUrl.substringBeforeLast("%2F")
                            val playlist = try {
                                applicationContext.contentResolver.openInputStream(videoUrl.toUri())!!.use {
                                    PlaylistUtils.parseMediaPlaylist(it)
                                }
                            } catch (e: Exception) {
                                null
                            }
                            val tracksToDelete = playlist?.segments?.toMutableSet() ?: mutableSetOf()
                            val playlists = repository.getPlaylists().mapNotNull { video ->
                                video.url?.takeIf {
                                    it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                            && it.substringBeforeLast("%2F") == videoDirectoryUri
                                            && it != videoUrl
                                }
                            }
                            playlists.forEach { uri ->
                                try {
                                    val p = applicationContext.contentResolver.openInputStream(uri.toUri())!!.use {
                                        PlaylistUtils.parseMediaPlaylist(it)
                                    }
                                    tracksToDelete.removeAll(p.segments.toSet())
                                } catch (e: Exception) {

                                }
                            }
                            val tracks = tracksToDelete.toList()
                            repository.updateVideo(video.apply {
                                maxProgress = tracks.size
                            })
                            val deletedCount = AtomicInteger(0)
                            coroutineScope {
                                val deleteSemaphore = Semaphore(6)
                                tracks.forEach { track ->
                                    launch {
                                        deleteSemaphore.withPermit {
                                            try {
                                                DocumentsContract.deleteDocument(applicationContext.contentResolver, track.uri.toUri())
                                            } catch (_: Exception) {

                                            }
                                            val deleted = deletedCount.incrementAndGet()
                                            // Batched Room writes: one per ~50 segments instead of one per segment.
                                            if (deleted % 50 == 0 || deleted == tracks.size) {
                                                repository.updateVideo(video.apply {
                                                    progress = deleted
                                                })
                                            }
                                        }
                                    }
                                }
                            }
                            try {
                                DocumentsContract.deleteDocument(applicationContext.contentResolver, videoUrl.toUri())
                            } catch (e: Exception) {

                            }
                            if (playlists.isEmpty()) {
                                // Chat + sidecar first: either one pins the
                                // directory and the folder survives.
                                video.chatUrl?.let {
                                    runCatching {
                                        DocumentsContract.deleteDocument(applicationContext.contentResolver, it.toUri())
                                    }
                                }
                                runCatching {
                                    DocumentsContract.deleteDocument(
                                        applicationContext.contentResolver,
                                        "$videoDirectoryUri%2F${DownloadStorage.INFO_FILE_NAME}".toUri()
                                    )
                                }
                                try {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, videoDirectoryUri.toUri())
                                } catch (e: Exception) {

                                }
                            }
                        } else {
                            try {
                                DocumentsContract.deleteDocument(applicationContext.contentResolver, videoUrl.toUri())
                            } catch (e: Exception) {

                            }
                            video.chatUrl?.let {
                                runCatching {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, it.toUri())
                                }
                            }
                            // Sidecar + container: single files own their container
                            // (no shared segments), so remove both when done. The
                            // directory delete is a no-op when siblings remain.
                            // Chat goes first — otherwise it pins the folder.
                            val containerUri = DownloadStorage.containerOfUrl(videoUrl, video.downloadPath)
                            if (containerUri != null && containerUri != videoUrl) {
                                runCatching {
                                    DocumentsContract.deleteDocument(
                                        applicationContext.contentResolver,
                                        "$containerUri%2F${DownloadStorage.INFO_FILE_NAME}".toUri()
                                    )
                                }
                                runCatching {
                                    DocumentsContract.deleteDocument(applicationContext.contentResolver, containerUri.toUri())
                                }
                            }
                        }
                        video.chatUrl?.let {
                            try {
                                DocumentsContract.deleteDocument(applicationContext.contentResolver, it.toUri())
                            } catch (e: Exception) {

                            }
                        }
                    } else {
                        val playlistFile = File(videoUrl)
                        if (!playlistFile.exists()) {
                            return@launch
                        }
                        if (videoUrl.endsWith(".m3u8")) {
                            val directory = playlistFile.parentFile
                            if (directory != null) {
                                val playlists = directory.listFiles { it.extension == "m3u8" && it != playlistFile }
                                if (playlists != null) {
                                    val playlist = PlaylistUtils.parseMediaPlaylist(playlistFile.inputStream())
                                    val tracksToDelete = playlist.segments.toMutableSet()
                                    playlists.forEach {
                                        val p = PlaylistUtils.parseMediaPlaylist(it.inputStream())
                                        tracksToDelete.removeAll(p.segments.toSet())
                                    }
                                    val tracks = tracksToDelete.toList()
                                    repository.updateVideo(video.apply {
                                        maxProgress = tracks.size
                                    })
                                    tracks.forEachIndexed { index, track ->
                                        File(track.uri).delete()
                                        if ((index + 1) % 50 == 0 || index + 1 == tracks.size) {
                                            repository.updateVideo(video.apply {
                                                progress = index + 1
                                            })
                                        }
                                    }
                                    playlistFile.delete()
                                    if (playlists.isEmpty()) {
                                        directory.deleteRecursively()
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
            }.invokeOnCompletion {
                videosInUse.remove(video)
                externalScope.launch(Dispatchers.IO) {
                    repository.deleteVideo(video, keepFiles)
                }
            }
        }
    }
}