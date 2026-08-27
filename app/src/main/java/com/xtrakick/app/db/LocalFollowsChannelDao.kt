package com.xtrakick.app.db

import androidx.room.*
import com.xtrakick.app.model.ui.LocalFollowChannel

@Dao
interface LocalFollowsChannelDao {

    @Query("SELECT * FROM local_follows")
    fun getAll(): List<LocalFollowChannel>

    @Query(
        """
        SELECT * FROM local_follows
        WHERE (:userId IS NOT NULL AND userId = :userId)
            OR (:userLogin IS NOT NULL AND userLogin = :userLogin)
        """
    )
    fun getByUserIdOrLogin(userId: String?, userLogin: String?): List<LocalFollowChannel>

    @Insert
    fun insert(video: LocalFollowChannel)

    @Query("DELETE FROM local_follows")
    fun deleteAll()

    @Delete
    fun delete(video: LocalFollowChannel)

    @Update
    fun update(video: LocalFollowChannel)
}
