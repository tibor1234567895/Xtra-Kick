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
        val messageSenderSource = pinnedMessage?.let { findObjectRecursive(it, setOf("sender", "user", "author")) }
            ?: if (allowRootFallback) findObjectRecursive(root, setOf("sender", "user", "author")) else null
            ?: pinnedMessage
            ?: if (allowRootFallback) root else null
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
