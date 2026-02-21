package com.github.andreyasadchy.xtra.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.andreyasadchy.xtra.model.ui.TranslateAllMessagesUser

@Dao
interface TranslateAllMessagesUsersDao {

    @Query("SELECT * FROM translate_all_messages WHERE channelId = :id")
    fun getByUserId(id: String): TranslateAllMessagesUser?

    @Insert()
    fun insert(item: TranslateAllMessagesUser)

    @Delete
    fun delete(item: TranslateAllMessagesUser)
}