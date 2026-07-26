package com.github.andreyasadchy.xtra.util

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Debug
import android.util.Log
import com.github.andreyasadchy.xtra.BuildConfig
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

    fun e(tag: String?, message: String, throwable: Throwable? = null) {
        val safeTag = tag ?: "Xtra"
        Log.e(safeTag, message, throwable)
        writeIfEnabled(LEVEL_ERROR, safeTag, message, throwable)
    }

    fun testEntry() {
        writeIfEnabled(LEVEL_WARNING, "DiagnosticLogger", "Test diagnostic log entry")
    }

    fun logCrash(throwable: Throwable) {
        writeIfEnabled(LEVEL_CRASH, "Crash", "Uncaught exception", throwable, forceCrash = true)
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

    private fun writeIfEnabled(
        level: String,
        tag: String,
        message: String,
        throwable: Throwable? = null,
        forceCrash: Boolean = false,
    ) {
        val appContext = context ?: return
        val prefs = appContext.prefs()
        if (!prefs.getBoolean(C.DEBUG_DIAGNOSTIC_FILE_LOGGING, false)) {
            return
        }
        if (!forceCrash && !shouldLogForMinimum(level, prefs.getString(C.DEBUG_DIAGNOSTIC_FILE_LOG_LEVEL, LEVEL_ERROR))) {
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
                appendLine(stackTrace(it))
            }
            appendLine()
        }
    }

    private fun stackTrace(throwable: Throwable): String {
        val writer = StringWriter()
        throwable.printStackTrace(PrintWriter(writer))
        return writer.toString()
    }

    private fun currentFile(context: Context) = File(File(context.filesDir, DIRECTORY), FILE_NAME)

    private fun previousFile(context: Context) = File(File(context.filesDir, DIRECTORY), PREVIOUS_FILE_NAME)
}
