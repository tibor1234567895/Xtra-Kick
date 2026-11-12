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
    fun syncReconcilesKickMembershipAndPreservesLocalBookmarks() = runBlocking {
        val database = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.getApplication(), AppDatabase::class.java).build()
        try {
            val repository = LocalFollowChannelRepository(database.localFollowsChannel(), database)
            repository.upsertLocalFollows(listOf(
                LocalFollowChannel("1", "local", sourceMask = 1),
                LocalFollowChannel("2", "removed", sourceMask = 2),
                LocalFollowChannel("3", "both", sourceMask = 3),
                LocalFollowChannel("4", "kept", sourceMask = 2),
            ))
            val keptId = repository.getFollow("4", "kept")!!.id
            val snapshot = listOf(LocalFollowChannel(userLogin = "KEPT"), LocalFollowChannel(userLogin = "new"))
            org.junit.Assert.assertTrue(repository.reconcileKickFollows(snapshot) { true })
            val saved = repository.loadFollows().associateBy { it.userLogin }
            assertEquals(setOf("local", "both", "kept", "new"), saved.keys)
            assertEquals(1, saved["both"]?.sourceMask)
            assertEquals(keptId, saved["kept"]?.id)
            assertEquals(2, saved["new"]?.sourceMask)

            val version = repository.changeVersion
            repository.reconcileKickFollows(snapshot) { true }
            assertEquals(version, repository.changeVersion)
            repository.reconcileKickFollows(emptyList()) { true }
            assertEquals(setOf("local", "both"), repository.loadFollows().map { it.userLogin }.toSet())
        } finally {
            database.close()
        }
    }

    @Test
    fun syncRollsBackIfAccountOrVisibilityChangesBeforeCommit() = runBlocking {
        val database = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.getApplication(), AppDatabase::class.java).build()
        try {
            val repository = LocalFollowChannelRepository(database.localFollowsChannel(), database)
            repository.saveFollow(LocalFollowChannel(userLogin = "original", sourceMask = 2))
            val version = repository.changeVersion
            var checks = 0
            org.junit.Assert.assertFalse(repository.reconcileKickFollows(listOf(LocalFollowChannel(userLogin = "new"))) { ++checks == 1 })
            assertEquals(listOf("original"), repository.loadFollows().map { it.userLogin })
            assertEquals(version, repository.changeVersion)
        } finally {
            database.close()
        }
    }

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

    @Test
    fun clearKickFollowsDeletesPureKickFollowsAndDemotesDualFollows() = runBlocking {
        val database = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.getApplication(), AppDatabase::class.java).build()
        try {
            val repository = LocalFollowChannelRepository(database.localFollowsChannel(), database)
            repository.upsertLocalFollows(listOf(
                LocalFollowChannel("1", "local_only", "Local User", sourceMask = 1),
                LocalFollowChannel("2", "kick_only", "Kick User", sourceMask = 2),
                LocalFollowChannel("3", "both", "Dual User", sourceMask = 3),
            ))
            assertEquals(3, repository.loadFollows().size)

            repository.clearKickFollows()

            val remaining = repository.loadFollows()
            assertEquals(2, remaining.size)

            val localOnly = remaining.find { it.userId == "1" }
            val dual = remaining.find { it.userId == "3" }
            val kickOnly = remaining.find { it.userId == "2" }

            org.junit.Assert.assertNotNull(localOnly)
            assertEquals(1, localOnly?.sourceMask)
            org.junit.Assert.assertTrue(localOnly?.isLocalOnlyFollow == true)

            org.junit.Assert.assertNotNull(dual)
            assertEquals(1, dual?.sourceMask)
            org.junit.Assert.assertTrue(dual?.isLocalOnlyFollow == true)

            org.junit.Assert.assertNull(kickOnly)

            repository.clearKickFollows()
            assertEquals(2, repository.loadFollows().size)
        } finally {
            database.close()
        }
    }
}
