package com.xtrakick.app.util

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.util.NetworkUtils.useCancellable
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FcmSyncManager @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val notificationUsersDao: NotificationUsersDao,
    private val localFollowChannelRepository: LocalFollowChannelRepository? = null,
    okHttpClient: OkHttpClient = OkHttpClient(),
) {

    private val subscriptionMutex = Mutex()
    private val subscriptionClient by lazy {
        okHttpClient.newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    companion object {
        private const val FCM_LAST_SYNCED_SIGNATURE = "fcm_last_synced_signature_v1"
    }

    @Suppress("DEPRECATION")
    suspend fun syncSubscriptions(tokenOverride: String? = null): Boolean = withContext(Dispatchers.IO) {
        subscriptionMutex.withLock {
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
                allChannelIds.addAll(NotificationUsersRepository.getKnownAliases(row))
            }

            val currentSignature = "$token:$kickUserId:${allChannelIds.sorted().joinToString(",")}"
            val lastSyncedSignature = context.prefs().getString(FCM_LAST_SYNCED_SIGNATURE, null)
            if (tokenOverride == null && currentSignature == lastSyncedSignature) {
                return@withContext true
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

            val ok = postSubscriptionRequest(url, bodyBytes, headers)
            if (ok) context.prefs().edit().putString(FCM_LAST_SYNCED_SIGNATURE, currentSignature).apply()
            ok
        }
    }

    @Suppress("DEPRECATION")
    suspend fun unsubscribe(tokenOverride: String? = null): Boolean = withContext(Dispatchers.IO) {
        subscriptionMutex.withLock {
            if (BuildConfig.DEBUG) return@withContext false
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

            val ok = postSubscriptionRequest(url, bodyBytes, headers)
            if (ok) context.prefs().edit().remove(FCM_LAST_SYNCED_SIGNATURE).apply()
            ok
        }
    }

    internal suspend fun postSubscriptionRequest(url: String, body: ByteArray, headers: Map<String, String>): Boolean {
        return try {
            val request = Request.Builder().url(url)
                .header("Content-Type", "application/json")
                .post(body.toRequestBody("application/json".toMediaType()))
                .apply { headers.forEach { (name, value) -> header(name, value) } }
                .build()
            subscriptionClient.newCall(request).useCancellable { it.isSuccessful }
        } catch (_: Exception) {
            currentCoroutineContext().ensureActive()
            false
        }
    }
}
