package com.xtrakick.app.util

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import dagger.Lazy
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FcmSyncManager @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val notificationUsersDao: NotificationUsersDao,
    private val localFollowChannelRepository: LocalFollowChannelRepository? = null,
    private val kickRepository: Lazy<KickRepository>? = null,
) {

    companion object {
        private const val FCM_LAST_SYNCED_SIGNATURE = "fcm_last_synced_signature_v1"
        private val channelInfoCache = java.util.concurrent.ConcurrentHashMap<String, List<String>>()
    }

    suspend fun syncSubscriptions(tokenOverride: String? = null): Boolean = withContext(Dispatchers.IO) {
        // Debug builds (.test) are blocked by the Firebase API-key allowlist and must stay
        // out of the prod subscription store until a staging backend exists.
        if (BuildConfig.DEBUG) return@withContext false
        val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
        if (baseUrl.isEmpty() || !baseUrl.startsWith("https://")) return@withContext false

        val token = tokenOverride ?: runCatching {
            FirebaseMessaging.getInstance().token.await()
        }.getOrNull() ?: return@withContext false

        val rawChannels = notificationUsersDao.getAll().map { it.channelId.trim() }.filter { it.isNotBlank() }
        val kickUserId = context.prefs().getString(AppConstants.USER_ID, null).orEmpty()
        val currentSignature = "$token:$kickUserId:${rawChannels.sorted().joinToString(",")}"
        val lastSyncedSignature = context.prefs().getString(FCM_LAST_SYNCED_SIGNATURE, null)
        if (tokenOverride == null && currentSignature == lastSyncedSignature) {
            return@withContext true
        }

        val allChannelIds = LinkedHashSet<String>(rawChannels)
        val follows = runCatching { localFollowChannelRepository?.loadFollows() }.getOrNull().orEmpty()
        val followsByUserId = follows.mapNotNull { f -> f.userId?.takeIf(String::isNotBlank)?.let { it to f } }.toMap()
        val followsByLogin = follows.mapNotNull { f -> f.userLogin?.trim()?.lowercase()?.takeIf(String::isNotBlank)?.let { it to f } }.toMap()
        for (row in rawChannels) {
            val follow = followsByUserId[row] ?: followsByLogin[row.lowercase()]
            if (follow != null) {
                follow.userId?.takeIf(String::isNotBlank)?.let(allChannelIds::add)
                follow.userLogin?.takeIf(String::isNotBlank)?.let { allChannelIds.add(it.lowercase()) }
            }
        }
        // Kick Pusher live events arrive on channel.<channel.id>, while the DB stores the
        // canonical broadcaster userId. Resolve both so the backend subscribes to the
        // correct Pusher channel. Best-effort: raw keys are always kept.
        runCatching {
            val repo = kickRepository?.get() ?: return@runCatching
            for (key in allChannelIds.toList()) {
                val cached = channelInfoCache[key]
                if (cached != null) {
                    allChannelIds.addAll(cached)
                    continue
                }
                val channel = runCatching {
                    repo.getChannel(key, prefetchBadgeCatalog = false)
                }.getOrNull() ?: continue
                val aliases = listOfNotNull(
                    channel.id?.toString(),
                    channel.userId?.toString(),
                    channel.user?.id?.toString(),
                    channel.slug?.trim(),
                    channel.slug?.trim()?.lowercase(),
                    channel.user?.username?.trim(),
                    channel.user?.username?.trim()?.lowercase(),
                ).filter { it.isNotBlank() }
                channelInfoCache[key] = aliases
                allChannelIds.addAll(aliases)
            }
        }

        val jsonBody = JSONObject().apply {
            put("token", token)
            if (kickUserId.isNotBlank()) {
                put("kick_user_id", kickUserId)
            }
            put("channel_ids", JSONArray(allChannelIds.toList()))
        }.toString()

        val url = "$baseUrl/v1/fcm/subscribe"
        val bodyBytes = jsonBody.toByteArray(Charsets.UTF_8)
        val headers = BackendRequestSigner.sign(
            secret = BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET,
            method = "POST",
            url = url,
            body = bodyBytes,
        )

        return@withContext runCatching {
            val connection = URL(url).openConnection() as HttpURLConnection
            try {
                connection.requestMethod = "POST"
                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/json")
                headers.forEach { (name, value) -> connection.setRequestProperty(name, value) }
                connection.outputStream.use { it.write(bodyBytes) }
                val ok = connection.responseCode in 200..299
                if (ok) {
                    context.prefs().edit().putString(FCM_LAST_SYNCED_SIGNATURE, currentSignature).apply()
                }
                ok
            } finally {
                connection.disconnect()
            }
        }.getOrDefault(false)
    }

    suspend fun unsubscribe(tokenOverride: String? = null): Boolean = withContext(Dispatchers.IO) {
        val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
        if (baseUrl.isEmpty() || !baseUrl.startsWith("https://")) return@withContext false

        val token = tokenOverride ?: runCatching {
            FirebaseMessaging.getInstance().token.await()
        }.getOrNull() ?: return@withContext false

        val jsonBody = JSONObject().apply {
            put("token", token)
        }.toString()

        val url = "$baseUrl/v1/fcm/unsubscribe"
        val bodyBytes = jsonBody.toByteArray(Charsets.UTF_8)
        val headers = BackendRequestSigner.sign(
            secret = BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET,
            method = "POST",
            url = url,
            body = bodyBytes,
        )

        return@withContext runCatching {
            val connection = URL(url).openConnection() as HttpURLConnection
            try {
                connection.requestMethod = "POST"
                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/json")
                headers.forEach { (name, value) -> connection.setRequestProperty(name, value) }
                connection.outputStream.use { it.write(bodyBytes) }
                val ok = connection.responseCode in 200..299
                if (ok) {
                    context.prefs().edit().remove(FCM_LAST_SYNCED_SIGNATURE).apply()
                }
                ok
            } finally {
                connection.disconnect()
            }
        }.getOrDefault(false)
    }
}
