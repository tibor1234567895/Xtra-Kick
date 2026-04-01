package com.github.andreyasadchy.xtra.repository

import android.content.Context
import android.util.Log
import android.webkit.CookieManager
import androidx.core.content.ContextCompat
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Reply
import com.github.andreyasadchy.xtra.model.kick.KickCategory
import com.github.andreyasadchy.xtra.model.kick.KickChannelResponse
import com.github.andreyasadchy.xtra.model.kick.KickChannelLivestream
import com.github.andreyasadchy.xtra.model.kick.KickLivestream
import com.github.andreyasadchy.xtra.model.kick.KickLivestreamsResponse
import com.github.andreyasadchy.xtra.model.kick.KickMessage
import com.github.andreyasadchy.xtra.model.kick.KickMessageBadge
import com.github.andreyasadchy.xtra.model.kick.KickMessageSender
import com.github.andreyasadchy.xtra.model.kick.KickMessagesData
import com.github.andreyasadchy.xtra.model.kick.KickMessagesEnvelope
import com.github.andreyasadchy.xtra.model.kick.KickSearchChannel
import com.github.andreyasadchy.xtra.model.kick.KickSubcategoriesResponse
import com.github.andreyasadchy.xtra.model.kick.KickSubcategory
import com.github.andreyasadchy.xtra.model.kick.KickThumbnail
import com.github.andreyasadchy.xtra.model.kick.KickWebsiteSearchResponse
import com.github.andreyasadchy.xtra.model.kick.auth.KickChatSendResponse
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
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.longOrNull
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Request
import java.util.Collections
import java.io.IOException
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KickRepository @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
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

    private enum class KickModerationType {
        NONE,
        DELETE_MESSAGE,
        CLEAR_CHAT,
        TIMEOUT,
        BAN,
        UNBAN,
        UNTIMEOUT,
    }

    private data class KickResolvedUser(
        val id: String? = null,
        val login: String? = null,
        val name: String? = null,
    )

    private val tag = "KickRepository"
    private val badgeDebugTag = "KickBadgeDebug"
    private val emoteRegex = Regex("\\[emote:\\d+:([^\\]]+)]")
    private val kickBadgeFallbackBaseUrl = "https://www.kickdatabase.com/kickBadges/"
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
    private val dedicatedChatroomCache = ConcurrentHashMap<String, Pair<Long, List<String>>>()
    private val recentMessagesCache = ConcurrentHashMap<String, Pair<Long, KickMessagesData>>()
    private val recentMessagesFailureCache = ConcurrentHashMap<String, Pair<Long, Int>>()
    private val kickBadgeCatalogRefreshAt = ConcurrentHashMap<String, Long>()
    private val kickBadgeCatalogRefreshInProgress = Collections.newSetFromMap(ConcurrentHashMap<String, Boolean>())
    private val inFlightChannelRequests = ConcurrentHashMap<String, CompletableDeferred<KickChannelResponse>>()
    private val inFlightChatroomRequests = ConcurrentHashMap<String, CompletableDeferred<List<String>>>()
    private val inFlightRecentMessagesRequests = ConcurrentHashMap<String, CompletableDeferred<KickMessagesData>>()
    private val badgeCacheScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    @Volatile
    private var badgePersistScheduled = false
    private val recentMessagesCacheTtlMs = 5_000L
    private val recentMessagesFailureCacheTtlMs = 45_000L
    private val dedicatedChatroomCacheTtlMs = 30_000L

    private fun isKickBadgeDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)
    }

    init {
        badgeCacheScope.launch {
            restoreKickBadgeCacheFromDisk()
        }
    }

    private data class KickCurrentUser(
        val id: String?,
        val login: String?,
    )

    private suspend fun resolveKickCurrentUser(accessToken: String): KickCurrentUser? {
        val raw = runCatching {
            getRawAuthenticated(
                url = "https://api.kick.com/public/v1/users",
                accessToken = accessToken,
                isKickWeb = false,
            )
        }.getOrNull() ?: return null
        val root = runCatching { json.parseToJsonElement(raw) }.getOrNull() ?: return null
        val users = when (root) {
            is JsonArray -> root
            is JsonObject -> root.arrayOrNull("data")
                ?: root.arrayOrNull("users")
                ?: root.objOrNull("data")?.arrayOrNull("users")
                ?: root.objOrNull("data")?.arrayOrNull("items")
            else -> null
        } ?: return null
        val user = users.firstOrNull() as? JsonObject ?: return null
        val id = user.primitiveOrNull("id")
            ?: user.primitiveOrNull("user_id")
            ?: user.primitiveOrNull("channel_id")
        val login = user.primitiveOrNull("name")
            ?: user.primitiveOrNull("username")
            ?: user.primitiveOrNull("channel_slug")
            ?: user.objOrNull("channel")?.primitiveOrNull("slug")
        return KickCurrentUser(id = id, login = login)
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
        val accessToken = context.tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null)?.takeIf { it.isNotBlank() }
            ?: throw IOException("missing kick auth token")
        val cookieHeader = CookieManager.getInstance().getCookie("https://kick.com")?.takeIf { it.isNotBlank() }
            ?: throw IOException("missing kick web cookies")
        val url = buildString {
            append("https://kick.com/api/v2/channels/followed")
            if (!cursor.isNullOrBlank()) {
                append("?cursor=")
                append(urlEncode(cursor))
            }
        }
        okHttpClient.newCall(
            createRequestBuilder(url, isKickWeb = true)
                .header("Authorization", "Bearer $accessToken")
                .header("Cookie", cookieHeader)
                .header("Accept", "application/json")
                .build()
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
            )
        }
    }

    suspend fun getChannel(channelSlug: String): KickChannelResponse {
        val normalizedKey = channelSlug.trim().lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        channelCache[normalizedKey]?.let { (cachedAt, cachedChannel) ->
            if (now - cachedAt <= channelCacheTtlMs) {
                return cachedChannel
            }
        }
        return coalesceRequest(inFlightChannelRequests, normalizedKey) {
            val decoded = json.decodeFromString<KickChannelResponse>(
                getRaw("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}")
            )
            decoded.also { channel ->
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
                maybeRefreshKickBadgeCatalogInBackground(channel)
            }
        }
    }

    suspend fun resolveDedicatedChatroomCandidates(channelOrId: String): List<String> {
        val candidate = channelOrId.trim()
        if (candidate.isBlank()) {
            return emptyList()
        }
        val normalizedKey = candidate.lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        dedicatedChatroomCache[normalizedKey]?.let { (cachedAt, cachedResults) ->
            if (now - cachedAt <= dedicatedChatroomCacheTtlMs) {
                return cachedResults
            }
        }
        return coalesceRequest(inFlightChatroomRequests, normalizedKey) {
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
            results.toList().also { resolved ->
                dedicatedChatroomCache[normalizedKey] = System.currentTimeMillis() to resolved
            }
        }
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
                    clip.id?.let { id -> collected.putIfAbsent(id, clip) }
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
        val normalizedKey = channelOrChatroomId.trim().lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        recentMessagesCache[normalizedKey]?.let { (cachedAt, cachedResults) ->
            if (now - cachedAt <= recentMessagesCacheTtlMs) {
                return cachedResults
            }
        }
        recentMessagesFailureCache[normalizedKey]?.let { (cachedAt, statusCode) ->
            if (now - cachedAt <= recentMessagesFailureCacheTtlMs) {
                throw IOException(
                    "Kick recent source temporarily degraded ($statusCode) for $channelOrChatroomId"
                )
            } else {
                recentMessagesFailureCache.remove(normalizedKey, cachedAt to statusCode)
            }
        }
        return coalesceRequest(inFlightRecentMessagesRequests, normalizedKey) {
            try {
                val raw = getRaw("https://kick.com/api/v2/channels/${urlEncode(channelOrChatroomId)}/messages")
                val root = runCatching { json.parseToJsonElement(raw) }.getOrElse { error ->
                    throw error
                }
                parseKickMessagesData(root, raw).also { parsed ->
                    recentMessagesCache[normalizedKey] = System.currentTimeMillis() to parsed
                    recentMessagesFailureCache.remove(normalizedKey)
                    if (parsed.messages.isEmpty()) {
                        Log.w(
                            "KickRecentChat",
                            "empty recent source=$channelOrChatroomId body=${raw.take(600).replace('\n', ' ')}"
                        )
                    }
                }
            } catch (e: IOException) {
                val statusCode = Regex("""\((\d{3})\)""")
                    .find(e.message.orEmpty())
                    ?.groupValues
                    ?.getOrNull(1)
                    ?.toIntOrNull()
                if (statusCode != null && statusCode >= 500) {
                    recentMessagesFailureCache[normalizedKey] = System.currentTimeMillis() to statusCode
                }
                throw e
            }
        }
    }

    private suspend fun <T> coalesceRequest(
        requests: ConcurrentHashMap<String, CompletableDeferred<T>>,
        key: String,
        block: suspend () -> T,
    ): T {
        requests[key]?.let { return it.await() }
        val deferred = CompletableDeferred<T>()
        val existing = requests.putIfAbsent(key, deferred)
        if (existing != null) {
            return existing.await()
        }
        try {
            return block().also(deferred::complete)
        } catch (t: Throwable) {
            deferred.completeExceptionally(t)
            throw t
        } finally {
            requests.remove(key, deferred)
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
            if (parsed.messages.isEmpty()) {
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
            if (parsed.messages.isEmpty()) {
                Log.w(
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
        data class ChatAttempt(
            val body: String,
            val requestMeta: String,
        )

        val attempts = buildList {
            add(
                ChatAttempt(
                    body = buildChatPayload(
                        broadcasterUserId = broadcasterUserId,
                        content = content,
                        replyToMessageId = replyToMessageId,
                        type = "user",
                        includeBroadcaster = true,
                    ),
                    requestMeta = "variant=v1-user,broadcaster_user_id=$broadcasterUserId,type=user,content_length=${content.length},has_reply=${!replyToMessageId.isNullOrBlank()}",
                )
            )
            add(
                ChatAttempt(
                    body = buildChatPayload(
                        broadcasterUserId = broadcasterUserId,
                        content = content,
                        replyToMessageId = replyToMessageId,
                        type = null,
                        includeBroadcaster = true,
                    ),
                    requestMeta = "variant=legacy-user-no-type,broadcaster_user_id=$broadcasterUserId,content_length=${content.length},has_reply=${!replyToMessageId.isNullOrBlank()}",
                )
            )
            add(
                ChatAttempt(
                    body = buildChatPayload(
                        broadcasterUserId = broadcasterUserId,
                        content = content,
                        replyToMessageId = replyToMessageId,
                        type = "bot",
                        includeBroadcaster = false,
                    ),
                    requestMeta = "variant=v1-bot,broadcaster_user_id=omitted,type=bot,content_length=${content.length},has_reply=${!replyToMessageId.isNullOrBlank()}",
                )
            )
        }

        var lastFailure: Pair<ChatAttempt, ChatResult>? = null
        for ((index, attempt) in attempts.withIndex()) {
            val result = executeChatSend(accessToken, attempt.body)
            if (result.code in 200..299) {
                return@withContext if (result.body.isBlank()) {
                    KickChatSendResponse()
                } else {
                    json.decodeFromString<KickChatSendResponse>(result.body)
                }
            }
            lastFailure = attempt to result
            val shouldTryNext = index < attempts.lastIndex &&
                    result.code == 400 &&
                    result.body.contains("invalid request", ignoreCase = true)
            if (!shouldTryNext) {
                break
            }
        }

        val (attempt, result) = lastFailure ?: throw IOException("Kick chat send failed (unknown)")
        val details = result.body.ifBlank { null }?.replace('\n', ' ')
        throw IOException("Kick chat send failed (${result.code})${details?.let { ": $it" } ?: ""}; request={${attempt.requestMeta}}")
    }

    private fun buildChatPayload(
        broadcasterUserId: Long,
        content: String,
        replyToMessageId: String?,
        type: String?,
        includeBroadcaster: Boolean,
    ): String {
        return json.encodeToString(
            buildJsonObject {
                if (includeBroadcaster) {
                    put("broadcaster_user_id", JsonPrimitive(broadcasterUserId))
                }
                put("content", JsonPrimitive(content))
                type?.let { put("type", JsonPrimitive(it)) }
                replyToMessageId?.takeIf { it.isNotBlank() }?.let {
                    put("reply_to_message_id", JsonPrimitive(it))
                }
            }
        )
    }

    private fun executeChatSend(accessToken: String, body: String): ChatResult {
        return okHttpClient.newCall(
            Request.Builder()
                .url("https://api.kick.com/public/v1/chat")
                .header("User-Agent", "okhttp/5.0.0")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer $accessToken")
                .header("Content-Type", "application/json")
                .post(body.toRequestBody())
                .build()
        ).execute().use { response ->
            ChatResult(
                code = response.code,
                body = response.body.string(),
            )
        }
    }

    private data class ChatResult(
        val code: Int,
        val body: String,
    )

    fun toStream(item: KickLivestream, gameId: String? = null, gameSlug: String? = null, gameName: String? = null): Stream {
        val category = item.categories?.firstOrNull()
        val channelLogin = item.channel?.slug ?: item.channel?.user?.username?.lowercase(Locale.ROOT)
        return Stream(
            id = item.id?.toString(),
            source = C.KICK,
            channelId = item.channel?.id?.toString() ?: item.channelId?.toString(),
            channelLogin = channelLogin,
            channelName = item.channel?.user?.username,
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

    fun toChatMessage(message: KickMessage, eventName: String? = null): ChatMessage {
        val moderationType = resolveKickModerationType(message, eventName)
        val deletedMessageObject = message.deletedMessage.asJsonObjectOrNull()
        val targetUser = extractKickTargetUser(message)
        val rawContent = message.content ?: message.message ?: message.text ?: message.body ?: extractKickMessageContent(deletedMessageObject)
        val content = rawContent?.replace(emoteRegex) { result -> result.groupValues.getOrElse(1) { "" } }
        val allBadges = buildList {
            addAll(message.sender?.identity?.badges.orEmpty())
            addAll(syntheticKickBadgesFromSender(message.sender))
        }
        val badges = allBadges.mapNotNull { badge ->
            val type = badge.type?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.badgeType?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.name?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.slug?.trim()?.takeIf { it.isNotBlank() }
                ?: badge.text?.trim()?.takeIf { it.isNotBlank() }
                ?: return@mapNotNull null
            val normalizedType = normalizeKickBadgeType(type)
            val version = (badge.count ?: badge.months ?: badge.level ?: badge.tier ?: badge.version ?: 1).toString()
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
                    kickBadgeUrls["kick:$candidate:$version"] = directImageUrl
                    kickBadgeUrls.putIfAbsent("kick:$candidate:default", directImageUrl)
                }
            }
            val resolvedImageUrl = directImageUrl
                ?: resolveKickBadgeUrl(type, version)
                ?: fallbackKickBadgeUrl(normalizedType, version)
            if (resolvedImageUrl.isNullOrBlank() && isKickBadgeDebugEnabled()) {
                Log.w(
                    tag,
                    "Missing kick badge URL. type=$type normalized=$normalizedType version=$version text=${badge.text} rawUrlCandidates=${listOf(badge.badgeImageUrl, badge.badgeImage, badge.imageUrl, badge.image, badge.iconUrl, badge.icon, badge.badgeUrl, badge.src, badge.url)}"
                )
            }
            if (resolvedImageUrl.isNullOrBlank()) {
                return@mapNotNull null
            }
            if (isKickBadgeDebugEnabled() && normalizedType in setOf("moderator", "vip", "verified", "og", "founder", "sub_gifter", "broadcaster", "staff")) {
                Log.d(
                    badgeDebugTag,
                    "messageBadge type=$type normalized=$normalizedType version=$version direct=${!directImageUrl.isNullOrBlank()} resolved=true"
                )
            }
            val displayText = badge.text?.takeIf { it.isNotBlank() } ?: type.replace('_', ' ').uppercase(Locale.ROOT)
            Badge(
                setId = "kick:$normalizedType",
                version = version,
                title = displayText,
                url1x = resolvedImageUrl,
                url2x = resolvedImageUrl,
                url3x = resolvedImageUrl,
                url4x = resolvedImageUrl,
            )
        }.takeIf { it.isNotEmpty() }
        val reply = extractKickReply(message)
        val targetLogin = targetUser?.login
        val targetName = targetUser?.name
        val targetUserId = targetUser?.id
        val moderationSystemMsg = when (moderationType) {
            KickModerationType.CLEAR_CHAT -> ContextCompat.getString(context, R.string.chat_clear)
            KickModerationType.TIMEOUT -> {
                val login = targetName ?: targetLogin
                val durationSeconds = extractKickModerationDurationSeconds(message)
                if (login != null && durationSeconds != null) {
                    ContextCompat.getString(context, R.string.chat_timeout).format(
                        login,
                        KickApiHelper.getDurationFromSeconds(context, durationSeconds.toString())
                    )
                } else if (login != null) {
                    ContextCompat.getString(context, R.string.chat_ban).format(login)
                } else {
                    null
                }
            }
            KickModerationType.BAN -> (targetName ?: targetLogin)?.let {
                ContextCompat.getString(context, R.string.chat_ban).format(it)
            }
            KickModerationType.UNBAN -> (targetName ?: targetLogin)?.let {
                ContextCompat.getString(context, R.string.irc_notice_unban_success).format(it)
            }
            KickModerationType.UNTIMEOUT -> (targetName ?: targetLogin)?.let {
                ContextCompat.getString(context, R.string.irc_notice_untimeout_success).format(it)
            }
            else -> null
        }
        val systemMsg = moderationSystemMsg ?: extractKickSubscriptionNotice(message, eventName, targetUser)
        return ChatMessage(
            id = message.id,
            userId = targetUserId ?: message.sender?.id?.toString() ?: message.userId?.toString(),
            userLogin = targetLogin ?: message.sender?.slug ?: message.sender?.username?.lowercase(Locale.ROOT),
            userName = targetName ?: message.sender?.username,
            message = if (moderationType == KickModerationType.DELETE_MESSAGE) content else content?.takeIf { systemMsg == null },
            color = message.sender?.identity?.color,
            badges = badges,
            systemMsg = systemMsg,
            msgId = when (moderationType) {
                KickModerationType.DELETE_MESSAGE -> "kick_clearmsg"
                KickModerationType.CLEAR_CHAT,
                KickModerationType.TIMEOUT,
                KickModerationType.BAN,
                KickModerationType.UNBAN,
                KickModerationType.UNTIMEOUT -> "kick_moderation"
                KickModerationType.NONE -> null
            },
            reply = reply,
            timestamp = normalizeDate(message.createdAt)?.let { KickApiHelper.parseIso8601DateUTC(it) },
            fullMsg = rawContent ?: content ?: message.type ?: eventName
        )
    }

    private fun syntheticKickBadgesFromSender(sender: KickMessageSender?): List<KickMessageBadge> {
        if (sender == null) return emptyList()
        val synthetic = mutableListOf<KickMessageBadge>()
        sender.role?.takeIf { it.isNotBlank() }?.let { role ->
            synthetic += KickMessageBadge(
                type = role,
                text = role.replace('_', ' ').replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            )
        }
        if (sender.isVerified == true || sender.verified == true) {
            synthetic += KickMessageBadge(type = "verified", text = "Verified")
        }
        if (sender.isSuperAdmin == true) {
            synthetic += KickMessageBadge(type = "staff", text = "Staff")
        }
        sender.followerBadges.orEmpty().forEach { followerBadge ->
            followerBadge.takeIf { it.isNotBlank() }?.let { label ->
                synthetic += KickMessageBadge(type = label, text = label)
            }
        }
        if (sender.isFounder == true) {
            synthetic += KickMessageBadge(
                type = "founder",
                text = "Founder",
                count = sender.monthsSubscribed
            )
        }
        sender.quantityGifted?.takeIf { it > 0 }?.let { giftedCount ->
            synthetic += KickMessageBadge(
                type = "sub_gifter",
                text = "Sub Gifter",
                count = giftedCount
            )
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
            metadata?.firstObjectOrNull("deleted_message")?.firstPrimitiveOrNull("id", "message_id", "uuid")
        )
    }

    private fun extractKickReply(message: KickMessage): Reply? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val replyObject = listOfNotNull(
            message.replyToMessage.asJsonObjectOrNull(),
            message.replyTo.asJsonObjectOrNull(),
            metadata?.firstObjectOrNull("reply", "reply_to", "reply_to_message", "parent_message", "replied_to_message", "original_message"),
            metadata?.firstObjectOrNull("reply_parent", "thread_parent")
        ).firstOrNull()
        val threadParentId = firstNonBlank(
            message.threadParentId,
            message.threadId,
            message.replyToMessageId,
            message.parentMessageId,
            replyObject?.firstPrimitiveOrNull("thread_parent_id", "thread_id", "parent_message_id", "reply_to_message_id", "id", "message_id", "uuid"),
            metadata?.firstPrimitiveOrNull("thread_parent_id", "thread_id", "parent_message_id", "reply_to_message_id"),
            metadata?.firstObjectOrNull("thread_parent")?.firstPrimitiveOrNull("id", "message_id", "uuid"),
            metadata?.firstObjectOrNull("parent_message")?.firstPrimitiveOrNull("id", "message_id", "uuid")
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
            message.targetUser.asJsonObjectOrNull(),
            message.target.asJsonObjectOrNull(),
            message.deletedMessage.asJsonObjectOrNull()?.firstObjectOrNull("sender", "user", "target_user"),
            metadata?.firstObjectOrNull("target_user", "target", "user", "subject"),
            metadata?.firstObjectOrNull("deleted_message")?.firstObjectOrNull("sender", "user", "target_user")
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

    private fun extractKickModerationDurationSeconds(message: KickMessage): Long? {
        val metadata = message.metadata.asJsonObjectOrNull()
        val durationObject = message.duration.asJsonObjectOrNull()
        return listOfNotNull(
            message.durationSeconds,
            message.duration.asLongOrNull(),
            durationObject?.firstLongOrNull("seconds", "duration", "duration_seconds"),
            metadata?.firstLongOrNull("duration_seconds", "duration", "seconds"),
            metadata?.firstObjectOrNull("duration")?.firstLongOrNull("seconds", "duration")
        ).firstOrNull { it >= 0L }
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
                ?: fallbackKickBadgeUrl(normalizeKickBadgeType(type), version)
                ?: return@forEach
            kickBadgeTypeCandidates(type).forEach { candidate ->
                val key = "kick:$candidate:$version"
                if (kickBadgeUrls.put(key, imageUrl) != imageUrl) {
                    changed = true
                }
                if (kickBadgeUrls.putIfAbsent("kick:$candidate:default", imageUrl) == null) {
                    changed = true
                }
                if (isKickBadgeDebugEnabled() && candidate in setOf("moderator", "vip", "verified", "og", "founder", "sub_gifter", "broadcaster", "staff")) {
                    Log.d(badgeDebugTag, "cacheBadge key=$key hasUrl=${imageUrl.isNotBlank()}")
                }
            }
        }
        return changed
    }

    private fun resolveKickBadgeUrl(type: String, version: String): String? {
        kickBadgeTypeCandidates(type).forEach { candidate ->
            kickBadgeUrls["kick:$candidate:$version"]?.let { return it }
            kickBadgeUrls["kick:$candidate:1"]?.let { return it }
            kickBadgeUrls["kick:$candidate:default"]?.let { return it }
        }
        fallbackKickBadgeUrl(normalizeKickBadgeType(type), version)?.let { return it }
        return null
    }

    private fun fallbackKickBadgeUrl(normalizedType: String, version: String): String? {
        val slug = when (normalizedType) {
            "moderator" -> "moderator"
            "vip" -> "vip"
            "verified" -> "verified"
            "og" -> "og"
            "founder" -> "founder"
            "subscriber" -> "subscriber"
            "broadcaster" -> "broadcaster"
            "staff" -> "staff"
            "sidekick" -> "sidekick"
            "sub_gifter" -> when {
                version.toIntOrNull()?.let { it >= 200 } == true -> "subGifter200"
                version.toIntOrNull()?.let { it >= 100 } == true -> "subGifter100"
                version.toIntOrNull()?.let { it >= 50 } == true -> "subGifter50"
                version.toIntOrNull()?.let { it >= 25 } == true -> "subGifter25"
                else -> "subGifter"
            }
            else -> null
        } ?: return null
        return "${kickBadgeFallbackBaseUrl}${slug}.svg"
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
                            val added = cacheKickBadgeUrlsFromJson(element)
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

    private fun cacheKickBadgeUrlsFromJson(root: JsonElement): Int {
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
                        val version = (intValue(element, listOf("count", "months", "level", "tier", "version")) ?: 1).toString()
                        val imageUrl = stringValue(element, listOf("badge_image_url", "badge_url", "image_url", "icon_url", "url", "src"))
                            ?: extractImageUrl(element["badge_image"])
                            ?: extractImageUrl(element["image"])
                            ?: extractImageUrl(element["icon"])
                            ?: extractImageUrl(element["badge"])
                        if (!type.isNullOrBlank() && !imageUrl.isNullOrBlank()) {
                            kickBadgeTypeCandidates(type).forEach { candidate ->
                                val key = "kick:$candidate:$version"
                                if (kickBadgeUrls.put(key, imageUrl) == null) {
                                    added += 1
                                }
                                kickBadgeUrls.putIfAbsent("kick:$candidate:default", imageUrl)
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
                    header("Referer", "https://kick.com/")
                    header("Accept", "application/json, text/plain, */*")
                    header("x-kick-platform", "web")
                    AuthStateHelper.getKickBearerToken(context)?.let { bearer ->
                        header("Authorization", bearer)
                    }
                    getKickCookieHeader()?.let { cookies ->
                        header("Cookie", cookies)
                        extractKickXsrfToken(cookies)?.let { xsrfToken ->
                            header("X-XSRF-TOKEN", xsrfToken)
                        }
                    }
                }
            }
    }

    private fun getKickCookieHeader(): String? {
        return CookieManager.getInstance().getCookie("https://kick.com")?.takeIf { it.isNotBlank() }
            ?: CookieManager.getInstance().getCookie("https://web.kick.com")?.takeIf { it.isNotBlank() }
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

    private fun JsonElement?.asJsonObjectOrNull(): JsonObject? {
        return this as? JsonObject
    }

    private fun JsonElement?.asLongOrNull(): Long? {
        val primitive = this as? JsonPrimitive ?: return null
        return primitive.longOrNull ?: primitive.contentOrNull?.toLongOrNull()
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
