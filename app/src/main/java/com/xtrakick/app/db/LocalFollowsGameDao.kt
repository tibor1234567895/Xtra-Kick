package com.xtrakick.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xtrakick.app.model.ui.LocalFollowGame

@Dao
interface LocalFollowsGameDao {

    @Query("SELECT * FROM local_follows_games")
    fun getAll(): List<LocalFollowGame>

    @Query("SELECT * FROM local_follows_games WHERE gameId = :id")
    fun getByGameId(id: String): LocalFollowGame?

    @Query(
        """
        SELECT * FROM local_follows_games
        WHERE (:id IS NOT NULL AND gameId = :id)
            OR (:slug IS NOT NULL AND gameSlug = :slug)
        LIMIT 1
        """
    )
    fun getByIdOrSlug(id: String?, slug: String?): LocalFollowGame?

    @Insert
    fun insert(video: LocalFollowGame)

    @Delete
    fun delete(video: LocalFollowGame)

    @Update
    fun update(video: LocalFollowGame)

    @Update
    fun updateAll(items: List<LocalFollowGame>)
}
