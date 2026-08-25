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

    fun loadAllVideos() = videosDao.getAll()

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

    suspend fun updateVideo(video: OfflineVideo) = withContext(Dispatchers.IO) {
        videosDao.update(video)
    }

    suspend fun updateVideoPosition(id: Int, position: Long) = withContext(Dispatchers.IO) {
        videosDao.updatePosition(id, position)
    }

    suspend fun deletePositions() = withContext(Dispatchers.IO) {
        videosDao.deletePositions()
    }

    suspend fun deleteOldImages() = withContext(Dispatchers.IO) {
        localFollowsChannelDao.getAll().forEach { item ->
            item.channelLogo?.let {
                val userId = item.userId
                if (it.isNotBlank() && !userId.isNullOrBlank() && bookmarksDao.getByUserId(userId).isEmpty() && videosDao.getByUserId(userId).isEmpty()) {
                    File(it).delete()
                }
            }
        }
    }
}
