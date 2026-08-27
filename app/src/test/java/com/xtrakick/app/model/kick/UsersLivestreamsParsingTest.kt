package com.xtrakick.app.model.kick

import com.xtrakick.app.model.kick.api.livestream.LivestreamV2
import com.xtrakick.app.model.kick.api.livestream.UsersLivestreamsResponse
import com.xtrakick.app.model.kick.api.livestream.toLegacyLivestream
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class UsersLivestreamsParsingTest {
    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun parsesEnvelopeAndMapsOntoLegacyModel() {
        val parsed = json.decodeFromString<UsersLivestreamsResponse>(
            """
            {
              "data": [
                {
                  "broadcaster_user": {
                    "id": 42,
                    "username": "streamer",
                    "profile_picture": "https://example.com/avatar.jpg"
                  },
                  "category": { "id": 12, "name": "Gaming", "thumbnail": "https://example.com/game.jpg" },
                  "channel": { "slug": "streamer" },
                  "has_mature_content": false,
                  "id": "123e4567-e89b-12d3-a456-426614174000",
                  "language_code": "en",
                  "started_at": "2026-08-01T10:00:00Z",
                  "tags": ["english"],
                  "thumbnail": "https://example.com/thumb.jpg",
                  "title": "Road to Radiant",
                  "viewer_count": 1337,
                  "future_field": "unknown keys must be tolerated"
                }
              ],
              "message": "OK"
            }
            """.trimIndent()
        )

        val legacy = parsed.data.single().toLegacyLivestream()
        assertEquals(42L, legacy.broadcasterUserId)
        assertEquals("streamer", legacy.slug)
        assertEquals("Road to Radiant", legacy.streamTitle)
        assertEquals(1337, legacy.viewerCount)
        assertEquals("2026-08-01T10:00:00Z", legacy.startedAt)
        assertEquals("https://example.com/thumb.jpg", legacy.thumbnail)
        assertEquals("https://example.com/avatar.jpg", legacy.profilePicture)
        assertEquals("en", legacy.language)
        assertNull(legacy.customTags)
        assertEquals(12L, legacy.category?.id)
        assertEquals("Gaming", legacy.category?.name)
    }

    @Test
    fun toleratesMissingOptionalsAndMapsToNulls() {
        val parsed = json.decodeFromString<LivestreamV2>("{}")
        assertNull(parsed.broadcasterUser)
        assertNull(parsed.channel)
        assertNull(parsed.toLegacyLivestream().broadcasterUserId)
    }
}
