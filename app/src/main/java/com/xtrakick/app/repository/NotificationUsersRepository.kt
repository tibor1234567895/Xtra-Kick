package com.xtrakick.app.repository

import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.model.NotificationUser
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.util.FcmSyncManager
import android.util.Log
import dagger.Lazy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationUsersRepository @Inject constructor(
    private val notificationUsersDao: NotificationUsersDao,
    private val kickRepository: KickRepository,
    private val fcmSyncManager: Lazy<FcmSyncManager>,
    private val localFollowChannelRepository: Lazy<LocalFollowChannelRepository>? = null,
) {

    suspend fun loadUsers() = withContext(Dispatchers.IO) {
        notificationUsersDao.getAll()
    }

    suspend fun getByUserId(id: String) = withContext(Dispatchers.IO) {
        notificationUsersDao.getByUserId(id)
    }

    suspend fun isNotificationEnabled(candidateKeys: Collection<String?>): Boolean = withContext(Dispatchers.IO) {
        val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toMutableSet()
        if (initialKeys.isEmpty()) return@withContext false

        // Fast direct check in DAO
        val fastKeys = (initialKeys + initialKeys.map { it.lowercase() }).distinct()
        val matches = notificationUsersDao.getByKeys(fastKeys)
        if (matches.isNotEmpty()) return@withContext true

        // If not matched directly, resolve channel aliases from cache or API and re-check
        val allKeys = resolveAllChannelKeys(initialKeys)
        if (allKeys.size > fastKeys.size) {
            val resolvedMatches = notificationUsersDao.getByKeys(allKeys.toList())
            if (resolvedMatches.isNotEmpty()) return@withContext true
        }
        false
    }

    suspend fun isNotificationEnabled(vararg candidateKeys: String?): Boolean =
        isNotificationEnabled(candidateKeys.toList())

    suspend fun enableNotificationsForChannel(candidateKeys: Collection<String?>): String? = withContext(Dispatchers.IO) {
        val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toSet()
        if (initialKeys.isEmpty()) return@withContext null

        val (canonicalId, allKeys) = resolveCanonicalChannelInfo(initialKeys)
        if (canonicalId == null) return@withContext null

        // Remove any stale / duplicate alias rows for this channel so the DB stays clean
        val staleKeys = allKeys.filter { it != canonicalId }
        if (staleKeys.isNotEmpty()) {
            notificationUsersDao.deleteByKeys(staleKeys)
        }

        notificationUsersDao.insert(NotificationUser(canonicalId))
        runCatching { fcmSyncManager.get().syncSubscriptions() }
        canonicalId
    }

    suspend fun enableNotificationsForChannel(vararg candidateKeys: String?): String? =
        enableNotificationsForChannel(candidateKeys.toList())

    /**
     * Bulk-enable live notifications for many channels with a single FCM sync.
     * Always resolves to canonical broadcaster user ID. Returns the number of newly inserted rows.
     */
    suspend fun enableNotificationsForChannels(candidateKeysPerChannel: List<Collection<String?>>): Int = withContext(Dispatchers.IO) {
        val canonicalIds = LinkedHashSet<String>()
        val staleKeys = mutableSetOf<String>()
        for (candidateKeys in candidateKeysPerChannel) {
            val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toSet()
            if (initialKeys.isEmpty()) continue
            val (canonicalId, allKeys) = resolveCanonicalChannelInfo(initialKeys)
            if (canonicalId != null) {
                canonicalIds.add(canonicalId)
                staleKeys.addAll(allKeys.filter { it != canonicalId })
            }
        }
        if (canonicalIds.isEmpty()) return@withContext 0

        staleKeys.removeAll(canonicalIds)
        if (staleKeys.isNotEmpty()) {
            notificationUsersDao.deleteByKeys(staleKeys.toList())
        }

        val existing = notificationUsersDao.getAll().mapTo(mutableSetOf()) { it.channelId }
        val missing = canonicalIds.filterNot { it in existing }
        if (missing.isNotEmpty()) {
            notificationUsersDao.insertList(missing.map { NotificationUser(it) })
            runCatching { fcmSyncManager.get().syncSubscriptions() }
        }
        missing.size
    }

    suspend fun disableNotificationsForChannel(candidateKeys: Collection<String?>) = withContext(Dispatchers.IO) {
        val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toSet()
        if (initialKeys.isEmpty()) return@withContext

        val allKeys = resolveAllChannelKeys(initialKeys)
        if (allKeys.isNotEmpty()) {
            notificationUsersDao.deleteByKeys(allKeys.toList())
        }
        notificationUsersDao.deleteByKeys(initialKeys.toList())
        runCatching { fcmSyncManager.get().syncSubscriptions() }
    }

    suspend fun disableNotificationsForChannel(vararg candidateKeys: String?) =
        disableNotificationsForChannel(candidateKeys.toList())

    suspend fun saveUser(item: NotificationUser) = withContext(Dispatchers.IO) {
        notificationUsersDao.insert(item)
        runCatching { fcmSyncManager.get().syncSubscriptions() }
    }

    suspend fun deleteAllUsers() = withContext(Dispatchers.IO) {
        notificationUsersDao.deleteAll()
        runCatching { fcmSyncManager.get().syncSubscriptions() }
    }

    suspend fun deleteUser(item: NotificationUser) = withContext(Dispatchers.IO) {
        notificationUsersDao.delete(item)
        runCatching { fcmSyncManager.get().syncSubscriptions() }
    }

    data class ChannelResolutionResult(
        val canonicalId: String?,
        val allKeys: Set<String>,
    )

    suspend fun resolveCanonicalChannelInfo(candidateKeys: Collection<String?>): ChannelResolutionResult {
        val normalized = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toMutableSet()
        if (normalized.isEmpty()) return ChannelResolutionResult(null, emptySet())

        val lower = normalized.map { it.lowercase() }
        normalized.addAll(lower)

        var resolvedChannel: KickChannelResponse? = null
        val slugs = normalized.filter { it.toIntOrNull() == null }
        for (slug in slugs) {
            val channel = runCatching {
                kickRepository.getChannel(slug, prefetchBadgeCatalog = false)
            }.getOrNull()
            if (channel != null) {
                resolvedChannel = channel
                channel.userId?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                channel.user?.id?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                channel.id?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                channel.slug?.trim()?.takeIf { it.isNotBlank() }?.let {
                    normalized.add(it)
                    normalized.add(it.lowercase())
                }
                channel.user?.username?.trim()?.takeIf { it.isNotBlank() }?.let {
                    normalized.add(it)
                    normalized.add(it.lowercase())
                }
                break
            }
        }

        // Canonical ID is always the broadcaster's USER ID (which matches LocalFollowChannel.userId
        // and Kick's Public API). Fall back to channel id, or numeric key, or initial key.
        val canonicalId = resolvedChannel?.userId?.toString()
            ?: resolvedChannel?.user?.id?.toString()
            ?: resolvedChannel?.id?.toString()
            ?: normalized.firstOrNull { it.all(Char::isDigit) }
            ?: normalized.firstOrNull()

        return ChannelResolutionResult(canonicalId, normalized)
    }

    private suspend fun resolveAllChannelKeys(candidateKeys: Collection<String?>): Set<String> {
        return resolveCanonicalChannelInfo(candidateKeys).allKeys
    }

    /**
     * Cleanup and migration: ensures all stored notification keys are canonical broadcaster user IDs.
     * Re-keys any rows stored with channel IDs (e.g. from Pusher) or slugs to the true user ID.
     */
    suspend fun migrateLegacyKeys() = withContext(Dispatchers.IO) {
        val allRows = notificationUsersDao.getAll()
        if (allRows.isEmpty()) return@withContext

        val follows = runCatching { localFollowChannelRepository?.get()?.loadFollows() }.getOrNull().orEmpty()
        var changed = false

        for (follow in follows) {
            val login = follow.userLogin?.trim()?.takeIf { it.isNotBlank() } ?: continue
            val followUserId = follow.userId?.trim()?.takeIf { it.isNotBlank() && it.all(Char::isDigit) } ?: continue
            val channel = runCatching { kickRepository.getChannel(login, prefetchBadgeCatalog = false) }.getOrNull()
            val channelId = channel?.id?.toString()
            val canonicalUserId = channel?.userId?.toString() ?: followUserId

            // If a row was stored with channel.id (like 101943 for 52chains or 2480758 for 0reed)
            if (channelId != null && channelId != canonicalUserId) {
                val rowWithChannelId = notificationUsersDao.getByUserId(channelId)
                if (rowWithChannelId != null) {
                    Log.i(TAG, "cleaning up channel ID row $channelId for $login and re-keying to user ID $canonicalUserId")
                    notificationUsersDao.delete(rowWithChannelId)
                    notificationUsersDao.insert(NotificationUser(canonicalUserId))
                    changed = true
                }
            }

            // If a row was stored with login
            val rowWithLogin = notificationUsersDao.getByUserId(login)
            if (rowWithLogin != null) {
                Log.i(TAG, "cleaning up login row $login and re-keying to user ID $canonicalUserId")
                notificationUsersDao.delete(rowWithLogin)
                notificationUsersDao.insert(NotificationUser(canonicalUserId))
                changed = true
            }
        }

        // Also clean up any remaining non-numeric rows
        val legacy = notificationUsersDao.getAll().filter { it.channelId.trim().toIntOrNull() == null }
        for (item in legacy) {
            val login = item.channelId.trim()
            val channel = runCatching {
                kickRepository.getChannel(login, prefetchBadgeCatalog = false)
            }.getOrNull()
            val id = channel?.userId?.toString() ?: channel?.user?.id?.toString() ?: channel?.id?.toString()
            if (id.isNullOrBlank() || id.equals(login, ignoreCase = true)) continue
            notificationUsersDao.rekey(item, NotificationUser(id))
            changed = true
        }

        if (changed) {
            runCatching { fcmSyncManager.get().syncSubscriptions() }
        }
    }

    private companion object {
        private const val TAG = "NotificationUsers"
    }
}
