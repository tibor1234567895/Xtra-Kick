package com.xtrakick.app.util

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.appcompat.app.AppCompatDelegate
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.ui.player.KickLivePlayback
import java.net.HttpURLConnection
import java.net.URL
import java.security.MessageDigest
import java.security.SecureRandom
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Anonymous usage ping. Sends a single random per-install identifier plus the
 * app version, Android API level, locale country, player engine, coarse watch
 * time bucket, crash count, the number of sessions and playback starts (per
 * engine) since the last successful ping to the OAuth backend, at most once per
 * calendar day. Release builds only, and skipped entirely when the user
 * disables anonymous usage stats in settings. Playback identifiers stay in
 * memory and are never sent; failures are silent.
 */
object UsagePing {

    private const val REQUEST_TIMEOUT_MS = 15_000L
    private const val PLAYBACK_ERROR_COOLDOWN_MS = 5_000L
    private const val MAX_RECENT_CRASH_BUILDS = 32
    private val ABI_REGEX = Regex("[A-Za-z0-9._-]{1,16}")
    private val LANG_REGEX = Regex("[a-z]{2,3}")
    private val BATCH_ID_REGEX = Regex("[0-9a-f]{32}")

    private data class PlaybackErrorBatch(val date: String, val id: String, val count: Int)

    private val dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC)
    private val inFlight = AtomicBoolean(false)
    private val hasUserInteracted = AtomicBoolean(false)
    private val random = SecureRandom()
    private val lastPlaybackIds = mutableMapOf<String, String>()
    @Volatile
    private var watchStartElapsedRealtime: Long? = null
    @Volatile
    private var retryAfterElapsedRealtime = 0L
    @Volatile
    private var lastPlaybackErrorElapsedRealtime = Long.MIN_VALUE
    private val isEmulatorDevice: Boolean by lazy { isLikelyEmulator() }

    fun noteUserInteraction(context: Context) {
        if (!hasUserInteracted.compareAndSet(false, true)) return
        maybeSend(context.applicationContext, delayMillis = 1_500L)
    }

    internal fun resetInteractionForTests() {
        hasUserInteracted.set(false)
        retryAfterElapsedRealtime = 0L
        lastPlaybackErrorElapsedRealtime = Long.MIN_VALUE
    }

    internal fun isLikelyEmulator(
        product: String = Build.PRODUCT,
        fingerprint: String = Build.FINGERPRINT,
        hardware: String = Build.HARDWARE,
        model: String = Build.MODEL,
    ): Boolean {
        val p = product.lowercase(java.util.Locale.ROOT)
        val f = fingerprint.lowercase(java.util.Locale.ROOT)
        val h = hardware.lowercase(java.util.Locale.ROOT)
        val m = model.lowercase(java.util.Locale.ROOT)
        return p.contains("sdk_gphone") ||
            p.contains("emulator") ||
            p.contains("simulator") ||
            p.contains("vbox86p") ||
            p.contains("vsoc_x86") ||
            p.contains("cf_x86") ||
            p == "sdk" ||
            p == "google_sdk" ||
            p == "sdk_x86" ||
            h.contains("goldfish") ||
            h.contains("ranchu") ||
            h.contains("cutf_cvm") ||
            h.contains("vbox86") ||
            f.startsWith("generic") ||
            f.startsWith("unknown") ||
            f.contains("emulator") ||
            m.contains("google_sdk") ||
            m.contains("emulator") ||
            m.contains("cuttlefish") ||
            m.contains("android sdk built for")
    }

    internal fun shouldSendPing(
        context: Context,
        today: String = dayFormat.format(Instant.ofEpochMilli(System.currentTimeMillis())),
        isDebug: Boolean = BuildConfig.DEBUG,
        emulatorCheck: () -> Boolean = { isEmulatorDevice },
    ): Boolean {
        if (isDebug || emulatorCheck() || SystemClock.elapsedRealtime() < retryAfterElapsedRealtime) return false
        val prefs = context.applicationContext.prefs()
        if (!prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) return false
        if (prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null) == today) return false
        val hasExistingSeed = !prefs.getString(AppConstants.USAGE_PING_SEED, null).isNullOrBlank()
        // Defer brand-new install pings until a real user interaction so headless
        // APK scanners / cloud sandboxes that cold-boot the app without touching it
        // never mint a seed or inflate install counts. Returning installs still ping
        // normally on foreground start so quick DAU visits remain accurate.
        return hasExistingSeed || hasUserInteracted.get()
    }

    fun maybeSend(context: Context, delayMillis: Long = 0L) {
        val appContext = context.applicationContext
        if (!shouldSendPing(appContext)) return
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
            if (SystemClock.elapsedRealtime() < retryAfterElapsedRealtime) return
            if (!prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) return
            if (prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null) == today) return
            val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
            if (baseUrl.isEmpty() || !baseUrl.startsWith("https://")) return
            val seed = prefs.getString(AppConstants.USAGE_PING_SEED, null)?.takeIf { it.isNotBlank() } ?: run {
                val generated = randomHex(16)
                runCatching { prefs.edit().putString(AppConstants.USAGE_PING_SEED, generated).apply() }
                generated
            }
            val sessions = prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0).coerceIn(0, 100_000)
            val crashes = prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0).coerceIn(0, 10_000)
            val crashBuilds = recentCrashBuilds(prefs.getStringSet(AppConstants.USAGE_RECENT_CRASH_BUILDS, null), today)
            val playbackErrorBatch = pendingPlaybackErrorBatch(prefs, today)
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
            val abi = resolvePrimaryAbi()
            val lang = resolveActiveLanguage()
            val isOAuthSignedIn = runCatching {
                AuthStateHelper.isKickLoggedIn(context) && !AuthStateHelper.isKickGoogleSession(context)
            }.getOrDefault(false)
            val body = buildString {
                append("{\"pid\":\"").append(pid).append("\",\"v\":\"").append(escapeJson(BuildConfig.VERSION_NAME)).append("\"")
                append(",\"b\":").append(BuildConfig.VERSION_CODE)
                append(",\"os\":\"").append(Build.VERSION.SDK_INT).append('"')
                if (country.length == 2) append(",\"cc\":\"").append(country).append('"')
                if (abi.isNotEmpty()) append(",\"abi\":\"").append(escapeJson(abi)).append('"')
                if (lang.isNotEmpty()) append(",\"lang\":\"").append(escapeJson(lang)).append('"')
                if (sessions > 0) append(",\"s\":").append(sessions)
                append(",\"pe\":\"").append(playerEngine).append('"')
                if (playbackStartsIvs > 0) append(",\"si\":").append(playbackStartsIvs)
                if (playbackStartsExo > 0) append(",\"se\":").append(playbackStartsExo)
                if (playbackErrorBatch != null) {
                    append(",\"pb\":{\"id\":\"").append(playbackErrorBatch.id)
                    append("\",\"date\":\"").append(playbackErrorBatch.date)
                    append("\",\"count\":").append(playbackErrorBatch.count).append('}')
                }
                if (crashes > 0) append(",\"c\":").append(crashes)
                crashBuilds.joinTo(this, separator = ",", prefix = ",\"cb\":[", postfix = "]") { "\"${escapeJson(it)}\"" }
                append(",\"wt\":\"").append(watchTimeBucket).append('"')
                if (isOAuthSignedIn) append(",\"li\":true")
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
                if (code == 429) {
                    connection.getHeaderField("Retry-After")?.toLongOrNull()?.takeIf { it in 1..3600 }?.let { seconds ->
                        val delay = seconds * 1000L
                        retryAfterElapsedRealtime = SystemClock.elapsedRealtime() + delay
                        Handler(Looper.getMainLooper()).postDelayed({ maybeSend(context) }, delay)
                    }
                    return
                }
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
                    if (playbackErrorBatch != null && connection.getHeaderField("X-Playback-Errors-Accepted") == playbackErrorBatch.id) {
                        synchronized(this) {
                            val remaining = (prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0) - playbackErrorBatch.count).coerceAtLeast(0)
                            prefs.edit()
                                .putInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, remaining)
                                .remove(AppConstants.USAGE_PLAYBACK_ERROR_BATCH)
                                .apply()
                        }
                    }
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
        noteUserInteraction(context)
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

    private fun pendingPlaybackErrorBatch(prefs: SharedPreferences, today: String): PlaybackErrorBatch? = synchronized(this) {
        val count = prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0).coerceIn(0, 100_000)
        if (count == 0) return null
        val saved = prefs.getString(AppConstants.USAGE_PLAYBACK_ERROR_BATCH, null)?.split('|')
        val restored = saved?.takeIf { it.size == 3 }?.let { (date, id, value) ->
            val savedCount = value.toIntOrNull() ?: return@let null
            if (savedCount !in 1..count || !BATCH_ID_REGEX.matches(id)) return@let null
            if (runCatching { LocalDate.parse(date).toString() }.getOrNull() != date) return@let null
            PlaybackErrorBatch(date, id, savedCount)
        }
        val batch = restored ?: PlaybackErrorBatch(today, randomHex(16), count)
        // Persist the snapshot before sending so a lost response or app restart can replay it verbatim.
        val durable = prefs.edit()
            .putString(AppConstants.USAGE_PLAYBACK_ERROR_BATCH, "${batch.date}|${batch.id}|${batch.count}")
            .commit()
        batch.takeIf { durable }
    }

    fun notePlaybackError(context: Context) {
        runCatching {
            val now = SystemClock.elapsedRealtime()
            synchronized(this) {
                if (lastPlaybackErrorElapsedRealtime != Long.MIN_VALUE &&
                    now - lastPlaybackErrorElapsedRealtime < PLAYBACK_ERROR_COOLDOWN_MS
                ) {
                    return
                }
                val prefs = context.applicationContext.prefs()
                if (!prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) return
                lastPlaybackErrorElapsedRealtime = now
                prefs.edit()
                    .putInt(
                        AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED,
                        (prefs.getInt(AppConstants.USAGE_PLAYBACK_ERRORS_UNREPORTED, 0) + 1).coerceAtMost(100_000),
                    )
                    .apply()
            }
        }
    }

    private fun resolvePrimaryAbi(): String =
        runCatching { Build.SUPPORTED_ABIS?.firstOrNull()?.trim().orEmpty() }
            .getOrDefault("")
            .takeIf { ABI_REGEX.matches(it) }
            .orEmpty()

    private fun resolveActiveLanguage(): String =
        runCatching {
            val appLang = AppCompatDelegate.getApplicationLocales().get(0)?.language.orEmpty()
            val raw = appLang.ifBlank { java.util.Locale.getDefault().language.orEmpty() }
            raw.trim().lowercase(java.util.Locale.ROOT)
        }.getOrDefault("")
            .takeIf { LANG_REGEX.matches(it) }
            .orEmpty()

    internal fun noteCrash(context: Context, now: Instant = Instant.now()) {
        runCatching {
            val prefs = context.applicationContext.prefs()
            val current = prefs.getInt(AppConstants.USAGE_UNREPORTED_CRASHES, 0)
            val edit = prefs.edit()
                .putInt(AppConstants.USAGE_UNREPORTED_CRASHES, (current + 1).coerceAtMost(10_000))
            if (prefs.getBoolean(AppConstants.USAGE_STATS_ENABLED, true)) {
                val today = dayFormat.format(now)
                val event = "$today|${BuildConfig.VERSION_NAME}|${BuildConfig.VERSION_CODE}"
                val stored = prefs.getStringSet(AppConstants.USAGE_RECENT_CRASH_BUILDS, null).orEmpty()
                edit.putStringSet(AppConstants.USAGE_RECENT_CRASH_BUILDS, recentCrashBuilds(stored + event, today).toSet())
            }
            edit.commit() // Must flush synchronously before unhandled exception terminates process
        }
    }

    private fun recentCrashBuilds(events: Set<String>?, today: String): List<String> {
        if (events.isNullOrEmpty()) return emptyList()
        val oldest = LocalDate.parse(today).minusDays(30).toString()
        return events.filter { it.substringBefore('|') >= oldest && it.substringBefore('|') <= today }
            .sortedDescending()
            .take(MAX_RECENT_CRASH_BUILDS)
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
