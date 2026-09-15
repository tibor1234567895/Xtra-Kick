package com.xtrakick.app.ui.settings

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInstaller
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.provider.DocumentsContract
import android.provider.OpenableColumns
import android.util.JsonReader
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.sqlite.db.SimpleSQLiteQuery
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.model.AppUpdateInfo
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.NotificationUsersRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.repository.RecentSearchRepository
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.cancelLiveNotificationsPollingWork
import com.xtrakick.app.util.enqueueLiveNotificationsPollingWork
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
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
import java.io.InputStream
import java.util.concurrent.ExecutorService
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
    data class LeftoverFiles(
        val count: Int,
        val bytes: Long,
        val restorableCount: Int = 0,
        val names: List<String> = emptyList(),
    ) {
        val isEmpty get() = count == 0
    }

    val leftoverScan = MutableSharedFlow<LeftoverFiles>()
    val leftoverRestored = MutableSharedFlow<Int>()
    val leftoverDeleted = MutableSharedFlow<Long>()
    val backupStatus = MutableSharedFlow<String>()
    val restoreStatus = MutableSharedFlow<String>()

    /**
     * Files under app storage are unreachable by file managers on Android 11+, so a download
     * removed with "keep files" leaves data the user can neither see nor delete. These three
     * functions make that state visible, recoverable and removable.
     *
     * "Leftover" means a top-level entry in `.downloads` that no OfflineVideo references —
     * matching the same traversal [importDownloads] uses to restore them — plus unreferenced
     * top-level entries in the shared-storage download folder, which the app-storage-only
     * traversal above can never see. Shared entries support delete but not restore.
     */
    private data class SharedLeftover(val uri: Uri, val name: String, val bytes: Long)

    private suspend fun referencedSharedDocIds(): Set<String> {
        return runCatching {
            val ids = hashSetOf<String>()
            val videos = offlineRepository.getAllVideos()
            (videos.mapNotNull { it.url } + videos.mapNotNull { it.chatUrl }).forEach { url ->
                runCatching { DocumentsContract.getDocumentId(url.toUri()) }.getOrNull()?.let { ids.add(it) }
            }
            ids
        }.getOrDefault(emptySet())
    }

    private fun queryChildDocs(treeUri: Uri, parentDocId: String): List<Triple<String, String, Long>> {
        // (documentId, mimeType, size). parentDocId is explicit because tree roots
        // and child documents need different ID functions; mixing them throws.
        val children = mutableListOf<Triple<String, String, Long>>()
        runCatching {
            val childrenUri = DocumentsContract.buildChildDocumentsUriUsingTree(treeUri, parentDocId)
            applicationContext.contentResolver.query(
                childrenUri,
                arrayOf(
                    DocumentsContract.Document.COLUMN_DOCUMENT_ID,
                    DocumentsContract.Document.COLUMN_MIME_TYPE,
                    DocumentsContract.Document.COLUMN_SIZE
                ),
                null, null, null
            )?.use { cursor ->
                val idCol = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DOCUMENT_ID)
                val mimeCol = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_MIME_TYPE)
                val sizeCol = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_SIZE)
                while (cursor.moveToNext()) {
                    children.add(
                        Triple(
                            cursor.getString(idCol) ?: continue,
                            cursor.getString(mimeCol).orEmpty(),
                            if (sizeCol >= 0) cursor.getLong(sizeCol) else 0L
                        )
                    )
                }
            }
        }.onFailure {
            DiagnosticLogger.w("LeftoverScan", "child query failed for $parentDocId: ${it.message}")
        }
        return children
    }

    private fun sharedDirSize(treeUri: Uri, docId: String): Long {
        var total = 0L
        val stack = ArrayDeque<String>().apply { add(docId) }
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            queryChildDocs(treeUri, current).forEach { (childId, childMime, childSize) ->
                if (childMime == DocumentsContract.Document.MIME_TYPE_DIR) {
                    stack.add(childId)
                } else {
                    total += childSize
                }
            }
        }
        return total
    }

    private suspend fun sharedLeftoverEntries(): List<SharedLeftover> {
        val orphans = mutableListOf<SharedLeftover>()
        val treeUriString = applicationContext.prefs().getString(AppConstants.DOWNLOAD_SHARED_PATH, null)
            ?.takeIf { it.isNotBlank() } ?: run {
                DiagnosticLogger.w("LeftoverScan", "shared scan skipped: no shared path pref")
                return orphans
            }
        val treeUri = runCatching { treeUriString.toUri() }.getOrNull() ?: run {
            DiagnosticLogger.w("LeftoverScan", "shared scan skipped: bad tree uri")
            return orphans
        }
        val referenced = referencedSharedDocIds()
        val rootDocId = runCatching { DocumentsContract.getTreeDocumentId(treeUri) }.getOrNull() ?: run {
            DiagnosticLogger.w("LeftoverScan", "shared scan skipped: not a tree uri")
            return orphans
        }
        val topLevel = queryChildDocs(treeUri, rootDocId)
        DiagnosticLogger.w("LeftoverScan", "shared scan: tree=$treeUriString children=${topLevel.size} referenced=${referenced.size}")
        topLevel.forEach { (docId, mimeType, size) ->
            // Only download-shaped entries qualify: the folder is user-visible and
            // may hold personal files, which must never be flagged. Matches the
            // app-storage rule: clip chat dumps, loose media files, playlist dirs.
            val name = docId.substringAfterLast('/')
            val isDir = mimeType == DocumentsContract.Document.MIME_TYPE_DIR
            // Never flag settings-backup exports: they live in user-picked folders
            // by design and must survive any cleanup.
            if (!isDir && (name.endsWith(".xml", ignoreCase = true) ||
                        name.equals("database", ignoreCase = true) ||
                        name.endsWith(".db", ignoreCase = true) ||
                        name.endsWith(".sqlite", ignoreCase = true) ||
                        name.endsWith(".zip", ignoreCase = true))
            ) {
                return@forEach
            }
            val looksLikeDownload = if (isDir) {
                queryChildDocs(treeUri, docId).any {
                    it.first.substringAfterLast('/').endsWith(".m3u8", ignoreCase = true)
                }
            } else {
                name.endsWith("_chat.json", ignoreCase = true) ||
                    name.endsWith(".mp4", ignoreCase = true) ||
                    name.endsWith(".ts", ignoreCase = true)
            }
            if (!looksLikeDownload) return@forEach
            val stillReferenced = referenced.any { it == docId || it.startsWith("$docId/") }
            if (!stillReferenced) {
                val bytes = if (isDir) {
                    runCatching { sharedDirSize(treeUri, docId) }.getOrDefault(0L)
                } else {
                    size
                }
                orphans.add(
                    SharedLeftover(
                        uri = DocumentsContract.buildDocumentUriUsingTree(treeUri, docId),
                        name = name.substringAfter(':'),
                        bytes = bytes
                    )
                )
            }
        }
        return orphans
    }
    private suspend fun leftoverEntries(): List<File> {
        val orphans = mutableListOf<File>()
        val allVideos = offlineRepository.getAllVideos()
        val videoByUrl = allVideos.associateBy { it.url }
        val referencedChatUrls = allVideos.mapNotNullTo(hashSetOf()) { it.chatUrl }
        applicationContext.getExternalFilesDirs(".downloads").forEach { storage ->
            val files = storage?.absolutePath?.let { File(it).listFiles() } ?: return@forEach
            files.forEach { entry ->
                when {
                    entry.name.endsWith(".json") -> {
                        if (entry.path !in referencedChatUrls) orphans.add(entry)
                    }
                    entry.isDirectory -> {
                        val playlists = entry.listFiles()?.filter { it.name.endsWith(".m3u8") }.orEmpty()
                        if (playlists.isNotEmpty() && playlists.all { videoByUrl[it.path] == null }) {
                            orphans.add(entry)
                        }
                    }
                    entry.isFile && (entry.name.endsWith(".mp4") || entry.name.endsWith(".ts")) -> {
                        if (videoByUrl[entry.path] == null) orphans.add(entry)
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
            val sharedOrphans = runCatching { sharedLeftoverEntries() }.getOrDefault(emptyList())
            leftoverScan.emit(
                LeftoverFiles(
                    count = orphans.size + sharedOrphans.size,
                    bytes = orphans.sumOf { it.sizeRecursive() } + sharedOrphans.sumOf { it.bytes },
                    restorableCount = orphans.size,
                    names = (orphans.map { it.name } + sharedOrphans.map { it.name }).take(12)
                )
            )
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
                sharedLeftoverEntries().forEach { entry ->
                    if (runCatching { DocumentsContract.deleteDocument(applicationContext.contentResolver, entry.uri) }.getOrDefault(false)) {
                        freed += entry.bytes
                    }
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
                val packageInstaller = applicationContext.packageManager.packageInstaller
                val sessionId = packageInstaller.createSession(
                    PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL)
                )
                packageInstaller.openSession(sessionId).use { session ->
                    try {
                        session.openWrite("package", 0, -1).use { output ->
                            playerRepository.downloadTo(networkLibrary, url, output)
                            session.fsync(output)
                        }
                        kotlinx.coroutines.currentCoroutineContext().ensureActive()
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
                    } catch (error: Exception) {
                        session.abandon()
                        throw error
                    }
                }
            } catch (e: Exception) {

            }
        }
    }

    fun backupSettings(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val treeUri = url.toUri()
                runCatching {
                    applicationContext.contentResolver.takePersistableUriPermission(
                        treeUri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                    )
                }
                val documentId = DocumentsContract.getTreeDocumentId(treeUri)
                val directoryUri = DocumentsContract.buildDocumentUriUsingTree(treeUri, documentId)
                val preferences = File("${applicationContext.applicationInfo.dataDir}/shared_prefs/${applicationContext.packageName}_preferences.xml")
                if (!preferences.exists() || preferences.length() == 0L) {
                    throw IllegalStateException("preferences file missing")
                }
                copyToTreeFile(directoryUri, preferences.name, "text/xml", preferences::inputStream)
                appDatabase.query(SimpleSQLiteQuery("PRAGMA wal_checkpoint(FULL)")).use {
                    it.moveToPosition(-1)
                }
                val database = applicationContext.getDatabasePath("database")
                if (!database.exists() || database.length() < 4096) {
                    throw IllegalStateException("database file missing")
                }
                copyToTreeFile(directoryUri, database.name, "application/octet-stream", database::inputStream)
                backupStatus.emit(applicationContext.getString(R.string.backup_success, 2))
            } catch (e: Exception) {
                DiagnosticLogger.e("SettingsViewModel", "backupSettings failed", e)
                runCatching {
                    backupStatus.emit(applicationContext.getString(R.string.backup_failed, e.message ?: "unknown"))
                }
            }
        }
    }

    private fun copyToTreeFile(directoryUri: Uri, fileName: String, mimeType: String, openSource: () -> InputStream) {
        val resolver = applicationContext.contentResolver
        val childrenUri = DocumentsContract.buildChildDocumentsUriUsingTree(
            directoryUri, DocumentsContract.getDocumentId(directoryUri)
        )
        var targetUri: Uri? = null
        resolver.query(childrenUri, arrayOf(DocumentsContract.Document.COLUMN_DOCUMENT_ID, DocumentsContract.Document.COLUMN_DISPLAY_NAME), null, null, null)?.use { cursor ->
            val idCol = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DOCUMENT_ID)
            val nameCol = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DISPLAY_NAME)
            while (targetUri == null && cursor.moveToNext()) {
                if (cursor.getString(nameCol) == fileName) {
                    targetUri = DocumentsContract.buildDocumentUriUsingTree(directoryUri, cursor.getString(idCol))
                }
            }
        }
        val dest = targetUri ?: DocumentsContract.createDocument(resolver, directoryUri, mimeType, fileName)
            ?: throw IllegalStateException("cannot create $fileName")
        var bytes = 0L
        resolver.openOutputStream(dest, "wt")!!.use { output ->
            openSource().use { input -> bytes = input.copyTo(output) }
        }
        if (bytes == 0L) throw IllegalStateException("$fileName is empty")
    }

    private enum class BackupFileType { PREFS, DATABASE, UNKNOWN }

    private fun classifyBackupFile(uri: Uri): BackupFileType {
        // Content sniffing first: renames and missing extensions must not break restore.
        try {
            applicationContext.contentResolver.openInputStream(uri)!!.use { input ->
                val header = ByteArray(16)
                val read = input.read(header)
                if (read > 0) {
                    val text = String(header, 0, read, Charsets.UTF_8)
                    if (text.startsWith("SQLite format 3")) return BackupFileType.DATABASE
                    if (text.trimStart().startsWith("<")) return BackupFileType.PREFS
                }
            }
        } catch (_: Exception) { }
        // Fallback to display name.
        runCatching {
            applicationContext.contentResolver.query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val name = cursor.getString(0).lowercase()
                    if (name.endsWith(".xml")) return BackupFileType.PREFS
                    if (name == "database" || name.endsWith(".db") || name.endsWith(".sqlite")) return BackupFileType.DATABASE
                }
            }
        }
        return BackupFileType.UNKNOWN
    }

    fun restoreSettings(list: List<String>, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var prefsUri: Uri? = null
                var dbUri: Uri? = null
                list.distinct().forEach { raw ->
                    val uri = raw.toUri()
                    when (classifyBackupFile(uri)) {
                        BackupFileType.PREFS -> if (prefsUri == null) prefsUri = uri
                        BackupFileType.DATABASE -> if (dbUri == null) dbUri = uri
                        BackupFileType.UNKNOWN -> { }
                    }
                }
                if (prefsUri == null || dbUri == null) {
                    restoreStatus.emit(applicationContext.getString(R.string.restore_needs_both))
                    return@launch
                }
                val prefsFile = prefsUri
                val dbFile = dbUri
                runCatching {
                    val safetyDir = File(applicationContext.filesDir, "backup-before-restore").apply { mkdirs() }
                    File("${applicationContext.applicationInfo.dataDir}/shared_prefs/${applicationContext.packageName}_preferences.xml")
                        .takeIf { it.exists() }?.copyTo(File(safetyDir, "preferences.xml"), overwrite = true)
                    applicationContext.getDatabasePath("database")
                        .takeIf { it.exists() }?.copyTo(File(safetyDir, "database"), overwrite = true)
                }
                val prefsText = applicationContext.contentResolver.openInputStream(prefsFile)!!.bufferedReader().use { it.readText() }
                if (!prefsText.contains("<map") || !prefsText.contains("string name=")) {
                    restoreStatus.emit(applicationContext.getString(R.string.restore_invalid))
                    return@launch
                }
                val tmpDb = File.createTempFile("restore-check", ".db", applicationContext.cacheDir)
                try {
                    applicationContext.contentResolver.openInputStream(dbFile)!!.use { input ->
                        tmpDb.outputStream().use { input.copyTo(it) }
                    }
                    if (tmpDb.length() < 4096) throw IllegalStateException("database too small")
                    val backupVersion = try {
                        val sqldb = SQLiteDatabase.openDatabase(tmpDb.path, null, SQLiteDatabase.OPEN_READONLY)
                        sqldb.version.also { sqldb.close() }
                    } catch (e: Exception) {
                        DiagnosticLogger.e("SettingsViewModel", "restore db version check failed", e)
                        null
                    }
                    if (backupVersion != null && backupVersion > 36) {
                        throw IllegalStateException("backup v$backupVersion newer than app v36")
                    }
                    FileOutputStream("${applicationContext.applicationInfo.dataDir}/shared_prefs/${applicationContext.packageName}_preferences.xml").use { outputStream ->
                        applicationContext.contentResolver.openInputStream(prefsFile)!!.use { inputStream ->
                            inputStream.copyTo(outputStream)
                        }
                    }
                    toggleNotifications(prefsText.contains("name=\"${AppConstants.LIVE_NOTIFICATIONS_ENABLED}\" value=\"true\""), networkLibrary, kickWebHeaders, kickPublicApiHeaders)
                    val database = applicationContext.getDatabasePath("database")
                    appDatabase.close()
                    File(database.parent, "database-shm").delete()
                    File(database.parent, "database-wal").delete()
                    tmpDb.copyTo(database, overwrite = true)
                } finally {
                    tmpDb.delete()
                }
                restoreStatus.emit(applicationContext.getString(R.string.restore_success))
                delay(800)
                applicationContext.startActivity(
                    Intent(applicationContext, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    }
                )
                exitProcess(0)
            } catch (e: Exception) {
                DiagnosticLogger.e("SettingsViewModel", "restoreSettings failed", e)
                runCatching {
                    restoreStatus.emit(applicationContext.getString(R.string.restore_failed, e.message ?: "unknown"))
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
                    cancelLiveNotificationsPollingWork(applicationContext)
                }
            } else {
                cancelLiveNotificationsPollingWork(applicationContext)
            }
        }
    }

    fun togglePollingBackup(enabled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (enabled && applicationContext.prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false)) {
                schedulePollingBackup()
            } else {
                cancelLiveNotificationsPollingWork(applicationContext)
            }
        }
    }

    private fun schedulePollingBackup() {
        enqueueLiveNotificationsPollingWork(applicationContext)
    }
}
