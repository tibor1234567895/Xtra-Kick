package com.xtrakick.app.ui.player

import android.net.Uri
import android.net.http.HttpEngine
import android.os.Build
import android.os.SystemClock
import android.os.ext.SdkExtensions
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.R
import com.xtrakick.app.model.NotificationUser
import com.xtrakick.app.model.ShownNotification
import com.xtrakick.app.model.VideoPosition
import com.xtrakick.app.model.ui.Bookmark
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.BookmarksRepository
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileOutputStream
import java.net.URI
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

private const val KICK_STREAM_REFRESH_RETRY_COOLDOWN_MS = 60_000L

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val shownNotificationsRepository: ShownNotificationsRepository,
    private val notificationUsersRepository: NotificationUsersRepository,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val playerRepository: PlayerRepository,
    private val bookmarksRepository: BookmarksRepository,
    private val offlineRepository: OfflineRepository,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)

    val streamResult = MutableStateFlow<String?>(null)
    val stream = MutableStateFlow<Stream?>(null)
    private var streamJob: Job? = null
    var useCustomProxy = false

    val videoResult = MutableStateFlow<String?>(null)
    val videoError = MutableStateFlow<Int?>(null)
    var backupQualities: List<String>? = null
    var playbackPosition: Long? = null
    val savedPosition = MutableStateFlow<Long?>(null)
    val isBookmarked = MutableStateFlow<Boolean?>(null)
    val gamesList = MutableStateFlow<List<Game>?>(null)
    var shouldRetry = true
    private var lastKickStreamRefreshRetryAtMs = 0L

    val clipUrls = MutableStateFlow<Map<Pair<String, String?>, String>?>(null)

    val savedOfflineVideoPosition = MutableStateFlow<Long?>(null)

    fun shouldRetryKickStreamWithFreshUrl(): Boolean {
        val now = SystemClock.elapsedRealtime()
        if (now - lastKickStreamRefreshRetryAtMs < KICK_STREAM_REFRESH_RETRY_COOLDOWN_MS) {
            return false
        }
        lastKickStreamRefreshRetryAtMs = now
        return true
    }

    var qualities: Map<String, Pair<String, String?>> = emptyMap()
    var quality: String? = null
    var previousQuality: String? = null
    var playlistUrl: Uri? = null
    var updateQualities = false
    var started = false
    var restoreQuality = false
    var resume = false
    val loaded = MutableStateFlow(false)
    private val _isFollowing = MutableStateFlow<Boolean?>(null)
    val isFollowing: StateFlow<Boolean?> = _isFollowing
    val follow = MutableStateFlow<Pair<Boolean, String?>?>(null)


    fun loadStreamResult(networkLibrary: String?, kickWebHeaders: Map<String, String>, channelLogin: String, randomDeviceId: Boolean?, xDeviceId: String?, playerType: String?, supportedCodecs: String?, proxyPlaybackAccessToken: Boolean, proxyHost: String?, proxyPort: Int?, proxyUser: String?, proxyPassword: String?, enableIntegrity: Boolean, forceRefresh: Boolean = false, stalePlaybackUrl: String? = null) {
        if (forceRefresh || streamResult.value == null) {
            viewModelScope.launch {
                try {
                    val playbackUrl = kickRepository.getPlaybackUrl(channelLogin, forceRefresh = forceRefresh)
                        ?.takeIf { it.isNotBlank() }
                        ?: throw Exception("Kick playback URL unavailable")
                    if (forceRefresh) {
                        // Successful URL resolution is routine recovery noise; keep failures as ERROR.
                        DiagnosticLogger.i(
                            "PlayerViewModel",
                            "Kick stream force refresh resolved channel=$channelLogin " +
                                "${summarizePlaybackUrl(playbackUrl)} expired=${summarizePlaybackUrl(stalePlaybackUrl)} sameAsExpired=${playbackUrl == stalePlaybackUrl}"
                        )
                    }
                    streamResult.value = playbackUrl
                } catch (e: Exception) {
                    if (forceRefresh) {
                        DiagnosticLogger.e(
                            "PlayerViewModel",
                            "Kick stream force refresh failed channel=$channelLogin message=${e.message}",
                            e
                        )
                    }
                    if (e.message == "failed integrity check" && integrity.value == null) {
                        integrity.value = "refreshStream"
                    }
                }
            }
        }
    }

    private fun summarizePlaybackUrl(url: String?): String {
        if (url.isNullOrBlank()) {
            return "url=missing"
        }
        return runCatching {
            val uri = Uri.parse(url)
            val query = uri.query
            "urlHost=${uri.host ?: "unknown"} urlPath=${uri.path ?: "unknown"} " +
                "queryPresent=${!query.isNullOrBlank()} queryHash=${query.shortHash()} urlHash=${url.shortHash()}"
        }.getOrDefault("url=unparseable")
    }

    private fun String?.shortHash(): String {
        return if (isNullOrBlank()) {
            "none"
        } else {
            Integer.toHexString(hashCode())
        }
    }

    fun loadStream(channelId: String?, channelLogin: String?, viewerCount: Int?, loop: Boolean, networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (loop) {
            streamJob?.cancel()
            streamJob = viewModelScope.launch {
                while (isActive) {
                    try {
                        updateStream(channelId, channelLogin, networkLibrary, kickPublicApiHeaders, kickWebHeaders, enableIntegrity)
                        delay(300000L)
                    } catch (e: Exception) {
                        if (e.message == "failed integrity check" && integrity.value == null) {
                            integrity.value = "stream"
                        }
                        delay(60000L)
                    }
                }
            }
        } else if (viewerCount == null) {
            viewModelScope.launch {
                try {
                    updateStream(channelId, channelLogin, networkLibrary, kickPublicApiHeaders, kickWebHeaders, enableIntegrity)
                } catch (e: Exception) {
                    if (e.message == "failed integrity check" && integrity.value == null) {
                        integrity.value = "stream"
                    }
                }
            }
        }
    }

    private suspend fun updateStream(channelId: String?, channelLogin: String?, networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        stream.value = channelLogin?.let { login ->
            kickRepository.getChannel(login).let { kickRepository.toStream(it) }
        }
    }

    fun loadVideo(
        networkLibrary: String?,
        kickWebHeaders: Map<String, String>,
        videoId: String?,
        videoSource: String?,
        channelId: String?,
        channelLogin: String?,
        playerType: String?,
        supportedCodecs: String?,
        enableIntegrity: Boolean
    ) {
        if (videoResult.value == null) {
            viewModelScope.launch {
                try {
                    if (videoSource.equals(AppConstants.KICK, true)) {
                        val kickUrl = videoId?.let { vid ->
                            runCatching { kickRepository.getVideoById(vid)?.url }.getOrNull()
                        } ?: channelLogin?.let { login ->
                            kickRepository.getChannelVideos(
                                channelSlug = login,
                                channelId = channelId,
                                limit = 30
                            ).firstOrNull { it.id == videoId }?.url
                        }
                        if (!kickUrl.isNullOrBlank()) {
                            videoResult.value = kickUrl
                            backupQualities = null
                        } else {
                            videoError.value = R.string.video_source_unavailable
                        }
                    } else {
                        videoError.value = R.string.video_source_unavailable
                    }
                } catch (e: Exception) {
                    if (e.message == "failed integrity check" && integrity.value == null) {
                        integrity.value = "refreshVideo"
                    }
                }
            }
        }
    }

    fun getVideoPosition(id: Long) {
        viewModelScope.launch {
            savedPosition.value = playerRepository.getVideoPosition(id)?.position ?: 0
        }
    }

    fun saveVideoPosition(id: Long, position: Long) {
        if (loaded.value) {
            viewModelScope.launch {
                playerRepository.saveVideoPosition(VideoPosition(id, position))
            }
        }
    }

    val resolutionChangeFlow = playerRepository.resolutionChangeFlow
    val qualityChangeFlow = playerRepository.qualityChangeFlow

    suspend fun savePosition(id: Long, position: Long) {
        playerRepository.saveVideoPosition(VideoPosition(id, position))
    }

    fun loadGamesList(videoId: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        // Kick VODs expose no chapter/game-moment API; the Chapters dialog stays empty.
        gamesList.value = emptyList()
    }

    fun checkBookmark(id: String) {
        viewModelScope.launch {
            isBookmarked.value = bookmarksRepository.getBookmarkByVideoId(id) != null
        }
    }

    fun saveBookmark(filesDir: String, networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, videoId: String?, title: String?, uploadDate: String?, duration: String?, type: String?, animatedPreviewUrl: String?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?) {
        viewModelScope.launch {
            val item = videoId?.let { bookmarksRepository.getBookmarkByVideoId(it) }
            if (item != null) {
                bookmarksRepository.deleteBookmark(item)
            } else {
                val downloadedThumbnail = videoId.takeIf { !it.isNullOrBlank() }?.let { id ->
                    thumbnail.takeIf { !it.isNullOrBlank() }?.let {
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
                val downloadedLogo = channelId.takeIf { !it.isNullOrBlank() }?.let { id ->
                    channelLogo.takeIf { !it.isNullOrBlank() }?.let {
                        File(filesDir, "profile_pics").mkdir()
                        val path = filesDir + File.separator + "profile_pics" + File.separator + id
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
                val userTypes = channelId?.let {
                    if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                        try {
                            kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = listOf(channelId)
                            ).data.firstOrNull()?.let {
                                User(
                                    channelId = it.channelId,
                                    channelLogin = it.channelLogin,
                                    channelName = it.channelName,
                                    type = it.type,
                                    broadcasterType = it.broadcasterType,
                                    profileImageUrl = it.profileImageUrl,
                                    createdAt = it.createdAt,
                                )
                            }
                        } catch (e: Exception) {
                            null
                        }
                    } else null
                }
                bookmarksRepository.saveBookmark(
                    Bookmark(
                        videoId = videoId,
                        userId = channelId,
                        userLogin = channelLogin,
                        userName = channelName,
                        userType = userTypes?.type,
                        userBroadcasterType = userTypes?.broadcasterType,
                        userLogo = downloadedLogo,
                        gameId = gameId,
                        gameSlug = gameSlug,
                        gameName = gameName,
                        title = title,
                        createdAt = uploadDate,
                        thumbnail = downloadedThumbnail,
                        type = type,
                        duration = duration,
                        animatedPreviewURL = animatedPreviewUrl
                    )
                )
            }
        }
    }

    fun loadClip(networkLibrary: String?, kickWebHeaders: Map<String, String>, id: String?, enableIntegrity: Boolean) {
        if (clipUrls.value == null) {
            viewModelScope.launch {
                try {
                    clipUrls.value = playerRepository.loadClipUrls(networkLibrary, kickWebHeaders, id, enableIntegrity) ?: emptyMap()
                } catch (e: Exception) {
                    if (e.message == "failed integrity check" && integrity.value == null) {
                        integrity.value = "refreshClip"
                    } else {
                        clipUrls.value = emptyMap()
                    }
                }
            }
        }
    }

    fun getOfflineVideoPosition(id: Int) {
        viewModelScope.launch {
            val video = offlineRepository.getVideoById(id)
            val position = video?.lastWatchPosition ?: 0
            // start from the beginning when the saved position is at (or past) the end
            val duration = video?.duration
            savedOfflineVideoPosition.value = if (duration != null && duration > 0 && position >= duration) 0 else position
        }
    }

    fun saveOfflineVideoPosition(id: Int, position: Long) {
        if (loaded.value) {
            viewModelScope.launch {
                offlineRepository.updateVideoPosition(id, position)
            }
        }
    }

    fun isFollowingChannel(userId: String?, channelId: String?, channelLogin: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        if (_isFollowing.value == null) {
            viewModelScope.launch {
                try {
                    if (!(channelId ?: channelLogin).isNullOrBlank()) {
                        _isFollowing.value = localFollowsChannel.getFollow(channelId, channelLogin) != null
                    }
                } catch (e: Exception) {

                }
            }
        }
    }

    fun saveFollowChannel(userId: String?, channelId: String?, channelLogin: String?, channelName: String?, setting: Int, notificationsEnabled: Boolean, startedAt: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            try {
                val followId = (channelId ?: channelLogin)?.trim()?.takeIf { it.isNotBlank() }
                if (followId != null) {
                    localFollowsChannel.saveFollow(LocalFollowChannel(followId, channelLogin, channelName))
                    _isFollowing.value = true
                    follow.value = Pair(true, null)
                    notificationUsersRepository.saveUser(NotificationUser(followId))
                    if (notificationsEnabled) {
                        startedAt.takeUnless { it.isNullOrBlank() }?.let { KickApiHelper.parseIso8601DateUTC(it) }?.let { started ->
                            shownNotificationsRepository.saveList(listOf(ShownNotification(followId, started)))
                        }
                    }
                }
            } catch (e: Exception) {

            }
        }
    }

    fun deleteFollowChannel(userId: String?, channelId: String?, channelLogin: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            try {
                val followId = (channelId ?: channelLogin)?.trim()?.takeIf { it.isNotBlank() }
                if (followId != null) {
                    localFollowsChannel.getFollow(channelId, channelLogin)?.let { localFollowsChannel.deleteFollow(it) }
                    _isFollowing.value = false
                    follow.value = Pair(false, null)
                    notificationUsersRepository.deleteUser(NotificationUser(followId))
                }
            } catch (e: Exception) {

            }
        }
    }
}
