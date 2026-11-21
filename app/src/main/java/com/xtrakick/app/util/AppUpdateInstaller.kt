package com.xtrakick.app.util

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageInstaller
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.Build
import android.widget.Toast
import androidx.core.content.pm.PackageInfoCompat
import com.xtrakick.app.R
import com.xtrakick.app.ui.main.MainActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

internal val activeUpdateSessionId = AtomicInteger(-1)
internal val pendingInstallConfirmationSessionId = AtomicInteger(-1)

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
                val callback = Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    action = MainActivity.INTENT_INSTALL_UPDATE
                }
                activeUpdateSessionId.set(sessionId)
                pendingInstallConfirmationSessionId.set(sessionId)
                session.commit(PendingIntent.getActivity(context, sessionId, callback, PendingIntent.FLAG_MUTABLE).intentSender)
            }
        } catch (error: Exception) {
            activeUpdateSessionId.compareAndSet(sessionId, -1)
            pendingInstallConfirmationSessionId.compareAndSet(sessionId, -1)
            runCatching { installer.abandonSession(sessionId) }
            throw error
        }
    } finally {
        apk.delete()
    }
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
