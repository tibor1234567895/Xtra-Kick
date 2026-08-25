package com.xtrakick.app.db

import androidx.room.*
import com.xtrakick.app.model.ui.LocalFollowGame

@Dao
interface LocalFollowsGameDao {

    @Query("SELECT * FROM local_follows_games")
    fun getAll(): List<LocalFollowGame>

    @Query("SELECT * FROM local_follows_games WHERE gameId = :id")
    fun getByGameId(id: String): LocalFollowGame?

    @Insert
    fun insert(video: LocalFollowGame)

    @Delete
    fun delete(video: LocalFollowGame)

    @Update
    fun update(video: LocalFollowGame)
}
