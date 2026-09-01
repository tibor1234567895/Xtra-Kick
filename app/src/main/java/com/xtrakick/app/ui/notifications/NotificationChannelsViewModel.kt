package com.xtrakick.app.ui.notifications

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.util.enqueueLiveNotificationsPollingWork
import com.xtrakick.app.R
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.PublicUserSummary
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationChannelsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationUsersRepository: NotificationUsersRepository,
    private val localFollowChannelRepository: LocalFollowChannelRepository,
    private val kickRepository: KickRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
) : ViewModel() {

    data class ChannelUi(
        val id: String,
        val name: String?,
        val login: String?,
        val logoUrl: String?,
        val enabled: Boolean,
        val followed: Boolean,
    )

    private val _channels = MutableStateFlow<List<ChannelUi>?>(null)
    val channels: StateFlow<List<ChannelUi>?> = _channels.asStateFlow()

    private var refreshJob: Job? = null

    init {
        refresh()
    }

    fun refresh() {
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            _channels.value = loadChannels()
        }
    }

    private val _updateError = MutableStateFlow<String?>(null)
    val updateError: StateFlow<String?> = _updateError.asStateFlow()

    /** Consumed by the UI after showing the error so it can reappear on later failures. */
    fun consumeUpdateError() {
        _updateError.value = null
    }

    // One in-flight toggle per channel: a new toggle for the same entry cancels the
    // previous one so a slow enable (network alias resolution) cannot resurrect the
    // row after the user already toggled it off.
    private val toggleJobs = mutableMapOf<String, Job>()

    fun setEnabled(entry: ChannelUi, enabled: Boolean) {
        _channels.value = _channels.value?.map {
            if (it.id == entry.id && it.followed == entry.followed) it.copy(enabled = enabled) else it
        }
        toggleJobs.remove(entry.id)?.cancel()
        toggleJobs[entry.id] = viewModelScope.launch {
            try {
                if (enabled) {
                    // Resolve by login so the canonical row id is authoritative, then store
                    // it on the local follow: follows imported without their numeric id
                    // would no longer match the new row on the next load.
                    val canonical = notificationUsersRepository.enableNotificationsForChannel(
                        entry.login ?: entry.id, entry.id, entry.name
                    )
                    if (canonical != null) {
                        onChannelsEnabled()
                        if (entry.followed && !canonical.equals(entry.id, true)) {
                            localFollowChannelRepository.upsertLocalFollow(canonical, entry.login, entry.name)
                        }
                    }
                } else {
                    notificationUsersRepository.disableNotificationsForChannel(entry.id, entry.login, entry.name)
                }
            } catch (error: kotlinx.coroutines.CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.w(TAG, "notification toggle failed for ${entry.id}", error)
                _updateError.value = context.getString(R.string.live_notification_channels_update_failed)
            }
            // Reached only on non-cancelled completion (a cancelled toggle's replacement
            // already owns the map entry): drop the finished job so the map holds only
            // in-flight toggles.
            toggleJobs.remove(entry.id)
            refresh()
        }
    }

    fun enableAll() {
        viewModelScope.launch {
            try {
                val follows = localFollowChannelRepository.loadFollows()
                notificationUsersRepository.enableNotificationsForChannels(
                    follows.map { listOf(it.userId, it.userLogin) }
                )
                // Not gated on the insert count: rows can all predate the master switch
                // being turned off, and "enable all" must still produce a working state.
                onChannelsEnabled()
            } catch (error: kotlinx.coroutines.CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.w(TAG, "enable all failed", error)
                _updateError.value = context.getString(R.string.live_notification_channels_update_failed)
            }
            refresh()
        }
    }

    fun disableAll() {
        viewModelScope.launch {
            try {
                notificationUsersRepository.deleteAllUsers()
            } catch (error: kotlinx.coroutines.CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.w(TAG, "disable all failed", error)
                _updateError.value = context.getString(R.string.live_notification_channels_update_failed)
            }
            // Leave the master switch alone: the polling backup and the event gate consult
            // it independently, and channels may be re-enabled right after.
            refresh()
        }
    }

    /**
     * Event paths refuse to post while the master switch is off, so any enable from this
     * screen must turn it on — the channel-page bell does the same. The polling backup, if
     * configured, is rescheduled here too so it picks up the new subscriptions promptly.
     */
    private fun onChannelsEnabled() {
        context.prefs().edit { putBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, true) }
        if (context.prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_POLLING_BACKUP, false)) {
            enqueueLiveNotificationsPollingWork(context)
        }
    }

    private data class Draft(
        val id: String,
        val name: String?,
        val login: String?,
        val logoUrl: String?,
        val rowId: String?,
        val followed: Boolean,
    )

    private suspend fun loadChannels(): List<ChannelUi> {
        val rows = notificationUsersRepository.loadUsers()
        val follows = localFollowChannelRepository.loadFollows()

        val drafts = mutableListOf<Draft>()
        follows.forEach { follow ->
            val login = follow.userLogin?.trim()?.takeIf { it.isNotBlank() }
            val userId = follow.userId?.trim()?.takeIf { it.isNotBlank() }
            val followId = userId ?: login ?: return@forEach
            // Notification rows are keyed by the canonical channel id, so match the follow
            // by id first, then login. Rows keyed by the channel's other numeric id
            // (channel id vs user id) are re-matched later via the resolved login.
            val row = rows.firstOrNull {
                (userId != null && it.channelId.equals(userId, ignoreCase = true)) ||
                    (login != null && it.channelId.equals(login, ignoreCase = true))
            }
            drafts.add(Draft(
                id = row?.channelId ?: followId,
                name = follow.userName?.takeIf { it.isNotBlank() } ?: login,
                login = login,
                logoUrl = follow.channelLogo,
                rowId = row?.channelId,
                followed = true,
            ))
        }

        val networkLibrary = context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        var cachedHeaders: Map<String, String>? = null
        suspend fun lookupUser(id: String): PublicUserSummary? {
            val headers = cachedHeaders ?: runCatching {
                kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
            }.getOrElse { KickApiHelper.getKickPublicApiHeaders(context) }.also { cachedHeaders = it }
            val normalizedId = id.toLongOrNull()?.toString() ?: id
            return runCatching {
                kickPublicApiRepository.lookupUsersByIds(networkLibrary, headers, listOf(id))[id]
                    // Kick ids are numeric; legacy rows may carry leading zeros, so also
                    // match the normalized form the API echoes back.
                    ?: (normalizedId.takeIf { it != id }?.let {
                        kickPublicApiRepository.lookupUsersByIds(networkLibrary, headers, listOf(it))[it]
                    })
            }.getOrNull().also {
                if (it == null || it.login == null) Log.w(TAG, "could not resolve channel id $id")
            }
        }

        // Follows stored without any name (legacy import artifacts) would render as a raw
        // id: resolve their login once so they display and open like other entries.
        drafts.forEachIndexed { index, draft ->
            if (draft.followed && draft.login == null && draft.name == null) {
                lookupUser(draft.id)?.let { resolved ->
                    drafts[index] = draft.copy(name = resolved.login, login = resolved.login, logoUrl = resolved.profilePictureUrl)
                }
            }
        }

        // Rows no follow claimed: either keyed by the channel's other numeric id, or
        // notifications left on an unfollowed channel. Resolve each row's login and
        // re-match before showing it as "not followed".
        val claimedRowIds = drafts.mapNotNull { it.rowId }.toSet()
        rows.filterNot { it.channelId in claimedRowIds }.forEach { row ->
            val resolved = lookupUser(row.channelId)
            val matchedIndex = resolved?.login?.let { login ->
                drafts.indexOfFirst { draft ->
                    draft.followed && draft.rowId == null &&
                        (draft.login.equals(login, true) || draft.name.equals(login, true))
                }.takeIf { it >= 0 }
            }
            if (matchedIndex != null) {
                drafts[matchedIndex] = drafts[matchedIndex].copy(id = row.channelId, rowId = row.channelId)
            } else {
                drafts.add(Draft(
                    id = row.channelId,
                    name = resolved?.login,
                    login = resolved?.login,
                    logoUrl = resolved?.profilePictureUrl,
                    rowId = row.channelId,
                    followed = false,
                ))
            }
        }

        return drafts
            .distinctBy { it.id.lowercase() }
            .map { draft ->
                ChannelUi(
                    id = draft.id,
                    name = draft.name,
                    login = draft.login,
                    logoUrl = draft.logoUrl,
                    enabled = draft.rowId != null,
                    followed = draft.followed,
                )
            }
            .sortedWith(compareBy({ !it.enabled }, { it.name?.lowercase() ?: "" }, { it.id }))
    }

    companion object {
        private const val TAG = "NotifChannels"
    }
}
