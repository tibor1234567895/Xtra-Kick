package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionCreateResponse
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionsResponse
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickOfficialApiModelsParsingTest {
    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun parsesEventSubscriptionCreateFailures() {
        val parsed = json.decodeFromString<KickEventSubscriptionCreateResponse>(
            """
            {
              "message": "OK",
              "data": [
                {
                  "name": "chat.message.sent",
                  "version": 1,
                  "error": "subscription limit reached"
                }
              ]
            }
            """.trimIndent()
        )

        assertEquals(1, parsed.data.size)
        assertEquals("chat.message.sent", parsed.data.first().name)
        assertEquals("subscription limit reached", parsed.data.first().error)
        assertNull(parsed.data.first().subscriptionId)
    }

    @Test
    fun parsesRewardRedemptionPagination() {
        val parsed = json.decodeFromString<KickRewardRedemptionsResponse>(
            """
            {
              "message": "OK",
              "data": [
                {
                  "reward": {
                    "id": "reward-1",
                    "title": "Unban Request",
                    "cost": 100,
                    "can_manage": true
                  },
                  "redemptions": [
                    {
                      "id": "redeem-1",
                      "redeemed_at": "2025-12-19T06:26:36Z",
                      "redeemer": {
                        "user_id": 123,
                        "username": "viewer"
                      },
                      "status": "pending",
                      "user_input": "sorry"
                    }
                  ]
                }
              ],
              "pagination": {
                "next_cursor": "BASE64_CURSOR"
              }
            }
            """.trimIndent()
        )

        assertEquals("BASE64_CURSOR", parsed.pagination?.nextCursor)
        assertEquals(1, parsed.data.size)
        assertEquals("reward-1", parsed.data.first().reward?.id)
        assertEquals("redeem-1", parsed.data.first().redemptions.first().id)
    }
}
