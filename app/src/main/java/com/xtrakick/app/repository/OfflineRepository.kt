package com.xtrakick.app.repository

import com.xtrakick.app.db.BookmarksDao
import com.xtrakick.app.db.LocalFollowsChannelDao
import com.xtrakick.app.db.VideosDao
import com.xtrakick.app.model.ui.OfflineVideo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfflineRepository @Inject constructor(
    private val videosDao: VideosDao,
    private val localFollowsChannelDao: LocalFollowsChannelDao,
    private val bookmarksDao: BookmarksDao,
) {

    private val fileCoordinator = DownloadFileCoordinator()

    private fun fileKey(video: OfflineVideo): String = "video:${video.id}"

    suspend fun <T> withVideoFiles(
        video: OfflineVideo, wait: Boolean = false, block: suspend (OfflineVideo) -> T,
    ): T? = withContext(Dispatchers.IO) {
        fileCoordinator.use(fileKey(video), deleting = false, wait = wait) {
            videosDao.getById(video.id)?.let { block(it) }
        }
    }

    suspend fun <T> withVideoDeletion(video: OfflineVideo, block: suspend (OfflineVideo) -> T): T? =
        withContext(Dispatchers.IO) {
            fileCoordinator.use(fileKey(video), deleting = true, wait = true) {
                videosDao.getById(video.id)?.let { block(it) }
            }
        }

    fun loadAllVideos() = videosDao.getAll()

    suspend fun getAllVideos(): List<OfflineVideo> = withContext(Dispatchers.IO) {
        videosDao.getAllVideos()
    }

    suspend fun getVideoById(id: Int) = withContext(Dispatchers.IO) {
        videosDao.getById(id)
    }

    suspend fun getVideoByUrl(url: String) = withContext(Dispatchers.IO) {
        videosDao.getByUrl(url)
    }

    suspend fun getLiveDownload(login: String) = withContext(Dispatchers.IO) {
        videosDao.getLiveDownload(login)
    }

    suspend fun getVideosByUserId(id: String) = withContext(Dispatchers.IO) {
        videosDao.getByUserId(id)
    }

    suspend fun getPlaylists() = withContext(Dispatchers.IO) {
        videosDao.getPlaylists()
    }

    suspend fun saveVideo(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.insert(video)
    }

    /**
     * @param keepFiles mirrors the "keep files" option in the delete dialog. It used to apply
     * only to the video and chat files while the thumbnail and channel logo were deleted
     * regardless — so a download removed with "keep files" left recoverable media but lost its
     * artwork, and anything restored from it came back blank.
     */
    suspend fun deleteVideo(video: OfflineVideo, keepFiles: Boolean = false) = withContext(Dispatchers.IO) {
        if (!keepFiles) {
            video.videoId?.let { id ->
                if (id.isNotBlank() && videosDao.getByVideoId(id).none { it.id != video.id } && bookmarksDao.getByVideoId(id) == null) {
                    video.thumbnail?.let {
                        if (it.isNotBlank()) {
                            File(it).delete()
                        }
                    }
                }
            }
            video.channelId?.let { id ->
                if (id.isNotBlank() && getVideosByUserId(id).none { it.id != video.id } && bookmarksDao.getByUserId(id).isEmpty()) {
                    video.channelLogo?.let {
                        if (it.isNotBlank()) {
                            File(it).delete()
                        }
                    }
                }
            }
        }
        videosDao.delete(video)
    }

    suspend fun updateStatus(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateStatus(video.id, video.status)
    }

    suspend fun updateOperationProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateOperationProgress(video.id, video.maxProgress, video.progress, video.status)
    }

    suspend fun updateMaximumProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateMaximumProgress(video.id, video.maxProgress)
    }

    suspend fun updateProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateProgress(video.id, video.progress)
    }

    suspend fun updateConvertedFiles(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateConvertedFiles(video.id, video.thumbnail, video.url)
    }

    suspend fun updateStorageLocation(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateStorageLocation(video.id, video.chatUrl, video.downloadPath, video.thumbnail, video.url)
    }

    suspend fun updateImportedChatMetadata(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateImportedChatMetadata(video.id, video.channelId, video.channelLogin, video.channelName, video.chatUrl, video.gameId, video.gameName, video.gameSlug, video.name, video.uploadDate, video.videoId)
    }

    suspend fun resetChatProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.resetChatProgress(video.id, video.chatBytes, video.chatOffsetSeconds, video.chatProgress, video.status)
    }

    suspend fun updateSourceRange(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateSourceRange(video.id, video.duration, video.sourceStartPosition)
    }

    suspend fun updateVideoPlaylist(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateVideoPlaylist(video.id, video.bytes, video.duration, video.maxProgress, video.sourceStartPosition, video.url)
    }

    suspend fun updateVideoProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateVideoProgress(video.id, video.bytes, video.progress)
    }

    suspend fun updateVideoRange(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateVideoRange(video.id, video.duration, video.maxProgress, video.sourceStartPosition, video.url)
    }

    suspend fun updateUrl(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateUrl(video.id, video.url)
    }

    suspend fun updateChatProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateChatProgress(video.id, video.chatProgress)
    }

    suspend fun updateChatLocation(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateChatLocation(video.id, video.chatUrl, video.maxChatProgress)
    }

    suspend fun updateChatDownloadProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateChatDownloadProgress(video.id, video.chatBytes, video.chatProgress)
    }

    suspend fun updateRecordingFile(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateRecordingFile(video.id, video.bytes, video.url)
    }

    suspend fun updateStreamMetadata(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateStreamMetadata(video.id, video.gameId, video.gameName, video.gameSlug, video.name, video.thumbnail, video.uploadDate)
    }

    suspend fun updateRecordingProgress(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateRecordingProgress(video.id, video.bytes, video.chatBytes, video.lastSegmentUrl)
    }

    suspend fun updateChatUrl(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateChatUrl(video.id, video.chatUrl)
    }

    suspend fun updateChannelMetadata(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.updateChannelMetadata(video.id, video.channelLogin, video.channelLogo, video.channelName)
    }

    suspend fun updateVideoPosition(id: Int, position: Long) = withContext(Dispatchers.IO) {
        videosDao.updatePosition(id, position)
    }

    suspend fun deletePositions() = withContext(Dispatchers.IO) {
        videosDao.deletePositions()
    }

    suspend fun deleteOldImages() = withContext(Dispatchers.IO) {
        val activeBookmarkUserIds = bookmarksDao.getAllUserIds().toHashSet()
        val activeVideoUserIds = videosDao.getAllChannelIds().toHashSet()
        localFollowsChannelDao.getAll().forEach { item ->
            val userId = item.userId
            if (!userId.isNullOrBlank() && userId !in activeBookmarkUserIds && userId !in activeVideoUserIds) {
                item.channelLogo?.takeIf { it.isNotBlank() }?.let { File(it).delete() }
            }
        }
    }
}
