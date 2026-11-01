package com.xtrakick.app.util

import com.xtrakick.app.model.ui.User
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class KickDefaultAssetsTest {

    @Test
    fun testDefaultProfilePictureForNebur1256() {
        val avatar = KickApiHelper.getDefaultProfilePicture("8683813", "nebur1256")
        assertEquals("https://kick.com/img/default-profile-pictures/default-avatar-2.webp", avatar)
    }

    @Test
    fun testDefaultBannerForNebur1256() {
        val banner = KickApiHelper.getDefaultBanner("8683813", "nebur1256")
        assertEquals("https://kick.com/img/default-channel-banners/new-default-banner-2.webp", banner)
    }

    @Test
    fun testDefaultProfilePictureForCease() {
        val avatar = KickApiHelper.getDefaultProfilePicture("62529", "cease")
        assertEquals("https://kick.com/img/default-profile-pictures/default-avatar-4.webp", avatar)
    }

    @Test
    fun testDefaultBannerForCease() {
        val banner = KickApiHelper.getDefaultBanner("62529", "cease")
        assertEquals("https://kick.com/img/default-channel-banners/new-default-banner-2.webp", banner)
    }

    @Test
    fun testUserChannelLogoFallback() {
        val userWithoutPfp = User(
            channelId = "8683813",
            channelLogin = "Nebur1256",
            profileImageUrl = null,
        )
        assertEquals("https://kick.com/img/default-profile-pictures/default-avatar-2.webp", userWithoutPfp.channelLogo)

        val userWithPfp = User(
            channelId = "8683813",
            channelLogin = "Nebur1256",
            profileImageUrl = "https://files.kick.com/images/user/8683813/profile_image/custom.jpg",
        )
        assertTrue(userWithPfp.channelLogo?.contains("custom") == true)
    }

    @Test
    fun testTemplateUrlDoesNotMangleDefaultAssetUrls() {
        val avatarUrl = "https://kick.com/img/default-profile-pictures/default-avatar-2.webp"
        val resolved = KickApiHelper.getTemplateUrl(avatarUrl, "profileimage")
        assertEquals(avatarUrl, resolved)
    }
}
