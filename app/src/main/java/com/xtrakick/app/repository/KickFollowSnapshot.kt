package com.xtrakick.app.repository

import java.io.IOException
import java.util.Locale
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

internal class KickFollowSnapshotException(message: String) : IOException(message)

internal object KickFollowSnapshot {
    private val json = Json { ignoreUnknownKeys = true }

    fun parsePage(payload: String, requireComplete: Boolean = false): KickRepository.KickFollowedChannelsPage {
        val root = json.parseToJsonElement(payload) as? JsonObject
            ?: throw KickFollowSnapshotException("Invalid Kick followed response")
        val entries = root["channels"] as? JsonArray
            ?: throw KickFollowSnapshotException("Missing Kick followed channels")
        val cursorValue = root["nextCursor"]
        if (cursorValue != null && cursorValue != JsonNull &&
            (cursorValue !is JsonPrimitive || (!cursorValue.isString && cursorValue.content.toLongOrNull() == null))
        ) {
            throw KickFollowSnapshotException("Invalid Kick followed cursor")
        }
        val cursor = (cursorValue as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
        val channels = entries.mapNotNull { element ->
            val item = element as? JsonObject
            val channel = item?.get("channel") as? JsonObject
            val user = item?.get("user") as? JsonObject
            val login = item?.text("channel_slug") ?: item?.text("slug") ?: channel?.text("slug")
                ?: item?.text("user_username") ?: item?.text("username")
            if (item == null || login == null) {
                if (requireComplete) throw KickFollowSnapshotException("Invalid Kick followed channel")
                return@mapNotNull null
            }
            KickRepository.KickFollowedChannel(
                login = login,
                name = item.text("user_username") ?: item.text("username") ?: item.text("channel_name")
                    ?: item.text("name") ?: channel?.text("name") ?: login,
                profilePicture = item.text("profile_picture") ?: item.text("profile_pic")
                    ?: item.text("profilepic") ?: item.text("profilePic")
                    ?: channel?.text("profile_picture") ?: channel?.text("profile_pic")
                    ?: user?.text("profile_picture") ?: user?.text("profile_pic"),
            )
        }
        return KickRepository.KickFollowedChannelsPage(channels, cursor)
    }

    suspend fun collect(fetchPage: suspend (String?) -> KickRepository.KickFollowedChannelsPage): List<KickRepository.KickFollowedChannel> {
        val channels = LinkedHashMap<String, KickRepository.KickFollowedChannel>()
        val cursors = HashSet<String>()
        var cursor: String? = null
        repeat(200) {
            val page = fetchPage(cursor)
            page.channels.forEach { channel ->
                val login = channel.login.trim().lowercase(Locale.ROOT)
                if (login.isBlank() || channels.put(login, channel) != null) {
                    throw KickFollowSnapshotException("Inconsistent Kick followed pages")
                }
            }
            val next = page.nextCursor ?: return channels.values.toList()
            if (page.channels.isEmpty() || !cursors.add(next)) {
                throw KickFollowSnapshotException("Incomplete Kick followed pagination")
            }
            cursor = next
        }
        throw KickFollowSnapshotException("Kick followed pagination limit exceeded")
    }

    private fun JsonObject.text(key: String): String? = (get(key) as? JsonPrimitive)
        ?.takeIf { it.isString }?.contentOrNull?.trim()?.takeIf { it.isNotBlank() }
}
