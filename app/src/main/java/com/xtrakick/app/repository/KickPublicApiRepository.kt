package com.xtrakick.app.repository

import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import com.xtrakick.app.model.kick.api.channel.ChannelSearchResponse
import com.xtrakick.app.model.kick.api.chat.BadgesResponse
import com.xtrakick.app.model.kick.api.chat.ChatUsersResponse
import com.xtrakick.app.model.kick.api.chat.CheerEmotesResponse
import com.xtrakick.app.model.kick.api.chat.EmoteSetsResponse
import com.xtrakick.app.model.kick.api.chat.UserEmotesResponse
import com.xtrakick.app.model.kick.api.clip.ClipsResponse
import com.xtrakick.app.model.kick.api.follows.FollowsResponse
import com.xtrakick.app.model.kick.api.game.GamesResponse
import com.xtrakick.app.model.kick.api.livestream.LivestreamsResponse
import com.xtrakick.app.model.kick.api.livestream.UsersLivestreamsResponse
import com.xtrakick.app.model.kick.api.livestream.toLegacyLivestream
import com.xtrakick.app.model.kick.api.stream.StreamsResponse
import com.xtrakick.app.model.kick.api.user.UsersResponse
import com.xtrakick.app.model.kick.api.video.VideosResponse
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import okhttp3.Headers.Companion.toHeaders
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.UploadDataProviders
import java.io.IOException
import java.net.URLEncoder
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.suspendCoroutine

@Singleton
class KickPublicApiRepository @Inject constructor(
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {

    private suspend fun executePublicApiRaw(
        networkLibrary: String?,
        path: String,
        headers: Map<String, String>,
        method: String = "GET",
        query: String = "",
        bodyJson: String? = null,
    ): Pair<Int, String> = withContext(Dispatchers.IO) {
        val url = "https://api.kick.com$path$query"
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        setHttpMethod(method)
                        headers.forEach { addHeader(it.key, it.value) }
                        if (bodyJson != null) {
                            addHeader("Content-Type", "application/json")
                            val bytes = bodyJson.toByteArray(Charsets.UTF_8)
                            setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(bytes), cronetExecutor)
                        }
                    }.build().start()
                }
                Pair(response.first.httpStatusCode, String(response.second))
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                        setHttpMethod(method)
                        headers.forEach { addHeader(it.key, it.value) }
                        if (bodyJson != null) {
                            addHeader("Content-Type", "application/json")
                            val bytes = bodyJson.toByteArray(Charsets.UTF_8)
                            setUploadDataProvider(UploadDataProviders.create(bytes), cronetExecutor)
                        }
                    }.build().start()
                }
                Pair(response.first.httpStatusCode, String(response.second))
            }
            else -> {
                val requestBuilder = Request.Builder().url(url).headers(headers.toHeaders())
                if (bodyJson != null) {
                    requestBuilder.header("Content-Type", "application/json")
                    requestBuilder.method(method, bodyJson.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull()))
                } else if (method == "DELETE") {
                    requestBuilder.method("DELETE", null)
                } else if (method != "GET") {
                    requestBuilder.method(method, "".toRequestBody(null))
                }
                okHttpClient.newCall(requestBuilder.build()).execute().use { response ->
                    Pair(response.code, response.body.string())
                }
            }
        }
    }

    private suspend inline fun <reified T> executePublicApi(
        networkLibrary: String?,
        path: String,
        headers: Map<String, String>,
        method: String = "GET",
        query: String = "",
        bodyJson: String? = null,
    ): T {
        val (statusCode, rawBody) = executePublicApiRaw(networkLibrary, path, headers, method, query, bodyJson)
        if (statusCode !in 200..299) {
            if (statusCode == 401) {
                throw KickAuthRequestException.HttpFailure(statusCode)
            }
            throw IOException("Kick Public API request failed ($statusCode): $rawBody")
        }
        return json.decodeFromString<T>(rawBody)
    }

    private suspend fun executePublicApiMutation(
        networkLibrary: String?,
        path: String,
        headers: Map<String, String>,
        method: String = "POST",
        query: String = "",
        bodyJson: String? = null,
    ): String? {
        val (statusCode, rawBody) = executePublicApiRaw(networkLibrary, path, headers, method, query, bodyJson)
        return if (statusCode in 200..299) null else rawBody
    }

    private fun encodeParam(v: String): String = URLEncoder.encode(v, Charsets.UTF_8.name())

    suspend fun getGames(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, names: List<String>? = null): GamesResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("id=${encodeParam(it)}") }
            names?.forEach { add("name=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/games", headers, query = query)
    }

    suspend fun getTopGames(networkLibrary: String?, headers: Map<String, String>, limit: Int?, offset: String?): GamesResponse {
        val query = mutableMapOf<String, String>().apply {
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/games/top", headers, query = query)
    }

    suspend fun getStreams(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, logins: List<String>? = null, gameId: String? = null, languages: List<String>? = null, limit: Int? = null, offset: String? = null): StreamsResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("user_id=${encodeParam(it)}") }
            logins?.forEach { add("user_login=${encodeParam(it)}") }
            gameId?.let { add("game_id=${encodeParam(it)}") }
            languages?.forEach { add("language=${encodeParam(it)}") }
            limit?.let { add("first=${encodeParam(it.toString())}") }
            offset?.let { add("after=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/streams", headers, query = query)
    }

    suspend fun getLivestreams(networkLibrary: String?, headers: Map<String, String>, broadcasterUserIds: List<String>? = null): LivestreamsResponse {
        val query = broadcasterUserIds.orEmpty()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .joinToString("&") { "user_id=${encodeParam(it)}" }
            .takeIf { it.isNotEmpty() }
            ?.let { "?$it" }
            .orEmpty()
        val payload: UsersLivestreamsResponse = executePublicApi(networkLibrary, "/public/v1/users/livestreams", headers, query = query)
        return LivestreamsResponse(
            data = payload.data.map { it.toLegacyLivestream() },
            message = payload.message,
        )
    }

    suspend fun getFollowedStreams(networkLibrary: String?, headers: Map<String, String>, userId: String?, limit: Int?, offset: String?): StreamsResponse {
        val query = mutableMapOf<String, String>().apply {
            userId?.let { put("user_id", it) }
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/channels/followed", headers, query = query)
    }

    suspend fun getClips(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, channelId: String? = null, gameId: String? = null, startedAt: String? = null, endedAt: String? = null, limit: Int? = null, offset: String? = null): ClipsResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("id=${encodeParam(it)}") }
            channelId?.let { add("broadcaster_id=${encodeParam(it)}") }
            gameId?.let { add("game_id=${encodeParam(it)}") }
            startedAt?.let { add("started_at=${encodeParam(it)}") }
            endedAt?.let { add("ended_at=${encodeParam(it)}") }
            limit?.let { add("first=${encodeParam(it.toString())}") }
            offset?.let { add("after=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/clips", headers, query = query)
    }

    suspend fun getVideos(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, gameId: String? = null, channelId: String? = null, period: String? = null, broadcastType: String? = null, sort: String? = null, language: String? = null, limit: Int? = null, offset: String? = null): VideosResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("id=${encodeParam(it)}") }
            gameId?.let { add("game_id=${encodeParam(it)}") }
            channelId?.let { add("broadcaster_id=${encodeParam(it)}") }
            period?.let { add("period=${encodeParam(it)}") }
            broadcastType?.let { add("type=${encodeParam(it)}") }
            sort?.let { add("sort=${encodeParam(it)}") }
            language?.let { add("language=${encodeParam(it)}") }
            limit?.let { add("first=${encodeParam(it.toString())}") }
            offset?.let { add("after=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/videos", headers, query = query)
    }

    suspend fun getUsers(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, logins: List<String>? = null): UsersResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("id=${encodeParam(it)}") }
            logins?.forEach { add("login=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/users", headers, query = query)
    }

    suspend fun getSearchGames(networkLibrary: String?, headers: Map<String, String>, query: String?, limit: Int?, offset: String?): GamesResponse {
        val queryString = mutableMapOf<String, String>().apply {
            query?.let { put("query", it) }
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/categories", headers, query = queryString)
    }

    suspend fun getSearchChannels(networkLibrary: String?, headers: Map<String, String>, query: String?, limit: Int?, offset: String?, live: Boolean? = null): ChannelSearchResponse {
        val queryString = mutableMapOf<String, String>().apply {
            query?.let { put("query", it) }
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
            live?.let { put("live", it.toString()) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/channels", headers, query = queryString)
    }

    suspend fun getUserFollows(networkLibrary: String?, headers: Map<String, String>, userId: String?, targetId: String? = null, limit: Int? = null, offset: String? = null): FollowsResponse {
        val query = mutableMapOf<String, String>().apply {
            userId?.let { put("user_id", it) }
            targetId?.let { put("broadcaster_id", it) }
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/users/following", headers, query = query)
    }

    suspend fun getUserFollowers(networkLibrary: String?, headers: Map<String, String>, userId: String?, targetId: String? = null, limit: Int? = null, offset: String? = null): FollowsResponse {
        val query = mutableMapOf<String, String>().apply {
            userId?.let { put("broadcaster_id", it) }
            targetId?.let { put("user_id", it) }
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/channels/followers", headers, query = query)
    }

    suspend fun getUserEmotes(networkLibrary: String?, headers: Map<String, String>, userId: String?, channelId: String?, offset: String?): UserEmotesResponse {
        val query = mutableMapOf<String, String>().apply {
            userId?.let { put("user_id", it) }
            channelId?.let { put("broadcaster_id", it) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/emotes", headers, query = query)
    }

    suspend fun getEmotesFromSet(networkLibrary: String?, headers: Map<String, String>, setIds: List<String>): EmoteSetsResponse {
        val query = setIds.joinToString("&") { "set_id=${encodeParam(it)}" }
            .takeIf { it.isNotEmpty() }
            ?.let { "?$it" }
            .orEmpty()
        return executePublicApi(networkLibrary, "/public/v1/emotes/sets", headers, query = query)
    }

    suspend fun getGlobalBadges(networkLibrary: String?, headers: Map<String, String>): BadgesResponse {
        return executePublicApi(networkLibrary, "/public/v1/badges", headers)
    }

    suspend fun getChannelBadges(networkLibrary: String?, headers: Map<String, String>, userId: String?): BadgesResponse {
        val query = userId?.let { "?broadcaster_id=${encodeParam(it)}" } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/badges/channel", headers, query = query)
    }

    suspend fun getCheerEmotes(networkLibrary: String?, headers: Map<String, String>, userId: String?): CheerEmotesResponse {
        val query = userId?.let { "?broadcaster_id=${encodeParam(it)}" } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/bits/actions", headers, query = query)
    }

    suspend fun getChatters(networkLibrary: String?, headers: Map<String, String>, channelId: String?, userId: String?, limit: Int? = null, offset: String? = null): ChatUsersResponse {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            userId?.let { put("user_id", it) }
            limit?.let { put("first", it.toString()) }
            offset?.let { put("after", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApi(networkLibrary, "/public/v1/chat/users", headers, query = query)
    }

    suspend fun createEventSubSubscription(networkLibrary: String?, headers: Map<String, String>, userId: String?, channelId: String?, type: String?, sessionId: String?): String? {
        val body = buildJsonObject {
            put("type", type)
            put("version", "1")
            putJsonObject("condition") {
                put("broadcaster_user_id", channelId)
                put("user_id", userId)
            }
            putJsonObject("transport") {
                put("method", "websocket")
                put("session_id", sessionId)
            }
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/eventsub/subscriptions", headers, method = "POST", bodyJson = body)
    }

    suspend fun sendMessage(networkLibrary: String?, headers: Map<String, String>, userId: String?, channelId: String?, message: String?, replyId: String?): String? {
        val body = buildJsonObject {
            put("broadcaster_id", channelId)
            put("sender_id", userId)
            put("message", message)
            replyId?.let { put("reply_parent_message_id", it) }
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/chat/messages", headers, method = "POST", bodyJson = body)
    }

    suspend fun sendAnnouncement(networkLibrary: String?, headers: Map<String, String>, channelId: String?, userId: String?, message: String?, color: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            userId?.let { put("moderator_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        val body = buildJsonObject {
            put("message", message)
            color?.let { put("color", it) }
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/chat/announcements", headers, method = "POST", query = query, bodyJson = body)
    }

    suspend fun banUser(networkLibrary: String?, headers: Map<String, String>, channelId: String?, userId: String?, targetId: String?, duration: String? = null, reason: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            userId?.let { put("moderator_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        val body = buildJsonObject {
            putJsonObject("data") {
                duration?.toIntOrNull()?.let { put("duration", it) }
                put("reason", reason)
                put("user_id", targetId)
            }
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/moderation/bans", headers, method = "POST", query = query, bodyJson = body)
    }

    suspend fun unbanUser(networkLibrary: String?, headers: Map<String, String>, channelId: String?, userId: String?, targetId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            userId?.let { put("moderator_id", it) }
            targetId?.let { put("user_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/moderation/bans", headers, method = "DELETE", query = query)
    }

    suspend fun deleteMessages(networkLibrary: String?, headers: Map<String, String>, channelId: String?, userId: String?, messageId: String? = null): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            userId?.let { put("moderator_id", it) }
            messageId?.let { put("message_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/moderation/chat", headers, method = "DELETE", query = query)
    }

    suspend fun getChatColor(networkLibrary: String?, headers: Map<String, String>, userId: String?): String? {
        val query = userId?.let { "?user_id=${encodeParam(it)}" } ?: ""
        val (statusCode, rawBody) = executePublicApiRaw(networkLibrary, "/public/v1/chat/color", headers, query = query)
        return if (statusCode in 200..299) {
            runCatching {
                json.decodeFromString<JsonElement>(rawBody).jsonObject["data"]?.jsonArray?.firstOrNull()?.jsonObject?.get("color")?.jsonPrimitive?.contentOrNull
            }.getOrNull()
        } else {
            rawBody
        }
    }

    suspend fun updateChatColor(networkLibrary: String?, headers: Map<String, String>, userId: String?, color: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            userId?.let { put("user_id", it) }
            color?.let { put("color", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/chat/color", headers, method = "PUT", query = query)
    }

    suspend fun startCommercial(networkLibrary: String?, headers: Map<String, String>, channelId: String?, length: String?): String? {
        val body = buildJsonObject {
            put("broadcaster_id", channelId)
            put("length", length?.toIntOrNull())
        }.toString()
        val (statusCode, rawBody) = executePublicApiRaw(networkLibrary, "/public/v1/channels/commercial", headers, method = "POST", bodyJson = body)
        return if (statusCode in 200..299) {
            runCatching {
                json.decodeFromString<JsonElement>(rawBody).jsonObject["data"]?.jsonArray?.firstOrNull()?.jsonObject?.get("message")?.jsonPrimitive?.contentOrNull
            }.getOrNull()
        } else {
            rawBody
        }
    }

    suspend fun updateChatSettings(networkLibrary: String?, headers: Map<String, String>, channelId: String?, userId: String?, emote: Boolean? = null, followers: Boolean? = null, followersDuration: Int? = null, slow: Boolean? = null, slowDuration: Int? = null, subs: Boolean? = null, unique: Boolean? = null): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            userId?.let { put("moderator_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        val body = buildJsonObject {
            emote?.let { put("emote_mode", it) }
            followers?.let { put("follower_mode", it) }
            followersDuration?.let { put("follower_mode_duration", it) }
            slow?.let { put("slow_mode", it) }
            slowDuration?.let { put("slow_mode_wait_time", it) }
            subs?.let { put("subscriber_mode", it) }
            unique?.let { put("unique_chat_mode", it) }
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/chat/settings", headers, method = "PATCH", query = query, bodyJson = body)
    }

    suspend fun createStreamMarker(networkLibrary: String?, headers: Map<String, String>, channelId: String?, description: String?): String? {
        val body = buildJsonObject {
            put("user_id", channelId)
            description?.let { put("description", it) }
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/streams/markers", headers, method = "POST", bodyJson = body)
    }

    suspend fun addModerator(networkLibrary: String?, headers: Map<String, String>, channelId: String?, targetId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            targetId?.let { put("user_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/moderation/moderators", headers, method = "POST", query = query)
    }

    suspend fun removeModerator(networkLibrary: String?, headers: Map<String, String>, channelId: String?, targetId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            targetId?.let { put("user_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/moderation/moderators", headers, method = "DELETE", query = query)
    }

    suspend fun startRaid(networkLibrary: String?, headers: Map<String, String>, channelId: String?, targetId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("from_broadcaster_id", it) }
            targetId?.let { put("to_broadcaster_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/raids", headers, method = "POST", query = query)
    }

    suspend fun cancelRaid(networkLibrary: String?, headers: Map<String, String>, channelId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("from_broadcaster_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/raids", headers, method = "DELETE", query = query)
    }

    suspend fun addVip(networkLibrary: String?, headers: Map<String, String>, channelId: String?, targetId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            targetId?.let { put("user_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/channels/vips", headers, method = "POST", query = query)
    }

    suspend fun removeVip(networkLibrary: String?, headers: Map<String, String>, channelId: String?, targetId: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            channelId?.let { put("broadcaster_id", it) }
            targetId?.let { put("user_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        return executePublicApiMutation(networkLibrary, "/public/v1/channels/vips", headers, method = "DELETE", query = query)
    }

    suspend fun sendWhisper(networkLibrary: String?, headers: Map<String, String>, userId: String?, targetId: String?, message: String?): String? {
        val query = mutableMapOf<String, String>().apply {
            userId?.let { put("from_user_id", it) }
            targetId?.let { put("to_user_id", it) }
        }.takeIf { it.isNotEmpty() }?.let {
            it.map { entry -> "${entry.key}=${encodeParam(entry.value)}" }.joinToString("&", "?")
        } ?: ""
        val body = buildJsonObject {
            put("message", message)
        }.toString()
        return executePublicApiMutation(networkLibrary, "/public/v1/whispers", headers, method = "POST", query = query, bodyJson = body)
    }
}
