package com.github.andreyasadchy.xtra.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class KickBadgeJsonInferenceUtilsTest {

    @Test
    fun `infers sub gifter type from gifted badge path`() {
        assertEquals("sub_gifter", inferKickBadgeTypeFromJsonPath(listOf("chatroom", "sub_gifter_badges", "0")))
        assertEquals("sub_gifter", inferKickBadgeTypeFromJsonPath(listOf("badges", "gift_subscriber_badges", "3")))
    }

    @Test
    fun `infers subscriber and founder badge types from path`() {
        assertEquals("subscriber", inferKickBadgeTypeFromJsonPath(listOf("subscriber_badges", "1")))
        assertEquals("founder", inferKickBadgeTypeFromJsonPath(listOf("chatroom", "founder_badges", "2")))
    }

    @Test
    fun `returns null for non badge paths`() {
        assertNull(inferKickBadgeTypeFromJsonPath(listOf("chatroom", "users", "0")))
    }
}
