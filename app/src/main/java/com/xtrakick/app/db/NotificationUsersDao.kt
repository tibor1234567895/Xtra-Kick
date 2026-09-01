package com.xtrakick.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.xtrakick.app.model.NotificationUser

@Dao
interface NotificationUsersDao {

    @Query("SELECT * FROM notifications")
    fun getAll(): List<NotificationUser>

    @Query("SELECT * FROM notifications WHERE channelId = :id")
    fun getByUserId(id: String): NotificationUser?

    @Query("SELECT * FROM notifications WHERE channelId IN (:keys)")
    fun getByKeys(keys: List<String>): List<NotificationUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: NotificationUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(items: List<NotificationUser>)

    @Query("DELETE FROM notifications")
    fun deleteAll()

    @Delete
    fun delete(item: NotificationUser)

    @Query("DELETE FROM notifications WHERE channelId IN (:keys)")
    fun deleteByKeys(keys: List<String>): Int

    /** Re-key a legacy row atomically so a crash can't drop the notification entry. */
    @Transaction
    fun rekey(item: NotificationUser, newItem: NotificationUser) {
        delete(item)
        insert(newItem)
    }
}
