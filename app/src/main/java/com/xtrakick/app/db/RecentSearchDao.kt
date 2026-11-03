package com.xtrakick.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.xtrakick.app.model.ui.RecentSearch
import kotlinx.coroutines.flow.Flow
import java.util.Locale

@Dao
interface RecentSearchDao {

    @Query("SELECT * FROM recent_search WHERE type = :type ORDER BY lastSearched DESC")
    fun getAllFlow(type: String): Flow<List<RecentSearch>>

    @Query("SELECT * FROM recent_search WHERE type = :type")
    fun getAll(type: String): List<RecentSearch>

    @Insert
    fun insert(item: RecentSearch)

    @Delete
    fun delete(item: RecentSearch)

    @Query("DELETE FROM recent_search WHERE id NOT IN (SELECT id FROM recent_search WHERE type = :type ORDER BY lastSearched DESC, id DESC LIMIT 20) AND type = :type")
    fun deleteOld(type: String)

    @Transaction
    fun deleteMatching(query: String, type: String) {
        val normalizedQuery = query.trim().lowercase(Locale.ROOT)
        getAll(type).filter { it.query.trim().lowercase(Locale.ROOT) == normalizedQuery }.forEach(::delete)
    }

    @Transaction
    fun ensureMaxSizeAndInsert(item: RecentSearch) {
        val query = item.query.trim()
        if (query.isBlank()) return
        deleteMatching(query, item.type)
        insert(RecentSearch(query, item.type, item.lastSearched))
        deleteOld(item.type)
    }

    @Query("DELETE FROM recent_search")
    fun deleteAll()
}
