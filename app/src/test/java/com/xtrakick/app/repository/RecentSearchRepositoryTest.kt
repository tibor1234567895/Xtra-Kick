package com.xtrakick.app.repository

import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.ui.RecentSearch
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class RecentSearchRepositoryTest {
    private val database = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.getApplication(), AppDatabase::class.java).build()
    private val dao = database.recentSearchDao()
    private val repository = RecentSearchRepository(dao)

    @After fun close() = database.close()

    @Test fun repeatedAndConcurrentSubmissionsMoveOneEntryToTheTop() = runBlocking {
        repository.save(RecentSearch("gta", RecentSearch.TYPE_GAME, 1))
        repository.save(RecentSearch("cs2", RecentSearch.TYPE_GAME, 2))
        coroutineScope {
            (3L..12L).map { timestamp -> async {
                repository.save(RecentSearch(" GTA ", RecentSearch.TYPE_GAME, timestamp))
            } }.awaitAll()
        }
        val history = repository.loadRecentSearchFlow(RecentSearch.TYPE_GAME).first()
        assertEquals(listOf("GTA", "cs2"), history.map { it.query })
        assertEquals(2, dao.getAllFlow(RecentSearch.TYPE_GAME).first().size)
    }

    @Test fun typesRemainSeparateBlankQueriesAreIgnoredAndEachTypeKeepsTwentyEntries() = runBlocking {
        repository.save(RecentSearch("gta", RecentSearch.TYPE_CHANNEL, 1))
        repository.save(RecentSearch("   ", RecentSearch.TYPE_GAME, 2))
        assertTrue(repository.loadRecentSearchFlow(RecentSearch.TYPE_GAME).first().isEmpty())
        for (index in 1..25) repository.save(RecentSearch("game $index", RecentSearch.TYPE_GAME, index.toLong()))
        val games = repository.loadRecentSearchFlow(RecentSearch.TYPE_GAME).first()
        assertEquals(20, games.size)
        assertEquals("game 25", games.first().query)
        assertEquals("game 6", games.last().query)
        assertEquals(listOf("gta"), repository.loadRecentSearchFlow(RecentSearch.TYPE_CHANNEL).first().map { it.query })
    }

    @Test fun oldDuplicateRowsAreNotDisplayedAndSelectingOneReplacesAllMatchingCopies() = runBlocking {
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            dao.insert(RecentSearch("gta", RecentSearch.TYPE_GAME, 1))
            dao.insert(RecentSearch(" GTA ", RecentSearch.TYPE_GAME, 2))
        }
        assertEquals(1, repository.loadRecentSearchFlow(RecentSearch.TYPE_GAME).first().size)
        repository.save(RecentSearch("gta", RecentSearch.TYPE_GAME, 3))
        assertEquals(1, dao.getAllFlow(RecentSearch.TYPE_GAME).first().size)
        assertEquals(3L, repository.loadRecentSearchFlow(RecentSearch.TYPE_GAME).first().single().lastSearched)
    }

    @Test fun deletingALegacyDuplicateRemovesEveryMatchingRowOnlyForItsType() = runBlocking {
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            dao.insert(RecentSearch("gta", RecentSearch.TYPE_GAME, 1))
            dao.insert(RecentSearch(" GTA ", RecentSearch.TYPE_GAME, 2))
            dao.insert(RecentSearch("gta", RecentSearch.TYPE_CHANNEL, 3))
        }
        repository.delete(repository.loadRecentSearchFlow(RecentSearch.TYPE_GAME).first().single())
        assertTrue(dao.getAllFlow(RecentSearch.TYPE_GAME).first().isEmpty())
        assertEquals(1, repository.loadRecentSearchFlow(RecentSearch.TYPE_CHANNEL).first().size)
    }

    @Test fun accentedDuplicatesUseTheSameNormalizationForSavingDisplayingAndDeleting() = runBlocking {
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            dao.insert(RecentSearch("ÉCLAIR", RecentSearch.TYPE_CHANNEL, 1))
            dao.insert(RecentSearch(" éclair ", RecentSearch.TYPE_CHANNEL, 2))
        }
        assertEquals(1, repository.loadRecentSearchFlow(RecentSearch.TYPE_CHANNEL).first().size)
        repository.delete(repository.loadRecentSearchFlow(RecentSearch.TYPE_CHANNEL).first().single())
        assertTrue(dao.getAllFlow(RecentSearch.TYPE_CHANNEL).first().isEmpty())
        repository.save(RecentSearch("ÉCLAIR", RecentSearch.TYPE_CHANNEL, 3))
        repository.save(RecentSearch("éclair", RecentSearch.TYPE_CHANNEL, 4))
        assertEquals(1, dao.getAllFlow(RecentSearch.TYPE_CHANNEL).first().size)
    }
}
