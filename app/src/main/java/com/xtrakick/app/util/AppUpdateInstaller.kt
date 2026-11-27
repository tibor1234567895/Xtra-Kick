package com.xtrakick.app.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageInstaller
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.net.Uri
import android.os.Build
import android.provider.Settings
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
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

internal class UpdateInstallException(message: String, cause: Throwable? = null) : IOException(message, cause)

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
            } catch (e: CancellationException) {
                throw e
            } catch (e: UpdateInstallException) {
                DiagnosticLogger.e(logTag, "downloadUpdate failed", e)
                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, R.string.update_install_failed, Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
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
    val downloadClient = okHttpClient.newBuilder()
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    var bytesRead = 0L
    val status = executeUpdateCall(downloadClient, url) { response ->
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
        commitApkUpdateSession(context, apk)
    } finally {
        apk.delete()
    }
}

private fun createApkUpdateSession(context: Context, apk: File): Int =
    runCatching {
        context.packageManager.packageInstaller.createSession(
            PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL).apply {
                setAppPackageName(context.packageName)
                setSize(apk.length())
            }
        )
    }.getOrElse { error ->
        throw UpdateInstallException("Could not create package installer session", error)
    }

private suspend fun commitApkUpdateSession(context: Context, apk: File) {
    val installer = context.packageManager.packageInstaller
    val sessionId = createApkUpdateSession(context, apk)
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
            val pendingIntentFlags = PendingIntent.FLAG_UPDATE_CURRENT or
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_MUTABLE else 0
            session.commit(PendingIntent.getBroadcast(context, sessionId, callback, pendingIntentFlags).intentSender)
        }
    } catch (error: CancellationException) {
        runCatching { installer.abandonSession(sessionId) }
        throw error
    } catch (error: Exception) {
        runCatching { installer.abandonSession(sessionId) }
        throw UpdateInstallException("Could not commit package installer session", error)
    }
}

private data class PendingInstallConfirmation(val sessionId: Int, val intent: Intent)

private val pendingInstallConfirmation = MutableStateFlow<PendingInstallConfirmation?>(null)

internal fun clearPendingInstallConfirmationForTests() {
    pendingInstallConfirmation.value = null
}

private const val PENDING_INSTALL_CONFIRMATION = "pending_install_confirmation"
private const val PENDING_UPDATE_DOWNLOAD_URL = "pending_update_download_url"
private const val PENDING_UPDATE_DOWNLOAD_SIZE = "pending_update_download_size"
private const val PENDING_UPDATE_DOWNLOAD_SAVED_AT = "pending_update_download_saved_at"
private const val PENDING_UPDATE_DOWNLOAD_TTL_MS = 10 * 60 * 1000L

/**
 * Persists a pending in-app update across process death / config changes while the user
 * toggles "Allow from this source" in system Settings (Android 11+ / Samsung One UI often
 * kills the app process immediately when REQUEST_INSTALL_PACKAGES changes).
 */
internal fun Context.savePendingUpdateDownload(url: String, expectedSize: Long?, now: Long = System.currentTimeMillis()) {
    if (!isTrustedUpdateUrl(url)) return
    prefs().edit {
        putString(PENDING_UPDATE_DOWNLOAD_URL, url)
        putLong(PENDING_UPDATE_DOWNLOAD_SIZE, expectedSize ?: -1L)
        putLong(PENDING_UPDATE_DOWNLOAD_SAVED_AT, now)
    }
}

internal fun Context.clearPendingUpdateDownload() {
    prefs().edit {
        remove(PENDING_UPDATE_DOWNLOAD_URL)
        remove(PENDING_UPDATE_DOWNLOAD_SIZE)
        remove(PENDING_UPDATE_DOWNLOAD_SAVED_AT)
    }
}

internal fun Context.consumePendingUpdateDownloadIfPermitted(now: Long = System.currentTimeMillis()): Pair<String, Long?>? {
    val sharedPrefs = prefs()
    val url = sharedPrefs.getString(PENDING_UPDATE_DOWNLOAD_URL, null) ?: return null
    val savedAt = sharedPrefs.getLong(PENDING_UPDATE_DOWNLOAD_SAVED_AT, 0L)
    val expired = savedAt <= 0L || now < savedAt || now - savedAt > PENDING_UPDATE_DOWNLOAD_TTL_MS
    if (expired || !isTrustedUpdateUrl(url)) {
        clearPendingUpdateDownload()
        return null
    }
    if (!packageManager.canRequestPackageInstalls()) return null
    val size = sharedPrefs.getLong(PENDING_UPDATE_DOWNLOAD_SIZE, -1L).takeIf { it >= 0L }
    clearPendingUpdateDownload()
    return url to size
}

class AppUpdateResultReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val sessionId = intent.getIntExtra(PackageInstaller.EXTRA_SESSION_ID, -1)
        if (intent.action != ACTION_INSTALL_RESULT || sessionId <= 0) return
        val prefs = context.prefs()
        val status = intent.getIntExtra(PackageInstaller.EXTRA_STATUS, PackageInstaller.STATUS_FAILURE)
        if (status == PackageInstaller.STATUS_PENDING_USER_ACTION) {
            val confirmation = IntentCompat.getParcelableExtra(intent, Intent.EXTRA_INTENT, Intent::class.java)
            if (confirmation != null && context.isSystemInstallerIntent(confirmation)) {
                // Keep the exact Intent in-process (preserving non-primitive extras), with a
                // non-secret prefs() URI fallback for process death (avoiding main-thread Keystore IPC).
                prefs.edit {
                    putString(PENDING_INSTALL_CONFIRMATION, "$sessionId|${confirmation.toUri(Intent.URI_INTENT_SCHEME)}")
                }
                pendingInstallConfirmation.value = PendingInstallConfirmation(sessionId, Intent(confirmation))
                return
            }
            runCatching { context.packageManager.packageInstaller.abandonSession(sessionId) }
            DiagnosticLogger.e(
                "AppUpdate",
                "Rejected install confirmation: session=$sessionId action=${confirmation?.action} " +
                    "pkg=${confirmation?.`package`} component=${confirmation?.component} hasData=${confirmation?.data != null}"
            )
            Toast.makeText(context, R.string.update_install_failed, Toast.LENGTH_LONG).show()
            return
        }
        if (pendingInstallConfirmation.value?.sessionId == sessionId) {
            pendingInstallConfirmation.value = null
        }
        if (prefs.getString(PENDING_INSTALL_CONFIRMATION, null)?.substringBefore('|') == sessionId.toString()) {
            prefs.edit { remove(PENDING_INSTALL_CONFIRMATION) }
        }
        if (status == PackageInstaller.STATUS_SUCCESS || status == PackageInstaller.STATUS_FAILURE_ABORTED) return
        val statusMessage = intent.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE)
        DiagnosticLogger.e("AppUpdate", "Update install failed: status=$status msg=$statusMessage")
        Toast.makeText(context, R.string.update_install_failed, Toast.LENGTH_LONG).show()
    }

    companion object {
        internal const val ACTION_INSTALL_RESULT = "com.xtrakick.app.INSTALL_UPDATE_RESULT"
    }
}

internal fun ComponentActivity.observeAppUpdateResults() {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.RESUMED) {
            showPendingAppUpdateConfirmation()
            pendingInstallConfirmation.collect { pending ->
                if (pending != null) {
                    showPendingAppUpdateConfirmation()
                }
            }
        }
    }
}

private fun Activity.showPendingAppUpdateConfirmation() {
    val prefs = prefs()
    val inMemory = pendingInstallConfirmation.getAndUpdate { null }
    val pendingPref = prefs.getString(PENDING_INSTALL_CONFIRMATION, null)
    if (inMemory == null && pendingPref == null) return
    try {
        val sessionId = inMemory?.sessionId ?: pendingPref?.substringBefore('|')?.toIntOrNull() ?: return
        if (packageManager.packageInstaller.getSessionInfo(sessionId) == null) return
        val confirmation = inMemory?.intent ?: Intent.parseUri(pendingPref!!.substringAfter('|'), Intent.URI_INTENT_SCHEME)
        check(isSystemInstallerIntent(confirmation))
        startActivity(confirmation)
        tokenPrefs().edit { putLong(AppConstants.UPDATE_LAST_CHECKED, System.currentTimeMillis()) }
    } catch (error: Exception) {
        DiagnosticLogger.e("AppUpdate", "Could not launch update confirmation", error)
        runCatching {
            startActivity(Intent(Intent.ACTION_VIEW, "https://github.com/tibor1234567895/Xtra-Kick/releases/latest".toUri()))
        }.onFailure { Toast.makeText(this, R.string.update_install_failed, Toast.LENGTH_LONG).show() }
    } finally {
        prefs.edit { remove(PENDING_INSTALL_CONFIRMATION) }
    }
}

internal fun Context.isSystemInstallerIntent(candidate: Intent): Boolean {
    if (candidate.clipData != null || candidate.selector != null) return false
    val uriGrantFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION or
        Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION or Intent.FLAG_GRANT_PREFIX_URI_PERMISSION
    if ((candidate.flags and uriGrantFlags) != 0) return false
    val isUnknownSourcesForSelf = candidate.action == Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES &&
        candidate.data == Uri.fromParts("package", packageName, null)
    if (candidate.data != null && !isUnknownSourcesForSelf) return false
    when (candidate.action) {
        Intent.ACTION_CHOOSER, Intent.ACTION_SEND, Intent.ACTION_SEND_MULTIPLE, Intent.ACTION_VIEW -> return false
        "android.content.pm.action.CONFIRM_INSTALL",
        "android.content.pm.action.CONFIRM_PERMISSIONS",
        "android.content.pm.action.CONFIRM_PRE_APPROVAL",
        Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES -> Unit
        else -> if (candidate.component == null && candidate.`package` == null) return false
    }
    val resolved = packageManager.resolveActivity(candidate, PackageManager.MATCH_DEFAULT_ONLY)
        ?: packageManager.resolveActivity(candidate, 0)
        ?: return false
    val appInfo = resolved.activityInfo?.applicationInfo ?: return false
    return appInfo.flags and (ApplicationInfo.FLAG_SYSTEM or ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0
}

internal fun verifyAppUpdate(context: Context, apk: File) {
    val failureMessage = runCatching {
        validateAppUpdateArchive(context, apk)
    }.getOrElse { error ->
        throw UpdateInstallException("Could not verify downloaded APK", error)
    }
    if (failureMessage != null) {
        throw UpdateInstallException(failureMessage)
    }
}

@Suppress("DEPRECATION")
@SuppressLint("PackageManagerGetSignatures")
private fun validateAppUpdateArchive(context: Context, apk: File): String? {
    val manager = context.packageManager
    // Combine GET_SIGNING_CERTIFICATES and GET_SIGNATURES on API 28+ to work around
    // AOSP #243324820 / #159537841 where getPackageArchiveInfo returns null signingInfo
    // on Android 9-13 unless GET_SIGNATURES is also requested.
    val flags = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        PackageManager.GET_SIGNING_CERTIFICATES or PackageManager.GET_SIGNATURES
    } else {
        PackageManager.GET_SIGNATURES
    }
    val candidate = manager.getPackageArchiveInfo(apk.absolutePath, flags)
        ?: return "Update is not a readable APK"
    if (candidate.packageName != context.packageName) {
        return "Update package does not match the installed app"
    }

    val installed = readInstalledPackageInfo(manager, context.packageName, flags)
    val installedSigners = apkSigners(installed)
    var candidateSigners = apkSigners(candidate)
    if (candidateSigners.isEmpty() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        manager.getPackageArchiveInfo(apk.absolutePath, PackageManager.GET_SIGNATURES)?.let { fallback ->
            candidateSigners = apkSigners(fallback)
        }
    }
    if (installedSigners.isEmpty() || candidateSigners != installedSigners) {
        return "Update signing certificate does not match the installed app " +
            "(installed=${installedSigners.size}, candidate=${candidateSigners.size})"
    }
    if (PackageInfoCompat.getLongVersionCode(candidate) <= PackageInfoCompat.getLongVersionCode(installed)) {
        return "Update is not newer than the installed app"
    }
    return null
}

@Suppress("DEPRECATION")
private fun readInstalledPackageInfo(manager: PackageManager, packageName: String, flags: Int): PackageInfo =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        manager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(flags.toLong()))
    } else {
        manager.getPackageInfo(packageName, flags)
    }

@Suppress("DEPRECATION")
internal fun apkSigners(info: PackageInfo): Set<Signature> {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val signers = info.signingInfo?.apkContentsSigners
        if (!signers.isNullOrEmpty()) return signers.toSet()
    }
    return info.signatures.orEmpty().toSet()
}
