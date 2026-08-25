package com.xtrakick.app.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.MutedChatUser
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.MutedChatUsersRepository
import com.xtrakick.app.util.AppConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MessageClickedUiState(
    val user: User? = null,
    val isLoadingUser: Boolean = false,
    val isFollowing: Boolean = false,
    val canFollow: Boolean = false,
    val isFollowActionInProgress: Boolean = false,
    val isMuted: Boolean = false,
    val isMuteActionInProgress: Boolean = false,
)

@HiltViewModel
class MessageClickedViewModel @Inject constructor(
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
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
    private var currentKickWebHeaders: Map<String, String> = emptyMap()
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
        currentKickWebHeaders = kickWebHeaders
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
                    User(
                        channelId = response.id?.toString() ?: kickUser.id?.toString(),
                        channelLogin = kickUser.username,
                        channelName = kickUser.username,
                        profileImageUrl = kickUser.profileImage,
                        bannerImageURL = response.bannerUrl,
                        createdAt = userCardDetails.createdAt ?: kickUser.createdAt,
                        followedAt = userCardDetails.followingSince
                    )
                } ?: throw Exception("Invalid response")
            } catch (_: Exception) {
                User(
                    channelId = currentChannelId ?: "",
                    channelLogin = currentChannelLogin,
                    channelName = currentChannelName ?: currentChannelLogin,
                    profileImageUrl = null,
                    bannerImageURL = null,
                    createdAt = null,
                    followedAt = null
                )
            }
        } else {
            if (!currentKickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
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

    fun toggleFollow(displayName: String?) {
        val userId = currentChannelId
        val channelLogin = currentChannelLogin
        if (currentIsKick) {
            if (userId.isNullOrBlank() && channelLogin.isNullOrBlank()) return
        } else if (userId.isNullOrBlank()) {
            return
        }
        viewModelScope.launch {
            if (!currentIsKick && currentKickWebHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                _events.emit("Follow requires a signed-in account.")
                return@launch
            }
            val isFollowing = uiState.value.isFollowing
            uiState.value = uiState.value.copy(isFollowActionInProgress = true)
            try {
                if (currentIsKick) {
                    // Kick follows are local-only; do not call Twitch GQL FollowButton ops.
                    val followUserId = userId ?: channelLogin.orEmpty()
                    if (isFollowing) {
                        localFollowChannelRepository.removeLocalFollow(userId, channelLogin)
                        _events.emit("Unfollowed ${displayName ?: currentChannelName ?: channelLogin ?: "channel"}")
                    } else {
                        localFollowChannelRepository.saveFollow(
                            LocalFollowChannel(
                                userId = followUserId,
                                userLogin = channelLogin,
                                userName = currentChannelName ?: displayName,
                                channelLogo = currentChannelLogo,
                            )
                        )
                        _events.emit("You're now following ${displayName ?: currentChannelName ?: channelLogin ?: "channel"}")
                    }
                    uiState.value = uiState.value.copy(isFollowing = !isFollowing)
                }
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
                _events.emit("Messages restored for ${userName ?: userLogin ?: "user"}")
            } else {
                mutedChatUsersRepository.saveMutedUser(MutedChatUser(userId, userLogin, userName))
                _events.emit("Muted ${userName ?: userLogin ?: "user"} in chat")
            }
            uiState.value = uiState.value.copy(
                isMuted = !isMuted,
                isMuteActionInProgress = false,
            )
        }
    }
}
