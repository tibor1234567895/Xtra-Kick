package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickCategory
import com.xtrakick.app.model.kick.KickLivestream
import com.xtrakick.app.model.kick.KickSubcategory
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.datasource.StreamsDataSource
import com.xtrakick.app.ui.common.TagFilterHelper
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KickTagsFilterTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun testKickSubcategoryAndCategoryTagsDeserialization() {
        val jsonStr = """
            {
              "id": 8,
              "name": "Grand Theft Auto V",
              "slug": "grand-theft-auto-v",
              "tags": ["Shooter", "Action", "Open World"]
            }
        """.trimIndent()

        val subcat = json.decodeFromString<KickSubcategory>(jsonStr)
        assertEquals(listOf("Shooter", "Action", "Open World"), subcat.tags)

        val game = KickWebsiteSearchMapper.toGame(subcat)
        assertEquals(3, game.tags?.size)
        assertEquals("Shooter", game.tags?.get(0)?.name)

        val cat = json.decodeFromString<KickCategory>(jsonStr)
        assertEquals(listOf("Shooter", "Action", "Open World"), cat.tags)
    }

    @Test
    fun testToStreamCombinesStreamAndCategoryTags() {
        val livestream = KickLivestream(
            id = 123L,
            title = "Testing stream",
            language = "English",
            isMature = true,
            tags = listOf("CustomStreamTag", "Drops"),
            categories = listOf(
                KickCategory(id = 1L, name = "Game 1", slug = "game-1", tags = listOf("Shooter", "FPS")),
                KickCategory(id = 2L, name = "Game 2", slug = "game-2", tags = listOf("Action", "Drops"))
            )
        )

        val stream = KickWebsiteSearchMapper.toStream(livestream)
        assertEquals(
            listOf("English", "18+", "CustomStreamTag", "Drops"),
            stream.tags
        )
    }

    @Test
    fun testMatchesFiltersMatchesCategoryAndStreamTags() {
        val livestream = KickLivestream(
            id = 123L,
            language = "English",
            tags = listOf("Drops"),
            categories = listOf(
                KickCategory(id = 1L, name = "CS2", slug = "cs2", tags = listOf("Shooter", "Tactical"))
            )
        )

        // Matches custom tag
        assertTrue(
            StreamsDataSource.matchesFilters(
                item = livestream,
                languages = null,
                tags = listOf("drops")
            )
        )

        // Matches category tag
        assertTrue(
            StreamsDataSource.matchesFilters(
                item = livestream,
                languages = null,
                tags = listOf("Shooter")
            )
        )

        // Matches language as tag
        assertTrue(
            StreamsDataSource.matchesFilters(
                item = livestream,
                languages = null,
                tags = listOf("English")
            )
        )

        // Case-insensitive match
        assertTrue(
            StreamsDataSource.matchesFilters(
                item = livestream,
                languages = null,
                tags = listOf("tactical")
            )
        )

        // Rejects non-matching tag
        assertFalse(
            StreamsDataSource.matchesFilters(
                item = livestream,
                languages = null,
                tags = listOf("RPG")
            )
        )
    }

    @Test
    fun testMatchesFiltersFuzzyAndTitleMatching() {
        val stream = KickLivestream(
            id = 456L,
            title = "🔴MARTY BANKS 🔴 NOPIXEL 5.0 🔴",
            language = "English",
            isMature = true,
            tags = listOf("nopixel V"),
            categories = listOf(
                KickCategory(id = 8L, name = "Grand Theft Auto V", slug = "grand-theft-auto-v", tags = listOf("Action"))
            )
        )

        // Matches exact tag
        assertTrue(StreamsDataSource.matchesFilters(stream, null, listOf("nopixel V")))

        // Matches substring tag
        assertTrue(StreamsDataSource.matchesFilters(stream, null, listOf("nopixel")))

        // Matches tag ignoring spaces (nopixelv -> nopixel V)
        assertTrue(StreamsDataSource.matchesFilters(stream, null, listOf("nopixelv")))

        // Matches title
        assertTrue(StreamsDataSource.matchesFilters(stream, null, listOf("MARTY")))

        // Matches mature indicator
        assertTrue(StreamsDataSource.matchesFilters(stream, null, listOf("18+")))

        // Matches game name
        assertTrue(StreamsDataSource.matchesFilters(stream, null, listOf("Grand Theft Auto")))
    }

    @Test
    fun testStreamsDeduplicationByKey() {
        val stream1 = Stream(id = "101", channelId = "202", channelLogin = "streamer_a")
        val stream1Duplicate = Stream(id = "101", channelId = "202", channelLogin = "streamer_a")
        val stream2 = Stream(id = "102", channelId = "203", channelLogin = "streamer_b")

        val seenKeys = java.util.Collections.synchronizedSet(mutableSetOf<String>())
        fun key(s: Stream) = s.channelId ?: s.channelLogin ?: s.id.orEmpty()
        val list = listOf(stream1, stream1Duplicate, stream2).filter { seenKeys.add(key(it)) }

        assertEquals(2, list.size)
        assertEquals("202", list[0].channelId)
        assertEquals("203", list[1].channelId)
    }

    @Test
    fun testTagFilterHelperIsTagActiveAndToggle() {
        val activeTags = listOf("English", "nopixel V")

        assertTrue(TagFilterHelper.isTagActive("nopixel V", activeTags))
        assertTrue(TagFilterHelper.isTagActive("English", activeTags))
        assertFalse(TagFilterHelper.isTagActive("18+", activeTags))

        val toggledOff = TagFilterHelper.toggleTag(activeTags, "nopixel V")
        assertEquals(listOf("English"), toggledOff.toList())

        val toggledOn = TagFilterHelper.toggleTag(toggledOff.toList(), "nopixel V")
        assertEquals(listOf("English", "nopixel V"), toggledOn.toList())
    }
}
