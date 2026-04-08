package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.db.MutedChatUsersDao
import com.github.andreyasadchy.xtra.model.ui.MutedChatUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MutedChatUsersRepository @Inject constructor(
    private val mutedChatUsersDao: MutedChatUsersDao,
) {

    fun loadUsersFlow() = mutedChatUsersDao.getAllFlow()

    suspend fun loadUsers() = withContext(Dispatchers.IO) {
        dedupeUsers(mutedChatUsersDao.getAll())
    }

    suspend fun getMutedUser(userId: String?, userLogin: String?, userName: String?) = withContext(Dispatchers.IO) {
        findExistingUser(userId, userLogin, userName)
    }

    suspend fun saveMutedUser(item: MutedChatUser) = withContext(Dispatchers.IO) {
        upsertMutedUser(item.userId, item.userLogin, item.userName)
    }

    suspend fun deleteMutedUser(item: MutedChatUser) = withContext(Dispatchers.IO) {
        removeMutedUser(item.userId, item.userLogin, item.userName)
    }

    suspend fun upsertMutedUser(userId: String?, userLogin: String?, userName: String?) = withContext(Dispatchers.IO) {
        val normalizedUserId = userId?.takeIf { it.isNotBlank() }
        val normalizedUserLogin = userLogin?.takeIf { it.isNotBlank() }
        val normalizedUserName = userName?.takeIf { it.isNotBlank() }
        if (normalizedUserId == null && normalizedUserLogin == null && normalizedUserName == null) return@withContext
        val existing = findExistingUser(normalizedUserId, normalizedUserLogin, normalizedUserName)
        if (existing == null) {
            mutedChatUsersDao.insert(
                MutedChatUser(
                    userId = normalizedUserId,
                    userLogin = normalizedUserLogin,
                    userName = normalizedUserName,
                )
            )
        } else {
            existing.userId = normalizedUserId ?: existing.userId
            existing.userLogin = normalizedUserLogin ?: existing.userLogin
            existing.userName = normalizedUserName ?: existing.userName
            mutedChatUsersDao.update(existing)
        }
    }

    suspend fun removeMutedUser(userId: String?, userLogin: String?, userName: String?) = withContext(Dispatchers.IO) {
        findExistingUser(
            userId?.takeIf { it.isNotBlank() },
            userLogin?.takeIf { it.isNotBlank() },
            userName?.takeIf { it.isNotBlank() }
        )?.let(mutedChatUsersDao::delete)
    }

    private fun findExistingUser(userId: String?, userLogin: String?, userName: String?): MutedChatUser? {
        val matches = mutedChatUsersDao.getByUserIdOrLoginOrName(
            userId?.takeIf { it.isNotBlank() },
            userLogin?.takeIf { it.isNotBlank() },
            userName?.takeIf { it.isNotBlank() }
        )
        return dedupeUsers(matches).firstOrNull()
    }

    private fun dedupeUsers(items: List<MutedChatUser>): List<MutedChatUser> {
        if (items.isEmpty()) return items

        val deduped = ArrayList<MutedChatUser>()
        val seenIds = HashMap<String, MutedChatUser>()
        val seenLogins = HashMap<String, MutedChatUser>()
        val seenNames = HashMap<String, MutedChatUser>()

        items.forEach { item ->
            val idKey = item.userId?.trim()?.takeIf { it.isNotEmpty() }
            val loginKey = item.userLogin?.trim()?.lowercase()?.takeIf { it.isNotEmpty() }
            val nameKey = item.userName?.trim()?.lowercase()?.takeIf { it.isNotEmpty() }
            val existing = idKey?.let(seenIds::get) ?: loginKey?.let(seenLogins::get) ?: nameKey?.let(seenNames::get)

            if (existing == null) {
                deduped += item
                idKey?.let { seenIds[it] = item }
                loginKey?.let { seenLogins[it] = item }
                nameKey?.let { seenNames[it] = item }
            } else {
                val mergedId = existing.userId ?: item.userId
                val mergedLogin = existing.userLogin ?: item.userLogin
                val mergedName = existing.userName ?: item.userName

                var changed = false
                if (existing.userId != mergedId) {
                    existing.userId = mergedId
                    changed = true
                }
                if (existing.userLogin != mergedLogin) {
                    existing.userLogin = mergedLogin
                    changed = true
                }
                if (existing.userName != mergedName) {
                    existing.userName = mergedName
                    changed = true
                }
                if (changed) {
                    mutedChatUsersDao.update(existing)
                }

                idKey?.let { seenIds[it] = existing }
                loginKey?.let { seenLogins[it] = existing }
                nameKey?.let { seenNames[it] = existing }
                mutedChatUsersDao.delete(item)
            }
        }

        return deduped
    }
}
