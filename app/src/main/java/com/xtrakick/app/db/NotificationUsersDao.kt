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
    fun getByKeysChunk(keys: List<String>): List<NotificationUser>

    @Transaction
    fun getByKeys(keys: List<String>): List<NotificationUser> {
        if (keys.isEmpty()) return emptyList()
        return keys.chunked(500).flatMap(::getByKeysChunk)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: NotificationUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(items: List<NotificationUser>)

    @Query("DELETE FROM notifications")
    fun deleteAll()

    @Delete
    fun delete(item: NotificationUser)

    @Query("DELETE FROM notifications WHERE channelId IN (:keys)")
    fun deleteByKeysChunk(keys: List<String>): Int

    @Transaction
    fun deleteByKeys(keys: List<String>): Int {
        if (keys.isEmpty()) return 0
        return keys.chunked(500).sumOf(::deleteByKeysChunk)
    }

    /** Atomically replace all notification subscriptions. */
    @Transaction
    fun replaceAll(items: List<NotificationUser>) {
        deleteAll()
        if (items.isNotEmpty()) {
            insertList(items)
        }
    }

    /** Re-key a legacy row atomically so a crash can't drop the notification entry. */
    @Transaction
    fun rekey(item: NotificationUser, newItem: NotificationUser) {
        delete(item)
        insert(newItem)
    }
}
