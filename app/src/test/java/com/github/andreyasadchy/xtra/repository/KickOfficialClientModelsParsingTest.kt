package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickOfficialChannelSubscriptionGiftsEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChatMessageSentEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialChannel
import com.github.andreyasadchy.xtra.model.kick.KickOfficialCategory
import com.github.andreyasadchy.xtra.model.kick.KickOfficialKicksGiftedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialLivestream
import com.github.andreyasadchy.xtra.model.kick.KickOfficialModerationBannedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardRedemptionUpdatedEvent
import com.github.andreyasadchy.xtra.model.kick.KickOfficialUser
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class KickOfficialClientModelsParsingTest {
    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun parsesOfficialUserWithChannelSlug() {
        val parsed = json.decodeFromString<KickOfficialUser>(
            """
            {
              "user_id": 42,
              "name": "viewer_name",
              "channel_slug": "viewer_login",
              "profile_picture": "https://example.com/avatar.jpg"
            }
            """.trimIndent()
        )

        assertEquals(42L, parsed.userId)
        assertEquals("viewer_name", parsed.name)
        assertEquals("viewer_login", parsed.channelSlug)
        assertEquals("https://example.com/avatar.jpg", parsed.profilePicture)
    }

    @Test
    fun parsesOfficialChatMessageSentEvent() {
        val parsed = json.decodeFromString<KickOfficialChatMessageSentEvent>(
            """
            {
              "message_id": "msg-1",
              "replies_to": {
                "message_id": "msg-0",
                "content": "parent",
                "sender": {
                  "user_id": 1,
                  "username": "parent_sender",
                  "channel_slug": "parent_sender"
                }
              },
              "broadcaster": {
                "user_id": 2,
                "username": "broadcaster",
                "channel_slug": "broadcaster"
              },
              "sender": {
                "user_id": 3,
                "username": "sender",
                "channel_slug": "sender",
                "identity": {
                  "username_color": "#12AB34",
                  "badges": [
                    { "text": "Moderator", "type": "moderator" }
                  ]
                }
              },
              "content": "hello chat",
              "created_at": "2025-01-14T16:08:06Z"
            }
            """.trimIndent()
        )

        assertEquals("msg-1", parsed.messageId)
        assertEquals("msg-0", parsed.repliesTo?.messageId)
        assertEquals("hello chat", parsed.content)
        assertEquals("sender", parsed.sender?.channelSlug)
        assertEquals("#12AB34", parsed.sender?.identity?.usernameColor)
        assertEquals("moderator", parsed.sender?.identity?.badges?.firstOrNull()?.type)
    }

    @Test
    fun parsesOfficialModerationBannedEvent() {
        val parsed = json.decodeFromString<KickOfficialModerationBannedEvent>(
            """
            {
              "broadcaster": {
                "user_id": 10,
                "username": "broadcaster",
                "channel_slug": "broadcaster"
              },
              "moderator": {
                "user_id": 11,
                "username": "mod",
                "channel_slug": "mod"
              },
              "banned_user": {
                "user_id": 12,
                "username": "bad_actor",
                "channel_slug": "bad_actor"
              },
              "metadata": {
                "reason": "spam",
                "created_at": "2025-01-14T16:08:05Z",
                "expires_at": "2025-01-14T16:10:05Z"
              }
            }
            """.trimIndent()
        )

        assertEquals(11L, parsed.moderator?.userId)
        assertEquals("bad_actor", parsed.bannedUser?.channelSlug)
        assertEquals("spam", parsed.metadata?.reason)
        assertEquals("2025-01-14T16:10:05Z", parsed.metadata?.expiresAt)
    }

    @Test
    fun parsesOfficialSubscriptionGiftAndRewardEvents() {
        val giftEvent = json.decodeFromString<KickOfficialChannelSubscriptionGiftsEvent>(
            """
            {
              "broadcaster": {
                "user_id": 20,
                "username": "broadcaster",
                "channel_slug": "broadcaster"
              },
              "gifter": {
                "user_id": 21,
                "username": "gifter",
                "channel_slug": "gifter"
              },
              "giftees": [
                {
                  "user_id": 22,
                  "username": "giftee",
                  "channel_slug": "giftee"
                }
              ],
              "created_at": "2025-01-14T16:08:06Z"
            }
            """.trimIndent()
        )
        val rewardEvent = json.decodeFromString<KickOfficialRewardRedemptionUpdatedEvent>(
            """
            {
              "broadcaster": {
                "user_id": 20,
                "username": "broadcaster",
                "channel_slug": "broadcaster"
              },
              "redeemer": {
                "user_id": 23,
                "username": "viewer",
                "channel_slug": "viewer"
              },
              "reward": {
                "id": "reward-1",
                "title": "Highlight Message",
                "cost": 250
              },
              "redemption": {
                "id": "redeem-1",
                "status": "accepted",
                "redeemed_at": "2025-01-14T16:09:06Z"
              }
            }
            """.trimIndent()
        )

        assertEquals("gifter", giftEvent.gifter?.channelSlug)
        assertEquals(1, giftEvent.giftees.size)
        assertEquals("giftee", giftEvent.giftees.first().channelSlug)
        assertEquals("Highlight Message", rewardEvent.reward?.title)
        assertEquals("accepted", rewardEvent.redemption?.status)
    }

    @Test
    fun parsesOfficialKicksGiftedEvent() {
        val parsed = json.decodeFromString<KickOfficialKicksGiftedEvent>(
            """
            {
              "broadcaster": {
                "user_id": 20,
                "username": "broadcaster",
                "channel_slug": "broadcaster"
              },
              "sender": {
                "user_id": 30,
                "username": "gifter",
                "channel_slug": "gifter"
              },
              "recipient": {
                "user_id": 31,
                "username": "recipient",
                "channel_slug": "recipient"
              },
              "gifted_amount": 500,
              "pinned_time_seconds": 120,
              "created_at": "2025-01-14T16:10:06Z"
            }
            """.trimIndent()
        )

        assertEquals(500L, parsed.giftedAmount)
        assertEquals(120, parsed.pinnedTimeSeconds)
        assertEquals("gifter", parsed.sender?.channelSlug)
        assertEquals("recipient", parsed.recipient?.channelSlug)
        assertNotNull(parsed.createdAt)
        assertNull(parsed.amount)
    }

    @Test
    fun parsesOfficialChannelLivestreamAndCategoryExtensions() {
        val category = json.decodeFromString<KickOfficialCategory>(
            """
            {
              "id": 12,
              "name": "Gaming",
              "thumbnail": "https://example.com/game.jpg",
              "tags": ["fps", "ranked"],
              "viewer_count": 4200
            }
            """.trimIndent()
        )
        val channel = json.decodeFromString<KickOfficialChannel>(
            """
            {
              "broadcaster_user_id": 55,
              "slug": "streamer",
              "stream_title": "Road to Radiant",
              "thumbnail": "https://example.com/thumb.jpg",
              "custom_tags": ["english", "competitive"]
            }
            """.trimIndent()
        )
        val livestream = json.decodeFromString<KickOfficialLivestream>(
            """
            {
              "broadcaster_user_id": 55,
              "channel_id": 99,
              "slug": "streamer",
              "stream_title": "Road to Radiant",
              "viewer_count": 1337,
              "custom_tags": ["english", "competitive"]
            }
            """.trimIndent()
        )

        assertEquals(listOf("fps", "ranked"), category.tags)
        assertEquals(4200, category.viewerCount)
        assertEquals("https://example.com/thumb.jpg", channel.thumbnail)
        assertEquals(listOf("english", "competitive"), channel.customTags)
        assertEquals(listOf("english", "competitive"), livestream.customTags)
    }
}
