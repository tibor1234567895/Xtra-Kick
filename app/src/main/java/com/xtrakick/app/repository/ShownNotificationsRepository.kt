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
import kotlinx.coroutines.CancellationException
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
        val headers = runCatching {
            kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        }.getOrElse { KickApiHelper.getKickPublicApiHeaders(context) }
        val follows = runCatching { localFollowChannelRepository.loadFollows() }.getOrDefault(emptyList())
        val followByUserId = follows.mapNotNull { f -> f.userId?.takeIf { it.isNotBlank() }?.let { it to f } }.toMap()
        val followBySlug = follows.mapNotNull { f -> f.userLogin?.takeIf { it.isNotBlank() }?.lowercase()?.let { it to f } }.toMap()

        val userIdsForPublicApi = mutableSetOf<String>()
        val slugsForFallback = mutableSetOf<String>()
        val keyToBroadcasterUserId = mutableMapOf<String, String>()
        val broadcasterIdsBySlug = mutableMapOf<String, String>()

        for (id in channelIds) {
            val follow = followByUserId[id] ?: followBySlug[id.lowercase()]
            if (follow != null) {
                val bId = follow.userId?.takeIf { it.all(Char::isDigit) }
                val slug = follow.userLogin?.takeIf { it.isNotBlank() }?.lowercase()
                if (bId != null) {
                    userIdsForPublicApi.add(bId)
                    keyToBroadcasterUserId[id] = bId
                }
                if (slug != null) {
                    slugsForFallback.add(slug)
                    if (bId != null) broadcasterIdsBySlug[slug] = bId
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
        val fetchedBroadcasterIds = mutableSetOf<String>()

        if (userIdsForPublicApi.isNotEmpty()) {
            val publicApiResult = userIdsForPublicApi.chunked(50).flatMap { batch ->
                try {
                    kickPublicApiRepository.getLivestreams(
                        networkLibrary = networkLibrary,
                        headers = headers,
                        broadcasterUserIds = batch,
                    ).data.also { fetchedBroadcasterIds.addAll(batch) }
                } catch (error: CancellationException) {
                    throw error
                } catch (_: Exception) {
                    emptyList()
                }
            }

            if (fetchedBroadcasterIds.isNotEmpty()) {
                channelIds.forEach { id ->
                    val bId = keyToBroadcasterUserId[id]
                    if (bId != null && bId in fetchedBroadcasterIds) {
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
                    val catId = live.category?.id?.toString()
                    val catName = live.category?.name
                    val follow = (broadcasterId?.let { followByUserId[it] })
                        ?: (live.slug?.lowercase()?.let { followBySlug[it] })
                    val stream = Stream(
                        id = null,
                        source = AppConstants.KICK,
                        channelId = broadcasterId,
                        channelLogin = live.slug,
                        channelName = follow?.userName?.takeIf { it.isNotBlank() } ?: live.slug,
                        playbackUrl = null,
                        gameId = catId,
                        gameSlug = kickRepository.getOrInferCachedCategorySlug(catId, catName),
                        gameName = catName,
                        title = live.streamTitle,
                        viewerCount = live.viewerCount,
                        startedAt = live.startedAt,
                        thumbnailUrl = live.thumbnail,
                        profileImageUrl = live.profilePicture
                            ?: follow?.channelLogo
                            ?: live.slug?.let { kickRepository.getCachedChannel(it)?.user?.profileImage },
                    )
                    resolvedStreams.add(stream)
                }
            }
        }

        val unresolvedSlugs = notificationFallbackSlugs(
            slugsForFallback, broadcasterIdsBySlug, fetchedBroadcasterIds, resolvedStreams,
        )

        if (unresolvedSlugs.isNotEmpty()) {
            val semaphore = Semaphore(8)
            val fallbackResults = coroutineScope {
                unresolvedSlugs.map { slug ->
                    async {
                        semaphore.withPermit {
                            val channel = runCatching {
                                this@ShownNotificationsRepository.kickRepository.getChannel(slug, prefetchBadgeCatalog = false)
                            }.getOrElse { error ->
                                if (error is CancellationException) throw error
                                null
                            }
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
        // Collapse duplicates from the two roads: group by login first so the same
        // channel merges even if one side carries a different numeric id (channel id
        // vs broadcaster id) or a differently-cased login. The survivor keeps a usable
        // id and prefers an entry that actually has a title.
        val list = resolvedStreams
            .groupBy { it.channelLogin?.lowercase()?.takeIf { login -> login.isNotBlank() } ?: it.channelId ?: it.id }
            .values
            .map { group ->
                group.minWithOrNull(
                    compareBy({ it.channelId.isNullOrBlank() }, { it.title.isNullOrBlank() }),
                ) ?: group.first()
            }

        val oldList = shownNotificationsDao.getAll()
        val oldByKey = oldList.associateBy { it.channelId }
        val oldByLower = oldList.associateBy { it.channelId.lowercase() }
        val nowMs = System.currentTimeMillis()

        // Prune only ancient sessions (older than 48 hours) so rows don't grow indefinitely.
        // Never prune active or recent sessions by subscription key.
        oldList.filter { item -> item.startedAt < nowMs - STALE_ROW_PRUNE_MS }.let {
            if (it.isNotEmpty()) shownNotificationsDao.deleteList(it)
        }

        val inputKeysByBroadcaster = mutableMapOf<String, MutableSet<String>>()
        keyToBroadcasterUserId.forEach { (inputKey, broadcasterId) ->
            inputKeysByBroadcaster.getOrPut(broadcasterId) { mutableSetOf() }.add(inputKey)
        }
        fun oldRowFor(channelId: String, login: String?): ShownNotification? {
            oldByKey[channelId]?.let { return it }
            oldByLower[channelId.lowercase()]?.let { return it }
            login?.let { oldByKey[it] ?: oldByLower[it.lowercase()] }?.let { return it }
            inputKeysByBroadcaster[channelId]?.forEach { alias ->
                oldByKey[alias]?.let { return it }
                oldByLower[alias.lowercase()]?.let { return it }
            }
            return null
        }

        val newStreams = mutableSetOf<String>()
        val allLiveRowsToPersist = mutableListOf<ShownNotification>()
        val active = readActiveLiveChannel()

        for (stream in list) {
            val cid = stream.channelId ?: continue
            val startedAt = stream.startedAt?.takeUnless { it.isBlank() }
                ?.let { KickApiHelper.parseIso8601DateUTC(it) } ?: continue

            // Record all alias rows so push/poll/watch share the same knowledge
            val aliasKeys = listOfNotNull(cid, stream.channelLogin, stream.channelLogin?.lowercase()).distinct()
            aliasKeys.forEach { key ->
                allLiveRowsToPersist.add(ShownNotification(key, startedAt))
            }

            val old = oldRowFor(cid, stream.channelLogin)
            val alreadyShown = old != null && old.startedAt >= startedAt
            val isTooOldToAlert = !isStreamStartFresh(startedAt, nowMs)
            val activelyWatching = isActivelyWatching(cid, stream.channelLogin, active, nowMs)

            if (!alreadyShown && !isTooOldToAlert && !activelyWatching) {
                newStreams.add(cid)
            }
        }

        if (allLiveRowsToPersist.isNotEmpty()) {
            shownNotificationsDao.insertList(allLiveRowsToPersist)
        }

        list.filter { it.channelId in newStreams }
    }

    private fun readActiveLiveChannel(): ActiveLiveChannel {
        return try {
            val prefs = context.prefs()
            ActiveLiveChannel(
                channelId = prefs.getString(AppConstants.ACTIVE_LIVE_CHANNEL_ID, null),
                channelLogin = prefs.getString(AppConstants.ACTIVE_LIVE_CHANNEL_LOGIN, null),
                updatedMs = prefs.getLong(AppConstants.ACTIVE_LIVE_UPDATED_MS, 0L),
            )
        } catch (_: Exception) {
            ActiveLiveChannel(null, null, 0L)
        }
    }

    suspend fun markStreamSessionShown(
        channelId: String?,
        channelLogin: String?,
        startedAtMs: Long? = null,
    ) = withContext(Dispatchers.IO) {
        val now = System.currentTimeMillis()
        val sessionTime = startedAtMs?.takeIf { it > 0L } ?: now
        val keys = listOfNotNull(
            channelId?.trim()?.takeIf { it.isNotBlank() },
            channelLogin?.trim()?.takeIf { it.isNotBlank() },
            channelLogin?.trim()?.lowercase()?.takeIf { it.isNotBlank() },
        ).distinct()
        if (keys.isNotEmpty()) {
            shownNotificationsDao.insertList(keys.map { ShownNotification(it, sessionTime) })
        }
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
                setContentTitle(ContextCompat.getString(context, R.string.app_name))
                setContentText(ContextCompat.getString(context, R.string.live_notification_channels))
                setGroup(GROUP_KEY)
                setSmallIcon(R.drawable.notification_icon)
                setGroupSummary(true)
                setAutoCancel(true)
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
        val aliasKeys = (listOfNotNull(canonicalId, userIdStr, channelIdStr, cleanSlug, resolution?.slug).flatMap {
            listOf(it, it.lowercase())
        }).distinct()

        var liveStartedAt = event.startTime
            ?.takeUnless { it.isBlank() }
            ?.let { runCatching { KickApiHelper.parseIso8601DateUTC(it) }.getOrNull() }
            ?: resolution?.livestream?.createdAt
                ?.takeUnless { it.isBlank() }
                ?.let { KickApiHelper.parseIso8601DateUTC(it) }
        if (liveStartedAt == null) {
            // The channel endpoint sometimes omits a live livestream object.
            liveStartedAt = runCatching {
                kickRepository.getChannelLivestream(cleanSlug)
            }.getOrNull()?.createdAt
                ?.takeUnless { it.isBlank() }
                ?.let { KickApiHelper.parseIso8601DateUTC(it) }
        }

        if (isActivelyWatching(canonicalId, cleanSlug, readActiveLiveChannel())) {
            Log.i(TAG, "dropping live event for $userIdStr/$cleanSlug from $source: already watching")
            val sessionTime = liveStartedAt ?: System.currentTimeMillis()
            shownNotificationsDao.insertList(aliasKeys.map { ShownNotification(it, sessionTime) })
            return@withContext
        }
        val nowMs = System.currentTimeMillis()
        if (liveStartedAt != null && !isStreamStartFresh(liveStartedAt, nowMs)) {
            Log.i(TAG, "dropping stale live event for $userIdStr/$cleanSlug from $source: started ${(nowMs - liveStartedAt) / 60000}m ago")
            shownNotificationsDao.insertList(aliasKeys.map { ShownNotification(it, liveStartedAt) })
            return@withContext
        }
        // Cross-road dedupe: a row for this channel means this session already notified,
        // no matter which road wrote it. Legacy rows keyed by the raw event ids count too.
        val legacyKeys = listOfNotNull(userIdStr, channelIdStr).distinct()
        val shown = shownNotificationsDao.getAll()
        val shownByLower = shown.associateBy { it.channelId.lowercase() }
        // Match exact keys plus slug variants in either casing: legacy rows may be keyed
        // by slug while this event resolves to the numeric broadcaster id, or vice versa.
        val existingStartedAt = (listOf(canonicalId) + legacyKeys + listOfNotNull(cleanSlug, resolution?.slug)).distinct()
            .firstNotNullOfOrNull { key ->
                shown.firstOrNull { it.channelId == key }?.startedAt
                    ?: shownByLower[key.lowercase()]?.startedAt
            }
        if (shouldSuppressEvent(existingStartedAt, liveStartedAt, nowMs)) {
            Log.i(TAG, "dropping duplicate live event for $userIdStr/$cleanSlug from $source: already shown")
            return@withContext
        }
        val follow = runCatching { localFollowChannelRepository.getFollow(canonicalId, cleanSlug) }.getOrNull()
        val effectiveAvatar = secureAvatar
            ?: resolution?.user?.profileImage?.takeIf { it.startsWith("https://", ignoreCase = true) }
            ?: follow?.channelLogo?.takeIf { it.startsWith("https://", ignoreCase = true) }
        // Prefer the real display name so push alerts show it the same way the
        // polling road does, instead of a second lowercase-looking notification.
        val displayName = resolution?.user?.username?.takeIf { it.isNotBlank() }
            ?: follow?.userName?.takeIf { it.isNotBlank() }
            ?: cleanSlug
        val stream = Stream(
            source = AppConstants.KICK,
            channelId = canonicalId,
            channelLogin = cleanSlug,
            channelName = displayName,
            title = cleanTitle,
            profileImageUrl = effectiveAvatar,
        )
        val sessionTime = liveStartedAt ?: nowMs
        shownNotificationsDao.insertList(aliasKeys.map { ShownNotification(it, sessionTime) })
        Log.i(TAG, "posting live event for $userIdStr/$cleanSlug from $source (canonical=$canonicalId)")
        withContext(Dispatchers.Main) {
            showLiveNotifications(context, listOf(stream))
        }
    }

    companion object {
        internal fun notificationFallbackSlugs(
            slugs: Set<String>,
            broadcasterIdsBySlug: Map<String, String>,
            fetchedBroadcasterIds: Set<String>,
            resolvedStreams: List<Stream>,
        ): List<String> {
            // A complete successful ID batch also resolves its offline channels.
            return slugs.filter { slug ->
                broadcasterIdsBySlug[slug] !in fetchedBroadcasterIds &&
                    resolvedStreams.none { it.channelLogin?.equals(slug, ignoreCase = true) == true }
            }
        }

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

        /** Maximum age of a stream start (20 min) eligible to trigger a notification alert. Older streams are silently recorded as known. */
        const val MAX_STREAM_START_ALERT_AGE_MS = 20 * 60 * 1000L

        /** Session markers are pruned after 48 hours to prevent unbounded growth. */
        const val STALE_ROW_PRUNE_MS = 48 * 60 * 60 * 1000L

        /** How long a playing channel suppresses its own live alert. */
        const val ACTIVE_WATCH_SUPPRESS_MS = 6 * 60 * 60 * 1000L

        fun isStreamStartFresh(
            startedAtMs: Long?,
            nowMs: Long = System.currentTimeMillis(),
            maxAgeMs: Long = MAX_STREAM_START_ALERT_AGE_MS,
        ): Boolean {
            if (startedAtMs == null) return true
            if (startedAtMs <= 0L) return false
            return (nowMs - startedAtMs) <= maxAgeMs
        }

        data class ActiveLiveChannel(
            val channelId: String?,
            val channelLogin: String?,
            val updatedMs: Long,
        )

        internal fun buildSubscribedKeys(
            channelIds: List<String>,
            keyToBroadcasterUserId: Map<String, String>,
            slugsForFallback: Set<String>,
        ): Set<String> {
            val keys = HashSet<String>(channelIds.size * 2 + slugsForFallback.size * 2)
            channelIds.forEach {
                keys.add(it)
                keys.add(it.lowercase())
            }
            keyToBroadcasterUserId.values.forEach {
                keys.add(it)
                keys.add(it.lowercase())
            }
            slugsForFallback.forEach {
                keys.add(it)
                keys.add(it.lowercase())
            }
            return keys
        }

        fun isActivelyWatching(
            channelId: String?,
            channelLogin: String?,
            active: ActiveLiveChannel,
            nowMs: Long = System.currentTimeMillis(),
        ): Boolean {
            if (active.updatedMs <= 0L || nowMs - active.updatedMs > ACTIVE_WATCH_SUPPRESS_MS) return false
            if (!channelId.isNullOrBlank() && !active.channelId.isNullOrBlank() &&
                active.channelId.equals(channelId, ignoreCase = true)
            ) return true
            return !channelLogin.isNullOrBlank() && !active.channelLogin.isNullOrBlank() &&
                active.channelLogin.equals(channelLogin, ignoreCase = true)
        }

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
            (stream.channelId ?: stream.channelLogin?.lowercase() ?: stream.id).hashCode()
    }
}
