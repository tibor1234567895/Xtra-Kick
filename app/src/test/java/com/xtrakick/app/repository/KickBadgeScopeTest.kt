package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickChannelBadge
import com.xtrakick.app.model.kick.KickChannelResponse
import com.xtrakick.app.model.kick.KickChatroom
import com.xtrakick.app.model.kick.KickMessage
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickBadgeScopeTest {

    @Test
    fun overlappingNumericIdentifiersDoNotOverwriteAnotherChatroom() {
        fun channel(id: Long, room: Long, user: Long, slug: String, image: String) =
            KickChannelResponse(id = id, userId = user, slug = slug,
                chatroom = KickChatroom(id = room, subscriberBadges = listOf(
                    KickChannelBadge(type = "subscriber", months = 1, badgeImageUrl = image))))
        kickRepository.cacheKickBadgeUrls(channel(10, 20, 30, "a", "https://example.com/a.png"))
        kickRepository.cacheKickBadgeUrls(channel(20, 10, 20, "20", "https://example.com/b.png"))
        assertEquals("https://example.com/a.png", kickRepository.resolveKickBadgeUrl("subscriber", "1", "20"))
        for (scope in listOf("chatroom:10", "channel:20", "user:20", "login:20")) {
            assertEquals("https://example.com/b.png", kickRepository.resolveKickBadgeUrl("subscriber", "1", scope))
        }
    }

    @Test
    fun accountCreationUsesTheUserTimestampAndNeverTheChatroomTimestamp() {
        val channel = json.decodeFromString<KickChannelResponse>(
            """{"slug":"a","chatroom":{"id":20,"created_at":"2025-01-01T00:00:00Z"},"user":{"id":30,"created_at":"2023-01-01T00:00:00Z"}}""")
        assertEquals("2023-01-01T00:00:00Z", kickRepository.toUser(channel).createdAt)
        val missingUserDate = json.decodeFromString<KickChannelResponse>(
            """{"chatroom":{"created_at":"2025-01-01T00:00:00Z"},"user":{"id":30}}""")
        assertNull(kickRepository.toUser(missingUserDate).createdAt)
    }

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
    fun `channel subscriber badges are cached under all channel scope identifiers`() {
        val channel = KickChannelResponse(
            id = 2587387L,
            userId = 2642629L,
            slug = "4head",
            chatroom = KickChatroom(
                id = 2579856L,
                subscriberBadges = listOf(
                    KickChannelBadge(
                        type = "subscriber",
                        months = 1,
                        badgeImageUrl = "https://files.kick.com/channel_subscriber_badges/323960/conversion/original-fullsize.png",
                    ),
                    KickChannelBadge(
                        type = "subscriber",
                        months = 2,
                        badgeImageUrl = "https://files.kick.com/channel_subscriber_badges/323961/conversion/original-fullsize.png",
                    ),
                ),
            ),
        )

        kickRepository.cacheKickBadgeUrls(channel)

        // Resolves by chatroom ID
        val urlByChatroom = kickRepository.resolveKickBadgeUrl("subscriber", "1", "2579856")
        assertEquals("https://files.kick.com/channel_subscriber_badges/323960/conversion/original-fullsize.png", urlByChatroom)

        // Resolves by channel ID
        val urlByChannel = kickRepository.resolveKickBadgeUrl("subscriber", "1", "channel:2587387")
        assertEquals("https://files.kick.com/channel_subscriber_badges/323960/conversion/original-fullsize.png", urlByChannel)

        // Resolves by channel slug (case-insensitive)
        val urlBySlug = kickRepository.resolveKickBadgeUrl("subscriber", "1", "4Head")
        assertEquals("https://files.kick.com/channel_subscriber_badges/323960/conversion/original-fullsize.png", urlBySlug)

        // Resolves by user ID
        val urlByUserId = kickRepository.resolveKickBadgeUrl("subscriber", "1", "user:2642629")
        assertEquals("https://files.kick.com/channel_subscriber_badges/323960/conversion/original-fullsize.png", urlByUserId)

        // Does NOT resolve under an unrelated channel scope
        val unrelatedUrl = kickRepository.resolveKickBadgeUrl("subscriber", "1", "9999999")
        assertNull(unrelatedUrl)
    }

    @Test
    fun `toChatMessage uses its message chatroom after another channel is cached`() {
        // Channel A (4head) has custom clown badge
        val channelA = KickChannelResponse(
            id = 2587387L,
            slug = "4head",
            chatroom = KickChatroom(
                id = 2579856L,
                subscriberBadges = listOf(
                    KickChannelBadge(
                        type = "subscriber",
                        months = 1,
                        badgeImageUrl = "https://files.kick.com/badges/4head_1m_clown.png",
                    ),
                ),
            ),
        )
        // Channel B (another streamer in MultiPOV) has Roman numeral badge
        val channelB = KickChannelResponse(
            id = 888888L,
            slug = "otherstreamer",
            chatroom = KickChatroom(
                id = 999999L,
                subscriberBadges = listOf(
                    KickChannelBadge(
                        type = "subscriber",
                        months = 1,
                        badgeImageUrl = "https://files.kick.com/badges/other_roman_ii.png",
                    ),
                ),
            ),
        )

        kickRepository.cacheKickBadgeUrls(channelA)
        kickRepository.cacheKickBadgeUrls(channelB)

        val messageJson = """
            {
              "id": "msg-1234",
              "chatroom_id": 2579856,
              "content": "RP session",
              "sender": {
                "id": 111,
                "username": "g4sandhu",
                "identity": {
                  "badges": [
                    { "type": "subscriber", "count": 1 }
                  ]
                }
              }
            }
        """.trimIndent()
        val message = json.decodeFromString<KickMessage>(messageJson)

        // Call toChatMessage with Channel A message
        val chatMessage = kickRepository.toChatMessage(message)

        val subBadge = chatMessage.badges?.find { it.setId == "kick:subscriber" }
        assertNotNull(subBadge)
        // Must resolve 4head's badge, NOT otherstreamer's badge!
        assertEquals("https://files.kick.com/badges/4head_1m_clown.png", subBadge?.url1x)
    }

    @Test
    fun `toChatMessage honors explicit chatScopeId passed from caller`() {
        val channelA = KickChannelResponse(
            id = 2587387L,
            slug = "4head",
            chatroom = KickChatroom(
                id = 2579856L,
                subscriberBadges = listOf(
                    KickChannelBadge(
                        type = "subscriber",
                        months = 2,
                        badgeImageUrl = "https://files.kick.com/badges/4head_2m_clown.png",
                    ),
                ),
            ),
        )
        kickRepository.cacheKickBadgeUrls(channelA)

        // Message without explicit chatroom_id in body
        val message = json.decodeFromString<KickMessage>(
            """
            {
              "id": "msg-5678",
              "content": "clown check",
              "sender": {
                "id": 222,
                "username": "daviep01",
                "identity": {
                  "badges": [
                    { "type": "subscriber", "count": 2 }
                  ]
                }
              }
            }
            """.trimIndent()
        )

        // ChatViewModel passes its own channel scope ("4head")
        val chatMessage = kickRepository.toChatMessage(message, chatScopeId = "4head")

        val subBadge = chatMessage.badges?.find { it.setId == "kick:subscriber" }
        assertNotNull(subBadge)
        assertEquals("https://files.kick.com/badges/4head_2m_clown.png", subBadge?.url1x)
    }
}
