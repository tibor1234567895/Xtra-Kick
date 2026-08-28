package com.xtrakick.app.repository

import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.model.NotificationUser
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationUsersRepository @Inject constructor(
    private val notificationUsersDao: NotificationUsersDao,
    private val kickRepository: KickRepository,
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

    suspend fun deleteAllUsers() = withContext(Dispatchers.IO) {
        notificationUsersDao.deleteAll()
    }

    suspend fun deleteUser(item: NotificationUser) = withContext(Dispatchers.IO) {
        notificationUsersDao.delete(item)
    }

    /**
     * One-time cleanup for rows written before the canonical-key fix (issues #44/#58): they
     * may be keyed by the channel login instead of its numeric id — invisible to the
     * channel-page bell while the worker keeps polling them. Re-keys every non-numeric row
     * to the resolved id. Unresolved rows (offline/failed fetch) are left for the next app
     * start. Cheap when there is nothing to migrate: the DAO scan short-circuits first.
     */
    suspend fun migrateLegacyKeys() = withContext(Dispatchers.IO) {
        val legacy = notificationUsersDao.getAll().filter { it.channelId.trim().toIntOrNull() == null }
        if (legacy.isEmpty()) return@withContext
        Log.i(TAG, "migrating ${legacy.size} legacy notification key(s)")
        for (item in legacy) {
            val login = item.channelId.trim()
            val channel = runCatching {
                kickRepository.getChannel(login, prefetchBadgeCatalog = false)
            }.getOrNull()
            val id = channel?.id?.toString()
            if (id.isNullOrBlank() || id == login) continue
            notificationUsersDao.delete(item)
            notificationUsersDao.insert(NotificationUser(id))
        }
    }

    private companion object {
        private const val TAG = "NotificationUsers"
    }
}
