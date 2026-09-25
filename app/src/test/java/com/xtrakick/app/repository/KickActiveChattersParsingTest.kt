package com.xtrakick.app.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class KickActiveChattersParsingTest {

    @Test
    fun parsesAllHumanGroupsAndSkipsBots() {
        val raw = """
            {
              "data": {
                "bots": [{"username": "streamelements"}],
                "chatters": [
                  {"slug": "kromestylez", "username": "kromestylez"},
                  {"slug": "tktooowavy", "username": "TKTOOOWAVY"}
                ],
                "moderators": [{"slug": "rclemon", "username": "Rclemon"}],
                "ogs": [],
                "vips": [{"slug": "neon-alt", "username": "Neon_Alt"}],
                "total_count": 5
              },
              "message": "success"
            }
        """.trimIndent()

        val names = KickRepository.parseActiveChattersResponse(raw)

        assertEquals(listOf("kromestylez", "TKTOOOWAVY", "Rclemon", "Neon_Alt"), names)
    }

    @Test
    fun preservesResponseOrderWithinEachGroup() {
        val raw = """
            {
              "data": {
                "chatters": [
                  {"username": "zacw7"},
                  {"username": "air7g"},
                  {"username": "kekzii"}
                ]
              }
            }
        """.trimIndent()

        assertEquals(listOf("zacw7", "air7g", "kekzii"), KickRepository.parseActiveChattersResponse(raw))
    }

    @Test
    fun skipsEntriesWithoutUsername() {
        val raw = """
            {"data": {"chatters": [{"slug": "no-name-here"}, {"username": "valid"}]}}
        """.trimIndent()

        assertEquals(listOf("valid"), KickRepository.parseActiveChattersResponse(raw))
    }

    @Test
    fun toleratesMalformedAndEmptyPayloads() {
        assertTrue(KickRepository.parseActiveChattersResponse("").isEmpty())
        assertTrue(KickRepository.parseActiveChattersResponse("not json at all").isEmpty())
        assertTrue(KickRepository.parseActiveChattersResponse("""{"data": {"chatters": "oops"}}""").isEmpty())
        assertTrue(KickRepository.parseActiveChattersResponse("""{"message": "error"}""").isEmpty())
    }
}
