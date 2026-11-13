package com.xtrakick.app.util

import android.content.Context
import android.os.Build
import android.os.SystemClock
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.ui.player.KickLivePlayback
import java.net.HttpURLConnection
import java.net.URL
import java.security.MessageDigest
import java.security.SecureRandom
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Anonymous usage ping. Sends a single random per-install identifier plus the
 * app version, Android API level, locale country, player engine, coarse watch
 * time bucket, crash count, the number of sessions and playback starts (per
 * engine) since the last successful ping to the OAuth backend, at most once per
 * calendar day. Release builds only, and skipped entirely when the user
 * disables anonymous usage stats in settings. When the user is logged in, a
 * one-way SHA-256 of the user id is included so reinstalls by a known account
 * can be reconciled server-side; it cannot be linked to an account without the
 * backend salt. Playback identifiers stay in memory and are never sent;
 * failures are silent.
 */
object UsagePing {

    private const val REQUEST_TIMEOUT_MS = 15_000L

    private val dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC)
    private val inFlight = AtomicBoolean(false)
    private val random = SecureRandom()
    private val lastPlaybackIds = mutableMapOf<String, String>()
    @Volatile
    private var watchStartElapsedRealtime: Long? = null

    fun maybeSend(context: Context, delayMillis: Long = 0L) {
        CrashReports.maybeSend(context, delayMillis)
        if (BuildConfig.DEBUG) return
        val appContext = context.applicationContext
        val prefs = appContext.prefs()
        if (!prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) return
        if (prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null) == dayFormat.format(Instant.ofEpochMilli(System.currentTimeMillis()))) return
        Thread(
            {
                if (delayMillis > 0L) {
                    try {
                        Thread.sleep(delayMillis)
                    } catch (_: InterruptedException) {
                        return@Thread
                    }
                }
                sendOnce(appContext, dayFormat.format(Instant.ofEpochMilli(System.currentTimeMillis())))
            },
            "UsagePing",
        ).apply { isDaemon = true; start() }
    }

    internal fun sendOnce(
        context: Context,
        today: String,
        openConnection: (URL) -> HttpURLConnection = { it.openConnection() as HttpURLConnection },
    ) {
        if (!inFlight.compareAndSet(false, true)) return
        try {
            val prefs = context.prefs()
            if (!prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) return
            if (prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null) == today) return
            val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
            if (baseUrl.isEmpty() || !baseUrl.startsWith("https://")) return
            val seed = prefs.getString(AppConstants.USAGE_PING_SEED, null) ?: run {
                val generated = randomHex(16)
                runCatching { prefs.edit().putString(AppConstants.USAGE_PING_SEED, generated).apply() }
                generated
            }
            val sessions = prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0).coerceIn(0, 100_000)
            val crashes = prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0).coerceIn(0, 10_000)
            val (playbackStartsIvs, playbackStartsExo) = synchronized(this) {
                prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS, 0).coerceIn(0, 100_000) to
                    prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0).coerceIn(0, 100_000)
            }
            val storedWatchMinutes = prefs.getInt(AppConstants.USAGE_WATCH_TIME_UNREPORTED_MINUTES, 0).coerceIn(0, 100_000)
            val activeWatchMinutes = synchronized(this) {
                val start = watchStartElapsedRealtime
                if (start != null) ((SystemClock.elapsedRealtime() - start) / 60_000L).toInt().coerceAtLeast(0) else 0
            }
            val totalWatchMinutes = (storedWatchMinutes + activeWatchMinutes).coerceIn(0, 100_000)
            val watchTimeBucket = when {
                totalWatchMinutes < 15 -> "0"
                totalWatchMinutes < 60 -> "1"
                totalWatchMinutes < 180 -> "2"
                else -> "3"
            }
            val enginePref = prefs.getString(AppConstants.PLAYER_KICK_LIVE_ENGINE, KickLivePlayback.ENGINE_IVS)
            val playerEngine = if (enginePref == KickLivePlayback.ENGINE_EXO_ONLY) "exo" else "ivs"

            val pid = sha256Hex(seed)
            val country = runCatching { java.util.Locale.getDefault().country }.getOrNull().orEmpty()
            val accountHash = runCatching {
                context.tokenPrefs().getString(AppConstants.USER_ID, null)
                    ?.takeIf { it.isNotBlank() }
                    ?.let { sha256Hex(it) }
            }.getOrNull()
            val body = buildString {
                append("{\"pid\":\"").append(pid).append("\",\"v\":\"").append(escapeJson(BuildConfig.VERSION_NAME)).append("\"")
                append(",\"os\":\"").append(Build.VERSION.SDK_INT).append('"')
                if (country.length == 2) append(",\"cc\":\"").append(country).append('"')
                if (accountHash != null) append(",\"ah\":\"").append(accountHash).append('"')
                if (sessions > 0) append(",\"s\":").append(sessions)
                append(",\"pe\":\"").append(playerEngine).append('"')
                if (playbackStartsIvs > 0) append(",\"si\":").append(playbackStartsIvs)
                if (playbackStartsExo > 0) append(",\"se\":").append(playbackStartsExo)
                if (crashes > 0) append(",\"c\":").append(crashes)
                append(",\"wt\":\"").append(watchTimeBucket).append('"')
                append("}")
            }
            val url = "$baseUrl/v1/metrics/ping"
            val headers = BackendRequestSigner.sign(
                secret = BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET,
                method = "POST",
                url = url,
                body = body.toByteArray(Charsets.UTF_8),
            )
            val connection = openConnection(URL(url))
            try {
                connection.requestMethod = "POST"
                connection.connectTimeout = REQUEST_TIMEOUT_MS.toInt()
                connection.readTimeout = REQUEST_TIMEOUT_MS.toInt()
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/json")
                headers.forEach { (name, value) -> connection.setRequestProperty(name, value) }
                connection.outputStream.use { it.write(body.toByteArray(Charsets.UTF_8)) }
                val code = connection.responseCode
                if (code in 200..299) {
                    prefs.edit().putString(AppConstants.USAGE_PING_LAST_DAY, today).apply()
                    // Keep sessions/crashes/watch time accumulated while the ping was in flight;
                    // only subtract what was actually reported.
                    val reportedSessions = (prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0) - sessions).coerceAtLeast(0)
                    val reportedCrashes = (prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0) - crashes).coerceAtLeast(0)
                    if (connection.getHeaderField("X-Playback-Starts-Accepted") == "1") {
                        synchronized(this) {
                            val remainingIvs = (prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS, 0) - playbackStartsIvs).coerceAtLeast(0)
                            val remainingExo = (prefs.getInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, 0) - playbackStartsExo).coerceAtLeast(0)
                            prefs.edit()
                                .putInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS, remainingIvs)
                                .putInt(AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO, remainingExo)
                                .apply()
                        }
                    }
                    val reportedMinutes = (prefs.getInt(AppConstants.USAGE_WATCH_TIME_UNREPORTED_MINUTES, 0) - storedWatchMinutes).coerceAtLeast(0)
                    prefs.edit()
                        .putInt(AppConstants.USAGE_SESSIONS_UNREPORTED, reportedSessions)
                        .putInt(AppConstants.USAGE_UNREPORTED_CRASHES, reportedCrashes)
                        .putInt(AppConstants.USAGE_WATCH_TIME_UNREPORTED_MINUTES, reportedMinutes)
                        .apply()
                    // Advance active watch start anchor if playback was ongoing during ping
                    synchronized(this) {
                        if (watchStartElapsedRealtime != null) {
                            watchStartElapsedRealtime = SystemClock.elapsedRealtime()
                        }
                    }
                }
            } finally {
                connection.disconnect()
            }
        } catch (_: Throwable) {
            // Intentionally silent: counters are best-effort.
        } finally {
            inFlight.set(false)
        }
    }

    fun noteSessionStarted(context: Context) {
        runCatching {
            val prefs = context.applicationContext.prefs()
            prefs.edit()
                .putInt(AppConstants.USAGE_SESSIONS_UNREPORTED, (prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0) + 1).coerceAtMost(100_000))
                .apply()
        }
    }

    fun notePlaybackStarted(context: Context, engine: String, playbackId: String?) {
        if (playbackId.isNullOrBlank()) return
        runCatching {
            val prefs = context.applicationContext.prefs()
            synchronized(this) {
                if (lastPlaybackIds[engine] == playbackId) return
                lastPlaybackIds[engine] = playbackId
                if (!prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) return
                val key = when (engine) {
                    KickLivePlayback.ENGINE_EXO_ONLY -> AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_EXO
                    KickLivePlayback.ENGINE_IVS -> AppConstants.USAGE_PLAYBACK_STARTS_UNREPORTED_IVS
                    else -> return
                }
                prefs.edit()
                    .putInt(key, (prefs.getInt(key, 0) + 1).coerceAtMost(100_000))
                    .apply()
            }
        }
    }

    fun notePlaybackEnded(engine: String) {
        synchronized(this) { lastPlaybackIds.remove(engine) }
    }

    fun noteCrash(context: Context) {
        runCatching {
            val prefs = context.applicationContext.prefs()
            val current = prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0)
            prefs.edit()
                .putInt(AppConstants.USAGE_UNREPORTED_CRASHES, (current + 1).coerceAtMost(10_000))
                .commit() // Must flush synchronously before unhandled exception terminates process
        }
    }

    fun noteWatchStarted() {
        synchronized(this) {
            if (watchStartElapsedRealtime == null) {
                watchStartElapsedRealtime = SystemClock.elapsedRealtime()
            }
        }
    }

    fun noteWatchStopped(context: Context) {
        val durationMs = synchronized(this) {
            val start = watchStartElapsedRealtime ?: return
            watchStartElapsedRealtime = null
            (SystemClock.elapsedRealtime() - start).coerceAtLeast(0L)
        }
        if (durationMs >= 30_000L) { // Only track meaningful viewing (at least 30 seconds)
            runCatching {
                val prefs = context.applicationContext.prefs()
                val currentMinutes = prefs.getInt(AppConstants.USAGE_WATCH_TIME_UNREPORTED_MINUTES, 0)
                val addedMinutes = (durationMs / 60_000L).toInt().coerceAtLeast(1)
                prefs.edit()
                    .putInt(AppConstants.USAGE_WATCH_TIME_UNREPORTED_MINUTES, (currentMinutes + addedMinutes).coerceAtMost(100_000))
                    .apply()
            }
        }
    }

    private fun randomHex(byteCount: Int): String {
        val bytes = ByteArray(byteCount)
        random.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }

    private fun sha256Hex(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        return digest.digest(input.toByteArray(Charsets.UTF_8)).joinToString("") { "%02x".format(it) }
    }

    private fun escapeJson(value: String): String =
        value.replace("\\", "\\\\").replace("\"", "\\\"")
}
