package com.xtrakick.app.ui.saved.bookmarks

import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.Bookmark
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.model.ui.VodBookmarkIgnoredUser
import com.xtrakick.app.repository.BookmarksRepository
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.repository.SortChannelRepository
import com.xtrakick.app.repository.VodBookmarkIgnoredUsersRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class BookmarksViewModel @Inject internal constructor(
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val bookmarksRepository: BookmarksRepository,
    private val sortChannelRepository: SortChannelRepository,
    playerRepository: PlayerRepository,
    private val vodBookmarkIgnoredUsersRepository: VodBookmarkIgnoredUsersRepository,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)

    val positions = playerRepository.loadVideoPositions()
    val ignoredUsers = vodBookmarkIgnoredUsersRepository.loadUsersFlow()
    private var updatedUsers = false
    private var updatedVideos = false

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
                bookmarks.mapNotNull { bookmark ->
                    bookmark.userId?.takeIf { ignored.find { it.userId == bookmark.userId } == null }
                }.chunked(100).forEach { ids ->
                    if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                        try {
                            val users = kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = ids,
                            ).data
                            users.forEach { user ->
                                user.channelId?.let { id ->
                                    bookmarks.filter { it.userId == id }
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

    fun updateVideo(filesDir: String, videoId: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            if (!videoId.isNullOrBlank()) {
                val video = if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                    try {
                        kickPublicApiRepository.getVideos(
                            networkLibrary = networkLibrary,
                            headers = kickPublicApiHeaders,
                            ids = listOf(videoId),
                        ).data.firstOrNull()?.let {
                            Video(
                                id = it.id,
                                channelId = it.channelId,
                                channelLogin = it.channelLogin,
                                channelName = it.channelName,
                                title = it.title,
                                viewCount = it.viewCount,
                                uploadDate = it.uploadDate,
                                duration = it.duration,
                                thumbnailUrl = it.thumbnailUrl,
                            )
                        }
                    } catch (e: Exception) {
                        null
                    }
                } else null
                val bookmark = bookmarksRepository.getBookmarkByVideoId(videoId)
                if (video != null && bookmark != null) {
                    val downloadedThumbnail = video.id.takeIf { !it.isNullOrBlank() }?.let { id ->
                        video.thumbnail.takeIf { !it.isNullOrBlank() }?.let {
                            File(filesDir, "thumbnails").mkdir()
                            val path = filesDir + File.separator + "thumbnails" + File.separator + id
                            viewModelScope.launch(Dispatchers.IO) {
                                try {
                                    when {
                                        networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                            val response = suspendCoroutine { continuation ->
                                                httpEngine.get().newUrlRequestBuilder(it, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                            }
                                            if (response.first.httpStatusCode in 200..299) {
                                                FileOutputStream(path).use {
                                                    it.write(response.second)
                                                }
                                            }
                                        }
                                        networkLibrary == "Cronet" && cronetEngine != null -> {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                                val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                                cronetEngine.get().newUrlRequestBuilder(it, request.callback, cronetExecutor).build().start()
                                                val response = request.future.get()
                                                if (response.urlResponseInfo.httpStatusCode in 200..299) {
                                                    FileOutputStream(path).use {
                                                        it.write(response.responseBody as ByteArray)
                                                    }
                                                }
                                            } else {
                                                val response = suspendCoroutine { continuation ->
                                                    cronetEngine.get().newUrlRequestBuilder(it, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                                }
                                                if (response.first.httpStatusCode in 200..299) {
                                                    FileOutputStream(path).use {
                                                        it.write(response.second)
                                                    }
                                                }
                                            }
                                        }
                                        else -> {
                                            okHttpClient.newCall(Request.Builder().url(it).build()).execute().use { response ->
                                                if (response.isSuccessful) {
                                                    FileOutputStream(path).use { outputStream ->
                                                        response.body.byteStream().use { inputStream ->
                                                            inputStream.copyTo(outputStream)
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (e: Exception) {

                                }
                            }
                            path
                        }
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
                            thumbnail = downloadedThumbnail,
                            type = video.type ?: bookmark.type,
                            duration = video.duration ?: bookmark.duration,
                            animatedPreviewURL = video.animatedPreviewURL ?: bookmark.animatedPreviewURL
                        )
                    )
                }
            }
        }
    }

    fun updateVideos(filesDir: String, networkLibrary: String?, kickPublicApiHeaders: Map<String, String>) {
        if (!updatedVideos) {
            viewModelScope.launch {
                val bookmarks = bookmarksRepository.loadBookmarks()
                bookmarks.mapNotNull { it.videoId }.chunked(100).forEach { ids ->
                    kickPublicApiRepository.getVideos(
                        networkLibrary = networkLibrary,
                        headers = kickPublicApiHeaders,
                        ids = ids,
                    ).data.map {
                        Video(
                            id = it.id,
                            channelId = it.channelId,
                            channelLogin = it.channelLogin,
                            channelName = it.channelName,
                            title = it.title,
                            viewCount = it.viewCount,
                            uploadDate = it.uploadDate,
                            duration = it.duration,
                            thumbnailUrl = it.thumbnailUrl,
                        )
                    }.forEach { video ->
                        video.id.takeIf { !it.isNullOrBlank() }?.let { id ->
                            bookmarks.find { it.videoId == id }
                        }?.let { bookmark ->
                            if (bookmark.userId != video.channelId ||
                                bookmark.userLogin != video.channelLogin ||
                                bookmark.userName != video.channelName ||
                                bookmark.title != video.title ||
                                bookmark.createdAt != video.uploadDate ||
                                bookmark.type != video.type ||
                                bookmark.duration != video.duration
                            ) {
                                val downloadedThumbnail = video.thumbnail.takeIf { !it.isNullOrBlank() }?.let {
                                    File(filesDir, "thumbnails").mkdir()
                                    val path = filesDir + File.separator + "thumbnails" + File.separator + video.id
                                    viewModelScope.launch(Dispatchers.IO) {
                                        try {
                                            when {
                                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                                    val response = suspendCoroutine { continuation ->
                                                        httpEngine.get().newUrlRequestBuilder(it, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                                    }
                                                    if (response.first.httpStatusCode in 200..299) {
                                                        FileOutputStream(path).use {
                                                            it.write(response.second)
                                                        }
                                                    }
                                                }
                                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                                        val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                                        cronetEngine.get().newUrlRequestBuilder(it, request.callback, cronetExecutor).build().start()
                                                        val response = request.future.get()
                                                        if (response.urlResponseInfo.httpStatusCode in 200..299) {
                                                            FileOutputStream(path).use {
                                                                it.write(response.responseBody as ByteArray)
                                                            }
                                                        }
                                                    } else {
                                                        val response = suspendCoroutine { continuation ->
                                                            cronetEngine.get().newUrlRequestBuilder(it, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                                        }
                                                        if (response.first.httpStatusCode in 200..299) {
                                                            FileOutputStream(path).use {
                                                                it.write(response.second)
                                                            }
                                                        }
                                                    }
                                                }
                                                else -> {
                                                    okHttpClient.newCall(Request.Builder().url(it).build()).execute().use { response ->
                                                        if (response.isSuccessful) {
                                                            FileOutputStream(path).use { outputStream ->
                                                                response.body.byteStream().use { inputStream ->
                                                                    inputStream.copyTo(outputStream)
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (e: Exception) {

                                        }
                                    }
                                    path
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
                                        gameId = bookmark.gameId,
                                        gameSlug = bookmark.gameSlug,
                                        gameName = bookmark.gameName,
                                        title = video.title ?: bookmark.title,
                                        createdAt = video.uploadDate ?: bookmark.createdAt,
                                        thumbnail = downloadedThumbnail,
                                        type = video.type ?: bookmark.type,
                                        duration = video.duration ?: bookmark.duration,
                                        animatedPreviewURL = video.animatedPreviewURL ?: bookmark.animatedPreviewURL
                                    )
                                )
                            }
                        }
                    }
                }
                updatedVideos = true
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