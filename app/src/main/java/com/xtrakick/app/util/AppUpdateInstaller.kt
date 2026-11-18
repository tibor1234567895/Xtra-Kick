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
import androidx.core.content.pm.PackageInfoCompat
import com.xtrakick.app.ui.main.MainActivity
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import java.io.File
import java.io.IOException
import java.io.OutputStream

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
                session.commit(PendingIntent.getActivity(context, sessionId, callback, PendingIntent.FLAG_MUTABLE).intentSender)
            }
        } catch (error: Exception) {
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
