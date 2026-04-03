package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.db.TranslateAllMessagesUsersDao
import com.github.andreyasadchy.xtra.model.ui.TranslateAllMessagesUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TranslateAllMessagesUsersRepository @Inject constructor(
    private val translateAllMessagesUsersDao: TranslateAllMessagesUsersDao,
) {

    suspend fun getByUserId(id: String) = withContext(Dispatchers.IO) {
        translateAllMessagesUsersDao.getByUserId(id)
    }

    suspend fun saveUser(item: TranslateAllMessagesUser) = withContext(Dispatchers.IO) {
        translateAllMessagesUsersDao.insert(item)
    }

    suspend fun deleteUser(item: TranslateAllMessagesUser) = withContext(Dispatchers.IO) {
        translateAllMessagesUsersDao.delete(item)
    }
}
