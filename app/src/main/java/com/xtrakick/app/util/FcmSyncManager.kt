package com.xtrakick.app.util

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.service.FcmDeliveryWorker
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
import okhttp3.Response
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
    suspend fun syncSubscriptions(scheduleRetry: Boolean = true): Boolean {
        // The debug package must stay out of the production subscription store.
        if (BuildConfig.DEBUG) return false
        val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
        if (!baseUrl.startsWith("https://")) return false
        return reconcileSubscriptions(baseUrl, scheduleRetry) {
            runCatching { FirebaseMessaging.getInstance().token.await() }.getOrElse {
                currentCoroutineContext().ensureActive()
                null
            }
        }
    }

    internal suspend fun reconcileSubscriptions(
        baseUrl: String,
        scheduleRetry: Boolean,
        resolveToken: suspend () -> String?,
    ): Boolean = withContext(Dispatchers.IO) {
        subscriptionMutex.withLock {
            val prefs = context.prefs()
            val notificationsEnabled = prefs.getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false)
            val token = resolveToken()
            if (token == null) {
                val lastSignature = prefs.getString(FCM_LAST_SYNCED_SIGNATURE, null)
                val needsRemoteSync = notificationsEnabled ||
                    (lastSignature != null && !lastSignature.endsWith(":unsubscribed"))
                if (scheduleRetry && needsRemoteSync) {
                    FcmDeliveryWorker.enqueueTokenSync(context, deduplicatePending = false)
                }
                return@withLock false
            }

            val rawChannels = if (notificationsEnabled) {
                notificationUsersDao.getAll().mapNotNull { it.channelId.trim().takeIf(String::isNotBlank) }
            } else {
                emptyList()
            }
            val subscribe = rawChannels.isNotEmpty()
            val kickUserId = if (subscribe) context.tokenPrefs().getString(AppConstants.USER_ID, null).orEmpty() else ""

            val allChannelIds = LinkedHashSet<String>(rawChannels)
            val follows = if (subscribe) {
                runCatching { localFollowChannelRepository?.loadFollows().orEmpty() }.getOrElse {
                    currentCoroutineContext().ensureActive()
                    emptyList()
                }
            } else {
                emptyList()
            }
            val followsByUserId = HashMap<String, LocalFollowChannel>()
            val followsByLogin = HashMap<String, LocalFollowChannel>()
            for (follow in follows) {
                follow.userId?.takeIf(String::isNotBlank)?.let { followsByUserId[it] = follow }
                follow.userLogin?.trim()?.lowercase()?.takeIf(String::isNotBlank)?.let { followsByLogin[it] = follow }
            }
            for (row in rawChannels) {
                val follow = followsByUserId[row] ?: followsByLogin[row.lowercase()]
                if (follow != null) {
                    follow.userId?.takeIf(String::isNotBlank)?.let(allChannelIds::add)
                    follow.userLogin?.takeIf(String::isNotBlank)?.let { allChannelIds.add(it.lowercase()) }
                }
                allChannelIds.addAll(NotificationUsersRepository.getKnownAliases(row))
            }

            val currentSignature = if (subscribe) {
                "v2:$token:$kickUserId:${allChannelIds.sorted().joinToString(",")}"
            } else {
                "v3:$token:unsubscribed"
            }
            if (currentSignature == prefs.getString(FCM_LAST_SYNCED_SIGNATURE, null)) {
                return@withLock true
            }

            val jsonBody = JSONObject().apply {
                put("token", token)
                if (subscribe) {
                    if (kickUserId.isNotBlank()) put("kick_user_id", kickUserId)
                    put("channel_ids", JSONArray(allChannelIds))
                }
            }.toString()

            val url = if (subscribe) "$baseUrl/v1/fcm/subscribe" else "$baseUrl/v1/fcm/unsubscribe"
            val bodyBytes = jsonBody.toByteArray(Charsets.UTF_8)
            val headers = BackendRequestSigner.sign(
                secret = BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET,
                method = "POST",
                url = url,
                body = bodyBytes,
            )

            var retry = true
            val ok = postSubscriptionRequest(url, bodyBytes, headers) { response ->
                retry = response.code == 429 || response.code in 500..599
                val complete = if (subscribe) isCompleteRegistration(response) else response.isSuccessful
                if (complete) {
                    prefs.edit().putString(FCM_LAST_SYNCED_SIGNATURE, currentSignature).apply()
                }
                response.isSuccessful
            }
            if (retry && scheduleRetry) FcmDeliveryWorker.enqueueTokenSync(context, deduplicatePending = false)
            ok
        }
    }

    internal suspend fun postSubscriptionRequest(
        url: String,
        body: ByteArray,
        headers: Map<String, String>,
        handleResponse: (Response) -> Boolean = { it.isSuccessful },
    ): Boolean {
        return try {
            val request = Request.Builder().url(url)
                .header("Content-Type", "application/json")
                .post(body.toRequestBody("application/json".toMediaType()))
                .apply { headers.forEach { (name, value) -> header(name, value) } }
                .build()
            subscriptionClient.newCall(request).useCancellable { handleResponse(it) }
        } catch (_: Exception) {
            currentCoroutineContext().ensureActive()
            false
        }
    }
}

internal fun isCompleteRegistration(response: Response): Boolean = response.isSuccessful && runCatching {
    JSONObject(response.peekBody(4096).string()).opt("complete") == true
}.getOrDefault(false)
