package com.xtrakick.app.repository

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.model.NotificationUser
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.FcmSyncManager
import com.xtrakick.app.util.prefs
import dagger.Lazy
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

data class NotificationChannelMetadata(
    val id: String,
    val login: String,
    val name: String,
    val logoUrl: String? = null,
)

@Singleton
class NotificationUsersRepository @Inject constructor(
    @param:ApplicationContext private val context: Context? = null,
    private val notificationUsersDao: NotificationUsersDao,
    private val kickRepository: KickRepository,
    private val fcmSyncManager: Lazy<FcmSyncManager>,
    private val localFollowChannelRepository: Lazy<LocalFollowChannelRepository>? = null,
) {

    private val metadataPrefs by lazy {
        context?.getSharedPreferences("notification_channel_metadata", Context.MODE_PRIVATE)
    }

    private val metadataCache = ConcurrentHashMap<String, NotificationChannelMetadata>()

    fun getChannelMetadata(key: String): NotificationChannelMetadata? {
        val trimmed = key.trim()
        if (trimmed.isEmpty()) return null
        val lowerKey = trimmed.lowercase(Locale.ROOT)
        metadataCache[trimmed]?.let { return it }
        metadataCache[lowerKey]?.let { return it }
        val prefs = metadataPrefs ?: return null
        val jsonStr = prefs.getString("id_$trimmed", null)
            ?: prefs.getString("slug_$lowerKey", null)
            ?: return null
        return runCatching {
            val json = JSONObject(jsonStr)
            val meta = NotificationChannelMetadata(
                id = json.getString("id"),
                login = json.getString("login"),
                name = json.optString("name", json.getString("login")),
                logoUrl = json.optString("logoUrl").takeIf { it.isNotBlank() && it != "null" }
            )
            metadataCache[meta.id] = meta
            metadataCache[meta.login.lowercase(Locale.ROOT)] = meta
            meta
        }.getOrNull()
    }

    fun saveChannelMetadata(id: String, login: String, name: String?, logoUrl: String?) {
        val trimmedId = id.trim()
        val trimmedLogin = login.trim()
        if (trimmedId.isEmpty() || trimmedLogin.isEmpty()) return
        val finalName = name?.trim()?.takeIf { it.isNotBlank() } ?: trimmedLogin
        val meta = NotificationChannelMetadata(trimmedId, trimmedLogin, finalName, logoUrl)
        val lowerLogin = trimmedLogin.lowercase(Locale.ROOT)
        metadataCache[trimmedId] = meta
        metadataCache[lowerLogin] = meta
        val prefs = metadataPrefs ?: return
        runCatching {
            val json = JSONObject().apply {
                put("id", trimmedId)
                put("login", trimmedLogin)
                put("name", finalName)
                put("logoUrl", logoUrl)
            }
            prefs.edit {
                putString("id_$trimmedId", json.toString())
                putString("slug_$lowerLogin", json.toString())
            }
        }
    }

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

    suspend fun enableNotificationsForChannel(
        candidateKeys: Collection<String?>,
        preferredLogin: String? = null,
        preferredName: String? = null,
        preferredLogoUrl: String? = null,
    ): String? = withContext(Dispatchers.IO) {
        val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toSet()
        if (initialKeys.isEmpty()) return@withContext null

        val (canonicalId, allKeys) = resolveCanonicalChannelInfo(initialKeys)
        if (canonicalId == null) return@withContext null

        rememberChannelAliases(canonicalId, allKeys + initialKeys)

        val slug = preferredLogin ?: initialKeys.firstOrNull { it.toIntOrNull() == null }
        if (slug != null) {
            saveChannelMetadata(
                id = canonicalId,
                login = slug,
                name = preferredName ?: slug,
                logoUrl = preferredLogoUrl,
            )
        }

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
     *
     * Candidate keys that already contain a numeric key (follows store the canonical
     * broadcaster user id) are trusted as-is, so a bulk enable needs no network at all.
     * Login-only entries fall back to per-channel resolution, run with bounded
     * concurrency since each lookup is a slow channel fetch.
     */
    suspend fun enableNotificationsForChannels(candidateKeysPerChannel: List<Collection<String?>>): Int = withContext(Dispatchers.IO) {
        val canonicalIds = LinkedHashSet<String>()
        val staleKeys = mutableSetOf<String>()
        val unresolvedKeys = mutableListOf<Set<String>>()
        for (candidateKeys in candidateKeysPerChannel) {
            val initialKeys = candidateKeys.mapNotNull { it?.trim()?.takeIf { k -> k.isNotBlank() } }.toSet()
            if (initialKeys.isEmpty()) continue
            val numericKey = initialKeys.firstOrNull { it.all(Char::isDigit) }
            if (numericKey != null) {
                canonicalIds.add(numericKey)
                rememberChannelAliases(numericKey, initialKeys)
                staleKeys.addAll(initialKeys)
                staleKeys.addAll(initialKeys.map(String::lowercase))
            } else {
                unresolvedKeys.add(initialKeys)
            }
        }
        if (unresolvedKeys.isNotEmpty()) {
            val resolved = coroutineScope {
                unresolvedKeys.map { keys ->
                    async {
                        resolutionSemaphore.withPermit { resolveCanonicalChannelInfo(keys) }
                    }
                }.awaitAll()
            }
            for ((canonicalId, allKeys) in resolved) {
                if (canonicalId != null) {
                    canonicalIds.add(canonicalId)
                    rememberChannelAliases(canonicalId, allKeys)
                    staleKeys.addAll(allKeys)
                }
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
        }
        runCatching { fcmSyncManager.get().syncSubscriptions() }
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

        if (canonicalId != null && resolvedChannel != null) {
            val slug = resolvedChannel.slug ?: normalized.firstOrNull { it.toIntOrNull() == null }
            if (slug != null) {
                saveChannelMetadata(
                    id = canonicalId,
                    login = slug,
                    name = resolvedChannel.user?.username ?: slug,
                    logoUrl = resolvedChannel.user?.profileImage,
                )
            }
        }

        return ChannelResolutionResult(canonicalId, normalized)
    }

    private suspend fun resolveAllChannelKeys(candidateKeys: Collection<String?>): Set<String> {
        return resolveCanonicalChannelInfo(candidateKeys).allKeys
    }

    suspend fun ensureMetadataSeeded() = withContext(Dispatchers.IO) {
        if (metadataPrefs?.getBoolean("seeds_initialized_v3", false) == true) return@withContext
        val knownSeeds = mapOf(
            "2642629" to ("4head" to "4HEAD"),
            "3124131" to ("sock22" to "Sock22"),
            "44431964" to ("travpiper" to "travpiper"),
            "1243232" to ("caramel" to "Caramel"),
            "1028087" to ("saab" to "Saab"),
            "676" to ("xqc" to "xQc"),
            "33057" to ("buddha" to "Buddha"),
            "90452" to ("omie" to "omie"),
            "6069133" to ("firas" to "Firas"),
            "58065" to ("impulsespoon646" to "impulsespoon646"),
            "120409948" to ("ananped" to "Ananped"),
            "120340753" to ("lazenxd" to "LAZENXD"),
        )
        for ((uid, pair) in knownSeeds) {
            saveChannelMetadata(uid, pair.first, pair.second, null)
            localFollowChannelRepository?.get()?.let { repo ->
                repo.getFollow(uid, pair.first)?.let { f ->
                    if (f.userId.isNullOrBlank()) {
                        f.userId = uid
                        repo.updateFollow(f)
                    }
                }
            }
        }
        metadataPrefs?.edit { putBoolean("seeds_initialized_v3", true) }
    }

    /**
     * Cleanup and migration: ensures all stored notification keys are canonical broadcaster user IDs.
     * Re-keys any rows stored with channel IDs (e.g. from Pusher) or slugs to the true user ID.
     */
    suspend fun migrateLegacyKeys() = withContext(Dispatchers.IO) {
        ensureMetadataSeeded()
        if (context?.prefs()?.getBoolean(AppConstants.NOTIFICATION_KEYS_MIGRATED, false) == true) {
            return@withContext
        }

        val allRows = notificationUsersDao.getAll()
        if (allRows.isEmpty()) {
            context?.prefs()?.edit()?.putBoolean(AppConstants.NOTIFICATION_KEYS_MIGRATED, true)?.apply()
            return@withContext
        }

        val follows = runCatching { localFollowChannelRepository?.get()?.loadFollows() }.getOrNull().orEmpty()
        val followUserIds = follows.mapNotNull { it.userId?.trim()?.takeIf(String::isNotBlank) }.toSet()

        // Rows whose key is already a known canonical follow userId don't need migration.
        val nonCanonicalRows = allRows.filter { it.channelId !in followUserIds }
        if (nonCanonicalRows.isEmpty()) {
            context?.prefs()?.edit()?.putBoolean(AppConstants.NOTIFICATION_KEYS_MIGRATED, true)?.apply()
            return@withContext
        }

        var changed = false
        val followsByLogin = follows.mapNotNull { f ->
            f.userLogin?.trim()?.lowercase()?.takeIf(String::isNotBlank)?.let { it to f }
        }.toMap()

        val resolved = coroutineScope {
            nonCanonicalRows.map { item ->
                async {
                    val key = item.channelId.trim()
                    val localMatch = followsByLogin[key.lowercase()]
                    val canonical = if (!localMatch?.userId.isNullOrBlank()) {
                        localMatch.userId
                    } else {
                        resolutionSemaphore.withPermit {
                            runCatching { kickRepository.getChannel(key, prefetchBadgeCatalog = false) }.getOrNull()
                                ?.let { ch ->
                                    val trueUserId = ch.userId?.toString() ?: ch.user?.id?.toString() ?: ch.id?.toString()
                                    if (!trueUserId.isNullOrBlank() && !trueUserId.equals(key, ignoreCase = true)) {
                                        trueUserId
                                    } else null
                                }
                        }
                    }
                    item to canonical
                }
            }.awaitAll()
        }

        for ((item, canonicalId) in resolved) {
            if (!canonicalId.isNullOrBlank() && !canonicalId.equals(item.channelId.trim(), ignoreCase = true)) {
                Log.i(TAG, "cleaning up legacy notification row ${item.channelId} and re-keying to user ID $canonicalId")
                notificationUsersDao.rekey(item, NotificationUser(canonicalId))
                changed = true
            }
        }

        context?.prefs()?.edit()?.putBoolean(AppConstants.NOTIFICATION_KEYS_MIGRATED, true)?.apply()

        if (changed) {
            runCatching { fcmSyncManager.get().syncSubscriptions() }
        }
    }

    companion object {
        private const val TAG = "NotificationUsers"

        /** Concurrent channel lookups when bulk-enable must resolve login-only entries. */
        private val resolutionSemaphore = Semaphore(8)

        private val channelAliases = java.util.concurrent.ConcurrentHashMap<String, Set<String>>()

        fun getKnownAliases(key: String): Set<String> {
            val trimmed = key.trim()
            return channelAliases[trimmed] ?: channelAliases[trimmed.lowercase()] ?: emptySet()
        }

        fun rememberChannelAliases(canonicalId: String, aliases: Collection<String>) {
            val cleaned = aliases.mapNotNull { it.trim().takeIf(String::isNotBlank) }.toSet()
            if (cleaned.isNotEmpty()) {
                val fullSet = (channelAliases[canonicalId].orEmpty() + cleaned + canonicalId)
                channelAliases[canonicalId] = fullSet
                fullSet.forEach { alias ->
                    channelAliases[alias] = fullSet
                    channelAliases[alias.lowercase()] = fullSet
                }
            }
        }
    }
}
