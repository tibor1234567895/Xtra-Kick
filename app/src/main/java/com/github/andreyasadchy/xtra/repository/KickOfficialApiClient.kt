package com.github.andreyasadchy.xtra.repository

import android.content.Context
import com.github.andreyasadchy.xtra.model.kick.KickCursorPagination
import com.github.andreyasadchy.xtra.model.kick.KickEventSubscription
import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionCreateResult
import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionRequestItem
import com.github.andreyasadchy.xtra.model.kick.KickOfficialCategory
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChannel
import com.github.andreyasadchy.xtra.model.kick.KickOfficialGetLivestreamsRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialLivestream
import com.github.andreyasadchy.xtra.model.kick.KickOfficialLivestreamStats
import com.github.andreyasadchy.xtra.model.kick.KickOfficialModerationBanRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialModerationDeleteBanRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialPostChatMessageRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialReward
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardCreateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardUpdateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialTokenIntrospect
import com.github.andreyasadchy.xtra.model.kick.KickOfficialUpdateChannelRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialUser
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionActionFailure
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionBulkActionResponse
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionsPage
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionsResponse
import com.github.andreyasadchy.xtra.util.KickOAuthConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.decodeFromJsonElement
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KickOfficialApiClient @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {
    companion object {
        private const val BASE_URL = "https://api.kick.com/public/v1"
    }

    suspend fun getUsers(accessToken: String, ids: List<Long>? = null): List<KickOfficialUser> {
        return requestData(
            path = "/users",
            accessToken = accessToken,
            query = buildMap {
                ids?.takeIf { it.isNotEmpty() }?.let { put("id", it) }
            }
        )
    }

    suspend fun introspectToken(accessToken: String): KickOfficialTokenIntrospect {
        return requestData(
            path = "/token/introspect",
            accessToken = accessToken,
            method = "POST",
            body = ""
        )
    }

    suspend fun getChannels(
        accessToken: String,
        broadcasterUserIds: List<Long>? = null,
        slugs: List<String>? = null,
    ): List<KickOfficialChannel> {
        return requestData(
            path = "/channels",
            accessToken = accessToken,
            query = buildMap {
                broadcasterUserIds?.takeIf { it.isNotEmpty() }?.let { put("broadcaster_user_id", it) }
                slugs?.takeIf { it.isNotEmpty() }?.let { put("slug", it) }
            }
        )
    }

    suspend fun updateChannel(accessToken: String, request: KickOfficialUpdateChannelRequest) {
        requestRaw(
            path = "/channels",
            accessToken = accessToken,
            method = "PATCH",
            body = json.encodeToString(request)
        )
    }

    suspend fun postChatMessage(accessToken: String, request: KickOfficialPostChatMessageRequest): JsonElement? {
        return requestElement(
            path = "/chat",
            accessToken = accessToken,
            method = "POST",
            body = json.encodeToString(request)
        )
    }

    suspend fun deleteChatMessage(accessToken: String, messageId: String) {
        requestRaw(
            path = "/chat/$messageId",
            accessToken = accessToken,
            method = "DELETE",
        )
    }

    suspend fun postModerationBan(accessToken: String, request: KickOfficialModerationBanRequest) {
        requestRaw(
            path = "/moderation/bans",
            accessToken = accessToken,
            method = "POST",
            body = json.encodeToString(request)
        )
    }

    suspend fun deleteModerationBan(accessToken: String, request: KickOfficialModerationDeleteBanRequest) {
        requestRaw(
            path = "/moderation/bans",
            accessToken = accessToken,
            method = "DELETE",
            body = json.encodeToString(request)
        )
    }

    suspend fun getLivestreams(accessToken: String, request: KickOfficialGetLivestreamsRequest): List<KickOfficialLivestream> {
        return requestData(
            path = "/livestreams",
            accessToken = accessToken,
            query = buildMap {
                request.broadcasterUserIds?.takeIf { it.isNotEmpty() }?.let { put("broadcaster_user_id", it) }
                request.category?.let { put("category", it) }
                request.language?.takeIf { it.isNotBlank() }?.let { put("language", it) }
                request.limit?.let { put("limit", it) }
                request.sort?.takeIf { it.isNotBlank() }?.let { put("sort", it) }
            }
        )
    }

    suspend fun getLivestreamStats(accessToken: String): KickOfficialLivestreamStats {
        return requestData(
            path = "/livestreams/stats",
            accessToken = accessToken,
        )
    }

    suspend fun getCategories(accessToken: String, query: String, page: Int = 1): List<KickOfficialCategory> {
        return requestData(
            path = "/categories",
            accessToken = accessToken,
            query = mapOf(
                "q" to query,
                "page" to page,
            )
        )
    }

    suspend fun getCategory(accessToken: String, categoryId: Long): KickOfficialCategory {
        return requestData(
            path = "/categories/$categoryId",
            accessToken = accessToken,
        )
    }

    suspend fun getEventSubscriptions(
        accessToken: String,
        broadcasterUserId: Long? = null,
    ): List<KickEventSubscription> {
        return requestData(
            path = "/events/subscriptions",
            accessToken = accessToken,
            query = buildMap {
                broadcasterUserId?.let { put("broadcaster_user_id", it) }
            }
        )
    }

    suspend fun createEventSubscriptions(
        accessToken: String,
        events: List<KickEventSubscriptionRequestItem>,
        broadcasterUserId: Long? = null,
        method: String = "webhook",
    ): List<KickEventSubscriptionCreateResult> {
        val body = json.encodeToString(
            buildJsonObject {
                broadcasterUserId?.let { put("broadcaster_user_id", JsonPrimitive(it)) }
                put("method", JsonPrimitive(method))
                put("events", buildJsonArray {
                    events.forEach { event ->
                        add(
                            buildJsonObject {
                                put("name", JsonPrimitive(event.name))
                                put("version", JsonPrimitive(event.version))
                            }
                        )
                    }
                })
            }
        )
        return requestData(
            path = "/events/subscriptions",
            accessToken = accessToken,
            method = "POST",
            body = body,
        )
    }

    suspend fun deleteEventSubscriptions(accessToken: String, ids: List<String>) {
        requestRaw(
            path = "/events/subscriptions",
            accessToken = accessToken,
            method = "DELETE",
            query = mapOf("id" to ids)
        )
    }

    suspend fun getChannelRewards(accessToken: String): List<KickOfficialReward> {
        return requestData(
            path = "/channels/rewards",
            accessToken = accessToken,
        )
    }

    suspend fun createChannelReward(accessToken: String, request: KickOfficialRewardCreateRequest): KickOfficialReward {
        return requestData(
            path = "/channels/rewards",
            accessToken = accessToken,
            method = "POST",
            body = json.encodeToString(request)
        )
    }

    suspend fun updateChannelReward(accessToken: String, rewardId: String, request: KickOfficialRewardUpdateRequest): KickOfficialReward {
        return requestData(
            path = "/channels/rewards/$rewardId",
            accessToken = accessToken,
            method = "PATCH",
            body = json.encodeToString(request)
        )
    }

    suspend fun deleteChannelReward(accessToken: String, rewardId: String) {
        requestRaw(
            path = "/channels/rewards/$rewardId",
            accessToken = accessToken,
            method = "DELETE"
        )
    }

    suspend fun getRewardRedemptions(
        accessToken: String,
        rewardId: String? = null,
        status: String? = null,
        ids: List<String>? = null,
        cursor: String? = null,
    ): KickRewardRedemptionsPage {
        val response = requestData<KickRewardRedemptionsResponse>(
            path = "/channels/rewards/redemptions",
            accessToken = accessToken,
            query = buildMap {
                rewardId?.takeIf { it.isNotBlank() }?.let { put("reward_id", it) }
                status?.takeIf { it.isNotBlank() }?.let { put("status", it) }
                ids?.takeIf { it.isNotEmpty() }?.let { put("id", it) }
                cursor?.takeIf { it.isNotBlank() }?.let { put("cursor", it) }
            },
            unwrapData = false,
        )
        return KickRewardRedemptionsPage(
            groups = response.data,
            nextCursor = response.pagination?.nextCursor
        )
    }

    suspend fun acceptRewardRedemptions(accessToken: String, ids: List<String>): List<KickRewardRedemptionActionFailure> {
        return bulkUpdateRewardRedemptions(accessToken, "accept", ids)
    }

    suspend fun rejectRewardRedemptions(accessToken: String, ids: List<String>): List<KickRewardRedemptionActionFailure> {
        return bulkUpdateRewardRedemptions(accessToken, "reject", ids)
    }

    private suspend fun bulkUpdateRewardRedemptions(
        accessToken: String,
        endpoint: String,
        ids: List<String>,
    ): List<KickRewardRedemptionActionFailure> {
        val response = requestData<KickRewardRedemptionBulkActionResponse>(
            path = "/channels/rewards/redemptions/$endpoint",
            accessToken = accessToken,
            method = "POST",
            body = json.encodeToString(buildJsonObject {
                put("ids", buildJsonArray {
                    ids.forEach { add(JsonPrimitive(it)) }
                })
            }),
            unwrapData = false,
        )
        return response.data
    }

    private suspend fun requestElement(
        path: String,
        accessToken: String,
        method: String = "GET",
        body: String? = null,
        query: Map<String, Any?>? = null,
    ): JsonElement? {
        val raw = requestRaw(
            path = path,
            accessToken = accessToken,
            method = method,
            body = body,
            query = query,
        )
        if (raw.isBlank()) {
            return null
        }
        return json.parseToJsonElement(raw)
    }

    private suspend inline fun <reified T> requestData(
        path: String,
        accessToken: String,
        method: String = "GET",
        body: String? = null,
        query: Map<String, Any?>? = null,
        unwrapData: Boolean = true,
    ): T {
        val raw = requestRaw(
            path = path,
            accessToken = accessToken,
            method = method,
            body = body,
            query = query,
        )
        if (raw.isBlank()) {
            throw IOException("Kick request returned an empty response for $path")
        }
        val root = json.parseToJsonElement(raw)
        val target = if (unwrapData && root is JsonObject && root["data"] != null) {
            root["data"] ?: root
        } else {
            root
        }
        return json.decodeFromJsonElement(target)
    }

    private suspend fun requestRaw(
        path: String,
        accessToken: String,
        method: String = "GET",
        body: String? = null,
        query: Map<String, Any?>? = null,
    ): String = withContext(Dispatchers.IO) {
        val url = buildUrl(path, query)
        val request = Request.Builder()
            .url(url)
            .header("Authorization", "Bearer $accessToken")
            .header("Accept", "application/json")
            .header("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            .apply {
                KickOAuthConfig.getClientId(context)?.takeIf { it.isNotBlank() }?.let {
                    header("Client-Id", it)
                }
                val requestBody = body?.toRequestBody("application/json".toMediaTypeOrNull())
                when (method.uppercase()) {
                    "GET" -> get()
                    "POST" -> post(requestBody ?: "".toRequestBody("application/json".toMediaTypeOrNull()))
                    "PATCH" -> patch(requestBody ?: "".toRequestBody("application/json".toMediaTypeOrNull()))
                    "DELETE" -> delete(requestBody)
                    else -> method(method.uppercase(), requestBody)
                }
                if (body != null) {
                    header("Content-Type", "application/json")
                }
            }
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            val responseBody = response.body.string()
            if (!response.isSuccessful) {
                val message = responseBody
                    .replace('\n', ' ')
                    .trim()
                    .take(300)
                throw IOException("Kick request failed (${response.code})${message.takeIf { it.isNotBlank() }?.let { ": $it" } ?: ""}")
            }
            responseBody
        }
    }

    private fun buildUrl(path: String, query: Map<String, Any?>?): String {
        val baseUrl = "$BASE_URL$path".toHttpUrlOrNull()
            ?: throw IOException("Invalid Kick URL path: $path")
        val builder = baseUrl.newBuilder()
        query.orEmpty().forEach { (key, value) ->
            when (value) {
                null -> Unit
                is Iterable<*> -> value.forEach { item ->
                    item?.toString()?.takeIf { it.isNotBlank() }?.let { builder.addQueryParameter(key, it) }
                }
                is Array<*> -> value.forEach { item ->
                    item?.toString()?.takeIf { it.isNotBlank() }?.let { builder.addQueryParameter(key, it) }
                }
                is JsonArray -> value.forEach { item ->
                    (item as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }?.let { builder.addQueryParameter(key, it) }
                }
                else -> value.toString().takeIf { it.isNotBlank() }?.let { builder.addQueryParameter(key, it) }
            }
        }
        return builder.build().toString()
    }
}
