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
        localFollowsChannelDao.getAll()
    }

    suspend fun getFollowByUserId(id: String) = withContext(Dispatchers.IO) {
        localFollowsChannelDao.getByUserId(id)
    }

    suspend fun saveFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        upsertLocalFollow(item.userId, item.userLogin, item.userName, item.channelLogo)
    }

    suspend fun deleteFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        removeLocalFollow(item.userId ?: item.userLogin)
    }

    suspend fun updateFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        localFollowsChannelDao.update(item)
    }

    suspend fun upsertLocalFollow(
        userId: String?,
        userLogin: String?,
        userName: String?,
        channelLogo: String? = null,
    ) = withContext(Dispatchers.IO) {
        val key = userId?.takeIf { it.isNotBlank() } ?: userLogin?.takeIf { it.isNotBlank() }
        if (key.isNullOrBlank()) return@withContext
        val existing = localFollowsChannelDao.getByUserId(key)
        if (existing == null) {
            localFollowsChannelDao.insert(
                LocalFollowChannel(
                    userId = userId,
                    userLogin = userLogin,
                    userName = userName,
                    channelLogo = channelLogo,
                    sourceMask = C.FOLLOW_SOURCE_MASK_LOCAL,
                )
            )
        } else {
            existing.userLogin = userLogin ?: existing.userLogin
            existing.userName = userName ?: existing.userName
            existing.channelLogo = channelLogo ?: existing.channelLogo
            existing.sourceMask = C.FOLLOW_SOURCE_MASK_LOCAL
            localFollowsChannelDao.update(existing)
        }
    }

    suspend fun removeLocalFollow(userIdOrLogin: String?) = withContext(Dispatchers.IO) {
        val key = userIdOrLogin?.takeIf { it.isNotBlank() } ?: return@withContext
        localFollowsChannelDao.getByUserId(key)?.let { existing ->
            localFollowsChannelDao.delete(existing)
        }
    }
}
