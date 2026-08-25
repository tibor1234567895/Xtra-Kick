package com.xtrakick.app.repository

import com.xtrakick.app.db.VodBookmarkIgnoredUsersDao
import com.xtrakick.app.model.ui.VodBookmarkIgnoredUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VodBookmarkIgnoredUsersRepository @Inject constructor(
    private val vodBookmarkIgnoredUsersDao: VodBookmarkIgnoredUsersDao,
) {

    fun loadUsersFlow() = vodBookmarkIgnoredUsersDao.getAllFlow()

    suspend fun loadUsers() = withContext(Dispatchers.IO) {
        vodBookmarkIgnoredUsersDao.getAll()
    }

    suspend fun getUserById(id: String) = withContext(Dispatchers.IO) {
        vodBookmarkIgnoredUsersDao.getById(id)
    }

    suspend fun saveUser(item: VodBookmarkIgnoredUser) = withContext(Dispatchers.IO) {
        vodBookmarkIgnoredUsersDao.insert(item)
    }

    suspend fun deleteUser(item: VodBookmarkIgnoredUser) = withContext(Dispatchers.IO) {
        vodBookmarkIgnoredUsersDao.delete(item)
    }
}
