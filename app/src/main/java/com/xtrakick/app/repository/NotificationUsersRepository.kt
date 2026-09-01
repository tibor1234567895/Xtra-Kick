package com.xtrakick.app.repository

import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.model.NotificationUser
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

        val allKeys = resolveAllChannelKeys(initialKeys)
        val canonicalId = allKeys.firstOrNull { it.all(Char::isDigit) }
            ?: initialKeys.firstOrNull()
            ?: return@withContext null

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
     * Bulk-enable live notifications for many channels with a single FCM sync. Numeric keys
     * are treated as canonical directly; slug-only channels fall back to alias resolution so
     * rows stay keyed by the channel id. Returns the number of newly inserted rows.
     */
    suspend fun enableNotificationsForChannels(candidateKeysPerChannel: List<Collection<String?>>): Int = withContext(Dispatchers.IO) {
        val canonicalIds = LinkedHashSet<String>()
        val staleKeys = mutableSetOf<String>()
        for (candidateKeys in candidateKeysPerChannel) {
            val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toSet()
            if (initialKeys.isEmpty()) continue
            val numericKey = initialKeys.firstOrNull { it.all(Char::isDigit) }
            if (numericKey != null) {
                canonicalIds.add(numericKey)
            } else {
                val allKeys = resolveAllChannelKeys(initialKeys)
                val canonicalId = allKeys.firstOrNull { it.all(Char::isDigit) }
                    ?: initialKeys.firstOrNull()
                    ?: continue
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

    private suspend fun resolveAllChannelKeys(candidateKeys: Collection<String?>): Set<String> {
        val normalized = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toMutableSet()
        if (normalized.isEmpty()) return emptySet()

        val lower = normalized.map { it.lowercase() }
        normalized.addAll(lower)

        val slugs = normalized.filter { it.toIntOrNull() == null }
        for (slug in slugs) {
            val channel = runCatching {
                kickRepository.getChannel(slug, prefetchBadgeCatalog = false)
            }.getOrNull()
            if (channel != null) {
                channel.id?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                channel.userId?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                channel.user?.id?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                channel.slug?.trim()?.takeIf { it.isNotBlank() }?.let {
                    normalized.add(it)
                    normalized.add(it.lowercase())
                }
                channel.user?.username?.trim()?.takeIf { it.isNotBlank() }?.let {
                    normalized.add(it)
                    normalized.add(it.lowercase())
                }
            }
        }

        val numericOnly = normalized.filter { it.all(Char::isDigit) }
        if (slugs.isEmpty() && numericOnly.isNotEmpty()) {
            for (numId in numericOnly) {
                val channel = runCatching {
                    kickRepository.getChannel(numId, prefetchBadgeCatalog = false)
                }.getOrNull()
                if (channel != null) {
                    channel.id?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                    channel.userId?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                    channel.user?.id?.toString()?.takeIf { it.isNotBlank() }?.let { normalized.add(it) }
                    channel.slug?.trim()?.takeIf { it.isNotBlank() }?.let {
                        normalized.add(it)
                        normalized.add(it.lowercase())
                    }
                }
            }
        }

        return normalized
    }

    /**
     * One-time cleanup for rows written before the canonical-key fix (issues #44/#58): they
     * may be keyed by the channel login instead of its numeric id — invisible to the
     * channel-page bell while the worker keeps polling them. Re-keys every non-numeric row
     * to the resolved id. Unresolved rows (offline/failed fetch) are left for the next app
     * start. Cheap when there is nothing to migrate: the DAO scan short-circuits first.
     */
    suspend fun migrateLegacyKeys() = withContext(Dispatchers.IO) {
        val legacy = notificationUsersDao.getAll().filter { it.channelId.trim().toIntOrNull() == null }
        if (legacy.isEmpty()) return@withContext
        Log.i(TAG, "migrating ${legacy.size} legacy notification key(s)")
        var changed = false
        for (item in legacy) {
            val login = item.channelId.trim()
            val channel = runCatching {
                kickRepository.getChannel(login, prefetchBadgeCatalog = false)
            }.getOrNull()
            val id = channel?.id?.toString() ?: channel?.userId?.toString()
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
