package com.github.andreyasadchy.xtra.ui.player

import android.net.Uri
import android.net.http.HttpEngine
import android.os.Build
import android.os.SystemClock
import android.os.ext.SdkExtensions
import androidx.annotation.OptIn
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.HttpDataSource
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.model.NotificationUser
import com.github.andreyasadchy.xtra.model.ShownNotification
import com.github.andreyasadchy.xtra.model.VideoPosition
import com.github.andreyasadchy.xtra.model.ui.Bookmark
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.player.lowlatency.CronetDataSource
import com.github.andreyasadchy.xtra.player.lowlatency.HttpEngineDataSource
import com.github.andreyasadchy.xtra.player.lowlatency.OkHttpDataSource
import com.github.andreyasadchy.xtra.repository.BookmarksRepository
import com.github.andreyasadchy.xtra.repository.KickGraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickPublicApiRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.repository.NotificationUsersRepository
import com.github.andreyasadchy.xtra.repository.OfflineRepository
import com.github.andreyasadchy.xtra.repository.PlayerRepository
import com.github.andreyasadchy.xtra.repository.ShownNotificationsRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.DiagnosticLogger
import com.github.andreyasadchy.xtra.util.HttpEngineUtils
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.getByteArrayCronetCallback
import com.github.andreyasadchy.xtra.util.m3u8.PlaylistUtils
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.ProxySelector
import java.net.SocketAddress
import java.net.URI
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

private const val KICK_STREAM_REFRESH_RETRY_COOLDOWN_MS = 60_000L

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val kickGraphQLRepository: KickGraphQLRepository,
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

    suspend fun loadPlaylist(url: String, networkLibrary: String?, proxyMultivariantPlaylist: Boolean = false, proxyHost: String? = null, proxyPort: Int? = null, proxyUser: String? = null, proxyPassword: String? = null): Pair<String?, Int?>? = withContext(Dispatchers.IO) {
        try {
            val useProxy = !useCustomProxy && proxyMultivariantPlaylist && !proxyHost.isNullOrBlank() && proxyPort != null
            when {
                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null && !useProxy -> {
                    val response = suspendCoroutine { continuation ->
                        httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                    }
                    if (response.first.httpStatusCode in 200..299) {
                        String(response.second) to null
                    } else {
                        null to response.first.httpStatusCode
                    }
                }
                networkLibrary == "Cronet" && cronetEngine != null && !useProxy -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                        cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                        val response = request.future.get()
                        if (response.urlResponseInfo.httpStatusCode in 200..299) {
                            (response.responseBody as String) to null
                        } else {
                            null to response.urlResponseInfo.httpStatusCode
                        }
                    } else {
                        val response = suspendCoroutine { continuation ->
                            cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                        }
                        if (response.first.httpStatusCode in 200..299) {
                            String(response.second) to null
                        } else {
                            null to response.first.httpStatusCode
                        }
                    }
                }
                else -> {
                    okHttpClient.newBuilder().apply {
                        if (useProxy) {
                            proxy(Proxy(Proxy.Type.HTTP, InetSocketAddress(proxyHost, proxyPort)))
                            if (!proxyUser.isNullOrBlank() && !proxyPassword.isNullOrBlank()) {
                                proxyAuthenticator { _, response ->
                                    response.request.newBuilder().header("Proxy-Authorization", Credentials.basic(proxyUser, proxyPassword)).build()
                                }
                            }
                        }
                    }.build().newCall(Request.Builder().url(url).build()).execute().use { response ->
                        if (response.isSuccessful) {
                            response.body.string() to null
                        } else {
                            null to response.code
                        }
                    }
                }
            }
        } catch (e: Exception) {
            null
        }
    }

    fun loadStreamResult(networkLibrary: String?, kickWebHeaders: Map<String, String>, channelLogin: String, randomDeviceId: Boolean?, xDeviceId: String?, playerType: String?, supportedCodecs: String?, proxyPlaybackAccessToken: Boolean, proxyHost: String?, proxyPort: Int?, proxyUser: String?, proxyPassword: String?, enableIntegrity: Boolean, forceRefresh: Boolean = false, stalePlaybackUrl: String? = null) {
        if (forceRefresh || streamResult.value == null) {
            viewModelScope.launch {
                try {
                    val livestreamPlaybackUrl = kickRepository
                        .getChannelLivestream(channelLogin, forceRefresh = forceRefresh)
                        ?.playbackUrl
                        ?.takeIf { it.isNotBlank() }
                    val playbackUrl = if (forceRefresh && livestreamPlaybackUrl != null && livestreamPlaybackUrl == stalePlaybackUrl) {
                        kickRepository
                            .getChannel(channelLogin, forceRefresh = forceRefresh)
                            .let { kickRepository.getPlayableUrl(it) }
                            ?.takeIf { it.isNotBlank() && it != stalePlaybackUrl }
                            ?: livestreamPlaybackUrl
                    } else {
                        livestreamPlaybackUrl
                    } ?: kickRepository
                        .getChannel(channelLogin, forceRefresh = forceRefresh)
                        .let { kickRepository.getPlayableUrl(it) }
                        ?.takeIf { it.isNotBlank() }
                        ?: throw Exception("Kick playback URL unavailable")
                    if (forceRefresh) {
                        // Successful URL resolution is routine recovery noise; keep failures as ERROR.
                        DiagnosticLogger.i(
                            "PlayerViewModel",
                            "Kick stream force refresh resolved channel=$channelLogin source=${if (playbackUrl == livestreamPlaybackUrl) "livestream" else "channel"} " +
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
                    if (videoSource.equals(C.KICK, true)) {
                        val kickUrl = channelLogin?.let { login ->
                            kickRepository.getChannelVideos(
                                channelSlug = login,
                                channelId = channelId,
                                limit = 100
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
        if (gamesList.value == null) {
            viewModelScope.launch {
                try {
                    val response = kickGraphQLRepository.loadVideoGames(networkLibrary, kickWebHeaders, videoId)
                    if (enableIntegrity && integrity.value == null) {
                        response.errors?.find { it.message == "failed integrity check" }?.let {
                            integrity.value = "refreshVideo"
                            return@launch
                        }
                    }
                    gamesList.value = response.data!!.video.moments.edges.map { item ->
                        item.node.let {
                            Game(
                                gameId = it.details?.game?.id,
                                gameName = it.details?.game?.displayName,
                                boxArtUrl = it.details?.game?.boxArtURL,
                                vodPosition = it.positionMilliseconds,
                                vodDuration = it.durationMilliseconds,
                            )
                        }
                    }
                } catch (e: Exception) {

                }
            }
        }
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
                    try {
                        val response = kickGraphQLRepository.loadQueryUsersType(networkLibrary, kickWebHeaders, listOf(channelId))
                        response.data!!.users?.firstOrNull()?.let {
                            User(
                                channelId = it.id,
                                broadcasterType = when {
                                    it.roles?.isPartner == true -> "partner"
                                    it.roles?.isAffiliate == true -> "affiliate"
                                    else -> null
                                },
                                type = when {
                                    it.roles?.isStaff == true -> "staff"
                                    else -> null
                                }
                            )
                        }
                    } catch (e: Exception) {
                        if (!kickPublicApiHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
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
            savedOfflineVideoPosition.value = offlineRepository.getVideoById(id)?.lastWatchPosition ?: 0
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
                val followId = channelId ?: channelLogin
                if (!followId.isNullOrBlank()) {
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
                val followId = channelId ?: channelLogin
                if (!followId.isNullOrBlank()) {
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
