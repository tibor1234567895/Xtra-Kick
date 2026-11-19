package com.xtrakick.app.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xtrakick.app.model.ui.OfflineVideo

@Dao
interface VideosDao {

    @Query("SELECT * FROM videos ORDER BY id DESC")
    fun getAll(): PagingSource<Int, OfflineVideo>

    @Query("SELECT * FROM videos")
    fun getAllVideos(): List<OfflineVideo>

    @Query("SELECT * FROM videos WHERE id = :id")
    fun getById(id: Int): OfflineVideo?

    @Query("SELECT * FROM videos WHERE url = :url")
    fun getByUrl(url: String): OfflineVideo?

    @Query("SELECT * FROM videos WHERE channel_login = :login AND live = 1 AND status != ${OfflineVideo.STATUS_DOWNLOADED}")
    fun getLiveDownload(login: String): OfflineVideo?

    @Query("SELECT * FROM videos WHERE videoId = :id")
    fun getByVideoId(id: String): List<OfflineVideo>

    @Query("SELECT * FROM videos WHERE channel_id = :id")
    fun getByUserId(id: String): List<OfflineVideo>

    @Query("SELECT DISTINCT channel_id FROM videos WHERE channel_id IS NOT NULL")
    fun getAllChannelIds(): List<String>

    @Query("SELECT * FROM videos WHERE lower(url) LIKE '%.m3u8'")
    fun getPlaylists(): List<OfflineVideo>

    @Query("SELECT * FROM videos WHERE status = ${OfflineVideo.STATUS_DELETING}")
    fun getDeletingVideos(): List<OfflineVideo>

    @Insert
    fun insert(video: OfflineVideo): Long

    @Delete
    fun delete(video: OfflineVideo)

    @Update
    fun update(video: OfflineVideo)

    @Query("UPDATE videos SET last_watch_position = :position WHERE id = :id")
    fun updatePosition(id: Int, position: Long)

    @Query("UPDATE videos SET last_watch_position = null")
    fun deletePositions()

    @Query("UPDATE videos SET status = :status WHERE id = :id")
    fun updateStatus(id: Int, status: Int)

    @Query("UPDATE videos SET max_progress = :maxProgress, progress = :progress, status = :status WHERE id = :id")
    fun updateOperationProgress(id: Int, maxProgress: Int, progress: Int, status: Int)

    @Query("UPDATE videos SET max_progress = :maxProgress WHERE id = :id")
    fun updateMaximumProgress(id: Int, maxProgress: Int)

    @Query("UPDATE videos SET progress = :progress WHERE id = :id")
    fun updateProgress(id: Int, progress: Int)

    @Query("UPDATE videos SET thumbnail = :thumbnail, url = :url WHERE id = :id")
    fun updateConvertedFiles(id: Int, thumbnail: String?, url: String?)

    @Query("UPDATE videos SET chatUrl = :chatUrl, downloadPath = :downloadPath, thumbnail = :thumbnail, url = :url WHERE id = :id")
    fun updateStorageLocation(id: Int, chatUrl: String?, downloadPath: String?, thumbnail: String?, url: String?)

    @Query("UPDATE videos SET channel_id = :channelId, channel_login = :channelLogin, channel_name = :channelName, chatUrl = :chatUrl, gameId = :gameId, gameName = :gameName, gameSlug = :gameSlug, name = :name, upload_date = :uploadDate, videoId = :videoId WHERE id = :id")
    fun updateImportedChatMetadata(id: Int, channelId: String?, channelLogin: String?, channelName: String?, chatUrl: String?, gameId: String?, gameName: String?, gameSlug: String?, name: String?, uploadDate: Long?, videoId: String?)

    @Query("UPDATE videos SET chatBytes = :chatBytes, chatOffsetSeconds = :chatOffsetSeconds, chatProgress = :chatProgress, status = :status WHERE id = :id")
    fun resetChatProgress(id: Int, chatBytes: Long, chatOffsetSeconds: Int, chatProgress: Int, status: Int)

    @Query("UPDATE videos SET duration = :duration, source_start_position = :sourceStartPosition WHERE id = :id")
    fun updateSourceRange(id: Int, duration: Long?, sourceStartPosition: Long?)

    @Query("UPDATE videos SET bytes = :bytes, duration = :duration, max_progress = :maxProgress, source_start_position = :sourceStartPosition, url = :url WHERE id = :id")
    fun updateVideoPlaylist(id: Int, bytes: Long, duration: Long?, maxProgress: Int, sourceStartPosition: Long?, url: String?)

    @Query("UPDATE videos SET bytes = :bytes, progress = :progress WHERE id = :id")
    fun updateVideoProgress(id: Int, bytes: Long, progress: Int)

    @Query("UPDATE videos SET duration = :duration, max_progress = :maxProgress, source_start_position = :sourceStartPosition, url = :url WHERE id = :id")
    fun updateVideoRange(id: Int, duration: Long?, maxProgress: Int, sourceStartPosition: Long?, url: String?)

    @Query("UPDATE videos SET url = :url WHERE id = :id")
    fun updateUrl(id: Int, url: String?)

    @Query("UPDATE videos SET chatProgress = :chatProgress WHERE id = :id")
    fun updateChatProgress(id: Int, chatProgress: Int)

    @Query("UPDATE videos SET chatUrl = :chatUrl, maxChatProgress = :maxChatProgress WHERE id = :id")
    fun updateChatLocation(id: Int, chatUrl: String?, maxChatProgress: Int)

    @Query("UPDATE videos SET chatBytes = :chatBytes, chatProgress = :chatProgress WHERE id = :id")
    fun updateChatDownloadProgress(id: Int, chatBytes: Long, chatProgress: Int)

    @Query("UPDATE videos SET bytes = :bytes, url = :url WHERE id = :id")
    fun updateRecordingFile(id: Int, bytes: Long, url: String?)

    @Query("UPDATE videos SET gameId = :gameId, gameName = :gameName, gameSlug = :gameSlug, name = :name, thumbnail = :thumbnail, upload_date = :uploadDate WHERE id = :id")
    fun updateStreamMetadata(id: Int, gameId: String?, gameName: String?, gameSlug: String?, name: String?, thumbnail: String?, uploadDate: Long?)

    @Query("UPDATE videos SET bytes = :bytes, chatBytes = :chatBytes, lastSegmentUrl = :lastSegmentUrl WHERE id = :id")
    fun updateRecordingProgress(id: Int, bytes: Long, chatBytes: Long, lastSegmentUrl: String?)

    @Query("UPDATE videos SET chatUrl = :chatUrl WHERE id = :id")
    fun updateChatUrl(id: Int, chatUrl: String?)

    @Query("UPDATE videos SET channel_login = :channelLogin, channel_logo = :channelLogo, channel_name = :channelName WHERE id = :id")
    fun updateChannelMetadata(id: Int, channelLogin: String?, channelLogo: String?, channelName: String?)
}
