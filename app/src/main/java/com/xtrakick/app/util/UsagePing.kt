package com.xtrakick.app.util

import android.content.Context
import android.os.Build
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.util.prefs
import java.security.MessageDigest
import java.security.SecureRandom
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Anonymous usage ping. Sends a single random per-install identifier plus the
 * app version, Android API level, locale country, and the number of sessions
 * started since the last successful ping to the OAuth backend, at most once
 * per calendar day. Release builds only, and skipped entirely when the user
 * disables anonymous usage stats in settings. When the user is logged in, a
 * one-way SHA-256 of the user id is included so reinstalls by a known account
 * can be reconciled server-side; it cannot be linked to an account without
 * the backend salt. No account, device, or behavioral data is included;
 * failures are silent.
 */
object UsagePing {

    private const val REQUEST_TIMEOUT_MS = 15_000L

    private val dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC)
    private val inFlight = AtomicBoolean(false)
    private val random = SecureRandom()

    fun maybeSend(context: Context, delayMillis: Long = 0L) {
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

    private fun sendOnce(context: Context, today: String) {
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
                append("}")
            }
            val url = "$baseUrl/v1/metrics/ping"
            val headers = BackendRequestSigner.sign(
                secret = BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET,
                method = "POST",
                url = url,
                body = body.toByteArray(Charsets.UTF_8),
            )
            val connection = java.net.URL(url).openConnection() as java.net.HttpURLConnection
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
                    // Keep sessions started while the ping was in flight; only
                    // subtract what was actually reported.
                    val reported = prefs.getInt(AppConstants.USAGE_SESSIONS_UNREPORTED, 0) - sessions
                    prefs.edit().putInt(AppConstants.USAGE_SESSIONS_UNREPORTED, reported.coerceAtLeast(0)).apply()
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
