package com.github.andreyasadchy.xtra.repository

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Locale

/**
 * Pure candidate-list / stop / auth-skip helpers for Kick web API probes.
 * Kept free of OkHttp so unit tests can assert sequences without network I/O.
 */
object KickApiCandidateUtils {

    fun urlEncode(value: String): String {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString())
    }

    /**
     * Channel-points / rewards URL candidates.
     *
     * Prefer slug-based public rewards. Optional `/points` only when cookies look present
     * **and** private web auth has not already been proven unusable (log: websiteSession=true
     * still 401s on `/points`). Known-dead shapes from multipov logcat (v1 rewards,
     * community-points, `/me`, numeric community-points) are omitted.
     */
    fun buildChannelPointRewardCandidates(
        channelSlug: String?,
        channelId: String?,
        hasKickWebsiteSession: Boolean,
        privateWebAuthUsable: Boolean = true,
    ): List<String> {
        val normalizedSlug = channelSlug?.trim()?.takeIf { it.isNotBlank() }
        val normalizedId = channelId?.trim()?.takeIf { it.isNotBlank() }
        val probeBalance = hasKickWebsiteSession && privateWebAuthUsable
        return buildList {
            normalizedSlug?.let { slug ->
                val encoded = urlEncode(slug)
                if (probeBalance) {
                    add("https://kick.com/api/v2/channels/$encoded/points")
                }
                add("https://kick.com/api/v2/channels/$encoded/rewards")
            }
            if (normalizedSlug == null) {
                normalizedId?.let { id ->
                    val encoded = urlEncode(id)
                    if (probeBalance) {
                        add("https://kick.com/api/v2/channels/$encoded/points")
                    }
                    add("https://kick.com/api/v2/channels/$encoded/rewards")
                }
            }
        }
    }

    /**
     * Whether to call session-gated private web endpoints (`/points`, `/me`, broadcasting/auth).
     * Cookie presence alone is not enough (log: websiteSession=true still 401).
     */
    fun shouldProbePrivateWebEndpoint(
        hasKickWebsiteSession: Boolean,
        privateWebAuthUsable: Boolean,
    ): Boolean = hasKickWebsiteSession && privateWebAuthUsable

    /**
     * Stop walking further candidates once rewards are usable.
     * Do not continue solely to hunt a missing balance across dead endpoints.
     */
    fun shouldStopChannelPointFetch(
        rewardsCount: Int,
        available: Boolean,
        balance: Int?,
    ): Boolean {
        if (available || rewardsCount > 0) {
            return true
        }
        return balance != null
    }

    /**
     * Extract only dedicated chatroom ids from a chatroom JSON payload.
     * Never treat channel_id / user_id as chatroom ids (those produce 404/405 on
     * GET api/v1|v2/chatrooms/{id}).
     */
    fun extractDedicatedChatroomIds(root: JsonElement?): List<String> {
        val obj = root as? JsonObject ?: return emptyList()
        val results = linkedSetOf<String>()
        fun addId(value: String?) {
            value?.trim()?.takeIf { it.isNotBlank() }?.let(results::add)
        }
        fun primitive(map: JsonObject?, key: String): String? {
            return (map?.get(key) as? JsonPrimitive)?.contentOrNull
        }
        fun isChatroomShaped(map: JsonObject?): Boolean {
            if (map == null) return false
            return map.containsKey("slow_mode") ||
                map.containsKey("subscribers_mode") ||
                map.containsKey("followers_mode") ||
                map.containsKey("emotes_mode") ||
                map.containsKey("pinned_message")
        }
        val nestedChatroom = obj["chatroom"] as? JsonObject
        val nestedData = obj["data"] as? JsonObject
        val nestedDataChatroom = nestedData?.get("chatroom") as? JsonObject
        // Nested chatroom objects always contribute their id.
        addId(primitive(nestedChatroom, "id"))
        addId(primitive(nestedDataChatroom, "id"))
        // Top-level / data-level id only for chatroom-shaped documents (not channel envelopes).
        if (isChatroomShaped(obj)) {
            addId(primitive(obj, "id"))
        }
        if (isChatroomShaped(nestedData)) {
            addId(primitive(nestedData, "id"))
        }
        return results.toList()
    }

    /**
     * URLs used only to discover a dedicated chatroom id (not room-state / pinned probes).
     * Prefer slug; never use numeric-only user id as the primary path when a slug exists
     * (caller should pass slug when available).
     */
    fun buildDedicatedChatroomDiscoveryUrls(channelOrId: String): List<String> {
        val candidate = channelOrId.trim()
        if (candidate.isBlank()) return emptyList()
        val encoded = urlEncode(candidate)
        return buildList {
            add("https://kick.com/api/v2/channels/$encoded/chatroom")
            if (!candidate.all(Char::isDigit)) {
                add("https://kick.com/api/v1/$encoded/chatroom")
            }
        }
    }

    /**
     * Room-state probe URLs. Slug-based channel chatroom first (works in logcat).
     * Omits GET api/v1|v2/chatrooms/{id} (405/404) and numeric channels/{userId}/chatroom
     * when a slug is available.
     */
    fun buildRoomStateCandidates(
        channelSlug: String?,
        channelId: String?,
    ): List<String> {
        val normalizedSlug = channelSlug?.trim()?.takeIf { it.isNotBlank() }
        val normalizedChannelId = channelId?.trim()?.takeIf { it.isNotBlank() }
        val candidates = linkedSetOf<String>()
        normalizedSlug?.let { slug ->
            val encoded = urlEncode(slug)
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v1/$encoded/chatroom"
            candidates += "https://kick.com/api/v2/channels/$encoded"
            candidates += "https://kick.com/api/v2/channels/$encoded/info"
        }
        // Numeric id only when slug is missing — channels/{userId}/chatroom 404s in logcat.
        if (normalizedSlug == null) {
            normalizedChannelId?.let { id ->
                val encoded = urlEncode(id)
                candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
                candidates += "https://kick.com/api/v2/channels/$encoded"
                candidates += "https://kick.com/api/v1/channels/$encoded"
            }
        } else {
            normalizedChannelId?.let { id ->
                val encoded = urlEncode(id)
                // Channel document fallbacks only (not .../chatroom with user id).
                candidates += "https://kick.com/api/v2/channels/$encoded"
                candidates += "https://kick.com/api/v1/channels/$encoded"
            }
        }
        return candidates.toList()
    }

    /**
     * Initial pinned-gift probe URLs. Keeps history + slug chatroom paths; omits
     * GET chatrooms/{id} and numeric-id chatroom paths when slug is present.
     *
     * @param historyChannelId optional channel id for web.kick.com history (not user_id).
     */
    fun buildPinnedGiftCandidates(
        channelSlug: String?,
        channelId: String?,
        historyChannelId: String? = null,
    ): List<String> {
        val normalizedSlug = channelSlug?.trim()?.takeIf { it.isNotBlank() }
        val normalizedChannelId = channelId?.trim()?.takeIf { it.isNotBlank() }
        val historyId = historyChannelId?.trim()?.takeIf { it.isNotBlank() }
            ?: normalizedChannelId
        val candidates = linkedSetOf<String>()
        historyId?.let { id ->
            candidates += "https://web.kick.com/api/v1/chat/${urlEncode(id)}/history"
        }
        normalizedSlug?.let { slug ->
            val encoded = urlEncode(slug)
            candidates += "https://kick.com/api/v2/channels/$encoded"
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v1/$encoded/chatroom"
            candidates += "https://kick.com/api/v2/channels/$encoded/info"
            candidates += "https://kick.com/api/internal/v1/channels/$encoded/chatroom/pinned-message"
        }
        if (normalizedSlug == null) {
            normalizedChannelId?.let { id ->
                val encoded = urlEncode(id)
                candidates += "https://kick.com/api/v2/channels/$encoded"
                candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
                candidates += "https://kick.com/api/v1/channels/$encoded"
                candidates += "https://kick.com/api/internal/v1/channels/$encoded/chatroom/pinned-message"
            }
        }
        return candidates.toList()
    }

    /**
     * Whether private Pusher auth should be attempted for remaining channels in this
     * connect cycle. After any auth failure, further private channels are skipped.
     */
    fun shouldAttemptPrivatePusherAuth(
        previousAuthFailedInCycle: Boolean,
        hasSocketId: Boolean,
    ): Boolean = hasSocketId && !previousAuthFailedInCycle

    /**
     * Kick web GETs that MultiPOV/chat re-hits heavily and are safe to short-TTL cache
     * (chatroom document, channel envelope, history). Avoid caching auth/mutations.
     */
    fun shouldShortCacheKickWebGet(url: String): Boolean {
        val normalized = url.trim().lowercase(Locale.ROOT)
        if (normalized.isBlank()) return false
        if (normalized.contains("broadcasting/auth")) return false
        if (normalized.contains("/points") || normalized.endsWith("/me") || normalized.contains("/redeem")) {
            return false
        }
        if (normalized.contains("/chatroom")) return true
        if (normalized.contains("/chat/") && normalized.contains("/history")) return true
        // Channel envelope only (no extra path segment after the slug/id).
        return CHANNEL_ENVELOPE_URL.containsMatchIn(normalized)
    }

    private val CHANNEL_ENVELOPE_URL =
        Regex("""https://kick\.com/api/v[12]/channels/[^/?#]+/?(\?.*)?$""")

    /**
     * Ordered message-source ids for web.kick.com chat history.
     *
     * Log-anchored for 4head: history works with channel top-level id (2587387);
     * user id (2642629) returns empty; chatroom id is for Pusher, not history.
     * Prefer preferred + history channel id; deprioritize/omit raw user ids when history id known.
     */
    fun buildLiveHistoryMessageSources(
        preferredSource: String? = null,
        historyChannelId: String? = null,
        chatroomIds: Collection<String> = emptyList(),
        channelId: String? = null,
        userIds: Collection<String> = emptyList(),
        channelLogin: String? = null,
    ): List<String> {
        fun norm(value: String?): String? = value?.trim()?.takeIf { it.isNotBlank() }
        val preferred = norm(preferredSource)
        val historyId = norm(historyChannelId)
        val rawChannelId = norm(channelId)
        val login = norm(channelLogin)
        val userIdSet = userIds.mapNotNull { norm(it) }.toSet()
        val chatroomSet = chatroomIds.mapNotNull { norm(it) }.toSet()

        val ordered = linkedSetOf<String>()
        preferred?.let(ordered::add)
        historyId?.let(ordered::add)

        if (historyId == null) {
            // No resolved history id yet — try channelId, then chatroom ids as weak fallbacks.
            rawChannelId?.let(ordered::add)
            chatroomSet.forEach(ordered::add)
            userIdSet.forEach(ordered::add)
        } else {
            // History id known: do not probe user ids or chatroom ids first (empty/wrong in log).
            // Keep raw channelId only when it is the same as history id (already added).
            if (rawChannelId != null && rawChannelId != historyId && rawChannelId !in userIdSet) {
                ordered += rawChannelId
            }
        }
        // Login slug is last-resort and usually wrong for /chat/{id}/history.
        if (login != null && !login.all(Char::isDigit)) {
            ordered += login
        }
        return ordered.toList()
    }

    /**
     * Badge catalog probe URLs for a channel.
     *
     * Omits dead GET `api/v1|v2/chatrooms/{id}` and numeric `channels/{id}/chatroom` when slug present.
     * Prefers slug chatroom/badges/info paths.
     */
    fun buildBadgeCatalogCandidates(
        channelSlug: String?,
        channelId: String?,
    ): List<String> {
        val normalizedSlug = channelSlug?.trim()?.takeIf { it.isNotBlank() }
        val normalizedChannelId = channelId?.trim()?.takeIf { it.isNotBlank() }
        val candidates = linkedSetOf<String>()
        normalizedSlug?.let { slug ->
            val encoded = urlEncode(slug)
            candidates += "https://kick.com/api/v2/channels/$encoded/info"
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
            candidates += "https://kick.com/api/v2/channels/$encoded/chatroom/badges"
            candidates += "https://kick.com/api/v2/channels/$encoded/badges"
            candidates += "https://kick.com/api/v1/$encoded/chatroom"
            candidates += "https://kick.com/api/v1/channels/$encoded"
        }
        normalizedChannelId?.let { id ->
            val encoded = urlEncode(id)
            candidates += "https://kick.com/api/v2/channels/$encoded/info"
            candidates += "https://kick.com/api/v2/channels/$encoded/badges"
            // Numeric .../chatroom 404s in log when id is user/channel id, not slug.
            // Only probe chatroom under numeric id when no slug is available as a last resort.
            if (normalizedSlug == null) {
                candidates += "https://kick.com/api/v2/channels/$encoded/chatroom"
                candidates += "https://kick.com/api/v2/channels/$encoded/chatroom/badges"
            }
        }
        return candidates.toList()
    }
}
