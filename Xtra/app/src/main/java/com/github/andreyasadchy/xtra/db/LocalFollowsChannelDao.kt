package com.github.andreyasadchy.xtra.db

import androidx.room.*
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel

@Dao
interface LocalFollowsChannelDao {

    @Query("SELECT * FROM local_follows")
    fun getAll(): List<LocalFollowChannel>

    @Query("SELECT * FROM local_follows WHERE userId = :id")
    fun getByUserId(id: String): LocalFollowChannel?

    @Insert
    fun insert(video: LocalFollowChannel)

    @Delete
    fun delete(video: LocalFollowChannel)

    @Update
    fun update(video: LocalFollowChannel)
}
