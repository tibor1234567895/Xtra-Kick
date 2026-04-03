package com.github.andreyasadchy.xtra.repository

import androidx.paging.PagingSource.LoadResult
import com.github.andreyasadchy.xtra.model.kick.KickCategory
import com.github.andreyasadchy.xtra.model.kick.KickChannelLivestream
import com.github.andreyasadchy.xtra.model.kick.KickSearchChannel
import com.github.andreyasadchy.xtra.model.kick.KickUser
import com.github.andreyasadchy.xtra.model.kick.KickThumbnail
import com.github.andreyasadchy.xtra.model.kick.KickWebsiteSearchResponse
import com.github.andreyasadchy.xtra.repository.datasource.KickSearchLoadStrategy
import com.github.andreyasadchy.xtra.util.C
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KickWebsiteSearchTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun buildUrlUsesSearchedWordParameter() {
        val url = KickWebsiteSearchRequest.buildUrl("  kick test  ")

        assertEquals("https://kick.com/api/search?searched_word=kick+test", url)
    }

    @Test(expected = IllegalArgumentException::class)
    fun buildUrlRejectsTooShortQueries() {
        KickWebsiteSearchRequest.buildUrl("hi")
    }

    @Test
    fun websiteSearchResponseMapsChannelsCategoriesAndLivestreams() {
        val response = json.decodeFromString<KickWebsiteSearchResponse>(
            """
            {
              "channels": [
                {
                  "id": 11,
                  "slug": "kickchan",
                  "followers_count": 321,
                  "is_live": true,
                  "user": {
                    "id": 99,
                    "username": "KickChan",
                    "profilepic": "https://files.kick.com/profile.webp"
                  }
                }
              ],
              "categories": [
                {
                  "id": 22,
                  "category_id": 1,
                  "name": "Kickback Clash",
                  "slug": "kickback-clash",
                  "viewers": 77,
                  "banner": {
                    "src": "https://files.kick.com/banner.webp"
                  }
                }
              ],
              "livestreams": {
                "tags": [
                  {
                    "id": 33,
                    "channel_id": 11,
                    "created_at": "2026-03-15 06:49:54",
                    "session_title": "Live title",
                    "viewer_count": 444,
                    "tags": ["Kick", "Gaming"],
                    "thumbnail": {
                      "src": "https://images.kick.com/thumb.webp"
                    },
                    "categories": [
                      {
                        "id": 22,
                        "name": "Kickback Clash",
                        "slug": "kickback-clash"
                      }
                    ],
                    "channel": {
                      "id": 11,
                      "slug": "kickchan",
                      "user": {
                        "id": 99,
                        "username": "KickChan",
                        "profilepic": "https://files.kick.com/profile.webp"
                      }
                    }
                  }
                ]
              }
            }
            """.trimIndent()
        )

        val user = KickWebsiteSearchMapper.toUser(response.channels.single())
        val game = KickWebsiteSearchMapper.toGame(response.categories.single())
        val stream = KickWebsiteSearchMapper.toStream(response.livestreams.tags.single())

        assertEquals("11", user.channelId)
        assertEquals("kickchan", user.channelLogin)
        assertEquals("KickChan", user.channelName)
        assertEquals(321, user.followersCount)
        assertTrue(user.isLive == true)

        assertEquals("22", game.gameId)
        assertEquals("kickback-clash", game.gameSlug)
        assertEquals("Kickback Clash", game.gameName)
        assertEquals("https://files.kick.com/banner.webp", game.boxArtUrl)
        assertEquals(77, game.viewersCount)

        assertEquals("33", stream.id)
        assertEquals("11", stream.channelId)
        assertEquals("kickchan", stream.channelLogin)
        assertEquals("KickChan", stream.channelName)
        assertEquals("22", stream.gameId)
        assertEquals("kickback-clash", stream.gameSlug)
        assertEquals("Kickback Clash", stream.gameName)
        assertEquals("Live title", stream.title)
        assertEquals(444, stream.viewerCount)
        assertEquals("2026-03-15T06:49:54Z", stream.startedAt)
        assertEquals("https://images.kick.com/thumb.webp", stream.thumbnailUrl)
        assertEquals("https://files.kick.com/profile.webp", stream.profileImageUrl)
        assertEquals(listOf("Kick", "Gaming"), stream.tags)
    }

    @Test
    fun thumbnailFallsBackToStreamHostWhenItIsTheOnlyCandidate() {
        val thumbnail = KickThumbnail(
            src = "https://stream.kick.com/live-thumb.webp"
        )

        assertEquals("https://stream.kick.com/live-thumb.webp", thumbnail.imageUrl)
    }

    @Test
    fun liveChannelCanBeMappedIntoAStream() {
        val stream = KickWebsiteSearchMapper.toStream(
            channel = KickSearchChannel(
                id = 11,
                userId = 99,
                slug = "kickchan",
                user = KickUser(
                    id = 99,
                    username = "KickChan",
                    profilePic = "https://files.kick.com/profile.webp"
                )
            ),
            livestream = KickChannelLivestream(
                id = 44,
                createdAt = "2026-03-15 07:00:00",
                title = "Fallback live",
                viewerCount = 555,
                thumbnail = KickThumbnail(src = "https://images.kick.com/fallback.webp"),
                category = KickCategory(
                    id = 22,
                    name = "Kickback Clash",
                    slug = "kickback-clash"
                )
            )
        )

        assertEquals(C.KICK, stream.source)
        assertEquals("44", stream.id)
        assertEquals("11", stream.channelId)
        assertEquals("kickchan", stream.channelLogin)
        assertEquals("KickChan", stream.channelName)
        assertEquals("22", stream.gameId)
        assertEquals("kickback-clash", stream.gameSlug)
        assertEquals("Kickback Clash", stream.gameName)
        assertEquals("Fallback live", stream.title)
        assertEquals(555, stream.viewerCount)
        assertEquals("2026-03-15T07:00:00Z", stream.startedAt)
        assertEquals("https://images.kick.com/fallback.webp", stream.thumbnailUrl)
        assertEquals("https://files.kick.com/profile.webp", stream.profileImageUrl)
    }

    @Test
    fun legacySwitchAndEmptyResultRulesStayExplicit() {
        val emptyResult = LoadResult.Page<Int, String>(
            data = emptyList(),
            prevKey = null,
            nextKey = null
        )
        val nonEmptyResult = LoadResult.Page<Int, String>(
            data = listOf("kick"),
            prevKey = null,
            nextKey = null
        )

        assertTrue(KickSearchLoadStrategy.useLegacySearch(true))
        assertFalse(KickSearchLoadStrategy.useLegacySearch(false))
        assertFalse(KickSearchLoadStrategy.shouldTryNextApi(C.KICK, false, emptyResult))
        assertTrue(KickSearchLoadStrategy.shouldTryNextApi(C.KICK, true, emptyResult))
        assertTrue(KickSearchLoadStrategy.shouldTryNextApi(C.GQL, false, emptyResult))
        assertFalse(KickSearchLoadStrategy.shouldTryNextApi(C.GQL, false, nonEmptyResult))
    }
}
