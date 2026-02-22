package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.kick.KickChannelResponse
import com.github.andreyasadchy.xtra.model.kick.KickLivestream
import com.github.andreyasadchy.xtra.model.kick.KickLivestreamsResponse
import com.github.andreyasadchy.xtra.model.kick.KickMessage
import com.github.andreyasadchy.xtra.model.kick.KickMessagesData
import com.github.andreyasadchy.xtra.model.kick.KickMessagesEnvelope
import com.github.andreyasadchy.xtra.model.kick.KickSubcategoriesResponse
import com.github.andreyasadchy.xtra.model.kick.KickSubcategory
import com.github.andreyasadchy.xtra.model.kick.auth.KickChatSendRequest
import com.github.andreyasadchy.xtra.model.kick.auth.KickChatSendResponse
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.util.TwitchApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Request
import java.io.IOException
import java.net.URLEncoder
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KickRepository @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {

    private val emoteRegex = Regex("\\[emote:\\d+:([^\\]]+)]")

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
        return get("https://kick.com/api/v2/channels/${urlEncode(channelSlug)}")
    }

    suspend fun getRecentMessages(channelOrChatroomId: String): KickMessagesData {
        return get<KickMessagesEnvelope>("https://kick.com/api/v2/channels/${urlEncode(channelOrChatroomId)}/messages").data ?: KickMessagesData()
    }

    suspend fun sendChatMessage(accessToken: String, broadcasterUserId: Int, content: String): KickChatSendResponse = withContext(Dispatchers.IO) {
        val body = json.encodeToString(
            KickChatSendRequest.serializer(),
            KickChatSendRequest(
                broadcasterUserId = broadcasterUserId,
                content = content,
            )
        )
        okHttpClient.newCall(
            Request.Builder()
                .url("https://api.kick.com/public/v1/chat")
                .header("User-Agent", "okhttp/5.0.0")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer $accessToken")
                .header("Content-Type", "application/json")
                .post(body.toRequestBody())
                .build()
        ).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick chat send failed (${response.code})")
            }
            json.decodeFromString<KickChatSendResponse>(response.body.string())
        }
    }

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
        val badges = message.sender?.identity?.badges?.mapNotNull { badge ->
            val setId = badge.type ?: badge.text
            setId?.let { Badge(it, (badge.count ?: 1).toString()) }
        }?.takeIf { it.isNotEmpty() }
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
