package com.github.andreyasadchy.xtra.repository

import android.content.Context
import android.util.Base64
import android.util.Log
import android.webkit.CookieManager
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChannelPointReward
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.PinnedGift
import com.github.andreyasadchy.xtra.model.chat.Poll
import com.github.andreyasadchy.xtra.model.chat.Prediction
import com.github.andreyasadchy.xtra.model.chat.Reply
import com.github.andreyasadchy.xtra.model.chat.RoomState
import com.github.andreyasadchy.xtra.model.kick.KickCategory
import com.github.andreyasadchy.xtra.model.kick.KickChannelResponse
import com.github.andreyasadchy.xtra.model.kick.KickChannelLivestream
import com.github.andreyasadchy.xtra.model.kick.KickLivestream
import com.github.andreyasadchy.xtra.model.kick.KickLivestreamsResponse
import com.github.andreyasadchy.xtra.model.kick.KickMessage
import com.github.andreyasadchy.xtra.model.kick.KickMessageBadge
import com.github.andreyasadchy.xtra.model.kick.KickMessageIdentity
import com.github.andreyasadchy.xtra.model.kick.KickMessageSender
import com.github.andreyasadchy.xtra.model.kick.KickMessagesData
import com.github.andreyasadchy.xtra.model.kick.KickMessagesEnvelope
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChannelFollowedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChannelSubscriptionEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChannelSubscriptionGiftsEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChatMessageSentEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialEventBadge
import com.github.andreyasadchy.xtra.model.kick.KickOfficialEventUser
import com.github.andreyasadchy.xtra.model.kick.KickOfficialKicksGiftedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialLivestreamMetadataUpdatedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialLivestreamStatusUpdatedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialModerationBannedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialPostChatMessageRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialReward
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardCreateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardRedemptionUpdatedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardUpdateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialModerationBanRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialModerationDeleteBanRequest
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionActionFailure
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionsPage
import com.github.andreyasadchy.xtra.model.kick.KickEventSubscription
import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionCreateResult
import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionRequestItem
import com.github.andreyasadchy.xtra.model.kick.KickSearchChannel
import com.github.andreyasadchy.xtra.model.kick.KickSubcategoriesResponse
import com.github.andreyasadchy.xtra.model.kick.KickSubcategory
import com.github.andreyasadchy.xtra.model.kick.KickThumbnail
import com.github.andreyasadchy.xtra.model.kick.KickWebsiteSearchResponse
import com.github.andreyasadchy.xtra.model.kick.auth.KickChatSendResponse
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendRefreshRequest
import com.github.andreyasadchy.xtra.model.ui.Clip
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.model.ui.Video
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickOAuthConfig
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import com.github.andreyasadchy.xtra.util.tokenPrefs
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.longOrNull
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.Collections
import java.io.IOException
import java.net.URLDecoder
import java.net.URLEncoder
import java.security.SecureRandom
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KickRepository @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
    private val authRepository: AuthRepository,
    private val kickOfficialApiClient: KickOfficialApiClient,
) {
    private data class KickClipPageResult(
        val clips: List<Clip>,
        val nextCursor: String? = null,
        val nextPageUrl: String? = null,
    )

    data class KickClipPage(
        val clips: List<Clip>,
        val nextCursor: String? = null,
    )

    data class KickRealtimeChannelPointsUpdate(
        val reason: String? = null,
        val points: Int? = null,
        val balance: Int? = null,
        val userId: String? = null,
        val channelId: String? = null,
    )

    data class KickVideoPage(
        val videos: List<Video>,
        val nextCursor: String? = null,
    )

    data class KickFollowedChannel(
        val login: String,
        val name: String? = null,
        val profilePicture: String? = null,
    )

    data class KickFollowedChannelsPage(
        val channels: List<KickFollowedChannel>,
        val nextCursor: String? = null,
    )

    data class KickUserCardDetails(
        val createdAt: String? = null,
        val followingSince: String? = null,
    )

    private enum class KickModerationType {
        NONE,
        DELETE_MESSAGE,
        CLEAR_CHAT,
        TIMEOUT,
        BAN,
        UNBAN,
        UNTIMEOUT,
    }

    private enum class KickBadgeSource(val priority: Int) {
        MESSAGE_DIRECT(4),
        CATALOG_CACHE(3),
    }

    private data class KickResolvedUser(
        val id: String? = null,
        val login: String? = null,
        val name: String? = null,
    )

    private val tag = "KickRepository"
    private val badgeDebugTag = "KickBadgeDebug"
    private val featureDebugTag = "KickFeatureDebug"
    private val pointsDebugTag = "KickPointsDebug"
    private val pinnedDebugTag = "KickPinnedDebug"
    private val emoteRegex = Regex("\\[emote:\\d+:([^\\]]+)]")
    private val kickLegacyBadgeFallbackBaseUrl = "https://www.kickdatabase.com/kickBadges/"
    private val kickBadgeCacheKey = "kick_badge_url_cache_v1"
    private val kickBadgeCacheTtlMs = 24L * 60L * 60L * 1000L
    private val kickBadgeCachePersistDebounceMs = 500L
    private val channelCacheTtlMs = 15_000L
    private val livestreamCacheTtlMs = 15_000L
    private val searchCacheTtlMs = 15_000L
    private val kickBadgeUrls = ConcurrentHashMap<String, String>()
    private val channelCache = ConcurrentHashMap<String, Pair<Long, KickChannelResponse>>()
    private val channelLivestreamCache = ConcurrentHashMap<String, Pair<Long, KickChannelLivestream?>>()
    private val websiteSearchCache = ConcurrentHashMap<String, Pair<Long, KickWebsiteSearchResponse>>()
    private val kickInlineBadgeSanitizedCache = ConcurrentHashMap<String, String>()
    private val kickBadgeCatalogRefreshAt = ConcurrentHashMap<String, Long>()
    private val kickBadgeCatalogRefreshInProgress = Collections.newSetFromMap(ConcurrentHashMap<String, Boolean>())
    private val channelPointRewardsCache = ConcurrentHashMap<String, Pair<Long, ChannelPointRewardsResult>>()
    private val kickBadgeSourceStats = ConcurrentHashMap<KickBadgeSource, Int>()
    private val kickChunkBodyCache = ConcurrentHashMap<String, String>()
    private val kickCanonicalBadgeTypes = listOf(
        "moderator",
        "vip",
        "verified",
        "founder",
        "subscriber",
        "sub_gifter",
        "staff",
        "broadcaster",
        "og",
    )
    private val kickChannelSpecificBadgeTypes = setOf("subscriber", "founder", "sub_gifter")
    @Volatile
    private var activeKickChatScopeId: String? = null
    private val channelRequestLock = Any()
    private val kickUlidRandom = SecureRandom()
    private val inFlightChannelRequests = mutableMapOf<String, CompletableDeferred<KickChannelResponse>>()
    private val channelLivestreamRequestLock = Any()
    private val inFlightChannelLivestreamRequests = mutableMapOf<String, CompletableDeferred<KickChannelLivestream?>>()
    private val badgeCacheScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val livestreamPrefetchScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val channelPointRewardsCacheTtlMs = 60_000L
    private val kickWebBadgeScrapeTtlMs = 6L * 60L * 60L * 1000L
    @Volatile
    private var badgePersistScheduled = false

    private fun isKickBadgeDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)
    }

    private fun isKickFeatureDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(C.DEBUG_KICK_FEATURE_LOGS, false)
    }

    private fun isKickRecentChatDebugEnabled(): Boolean {
        if (!BuildConfig.DEBUG) {
            return false
        }
        val prefs = context.prefs()
        return prefs.getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false) || prefs.getBoolean(C.DEBUG_KICK_CLIP_CHAT, false)
    }

    private fun isKickAuthDebugEnabled(): Boolean {
        return context.prefs().getBoolean(C.DEBUG_NETWORK_LOGS, false)
    }

    init {
        badgeCacheScope.launch {
            restoreKickBadgeCacheFromDisk()
        }
        maybeRefreshKickBadgeCatalogOnAppOpenInBackground()
    }

    private data class KickCurrentUser(
        val id: String?,
        val login: String?,
    )

    data class KickIdentity(
        val id: String? = null,
        val login: String? = null,
    )

    data class ChannelPointRewardsResult(
        val rewards: List<ChannelPointReward> = emptyList(),
        val available: Boolean = false,
        val balance: Int? = null,
    )

    data class PinnedGiftUpdate(
        val pinnedGift: PinnedGift? = null,
        val cleared: Boolean = false,
    )

    data class KickRealtimeParsedEvent(
        val chatMessage: ChatMessage,
        val clearTargetUserId: String? = null,
        val clearTargetUserLogin: String? = null,
        val clearTargetUserName: String? = null,
    )

    private fun ChannelPointRewardsResult.merge(other: ChannelPointRewardsResult): ChannelPointRewardsResult {
        val mergedRewards = LinkedHashMap<String, ChannelPointReward>()
        rewards.forEach { reward ->
            val key = reward.id ?: "${reward.title.orEmpty()}|${reward.cost ?: -1}"
            mergedRewards[key] = reward
        }
        other.rewards.forEach { reward ->
            val key = reward.id ?: "${reward.title.orEmpty()}|${reward.cost ?: -1}"
            mergedRewards[key] = reward
        }
        return ChannelPointRewardsResult(
            rewards = mergedRewards.values.sortedWith(compareBy<ChannelPointReward> { it.cost ?: Int.MAX_VALUE }.thenBy { it.title.orEmpty() }),
            available = available || other.available,
            balance = balance ?: other.balance,
        )
    }

    private suspend fun resolveKickCurrentUser(accessToken: String): KickCurrentUser? {
        val user = runCatching {
            kickOfficialApiClient.getUsers(accessToken).firstOrNull()
        }.getOrNull() ?: return null
        return KickCurrentUser(
            id = user.userId?.toString(),
            login = user.channelSlug ?: user.name,
        )
    }

    suspend fun ensureKickCurrentUserIdentity(): KickIdentity? {
        val prefs = context.tokenPrefs()
        val cachedId = prefs.getString(C.KICK_USER_ID, null)?.takeIf { it.isNotBlank() }
        val cachedLogin = prefs.getString(C.KICK_USER_LOGIN, null)?.takeIf { it.isNotBlank() }
        if (!cachedId.isNullOrBlank() || !cachedLogin.isNullOrBlank()) {
            return KickIdentity(
                id = cachedId,
                login = cachedLogin,
            )
        }
        val accessToken = prefs.getString(C.KICK_ACCESS_TOKEN, null)?.takeIf { it.isNotBlank() } ?: return null
        val resolved = resolveKickCurrentUser(accessToken) ?: return null
        if (!resolved.id.isNullOrBlank() || !resolved.login.isNullOrBlank()) {
            prefs.edit {
                resolved.id?.takeIf { it.isNotBlank() }?.let { putString(C.KICK_USER_ID, it) }
                resolved.login?.takeIf { it.isNotBlank() }?.let { putString(C.KICK_USER_LOGIN, it) }
            }
        }
        return KickIdentity(
            id = resolved.id?.takeIf { it.isNotBlank() },
            login = resolved.login?.takeIf { it.isNotBlank() },
        )
    }

    suspend fun getHelixHeadersWithRefresh(networkLibrary: String?, forceRefresh: Boolean = false): Map<String, String> {
        val headers = KickApiHelper.getHelixHeaders(context)
        if (!forceRefresh && !headers[C.HEADER_TOKEN].isNullOrBlank()) {
            return headers
        }

        val tokenPrefs = context.tokenPrefs()
        val refreshToken = tokenPrefs.getString(C.KICK_REFRESH_TOKEN, null)?.takeIf { it.isNotBlank() }
        if (refreshToken.isNullOrBlank()) {
            if (isKickAuthDebugEnabled()) {
                Log.i(tag, "Kick helix headers missing token and no refresh token available")
            }
            return headers
        }

        val backendBaseUrl = KickOAuthConfig.getBackendBaseUrl(context)
        if (backendBaseUrl.isNullOrBlank()) {
            if (isKickAuthDebugEnabled()) {
                Log.i(tag, "Kick helix headers missing token and backend base URL is unavailable")
            }
            return headers
        }

        return try {
            if (isKickAuthDebugEnabled()) {
                val reason = if (forceRefresh) "forced" else "missing_token"
                Log.i(tag, "Kick helix headers attempting refresh reason=$reason")
            }
            val now = System.currentTimeMillis() / 1000L
            val refresh = authRepository.refreshKickToken(
                networkLibrary = networkLibrary,
                backendBaseUrl = backendBaseUrl,
                request = KickBackendRefreshRequest(
                    refreshToken = refreshToken,
                ),
            )
            val newAccessToken = refresh.accessToken?.takeIf { it.isNotBlank() }
            if (newAccessToken.isNullOrBlank()) {
                if (isKickAuthDebugEnabled()) {
                    Log.w(tag, "Kick token refresh returned blank access token")
                }
                headers
            } else {
                tokenPrefs.edit {
                    putString(C.KICK_ACCESS_TOKEN, newAccessToken)
                    putString(C.KICK_REFRESH_TOKEN, refresh.refreshToken ?: refreshToken)
                    putLong(C.KICK_ACCESS_TOKEN_EXPIRES_AT, now + (refresh.expiresIn ?: 0L))
                    putString(C.KICK_TOKEN_TYPE, refresh.tokenType)
                }
                val refreshedHeaders = KickApiHelper.getHelixHeaders(context)
                if (isKickAuthDebugEnabled()) {
                    val outcome = if (refreshedHeaders[C.HEADER_TOKEN].isNullOrBlank()) "missing_token_after_refresh" else "ok"
                    Log.i(tag, "Kick token refresh completed for helix headers outcome=$outcome")
                }
                refreshedHeaders
            }
        } catch (e: Exception) {
            if (isKickAuthDebugEnabled()) {
                Log.w(tag, "Kick token refresh failed for helix headers: ${e.message}")
            }
            headers
        }
    }

    suspend fun getLivestreams(
        page: Int,
        limit: Int,
        sort: String? = null,
        subcategory: String? = null,
    ): KickLivestreamsResponse {
        val query = mutableMapOf<String, String>().apply {
            put("page", page.toString())
            put("limit", limit.toString())
            sort?.takeIf { it.isNotBlank() }?.let { put("sort", it) }
            subcategory?.takeIf { it.isNotBlank() }?.let { put("subcategory", it) }
        }
        return get("https://kick.com/stream/livestreams/en${encodeQuery(query)}")
    }

    suspend fun getSubcategories(page: Int, limit: Int): KickSubcategoriesResponse {
        return get("https://kick.com/api/v1/subcategories${encodeQuery(mapOf("page" to page.toString(), "limit" to limit.toString()))}")
    }

    suspend fun searchWebsite(query: String): KickWebsiteSearchResponse {
        val normalizedQuery = query.trim()
        val cacheKey = normalizedQuery.lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        websiteSearchCache[cacheKey]?.let { (cachedAt, cachedResponse) ->
            if (now - cachedAt <= searchCacheTtlMs) {
                return cachedResponse
            }
        }
        return get<KickWebsiteSearchResponse>(
            url = KickWebsiteSearchRequest.buildUrl(normalizedQuery),
            isKickWeb = true
        ).also { response ->
            websiteSearchCache[cacheKey] = System.currentTimeMillis() to response
        }
    }

    suspend fun getFollowedChannelsWebPage(cursor: String? = null): KickFollowedChannelsPage = withContext(Dispatchers.IO) {
        val cookieHeader = getKickCookieHeader()
            ?: throw IOException("missing kick web cookies")
        val url = buildString {
            append("https://kick.com/api/v2/channels/followed-page")
            if (!cursor.isNullOrBlank()) {
                append("?cursor=")
                append(urlEncode(cursor))
            }
        }
        val requestBuilder = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            .header("Origin", "https://kick.com")
            .header("Referer", "https://kick.com/following/channels")
            .header("Accept", "application/json, text/plain, */*")
            .header("x-app-platform", "web")
            .header("x-kick-platform", "web")
            .header("Cookie", cookieHeader)
        extractKickWebAuthToken(cookieHeader)?.let { authToken ->
            requestBuilder.header(C.HEADER_TOKEN, "Bearer $authToken")
        }
        extractKickXsrfToken(cookieHeader)?.let { xsrfToken ->
            requestBuilder.header("X-XSRF-TOKEN", xsrfToken)
        }
        Log.i(tag, "Kick follow import request url=$url cursor=${cursor ?: "<initial>"}")
        okHttpClient.newCall(
            requestBuilder.build()
        ).execute().use { response ->
            val body = response.body.string()
            if (!response.isSuccessful) {
                throw IOException("Kick followed request failed (${response.code}) for $url: ${body.take(200)}")
            }
            val root = json.parseToJsonElement(body) as? JsonObject
                ?: throw IOException("Invalid Kick followed response")
            val channels = root.arrayOrNull("channels").orEmpty().mapNotNull { element ->
                val item = element as? JsonObject ?: return@mapNotNull null
                val login = item.primitiveOrNull("channel_slug")?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
                KickFollowedChannel(
                    login = login,
                    name = item.primitiveOrNull("user_username")?.takeIf { it.isNotBlank() },
                    profilePicture = item.primitiveOrNull("profile_picture")?.takeIf { it.isNotBlank() },
                )
            }
            KickFollowedChannelsPage(
                channels = channels,
                nextCursor = root.primitiveOrNull("nextCursor"),
            ).also { page ->
                Log.i(
                    tag,
                    "Kick follow import response url=$url channels=${page.channels.size} nextCursor=${page.nextCursor ?: "<end>"}",
                )
            }
        }
    }

    suspend fun getFollowedChannelsWithStoredAuth(networkLibrary: String?): List<KickFollowedChannel> = withContext(Dispatchers.IO) {
        val authHeader = getHelixHeadersWithRefresh(networkLibrary)[C.HEADER_TOKEN]
            ?.takeIf { it.isNotBlank() }
            ?: throw IOException("missing kick auth token")
        val collected = LinkedHashMap<String, KickFollowedChannel>()
        var cursor: String? = null
        do {
            val page = getFollowedChannelsAuthorizedPage(authHeader = authHeader, cursor = cursor)
            page.channels.forEach { channel ->
                val key = channel.login.trim().lowercase(Locale.ROOT)
                if (key.isNotBlank()) {
                    collected[key] = channel
                }
            }
            val nextCursor = page.nextCursor?.takeIf { it.isNotBlank() }
            cursor = nextCursor?.takeIf { it != cursor }
        } while (!cursor.isNullOrBlank())
        collected.values.toList()
    }

    suspend fun getChannel(
        channelSlug: String,
        prefetchBadgeCatalog: Boolean = true,
    ): KickChannelResponse {
        val normalizedKey = channelSlug.trim().lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        channelCache[normalizedKey]?.let { (cachedAt, cachedChannel) ->
            if (now - cachedAt <= channelCacheTtlMs) {
                activeKickChatScopeId = cachedChannel.chatroom?.id?.toString()?.takeIf { it.isNotBlank() }
                return cachedChannel
            }
        }
        val deferred = CompletableDeferred<KickChannelResponse>()
        val inFlight = synchronized(channelRequestLock) {
            inFlightChannelRequests[normalizedKey]?.also { return@synchronized it }
                ?: deferred.also { inFlightChannelRequests[normalizedKey] = it }
        }
        if (inFlight !== deferred) {
            return inFlight.await()
        }
        try {
            val decoded = json.decodeFromString<KickChannelResponse>(
                getRaw("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}")
            )
            return decoded.also { channel ->
                activeKickChatScopeId = channel.chatroom?.id?.toString()?.takeIf { it.isNotBlank() }
                val cachedAt = System.currentTimeMillis()
                channelCache[normalizedKey] = cachedAt to channel
                channel.slug?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotBlank() }?.let { channelCache[it] = cachedAt to channel }
                channel.id?.toString()?.takeIf { it.isNotBlank() }?.let { channelCache[it] = cachedAt to channel }
                val livestream = channel.livestream
                channelLivestreamCache[normalizedKey] = cachedAt to livestream
                channel.slug?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotBlank() }?.let { channelLivestreamCache[it] = cachedAt to livestream }
                channel.id?.toString()?.takeIf { it.isNotBlank() }?.let { channelLivestreamCache[it] = cachedAt to livestream }
                val changed = cacheKickBadgeUrls(channel)
                if (changed) {
                    schedulePersistBadgeCache()
                }
                if (prefetchBadgeCatalog) {
                    maybeRefreshKickBadgeCatalogInBackground(channel)
                }
                deferred.complete(channel)
            }
        } catch (t: Throwable) {
            deferred.completeExceptionally(t)
            throw t
        } finally {
            synchronized(channelRequestLock) {
                if (inFlightChannelRequests[normalizedKey] === deferred) {
                    inFlightChannelRequests.remove(normalizedKey)
                }
            }
        }
    }

    private fun getFollowedChannelsAuthorizedPage(authHeader: String, cursor: String?): KickFollowedChannelsPage {
        val url = buildString {
            append("https://kick.com/api/v2/channels/followed")
            if (!cursor.isNullOrBlank()) {
                append("?cursor=")
                append(urlEncode(cursor))
            }
        }
        val requestBuilder = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            .header("Origin", "https://kick.com")
            .header("Referer", "https://kick.com/")
            .header("Accept", "application/json, text/plain, */*")
            .header("x-kick-platform", "web")
            .header(C.HEADER_TOKEN, authHeader)
        return okHttpClient.newCall(requestBuilder.build()).execute().use { response ->
            val body = response.body.string()
            if (!response.isSuccessful) {
                throw IOException("Kick followed auth request failed (${response.code}) for $url: ${body.take(200)}")
            }
            val root = json.parseToJsonElement(body) as? JsonObject
                ?: throw IOException("Invalid Kick followed auth response")
            val channels = root.arrayOrNull("channels").orEmpty().mapNotNull { element ->
                val item = element as? JsonObject ?: return@mapNotNull null
                val login = item.primitiveOrNull("channel_slug")?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
                KickFollowedChannel(
                    login = login,
                    name = item.primitiveOrNull("user_username")?.takeIf { it.isNotBlank() },
                    profilePicture = item.primitiveOrNull("profile_picture")?.takeIf { it.isNotBlank() },
                )
            }
            KickFollowedChannelsPage(
                channels = channels,
                nextCursor = root.primitiveOrNull("nextCursor"),
            )
        }
    }

    suspend fun getUserCardDetails(
        channelSlug: String?,
        userSlug: String,
    ): KickUserCardDetails = withContext(Dispatchers.IO) {
        val normalizedUserSlug = userSlug.trim()
        if (normalizedUserSlug.isBlank()) return@withContext KickUserCardDetails()

        val createdAt = runCatching {
            val root = json.parseToJsonElement(
                getRaw("https://kick.com/api/v2/channels/${urlEncode(normalizedUserSlug)}", isKickWeb = true)
            ).jsonObject
            root.objOrNull("chatroom")?.firstPrimitiveOrNull("created_at", "createdAt")
                ?: root.objOrNull("user")?.firstPrimitiveOrNull("created_at", "createdAt")
                ?: root.firstPrimitiveOrNull("created_at", "createdAt")
        }.getOrNull()?.let(::normalizeDate)

        val followingSince = channelSlug
            ?.trim()
            ?.takeIf { it.isNotBlank() && !it.equals(normalizedUserSlug, true) }
            ?.let { normalizedChannelSlug ->
                runCatching {
                    val root = json.parseToJsonElement(
                        getRaw(
                            "https://kick.com/api/v2/channels/${urlEncode(normalizedChannelSlug)}/users/${urlEncode(normalizedUserSlug)}",
                            isKickWeb = true
                        )
                    ).jsonObject
                    root.firstPrimitiveOrNull("following_since", "followed_at", "followedAt")
                        ?: root.objOrNull("user")?.firstPrimitiveOrNull("following_since", "followed_at", "followedAt")
                }.getOrNull()?.let(::normalizeDate)
            }

        KickUserCardDetails(
            createdAt = createdAt,
            followingSince = followingSince
        )
    }

    suspend fun getChannelPointRewards(
        channelSlug: String?,
        channelId: String? = null,
        forceRefresh: Boolean = false,
    ): ChannelPointRewardsResult {
        val cacheKey = listOfNotNull(
            channelId?.trim()?.takeIf { it.isNotBlank() },
            channelSlug?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotBlank() }
        ).joinToString("|")
        if (cacheKey.isNotBlank() && !forceRefresh) {
            channelPointRewardsCache[cacheKey]?.let { (cachedAt, cached) ->
                if (System.currentTimeMillis() - cachedAt <= channelPointRewardsCacheTtlMs) {
                    return cached
                }
            }
        }
        val hasKickWebsiteSession = hasKickWebsiteSessionCookie()
        val normalizedChannelSlug = channelSlug?.trim()?.takeIf { it.isNotBlank() }
        val normalizedChannelId = channelId?.trim()?.takeIf { it.isNotBlank() }
        val candidates = buildList {
            normalizedChannelSlug?.let { value ->
                if (hasKickWebsiteSession) {
                    add("https://kick.com/api/v2/channels/${urlEncode(value)}/points")
                }
                add("https://kick.com/api/v2/channels/${urlEncode(value)}/rewards")
                add("https://kick.com/api/v1/channels/${urlEncode(value)}/rewards")
                add("https://kick.com/api/v2/channels/${urlEncode(value)}/community-points/rewards")
                add("https://kick.com/api/v1/channels/${urlEncode(value)}/community-points/rewards")
                if (hasKickWebsiteSession) {
                    add("https://kick.com/api/v2/channels/${urlEncode(value)}/me")
                }
            }
            normalizedChannelId?.let { value ->
                if (hasKickWebsiteSession && normalizedChannelSlug == null) {
                    add("https://kick.com/api/v2/channels/${urlEncode(value)}/points")
                }
                if (normalizedChannelSlug == null) {
                    add("https://kick.com/api/v2/channels/${urlEncode(value)}/rewards")
                }
                add("https://kick.com/api/v2/channels/${urlEncode(value)}/community-points/rewards")
                add("https://kick.com/api/v1/channels/${urlEncode(value)}/community-points/rewards")
                if (hasKickWebsiteSession && normalizedChannelSlug == null) {
                    add("https://kick.com/api/v2/channels/${urlEncode(value)}/me")
                }
            }
        }
        Log.i(
            pointsDebugTag,
            "channel points fetch started slug=${normalizedChannelSlug ?: "<none>"} id=${normalizedChannelId ?: "<none>"} websiteSession=$hasKickWebsiteSession candidates=${candidates.size}",
        )
        var best = ChannelPointRewardsResult()
        for (url in candidates) {
            Log.i(pointsDebugTag, "channel points trying url=$url")
            val rawResult = runCatching {
                getRaw(url, isKickWeb = true)
            }
            val raw = rawResult.getOrNull()
            if (raw == null) {
                Log.i(pointsDebugTag, "channel points request failed url=$url error=${rawResult.exceptionOrNull()?.message ?: "unknown"}")
                if (isKickFeatureDebugEnabled()) {
                    Log.d(
                        pointsDebugTag,
                        "rewards url=$url failed=${rawResult.exceptionOrNull()?.message ?: "unknown"}"
                    )
                }
                continue
            }
            val trimmed = raw.trimStart()
            if (trimmed.startsWith("<!DOCTYPE html", ignoreCase = true) || trimmed.startsWith("<html", ignoreCase = true)) {
                if (isKickFeatureDebugEnabled()) {
                    Log.d(pointsDebugTag, "rewards url=$url ignored=html-shell")
                }
                continue
            }
            val root = runCatching { json.parseToJsonElement(raw) }.getOrNull()
            val result = root?.let(::parseChannelPointRewardsResponse)
                ?: runCatching { parseChannelPointRewardsResponse(raw) }.getOrNull()
                ?: continue
            Log.i(
                pointsDebugTag,
                "channel points parsed url=$url balance=${result.balance ?: "null"} rewards=${result.rewards.size} available=${result.available}",
            )
            if (isKickFeatureDebugEnabled()) {
                Log.d(
                    pointsDebugTag,
                    "rewards url=$url topLevel=${summarizeTopLevelKeys(root)} rewards=${result.rewards.size} available=${result.available} balance=${result.balance ?: "null"} balanceKeys=${findBalanceKeyPaths(root).take(6)} sample=${extractRewardsSample(root)} raw=${raw.compactDebugSnippet()}"
                )
            }
            best = best.merge(result)
            if (best.balance != null && (best.available || best.rewards.isNotEmpty())) {
                break
            }
        }
        return best.also { result ->
            Log.i(
                pointsDebugTag,
                "channel points fetch finished slug=${normalizedChannelSlug ?: "<none>"} id=${normalizedChannelId ?: "<none>"} balance=${result.balance ?: "null"} rewards=${result.rewards.size} available=${result.available}",
            )
            if (cacheKey.isNotBlank()) {
                channelPointRewardsCache[cacheKey] = System.currentTimeMillis() to result
            }
        }
    }

    suspend fun getKickEventSubscriptions(
        networkLibrary: String?,
        broadcasterUserId: Long? = null,
    ): List<KickEventSubscription> = withContext(Dispatchers.IO) {
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.getEventSubscriptions(accessToken, broadcasterUserId)
    }

    suspend fun createKickEventSubscriptions(
        networkLibrary: String?,
        events: List<KickEventSubscriptionRequestItem>,
        broadcasterUserId: Long? = null,
        method: String = "webhook",
    ): List<KickEventSubscriptionCreateResult> = withContext(Dispatchers.IO) {
        KickOfficialApiValidationUtils.validateEventSubscriptionCreate(events)
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.createEventSubscriptions(
            accessToken = accessToken,
            events = events,
            broadcasterUserId = broadcasterUserId,
            method = method,
        )
    }

    suspend fun deleteKickEventSubscriptions(
        networkLibrary: String?,
        ids: List<String>,
    ) = withContext(Dispatchers.IO) {
        val normalizedIds = ids.map(String::trim).filter(String::isNotBlank)
        require(normalizedIds.isNotEmpty()) { "Select at least one event subscription." }
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.deleteEventSubscriptions(accessToken, normalizedIds)
    }

    suspend fun deleteOfficialChatMessage(
        networkLibrary: String?,
        messageId: String,
    ) = withContext(Dispatchers.IO) {
        val normalizedMessageId = messageId.trim()
        require(normalizedMessageId.isNotBlank()) { "Message id is required." }
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.deleteChatMessage(accessToken, normalizedMessageId)
    }

    suspend fun banOfficialUser(
        networkLibrary: String?,
        broadcasterUserId: Long,
        targetUserId: Long,
        durationSeconds: Int? = null,
        reason: String? = null,
    ) = withContext(Dispatchers.IO) {
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.postModerationBan(
            accessToken = accessToken,
            request = KickOfficialModerationBanRequest(
                broadcasterUserId = broadcasterUserId,
                userId = targetUserId,
                duration = durationSeconds,
                reason = reason?.trim()?.takeIf { it.isNotBlank() },
            )
        )
    }

    suspend fun unbanOfficialUser(
        networkLibrary: String?,
        broadcasterUserId: Long,
        targetUserId: Long,
    ) = withContext(Dispatchers.IO) {
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.deleteModerationBan(
            accessToken = accessToken,
            request = KickOfficialModerationDeleteBanRequest(
                broadcasterUserId = broadcasterUserId,
                userId = targetUserId,
            )
        )
    }

    suspend fun getOfficialChannelRewards(networkLibrary: String?): List<KickOfficialReward> = withContext(Dispatchers.IO) {
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.getChannelRewards(accessToken)
    }

    suspend fun createOfficialChannelReward(
        networkLibrary: String?,
        input: KickOfficialRewardCreateRequest,
    ): KickOfficialReward = withContext(Dispatchers.IO) {
        KickOfficialApiValidationUtils.validateCreateReward(input)
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.createChannelReward(accessToken, input)
    }

    suspend fun updateOfficialChannelReward(
        networkLibrary: String?,
        rewardId: String,
        input: KickOfficialRewardUpdateRequest,
    ): KickOfficialReward = withContext(Dispatchers.IO) {
        KickOfficialApiValidationUtils.validateUpdateReward(input)
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.updateChannelReward(accessToken, rewardId, input)
    }

    suspend fun deleteOfficialChannelReward(
        networkLibrary: String?,
        rewardId: String,
    ) = withContext(Dispatchers.IO) {
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.deleteChannelReward(accessToken, rewardId)
    }

    suspend fun getOfficialRewardRedemptions(
        networkLibrary: String?,
        rewardId: String? = null,
        status: String? = null,
        ids: List<String>? = null,
        cursor: String? = null,
    ): KickRewardRedemptionsPage = withContext(Dispatchers.IO) {
        val normalizedIds = ids?.map(String::trim)?.filter(String::isNotBlank).orEmpty()
        require(normalizedIds.isEmpty() || (rewardId.isNullOrBlank() && status.isNullOrBlank() && cursor.isNullOrBlank())) {
            "Redemption id lookups cannot be combined with other filters."
        }
        status?.let {
            require(it in KickOfficialApiValidationUtils.REDEMPTION_STATUSES) {
                "Unsupported redemption status."
            }
        }
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.getRewardRedemptions(
            accessToken = accessToken,
            rewardId = rewardId,
            status = status,
            ids = normalizedIds,
            cursor = cursor,
        )
    }

    suspend fun acceptOfficialRewardRedemptions(
        networkLibrary: String?,
        ids: List<String>,
    ): List<KickRewardRedemptionActionFailure> = withContext(Dispatchers.IO) {
        val normalizedIds = ids.map(String::trim).filter(String::isNotBlank)
        KickOfficialApiValidationUtils.validateRedemptionActionIds(normalizedIds)
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.acceptRewardRedemptions(accessToken, normalizedIds)
    }

    suspend fun rejectOfficialRewardRedemptions(
        networkLibrary: String?,
        ids: List<String>,
    ): List<KickRewardRedemptionActionFailure> = withContext(Dispatchers.IO) {
        val normalizedIds = ids.map(String::trim).filter(String::isNotBlank)
        KickOfficialApiValidationUtils.validateRedemptionActionIds(normalizedIds)
        val accessToken = requireKickAccessToken(networkLibrary)
        kickOfficialApiClient.rejectRewardRedemptions(accessToken, normalizedIds)
    }

    fun parsePinnedGiftUpdate(eventName: String?, messageJson: String): PinnedGiftUpdate? {
        return KickFeatureParsingUtils.parsePinnedGiftUpdate(eventName, messageJson)
    }

    fun parseRealtimeRoomStateUpdate(eventName: String?, messageJson: String): RoomState? {
        val root = runCatching { json.parseToJsonElement(messageJson) }.getOrNull() ?: return null
        val roomState = parseKickRoomState(root) ?: return null
        if (roomState.emote == null &&
            roomState.followers == null &&
            roomState.unique == null &&
            roomState.slow == null &&
            roomState.subs == null
        ) {
            return null
        }
        if (isKickFeatureDebugEnabled()) {
            Log.d(featureDebugTag, "roomState realtime event=${eventName ?: "null"} parsed=${roomState.toDebugString()}")
        }
        return roomState
    }

    fun shouldRefreshRoomStateFromRealtimeEvent(eventName: String?, messageJson: String): Boolean {
        val normalizedEvent = eventName?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent.contains("chatroomupdatedevent")) {
            return true
        }
        val root = runCatching { json.parseToJsonElement(messageJson) }.getOrNull() ?: return false
        return findInterestingKeyPaths(
            root,
            setOf("slow", "follower", "follow", "subscriber", "sub", "emote", "unique", "r9k", "interval")
        ).isNotEmpty()
    }

    fun parseKickRealtimeEvent(eventName: String?, messageJson: String): KickRealtimeParsedEvent? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent.isBlank()) {
            return null
        }
        return when (normalizedEvent) {
            "chat.message.sent" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialChatMessageSentEvent>(messageJson) ?: return null
                val kickMessage = officialChatEventToKickMessage(event)
                KickRealtimeParsedEvent(
                    chatMessage = toChatMessage(kickMessage, eventName)
                )
            }
            "channel.subscription.gifts" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialChannelSubscriptionGiftsEvent>(messageJson) ?: return null
                val kickMessage = officialGiftEventToKickMessage(event)
                KickRealtimeParsedEvent(
                    chatMessage = toChatMessage(kickMessage, eventName)
                )
            }
            "channel.subscription.new" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialChannelSubscriptionEvent>(messageJson) ?: return null
                val subscriberName = event.subscriber?.username ?: event.subscriber?.channelSlug ?: return null
                val message = if ((event.duration ?: 0) > 1) {
                    context.getString(R.string.kick_subscribed_for_months_notice, subscriberName, event.duration ?: 1)
                } else {
                    context.getString(R.string.kick_subscribed_notice, subscriberName)
                }
                KickRealtimeParsedEvent(chatMessage = createKickNoticeMessage(message, event.createdAt))
            }
            "channel.subscription.renewal" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialChannelSubscriptionEvent>(messageJson) ?: return null
                val subscriberName = event.subscriber?.username ?: event.subscriber?.channelSlug ?: return null
                val message = if ((event.duration ?: 0) > 1) {
                    context.getString(R.string.kick_renewed_sub_for_months_notice, subscriberName, event.duration ?: 1)
                } else {
                    context.getString(R.string.kick_renewed_sub_notice, subscriberName)
                }
                KickRealtimeParsedEvent(chatMessage = createKickNoticeMessage(message, event.createdAt))
            }
            "channel.followed" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialChannelFollowedEvent>(messageJson) ?: return null
                val followerName = event.follower?.username ?: event.follower?.channelSlug ?: return null
                val broadcasterName = event.broadcaster?.username ?: event.broadcaster?.channelSlug ?: return null
                KickRealtimeParsedEvent(
                    chatMessage = createKickNoticeMessage(
                        context.getString(R.string.kick_followed_notice, followerName, broadcasterName),
                        event.createdAt,
                    )
                )
            }
            "moderation.banned" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialModerationBannedEvent>(messageJson) ?: return null
                val kickMessage = officialModerationEventToKickMessage(event)
                val targetUser = event.bannedUser
                KickRealtimeParsedEvent(
                    chatMessage = toChatMessage(kickMessage, eventName),
                    clearTargetUserId = targetUser?.userId?.toString(),
                    clearTargetUserLogin = targetUser?.channelSlug,
                    clearTargetUserName = targetUser?.username,
                )
            }
            "channel.reward.redemption.updated" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialRewardRedemptionUpdatedEvent>(messageJson) ?: return null
                val reward = event.reward ?: return null
                val redeemer = event.redeemer ?: return null
                KickRealtimeParsedEvent(
                    chatMessage = ChatMessage(
                        userId = redeemer.userId?.toString(),
                        userLogin = redeemer.channelSlug,
                        userName = redeemer.username,
                        message = event.redemption?.userInput?.takeIf { it.isNotBlank() },
                        reward = ChannelPointReward(
                            id = reward.id,
                            title = reward.title,
                            cost = reward.cost,
                            backgroundColor = reward.backgroundColor,
                            isEnabled = reward.isEnabled,
                            isUserInputRequired = reward.isUserInputRequired,
                            prompt = reward.description,
                        ),
                        timestamp = event.redemption?.redeemedAt?.let(KickApiHelper::parseIso8601DateUTC),
                        fullMsg = messageJson,
                    )
                )
            }
            "rewardredeemedevent" -> {
                val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
                val rewardTitle = root.primitiveOrNull("reward_title") ?: return null
                val userId = root.primitiveOrNull("user_id")
                val channelId = root.primitiveOrNull("channel_id")
                val username = root.primitiveOrNull("username")
                val userInput = root.primitiveOrNull("user_input")?.takeIf { it.isNotBlank() }
                val backgroundColor = root.primitiveOrNull("reward_background_color")
                val systemMessage = username?.let { context.getString(R.string.user_redeemed, it, rewardTitle) }
                    ?: context.getString(R.string.redeemed, rewardTitle)
                KickRealtimeParsedEvent(
                    chatMessage = ChatMessage(
                        id = buildString {
                            append("kick_reward_redeemed:")
                            append(userId ?: "unknown")
                            append(':')
                            append(rewardTitle)
                            append(':')
                            append(channelId ?: "unknown")
                        },
                        userId = userId,
                        userName = username,
                        message = userInput,
                        systemMsg = systemMessage,
                        msgId = "kick_usernotice",
                        reward = ChannelPointReward(
                            title = rewardTitle,
                            backgroundColor = backgroundColor,
                        ),
                        fullMsg = messageJson,
                    )
                )
            }
            "livestream.status.updated" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialLivestreamStatusUpdatedEvent>(messageJson) ?: return null
                val title = event.title ?: event.broadcaster?.username ?: return null
                val message = if (event.isLive == true) {
                    context.getString(R.string.kick_livestream_started_notice, title)
                } else {
                    context.getString(R.string.kick_livestream_ended_notice, title)
                }
                KickRealtimeParsedEvent(
                    chatMessage = createKickNoticeMessage(message, event.startedAt ?: event.endedAt)
                )
            }
            "livestream.metadata.updated" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialLivestreamMetadataUpdatedEvent>(messageJson) ?: return null
                val title = event.metadata?.title ?: event.broadcaster?.username ?: return null
                val category = event.metadata?.category?.name
                val message = if (!category.isNullOrBlank()) {
                    context.getString(R.string.kick_livestream_metadata_notice_with_category, title, category)
                } else {
                    context.getString(R.string.kick_livestream_metadata_notice, title)
                }
                KickRealtimeParsedEvent(chatMessage = createKickNoticeMessage(message))
            }
            "kicks.gifted" -> {
                val event = decodeKickOfficialRealtimePayload<KickOfficialKicksGiftedEvent>(messageJson) ?: return null
                val senderName = event.sender?.username ?: event.sender?.channelSlug ?: return null
                val amount = event.giftedAmount ?: event.amount ?: return null
                val recipientName = event.recipient?.username ?: event.recipient?.channelSlug
                val message = if (!recipientName.isNullOrBlank()) {
                    context.getString(R.string.kick_kicks_gifted_notice, senderName, amount, recipientName)
                } else {
                    context.getString(R.string.kick_kicks_gifted_notice_without_recipient, senderName, amount)
                }
                KickRealtimeParsedEvent(
                    chatMessage = createKickNoticeMessage(message, event.createdAt)
                )
            }
            "kicksgifted" -> {
                val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
                val sender = (root["sender"] as? JsonObject)
                val gift = (root["gift"] as? JsonObject)
                val senderName = sender?.primitiveOrNull("username")
                    ?: sender?.primitiveOrNull("channel_slug")
                    ?: sender?.primitiveOrNull("slug")
                    ?: return null
                val amount = gift?.firstLongOrNull("amount", "gift_amount", "kicks")?.toInt()
                    ?: root.firstLongOrNull("amount", "gifted_amount", "kicks")?.toInt()
                    ?: return null
                val message = context.getString(R.string.kick_kicks_gifted_notice_without_recipient, senderName, amount)
                KickRealtimeParsedEvent(chatMessage = createKickNoticeMessage(message, root.primitiveOrNull("created_at")))
            }
            "app\\events\\streamhostevent", "app\\events\\streamhostedevent" -> {
                val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
                val messageObject = root["message"] as? JsonObject
                val userObject = root["user"] as? JsonObject
                val hostUsername = root.primitiveOrNull("host_username")
                    ?: userObject?.primitiveOrNull("username")
                    ?: return null
                val viewerCount = root.firstLongOrNull("number_viewers", "numberOfViewers")
                    ?: messageObject?.firstLongOrNull("numberOfViewers", "number_viewers")
                val message = if (viewerCount != null && viewerCount > 0) {
                    "$hostUsername hosted with $viewerCount viewers"
                } else {
                    "$hostUsername hosted the stream"
                }
                KickRealtimeParsedEvent(
                    chatMessage = createKickNoticeMessage(
                        message,
                        root.primitiveOrNull("created_at") ?: messageObject?.primitiveOrNull("createdAt")
                    )
                )
            }
            else -> null
        }
    }

    fun parseKickRealtimeChannelPointsUpdate(eventName: String?, messageJson: String): KickRealtimeChannelPointsUpdate? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent != "pointsupdated") {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        return KickRealtimeChannelPointsUpdate(
            reason = root.primitiveOrNull("reason"),
            points = (root["points"] as? JsonPrimitive)?.intOrNull,
            balance = (root["balance"] as? JsonPrimitive)?.intOrNull,
            userId = root.primitiveOrNull("user_id"),
            channelId = root.primitiveOrNull("channel_id"),
        )
    }

    fun parseKickRealtimePredictionUpdate(eventName: String?, messageJson: String): Prediction? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent !in setOf(
                "predictioncreated",
                "predictionupdated",
                "predictionlocked",
                "predictionended",
                "predictionresolved",
                "predictioncancelled",
            )
        ) {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        val predictionObject = root.objOrNull("prediction") ?: root
        val outcomes = predictionObject.arrayOrNull("outcomes").orEmpty().mapNotNull { element ->
            val outcome = element as? JsonObject ?: return@mapNotNull null
            val title = outcome.primitiveOrNull("title")?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
            Prediction.PredictionOutcome(
                id = outcome.primitiveOrNull("id"),
                title = title,
                totalPoints = outcome.firstLongOrNull("total_points", "total_vote_amount")?.toInt(),
                totalUsers = outcome.firstLongOrNull("total_users", "vote_count")?.toInt(),
            )
        }
        val status = predictionObject.firstPrimitiveOrNull("status", "state") ?: when (normalizedEvent) {
            "predictionlocked" -> "LOCKED"
            "predictionresolved", "predictionended" -> "RESOLVED"
            "predictioncancelled" -> "CANCELED"
            else -> null
        }
        return Prediction(
            id = predictionObject.primitiveOrNull("id"),
            createdAt = predictionObject.primitiveOrNull("created_at")?.let(KickApiHelper::parseIso8601DateUTC),
            outcomes = outcomes,
            predictionWindowSeconds = predictionObject.firstLongOrNull("prediction_window_seconds", "duration")?.toInt(),
            status = status,
            title = predictionObject.primitiveOrNull("title"),
            winningOutcomeId = predictionObject.firstPrimitiveOrNull("winning_outcome_id", "winningOutcomeId"),
        )
    }

    fun parseKickRealtimePollUpdate(eventName: String?, messageJson: String): Poll? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent != "app\\events\\pollupdateevent") {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        val pollObject = root.objOrNull("poll") ?: root
        return parseKickPollObject(pollObject)
    }

    fun parseKickWebPollResponse(raw: String): Poll? {
        val root = runCatching { json.parseToJsonElement(raw).jsonObject }.getOrNull() ?: return null
        val data = root.objOrNull("data") ?: root
        val pollObject = data.objOrNull("poll") ?: return null
        return parseKickPollObject(pollObject)
    }

    suspend fun voteKickWebPoll(
        channelSlug: String,
        choiceId: Int,
    ): Poll? = withContext(Dispatchers.IO) {
        val normalizedChannelSlug = channelSlug.trim().takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("channel slug is required")
        val url = "https://kick.com/api/v2/channels/${urlEncode(normalizedChannelSlug)}/polls/vote"
        val body = buildJsonObject {
            put("id", JsonPrimitive(choiceId))
        }.toString()
        okHttpClient.newCall(
            createRequestBuilder(url, isKickWeb = true)
                .header("Content-Type", "application/json")
                .post(body.toRequestBody("application/json".toMediaTypeOrNull()))
                .build()
        ).execute().use { response ->
            val raw = response.body.string()
            if (!response.isSuccessful) {
                throw IOException("Kick poll vote failed (${response.code}) for $url: ${raw.take(200)}")
            }
            parseKickWebPollResponse(raw)
        }
    }

    private fun parseKickPollObject(pollObject: JsonObject): Poll {
        val choices = pollObject.arrayOrNull("options").orEmpty().mapNotNull { element ->
            val option = element as? JsonObject ?: return@mapNotNull null
            val title = option.firstPrimitiveOrNull("label", "title")?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
            Poll.PollChoice(
                id = option.firstLongOrNull("id", "option_id")?.toInt(),
                title = title,
                totalVotes = option.firstLongOrNull("votes", "total_votes", "vote_count")?.toInt(),
            )
        }
        val totalVotes = choices.sumOf { it.totalVotes ?: 0 }
        val remainingSeconds = pollObject.firstLongOrNull("remaining", "remaining_seconds")
        val status = when {
            !pollObject.primitiveOrNull("status").isNullOrBlank() -> pollObject.primitiveOrNull("status")
            remainingSeconds == null -> "ACTIVE"
            remainingSeconds <= 0L -> "COMPLETED"
            else -> "ACTIVE"
        }
        return Poll(
            id = pollObject.firstPrimitiveOrNull("poll_id", "id", "title"),
            title = pollObject.primitiveOrNull("title"),
            status = status,
            choices = choices,
            totalVotes = totalVotes,
            remainingMilliseconds = remainingSeconds?.times(1000)?.toInt(),
            resultDisplayMilliseconds = pollObject.firstLongOrNull("result_display_duration", "result_display_seconds")?.times(1000)?.toInt(),
            hasVoted = pollObject["has_voted"]?.let { (it as? JsonPrimitive)?.contentOrNull?.toBooleanStrictOrNull() ?: (it as? JsonPrimitive)?.intOrNull?.let { intValue -> intValue != 0 } },
            votedChoiceId = pollObject.firstLongOrNull("voted_option_id", "voted_choice_id")?.toInt(),
        )
    }

    suspend fun authorizeKickPusherPrivateChannel(socketId: String, channelName: String): String? = withContext(Dispatchers.IO) {
        if (socketId.isBlank() || channelName.isBlank()) {
            return@withContext null
        }
        val url = "https://kick.com/broadcasting/auth"
        val body = JSONObject().apply {
            put("socket_id", socketId)
            put("channel_name", channelName)
        }.toString()
        runCatching {
            okHttpClient.newCall(
                createRequestBuilder(url, isKickWeb = true)
                    .header("Content-Type", "application/json")
                    .post(body.toRequestBody("application/json".toMediaTypeOrNull()))
                    .build()
            ).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException("Kick private channel auth failed (${response.code}) for $channelName")
                }
                val raw = response.body.string()
                JSONObject(raw).optString("auth").takeIf { it.isNotBlank() }
            }
        }.onFailure {
            Log.w(tag, "kick pusher auth failed channel=$channelName message=${it.message}")
        }.getOrNull()
    }

    suspend fun redeemKickWebReward(
        channelSlug: String,
        rewardId: String,
        userInput: String? = null,
    ) = withContext(Dispatchers.IO) {
        val normalizedChannelSlug = channelSlug.trim().takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("channel slug is required")
        val normalizedRewardId = rewardId.trim().takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("reward id is required")
        val transactionId = generateKickTransactionId()
        val normalizedUserInput = userInput?.trim()?.takeIf { it.isNotBlank() }
        val body = buildJsonObject {
            put("transaction_id", JsonPrimitive(transactionId))
            normalizedUserInput?.let { put("user_input", JsonPrimitive(it)) }
        }.toString()
        val url = "https://kick.com/api/v2/channels/${urlEncode(normalizedChannelSlug)}/rewards/${urlEncode(normalizedRewardId)}/redeem"
        Log.i(pointsDebugTag, "channel points redeem started slug=$normalizedChannelSlug rewardId=$normalizedRewardId transactionId=$transactionId")
        okHttpClient.newCall(
            createRequestBuilder(url, isKickWeb = true)
                .header("Content-Type", "application/json")
                .post(body.toRequestBody("application/json".toMediaTypeOrNull()))
                .build()
        ).execute().use { response ->
            val raw = response.body.string()
            if (!response.isSuccessful) {
                Log.i(
                    pointsDebugTag,
                    "channel points redeem failed slug=$normalizedChannelSlug rewardId=$normalizedRewardId code=${response.code} body=${raw.take(200)}",
                )
                throw IOException("Kick reward redeem failed (${response.code}) for $url: ${raw.take(200)}")
            }
            Log.i(pointsDebugTag, "channel points redeem succeeded slug=$normalizedChannelSlug rewardId=$normalizedRewardId")
        }
    }

    private inline fun <reified T> decodeKickOfficialRealtimePayload(messageJson: String): T? {
        runCatching { json.decodeFromString<T>(messageJson) }.getOrNull()?.let { return it }
        val root = runCatching { json.parseToJsonElement(messageJson) }.getOrNull() ?: return null
        val candidates = buildList<JsonElement> {
            add(root)
            (root as? JsonObject)?.let { obj ->
                obj["data"]?.let(::add)
                obj["message"]?.let(::add)
                obj["payload"]?.let(::add)
                (obj["payload"] as? JsonObject)?.get("data")?.let(::add)
                listOf("data", "message", "payload").forEach { key ->
                    val raw = (obj[key] as? JsonPrimitive)?.contentOrNull ?: return@forEach
                    runCatching { json.parseToJsonElement(raw) }.getOrNull()?.let(::add)
                }
            }
        }
        return candidates.firstNotNullOfOrNull { candidate ->
            runCatching { json.decodeFromJsonElement<T>(candidate) }.getOrNull()
        }
    }

    fun parseChannelPointRewardsResponse(raw: String): ChannelPointRewardsResult {
        return KickFeatureParsingUtils.parseChannelPointRewardsResponse(raw, json)
    }

    fun parseChannelPointRewardsResponse(root: JsonElement): ChannelPointRewardsResult {
        return KickFeatureParsingUtils.parseChannelPointRewardsResponse(root)
    }

    suspend fun getInitialPinnedGift(
        channelSlug: String?,
        channelId: String? = null,
    ): PinnedGiftUpdate? {
        val candidates = linkedSetOf<String>()
        val resolvedChannel = listOfNotNull(
            channelSlug?.trim()?.takeIf { it.isNotBlank() },
            channelId?.trim()?.takeIf { it.isNotBlank() }
        ).firstNotNullOfOrNull { candidate ->
            runCatching { getChannel(candidate) }.getOrNull()
        }
        resolvedChannel?.id?.toString()?.takeIf { it.isNotBlank() }?.let { resolvedChannelId ->
            candidates += "https://web.kick.com/api/v1/chat/${urlEncode(resolvedChannelId)}/history"
        }
        channelSlug?.trim()?.takeIf { it.isNotBlank() }?.let { slug ->
            val encoded = urlEncode(slug)
            candidates += "https://kick.com/api/v2/channels/$encoded"
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v1/$encoded/chatroom"
            candidates += "https://kick.com/api/v2/channels/$encoded/info"
            candidates += "https://kick.com/api/internal/v1/channels/$encoded/chatroom/pinned-message"
        }
        channelId?.trim()?.takeIf { it.isNotBlank() }?.let { id ->
            val encoded = urlEncode(id)
            candidates += "https://kick.com/api/v2/channels/$encoded"
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v1/channels/$encoded"
            candidates += "https://kick.com/api/internal/v1/channels/$encoded/chatroom/pinned-message"
        }
        resolveDedicatedChatroomCandidates(channelId?.takeIf { !it.isNullOrBlank() } ?: channelSlug.orEmpty())
            .forEach { chatroomId ->
                val encoded = urlEncode(chatroomId)
                candidates += "https://kick.com/api/v1/chatrooms/$encoded"
                candidates += "https://kick.com/api/v2/chatrooms/$encoded"
            }
        candidates.forEach { url ->
            val raw = runCatching { getRaw(url, isKickWeb = true) }.getOrNull() ?: return@forEach
            val update = runCatching {
                parsePinnedGiftUpdate(
                    eventName = if (url.contains("pinned-message", ignoreCase = true)) "pinned_message" else "initial_state",
                    messageJson = raw
                )
            }.getOrNull()
            if (isKickFeatureDebugEnabled()) {
                val root = runCatching { json.parseToJsonElement(raw) }.getOrNull()
                val pinnedKeyPaths = findInterestingKeyPaths(root, setOf("pin", "gift", "message")).take(10)
                val parsedState = update?.pinnedGift?.id ?: if (update?.cleared == true) "cleared" else "null"
                val preview = update?.pinnedGift?.message?.take(80) ?: "null"
                Log.d(
                    pinnedDebugTag,
                    "initial url=$url topLevel=${summarizeTopLevelKeys(root)} pinnedKeys=$pinnedKeyPaths pinnedSnippet=${extractKeySnippet(root, "pinned_message")} parsed=$parsedState preview=$preview raw=${raw.compactDebugSnippet()}"
                )
            }
            if (update?.pinnedGift != null || update?.cleared == true) {
                return update
            }
        }
        return null
    }

    suspend fun resolveDedicatedChatroomCandidates(channelOrId: String): List<String> {
        val candidate = channelOrId.trim()
        if (candidate.isBlank()) {
            return emptyList()
        }
        val urls = buildList {
            add("https://kick.com/api/v2/channels/${urlEncode(candidate)}/chatroom")
            if (!candidate.all(Char::isDigit)) {
                add("https://kick.com/api/v1/${urlEncode(candidate)}/chatroom")
            }
        }
        val results = linkedSetOf<String>()
        urls.forEach { url ->
            runCatching {
                val root = json.parseToJsonElement(getRaw(url)).jsonObject
                listOfNotNull(
                    root.primitiveOrNull("id"),
                    root.primitiveOrNull("channel_id"),
                    root.primitiveOrNull("user_id"),
                    (root["chatroom"] as? JsonObject)?.primitiveOrNull("id"),
                    (root["chatroom"] as? JsonObject)?.primitiveOrNull("channel_id"),
                    (root["chatroom"] as? JsonObject)?.primitiveOrNull("user_id"),
                    (root["data"] as? JsonObject)?.primitiveOrNull("id"),
                    (root["data"] as? JsonObject)?.primitiveOrNull("channel_id"),
                    (root["data"] as? JsonObject)?.primitiveOrNull("user_id"),
                )
            }.getOrNull().orEmpty()
                .map(String::trim)
                .filter(String::isNotBlank)
                .forEach(results::add)
        }
        return results.toList()
    }

    suspend fun getInitialRoomState(channelSlug: String?, channelId: String?): RoomState? {
        val candidates = linkedSetOf<String>()
        resolveDedicatedChatroomCandidates(channelId?.takeIf { !it.isNullOrBlank() } ?: channelSlug.orEmpty())
            .forEach { chatroomId ->
                val encoded = urlEncode(chatroomId)
                candidates += "https://kick.com/api/v1/chatrooms/$encoded"
                candidates += "https://kick.com/api/v2/chatrooms/$encoded"
            }
        channelSlug?.trim()?.takeIf { it.isNotBlank() }?.let { slug ->
            val encoded = urlEncode(slug)
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v1/$encoded/chatroom"
            candidates += "https://kick.com/api/v2/channels/$encoded"
            candidates += "https://kick.com/api/v2/channels/$encoded/info"
        }
        channelId?.trim()?.takeIf { it.isNotBlank() }?.let { id ->
            val encoded = urlEncode(id)
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v2/channels/$encoded"
            candidates += "https://kick.com/api/v1/channels/$encoded"
        }

        candidates.forEach { url ->
            val raw = runCatching { getRaw(url, isKickWeb = true) }.getOrNull() ?: return@forEach
            val root = runCatching { json.parseToJsonElement(raw) }.getOrNull()
            val roomState = parseKickRoomState(root)
            if (isKickFeatureDebugEnabled()) {
                val roomKeys = findInterestingKeyPaths(
                    root,
                    setOf("slow", "follower", "follow", "subscriber", "sub", "emote", "unique", "r9k")
                ).take(16)
                Log.d(
                    featureDebugTag,
                    "roomState url=$url topLevel=${summarizeTopLevelKeys(root)} roomKeys=$roomKeys parsed=${roomState?.toDebugString() ?: "null"} raw=${raw.compactDebugSnippet()}"
                )
            }
            if (roomState != null) {
                return roomState
            }
        }
        return null
    }

    suspend fun getChannelLivestream(channelSlug: String, forceRefresh: Boolean = false): KickChannelLivestream? {
        val normalizedKey = channelSlug.trim().lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        if (!forceRefresh) {
            channelLivestreamCache[normalizedKey]?.let { (cachedAt, cachedLivestream) ->
                if (now - cachedAt <= livestreamCacheTtlMs) {
                    return cachedLivestream
                }
            }
        }
        val deferred = CompletableDeferred<KickChannelLivestream?>()
        val inFlight = synchronized(channelLivestreamRequestLock) {
            inFlightChannelLivestreamRequests[normalizedKey]?.also { return@synchronized it }
                ?: deferred.also { inFlightChannelLivestreamRequests[normalizedKey] = it }
        }
        if (inFlight !== deferred) {
            return inFlight.await()
        }
        try {
            val livestream = parseChannelLivestream(
                json.parseToJsonElement(
                    getRaw(
                        url = "https://kick.com/api/v2/channels/${urlEncode(channelSlug)}/livestream",
                        isKickWeb = true
                    )
                )
            )
            return livestream.also {
                val cachedAt = System.currentTimeMillis()
                channelLivestreamCache[normalizedKey] = cachedAt to livestream
                deferred.complete(livestream)
            }
        } catch (t: Throwable) {
            deferred.completeExceptionally(t)
            throw t
        } finally {
            synchronized(channelLivestreamRequestLock) {
                if (inFlightChannelLivestreamRequests[normalizedKey] === deferred) {
                    inFlightChannelLivestreamRequests.remove(normalizedKey)
                }
            }
        }
    }

    fun prefetchChannelLivestreams(channelSlugs: List<String>, forceRefresh: Boolean = false) {
        channelSlugs
            .asSequence()
            .map { it.trim().lowercase(Locale.ROOT) }
            .filter { it.isNotBlank() }
            .distinct()
            .forEach { channelSlug ->
                livestreamPrefetchScope.launch {
                    runCatching {
                        getChannelLivestream(channelSlug, forceRefresh = forceRefresh)
                    }
                }
            }
    }

    suspend fun getChannelVideos(channelSlug: String, channelId: String? = null, limit: Int = 30): List<Video> {
        var cursor: String? = null
        val collected = mutableListOf<Video>()
        do {
            val page = getChannelVideosPage(
                channelSlug = channelSlug,
                channelId = channelId,
                limit = limit,
                cursor = cursor,
            ) ?: break
            collected += page.videos
            cursor = page.nextCursor
        } while (!cursor.isNullOrBlank() && collected.size < limit)
        return collected.distinctBy { it.id }.take(limit)
    }

    suspend fun getChannelVideosPage(
        channelSlug: String,
        channelId: String? = null,
        limit: Int = 30,
        cursor: String? = null,
    ): KickVideoPage? {
        val cached = channelCache[channelSlug.trim().lowercase(Locale.ROOT)]?.second
        var resolvedChannelId = channelId ?: cached?.id?.toString()
        var login = cached?.slug ?: channelSlug
        var channelName = cached?.user?.username
        var channelLogo = cached?.user?.profileImage
        val pageSize = limit.coerceIn(20, 100)

        val attempted = mutableSetOf<String>()
        suspend fun tryBaseUrl(baseUrl: String): KickVideoPage? {
            if (!attempted.add(baseUrl)) return null
            val urls = buildList {
                add(
                    buildPagedKickUrl(
                        baseUrl = baseUrl,
                        page = 1,
                        limit = pageSize,
                        extraQuery = buildMap {
                            cursor?.let { put("cursor", it) }
                        }
                    )
                )
                add(
                    buildKickUrl(
                        baseUrl = baseUrl,
                        extraQuery = buildMap {
                            cursor?.let { put("cursor", it) }
                        }
                    )
                )
            }
            urls.forEach { url ->
                val root = runCatching { json.parseToJsonElement(getRaw(url, isKickWeb = true)) }.getOrNull() ?: return@forEach
                val parsed = parseVideos(
                    roots = listOf(root),
                    channelId = channelId,
                    channelLogin = login,
                    channelName = channelName,
                    channelLogo = channelLogo,
                    limit = pageSize
                )
                if (parsed.isNotEmpty()) {
                    return KickVideoPage(
                        videos = parsed,
                        nextCursor = (root as? JsonObject)?.let(::extractNextCursor)
                    )
                }
            }
            return null
        }

        tryBaseUrl("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}/videos")?.let { return it }
        resolvedChannelId?.let { id ->
            tryBaseUrl("https://kick.com/api/v2/channels/${urlEncode(id)}/videos")?.let { return it }
        }
        tryBaseUrl("https://kick.com/api/v1/channels/${urlEncode(channelSlug)}/videos")?.let { return it }
        resolvedChannelId?.let { id ->
            tryBaseUrl("https://kick.com/api/v1/channels/${urlEncode(id)}/videos")?.let { return it }
        }

        val channelRoot = runCatching {
            json.parseToJsonElement(getRaw("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}", isKickWeb = true)).jsonObject
        }.getOrNull()
        if (channelRoot != null) {
            resolvedChannelId = resolvedChannelId ?: channelRoot.primitiveOrNull("id")
            login = channelRoot.primitiveOrNull("slug") ?: login
            channelName = channelRoot.objOrNull("user")?.primitiveOrNull("username") ?: channelName
            channelLogo = channelRoot.objOrNull("user")?.primitiveOrNull("profile_pic")
                ?: channelRoot.objOrNull("user")?.primitiveOrNull("profile_picture")
                ?: channelLogo
            parseVideos(
                roots = listOf(channelRoot),
                channelId = channelId,
                channelLogin = login,
                channelName = channelName,
                channelLogo = channelLogo,
                limit = pageSize
            ).takeIf { it.isNotEmpty() }?.let {
                return KickVideoPage(
                    videos = it,
                    nextCursor = extractNextCursor(channelRoot)
                )
            }

            resolvedChannelId?.let { id ->
                tryBaseUrl("https://kick.com/api/v2/channels/${urlEncode(id)}/videos")?.let { return it }
                tryBaseUrl("https://kick.com/api/v1/channels/${urlEncode(id)}/videos")?.let { return it }
            }
        }

        return null
    }

    suspend fun getChannelClips(channelSlug: String, channelId: String? = null, limit: Int = 20): List<Clip> {
        var cursor: String? = null
        val collected = mutableListOf<Clip>()
        do {
            val page = getChannelClipsPage(
                channelSlug = channelSlug,
                channelId = channelId,
                limit = limit,
                cursor = cursor,
            ) ?: break
            collected += page.clips
            cursor = page.nextCursor
        } while (!cursor.isNullOrBlank() && collected.size < limit)
        return collected.distinctBy { it.id }.take(limit)
    }

    suspend fun getChannelClipsPage(
        channelSlug: String,
        channelId: String? = null,
        limit: Int = 20,
        time: String? = null,
        cursor: String? = null,
    ): KickClipPage? {
        val cached = channelCache[channelSlug.trim().lowercase(Locale.ROOT)]?.second
        var resolvedChannelId = channelId ?: cached?.id?.toString()
        var login = cached?.slug ?: channelSlug
        var channelName = cached?.user?.username
        var channelLogo = cached?.user?.profileImage
        val pageSize = limit.coerceIn(20, 100)
        val timeCandidates = when (time?.trim()?.lowercase(Locale.ROOT)) {
            "day", "today" -> listOf("day", "today")
            "week" -> listOf("week")
            "month" -> listOf("month")
            "all" -> listOf("all")
            else -> listOf<String?>(null)
        }

        suspend fun loadFromUrls(urls: List<String>): KickClipPage? {
            return collectClipPages(
                initialUrls = urls,
                limit = pageSize,
                maxPages = 1,
                channelId = channelId,
                channelLogin = login,
                channelName = channelName,
                channelLogo = channelLogo,
            )
        }

        val attempted = mutableSetOf<String>()
        fun buildUrls(baseUrl: String): List<String> {
            return buildList {
                timeCandidates.forEach { resolvedTime ->
                    add(
                        buildPagedKickUrl(
                            baseUrl = baseUrl,
                            page = 1,
                            limit = pageSize,
                            extraQuery = buildMap {
                                put("sort", "view")
                                resolvedTime?.let { put("time", it) }
                                cursor?.let { put("cursor", it) }
                            }
                        )
                    )
                    add(
                        buildKickUrl(
                            baseUrl = baseUrl,
                            extraQuery = buildMap {
                                put("sort", "view")
                                resolvedTime?.let { put("time", it) }
                                cursor?.let { put("cursor", it) }
                            }
                        )
                    )
                }
            }
        }

        val channelSlugUrl = "https://kick.com/api/v2/channels/${urlEncode(channelSlug)}/clips"
        if (attempted.add(channelSlugUrl)) {
            loadFromUrls(buildUrls(channelSlugUrl))?.let { return it }
        }
        resolvedChannelId?.let { id ->
            val channelIdUrl = "https://kick.com/api/v2/channels/${urlEncode(id)}/clips"
            if (attempted.add(channelIdUrl)) {
                loadFromUrls(buildUrls(channelIdUrl))?.let { return it }
            }
        }
        val legacySlugUrl = "https://kick.com/api/v1/channels/${urlEncode(channelSlug)}/clips"
        if (attempted.add(legacySlugUrl)) {
            loadFromUrls(buildUrls(legacySlugUrl))?.let { return it }
        }
        resolvedChannelId?.let { id ->
            val legacyIdUrl = "https://kick.com/api/v1/channels/${urlEncode(id)}/clips"
            if (attempted.add(legacyIdUrl)) {
                loadFromUrls(buildUrls(legacyIdUrl))?.let { return it }
            }
        }

        val channelRoot = runCatching {
            json.parseToJsonElement(getRaw("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}", isKickWeb = true)).jsonObject
        }.getOrNull()
        if (channelRoot != null) {
            resolvedChannelId = resolvedChannelId ?: channelRoot.primitiveOrNull("id")
            login = channelRoot.primitiveOrNull("slug") ?: login
            channelName = channelRoot.objOrNull("user")?.primitiveOrNull("username") ?: channelName
            channelLogo = channelRoot.objOrNull("user")?.primitiveOrNull("profile_pic")
                ?: channelRoot.objOrNull("user")?.primitiveOrNull("profile_picture")
                ?: channelLogo
            resolvedChannelId?.let { id ->
                val refreshedV2Url = "https://kick.com/api/v2/channels/${urlEncode(id)}/clips"
                if (attempted.add(refreshedV2Url)) {
                    loadFromUrls(buildUrls(refreshedV2Url))?.let { return it }
                }
                val refreshedV1Url = "https://kick.com/api/v1/channels/${urlEncode(id)}/clips"
                if (attempted.add(refreshedV1Url)) {
                    loadFromUrls(buildUrls(refreshedV1Url))?.let { return it }
                }
            }
        }

        return null
    }

    suspend fun getCategoryClips(
        categorySlug: String,
        gameId: String? = null,
        gameName: String? = null,
        limit: Int = 20,
        time: String? = null,
    ): List<Clip> {
        var cursor: String? = null
        val collected = mutableListOf<Clip>()
        do {
            val page = getCategoryClipsPage(
                categorySlug = categorySlug,
                gameId = gameId,
                gameName = gameName,
                limit = limit,
                time = time,
                cursor = cursor,
            ) ?: break
            collected += page.clips
            cursor = page.nextCursor
        } while (!cursor.isNullOrBlank() && collected.size < limit)
        return collected.distinctBy { it.id }.take(limit)
    }

    suspend fun getCategoryClipsPage(
        categorySlug: String,
        gameId: String? = null,
        gameName: String? = null,
        limit: Int = 20,
        time: String? = null,
        cursor: String? = null,
    ): KickClipPage? {
        val normalizedSlug = categorySlug.trim().lowercase(Locale.ROOT)
        if (normalizedSlug.isBlank()) return null

        val pageSize = limit.coerceIn(20, 100)
        val timeCandidates = when (time?.trim()?.lowercase(Locale.ROOT)) {
            "day", "today" -> listOf("day", "today")
            "week" -> listOf("week")
            "month" -> listOf("month")
            "all" -> listOf("all")
            else -> listOf<String?>(null)
        }
        val initialUrls = buildList {
            timeCandidates.forEach { resolvedTime ->
                add(
                    buildPagedKickUrl(
                        baseUrl = "https://kick.com/api/v2/categories/${urlEncode(normalizedSlug)}/clips",
                        page = 1,
                        limit = pageSize,
                        extraQuery = buildMap {
                            put("sort", "view")
                            resolvedTime?.let { put("time", it) }
                            cursor?.let { put("cursor", it) }
                        }
                    )
                )
                add(
                    buildKickUrl(
                        baseUrl = "https://kick.com/api/v2/categories/${urlEncode(normalizedSlug)}/clips",
                        extraQuery = buildMap {
                            put("sort", "view")
                            resolvedTime?.let { put("time", it) }
                            cursor?.let { put("cursor", it) }
                        }
                    )
                )
            }
            add(buildPagedKickUrl("https://kick.com/api/v2/subcategories/${urlEncode(normalizedSlug)}/clips", page = 1, limit = pageSize, extraQuery = buildMap {
                cursor?.let { put("cursor", it) }
            }))
            add("https://kick.com/api/v2/subcategories/${urlEncode(normalizedSlug)}/clips")
            add(buildPagedKickUrl("https://kick.com/api/v1/subcategories/${urlEncode(normalizedSlug)}/clips", page = 1, limit = pageSize, extraQuery = buildMap {
                cursor?.let { put("cursor", it) }
            }))
            add("https://kick.com/api/v1/subcategories/${urlEncode(normalizedSlug)}/clips")
        }
        return collectClipPages(
            initialUrls = initialUrls,
            limit = pageSize,
            maxPages = 1,
            gameId = gameId,
            gameSlug = normalizedSlug,
            gameName = gameName,
        )
    }

    private suspend fun collectClipPages(
        initialUrls: List<String>,
        limit: Int,
        maxPages: Int,
        channelId: String? = null,
        channelLogin: String? = null,
        channelName: String? = null,
        channelLogo: String? = null,
        gameId: String? = null,
        gameSlug: String? = null,
        gameName: String? = null,
    ): KickClipPage? {
        val attemptedInitialUrls = mutableSetOf<String>()
        initialUrls.forEach { initialUrl ->
            if (!attemptedInitialUrls.add(initialUrl)) return@forEach
            val visitedPageUrls = mutableSetOf<String>()
            val collected = linkedMapOf<String, Clip>()
            var currentUrl: String? = initialUrl
            var pageCount = 0
            var nextCursor: String? = null
            while (!currentUrl.isNullOrBlank() && visitedPageUrls.add(currentUrl) && pageCount < maxPages && collected.size < limit) {
                val page = loadClipPage(
                    url = currentUrl,
                    limit = limit,
                    channelId = channelId,
                    channelLogin = channelLogin,
                    channelName = channelName,
                    channelLogo = channelLogo,
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
                ) ?: break
                page.clips.forEach { clip ->
                    clip.id?.let { id ->
                        if (collected[id] == null) {
                            collected[id] = clip
                        }
                    }
                }
                nextCursor = page.nextCursor
                val nextExplicit = page.nextPageUrl
                currentUrl = when {
                    !nextExplicit.isNullOrBlank() -> resolveKickPageUrl(nextExplicit)
                    else -> buildNextPageUrl(currentUrl, pageCount + 2).takeIf { nextCandidate ->
                        nextCandidate != currentUrl && !visitedPageUrls.contains(nextCandidate)
                    }
                }
                if (page.clips.isEmpty()) {
                    currentUrl = null
                }
                pageCount++
            }
            if (collected.isNotEmpty()) {
                return KickClipPage(
                    clips = collected.values.take(limit),
                    nextCursor = nextCursor
                )
            }
        }
        return null
    }

    private suspend fun loadClipPage(
        url: String,
        limit: Int,
        channelId: String? = null,
        channelLogin: String? = null,
        channelName: String? = null,
        channelLogo: String? = null,
        gameId: String? = null,
        gameSlug: String? = null,
        gameName: String? = null,
    ): KickClipPageResult? {
        val root = runCatching { json.parseToJsonElement(getRaw(url, isKickWeb = true)) }.getOrNull() ?: return null
        val parsed = parseClips(
            roots = listOf(root),
            channelId = channelId,
            channelLogin = channelLogin,
            channelName = channelName,
            channelLogo = channelLogo,
            gameId = gameId,
            gameSlug = gameSlug,
            gameName = gameName,
            limit = limit
        )
        val nextCursor = (root as? JsonObject)?.let(::extractNextCursor)
        val nextPageUrl = (root as? JsonObject)?.let { extractNextPageUrl(it, url) }
        return KickClipPageResult(
            clips = parsed,
            nextCursor = nextCursor,
            nextPageUrl = nextPageUrl
        )
    }

    private fun extractNextPageUrl(root: JsonObject, currentUrl: String): String? {
        return root.firstPrimitiveOrNull("next_page_url", "nextPageUrl")
            ?: root.objOrNull("pagination")?.firstPrimitiveOrNull("next_page_url", "nextPageUrl", "next")
            ?: root.objOrNull("meta")?.firstPrimitiveOrNull("next_page_url", "nextPageUrl", "next")
            ?: root.objOrNull("links")?.firstPrimitiveOrNull("next", "next_page_url")
            ?: root.objOrNull("data")?.firstPrimitiveOrNull("next_page_url", "nextPageUrl")
            ?: root.objOrNull("data")?.objOrNull("pagination")?.firstPrimitiveOrNull("next_page_url", "nextPageUrl", "next")
            ?: root.objOrNull("data")?.objOrNull("links")?.firstPrimitiveOrNull("next", "next_page_url")
            ?: root.objOrNull("status")?.firstPrimitiveOrNull("next_page_url", "nextPageUrl")
            ?: root.objOrNull("status")?.objOrNull("pagination")?.firstPrimitiveOrNull("next_page_url", "nextPageUrl", "next")
            ?: root.objOrNull("status")?.objOrNull("links")?.firstPrimitiveOrNull("next", "next_page_url")
            ?: extractCursorNextPageUrl(root, currentUrl)
    }

    private fun extractNextCursor(root: JsonObject): String? {
        return root.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
            ?: root.objOrNull("data")?.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
            ?: root.objOrNull("status")?.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
            ?: root.objOrNull("pagination")?.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
    }

    private fun extractCursorNextPageUrl(root: JsonObject, currentUrl: String): String? {
        val cursor = root.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
            ?: root.objOrNull("data")?.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
            ?: root.objOrNull("status")?.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
            ?: root.objOrNull("pagination")?.firstPrimitiveOrNull("cursor", "next_cursor", "nextCursor")
        if (cursor.isNullOrBlank()) return null
        val builder = currentUrl.toHttpUrlOrNull()?.newBuilder() ?: return null
        builder.setQueryParameter("cursor", cursor)
        return builder.build().toString()
    }

    private fun buildKickUrl(baseUrl: String, extraQuery: Map<String, String> = emptyMap()): String {
        val builder = baseUrl.toHttpUrlOrNull()?.newBuilder() ?: return baseUrl
        extraQuery.forEach { (key, value) ->
            builder.setQueryParameter(key, value)
        }
        return builder.build().toString()
    }

    private fun buildPagedKickUrl(baseUrl: String, page: Int, limit: Int, extraQuery: Map<String, String> = emptyMap()): String {
        val builder = baseUrl.toHttpUrlOrNull()?.newBuilder() ?: return baseUrl
        builder.setQueryParameter("page", page.toString())
        builder.setQueryParameter("limit", limit.toString())
        extraQuery.forEach { (key, value) ->
            builder.setQueryParameter(key, value)
        }
        return builder.build().toString()
    }

    private fun buildNextPageUrl(currentUrl: String, nextPage: Int): String? {
        val builder = currentUrl.toHttpUrlOrNull()?.newBuilder() ?: return null
        builder.setQueryParameter("page", nextPage.toString())
        if (builder.build().queryParameter("limit").isNullOrBlank()) {
            builder.setQueryParameter("limit", "100")
        }
        return builder.build().toString()
    }

    private fun resolveKickPageUrl(value: String): String {
        return if (value.startsWith("http://", ignoreCase = true) || value.startsWith("https://", ignoreCase = true)) {
            value
        } else {
            "https://kick.com${if (value.startsWith('/')) value else "/$value"}"
        }
    }

    private fun parseVideos(
        roots: List<JsonElement>,
        channelId: String?,
        channelLogin: String?,
        channelName: String?,
        channelLogo: String?,
        limit: Int,
    ): List<Video> {
        val arrays = roots.asSequence().flatMap { root ->
            extractVideoArrays(root).asSequence()
        }
        return arrays.flatMap { array -> array.asSequence() }
            .mapNotNull { element ->
                val item = element as? JsonObject ?: return@mapNotNull null
                val id = item.primitiveOrNull("id")
                    ?: item.primitiveOrNull("video_id")
                    ?: item.primitiveOrNull("livestream_id")
                    ?: return@mapNotNull null
                val title = item.primitiveOrNull("session_title")
                    ?: item.primitiveOrNull("title")
                    ?: item.primitiveOrNull("name")
                val createdAt = item.primitiveOrNull("created_at")
                    ?: item.primitiveOrNull("start_time")
                    ?: item.primitiveOrNull("published_at")
                val thumbnail = extractImageUrl(item.objOrNull("thumbnail"))
                    ?: item.primitiveOrNull("preview_thumbnail_url")
                    ?: item.primitiveOrNull("thumbnail_url")
                val viewCount = item.intOrNull("views")
                    ?: item.intOrNull("view_count")
                    ?: item.intOrNull("viewer_count")
                val duration = item.primitiveOrNull("duration")
                    ?: item.intOrNull("duration_seconds")?.toString()
                    ?: item.intOrNull("length_seconds")?.toString()
                val category = item.arrayOrNull("categories")?.firstNotNullOfOrNull { categoryElement ->
                    (categoryElement as? JsonObject)?.let { categoryObject ->
                        Triple(
                            categoryObject.primitiveOrNull("id"),
                            categoryObject.primitiveOrNull("slug"),
                            categoryObject.primitiveOrNull("name"),
                        )
                    }
                } ?: item.objOrNull("category")?.let { categoryObject ->
                    Triple(
                        categoryObject.primitiveOrNull("id"),
                        categoryObject.primitiveOrNull("slug"),
                        categoryObject.primitiveOrNull("name"),
                    )
                }
                Video(
                    id = id,
                    source = C.KICK,
                    url = extractKickVideoUrl(item),
                    channelId = channelId,
                    channelLogin = channelLogin,
                    channelName = channelName,
                    title = title,
                    uploadDate = normalizeDate(createdAt),
                    thumbnailUrl = thumbnail,
                    viewCount = viewCount,
                    type = "ARCHIVE",
                    duration = duration,
                    gameId = category?.first,
                    gameSlug = category?.second,
                    gameName = category?.third,
                    profileImageUrl = channelLogo
                )
            }
            .distinctBy { it.id }
            .sortedByDescending { it.uploadDate }
            .take(limit)
            .toList()
    }

    private fun parseClips(
        roots: List<JsonElement>,
        channelId: String? = null,
        channelLogin: String? = null,
        channelName: String? = null,
        channelLogo: String? = null,
        gameId: String? = null,
        gameSlug: String? = null,
        gameName: String? = null,
        limit: Int,
    ): List<Clip> {
        val arrays = roots.asSequence().flatMap { root ->
            extractClipArrays(root).asSequence()
        }
        return arrays.flatMap { array -> array.asSequence() }
            .mapNotNull { element ->
                val item = element as? JsonObject ?: return@mapNotNull null
                val id = item.primitiveOrNull("slug")
                    ?: item.primitiveOrNull("id")
                    ?: item.primitiveOrNull("clip_id")
                    ?: return@mapNotNull null
                val title = item.primitiveOrNull("title")
                    ?: item.primitiveOrNull("session_title")
                    ?: item.primitiveOrNull("name")
                val createdAt = item.primitiveOrNull("created_at")
                    ?: item.primitiveOrNull("published_at")
                    ?: item.objOrNull("clip")?.primitiveOrNull("created_at")
                    ?: item.objOrNull("clip")?.primitiveOrNull("published_at")
                    ?: item.objOrNull("video")?.primitiveOrNull("created_at")
                    ?: item.objOrNull("video")?.primitiveOrNull("published_at")
                val replayStartTime = item.primitiveOrNull("start_time")
                    ?: item.primitiveOrNull("clip_start_time")
                    ?: item.objOrNull("clip")?.primitiveOrNull("start_time")
                    ?: item.objOrNull("video")?.primitiveOrNull("start_time")
                    ?: createdAt
                val thumbnail = extractImageUrl(item.objOrNull("thumbnail"))
                    ?: item.primitiveOrNull("thumbnail_url")
                    ?: item.primitiveOrNull("preview_thumbnail_url")
                val viewCount = item.intOrNull("views")
                    ?: item.intOrNull("view_count")
                    ?: item.intOrNull("viewer_count")
                val duration = item.intOrNull("duration_seconds")?.toDouble()
                    ?: item.intOrNull("duration")?.toDouble()
                    ?: item.intOrNull("clip_duration")?.toDouble()
                val vodOffset = item.intOrNull("video_offset")
                    ?: item.intOrNull("vod_offset")
                val clipUrl = item.primitiveOrNull("video_url")
                    ?: item.primitiveOrNull("clip_url")
                    ?: item.objOrNull("video")?.primitiveOrNull("url")
                    ?: item.objOrNull("clip")?.primitiveOrNull("url")
                val videoId = item.primitiveOrNull("video_id")
                    ?: item.objOrNull("video")?.primitiveOrNull("id")
                val category = item.arrayOrNull("categories")?.firstNotNullOfOrNull { categoryElement ->
                    (categoryElement as? JsonObject)?.let { categoryObject ->
                        Triple(
                            categoryObject.primitiveOrNull("id"),
                            categoryObject.primitiveOrNull("slug"),
                            categoryObject.primitiveOrNull("name"),
                        )
                    }
                } ?: item.objOrNull("category")?.let { categoryObject ->
                    Triple(
                        categoryObject.primitiveOrNull("id"),
                        categoryObject.primitiveOrNull("slug"),
                        categoryObject.primitiveOrNull("name"),
                    )
                }
                val itemChannel = item.objOrNull("channel")
                val itemChannelUser = itemChannel?.objOrNull("user")
                val clipChannelId = item.primitiveOrNull("channel_id")
                    ?: itemChannel?.primitiveOrNull("id")
                    ?: channelId
                val clipChannelLogin = item.primitiveOrNull("channel_slug")
                    ?: itemChannel?.primitiveOrNull("slug")
                    ?: itemChannelUser?.primitiveOrNull("username")?.lowercase(Locale.ROOT)
                    ?: channelLogin
                val clipChannelName = item.primitiveOrNull("channel_name")
                    ?: itemChannelUser?.primitiveOrNull("username")
                    ?: itemChannel?.primitiveOrNull("name")
                    ?: channelName
                val clipProfileImage = itemChannelUser?.primitiveOrNull("profile_image")
                    ?: itemChannelUser?.primitiveOrNull("profile_pic")
                    ?: itemChannelUser?.primitiveOrNull("profile_picture")
                    ?: channelLogo
                Clip(
                    id = id,
                    channelId = clipChannelId,
                    channelLogin = clipChannelLogin,
                    channelName = clipChannelName,
                    clipUrl = clipUrl,
                    replayStartTime = normalizeDate(replayStartTime),
                    videoId = videoId,
                    vodOffset = vodOffset,
                    gameId = category?.first ?: gameId,
                    gameSlug = category?.second ?: gameSlug,
                    gameName = category?.third ?: gameName,
                    title = title,
                    viewCount = viewCount,
                    uploadDate = normalizeDate(createdAt),
                    thumbnailUrl = thumbnail,
                    duration = duration,
                    profileImageUrl = clipProfileImage
                )
            }
            .distinctBy { it.id }
            .sortedWith(
                compareByDescending<Clip> { it.viewCount ?: -1 }
                    .thenByDescending { it.uploadDate }
            )
            .take(limit)
            .toList()
    }

    private fun extractKickVideoUrl(item: JsonObject): String? {
        val directUrl = item.primitiveOrNull("playback_url")
            ?: item.primitiveOrNull("playlist_url")
            ?: item.primitiveOrNull("hls_url")
            ?: item.primitiveOrNull("video_url")
            ?: item.primitiveOrNull("source")
            ?: item.objOrNull("source")?.primitiveOrNull("url")
            ?: item.objOrNull("video")?.primitiveOrNull("url")
            ?: item.objOrNull("livestream")?.primitiveOrNull("playback_url")
        return normalizeKickVideoUrl(directUrl)
    }

    private fun normalizeKickVideoUrl(url: String?): String? {
        val normalizedUrl = url?.trim().takeUnless { it.isNullOrBlank() } ?: return null
        return when {
            normalizedUrl.endsWith(".m3u8", ignoreCase = true) -> normalizedUrl
            normalizedUrl.contains("kick.com", ignoreCase = true) &&
                    (normalizedUrl.contains("/hls/", ignoreCase = true) ||
                            normalizedUrl.contains("/stream/", ignoreCase = true)) -> {
                if (normalizedUrl.endsWith("/")) {
                    "${normalizedUrl}playlist.m3u8"
                } else {
                    "$normalizedUrl/playlist.m3u8"
                }
            }
            else -> normalizedUrl
        }
    }

    suspend fun getRecentMessages(channelOrChatroomId: String): KickMessagesData {
        val raw = getRaw("https://kick.com/api/v2/channels/${urlEncode(channelOrChatroomId)}/messages")
        val root = runCatching { json.parseToJsonElement(raw) }.getOrElse { error ->
            throw error
        }
        return parseKickMessagesData(root, raw).also { parsed ->
            if (parsed.messages.isEmpty() && isKickRecentChatDebugEnabled()) {
                Log.w(
                    "KickRecentChat",
                    "empty recent source=$channelOrChatroomId body=${raw.take(600).replace('\n', ' ')}"
                )
            }
        }
    }

    suspend fun getChatHistory(channelOrChatroomId: String, startTime: String, cursor: String? = null): KickMessagesData {
        val url = buildString {
            append("https://web.kick.com/api/v1/chat/")
            append(urlEncode(channelOrChatroomId))
            append("/history?start_time=")
            append(urlEncode(startTime))
            if (!cursor.isNullOrBlank()) {
                append("&cursor=")
                append(urlEncode(cursor))
            }
        }
        val raw = getRaw(url, isKickWeb = true)
        val root = runCatching { json.parseToJsonElement(raw) }.getOrElse { error ->
            throw error
        }
        return parseKickMessagesData(root, raw).also { parsed ->
            if (parsed.messages.isEmpty() && isKickRecentChatDebugEnabled()) {
                Log.w(
                    "KickRecentChat",
                    "empty history source=$channelOrChatroomId start=$startTime cursor=${cursor ?: "-"} body=${raw.take(600).replace('\n', ' ')}"
                )
            }
        }
    }

    suspend fun getLiveChatHistory(channelOrChatroomId: String): KickMessagesData {
        val raw = getRaw(
            "https://web.kick.com/api/v1/chat/${urlEncode(channelOrChatroomId)}/history",
            isKickWeb = true
        )
        val root = runCatching { json.parseToJsonElement(raw) }.getOrElse { error ->
            throw error
        }
        return parseKickMessagesData(root, raw).also { parsed ->
            if (parsed.messages.isEmpty() && isKickRecentChatDebugEnabled()) {
                Log.d(
                    "KickRecentChat",
                    "empty live history source=$channelOrChatroomId body=${raw.take(600).replace('\n', ' ')}"
                )
            }
        }
    }

    private fun parseKickMessagesData(root: JsonElement, raw: String): KickMessagesData {
        fun decodeMessagesArray(element: JsonElement?): List<KickMessage>? {
            val array = element as? JsonArray ?: return null
            return runCatching {
                array.mapNotNull { item ->
                    runCatching { json.decodeFromJsonElement(KickMessage.serializer(), item) }.getOrNull()
                }
            }.getOrNull()
        }

        val rootObject = root as? JsonObject
        val dataElement = rootObject?.get("data")
        val dataObject = dataElement as? JsonObject
        val topLevelMessages = decodeMessagesArray(rootObject?.get("messages"))
        val nestedMessages = decodeMessagesArray(dataObject?.get("messages"))
        val directMessages = decodeMessagesArray(dataElement)
        val rootArrayMessages = decodeMessagesArray(root)
        val cursor = (dataObject?.get("cursor") as? JsonPrimitive)?.contentOrNull
            ?: (rootObject?.get("cursor") as? JsonPrimitive)?.contentOrNull

        return when {
            rootArrayMessages != null -> KickMessagesData(messages = rootArrayMessages)
            topLevelMessages != null -> KickMessagesData(messages = topLevelMessages, cursor = cursor)
            nestedMessages != null -> KickMessagesData(messages = nestedMessages, cursor = cursor)
            directMessages != null -> KickMessagesData(messages = directMessages, cursor = cursor)
            else -> runCatching {
                dataObject?.let { json.decodeFromString<KickMessagesData>(it.toString()) }
                    ?: json.decodeFromString<KickMessagesEnvelope>(raw).data
                    ?: KickMessagesData()
            }.getOrElse {
                KickMessagesData()
            }
        }
    }

    suspend fun getClipPlaylistStartTimeMs(clipUrl: String): Long? = withContext(Dispatchers.IO) {
        val normalizedUrl = clipUrl.trim()
        if (normalizedUrl.isBlank()) return@withContext null
        val playlistUrl = when {
            normalizedUrl.endsWith(".m3u8", ignoreCase = true) -> normalizedUrl
            normalizedUrl.endsWith("/") -> "${normalizedUrl}playlist.m3u8"
            else -> "$normalizedUrl/playlist.m3u8"
        }
        okHttpClient.newCall(
            Request.Builder()
                .url(playlistUrl)
                .header("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
                .header("Accept", "application/x-mpegURL,text/plain,*/*")
                .build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                return@withContext null
            }
            val firstProgramDateTime = response.body.string()
                .lineSequence()
                .firstOrNull { it.startsWith("#EXT-X-PROGRAM-DATE-TIME:", ignoreCase = true) }
                ?.substringAfter(':')
                ?.trim()
                ?.takeIf { it.isNotBlank() }
                ?: return@withContext null
            return@withContext runCatching {
                normalizeDate(firstProgramDateTime)?.let { normalized ->
                    KickApiHelper.parseIso8601DateUTC(normalized)
                }
            }.getOrNull()
        }
    }

    suspend fun sendChatMessage(accessToken: String, broadcasterUserId: Long, content: String, replyToMessageId: String? = null): KickChatSendResponse = withContext(Dispatchers.IO) {
        val response = kickOfficialApiClient.postChatMessage(
            accessToken = accessToken,
            request = KickOfficialPostChatMessageRequest(
                broadcasterUserId = broadcasterUserId,
                content = content,
                replyToMessageId = replyToMessageId,
                type = "user",
            )
        )
        return@withContext when {
            response == null -> KickChatSendResponse()
            response is JsonObject && response["data"] != null -> json.decodeFromJsonElement(response)
            else -> KickChatSendResponse(
                data = json.decodeFromJsonElement(response)
            )
        }
    }

    fun toStream(item: KickLivestream, gameId: String? = null, gameSlug: String? = null, gameName: String? = null): Stream {
        val category = item.categories?.firstOrNull()
        val channelLogin = item.channel?.slug ?: item.channel?.user?.username?.lowercase(Locale.ROOT)
        return Stream(
            id = item.id?.toString(),
            source = C.KICK,
            channelId = item.channel?.id?.toString() ?: item.channelId?.toString(),
            channelLogin = channelLogin,
            channelName = item.channel?.user?.username,
            playbackUrl = item.channel?.playbackUrl,
            gameId = gameId ?: category?.id?.toString(),
            gameSlug = gameSlug ?: category?.slug,
            gameName = gameName ?: category?.name,
            title = item.title,
            viewerCount = item.viewerCount,
            startedAt = normalizeDate(item.createdAt),
            thumbnailUrl = item.thumbnail?.imageUrl,
            profileImageUrl = item.channel?.user?.profileImage,
            tags = item.tags
        )
    }

    fun toStream(channel: KickChannelResponse, livestreamOverride: KickChannelLivestream? = null): Stream {
        val livestream = livestreamOverride ?: channel.livestream
        return Stream(
            id = livestream?.id?.toString(),
            source = C.KICK,
            channelId = channel.id?.toString(),
            channelLogin = channel.slug,
            channelName = channel.user?.username,
            playbackUrl = livestream?.playbackUrl ?: channel.playbackUrl,
            gameId = livestream?.category?.id?.toString(),
            gameSlug = livestream?.category?.slug,
            gameName = livestream?.category?.name,
            title = livestream?.title,
            viewerCount = livestream?.viewerCount,
            startedAt = normalizeDate(livestream?.createdAt),
            thumbnailUrl = livestream?.thumbnail?.imageUrl,
            profileImageUrl = channel.user?.profileImage,
        )
    }

    fun toUser(channel: KickChannelResponse): User {
        return User(
            channelId = channel.id?.toString(),
            channelLogin = channel.slug,
            channelName = channel.user?.username,
            profileImageUrl = channel.user?.profileImage,
            followersCount = channel.followersCount,
            bannerImageURL = channel.bannerImage?.url,
            isLive = channel.livestream != null
        )
    }

    fun toGame(item: KickSubcategory): Game {
        return KickWebsiteSearchMapper.toGame(item)
    }

    fun toUser(item: KickSearchChannel): User {
        return KickWebsiteSearchMapper.toUser(item)
    }

    private fun officialChatEventToKickMessage(event: KickOfficialChatMessageSentEvent): KickMessage {
        return KickMessage(
            id = event.messageId,
            content = event.content,
            createdAt = event.createdAt,
            replyTo = event.repliesTo?.let(::encodeOfficialReplyInfo),
            replyToMessage = event.repliesTo?.let(::encodeOfficialReplyInfo),
            replyToMessageId = event.repliesTo?.messageId,
            sender = event.sender?.let(::toKickMessageSender),
        )
    }

    private fun officialGiftEventToKickMessage(event: KickOfficialChannelSubscriptionGiftsEvent): KickMessage {
        val gifter = event.gifter ?: event.subscriber
        val firstGiftee = event.giftees.firstOrNull()
        return KickMessage(
            id = "kick_subscription_gifts:${gifter?.userId ?: "unknown"}:${event.createdAt ?: "0"}",
            createdAt = event.createdAt,
            type = "subscription_gifts",
            sender = gifter?.let(::toKickMessageSender),
            targetUser = firstGiftee?.let(::encodeOfficialEventUser),
            metadata = buildJsonObject {
                put("event", JsonPrimitive("channel.subscription.gifts"))
                put("gifted_count", JsonPrimitive(event.giftees.size.coerceAtLeast(1)))
            },
        )
    }

    private fun officialModerationEventToKickMessage(event: KickOfficialModerationBannedEvent): KickMessage {
        val createdAt = event.metadata?.createdAt?.let(::normalizeDate)?.let(KickApiHelper::parseIso8601DateUTC)
        val expiresAt = event.metadata?.expiresAt?.let(::normalizeDate)?.let(KickApiHelper::parseIso8601DateUTC)
        val durationSeconds = if (createdAt != null && expiresAt != null && expiresAt > createdAt) {
            ((expiresAt - createdAt) / 1000L).coerceAtLeast(0L)
        } else {
            null
        }
        return KickMessage(
            id = "kick_moderation:${event.bannedUser?.userId ?: "unknown"}:${event.metadata?.createdAt ?: "0"}",
            createdAt = event.metadata?.createdAt,
            type = "moderation_banned",
            sender = event.moderator?.let(::toKickMessageSender),
            targetUser = event.bannedUser?.let(::encodeOfficialEventUser),
            metadata = buildJsonObject {
                put("event", JsonPrimitive("moderation.banned"))
                event.metadata?.reason?.takeIf { it.isNotBlank() }?.let { put("reason", JsonPrimitive(it)) }
                durationSeconds?.let { put("duration_seconds", JsonPrimitive(it)) }
                put("permanent", JsonPrimitive(durationSeconds == null))
            },
        )
    }

    private fun toKickMessageSender(user: KickOfficialEventUser): KickMessageSender {
        return KickMessageSender(
            id = user.userId,
            slug = user.channelSlug,
            username = user.username,
            isVerified = user.isVerified,
            verified = user.isVerified,
            identity = user.identity?.let { identity ->
                KickMessageIdentity(
                    color = identity.usernameColor,
                    badges = identity.badges.map(::toKickMessageBadge)
                )
            }
        )
    }

    private fun toKickMessageBadge(badge: KickOfficialEventBadge): KickMessageBadge {
        return KickMessageBadge(
            type = badge.type,
            text = badge.text,
            count = badge.count,
        )
    }

    private fun encodeOfficialReplyInfo(replyInfo: com.github.andreyasadchy.xtra.model.kick.KickOfficialReplyInfo): JsonObject {
        return buildJsonObject {
            replyInfo.messageId?.let { put("id", JsonPrimitive(it)) }
            replyInfo.messageId?.let { put("message_id", JsonPrimitive(it)) }
            replyInfo.content?.let { put("content", JsonPrimitive(it)) }
            replyInfo.sender?.let { put("sender", encodeOfficialEventUser(it)) }
        }
    }

    private fun encodeOfficialEventUser(user: KickOfficialEventUser): JsonObject {
        return buildJsonObject {
            user.userId?.let { put("id", JsonPrimitive(it)) }
            user.channelSlug?.takeIf { it.isNotBlank() }?.let { put("slug", JsonPrimitive(it)) }
            user.username?.takeIf { it.isNotBlank() }?.let { put("username", JsonPrimitive(it)) }
        }
    }

    private fun createKickNoticeMessage(message: String, createdAt: String? = null): ChatMessage {
        return ChatMessage(
            id = "kick_notice:${message.hashCode()}:${createdAt.orEmpty()}",
            systemMsg = message,
            msgId = "kick_usernotice",
            timestamp = normalizeDate(createdAt)?.let(KickApiHelper::parseIso8601DateUTC),
            fullMsg = message,
        )
    }

    fun toChatMessage(message: KickMessage, eventName: String? = null): ChatMessage {
        val moderationType = resolveKickModerationType(message, eventName)
        val deletedMessageObject = message.deletedMessage.asJsonObjectOrNull()
        val targetUser = extractKickTargetUser(message)
        val actorUser = extractKickModeratorUser(message)
        val rawContent = message.content ?: message.message ?: message.text ?: message.body ?: extractKickMessageContent(deletedMessageObject)
        val content = rawContent?.replace(emoteRegex) { result -> result.groupValues.getOrElse(1) { "" } }
        val identityBadges = message.sender?.identity?.badges.orEmpty()
        val syntheticBadges = syntheticKickBadgesFromSender(message.sender)
        val allBadges = mergeKickMessageBadges(
            existingBadges = identityBadges,
            syntheticBadges = syntheticBadges,
            resolveType = ::resolveKickBadgeType,
            normalizeType = ::normalizeKickBadgeType,
        )
        val effectiveChatScopeId = activeKickChatScopeId ?: message.chatId?.toString()?.takeIf { it.isNotBlank() }
        val dedupedBadges = LinkedHashMap<String, Pair<KickBadgeSource, Badge>>()
        allBadges.forEach { badge ->
            val type = resolveKickBadgeType(badge) ?: return@forEach
            val normalizedType = normalizeKickBadgeType(type)
            val channelSpecificBadge = isKickChannelSpecificBadgeType(normalizedType)
            val version = resolveKickBadgeVersion(badge)
            val directImageUrl = badge.badgeImageUrl
                ?: extractImageUrl(badge.badgeImage)
                ?: badge.imageUrl
                ?: extractImageUrl(badge.image)
                ?: badge.iconUrl
                ?: extractImageUrl(badge.icon)
                ?: badge.badgeUrl
                ?: badge.src
                ?: badge.url
            if (!directImageUrl.isNullOrBlank()) {
                kickBadgeTypeCandidates(type).forEach { candidate ->
                    if (isKickChannelSpecificBadgeType(candidate)) {
                        if (effectiveChatScopeId != null) {
                            cacheKickBadgeUrlIfAbsent("kick:chat:$effectiveChatScopeId:$candidate:default", directImageUrl)
                        } else {
                            cacheKickBadgeUrlIfAbsent("kick:$candidate:default", directImageUrl)
                        }
                    } else {
                        kickBadgeUrls["kick:$candidate:$version"] = directImageUrl
                        cacheKickBadgeUrlIfAbsent("kick:$candidate:default", directImageUrl)
                    }
                }
            }
            val catalogImageUrl = resolveKickBadgeUrl(type, version, effectiveChatScopeId)
            val inlineImageUrl = if (directImageUrl.isNullOrBlank() && catalogImageUrl.isNullOrBlank()) {
                resolveKickInlineBadgeUrl(normalizedType, version)
            } else {
                null
            }
            val selection = selectKickBadgeUrl(
                isChannelSpecific = channelSpecificBadge,
                directImageUrl = directImageUrl,
                catalogImageUrl = catalogImageUrl,
                inlineImageUrl = inlineImageUrl
            )
            val usedInlineFallback = selection.source == KickBadgeUrlSourcePreference.INLINE_FALLBACK
            val source = when (selection.source) {
                KickBadgeUrlSourcePreference.MESSAGE_DIRECT -> KickBadgeSource.MESSAGE_DIRECT
                KickBadgeUrlSourcePreference.CATALOG_CACHE -> KickBadgeSource.CATALOG_CACHE
                KickBadgeUrlSourcePreference.INLINE_FALLBACK -> KickBadgeSource.CATALOG_CACHE
                null -> null
            } ?: return@forEach
            recordKickBadgeSource(source)
            val resolvedImageUrl = selection.imageUrl
            if (resolvedImageUrl.isNullOrBlank() && isKickBadgeDebugEnabled()) {
                Log.w(
                    tag,
                    "Missing kick badge URL. type=$type normalized=$normalizedType version=$version text=${badge.text} rawUrlCandidates=${listOf(badge.badgeImageUrl, badge.badgeImage, badge.imageUrl, badge.image, badge.iconUrl, badge.icon, badge.badgeUrl, badge.src, badge.url)}"
                )
            }
            if (resolvedImageUrl.isNullOrBlank()) {
                return@forEach
            }
            if (isKickBadgeDebugEnabled() && normalizedType in setOf("moderator", "vip", "verified", "og", "founder", "sub_gifter", "subscriber", "broadcaster", "staff")) {
                Log.d(
                    badgeDebugTag,
                    "messageBadge type=$type normalized=$normalizedType version=$version source=${source.name} inlineFallback=$usedInlineFallback resolved=true"
                )
            }
            val displayText = badge.text?.takeIf { it.isNotBlank() } ?: type.replace('_', ' ').uppercase(Locale.ROOT)
            val resolvedBadge = Badge(
                setId = "kick:$normalizedType",
                version = version,
                title = displayText,
                url1x = resolvedImageUrl,
                url2x = resolvedImageUrl,
                url3x = resolvedImageUrl,
                url4x = resolvedImageUrl,
            )
            val dedupeKey = "${resolvedBadge.setId}|${resolvedBadge.version}"
            val existing = dedupedBadges[dedupeKey]
            if (existing == null || source.priority > existing.first.priority) {
                dedupedBadges[dedupeKey] = source to resolvedBadge
            }
        }
        val badges = dedupedBadges.values.map { it.second }.takeIf { it.isNotEmpty() }
        val reply = extractKickReply(message)
        val targetLogin = targetUser?.login
        val targetName = targetUser?.name
        val targetUserId = targetUser?.id
        val actorLogin = actorUser?.login ?: message.sender?.slug ?: message.sender?.username?.lowercase(Locale.ROOT)
        val actorName = actorUser?.name ?: message.sender?.username
        val actorUserId = actorUser?.id ?: message.sender?.id?.toString() ?: message.userId?.toString()
        val targetDisplayName = targetName ?: targetLogin
        val actorDisplayName = actorName ?: actorLogin
        val moderationInlineMsg = when (moderationType) {
            KickModerationType.TIMEOUT -> {
                val durationSeconds = extractKickModerationDurationSeconds(message, eventName)
                if (targetDisplayName != null && durationSeconds != null) {
                    if (actorDisplayName != null) {
                        "$targetDisplayName was timed out by $actorDisplayName for ${KickApiHelper.getDurationFromSeconds(context, durationSeconds.toString())}"
                    } else {
                        "$targetDisplayName was timed out for ${KickApiHelper.getDurationFromSeconds(context, durationSeconds.toString())}"
                    }
                } else if (targetDisplayName != null) {
                    if (actorDisplayName != null) {
                        "$targetDisplayName was timed out by $actorDisplayName"
                    } else {
                        "$targetDisplayName was timed out"
                    }
                } else {
                    null
                }
            }
            KickModerationType.BAN -> targetDisplayName?.let {
                if (actorDisplayName != null) {
                    "$it was banned by $actorDisplayName"
                } else {
                    "$it was banned"
                }
            }
            KickModerationType.UNBAN -> targetDisplayName?.let {
                if (actorDisplayName != null) {
                    "$it was unbanned by $actorDisplayName"
                } else {
                    "$it was unbanned"
                }
            }
            KickModerationType.UNTIMEOUT -> targetDisplayName?.let {
                if (actorDisplayName != null) {
                    "$it was untimed out by $actorDisplayName"
                } else {
                    "$it was untimed out"
                }
            }
            else -> null
        }
        val moderationSystemMsg = when (moderationType) {
            KickModerationType.CLEAR_CHAT -> ContextCompat.getString(context, R.string.chat_clear)
            KickModerationType.TIMEOUT,
            KickModerationType.BAN,
            KickModerationType.UNBAN,
            KickModerationType.UNTIMEOUT -> moderationInlineMsg
            else -> null
        }
        val systemMsg = moderationSystemMsg ?: extractKickSubscriptionNotice(message, eventName, targetUser)
        val effectiveUserId = if (moderationSystemMsg != null) {
            null
        } else if (moderationInlineMsg != null) {
            actorUserId
        } else {
            message.sender?.id?.toString() ?: message.userId?.toString() ?: targetUserId
        }
        val effectiveUserLogin = if (moderationSystemMsg != null) {
            null
        } else if (moderationInlineMsg != null) {
            actorLogin
        } else {
            message.sender?.slug ?: message.sender?.username?.lowercase(Locale.ROOT) ?: targetLogin
        }
        val effectiveUserName = if (moderationSystemMsg != null) {
            null
        } else if (moderationInlineMsg != null) {
            actorName
        } else {
            message.sender?.username ?: targetName
        }
        val effectiveMessage = when {
            moderationType == KickModerationType.DELETE_MESSAGE -> content
            moderationSystemMsg != null -> null
            moderationInlineMsg != null -> moderationInlineMsg
            else -> content?.takeIf { systemMsg == null }
        }
        return ChatMessage(
            id = message.id,
            userId = effectiveUserId,
            userLogin = effectiveUserLogin,
            userName = effectiveUserName,
            message = effectiveMessage,
            color = message.sender?.identity?.color,
            badges = badges,
            systemMsg = systemMsg,
            msgId = when (moderationType) {
                KickModerationType.DELETE_MESSAGE -> "kick_clearmsg"
                KickModerationType.CLEAR_CHAT,
                KickModerationType.TIMEOUT,
                KickModerationType.BAN,
                KickModerationType.UNBAN,
                KickModerationType.UNTIMEOUT -> if (moderationInlineMsg != null) null else "kick_moderation"
                KickModerationType.NONE -> null
            },
            reply = reply,
            timestamp = normalizeDate(message.createdAt)?.let { KickApiHelper.parseIso8601DateUTC(it) },
            fullMsg = rawContent ?: content ?: message.type ?: eventName
        )
    }

    fun getKickModerationTargetUserInfo(message: KickMessage): Triple<String?, String?, String?> {
        val user = extractKickTargetUser(message)
        return Triple(user?.id, user?.login, user?.name)
    }

    private fun resolveKickBadgeType(badge: KickMessageBadge): String? {
        return badge.type?.trim()?.takeIf { it.isNotBlank() }
            ?: badge.badgeType?.trim()?.takeIf { it.isNotBlank() }
            ?: badge.name?.trim()?.takeIf { it.isNotBlank() }
            ?: badge.slug?.trim()?.takeIf { it.isNotBlank() }
            ?: badge.text?.trim()?.takeIf { it.isNotBlank() }
    }

    private fun resolveKickBadgeVersion(badge: KickMessageBadge): String {
        val parsedFromText = badge.text
            ?.let { Regex("""(\d{1,3})""").find(it) }
            ?.groupValues
            ?.getOrNull(1)
            ?.toIntOrNull()
        return (badge.count ?: badge.months ?: badge.level ?: badge.tier ?: badge.version ?: parsedFromText ?: 1).toString()
    }

    private fun syntheticKickBadgesFromSender(
        sender: KickMessageSender?,
    ): List<KickMessageBadge> {
        if (sender == null) return emptyList()
        val synthetic = mutableListOf<KickMessageBadge>()

        fun addSynthetic(badge: KickMessageBadge) {
            synthetic += badge
        }

        sender.role?.takeIf { it.isNotBlank() }?.let { role ->
            addSynthetic(KickMessageBadge(
                type = role,
                text = role.replace('_', ' ').replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            ))
        }
        if (sender.isVerified == true || sender.verified == true) {
            addSynthetic(KickMessageBadge(type = "verified", text = "Verified"))
        }
        if (sender.isSuperAdmin == true) {
            addSynthetic(KickMessageBadge(type = "staff", text = "Staff"))
        }
        sender.followerBadges.orEmpty().forEach { followerBadge ->
            followerBadge.takeIf { it.isNotBlank() }?.let { label ->
                addSynthetic(KickMessageBadge(type = label, text = label))
            }
        }
        if (sender.isFounder == true) {
            addSynthetic(KickMessageBadge(
                type = "founder",
                text = "Founder",
                count = sender.monthsSubscribed
            ))
        }
        sender.quantityGifted?.takeIf { it > 0 }?.let { giftedCount ->
            addSynthetic(KickMessageBadge(
                type = "sub_gifter",
                text = "Sub Gifter",
                count = giftedCount
            ))
        }
        return synthetic
    }

    fun isKickSingleMessageDelete(message: KickMessage, eventName: String? = null): Boolean {
        return resolveKickModerationType(message, eventName) == KickModerationType.DELETE_MESSAGE
    }

    fun getKickModerationTargetMessageId(message: KickMessage): String? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val deletedMessage = message.deletedMessage.asJsonObjectOrNull()
        return firstNonBlank(
            message.targetMessageId,
            deletedMessage?.firstPrimitiveOrNull("id", "message_id", "target_message_id", "uuid"),
            metadata?.firstPrimitiveOrNull("target_message_id", "message_id", "deleted_message_id"),
            metadata?.firstObjectOrNull("target_message")?.firstPrimitiveOrNull("id", "message_id", "uuid"),
            metadata?.firstObjectOrNull("deleted_message")?.firstPrimitiveOrNull("id", "message_id", "uuid"),
            // Kick MessageDeletedEvent can place the deleted chat message id directly on the event object itself.
            message.id
        )
    }

    private fun extractKickReply(message: KickMessage): Reply? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val hasReplyMetadata = metadata?.let {
            it.firstObjectOrNull("reply", "reply_to", "reply_to_message", "parent_message", "replied_to_message", "original_message", "reply_parent", "thread_parent") != null ||
                it.firstPrimitiveOrNull("thread_parent_id", "parent_message_id", "reply_to_message_id") != null
        } == true
        val hasExplicitReplyFields = message.replyToMessage != null ||
            message.replyTo != null ||
            !message.replyToMessageId.isNullOrBlank() ||
            !message.parentMessageId.isNullOrBlank()
        val isReplyType = message.type.equals("reply", ignoreCase = true)
        if (!isReplyType && !hasExplicitReplyFields && !hasReplyMetadata) {
            return null
        }
        val replyObject = listOfNotNull(
            message.replyToMessage.asJsonObjectOrNull(),
            message.replyTo.asJsonObjectOrNull(),
            metadata?.firstObjectOrNull("reply", "reply_to", "reply_to_message", "parent_message", "replied_to_message", "original_message"),
            metadata?.firstObjectOrNull("reply_parent", "thread_parent")
        ).firstOrNull()
        val threadParentId = firstNonBlank(
            message.replyToMessageId,
            message.parentMessageId,
            replyObject?.firstPrimitiveOrNull("thread_parent_id", "thread_id", "parent_message_id", "reply_to_message_id", "id", "message_id", "uuid"),
            metadata?.firstPrimitiveOrNull("thread_parent_id", "thread_id", "parent_message_id", "reply_to_message_id"),
            metadata?.firstObjectOrNull("thread_parent")?.firstPrimitiveOrNull("id", "message_id", "uuid"),
            metadata?.firstObjectOrNull("parent_message")?.firstPrimitiveOrNull("id", "message_id", "uuid"),
            message.threadParentId,
            message.threadId
        ) ?: return null
        val replyUser = extractUserFromObject(replyObject)
        return Reply(
            threadParentId = threadParentId,
            userLogin = replyUser?.login ?: replyObject?.firstPrimitiveOrNull("user_login", "username", "slug", "login"),
            userName = replyUser?.name ?: replyObject?.firstPrimitiveOrNull("display_name", "user_name", "name"),
            message = extractKickMessageContent(replyObject)
        )
    }

    private fun extractKickTargetUser(message: KickMessage): KickResolvedUser? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val candidates = listOfNotNull(
            message.user.asJsonObjectOrNull(),
            message.targetUser.asJsonObjectOrNull(),
            message.target.asJsonObjectOrNull(),
            message.deletedMessage.asJsonObjectOrNull()?.firstObjectOrNull("sender", "user", "target_user"),
            metadata?.firstObjectOrNull("target_user", "target", "user", "subject", "banned_user", "timed_out_user", "affected_user", "recipient", "member"),
            metadata?.firstObjectOrNull("deleted_message")?.firstObjectOrNull("sender", "user", "target_user"),
            metadata?.firstObjectOrNull("ban")?.firstObjectOrNull("user", "target_user", "banned_user"),
            metadata?.firstObjectOrNull("timeout")?.firstObjectOrNull("user", "target_user", "timed_out_user")
        )
        candidates.firstNotNullOfOrNull(::extractUserFromObject)?.let { return it }

        val id = firstNonBlank(
            findPrimitiveRecursive(message.metadata, setOf("target_user_id", "banned_user_id", "timed_out_user_id", "affected_user_id", "user_id")),
            findPrimitiveRecursive(message.targetUser, setOf("target_user_id", "banned_user_id", "timed_out_user_id", "affected_user_id", "user_id")),
            findPrimitiveRecursive(message.target, setOf("target_user_id", "banned_user_id", "timed_out_user_id", "affected_user_id", "user_id"))
        )
        val login = firstNonBlank(
            findPrimitiveRecursive(message.metadata, setOf("target_user_login", "target_login", "banned_user_login", "timed_out_user_login", "affected_user_login", "user_login", "login", "slug")),
            findPrimitiveRecursive(message.metadata, setOf("target_user_username", "target_username", "banned_user_username", "timed_out_user_username", "affected_user_username", "username"))?.lowercase(Locale.ROOT),
            findPrimitiveRecursive(message.targetUser, setOf("target_user_login", "target_login", "banned_user_login", "timed_out_user_login", "affected_user_login", "user_login", "login", "slug")),
            findPrimitiveRecursive(message.target, setOf("target_user_login", "target_login", "banned_user_login", "timed_out_user_login", "affected_user_login", "user_login", "login", "slug"))
        )
        val name = firstNonBlank(
            findPrimitiveRecursive(message.metadata, setOf("target_user_name", "target_name", "banned_user_name", "banned_user_username", "timed_out_user_name", "timed_out_user_username", "affected_user_name", "affected_user_username", "display_name", "username", "name")),
            findPrimitiveRecursive(message.targetUser, setOf("target_user_name", "target_name", "banned_user_name", "timed_out_user_name", "affected_user_name", "display_name", "username", "name")),
            findPrimitiveRecursive(message.target, setOf("target_user_name", "target_name", "banned_user_name", "timed_out_user_name", "affected_user_name", "display_name", "username", "name"))
        )
        return if (id.isNullOrBlank() && login.isNullOrBlank() && name.isNullOrBlank()) {
            null
        } else {
            KickResolvedUser(id = id, login = login, name = name)
        }
    }

    private fun extractKickModeratorUser(message: KickMessage): KickResolvedUser? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val candidates = listOfNotNull(
            message.bannedBy.asJsonObjectOrNull(),
            message.unbannedBy.asJsonObjectOrNull(),
            message.timedOutBy.asJsonObjectOrNull(),
            message.sender?.let {
                buildJsonObject {
                    it.id?.let { id -> put("id", JsonPrimitive(id)) }
                    it.slug?.let { slug -> put("slug", JsonPrimitive(slug)) }
                    it.username?.let { username -> put("username", JsonPrimitive(username)) }
                }
            }.takeIf { it?.isNotEmpty() == true },
            metadata?.firstObjectOrNull("banned_by", "unbanned_by", "timed_out_by", "moderated_by", "actor", "moderator"),
            message.target.asJsonObjectOrNull()?.firstObjectOrNull("banned_by", "unbanned_by", "timed_out_by", "moderated_by", "actor", "moderator"),
            message.targetUser.asJsonObjectOrNull()?.firstObjectOrNull("banned_by", "unbanned_by", "timed_out_by", "moderated_by", "actor", "moderator")
        )
        return candidates.firstNotNullOfOrNull(::extractUserFromObject)
    }

    private fun extractUserFromObject(obj: JsonObject?): KickResolvedUser? {
        obj ?: return null
        val nestedUser = obj.firstObjectOrNull("user", "sender")
        val source = nestedUser ?: obj
        val id = source.firstPrimitiveOrNull("id", "user_id", "target_user_id")
        val login = source.firstPrimitiveOrNull("slug", "login", "user_login")
            ?: source.firstPrimitiveOrNull("username")?.lowercase(Locale.ROOT)
        val name = source.firstPrimitiveOrNull("username", "display_name", "user_name", "name")
        if (id.isNullOrBlank() && login.isNullOrBlank() && name.isNullOrBlank()) {
            return null
        }
        return KickResolvedUser(id = id, login = login, name = name)
    }

    private fun extractKickMessageContent(obj: JsonObject?): String? {
        obj ?: return null
        return firstNonBlank(
            obj.firstPrimitiveOrNull("content", "message", "text", "body"),
            obj.firstObjectOrNull("message")?.firstPrimitiveOrNull("content", "message", "text", "body"),
            obj.firstObjectOrNull("content")?.firstPrimitiveOrNull("text", "body", "message")
        )?.replace(emoteRegex) { result -> result.groupValues.getOrElse(1) { "" } }
    }

    private fun extractKickModerationDurationSeconds(message: KickMessage, eventName: String? = null): Long? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val durationObject = message.duration.asJsonObjectOrNull()
        val explicitSeconds = listOfNotNull(
            message.durationSeconds,
            durationObject?.firstLongOrNull("seconds", "duration", "duration_seconds"),
            metadata?.firstLongOrNull("duration_seconds", "duration", "seconds"),
            metadata?.firstLongOrNull("timeout", "timeout_seconds", "expires_in", "ban_duration", "length"),
            metadata?.firstObjectOrNull("duration")?.firstLongOrNull("seconds", "duration"),
            metadata?.firstObjectOrNull("timeout")?.firstLongOrNull("seconds", "duration", "duration_seconds", "expires_in"),
            metadata?.firstObjectOrNull("ban")?.firstLongOrNull("seconds", "duration", "duration_seconds", "expires_in"),
            findLongRecursive(message.metadata, setOf("duration_seconds", "timeout_seconds", "expires_in", "ban_duration", "length", "seconds")),
            findLongRecursive(message.target, setOf("duration_seconds", "timeout_seconds", "expires_in", "ban_duration", "length", "seconds")),
            findLongRecursive(message.targetUser, setOf("duration_seconds", "timeout_seconds", "expires_in", "ban_duration", "length", "seconds"))
        ).firstOrNull { it >= 0L }
        if (explicitSeconds != null) {
            return explicitSeconds
        }
        val rawDuration = message.duration.asLongOrNull()
        val normalizedEvent = eventName?.lowercase(Locale.ROOT).orEmpty()
        return when {
            rawDuration == null || rawDuration < 0L -> null
            normalizedEvent.contains("userbannedevent") -> rawDuration * 60L
            else -> rawDuration
        }
    }

    private fun extractKickSubscriptionNotice(message: KickMessage, eventName: String?, targetUser: KickResolvedUser?): String? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val normalized = buildList {
            eventName?.let(::add)
            message.type?.let(::add)
            metadata?.firstPrimitiveOrNull("type", "event", "action", "name")?.let(::add)
        }
            .map { it.trim().lowercase(Locale.ROOT) }
            .filter { it.isNotBlank() }
            .joinToString("|")
        if (normalized.isBlank()) {
            return null
        }
        val senderName = message.sender?.username ?: message.sender?.slug ?: message.userId?.toString()
        if (senderName.isNullOrBlank()) {
            return null
        }
        if (normalized.contains("gift") && normalized.contains("sub")) {
            val giftCount = extractKickGiftCount(message)
            val targetName = targetUser?.name ?: targetUser?.login
            return when {
                giftCount != null && giftCount > 1L -> {
                    ContextCompat.getString(context, R.string.kick_gifted_subs).format(senderName, giftCount)
                }
                !targetName.isNullOrBlank() -> {
                    ContextCompat.getString(context, R.string.kick_gifted_sub_to).format(senderName, targetName)
                }
                else -> {
                    ContextCompat.getString(context, R.string.kick_gifted_sub).format(senderName)
                }
            }
        }
        return null
    }

    private fun extractKickGiftCount(message: KickMessage): Long? {
        val metadata = message.metadata.asJsonObjectOrNull()
        return listOfNotNull(
            metadata?.firstLongOrNull("gifted_count", "gifts_count", "gift_count", "count", "quantity", "amount", "total"),
            metadata?.firstObjectOrNull("gift", "gifts", "subscription", "subscriptions")?.firstLongOrNull("count", "quantity", "amount", "total"),
            message.target.asJsonObjectOrNull()?.firstLongOrNull("count", "quantity", "amount", "total"),
            message.targetUser.asJsonObjectOrNull()?.firstLongOrNull("count", "quantity", "amount", "total")
        ).firstOrNull { it > 0L }
    }

    private fun resolveKickModerationType(message: KickMessage, eventName: String?): KickModerationType {
        val metadata = message.metadata.asJsonObjectOrNull()
        val permanent = listOfNotNull(
            (message.target as? JsonObject)?.get("permanent") as? JsonPrimitive,
            (message.targetUser as? JsonObject)?.get("permanent") as? JsonPrimitive,
            metadata?.get("permanent") as? JsonPrimitive
        ).firstNotNullOfOrNull {
            it.contentOrNull?.trim()?.lowercase(Locale.ROOT)?.let { value ->
                when (value) {
                    "true" -> true
                    "false" -> false
                    else -> null
                }
            }
        }
        val hasFiniteDuration = extractKickModerationDurationSeconds(message)?.let { it > 0L } == true
        val normalized = buildList {
            eventName?.let(::add)
            message.type?.let(::add)
            metadata?.firstPrimitiveOrNull("type", "event", "action", "name")?.let(::add)
        }
            .map { it.trim().lowercase(Locale.ROOT) }
            .filter { it.isNotBlank() }
            .joinToString("|")
        if (normalized.isBlank()) {
            return KickModerationType.NONE
        }
        return when {
            listOf("deleted", "delete", "clearmsg", "message_removed", "message_deleted").any { normalized.contains(it) } -> KickModerationType.DELETE_MESSAGE
            listOf("clear_chat", "chat_cleared", "messages_cleared", "clearchat").any { normalized.contains(it) } -> KickModerationType.CLEAR_CHAT
            listOf("untimeout", "timed_in", "timeout_removed").any { normalized.contains(it) } -> KickModerationType.UNTIMEOUT
            listOf("unban", "ban_removed").any { normalized.contains(it) } -> KickModerationType.UNBAN
            (normalized.contains("userbannedevent") || normalized.contains("banned")) && (permanent == false || hasFiniteDuration) -> KickModerationType.TIMEOUT
            (normalized.contains("userunbannedevent") || normalized.contains("unbanned")) && permanent == false -> KickModerationType.UNTIMEOUT
            listOf("timeout", "timed_out").any { normalized.contains(it) } -> KickModerationType.TIMEOUT
            listOf("banned", "ban").any { normalized.contains(it) } -> KickModerationType.BAN
            else -> KickModerationType.NONE
        }
    }

    private fun firstNonBlank(vararg values: String?): String? {
        return values.firstOrNull { !it.isNullOrBlank() }?.trim()
    }

    fun matchesQuery(item: KickLivestream, query: String): Boolean {
        val value = query.trim().lowercase(Locale.ROOT)
        if (value.isBlank()) return true
        return item.title?.contains(value, true) == true ||
                item.channel?.slug?.contains(value, true) == true ||
                item.channel?.user?.username?.contains(value, true) == true ||
                item.categories?.any { category ->
                    category.name?.contains(value, true) == true || category.slug?.contains(value, true) == true
                } == true
    }

    fun matchesQuery(item: KickSubcategory, query: String): Boolean {
        val value = query.trim().lowercase(Locale.ROOT)
        if (value.isBlank()) return true
        return item.name?.contains(value, true) == true || item.slug?.contains(value, true) == true
    }

    fun getPlayableUrl(channel: KickChannelResponse): String? {
        return channel.livestream?.playbackUrl ?: channel.playbackUrl
    }

    fun getChatroomId(channel: KickChannelResponse): String? {
        return channel.chatroom?.id?.toString()
    }

    private fun cacheKickBadgeUrls(channel: KickChannelResponse): Boolean {
        var changed = false
        val scopeIds = listOfNotNull(
            channel.chatroom?.id?.toString()?.takeIf { it.isNotBlank() },
            channel.id?.toString()?.takeIf { it.isNotBlank() }
        ).distinct()
        val channelBadges = buildList {
            addAll(channel.subscriberBadges.orEmpty())
            addAll(channel.founderBadges.orEmpty())
            addAll(channel.badges.orEmpty())
            addAll(channel.chatroom?.subscriberBadges.orEmpty())
            addAll(channel.chatroom?.founderBadges.orEmpty())
            addAll(channel.chatroom?.badges.orEmpty())
        }
        channelBadges.forEach { badge ->
            val type = badge.type?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.badgeType?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.name?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.slug?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.text?.trim()?.takeIf { it.isNotBlank() }
                ?: if (badge.months != null) "subscriber" else return@forEach
            val version = (badge.count ?: badge.months ?: badge.level ?: badge.tier ?: badge.version ?: 1).toString()
            val imageUrl = badge.badgeImageUrl
                ?: extractImageUrl(badge.badgeImage)
                ?: badge.imageUrl
                ?: extractImageUrl(badge.image)
                ?: badge.iconUrl
                ?: extractImageUrl(badge.icon)
                ?: badge.src
                ?: badge.url
                ?: return@forEach
            kickBadgeTypeCandidates(type).forEach { candidate ->
                if (isKickChannelSpecificBadgeType(candidate) && scopeIds.isNotEmpty()) {
                    scopeIds.forEach { scopeId ->
                        val scopedKey = "kick:chat:$scopeId:$candidate:$version"
                        if (kickBadgeUrls.put(scopedKey, imageUrl) != imageUrl) {
                            changed = true
                        }
                        if (cacheKickBadgeUrlIfAbsent("kick:chat:$scopeId:$candidate:default", imageUrl)) {
                            changed = true
                        }
                    }
                } else {
                    val key = "kick:$candidate:$version"
                    if (kickBadgeUrls.put(key, imageUrl) != imageUrl) {
                        changed = true
                    }
                    if (cacheKickBadgeUrlIfAbsent("kick:$candidate:default", imageUrl)) {
                        changed = true
                    }
                }
                if (isKickBadgeDebugEnabled() && candidate in setOf("moderator", "vip", "verified", "og", "founder", "sub_gifter", "broadcaster", "staff")) {
                    Log.d(badgeDebugTag, "cacheBadge candidate=$candidate version=$version hasUrl=${imageUrl.isNotBlank()} chatScope=${scopeIds.joinToString(",")}")
                }
            }
        }
        return changed
    }

    private fun resolveKickBadgeUrl(type: String, version: String, chatScopeId: String? = null): String? {
        val channelSpecific = isKickChannelSpecificBadgeType(type)
        kickBadgeTypeCandidates(type).forEach { candidate ->
            if (chatScopeId != null) {
                kickBadgeUrls["kick:chat:$chatScopeId:$candidate:$version"]?.takeIf { !isFallbackBadgeUrl(it) }?.let { return it }
                if (channelSpecific) {
                    resolveClosestChannelScopedBadgeUrl(chatScopeId, candidate, version)?.let { return it }
                }
                kickBadgeUrls["kick:chat:$chatScopeId:$candidate:default"]?.takeIf { !isFallbackBadgeUrl(it) }?.let { return it }
            }
            if (channelSpecific && chatScopeId != null) {
                return@forEach
            }
            kickBadgeUrls["kick:$candidate:$version"]?.takeIf { !isFallbackBadgeUrl(it) }?.let { return it }
            kickBadgeUrls["kick:$candidate:1"]?.takeIf { !isFallbackBadgeUrl(it) }?.let { return it }
            kickBadgeUrls["kick:$candidate:default"]?.takeIf { !isFallbackBadgeUrl(it) }?.let { return it }
        }
        return null
    }

    private fun isFallbackBadgeUrl(url: String): Boolean {
        return url.startsWith(kickLegacyBadgeFallbackBaseUrl, ignoreCase = true)
    }

    private fun hasAuthoritativeKickBadge(type: String): Boolean {
        return kickBadgeTypeCandidates(type).any { candidate ->
            kickBadgeUrls.entries.any { (key, url) ->
                (key.startsWith("kick:$candidate:") || key.contains(":$candidate:")) && !url.isNullOrBlank() && !isFallbackBadgeUrl(url)
            }
        }
    }

    private fun isKickChannelSpecificBadgeType(type: String): Boolean {
        return normalizeKickBadgeType(type) in kickChannelSpecificBadgeTypes
    }

    private fun resolveClosestChannelScopedBadgeUrl(chatScopeId: String, candidate: String, requestedVersion: String): String? {
        val requested = requestedVersion.toIntOrNull() ?: return null
        val prefix = "kick:chat:$chatScopeId:$candidate:"
        val scoped = kickBadgeUrls.entries
            .asSequence()
            .filter { (key, url) -> key.startsWith(prefix) && !url.isNullOrBlank() && !isFallbackBadgeUrl(url) }
            .mapNotNull { (key, url) ->
                val tier = key.removePrefix(prefix).toIntOrNull() ?: return@mapNotNull null
                tier to url
            }
            .toList()
        if (scoped.isEmpty()) return null
        val lowerOrEqual = scoped.filter { (tier, _) -> tier <= requested }.maxByOrNull { (tier, _) -> tier }
        if (lowerOrEqual != null) return lowerOrEqual.second
        return scoped.minByOrNull { (tier, _) -> tier }?.second
    }

    private fun unresolvedKickCanonicalBadgeTypes(): List<String> {
        return kickCanonicalBadgeTypes.filterNot(::hasAuthoritativeKickBadge)
    }

    private fun resolveKickInlineBadgeUrl(normalizedType: String, version: String? = null): String? {
        val dataUri = KickInlineBadgeData.forBadge(normalizedType, version) ?: return null
        val cacheKey = if (version != null) "$normalizedType:$version" else normalizedType
        return kickInlineBadgeSanitizedCache.computeIfAbsent(cacheKey) {
            sanitizeKickInlineBadgeDataUri(dataUri)
        }
    }

    private fun sanitizeKickInlineBadgeDataUri(dataUri: String): String {
        val prefix = "data:image/svg+xml;base64,"
        if (!dataUri.startsWith(prefix)) {
            return dataUri
        }
        val encoded = dataUri.removePrefix(prefix)
        val decodedSvg = runCatching {
            String(Base64.decode(encoded, Base64.DEFAULT), Charsets.UTF_8)
        }.getOrNull() ?: return dataUri
        val sanitizedSvg = decodedSvg
            .replace("clipPath=", "clip-path=")
            .replace("stopColor=", "stop-color=")
            .replace("stopOpacity=", "stop-opacity=")
            .replace("fillOpacity=", "fill-opacity=")
            .replace("strokeOpacity=", "stroke-opacity=")
            .replace("strokeWidth=", "stroke-width=")
            .replace("fillRule=", "fill-rule=")
            .replace("clipRule=", "clip-rule=")
            .replace("colorInterpolationFilters=", "color-interpolation-filters=")
        if (sanitizedSvg == decodedSvg) {
            return dataUri
        }
        val reEncoded = Base64.encodeToString(sanitizedSvg.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
        return prefix + reEncoded
    }

    private fun recordKickBadgeSource(source: KickBadgeSource) {
        val updated = synchronized(kickBadgeSourceStats) {
            val next = (kickBadgeSourceStats[source] ?: 0) + 1
            kickBadgeSourceStats[source] = next
            next
        }
        if (isKickBadgeDebugEnabled() && updated % 50 == 0) {
            val snapshot = synchronized(kickBadgeSourceStats) {
                kickBadgeSourceStats.entries.joinToString(",") { "${it.key.name}=${it.value}" }
            }
            Log.d(badgeDebugTag, "badge source counters $snapshot")
        }
    }

    private fun kickBadgeTypeCandidates(type: String): List<String> {
        val normalized = normalizeKickBadgeType(type)
        return linkedSetOf<String>().apply {
            add(normalized)
            when (normalized) {
                "subscriber" -> {
                    add("sub")
                    add("subscription")
                    add("subscribers")
                }
                "founder" -> {
                    add("founders")
                    add("founding")
                }
                "sub_gifter" -> {
                    add("gifter")
                    add("gift_sub")
                    add("gift_subscriber")
                    add("subscriber_gifter")
                    add("subscription_gifter")
                    add("subgift")
                    add("sub_gift")
                }
                "moderator" -> {
                    add("mod")
                    add("mods")
                    add("channel_moderator")
                    add("chat_moderator")
                }
                "broadcaster" -> {
                    add("host")
                    add("channel_host")
                    add("streamer")
                    add("owner")
                }
                "verified" -> {
                    add("verification")
                    add("verified_user")
                    add("is_verified")
                }
                "vip" -> {
                    add("vips")
                    add("channel_vip")
                }
                "staff" -> {
                    add("admin")
                    add("super_admin")
                    add("kick_staff")
                }
                "og" -> {
                    add("original")
                }
            }
        }.toList()
    }

    private fun normalizeKickBadgeType(type: String): String {
        val normalized = type.trim()
            .lowercase(Locale.ROOT)
            .replace('-', '_')
            .replace(' ', '_')
            .removePrefix("badge_")
            .replace(Regex("_badges?$"), "")
            .replace(Regex("_badge_?\\d*$"), "")
            .replace(Regex("_v\\d+$"), "")
            .replace(Regex("_\\d+$"), "")
            .trim('_')
        return when (normalized) {
            "sub", "subscription", "subscribers" -> "subscriber"
            "subgift", "sub_gift", "gift_sub", "gift_subscriber", "subscriber_gifter", "subscription_gifter", "gifter" -> "sub_gifter"
            "mod", "mods", "channel_moderator", "chat_moderator" -> "moderator"
            "host", "channel_host", "streamer", "owner" -> "broadcaster"
            "verification", "verified_user", "is_verified" -> "verified"
            "vips", "channel_vip" -> "vip"
            "kick_staff", "admin", "super_admin" -> "staff"
            "founders", "founding" -> "founder"
            "og", "original" -> "og"
            else -> when {
                normalized.contains("moderator") -> "moderator"
                normalized.contains("broadcaster") || normalized.contains("host") || normalized.contains("streamer") -> "broadcaster"
                normalized.contains("staff") || normalized.contains("admin") -> "staff"
                normalized.contains("vip") -> "vip"
                normalized.contains("verified") -> "verified"
                normalized.contains("founder") -> "founder"
                normalized.contains("gift") && normalized.contains("sub") -> "sub_gifter"
                normalized.contains("gifter") -> "sub_gifter"
                normalized.contains("sub") -> "subscriber"
                else -> normalized
            }
        }
    }

    private suspend fun prefetchKickBadgeCatalog(channel: KickChannelResponse) {
        val scopeIds = listOfNotNull(
            channel.chatroom?.id?.toString()?.takeIf { it.isNotBlank() },
            channel.id?.toString()?.takeIf { it.isNotBlank() }
        ).distinct()
        val urls = linkedSetOf<String>().apply {
            channel.chatroom?.id?.let { chatroomId ->
                add("https://kick.com/api/v1/chatrooms/$chatroomId")
                add("https://kick.com/api/v2/chatrooms/$chatroomId")
                add("https://kick.com/api/v2/chatrooms/$chatroomId/badges")
            }
            channel.id?.let { channelId ->
                add("https://kick.com/api/v2/channels/$channelId/info")
                add("https://kick.com/api/v2/channels/$channelId/chatroom")
                add("https://kick.com/api/v2/channels/$channelId/chatroom/badges")
                add("https://kick.com/api/v2/channels/$channelId/badges")
            }
            channel.slug?.takeIf { it.isNotBlank() }?.let { slug ->
                val encodedSlug = urlEncode(slug)
                add("https://kick.com/api/v2/channels/$encodedSlug/info")
                add("https://kick.com/api/v2/channels/$encodedSlug/chatroom")
                add("https://kick.com/api/v2/channels/$encodedSlug/chatroom/badges")
                add("https://kick.com/api/v2/channels/$encodedSlug/badges")
                add("https://kick.com/api/v1/$encodedSlug/chatroom")
                add("https://kick.com/api/v1/channels/$encodedSlug")
            }
        }
        urls.forEach { url ->
            runCatching { getRaw(url) }
                .onSuccess { body ->
                    runCatching { json.parseToJsonElement(body) }
                        .onSuccess { element ->
                            val added = cacheKickBadgeUrlsFromJson(element, scopeIds)
                            if (isKickBadgeDebugEnabled() && added > 0) {
                                Log.d(badgeDebugTag, "prefetch catalog matched $added entries from $url")
                            }
                        }
                }
                .onFailure {
                    if (isKickBadgeDebugEnabled()) {
                        Log.d(badgeDebugTag, "prefetch catalog skip $url: ${it.message}")
                    }
                }
        }
    }

    private suspend fun prefetchKickBadgeCatalogFromWeb(
        channel: KickChannelResponse,
        unresolvedTargetTypes: Set<String>,
    ): Int {
        if (unresolvedTargetTypes.isEmpty()) return 0
        var added = 0
        val scopeIds = listOfNotNull(
            channel.chatroom?.id?.toString()?.takeIf { it.isNotBlank() },
            channel.id?.toString()?.takeIf { it.isNotBlank() }
        ).distinct()
        val pageSlugs = linkedSetOf<String>().apply {
            channel.slug?.trim()?.takeIf { it.isNotBlank() }?.let(::add)
            add("kick")
        }
        pageSlugs.forEach { slug ->
            val pageUrl = "https://kick.com/${urlEncode(slug)}"
            val html = getRawWithBackoff(pageUrl, isKickWeb = true) ?: return@forEach
            val snapshot = runCatching {
                KickFeatureParsingUtils.extractKickWebBadgeSnapshot(html, pageUrl)
            }.getOrElse { error ->
                if (isKickBadgeDebugEnabled()) {
                    Log.w(badgeDebugTag, "web badge snapshot parse failed for $pageUrl: ${error.message}")
                }
                return@forEach
            }
            snapshot.jsonPayloads.forEach { payload ->
                added += cacheKickBadgeUrlsFromJson(payload, scopeIds)
            }
            if (unresolvedKickCanonicalBadgeTypes().none { it in unresolvedTargetTypes }) {
                return@forEach
            }
            snapshot.chunkUrls
                .asSequence()
                .distinct()
                .take(18)
                .forEach { chunkUrl ->
                    val body = kickChunkBodyCache[chunkUrl]
                        ?: getRawWithBackoff(chunkUrl, isKickWeb = true)?.also { fetched ->
                            if (kickChunkBodyCache.size < 64) {
                                kickChunkBodyCache[chunkUrl] = fetched
                            }
                        }
                        ?: return@forEach
                    val extracted = runCatching {
                        KickFeatureParsingUtils.extractKickGlobalBadgeUrlsFromChunk(body)
                    }.getOrElse { error ->
                        if (isKickBadgeDebugEnabled()) {
                            Log.w(badgeDebugTag, "web badge chunk parse failed for $chunkUrl: ${error.message}")
                        }
                        emptyMap()
                    }
                    extracted.forEach { (type, imageUrl) ->
                        if (type !in unresolvedTargetTypes) return@forEach
                        added += cacheKickExtractedBadgeUrl(type, "1", imageUrl)
                    }
                }
            if (unresolvedKickCanonicalBadgeTypes().none { it in unresolvedTargetTypes }) {
                return@forEach
            }
        }
        if (added > 0) {
            schedulePersistBadgeCache()
        }
        return added
    }

    private fun cacheKickBadgeUrlsFromJson(root: JsonElement, scopeIds: List<String> = emptyList()): Int {
        var added = 0

        fun stringValue(obj: JsonObject, keys: List<String>): String? {
            keys.forEach { key ->
                (obj[key] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }?.let { return it }
            }
            return null
        }

        fun intValue(obj: JsonObject, keys: List<String>): Int? {
            keys.forEach { key ->
                val primitive = obj[key] as? JsonPrimitive ?: return@forEach
                primitive.intOrNull?.let { return it }
                primitive.contentOrNull?.toIntOrNull()?.let { return it }
            }
            return null
        }

        fun walk(element: JsonElement, path: List<String>) {
            when (element) {
                is JsonObject -> {
                    val pathHasBadge = path.any { it.contains("badge") }
                    val objectHasBadgeKeys = element.keys.any { it.contains("badge", true) }
                    if (pathHasBadge || objectHasBadgeKeys) {
                        val type = stringValue(element, listOf("type", "badge_type", "name", "slug", "text"))
                            ?: inferKickBadgeTypeFromJsonPath(path)
                        val version = (intValue(element, listOf("count", "months", "level", "tier", "version")) ?: 1).toString()
                        val imageUrl = stringValue(element, listOf("badge_image_url", "badge_url", "image_url", "icon_url", "url", "src"))
                            ?: extractImageUrl(element["badge_image"])
                            ?: extractImageUrl(element["image"])
                            ?: extractImageUrl(element["icon"])
                            ?: extractImageUrl(element["badge"])
                        if (!type.isNullOrBlank() && !imageUrl.isNullOrBlank()) {
                            kickBadgeTypeCandidates(type).forEach { candidate ->
                                if (isKickChannelSpecificBadgeType(candidate) && scopeIds.isNotEmpty()) {
                                    scopeIds.forEach { scopeId ->
                                        val key = "kick:chat:$scopeId:$candidate:$version"
                                        if (kickBadgeUrls.put(key, imageUrl) == null) {
                                            added += 1
                                        }
                                        cacheKickBadgeUrlIfAbsent("kick:chat:$scopeId:$candidate:default", imageUrl)
                                    }
                                } else {
                                    val key = "kick:$candidate:$version"
                                    if (kickBadgeUrls.put(key, imageUrl) == null) {
                                        added += 1
                                    }
                                    cacheKickBadgeUrlIfAbsent("kick:$candidate:default", imageUrl)
                                }
                            }
                        }
                    }
                    element.forEach { (key, value) ->
                        walk(value, path + key.lowercase(Locale.ROOT))
                    }
                }
                is JsonArray -> element.forEach { child -> walk(child, path) }
                else -> Unit
            }
        }

        walk(root, emptyList())
        if (added > 0) {
            schedulePersistBadgeCache()
        }
        return added
    }

    private fun extractImageUrl(element: JsonElement?): String? {
        return when (element) {
            null -> null
            is JsonPrimitive -> element.contentOrNull?.takeIf { it.isNotBlank() }
            is JsonObject -> {
                listOf(
                    "4x", "4", "3x", "3", "2x", "2", "1x", "1",
                    "fullsize", "medium", "small", "large", "thumbnail", "thumb", "original",
                    "src", "url", "image_url", "badge_image_url", "icon", "icon_url"
                ).forEach { key ->
                    val value = (element[key] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
                    if (!value.isNullOrBlank()) {
                        return value
                    }
                }
                listOf("srcset", "responsive").forEach { key ->
                    val value = (element[key] as? JsonPrimitive)?.contentOrNull
                        ?.let(::extractUrlFromImageSet)
                    if (!value.isNullOrBlank()) {
                        return value
                    }
                }
                element.values.forEach { value ->
                    extractImageUrl(value)?.let { return it }
                }
                null
            }
            is JsonArray -> {
                element.forEach { value ->
                    extractImageUrl(value)?.let { return it }
                }
                null
            }
        }
    }

    private fun cacheKickBadgeUrlIfAbsent(key: String, imageUrl: String): Boolean {
        synchronized(kickBadgeUrls) {
            if (kickBadgeUrls.containsKey(key)) {
                return false
            }
            kickBadgeUrls[key] = imageUrl
            return true
        }
    }

    private fun cacheKickExtractedBadgeUrl(type: String, version: String, imageUrl: String): Int {
        if (imageUrl.isBlank() || isFallbackBadgeUrl(imageUrl)) {
            return 0
        }
        var changed = 0
        kickBadgeTypeCandidates(type).forEach { candidate ->
            val versionKey = "kick:$candidate:$version"
            val existingVersion = kickBadgeUrls[versionKey]
            if (existingVersion.isNullOrBlank() || isFallbackBadgeUrl(existingVersion)) {
                if (kickBadgeUrls.put(versionKey, imageUrl) != imageUrl) {
                    changed += 1
                }
            }
            val defaultKey = "kick:$candidate:default"
            val existingDefault = kickBadgeUrls[defaultKey]
            if (existingDefault.isNullOrBlank() || isFallbackBadgeUrl(existingDefault)) {
                if (kickBadgeUrls.put(defaultKey, imageUrl) != imageUrl) {
                    changed += 1
                }
            }
        }
        return changed
    }

    private fun parseChannelLivestream(root: JsonElement): KickChannelLivestream? {
        val payload = when (root) {
            is JsonObject -> root.objOrNull("data")
                ?: root.firstObjectOrNull("livestream", "stream")
                ?: root
            else -> null
        } ?: return null

        val categoryObject = payload.firstObjectOrNull("category", "subcategory")
            ?: payload.arrayOrNull("categories")?.firstOrNull()?.asJsonObjectOrNull()
        val category = categoryObject?.let {
            KickCategory(
                id = it.firstLongOrNull("id"),
                name = it.firstPrimitiveOrNull("name", "title"),
                slug = it.firstPrimitiveOrNull("slug"),
            )
        }

        val thumbnail = payload.objOrNull("thumbnail")?.let {
            KickThumbnail(
                src = it.primitiveOrNull("src"),
                url = it.firstPrimitiveOrNull("url", "image_url", "thumbnail_url", "preview_thumbnail_url"),
                srcset = it.primitiveOrNull("srcset"),
                responsive = it.primitiveOrNull("responsive"),
            )
        } ?: payload.firstPrimitiveOrNull("thumbnail_url", "preview_thumbnail_url", "poster", "poster_url")?.let {
            KickThumbnail(url = it)
        }

        return KickChannelLivestream(
            id = payload.firstLongOrNull("id", "livestream_id"),
            createdAt = payload.firstPrimitiveOrNull("created_at", "start_time", "started_at"),
            title = payload.firstPrimitiveOrNull("session_title", "title", "name"),
            viewerCount = payload.intOrNull("viewer_count")
                ?: payload.intOrNull("viewers")
                ?: payload.intOrNull("viewers_count"),
            playbackUrl = payload.firstPrimitiveOrNull("playback_url", "playlist_url", "hls_url"),
            thumbnail = thumbnail,
            category = category,
        )
    }

    private fun extractUrlFromImageSet(value: String): String? {
        return value.split(',')
            .asSequence()
            .map { candidate -> candidate.trim().substringBefore(' ').trim() }
            .firstOrNull { candidate -> candidate.isNotBlank() }
    }

    private fun maybeRefreshKickBadgeCatalogInBackground(channel: KickChannelResponse) {
        val channelCacheKey = channel.id?.toString() ?: channel.slug.orEmpty()
        if (channelCacheKey.isBlank()) return
        val now = System.currentTimeMillis()
        val lastRefresh = kickBadgeCatalogRefreshAt[channelCacheKey] ?: 0L
        if (now - lastRefresh < kickBadgeCacheTtlMs) return
        if (!kickBadgeCatalogRefreshInProgress.add(channelCacheKey)) return
        badgeCacheScope.launch {
            try {
                prefetchKickBadgeCatalog(channel)
                val unresolvedBeforeWeb = unresolvedKickCanonicalBadgeTypes().toSet()
                if (unresolvedBeforeWeb.isNotEmpty()) {
                    val webRefreshKey = "web:$channelCacheKey"
                    val lastWebRefresh = kickBadgeCatalogRefreshAt[webRefreshKey] ?: 0L
                    if (now - lastWebRefresh >= kickWebBadgeScrapeTtlMs) {
                        val webAdded = prefetchKickBadgeCatalogFromWeb(channel, unresolvedBeforeWeb)
                        kickBadgeCatalogRefreshAt[webRefreshKey] = System.currentTimeMillis()
                        if (isKickBadgeDebugEnabled()) {
                            val unresolvedAfterWeb = unresolvedKickCanonicalBadgeTypes().toSet()
                            Log.d(
                                badgeDebugTag,
                                "web badge prefetch channel=$channelCacheKey unresolvedBefore=${unresolvedBeforeWeb.joinToString(",")} unresolvedAfter=${unresolvedAfterWeb.joinToString(",")} added=$webAdded"
                            )
                        }
                    }
                }
                kickBadgeCatalogRefreshAt[channelCacheKey] = System.currentTimeMillis()
                schedulePersistBadgeCache()
            } catch (e: Exception) {
                if (isKickBadgeDebugEnabled()) {
                    Log.w(badgeDebugTag, "prefetch catalog failed for channel=$channelCacheKey: ${e.message}")
                }
            } finally {
                kickBadgeCatalogRefreshInProgress.remove(channelCacheKey)
            }
        }
    }

    private fun maybeRefreshKickBadgeCatalogOnAppOpenInBackground() {
        val refreshKey = "app_open_web"
        if (!kickBadgeCatalogRefreshInProgress.add(refreshKey)) return
        badgeCacheScope.launch {
            try {
                val channel = KickChannelResponse(slug = "kick")
                val targetTypes = kickCanonicalBadgeTypes.toSet()
                val webAdded = prefetchKickBadgeCatalogFromWeb(channel, targetTypes)
                kickBadgeCatalogRefreshAt[refreshKey] = System.currentTimeMillis()
                if (webAdded > 0) {
                    schedulePersistBadgeCache()
                }
                if (isKickBadgeDebugEnabled()) {
                    Log.d(badgeDebugTag, "app-open web badge refresh added=$webAdded")
                }
            } catch (e: Exception) {
                if (isKickBadgeDebugEnabled()) {
                    Log.w(badgeDebugTag, "app-open web badge refresh failed: ${e.message}")
                }
            } finally {
                kickBadgeCatalogRefreshInProgress.remove(refreshKey)
            }
        }
    }

    private fun schedulePersistBadgeCache() {
        if (badgePersistScheduled) return
        badgePersistScheduled = true
        badgeCacheScope.launch {
            try {
                delay(kickBadgeCachePersistDebounceMs)
                persistKickBadgeCacheToDisk()
            } finally {
                badgePersistScheduled = false
            }
        }
    }

    private fun persistKickBadgeCacheToDisk() {
        val snapshotUrls = kickBadgeUrls.toMap()
        val snapshotRefresh = kickBadgeCatalogRefreshAt.toMap()
        val payload = buildJsonObject {
            put("entries", buildJsonObject {
                snapshotUrls.forEach { (key, value) ->
                    put(key, JsonPrimitive(value))
                }
            })
            put("refreshed", buildJsonObject {
                snapshotRefresh.forEach { (key, value) ->
                    put(key, JsonPrimitive(value))
                }
            })
        }.toString()
        context.prefs().edit().putString(kickBadgeCacheKey, payload).apply()
    }

    private fun restoreKickBadgeCacheFromDisk() {
        val raw = context.prefs().getString(kickBadgeCacheKey, null) ?: return
        runCatching {
            json.parseToJsonElement(raw).jsonObject
        }.onSuccess { root ->
            val entries = root["entries"] as? JsonObject
            entries?.forEach { (key, value) ->
                val url = (value as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() } ?: return@forEach
                if (isFallbackBadgeUrl(url)) return@forEach
                kickBadgeUrls[key] = url
            }
            val refreshed = root["refreshed"] as? JsonObject
            refreshed?.forEach { (key, value) ->
                val ts = (value as? JsonPrimitive)?.longOrNull ?: (value as? JsonPrimitive)?.contentOrNull?.toLongOrNull() ?: return@forEach
                if (ts > 0L) {
                    kickBadgeCatalogRefreshAt[key] = ts
                }
            }
        }.onFailure {
            if (isKickBadgeDebugEnabled()) {
                Log.w(badgeDebugTag, "restore badge cache failed: ${it.message}")
            }
        }
    }

    private suspend inline fun <reified T> get(url: String, isKickWeb: Boolean = false): T = withContext(Dispatchers.IO) {
        okHttpClient.newCall(
            createRequestBuilder(url, isKickWeb).build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick request failed (${response.code}) for $url")
            }
            val body = response.body.string()
            json.decodeFromString<T>(body)
        }
    }

    private suspend fun getRaw(url: String, isKickWeb: Boolean = false): String = withContext(Dispatchers.IO) {
        okHttpClient.newCall(
            createRequestBuilder(url, isKickWeb).build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick request failed (${response.code}) for $url")
            }
            response.body.string()
        }
    }

    private suspend fun getRawWithBackoff(url: String, isKickWeb: Boolean = false, maxAttempts: Int = 3): String? {
        var backoffMs = 400L
        repeat(maxAttempts) { attempt ->
            val result = runCatching { getRaw(url, isKickWeb = isKickWeb) }
            result.getOrNull()?.let { return it }
            if (attempt == maxAttempts - 1) {
                return null
            }
            delay(backoffMs)
            backoffMs = (backoffMs * 2L).coerceAtMost(2_000L)
        }
        return null
    }

    private suspend fun requireKickAccessToken(networkLibrary: String?): String {
        val headers = getHelixHeadersWithRefresh(networkLibrary)
        return headers[C.HEADER_TOKEN]
            ?.removePrefix("Bearer ")
            ?.trim()
            ?.takeIf { it.isNotBlank() }
            ?: throw IOException("Kick login is required.")
    }

    private suspend fun getRawAuthenticated(
        url: String,
        accessToken: String,
        isKickWeb: Boolean = false,
        kickPlatformWeb: Boolean = false,
    ): String = withContext(Dispatchers.IO) {
        val clientId = KickOAuthConfig.getClientId(context)
        okHttpClient.newCall(
            createRequestBuilder(url, isKickWeb)
                .header("Authorization", "Bearer $accessToken")
                .apply {
                    if (url.contains("api.kick.com/") && !clientId.isNullOrBlank()) {
                        header("Client-Id", clientId)
                    }
                    if (kickPlatformWeb) {
                        header("x-kick-platform", "web")
                        header("Accept", "application/json, text/plain, */*")
                    }
                }
                .build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick request failed (${response.code}) for $url")
            }
            response.body.string()
        }
    }

    private fun createRequestBuilder(url: String, isKickWeb: Boolean = false): Request.Builder {
        return Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            .header("Accept", "application/json")
            .apply {
                if (isKickWeb) {
                    header("Origin", "https://kick.com")
                    header("Referer", buildKickWebReferer(url))
                    header("Accept", "application/json, text/plain, */*")
                    header("x-app-platform", "web")
                    header("x-kick-platform", "web")
                    getKickCookieHeader()?.let { cookies ->
                        header("Cookie", cookies)
                        extractKickWebAuthToken(cookies)?.let { webAuthToken ->
                            header("Authorization", "Bearer $webAuthToken")
                        }
                        extractKickXsrfToken(cookies)?.let { xsrfToken ->
                            header("X-XSRF-TOKEN", xsrfToken)
                        }
                    } ?: AuthStateHelper.getKickBearerToken(context)?.let { bearer ->
                        header("Authorization", bearer)
                    }
                }
            }
    }

    private fun getKickCookieHeader(): String? {
        return CookieManager.getInstance().getCookie("https://kick.com")?.takeIf { it.isNotBlank() }
            ?: CookieManager.getInstance().getCookie("https://web.kick.com")?.takeIf { it.isNotBlank() }
    }

    private fun hasKickWebsiteSessionCookie(): Boolean {
        val cookieHeader = getKickCookieHeader() ?: return false
        val cookieNames = cookieHeader
            .split(';')
            .asSequence()
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .map { it.substringBefore('=').trim().lowercase(Locale.ROOT) }
            .toSet()
        return cookieNames.any { it == "xsrf-token" || it == "session_token" || it.endsWith("_session") }
    }

    private fun extractKickXsrfToken(cookieHeader: String): String? {
        return cookieHeader
            .split(';')
            .asSequence()
            .map { it.trim() }
            .firstOrNull { it.startsWith("XSRF-TOKEN=", ignoreCase = true) }
            ?.substringAfter('=')
            ?.takeIf { it.isNotBlank() }
            ?.let { token ->
                runCatching { URLDecoder.decode(token, Charsets.UTF_8.name()) }.getOrDefault(token)
            }
    }

    private fun extractKickWebAuthToken(cookieHeader: String): String? {
        val rawCookieValue = cookieHeader
            .split(';')
            .asSequence()
            .map { it.trim() }
            .firstOrNull {
                it.startsWith("auth-token=", ignoreCase = true) ||
                    it.startsWith("session_token=", ignoreCase = true)
            }
            ?.substringAfter('=')
            ?.takeIf { it.isNotBlank() }
            ?: return null
        val decoded = runCatching { URLDecoder.decode(rawCookieValue, Charsets.UTF_8.name()) }.getOrDefault(rawCookieValue)
        return decoded.takeIf { it.isNotBlank() }
    }

    private fun buildKickWebReferer(url: String): String {
        val channelSlug = Regex("""https://kick\.com/api/v\d+/channels/([^/?]+)/""")
            .find(url)
            ?.groupValues
            ?.getOrNull(1)
            ?.takeIf { it.isNotBlank() }
        return when {
            url.contains("/followed-page") -> "https://kick.com/following/channels"
            !channelSlug.isNullOrBlank() -> "https://kick.com/$channelSlug"
            else -> "https://kick.com/"
        }
    }

    private fun generateKickTransactionId(): String {
        val alphabet = "0123456789ABCDEFGHJKMNPQRSTVWXYZ"
        val timestamp = System.currentTimeMillis()
        val chars = CharArray(26)
        var value = timestamp
        for (index in 9 downTo 0) {
            chars[index] = alphabet[(value % 32L).toInt()]
            value /= 32L
        }
        for (index in 10 until 26) {
            chars[index] = alphabet[kickUlidRandom.nextInt(32)]
        }
        return String(chars)
    }

    private fun normalizeDate(input: String?): String? {
        if (input.isNullOrBlank()) return null
        return when {
            input.contains('T') -> if (input.endsWith("Z") || input.contains("+")) input else "${input}Z"
            else -> input.replace(' ', 'T') + "Z"
        }
    }

    private fun urlEncode(value: String): String {
        return URLEncoder.encode(value, Charsets.UTF_8.name())
    }

    private fun JsonObject.primitiveOrNull(key: String): String? {
        return (this[key] as? JsonPrimitive)?.contentOrNull
    }

    private fun JsonObject.intOrNull(key: String): Int? {
        val primitive = this[key] as? JsonPrimitive ?: return null
        return primitive.intOrNull ?: primitive.contentOrNull?.toIntOrNull()
    }

    private fun JsonObject.firstPrimitiveOrNull(vararg keys: String): String? {
        keys.forEach { key ->
            primitiveOrNull(key)?.let { return it }
        }
        return null
    }

    private fun JsonObject.firstLongOrNull(vararg keys: String): Long? {
        keys.forEach { key ->
            (this[key] as? JsonPrimitive)?.let { primitive ->
                primitive.longOrNull?.let { return it }
                primitive.contentOrNull?.toLongOrNull()?.let { return it }
            }
        }
        return null
    }

    private fun JsonObject.objOrNull(key: String): JsonObject? {
        return this[key] as? JsonObject
    }

    private fun JsonObject.firstObjectOrNull(vararg keys: String): JsonObject? {
        keys.forEach { key ->
            objOrNull(key)?.let { return it }
        }
        return null
    }

    private fun JsonObject.arrayOrNull(key: String): JsonArray? {
        return this[key] as? JsonArray
    }

    private fun RoomState.toDebugString(): String {
        return "emote=${emote ?: "null"},followers=${followers ?: "null"},unique=${unique ?: "null"},slow=${slow ?: "null"},subs=${subs ?: "null"}"
    }

    private fun Map<String, JsonPrimitive>.toDebugString(): String {
        return entries.joinToString(separator = ",") { (key, value) ->
            "$key=${value.contentOrNull ?: value.toString()}"
        }
    }

    private fun MutableMap<String, JsonPrimitive>.putIfPrimitiveAbsent(canonical: String, value: JsonElement?) {
        if (canonical in this || value !is JsonPrimitive) return
        this[canonical] = value
    }

    private fun parseKickRoomState(root: JsonElement?): RoomState? {
        if (root == null) return null

        val values = linkedMapOf<String, JsonPrimitive>()
        val toggleModeKeys = setOf(
            "emote_mode",
            "follower_mode",
            "slow_mode",
            "subscriber_mode",
            "unique_chat_mode",
        )
        val targetKeys = mapOf(
            "emote_mode" to "emote_mode",
            "emotemode" to "emote_mode",
            "emotes_mode" to "emote_mode",
            "emotesmode" to "emote_mode",
            "emoteonly" to "emote_mode",
            "follower_mode" to "follower_mode",
            "followermode" to "follower_mode",
            "followers_mode" to "follower_mode",
            "followersmode" to "follower_mode",
            "follower_mode_duration_minutes" to "follower_mode_duration_minutes",
            "followermodedurationminutes" to "follower_mode_duration_minutes",
            "followers_only_min_duration" to "follower_mode_duration_minutes",
            "following_min_duration" to "follower_mode_duration_minutes",
            "followingminduration" to "follower_mode_duration_minutes",
            "slow_mode" to "slow_mode",
            "slowmode" to "slow_mode",
            "slow_mode_wait_time_seconds" to "slow_mode_wait_time_seconds",
            "slowmodewaittimeseconds" to "slow_mode_wait_time_seconds",
            "slow_mode_wait_time" to "slow_mode_wait_time_seconds",
            "message_interval" to "slow_mode_wait_time_seconds",
            "messageinterval" to "slow_mode_wait_time_seconds",
            "subscriber_mode" to "subscriber_mode",
            "subscribermode" to "subscriber_mode",
            "subscribers_mode" to "subscriber_mode",
            "subscribersmode" to "subscriber_mode",
            "subs_only" to "subscriber_mode",
            "submode" to "subscriber_mode",
            "unique_chat_mode" to "unique_chat_mode",
            "uniquechatmode" to "unique_chat_mode",
            "r9k" to "unique_chat_mode",
            "emote-only" to "emote_mode",
            "followers-only" to "follower_mode",
            "subs-only" to "subscriber_mode",
        )

        fun normalize(key: String): String {
            return key.lowercase(Locale.ROOT).replace(Regex("[^a-z0-9]"), "")
        }

        fun captureCanonicalValue(canonical: String, value: JsonElement) {
            when (value) {
                is JsonPrimitive -> values.putIfPrimitiveAbsent(canonical, value)
                is JsonObject -> {
                    if (canonical in toggleModeKeys) {
                        values.putIfPrimitiveAbsent(canonical, value["enabled"])
                    }
                    when (canonical) {
                        "follower_mode_duration_minutes" -> {
                            values.putIfPrimitiveAbsent(canonical, value["min_duration"])
                        }
                        "slow_mode_wait_time_seconds" -> {
                            values.putIfPrimitiveAbsent(
                                canonical,
                                value["message_interval"] ?: value["wait_time"] ?: value["duration_seconds"]
                            )
                        }
                    }
                }
                else -> Unit
            }
        }

        fun walk(element: JsonElement) {
            when (element) {
                is JsonObject -> {
                    element.forEach { (key, value) ->
                        val normalized = normalize(key)
                        val canonical = targetKeys[normalized]
                        if (canonical != null && canonical !in values) {
                            captureCanonicalValue(canonical, value)
                        }
                        if (value is JsonObject || value is JsonArray) {
                            walk(value)
                        }
                    }
                }
                is JsonArray -> element.forEach(::walk)
                else -> Unit
            }
        }

        fun JsonPrimitive.asBooleanOrNull(): Boolean? {
            return when (contentOrNull?.trim()?.lowercase(Locale.ROOT)) {
                "1", "true", "on", "enabled" -> true
                "0", "false", "off", "disabled" -> false
                else -> null
            }
        }

        fun JsonPrimitive.asIntOrNull(): Int? {
            return intOrNull ?: contentOrNull?.trim()?.toIntOrNull()
        }

        walk(root)
        if (values.isEmpty()) return null
        if (isKickFeatureDebugEnabled()) {
            Log.d(featureDebugTag, "roomState matchedFields=${values.toDebugString()}")
        }

        val emoteEnabled = values["emote_mode"]?.asBooleanOrNull()
        val followerEnabled = values["follower_mode"]?.asBooleanOrNull()
        val followerDuration = values["follower_mode_duration_minutes"]?.asIntOrNull()
        val slowEnabled = values["slow_mode"]?.asBooleanOrNull()
        val slowDuration = values["slow_mode_wait_time_seconds"]?.asIntOrNull()
        val subscriberEnabled = values["subscriber_mode"]?.asBooleanOrNull()
        val uniqueEnabled = values["unique_chat_mode"]?.asBooleanOrNull()
        if (isKickFeatureDebugEnabled() && slowEnabled == true && slowDuration == null) {
            Log.d(
                featureDebugTag,
                "roomState slowModeMissingDuration keys=${findInterestingKeyPaths(root, setOf("slow", "wait", "interval", "rate", "message")).take(16)} snippets=${extractInterestingKeySnippets(root, setOf("slow", "wait", "interval", "rate", "message"))}"
            )
        }

        return RoomState(
            emote = when (emoteEnabled) {
                true -> "1"
                false -> "0"
                null -> null
            },
            followers = when (followerEnabled) {
                true -> (followerDuration ?: 0).toString()
                false -> "-1"
                null -> null
            },
            unique = when (uniqueEnabled) {
                true -> "1"
                false -> "0"
                null -> null
            },
            slow = when {
                slowEnabled == true -> (slowDuration ?: 0).toString()
                slowEnabled == false -> "0"
                else -> null
            },
            subs = when (subscriberEnabled) {
                true -> "1"
                false -> "0"
                null -> null
            }
        )
    }

    private fun summarizeTopLevelKeys(root: JsonElement?): String {
        val obj = root as? JsonObject ?: return "n/a"
        return obj.keys.take(12).joinToString(",")
    }

    private fun findBalanceKeyPaths(root: JsonElement?): List<String> {
        return findInterestingKeyPaths(
            root,
            setOf("balance", "points", "currency", "wallet")
        )
    }

    private fun extractKeySnippet(root: JsonElement?, targetKey: String): String {
        val normalized = targetKey.lowercase(Locale.ROOT)

        fun find(element: JsonElement?): JsonElement? {
            return when (element) {
                is JsonObject -> {
                    element.entries.firstOrNull { it.key.lowercase(Locale.ROOT) == normalized }?.value
                        ?: element.values.firstNotNullOfOrNull(::find)
                }
                is JsonArray -> element.firstNotNullOfOrNull(::find)
                else -> null
            }
        }

        return find(root)
            ?.toString()
            ?.replace(Regex("\\s+"), " ")
            ?.trim()
            ?.take(220)
            ?: "null"
    }

    private fun extractRewardsSample(root: JsonElement?): String {
        val sample = when (root) {
            is JsonObject -> {
                when (val data = root["data"]) {
                    is JsonArray -> data.firstOrNull()?.toString()
                    is JsonObject -> data.toString()
                    else -> null
                } ?: root.entries.firstOrNull { !it.key.equals("message", true) }?.value?.toString()
            }
            is JsonArray -> root.firstOrNull()?.toString()
            else -> null
        }
        return sample
            ?.replace(Regex("\\s+"), " ")
            ?.trim()
            ?.take(220)
            ?: "null"
    }

    private fun extractInterestingKeySnippets(root: JsonElement?, fragments: Set<String>): String {
        if (root == null) return "null"
        val snippets = linkedMapOf<String, String>()

        fun walk(element: JsonElement, path: List<String>) {
            when (element) {
                is JsonObject -> {
                    element.forEach { (key, value) ->
                        val lower = key.lowercase(Locale.ROOT)
                        val nextPath = path + key
                        if (fragments.any { lower.contains(it) } && snippets.size < 12) {
                            snippets[nextPath.joinToString(".")] = value.toString()
                                .replace(Regex("\\s+"), " ")
                                .trim()
                                .take(120)
                        }
                        if (snippets.size < 12) {
                            walk(value, nextPath)
                        }
                    }
                }
                is JsonArray -> {
                    element.forEachIndexed { index, child ->
                        if (snippets.size < 12) {
                            walk(child, path + "[$index]")
                        }
                    }
                }
                else -> Unit
            }
        }

        walk(root, emptyList())
        return snippets.entries.joinToString(separator = ",") { (path, value) -> "$path=$value" }
            .ifBlank { "null" }
    }

    private fun String.compactDebugSnippet(limit: Int = 260): String {
        return replace(Regex("\\s+"), " ")
            .trim()
            .take(limit)
    }

    private fun findInterestingKeyPaths(root: JsonElement?, fragments: Set<String>): List<String> {
        if (root == null) return emptyList()
        val matches = mutableListOf<String>()

        fun walk(element: JsonElement, path: List<String>) {
            when (element) {
                is JsonObject -> {
                    element.forEach { (key, value) ->
                        val lower = key.lowercase(Locale.ROOT)
                        val nextPath = path + key
                        if (fragments.any { lower.contains(it) }) {
                            matches += nextPath.joinToString(".")
                        }
                        if (matches.size < 32) {
                            walk(value, nextPath)
                        }
                    }
                }
                is JsonArray -> {
                    element.forEachIndexed { index, child ->
                        if (matches.size < 32) {
                            walk(child, path + "[$index]")
                        }
                    }
                }
                else -> Unit
            }
        }

        walk(root, emptyList())
        return matches.distinct()
    }

    private fun JsonElement?.asJsonObjectOrNull(): JsonObject? {
        return when (this) {
            is JsonObject -> this
            is JsonPrimitive -> contentOrNull
                ?.takeIf { it.isNotBlank() }
                ?.let { raw ->
                    runCatching { json.parseToJsonElement(raw) as? JsonObject }.getOrNull()
                }
            else -> null
        }
    }

    private fun JsonElement?.asLongOrNull(): Long? {
        val primitive = this as? JsonPrimitive ?: return null
        return primitive.longOrNull ?: primitive.contentOrNull?.toLongOrNull()
    }

    private fun findPrimitiveRecursive(root: JsonElement?, targetKeys: Set<String>): String? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        fun search(element: JsonElement?): String? {
            return when (element) {
                is JsonObject -> {
                    element.entries.firstNotNullOfOrNull { (key, value) ->
                        val normalizedKey = key.lowercase(Locale.ROOT)
                        when {
                            normalizedKey in normalizedKeys -> (value as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
                            else -> search(value)
                        }
                    }
                }
                is JsonArray -> element.firstNotNullOfOrNull(::search)
                else -> null
            }
        }
        return search(root)
    }

    private fun findLongRecursive(root: JsonElement?, targetKeys: Set<String>): Long? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        fun search(element: JsonElement?): Long? {
            return when (element) {
                is JsonObject -> {
                    element.entries.firstNotNullOfOrNull { (key, value) ->
                        val normalizedKey = key.lowercase(Locale.ROOT)
                        when {
                            normalizedKey in normalizedKeys -> value.asLongOrNull()
                            else -> search(value)
                        }
                    }
                }
                is JsonArray -> element.firstNotNullOfOrNull(::search)
                else -> null
            }
        }
        return search(root)
    }

    private fun extractVideoArrays(root: JsonElement): List<JsonArray> {
        return when (root) {
            is JsonArray -> listOf(root)
            is JsonObject -> buildList {
                root.arrayOrNull("previous_livestreams")?.let(::add)
                root.arrayOrNull("past_livestreams")?.let(::add)
                root.arrayOrNull("livestreams")?.let(::add)
                root.arrayOrNull("videos")?.let(::add)
                root.arrayOrNull("vods")?.let(::add)
                root.arrayOrNull("replays")?.let(::add)
                root.objOrNull("data")?.arrayOrNull("videos")?.let(::add)
                root.objOrNull("data")?.arrayOrNull("vods")?.let(::add)
                root.objOrNull("data")?.arrayOrNull("livestreams")?.let(::add)
                root.objOrNull("status")?.arrayOrNull("videos")?.let(::add)
            }
            else -> emptyList()
        }
    }

    private fun extractClipArrays(root: JsonElement): List<JsonArray> {
        return when (root) {
            is JsonArray -> listOf(root)
            is JsonObject -> buildList {
                root.arrayOrNull("clips")?.let(::add)
                root.arrayOrNull("data")?.let(::add)
                root.arrayOrNull("items")?.let(::add)
                root.objOrNull("data")?.arrayOrNull("clips")?.let(::add)
                root.objOrNull("status")?.arrayOrNull("clips")?.let(::add)
            }
            else -> emptyList()
        }
    }

    private fun encodeQuery(query: Map<String, String>): String {
        val url = "https://kick.com/".toHttpUrlOrNull() ?: return ""
        val builder = url.newBuilder()
        query.forEach { (key, value) ->
            builder.addQueryParameter(key, value)
        }
        return builder.build().query?.let { "?$it" } ?: ""
    }
}
