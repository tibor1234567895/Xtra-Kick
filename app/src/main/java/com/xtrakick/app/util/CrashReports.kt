package com.xtrakick.app.util

import android.content.Context
import android.os.Build
import android.os.Process
import android.os.SystemClock
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.ui.player.KickLivePlayback
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import kotlinx.serialization.json.put
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.util.Collections
import java.util.IdentityHashMap
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean

object CrashReports {
    internal const val RETENTION_MS = 90 * 86_400_000L
    private const val MAX_BYTES = 24 * 1024
    private val symbolPattern = Regex("[A-Za-z0-9_.$<>-]+")
    private val filePattern = Regex("[A-Za-z0-9_.$-]+")
    private val inFlight = AtomicBoolean(false)
    @Volatile private var lastAttempt = -60_000L

    fun capture(context: Context, throwable: Throwable) {
        if (BuildConfig.DEBUG || !enabled(context)) return
        runCatching {
            val processAbis = if (Process.is64Bit()) setOf("arm64-v8a", "x86_64") else setOf("armeabi-v7a", "x86")
            val abi = Build.SUPPORTED_ABIS.firstOrNull { it in processAbis } ?: "unknown"
            val liveEnginePreference = when (context.prefs().getString(AppConstants.PLAYER_KICK_LIVE_ENGINE, KickLivePlayback.ENGINE_IVS)) {
                KickLivePlayback.ENGINE_IVS -> "ivs"
                KickLivePlayback.ENGINE_EXO_ONLY -> "exo"
                else -> "unknown"
            }
            enqueue(
                directory(context),
                report(throwable, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE, Build.VERSION.SDK_INT,
                    abi = abi, liveEnginePreference = liveEnginePreference),
            )
        }
    }

    internal fun report(
        throwable: Throwable,
        version: String,
        build: Int,
        sdk: Int,
        now: Long = System.currentTimeMillis(),
        abi: String = "unknown",
        liveEnginePreference: String = "unknown",
    ): JsonObject = buildJsonObject {
        put("id", UUID.randomUUID().toString())
        put("version", version)
        put("build", build)
        put("sdk", sdk)
        put("abi", abi.takeIf { it in setOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64") } ?: "unknown")
        put("liveEnginePreference", liveEnginePreference.takeIf { it == "ivs" || it == "exo" } ?: "unknown")
        put("crashedAt", now)
        put("exceptions", buildJsonArray {
            val seen = Collections.newSetFromMap(IdentityHashMap<Throwable, Boolean>())
            val causes = mutableListOf<Throwable>()
            var current: Throwable? = throwable
            while (current != null && seen.size < 8 && seen.add(current)) {
                causes.add(current)
                current = current.cause
            }
            val framesPerCause = minOf(16, 32 / causes.size)
            for (exception in causes) {
                add(buildJsonObject {
                    put("type", safeSymbol(exception.javaClass.name))
                    put("frames", buildJsonArray {
                        for (frame in exception.stackTrace.take(framesPerCause)) {
                            add(buildJsonObject {
                                put("class", safeSymbol(frame.className))
                                put("method", safeSymbol(frame.methodName))
                                put("file", frame.fileName?.takeIf { it.length <= 120 && filePattern.matches(it) } ?: "Unknown")
                                put("line", frame.lineNumber.coerceAtLeast(-2))
                            })
                        }
                    })
                })
            }
        })
    }

    private fun safeSymbol(value: String): String =
        value.takeIf { it.length <= 200 && symbolPattern.matches(it) } ?: "unknown"

    internal fun enqueue(dir: File, report: JsonObject, now: Long = System.currentTimeMillis()) {
        synchronized(this) {
            dir.mkdirs()
            val bytes = report.toString().toByteArray(Charsets.UTF_8)
            if (bytes.size > MAX_BYTES) return
            val file = File(dir, "${UUID.randomUUID()}.json")
            val pending = File(dir, "${file.name}.tmp")
            pending.outputStream().use { output ->
                output.write(bytes)
                output.fd.sync()
            }
            check(pending.renameTo(file))
            pendingFiles(dir, now).dropLast(5).forEach { it.delete() }
        }
    }

    internal fun pendingFiles(dir: File, now: Long = System.currentTimeMillis()): List<File> = synchronized(this) {
        dir.listFiles().orEmpty().filter { file ->
            if (!file.name.endsWith(".json")) {
                file.delete()
                false
            } else {
                val timestamp = runCatching {
                    if (file.length() > MAX_BYTES) null
                    else Json.parseToJsonElement(file.readText()).let { it as? JsonObject }
                        ?.get("crashedAt")?.jsonPrimitive?.longOrNull
                }.getOrNull()
                if (timestamp == null || timestamp <= now - RETENTION_MS || timestamp > now + 300_000L) {
                    file.delete()
                    false
                } else true
            }
        }.sortedWith(compareBy<File> { it.lastModified() }.thenBy { it.name })
    }

    fun clear(context: Context) {
        synchronized(this) { directory(context).listFiles().orEmpty().forEach { it.delete() } }
    }

    /** True when at least one crash report from a previous run is still queued. */
    fun hasPending(context: Context): Boolean {
        val appContext = context.applicationContext
        if (!enabled(appContext)) return false
        return runCatching { pendingFiles(directory(appContext)).isNotEmpty() }.getOrDefault(false)
    }

    internal fun sendPending(dir: File, isEnabled: () -> Boolean, send: (ByteArray) -> Int) {
        for (file in pendingFiles(dir)) {
            if (!isEnabled()) {
                synchronized(this) { dir.listFiles().orEmpty().forEach { it.delete() } }
                break
            }
            if (!file.exists()) continue
            val code = send(file.readBytes())
            if (code in 200..299 || code == 400 || code == 413) file.delete() else break
        }
    }

    fun maybeSend(context: Context, delayMillis: Long) {
        val appContext = context.applicationContext
        if (!enabled(appContext)) {
            clear(appContext)
            return
        }
        if (BuildConfig.DEBUG || !inFlight.compareAndSet(false, true)) return
        Thread({
            try {
                if (delayMillis > 0) Thread.sleep(delayMillis)
                if (SystemClock.elapsedRealtime() - lastAttempt < 60_000L) return@Thread
                val baseUrl = BuildConfig.KICK_OAUTH_BACKEND_BASE_URL.trim().trimEnd('/')
                if (!baseUrl.startsWith("https://") || BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET.isBlank()) return@Thread
                sendPending(directory(appContext), { enabled(appContext) }) { body ->
                    lastAttempt = SystemClock.elapsedRealtime()
                    val url = "$baseUrl/v1/metrics/crash"
                    val headers = BackendRequestSigner.sign(
                        secret = BuildConfig.KICK_OAUTH_BACKEND_HMAC_SECRET,
                        method = "POST",
                        url = url,
                        body = body,
                    )
                    val connection = URL(url).openConnection() as HttpURLConnection
                    try {
                        connection.instanceFollowRedirects = false
                        connection.requestMethod = "POST"
                        connection.connectTimeout = 15_000
                        connection.readTimeout = 15_000
                        connection.doOutput = true
                        connection.setRequestProperty("Content-Type", "application/json")
                        headers.forEach { (name, value) -> connection.setRequestProperty(name, value) }
                        connection.outputStream.use { it.write(body) }
                        connection.responseCode
                    } finally {
                        connection.disconnect()
                    }
                }
            } catch (_: Exception) {
                // Preserve pending reports for a later foreground launch.
            } finally {
                inFlight.set(false)
            }
        }, "CrashReports").apply { isDaemon = true; start() }
    }

    private fun enabled(context: Context): Boolean = context.prefs().let {
        it.getBoolean(AppConstants.USAGE_STATS_ENABLED, true) &&
            it.getBoolean(AppConstants.CRASH_REPORTS_ENABLED, true)
    }

    private fun directory(context: Context): File = File(context.noBackupFilesDir, "crash-reports")
}
