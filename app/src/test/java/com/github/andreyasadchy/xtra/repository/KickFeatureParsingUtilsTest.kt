package com.github.andreyasadchy.xtra.repository

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KickFeatureParsingUtilsTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun `parse pinned gift update extracts pinned gift payload`() {
        val update = KickFeatureParsingUtils.parsePinnedGiftUpdate(
            "App\\Events\\ChatMessagePinned",
            """
            {
              "message_id": "pin-1",
              "content": "hello from chat",
              "pinned_time_seconds": 60,
              "gifted_kicks": 3,
              "gift_value": 120,
              "sender": {
                "id": "42",
                "slug": "viewer_login",
                "username": "ViewerName",
                "profile_picture": "https://example.com/avatar.png"
              }
            }
            """.trimIndent()
        )

        assertNotNull(update)
        assertFalse(update!!.cleared)
        assertEquals("pin-1", update.pinnedGift?.id)
        assertEquals("hello from chat", update.pinnedGift?.message)
        assertEquals(60, update.pinnedGift?.pinnedSeconds)
        assertEquals(3, update.pinnedGift?.giftCount)
        assertEquals(120, update.pinnedGift?.giftValue)
        assertEquals("viewer_login", update.pinnedGift?.userLogin)
        assertEquals("ViewerName", update.pinnedGift?.userName)
    }

    @Test
    fun `parse pinned gift update recognizes pinned gift deletion`() {
        val update = KickFeatureParsingUtils.parsePinnedGiftUpdate(
            "App\\Events\\PinnedMessageDeleted",
            """
            {
              "pinned_message_id": "pin-1",
              "deleted": true
            }
            """.trimIndent()
        )

        assertNotNull(update)
        assertTrue(update!!.cleared)
        assertNull(update.pinnedGift)
    }

    @Test
    fun `parse pinned gift update extracts nested pinned message payload`() {
        val update = KickFeatureParsingUtils.parsePinnedGiftUpdate(
            "App\\Events\\PinnedMessageCreated",
            """
            {
              "duration": 45,
              "pinnedBy": {
                "id": "999",
                "username": "HolySkittles",
                "slug": "holyskittles"
              },
              "message": {
                "id": "pin-2",
                "content": "https://kick.com/example",
                "profile_picture": "https://example.com/avatar.png"
              }
            }
            """.trimIndent()
        )

        assertNotNull(update)
        assertFalse(update!!.cleared)
        assertEquals("pin-2", update.pinnedGift?.id)
        assertEquals("https://kick.com/example", update.pinnedGift?.message)
        assertEquals(45, update.pinnedGift?.pinnedSeconds)
        assertEquals("holyskittles", update.pinnedGift?.userLogin)
        assertEquals("HolySkittles", update.pinnedGift?.userName)
    }

    @Test
    fun `parse pinned gift update clears initial state when pinned message is null`() {
        val update = KickFeatureParsingUtils.parsePinnedGiftUpdate(
            "initial_state",
            """
            {
              "data": {
                "messages": [
                  {
                    "id": "6838ae8e-1821-4127-b149-1318c3c0b359",
                    "chat_id": 114586,
                    "user_id": 8392354,
                    "content": "yes. i blaim you",
                    "type": "message",
                    "sender": {
                      "id": 8392354,
                      "slug": "nebeloo",
                      "username": "Nebeloo"
                    }
                  }
                ],
                "pinned_message": null
              },
              "message": "success"
            }
            """.trimIndent()
        )

        assertNotNull(update)
        assertTrue(update!!.cleared)
        assertNull(update.pinnedGift)
    }

    @Test
    fun `parse pinned gift update ignores unrelated chat event`() {
        val update = KickFeatureParsingUtils.parsePinnedGiftUpdate(
            "App\\Events\\MessageSent",
            """
            {
              "message_id": "chat-1",
              "content": "plain chat message"
            }
            """.trimIndent()
        )

        assertNull(update)
    }

    @Test
    fun `parse channel point rewards response extracts rewards`() {
        val result = KickFeatureParsingUtils.parseChannelPointRewardsResponse(
            """
            {
              "data": {
                "rewards": [
                  {
                    "id": "reward-1",
                    "title": "Timeout",
                    "cost": 500,
                    "is_enabled": true,
                    "is_user_input_required": true,
                    "background_color": "#00FF00",
                    "image": {
                      "url": "https://example.com/reward.png"
                    }
                  }
                ]
              }
            }
            """.trimIndent(),
            json
        )

        assertTrue(result.available)
        assertEquals(1, result.rewards.size)
        assertEquals("reward-1", result.rewards.first().id)
        assertEquals("Timeout", result.rewards.first().title)
        assertEquals(500, result.rewards.first().cost)
        assertEquals(true, result.rewards.first().isEnabled)
        assertEquals(true, result.rewards.first().isUserInputRequired)
        assertEquals("https://example.com/reward.png", result.rewards.first().url1x)
    }

    @Test
    fun `parse channel point rewards response handles unsupported payload`() {
        val result = KickFeatureParsingUtils.parseChannelPointRewardsResponse(
            """{"status":"ok"}""",
            json
        )

        assertFalse(result.available)
        assertTrue(result.rewards.isEmpty())
    }
}
