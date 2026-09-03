package com.xtrakick.app.model.ui

import com.xtrakick.app.util.AppConstants
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LocalFollowChannelSourceMaskTest {

    @Test
    fun defaultIsLocalOnly() {
        val channel = LocalFollowChannel(userLogin = "someone")
        assertTrue((channel.sourceMask and AppConstants.FOLLOW_SOURCE_MASK_LOCAL) != 0)
        assertTrue(channel.isLocalOnlyFollow)
    }

    @Test
    fun kickFlagClearsLocalOnly() {
        val channel = LocalFollowChannel(
            userLogin = "someone",
            sourceMask = AppConstants.FOLLOW_SOURCE_MASK_LOCAL or AppConstants.FOLLOW_SOURCE_MASK_KICK,
        )
        assertTrue(channel.isKickFollow)
        assertFalse(channel.isLocalOnlyFollow)
    }

    @Test
    fun masksAreDistinctBits() {
        assertTrue((AppConstants.FOLLOW_SOURCE_MASK_LOCAL and AppConstants.FOLLOW_SOURCE_MASK_KICK) == 0)
    }
}
