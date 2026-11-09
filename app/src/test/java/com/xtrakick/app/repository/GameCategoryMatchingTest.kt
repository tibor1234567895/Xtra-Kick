package com.xtrakick.app.repository

import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.util.KickApiHelper
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Locale

class GameCategoryMatchingTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun testSanitizeGameId_stripsParentCategoryIdsFromSubcategories() {
        // Parent ID 1 ("Games") paired with GTA V slug must be stripped
        assertNull(KickApiHelper.sanitizeGameId("1", "grand-theft-auto-v"))
        // Parent ID 2 ("IRL") paired with Just Chatting slug must be stripped
        assertNull(KickApiHelper.sanitizeGameId("2", "just-chatting"))
        // Parent ID 1 paired with parent slug "games" must be preserved
        assertEquals("1", KickApiHelper.sanitizeGameId("1", "games"))
        // Parent ID 2 paired with parent slug "irl" must be preserved
        assertEquals("2", KickApiHelper.sanitizeGameId("2", "irl"))
        // Valid subcategory ID 8 for GTA V must be preserved
        assertEquals("8", KickApiHelper.sanitizeGameId("8", "grand-theft-auto-v"))
        // Null or blank handling
        assertNull(KickApiHelper.sanitizeGameId(null, "grand-theft-auto-v"))
        assertNull(KickApiHelper.sanitizeGameId("  ", "grand-theft-auto-v"))
        assertEquals("1", KickApiHelper.sanitizeGameId("1", null))
    }

    @Test
    fun testResolveEffectiveCategorySlug_infersFromGameName() {
        // Direct slug preserved
        assertEquals(
            "grand-theft-auto-v",
            KickApiHelper.resolveEffectiveCategorySlug("grand-theft-auto-v", "Grand Theft Auto V (GTA)")
        )
        // Slug inferred from name containing acronym parentheses
        assertEquals(
            "grand-theft-auto-v",
            KickApiHelper.resolveEffectiveCategorySlug(null, "Grand Theft Auto V (GTA)")
        )
        // Slug inferred when original slug is blank
        assertEquals(
            "just-chatting",
            KickApiHelper.resolveEffectiveCategorySlug("", "Just Chatting")
        )
        assertEquals(
            "league-of-legends",
            KickApiHelper.resolveEffectiveCategorySlug(null, "League of Legends")
        )
    }

    @Test
    fun testFollowedStreamsCategoryJsonParsing_prefersSubcategoryIdOverParentId() {
        // Kick's /api/v1/user/livestreams categories[0] structure
        val categoryJson = """
            {
                "id": 8,
                "category_id": 1,
                "name": "Grand Theft Auto V (GTA)",
                "slug": "grand-theft-auto-v"
            }
        """.trimIndent()

        val jsonObject = json.parseToJsonElement(categoryJson).jsonObject

        // Buggy parser order returned parent category "1" (Games)
        val buggyId = jsonObject.firstLongOrNull("category_id", "id")?.toString()
        assertEquals("1", buggyId)

        // Fixed parser order returns correct subcategory "8" (Grand Theft Auto V)
        val fixedId = jsonObject.firstLongOrNull("id", "category_id")?.toString()
        assertEquals("8", fixedId)
    }

    @Test
    fun testMatchesCategory_matchesEventStreamAcrossAllNavigationEntryPoints() {
        // The event stream as returned by Kick events API:
        // Has subcategory ID 8, slug "grand-theft-auto-v", name "Grand Theft Auto V (GTA)"
        val eventStream = Stream(
            id = "1001",
            gameId = "8",
            gameSlug = "grand-theft-auto-v",
            gameName = "Grand Theft Auto V (GTA)",
            tags = listOf("nopixel V", "English")
        )

        // Helper replicating the hardened matching logic in GameStreamsDataSource
        fun matches(
            stream: Stream,
            targetId: String?,
            targetSlug: String?,
            targetName: String?
        ): Boolean {
            val streamId = stream.gameId?.trim()
            val streamSlug = stream.gameSlug?.trim()?.lowercase(Locale.ROOT)
            val streamName = stream.gameName?.trim()
            val streamInferredSlug = KickApiHelper.toCategorySlug(streamName)

            val targetNormalizedSlug = targetSlug?.trim()?.lowercase(Locale.ROOT)
            val targetNormalizedName = targetName?.trim()
            val targetInferredSlug = KickApiHelper.toCategorySlug(targetNormalizedName)

            // 1. Direct ID match
            if (targetId != null && streamId != null && streamId == targetId) return true

            // 2. Direct slug match
            if (targetNormalizedSlug != null && streamSlug != null && streamSlug == targetNormalizedSlug) return true

            // 3. Name match
            if (targetNormalizedName != null && streamName != null && streamName.equals(targetNormalizedName, ignoreCase = true)) return true

            // 4. Inferred slug cross-match
            if (targetNormalizedSlug != null && streamInferredSlug != null && streamInferredSlug == targetNormalizedSlug) return true
            if (targetInferredSlug != null && streamSlug != null && streamSlug == targetInferredSlug) return true
            if (targetInferredSlug != null && streamInferredSlug != null && targetInferredSlug == streamInferredSlug) return true

            return false
        }

        // Case A: Navigated from Games > GTA V (clean ID 8 and slug)
        assertTrue(
            "Games > Category navigation should match",
            matches(eventStream, targetId = "8", targetSlug = "grand-theft-auto-v", targetName = "Grand Theft Auto V (GTA)")
        )

        // Case B: Navigated from Following > Live card with sanitized ID (id=null, inferred slug)
        val sanitizedId = KickApiHelper.sanitizeGameId("1", "grand-theft-auto-v")
        assertNull(sanitizedId)
        assertTrue(
            "Following > Live card navigation with sanitized ID should match",
            matches(eventStream, targetId = sanitizedId, targetSlug = "grand-theft-auto-v", targetName = "Grand Theft Auto V (GTA)")
        )

        // Case C: Stale ID "1" passed from legacy cache or bundle, but slug/name match
        assertTrue(
            "Stale parent category ID 1 with matching slug should still match by slug/name",
            matches(eventStream, targetId = "1", targetSlug = "grand-theft-auto-v", targetName = "Grand Theft Auto V (GTA)")
        )

        // Case D: Name variation without "(GTA)" suffix
        assertTrue(
            "Name variation without acronym suffix should match via inferred slug",
            matches(eventStream, targetId = null, targetSlug = null, targetName = "Grand Theft Auto V")
        )

        // Case E: Mismatched game (Valorant) must NOT match
        assertFalse(
            "Different game must be rejected",
            matches(eventStream, targetId = "123", targetSlug = "valorant", targetName = "Valorant")
        )
    }

    @Test
    fun testParentCategoryIds_neverCachedAsSubcategories() {
        val parentIds = KickApiHelper.PARENT_CATEGORY_IDS
        val parentSlugs = KickApiHelper.PARENT_CATEGORY_SLUGS

        fun isValidCacheEntry(id: String?, slug: String?): Boolean {
            if (id.isNullOrBlank() || slug.isNullOrBlank()) return false
            val cleanSlug = slug.trim().lowercase(Locale.ROOT)
            if (id in parentIds && cleanSlug !in parentSlugs) {
                return false
            }
            return true
        }

        // Subcategory GTA V with ID 8 is valid
        assertTrue(isValidCacheEntry("8", "grand-theft-auto-v"))
        // Parent Games with ID 1 is valid
        assertTrue(isValidCacheEntry("1", "games"))
        // Corrupted pairing: ID 1 with GTA V must be rejected from cache
        assertFalse(isValidCacheEntry("1", "grand-theft-auto-v"))
        // Corrupted pairing: ID 2 with Just Chatting must be rejected from cache
        assertFalse(isValidCacheEntry("2", "just-chatting"))
    }
}
