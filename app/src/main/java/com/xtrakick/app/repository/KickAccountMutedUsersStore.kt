package com.xtrakick.app.repository

import android.os.SystemClock
import com.xtrakick.app.model.ui.KickMutedUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * In-memory mirror of the logged-in Kick account's muted (silenced) users, shared by
 * the chat filter, the message-click mute mirror, and the muted-users dialog so all
 * three agree without refetching. The list is pulled from `/api/v2/silenced-users`
 * when a chat session or the dialog opens; in-app mute/unmute updates it
 * optimistically so the chat filter reacts instantly, matching the official app's
 * account-scoped mute behavior.
 */
@Singleton
class KickAccountMutedUsersStore @Inject constructor(
    private val kickRepository: KickRepository,
) {
    private val _users = MutableStateFlow<List<KickMutedUser>>(emptyList())
    val users: StateFlow<List<KickMutedUser>> = _users.asStateFlow()

    @Volatile
    private var lastRefreshElapsedMs = -1L

    /**
     * Refetches the account list, throwing on failure like the repository call so the
     * dialog can surface login/network errors. Keeps the previous value on failure.
     */
    suspend fun refresh() {
        _users.value = kickRepository.getKickAccountMutedUsers()
        lastRefreshElapsedMs = SystemClock.elapsedRealtime()
    }

    /** Skips the network call while the list is younger than [maxAgeMs] (multipov opens several chat sessions at once). */
    suspend fun refreshIfStale(maxAgeMs: Long = 30_000L) {
        if (lastRefreshElapsedMs != -1L && SystemClock.elapsedRealtime() - lastRefreshElapsedMs < maxAgeMs) return
        refresh()
    }

    fun onAccountMuteApplied(id: String, username: String?) {
        val normalizedId = id.trim()
        if (_users.value.any { it.id == normalizedId }) return
        _users.value = _users.value + KickMutedUser(normalizedId, username)
    }

    fun onAccountUnmuteApplied(id: String) {
        val normalizedId = id.trim()
        if (_users.value.none { it.id == normalizedId }) return
        _users.value = _users.value.filterNot { it.id == normalizedId }
    }
}
