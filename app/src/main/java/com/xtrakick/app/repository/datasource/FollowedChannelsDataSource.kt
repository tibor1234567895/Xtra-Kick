package com.xtrakick.app.repository.datasource

import android.os.SystemClock
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap

class FollowedChannelsDataSource(
    private val sort: String,
    private val order: String,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val kickRepository: KickRepository? = null,
    private val avatarScope: CoroutineScope,
    private val elapsedTimeMs: () -> Long = { SystemClock.elapsedRealtime() },
) : PagingSource<Int, User>() {

    companion object {
        private const val AVATAR_RETRY_DELAY_MS = 60_000L
        private val avatarRetryAfter = ConcurrentHashMap<String, Long>()
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val follows = localFollowsChannel.loadFollows()
        kickRepository?.let { repo ->
            if (!avatarScope.isActive) return@let
            val now = elapsedTimeMs()
            val missing = follows.mapNotNull { follow ->
                if (!follow.channelLogo.isNullOrBlank()) return@mapNotNull null
                val login = follow.userLogin?.trim()?.takeIf { it.isNotBlank() }
                    ?.lowercase(Locale.ROOT) ?: return@mapNotNull null
                val retryAfter = avatarRetryAfter[login]
                val reserved = if (retryAfter == null) {
                    avatarRetryAfter.putIfAbsent(login, Long.MAX_VALUE) == null
                } else {
                    retryAfter <= now && avatarRetryAfter.replace(login, retryAfter, Long.MAX_VALUE)
                }
                if (reserved) login to follow else null
            }.toMap()
            if (missing.isNotEmpty()) {
                val pendingLogins = ConcurrentHashMap.newKeySet<String>().apply {
                    addAll(missing.keys)
                }
                val job = avatarScope.launch(Dispatchers.IO) {
                    for ((login, follow) in missing) {
                        ensureActive()
                        try {
                            val channelResp = repo.getChannel(login, prefetchBadgeCatalog = false, forceRefresh = true)
                            val pic = channelResp.user?.profileImage
                            if (!pic.isNullOrBlank()) {
                                val current = localFollowsChannel.getFollow(follow.userId, follow.userLogin)
                                if (current != null && current.channelLogo.isNullOrBlank()) {
                                    current.channelLogo = pic
                                    localFollowsChannel.updateFollow(current)
                                }
                            }
                        } catch (error: CancellationException) {
                            throw error
                        } catch (_: Exception) {
                        } finally {
                            avatarRetryAfter[login] = elapsedTimeMs() + AVATAR_RETRY_DELAY_MS
                            pendingLogins.remove(login)
                        }
                    }
                }
                job.invokeOnCompletion {
                    pendingLogins.forEach { avatarRetryAfter.remove(it, Long.MAX_VALUE) }
                }
            }
        }
        val list = follows.map { FollowedChannelRow(it.toUser(), it.id) }
        val sorted = list.sortedForFilter().map { it.user }

        return LoadResult.Page(
            data = sorted,
            prevKey = null,
            nextKey = null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private fun LocalFollowChannel.toUser(): User {
        return User(
            channelId = userId,
            channelLogin = userLogin,
            channelName = userName ?: userLogin,
            profileImageUrl = channelLogo,
            followLocal = isLocalOnlyFollow,
            followAccount = isKickFollow,
        )
    }

    private fun List<FollowedChannelRow>.sortedForFilter(): List<FollowedChannelRow> {
        val nameComparator = compareBy<FollowedChannelRow, String?>(nullsLast(String.CASE_INSENSITIVE_ORDER)) { it.user.channelLogin }
            .thenBy(nullsLast(String.CASE_INSENSITIVE_ORDER)) { it.user.channelName }
        return when (sort) {
            "created_at" -> {
                if (order == "asc") sortedBy { it.followId } else sortedByDescending { it.followId }
            }
            "login" -> {
                if (order == "asc") sortedWith(nameComparator) else sortedWith(nameComparator.reversed())
            }
            "source" -> {
                // Asc = Kick-account follows first, desc = local follows first;
                // each group stays alphabetical.
                val alphabetical = sortedWith(nameComparator)
                val (kick, local) = alphabetical.partition { it.user.followAccount }
                if (order == "asc") kick + local else local + kick
            }
            else -> {
                sortedWith(nameComparator)
            }
        }
    }

    private data class FollowedChannelRow(
        val user: User,
        val followId: Int,
    )
}
