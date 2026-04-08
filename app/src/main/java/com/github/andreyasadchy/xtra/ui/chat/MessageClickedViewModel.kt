package com.github.andreyasadchy.xtra.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel
import com.github.andreyasadchy.xtra.model.ui.MutedChatUser
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.repository.MutedChatUsersRepository
import com.github.andreyasadchy.xtra.util.C
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
    private val graphQLRepository: GraphQLRepository,
    private val helixRepository: HelixRepository,
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
    private var currentGqlHeaders: Map<String, String> = emptyMap()
    private var currentHelixHeaders: Map<String, String> = emptyMap()
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
        gqlHeaders: Map<String, String>,
        helixHeaders: Map<String, String>,
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
        currentGqlHeaders = gqlHeaders
        currentHelixHeaders = helixHeaders
        currentEnableIntegrity = enableIntegrity
        currentIsKick = isKick

        viewModelScope.launch {
            isLoadingUser = true
            val existingFollow = localFollowChannelRepository.getFollow(currentChannelId, currentChannelLogin)
            val mutedUser = mutedChatUsersRepository.getMutedUser(currentChannelId, currentChannelLogin, currentChannelName)
            uiState.value = uiState.value.copy(
                isLoadingUser = true,
                isFollowing = existingFollow != null,
                canFollow = !currentChannelId.isNullOrBlank() && !gqlHeaders[C.HEADER_TOKEN].isNullOrBlank(),
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
                canFollow = !currentChannelId.isNullOrBlank() && !gqlHeaders[C.HEADER_TOKEN].isNullOrBlank(),
                isMuted = currentMutedUser != null,
            )
            isLoadingUser = false
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
                        bannerImageURL = response.bannerImage?.url,
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
            try {
                val response = graphQLRepository.loadQueryUserMessageClicked(
                    currentNetworkLibrary,
                    currentGqlHeaders,
                    currentChannelId,
                    currentChannelLogin.takeIf { currentChannelId.isNullOrBlank() },
                    currentTargetId
                )
                if (currentEnableIntegrity && integrity.value == null) {
                    response.errors?.find { it.message == "failed integrity check" }?.let {
                        integrity.value = "refresh"
                        return null
                    }
                }
                response.data!!.user?.let {
                    User(
                        channelId = it.id,
                        channelLogin = it.login,
                        channelName = it.displayName,
                        profileImageUrl = it.profileImageURL,
                        bannerImageURL = it.bannerImageURL,
                        createdAt = it.createdAt?.toString(),
                        followedAt = it.follow?.followedAt?.toString()
                    )
                }
            } catch (_: Exception) {
                if (!currentHelixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    try {
                        helixRepository.getUsers(
                            networkLibrary = currentNetworkLibrary,
                            headers = currentHelixHeaders,
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
    }

    private suspend fun loadFollowingState(): Boolean? {
        val userId = currentChannelId ?: return null
        if (currentGqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) return null
        return try {
            val response = graphQLRepository.loadQueryFollowingUser(
                currentNetworkLibrary,
                currentGqlHeaders,
                userId,
                currentChannelLogin.takeIf { userId.isBlank() }
            )
            if (currentEnableIntegrity && integrity.value == null) {
                response.errors?.find { it.message == "failed integrity check" }?.let {
                    integrity.value = "refresh"
                    return null
                }
            }
            response.data?.user?.self?.follower?.followedAt != null
        } catch (_: Exception) {
            null
        }
    }

    fun toggleFollow(displayName: String?) {
        val userId = currentChannelId ?: return
        val channelLogin = currentChannelLogin
        viewModelScope.launch {
            if (currentGqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                _events.emit("Follow requires a signed-in Kick account.")
                return@launch
            }
            val isFollowing = uiState.value.isFollowing
            uiState.value = uiState.value.copy(isFollowActionInProgress = true)
            try {
                val errorMessage = if (isFollowing) {
                    graphQLRepository.loadUnfollowUser(currentNetworkLibrary, currentGqlHeaders, userId).also { response ->
                        if (currentEnableIntegrity && integrity.value == null) {
                            response.errors?.find { it.message == "failed integrity check" }?.let {
                                integrity.value = "refresh"
                                uiState.value = uiState.value.copy(isFollowActionInProgress = false)
                                return@launch
                            }
                        }
                    }.errors?.firstOrNull()?.message
                } else {
                    graphQLRepository.loadFollowUser(currentNetworkLibrary, currentGqlHeaders, userId).also { response ->
                        if (currentEnableIntegrity && integrity.value == null) {
                            response.errors?.find { it.message == "failed integrity check" }?.let {
                                integrity.value = "refresh"
                                uiState.value = uiState.value.copy(isFollowActionInProgress = false)
                                return@launch
                            }
                        }
                    }.errors?.firstOrNull()?.message
                }
                if (!errorMessage.isNullOrBlank()) {
                    _events.emit(errorMessage)
                } else {
                    if (isFollowing) {
                        localFollowChannelRepository.removeLocalFollow(userId, channelLogin)
                        _events.emit("Unfollowed ${displayName ?: currentChannelName ?: channelLogin ?: "channel"}")
                    } else {
                        localFollowChannelRepository.saveFollow(
                            LocalFollowChannel(
                                userId = userId,
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
