package com.xtrakick.app.util

import android.app.ActivityManager
import android.app.Application
import android.app.KeyguardManager
import android.content.Context
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Debug
import android.os.PowerManager
import android.util.Log
import com.xtrakick.app.BuildConfig
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DiagnosticLogger {
    private const val DIRECTORY = "diagnostics"
    private const val FILE_NAME = "xtra-diagnostic.log"
    private const val PREVIOUS_FILE_NAME = "xtra-diagnostic.previous.log"
    private const val MAX_BYTES = 512L * 1024L
    private const val LEVEL_CRASH = "crash"
    private const val LEVEL_ERROR = "error"
    private const val LEVEL_WARNING = "warning"

    // Typed as Application, not Context: this object is a singleton, so holding an Activity
    // or Service context here would be a genuine leak. The narrower type makes "only ever the
    // process-lifetime context" a compile-time guarantee instead of a convention, and clears
    // the StaticFieldLeak warning honestly rather than by suppression.
    @Volatile
    private var context: Application? = null

    @Volatile
    private var lastResumedActivity: String? = null

    @Volatile
    private var isAppInForeground: Boolean = false

    val isForeground: Boolean
        get() = isAppInForeground

    fun init(application: Application) {
        this.context = application
    }

    fun updateAppState(isForeground: Boolean, resumedActivity: String? = lastResumedActivity) {
        isAppInForeground = isForeground
        lastResumedActivity = resumedActivity
    }

    /**
     * Logcat-only informational trace. Does not write to the diagnostic export file.
     * Use for high-volume operational noise that is useful while debugging but not
     * "important errors and warnings" for export review.
     */
    fun i(tag: String?, message: String, throwable: Throwable? = null) {
        val safeTag = tag ?: "Xtra"
        if (throwable != null) {
            Log.i(safeTag, message, throwable)
        } else {
            Log.i(safeTag, message)
        }
    }

    fun w(tag: String?, message: String, throwable: Throwable? = null) {
        val safeTag = tag ?: "Xtra"
        Log.w(safeTag, message, throwable)
        writeIfEnabled(LEVEL_WARNING, safeTag, message, throwable)
    }

    /**
     * Emits a warning to file diagnostics only when the app is in the foreground.
     * When backgrounded, downgrades to logcat [i] to avoid flooding diagnostic exports
     * with transient background-restriction failures (e.g. Doze, socket reconnects).
     */
    fun wIfForeground(tag: String?, message: String, throwable: Throwable? = null) {
        if (isAppInForeground) {
            w(tag, message, throwable)
        } else {
            i(tag, message, throwable)
        }
    }

    fun e(tag: String?, message: String, throwable: Throwable? = null) {
        val safeTag = tag ?: "Xtra"
        Log.e(safeTag, message, throwable)
        writeIfEnabled(LEVEL_ERROR, safeTag, message, throwable)
    }

    fun testEntry() {
        val appContext = context ?: return
        write(appContext, LEVEL_WARNING, "DiagnosticLogger", "Test diagnostic log entry", null)
        logPause(
            callingContext = appContext,
            source = "DiagnosticLogger.testEntry",
            reason = "Diagnostic test triggered from Settings",
            isUserInitiated = true,
            engine = "TestEngine",
            details = "Verification entry to confirm pause logging functionality",
        )
    }

    fun logCrash(throwable: Throwable) {
        writeIfEnabled(LEVEL_CRASH, "Crash", "Uncaught exception", throwable, forceCrash = true)
    }

    /**
     * Logs pauses or stops that are not directly initiated by the user tapping the
     * in-app play/pause button (e.g. audio focus loss, headset disconnect, media session callbacks,
     * watchdog expiry, or live buffer exhaustion).
     */
    fun logNonUiPause(
        callingContext: Context?,
        source: String,
        reason: String,
        details: String = "",
    ) {
        logPause(
            callingContext = callingContext,
            source = source,
            reason = reason,
            isUserInitiated = false,
            engine = null,
            details = details,
        )
    }

    internal fun shouldLogPause(
        logAllPausesEnabled: Boolean,
        logNonUserPausesEnabled: Boolean,
        isUserInitiated: Boolean,
    ): Boolean {
        return logAllPausesEnabled || (!isUserInitiated && logNonUserPausesEnabled)
    }

    /**
     * Logs playback pauses, stops, stalls, errors, and state transitions.
     * Records rich release-safe diagnostic information:
     * - Source and trigger reason
     * - User-initiated vs unexpected/system/player event
     * - Player engine (IVS / Media3) and playback metadata
     * - Live latency, playback position, buffer health, bandwidth
     * - System state: screen lock, interactive/on, power save, thermal status, network connectivity
     * - Audio routing: active output devices (BT A2DP, BLE, wired, speaker), audio mode, music active
     * - Full synthetic or passed throwable callstack to pinpoint the exact caller
     */
    fun logPause(
        callingContext: Context?,
        source: String,
        reason: String,
        isUserInitiated: Boolean,
        engine: String? = null,
        details: String = "",
        throwable: Throwable? = null,
    ) {
        val appContext = context ?: (callingContext?.applicationContext as? Application)
        val prefs = appContext?.prefs()
        val logAll = prefs?.getBoolean(AppConstants.DEBUG_LOG_ALL_PAUSES, true) ?: true
        val logNonUser = prefs?.getBoolean(AppConstants.DEBUG_LOG_NON_USER_PAUSES, true) ?: true
        val shouldLog = shouldLogPause(logAll, logNonUser, isUserInitiated)

        val tag = if (isUserInitiated) "PlaybackPause" else "NonUiPause"
        val level = if (isUserInitiated) "PAUSE_USER" else "PAUSE_NON_USER"
        val callstack = throwable ?: Throwable("Playback pause: $source ($reason)")
        val audioInfo = getAudioRoutingDetails(appContext)
        val sysInfo = getSystemDiagnostics(appContext)

        val message = buildString {
            append("source=").append(source)
            append(" | reason=").append(reason)
            append(" | userInitiated=").append(isUserInitiated)
            if (!engine.isNullOrBlank()) append(" | engine=").append(engine)
            if (details.isNotBlank()) append(" | ").append(details)
            if (sysInfo.isNotBlank()) append(" | sys=[").append(sysInfo).append("]")
            if (audioInfo.isNotBlank()) append(" | audio=[").append(audioInfo).append("]")
        }

        Log.w(tag, message, callstack)
        if (shouldLog && appContext != null) {
            write(appContext, level, tag, message, callstack)
        }
    }

    private fun getSystemDiagnostics(context: Context?): String {
        if (context == null) return ""
        return runCatching {
            val km = context.getSystemService(Context.KEYGUARD_SERVICE) as? KeyguardManager
            val pm = context.getSystemService(Context.POWER_SERVICE) as? PowerManager
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            val isLocked = km?.isKeyguardLocked ?: false
            val isInteractive = pm?.isInteractive ?: true
            val isPowerSave = pm?.isPowerSaveMode ?: false
            val thermal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                pm?.currentThermalStatus ?: -1
            } else -1

            val netInfo = cm?.let {
                val active = it.activeNetwork
                val caps = it.getNetworkCapabilities(active)
                val type = when {
                    caps == null -> "NONE"
                    caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "WIFI"
                    caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "CELLULAR"
                    caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "ETHERNET"
                    caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> "VPN"
                    else -> "OTHER"
                }
                val validated = caps?.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) ?: false
                val metered = it.isActiveNetworkMetered
                "$type(validated=$validated,metered=$metered)"
            } ?: "unknown"

            "locked=$isLocked,interactive=$isInteractive,powerSave=$isPowerSave${if (thermal >= 0) ",thermal=$thermal" else ""},net=$netInfo"
        }.getOrDefault("")
    }

    private fun getAudioRoutingDetails(context: Context?): String {
        if (context == null) return ""
        return runCatching {
            val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return ""
            val devicesStr = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val outputs = am.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
                outputs.joinToString(",") { dev ->
                    val typeName = when (dev.type) {
                        AudioDeviceInfo.TYPE_BLUETOOTH_A2DP -> "BT_A2DP"
                        AudioDeviceInfo.TYPE_BLUETOOTH_SCO -> "BT_SCO"
                        AudioDeviceInfo.TYPE_BLE_HEADSET -> "BLE_HEADSET"
                        AudioDeviceInfo.TYPE_BLE_SPEAKER -> "BLE_SPEAKER"
                        AudioDeviceInfo.TYPE_WIRED_HEADSET -> "WIRED_HEADSET"
                        AudioDeviceInfo.TYPE_WIRED_HEADPHONES -> "WIRED_HEADPHONES"
                        AudioDeviceInfo.TYPE_BUILTIN_SPEAKER -> "SPEAKER"
                        AudioDeviceInfo.TYPE_BUILTIN_EARPIECE -> "EARPIECE"
                        AudioDeviceInfo.TYPE_USB_DEVICE -> "USB"
                        AudioDeviceInfo.TYPE_USB_HEADSET -> "USB_HEADSET"
                        else -> "type_${dev.type}"
                    }
                    "$typeName(${dev.productName})"
                }
            } else {
                @Suppress("DEPRECATION")
                "isBluetoothA2dpOn=${am.isBluetoothA2dpOn}, isWiredHeadsetOn=${am.isWiredHeadsetOn}"
            }
            "mode=${am.mode}, musicActive=${am.isMusicActive}, outputs=[$devicesStr]"
        }.getOrDefault("")
    }

    fun clear(context: Context) {
        synchronized(this) {
            currentFile(context).delete()
            previousFile(context).delete()
        }
    }

    fun exportFile(context: Context): File? {
        synchronized(this) {
            val current = currentFile(context)
            val previous = previousFile(context)
            if (!current.exists() && !previous.exists()) {
                return null
            }
            val export = File(context.cacheDir, "xtra-diagnostic-export.txt")
            export.parentFile?.mkdirs()
            export.bufferedWriter().use { writer ->
                if (previous.exists()) {
                    writer.appendLine("===== Previous log =====")
                    previous.forEachLine { writer.appendLine(it) }
                    writer.appendLine()
                }
                if (current.exists()) {
                    writer.appendLine("===== Current log =====")
                    current.forEachLine { writer.appendLine(it) }
                }
            }
            return export
        }
    }

    data class DiagnosticLogView(
        val totalBytes: Long,
        val entryCount: Int,
        val preview: String,
        val truncated: Boolean,
    )

    /**
     * Tail of the combined diagnostic logs for in-app viewing. Capped so a full
     * log can't blow up a dialog; entry count feeds the status line.
     */
    fun readForView(context: Context, tailChars: Int = 60_000): DiagnosticLogView? {
        synchronized(this) {
            val previous = previousFile(context).takeIf { it.exists() }
            val current = currentFile(context).takeIf { it.exists() }
            if (previous == null && current == null) return null
            val full = buildString {
                if (previous != null) {
                    appendLine("===== Previous log =====")
                    append(previous.readText())
                    appendLine()
                }
                if (current != null) {
                    appendLine("===== Current log =====")
                    append(current.readText())
                }
            }
            var entries = 0
            var index = 0
            while (true) {
                val newline = full.indexOf('\n', index)
                val lineEnd = if (newline == -1) full.length else newline
                if (lineEnd > index && full[index] == '[') entries++
                if (newline == -1) break
                index = newline + 1
            }
            val totalBytes = (previous?.length() ?: 0L) + (current?.length() ?: 0L)
            if (full.length <= tailChars) {
                return DiagnosticLogView(totalBytes, entries, full, false)
            }
            var start = full.length - tailChars
            full.indexOf('\n', start).takeIf { it != -1 }?.let { start = it + 1 }
            return DiagnosticLogView(totalBytes, entries, "…\n" + full.substring(start), true)
        }
    }

    private fun writeIfEnabled(
        level: String,
        tag: String,
        message: String,
        throwable: Throwable? = null,
        forceCrash: Boolean = false,
    ) {
        val appContext = context ?: return
        val prefs = appContext.prefs()
        // Fatal crashes always persist: writing once per crash costs no battery,
        // and release builds hide the toggle that would otherwise gate them.
        if (!forceCrash && !prefs.getBoolean(AppConstants.DEBUG_DIAGNOSTIC_FILE_LOGGING, false)) {
            return
        }
        if (!forceCrash && !shouldLogForMinimum(level, prefs.getString(AppConstants.DEBUG_DIAGNOSTIC_FILE_LOG_LEVEL, LEVEL_ERROR))) {
            return
        }
        write(appContext, level, tag, message, throwable)
    }

    internal fun shouldLogForMinimum(level: String, minimum: String?): Boolean {
        return when (minimum) {
            LEVEL_WARNING -> level == LEVEL_WARNING || level == LEVEL_ERROR || level == LEVEL_CRASH
            LEVEL_ERROR -> level == LEVEL_ERROR || level == LEVEL_CRASH
            else -> level == LEVEL_CRASH
        }
    }

    private fun write(context: Context, level: String, tag: String, message: String, throwable: Throwable?) {
        synchronized(this) {
            runCatching {
                val file = currentFile(context)
                file.parentFile?.mkdirs()
                rotateIfNeeded(context, file)
                file.appendText(formatEntry(context, level, tag, message, throwable))
            }
        }
    }

    private fun rotateIfNeeded(context: Context, file: File) {
        if (!file.exists() || file.length() < MAX_BYTES) {
            return
        }
        val previous = previousFile(context)
        previous.delete()
        file.renameTo(previous)
    }

    private fun formatEntry(context: Context, level: String, tag: String, message: String, throwable: Throwable?): String {
        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z", Locale.US).format(Date())
        val runtime = Runtime.getRuntime()
        val memoryClass = runCatching {
            (context.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager)?.memoryClass
        }.getOrNull()
        val nativeHeapKb = Debug.getNativeHeapAllocatedSize() / 1024L
        return buildString {
            appendLine("[$timestamp] ${level.uppercase(Locale.US)}/$tag")
            appendLine("message=$message")
            appendLine("app=${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE}) ${BuildConfig.BUILD_TYPE}")
            appendLine("device=${Build.MANUFACTURER} ${Build.MODEL}; sdk=${Build.VERSION.SDK_INT}")
            appendLine("thread=${Thread.currentThread().name}; foreground=$isAppInForeground; activity=${lastResumedActivity ?: "unknown"}")
            appendLine("memory=usedKb:${(runtime.totalMemory() - runtime.freeMemory()) / 1024L} maxKb:${runtime.maxMemory() / 1024L} nativeKb:$nativeHeapKb classMb:${memoryClass ?: "unknown"}")
            throwable?.let {
                if (level == LEVEL_WARNING && isNetworkException(it)) {
                    val causeMsg = it.cause?.let { cause ->
                        " (cause: ${cause.javaClass.simpleName}: ${cause.message})"
                    } ?: ""
                    appendLine("cause=${it.javaClass.simpleName}: ${it.message ?: "network error"}$causeMsg")
                } else {
                    appendLine(stackTrace(it))
                }
            }
            appendLine()
        }
    }

    internal fun isNetworkException(throwable: Throwable): Boolean {
        var current: Throwable? = throwable
        while (current != null) {
            if (current is java.net.SocketException ||
                current is java.net.SocketTimeoutException ||
                current is java.net.UnknownHostException ||
                current is java.net.ConnectException ||
                current is java.net.NoRouteToHostException ||
                current is java.net.PortUnreachableException ||
                current is javax.net.ssl.SSLException ||
                current is java.io.InterruptedIOException ||
                current.javaClass.name.contains("HttpException")
            ) {
                return true
            }
            current = current.cause
        }
        return false
    }

    private fun stackTrace(throwable: Throwable): String {
        val writer = StringWriter()
        throwable.printStackTrace(PrintWriter(writer))
        return writer.toString()
    }

    private fun currentFile(context: Context) = File(File(context.filesDir, DIRECTORY), FILE_NAME)

    private fun previousFile(context: Context) = File(File(context.filesDir, DIRECTORY), PREVIOUS_FILE_NAME)
}
