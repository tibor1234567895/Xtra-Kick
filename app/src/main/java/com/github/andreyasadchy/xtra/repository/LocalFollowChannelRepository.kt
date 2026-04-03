package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.db.LocalFollowsChannelDao
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel
import com.github.andreyasadchy.xtra.util.C
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalFollowChannelRepository @Inject constructor(
    private val localFollowsChannelDao: LocalFollowsChannelDao,
) {

    suspend fun loadFollows() = withContext(Dispatchers.IO) {
        dedupeFollows(localFollowsChannelDao.getAll())
    }

    suspend fun getFollow(userId: String?, userLogin: String?) = withContext(Dispatchers.IO) {
        findExistingFollow(userId, userLogin)
    }

    suspend fun getFollowByUserId(id: String) = withContext(Dispatchers.IO) {
        findExistingFollow(id, id)
    }

    suspend fun saveFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        upsertLocalFollow(item.userId, item.userLogin, item.userName, item.channelLogo)
    }

    suspend fun deleteFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        removeLocalFollow(item.userId, item.userLogin)
    }

    suspend fun updateFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        localFollowsChannelDao.update(item)
    }

    suspend fun deleteAllFollows() = withContext(Dispatchers.IO) {
        localFollowsChannelDao.deleteAll()
    }

    suspend fun upsertLocalFollow(
        userId: String?,
        userLogin: String?,
        userName: String?,
        channelLogo: String? = null,
    ) = withContext(Dispatchers.IO) {
        val normalizedUserId = userId?.takeIf { it.isNotBlank() }
        val normalizedUserLogin = userLogin?.takeIf { it.isNotBlank() }
        if (normalizedUserId == null && normalizedUserLogin == null) return@withContext
        val existing = findExistingFollow(normalizedUserId, normalizedUserLogin)
        if (existing == null) {
            localFollowsChannelDao.insert(
                LocalFollowChannel(
                    userId = normalizedUserId,
                    userLogin = normalizedUserLogin,
                    userName = userName,
                    channelLogo = channelLogo,
                    sourceMask = C.FOLLOW_SOURCE_MASK_LOCAL,
                )
            )
        } else {
            existing.userId = normalizedUserId ?: existing.userId
            existing.userLogin = normalizedUserLogin ?: existing.userLogin
            existing.userName = userName ?: existing.userName
            existing.channelLogo = channelLogo ?: existing.channelLogo
            existing.sourceMask = existing.sourceMask or C.FOLLOW_SOURCE_MASK_LOCAL
            localFollowsChannelDao.update(existing)
        }
    }

    suspend fun removeLocalFollow(userId: String?, userLogin: String?) = withContext(Dispatchers.IO) {
        findExistingFollow(userId?.takeIf { it.isNotBlank() }, userLogin?.takeIf { it.isNotBlank() })?.let { existing ->
            localFollowsChannelDao.delete(existing)
        }
    }

    private fun findExistingFollow(userId: String?, userLogin: String?): LocalFollowChannel? {
        val matches = localFollowsChannelDao.getByUserIdOrLogin(
            userId?.takeIf { it.isNotBlank() },
            userLogin?.takeIf { it.isNotBlank() }
        )
        return dedupeFollows(matches).firstOrNull()
    }

    private fun dedupeFollows(items: List<LocalFollowChannel>): List<LocalFollowChannel> {
        if (items.isEmpty()) return items

        val deduped = ArrayList<LocalFollowChannel>()
        val seenIds = HashMap<String, LocalFollowChannel>()
        val seenLogins = HashMap<String, LocalFollowChannel>()

        items.forEach { item ->
            val idKey = item.userId?.trim()?.takeIf { it.isNotEmpty() }
            val loginKey = item.userLogin?.trim()?.lowercase()?.takeIf { it.isNotEmpty() }
            val existing = idKey?.let(seenIds::get) ?: loginKey?.let(seenLogins::get)

            if (existing == null) {
                deduped += item
                idKey?.let { seenIds[it] = item }
                loginKey?.let { seenLogins[it] = item }
            } else {
                val mergedId = existing.userId ?: item.userId
                val mergedLogin = existing.userLogin ?: item.userLogin
                val mergedName = existing.userName ?: item.userName
                val mergedLogo = existing.channelLogo ?: item.channelLogo
                val mergedSourceMask = existing.sourceMask or item.sourceMask

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
                if (existing.channelLogo != mergedLogo) {
                    existing.channelLogo = mergedLogo
                    changed = true
                }
                if (existing.sourceMask != mergedSourceMask) {
                    existing.sourceMask = mergedSourceMask
                    changed = true
                }

                if (changed) {
                    localFollowsChannelDao.update(existing)
                }

                idKey?.let { seenIds[it] = existing }
                loginKey?.let { seenLogins[it] = existing }
                localFollowsChannelDao.delete(item)
            }
        }

        return deduped
    }
}
