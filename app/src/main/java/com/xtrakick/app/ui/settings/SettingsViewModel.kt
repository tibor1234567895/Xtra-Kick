package com.xtrakick.app.ui.settings

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInstaller
import android.net.Uri
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.provider.DocumentsContract
import android.util.JsonReader
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.net.toUri
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.AppUpdateInfo
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.repository.RecentSearchRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.ui.main.LiveNotificationWorker
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.getByteArrayCronetCallback
import com.xtrakick.app.util.m3u8.PlaylistUtils
import com.xtrakick.app.util.m3u8.Segment
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine
import kotlin.math.max
import kotlin.system.exitProcess

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val playerRepository: PlayerRepository,
    private val offlineRepository: OfflineRepository,
    private val recentSearchRepository: RecentSearchRepository,
    private val shownNotificationsRepository: ShownNotificationsRepository,
    private val notificationUsersRepository: NotificationUsersRepository,
    private val appDatabase: AppDatabase,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) : ViewModel() {

    val updateInfo = MutableSharedFlow<AppUpdateInfo?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val updateUrl = MutableSharedFlow<String?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    fun consumeUpdateInfo() {
        updateInfo.resetReplayCache()
        updateUrl.resetReplayCache()
    }

    /** Result of scanning app storage for download files with no matching library entry. */
    data class LeftoverFiles(val count: Int, val bytes: Long) {
        val isEmpty get() = count == 0
    }

    val leftoverScan = MutableSharedFlow<LeftoverFiles>()
    val leftoverRestored = MutableSharedFlow<Int>()
    val leftoverDeleted = MutableSharedFlow<Long>()

    /**
     * Files under app storage are unreachable by file managers on Android 11+, so a download
     * removed with "keep files" leaves data the user can neither see nor delete. These three
     * functions make that state visible, recoverable and removable.
     *
     * "Leftover" means a top-level entry in `.downloads` that no OfflineVideo references —
     * matching the same traversal [importDownloads] uses to restore them.
     */
    private suspend fun leftoverEntries(): List<File> {
        val orphans = mutableListOf<File>()
        applicationContext.getExternalFilesDirs(".downloads").forEach { storage ->
            val files = storage?.absolutePath?.let { File(it).listFiles() } ?: return@forEach
            val referencedChatUrls = files.filter { !it.name.endsWith(".json") }
                .flatMap { entry ->
                    when {
                        entry.isDirectory -> entry.listFiles()?.filter { it.name.endsWith(".m3u8") }?.map { it.path }.orEmpty()
                        else -> listOf(entry.path)
                    }
                }
                .mapNotNull { offlineRepository.getVideoByUrl(it)?.chatUrl }
                .toSet()
            files.forEach { entry ->
                when {
                    entry.name.endsWith(".json") -> {
                        if (entry.path !in referencedChatUrls) orphans.add(entry)
                    }
                    entry.isDirectory -> {
                        val playlists = entry.listFiles()?.filter { it.name.endsWith(".m3u8") }.orEmpty()
                        if (playlists.isNotEmpty() && playlists.all { offlineRepository.getVideoByUrl(it.path) == null }) {
                            orphans.add(entry)
                        }
                    }
                    entry.isFile && (entry.name.endsWith(".mp4") || entry.name.endsWith(".ts")) -> {
                        if (offlineRepository.getVideoByUrl(entry.path) == null) orphans.add(entry)
                    }
                }
            }
        }
        return orphans
    }

    private fun File.sizeRecursive(): Long =
        if (isDirectory) walkBottomUp().filter { it.isFile }.sumOf { it.length() } else length()

    fun scanLeftoverFiles() {
        viewModelScope.launch(Dispatchers.IO) {
            val orphans = runCatching { leftoverEntries() }.getOrDefault(emptyList())
            leftoverScan.emit(LeftoverFiles(orphans.size, orphans.sumOf { it.sizeRecursive() }))
        }
    }

    fun deleteLeftoverFiles() {
        viewModelScope.launch(Dispatchers.IO) {
            var freed = 0L
            runCatching {
                leftoverEntries().forEach { entry ->
                    val size = entry.sizeRecursive()
                    if (entry.deleteRecursively()) freed += size
                }
            }
            leftoverDeleted.emit(freed)
        }
    }

    fun deletePositions() {
        viewModelScope.launch {
            playerRepository.deleteVideoPositions()
            offlineRepository.deletePositions()
        }
    }

    fun deleteRecentSearches() {
        viewModelScope.launch {
            recentSearchRepository.deleteAll()
        }
    }

    fun importDownloads() {
        viewModelScope.launch(Dispatchers.IO) {
            var restored = 0
            val chatFiles = mutableMapOf<String, String>()
            applicationContext.getExternalFilesDirs(".downloads").forEach { storage ->
                storage?.absolutePath?.let { directory ->
                    File(directory).listFiles()?.let { files ->
                        files.filter { it.name.endsWith(".json") }.forEach { chatFile ->
                            chatFiles[chatFile.name.removeSuffix(".json").removeSuffix("_chat")] = chatFile.path
                        }
                        files.filter { !it.name.endsWith(".json") }.forEach { file ->
                            if (file.isDirectory) {
                                file.listFiles()?.filter { it.name.endsWith(".m3u8") }?.forEach { playlistFile ->
                                        val existingVideo = offlineRepository.getVideoByUrl(playlistFile.path)
                                        if (existingVideo == null) {
                                            val playlist = FileInputStream(playlistFile).use {
                                                PlaylistUtils.parseMediaPlaylist(it)
                                            }
                                            var totalDuration = 0L
                                            val segments = ArrayList<Segment>()
                                            playlist.segments.forEach { segment ->
                                                totalDuration += (segment.duration * 1000f).toLong()
                                                segments.add(segment.copy(uri = segment.uri.substringAfterLast("%2F").substringAfterLast("/")))
                                            }
                                            FileOutputStream(playlistFile).use {
                                                PlaylistUtils.writeMediaPlaylist(playlist.copy(
                                                    initSegmentUri = playlist.initSegmentUri?.substringAfterLast("%2F")?.substringAfterLast("/"),
                                                    segments = segments
                                                ), it)
                                            }
                                            val chatFile = chatFiles[file.name + playlistFile.name.removeSuffix(".m3u8")]
                                            var id: String? = null
                                            var title: String? = null
                                            var uploadDate: Long? = null
                                            var channelId: String? = null
                                            var channelLogin: String? = null
                                            var channelName: String? = null
                                            var gameId: String? = null
                                            var gameSlug: String? = null
                                            var gameName: String? = null
                                            chatFile?.let { uri ->
                                                try {
                                                    FileInputStream(File(uri)).bufferedReader().use { fileReader ->
                                                        JsonReader(fileReader).use { reader ->
                                                            reader.beginObject()
                                                            while (reader.hasNext()) {
                                                                when (reader.nextName()) {
                                                                    "video" -> {
                                                                        reader.beginObject()
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName()) {
                                                                                "id" -> id = reader.nextString()
                                                                                "title" -> title = reader.nextString()
                                                                                "uploadDate" -> uploadDate = reader.nextLong()
                                                                                "channelId" -> channelId = reader.nextString()
                                                                                "channelLogin" -> channelLogin = reader.nextString()
                                                                                "channelName" -> channelName = reader.nextString()
                                                                                "gameId" -> gameId = reader.nextString()
                                                                                "gameSlug" -> gameSlug = reader.nextString()
                                                                                "gameName" -> gameName = reader.nextString()
                                                                                else -> reader.skipValue()
                                                                            }
                                                                        }
                                                                        reader.endObject()
                                                                    }
                                                                    else -> reader.skipValue()
                                                                }
                                                            }
                                                            reader.endObject()
                                                        }
                                                    }
                                                } catch (e: Exception) {

                                                }
                                            }
                                            restored++
                                            restored++
                                    offlineRepository.saveVideo(
                                                OfflineVideo(
                                                    url = playlistFile.path,
                                                    name = if (!title.isNullOrBlank()) title else Uri.decode(file.name),
                                                    channelId = if (!channelId.isNullOrBlank()) channelId else null,
                                                    channelLogin = if (!channelLogin.isNullOrBlank()) channelLogin else null,
                                                    channelName = if (!channelName.isNullOrBlank()) channelName else null,
                                                    thumbnail = file.path + File.separator + segments.getOrNull(max(0, (segments.size / 2) - 1))?.uri,
                                                    gameId = if (!gameId.isNullOrBlank()) gameId else null,
                                                    gameSlug = if (!gameSlug.isNullOrBlank()) gameSlug else null,
                                                    gameName = if (!gameName.isNullOrBlank()) gameName else null,
                                                    duration = totalDuration,
                                                    uploadDate = uploadDate,
                                                    progress = 100,
                                                    maxProgress = 100,
                                                    status = OfflineVideo.STATUS_DOWNLOADED,
                                                    videoId = if (!id.isNullOrBlank()) id else null,
                                                    chatUrl = chatFile
                                                )
                                            )
                                        }
                                    }
                            } else if (file.isFile && (file.name.endsWith(".mp4") || file.name.endsWith(".ts"))) {
                                val existingVideo = offlineRepository.getVideoByUrl(file.path)
                                if (existingVideo == null) {
                                    val fileName = file.name.removeSuffix(".mp4").removeSuffix(".ts")
                                    val chatFile = chatFiles[fileName]
                                    var id: String? = null
                                    var title: String? = null
                                    var uploadDate: Long? = null
                                    var channelId: String? = null
                                    var channelLogin: String? = null
                                    var channelName: String? = null
                                    var gameId: String? = null
                                    var gameSlug: String? = null
                                    var gameName: String? = null
                                    chatFile?.let { uri ->
                                        try {
                                            FileInputStream(File(uri)).bufferedReader().use { fileReader ->
                                                JsonReader(fileReader).use { reader ->
                                                    reader.beginObject()
                                                    while (reader.hasNext()) {
                                                        when (reader.nextName()) {
                                                            "video" -> {
                                                                reader.beginObject()
                                                                while (reader.hasNext()) {
                                                                    when (reader.nextName()) {
                                                                        "id" -> id = reader.nextString()
                                                                        "title" -> title = reader.nextString()
                                                                        "uploadDate" -> uploadDate = reader.nextLong()
                                                                        "channelId" -> channelId = reader.nextString()
                                                                        "channelLogin" -> channelLogin = reader.nextString()
                                                                        "channelName" -> channelName = reader.nextString()
                                                                        "gameId" -> gameId = reader.nextString()
                                                                        "gameSlug" -> gameSlug = reader.nextString()
                                                                        "gameName" -> gameName = reader.nextString()
                                                                        else -> reader.skipValue()
                                                                    }
                                                                }
                                                                reader.endObject()
                                                            }
                                                            else -> reader.skipValue()
                                                        }
                                                    }
                                                    reader.endObject()
                                                }
                                            }
                                        } catch (e: Exception) {

                                        }
                                    }
                                    offlineRepository.saveVideo(
                                        OfflineVideo(
                                            url = file.path,
                                            name = if (!title.isNullOrBlank()) title else Uri.decode(fileName),
                                            channelId = if (!channelId.isNullOrBlank()) channelId else null,
                                            channelLogin = if (!channelLogin.isNullOrBlank()) channelLogin else null,
                                            channelName = if (!channelName.isNullOrBlank()) channelName else null,
                                            thumbnail = id?.takeIf { it.isNotBlank() }
                                                ?.let { File(applicationContext.filesDir, "thumbnails${File.separator}$it") }
                                                ?.takeIf { it.exists() }?.path
                                                ?: file.path,
                                            gameId = if (!gameId.isNullOrBlank()) gameId else null,
                                            gameSlug = if (!gameSlug.isNullOrBlank()) gameSlug else null,
                                            gameName = if (!gameName.isNullOrBlank()) gameName else null,
                                            uploadDate = uploadDate,
                                            progress = 100,
                                            maxProgress = 100,
                                            status = OfflineVideo.STATUS_DOWNLOADED,
                                            videoId = if (!id.isNullOrBlank()) id else null,
                                            chatUrl = chatFile
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
            leftoverRestored.emit(restored)
        }
    }

    fun checkUpdates(networkLibrary: String?, url: String, lastChecked: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            if (BuildConfig.DEBUG && applicationContext.prefs().getBoolean(AppConstants.DEBUG_MOCK_UPDATE_AVAILABLE, false)) {
                val mockTime = System.currentTimeMillis() + 86_400_000L
                if (mockTime > lastChecked) {
                    val mockInfo = AppUpdateInfo(
                        downloadUrl = "https://github.com/tibor1234567895/Xtra-Kick/releases/latest",
                        size = 25_000_000L,
                        updatedAt = mockTime,
                        releaseTitle = "v99.0.0 (Debug Test Update)",
                        releaseNotes = "### Simulated Release Notes\n- Verified in-app updater startup checks\n- Verified Remind Me Later and Skip actions"
                    )
                    updateInfo.emit(mockInfo)
                    updateUrl.emit(mockInfo.downloadUrl)
                    return@launch
                }
            }
            val updateInfoResult: AppUpdateInfo? = try {
                val response = when {
                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                        val response = suspendCoroutine { continuation ->
                            httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                        }
                        json.decodeFromString<JsonObject>(String(response.second))
                    }
                    networkLibrary == "Cronet" && cronetEngine != null -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                            cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                            val response = request.future.get().responseBody as String
                            json.decodeFromString<JsonObject>(response)
                        } else {
                            val response = suspendCoroutine { continuation ->
                                cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                            }
                            json.decodeFromString<JsonObject>(String(response.second))
                        }
                    }
                    else -> {
                        okHttpClient.newCall(Request.Builder().url(url).build()).execute().use { response ->
                            json.decodeFromString<JsonObject>(response.body.string())
                        }
                    }
                }
                val releaseNotes = response["body"]?.jsonPrimitive?.contentOrNull
                val releaseTitle = response["name"]?.jsonPrimitive?.contentOrNull ?: response["tag_name"]?.jsonPrimitive?.contentOrNull
                response["assets"]?.jsonArray?.find {
                    val asset = it.jsonObject
                    asset["content_type"]?.jsonPrimitive?.contentOrNull == "application/vnd.android.package-archive" ||
                        (asset["name"]?.jsonPrimitive?.contentOrNull)?.endsWith(".apk") == true
                }?.jsonObject?.let { obj ->
                    val updatedAt = obj["updated_at"]?.jsonPrimitive?.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }
                        ?: response["published_at"]?.jsonPrimitive?.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }
                        ?: response["created_at"]?.jsonPrimitive?.contentOrNull?.let { KickApiHelper.parseIso8601DateUTC(it) }
                    val downloadUrl = obj["browser_download_url"]?.jsonPrimitive?.contentOrNull
                    val size = obj["size"]?.jsonPrimitive?.longOrNull
                    if (updatedAt != null && downloadUrl != null && updatedAt > lastChecked) {
                        AppUpdateInfo(
                            downloadUrl = downloadUrl,
                            size = size,
                            updatedAt = updatedAt,
                            releaseTitle = releaseTitle,
                            releaseNotes = releaseNotes
                        )
                    } else null
                }
            } catch (e: Exception) {
                DiagnosticLogger.e("SettingsViewModel", "checkUpdates failed", e)
                null
            }
            updateInfo.emit(updateInfoResult)
            updateUrl.emit(updateInfoResult?.downloadUrl)
        }
    }

    fun downloadUpdate(networkLibrary: String?, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = when {
                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                        val response = suspendCoroutine { continuation ->
                            httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                        }
                        if (response.first.httpStatusCode in 200..299) {
                            response.second
                        } else null
                    }
                    networkLibrary == "Cronet" && cronetEngine != null -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                            cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                            val response = request.future.get()
                            if (response.urlResponseInfo.httpStatusCode in 200..299) {
                                response.responseBody as ByteArray
                            } else null
                        } else {
                            val response = suspendCoroutine { continuation ->
                                cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                            }
                            if (response.first.httpStatusCode in 200..299) {
                                response.second
                            } else null
                        }
                    }
                    else -> {
                        okHttpClient.newCall(Request.Builder().url(url).build()).execute().use { response ->
                            if (response.isSuccessful) {
                                response.body.bytes()
                            } else null
                        }
                    }
                }
                if (response != null && response.isNotEmpty()) {
                    val packageInstaller = applicationContext.packageManager.packageInstaller
                    val sessionId = packageInstaller.createSession(
                        PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL)
                    )
                    val session = packageInstaller.openSession(sessionId)
                    session.openWrite("package", 0, response.size.toLong()).use {
                        it.write(response)
                    }
                    session.commit(
                        PendingIntent.getActivity(
                            applicationContext,
                            0,
                            Intent(applicationContext, MainActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                                setAction(MainActivity.INTENT_INSTALL_UPDATE)
                            },
                            PendingIntent.FLAG_MUTABLE
                        ).intentSender
                    )
                    session.close()
                }
            } catch (e: Exception) {

            }
        }
    }

    fun backupSettings(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val documentId = DocumentsContract.getTreeDocumentId(url.toUri())
            val directoryUri = DocumentsContract.buildDocumentUriUsingTree(url.toUri(), documentId)
            val preferences = File("${applicationContext.applicationInfo.dataDir}/shared_prefs/${applicationContext.packageName}_preferences.xml")
            val preferencesUri = directoryUri.toString() + (if (!directoryUri.toString().endsWith("%3A")) "%2F" else "") + preferences.name
            try {
                applicationContext.contentResolver.openOutputStream(preferencesUri.toUri())!!
            } catch (e: IllegalArgumentException) {
                DocumentsContract.createDocument(applicationContext.contentResolver, directoryUri, "", preferences.name)
                applicationContext.contentResolver.openOutputStream(preferencesUri.toUri())!!
            }.use { outputStream ->
                preferences.inputStream().use { inputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
            appDatabase.query(SimpleSQLiteQuery("PRAGMA wal_checkpoint(FULL)")).use {
                it.moveToPosition(-1)
            }
            val database = applicationContext.getDatabasePath("database")
            val databaseUri = directoryUri.toString() + (if (!directoryUri.toString().endsWith("%3A")) "%2F" else "") + database.name
            try {
                applicationContext.contentResolver.openOutputStream(databaseUri.toUri())!!
            } catch (e: IllegalArgumentException) {
                DocumentsContract.createDocument(applicationContext.contentResolver, directoryUri, "", database.name)
                applicationContext.contentResolver.openOutputStream(databaseUri.toUri())!!
            }.use { outputStream ->
                database.inputStream().use { inputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        }
    }

    fun restoreSettings(list: List<String>, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        viewModelScope.launch(Dispatchers.IO) {
            list.take(2).forEach { url ->
                if (url.endsWith(".xml")) {
                    FileOutputStream("${applicationContext.applicationInfo.dataDir}/shared_prefs/${applicationContext.packageName}_preferences.xml").use { outputStream ->
                        applicationContext.contentResolver.openInputStream(url.toUri())!!.use { inputStream ->
                            inputStream.copyTo(outputStream)
                        }
                    }
                    val prefs = applicationContext.contentResolver.openInputStream(url.toUri())!!.bufferedReader().use {
                        it.readText()
                    }
                    toggleNotifications(prefs.contains("name=\"${AppConstants.LIVE_NOTIFICATIONS_ENABLED}\" value=\"true\""), networkLibrary, kickWebHeaders, kickPublicApiHeaders)
                    val language = Regex("<string name=\"${AppConstants.UI_LANGUAGE}\">(.+?)</string>").find(prefs)?.groups?.get(1)?.value
                    AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(language.takeIf { it != "auto" }))
                } else {
                    val database = applicationContext.getDatabasePath("database")
                    File(database.parent, "database-shm").delete()
                    File(database.parent, "database-wal").delete()
                    database.outputStream().use { outputStream ->
                        applicationContext.contentResolver.openInputStream(url.toUri())!!.use { inputStream ->
                            inputStream.copyTo(outputStream)
                        }
                    }
                    applicationContext.startActivity(
                        Intent(applicationContext, MainActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        }
                    )
                    exitProcess(0)
                }
            }
        }
    }

    fun toggleNotifications(enabled: Boolean, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        viewModelScope.launch(Dispatchers.IO) {
            if (enabled) {
                val newStreams = shownNotificationsRepository.getNewKickStreams(notificationUsersRepository)
                if (newStreams.isNotEmpty()) {
                    shownNotificationsRepository.showLiveNotifications(applicationContext, newStreams)
                }
                if (applicationContext.prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_POLLING_BACKUP, false)) {
                    schedulePollingBackup()
                } else {
                    WorkManager.getInstance(applicationContext).cancelUniqueWork("live_notifications")
                }
            } else {
                WorkManager.getInstance(applicationContext).cancelUniqueWork("live_notifications")
            }
        }
    }

    fun togglePollingBackup(enabled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (enabled && applicationContext.prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false)) {
                schedulePollingBackup()
            } else {
                WorkManager.getInstance(applicationContext).cancelUniqueWork("live_notifications")
            }
        }
    }

    private fun schedulePollingBackup() {
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            "live_notifications",
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            PeriodicWorkRequestBuilder<LiveNotificationWorker>(15, TimeUnit.MINUTES)
                .setInitialDelay(1, TimeUnit.MINUTES)
                .setConstraints(
                    Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build()
                )
                .build()
        )
    }
}
