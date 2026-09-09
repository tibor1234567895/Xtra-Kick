package com.xtrakick.app.repository

import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.LocalFollowChannel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class LocalFollowChannelRepositoryTest {
    @Test
    fun batchImportMergesRepeatedIdentitiesAndKeepsSourceFlags() = runBlocking {
        val database = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.getApplication(), AppDatabase::class.java).build()
        try {
            val repository = LocalFollowChannelRepository(database.localFollowsChannel(), database)
            repository.upsertLocalFollows(listOf(
                LocalFollowChannel("123", "channel", "Original", sourceMask = 1),
                LocalFollowChannel("123", "channel", "Updated", sourceMask = 2),
                LocalFollowChannel(null, "CHANNEL", channelLogo = "logo", sourceMask = 1),
            ))
            val saved = repository.loadFollows().single()
            assertEquals("123", saved.userId)
            assertEquals("Updated", saved.userName)
            assertEquals("logo", saved.channelLogo)
            assertEquals(3, saved.sourceMask)
            repository.upsertLocalFollows(listOf(LocalFollowChannel("456", "other")))
            assertEquals(2, repository.loadFollows().size)
        } finally {
            database.close()
        }
    }
}
