package com.xtrakick.app.repository

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Logcat-anchored tests for Kick API candidate selection / stop / auth-skip.
 * Inputs mirror temp-random/multipov/logcat_cleanup.txt (4head + 2642629).
 */
class KickApiCandidateUtilsTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun `channel points candidates match log shape with session and slug+id`() {
        val candidates = KickApiCandidateUtils.buildChannelPointRewardCandidates(
            channelSlug = "4head",
            channelId = "2642629",
            hasKickWebsiteSession = true,
        )

        assertEquals(
            listOf(
                "https://kick.com/api/v2/channels/4head/points",
                "https://kick.com/api/v2/channels/4head/rewards",
            ),
            candidates,
        )
        // Dead endpoints from logcat must not appear.
        assertTrue(candidates.none { it.contains("/community-points/") })
        assertTrue(candidates.none { it.endsWith("/me") })
        assertTrue(candidates.none { it.contains("/v1/channels/") })
        assertTrue(candidates.none { it.contains("/2642629/") })
    }

    @Test
    fun `channel points candidates without session drop points endpoint`() {
        val candidates = KickApiCandidateUtils.buildChannelPointRewardCandidates(
            channelSlug = "4head",
            channelId = "2642629",
            hasKickWebsiteSession = false,
        )
        assertEquals(
            listOf("https://kick.com/api/v2/channels/4head/rewards"),
            candidates,
        )
    }

    @Test
    fun `channel points drop points when private web auth already unusable`() {
        // After log: websiteSession=true still 401 on /points — later channels skip balance probe.
        val candidates = KickApiCandidateUtils.buildChannelPointRewardCandidates(
            channelSlug = "biotox",
            channelId = "245476",
            hasKickWebsiteSession = true,
            privateWebAuthUsable = false,
        )
        assertEquals(
            listOf("https://kick.com/api/v2/channels/biotox/rewards"),
            candidates,
        )
        assertFalse(
            KickApiCandidateUtils.shouldProbePrivateWebEndpoint(
                hasKickWebsiteSession = true,
                privateWebAuthUsable = false,
            ),
        )
        assertTrue(
            KickApiCandidateUtils.shouldProbePrivateWebEndpoint(
                hasKickWebsiteSession = true,
                privateWebAuthUsable = true,
            ),
        )
    }

    @Test
    fun `channel points candidates id-only when slug missing`() {
        val candidates = KickApiCandidateUtils.buildChannelPointRewardCandidates(
            channelSlug = null,
            channelId = "2642629",
            hasKickWebsiteSession = true,
        )
        assertEquals(
            listOf(
                "https://kick.com/api/v2/channels/2642629/points",
                "https://kick.com/api/v2/channels/2642629/rewards",
            ),
            candidates,
        )
    }

    @Test
    fun `stop channel points fetch after usable rewards without balance`() {
        // Log: rewards=5 available=true balance=null → must stop (no cascade for balance).
        assertTrue(
            KickApiCandidateUtils.shouldStopChannelPointFetch(
                rewardsCount = 5,
                available = true,
                balance = null,
            ),
        )
        assertTrue(
            KickApiCandidateUtils.shouldStopChannelPointFetch(
                rewardsCount = 1,
                available = false,
                balance = null,
            ),
        )
        assertFalse(
            KickApiCandidateUtils.shouldStopChannelPointFetch(
                rewardsCount = 0,
                available = false,
                balance = null,
            ),
        )
        assertTrue(
            KickApiCandidateUtils.shouldStopChannelPointFetch(
                rewardsCount = 0,
                available = false,
                balance = 100,
            ),
        )
    }

    @Test
    fun `room state candidates prefer slug chatroom and omit dead shapes`() {
        val candidates = KickApiCandidateUtils.buildRoomStateCandidates(
            channelSlug = "4head",
            channelId = "2642629",
        )

        assertEquals(
            "https://kick.com/api/v2/channels/4head/chatroom",
            candidates.first(),
        )
        assertTrue(candidates.contains("https://kick.com/api/v1/4head/chatroom"))
        // Numeric user-id chatroom always 404 in log when used as channel path.
        assertFalse(candidates.any { it.contains("/channels/2642629/chatroom") })
        // GET chatrooms/{id} always 405/404 in log.
        assertFalse(candidates.any { it.contains("/chatrooms/") })
    }

    @Test
    fun `room state candidates allow numeric chatroom only without slug`() {
        val candidates = KickApiCandidateUtils.buildRoomStateCandidates(
            channelSlug = null,
            channelId = "2642629",
        )
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/2642629/chatroom"))
        assertFalse(candidates.any { it.contains("/chatrooms/") })
    }

    @Test
    fun `pinned gift candidates omit chatrooms path and numeric chatroom when slug present`() {
        val candidates = KickApiCandidateUtils.buildPinnedGiftCandidates(
            channelSlug = "4head",
            channelId = "2642629",
            historyChannelId = "2587387",
        )
        assertEquals(
            "https://web.kick.com/api/v1/chat/2587387/history",
            candidates.first(),
        )
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/4head/chatroom"))
        assertFalse(candidates.any { it.contains("/chatrooms/") })
        assertFalse(candidates.any { it.contains("/channels/2642629/chatroom") })
    }

    @Test
    fun `extract chatroom ids ignores channel_id and user_id`() {
        // Mirrors log payload: chatroom id 2579856; channel/user ids must not be treated as chatroom ids.
        val root = json.parseToJsonElement(
            """
            {
              "id": 2579856,
              "channel_id": 2587387,
              "user_id": 2642629,
              "slow_mode": {"enabled": true, "message_interval": 1},
              "subscribers_mode": {"enabled": false},
              "followers_mode": {"enabled": true, "min_duration": 1},
              "emotes_mode": {"enabled": false},
              "pinned_message": null
            }
            """.trimIndent(),
        )
        assertEquals(listOf("2579856"), KickApiCandidateUtils.extractDedicatedChatroomIds(root))
    }

    @Test
    fun `extract chatroom ids from nested channel envelope`() {
        val root = json.parseToJsonElement(
            """
            {
              "id": 2587387,
              "slug": "4head",
              "user": {"id": 2642629},
              "chatroom": {
                "id": 2579856,
                "slow_mode": {"enabled": false}
              }
            }
            """.trimIndent(),
        )
        assertEquals(listOf("2579856"), KickApiCandidateUtils.extractDedicatedChatroomIds(root))
    }

    @Test
    fun `dedicated chatroom discovery urls skip v1 for pure numeric id`() {
        assertEquals(
            listOf("https://kick.com/api/v2/channels/2642629/chatroom"),
            KickApiCandidateUtils.buildDedicatedChatroomDiscoveryUrls("2642629"),
        )
        assertEquals(
            listOf(
                "https://kick.com/api/v2/channels/4head/chatroom",
                "https://kick.com/api/v1/4head/chatroom",
            ),
            KickApiCandidateUtils.buildDedicatedChatroomDiscoveryUrls("4head"),
        )
    }

    @Test
    fun `private pusher auth short-circuits after first failure in cycle`() {
        assertTrue(
            KickApiCandidateUtils.shouldAttemptPrivatePusherAuth(
                previousAuthFailedInCycle = false,
                hasSocketId = true,
            ),
        )
        assertFalse(
            KickApiCandidateUtils.shouldAttemptPrivatePusherAuth(
                previousAuthFailedInCycle = true,
                hasSocketId = true,
            ),
        )
        assertFalse(
            KickApiCandidateUtils.shouldAttemptPrivatePusherAuth(
                previousAuthFailedInCycle = false,
                hasSocketId = false,
            ),
        )
    }

    @Test
    fun `badge catalog candidates drop dead chatrooms and numeric chatroom when slug present`() {
        // Log: GET api/v1|v2/chatrooms/{n} 405/404; channels/{userId}/chatroom 404.
        val candidates = KickApiCandidateUtils.buildBadgeCatalogCandidates(
            channelSlug = "4head",
            channelId = "2642629",
        )
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/4head/chatroom"))
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/4head/badges"))
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/4head/chatroom/badges"))
        assertFalse(candidates.any { it.contains("/chatrooms/") })
        assertFalse(candidates.any { it.contains("/channels/2642629/chatroom") })
        // Numeric channel document/badges without .../chatroom remain OK fallbacks.
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/2642629/badges"))
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/2642629/info"))
    }

    @Test
    fun `badge catalog without slug may probe numeric chatroom as last resort`() {
        val candidates = KickApiCandidateUtils.buildBadgeCatalogCandidates(
            channelSlug = null,
            channelId = "2642629",
        )
        assertTrue(candidates.contains("https://kick.com/api/v2/channels/2642629/chatroom"))
        assertFalse(candidates.any { it.contains("/chatrooms/") })
    }

    @Test
    fun `short cache applies to chatroom channel and history urls only`() {
        assertTrue(
            KickApiCandidateUtils.shouldShortCacheKickWebGet(
                "https://kick.com/api/v2/channels/4head/chatroom",
            ),
        )
        assertTrue(
            KickApiCandidateUtils.shouldShortCacheKickWebGet(
                "https://web.kick.com/api/v1/chat/2587387/history",
            ),
        )
        assertTrue(
            KickApiCandidateUtils.shouldShortCacheKickWebGet(
                "https://kick.com/api/v2/channels/4head",
            ),
        )
        assertFalse(
            KickApiCandidateUtils.shouldShortCacheKickWebGet(
                "https://kick.com/broadcasting/auth",
            ),
        )
        assertFalse(
            KickApiCandidateUtils.shouldShortCacheKickWebGet(
                "https://kick.com/api/v2/channels/4head/points",
            ),
        )
        assertFalse(
            KickApiCandidateUtils.shouldShortCacheKickWebGet(
                "https://kick.com/api/v2/channels/4head/me",
            ),
        )
    }

    @Test
    fun `live history sources prefer history channel id over user id`() {
        // Log: 2587387 works; 2642629 (user) empty; chatroom 2579856 is for pusher not history.
        val sources = KickApiCandidateUtils.buildLiveHistoryMessageSources(
            preferredSource = null,
            historyChannelId = "2587387",
            chatroomIds = listOf("2579856"),
            channelId = "2642629",
            userIds = listOf("2642629"),
            channelLogin = "4head",
        )
        assertEquals("2587387", sources.first())
        assertFalse(sources.contains("2642629"))
        assertFalse(sources.contains("2579856"))
        assertTrue(sources.contains("4head"))
    }

    @Test
    fun `live history sources fall back when history id unknown`() {
        val sources = KickApiCandidateUtils.buildLiveHistoryMessageSources(
            preferredSource = "cached-source",
            historyChannelId = null,
            chatroomIds = listOf("2579856"),
            channelId = "2642629",
            userIds = listOf("2642629"),
            channelLogin = "4head",
        )
        assertEquals(
            listOf("cached-source", "2642629", "2579856", "4head"),
            sources,
        )
    }
}
