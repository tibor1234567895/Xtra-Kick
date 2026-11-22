package com.xtrakick.app.util

import com.xtrakick.app.model.ui.User
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KickDefaultAssetsTest {

    @Test
    fun testDefaultProfilePictureForNebur1256() {
        val avatar = KickApiHelper.getDefaultProfilePicture("8683813", "nebur1256")
        assertEquals("https://files.kick.com/images/profile_image/default2.jpeg", avatar)
    }

    @Test
    fun testDefaultBannerForNebur1256() {
        val banner = KickApiHelper.getDefaultBanner("8683813", "nebur1256")
        assertEquals("https://files.kick.com/images/channel_banner/default2.webp", banner)
    }

    @Test
    fun testDefaultProfilePictureForCease() {
        val avatar = KickApiHelper.getDefaultProfilePicture("62529", "cease")
        assertEquals("https://files.kick.com/images/profile_image/default2.jpeg", avatar)
    }

    @Test
    fun testDefaultBannerForCease() {
        val banner = KickApiHelper.getDefaultBanner("62529", "cease")
        assertEquals("https://files.kick.com/images/channel_banner/default2.webp", banner)
    }

    @Test
    fun gymOwnerUsesOfficialMobileBannerWhenNoCustomBannerExists() {
        val user = User(channelId = "120599077", channelLogin = "gymowner")
        assertEquals("https://files.kick.com/images/channel_banner/default2.webp", user.bannerUrl)
        assertEquals("https://files.kick.com/images/profile_image/default2.jpeg", user.channelLogo)
    }

    @Test
    fun defaultAvatarsUseTheFourMobileVariants() {
        for (id in 4L..7L) {
            val variant = id % 4 + 1
            assertEquals("https://files.kick.com/images/profile_image/default$variant.jpeg", KickApiHelper.getDefaultProfilePicture(id))
        }
    }

    @Test
    fun customBannerTakesPriorityOverDefaultArtwork() {
        val url = "https://files.kick.com/images/channel/120599077/banner_image/custom.webp"
        val user = User(channelId = "120599077", channelLogin = "gymowner", bannerImageURL = url)
        assertEquals(url, user.bannerUrl)
    }

    @Test
    fun testUserChannelLogoFallback() {
        val userWithoutPfp = User(
            channelId = "8683813",
            channelLogin = "Nebur1256",
            profileImageUrl = null,
        )
        assertEquals("https://files.kick.com/images/profile_image/default2.jpeg", userWithoutPfp.channelLogo)

        val userWithPfp = User(
            channelId = "8683813",
            channelLogin = "Nebur1256",
            profileImageUrl = "https://files.kick.com/images/user/8683813/profile_image/custom.jpg",
        )
        assertTrue(userWithPfp.channelLogo?.contains("custom") == true)
    }

    @Test
    fun testTemplateUrlDoesNotMangleDefaultAssetUrls() {
        val avatarUrl = "https://files.kick.com/images/profile_image/default2.jpeg"
        val resolved = KickApiHelper.getTemplateUrl(avatarUrl, "profileimage")
        assertEquals(avatarUrl, resolved)
    }

    @Test
    fun testIsDefaultProfilePictureDistinguishesGenericAndCustomAvatars() {
        assertTrue(KickApiHelper.isDefaultProfilePicture("https://files.kick.com/images/profile_image/default4.jpeg"))
        assertTrue(KickApiHelper.isDefaultProfilePicture(KickApiHelper.getDefaultProfilePicture("984675", "saab")))
        assertFalse(KickApiHelper.isDefaultProfilePicture("https://files.kick.com/images/user/1028087/profile_image/conversion/64110a86-82e6-48f3-bb2c-df77d4c54572-fullsize.webp"))
        assertFalse(KickApiHelper.isDefaultProfilePicture(null))
        assertFalse(KickApiHelper.isDefaultProfilePicture(""))
    }
}
