package com.xtrakick.app.repository

import com.xtrakick.app.db.LocalFollowsGameDao
import com.xtrakick.app.model.ui.LocalFollowGame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalFollowGameRepository @Inject constructor(
    private val localFollowsGameDao: LocalFollowsGameDao,
) {

    suspend fun loadFollows() = withContext(Dispatchers.IO) {
        localFollowsGameDao.getAll()
    }

    suspend fun getFollowByGameId(id: String) = withContext(Dispatchers.IO) {
        localFollowsGameDao.getByGameId(id)
    }

    suspend fun saveFollow(item: LocalFollowGame) = withContext(Dispatchers.IO) {
        localFollowsGameDao.insert(item)
    }

    suspend fun deleteFollow(item: LocalFollowGame) = withContext(Dispatchers.IO) {
        item.boxArt?.let {
            if (it.isNotBlank()) {
                File(it).delete()
            }
        }
        localFollowsGameDao.delete(item)
    }

    suspend fun updateFollow(item: LocalFollowGame) = withContext(Dispatchers.IO) {
        localFollowsGameDao.update(item)
    }
}
