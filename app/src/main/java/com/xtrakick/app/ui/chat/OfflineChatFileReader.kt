package com.xtrakick.app.ui.chat

import android.content.ContentResolver
import android.content.Context
import android.util.JsonReader
import android.util.JsonToken
import androidx.core.net.toUri
import com.xtrakick.app.model.chat.Badge
import com.xtrakick.app.model.chat.ChatBadge
import com.xtrakick.app.model.chat.ChatEmote
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.chat.ChatUtils
import com.xtrakick.app.util.prefs
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.Reader

internal data class OfflineChatFileResult(
    val messages: List<ChatMessage>,
    val startTimeMs: Long,
    val chatEmotes: List<ChatEmote>,
    val channelBadges: List<ChatBadge>,
    val emotes: List<Emote>,
)

/**
 * Parses downloaded offline VOD/stream chat JSON files (both Kick real-time envelopes
 * and legacy IRC/comment exports) while tracking byte/char offsets for lazily loading
 * inline base64 emotes and badges.
 */
internal object OfflineChatFileReader {

    fun read(
        context: Context,
        kickRepository: KickRepository,
        url: String,
        fallbackStartTimeSeconds: Int? = null,
        buildReplyPreview: (ChatMessage, List<ChatMessage>) -> ChatMessage?,
        createDeletedMessage: (ChatMessage) -> ChatMessage,
        createClearMessage: (ChatMessage, ChatMessage?, String?) -> ChatMessage,
    ): OfflineChatFileResult {
        val reader = if (url.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
            context.contentResolver.openInputStream(url.toUri())?.bufferedReader()
        } else {
            FileInputStream(File(url)).bufferedReader()
        }
        return if (reader != null) {
            reader.use { fileReader ->
                readFromReader(
                    context = context,
                    kickRepository = kickRepository,
                    fileReader = fileReader,
                    nameDisplay = context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1"),
                    fallbackStartTimeSeconds = fallbackStartTimeSeconds,
                    buildReplyPreview = buildReplyPreview,
                    createDeletedMessage = createDeletedMessage,
                    createClearMessage = createClearMessage,
                )
            }
        } else {
            OfflineChatFileResult(
                messages = emptyList(),
                startTimeMs = fallbackStartTimeSeconds?.times(1000L) ?: 0L,
                chatEmotes = emptyList(),
                channelBadges = emptyList(),
                emotes = emptyList(),
            )
        }
    }

    internal fun readFromReader(
        context: Context,
        kickRepository: KickRepository,
        fileReader: Reader,
        nameDisplay: String?,
        fallbackStartTimeSeconds: Int? = null,
        buildReplyPreview: (ChatMessage, List<ChatMessage>) -> ChatMessage?,
        createDeletedMessage: (ChatMessage) -> ChatMessage,
        createClearMessage: (ChatMessage, ChatMessage?, String?) -> ChatMessage,
    ): OfflineChatFileResult {
        val messages = mutableListOf<ChatMessage>()
        var startTimeMs = fallbackStartTimeSeconds?.times(1000L) ?: 0L
        var fileStartTimeFound = false
        val chatEmotes = mutableListOf<ChatEmote>()
        val chatBadges = mutableListOf<ChatBadge>()
        val emotes = mutableListOf<Emote>()

        try {
            JsonReader(fileReader).use { reader ->
                reader.isLenient = true
                var position = 0L
                var token: JsonToken
                do {
                    token = reader.peek()
                    when (token) {
                        JsonToken.END_DOCUMENT -> {}
                        JsonToken.BEGIN_OBJECT -> {
                            reader.beginObject().also { position += 1 }
                            while (reader.hasNext()) {
                                when (reader.peek()) {
                                    JsonToken.NAME -> {
                                        when (reader.nextName().also { position += jsonEncodedStringLength(it) + 1 }) {
                                            "liveStartTime" -> {
                                                readStringOrSkip(reader) { position += it }
                                                    ?.let(KickApiHelper::parseIso8601DateUTC)
                                                    ?.let { startTimeMs = it }
                                            }
                                            "liveComments" -> {
                                                if (reader.peek() != JsonToken.BEGIN_ARRAY) {
                                                    position += skipJsonValue(reader)
                                                } else {
                                                    reader.beginArray().also { position += 1 }
                                                    while (reader.hasNext()) {
                                                        val message = readStringOrSkip(reader) { position += it }
                                                        if (message != null) {
                                                            runCatching {
                                                                when {
                                                                    message.startsWith("{") -> {
                                                                        val root = JSONObject(message)
                                                                        val eventName = root.optString("kickEvent", "App\\Events\\ChatMessageEvent")
                                                                        val payload = root.optString("kickData", message)
                                                                        kickRepository.parseKickRealtimeEvent(eventName, payload)?.allChatMessages?.forEach { parsed ->
                                                                            val timed = parsed.copyContent(timestamp = parsed.timestamp ?: startTimeMs)
                                                                            buildReplyPreview(timed, messages)?.let(messages::add)
                                                                            messages.add(timed)
                                                                        }
                                                                    }
                                                                    message.contains("PRIVMSG") -> {
                                                                        val chatMessage = ChatUtils.parseChatMessage(message, false)
                                                                        buildReplyPreview(chatMessage, messages)?.let(messages::add)
                                                                        messages.add(chatMessage)
                                                                    }
                                                                    message.contains("USERNOTICE") -> {
                                                                        val chatMessage = ChatUtils.parseChatMessage(message, true)
                                                                        buildReplyPreview(chatMessage, messages)?.let(messages::add)
                                                                        messages.add(chatMessage)
                                                                    }
                                                                    message.contains("CLEARMSG") -> {
                                                                        val pair = ChatUtils.parseClearMessage(message)
                                                                        val deletedMessageIndex = pair.second?.let { targetId ->
                                                                            messages.indexOfLast { it.id == targetId }
                                                                        } ?: -1
                                                                        if (deletedMessageIndex != -1) {
                                                                            messages[deletedMessageIndex] = createDeletedMessage(messages[deletedMessageIndex])
                                                                        } else {
                                                                            messages.add(createClearMessage(pair.first, null, nameDisplay))
                                                                        }
                                                                    }
                                                                    message.contains("CLEARCHAT") -> {
                                                                        messages.add(ChatUtils.parseClearChat(context, message))
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (reader.peek() != JsonToken.END_ARRAY) {
                                                            position += 1
                                                        }
                                                    }
                                                    reader.endArray().also { position += 1 }
                                                }
                                            }
                                            "comments" -> {
                                                readObjectArray(reader, { position += it }) {
                                                    val message = StringBuilder()
                                                    var previousWasEmote = false
                                                    var id: String? = null
                                                    var offsetSeconds: Int? = null
                                                    var userId: String? = null
                                                    var userLogin: String? = null
                                                    var userName: String? = null
                                                    var color: String? = null
                                                    val emotesList = mutableListOf<ChatEmote>()
                                                    val badgesList = mutableListOf<Badge>()
                                                    var hasMessageObject = false
                                                    readObjectOrSkip(reader, { position += it }) { field ->
                                                        when (field) {
                                                            "id" -> id = readStringOrSkip(reader) { position += it }
                                                            "commenter" -> readObjectOrSkip(reader, { position += it }) { commenterField ->
                                                                when (commenterField) {
                                                                    "id" -> userId = readStringOrSkip(reader) { position += it }
                                                                    "login" -> userLogin = readStringOrSkip(reader) { position += it }
                                                                    "displayName" -> userName = readStringOrSkip(reader) { position += it }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                            }
                                                            "contentOffsetSeconds" -> offsetSeconds = readIntOrSkip(reader) { position += it }
                                                            "message" -> hasMessageObject = readObjectOrSkip(reader, { position += it }) { msgField ->
                                                                when (msgField) {
                                                                    "fragments" -> readObjectArray(reader, { position += it }) {
                                                                        var emoteId: String? = null
                                                                        var fragmentText: String? = null
                                                                        readObjectOrSkip(reader, { position += it }) { fragField ->
                                                                            when (fragField) {
                                                                                "emote" -> readObjectOrSkip(reader, { position += it }) { emoteField ->
                                                                                    when (emoteField) {
                                                                                        "emoteID" -> emoteId = readStringOrSkip(reader) { position += it }
                                                                                        else -> position += skipJsonValue(reader)
                                                                                    }
                                                                                }
                                                                                "text" -> fragmentText = readStringOrSkip(reader) { position += it }
                                                                                else -> position += skipJsonValue(reader)
                                                                            }
                                                                        }
                                                                        fragmentText?.let { text ->
                                                                            val resolvedEmoteId = emoteId?.takeIf { it.isNotBlank() }
                                                                            val currentIsEmote = resolvedEmoteId != null
                                                                            if (shouldInsertFragmentSpace(message, text, currentIsEmote, previousWasEmote)) {
                                                                                message.append(' ')
                                                                            }
                                                                            if (resolvedEmoteId != null && text.isNotEmpty()) {
                                                                                val begin = message.codePointCount(0, message.length)
                                                                                emotesList.add(ChatEmote(
                                                                                    id = resolvedEmoteId,
                                                                                    begin = begin,
                                                                                    end = begin + text.codePointCount(0, text.length) - 1
                                                                                ))
                                                                            }
                                                                            message.append(text)
                                                                            previousWasEmote = currentIsEmote
                                                                        }
                                                                    }
                                                                    "userBadges" -> readObjectArray(reader, { position += it }) {
                                                                        var set: String? = null
                                                                        var version: String? = null
                                                                        readObjectOrSkip(reader, { position += it }) { badgeField ->
                                                                            when (badgeField) {
                                                                                "setID" -> set = readStringOrSkip(reader) { position += it }
                                                                                "version" -> version = readStringOrSkip(reader) { position += it }
                                                                                else -> position += skipJsonValue(reader)
                                                                            }
                                                                        }
                                                                        if (!set.isNullOrBlank() && !version.isNullOrBlank()) {
                                                                            badgesList.add(Badge(set, version))
                                                                        }
                                                                    }
                                                                    "userColor" -> color = readStringOrSkip(reader) { position += it }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                            }
                                                            else -> position += skipJsonValue(reader)
                                                        }
                                                    }
                                                    if (hasMessageObject) {
                                                        messages.add(ChatMessage(
                                                            id = id,
                                                            userId = userId,
                                                            userLogin = userLogin,
                                                            userName = userName,
                                                            message = message.toString(),
                                                            color = color,
                                                            emotes = emotesList,
                                                            badges = badgesList,
                                                            bits = 0,
                                                            timestamp = offsetSeconds?.times(1000L),
                                                            fullMsg = null
                                                        ))
                                                    }
                                                }
                                            }
                                            "chatEmotes" -> readObjectArray(reader, { position += it }) {
                                                var id: String? = null
                                                var data: Pair<Long, Int>? = null
                                                readObjectOrSkip(reader, { position += it }) { field ->
                                                    when (field) {
                                                        "data" -> data = readBase64Span(reader, position) { position += it }
                                                        "id" -> id = readStringOrSkip(reader) { position += it }
                                                        else -> position += skipJsonValue(reader)
                                                    }
                                                }
                                                if (!id.isNullOrBlank() && data != null) {
                                                    chatEmotes.add(ChatEmote(id = id, localData = data))
                                                }
                                            }
                                            "ChatBadges" -> readObjectArray(reader, { position += it }) {
                                                var setId: String? = null
                                                var version: String? = null
                                                var data: Pair<Long, Int>? = null
                                                readObjectOrSkip(reader, { position += it }) { field ->
                                                    when (field) {
                                                        "data" -> data = readBase64Span(reader, position) { position += it }
                                                        "setId" -> setId = readStringOrSkip(reader) { position += it }
                                                        "version" -> version = readStringOrSkip(reader) { position += it }
                                                        else -> position += skipJsonValue(reader)
                                                    }
                                                }
                                                if (!setId.isNullOrBlank() && !version.isNullOrBlank() && data != null) {
                                                    chatBadges.add(ChatBadge(setId = setId, version = version, localData = data))
                                                }
                                            }
                                            "cheerEmotes" -> position += skipJsonValue(reader)
                                            "emotes" -> readObjectArray(reader, { position += it }) {
                                                var data: Pair<Long, Int>? = null
                                                var name: String? = null
                                                var isOverlayEmote = false
                                                readObjectOrSkip(reader, { position += it }) { field ->
                                                    when (field) {
                                                        "data" -> data = readBase64Span(reader, position) { position += it }
                                                        "name" -> name = readStringOrSkip(reader) { position += it }
                                                        "isZeroWidth" -> {
                                                            if (reader.peek() == JsonToken.BOOLEAN) {
                                                                isOverlayEmote = reader.nextBoolean().also { position += it.toString().length }
                                                            } else {
                                                                position += skipJsonValue(reader)
                                                            }
                                                        }
                                                        else -> position += skipJsonValue(reader)
                                                    }
                                                }
                                                if (!name.isNullOrBlank() && data != null) {
                                                    emotes.add(Emote(name = name, localData = data, isOverlayEmote = isOverlayEmote))
                                                }
                                            }
                                            "startTime" -> {
                                                readIntOrSkip(reader) { position += it }?.let {
                                                    fileStartTimeFound = true
                                                    startTimeMs = it.times(1000L)
                                                }
                                            }
                                            else -> position += skipJsonValue(reader)
                                        }
                                    }
                                    else -> position += skipJsonValue(reader)
                                }
                                if (reader.peek() != JsonToken.END_OBJECT) {
                                    position += 1
                                }
                            }
                            reader.endObject().also { position += 1 }
                        }
                        else -> position += skipJsonValue(reader)
                    }
                } while (token != JsonToken.END_DOCUMENT)
            }
        } catch (_: Exception) {
            // Partial local chat files are common during interrupted downloads; keep the messages parsed so far.
        }

        val sortedMessages = messages.filter { it.timestamp != null }.sortedBy { it.timestamp }
        val hasFallbackStartTime = (fallbackStartTimeSeconds ?: 0) > 0
        if (!fileStartTimeFound && !hasFallbackStartTime && startTimeMs == 0L) {
            sortedMessages.firstOrNull()?.timestamp?.let { firstTimestamp ->
                if (firstTimestamp >= 10 * 60 * 1000L) {
                    startTimeMs = firstTimestamp
                }
            }
        }
        return OfflineChatFileResult(
            messages = sortedMessages,
            startTimeMs = startTimeMs,
            chatEmotes = chatEmotes,
            channelBadges = chatBadges,
            emotes = emotes,
        )
    }

    private inline fun readObjectArray(
        reader: JsonReader,
        advance: (Int) -> Unit,
        onObject: () -> Unit,
    ) {
        if (reader.peek() != JsonToken.BEGIN_ARRAY) {
            advance(skipJsonValue(reader))
            return
        }
        reader.beginArray()
        advance(1)
        while (reader.hasNext()) {
            if (reader.peek() != JsonToken.BEGIN_OBJECT) {
                advance(skipJsonValue(reader))
            } else {
                onObject()
            }
            if (reader.peek() != JsonToken.END_ARRAY) advance(1)
        }
        reader.endArray()
        advance(1)
    }

    private inline fun readObjectOrSkip(
        reader: JsonReader,
        advance: (Int) -> Unit,
        onField: (String) -> Unit,
    ): Boolean {
        if (reader.peek() != JsonToken.BEGIN_OBJECT) {
            advance(skipJsonValue(reader))
            return false
        }
        reader.beginObject()
        advance(1)
        while (reader.hasNext()) {
            val name = reader.nextName()
            advance(jsonEncodedStringLength(name) + 1)
            onField(name)
            if (reader.peek() != JsonToken.END_OBJECT) advance(1)
        }
        reader.endObject()
        advance(1)
        return true
    }

    private inline fun readBase64Span(
        reader: JsonReader,
        currentPosition: Long,
        advance: (Int) -> Unit,
    ): Pair<Long, Int>? {
        if (reader.peek() != JsonToken.STRING) {
            advance(skipJsonValue(reader))
            return null
        }
        val length = reader.nextString().length
        val span = Pair(currentPosition + 1, length)
        advance(length + 2)
        return span
    }

    private inline fun readStringOrSkip(reader: JsonReader, advance: (Int) -> Unit): String? {
        return if (reader.peek() == JsonToken.STRING) {
            reader.nextString().also { advance(jsonEncodedStringLength(it)) }
        } else {
            advance(skipJsonValue(reader))
            null
        }
    }

    private inline fun readIntOrSkip(reader: JsonReader, advance: (Int) -> Unit): Int? {
        return if (reader.peek() == JsonToken.NUMBER) {
            val raw = reader.nextString()
            advance(raw.length)
            raw.toIntOrNull() ?: raw.toDoubleOrNull()?.toInt()
        } else {
            advance(skipJsonValue(reader))
            null
        }
    }

    /** Encoded JSON string length including surrounding quotes as emitted by [android.util.JsonWriter]. */
    private fun jsonEncodedStringLength(value: String): Int {
        var length = value.length + 2
        for (i in 0 until value.length) {
            val c = value[i]
            length += when {
                c == '"' || c == '\\' || c == '\b' || c == '\t' || c == '\n' || c == '\r' || c == '\u000C' -> 1
                c.code < 0x20 || c == '\u2028' || c == '\u2029' -> 5
                else -> 0
            }
        }
        return length
    }

    private fun skipJsonValue(reader: JsonReader): Int {
        var length = 0
        when (reader.peek()) {
            JsonToken.BEGIN_ARRAY -> {
                reader.beginArray().also { length += 1 }
                while (reader.hasNext()) {
                    when (reader.peek()) {
                        JsonToken.NAME -> length += jsonEncodedStringLength(reader.nextName()) + 1
                        else -> {
                            length += skipJsonValue(reader)
                            if (reader.peek() != JsonToken.END_ARRAY) {
                                length += 1
                            }
                        }
                    }
                }
                reader.endArray().also { length += 1 }
            }
            JsonToken.END_ARRAY -> length += 1
            JsonToken.BEGIN_OBJECT -> {
                reader.beginObject().also { length += 1 }
                while (reader.hasNext()) {
                    when (reader.peek()) {
                        JsonToken.NAME -> length += jsonEncodedStringLength(reader.nextName()) + 1
                        else -> {
                            length += skipJsonValue(reader)
                            if (reader.peek() != JsonToken.END_OBJECT) {
                                length += 1
                            }
                        }
                    }
                }
                reader.endObject().also { length += 1 }
            }
            JsonToken.END_OBJECT -> length += 1
            JsonToken.STRING -> length += jsonEncodedStringLength(reader.nextString())
            JsonToken.NUMBER -> length += reader.nextString().length
            JsonToken.BOOLEAN -> length += reader.nextBoolean().toString().length
            JsonToken.NULL -> {
                reader.nextNull()
                length += 4
            }
            else -> reader.skipValue()
        }
        return length
    }

    private fun shouldInsertFragmentSpace(
        builder: StringBuilder,
        fragmentText: String,
        currentIsEmote: Boolean,
        previousWasEmote: Boolean,
    ): Boolean {
        if (builder.isEmpty() || fragmentText.isEmpty()) return false
        val previousChar = builder.last()
        val nextChar = fragmentText.first()
        if (previousChar.isWhitespace() || nextChar.isWhitespace()) return false
        if (!(previousWasEmote || currentIsEmote)) return false
        if (previousChar in "([{" || nextChar in ".,!?;:)]}") return false
        return true
    }
}
