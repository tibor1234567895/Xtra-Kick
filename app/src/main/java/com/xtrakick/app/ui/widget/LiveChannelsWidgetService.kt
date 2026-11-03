package com.xtrakick.app.ui.widget

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.SystemClock
import android.util.LruCache
import android.view.View
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.xtrakick.app.R
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.FollowedLiveStreamsRepository
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LiveChannelsWidgetEntryPoint {
    fun followedLiveStreamsRepository(): FollowedLiveStreamsRepository
}

class LiveChannelsWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        val repository = EntryPointAccessors.fromApplication(
            applicationContext, LiveChannelsWidgetEntryPoint::class.java,
        ).followedLiveStreamsRepository()
        return LiveChannelsRemoteViewsFactory(applicationContext, repository)
    }
}

class LiveChannelsRemoteViewsFactory(
    private val context: Context,
    private val repository: FollowedLiveStreamsRepository,
) : RemoteViewsService.RemoteViewsFactory {

    @Volatile private var streams: List<Stream> = emptyList()
    private val avatarScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val avatars = LruCache<String, Bitmap>(50)
    private val avatarRetryAfter = LruCache<String, Long>(50)
    private val pendingAvatars = ConcurrentHashMap.newKeySet<String>()
    private val avatarSemaphore = Semaphore(4)
    private val refreshLock = Any()
    private var avatarRefreshJob: Job? = null

    override fun onCreate() {}

    override fun onDataSetChanged() {
        streams = runCatching {
            runBlocking {
                repository.loadLiveFollowed(forceRefresh = LiveChannelsWidgetProvider.consumeRefreshRequest()).items
            }
        }.getOrElse { repository.peekCache(maxAgeMs = TimeUnit.HOURS.toMillis(24)) }
    }

    override fun onDestroy() {
        avatarScope.cancel()
        avatars.evictAll()
        avatarRetryAfter.evictAll()
        streams = emptyList()
    }

    override fun getCount(): Int = streams.size

    override fun getViewAt(position: Int): RemoteViews? {
        val stream = streams.getOrNull(position) ?: return null

        val views = RemoteViews(context.packageName, R.layout.widget_live_channel_item)
        views.setTextViewText(R.id.widgetChannelName, stream.channelName ?: stream.channelLogin.orEmpty())

        val category = stream.gameName?.takeIf { it.isNotBlank() }
        if (category != null) {
            views.setTextViewText(R.id.widgetGameName, category)
            views.setViewVisibility(R.id.widgetGameName, View.VISIBLE)
        } else {
            views.setViewVisibility(R.id.widgetGameName, View.GONE)
        }

        val title = stream.title?.takeIf { it.isNotBlank() }
        if (title != null) {
            views.setTextViewText(R.id.widgetStreamTitle, title)
            views.setViewVisibility(R.id.widgetStreamTitle, View.VISIBLE)
        } else {
            views.setViewVisibility(R.id.widgetStreamTitle, View.GONE)
        }

        val viewers = stream.viewerCount ?: 0
        views.setTextViewText(R.id.widgetViewerCount, formatViewerCount(viewers))

        val logoUrl = stream.channelLogo ?: stream.profileImageUrl
        if (!logoUrl.isNullOrBlank()) {
            val bitmap = avatars.get(logoUrl)
            if (bitmap != null) {
                views.setImageViewBitmap(R.id.widgetChannelLogo, bitmap)
            } else {
                views.setImageViewResource(R.id.widgetChannelLogo, R.drawable.bg_widget_avatar_placeholder)
                loadAvatar(logoUrl)
            }
        } else {
            views.setImageViewResource(R.id.widgetChannelLogo, R.drawable.bg_widget_avatar_placeholder)
        }

        val fillInIntent = Intent().apply {
            action = MainActivity.INTENT_LIVE_NOTIFICATION
            putExtra(MainActivity.KEY_VIDEO, stream)
            putExtra("stream_channel_login", stream.channelLogin)
            putExtra("channel_name", stream.channelName)
            putExtra("stream_source", stream.source ?: AppConstants.KICK)
        }
        views.setOnClickFillInIntent(R.id.widgetItemContainer, fillInIntent)

        return views
    }

    private fun loadAvatar(url: String) {
        if (!avatarScope.isActive || (avatarRetryAfter.get(url) ?: 0L) > SystemClock.elapsedRealtime() || !pendingAvatars.add(url)) return
        avatarScope.launch {
            try {
                avatarSemaphore.withPermit {
                    val manager = Glide.with(context)
                    val target = manager.asBitmap().load(url).transform(CircleCrop()).submit(96, 96)
                    try {
                        val bitmap = target.get(2, TimeUnit.SECONDS).copy(Bitmap.Config.ARGB_8888, false)
                        if (isActive && bitmap != null) avatars.put(url, bitmap)
                    } finally {
                        manager.clear(target)
                    }
                }
                synchronized(refreshLock) {
                    if (avatarRefreshJob?.isActive != true) {
                        avatarRefreshJob = avatarScope.launch {
                            delay(250L)
                            LiveChannelsWidgetProvider.notifyDataChanged(context)
                        }
                    }
                }
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                avatarRetryAfter.put(url, SystemClock.elapsedRealtime() + 60_000L)
            } finally {
                pendingAvatars.remove(url)
            }
        }
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = position.toLong()

    override fun hasStableIds(): Boolean = false

    private fun formatViewerCount(count: Int): String {
        return when {
            count >= 1_000_000 -> String.format(Locale.US, "%.1fM", count / 1_000_000.0)
            count >= 1_000 -> String.format(Locale.US, "%.1fk", count / 1_000.0)
            else -> count.toString()
        }
    }
}
