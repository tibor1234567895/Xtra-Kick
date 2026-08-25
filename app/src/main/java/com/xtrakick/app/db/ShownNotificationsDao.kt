package com.xtrakick.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xtrakick.app.model.ShownNotification

@Dao
interface ShownNotificationsDao {

    @Query("SELECT * FROM shown_notifications")
    fun getAll(): List<ShownNotification>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(items: List<ShownNotification>)

    @Query("DELETE FROM shown_notifications")
    fun deleteAll()

    @Delete
    fun deleteList(items: List<ShownNotification>)
}
