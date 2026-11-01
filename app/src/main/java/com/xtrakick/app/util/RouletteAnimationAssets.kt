package com.xtrakick.app.util

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.IOException
import java.util.Locale

/**
 * Prefetches and serves the daily-reward roulette stage videos that kick.com ships on
 * its static CDN (VP9 webm, black background baked in — safe to play opaque):
 *
 *  - idle.webm      crate idle loop shown before claiming
 *  - unbox.webm     lid-pop + green burst one-shot playing right after a claim tap
 *  - background.webm looping glitch-particle layer rendered behind the spinning reel
 *
 * Files land in `cacheDir/kick-anim/` with a 7-day TTL (kick serves immutable versioned
 * CDN assets, so refreshes are cheap and rare). Any playback resolves to the cached
 * file when present, otherwise the direct CDN URL (ExoPlayer streams progressively).
 */
object RouletteAnimationAssets {

    private const val STATIC_BASE = "https://static.kick.com/rewards"
    const val DEFAULT_IDLE_URL = "$STATIC_BASE/daily-rewards/idle.webm"
    const val DEFAULT_UNBOX_URL = "$STATIC_BASE/daily-rewards/unbox.webm"
    const val DEFAULT_BACKGROUND_URL = "$STATIC_BASE/background.webm"

    private const val CACHE_DIR_NAME = "kick-anim"
    private const val DOWNLOAD_SUFFIX = ".download"
    private const val CACHE_TTL_MS = 7L * 24L * 60L * 60L * 1000L

    private val VIDEO_EXTENSIONS = listOf(".webm", ".mp4", ".mov", ".m4v")

    private val ASSET_URLS = listOf(
        DEFAULT_IDLE_URL,
        DEFAULT_UNBOX_URL,
        DEFAULT_BACKGROUND_URL,
    )

    /** Downloads any missing/stale stage asset on a background dispatcher. */
    suspend fun ensureDailyAnimationAssetsCached(context: Context, okHttpClient: OkHttpClient) {
        withContext(Dispatchers.IO) {
            val cacheDir = File(context.cacheDir, CACHE_DIR_NAME)
            for (url in ASSET_URLS) {
                val file = cachedFile(cacheDir, url)
                if (file.isFile && file.length() > 0 && System.currentTimeMillis() - file.lastModified() < CACHE_TTL_MS) {
                    continue
                }
                runCatching { download(okHttpClient, url, file) }
            }
        }
    }

    /**
     * Resolves the unbox video source. The claim API's `animations.unbox_url` is read by the
     * web player as a video, but our model normalizes it to an image URL (`.gif` suffix) for
     * Glide, so only URLs that actually point at a video are served server-first; anything
     * else falls back to kick.com's own default unbox.webm (cached file preferred, then the
     * direct CDN URL — mirrors the web's `animations?.unbox_url || DEFAULT_UNBOX_URL`).
     */
    fun unboxSourceUri(context: Context, serverUnboxUrl: String?): Uri {
        val isServerVideo = serverUnboxUrl != null &&
            VIDEO_EXTENSIONS.any { serverUnboxUrl.lowercase(Locale.ROOT).endsWith(it) }
        if (isServerVideo) {
            if (serverUnboxUrl == DEFAULT_UNBOX_URL) {
                localSourceUri(context, DEFAULT_UNBOX_URL)?.let { return it }
            }
            return Uri.parse(serverUnboxUrl)
        }
        return localSourceUri(context, DEFAULT_UNBOX_URL) ?: Uri.parse(DEFAULT_UNBOX_URL)
    }

    /** @return background loop file, or the direct CDN URL as fallback. */
    fun backgroundSourceUri(context: Context): Uri =
        localSourceUri(context, DEFAULT_BACKGROUND_URL) ?: Uri.parse(DEFAULT_BACKGROUND_URL)

    private fun localSourceUri(context: Context, url: String): Uri? {
        val file = cachedFile(File(context.cacheDir, CACHE_DIR_NAME), url)
        return if (file.isFile && file.length() > 0) Uri.fromFile(file) else null
    }

    private fun cachedFile(cacheDir: File, url: String): File {
        val fileName = url.substringAfterLast('/')
        return File(cacheDir, fileName)
    }

    private fun download(okHttpClient: OkHttpClient, url: String, target: File) {
        val request = Request.Builder().url(url).build()
        target.parentFile?.mkdirs()
        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Kick stage asset download failed (${response.code}) for $url")
            }
            val temp = File(target.parentFile, target.name + DOWNLOAD_SUFFIX)
            temp.outputStream().use { output -> response.body.byteStream().copyTo(output) }
            if (target.exists()) {
                target.delete()
            }
            if (!temp.renameTo(target)) {
                temp.delete()
                throw IOException("Could not finalize download for $url")
            }
        }
    }
}
