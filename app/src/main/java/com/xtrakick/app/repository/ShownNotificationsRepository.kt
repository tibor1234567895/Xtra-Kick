package com.xtrakick.app.repository

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.xtrakick.app.db.ShownNotificationsDao
import com.xtrakick.app.model.ShownNotification
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.R
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
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
        val results = coroutineScope {
            channelIds.map { channelId ->
                async {
                    semaphore.withPermit {
                        // Notifications render a title and an icon, never badges. Leaving the
                        // default on fired a badge-catalog prefetch for every followed channel
                        // on every poll — 8 concurrent channels turning a background check into
                        // 100+ requests. FollowedLiveStreamsRepository already passes false.
                        val channel = runCatching {
                            this@ShownNotificationsRepository.kickRepository.getChannel(channelId, prefetchBadgeCatalog = false)
                        }.getOrNull()
                        // The Boolean records whether the fetch itself succeeded, so failed
                        // fetches never wipe a channel's dedupe row (which used to re-notify
                        // currently-live streams on the next healthy poll).
                        channel?.let { this@ShownNotificationsRepository.kickRepository.toStream(it) } to (channel != null)
                    }
                }
            }.awaitAll()
        }
        val fetchedKeys = channelIds.filterIndexed { index, _ -> results[index].second }.toSet()
        if (fetchedKeys.isEmpty()) {
            // Every fetch failed (Kick 429, offline). Keep the dedupe table untouched and
            // try again next window instead of treating everything as new.
            return@withContext emptyList()
        }
        val list = results.mapNotNull { it.first }
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
        // Only sync dedupe rows of channels this poll actually fetched: a transient failure
        // for one channel must not delete its row.
        oldList.filter { item -> item.channelId in fetchedKeys && !liveByChannelId.containsKey(item.channelId) }.let {
            shownNotificationsDao.deleteList(it)
        }
        shownNotificationsDao.insertList(liveList)
        val newStreams = liveList.mapNotNull { item ->
            item.takeIf { oldByChannelId[item.channelId]?.startedAt?.let { it < item.startedAt } != false }?.channelId
        }.toSet()
        list.filter { it.channelId in newStreams }
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
                        when (context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
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
        const val GROUP_KEY = "com.xtrakick.app.LIVE_NOTIFICATIONS"

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
