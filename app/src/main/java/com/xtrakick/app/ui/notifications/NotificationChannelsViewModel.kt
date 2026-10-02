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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CoroutineStart
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import org.json.JSONObject

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

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _enabledOnly = MutableStateFlow(false)
    val enabledOnly: StateFlow<Boolean> = _enabledOnly.asStateFlow()

    /**
     * Full list filtered by the search query (name/login/id, case-insensitive)
     * and the "enabled only" toggle. Null while the initial load is in flight.
     */
    val filteredChannels: StateFlow<List<ChannelUi>?> = combine(_channels, _query, _enabledOnly) { channels, query, enabledOnly ->
        channels?.let { applyChannelFilter(it, query, enabledOnly) }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, null)

    fun setQuery(value: String) {
        _query.value = value
    }

    fun setEnabledOnly(value: Boolean) {
        _enabledOnly.value = value
    }

    private var refreshJob: Job? = null
    private val userSummaryCache = ConcurrentHashMap<String, PublicUserSummary>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching { notificationUsersRepository.migrateLegacyKeys() }
        }
        refresh()
    }

    fun refresh() {
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            _channels.value = loadChannels()
            enrichMissingChannelDetails()
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
        val job = viewModelScope.launch(start = CoroutineStart.LAZY) {
            try {
                if (enabled) {
                    val canonical = notificationUsersRepository.enableNotificationsForChannel(
                        listOfNotNull(entry.login, entry.id, entry.name),
                        preferredLogin = entry.login,
                        preferredName = entry.name,
                        preferredLogoUrl = entry.logoUrl,
                    )
                    if (canonical != null) {
                        onChannelsEnabled()
                        if (entry.followed) {
                            localFollowChannelRepository.upsertLocalFollow(canonical, entry.login, entry.name, entry.logoUrl)
                        }
                        if (canonical != entry.id) {
                            _channels.value = _channels.value?.map {
                                if (it.id == entry.id && it.followed == entry.followed) it.copy(id = canonical) else it
                            }
                        }
                    }
                } else {
                    notificationUsersRepository.disableNotificationsForChannel(entry.id, entry.login, entry.name)
                }
            } catch (error: kotlinx.coroutines.CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.w(TAG, "notification toggle failed for ${entry.id}", error)
                _channels.value = _channels.value?.map {
                    if (it.id == entry.id && it.followed == entry.followed) it.copy(enabled = !enabled) else it
                }
                _updateError.value = context.getString(R.string.live_notification_channels_update_failed)
            } finally {
                if (toggleJobs[entry.id] === coroutineContext[Job]) toggleJobs.remove(entry.id)
            }
        }
        toggleJobs[entry.id] = job
        job.start()
    }

    fun enableAll() {
        _channels.value = _channels.value?.map { it.copy(enabled = true) }
        viewModelScope.launch {
            try {
                val follows = localFollowChannelRepository.loadFollows()
                notificationUsersRepository.enableNotificationsForChannels(
                    follows.map { listOf(it.userId, it.userLogin) }
                )
                onChannelsEnabled()
            } catch (error: kotlinx.coroutines.CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.w(TAG, "enable all failed", error)
                _updateError.value = context.getString(R.string.live_notification_channels_update_failed)
                refresh()
            }
        }
    }

    fun disableAll() {
        _channels.value = _channels.value?.map { it.copy(enabled = false) }
        viewModelScope.launch {
            try {
                notificationUsersRepository.deleteAllUsers()
            } catch (error: kotlinx.coroutines.CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.w(TAG, "disable all failed", error)
                _updateError.value = context.getString(R.string.live_notification_channels_update_failed)
                refresh()
            }
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

    private suspend fun loadChannels(): List<ChannelUi> = withContext(Dispatchers.Default) {
        val rows = notificationUsersRepository.loadUsers()
        val follows = localFollowChannelRepository.loadFollows()

        val drafts = mutableListOf<Draft>()
        val claimedRowIds = mutableSetOf<String>()

        follows.forEach { follow ->
            val login = follow.userLogin?.trim()?.takeIf { it.isNotBlank() }
            val userId = follow.userId?.trim()?.takeIf { it.isNotBlank() }
            val followId = userId ?: login ?: return@forEach

            // Check metadata cache for this follow's known canonicalId or slug
            val followMeta = (userId?.let { notificationUsersRepository.getChannelMetadata(it) }
                ?: login?.let { notificationUsersRepository.getChannelMetadata(it) })
            val canonicalUserId = followMeta?.id ?: userId

            // Notification rows are keyed by the canonical broadcaster user id, but legacy
            // rows may temporarily be keyed by channel id or login.
            var row = rows.firstOrNull {
                (userId != null && it.channelId.equals(userId, ignoreCase = true)) ||
                    (canonicalUserId != null && it.channelId.equals(canonicalUserId, ignoreCase = true)) ||
                    (login != null && it.channelId.equals(login, ignoreCase = true))
            }

            // Check if any row matches the follow's channel ID or the broadcaster user
            // ID if cached — notification rows are keyed by the broadcaster user id,
            // which differs from the channel id on the follow row.
            if (row == null && login != null) {
                val cached = kickRepository.getCachedChannel(login)
                val candidateIds = listOfNotNull(
                    cached?.id?.toString(),
                    cached?.userId?.toString(),
                )
                if (candidateIds.isNotEmpty()) {
                    row = rows.firstOrNull { candidateIds.any { id -> it.channelId.equals(id, ignoreCase = true) } }
                }
            }

            if (row != null) {
                claimedRowIds.add(row.channelId)
                if (canonicalUserId != null) claimedRowIds.add(canonicalUserId)
                if (userId.isNullOrBlank() && row.channelId.all(Char::isDigit)) {
                    viewModelScope.launch(Dispatchers.IO) {
                        localFollowChannelRepository.upsertLocalFollow(row.channelId, login, follow.userName, follow.channelLogo)
                    }
                }
            }

            drafts.add(Draft(
                id = row?.channelId ?: canonicalUserId ?: followId,
                name = follow.userName?.takeIf { it.isNotBlank() } ?: followMeta?.name ?: login,
                login = login,
                logoUrl = follow.channelLogo ?: followMeta?.logoUrl,
                rowId = row?.channelId,
                followed = true,
            ))
        }

        // Also claim any rows that match known aliases of drafts
        val draftAliases = hashSetOf<String>()
        drafts.forEach { draft ->
            draft.rowId?.let {
                claimedRowIds.add(it)
                draftAliases.add(it.trim().lowercase(Locale.ROOT))
            }
            if (draft.id.isNotBlank()) {
                draftAliases.add(draft.id.trim().lowercase(Locale.ROOT))
            }
            draft.login?.trim()?.lowercase(Locale.ROOT)?.let { login ->
                draftAliases.add(login)
                notificationUsersRepository.getChannelMetadata(login)?.id?.trim()?.lowercase(Locale.ROOT)?.let(draftAliases::add)
                kickRepository.getCachedChannel(login)?.id?.toString()?.trim()?.lowercase(Locale.ROOT)?.let(draftAliases::add)
            }
        }
        rows.forEach { row ->
            if (row.channelId.trim().lowercase(Locale.ROOT) in draftAliases) {
                claimedRowIds.add(row.channelId)
            }
        }

        val unclaimedRows = rows.filterNot { it.channelId in claimedRowIds }
        if (unclaimedRows.isNotEmpty()) {
            val networkLibrary = context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
            var cachedHeaders: Map<String, String>? = null

            val missingIds = unclaimedRows.map { it.channelId }.filterNot { userSummaryCache.containsKey(it) || notificationUsersRepository.getChannelMetadata(it) != null }
            if (missingIds.isNotEmpty()) {
                runCatching {
                    val headers = cachedHeaders ?: runCatching {
                        kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
                    }.getOrElse { KickApiHelper.getKickPublicApiHeaders(context) }.also { cachedHeaders = it }
                    val fetched = kickPublicApiRepository.lookupUsersByIds(networkLibrary, headers, missingIds)
                    userSummaryCache.putAll(fetched)
                }
            }

            // Pre-parse the broadcaster id cache once before iterating unclaimed rows
            val broadcasterIdToSlug: Map<String, String> = runCatching {
                val raw = context.prefs().getString("kick_broadcaster_id_cache_v1", null)
                if (!raw.isNullOrBlank()) {
                    val root = JSONObject(raw)
                    val map = mutableMapOf<String, String>()
                    val keys = root.keys()
                    while (keys.hasNext()) {
                        val s = keys.next()
                        val id = root.optString(s).trim().lowercase(Locale.ROOT)
                        if (id.isNotEmpty()) {
                            map[id] = s.lowercase(Locale.ROOT)
                        }
                    }
                    map
                } else emptyMap()
            }.getOrDefault(emptyMap())

            unclaimedRows.forEach { row ->
                val rowKey = row.channelId.trim()
                // Check if persistent metadata knows this channel
                val meta = notificationUsersRepository.getChannelMetadata(rowKey)
                if (meta != null) {
                    val matchedDraft = drafts.firstOrNull { draft ->
                        draft.followed && draft.rowId == null &&
                            (draft.login?.equals(meta.login, ignoreCase = true) == true ||
                             draft.id.equals(meta.id, ignoreCase = true))
                    }
                    if (matchedDraft != null) {
                        val index = drafts.indexOf(matchedDraft)
                        drafts[index] = matchedDraft.copy(id = rowKey, rowId = rowKey)
                        viewModelScope.launch(Dispatchers.IO) {
                            localFollowChannelRepository.upsertLocalFollow(rowKey, matchedDraft.login, matchedDraft.name, matchedDraft.logoUrl)
                        }
                    } else {
                        drafts.add(Draft(
                            id = rowKey,
                            name = meta.name,
                            login = meta.login,
                            logoUrl = meta.logoUrl,
                            rowId = rowKey,
                            followed = false,
                        ))
                    }
                    return@forEach
                }

                // Check if the unclaimed row matches a follow's cached channel ID
                val matchedByFollowChannel = drafts.firstOrNull { draft ->
                    draft.followed && draft.rowId == null && draft.login != null &&
                        kickRepository.getCachedChannel(draft.login)?.id?.toString() == rowKey
                }
                if (matchedByFollowChannel != null) {
                    val index = drafts.indexOf(matchedByFollowChannel)
                    drafts[index] = matchedByFollowChannel.copy(id = rowKey, rowId = rowKey)
                    return@forEach
                }

                val resolved = userSummaryCache[rowKey]
                val matchedIndex = resolved?.login?.let { login ->
                    drafts.indexOfFirst { draft ->
                        draft.followed && draft.rowId == null &&
                            (draft.login.equals(login, true) || draft.name.equals(login, true))
                    }.takeIf { it >= 0 }
                }
                if (matchedIndex != null) {
                    val draft = drafts[matchedIndex]
                    drafts[matchedIndex] = draft.copy(id = rowKey, rowId = rowKey)
                    viewModelScope.launch(Dispatchers.IO) {
                        localFollowChannelRepository.upsertLocalFollow(rowKey, draft.login, draft.name, draft.logoUrl)
                    }
                } else if (resolved?.login != null) {
                    drafts.add(Draft(
                        id = rowKey,
                        name = resolved.login,
                        login = resolved.login,
                        logoUrl = resolved.profilePictureUrl,
                        rowId = rowKey,
                        followed = false,
                    ))
                } else {
                    // Fast O(1) map lookup for broadcaster slug
                    val broadcasterSlug = broadcasterIdToSlug[rowKey.lowercase(Locale.ROOT)]
                    val targetLookup = broadcasterSlug ?: rowKey
                    val cached = kickRepository.getCachedChannel(targetLookup)
                    val fallbackName = cached?.user?.username ?: cached?.slug ?: broadcasterSlug ?: rowKey
                    val fallbackLogin = cached?.slug ?: broadcasterSlug ?: rowKey
                    val fallbackLogo = cached?.user?.profileImage
                    if (cached != null || broadcasterSlug != null) {
                        notificationUsersRepository.saveChannelMetadata(rowKey, fallbackLogin, fallbackName, fallbackLogo)
                    }
                    drafts.add(Draft(
                        id = rowKey,
                        name = fallbackName,
                        login = fallbackLogin,
                        logoUrl = fallbackLogo,
                        rowId = rowKey,
                        followed = false,
                    ))
                }
            }
        }

        drafts
            .distinctBy { (it.login ?: it.id).lowercase() }
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
            .sortedWith(compareBy({ !it.followed }, { it.name?.lowercase() ?: "" }, { it.id }))
    }

    private suspend fun enrichMissingChannelDetails() = withContext(Dispatchers.IO) {
        val current = _channels.value ?: return@withContext
        val missing = current.filter { 
            (it.logoUrl.isNullOrBlank() || it.name == it.id) && 
            !it.login.isNullOrBlank() && 
            !it.login.all(Char::isDigit) 
        }.take(15)
        if (missing.isEmpty()) return@withContext

        var changed = false
        val updated = current.toMutableList()

        for (item in missing) {
            val slug = item.login ?: continue
            val ch = runCatching { kickRepository.getChannel(slug, prefetchBadgeCatalog = false) }.getOrNull() ?: continue
            val logo = ch.user?.profileImage
            val realName = ch.user?.username ?: ch.slug ?: item.name
            val trueUserId = ch.userId?.toString() ?: item.id
            if (!logo.isNullOrBlank() || realName != item.name) {
                notificationUsersRepository.saveChannelMetadata(trueUserId, slug, realName, logo)
                notificationUsersRepository.saveChannelMetadata(item.id, slug, realName, logo)
                if (item.followed) {
                    localFollowChannelRepository.upsertLocalFollow(trueUserId, slug, realName, logo)
                }
                val idx = updated.indexOfFirst { it.id == item.id && it.followed == item.followed }
                if (idx >= 0) {
                    updated[idx] = updated[idx].copy(
                        id = trueUserId,
                        name = realName,
                        login = slug,
                        logoUrl = logo ?: updated[idx].logoUrl
                    )
                    changed = true
                }
            }
        }
        if (changed) {
            withContext(Dispatchers.Main) {
                _channels.value = updated.sortedWith(compareBy({ !it.followed }, { it.name?.lowercase() ?: "" }, { it.id }))
            }
        }
    }

    companion object {
        private const val TAG = "NotifChannels"

        /**
         * Pure search + enabled-only filter over the loaded list. The filter never
         * adds, removes, or reorders source rows — toggling it on and back off
         * always restores the exact input list.
         */
        fun applyChannelFilter(channels: List<ChannelUi>, query: String, enabledOnly: Boolean): List<ChannelUi> {
            var list = channels
            if (enabledOnly) {
                list = list.filter { it.enabled }
            }
            val q = query.trim()
            if (q.isNotEmpty()) {
                list = list.filter {
                    it.name?.contains(q, ignoreCase = true) == true ||
                        it.login?.contains(q, ignoreCase = true) == true ||
                        it.id.contains(q, ignoreCase = true)
                }
            }
            return list
        }
    }
}
