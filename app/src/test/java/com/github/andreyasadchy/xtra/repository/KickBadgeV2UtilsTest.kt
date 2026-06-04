package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickMessage
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickBadgeV2UtilsTest {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Test
    fun `history badge v2 selected level is included with metadata level version`() {
        val message = json.decodeFromString<KickMessage>(
            """
            {
              "id": "5cd16e0f-02ad-4df2-81da-e39428a9da12",
              "chat_id": 5215100,
              "sender": {
                "id": 584800,
                "identity": {
                  "badges": [
                    { "type": "moderator", "text": "Moderator", "sort_order": 4 }
                  ],
                  "badges_v2": [
                    {
                      "name": "level",
                      "badge_type": "global",
                      "image_url": "https://ext.cdn.kick.com/chat/badges/12_68faed31.png",
                      "selected": true,
                      "metadata": { "level": 12 },
                      "sort_order": 1
                    }
                  ]
                }
              }
            }
            """.trimIndent()
        )

        val badges = selectedKickIdentityBadges(message.sender?.identity)

        assertEquals(2, badges.size)
        assertEquals("moderator", badges[0].type)
        assertEquals("level", badges[1].name)
        assertEquals("level", kickMessageBadgeType(badges[1]))
        assertEquals("global", badges[1].badgeType)
        assertEquals("https://ext.cdn.kick.com/chat/badges/12_68faed31.png", badges[1].imageUrl)
        assertEquals("12", kickMessageBadgeVersion(badges[1]))
    }

    @Test
    fun `pusher badge v2 selected level preserves legacy subscriber badge`() {
        val message = json.decodeFromString<KickMessage>(
            """
            {
              "id": "d04dd13d-fc55-44f0-bf9f-261d586fe851",
              "chatroom_id": 5192108,
              "sender": {
                "id": 119829,
                "identity": {
                  "badges": [
                    { "type": "subscriber", "text": "Subscriber", "count": 1, "sort_order": 9 }
                  ],
                  "badges_v2": [
                    {
                      "name": "level",
                      "badge_type": "global",
                      "image_url": "https://ext.cdn.kick.com/chat/badges/16_d3bd37f4.png",
                      "metadata": { "level": 16 },
                      "selected": true,
                      "sort_order": 1
                    }
                  ]
                }
              }
            }
            """.trimIndent()
        )

        val badges = selectedKickIdentityBadges(message.sender?.identity)

        assertEquals(2, badges.size)
        assertEquals("subscriber", badges[0].type)
        assertEquals(1, badges[0].count)
        assertEquals("level", badges[1].name)
        assertEquals("level", kickMessageBadgeType(badges[1]))
        assertEquals("16", kickMessageBadgeVersion(badges[1]))
    }

    @Test
    fun `badge v2 unselected and missing selected entries are ignored`() {
        val message = json.decodeFromString<KickMessage>(
            """
            {
              "sender": {
                "identity": {
                  "badges_v2": [
                    {
                      "name": "level",
                      "image_url": "https://ext.cdn.kick.com/chat/badges/12.png",
                      "selected": false,
                      "metadata": { "level": 12 }
                    },
                    {
                      "name": "level",
                      "image_url": "https://ext.cdn.kick.com/chat/badges/16.png",
                      "metadata": { "level": 16 }
                    }
                  ]
                }
              }
            }
            """.trimIndent()
        )

        val badges = selectedKickIdentityBadges(message.sender?.identity)

        assertEquals(0, badges.size)
    }

    @Test
    fun `metadata level is ignored when top level level exists`() {
        val message = json.decodeFromString<KickMessage>(
            """
            {
              "sender": {
                "identity": {
                  "badges_v2": [
                    {
                      "name": "level",
                      "level": 20,
                      "selected": true,
                      "metadata": { "level": 21 }
                    }
                  ]
                }
              }
            }
            """.trimIndent()
        )

        val badge = selectedKickIdentityBadges(message.sender?.identity).firstOrNull()

        assertEquals("20", badge?.let(::kickMessageBadgeVersion))
        assertNull(message.sender?.identity?.badges)
    }
}
