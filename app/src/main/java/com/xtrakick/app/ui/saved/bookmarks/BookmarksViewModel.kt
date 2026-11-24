package com.xtrakick.app.ui.saved.bookmarks

import android.graphics.BitmapFactory
import android.net.http.HttpEngine
import com.xtrakick.app.util.NetworkUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.Bookmark
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.model.ui.VodBookmarkIgnoredUser
import com.xtrakick.app.repository.BookmarksRepository
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.repository.SortChannelRepository
import com.xtrakick.app.repository.VodBookmarkIgnoredUsersRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import org.chromium.net.CronetEngine
import java.io.File
import java.io.IOException
import java.util.concurrent.ExecutorService
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject internal constructor(
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val bookmarksRepository: BookmarksRepository,
    private val sortChannelRepository: SortChannelRepository,
    playerRepository: PlayerRepository,
    private val vodBookmarkIgnoredUsersRepository: VodBookmarkIgnoredUsersRepository,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
) : ViewModel() {

    val positions = playerRepository.loadVideoPositions()
    val ignoredUsers = vodBookmarkIgnoredUsersRepository.loadUsersFlow()
    private var updatedUsers = false
    private val refreshMutex = Mutex()

    val filter = MutableStateFlow<Filter?>(null)
    val sortText = MutableStateFlow<CharSequence?>(null)

    val sort: String
        get() = filter.value?.sort ?: BookmarksSortDialog.SORT_SAVED_AT
    val order: String
        get() = filter.value?.order ?: BookmarksSortDialog.ORDER_DESC

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest { filter ->
        bookmarksRepository.loadBookmarksFlow()
    }

    fun delete(bookmark: Bookmark) {
        viewModelScope.launch {
            bookmarksRepository.deleteBookmark(bookmark)
        }
    }

    fun vodIgnoreUser(userId: String) {
        viewModelScope.launch {
            if (vodBookmarkIgnoredUsersRepository.getUserById(userId) != null) {
                vodBookmarkIgnoredUsersRepository.deleteUser(VodBookmarkIgnoredUser(userId))
            } else {
                vodBookmarkIgnoredUsersRepository.saveUser(VodBookmarkIgnoredUser(userId))
            }
        }
    }

    fun updateUsers(networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (!updatedUsers) {
            viewModelScope.launch {
                val bookmarks = bookmarksRepository.loadBookmarks()
                val ignored = vodBookmarkIgnoredUsersRepository.loadUsers()
                val ignoredUserIds = ignored.mapTo(HashSet(ignored.size)) { it.userId }
                val bookmarksByUserId = bookmarks.groupBy { it.userId }
                bookmarks.mapNotNull { bookmark ->
                    bookmark.userId?.takeUnless(ignoredUserIds::contains)
                }.chunked(100).forEach { ids ->
                    if (kickPublicApiHeaders.isNotEmpty()) {
                        try {
                            val users = kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = ids,
                            ).data
                            users.forEach { user ->
                                user.channelId?.let { id ->
                                    bookmarksByUserId[id]
                                }?.forEach { bookmark ->
                                    if (user.type != bookmark.userType || user.broadcasterType != bookmark.userBroadcasterType) {
                                        bookmarksRepository.updateBookmark(bookmark.apply {
                                            userType = user.type
                                            userBroadcasterType = user.broadcasterType
                                        })
                                    }
                                }
                            }
                        } catch (e: Exception) {
                        }
                    }
                }
                updatedUsers = true
            }
        }
    }

    private suspend fun downloadThumbnail(
        directory: File,
        bookmarkId: Int,
        thumbUrl: String?,
        networkLibrary: String?,
    ): String? = withContext(Dispatchers.IO) {
        val url = thumbUrl?.takeIf { it.isNotBlank() } ?: return@withContext null
        try {
            val (status, bytes) = NetworkUtils.fetchBytesRaw(
                httpEngine = httpEngine,
                cronetEngine = cronetEngine,
                executor = cronetExecutor,
                okHttp = okHttpClient,
                networkLibrary = networkLibrary,
                url = url,
            )
            writeBookmarkThumbnail(directory, bookmarkId, status, bytes)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            null
        }
    }

    fun updateVideo(filesDir: String, videoId: String?, networkLibrary: String?) {
        if (videoId.isNullOrBlank()) return
        viewModelScope.launch {
            refreshMutex.withLock {
                val initial = bookmarksRepository.getBookmarkByVideoId(videoId) ?: return@withLock
                val video = try {
                    kickRepository.getVideoById(videoId, initial.userLogin)
                } catch (e: Exception) {
                    if (e is CancellationException) throw e
                    null
                } ?: return@withLock
                val directory = File(filesDir, "thumbnails")
                val downloadedThumbnail = downloadThumbnail(directory, initial.id, video.thumbnail, networkLibrary)
                val bookmark = bookmarksRepository.getBookmarkByVideoId(videoId)
                if (bookmark?.id != initial.id) {
                    downloadedThumbnail?.let { withContext(Dispatchers.IO) { File(it).delete() } }
                    return@withLock
                }
                bookmarksRepository.updateBookmark(
                    Bookmark(
                        videoId = bookmark.videoId,
                        userId = video.channelId ?: bookmark.userId,
                        userLogin = video.channelLogin ?: bookmark.userLogin,
                        userName = video.channelName ?: bookmark.userName,
                        userType = bookmark.userType,
                        userBroadcasterType = bookmark.userBroadcasterType,
                        userLogo = bookmark.userLogo,
                        gameId = video.gameId ?: bookmark.gameId,
                        gameSlug = video.gameSlug ?: bookmark.gameSlug,
                        gameName = video.gameName ?: bookmark.gameName,
                        title = video.title ?: bookmark.title,
                        createdAt = video.uploadDate ?: bookmark.createdAt,
                        thumbnail = downloadedThumbnail ?: bookmark.thumbnail,
                        type = video.type ?: bookmark.type,
                        duration = video.duration ?: bookmark.duration,
                        animatedPreviewURL = video.animatedPreviewURL ?: bookmark.animatedPreviewURL
                    ).apply { id = bookmark.id }
                )
                if (downloadedThumbnail != null) {
                    val previous = bookmark.thumbnail?.let(::File)
                    if (previous?.parentFile == directory && previous.name.startsWith("bookmark-${bookmark.id}-")) {
                        withContext(Dispatchers.IO) { previous.delete() }
                    }
                }
            }
        }
    }

    suspend fun getSortChannel(id: String): SortChannel? {
        return sortChannelRepository.getById(id)
    }

    suspend fun saveSortChannel(item: SortChannel) {
        sortChannelRepository.save(item)
    }

    fun setFilter(sort: String?, order: String?) {
        filter.value = Filter(sort, order)
    }

    class Filter(
        val sort: String?,
        val order: String?,
    )
}

internal fun writeBookmarkThumbnail(directory: File, bookmarkId: Int, status: Int, bytes: ByteArray): String? {
    if (status !in 200..299 || bytes.isEmpty()) return null
    val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
    BitmapFactory.decodeByteArray(bytes, 0, bytes.size, bounds)
    if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return null
    directory.mkdirs()
    val target = File.createTempFile("bookmark-$bookmarkId-", ".image", directory)
    return try {
        target.writeBytes(bytes)
        target.path
    } catch (_: IOException) {
        target.delete()
        null
    }
}
