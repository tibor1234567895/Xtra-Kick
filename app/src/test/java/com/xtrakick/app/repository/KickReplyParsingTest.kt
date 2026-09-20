package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickMessage
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickReplyParsingTest {

    private val json = Json { ignoreUnknownKeys = true }
    private lateinit var kickRepository: KickRepository

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        val okHttpClient = OkHttpClient()
        val executor = Executors.newSingleThreadExecutor()
        val authRepository = AuthRepository(
            httpEngine = null,
            cronetEngine = null,
            cronetExecutor = executor,
            okHttpClient = okHttpClient,
            json = json,
        )
        val kickOfficialApiClient = KickOfficialApiClient(
            context = context,
            okHttpClient = okHttpClient,
            json = json,
        )
        kickRepository = KickRepository(
            context = context,
            okHttpClient = okHttpClient,
            cronetEngine = null,
            cronetExecutor = executor,
            json = json,
            authRepository = authRepository,
            kickOfficialApiClient = kickOfficialApiClient,
        )
    }

    @Test
    fun parsesLiveChatMessageEventReplyWithOriginalSenderAndOriginalMessage() {
        val rawJson = """
            {
              "id": "reply-msg-101",
              "content": "me next",
              "metadata": {
                "original_sender": {
                  "id": 12345,
                  "username": "PurpleW0lf"
                },
                "original_message": {
                  "id": "parent-msg-202",
                  "content": "going to need a storage unit"
                }
              }
            }
        """.trimIndent()

        val kickMessage = json.decodeFromString<KickMessage>(rawJson)
        val chatMessage = kickRepository.toChatMessage(kickMessage)

        val reply = chatMessage.reply
        assertNotNull(reply)
        assertEquals("parent-msg-202", reply?.threadParentId)
        assertEquals("PurpleW0lf", reply?.userName)
        assertEquals("purplew0lf", reply?.userLogin)
        assertEquals("going to need a storage unit", reply?.message)
    }

    @Test
    fun parsesReplyWithKickNativeEmoteWithoutNumericIdBug() {
        val rawJson = """
            {
              "id": "reply-msg-102",
              "content": "pretty sure he is the reason",
              "metadata": {
                "original_sender": {
                  "id": 67890,
                  "username": "ThugWaffle"
                },
                "original_message": {
                  "id": "parent-msg-303",
                  "content": "[emote:5747985:pepeLaugh]"
                }
              }
            }
        """.trimIndent()

        val kickMessage = json.decodeFromString<KickMessage>(rawJson)
        val chatMessage = kickRepository.toChatMessage(kickMessage)

        val reply = chatMessage.reply
        assertNotNull(reply)
        assertEquals("ThugWaffle", reply?.userName)
        assertEquals("pepeLaugh", reply?.message)
        assertEquals(1, reply?.emotes?.size)
        assertEquals("5747985", reply?.emotes?.first()?.id)
        assertEquals("pepeLaugh", reply?.emotes?.first()?.name)
    }

    @Test
    fun parsesMixedTextAndKickNativeEmotesInReply() {
        val rawJson = """
            {
              "id": "reply-msg-103",
              "content": "response",
              "metadata": {
                "original_sender": {
                  "id": 111,
                  "username": "Gamer123"
                },
                "original_message": {
                  "id": "parent-msg-404",
                  "content": "wtf [emote:5747985:pepeLaugh] they wiped everyone?"
                }
              }
            }
        """.trimIndent()

        val kickMessage = json.decodeFromString<KickMessage>(rawJson)
        val chatMessage = kickRepository.toChatMessage(kickMessage)

        val reply = chatMessage.reply
        assertNotNull(reply)
        assertEquals("Gamer123", reply?.userName)
        assertEquals("wtf pepeLaugh they wiped everyone?", reply?.message)
        assertEquals(1, reply?.emotes?.size)
        assertEquals("5747985", reply?.emotes?.first()?.id)
        assertEquals("pepeLaugh", reply?.emotes?.first()?.name)
    }

    @Test
    fun parsesMultipleKickNativeEmotesWithAccurateOffsets() {
        val rawJson = """
            {
              "id": "reply-msg-104",
              "content": "lol",
              "metadata": {
                "original_sender": {
                  "username": "CoolGuy"
                },
                "original_message": {
                  "id": "parent-msg-505",
                  "content": "Hey [emote:111:wave] check this [emote:222:clap] out"
                }
              }
            }
        """.trimIndent()

        val kickMessage = json.decodeFromString<KickMessage>(rawJson)
        val chatMessage = kickRepository.toChatMessage(kickMessage)

        val reply = chatMessage.reply
        assertNotNull(reply)
        assertEquals("Hey wave check this clap out", reply?.message)
        assertEquals(2, reply?.emotes?.size)

        val firstEmote = reply?.emotes?.get(0)
        assertEquals("111", firstEmote?.id)
        assertEquals("wave", firstEmote?.name)
        assertEquals(4, firstEmote?.begin) // "Hey " is length 4
        assertEquals(7, firstEmote?.end)   // 4 + 4 - 1 = 7

        val secondEmote = reply?.emotes?.get(1)
        assertEquals("222", secondEmote?.id)
        assertEquals("clap", secondEmote?.name)
        assertEquals(20, secondEmote?.begin) // "Hey wave check this " is length 20
        assertEquals(23, secondEmote?.end)   // 20 + 4 - 1 = 23
    }

    @Test
    fun parsesPlainTextMessageWithoutAllocatingEmotes() {
        val rawJson = """
            {
              "id": "msg-105",
              "content": "just a regular message without any emotes"
            }
        """.trimIndent()

        val kickMessage = json.decodeFromString<KickMessage>(rawJson)
        val chatMessage = kickRepository.toChatMessage(kickMessage)

        assertEquals("just a regular message without any emotes", chatMessage.message)
        org.junit.Assert.assertNull(chatMessage.emotes)
    }

    @Test
    fun parsesReplyWithoutSenderGracefully() {
        val rawJson = """
            {
              "id": "reply-msg-106",
              "content": "mystery reply",
              "metadata": {
                "original_message": {
                  "id": "parent-msg-606",
                  "content": "some old message"
                }
              }
            }
        """.trimIndent()

        val kickMessage = json.decodeFromString<KickMessage>(rawJson)
        val chatMessage = kickRepository.toChatMessage(kickMessage)

        val reply = chatMessage.reply
        assertNotNull(reply)
        assertEquals("parent-msg-606", reply?.threadParentId)
        org.junit.Assert.assertNull(reply?.userName)
        org.junit.Assert.assertNull(reply?.userLogin)
        assertEquals("some old message", reply?.message)
    }
}

