package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickLiveNotificationEvent
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class KickLiveNotificationEventTest {
    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun parsesNativeKickPusherLiveEvent() {
        val payload = """
        {
            "user_id": 58065,
            "title": "<strong>BigSkenger</strong> just went live!",
            "description": "I HATE LORD KEBUN NOT MR K",
            "path": "/bigskenger",
            "profile_picture": "https://files.kick.com/images/user/128031/profile_image/conversion/e7ee3317-81c1-4571-a92a-b35ad00e2034-medium.webp"
        }
        """.trimIndent()

        val parsed = json.decodeFromString<KickLiveNotificationEvent>(payload)
        assertNotNull(parsed)
        assertEquals(58065L, parsed.userId)
        assertEquals("<strong>BigSkenger</strong> just went live!", parsed.title)
        assertEquals("I HATE LORD KEBUN NOT MR K", parsed.description)
        assertEquals("/bigskenger", parsed.path)
        assertEquals("https://files.kick.com/images/user/128031/profile_image/conversion/e7ee3317-81c1-4571-a92a-b35ad00e2034-medium.webp", parsed.profilePicture)
    }

    @Test
    fun handlesPartialPayloadWithMissingFields() {
        val payload = """
        {
            "user_id": 9999,
            "path": "/streamer"
        }
        """.trimIndent()

        val parsed = json.decodeFromString<KickLiveNotificationEvent>(payload)
        assertEquals(9999L, parsed.userId)
        assertEquals("/streamer", parsed.path)
        assertNull(parsed.title)
        assertNull(parsed.description)
        assertNull(parsed.profilePicture)
    }

    @Test
    fun ignoresUnknownFieldsSafely() {
        val payload = """
        {
            "user_id": 1234,
            "path": "/test",
            "new_kick_field": "something_unexpected",
            "nested_extra": { "foo": "bar" }
        }
        """.trimIndent()

        val parsed = json.decodeFromString<KickLiveNotificationEvent>(payload)
        assertEquals(1234L, parsed.userId)
        assertEquals("/test", parsed.path)
    }

    @Test
    fun slugSanitizationStripsSlashesAndQueryParameters() {
        val rawPaths = listOf(
            "/streamer" to "streamer",
            "///streamer///" to "streamer",
            "/streamer?ref=notification" to "streamer",
            "/streamer/subpath" to "streamer",
        )

        rawPaths.forEach { (raw, expected) ->
            val cleanSlug = raw.trim()
                .trimStart('/')
                .substringBefore('?')
                .substringBefore('/')
            assertEquals(expected, cleanSlug)
        }
    }
}
