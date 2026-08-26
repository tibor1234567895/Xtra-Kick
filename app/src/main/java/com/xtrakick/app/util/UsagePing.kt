package com.xtrakick.app.util

import android.content.Context
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.util.prefs
import java.security.MessageDigest
import java.security.SecureRandom
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Anonymous, dev-only usage counter. Sends a single random identifier that rotates
 * once per calendar month along with the app version to the OAuth backend, at most
 * once per calendar day. No account, device, or usage data is included.
 */
object UsagePing {

    private const val REQUEST_TIMEOUT_MS = 15_000L

    private val dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC)
    private val monthFormat = DateTimeFormatter.ofPattern("yyyy-MM").withZone(ZoneOffset.UTC)
    private val inFlight = AtomicBoolean(false)
    private val random = SecureRandom()

    fun maybeSend(context: Context, delayMillis: Long = 0L) {
        if (BuildConfig.DEBUG) return
        val appContext = context.applicationContext
        if (appContext.prefs().getString(AppConstants.USAGE_PING_LAST_DAY, null) == dayFormat.format(Instant.ofEpochMilli(System.currentTimeMillis()))) return
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
            if (prefs.getString(AppConstants.USAGE_PING_LAST_DAY, null) == today) return
            val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
            if (baseUrl.isEmpty() || !baseUrl.startsWith("https://")) return
            val seed = prefs.getString(AppConstants.USAGE_PING_SEED, null) ?: run {
                val generated = randomHex(16)
                runCatching { prefs.edit().putString(AppConstants.USAGE_PING_SEED, generated).apply() }
                generated
            }
            val month = monthFormat.format(Instant.ofEpochMilli(System.currentTimeMillis()))
            val pid = sha256Hex("$seed:$month")
            val body = "{\"pid\":\"$pid\",\"v\":\"${escapeJson(BuildConfig.VERSION_NAME)}\"}"
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
