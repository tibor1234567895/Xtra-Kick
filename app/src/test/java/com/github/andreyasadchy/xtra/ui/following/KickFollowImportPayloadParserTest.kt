package com.github.andreyasadchy.xtra.ui.following

import org.junit.Assert.assertEquals
import org.junit.Test

class KickFollowImportPayloadParserTest {

    @Test
    fun parsesAndDeduplicatesImportedChannels() {
        val payload = """
            {
              "channels": [
                {
                  "channel_slug": "Alpha",
                  "user_username": "Alpha Name",
                  "profile_picture": "https://example.com/a.jpg"
                },
                {
                  "channel_slug": "alpha",
                  "user_username": "Duplicate",
                  "profile_picture": "https://example.com/b.jpg"
                },
                {
                  "channel_slug": "Beta",
                  "user_username": "",
                  "profile_picture": ""
                },
                {
                  "channel_slug": " ",
                  "user_username": "Ignored",
                  "profile_picture": "https://example.com/c.jpg"
                }
              ]
            }
        """.trimIndent()

        val parsed = KickFollowImportPayloadParser.parse(payload)

        assertEquals(
            listOf(
                KickImportedFollow(
                    login = "Alpha",
                    name = "Alpha Name",
                    profilePicture = "https://example.com/a.jpg",
                ),
                KickImportedFollow(
                    login = "Beta",
                    name = "Beta",
                    profilePicture = null,
                ),
            ),
            parsed,
        )
    }
}
