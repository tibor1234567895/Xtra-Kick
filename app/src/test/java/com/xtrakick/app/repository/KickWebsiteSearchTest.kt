package com.xtrakick.app.repository

import androidx.paging.PagingSource.LoadResult
import com.xtrakick.app.model.kick.KickCategory
import com.xtrakick.app.model.kick.KickChannelLivestream
import com.xtrakick.app.model.kick.KickSearchChannel
import com.xtrakick.app.model.kick.KickUser
import com.xtrakick.app.model.kick.KickThumbnail
import com.xtrakick.app.model.kick.KickWebsiteSearchResponse
import com.xtrakick.app.repository.datasource.KickSearchLoadStrategy
import com.xtrakick.app.util.AppConstants
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

        assertEquals(AppConstants.KICK, stream.source)
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
        assertFalse(KickSearchLoadStrategy.shouldTryNextApi(AppConstants.KICK, false, emptyResult))
        assertTrue(KickSearchLoadStrategy.shouldTryNextApi(AppConstants.KICK, true, emptyResult))
        assertTrue(KickSearchLoadStrategy.shouldTryNextApi(AppConstants.GQL, false, emptyResult))
        assertFalse(KickSearchLoadStrategy.shouldTryNextApi(AppConstants.GQL, false, nonEmptyResult))
    }

    @Test
    fun typesenseMultiSearchResponseParsesChannelsAndCategories() {
        val jsonString = """
        {
          "results": [
            {
              "found": 13,
              "out_of": 119657385,
              "page": 1,
              "search_time_ms": 2,
              "hits": [
                {
                  "document": {
                    "followers_count": 18740,
                    "id": "121900",
                    "is_banned": false,
                    "is_live": false,
                    "slug": "ming",
                    "username": "Ming",
                    "verified": true
                  }
                },
                {
                  "document": {
                    "category_id": 1,
                    "id": "1344",
                    "is_live": true,
                    "name": "Grand Prix World",
                    "slug": "grand-prix-world",
                    "src": "https://files.kick.com/banner.webp"
                  }
                }
              ]
            }
          ]
        }
        """.trimIndent()

        val response = json.decodeFromString<com.xtrakick.app.model.kick.KickMultiSearchResponse>(jsonString)
        assertEquals(1, response.results.size)
        val result = response.results.first()
        assertEquals(13, result.found)
        assertEquals(1, result.page)
        assertEquals(2, result.hits.size)

        val user = KickWebsiteSearchMapper.toUser(result.hits[0].document)
        assertEquals("121900", user.channelId)
        assertEquals("ming", user.channelLogin)
        assertEquals("Ming", user.channelName)
        assertEquals(18740, user.followersCount)
        assertFalse(user.isLive == true)

        val game = KickWebsiteSearchMapper.toGame(result.hits[1].document)
        assertEquals("1344", game.gameId)
        assertEquals("grand-prix-world", game.gameSlug)
        assertEquals("Grand Prix World", game.gameName)
        assertEquals("https://files.kick.com/banner.webp", game.boxArtUrl)
    }

    @Test
    fun typesenseMultiSearchRequestEncodesValidJson() {
        val request = com.xtrakick.app.model.kick.KickMultiSearchRequest(
            searches = listOf(
                com.xtrakick.app.model.kick.KickTypesenseQuery(
                    preset = "channel_search",
                    q = "ming",
                    page = 2,
                    perPage = 20
                )
            )
        )
        val encoded = json.encodeToString(com.xtrakick.app.model.kick.KickMultiSearchRequest.serializer(), request)
        assertTrue(encoded.contains("\"preset\":\"channel_search\""))
        assertTrue(encoded.contains("\"q\":\"ming\""))
        assertTrue(encoded.contains("\"page\":2"))
        assertTrue(encoded.contains("\"per_page\":20"))
    }
}
