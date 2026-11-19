package com.xtrakick.app.util.chat

import android.content.Context
import android.net.ConnectivityManager
import coil3.imageLoader
import coil3.memory.MemoryCache
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.model.chat.Emote
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal fun Emote.stvPrefetchUrl(): String? = when (source) {
    Emote.GLOBAL_STV, Emote.PERSONAL_STV -> url2x ?: url1x
    Emote.CHANNEL_STV -> url1x ?: url2x
    else -> null
}

/** Warms the Coil disk cache with smaller 7TV variants on unmetered connections. */
object StvEmotePrefetcher {
    private const val WORKERS = 2
    private const val INTER_REQUEST_GAP_MS = 200L
    private const val FIRST_REPASS_DELAY_MS = 60_000L
    private const val REPASS_DELAY_MS = 120_000L

    private val claimed = ConcurrentHashMap.newKeySet<String>()
    fun prefetch(context: Context, scope: CoroutineScope, emotes: Collection<Emote>): Job {
        val appContext = context.applicationContext
        return scope.launch(Dispatchers.IO) {
            val loader = appContext.imageLoader
            // Metered networks opt out entirely: a full channel set costs tens of MB and the
            // picker's per-cell loading still works. Re-entering the channel re-evaluates.
            val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            if (connectivityManager?.isActiveNetworkMetered == true) return@launch
            val urls = emotes.mapNotNull(Emote::stvPrefetchUrl).filter(claimed::add)
            try {
                var pending = urls.filterNot { isCached(loader, it) }
                while (isActive && pending.isNotEmpty()) {
                    val attempted = pending.size
                    pending = runPass(appContext, loader, pending)
                    if (pending.isNotEmpty()) {
                        delay(if (attempted > pending.size) FIRST_REPASS_DELAY_MS else REPASS_DELAY_MS)
                    }
                }
            } finally {
                urls.forEach(claimed::remove)
            }
        }
    }

    private suspend fun runPass(
        appContext: Context,
        loader: coil3.ImageLoader,
        urls: List<String>,
    ): List<String> {
        val failed = Collections.synchronizedList(mutableListOf<String>())
        val iteratorMutex = Mutex()
        val queue = urls.iterator()
        coroutineScope {
            repeat(WORKERS) {
                launch {
                    while (isActive) {
                        val url = iteratorMutex.withLock { if (queue.hasNext()) queue.next() else return@launch }
                        if (!fetchOne(appContext, loader, url)) failed.add(url)
                        delay(INTER_REQUEST_GAP_MS)
                    }
                }
            }
        }
        return failed
    }

    private suspend fun fetchOne(appContext: Context, loader: coil3.ImageLoader, url: String): Boolean {
        val request = ImageRequest.Builder(appContext).apply {
            data(url)
            httpHeaders(
                NetworkHeaders.Builder()
                    .add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    .build()
            )
        }.build()
        return loader.execute(request) is SuccessResult
    }

    private fun isCached(loader: coil3.ImageLoader, url: String): Boolean {
        if (loader.memoryCache?.get(MemoryCache.Key(url)) != null) return true
        val snapshot = loader.diskCache?.openSnapshot(url)
        if (snapshot != null) {
            snapshot.close()
            return true
        }
        return false
    }
}
