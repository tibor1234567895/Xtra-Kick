package com.xtrakick.app.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.MutedChatUser
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.KickAccountMutedUsersStore
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.MutedChatUsersRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MessageClickedViewModel"

data class MessageClickedUiState(
    val user: User? = null,
    val isLoadingUser: Boolean = false,
    val isFollowing: Boolean = false,
    val canFollow: Boolean = false,
    val isKickTarget: Boolean = false,
    val isFollowActionInProgress: Boolean = false,
    val isMuted: Boolean = false,
    val isMuteActionInProgress: Boolean = false,
)

@HiltViewModel
class MessageClickedViewModel @Inject constructor(
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val kickAccountMutedUsersStore: KickAccountMutedUsersStore,
    private val localFollowChannelRepository: LocalFollowChannelRepository,
    private val mutedChatUsersRepository: MutedChatUsersRepository,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)
    val uiState = MutableStateFlow(MessageClickedUiState())

    private val _events = MutableSharedFlow<String>()
    val events = _events.asSharedFlow()

    private var currentChannelId: String? = null
    private var currentChannelLogin: String? = null
    private var currentChannelName: String? = null
    private var currentChannelLogo: String? = null
    private var currentTargetId: String? = null
    private var currentTargetLogin: String? = null
    private var currentNetworkLibrary: String? = null
    private var currentKickPublicApiHeaders: Map<String, String> = emptyMap()
    private var currentEnableIntegrity = false
    private var currentIsKick = false
    private var isLoadingUser = false

    fun loadUser(
        channelId: String?,
        channelLogin: String?,
        channelName: String?,
        targetId: String?,
        targetLogin: String?,
        networkLibrary: String?,
        kickWebHeaders: Map<String, String>,
        kickPublicApiHeaders: Map<String, String>,
        enableIntegrity: Boolean,
        isKick: Boolean = false,
    ) {
        if (isLoadingUser) return

        currentChannelId = channelId?.takeIf { it.isNotBlank() }
        currentChannelLogin = channelLogin?.takeIf { it.isNotBlank() }
        currentChannelName = channelName?.takeIf { it.isNotBlank() }
        currentTargetId = targetId?.takeIf { it.isNotBlank() }
        currentTargetLogin = targetLogin?.takeIf { it.isNotBlank() }
        currentNetworkLibrary = networkLibrary
        currentKickPublicApiHeaders = kickPublicApiHeaders
        currentEnableIntegrity = enableIntegrity
        currentIsKick = isKick

        viewModelScope.launch {
            isLoadingUser = true
            val existingFollow = localFollowChannelRepository.getFollow(currentChannelId, currentChannelLogin)
            val mutedUser = mutedChatUsersRepository.getMutedUser(currentChannelId, currentChannelLogin, currentChannelName)
            val canFollowChannel = canFollowCurrentChannel(kickWebHeaders)
            uiState.value = uiState.value.copy(
                isLoadingUser = true,
                isFollowing = existingFollow != null,
                canFollow = canFollowChannel,
                isKickTarget = isKick,
                isMuted = mutedUser != null,
            )

            val response = loadUserInternal()
            if (response == null) {
                uiState.value = uiState.value.copy(isLoadingUser = false)
                isLoadingUser = false
                return@launch
            }

            currentChannelName = response.channelName ?: currentChannelName
            currentChannelLogo = response.channelLogo ?: currentChannelLogo

            val remoteFollowing = loadFollowingState()
            val currentMutedUser = mutedChatUsersRepository.getMutedUser(currentChannelId, currentChannelLogin, currentChannelName)
            uiState.value = uiState.value.copy(
                user = response,
                isLoadingUser = false,
                isFollowing = remoteFollowing ?: (existingFollow != null),
                canFollow = canFollowChannel,
                isMuted = currentMutedUser != null,
            )
            isLoadingUser = false
        }
    }

    private fun canFollowCurrentChannel(kickWebHeaders: Map<String, String>): Boolean {
        return if (currentIsKick) {
            !currentChannelId.isNullOrBlank() || !currentChannelLogin.isNullOrBlank()
        } else {
            !currentChannelId.isNullOrBlank() && !kickWebHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()
        }
    }

    private suspend fun loadUserInternal(): User? {
        return if (currentIsKick && !currentChannelLogin.isNullOrBlank()) {
            try {
                val response = kickRepository.getChannel(requireNotNull(currentChannelLogin), false)
                response.user?.let { kickUser ->
                    val userCardDetails = kickRepository.getUserCardDetails(
                        channelSlug = currentTargetLogin,
                        userSlug = requireNotNull(currentChannelLogin)
                    )
                    val resolvedId = response.id?.toString() ?: kickUser.id?.toString() ?: currentChannelId
                    val resolvedBanner = response.bannerUrl
                        ?: KickApiHelper.getDefaultBanner(resolvedId, kickUser.username)
                    User(
                        channelId = resolvedId,
                        channelLogin = kickUser.username,
                        channelName = kickUser.username,
                        profileImageUrl = kickUser.profileImage,
                        bannerImageURL = resolvedBanner,
                        createdAt = userCardDetails.createdAt ?: kickUser.createdAt,
                        followedAt = userCardDetails.followingSince
                    )
                } ?: throw Exception("Invalid response")
            } catch (_: Exception) {
                val resolvedId = currentChannelId
                User(
                    channelId = resolvedId ?: "",
                    channelLogin = currentChannelLogin,
                    channelName = currentChannelName ?: currentChannelLogin,
                    profileImageUrl = null,
                    bannerImageURL = KickApiHelper.getDefaultBanner(resolvedId, currentChannelLogin),
                    createdAt = null,
                    followedAt = null
                )
            }
        } else {
            if (currentKickPublicApiHeaders.isNotEmpty()) {
                try {
                    kickPublicApiRepository.getUsers(
                        networkLibrary = currentNetworkLibrary,
                        headers = currentKickPublicApiHeaders,
                        ids = currentChannelId?.let { listOf(it) },
                        logins = if (currentChannelId.isNullOrBlank()) currentChannelLogin?.let { listOf(it) } else null
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
            } else {
                null
            }
        }
    }

    private suspend fun loadFollowingState(): Boolean? {
        if (currentIsKick) {
            return localFollowChannelRepository.getFollow(currentChannelId, currentChannelLogin) != null
        }
        return null
    }

    /** Saves the follow with the chosen source, mirroring the channel-page pattern:
     * Kick follow = local record with the Kick mask + best-effort account mirror;
     * local-only = local record without touching the Kick account. */
    fun follow(kickFollow: Boolean, displayName: String?) {
        if (!currentIsKick) return
        val userId = currentChannelId
        val channelLogin = currentChannelLogin
        if (userId.isNullOrBlank() && channelLogin.isNullOrBlank()) return
        viewModelScope.launch {
            uiState.value = uiState.value.copy(isFollowActionInProgress = true)
            try {
                val name = displayName ?: currentChannelName ?: channelLogin ?: "channel"
                localFollowChannelRepository.saveFollow(
                    LocalFollowChannel(
                        userId = userId ?: channelLogin.orEmpty(),
                        userLogin = channelLogin,
                        userName = currentChannelName ?: displayName,
                        channelLogo = currentChannelLogo,
                        sourceMask = if (kickFollow) {
                            AppConstants.FOLLOW_SOURCE_MASK_KICK or AppConstants.FOLLOW_SOURCE_MASK_LOCAL
                        } else {
                            AppConstants.FOLLOW_SOURCE_MASK_LOCAL
                        },
                    )
                )
                val slug = channelLogin?.trim()?.takeIf { it.isNotBlank() }
                val kickApplied = if (kickFollow && slug != null && kickRepository.hasKickAccountFollowCapability()) {
                    runCatching { kickRepository.setKickAccountFollow(slug, true) }
                        .onFailure { DiagnosticLogger.w(TAG, "Kick account follow failed for $slug: ${it.message}") }
                        .getOrNull() == true
                } else {
                    null
                }
                _events.emit(
                    when (kickApplied) {
                        true -> "You're now following $name on Kick"
                        false -> "You're now following $name (Kick account sync failed)"
                        else -> "You're now following $name (local only)"
                    }
                )
                uiState.value = uiState.value.copy(isFollowing = true)
            } catch (e: Exception) {
                _events.emit(e.message ?: "Unable to update follow state.")
            }
            uiState.value = uiState.value.copy(isFollowActionInProgress = false)
        }
    }

    fun unfollow(displayName: String?) {
        if (!currentIsKick) return
        val userId = currentChannelId
        val channelLogin = currentChannelLogin
        if (userId.isNullOrBlank() && channelLogin.isNullOrBlank()) return
        viewModelScope.launch {
            uiState.value = uiState.value.copy(isFollowActionInProgress = true)
            try {
                val name = displayName ?: currentChannelName ?: channelLogin ?: "channel"
                // Only mirror the unfollow onto the Kick account when the record
                // was a Kick follow — local-only follows never touch the account.
                val wasKickFollow = localFollowChannelRepository.getFollow(userId, channelLogin)?.isKickFollow == true
                localFollowChannelRepository.removeLocalFollow(userId, channelLogin)
                val slug = channelLogin?.trim()?.takeIf { it.isNotBlank() }
                if (wasKickFollow && slug != null && kickRepository.hasKickAccountFollowCapability()) {
                    runCatching { kickRepository.setKickAccountFollow(slug, false) }
                        .onFailure { DiagnosticLogger.w(TAG, "Kick account unfollow failed for $slug: ${it.message}") }
                }
                _events.emit("Unfollowed $name")
                uiState.value = uiState.value.copy(isFollowing = false)
            } catch (e: Exception) {
                _events.emit(e.message ?: "Unable to update follow state.")
            }
            uiState.value = uiState.value.copy(isFollowActionInProgress = false)
        }
    }

    fun toggleMute() {
        viewModelScope.launch {
            val userId = currentChannelId
            val userLogin = currentChannelLogin
            val userName = currentChannelName
            if (userId.isNullOrBlank() && userLogin.isNullOrBlank() && userName.isNullOrBlank()) {
                return@launch
            }
            val isMuted = uiState.value.isMuted
            uiState.value = uiState.value.copy(isMuteActionInProgress = true)
            if (isMuted) {
                mutedChatUsersRepository.removeMutedUser(userId, userLogin, userName)
            } else {
                mutedChatUsersRepository.saveMutedUser(MutedChatUser(userId, userLogin, userName))
            }
            val displayName = userName ?: userLogin ?: "user"
            val verb = if (isMuted) "Unmuted" else "Muted"
            when (mirrorMuteOnKickAccount(userId, !isMuted)) {
                true -> _events.emit("$verb $displayName on Kick")
                false -> _events.emit("$verb $displayName in chat (account sync failed)")
                else -> _events.emit(if (isMuted) "Messages restored for $displayName" else "$verb $displayName in chat")
            }
            uiState.value = uiState.value.copy(
                isMuted = !isMuted,
                isMuteActionInProgress = false,
            )
        }
    }

    /**
     * Mirrors the mute onto the logged-in Kick account (best-effort), mirroring the
     * local-first follow pattern. Null means not attempted (not a Kick stream, no
     * numeric user id, or no account capability); otherwise the applied outcome.
     */
    private suspend fun mirrorMuteOnKickAccount(userId: String?, mute: Boolean): Boolean? {
        if (!currentIsKick) return null
        val id = userId?.trim()?.takeIf { it.isNotBlank() } ?: return null
        if (!kickRepository.hasKickAccountFollowCapability()) return null
        // The account store mirrors the server's silenced-users list — when it already
        // has the target state, the write would be an idempotent no-op.
        val alreadyMuted = kickAccountMutedUsersStore.users.value.any { it.id == id }
        if (mute == alreadyMuted) return true
        val applied = runCatching { kickRepository.setKickAccountMutedUser(id, mute) }
            .onFailure { DiagnosticLogger.w(TAG, "Kick account mute mirror failed for $id: ${it.message}") }
            .getOrNull() == true
        if (applied) {
            // Keep the shared account store in sync so the chat filter releases
            // remote mutes immediately instead of waiting for the next refresh.
            if (mute) {
                kickAccountMutedUsersStore.onAccountMuteApplied(id, currentChannelName ?: currentChannelLogin)
            } else {
                kickAccountMutedUsersStore.onAccountUnmuteApplied(id)
            }
        }
        return applied
    }
}
