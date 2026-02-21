package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.db.NotificationUsersDao
import com.github.andreyasadchy.xtra.model.NotificationUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationUsersRepository @Inject constructor(
    private val notificationUsersDao: NotificationUsersDao,
) {

    suspend fun loadUsers() = withContext(Dispatchers.IO) {
        notificationUsersDao.getAll()
    }

    suspend fun getByUserId(id: String) = withContext(Dispatchers.IO) {
        notificationUsersDao.getByUserId(id)
    }

    suspend fun saveUser(item: NotificationUser) = withContext(Dispatchers.IO) {
        notificationUsersDao.insert(item)
    }

    suspend fun deleteUser(item: NotificationUser) = withContext(Dispatchers.IO) {
        notificationUsersDao.delete(item)
    }
}
