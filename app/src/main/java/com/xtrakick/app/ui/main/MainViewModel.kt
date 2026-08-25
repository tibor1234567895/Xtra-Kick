package com.xtrakick.app.ui.main

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInstaller
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.xtrakick.app.R
import com.xtrakick.app.model.VideoPosition
import com.xtrakick.app.model.kick.auth.KickBackendIntrospectRequest
import com.xtrakick.app.model.kick.auth.KickBackendRefreshRequest
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.KickAuthRequestException
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.ui.download.StreamDownloadWorker
import com.xtrakick.app.ui.download.VideoDownloadWorker
import com.xtrakick.app.ui.login.LoginActivity
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.KickOAuthConfig
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.getByteArrayCronetCallback
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileOutputStream
import java.util.Timer
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine
import kotlin.math.max

@HiltViewModel
class MainViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val playerRepository: PlayerRepository,
    private val offlineRepository: OfflineRepository,
    private val authRepository: AuthRepository,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) : ViewModel() {

    enum class KickValidationState {
        IDLE,
        RUNNING,
        COMPLETE,
    }

    private val kickAuthValidateTag = "KickAuthValidate"
    private var kickValidationJob: Job? = null

    private fun isNetworkDebugEnabled(): Boolean {
        return applicationContext.prefs().getBoolean(AppConstants.DEBUG_NETWORK_LOGS, false)
    }

    val integrity = MutableStateFlow<String?>(null)

    private val _kickValidationState = MutableStateFlow(
        if (KickApiHelper.checkedValidation) KickValidationState.COMPLETE else KickValidationState.IDLE
    )
    val kickValidationState: StateFlow<KickValidationState> = _kickValidationState.asStateFlow()

    val checkNetworkStatus = MutableStateFlow(false)
    val isNetworkAvailable = MutableStateFlow<Boolean?>(null)

    var isPlayerOpened = false
    var isMultiPovOpened = false

    var sleepTimer: Timer? = null
    var sleepTimerEndTime = 0L

    val video = MutableStateFlow<Pair<Video?, Long?>?>(null)
    val clip = MutableStateFlow<Clip?>(null)
    val user = MutableStateFlow<User?>(null)
    val game = MutableStateFlow<Pair<Game?, String?>?>(null)

    val updateUrl = MutableSharedFlow<String?>()

    private fun markKickValidationComplete() {
        _kickValidationState.value = KickValidationState.COMPLETE
        KickApiHelper.checkedValidation = true
    }

    fun startKickValidationIfNeeded(activity: Activity) {
        if (!activity.prefs().getBoolean(AppConstants.VALIDATE_TOKENS, true)) {
            markKickValidationComplete()
            return
        }
        validate(
            networkLibrary = activity.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
            kickWebHeaders = emptyMap(),
            gqlWebClientId = null,
            gqlWebToken = null,
            kickPublicApiHeaders = emptyMap(),
            accountId = activity.tokenPrefs().getString(AppConstants.KICK_USER_ID, null),
            accountLogin = activity.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null),
            activity = activity,
        )
    }

    suspend fun awaitKickValidationComplete(timeoutMs: Long): Boolean {
        if (_kickValidationState.value == KickValidationState.COMPLETE) {
            return true
        }
        return withTimeoutOrNull(timeoutMs) {
            kickValidationState.first { it == KickValidationState.COMPLETE }
            true
        } ?: false
    }

    fun loadVideo(videoId: String?, offset: Long?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (video.value == null) {
            viewModelScope.launch {
                val id = videoId?.takeIf { it.isNotBlank() }
                val item = if (id == null) {
                    null
                } else {
                    // Prefer Kick web / public APIs — never Twitch GQL for deep links.
                    runCatching { kickRepository.getVideoById(id) }.getOrNull()
                        ?: runCatching {
                            kickPublicApiRepository.getVideos(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = listOf(id),
                            ).data.firstOrNull()?.let {
                                Video(
                                    id = it.id,
                                    source = AppConstants.KICK,
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
                        }.getOrNull()
                }
                video.value = item to offset
            }
        }
    }

    suspend fun savePosition(id: Long, position: Long) {
        playerRepository.saveVideoPosition(VideoPosition(id, position))
    }

    fun loadClip(clipId: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (clip.value == null) {
            viewModelScope.launch {
                val id = clipId?.takeIf { it.isNotBlank() }
                clip.value = if (id == null) {
                    null
                } else {
                    runCatching { kickRepository.getClip(id) }.getOrNull()
                        ?: runCatching {
                            kickPublicApiRepository.getClips(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = listOf(id),
                            ).data.firstOrNull()?.let {
                                Clip(
                                    id = it.id,
                                    channelId = it.channelId,
                                    channelName = it.channelName,
                                    videoId = it.videoId,
                                    vodOffset = if (it.vodOffset != null && it.duration != null) {
                                        max(it.vodOffset - it.duration.toInt(), 0)
                                    } else {
                                        it.vodOffset
                                    },
                                    gameId = it.gameId,
                                    title = it.title,
                                    viewCount = it.viewCount,
                                    uploadDate = it.createdAt,
                                    duration = it.duration,
                                    thumbnailUrl = it.thumbnailUrl,
                                )
                            }
                        }.getOrNull()
                        ?: Clip(id = id)
                }
            }
        }
    }

    fun loadUser(login: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (user.value == null) {
            viewModelScope.launch {
                val slug = login?.trim()?.takeIf { it.isNotBlank() }
                user.value = if (slug == null) {
                    null
                } else {
                    runCatching {
                        kickRepository.getChannel(slug).let { channel ->
                            User(
                                channelId = channel.id?.toString(),
                                channelLogin = channel.slug,
                                channelName = channel.user?.username,
                                profileImageUrl = channel.user?.profileImage,
                            )
                        }
                    }.getOrNull()
                        ?: runCatching {
                            kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                logins = listOf(slug),
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
                        }.getOrNull()
                        ?: User(channelLogin = slug, channelName = slug)
                }
            }
        }
    }

    fun loadGame(gameSlug: String? = null, gameName: String? = null, tag: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (game.value == null) {
            viewModelScope.launch {
                val slug = gameSlug?.trim()?.takeIf { it.isNotBlank() }
                val name = gameName?.trim()?.takeIf { it.isNotBlank() }
                val resolved = when {
                    !slug.isNullOrBlank() -> runCatching {
                        kickRepository.getSubcategories(page = 1, limit = 100).data
                            .firstOrNull { it.slug.equals(slug, true) || it.name.equals(slug, true) }
                            ?.let {
                                Game(
                                    gameId = it.id?.toString(),
                                    gameSlug = it.slug,
                                    gameName = it.name,
                                    boxArtUrl = it.banner?.imageUrl,
                                )
                            }
                    }.getOrNull()
                    !name.isNullOrBlank() -> runCatching {
                        kickPublicApiRepository.getGames(
                            networkLibrary = networkLibrary,
                            headers = kickPublicApiHeaders,
                            names = listOf(name),
                        ).data.firstOrNull()?.let {
                            Game(
                                gameId = it.id,
                                gameName = it.name,
                                boxArtUrl = it.boxArtUrl,
                            )
                        }
                    }.getOrNull()
                        ?: runCatching {
                            kickRepository.getSubcategories(page = 1, limit = 100).data
                                .firstOrNull { it.name.equals(name, true) }
                                ?.let {
                                    Game(
                                        gameId = it.id?.toString(),
                                        gameSlug = it.slug,
                                        gameName = it.name,
                                        boxArtUrl = it.banner?.imageUrl,
                                    )
                                }
                        }.getOrNull()
                    else -> null
                } ?: Game(
                    gameSlug = slug,
                    gameName = name ?: slug,
                )
                game.value = resolved to tag
            }
        }
    }

    fun downloadStream(networkLibrary: String?, filesDir: String, id: String?, title: String?, startedAt: String?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?, downloadPath: String, quality: String, downloadChat: Boolean, downloadChatEmotes: Boolean, wifiOnly: Boolean) {
        viewModelScope.launch {
            if (!channelLogin.isNullOrBlank()) {
                val downloadedThumbnail = id.takeIf { !it.isNullOrBlank() }?.let { id ->
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
                val videoId = offlineRepository.saveVideo(
                    OfflineVideo(
                        name = title,
                        channelId = channelId,
                        channelLogin = channelLogin,
                        channelName = channelName,
                        channelLogo = downloadedLogo,
                        thumbnail = downloadedThumbnail,
                        gameId = gameId,
                        gameSlug = gameSlug,
                        gameName = gameName,
                        uploadDate = startedAt?.let { KickApiHelper.parseIso8601DateUTC(it) },
                        downloadDate = System.currentTimeMillis(),
                        downloadPath = downloadPath,
                        status = OfflineVideo.STATUS_BLOCKED,
                        quality = if (!quality.contains("Audio", true)) quality else "audio",
                        downloadChat = downloadChat,
                        downloadChatEmotes = downloadChatEmotes,
                        live = true
                    )
                ).toInt()
                WorkManager.getInstance(applicationContext).enqueueUniqueWork(
                    channelLogin,
                    ExistingWorkPolicy.REPLACE,
                    OneTimeWorkRequestBuilder<StreamDownloadWorker>()
                        .setInputData(workDataOf(StreamDownloadWorker.KEY_VIDEO_ID to videoId))
                        .setConstraints(
                            Constraints.Builder()
                                .setRequiredNetworkType(if (wifiOnly) NetworkType.UNMETERED else NetworkType.CONNECTED)
                                .build()
                        )
                        .build()
                )
            }
        }
    }

    fun downloadVideo(networkLibrary: String?, filesDir: String, id: String?, title: String?, uploadDate: String?, type: String?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?, url: String, downloadPath: String, quality: String, from: Long, to: Long, downloadChat: Boolean, downloadChatEmotes: Boolean, playlistToFile: Boolean, wifiOnly: Boolean) {
        viewModelScope.launch {
            val downloadedThumbnail = id.takeIf { !it.isNullOrBlank() }?.let { id ->
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
            val videoId = offlineRepository.saveVideo(
                OfflineVideo(
                    sourceUrl = url,
                    name = title,
                    channelId = channelId,
                    channelLogin = channelLogin,
                    channelName = channelName,
                    channelLogo = downloadedLogo,
                    thumbnail = downloadedThumbnail,
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
                    uploadDate = uploadDate?.let { KickApiHelper.parseIso8601DateUTC(it) },
                    downloadDate = System.currentTimeMillis(),
                    downloadPath = downloadPath,
                    fromTime = from,
                    toTime = to,
                    status = OfflineVideo.STATUS_BLOCKED,
                    type = type,
                    videoId = id,
                    quality = if (!quality.contains("Audio", true)) quality else "audio",
                    downloadChat = downloadChat,
                    downloadChatEmotes = downloadChatEmotes,
                    playlistToFile = playlistToFile
                )
            ).toInt()
            WorkManager.getInstance(applicationContext).enqueueUniqueWork(
                "download",
                ExistingWorkPolicy.APPEND_OR_REPLACE,
                OneTimeWorkRequestBuilder<VideoDownloadWorker>()
                    .setInputData(workDataOf(VideoDownloadWorker.KEY_VIDEO_ID to videoId))
                    .addTag(videoId.toString())
                    .setConstraints(
                        Constraints.Builder()
                            .setRequiredNetworkType(if (wifiOnly) NetworkType.UNMETERED else NetworkType.CONNECTED)
                            .build()
                    )
                    .build()
            )
        }
    }

    fun downloadClip(networkLibrary: String?, filesDir: String, clipId: String?, title: String?, uploadDate: String?, duration: Double?, videoId: String?, vodOffset: Int?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?, url: String, downloadPath: String, quality: String, downloadChat: Boolean, downloadChatEmotes: Boolean, wifiOnly: Boolean) {
        viewModelScope.launch {
            val downloadedThumbnail = clipId.takeIf { !it.isNullOrBlank() }?.let { id ->
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
            val videoId = offlineRepository.saveVideo(
                OfflineVideo(
                    sourceUrl = url,
                    sourceStartPosition = vodOffset?.toLong()?.times(1000L),
                    name = title,
                    channelId = channelId,
                    channelLogin = channelLogin,
                    channelName = channelName,
                    channelLogo = downloadedLogo,
                    thumbnail = downloadedThumbnail,
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
                    duration = duration?.toLong()?.times(1000L),
                    uploadDate = uploadDate?.let { KickApiHelper.parseIso8601DateUTC(it) },
                    downloadDate = System.currentTimeMillis(),
                    downloadPath = downloadPath,
                    status = OfflineVideo.STATUS_BLOCKED,
                    videoId = videoId,
                    clipId = clipId,
                    quality = if (!quality.contains("Audio", true)) quality else "audio",
                    downloadChat = downloadChat,
                    downloadChatEmotes = downloadChatEmotes
                )
            ).toInt()
            WorkManager.getInstance(applicationContext).enqueueUniqueWork(
                "download",
                ExistingWorkPolicy.APPEND_OR_REPLACE,
                OneTimeWorkRequestBuilder<VideoDownloadWorker>()
                    .setInputData(workDataOf(VideoDownloadWorker.KEY_VIDEO_ID to videoId))
                    .addTag(videoId.toString())
                    .setConstraints(
                        Constraints.Builder()
                            .setRequiredNetworkType(if (wifiOnly) NetworkType.UNMETERED else NetworkType.CONNECTED)
                            .build()
                    )
                    .build()
            )
        }
    }

    fun validate(networkLibrary: String?, kickWebHeaders: Map<String, String>, gqlWebClientId: String?, gqlWebToken: String?, kickPublicApiHeaders: Map<String, String>, accountId: String?, accountLogin: String?, activity: Activity) {
        if (_kickValidationState.value == KickValidationState.COMPLETE) {
            val accessToken = activity.tokenPrefs().getString(AppConstants.KICK_ACCESS_TOKEN, null)
            val expiresAt = activity.tokenPrefs().getLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L)
            val now = System.currentTimeMillis() / 1000L
            if (!accessToken.isNullOrBlank() && AuthStateHelper.isKickAccessTokenUsable(expiresAt, now)) {
                KickApiHelper.checkedValidation = true
                return
            }
            _kickValidationState.value = KickValidationState.IDLE
        }
        if (kickValidationJob?.isActive == true) {
            return
        }
        _kickValidationState.value = KickValidationState.RUNNING
        kickValidationJob = viewModelScope.launch {
            try {
                val accessToken = activity.tokenPrefs().getString(AppConstants.KICK_ACCESS_TOKEN, null)
                if (accessToken.isNullOrBlank()) {
                    return@launch
                }
                val now = System.currentTimeMillis() / 1000L
                val expiresAt = activity.tokenPrefs().getLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, 0L)
                val backendBaseUrl = KickOAuthConfig.getBackendBaseUrl(activity)
                    ?: throw IllegalStateException("401")
                val refreshToken = activity.tokenPrefs().getString(AppConstants.KICK_REFRESH_TOKEN, null)
                var activeToken = accessToken
                val shouldRefresh = expiresAt > 0L && expiresAt <= now + 30L
                if (!shouldRefresh) {
                    val introspect = runCatching {
                        authRepository.introspectKickToken(
                            networkLibrary = networkLibrary,
                            backendBaseUrl = backendBaseUrl,
                            request = KickBackendIntrospectRequest(
                                token = accessToken,
                            ),
                        )
                    }.getOrElse { error ->
                        if (isNetworkDebugEnabled()) {
                            DiagnosticLogger.w(kickAuthValidateTag, "Introspect failed, falling back to users endpoint: ${error.message}", error)
                        }
                        null
                    }
                    if (introspect != null && !introspect.active) {
                        throw IllegalStateException("401")
                    }
                }
                if (shouldRefresh) {
                    if (refreshToken.isNullOrBlank()) {
                        throw IllegalStateException("401")
                    }
                    val refresh = authRepository.refreshKickToken(
                        networkLibrary = networkLibrary,
                        backendBaseUrl = backendBaseUrl,
                        request = KickBackendRefreshRequest(
                            refreshToken = refreshToken,
                        ),
                    )
                    val newAccess = refresh.accessToken?.takeIf { it.isNotBlank() } ?: throw IllegalStateException("401")
                    activeToken = newAccess
                    activity.tokenPrefs().edit {
                        putString(AppConstants.KICK_ACCESS_TOKEN, newAccess)
                        putString(AppConstants.KICK_REFRESH_TOKEN, refresh.refreshToken ?: refreshToken)
                        putLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, now + (refresh.expiresIn ?: 0L))
                        putString(AppConstants.KICK_TOKEN_TYPE, refresh.tokenType)
                    }
                }
                val user = try {
                    authRepository.getKickCurrentUser(networkLibrary, activeToken).data.firstOrNull()
                } catch (e: Exception) {
                    if (KickAuthRequestException.isUnauthorized(e)) {
                        throw IllegalStateException("401")
                    }
                    throw e
                }
                if (user == null) {
                    throw IllegalStateException("401")
                }
                val userId = user.id?.toString()
                val loginName = user.name ?: user.channelSlug ?: userId
                if (isNetworkDebugEnabled()) {
                    Log.i(kickAuthValidateTag, "Kick OAuth validated via /public/v1/users. userId=${userId ?: "null"} login=${loginName ?: "unknown"}")
                }
                activity.tokenPrefs().edit {
                    putString(AppConstants.KICK_USER_ID, userId)
                    putString(AppConstants.KICK_USER_LOGIN, loginName)
                    putString(AppConstants.USER_ID, userId)
                    putString(AppConstants.USERNAME, loginName)
                }
            } catch (e: Exception) {
                if (e is IllegalStateException && e.message == "401") {
                    AuthStateHelper.markUnexpectedLogout(activity)
                    Toast.makeText(activity, R.string.token_expired, Toast.LENGTH_LONG).show()
                    AuthStateHelper.clearKickAuth(activity)
                    AuthStateHelper.clearLegacyWebAuth(activity)
                    (activity as? MainActivity)?.loginResultLauncher?.launch(Intent(activity, LoginActivity::class.java))
                } else if (KickAuthRequestException.isBackendUnavailable(e)) {
                    Toast.makeText(activity, R.string.kick_oauth_backend_unreachable, Toast.LENGTH_LONG).show()
                }
            } finally {
                markKickValidationComplete()
                kickValidationJob = null
            }
        }
    }

    fun checkUpdates(networkLibrary: String?, url: String, lastChecked: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            updateUrl.emit(
                try {
                    val response = when {
                        networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                            val response = suspendCoroutine { continuation ->
                                httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                            }
                            json.decodeFromString<JsonObject>(String(response.second))
                        }
                        networkLibrary == "Cronet" && cronetEngine != null -> {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                                cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                                val response = request.future.get().responseBody as String
                                json.decodeFromString<JsonObject>(response)
                            } else {
                                val response = suspendCoroutine { continuation ->
                                    cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                }
                                json.decodeFromString<JsonObject>(String(response.second))
                            }
                        }
                        else -> {
                            okHttpClient.newCall(Request.Builder().url(url).build()).execute().use { response ->
                                json.decodeFromString<JsonObject>(response.body.string())
                            }
                        }
                    }
                    response["assets"]?.jsonArray?.find {
                        val asset = it.jsonObject
                        asset.getValue("content_type").jsonPrimitive.contentOrNull == "application/vnd.android.package-archive" ||
                            (asset["name"]?.jsonPrimitive?.contentOrNull)?.endsWith(".apk") == true
                    }?.jsonObject?.let { obj ->
                        obj.getValue("updated_at").jsonPrimitive.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }?.let {
                            if (it > lastChecked) {
                                obj.getValue("browser_download_url").jsonPrimitive.contentOrNull
                            } else null
                        }
                    }
                } catch (e: Exception) {
                    null
                }
            )
        }
        KickApiHelper.checkedUpdates = true
    }

    fun downloadUpdate(networkLibrary: String?, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = when {
                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                        val response = suspendCoroutine { continuation ->
                            httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                        }
                        if (response.first.httpStatusCode in 200..299) {
                            response.second
                        } else null
                    }
                    networkLibrary == "Cronet" && cronetEngine != null -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                            cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                            val response = request.future.get()
                            if (response.urlResponseInfo.httpStatusCode in 200..299) {
                                response.responseBody as ByteArray
                            } else null
                        } else {
                            val response = suspendCoroutine { continuation ->
                                cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                            }
                            if (response.first.httpStatusCode in 200..299) {
                                response.second
                            } else null
                        }
                    }
                    else -> {
                        okHttpClient.newCall(Request.Builder().url(url).build()).execute().use { response ->
                            if (response.isSuccessful) {
                                response.body.bytes()
                            } else null
                        }
                    }
                }
                if (response != null && response.isNotEmpty()) {
                    val packageInstaller = applicationContext.packageManager.packageInstaller
                    val sessionId = packageInstaller.createSession(
                        PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL)
                    )
                    val session = packageInstaller.openSession(sessionId)
                    session.openWrite("package", 0, response.size.toLong()).use {
                        it.write(response)
                    }
                    session.commit(
                        PendingIntent.getActivity(
                            applicationContext,
                            0,
                            Intent(applicationContext, MainActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                                setAction(MainActivity.INTENT_INSTALL_UPDATE)
                            },
                            PendingIntent.FLAG_MUTABLE
                        ).intentSender
                    )
                    session.close()
                }
            } catch (e: Exception) {

            }
        }
    }

    fun deleteOldImages() {
        viewModelScope.launch(Dispatchers.IO) {
            offlineRepository.deleteOldImages()
        }
    }
}
