package com.github.andreyasadchy.xtra.repository

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
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.util.TwitchApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
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
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {

    private val tag = "KickRepository"
    private val badgeDebugTag = "KickBadgeDebug"
    private val emoteRegex = Regex("\\[emote:\\d+:([^\\]]+)]")
    private val kickBadgeFallbackBaseUrl = "https://www.kickdatabase.com/kickBadges/"
    private val kickBadgeUrls = ConcurrentHashMap<String, String>()
    private val kickBadgeCatalogFetched = ConcurrentHashMap.newKeySet<String>()

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
        return get<KickChannelResponse>("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}").also { channel ->
            cacheKickBadgeUrls(channel)
            val channelCacheKey = channel.id?.toString() ?: channel.slug.orEmpty()
            if (channelCacheKey.isNotBlank() && kickBadgeCatalogFetched.add(channelCacheKey)) {
                runCatching { prefetchKickBadgeCatalog(channel) }
                    .onFailure {
                        if (BuildConfig.DEBUG) {
                            Log.w(badgeDebugTag, "prefetch catalog failed for channel=$channelCacheKey: ${it.message}")
                        }
                    }
            }
        }
    }

    suspend fun getRecentMessages(channelOrChatroomId: String): KickMessagesData {
        return get<KickMessagesEnvelope>("https://kick.com/api/v2/channels/${urlEncode(channelOrChatroomId)}/messages").data ?: KickMessagesData()
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
        val content = message.content?.replace(emoteRegex) { result -> result.groupValues.getOrElse(1) { "" } }
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
            if (resolvedImageUrl.isNullOrBlank() && BuildConfig.DEBUG) {
                Log.w(
                    tag,
                    "Missing kick badge URL. type=$type normalized=$normalizedType version=$version text=${badge.text} rawUrlCandidates=${listOf(badge.badgeImageUrl, badge.badgeImage, badge.imageUrl, badge.image, badge.iconUrl, badge.icon, badge.badgeUrl, badge.src, badge.url)}"
                )
            }
            if (resolvedImageUrl.isNullOrBlank()) {
                return@mapNotNull null
            }
            if (BuildConfig.DEBUG && normalizedType in setOf("moderator", "vip", "verified", "og", "founder", "sub_gifter", "broadcaster", "staff")) {
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
            fullMsg = message.content
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

    private fun cacheKickBadgeUrls(channel: KickChannelResponse) {
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
                kickBadgeUrls[key] = imageUrl
                kickBadgeUrls.putIfAbsent("kick:$candidate:default", imageUrl)
                if (BuildConfig.DEBUG && candidate in setOf("moderator", "vip", "verified", "og", "founder", "sub_gifter", "broadcaster", "staff")) {
                    Log.d(badgeDebugTag, "cacheBadge key=$key hasUrl=${imageUrl.isNotBlank()}")
                }
            }
        }
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
                            if (BuildConfig.DEBUG && added > 0) {
                                Log.d(badgeDebugTag, "prefetch catalog matched $added entries from $url")
                            }
                        }
                }
                .onFailure {
                    if (BuildConfig.DEBUG) {
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

    private suspend inline fun <reified T> get(url: String): T = withContext(Dispatchers.IO) {
        okHttpClient.newCall(
            Request.Builder()
                .url(url)
                .header("User-Agent", "okhttp/5.0.0")
                .header("Accept", "application/json")
                .build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick request failed (${response.code}) for $url")
            }
            val body = response.body.string()
            json.decodeFromString<T>(body)
        }
    }

    private suspend fun getRaw(url: String): String = withContext(Dispatchers.IO) {
        okHttpClient.newCall(
            Request.Builder()
                .url(url)
                .header("User-Agent", "okhttp/5.0.0")
                .header("Accept", "application/json")
                .build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick request failed (${response.code}) for $url")
            }
            response.body.string()
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

    private fun encodeQuery(query: Map<String, String>): String {
        val url = "https://kick.com/".toHttpUrlOrNull() ?: return ""
        val builder = url.newBuilder()
        query.forEach { (key, value) ->
            builder.addQueryParameter(key, value)
        }
        return builder.build().query?.let { "?$it" } ?: ""
    }
}
