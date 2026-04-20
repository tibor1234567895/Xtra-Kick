package com.github.andreyasadchy.xtra.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.github.andreyasadchy.xtra.model.ui.MutedChatUser
import kotlinx.coroutines.flow.Flow

@Dao
interface MutedChatUsersDao {

    @Query("SELECT * FROM muted_chat_users")
    fun getAllFlow(): Flow<List<MutedChatUser>>

    @Query("SELECT * FROM muted_chat_users")
    fun getAll(): List<MutedChatUser>

    @Query(
        """
        SELECT * FROM muted_chat_users
        WHERE (:userId IS NOT NULL AND userId = :userId)
            OR (:userLogin IS NOT NULL AND userLogin = :userLogin)
            OR (:userName IS NOT NULL AND userName = :userName)
        """
    )
    fun getByUserIdOrLoginOrName(userId: String?, userLogin: String?, userName: String?): List<MutedChatUser>

    @Insert
    fun insert(item: MutedChatUser)

    @Delete
    fun delete(item: MutedChatUser)

    @Update
    fun update(item: MutedChatUser)
}
