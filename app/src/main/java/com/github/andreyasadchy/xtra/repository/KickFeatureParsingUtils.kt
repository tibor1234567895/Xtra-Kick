package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.chat.ChannelPointReward
import com.github.andreyasadchy.xtra.model.chat.PinnedGift
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import java.util.Locale

object KickFeatureParsingUtils {
    private val parserJson = Json { ignoreUnknownKeys = true }
    private val explicitPinnedKeys = setOf(
        "pinned_time_seconds",
        "pin_duration",
        "pin_duration_seconds",
        "pinned_message_id",
        "pinned_message",
        "pinned_chat_message",
        "current_pinned_message",
        "pinnedby",
        "pinned_by"
    )

    data class KickWebBadgeSnapshot(
        val jsonPayloads: List<JsonElement> = emptyList(),
        val chunkUrls: List<String> = emptyList(),
        val buildId: String? = null,
    )

    fun extractKickWebBadgeSnapshot(html: String, pageUrl: String = "https://kick.com"): KickWebBadgeSnapshot {
        if (html.isBlank()) {
            return KickWebBadgeSnapshot()
        }
        val payloads = LinkedHashMap<String, JsonElement>()
        val chunkUrls = linkedSetOf<String>()
        var chunkAssetBase: String? = null

        fun resolveChunkUrl(raw: String): String? {
            val value = raw.trim().trim('"').trim('\'')
            if (value.isBlank()) return null
            return when {
                value.startsWith("https://", ignoreCase = true) || value.startsWith("http://", ignoreCase = true) -> value
                value.startsWith("//") -> "https:$value"
                value.startsWith("/_next/") -> chunkAssetBase?.let { "$it$value" } ?: "https://kick.com$value"
                value.startsWith("_next/") -> chunkAssetBase?.let { "$it/$value" } ?: "https://kick.com/$value"
                value.startsWith("static/chunks/") -> chunkAssetBase?.let { "$it/_next/$value" } ?: "https://kick.com/_next/$value"
                else -> normalizeScriptSrc(value, pageUrl)
            }
        }

        fun collectChunkUrls(raw: String?) {
            if (raw.isNullOrBlank()) return
            Regex(
                """(?:https?:\\/\\/[^\"'\\s>]+/_next/static/chunks/[^\"'\\s>]+|/_next/static/chunks/[^\"'\\s>]+|_next/static/chunks/[^\"'\\s>]+|static/chunks/[^\"'\\s>]+)"""
            ).findAll(raw).forEach { match ->
                resolveChunkUrl(cleanWebUrl(match.value) ?: match.value)?.let(chunkUrls::add)
            }
        }

        fun addPayload(raw: String?) {
            if (raw.isNullOrBlank()) return
            val candidate = raw.trim()
            if (candidate.isBlank()) return
            runCatching { parserJson.parseToJsonElement(candidate) }
                .getOrNull()
                ?.let { payloads.putIfAbsent(it.toString(), it) }
        }

        val nextDataMatch = Regex(
            """<script[^>]*id=[\"']__NEXT_DATA__[\"'][^>]*>([\s\S]*?)</script>""",
            setOf(RegexOption.IGNORE_CASE)
        ).find(html)
        addPayload(nextDataMatch?.groupValues?.getOrNull(1))

        val chunkRegex = Regex(
            """<script[^>]+src=[\"']([^\"']*_next/static/chunks/[^\"']+)[\"'][^>]*>""",
            setOf(RegexOption.IGNORE_CASE)
        )
        chunkRegex.findAll(html).forEach { match ->
            val src = match.groupValues.getOrElse(1) { "" }
            normalizeScriptSrc(src, pageUrl)?.let { normalized ->
                chunkUrls += normalized
                if (chunkAssetBase == null) {
                    val marker = "/_next/static/chunks/"
                    val markerIndex = normalized.indexOf(marker)
                    if (markerIndex > 0) {
                        chunkAssetBase = normalized.substring(0, markerIndex)
                    }
                }
            }
        }
        collectChunkUrls(html)

        val pushRegex = Regex("""self\.__next_f\.push\((.*?)\);""", setOf(RegexOption.DOT_MATCHES_ALL))
        pushRegex.findAll(html).forEach { match ->
            val pushArg = match.groupValues.getOrNull(1)
            addPayload(pushArg)
            collectChunkUrls(pushArg)
            Regex("\"((?:\\\\.|[^\"\\\\])+)\"")
                .findAll(pushArg.orEmpty()).forEach { stringMatch ->
                val decoded = decodeJsString(stringMatch.groupValues.getOrElse(1) { "" })
                if (decoded.startsWith("{") || decoded.startsWith("[")) {
                    addPayload(decoded)
                }
                collectChunkUrls(decoded)
            }
        }

        val buildId = Regex("""[\"']buildId[\"']\s*:\s*[\"']([^\"']+)[\"']"""
        ).find(html)?.groupValues?.getOrNull(1)

        return KickWebBadgeSnapshot(
            jsonPayloads = payloads.values.toList(),
            chunkUrls = chunkUrls.toList(),
            buildId = buildId,
        )
    }

    fun extractKickGlobalBadgeUrlsFromChunk(chunkBody: String): Map<String, String> {
        if (chunkBody.isBlank()) {
            return emptyMap()
        }
        val results = LinkedHashMap<String, String>()
        val normalizedBody = decodeJsString(chunkBody)

        fun store(typeRaw: String?, urlRaw: String?) {
            val normalizedType = typeRaw?.let(::normalizeKnownKickBadgeType) ?: return
            val cleanedUrl = cleanWebUrl(urlRaw) ?: return
            results.putIfAbsent(normalizedType, cleanedUrl)
        }

        Regex(
            """(?is)\"badge_type\"\s*:\s*\"([^\"]+)\"[\s\S]{0,260}?\"(?:badge_image_url|image_url|icon_url|url|src)\"\s*:\s*\"([^\"]+)\""""
        ).findAll(normalizedBody).forEach { match ->
            store(match.groupValues.getOrNull(1), match.groupValues.getOrNull(2))
        }

        Regex(
            """(?is)\"(moderator|vip|verified|founder|subscriber|sub[_-]?gifter|staff|broadcaster|og)\"\s*:\s*\{[\s\S]{0,260}?\"(?:badge_image_url|image_url|icon_url|url|src)\"\s*:\s*\"([^\"]+)\""""
        ).findAll(normalizedBody).forEach { match ->
            store(match.groupValues.getOrNull(1), match.groupValues.getOrNull(2))
        }

        Regex(
            """(?is)(moderator|vip|verified|founder|subscriber|sub[_-]?gifter|staff|broadcaster|og)[^\n\r]{0,240}?(https?:\\/\\/[^\"'\s)]+\.(?:svg|png|webp))"""
        ).findAll(normalizedBody).forEach { match ->
            store(match.groupValues.getOrNull(1), match.groupValues.getOrNull(2))
        }

        return results
    }

    private fun normalizeScriptSrc(src: String, pageUrl: String): String? {
        val value = src.trim().takeIf { it.isNotBlank() } ?: return null
        return when {
            value.startsWith("https://", ignoreCase = true) || value.startsWith("http://", ignoreCase = true) -> value
            value.startsWith("//") -> "https:$value"
            value.startsWith("/") -> "https://kick.com$value"
            value.startsWith("_next/") -> "https://kick.com/$value"
            else -> {
                val base = pageUrl.trim().ifBlank { "https://kick.com" }.removeSuffix("/")
                "$base/$value"
            }
        }
    }

    private fun cleanWebUrl(url: String?): String? {
        val raw = url?.trim()?.takeIf { it.isNotBlank() } ?: return null
        val cleaned = decodeJsString(raw)
            .replace("\\u002F", "/", ignoreCase = true)
            .replace("\\u003A", ":", ignoreCase = true)
            .replace("\\/", "/")
            .trim()
            .trim('"')
            .trim('\'')
        return when {
            cleaned.startsWith("https://", ignoreCase = true) || cleaned.startsWith("http://", ignoreCase = true) -> cleaned
            cleaned.startsWith("//") -> "https:$cleaned"
            cleaned.startsWith("files.kick.com", ignoreCase = true) -> "https://$cleaned"
            else -> null
        }
    }

    private fun normalizeKnownKickBadgeType(typeRaw: String): String {
        val normalized = typeRaw.trim().lowercase(Locale.ROOT).replace('-', '_').replace(' ', '_')
        return when {
            normalized.contains("moderator") || normalized == "mod" || normalized == "mods" -> "moderator"
            normalized.contains("verified") -> "verified"
            normalized.contains("founder") -> "founder"
            normalized.contains("vip") -> "vip"
            normalized.contains("staff") || normalized.contains("admin") -> "staff"
            normalized.contains("broadcaster") || normalized.contains("streamer") || normalized.contains("host") -> "broadcaster"
            normalized.contains("gift") && normalized.contains("sub") -> "sub_gifter"
            normalized.contains("gifter") -> "sub_gifter"
            normalized.contains("subscriber") || normalized == "sub" || normalized.contains("subscription") -> "subscriber"
            normalized == "og" || normalized.contains("original") -> "og"
            else -> normalized
        }
    }

    private fun decodeJsString(value: String): String {
        return value
            .replace("\\u002F", "/", ignoreCase = true)
            .replace("\\u003A", ":", ignoreCase = true)
            .replace("\\u003D", "=", ignoreCase = true)
            .replace("\\u0026", "&", ignoreCase = true)
            .replace("\\u005C", "\\", ignoreCase = true)
            .replace("\\/", "/")
            .replace("\\\"", "\"")
    }

    fun parsePinnedGiftUpdate(eventName: String?, messageJson: String): KickRepository.PinnedGiftUpdate? {
        val root = runCatching { parserJson.parseToJsonElement(messageJson) }.getOrNull() ?: return null
        parsePinnedMessageEvent(eventName, root, messageJson)?.let { return it }
        if (!looksLikePinnedGiftEvent(eventName, root)) {
            return null
        }
        if (isPinnedGiftCleared(eventName, root)) {
            return KickRepository.PinnedGiftUpdate(cleared = true)
        }
        val normalizedEventName = eventName?.lowercase(Locale.ROOT).orEmpty()
        val allowRootFallback = normalizedEventName.contains("pin") || normalizedEventName.contains("gift")
        val pinnedSeconds = findIntRecursive(root, setOf("pinned_time_seconds", "pin_duration", "pin_duration_seconds", "duration"))
        val giftCount = findIntRecursive(root, setOf("gifted_kicks", "kicks_gifted", "gift_count", "gifts_count"))
        val giftValue = findIntRecursive(root, setOf("gift_value", "gifted_amount", "gift_amount", "kicks_value", "kicks"))
        val pinnedBy = findObjectRecursive(root, setOf("pinnedby", "pinned_by"))
        val pinnedMessageElement = findElementRecursive(root, setOf("pinned_message", "pinnedmessage", "pinned_chat_message", "current_pinned_message"))
            ?: if (allowRootFallback) {
                findElementRecursive(root, setOf("message", "chat_message"))
            } else {
                null
            }
        if (normalizedEventName == "initial_state" && isEmptyPinnedPayload(pinnedMessageElement)) {
            return KickRepository.PinnedGiftUpdate(cleared = true)
        }
        val pinnedMessage = pinnedMessageElement as? JsonObject
        val messageSenderSource: JsonElement? = when {
            pinnedMessage != null -> findObjectRecursive(pinnedMessage, setOf("sender", "user", "author")) ?: pinnedMessage
            allowRootFallback -> findObjectRecursive(root, setOf("sender", "user", "author")) ?: root
            else -> null
        }
        val pinnedBySource = pinnedBy
            ?: findObjectRecursive(root, setOf("pinned_by", "pinnedby"))
        val messageSource = pinnedMessageElement ?: if (allowRootFallback) root else null
        val directPinnedText = extractPinnedMessageContent(pinnedMessageElement)
        val id = messageSource?.let {
            findStringRecursive(
                it,
                setOf("pinned_message_id", "pinned_chat_message_id", "chat_message_id", "message_id", "uuid", "id")
            )
        } ?: if (allowRootFallback) findStringRecursive(
            root,
            setOf("pinned_message_id", "pinned_chat_message_id", "chat_message_id", "message_id", "uuid", "id")
        ) else null
        val userId = messageSenderSource?.let { findStringRecursive(it, setOf("sender_id", "user_id", "creator_id", "author_id", "id")) }
        val userLogin = messageSenderSource?.let { findStringRecursive(it, setOf("sender_slug", "user_slug", "username_slug", "login", "slug")) }
        val userName = messageSenderSource?.let { findStringRecursive(it, setOf("sender_username", "display_name", "username", "user_name", "name")) }
        val userColor = messageSenderSource?.let { findStringRecursive(it, setOf("color", "name_color", "username_color")) }
        val avatarUrl = messageSenderSource?.let { findStringRecursive(it, setOf("profile_picture", "profilepic", "avatar", "avatar_url", "profile_image")) }
        val pinnedByUserId = findStringRecursive(pinnedBySource ?: root, setOf("sender_id", "user_id", "creator_id", "author_id", "id"))
        val pinnedByUserLogin = findStringRecursive(pinnedBySource ?: root, setOf("sender_slug", "user_slug", "username_slug", "login", "slug"))
        val pinnedByUserName = findStringRecursive(pinnedBySource ?: root, setOf("sender_username", "display_name", "username", "user_name", "name"))
        val pinnedByUserColor = findStringRecursive(pinnedBySource ?: root, setOf("color", "name_color", "username_color"))
        val message = directPinnedText
            ?: extractPinnedMessageContent(messageSource)
            ?: extractReadableText(messageSource)
        if (message.isNullOrBlank() && userLogin.isNullOrBlank() && userName.isNullOrBlank() && giftValue == null) {
            return null
        }
        val stableId = id ?: buildString {
            append("kick-pinned:")
            append(userId ?: userLogin ?: userName ?: "unknown")
            append(':')
            append(message ?: directPinnedText ?: giftValue?.toString() ?: "message")
        }
        return KickRepository.PinnedGiftUpdate(
            pinnedGift = PinnedGift(
                id = stableId,
                userId = userId,
                userLogin = userLogin,
                userName = userName,
                userColor = userColor,
                avatarUrl = avatarUrl,
                pinnedByUserId = pinnedByUserId,
                pinnedByUserLogin = pinnedByUserLogin,
                pinnedByUserName = pinnedByUserName,
                pinnedByUserColor = pinnedByUserColor,
                message = message,
                giftCount = giftCount,
                giftValue = giftValue,
                pinnedSeconds = pinnedSeconds,
                pinnedUntilMs = pinnedSeconds?.let { System.currentTimeMillis() + (it * 1000L) },
                rawEventName = eventName,
                fullMsg = messageJson,
            )
        )
    }

    private fun parsePinnedMessageEvent(
        eventName: String?,
        root: JsonElement,
        messageJson: String,
    ): KickRepository.PinnedGiftUpdate? {
        val normalizedEventName = eventName?.lowercase(Locale.ROOT).orEmpty()
        if (!normalizedEventName.contains("pinnedmessage") && !normalizedEventName.contains("pinned_message")) {
            return null
        }
        if (normalizedEventName.contains("delete") || normalizedEventName.contains("remove") || normalizedEventName.contains("clear")) {
            return KickRepository.PinnedGiftUpdate(cleared = true)
        }
        val messageObject = findObjectRecursive(root, setOf("message")) ?: (root as? JsonObject)
        val senderObject = messageObject?.let { findObjectRecursive(it, setOf("sender", "user", "author")) }
        val pinnedByObject = findObjectRecursive(root, setOf("pinned_by", "pinnedby"))
        val content = extractPinnedMessageContent(messageObject ?: root)
            ?: extractReadableText(messageObject ?: root)
        val messageId = findStringRecursive(messageObject ?: root, setOf("id", "message_id", "pinned_message_id"))
        val durationSeconds = findIntRecursive(root, setOf("duration", "duration_seconds", "pin_duration", "pinned_time_seconds"))
        if (content.isNullOrBlank() && messageId.isNullOrBlank()) {
            return null
        }
        return KickRepository.PinnedGiftUpdate(
            pinnedGift = PinnedGift(
                id = messageId ?: buildString {
                    append("kick-pinned:")
                    append(findStringRecursive(senderObject ?: root, setOf("id", "user_id", "sender_id")) ?: "unknown")
                    append(':')
                    append(content ?: "message")
                },
                userId = findStringRecursive(senderObject ?: root, setOf("id", "user_id", "sender_id")),
                userLogin = findStringRecursive(senderObject ?: root, setOf("slug", "channel_slug", "login")),
                userName = findStringRecursive(senderObject ?: root, setOf("username", "display_name", "name")),
                userColor = findStringRecursive(senderObject ?: root, setOf("color", "name_color", "username_color")),
                pinnedByUserId = findStringRecursive(pinnedByObject ?: root, setOf("id", "user_id", "sender_id")),
                pinnedByUserLogin = findStringRecursive(pinnedByObject ?: root, setOf("slug", "channel_slug", "login")),
                pinnedByUserName = findStringRecursive(pinnedByObject ?: root, setOf("username", "display_name", "name")),
                pinnedByUserColor = findStringRecursive(pinnedByObject ?: root, setOf("color", "name_color", "username_color")),
                message = content,
                pinnedSeconds = durationSeconds,
                pinnedUntilMs = durationSeconds?.let { System.currentTimeMillis() + (it * 1000L) },
                rawEventName = eventName,
                fullMsg = messageJson,
            )
        )
    }

    fun parseChannelPointRewardsResponse(raw: String, json: Json): KickRepository.ChannelPointRewardsResult {
        val root = runCatching { json.parseToJsonElement(raw) }.getOrNull() ?: return KickRepository.ChannelPointRewardsResult()
        return parseChannelPointRewardsResponse(root)
    }

    fun parseChannelPointRewardsResponse(root: JsonElement): KickRepository.ChannelPointRewardsResult {
        val rewards = linkedMapOf<String, ChannelPointReward>()
        var available = false
        var balance: Int? = null

        fun walk(element: JsonElement, path: List<String>) {
            when (element) {
                is JsonObject -> {
                    if (path.any { it.contains("reward") || it.contains("community-point") || it.contains("channel-point") }) {
                        available = true
                    }
                    if (balance == null) {
                        balance = intValue(element, listOf("balance", "current_balance", "viewer_balance", "points_balance", "community_points_balance", "points"))
                    }
                    val rewardId = stringValue(element, listOf("id", "reward_id", "uuid"))
                    val rewardTitle = stringValue(element, listOf("title", "name"))
                    val cost = intValue(element, listOf("cost", "value", "points_cost"))
                    val imageUrl = stringValue(element, listOf("image_url", "icon_url", "url"))
                        ?: extractImageUrl(element["image"])
                        ?: extractImageUrl(element["icon"])
                        ?: extractImageUrl(element["default_image"])
                    val userInputRequired = booleanValue(element, listOf("is_user_input_required", "requires_user_input"))
                    val isEnabled = booleanValue(element, listOf("is_enabled", "enabled", "active"))
                    val backgroundColor = stringValue(element, listOf("background_color", "color"))
                    val prompt = stringValue(element, listOf("prompt", "description"))
                    val hasRewardShape = !rewardId.isNullOrBlank() || (!rewardTitle.isNullOrBlank() && cost != null) || userInputRequired != null
                    if (hasRewardShape) {
                        available = true
                        val normalizedId = rewardId ?: "${rewardTitle.orEmpty()}|${cost ?: -1}"
                        rewards[normalizedId] = ChannelPointReward(
                            id = rewardId,
                            title = rewardTitle,
                            cost = cost,
                            url1x = imageUrl,
                            url2x = imageUrl,
                            url4x = imageUrl,
                            backgroundColor = backgroundColor,
                            isEnabled = isEnabled,
                            isUserInputRequired = userInputRequired,
                            prompt = prompt,
                        )
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
        return KickRepository.ChannelPointRewardsResult(
            rewards = rewards.values.sortedWith(compareBy<ChannelPointReward> { it.cost ?: Int.MAX_VALUE }.thenBy { it.title.orEmpty() }),
            available = available,
            balance = balance,
        )
    }

    private fun looksLikePinnedGiftEvent(eventName: String?, root: JsonElement): Boolean {
        val normalizedEventName = eventName?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEventName.contains("pin")) return true
        if (normalizedEventName.contains("gift") && findIntRecursive(root, setOf("pinned_time_seconds", "pin_duration", "pin_duration_seconds", "duration")) != null) {
            return true
        }
        return containsKeyRecursive(root, explicitPinnedKeys)
    }

    private fun isPinnedGiftCleared(eventName: String?, root: JsonElement): Boolean {
        val normalizedEventName = eventName?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEventName.contains("unpin") || normalizedEventName.contains("delete")) {
            return true
        }
        val action = findStringRecursive(root, setOf("action", "event", "type", "status"))?.lowercase(Locale.ROOT)
        if (action == "deleted" || action == "removed" || action == "unpinned" || action == "cleared") {
            return true
        }
        return findBooleanRecursive(root, setOf("is_deleted", "deleted", "removed", "unpinned")) == true
    }

    private fun containsKeyRecursive(root: JsonElement, targetKeys: Set<String>): Boolean {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        when (root) {
            is JsonObject -> {
                root.forEach { (key, value) ->
                    if (key.lowercase(Locale.ROOT) in normalizedKeys) {
                        return true
                    }
                    if (containsKeyRecursive(value, normalizedKeys)) {
                        return true
                    }
                }
            }
            is JsonArray -> root.forEach { child ->
                if (containsKeyRecursive(child, normalizedKeys)) return true
            }
            else -> Unit
        }
        return false
    }

    private fun findStringRecursive(root: JsonElement, targetKeys: Set<String>): String? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        when (root) {
            is JsonObject -> {
                root.forEach { (key, value) ->
                    if (key.lowercase(Locale.ROOT) in normalizedKeys) {
                        when (value) {
                            is JsonPrimitive -> {
                                value.contentOrNull?.takeIf { it.isNotBlank() }?.let { return it }
                            }
                            else -> Unit
                        }
                    }
                    findStringRecursive(value, normalizedKeys)?.let { return it }
                }
            }
            is JsonArray -> root.forEach { child ->
                findStringRecursive(child, normalizedKeys)?.let { return it }
            }
            is JsonPrimitive -> Unit
        }
        return null
    }

    private fun findIntRecursive(root: JsonElement, targetKeys: Set<String>): Int? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        when (root) {
            is JsonObject -> {
                root.forEach { (key, value) ->
                    if (key.lowercase(Locale.ROOT) in normalizedKeys) {
                        when (value) {
                            is JsonPrimitive -> {
                                value.intOrNull?.let { return it }
                                value.contentOrNull?.toIntOrNull()?.let { return it }
                            }
                            else -> Unit
                        }
                    }
                    findIntRecursive(value, normalizedKeys)?.let { return it }
                }
            }
            is JsonArray -> root.forEach { child ->
                findIntRecursive(child, normalizedKeys)?.let { return it }
            }
            else -> Unit
        }
        return null
    }

    private fun findBooleanRecursive(root: JsonElement, targetKeys: Set<String>): Boolean? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        when (root) {
            is JsonObject -> {
                root.forEach { (key, value) ->
                    if (key.lowercase(Locale.ROOT) in normalizedKeys) {
                        when (value) {
                            is JsonPrimitive -> {
                                value.booleanOrNull?.let { return it }
                                value.contentOrNull?.toBooleanStrictOrNull()?.let { return it }
                            }
                            else -> Unit
                        }
                    }
                    findBooleanRecursive(value, normalizedKeys)?.let { return it }
                }
            }
            is JsonArray -> root.forEach { child ->
                findBooleanRecursive(child, normalizedKeys)?.let { return it }
            }
            else -> Unit
        }
        return null
    }

    private fun findObjectRecursive(root: JsonElement, targetKeys: Set<String>): JsonObject? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        when (root) {
            is JsonObject -> {
                root.forEach { (key, value) ->
                    if (key.lowercase(Locale.ROOT) in normalizedKeys) {
                        (value as? JsonObject)?.let { return it }
                    }
                    findObjectRecursive(value, normalizedKeys)?.let { return it }
                }
            }
            is JsonArray -> root.forEach { child ->
                findObjectRecursive(child, normalizedKeys)?.let { return it }
            }
            else -> Unit
        }
        return null
    }

    private fun findElementRecursive(root: JsonElement, targetKeys: Set<String>): JsonElement? {
        val normalizedKeys = targetKeys.map { it.lowercase(Locale.ROOT) }.toSet()
        when (root) {
            is JsonObject -> {
                root.forEach { (key, value) ->
                    if (key.lowercase(Locale.ROOT) in normalizedKeys) {
                        return value
                    }
                    findElementRecursive(value, normalizedKeys)?.let { return it }
                }
            }
            is JsonArray -> root.forEach { child ->
                findElementRecursive(child, normalizedKeys)?.let { return it }
            }
            else -> Unit
        }
        return null
    }

    private fun stringValue(obj: JsonObject, keys: List<String>): String? {
        keys.forEach { key ->
            (obj[key] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }?.let { return it }
        }
        return null
    }

    private fun intValue(obj: JsonObject, keys: List<String>): Int? {
        keys.forEach { key ->
            val primitive = obj[key] as? JsonPrimitive ?: return@forEach
            primitive.intOrNull?.let { return it }
            primitive.contentOrNull?.toIntOrNull()?.let { return it }
        }
        return null
    }

    private fun booleanValue(obj: JsonObject, keys: List<String>): Boolean? {
        keys.forEach { key ->
            val primitive = obj[key] as? JsonPrimitive ?: return@forEach
            primitive.contentOrNull?.let { value ->
                if (value.equals("true", true)) return true
                if (value.equals("false", true)) return false
            }
        }
        return null
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

    private fun extractReadableText(element: JsonElement?): String? {
        return when (element) {
            null -> null
            is JsonPrimitive -> {
                element.contentOrNull
                    ?.trim()
                    ?.takeIf(::looksLikeReadableText)
            }
            is JsonArray -> {
                val parts = element.mapNotNull { extractReadableText(it) }
                    .distinct()
                when {
                    parts.isEmpty() -> null
                    parts.size == 1 -> parts.first()
                    else -> parts.joinToString(" ").trim().takeIf(::looksLikeReadableText)
                        ?: parts.maxByOrNull { it.length }
                }
            }
            is JsonObject -> {
                val preferredKeys = listOf(
                    "content", "message", "text", "body", "plain_text", "display_text", "value", "comment"
                )
                preferredKeys.forEach { key ->
                    extractReadableText(element[key])?.let { return it }
                }
                val ignoredKeys = setOf(
                    "id", "uuid", "user_id", "sender_id", "slug", "login", "username", "name",
                    "avatar", "avatar_url", "profile_image", "profile_picture", "image", "icon",
                    "badge", "color", "type", "created_at", "updated_at", "timestamp", "duration"
                )
                val parts = element.entries.mapNotNull { (key, value) ->
                    key.lowercase(Locale.ROOT)
                        .takeIf { it !in ignoredKeys }
                        ?.let { extractReadableText(value) }
                }.distinct()
                when {
                    parts.isEmpty() -> null
                    parts.size == 1 -> parts.first()
                    else -> parts.joinToString(" ").trim().takeIf(::looksLikeReadableText)
                        ?: parts.firstOrNull { it.contains(' ') }
                        ?: parts.maxByOrNull { it.length }
                }
            }
        }
    }

    private fun extractPinnedMessageContent(element: JsonElement?): String? {
        return when (element) {
            null -> null
            is JsonPrimitive -> element.contentOrNull?.trim()?.takeIf { it.isNotBlank() }
            is JsonArray -> element.firstNotNullOfOrNull { extractPinnedMessageContent(it) }
            is JsonObject -> {
                listOf("content", "text", "body", "plain_text", "display_text", "comment").forEach { key ->
                    (element[key] as? JsonPrimitive)?.contentOrNull?.trim()?.takeIf { it.isNotBlank() }?.let { return it }
                }
                (element["message"] as? JsonPrimitive)?.contentOrNull?.trim()?.takeIf { it.isNotBlank() }?.let { return it }
                listOf("message", "chat_message", "pinned_message", "current_pinned_message", "data").forEach { key ->
                    extractPinnedMessageContent(element[key])?.let { return it }
                }
                null
            }
        }
    }

    private fun isEmptyPinnedPayload(element: JsonElement?): Boolean {
        return when (element) {
            null -> false
            is JsonObject -> element.isEmpty()
            is JsonArray -> element.isEmpty()
            is JsonPrimitive -> element.contentOrNull.isNullOrBlank()
        }
    }

    private fun looksLikeReadableText(value: String): Boolean {
        if (value.isBlank()) {
            return false
        }
        if (value.startsWith("http://") || value.startsWith("https://")) {
            return false
        }
        if (value.all { it.isDigit() }) {
            return false
        }
        return value.contains(' ') ||
            value.length >= 12 ||
            value.any { it in "!?.,:'\"()" }
    }
}
