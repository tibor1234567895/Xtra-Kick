package com.xtrakick.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.xtrakick.app.model.ui.VodBookmarkIgnoredUser
import kotlinx.coroutines.flow.Flow

@Dao
interface VodBookmarkIgnoredUsersDao {

    @Query("SELECT * FROM vod_bookmark_ignored_users")
    fun getAllFlow(): Flow<List<VodBookmarkIgnoredUser>>

    @Query("SELECT * FROM vod_bookmark_ignored_users")
    fun getAll(): List<VodBookmarkIgnoredUser>

    @Query("SELECT * FROM vod_bookmark_ignored_users WHERE user_id = :id")
    fun getById(id: String): VodBookmarkIgnoredUser?

    @Insert
    fun insert(user: VodBookmarkIgnoredUser)

    @Delete
    fun delete(user: VodBookmarkIgnoredUser)
}
