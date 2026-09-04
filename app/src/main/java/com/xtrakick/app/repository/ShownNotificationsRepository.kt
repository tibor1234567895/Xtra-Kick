package com.xtrakick.app.repository

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.xtrakick.app.db.ShownNotificationsDao
import com.xtrakick.app.model.ShownNotification
import com.xtrakick.app.model.kick.api.livestream.Livestream
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
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShownNotificationsRepository @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val shownNotificationsDao: ShownNotificationsDao,
    private val kickRepository: KickRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val notificationUsersRepository: NotificationUsersRepository,
    private val localFollowChannelRepository: LocalFollowChannelRepository,
) {

    suspend fun getNewKickStreams(
        notificationUsersRepository: NotificationUsersRepository,
    ): List<Stream> = withContext(Dispatchers.IO) {
        val users = notificationUsersRepository.loadUsers()
        val channelIds = users
            .mapNotNull { it.channelId.takeIf { id -> id.isNotBlank() } }
            .distinct()
        if (channelIds.isEmpty()) {
            return@withContext emptyList()
        }

        val networkLibrary = context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        val headers = KickApiHelper.getKickPublicApiHeaders(context)
        val follows = runCatching { localFollowChannelRepository.loadFollows() }.getOrDefault(emptyList())

        val userIdsForPublicApi = mutableSetOf<String>()
        val slugsForFallback = mutableSetOf<String>()
        val keyToBroadcasterUserId = mutableMapOf<String, String>()

        for (id in channelIds) {
            val follow = follows.firstOrNull { it.userId == id || it.userLogin?.equals(id, ignoreCase = true) == true }
            if (follow != null) {
                val bId = follow.userId?.takeIf { it.all(Char::isDigit) }
                val slug = follow.userLogin?.takeIf { it.isNotBlank() }?.lowercase()
                if (bId != null) {
                    userIdsForPublicApi.add(bId)
                    keyToBroadcasterUserId[id] = bId
                }
                if (slug != null) {
                    slugsForFallback.add(slug)
                }
            } else if (id.all(Char::isDigit)) {
                userIdsForPublicApi.add(id)
                keyToBroadcasterUserId[id] = id
            } else {
                slugsForFallback.add(id.lowercase())
            }
        }

        val resolvedStreams = mutableListOf<Stream>()
        val fetchedKeys = mutableSetOf<String>()

        if (userIdsForPublicApi.isNotEmpty()) {
            val publicApiResult = runCatching {
                userIdsForPublicApi.chunked(50).flatMap { batch ->
                    kickPublicApiRepository.getLivestreams(
                        networkLibrary = networkLibrary,
                        headers = headers,
                        broadcasterUserIds = batch,
                    ).data
                }
            }.getOrNull()

            if (publicApiResult != null) {
                channelIds.forEach { id ->
                    val bId = keyToBroadcasterUserId[id]
                    if (bId != null && bId in userIdsForPublicApi) {
                        fetchedKeys.add(id)
                    }
                }
                // Never trust the server filter blindly: only streams that were actually
                // requested may notify. Anything else is another channel's live response
                // leaking into this poll (strangers in the notification shade).
                val requested = publicApiResult.filter { isRequestedLivestream(it, userIdsForPublicApi, slugsForFallback) }
                val dropped = publicApiResult.size - requested.size
                if (dropped > 0) {
                    Log.i(TAG, "ignoring $dropped unrequested livestreams")
                }
                requested.forEach { live ->
                    val broadcasterId = live.broadcasterUserId?.toString() ?: live.channelId?.toString()
                    val stream = Stream(
                        id = null,
                        source = AppConstants.KICK,
                        channelId = broadcasterId,
                        channelLogin = live.slug,
                        channelName = live.slug,
                        playbackUrl = null,
                        gameId = live.category?.id?.toString(),
                        gameSlug = null,
                        gameName = live.category?.name,
                        title = live.streamTitle,
                        viewerCount = live.viewerCount,
                        startedAt = live.startedAt,
                        thumbnailUrl = live.thumbnail,
                        profileImageUrl = live.profilePicture,
                    )
                    resolvedStreams.add(stream)
                }
            }
        }

        val unresolvedSlugs = slugsForFallback.filter { slug ->
            resolvedStreams.none { it.channelLogin?.equals(slug, ignoreCase = true) == true }
        }

        if (unresolvedSlugs.isNotEmpty()) {
            val semaphore = Semaphore(8)
            val fallbackResults = coroutineScope {
                unresolvedSlugs.map { slug ->
                    async {
                        semaphore.withPermit {
                            val channel = runCatching {
                                this@ShownNotificationsRepository.kickRepository.getChannel(slug, prefetchBadgeCatalog = false)
                            }.getOrNull()
                            channel?.let { this@ShownNotificationsRepository.kickRepository.toStream(it) } to (channel != null)
                        }
                    }
                }.awaitAll()
            }
            unresolvedSlugs.forEachIndexed { index, slug ->
                if (fallbackResults[index].second) {
                    fetchedKeys.add(slug)
                }
                fallbackResults[index].first?.let { resolvedStreams.add(it) }
            }
        }

        if (fetchedKeys.isEmpty()) {
            return@withContext emptyList()
        }
        val list = resolvedStreams.distinctBy { it.channelId ?: it.channelLogin ?: it.id }

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

    suspend fun showLiveNotificationFromEvent(
        context: Context,
        event: com.xtrakick.app.model.kick.KickLiveNotificationEvent,
        source: String = EVENT_SOURCE_UNKNOWN,
    ) = withContext(Dispatchers.IO) {
        val userIdStr = event.userId?.toString() ?: return@withContext
        val cleanSlug = event.path?.trim()
            ?.trimStart('/')
            ?.substringBefore('?')
            ?.substringBefore('/')
            ?.takeIf { it.isNotBlank() }
            ?: userIdStr
        // Chat (Pusher) and FCM deliver Kick's stream-start event with no per-channel check
        // upstream, so the poller's gating is re-applied here: the master switch plus the
        // channel's toggle. Without this, a stale backend subscription or an open chat of a
        // non-enabled channel posts anyway. Dropped events must not write the dedupe row —
        // doing so would suppress the poller for the rest of the session.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.i(TAG, "dropping live event for $userIdStr/$cleanSlug from $source: POST_NOTIFICATIONS not granted")
            return@withContext
        }
        if (!context.prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false)) {
            Log.i(TAG, "dropping live event for $userIdStr/$cleanSlug from $source: live notifications disabled")
            return@withContext
        }
        val channelIdStr = event.channelId?.toString()
        val candidateKeys = listOfNotNull(channelIdStr, userIdStr, cleanSlug).distinct()
        val channelEnabled = runCatching {
            notificationUsersRepository.isNotificationEnabled(candidateKeys)
        }.getOrElse {
            Log.w(TAG, "enablement check failed for $userIdStr/$cleanSlug", it)
            false
        }
        if (!channelEnabled) {
            Log.i(TAG, "dropping live event for $userIdStr/$cleanSlug from $source: channel notifications disabled")
            return@withContext
        }
        val cleanTitle = event.description?.trim()?.takeIf { it.isNotBlank() }
            ?: event.title?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY).toString().trim() }
        val secureAvatar = event.profilePicture?.takeIf { it.startsWith("https://", ignoreCase = true) }
        // Unify with the checker road: resolve the canonical broadcaster id and the live
        // start so both roads share one notification id and one dedupe row. Fail open —
        // without resolution keep posting so a slow network never eats the alert.
        val resolution = runCatching {
            kickRepository.getChannel(cleanSlug, prefetchBadgeCatalog = false)
        }.getOrNull()
        val canonicalId = resolution?.userId?.toString()
            ?: resolution?.user?.id?.toString()
            ?: channelIdStr
            ?: userIdStr
        val liveStartedAt = resolution?.livestream?.createdAt
            ?.takeUnless { it.isBlank() }
            ?.let { KickApiHelper.parseIso8601DateUTC(it) }
        val nowMs = System.currentTimeMillis()
        // Cross-road dedupe: a row for this channel means this session already notified,
        // no matter which road wrote it. Legacy rows keyed by the raw event ids count too.
        val legacyKeys = listOfNotNull(userIdStr, channelIdStr).distinct()
        val shown = shownNotificationsDao.getAll()
        val existingStartedAt = (listOf(canonicalId) + legacyKeys).distinct()
            .firstNotNullOfOrNull { key -> shown.firstOrNull { it.channelId == key }?.startedAt }
        if (shouldSuppressEvent(existingStartedAt, liveStartedAt, nowMs)) {
            Log.i(TAG, "dropping duplicate live event for $userIdStr/$cleanSlug from $source: already shown")
            return@withContext
        }
        val stream = Stream(
            source = AppConstants.KICK,
            channelId = canonicalId,
            channelLogin = cleanSlug,
            channelName = cleanSlug,
            title = cleanTitle,
            profileImageUrl = secureAvatar,
        )
        shownNotificationsDao.insertList(listOf(ShownNotification(canonicalId, liveStartedAt ?: nowMs)))
        Log.i(TAG, "posting live event for $userIdStr/$cleanSlug from $source (canonical=$canonicalId)")
        withContext(Dispatchers.Main) {
            showLiveNotifications(context, listOf(stream))
        }
    }

    companion object {
        const val GROUP_KEY = "com.xtrakick.app.LIVE_NOTIFICATIONS"

        private const val TAG = "ShownNotifications"

        /** Where a live-start event came from. Logged on every post/drop so doubles are attributable. */
        const val EVENT_SOURCE_FCM = "fcm"
        const val EVENT_SOURCE_CHAT = "chat"
        const val EVENT_SOURCE_UNKNOWN = "unknown"

        /**
         * Fallback duplicate window when the live start is unknown (channel lookup failed).
         * Same-session redeliveries arrive seconds/minutes apart; a genuinely restarted
         * stream days later must still notify, so the window stays at hours, not days.
         */
        const val EVENT_DUPLICATE_WINDOW_MS = 4 * 60 * 60 * 1000L

        /**
         * Guards the checker road: keep only livestreams that were actually requested,
         * by broadcaster id, channel id, or slug. Anything else is another channel's
         * live response leaking into this poll and must never notify.
         */
        fun isRequestedLivestream(
            live: Livestream,
            requestedIds: Set<String>,
            requestedSlugsLowercase: Set<String>,
        ): Boolean {
            live.broadcasterUserId?.toString()?.let { if (it in requestedIds) return true }
            live.channelId?.toString()?.let { if (it in requestedIds) return true }
            live.slug?.lowercase()?.let { if (it in requestedSlugsLowercase) return true }
            return false
        }

        /**
         * Cross-road duplicate check shared by the event and checker roads, which use the
         * same canonical channel key. With a known live start, any stored row at or past
         * it means this session already notified. Without one, only a recent row counts.
         */
        fun shouldSuppressEvent(
            existingStartedAt: Long?,
            liveStartedAt: Long?,
            nowMs: Long = System.currentTimeMillis(),
        ): Boolean {
            if (existingStartedAt == null) return false
            if (liveStartedAt != null) return existingStartedAt >= liveStartedAt
            return existingStartedAt > nowMs - EVENT_DUPLICATE_WINDOW_MS
        }

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
