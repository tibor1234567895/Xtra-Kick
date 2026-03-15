package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.db.ShownNotificationsDao
import com.github.andreyasadchy.xtra.model.ShownNotification
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.TwitchApiHelper
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShownNotificationsRepository @Inject constructor(
    private val shownNotificationsDao: ShownNotificationsDao,
    private val kickRepository: KickRepository,
) {

    suspend fun getNewKickStreams(
        notificationUsersRepository: NotificationUsersRepository,
    ): List<Stream> = withContext(Dispatchers.IO) {
        val channelIds = notificationUsersRepository.loadUsers()
            .mapNotNull { it.channelId?.takeIf { id -> id.isNotBlank() } }
            .distinct()
        if (channelIds.isEmpty()) {
            return@withContext emptyList()
        }
        val semaphore = Semaphore(8)
        val list = coroutineScope {
            channelIds.map { channelId ->
                async {
                    semaphore.withPermit {
                        val channel = runCatching { this@ShownNotificationsRepository.kickRepository.getChannel(channelId) }.getOrNull() ?: return@withPermit null
                        channel.livestream?.let { this@ShownNotificationsRepository.kickRepository.toStream(channel) }
                    }
                }
            }.awaitAll()
        }.filterNotNull()
            .distinctBy { it.channelId ?: it.channelLogin ?: it.id }

        val liveList = list.mapNotNull { stream ->
            stream.channelId.takeUnless { it.isNullOrBlank() }?.let { channelId ->
                stream.startedAt.takeUnless { it.isNullOrBlank() }?.let { TwitchApiHelper.parseIso8601DateUTC(it) }?.let { startedAt ->
                    ShownNotification(channelId, startedAt)
                }
            }
        }
        val oldList = shownNotificationsDao.getAll()
        val oldByChannelId = oldList.associateBy { it.channelId }
        val liveByChannelId = liveList.associateBy { it.channelId }
        oldList.filter { item -> !liveByChannelId.containsKey(item.channelId) }.let {
            shownNotificationsDao.deleteList(it)
        }
        shownNotificationsDao.insertList(liveList)
        val newStreams = liveList.mapNotNull { item ->
            item.takeIf { oldByChannelId[item.channelId]?.startedAt?.let { it < item.startedAt } != false }?.channelId
        }.toSet()
        list.filter { it.channelId in newStreams }
    }

    suspend fun getNewStreams(notificationUsersRepository: NotificationUsersRepository, networkLibrary: String?, gqlHeaders: Map<String, String>, graphQLRepository: GraphQLRepository, helixHeaders: Map<String, String>, helixRepository: HelixRepository): List<Stream> = withContext(Dispatchers.IO) {
        getNewKickStreams(notificationUsersRepository)
    }

    private suspend fun gqlQueryLoad(networkLibrary: String?, gqlHeaders: Map<String, String>, graphQLRepository: GraphQLRepository): List<Stream> {
        val list = mutableListOf<Stream>()
        var offset: String? = null
        do {
            val response = graphQLRepository.loadQueryUserFollowedStreams(networkLibrary, gqlHeaders, 100, offset)
            val data = response.data!!.user!!.followedLiveUsers!!
            val items = data.edges!!
            items.mapNotNull { item ->
                item?.node?.let {
                    if (it.self?.follower?.notificationSettings?.isEnabled == true) {
                        Stream(
                            id = it.stream?.id,
                            channelId = it.id,
                            channelLogin = it.login,
                            channelName = it.displayName,
                            gameId = it.stream?.game?.id,
                            gameSlug = it.stream?.game?.slug,
                            gameName = it.stream?.game?.displayName,
                            title = it.stream?.broadcaster?.broadcastSettings?.title,
                            viewerCount = it.stream?.viewersCount,
                            startedAt = it.stream?.createdAt?.toString(),
                            thumbnailUrl = it.stream?.previewImageURL,
                            profileImageUrl = it.profileImageURL,
                            tags = it.stream?.freeformTags?.mapNotNull { tag -> tag.name }
                        )
                    } else null
                }
            }.let { list.addAll(it) }
            offset = items.lastOrNull()?.cursor?.toString()
        } while (!items.lastOrNull()?.cursor?.toString().isNullOrBlank() && data.pageInfo?.hasNextPage == true)
        return list
    }

    private suspend fun gqlQueryLocal(networkLibrary: String?, gqlHeaders: Map<String, String>, ids: List<String>, graphQLRepository: GraphQLRepository): List<Stream> {
        val items = ids.chunked(100).map { list ->
            graphQLRepository.loadQueryUsersStream(networkLibrary, gqlHeaders, list)
        }.flatMap { it.data!!.users!! }
        val list = items.mapNotNull { item ->
            item?.let {
                if (it.stream?.viewersCount != null) {
                    Stream(
                        id = it.stream.id,
                        channelId = it.id,
                        channelLogin = it.login,
                        channelName = it.displayName,
                        gameId = it.stream.game?.id,
                        gameSlug = it.stream.game?.slug,
                        gameName = it.stream.game?.displayName,
                        title = it.stream.broadcaster?.broadcastSettings?.title,
                        viewerCount = it.stream.viewersCount,
                        startedAt = it.stream.createdAt?.toString(),
                        thumbnailUrl = it.stream.previewImageURL,
                        profileImageUrl = it.profileImageURL,
                        tags = it.stream.freeformTags?.mapNotNull { tag -> tag.name }
                    )
                } else null
            }
        }
        return list
    }

    private suspend fun helixLocal(networkLibrary: String?, helixHeaders: Map<String, String>, ids: List<String>, helixRepository: HelixRepository): List<Stream> {
        val items = ids.chunked(100).map {
            helixRepository.getStreams(
                networkLibrary = networkLibrary,
                headers = helixHeaders,
                ids = it
            )
        }.flatMap { it.data }
        val users = items.mapNotNull { it.channelId }.chunked(100).map {
            helixRepository.getUsers(
                networkLibrary = networkLibrary,
                headers = helixHeaders,
                ids = it
            )
        }.flatMap { it.data }
        val list = items.mapNotNull {
            if (it.viewerCount != null) {
                Stream(
                    id = it.id,
                    channelId = it.channelId,
                    channelLogin = it.channelLogin,
                    channelName = it.channelName,
                    gameId = it.gameId,
                    gameName = it.gameName,
                    title = it.title,
                    viewerCount = it.viewerCount,
                    startedAt = it.startedAt,
                    thumbnailUrl = it.thumbnailUrl,
                    profileImageUrl = it.channelId?.let { id ->
                        users.find { user -> user.channelId == id }?.profileImageUrl
                    },
                    tags = it.tags
                )
            } else null
        }
        return list
    }

    suspend fun saveList(list: List<ShownNotification>) = withContext(Dispatchers.IO) {
        shownNotificationsDao.insertList(list)
    }
}
