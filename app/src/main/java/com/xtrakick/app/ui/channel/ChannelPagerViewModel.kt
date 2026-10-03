package com.xtrakick.app.ui.channel

import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.NotificationUser
import com.xtrakick.app.model.ShownNotification
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.BookmarksRepository
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.getByteArrayCronetCallback
import android.content.Context
import android.util.Log
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
class ChannelPagerViewModel @Inject constructor(
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val offlineRepository: OfflineRepository,
    private val bookmarksRepository: BookmarksRepository,
    private val shownNotificationsRepository: ShownNotificationsRepository,
    private val notificationUsersRepository: NotificationUsersRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    // Injected rather than passed in from the Fragment: enableNotifications runs in
    // viewModelScope, so holding a caller-supplied Activity Context would leak it across
    // configuration change.
    @param:ApplicationContext private val applicationContext: Context,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)

    private val args = ChannelPagerFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val _notificationsEnabled = MutableStateFlow(false)
    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled

    // Single canonical poll key for the notifications table. Channel page and player both
    // derive it the same way, so a row written on one screen is visible on the other.
    private fun canonicalKey(channelId: String?, channelLogin: String?): String? =
        (channelId ?: channelLogin)?.trim()?.takeIf { it.isNotBlank() }

    private fun allCandidateKeys(vararg extraKeys: String?): List<String> = listOfNotNull(
        args.channelId,
        args.channelLogin,
        _stream.value?.channelId,
        _stream.value?.channelLogin,
        _stream.value?.user?.channelId,
        _stream.value?.user?.channelLogin,
        _user.value?.channelId,
        _user.value?.channelLogin,
        *extraKeys
    ).map { it.trim() }.filter { it.isNotBlank() }.distinct()

    val notifications = MutableStateFlow<Pair<Boolean, String?>?>(null)
    private val _isFollowing = MutableStateFlow<Boolean?>(null)
    val isFollowing: StateFlow<Boolean?> = _isFollowing
    val follow = MutableStateFlow<Pair<Boolean, String?>?>(null)
    private var updatedLocalUser = false

    private val _stream = MutableStateFlow<Stream?>(null)
    val stream: StateFlow<Stream?> = _stream
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun loadStream(networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (_stream.value == null) {
            viewModelScope.launch {
                val loadedStream = if (!args.channelLogin.isNullOrBlank()) {
                    try {
                        val channelLogin = requireNotNull(args.channelLogin)
                        val channel = kickRepository.getChannel(channelLogin)
                        val stream = kickRepository.toStream(channel)
                        Stream(
                            id = stream.id,
                            source = stream.source,
                            channelId = stream.channelId,
                            channelLogin = stream.channelLogin,
                            channelName = stream.channelName,
                            gameId = stream.gameId,
                            gameSlug = stream.gameSlug,
                            gameName = stream.gameName,
                            title = stream.title,
                            viewerCount = stream.viewerCount,
                            startedAt = stream.startedAt,
                            thumbnailUrl = stream.thumbnailUrl,
                            profileImageUrl = stream.profileImageUrl,
                            tags = stream.tags,
                            user = User(
                                channelId = channel.id?.toString(),
                                channelLogin = channel.slug,
                                channelName = channel.user?.username,
                                profileImageUrl = channel.user?.profileImage,
                                followersCount = channel.followersCount,
                                bannerImageURL = channel.bannerUrl,
                                lastBroadcast = stream.startedAt,
                                isLive = channel.livestream != null,
                            )
                        )
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                        try {
                            kickPublicApiRepository.getStreams(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = args.channelId?.let { listOf(it) },
                                logins = if (args.channelId.isNullOrBlank()) args.channelLogin?.let { listOf(it) } else null
                            ).data.firstOrNull()?.let {
                                Stream(
                                    id = it.id,
                                    channelId = it.channelId,
                                    channelLogin = it.channelLogin,
                                    channelName = it.channelName,
                                    gameId = it.gameId,
                                    gameName = it.gameName,
                                    title = it.title,
                                    viewerCount = it.viewerCount,
                                    startedAt = it.startedAt,
                                    thumbnailUrl = it.thumbnailUrl,
                                    tags = it.tags
                                )
                            }
                        } catch (_: Exception) {
                            null
                        }
                    } else null
                }
                _stream.value = loadedStream
                if (loadedStream != null) {
                    val candidateKeys = allCandidateKeys(
                        loadedStream.channelId,
                        loadedStream.channelLogin,
                        loadedStream.user?.channelId,
                        loadedStream.user?.channelLogin
                    )
                    runCatching {
                        _notificationsEnabled.value = notificationUsersRepository.isNotificationEnabled(candidateKeys)
                    }
                }
            }
        }
    }

    fun loadUser(networkLibrary: String?, kickPublicApiHeaders: Map<String, String>) {
        if (_user.value == null) {
            viewModelScope.launch {
                val loadedUser = if (!args.channelLogin.isNullOrBlank()) {
                    try {
                        val channelLogin = requireNotNull(args.channelLogin)
                        kickRepository.getChannel(channelLogin).let { kickRepository.toUser(it) }
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                        try {
                            kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = args.channelId?.let { listOf(it) },
                                logins = if (args.channelId.isNullOrBlank()) args.channelLogin?.let { listOf(it) } else null
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
                        } catch (_: Exception) {
                            null
                        }
                    } else null
                }
                _user.value = loadedUser
                if (loadedUser != null) {
                    val candidateKeys = allCandidateKeys(loadedUser.channelId, loadedUser.channelLogin)
                    runCatching {
                        _notificationsEnabled.value = notificationUsersRepository.isNotificationEnabled(candidateKeys)
                    }
                }
            }
        }
    }

    fun retry(networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if (_stream.value == null) {
            loadStream(networkLibrary, kickWebHeaders, kickPublicApiHeaders, enableIntegrity)
        } else {
            if (_stream.value?.user == null && _user.value == null) {
                loadUser(networkLibrary, kickPublicApiHeaders)
            }
        }
    }

    fun enableNotifications(userId: String?, channelId: String?, channelLogin: String?, setting: Int, notificationsEnabled: Boolean, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            val candidateKeys = allCandidateKeys(channelId, channelLogin)
            if (candidateKeys.isEmpty()) return@launch
            try {
                val slug = channelLogin ?: args.channelLogin
                val name = _user.value?.channelName ?: _stream.value?.user?.channelName ?: args.channelName ?: slug
                val logo = _user.value?.profileImageUrl ?: _stream.value?.channelLogo ?: args.channelLogo
                val key = notificationUsersRepository.enableNotificationsForChannel(
                    candidateKeys = candidateKeys,
                    preferredLogin = slug,
                    preferredName = name,
                    preferredLogoUrl = logo,
                )
                _notificationsEnabled.value = true
                notifications.value = Pair(true, null)
                if (key != null && slug != null) {
                    notificationUsersRepository.saveChannelMetadata(key, slug, name, logo)
                    localFollowsChannel.getFollow(key, slug)?.let { follow ->
                        if (follow.userId.isNullOrBlank()) {
                            follow.userId = key
                            localFollowsChannel.updateFollow(follow)
                        }
                    }
                }
                if (notificationsEnabled && key != null) {
                    _stream.value?.startedAt.takeUnless { it.isNullOrBlank() }?.let { KickApiHelper.parseIso8601DateUTC(it) }?.let {
                        shownNotificationsRepository.saveList(listOf(ShownNotification(key, it)))
                    }
                }
                if (notificationsEnabled) {
                    // Kept separate from the enclosing catch so a notification failure is
                    // visible rather than being folded into the follow-toggle error path.
                    runCatching {
                        val newStreams = shownNotificationsRepository.getNewKickStreams(notificationUsersRepository)
                        if (newStreams.isNotEmpty()) {
                            shownNotificationsRepository.showLiveNotifications(applicationContext, newStreams)
                        }
                    }.onFailure {
                        Log.e(TAG, "failed to post live notifications after enabling", it)
                    }
                }
            } catch (e: Exception) {
                // Never swallow silently: an empty catch here left _notificationsEnabled
                // stale and the bell unresponsive (issues #44/#58).
                Log.e(TAG, "enableNotifications failed", e)
                notifications.value = Pair(false, e.message)
            }
        }
    }

    fun disableNotifications(userId: String?, channelId: String?, channelLogin: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            val candidateKeys = allCandidateKeys(channelId, channelLogin)
            if (candidateKeys.isEmpty()) return@launch
            try {
                notificationUsersRepository.disableNotificationsForChannel(candidateKeys)
                _notificationsEnabled.value = false
                notifications.value = Pair(false, null)
            } catch (e: Exception) {
                Log.e(TAG, "disableNotifications failed", e)
                notifications.value = Pair(false, e.message)
            }
        }
    }

    fun updateNotifications(networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        viewModelScope.launch {
            shownNotificationsRepository.getNewKickStreams(notificationUsersRepository)
        }
    }

    fun isFollowingChannel(userId: String?, channelId: String?, channelLogin: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        viewModelScope.launch {
            val candidateKeys = allCandidateKeys(channelId, channelLogin)
            if (candidateKeys.isEmpty()) {
                _notificationsEnabled.value = false
                return@launch
            }
            try {
                if (_isFollowing.value == null) {
                    _isFollowing.value = localFollowsChannel.getFollow(channelId ?: args.channelId, channelLogin ?: args.channelLogin) != null
                }
                // The heart also counts a Kick-account-only follow (made on another
                // device or before a local clear): local says no -> ask Kick.
                val login = channelLogin ?: args.channelLogin
                if (_isFollowing.value != true && !login.isNullOrBlank() && kickRepository.hasKickAccountFollowCapability()) {
                    kickRepository.getKickAccountFollowState(login)?.let { kickFollows ->
                        if (kickFollows) {
                            _isFollowing.value = true
                            localFollowsChannel.upsertLocalFollow(
                                userId = canonicalKey(channelId, channelLogin),
                                userLogin = login,
                                userName = args.channelName,
                                channelLogo = args.channelLogo,
                                sourceMask = AppConstants.FOLLOW_SOURCE_MASK_KICK
                            )
                        }
                    }
                }
                _notificationsEnabled.value = notificationUsersRepository.isNotificationEnabled(candidateKeys)
            } catch (e: Exception) {
                Log.e(TAG, "isFollowingChannel failed", e)
                _notificationsEnabled.value = false
            }
        }
    }

    fun saveFollowChannel(userId: String?, channelId: String?, channelLogin: String?, channelName: String?, setting: Int, notificationsEnabled: Boolean, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean, kickFollow: Boolean = true) {
        viewModelScope.launch {
            try {
                val candidateKeys = allCandidateKeys(channelId, channelLogin)
                val followId = canonicalKey(channelId, channelLogin) ?: candidateKeys.firstOrNull()
                if (followId != null) {
                    val mask = if (kickFollow) {
                        AppConstants.FOLLOW_SOURCE_MASK_KICK or AppConstants.FOLLOW_SOURCE_MASK_LOCAL
                    } else {
                        AppConstants.FOLLOW_SOURCE_MASK_LOCAL
                    }
                    val logo = _stream.value?.channelLogo
                        ?: _stream.value?.user?.profileImageUrl
                        ?: _user.value?.profileImageUrl
                    localFollowsChannel.saveFollow(LocalFollowChannel(followId, channelLogin ?: args.channelLogin, channelName, logo, mask))
                    _isFollowing.value = true
                    follow.value = Pair(true, null)
                    followOnKickAccount(channelLogin ?: args.channelLogin, true, kickFollow)
                    // Following never touches notifications — the bell button is the only
                    // thing that arms them.
                }
            } catch (e: Exception) {
                Log.e(TAG, "saveFollowChannel failed", e)
            }
        }
    }

    fun deleteFollowChannel(userId: String?, channelId: String?, channelLogin: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean, kickFollow: Boolean = true) {
        viewModelScope.launch {
            try {
                val candidateKeys = allCandidateKeys(channelId, channelLogin)
                val existing = localFollowsChannel.getFollow(channelId ?: args.channelId, channelLogin ?: args.channelLogin)
                val wasKickFollow = existing?.isKickFollow == true || (kickFollow && kickRepository.hasKickAccountFollowCapability())
                existing?.let { localFollowsChannel.deleteFollow(it) }
                _isFollowing.value = false
                follow.value = Pair(false, null)
                followOnKickAccount(channelLogin ?: args.channelLogin, false, wasKickFollow)
                notificationUsersRepository.disableNotificationsForChannel(candidateKeys)
                _notificationsEnabled.value = false
            } catch (e: Exception) {
                Log.e(TAG, "deleteFollowChannel failed", e)
            }
        }
    }

    /**
     * Mirrors the follow onto the logged-in Kick account (best-effort). With a Google
     * or OAuth session the website endpoint accepts the bearer; failures never break
     * the local follow and are logged for diagnosis.
     */
    private suspend fun followOnKickAccount(channelLogin: String?, follow: Boolean, enabled: Boolean) {
        val slug = channelLogin?.trim()?.takeIf { it.isNotBlank() } ?: return
        DiagnosticLogger.i(TAG, "followOnKickAccount slug=$slug follow=$follow enabled=$enabled hasCapability=${kickRepository.hasKickAccountFollowCapability()}")
        if (!enabled || !kickRepository.hasKickAccountFollowCapability()) return
        val verb = if (follow) "follow" else "unfollow"
        DiagnosticLogger.i(TAG, "Starting Kick account $verb for $slug...")
        runCatching { kickRepository.setKickAccountFollow(slug, follow) }
            .onSuccess { applied ->
                if (applied) {
                    DiagnosticLogger.i(TAG, "Kick account $verb succeeded for $slug")
                } else {
                    DiagnosticLogger.w(TAG, "Kick account $verb returned a negative status for $slug")
                }
            }
            .onFailure {
                DiagnosticLogger.w(TAG, "Kick account $verb failed for $slug: ${it.message}")
            }
    }

    fun updateLocalUser(networkLibrary: String?, filesDir: String, user: User) {
        if (!updatedLocalUser) {
            updatedLocalUser = true
            user.channelId.takeIf { !it.isNullOrBlank() }?.let { userId ->
                viewModelScope.launch {
                    val downloadedLogo = user.channelLogo.takeIf { !it.isNullOrBlank() }?.let {
                        File(filesDir, "profile_pics").mkdir()
                        val path = filesDir + File.separator + "profile_pics" + File.separator + userId
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
                    localFollowsChannel.getFollow(userId, user.channelLogin)?.let {
                        localFollowsChannel.updateFollow(it.apply {
                            if (!userId.isNullOrBlank()) this.userId = userId
                            userLogin = user.channelLogin
                            userName = user.channelName
                        })
                    }
                    offlineRepository.getVideosByUserId(userId).forEach {
                        offlineRepository.updateVideo(it.apply {
                            channelLogin = user.channelLogin
                            channelName = user.channelName
                            channelLogo = downloadedLogo
                        })
                    }
                    bookmarksRepository.getBookmarksByUserId(userId).forEach {
                        bookmarksRepository.updateBookmark(it.apply {
                            userLogin = user.channelLogin
                            userName = user.channelName
                            userLogo = downloadedLogo
                        })
                    }
                }
            }
        }
    }

    private companion object {
        private const val TAG = "ChannelPagerViewModel"
    }
}
