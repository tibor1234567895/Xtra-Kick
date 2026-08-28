package com.xtrakick.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xtrakick.app.model.ui.Bookmark
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarksDao {

    @Query("SELECT * FROM bookmarks")
    fun getAllFlow(): Flow<List<Bookmark>>

    @Query("SELECT * FROM bookmarks")
    fun getAll(): List<Bookmark>

    @Query("SELECT DISTINCT userId FROM bookmarks WHERE userId IS NOT NULL")
    fun getAllUserIds(): List<String>

    @Query("SELECT * FROM bookmarks WHERE videoId = :id")
    fun getByVideoId(id: String): Bookmark?

    @Query("SELECT * FROM bookmarks WHERE userId = :id")
    fun getByUserId(id: String): List<Bookmark>

    @Insert
    fun insert(video: Bookmark)

    @Delete
    fun delete(video: Bookmark)

    @Update
    fun update(video: Bookmark)
}
