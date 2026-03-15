package com.github.andreyasadchy.xtra.db

import androidx.room.*
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel

@Dao
interface LocalFollowsChannelDao {

    @Query("SELECT * FROM local_follows")
    fun getAll(): List<LocalFollowChannel>

    @Query("SELECT * FROM local_follows WHERE userId = :id OR userLogin = :id LIMIT 1")
    fun getByUserId(id: String): LocalFollowChannel?

    @Query("SELECT * FROM local_follows WHERE (sourceMask & :mask) != 0")
    fun getAllBySourceMask(mask: Int): List<LocalFollowChannel>

    @Insert
    fun insert(video: LocalFollowChannel)

    @Delete
    fun delete(video: LocalFollowChannel)

    @Update
    fun update(video: LocalFollowChannel)
}
