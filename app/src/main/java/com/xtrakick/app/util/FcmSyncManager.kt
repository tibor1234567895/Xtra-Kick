package com.xtrakick.app.util

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.db.NotificationUsersDao
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
) {

    suspend fun syncSubscriptions(tokenOverride: String? = null): Boolean = withContext(Dispatchers.IO) {
        val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
        if (baseUrl.isEmpty() || !baseUrl.startsWith("https://")) return@withContext false

        val token = tokenOverride ?: runCatching {
            FirebaseMessaging.getInstance().token.await()
        }.getOrNull() ?: return@withContext false

        val followedChannels = notificationUsersDao.getAll().map { it.channelId }
        val kickUserId = context.prefs().getString(AppConstants.USER_ID, null)

        val jsonBody = JSONObject().apply {
            put("token", token)
            if (!kickUserId.isNullOrBlank()) {
                put("kick_user_id", kickUserId)
            }
            put("channel_ids", JSONArray(followedChannels))
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
                connection.responseCode in 200..299
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
                connection.responseCode in 200..299
            } finally {
                connection.disconnect()
            }
        }.getOrDefault(false)
    }
}
