package com.xtrakick.app.util.chat

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

// parseRGBAColor delegates to android.graphics.Color, which has no implementation on a plain
// JVM — Robolectric supplies it.
// application pinned so Robolectric boots the stock Application instead of KickApp
// (Conscrypt fails with UnsatisfiedLinkError on the JVM).
@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class StvEventApiHydrateTest {

    private fun gql(vararg json: String) = Json.parseToJsonElement(json.joinToString("")).jsonObject

    @Test
    fun `linear gradient paint maps onto NamePaint`() {
        val response = """
            {
              "paints": [
                {
                  "id": "PAINT1",
                  "name": "Sea Foam",
                  "gradients": [
                    {
                      "function": "LINEAR_GRADIENT",
                      "angle": 180,
                      "repeat": false,
                      "image_url": "",
                      "stops": [
                        { "at": 0.0, "color": -16777216 },
                        { "at": 1.0, "color": 255 }
                      ]
                    }
                  ],
                  "shadows": [
                    { "x_offset": 0.5, "y_offset": -0.5, "radius": 4.0, "color": 8238079 }
                  ]
                }
              ],
              "badges": []
            }
        """.trimIndent()
        val result = StvEventApiUtils.hydrateFromGql(gql(response), useWebp = true)

        assertEquals(1, result.size)
        val cosmetic = result.first() as StvEventApiUtils.Cosmetic.Paint
        assertEquals("PAINT1", cosmetic.paint.id)
        assertEquals("LINEAR_GRADIENT", cosmetic.paint.type)
        assertEquals(180, cosmetic.paint.angle)
        assertEquals(false, cosmetic.paint.repeat)
        assertEquals(2, cosmetic.paint.colors?.size)
        assertEquals(2, cosmetic.paint.colorPositions?.size)
        assertEquals(0f, cosmetic.paint.colorPositions!![0])
        assertEquals(1f, cosmetic.paint.colorPositions[1])
        assertEquals(1, cosmetic.paint.shadows?.size)
        val shadow = cosmetic.paint.shadows!!.first()
        assertEquals(0.5f, shadow.xOffset)
        assertEquals(-0.5f, shadow.yOffset)
        assertEquals(4f, shadow.radius)
    }

    @Test
    fun `url paint maps image url`() {
        val response = """
            {
              "paints": [
                {
                  "id": "PAINT2",
                  "name": "Picture",
                  "gradients": [
                    { "function": "URL", "image_url": "https://cdn.7tv.app/paint.webp" }
                  ],
                  "shadows": []
                }
              ],
              "badges": []
            }
        """.trimIndent()
        val result = StvEventApiUtils.hydrateFromGql(gql(response), useWebp = true)
        val cosmetic = result.first() as StvEventApiUtils.Cosmetic.Paint
        assertEquals("URL", cosmetic.paint.type)
        assertEquals("https://cdn.7tv.app/paint.webp", cosmetic.paint.imageUrl)
        assertNull(cosmetic.paint.colors)
    }

    @Test
    fun `solid color only paint is skipped`() {
        val response = """
            {
              "paints": [
                { "id": "SOLID", "name": "Plain", "gradients": [], "shadows": [] }
              ],
              "badges": []
            }
        """.trimIndent()
        assertTrue(StvEventApiUtils.hydrateFromGql(gql(response), useWebp = true).isEmpty())
    }

    @Test
    fun `badge builds scaled urls filtered by format preference`() {
        val webpResponse = """
            {
              "paints": [],
              "badges": [
                {
                  "id": "BADGE1",
                  "name": "Moderator",
                  "tooltip": "7TV Moderator",
                  "host": {
                    "url": "//cdn.7tv.app/badge/BADGE1",
                    "files": [
                      { "name": "1x.webp", "format": "WEBP" },
                      { "name": "2x.webp", "format": "WEBP" },
                      { "name": "3x.webp", "format": "WEBP" },
                      { "name": "4x.webp", "format": "WEBP" }
                    ]
                  }
                }
              ]
            }
        """.trimIndent()
        val webpResult = StvEventApiUtils.hydrateFromGql(gql(webpResponse), useWebp = true)
        val badge = (webpResult.first() as StvEventApiUtils.Cosmetic.Badge).badge
        assertEquals("BADGE1", badge.id)
        assertEquals("7TV Moderator", badge.name)
        assertEquals("https://cdn.7tv.app/badge/BADGE1/1x.webp", badge.url1x)
        assertEquals("https://cdn.7tv.app/badge/BADGE1/4x.webp", badge.url4x)
        assertEquals("webp", badge.format)

        val gifResponse = webpResponse.replace("webp", "gif").replace("WEBP", "GIF")
        val gifResult = StvEventApiUtils.hydrateFromGql(gql(gifResponse), useWebp = false)
        val gifBadge = (gifResult.first() as StvEventApiUtils.Cosmetic.Badge).badge
        assertEquals("https://cdn.7tv.app/badge/BADGE1/1x.gif", gifBadge.url1x)
        assertEquals("gif", gifBadge.format)
    }

    @Test
    fun `non matching formats fall back to default urls`() {
        val response = """
            {
              "paints": [],
              "badges": [
                {
                  "id": "AVIF_ONLY",
                  "name": "Fancy",
                  "tooltip": "Fancy",
                  "host": {
                    "url": "//cdn.7tv.app/badge/AVIF_ONLY",
                    "files": [ { "name": "3x.avif", "format": "AVIF" } ]
                  }
                }
              ]
            }
        """.trimIndent()
        val result = StvEventApiUtils.hydrateFromGql(gql(response), useWebp = true)
        val badge = (result.first() as StvEventApiUtils.Cosmetic.Badge).badge
        // parseCosmetic falls back to templated webp urls when no preferred format matched
        assertEquals("https://cdn.7tv.app/badge/AVIF_ONLY/1x.webp", badge.url1x)
        assertEquals("https://cdn.7tv.app/badge/AVIF_ONLY/4x.webp", badge.url4x)
    }
}
