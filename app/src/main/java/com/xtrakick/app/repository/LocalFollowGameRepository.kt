package com.xtrakick.app.repository

import com.xtrakick.app.db.LocalFollowsGameDao
import com.xtrakick.app.model.ui.LocalFollowGame
import com.xtrakick.app.util.KickApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalFollowGameRepository @Inject constructor(
    private val localFollowsGameDao: LocalFollowsGameDao,
) {

    private val _followsChanged = MutableSharedFlow<Unit>(extraBufferCapacity = 1)
    val followsChanged: SharedFlow<Unit> = _followsChanged.asSharedFlow()

    fun notifyFollowsChanged() {
        _followsChanged.tryEmit(Unit)
    }

    suspend fun loadFollows() = withContext(Dispatchers.IO) {
        localFollowsGameDao.getAll()
    }

    suspend fun getFollowByGameId(id: String) = withContext(Dispatchers.IO) {
        localFollowsGameDao.getByGameId(id)
    }

    suspend fun getFollowByIdOrSlug(id: String?, slug: String?) = withContext(Dispatchers.IO) {
        val cleanSlug = slug?.trim()?.takeIf { it.isNotBlank() }
        val sanitizedId = KickApiHelper.sanitizeGameId(id, cleanSlug)
        if (sanitizedId.isNullOrBlank() && cleanSlug.isNullOrBlank()) null
        else localFollowsGameDao.getByIdOrSlug(sanitizedId, cleanSlug)
    }

    suspend fun saveFollow(item: LocalFollowGame) = withContext(Dispatchers.IO) {
        item.gameId = KickApiHelper.sanitizeGameId(item.gameId, item.gameSlug)
        localFollowsGameDao.insert(item)
        _followsChanged.tryEmit(Unit)
    }

    suspend fun deleteFollow(item: LocalFollowGame) = withContext(Dispatchers.IO) {
        item.boxArt?.let {
            if (it.isNotBlank() && it.startsWith("/")) {
                File(it).delete()
            }
        }
        localFollowsGameDao.delete(item)
        _followsChanged.tryEmit(Unit)
    }

    suspend fun updateFollow(item: LocalFollowGame, notify: Boolean = true) = withContext(Dispatchers.IO) {
        localFollowsGameDao.update(item)
        if (notify) {
            _followsChanged.tryEmit(Unit)
        }
    }

    suspend fun updateFollows(items: List<LocalFollowGame>, notify: Boolean = true) = withContext(Dispatchers.IO) {
        if (items.isEmpty()) return@withContext
        localFollowsGameDao.updateAll(items)
        if (notify) {
            _followsChanged.tryEmit(Unit)
        }
    }
}
