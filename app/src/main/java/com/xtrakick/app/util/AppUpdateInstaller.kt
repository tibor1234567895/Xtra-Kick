package com.xtrakick.app.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageInstaller
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.Build
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.IntentCompat
import androidx.core.content.pm.PackageInfoCompat
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.xtrakick.app.R
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.util.concurrent.atomic.AtomicLong

internal class AppUpdateDownloader(
    private val applicationContext: Context,
    private val okHttpClient: OkHttpClient,
    private val scope: CoroutineScope,
    private val logTag: String,
) {
    private val generation = AtomicLong(0L)
    private var job: Job? = null
    private val _progress = MutableStateFlow<UpdateDownloadProgress?>(null)
    val progress: StateFlow<UpdateDownloadProgress?> = _progress.asStateFlow()

    fun start(url: String, expectedSize: Long?) {
        val token = generation.incrementAndGet()
        job?.cancel()
        _progress.value = UpdateDownloadProgress(bytesRead = 0L, totalBytes = expectedSize)
        job = scope.launch(Dispatchers.IO) {
            try {
                installAppUpdate(applicationContext, url) { output ->
                    downloadAppUpdate(okHttpClient, url, output) { bytesRead ->
                        if (generation.get() == token) {
                            _progress.value = UpdateDownloadProgress(bytesRead = bytesRead, totalBytes = expectedSize)
                        }
                    }
                }
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                DiagnosticLogger.e(logTag, "downloadUpdate failed", e)
                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, R.string.update_download_failed, Toast.LENGTH_LONG).show()
                }
            } finally {
                if (generation.get() == token) {
                    _progress.value = null
                }
            }
        }
    }

    fun cancel() {
        generation.incrementAndGet()
        job?.cancel()
        _progress.value = null
    }
}

internal suspend fun downloadAppUpdate(
    okHttpClient: OkHttpClient,
    url: String,
    output: OutputStream,
    onProgress: ((Long) -> Unit)? = null,
) {
    var bytesRead = 0L
    val status = executeUpdateCall(okHttpClient, url) { response ->
        if (response.isSuccessful) {
            response.body.byteStream().use { input ->
                val buffer = ByteArray(32 * 1024)
                var count = input.read(buffer)
                while (count != -1) {
                    currentCoroutineContext().ensureActive()
                    output.write(buffer, 0, count)
                    bytesRead = Math.addExact(bytesRead, count.toLong())
                    onProgress?.invoke(bytesRead)
                    count = input.read(buffer)
                }
            }
        }
        response.code
    }
    if (status !in 200..299 || bytesRead == 0L) {
        throw IOException("Update download failed: HTTP $status, $bytesRead bytes")
    }
}

internal suspend fun installAppUpdate(context: Context, url: String, download: suspend (OutputStream) -> Unit) {
    require(isTrustedUpdateUrl(url)) { "Update URL must point to an official release asset" }
    val apk = File.createTempFile("app-update-", ".apk", context.cacheDir)
    try {
        apk.outputStream().use { download(it) }
        verifyAppUpdate(context, apk)
        currentCoroutineContext().ensureActive()

        val installer = context.packageManager.packageInstaller
        val sessionId = installer.createSession(
            PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL).apply {
                setAppPackageName(context.packageName)
                setSize(apk.length())
            }
        )
        try {
            installer.openSession(sessionId).use { session ->
                session.openWrite("package", 0, apk.length()).use { output ->
                    apk.inputStream().use { it.copyTo(output) }
                    session.fsync(output)
                }
                currentCoroutineContext().ensureActive()
                val callback = Intent(context, AppUpdateResultReceiver::class.java).apply {
                    action = AppUpdateResultReceiver.ACTION_INSTALL_RESULT
                    setPackage(context.packageName)
                }
                session.commit(PendingIntent.getBroadcast(context, sessionId, callback, PendingIntent.FLAG_MUTABLE).intentSender)
            }
        } catch (error: Exception) {
            runCatching { installer.abandonSession(sessionId) }
            throw error
        }
    } finally {
        apk.delete()
    }
}

class AppUpdateResultReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val sessionId = intent.getIntExtra(PackageInstaller.EXTRA_SESSION_ID, -1)
        if (intent.action != ACTION_INSTALL_RESULT || sessionId <= 0) return
        val prefs = context.tokenPrefs()
        val status = intent.getIntExtra(PackageInstaller.EXTRA_STATUS, PackageInstaller.STATUS_FAILURE)
        if (status == PackageInstaller.STATUS_PENDING_USER_ACTION) {
            val confirmation = IntentCompat.getParcelableExtra(intent, Intent.EXTRA_INTENT, Intent::class.java)
            if (confirmation != null && context.isSystemInstallerIntent(confirmation) &&
                prefs.edit().putString(PENDING_INSTALL_CONFIRMATION, "$sessionId|${confirmation.toUri(Intent.URI_INTENT_SCHEME)}").commit()) {
                return
            }
        } else {
            if (prefs.getString(PENDING_INSTALL_CONFIRMATION, null)?.substringBefore('|') == sessionId.toString()) {
                prefs.edit { remove(PENDING_INSTALL_CONFIRMATION) }
            }
            if (status == PackageInstaller.STATUS_SUCCESS || status == PackageInstaller.STATUS_FAILURE_ABORTED) return
        }
        val statusMessage = intent.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE)
        DiagnosticLogger.e("AppUpdate", "Update install failed: status=$status msg=$statusMessage")
        Toast.makeText(context, R.string.update_download_failed, Toast.LENGTH_LONG).show()
    }

    companion object {
        internal const val ACTION_INSTALL_RESULT = "com.xtrakick.app.INSTALL_UPDATE_RESULT"
    }
}

private const val PENDING_INSTALL_CONFIRMATION = "pending_install_confirmation"

internal fun ComponentActivity.observeAppUpdateResults() {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.RESUMED) {
            val prefs = tokenPrefs()
            val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                if (key == PENDING_INSTALL_CONFIRMATION) showPendingAppUpdateConfirmation()
            }
            prefs.registerOnSharedPreferenceChangeListener(listener)
            try {
                showPendingAppUpdateConfirmation()
                awaitCancellation()
            } finally {
                prefs.unregisterOnSharedPreferenceChangeListener(listener)
            }
        }
    }
}

private fun Activity.showPendingAppUpdateConfirmation() {
    val prefs = tokenPrefs()
    val pending = prefs.getString(PENDING_INSTALL_CONFIRMATION, null) ?: return
    try {
        val sessionId = pending.substringBefore('|').toIntOrNull() ?: return
        if (packageManager.packageInstaller.getSessionInfo(sessionId) == null) return
        val confirmation = Intent.parseUri(pending.substringAfter('|'), Intent.URI_INTENT_SCHEME)
        check(isSystemInstallerIntent(confirmation))
        startActivity(confirmation)
        prefs.edit { putLong(AppConstants.UPDATE_LAST_CHECKED, System.currentTimeMillis()) }
    } catch (error: Exception) {
        DiagnosticLogger.e("AppUpdate", "Could not launch update confirmation", error)
        runCatching {
            startActivity(Intent(Intent.ACTION_VIEW, "https://github.com/tibor1234567895/Xtra-Kick/releases/latest".toUri()))
        }.onFailure { Toast.makeText(this, R.string.update_download_failed, Toast.LENGTH_LONG).show() }
    } finally {
        prefs.edit { remove(PENDING_INSTALL_CONFIRMATION) }
    }
}

internal fun Context.isSystemInstallerIntent(candidate: Intent): Boolean {
    if (candidate.data != null || candidate.clipData != null || candidate.selector != null) return false
    val uriGrantFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION or
        Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION or Intent.FLAG_GRANT_PREFIX_URI_PERMISSION
    if ((candidate.flags and uriGrantFlags) != 0) return false
    when (candidate.action) {
        Intent.ACTION_CHOOSER, Intent.ACTION_SEND, Intent.ACTION_SEND_MULTIPLE, Intent.ACTION_VIEW -> return false
        "android.content.pm.action.CONFIRM_INSTALL", "android.content.pm.action.CONFIRM_PERMISSIONS" -> Unit
        else -> if (candidate.component == null) return false
    }
    val appInfo = packageManager.resolveActivity(candidate, PackageManager.MATCH_DEFAULT_ONLY)
        ?.activityInfo?.applicationInfo ?: return false
    return appInfo.flags and (ApplicationInfo.FLAG_SYSTEM or ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0
}

@Suppress("DEPRECATION")
@SuppressLint("PackageManagerGetSignatures")
private fun verifyAppUpdate(context: Context, apk: File) {
    val manager = context.packageManager
    val flags = if (Build.VERSION.SDK_INT >= 28) PackageManager.GET_SIGNING_CERTIFICATES else PackageManager.GET_SIGNATURES
    val candidate = manager.getPackageArchiveInfo(apk.absolutePath, flags)
        ?: throw IOException("Update is not a readable APK")
    if (candidate.packageName != context.packageName) throw IOException("Update package does not match the installed app")

    val installed = manager.getPackageInfo(context.packageName, flags)
    val installedSigners = apkSigners(installed)
    if (installedSigners.isEmpty() || apkSigners(candidate) != installedSigners) {
        throw IOException("Update signing certificate does not match the installed app")
    }
    if (PackageInfoCompat.getLongVersionCode(candidate) <= PackageInfoCompat.getLongVersionCode(installed)) {
        throw IOException("Update is not newer than the installed app")
    }
}

@Suppress("DEPRECATION")
private fun apkSigners(info: PackageInfo): Set<Signature> =
    if (Build.VERSION.SDK_INT >= 28) info.signingInfo?.apkContentsSigners.orEmpty().toSet()
    else info.signatures.orEmpty().toSet()
