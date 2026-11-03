package com.xtrakick.app.repository

import com.xtrakick.app.db.RecentSearchDao
import com.xtrakick.app.model.ui.RecentSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecentSearchRepository @Inject constructor(
    private val recentSearchDao: RecentSearchDao,
) {

    fun loadRecentSearchFlow(type: String) = recentSearchDao.getAllFlow(type).map { items ->
        items.distinctBy { it.query.trim().lowercase(Locale.ROOT) }
    }

    suspend fun save(item: RecentSearch) = withContext(Dispatchers.IO) {
        recentSearchDao.ensureMaxSizeAndInsert(item)
    }

    suspend fun delete(item: RecentSearch) = withContext(Dispatchers.IO) {
        recentSearchDao.deleteMatching(item.query, item.type)
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        recentSearchDao.deleteAll()
    }
}
