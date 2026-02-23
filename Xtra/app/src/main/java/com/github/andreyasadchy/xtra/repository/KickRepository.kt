package com.github.andreyasadchy.xtra.repository

import android.content.Context
import android.util.Log
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.kick.KickChannelResponse
import com.github.andreyasadchy.xtra.model.kick.KickLivestream
import com.github.andreyasadchy.xtra.model.kick.KickLivestreamsResponse
import com.github.andreyasadchy.xtra.model.kick.KickMessage
import com.github.andreyasadchy.xtra.model.kick.KickMessageBadge
import com.github.andreyasadchy.xtra.model.kick.KickMessageSender
import com.github.andreyasadchy.xtra.model.kick.KickMessagesData
import com.github.andreyasadchy.xtra.model.kick.KickMessagesEnvelope
import com.github.andreyasadchy.xtra.model.kick.KickSubcategoriesResponse
import com.github.andreyasadchy.xtra.model.kick.KickSubcategory
import com.github.andreyasadchy.xtra.model.kick.auth.KickChatSendResponse
import com.github.andreyasadchy.xtra.model.ui.Clip
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.model.ui.Video
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.TwitchApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.qualifiers.ApplicationContext
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
import java.io.IOException
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

    private val tag = "KickRepository"
    private val badgeDebugTag = "KickBadgeDebug"
    private val emoteRegex = Regex("\\[emote:\\d+:([^\\]]+)]")
    private val kickBadgeFallbackBaseUrl = "https://www.kickdatabase.com/kickBadges/"
    private val kickBadgeCacheKey = "kick_badge_url_cache_v1"
    private val kickBadgeCacheTtlMs = 24L * 60L * 60L * 1000L
    private val kickBadgeCachePersistDebounceMs = 500L
    private val channelCacheTtlMs = 15_000L
    private val kickBadgeUrls = ConcurrentHashMap<String, String>()
    private val channelCache = ConcurrentHashMap<String, Pair<Long, KickChannelResponse>>()
    private val kickBadgeCatalogRefreshAt = ConcurrentHashMap<String, Long>()
    private val kickBadgeCatalogRefreshInProgress = ConcurrentHashMap.newKeySet<String>()
    private val badgeCacheScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    @Volatile
    private var badgePersistScheduled = false

    private fun isKickBadgeDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)
    }

    init {
        badgeCacheScope.launch {
            restoreKickBadgeCacheFromDisk()
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

    suspend fun getChannel(channelSlug: String): KickChannelResponse {
        val normalizedKey = channelSlug.trim().lowercase(Locale.ROOT)
        val now = System.currentTimeMillis()
        channelCache[normalizedKey]?.let { (cachedAt, cachedChannel) ->
            if (now - cachedAt <= channelCacheTtlMs) {
                return cachedChannel
            }
        }
        return get<KickChannelResponse>("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}").also { channel ->
            val cachedAt = System.currentTimeMillis()
            channelCache[normalizedKey] = cachedAt to channel
            channel.slug?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotBlank() }?.let { channelCache[it] = cachedAt to channel }
            channel.id?.toString()?.takeIf { it.isNotBlank() }?.let { channelCache[it] = cachedAt to channel }
            val changed = cacheKickBadgeUrls(channel)
            if (changed) {
                schedulePersistBadgeCache()
            }
            maybeRefreshKickBadgeCatalogInBackground(channel)
        }
    }

    suspend fun getChannelVideos(channelSlug: String, channelId: String? = null, limit: Int = 30): List<Video> {
        val cached = channelCache[channelSlug.trim().lowercase(Locale.ROOT)]?.second
        var resolvedChannelId = channelId ?: cached?.id?.toString()
        var login = cached?.slug ?: channelSlug
        var channelName = cached?.user?.username
        var channelLogo = cached?.user?.profileImage

        val attempted = mutableSetOf<String>()
        suspend fun tryUrl(url: String): List<Video>? {
            if (!attempted.add(url)) return null
            val root = runCatching { json.parseToJsonElement(getRaw(url)) }.getOrNull() ?: return null
            val parsed = parseVideos(
                roots = listOf(root),
                channelId = channelId,
                channelLogin = login,
                channelName = channelName,
                channelLogo = channelLogo,
                limit = limit
            )
            return parsed.takeIf { it.isNotEmpty() }
        }

        tryUrl("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}/videos")?.let { return it }
        resolvedChannelId?.let { id ->
            tryUrl("https://kick.com/api/v2/channels/${urlEncode(id)}/videos")?.let { return it }
        }
        tryUrl("https://kick.com/api/v1/channels/${urlEncode(channelSlug)}/videos")?.let { return it }
        resolvedChannelId?.let { id ->
            tryUrl("https://kick.com/api/v1/channels/${urlEncode(id)}/videos")?.let { return it }
        }

        val channelRoot = runCatching {
            json.parseToJsonElement(getRaw("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}")).jsonObject
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
                limit = limit
            ).takeIf { it.isNotEmpty() }?.let { return it }

            resolvedChannelId?.let { id ->
                tryUrl("https://kick.com/api/v2/channels/${urlEncode(id)}/videos")?.let { return it }
                tryUrl("https://kick.com/api/v1/channels/${urlEncode(id)}/videos")?.let { return it }
            }
        }

        return emptyList()
    }

    suspend fun getChannelClips(channelSlug: String, channelId: String? = null, limit: Int = 20): List<Clip> {
        val cached = channelCache[channelSlug.trim().lowercase(Locale.ROOT)]?.second
        var resolvedChannelId = channelId ?: cached?.id?.toString()
        var login = cached?.slug ?: channelSlug
        var channelName = cached?.user?.username
        var channelLogo = cached?.user?.profileImage

        fun parseClipRoots(roots: List<JsonElement>): List<Clip> {
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
                    ?: item.primitiveOrNull("start_time")
                    ?: item.primitiveOrNull("published_at")
                val replayStartTime = item.primitiveOrNull("start_time")
                    ?: item.primitiveOrNull("clip_start_time")
                    ?: item.objOrNull("clip")?.primitiveOrNull("start_time")
                    ?: item.objOrNull("video")?.primitiveOrNull("start_time")
                    ?: createdAt
                val thumbnail = item.objOrNull("thumbnail")?.primitiveOrNull("src")
                    ?: item.objOrNull("thumbnail")?.primitiveOrNull("url")
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
                    ?: resolvedChannelId
                    ?: channelId
                val clipChannelLogin = item.primitiveOrNull("channel_slug")
                    ?: itemChannel?.primitiveOrNull("slug")
                    ?: itemChannelUser?.primitiveOrNull("username")?.lowercase(Locale.ROOT)
                    ?: login
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
                    gameId = category?.first,
                    gameSlug = category?.second,
                    gameName = category?.third,
                    title = title,
                    viewCount = viewCount,
                    uploadDate = normalizeDate(createdAt),
                    thumbnailUrl = thumbnail,
                    duration = duration,
                    profileImageUrl = clipProfileImage
                )
            }
            .distinctBy { it.id }
            .sortedByDescending { it.uploadDate }
            .take(limit)
            .toList()
        }

        val attempted = mutableSetOf<String>()
        suspend fun tryUrl(url: String): List<Clip>? {
            if (!attempted.add(url)) return null
            val root = runCatching { json.parseToJsonElement(getRaw(url)) }.getOrNull() ?: return null
            val parsed = parseClipRoots(listOf(root))
            return parsed.takeIf { it.isNotEmpty() }
        }

        tryUrl("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}/clips")?.let { return it }
        resolvedChannelId?.let { id ->
            tryUrl("https://kick.com/api/v2/channels/${urlEncode(id)}/clips")?.let { return it }
        }
        tryUrl("https://kick.com/api/v1/channels/${urlEncode(channelSlug)}/clips")?.let { return it }
        resolvedChannelId?.let { id ->
            tryUrl("https://kick.com/api/v1/channels/${urlEncode(id)}/clips")?.let { return it }
        }

        val channelRoot = runCatching {
            json.parseToJsonElement(getRaw("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}")).jsonObject
        }.getOrNull()
        if (channelRoot != null) {
            resolvedChannelId = resolvedChannelId ?: channelRoot.primitiveOrNull("id")
            login = channelRoot.primitiveOrNull("slug") ?: login
            channelName = channelRoot.objOrNull("user")?.primitiveOrNull("username") ?: channelName
            channelLogo = channelRoot.objOrNull("user")?.primitiveOrNull("profile_pic")
                ?: channelRoot.objOrNull("user")?.primitiveOrNull("profile_picture")
                ?: channelLogo
            resolvedChannelId?.let { id ->
                tryUrl("https://kick.com/api/v2/channels/${urlEncode(id)}/clips")?.let { return it }
                tryUrl("https://kick.com/api/v1/channels/${urlEncode(id)}/clips")?.let { return it }
            }
        }

        return emptyList()
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
                val thumbnail = item.objOrNull("thumbnail")?.primitiveOrNull("src")
                    ?: item.objOrNull("thumbnail")?.primitiveOrNull("url")
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

    suspend fun getRecentMessages(channelOrChatroomId: String): KickMessagesData {
        return get<KickMessagesEnvelope>("https://kick.com/api/v2/channels/${urlEncode(channelOrChatroomId)}/messages").data ?: KickMessagesData()
    }

    suspend fun getChatHistory(channelOrChatroomId: String, startTime: String): KickMessagesData {
        val url = "https://web.kick.com/api/v1/chat/${urlEncode(channelOrChatroomId)}/history?start_time=${urlEncode(startTime)}"
        val raw = getRaw(url, isKickWeb = true)
        val root = runCatching { json.parseToJsonElement(raw) }.getOrElse { error ->
            throw error
        }
        val dataObject = (root as? JsonObject)?.get("data") as? JsonObject ?: (root as? JsonObject)
        val messagesElement = dataObject?.get("messages") as? JsonArray
        val cursor = (dataObject?.get("cursor") as? JsonPrimitive)?.contentOrNull
        val messages = runCatching {
            messagesElement?.mapNotNull { element ->
                runCatching { json.decodeFromJsonElement(KickMessage.serializer(), element) }.getOrNull()
            }.orEmpty()
        }.getOrDefault(emptyList())
        return KickMessagesData(messages = messages, cursor = cursor)
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
                body = response.body?.string().orEmpty(),
            )
        }
    }

    private data class ChatResult(
        val code: Int,
        val body: String,
    )

    fun toStream(item: KickLivestream, gameId: String? = null, gameSlug: String? = null, gameName: String? = null): Stream {
        val category = item.categories?.firstOrNull()
        return Stream(
            id = item.id?.toString(),
            channelId = item.channel?.id?.toString() ?: item.channelId?.toString(),
            channelLogin = item.channel?.slug,
            channelName = item.channel?.user?.username,
            gameId = gameId ?: category?.id?.toString(),
            gameSlug = gameSlug ?: category?.slug,
            gameName = gameName ?: category?.name,
            title = item.title,
            viewerCount = item.viewerCount,
            startedAt = normalizeDate(item.createdAt),
            thumbnailUrl = item.thumbnail?.src,
            profileImageUrl = item.channel?.user?.profileImage,
            tags = item.tags
        )
    }

    fun toStream(channel: KickChannelResponse): Stream {
        return Stream(
            id = channel.livestream?.id?.toString(),
            channelId = channel.id?.toString(),
            channelLogin = channel.slug,
            channelName = channel.user?.username,
            gameId = channel.livestream?.category?.id?.toString(),
            gameSlug = channel.livestream?.category?.slug,
            gameName = channel.livestream?.category?.name,
            title = channel.livestream?.title,
            viewerCount = channel.livestream?.viewerCount,
            startedAt = normalizeDate(channel.livestream?.createdAt),
            thumbnailUrl = channel.livestream?.thumbnail?.src,
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
        return Game(
            gameId = item.id?.toString(),
            gameSlug = item.slug,
            gameName = item.name,
            boxArtUrl = item.banner?.url,
            viewersCount = item.viewers
        )
    }

    fun toChatMessage(message: KickMessage): ChatMessage {
        val rawContent = message.content ?: message.message ?: message.text ?: message.body
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
        return ChatMessage(
            id = message.id,
            userId = message.sender?.id?.toString() ?: message.userId?.toString(),
            userLogin = message.sender?.slug ?: message.sender?.username?.lowercase(Locale.ROOT),
            userName = message.sender?.username,
            message = content,
            color = message.sender?.identity?.color,
            badges = badges,
            timestamp = normalizeDate(message.createdAt)?.let { TwitchApiHelper.parseIso8601DateUTC(it) },
            fullMsg = rawContent
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

    fun getChatId(channel: KickChannelResponse): String? {
        return channel.chatroom?.id?.toString() ?: channel.id?.toString()
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

    private suspend inline fun <reified T> get(url: String): T = withContext(Dispatchers.IO) {
        okHttpClient.newCall(
            createRequestBuilder(url).build()
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

    private fun createRequestBuilder(url: String, isKickWeb: Boolean = false): Request.Builder {
        return Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            .header("Accept", "application/json")
            .apply {
                if (isKickWeb) {
                    header("Origin", "https://kick.com")
                    header("Referer", "https://kick.com/")
                    AuthStateHelper.getKickBearerToken(context)?.let { bearer ->
                        header("Authorization", bearer)
                    }
                }
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

    private fun JsonObject.objOrNull(key: String): JsonObject? {
        return this[key] as? JsonObject
    }

    private fun JsonObject.arrayOrNull(key: String): JsonArray? {
        return this[key] as? JsonArray
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
