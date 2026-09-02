package com.xtrakick.app.repository

import com.xtrakick.app.model.ui.Video
import org.junit.Assert.assertEquals
import org.junit.Test

class KickVideoParsingTest {

    private fun resolveDisplayName(
        channelLogin: String?,
        channelName: String?,
        nameDisplayPref: String = "1"
    ): String? {
        val cleanLogin = channelLogin?.trim()?.takeIf { it.isNotBlank() }
        val cleanName = channelName?.trim()?.takeIf { it.isNotBlank() }
        return if (!cleanLogin.isNullOrBlank() && !cleanName.isNullOrBlank() && !cleanLogin.equals(cleanName, true)) {
            when (nameDisplayPref) {
                "0" -> "${cleanName}(${cleanLogin})"
                "1" -> cleanName
                else -> cleanLogin
            }
        } else {
            cleanName ?: cleanLogin
        }
    }

    @Test
    fun testDisplayNameResolution_whenChannelNameIsNull_fallsBackToChannelLogin() {
        val displayName = resolveDisplayName(channelLogin = "maximusblack", channelName = null, nameDisplayPref = "1")
        assertEquals("maximusblack", displayName)
    }

    @Test
    fun testDisplayNameResolution_whenChannelLoginIsNull_fallsBackToChannelName() {
        val displayName = resolveDisplayName(channelLogin = null, channelName = "MaximusBlack", nameDisplayPref = "1")
        assertEquals("MaximusBlack", displayName)
    }

    @Test
    fun testDisplayNameResolution_whenBothPresentAndDiffer_respectsDisplayMode() {
        assertEquals("Maximus(maximusblack)", resolveDisplayName("maximusblack", "Maximus", "0"))
        assertEquals("Maximus", resolveDisplayName("maximusblack", "Maximus", "1"))
        assertEquals("maximusblack", resolveDisplayName("maximusblack", "Maximus", "2"))
    }

    @Test
    fun testDisplayNameResolution_whenBothMatchCaseInsensitive_usesChannelName() {
        assertEquals("MaximusBlack", resolveDisplayName("maximusblack", "MaximusBlack", "1"))
        assertEquals("MaximusBlack", resolveDisplayName("maximusblack", "MaximusBlack", "0"))
    }

    @Test
    fun testVideoModelChannelProperties() {
        val video = Video(
            id = "12345",
            channelId = "999",
            channelLogin = "maximusblack",
            channelName = "MaximusBlack",
            title = "OTT - Gang Update",
            duration = "7445"
        )
        assertEquals("12345", video.id)
        assertEquals("maximusblack", video.channelLogin)
        assertEquals("MaximusBlack", video.channelName)
        assertEquals("OTT - Gang Update", video.title)
    }
}
