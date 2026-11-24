package com.xtrakick.app.ui.chat

import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.KickOfficialApiClient
import com.xtrakick.app.repository.KickRepository
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.io.StringReader
import java.time.Instant
import java.util.concurrent.Executors

@RunWith(RobolectricTestRunner::class)
class OfflineChatFileReaderTest {

    private val context = RuntimeEnvironment.getApplication()
    private val executor = Executors.newSingleThreadExecutor()
    private val client = OkHttpClient.Builder().addInterceptor { error("Unexpected network request") }.build()
    private val json = Json { ignoreUnknownKeys = true }
    private val kickRepository = KickRepository(
        context,
        client,
        null,
        executor,
        json,
        AuthRepository(null, null, executor, client, json),
        KickOfficialApiClient(context, client, json),
    )

    @After
    fun tearDown() {
        executor.shutdownNow()
    }

    @Test
    fun readFromReaderSkipsLegacyCheerEmotesAndParsesComments() {
        val payload = """
            {
              "startTime": 120,
              "cheerEmotes": [
                {"data": "AAAA", "name": "Cheer", "minBits": 1, "color": "#979797"}
              ],
              "comments": [
                {
                  "id": "m1",
                  "commenter": {"id": "10", "login": "alice", "displayName": "Alice"},
                  "contentOffsetSeconds": 15,
                  "message": {
                    "fragments": [{"text": "hello world"}],
                    "userBadges": [{"setID": "subscriber", "version": "1"}],
                    "userColor": "#FF0000"
                  }
                }
              ],
              "emotes": [
                {"data": "BBBB", "name": "KEKW", "isZeroWidth": false}
              ]
            }
        """.trimIndent()

        val result = OfflineChatFileReader.readFromReader(
            context = context,
            kickRepository = kickRepository,
            fileReader = StringReader(payload),
            nameDisplay = "1",
            buildReplyPreview = { _, _ -> null },
            createDeletedMessage = { it },
            createClearMessage = { msg, _, _ -> msg },
        )

        assertEquals(120_000L, result.startTimeMs)
        assertEquals(1, result.messages.size)
        assertEquals("hello world", result.messages[0].message)
        assertEquals("Alice", result.messages[0].userName)
        assertEquals(15_000L, result.messages[0].timestamp)
        assertEquals(1, result.emotes.size)
        assertEquals("KEKW", result.emotes[0].name)
    }

    @Test
    fun readFromReaderIsolatesMalformedLiveCommentLines() {
        val validIrc = "@badge-info=;badges=;color=#1E90FF;display-name=Bob;id=id1;tmi-sent-ts=1000;user-id=42 :bob!bob@bob.tmi.twitch.tv PRIVMSG #chan :good line"
        val payload = """
            {
              "liveComments": [
                "{not valid json",
                null,
                {"unexpected": true},
                42,
                "BROKEN PRIVMSG WITHOUT STRUCTURE",
                "$validIrc"
              ]
            }
        """.trimIndent()

        val result = OfflineChatFileReader.readFromReader(
            context = context,
            kickRepository = kickRepository,
            fileReader = StringReader(payload),
            nameDisplay = "1",
            buildReplyPreview = { _, _ -> null },
            createDeletedMessage = { it },
            createClearMessage = { msg, _, _ -> msg },
        )

        assertTrue(result.messages.any { it.message == "good line" })
    }

    @Test
    fun kickRecordingKeepsMessagesOnTheTimelineUsedByTheReplayManager() {
        val start = Instant.parse("2026-11-02T10:00:00Z")
        fun envelope(id: String, offset: Long, legacy: Boolean = false) = JSONObject()
            .put("kickEvent", if (legacy) "App\\Events\\ChatMessageEvent" else "chat.message.sent")
            .put("kickData", JSONObject()
                .put(if (legacy) "id" else "message_id", id)
                .put("content", id)
                .put("created_at", start.plusSeconds(offset).toString())
                .put("sender", JSONObject().put(if (legacy) "id" else "user_id", 42).put("username", "tester"))
                .toString())
            .toString()
        val payload = JSONObject()
            .put("liveStartTime", start.toString())
            .put("liveComments", JSONArray().put(envelope("first", 1)).put(JSONObject.NULL).put(envelope("second", 4, legacy = true)))
            .toString()
        val result = OfflineChatFileReader.readFromReader(
            context = context,
            kickRepository = kickRepository,
            fileReader = StringReader(payload),
            nameDisplay = "1",
            buildReplyPreview = { _, _ -> null },
            createDeletedMessage = { it },
            createClearMessage = { msg, _, _ -> msg },
        )

        assertEquals(start.toEpochMilli(), result.startTimeMs)
        assertEquals(listOf("first", "second"), result.messages.map { it.message })
        assertEquals(0, ChatReplayManagerLocal.messageUpperBound(result.messages, result.startTimeMs))
        assertEquals(1, ChatReplayManagerLocal.messageUpperBound(result.messages, result.startTimeMs + 2_000L))
        assertEquals(2, ChatReplayManagerLocal.messageUpperBound(result.messages, result.startTimeMs + 5_000L))
    }

    @Test
    fun readFromReaderAlignsEmoteSpanAfterAutoInsertedSpaceAndTracksNullOffsets() {
        val compact = "{\"cheerEmotes\":[{\"a\":null}],\"comments\":[{\"id\":\"m2\",\"commenter\":{\"id\":\"1\",\"login\":\"a\",\"displayName\":\"A\"},\"contentOffsetSeconds\":5,\"message\":{\"fragments\":[{\"text\":\"hi\"},{\"text\":\"KEKW\",\"emote\":{\"emoteID\":\"e1\"}}],\"userColor\":null}}],\"emotes\":[{\"data\":\"BBBB\",\"name\":\"KEKW\",\"isZeroWidth\":false}]}"

        val result = OfflineChatFileReader.readFromReader(
            context = context,
            kickRepository = kickRepository,
            fileReader = StringReader(compact),
            nameDisplay = "1",
            buildReplyPreview = { _, _ -> null },
            createDeletedMessage = { it },
            createClearMessage = { msg, _, _ -> msg },
        )

        assertEquals(1, result.messages.size)
        assertEquals("hi KEKW", result.messages[0].message)
        val emote = result.messages[0].emotes!!.single()
        assertEquals("e1", emote.id)
        assertEquals(3, emote.begin)
        assertEquals(6, emote.end)

        val localData = result.emotes.single().localData!!
        val expectedOffset = compact.indexOf("BBBB").toLong()
        assertEquals(expectedOffset, localData.first)
        assertEquals(4, localData.second)
    }

    @Test
    fun readFromReaderHandlesNullCommenterAndEscapedControlCharsInMetadata() {
        val compact = """{"video":{"title":"Line1\nLine2\tTabbed\rEnd"},"comments":[{"id":"m1","commenter":null,"contentOffsetSeconds":10,"message":{"fragments":[{"text":"deleted user"}],"userBadges":null,"userColor":null}},{"id":"m2","commenter":{"id":null,"login":"bob","displayName":null},"contentOffsetSeconds":20,"message":{"fragments":[{"text":"still parsed"}]}}],"emotes":[{"data":"CCCC","name":"LUL","isZeroWidth":false}]}"""

        val result = OfflineChatFileReader.readFromReader(
            context = context,
            kickRepository = kickRepository,
            fileReader = StringReader(compact),
            nameDisplay = "1",
            buildReplyPreview = { _, _ -> null },
            createDeletedMessage = { it },
            createClearMessage = { msg, _, _ -> msg },
        )

        assertEquals(listOf("deleted user", "still parsed"), result.messages.map { it.message })
        assertEquals("bob", result.messages[1].userLogin)
        val localData = result.emotes.single().localData!!
        assertEquals(compact.indexOf("CCCC").toLong(), localData.first)
        assertEquals(4, localData.second)
    }
}
