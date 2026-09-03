package com.xtrakick.app.ui.notifications

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Pure-function tests for the Notification channels search + "Enabled only" filter.
 * The filter derives from the loaded list without touching it, so toggling it
 * on and back off must always restore every row (regression coverage for a
 * report where the top channel seemed to vanish after toggling).
 */
class NotificationChannelsFilterTest {

    private fun channel(
        id: String,
        name: String?,
        login: String? = name,
        enabled: Boolean,
    ) = NotificationChannelsViewModel.ChannelUi(
        id = id,
        name = name,
        login = login,
        logoUrl = null,
        enabled = enabled,
        followed = true,
    )

    private val full = listOf(
        channel(id = "0reed-id", name = "0Reed", enabled = false),
        channel(id = "4head-id", name = "4HEAD", enabled = true),
        channel(id = "52chains-id", name = "52chains", enabled = false),
    )

    @Test
    fun `no filter returns every channel`() {
        assertEquals(full, NotificationChannelsViewModel.applyChannelFilter(full, "", false))
    }

    @Test
    fun `enabled only keeps just the enabled channels`() {
        val filtered = NotificationChannelsViewModel.applyChannelFilter(full, "", true)
        assertEquals(listOf(full[1]), filtered)
    }

    @Test
    fun `toggling enabled only off restores every channel including the first`() {
        val enabledOnly = NotificationChannelsViewModel.applyChannelFilter(full, "", true)
        assertEquals(1, enabledOnly.size)
        val restored = NotificationChannelsViewModel.applyChannelFilter(full, "", false)
        assertEquals(full, restored)
        assertEquals("0Reed", restored.first().name)
    }

    @Test
    fun `query matches name case-insensitively`() {
        val filtered = NotificationChannelsViewModel.applyChannelFilter(full, "0ree", false)
        assertEquals(listOf(full[0]), filtered)
    }

    @Test
    fun `query matches login`() {
        val withLogin = full + channel(id = "999", name = "Some Name", login = "somelogin", enabled = false)
        val filtered = NotificationChannelsViewModel.applyChannelFilter(withLogin, "SOMELOGIN", false)
        assertEquals(listOf(withLogin.last()), filtered)
    }

    @Test
    fun `query matches channel id`() {
        val filtered = NotificationChannelsViewModel.applyChannelFilter(full, "4head-id", false)
        assertEquals(listOf(full[1]), filtered)
    }

    @Test
    fun `query combines with enabled only`() {
        val filtered = NotificationChannelsViewModel.applyChannelFilter(full, "head", true)
        assertEquals(listOf(full[1]), filtered)
        val none = NotificationChannelsViewModel.applyChannelFilter(full, "reed", true)
        assertEquals(emptyList<NotificationChannelsViewModel.ChannelUi>(), none)
    }

    @Test
    fun `blank query behaves like no query`() {
        assertEquals(full, NotificationChannelsViewModel.applyChannelFilter(full, "   ", false))
    }
}
