package com.github.andreyasadchy.xtra.repository

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.github.andreyasadchy.xtra.db.ShownNotificationsDao
import com.github.andreyasadchy.xtra.model.ShownNotification
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
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
            .mapNotNull { it.channelId.takeIf { id -> id.isNotBlank() } }
            .distinct()
        if (channelIds.isEmpty()) {
            return@withContext emptyList()
        }
        val semaphore = Semaphore(8)
        val list = coroutineScope {
            channelIds.map { channelId ->
                async {
                    semaphore.withPermit {
                        // Notifications render a title and an icon, never badges. Leaving the
                        // default on fired a badge-catalog prefetch for every followed channel
                        // on every poll — 8 concurrent channels turning a background check into
                        // 100+ requests. FollowedLiveStreamsRepository already passes false.
                        val channel = runCatching {
                            this@ShownNotificationsRepository.kickRepository.getChannel(channelId, prefetchBadgeCatalog = false)
                        }.getOrNull() ?: return@withPermit null
                        channel.livestream?.let { this@ShownNotificationsRepository.kickRepository.toStream(channel) }
                    }
                }
            }.awaitAll()
        }.filterNotNull()
            .distinctBy { it.channelId ?: it.channelLogin ?: it.id }

        val liveList = list.mapNotNull { stream ->
            stream.channelId.takeUnless { it.isNullOrBlank() }?.let { channelId ->
                stream.startedAt.takeUnless { it.isNullOrBlank() }?.let { KickApiHelper.parseIso8601DateUTC(it) }?.let { startedAt ->
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

    suspend fun getNewStreams(notificationUsersRepository: NotificationUsersRepository, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickGraphQLRepository: KickGraphQLRepository, kickPublicApiHeaders: Map<String, String>, kickPublicApiRepository: KickPublicApiRepository): List<Stream> = withContext(Dispatchers.IO) {
        getNewKickStreams(notificationUsersRepository)
    }

    private suspend fun kickWebQueryLoad(networkLibrary: String?, kickWebHeaders: Map<String, String>, kickGraphQLRepository: KickGraphQLRepository): List<Stream> {
        val list = mutableListOf<Stream>()
        var offset: String? = null
        do {
            val response = kickGraphQLRepository.loadQueryUserFollowedStreams(networkLibrary, kickWebHeaders, 100, offset)
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

    private suspend fun kickWebQueryLocal(networkLibrary: String?, kickWebHeaders: Map<String, String>, ids: List<String>, kickGraphQLRepository: KickGraphQLRepository): List<Stream> {
        val items = ids.chunked(100).map { list ->
            kickGraphQLRepository.loadQueryUsersStream(networkLibrary, kickWebHeaders, list)
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

    private suspend fun kickPublicApiLocal(networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, ids: List<String>, kickPublicApiRepository: KickPublicApiRepository): List<Stream> {
        val items = ids.chunked(100).map {
            kickPublicApiRepository.getStreams(
                networkLibrary = networkLibrary,
                headers = kickPublicApiHeaders,
                ids = it
            )
        }.flatMap { it.data }
        val users = items.mapNotNull { it.channelId }.chunked(100).map {
            kickPublicApiRepository.getUsers(
                networkLibrary = networkLibrary,
                headers = kickPublicApiHeaders,
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

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        shownNotificationsDao.deleteAll()
    }

    fun showLiveNotifications(context: Context, streams: List<Stream>) {
        if (streams.isEmpty()) return

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = context.getString(R.string.notification_live_channel_id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (notificationManager.getNotificationChannel(channelId) == null) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        channelId,
                        ContextCompat.getString(context, R.string.notification_live_channel_title),
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                )
            }
        }

        streams.forEach { stream ->
            val notificationId = notificationIdFor(stream)
            val notification = NotificationCompat.Builder(context, channelId).apply {
                setGroup(GROUP_KEY)
                setContentTitle(ContextCompat.getString(context, R.string.live_notification).format(
                    if (stream.channelLogin != null && !stream.channelLogin.equals(stream.channelName, true)) {
                        when (context.prefs().getString(C.UI_NAME_DISPLAY, "1")) {
                            "0" -> "${stream.channelName}(${stream.channelLogin})"
                            "1" -> stream.channelName
                            else -> stream.channelLogin
                        }
                    } else {
                        stream.channelName
                    }
                ))
                setContentText(stream.title)
                setSmallIcon(R.drawable.notification_icon)
                setAutoCancel(true)
                setContentIntent(
                    PendingIntent.getActivity(
                        context,
                        notificationId,
                        Intent(context, MainActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                            action = MainActivity.INTENT_LIVE_NOTIFICATION
                            putExtra(MainActivity.KEY_VIDEO, stream)
                        },
                        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                    )
                )
            }.build()
            notificationManager.notify(notificationId, notification)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val summaryNotification = NotificationCompat.Builder(context, channelId).apply {
                setGroup(GROUP_KEY)
                setSmallIcon(R.drawable.notification_icon)
                setGroupSummary(true)
            }.build()
            notificationManager.notify(SUMMARY_NOTIFICATION_ID, summaryNotification)
        }
    }

    companion object {
        const val GROUP_KEY = "com.github.andreyasadchy.xtra.LIVE_NOTIFICATIONS"

        /**
         * Sentinel outside the practical range of String.hashCode() for channel ids, so a
         * per-stream notification can never collide with the group summary by construction.
         */
        internal const val SUMMARY_NOTIFICATION_ID = Int.MIN_VALUE

        /**
         * Stable per-stream notification id, used for both the notification itself and its
         * PendingIntent request code.
         *
         * [Stream.channelId] is nullable and Kotlin's `null.hashCode()` is 0 — which used to be
         * the group summary's id. So a null-channelId stream replaced the summary, and any two
         * such streams shared request code 0: with FLAG_UPDATE_CURRENT the second overwrote the
         * first's KEY_VIDEO extra, and tapping notification A opened channel B.
         */
        internal fun notificationIdFor(stream: Stream): Int =
            (stream.channelId ?: stream.channelLogin ?: stream.id).hashCode()
    }
}
