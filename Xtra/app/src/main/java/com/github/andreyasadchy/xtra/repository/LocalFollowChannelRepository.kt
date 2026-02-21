package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.db.LocalFollowsChannelDao
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel
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
        localFollowsChannelDao.insert(item)
    }

    suspend fun deleteFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        localFollowsChannelDao.delete(item)
    }

    suspend fun updateFollow(item: LocalFollowChannel) = withContext(Dispatchers.IO) {
        localFollowsChannelDao.update(item)
    }
}
