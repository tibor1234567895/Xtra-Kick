package com.xtrakick.app.ui.download

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.provider.DocumentsContract
import android.util.Base64
import android.util.Log
import android.util.JsonWriter
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.CheerEmote
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.ChatBadge
import com.xtrakick.app.model.chat.ChatEmote
import com.xtrakick.app.model.kick.KickMessage
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.OfflineRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.getByteArrayCronetCallback
import com.xtrakick.app.util.m3u8.PlaylistUtils
import com.xtrakick.app.util.m3u8.Segment
import com.xtrakick.app.util.prefs
import dagger.Lazy
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import com.xtrakick.app.util.NetworkUtils.useCancellable
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.URI
import java.time.Instant
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicIntegerArray
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

internal fun canReuseDownloadedTrack(name: String, downloadedTracks: Set<String>, isReadable: () -> Boolean): Boolean =
    name in downloadedTracks && isReadable()

@HiltWorker
class VideoDownloadWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted parameters: WorkerParameters,
) : CoroutineWorker(context, parameters) {

    @Inject
    @JvmField
    var httpEngine: Lazy<HttpEngine>? = null

    @Inject
    @JvmField
    var cronetEngine: Lazy<CronetEngine>? = null

    @Inject
    lateinit var cronetExecutor: ExecutorService

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var json: Json

    @Inject
    lateinit var playerRepository: PlayerRepository

    @Inject
    lateinit var kickRepository: KickRepository

    @Inject
    lateinit var offlineRepository: OfflineRepository

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private lateinit var offlineVideo: OfflineVideo
    private val collectedBadgeImageUrls = ConcurrentHashMap<Pair<String, String>, String>()

    /**
     * Opens a segment file for writing, creating it if needed. Creation is
     * serialized and retried: the provider rejects concurrent creates.
     */
    private suspend fun openSegmentOutputForWrite(fileUri: android.net.Uri, parentUri: String, displayName: String): OutputStream {
        runCatching { context.contentResolver.openOutputStream(fileUri)!! }.getOrNull()?.let { return it }
        return documentCreationMutex.withLock {
            runCatching { context.contentResolver.openOutputStream(fileUri)!! }.getOrNull()?.let { return it }
            DocumentsContract.createDocument(context.contentResolver, parentUri.toUri(), "", displayName)
            var lastError: Exception? = null
            repeat(3) {
                try {
                    return context.contentResolver.openOutputStream(fileUri)!!
                } catch (e: Exception) {
                    lastError = e
                    delay(300)
                }
            }
            throw IOException("Failed to create segment file $displayName", lastError)
        }
    }

    override suspend fun doWork(): Result {
        offlineVideo = offlineRepository.getVideoById(inputData.getInt(KEY_VIDEO_ID, 0)) ?: return Result.failure()
        val forceChatRedownload = inputData.getBoolean(KEY_FORCE_CHAT_REDOWNLOAD, false)
        offlineRepository.updateVideo(offlineVideo.apply { status = OfflineVideo.STATUS_DOWNLOADING })
        setForeground(createForegroundInfo())
        val networkLibrary = context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        val sourceUrl = offlineVideo.sourceUrl!!
        if (isStopped) {
                return Result.failure()
            }
            if (sourceUrl.endsWith(".m3u8")) {
            val path = offlineVideo.downloadPath!!
            val from = offlineVideo.fromTime ?: 0L
            val to = offlineVideo.toTime
            // Chat runs alongside video when its inputs are already known (clips,
            // or resumes with a refined range). Fresh VODs launch once the playlist
            // range is resolved below.
            val chatPrerequisitesReady = !offlineVideo.clipId.isNullOrBlank() ||
                (offlineVideo.sourceStartPosition != null && offlineVideo.duration != null)
            val chatScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
            var earlyChatJob: Job? = if (chatPrerequisitesReady) {
                chatScope.launch {
                    startChatJobSafely(path, forceChatRedownload)
                }
            } else null
            val isShared = path.toUri().scheme == ContentResolver.SCHEME_CONTENT
            var playlistUrl = sourceUrl
            var playlist = when {
                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                    val response = suspendCoroutine { continuation ->
                        httpEngine!!.get().newUrlRequestBuilder(sourceUrl, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                    }
                    response.second.inputStream().use {
                        PlaylistUtils.parseMediaPlaylist(it)
                    }
                }
                networkLibrary == "Cronet" && cronetEngine != null -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                        cronetEngine!!.get().newUrlRequestBuilder(sourceUrl, request.callback, cronetExecutor).build().start()
                        val response = request.future.get().responseBody as ByteArray
                        response.inputStream().use {
                            PlaylistUtils.parseMediaPlaylist(it)
                        }
                    } else {
                        val response = suspendCoroutine { continuation ->
                            cronetEngine!!.get().newUrlRequestBuilder(sourceUrl, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                        }
                        response.second.inputStream().use {
                            PlaylistUtils.parseMediaPlaylist(it)
                        }
                    }
                }
                else -> {
                    okHttpClient.newCall(Request.Builder().url(sourceUrl).build()).execute().use { response ->
                        response.body.byteStream().use {
                            PlaylistUtils.parseMediaPlaylist(it)
                        }
                    }
                }
            }
            if (playlist.segments.isEmpty()) {
                playlistUrl = getFirstVariantPlaylistUrl(networkLibrary, sourceUrl) ?: return Result.failure()
                playlist = (playerRepository.loadTextFromUrl(networkLibrary, playlistUrl) ?: return Result.failure())
                    .byteInputStream()
                    .use { PlaylistUtils.parseMediaPlaylist(it) }
                if (playlist.segments.isEmpty()) {
                    return Result.failure()
                }
            }
            if (playlist.encrypted) {
                Log.e("VideoDownloadWorker", "Aborting download: playlist is HLS-encrypted (#EXT-X-KEY); downloaded segments would be unplayable")
                offlineRepository.updateVideo(offlineVideo.apply { status = OfflineVideo.STATUS_PENDING })
                return Result.failure()
            }
            val targetDuration = playlist.targetDuration * 1000L
            var totalDuration = 0L
            val size = playlist.segments.size
            val relativeStartTimes = ArrayList<Long>(size)
            val durations = ArrayList<Long>(size)
            var relativeTime = 0L
            playlist.segments.forEach {
                val duration = (it.duration * 1000f).toLong()
                durations.add(duration)
                totalDuration += duration
                relativeStartTimes.add(relativeTime)
                relativeTime += duration
            }
            val fromIndex = if (from == 0L) {
                0
            } else {
                val min = from - targetDuration
                relativeStartTimes.binarySearch(comparison = { time ->
                    when {
                        time > from -> 1
                        time < min -> -1
                        else -> 0
                    }
                }).let { if (it < 0) -it - 1 else it }.coerceIn(0, size - 1)
            }
            val toIndex = if (to == null || to in relativeStartTimes.last()..totalDuration) {
                size - 1
            } else {
                val max = to + targetDuration
                relativeStartTimes.binarySearch(comparison = { time ->
                    when {
                        time > max -> 1
                        time < to -> -1
                        else -> 0
                    }
                }).let { if (it < 0) -it - 1 else it }.coerceIn(fromIndex, size - 1)
            }
            // Fresh VOD: the download range is resolved, so chat can start downloading
            // in parallel with the segment phase instead of after it. The persisted
            // range is what startChatJob reads; the branches below re-persist the
            // same values alongside their own fields.
            if (offlineVideo.clipId.isNullOrBlank() && earlyChatJob == null) {
                val chatStartPosition = relativeStartTimes[fromIndex]
                offlineRepository.updateVideo(offlineVideo.apply {
                    sourceStartPosition = chatStartPosition
                    duration = relativeStartTimes[toIndex] + durations[toIndex] - chatStartPosition - 1000L
                })
                earlyChatJob = chatScope.launch {
                    startChatJobSafely(path, forceChatRedownload)
                }
            }
            val urlPath = playlistUrl.substringBeforeLast('/') + "/"
            val remainingSegments = ArrayList<Segment>()
            if (offlineVideo.progress < offlineVideo.maxProgress) {
                for (i in fromIndex + offlineVideo.progress..toIndex) {
                    val segment = playlist.segments[i]
                    remainingSegments.add(segment.copy(uri = segment.uri.replace("-unmuted", "-muted")))
                }
            }
            val requestSemaphore = Semaphore(context.prefs().getInt(AppConstants.DOWNLOAD_CONCURRENT_LIMIT, 10).coerceIn(1, 32))
            val count = MutableStateFlow(0)
            val jobs = if (offlineVideo.playlistToFile) {
                val videoFileUri = if (!offlineVideo.url.isNullOrBlank()) {
                    val fileUri = offlineVideo.url!!
                    if (isShared) {
                        context.contentResolver.openFileDescriptor(fileUri.toUri(), "rw")!!.use {
                            FileOutputStream(it.fileDescriptor).use { output ->
                                output.channel.truncate(offlineVideo.bytes)
                            }
                        }
                    } else {
                        FileOutputStream(fileUri, true).use { output ->
                            output.channel.truncate(offlineVideo.bytes)
                        }
                    }
                    fileUri
                } else {
                    val fileName = "${offlineVideo.videoId ?: ""}${offlineVideo.quality ?: ""}${offlineVideo.downloadDate}.${remainingSegments.first().uri.substringAfterLast(".")}"
                    val fileUri = if (isShared) {
                        val documentId = DocumentsContract.getTreeDocumentId(path.toUri())
                        val directoryUri = DocumentsContract.buildDocumentUriUsingTree(path.toUri(), documentId)
                        val fileUri = directoryUri.toString() + (if (!directoryUri.toString().endsWith("%3A")) "%2F" else "") + fileName
                        try {
                            context.contentResolver.openOutputStream(fileUri.toUri())!!.close()
                        } catch (e: IllegalArgumentException) {
                            DocumentsContract.createDocument(context.contentResolver, directoryUri, "", fileName)
                        }
                        fileUri
                    } else {
                        "$path${File.separator}$fileName"
                    }
                    val startPosition = relativeStartTimes[fromIndex]
                    val initSegmentBytes = if (playlist.initSegmentUri != null) {
                        when {
                            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                val response = suspendCoroutine { continuation ->
                                    httpEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                }
                                if (isShared) {
                                    context.contentResolver.openOutputStream(fileUri.toUri(), "wa")!!.use {
                                        it.write(response.second)
                                    }
                                } else {
                                    FileOutputStream(fileUri, true).use {
                                        it.write(response.second)
                                    }
                                }
                                response.second.size.toLong()
                            }
                            networkLibrary == "Cronet" && cronetEngine != null -> {
                                val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                    cronetEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, request.callback, cronetExecutor).build().start()
                                    request.future.get().responseBody as ByteArray
                                } else {
                                    val response = suspendCoroutine { continuation ->
                                        cronetEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                    }
                                    response.second
                                }
                                if (isShared) {
                                    context.contentResolver.openOutputStream(fileUri.toUri(), "wa")!!.use {
                                        it.write(response)
                                    }
                                } else {
                                    FileOutputStream(fileUri, true).use {
                                        it.write(response)
                                    }
                                }
                                response.size.toLong()
                            }
                            else -> {
                                okHttpClient.newCall(Request.Builder().url(urlPath + playlist.initSegmentUri).build()).execute().use { response ->
                                    if (isShared) {
                                        context.contentResolver.openOutputStream(fileUri.toUri(), "wa")!!
                                    } else {
                                        FileOutputStream(fileUri, true)
                                    }.use { outputStream ->
                                        response.body.byteStream().use { inputStream ->
                                            inputStream.copyTo(outputStream)
                                        }
                                    }
                                    response.body.contentLength()
                                }
                            }
                        }
                    } else null
                    offlineRepository.updateVideo(offlineVideo.apply {
                        url = fileUri
                        duration = (relativeStartTimes[toIndex] + durations[toIndex] - startPosition) - 1000L
                        sourceStartPosition = startPosition
                        maxProgress = toIndex - fromIndex + 1
                        initSegmentBytes?.let { bytes += it }
                    })
                    fileUri
                }
                coroutineScope {
                    val segmentIds = generateSequence(0) { it + 1 }.iterator()
                    remainingSegments.map {
                        val id = segmentIds.next()
                        launch(start = CoroutineStart.UNDISPATCHED) {
                            requestSemaphore.withPermit {
                                when {
                                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                        val response = suspendCoroutine { continuation ->
                                            httpEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                        }
                                        count.first { turn -> turn == id }
                                        if (isShared) {
                                            context.contentResolver.openOutputStream(videoFileUri.toUri(), "wa")!!.use {
                                                it.write(response.second)
                                            }
                                        } else {
                                            FileOutputStream(videoFileUri, true).use {
                                                it.write(response.second)
                                            }
                                        }
                                        offlineRepository.updateVideo(offlineVideo.apply {
                                            bytes += response.second.size
                                            progress += 1
                                        })
                                    }
                                    networkLibrary == "Cronet" && cronetEngine != null -> {
                                        val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                            val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                            cronetEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, request.callback, cronetExecutor).build().start()
                                            request.future.get().responseBody as ByteArray
                                        } else {
                                            val response = suspendCoroutine { continuation ->
                                                cronetEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                            }
                                            response.second
                                        }
                                        count.first { turn -> turn == id }
                                        if (isShared) {
                                            context.contentResolver.openOutputStream(videoFileUri.toUri(), "wa")!!.use {
                                                it.write(response)
                                            }
                                        } else {
                                            FileOutputStream(videoFileUri, true).use {
                                                it.write(response)
                                            }
                                        }
                                        offlineRepository.updateVideo(offlineVideo.apply {
                                            bytes += response.size
                                            progress += 1
                                        })
                                    }
                                    else -> {
                                        okHttpClient.newCall(Request.Builder().url(urlPath + it.uri).build()).useCancellable { response ->
                                            count.first { turn -> turn == id }
                                            if (isShared) {
                                                context.contentResolver.openOutputStream(videoFileUri.toUri(), "wa")!!
                                            } else {
                                                FileOutputStream(videoFileUri, true)
                                            }.use { outputStream ->
                                                response.body.byteStream().use { inputStream ->
                                                    inputStream.copyTo(outputStream)
                                                }
                                                offlineRepository.updateVideo(offlineVideo.apply {
                                                    bytes += response.body.contentLength()
                                                    progress += 1
                                                })
                                            }
                                        }
                                    }
                                }
                                count.update { it + 1 }
                                setForeground(createForegroundInfo())
                            }
                        }
                    }
                }
            } else {
                val videoDirectoryName = if (!offlineVideo.videoId.isNullOrBlank()) {
                    "${offlineVideo.videoId}${offlineVideo.quality ?: ""}"
                } else {
                    "${offlineVideo.downloadDate}"
                }
                if (isShared) {
                    val documentId = DocumentsContract.getTreeDocumentId(path.toUri())
                    val directoryUri = DocumentsContract.buildDocumentUriUsingTree(path.toUri(), documentId)
                    val videoDirectoryUri = directoryUri.toString() + (if (!directoryUri.toString().endsWith("%3A")) "%2F" else "") + videoDirectoryName
                    try {
                        context.contentResolver.openOutputStream(videoDirectoryUri.toUri())!!.close()
                    } catch (e: Exception) {
                        if (e is IllegalArgumentException) {
                            DocumentsContract.createDocument(context.contentResolver, directoryUri, DocumentsContract.Document.MIME_TYPE_DIR, videoDirectoryName)
                        }
                    }
                    val playlistFileUri = if (!offlineVideo.url.isNullOrBlank()) {
                        offlineVideo.url!!
                    } else {
                        val sharedSegments = ArrayList<Segment>()
                        for (i in fromIndex..toIndex) {
                            val segment = playlist.segments[i]
                            sharedSegments.add(segment.copy(uri = videoDirectoryUri + "%2F" + segment.uri.replace("-unmuted", "-muted")))
                        }
                        val fileName = "${offlineVideo.downloadDate}.m3u8"
                        val playlistFileUri = "$videoDirectoryUri%2F$fileName"
                        try {
                            context.contentResolver.openOutputStream(playlistFileUri.toUri())!!
                        } catch (e: IllegalArgumentException) {
                            DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", fileName)
                            context.contentResolver.openOutputStream(playlistFileUri.toUri())!!
                        }.use {
                            PlaylistUtils.writeMediaPlaylist(playlist.copy(
                                initSegmentUri = playlist.initSegmentUri?.let { uri -> "$videoDirectoryUri%2F$uri" },
                                segments = sharedSegments
                            ), it)
                        }
                        val startPosition = relativeStartTimes[fromIndex]
                        if (playlist.initSegmentUri != null) {
                            val initSegmentFileUri = (videoDirectoryUri + "%2F" + playlist.initSegmentUri).toUri()
                            when {
                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                    val response = suspendCoroutine { continuation ->
                                        httpEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                    }
                                    try {
                                        context.contentResolver.openOutputStream(initSegmentFileUri)!!
                                    } catch (e: IllegalArgumentException) {
                                        DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", playlist.initSegmentUri)
                                        context.contentResolver.openOutputStream(initSegmentFileUri)!!
                                    }.use {
                                        it.write(response.second)
                                    }
                                }
                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                    val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                        val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                        cronetEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, request.callback, cronetExecutor).build().start()
                                        request.future.get().responseBody as ByteArray
                                    } else {
                                        val response = suspendCoroutine { continuation ->
                                            cronetEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                        }
                                        response.second
                                    }
                                    try {
                                        context.contentResolver.openOutputStream(initSegmentFileUri)!!
                                    } catch (e: IllegalArgumentException) {
                                        DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", playlist.initSegmentUri)
                                        context.contentResolver.openOutputStream(initSegmentFileUri)!!
                                    }.use {
                                        it.write(response)
                                    }
                                }
                                else -> {
                                    okHttpClient.newCall(Request.Builder().url(urlPath + playlist.initSegmentUri).build()).execute().use { response ->
                                        try {
                                            context.contentResolver.openOutputStream(initSegmentFileUri)!!
                                        } catch (e: IllegalArgumentException) {
                                            DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", playlist.initSegmentUri)
                                            context.contentResolver.openOutputStream(initSegmentFileUri)!!
                                        }.use { outputStream ->
                                            response.body.byteStream().use { inputStream ->
                                                inputStream.copyTo(outputStream)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        offlineRepository.updateVideo(offlineVideo.apply {
                            url = playlistFileUri
                            duration = (relativeStartTimes[toIndex] + durations[toIndex] - startPosition) - 1000L
                            sourceStartPosition = startPosition
                            maxProgress = toIndex - fromIndex + 1
                        })
                        playlistFileUri
                    }
                    val downloadedTracks = mutableSetOf<String>()
                    val playlists = offlineRepository.getPlaylists().mapNotNull { video ->
                        video.url?.takeIf {
                            it.toUri().scheme == ContentResolver.SCHEME_CONTENT
                                    && it.substringBeforeLast("%2F") == videoDirectoryUri
                                    && it != playlistFileUri
                        }
                    }
                    playlists.forEach { uri ->
                        try {
                            val p = applicationContext.contentResolver.openInputStream(uri.toUri())!!.use {
                                PlaylistUtils.parseMediaPlaylist(it)
                            }
                            p.segments.forEach { downloadedTracks.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                        } catch (e: Exception) {

                        }
                    }
                    coroutineScope {
                        val segmentIds = generateSequence(0) { it + 1 }.iterator()
                        remainingSegments.map {
                            val id = segmentIds.next()
                            launch(start = CoroutineStart.UNDISPATCHED) {
                                requestSemaphore.withPermit {
                                    val fileUri = (videoDirectoryUri + "%2F" + it.uri).toUri()
                                    val reusable = canReuseDownloadedTrack(it.uri, downloadedTracks) {
                                        runCatching {
                                            context.contentResolver.openInputStream(fileUri)?.use { true } ?: false
                                        }.getOrDefault(false)
                                    }
                                    if (reusable) {
                                        count.first { turn -> turn == id }
                                        offlineRepository.updateVideo(offlineVideo.apply { progress += 1 })
                                        count.update { it + 1 }
                                        setForeground(createForegroundInfo())
                                        return@withPermit
                                    }
                                    try {
                                        context.contentResolver.openOutputStream(fileUri)!!
                                    } catch (e: IllegalArgumentException) {
                                        null
                                    }.use { outputStream ->
                                        if (!reusable) {
                                            when {
                                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                                    val response = suspendCoroutine { continuation ->
                                                        httpEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                                    }
                                                    if (outputStream != null) {
                                                        outputStream
                                                    } else {
                                                        openSegmentOutputForWrite(fileUri, videoDirectoryUri, it.uri)
                                                    }.use {
                                                        it.write(response.second)
                                                    }
                                                }
                                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                                    val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                                        val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                                        cronetEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, request.callback, cronetExecutor).build().start()
                                                        request.future.get().responseBody as ByteArray
                                                    } else {
                                                        val response = suspendCoroutine { continuation ->
                                                            cronetEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                                        }
                                                        response.second
                                                    }
                                                    if (outputStream != null) {
                                                        outputStream
                                                    } else {
                                                        openSegmentOutputForWrite(fileUri, videoDirectoryUri, it.uri)
                                                    }.use {
                                                        it.write(response)
                                                    }
                                                }
                                                else -> {
                                                    // Segment files are idempotent on re-download, so
                                                    // let in-flight calls finish on stop instead of
                                                    // cancelling them mid-TLS (see chatCancelScope).
                                                    okHttpClient.newCall(Request.Builder().url(urlPath + it.uri).build()).useCancellable(cancelCallOnCancellation = false) { response ->
                                                        if (outputStream != null) {
                                                            outputStream
                                                        } else {
                                                            openSegmentOutputForWrite(fileUri, videoDirectoryUri, it.uri)
                                                        }.use { outputStream ->
                                                            response.body.byteStream().use { inputStream ->
                                                                inputStream.copyTo(outputStream)
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    count.first { turn -> turn == id }
                                    offlineRepository.updateVideo(offlineVideo.apply { progress += 1 })
                                    count.update { it + 1 }
                                    setForeground(createForegroundInfo())
                                }
                            }
                        }
                    }
                } else {
                    val directory = "$path${File.separator}$videoDirectoryName${File.separator}"
                    val playlistFileUri = if (!offlineVideo.url.isNullOrBlank()) {
                        offlineVideo.url!!
                    } else {
                        File(directory).mkdir()
                        val playlistUri = "$directory${offlineVideo.downloadDate}.m3u8"
                        FileOutputStream(playlistUri).use {
                            PlaylistUtils.writeMediaPlaylist(playlist.copy(segments = remainingSegments), it)
                        }
                        val startPosition = relativeStartTimes[fromIndex]
                        if (playlist.initSegmentUri != null) {
                            when {
                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                    val response = suspendCoroutine { continuation ->
                                        httpEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                    }
                                    FileOutputStream(directory + playlist.initSegmentUri).use {
                                        it.write(response.second)
                                    }
                                }
                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                    val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                        val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                        cronetEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, request.callback, cronetExecutor).build().start()
                                        request.future.get().responseBody as ByteArray
                                    } else {
                                        val response = suspendCoroutine { continuation ->
                                            cronetEngine!!.get().newUrlRequestBuilder(urlPath + playlist.initSegmentUri, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                        }
                                        response.second
                                    }
                                    FileOutputStream(directory + playlist.initSegmentUri).use {
                                        it.write(response)
                                    }
                                }
                                else -> {
                                    okHttpClient.newCall(Request.Builder().url(urlPath + playlist.initSegmentUri).build()).execute().use { response ->
                                        FileOutputStream(directory + playlist.initSegmentUri).use { outputStream ->
                                            response.body.byteStream().use { inputStream ->
                                                inputStream.copyTo(outputStream)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        offlineRepository.updateVideo(offlineVideo.apply {
                            url = playlistUri
                            duration = (relativeStartTimes[toIndex] + durations[toIndex] - startPosition) - 1000L
                            sourceStartPosition = startPosition
                            maxProgress = toIndex - fromIndex + 1
                        })
                        playlistUri
                    }
                    val downloadedTracks = mutableSetOf<String>()
                    val playlists = File(directory).listFiles { it.extension == "m3u8" && it.path != playlistFileUri }
                    playlists?.forEach { file ->
                        val p = PlaylistUtils.parseMediaPlaylist(file.inputStream())
                        p.segments.forEach { downloadedTracks.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                    }
                    coroutineScope {
                        val segmentIds = generateSequence(0) { it + 1 }.iterator()
                        remainingSegments.map {
                            val id = segmentIds.next()
                            launch(start = CoroutineStart.UNDISPATCHED) {
                                requestSemaphore.withPermit {
                                    if (!File(directory + it.uri).exists() || !downloadedTracks.contains(it.uri)) {
                                        when {
                                            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                                val response = suspendCoroutine { continuation ->
                                                    httpEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                                }
                                                FileOutputStream(directory + it.uri).use {
                                                    it.write(response.second)
                                                }
                                            }
                                            networkLibrary == "Cronet" && cronetEngine != null -> {
                                                val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                                    val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                                    cronetEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, request.callback, cronetExecutor).build().start()
                                                    request.future.get().responseBody as ByteArray
                                                } else {
                                                    val response = suspendCoroutine { continuation ->
                                                        cronetEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                                    }
                                                    response.second
                                                }
                                                FileOutputStream(directory + it.uri).use {
                                                    it.write(response)
                                                }
                                            }
                                            else -> {
                                                okHttpClient.newCall(Request.Builder().url(urlPath + it.uri).build()).useCancellable(cancelCallOnCancellation = false) { response ->
                                                    FileOutputStream(directory + it.uri).use { outputStream ->
                                                        response.body.byteStream().use { inputStream ->
                                                            inputStream.copyTo(outputStream)
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    count.first { turn -> turn == id }
                                    offlineRepository.updateVideo(offlineVideo.apply { progress += 1 })
                                    count.update { it + 1 }
                                    setForeground(createForegroundInfo())
                                }
                            }
                        }
                    }
                }
            }
            try {
                jobs.joinAll()
                if (earlyChatJob != null) {
                    earlyChatJob.join()
                } else {
                    startChatJobSafely(path, forceChatRedownload)
                }
            } finally {
                // Grace period: the chat loop exits via isStopped after its current
                // request completes; cancelling immediately would kill the TLS
                // connection mid-flight (see chatCancelScope).
                chatCancelScope.launch {
                    delay(2_000)
                    chatScope.cancel()
                }
            }
        } else {
            val path = offlineVideo.downloadPath!!
            val isShared = path.toUri().scheme == ContentResolver.SCHEME_CONTENT
            val chatPrerequisitesReady = !offlineVideo.clipId.isNullOrBlank() ||
                (offlineVideo.sourceStartPosition != null && offlineVideo.duration != null)
            val chatScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
            val earlyChatJob = if (chatPrerequisitesReady) {
                chatScope.launch {
                    startChatJobSafely(path, forceChatRedownload)
                }
            } else null
            val videoFileUri = if (!offlineVideo.url.isNullOrBlank()) {
                offlineVideo.url!!
            } else {
                val fileName = if (!offlineVideo.clipId.isNullOrBlank()) {
                    "${offlineVideo.clipId}${offlineVideo.quality ?: ""}.mp4"
                } else {
                    "${offlineVideo.downloadDate}.mp4"
                }
                val fileUri = if (isShared) {
                    val documentId = DocumentsContract.getTreeDocumentId(path.toUri())
                    val directoryUri = DocumentsContract.buildDocumentUriUsingTree(path.toUri(), documentId)
                    val fileUri = directoryUri.toString() + (if (!directoryUri.toString().endsWith("%3A")) "%2F" else "") + fileName
                    try {
                        context.contentResolver.openOutputStream(fileUri.toUri())!!.close()
                    } catch (e: IllegalArgumentException) {
                        DocumentsContract.createDocument(context.contentResolver, directoryUri, "", fileName)
                    }
                    fileUri
                } else {
                    "$path${File.separator}$fileName"
                }
                offlineRepository.updateVideo(offlineVideo.apply {
                    url = fileUri
                })
                fileUri
            }
            val jobs = runBlocking {
                launch {
                    if (offlineVideo.progress < offlineVideo.maxProgress) {
                        when {
                            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                val response = suspendCoroutine { continuation ->
                                    httpEngine!!.get().newUrlRequestBuilder(sourceUrl, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                }
                                if (isShared) {
                                    context.contentResolver.openOutputStream(videoFileUri.toUri())!!.use {
                                        it.write(response.second)
                                    }
                                } else {
                                    FileOutputStream(videoFileUri).use {
                                        it.write(response.second)
                                    }
                                }
                            }
                            networkLibrary == "Cronet" && cronetEngine != null -> {
                                val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                    cronetEngine!!.get().newUrlRequestBuilder(sourceUrl, request.callback, cronetExecutor).build().start()
                                    request.future.get().responseBody as ByteArray
                                } else {
                                    val response = suspendCoroutine { continuation ->
                                        cronetEngine!!.get().newUrlRequestBuilder(sourceUrl, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                    }
                                    response.second
                                }
                                if (isShared) {
                                    context.contentResolver.openOutputStream(videoFileUri.toUri())!!.use {
                                        it.write(response)
                                    }
                                } else {
                                    FileOutputStream(videoFileUri).use {
                                        it.write(response)
                                    }
                                }
                            }
                            else -> {
                                okHttpClient.newCall(Request.Builder().url(sourceUrl).build()).execute().use { response ->
                                    if (isShared) {
                                        context.contentResolver.openOutputStream(videoFileUri.toUri())!!
                                    } else {
                                        FileOutputStream(videoFileUri)
                                    }.use { outputStream ->
                                        response.body.byteStream().use { inputStream ->
                                            inputStream.copyTo(outputStream)
                                        }
                                    }
                                }
                            }
                        }
                        offlineRepository.updateVideo(offlineVideo.apply { progress = offlineVideo.maxProgress })
                        setForeground(createForegroundInfo())
                    }
                }
            }
            try {
                jobs.join()
                val chatJob = earlyChatJob
                if (chatJob != null) {
                    chatJob.join()
                } else {
                    startChatJobSafely(path, forceChatRedownload)
                }
            } finally {
                // Grace period: the chat loop exits via isStopped after its current
                // request completes; cancelling immediately would kill the TLS
                // connection mid-flight (see chatCancelScope).
                chatCancelScope.launch {
                    delay(2_000)
                    chatScope.cancel()
                }
            }
        }
        // Both the video jobs and the chat job have joined above, so neither can
        // progress anymore: a completed video is final even if the chat walk ended
        // early (the force-chat-redownload flow can repair chat). Basing the status
        // on chat progress here would stick the item at "DOWNLOADING: 100%" forever.
        if (offlineVideo.progress < offlineVideo.maxProgress) {
            offlineRepository.updateVideo(offlineVideo.apply { status = OfflineVideo.STATUS_DOWNLOADING })
        } else {
            offlineRepository.updateVideo(offlineVideo.apply { status = OfflineVideo.STATUS_DOWNLOADED })
            val notification = NotificationCompat.Builder(context, context.getString(R.string.notification_downloads_channel_id)).apply {
                setGroup(GROUP_KEY)
                setContentTitle(ContextCompat.getString(context, R.string.downloaded))
                setContentText(offlineVideo.name)
                setSmallIcon(android.R.drawable.stat_sys_download_done)
                setAutoCancel(true)
                setContentIntent(
                    PendingIntent.getActivity(
                        context,
                        -offlineVideo.id,
                        Intent(context, MainActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                            action = MainActivity.INTENT_OPEN_DOWNLOADED_VIDEO
                            putExtra(MainActivity.KEY_VIDEO, offlineVideo)
                        },
                        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                    )
                )
            }.build()
            notificationManager.notify(-offlineVideo.id, notification)
        }
        return Result.success()
    }

    // Per-chain collection for the parallel chat history walk; merged after join.
    private class ChatWalkResult {
        val comments = mutableListOf<JsonObject>()
        val badgePairs = linkedSetOf<Pair<String, String>>()
        val emoteIds = linkedSetOf<String>()
        val words = linkedSetOf<String>()
        var pages = 0
    }

    // Schedules chatScope cancellation slightly after stop so the in-flight chat
    // request can finish normally. Abrupt mid-TLS cancellation right after the stop
    // press was repeatedly followed by native SIGSEGV crashes on the chat thread's
    // network stack.
    private val chatCancelScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    // Chat failures must neither fail the video download nor leave it stuck in
    // STATUS_DOWNLOADING; the force-chat-redownload flow can repair chat later.
    private suspend fun startChatJobSafely(path: String, forceChatRedownload: Boolean) {
        try {
            startChatJob(path, forceChatRedownload)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            if (!currentCoroutineContext().isActive || isStopped) {
                // Stopped mid-write: JsonWriter.close() throws "Incomplete document"
                // while unwinding. Cancellation wins; a resume redoes the chat file.
                throw CancellationException("chat job cancelled", e)
            }
            Log.e("VideoDownloadWorker", "chat download failed", e)
            offlineRepository.updateVideo(offlineVideo.apply {
                chatProgress = offlineVideo.maxChatProgress
            })
        }
    }

    private suspend fun startChatJob(path: String, forceChatRedownload: Boolean) {
        if ((offlineVideo.downloadChat || forceChatRedownload) && offlineVideo.chatProgress < offlineVideo.maxChatProgress) {
            val isClip = !offlineVideo.clipId.isNullOrBlank()
            // Clips resolve their real-time start from the playlist (same as live
            // playback); VODs use the stored source position.
            val clipStartMs: Long? = if (isClip) {
                runCatching {
                    offlineVideo.sourceUrl?.takeIf { it.isNotBlank() }?.let { kickRepository.getClipPlaylistStartTimeMs(it) }
                }.getOrNull() ?: offlineVideo.uploadDate
            } else null
            suspend fun markChatComplete() {
                offlineRepository.updateVideo(offlineVideo.apply {
                    chatProgress = maxChatProgress
                })
            }
            val videoId: String = if (isClip) {
                (offlineVideo.clipId ?: offlineVideo.videoId).takeIf { !it.isNullOrBlank() && clipStartMs != null }
            } else {
                offlineVideo.videoId.takeIf { !it.isNullOrBlank() }
            } ?: run {
                // No chat source: mark complete so the download can finish.
                markChatComplete()
                return
            }
            val startPosition: Long = if (isClip) 0L else (offlineVideo.sourceStartPosition ?: run {
                markChatComplete()
                return
            })
            val duration: Long = if (isClip) {
                offlineVideo.duration?.takeIf { it > 0 } ?: 300_000L
            } else {
                (offlineVideo.duration ?: run {
                    markChatComplete()
                    return
                })
            }
            videoId.let {
                val isShared = path.toUri().scheme == ContentResolver.SCHEME_CONTENT
                val startTimeSeconds = (startPosition / 1000).toInt()
                val requestedDurationSeconds = offlineVideo.fromTime?.let { from ->
                    offlineVideo.toTime?.let { to -> ((to - from).coerceAtLeast(0L) / 1000L).toInt() }
                } ?: 0
                val durationSeconds = maxOf((duration / 1000).toInt(), requestedDurationSeconds)
                val requestedEndTimeSeconds = offlineVideo.toTime?.let { (it / 1000L).toInt() } ?: 0
                val endTimeSeconds = maxOf(startTimeSeconds + durationSeconds, requestedEndTimeSeconds + 120)
                val fileName = "${videoId}${offlineVideo.quality ?: ""}${offlineVideo.downloadDate}_chat.json"
                val savedChatEmotes = hashSetOf<String>()
                val savedBadges = hashSetOf<Pair<String, String>>()
                val savedEmotes = hashSetOf<String>()
                val existingChatFileUri = offlineVideo.chatUrl
                val existingChatFileAccessible = if (!existingChatFileUri.isNullOrBlank()) {
                    canOpenChatFile(existingChatFileUri, isShared)
                } else {
                    false
                }
                val fileUri = if (forceChatRedownload && existingChatFileAccessible) {
                    existingChatFileUri!!
                } else {
                    val fileUri = if (isShared) {
                        val documentId = DocumentsContract.getTreeDocumentId(path.toUri())
                        val directoryUri = DocumentsContract.buildDocumentUriUsingTree(path.toUri(), documentId)
                        val fileUri = directoryUri.toString() + (if (!directoryUri.toString().endsWith("%3A")) "%2F" else "") + fileName
                        try {
                            context.contentResolver.openOutputStream(fileUri.toUri())!!.close()
                        } catch (e: IllegalArgumentException) {
                            DocumentsContract.createDocument(context.contentResolver, directoryUri, "", fileName)
                        }
                        fileUri
                    } else {
                        "$path${File.separator}$fileName"
                    }
                    offlineRepository.updateVideo(offlineVideo.apply {
                        maxChatProgress = durationSeconds
                        chatUrl = fileUri
                    })
                    fileUri
                }
                val downloadEmotes = offlineVideo.downloadChatEmotes
                val networkLibrary = context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
                val kickWebHeaders = KickApiHelper.getKickWebHeaders(context, true)
                val kickPublicApiHeaders = KickApiHelper.getKickWebHeaders(context)
                val emoteQuality = context.prefs().getString(AppConstants.CHAT_IMAGE_QUALITY, "4") ?: "4"
                val useWebp = context.prefs().getBoolean(AppConstants.CHAT_USE_WEBP, true)
                val channelId = offlineVideo.channelId
                val channelLogin = offlineVideo.channelLogin
                val cheerEmoteList = emptyList<CheerEmote>()
                val emoteList = emptyList<Emote>()
                if (isShared) {
                    context.contentResolver.openFileDescriptor(fileUri.toUri(), "rw")?.use {
                        FileOutputStream(it.fileDescriptor).use { output ->
                            output.channel.truncate(0L)
                        }
                    }
                } else {
                    FileOutputStream(fileUri, false).use { output ->
                        output.channel.truncate(0L)
                    }
                }
                if (isShared) {
                    context.contentResolver.openOutputStream(fileUri.toUri(), "w")!!.bufferedWriter()
                } else {
                    FileOutputStream(fileUri, false).bufferedWriter()
                }.use { fileWriter ->
                    JsonWriter(fileWriter).use { writer ->
                        var position = 0L
                        writer.beginObject().also { position += 1 }
                        writer.name("video".also { position += it.length + 3 })
                        writer.beginObject().also { position += 1 }
                        writer.name("id".also { position += it.length + 3 }).value(videoId.also { position += it.length + 2 })
                        offlineVideo.name?.let { value -> writer.name("title".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                        offlineVideo.uploadDate?.let { value -> writer.name("uploadDate".also { position += it.length + 4 }).value(value.also { position += it.toString().length }) }
                        offlineVideo.channelId?.let { value -> writer.name("channelId".also { position += it.length + 4 }).value(value.also { position += it.length + 2 }) }
                        offlineVideo.channelLogin?.let { value -> writer.name("channelLogin".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                        offlineVideo.channelName?.let { value -> writer.name("channelName".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                        offlineVideo.gameId?.let { value -> writer.name("gameId".also { position += it.length + 4 }).value(value.also { position += it.length + 2 }) }
                        offlineVideo.gameSlug?.let { value -> writer.name("gameSlug".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                        offlineVideo.gameName?.let { value -> writer.name("gameName".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                        writer.endObject().also { position += 1 }
                        writer.name("startTime".also { position += it.length + 4 }).value(startTimeSeconds.also { position += it.toString().length })
                        val downloadedComments = mutableListOf<JsonObject>()
                        // Prefetch channel metadata and badge catalog so subscriber, founder,
                        // and channel-specific badges resolve their image URLs properly.
                        channelLogin?.takeIf { it.isNotBlank() }?.let { login ->
                            runCatching {
                                val channel = kickRepository.getChannel(login, prefetchBadgeCatalog = false)
                                kickRepository.cacheKickBadgeUrls(channel)
                                kickRepository.prefetchKickBadgeCatalog(channel)
                            }
                        }

                        // web.kick.com/api/v1/chat/{id}/history uses the chatroom's `channel_id`
                        // field — NOT the chatroom's own `id` nor the user/channel ID stored
                        // on the video. getChatHistoryId fetches this specifically.
                        val chatSourceId = channelLogin
                            ?.takeIf { it.isNotBlank() }
                            ?.let { login ->
                                runCatching {
                                    kickRepository.getChatHistoryId(login)
                                }.getOrNull()
                            }
                            ?: channelId?.takeIf { it.isNotBlank() }
                        if (chatSourceId.isNullOrBlank()) {
                            Log.w("OfflineChatDownload", "skipping chat download because no chat source id was available for videoId=$videoId")
                            offlineRepository.updateVideo(offlineVideo.apply {
                                chatProgress = offlineVideo.maxChatProgress
                            })
                            return@use
                        }
                        val actualStartTimeMs = (if (isClip) clipStartMs else offlineVideo.uploadDate) ?: 0L
                        val writtenMessageIds = mutableSetOf<String>()
                        // Parallel backward cursor walks: the history API caps pages at 25
                        // messages and each cursor depends on the previous response, so the
                        // range is split into slices walked backward concurrently. Chains
                        // only collect data; DB progress runs on a poller and the catalogs
                        // plus file writing happen after the chains join.
                        val walkChains = 4
                        val sliceDurationSeconds = ((endTimeSeconds - startTimeSeconds) + walkChains - 1) / walkChains
                        val sliceStartsSec = IntArray(walkChains) { startTimeSeconds + it * sliceDurationSeconds }
                        val sliceEndsSec = IntArray(walkChains) { minOf(sliceStartsSec[it] + sliceDurationSeconds, endTimeSeconds) }
                        // Per-chain oldest offset reached; progress sums per-slice coverage
                        // (a global minimum would credit unsliced ranges as done instantly).
                        val chainOldest = AtomicIntegerArray(walkChains).apply {
                            (0 until walkChains).forEach { set(it, sliceEndsSec[it]) }
                        }
                        val chatBadgesList = mutableListOf<ChatBadge>()
                        val chatEmotesList = mutableListOf<ChatEmote>()
                        val cheerEmotesList = mutableListOf<CheerEmote>()
                        val emotesList = mutableListOf<Emote>()

                        suspend fun walkChain(chain: Int): ChatWalkResult {
                            val sliceStartSec = sliceStartsSec[chain]
                            val sliceEndSec = sliceEndsSec[chain]
                            val result = ChatWalkResult()
                            var cursor: String? = ((actualStartTimeMs + sliceEndSec * 1000L) * 1000L).toString()
                            val seenCursors = mutableSetOf<String>()
                            val commentIds = mutableSetOf<String>()
                            var previousOldest = Int.MAX_VALUE
                            while (true) {
                                if (isStopped) throw CancellationException("download stopped")
                                val requestCursor = cursor
                                if (requestCursor == null || !seenCursors.add(requestCursor)) break
                                val response = kickRepository.getChatHistory(chatSourceId, requestCursor, requestCursor)
                                val messages = response.messages
                                result.pages += 1
                                if (messages.isEmpty()) break
                                val messageObjects = messages.mapNotNull { message ->
                                    val offsetSeconds = getKickChatOffsetSeconds(message, actualStartTimeMs)
                                        ?: return@mapNotNull null
                                    if (offsetSeconds !in startTimeSeconds..endTimeSeconds) {
                                        return@mapNotNull null
                                    }
                                    if (!commentIds.add(message.id ?: "kick:${message.hashCode()}")) {
                                        return@mapNotNull null
                                    }
                                    createKickChatCommentJson(message, actualStartTimeMs, result, downloadEmotes)
                                }
                                result.comments.addAll(messageObjects)
                                val pageOldestOffset = messages.mapNotNull { getKickChatOffsetSeconds(it, actualStartTimeMs) }.minOrNull()
                                if (pageOldestOffset != null) {
                                    // Guard against a server looping identical pages with
                                    // changing cursors: require strict backward progress.
                                    if (pageOldestOffset >= previousOldest) break
                                    previousOldest = pageOldestOffset
                                    chainOldest.updateAndGet(chain) { current -> if (pageOldestOffset < current) pageOldestOffset else current }
                                    if (pageOldestOffset < sliceStartSec) {
                                        // Walked past this slice's start; the slice is covered.
                                        break
                                    }
                                }
                                cursor = response.cursor
                            }
                            return result
                        }
                        val chainResults = coroutineScope {
                            val progressJob = launch {
                                while (isActive) {
                                    val covered = (0 until walkChains).sumOf { i ->
                                        (sliceEndsSec[i] - chainOldest[i]).coerceIn(0, sliceEndsSec[i] - sliceStartsSec[i])
                                    }.coerceIn(0, offlineVideo.maxChatProgress)
                                    offlineRepository.updateVideo(offlineVideo.apply { chatProgress = covered })
                                    delay(400)
                                }
                            }
                            val results = (0 until walkChains).map { chain ->
                                async { walkChain(chain) }
                            }
                            val done = results.awaitAll()
                            progressJob.cancel()
                            done
                        }
                        val reachedRangeStart = chainOldest[0] <= sliceStartsSec[0]
                        val pages = chainResults.sumOf { it.pages }
                        // Merge chain results in slice order; boundary overlaps dedupe here.
                        chainResults.forEach { result ->
                            result.comments.forEach { comment ->
                                val id = (comment["id"] as? JsonPrimitive)?.content
                                if (id == null || writtenMessageIds.add(id)) {
                                    downloadedComments.add(comment)
                                }
                            }
                            result.badgePairs.forEach { pair ->
                                if (savedBadges.add(pair)) {
                                    val url = collectedBadgeImageUrls[pair]?.takeIf { url -> url.isNotBlank() }
                                        ?: kickRepository.resolveKickBadgeUrl(pair.first.removePrefix("kick:"), pair.second, chatSourceId)
                                        ?: kickRepository.resolveKickInlineBadgeUrl(pair.first.removePrefix("kick:"), pair.second)
                                    if (!url.isNullOrBlank()) {
                                        chatBadgesList.add(ChatBadge(setId = pair.first, version = pair.second, url1x = url, url2x = url, url3x = url, url4x = url))
                                    }
                                }
                            }
                            result.emoteIds.forEach { emoteId ->
                                if (savedChatEmotes.add(emoteId)) {
                                    chatEmotesList.add(ChatEmote(
                                        id = emoteId,
                                        url1x = "https://files.kick.com/emotes/$emoteId/fullsize",
                                        url2x = "https://files.kick.com/emotes/$emoteId/fullsize",
                                        url3x = "https://files.kick.com/emotes/$emoteId/fullsize",
                                        url4x = "https://files.kick.com/emotes/$emoteId/fullsize"
                                    ))
                                }
                            }
                            result.words.forEach { word ->
                                if (savedEmotes.add(word)) {
                                    val bitsCount = word.takeLastWhile { it.isDigit() }
                                    val cheerEmote = if (bitsCount.isNotEmpty()) {
                                        val bitsName = word.substringBeforeLast(bitsCount)
                                        cheerEmoteList.findLast { it.name.equals(bitsName, true) && it.minBits <= bitsCount.toInt() }
                                    } else null
                                    if (cheerEmote != null) {
                                        cheerEmotesList.add(cheerEmote)
                                    } else {
                                        emoteList.find { it.name == word }?.let { emotesList.add(it) }
                                    }
                                }
                            }
                        }

                        // Emote/badge images are fetched after the walk in parallel chunks —
                        // fetching them inline stalled every page on large images.
                        suspend fun fetchImageBytes(url: String): ByteArray? = runCatching {
                            if (url.startsWith("data:", ignoreCase = true)) {
                                decodeDataUriToByteArray(url)
                            } else when {
                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                    val response = suspendCoroutine { continuation ->
                                        httpEngine!!.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                    }
                                    response.second
                                }
                                networkLibrary == "Cronet" && cronetEngine != null -> {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                        val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                        cronetEngine!!.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                                        request.future.get().responseBody as ByteArray
                                    } else {
                                        val response = suspendCoroutine { continuation ->
                                            cronetEngine!!.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                        }
                                        response.second
                                    }
                                }
                                else -> {
                                    okHttpClient.newCall(Request.Builder().url(url).build()).execute().use { response ->
                                        response.body.source().readByteArray()
                                    }
                                }
                            }
                        }.getOrNull()

                        suspend fun <T> writeImageArray(name: String, items: List<T>, urlOf: (T) -> String?, writeItem: (T, ByteArray) -> Unit) {
                            val resolvable = items.mapNotNull { item ->
                                urlOf(item)?.takeIf { url -> url.isNotBlank() }?.let { url -> item to url }
                            }
                            if (resolvable.isEmpty()) return
                            writer.name(name.also { position += it.length + 4 })
                            writer.beginArray().also { position += 1 }
                            val lastItem = resolvable.last().first
                            resolvable.chunked(6).forEach { chunk ->
                                val responses = coroutineScope {
                                    chunk.map { (_, url) -> async { fetchImageBytes(url) } }.awaitAll()
                                }
                                chunk.forEachIndexed { index, (item, _) ->
                                    val response = responses[index] ?: return@forEachIndexed
                                    writeItem(item, response)
                                    if (item != lastItem) {
                                        position += 1
                                    }
                                }
                            }
                            writer.endArray().also { position += 1 }
                        }
                        if (downloadEmotes && chatEmotesList.isNotEmpty()) {
                            writeImageArray("chatEmotes", chatEmotesList, { emote ->
                                when (emoteQuality) {
                                    "4" -> emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x
                                    "3" -> emote.url3x ?: emote.url2x ?: emote.url1x
                                    "2" -> emote.url2x ?: emote.url1x
                                    else -> emote.url1x
                                }
                            }) { emote, response ->
                                writer.beginObject().also { position += 1 }
                                writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                writer.name("id".also { position += it.length + 4 }).value(emote.id.also { position += it.toString().toByteArray().size + it.toString().count { c -> c == '"' || c == '\\' } + 2 })
                                writer.endObject().also { position += 1 }
                            }
                        }
                        if (downloadEmotes && chatBadgesList.isNotEmpty()) {
                            writeImageArray("ChatBadges", chatBadgesList, { badge ->
                                when (emoteQuality) {
                                    "4" -> badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x
                                    "3" -> badge.url3x ?: badge.url2x ?: badge.url1x
                                    "2" -> badge.url2x ?: badge.url1x
                                    else -> badge.url1x
                                }
                            }) { badge, response ->
                                writer.beginObject().also { position += 1 }
                                writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                writer.name("setId".also { position += it.length + 4 }).value(badge.setId.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                writer.name("version".also { position += it.length + 4 }).value(badge.version.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                writer.endObject().also { position += 1 }
                            }
                        }
                        if (downloadEmotes && cheerEmotesList.isNotEmpty()) {
                            writeImageArray("cheerEmotes", cheerEmotesList, { cheerEmote ->
                                when (emoteQuality) {
                                    "4" -> cheerEmote.url4x ?: cheerEmote.url3x ?: cheerEmote.url2x ?: cheerEmote.url1x
                                    "3" -> cheerEmote.url3x ?: cheerEmote.url2x ?: cheerEmote.url1x
                                    "2" -> cheerEmote.url2x ?: cheerEmote.url1x
                                    else -> cheerEmote.url1x
                                }
                            }) { cheerEmote, response ->
                                writer.beginObject().also { position += 1 }
                                writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                writer.name("name".also { position += it.length + 4 }).value(cheerEmote.name.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                writer.name("minBits".also { position += it.length + 4 }).value(cheerEmote.minBits.also { position += it.toString().length })
                                cheerEmote.color?.let { value -> writer.name("color".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                                writer.endObject().also { position += 1 }
                            }
                        }
                        if (downloadEmotes && emotesList.isNotEmpty()) {
                            writeImageArray("emotes", emotesList, { emote ->
                                when (emoteQuality) {
                                    "4" -> emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x
                                    "3" -> emote.url3x ?: emote.url2x ?: emote.url1x
                                    "2" -> emote.url2x ?: emote.url1x
                                    else -> emote.url1x
                                }
                            }) { emote, response ->
                                writer.beginObject().also { position += 1 }
                                writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                writer.name("name".also { position += it.length + 4 }).value(emote.name.also { position += it.toString().toByteArray().size + it.toString().count { c -> c == '"' || c == '\\' } + 2 })
                                writer.name("isZeroWidth".also { position += it.length + 4 }).value(emote.isOverlayEmote.also { position += it.toString().length })
                                writer.endObject().also { position += 1 }
                            }
                        }
                        // Badges save whenever chat downloads, not just with the emote toggle.
                        if (!downloadEmotes && chatBadgesList.isNotEmpty()) {
                            writeImageArray("ChatBadges", chatBadgesList, { badge ->
                                when (emoteQuality) {
                                    "4" -> badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x
                                    "3" -> badge.url3x ?: badge.url2x ?: badge.url1x
                                    "2" -> badge.url2x ?: badge.url1x
                                    else -> badge.url1x
                                }
                            }) { badge, response ->
                                writer.beginObject().also { position += 1 }
                                writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                writer.name("setId".also { position += it.length + 4 }).value(badge.setId.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                writer.name("version".also { position += it.length + 4 }).value(badge.version.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                writer.endObject().also { position += 1 }
                            }
                        }
                        if (!reachedRangeStart) {
                            Log.w(
                                "OfflineChatDownload",
                                "chat walk ended before range start videoId=$videoId chatId=$chatSourceId " +
                                    "start=$startTimeSeconds end=$endTimeSeconds oldest=${chainOldest[0]} " +
                                    "pages=$pages written=${writtenMessageIds.size} progress=${offlineVideo.chatProgress}/${offlineVideo.maxChatProgress}"
                            )
                        }
                        if (downloadedComments.isNotEmpty()) {
                            // Backward pages arrive newest-first; restore chronological order.
                            downloadedComments.sortBy { json ->
                                (json["contentOffsetSeconds"] as? JsonPrimitive)?.intOrNull ?: Int.MAX_VALUE
                            }
                            writer.name("comments".also { position += it.length + 4 })
                            writer.beginArray().also { position += 1 }
                            downloadedComments.forEach {
                                val length = writeJsonElement(null, it, writer)
                                if (length > 0L) {
                                    position += length + 1
                                }
                            }
                            writer.endArray().also { position += 1 }
                        }
                        writer.endObject().also { position += 1 }
                        offlineRepository.updateVideo(offlineVideo.apply {
                            chatProgress = offlineVideo.maxChatProgress
                            chatBytes = position
                        })
                    }
                }
            }
        }
    }

    private fun writeJsonElement(key: String?, value: JsonElement, writer: JsonWriter): Long {
        var position = 0L
        if (key != "__typename") {
            when (value) {
                is JsonObject -> {
                    if (key != null) {
                        writer.name(key.also { position += it.length + 3 })
                    }
                    writer.beginObject().also { position += 1 }
                    var empty = true
                    value.jsonObject.entries.forEach {
                        val length = writeJsonElement(it.key, it.value, writer)
                        if (length > 0L) {
                            position += length + 1
                            empty = false
                        }
                    }
                    writer.endObject().also { if (empty) { position += 1 } }
                }
                is JsonArray -> {
                    if (key != null) {
                        writer.name(key.also { position += it.length + 3 })
                    }
                    writer.beginArray().also { position += 1 }
                    var empty = true
                    value.jsonArray.forEach {
                        val length = writeJsonElement(null, it, writer)
                        if (length > 0L) {
                            position += length + 1
                            empty = false
                        }
                    }
                    writer.endArray().also { if (empty) { position += 1 } }
                }
                is JsonPrimitive -> {
                    if (value !is JsonNull) {
                        if (value.isString) {
                            if (key != null) {
                                writer.name(key.also { position += it.length + 3 })
                            }
                            writer.value(value.content.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                        } else {
                            value.intOrNull?.let { int ->
                                if (key != null) {
                                    writer.name(key.also { position += it.length + 3 })
                                }
                                writer.value(int.also { position += it.toString().length })
                            }
                            value.booleanOrNull?.let { boolean ->
                                if (key != null) {
                                    writer.name(key.also { position += it.length + 3 })
                                }
                                writer.value(boolean.also { position += it.toString().length })
                            }
                        }
                    }
                }
            }
        }
        return position
    }

    private fun formatIso8601Utc(timestampMs: Long): String {
        // Kick's history API requires milliseconds in the timestamp (e.g. 2026-04-30T17:06:00.000Z).
        // Instant.toString() omits fractional seconds when they are zero, so we force the format.
        val instant = Instant.ofEpochMilli(timestampMs)
        val seconds = instant.epochSecond
        val millis = instant.nano / 1_000_000
        val base = Instant.ofEpochSecond(seconds).toString() // e.g. 2026-04-30T17:06:00Z
        return if (base.endsWith("Z")) {
            base.dropLast(1) + "." + millis.toString().padStart(3, '0') + "Z"
        } else {
            base
        }
    }

    private fun getKickChatOffsetSeconds(message: KickMessage, startTimeMs: Long): Int? {
        val createdAtMs = message.createdAt?.let(KickApiHelper::parseIso8601DateUTC) ?: return null
        return ((createdAtMs - startTimeMs).coerceAtLeast(0L) / 1000L).toInt()
    }

    private fun createKickChatCommentJson(
        message: KickMessage,
        startTimeMs: Long,
        walkResult: ChatWalkResult? = null,
        downloadEmotes: Boolean = false
    ): JsonObject? {
        val offsetSeconds = getKickChatOffsetSeconds(message, startTimeMs) ?: return null
        val chatMessage = kickRepository.toChatMessage(message)
        val content = chatMessage.message
            ?: chatMessage.systemMsg
            ?: chatMessage.fullMsg
            ?: message.content
            ?: message.message
            ?: message.text
            ?: message.body
            ?: return null
        val badges = chatMessage.badges.orEmpty()
        badges.forEach { badge ->
            val url = badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x
            if (!url.isNullOrBlank()) {
                collectedBadgeImageUrls.putIfAbsent(Pair(badge.setId, badge.version), url)
            }
            walkResult?.badgePairs?.add(Pair(badge.setId, badge.version))
        }
        if (downloadEmotes && walkResult != null) {
            chatMessage.emotes?.mapNotNull { it.id }?.forEach { walkResult.emoteIds.add(it) }
            content.split(" ").filter { it.isNotBlank() }.forEach { walkResult.words.add(it) }
        }
        return buildJsonObject {
            put("id", JsonPrimitive(message.id ?: "kick:${message.hashCode()}"))
            put("commenter", buildJsonObject {
                chatMessage.userId?.let { put("id", JsonPrimitive(it)) }
                chatMessage.userLogin?.let { put("login", JsonPrimitive(it)) }
                chatMessage.userName?.let { put("displayName", JsonPrimitive(it)) }
            })
            put("contentOffsetSeconds", JsonPrimitive(offsetSeconds))
            put("message", buildJsonObject {
                put("fragments", buildJsonArray {
                    val emotes = chatMessage.emotes.orEmpty().sortedBy { it.begin }
                    if (emotes.isEmpty()) {
                        add(buildJsonObject {
                            put("text", JsonPrimitive(content))
                        })
                    } else {
                        var lastIndexCp = 0
                        emotes.forEach { emote ->
                            if (emote.begin > lastIndexCp) {
                                val charStart = content.offsetByCodePoints(0, lastIndexCp)
                                val charEnd = content.offsetByCodePoints(0, emote.begin)
                                val textPart = content.substring(charStart, charEnd)
                                if (textPart.isNotEmpty()) {
                                    add(buildJsonObject {
                                        put("text", JsonPrimitive(textPart))
                                    })
                                }
                            }
                            add(buildJsonObject {
                                put("text", JsonPrimitive(emote.name ?: ""))
                                put("emote", buildJsonObject {
                                    put("emoteID", JsonPrimitive(emote.id ?: ""))
                                })
                            })
                            lastIndexCp = emote.end + 1
                        }
                        val totalCp = content.codePointCount(0, content.length)
                        if (lastIndexCp < totalCp) {
                            val charStart = content.offsetByCodePoints(0, lastIndexCp)
                            add(buildJsonObject {
                                put("text", JsonPrimitive(content.substring(charStart)))
                            })
                        }
                    }
                })
                if (badges.isNotEmpty()) {
                    put("userBadges", buildJsonArray {
                        badges.forEach { badge ->
                            add(buildJsonObject {
                                put("setID", JsonPrimitive(badge.setId))
                                put("version", JsonPrimitive(badge.version))
                            })
                        }
                    })
                }
                chatMessage.color?.let { put("userColor", JsonPrimitive(it)) }
            })
        }
    }

    private fun decodeDataUriToByteArray(dataUri: String): ByteArray {
        val commaIndex = dataUri.indexOf(',')
        if (commaIndex == -1) return ByteArray(0)
        val meta = dataUri.substring(0, commaIndex)
        val data = dataUri.substring(commaIndex + 1)
        return if (meta.contains(";base64", ignoreCase = true)) {
            Base64.decode(data, Base64.DEFAULT)
        } else {
            data.toByteArray(Charsets.UTF_8)
        }
    }

    private fun canOpenChatFile(fileUri: String, isShared: Boolean): Boolean {
        return runCatching {
            if (isShared) {
                context.contentResolver.openInputStream(fileUri.toUri())?.close() != null
            } else {
                File(fileUri).exists()
            }
        }.getOrDefault(false)
    }

    private fun createForegroundInfo(): ForegroundInfo {
        val channelId = context.getString(R.string.notification_downloads_channel_id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (notificationManager.getNotificationChannel(channelId) == null) {
                NotificationChannel(channelId, ContextCompat.getString(context, R.string.notification_downloads_channel_title), NotificationManager.IMPORTANCE_DEFAULT).apply {
                    setSound(null, null)
                    notificationManager.createNotificationChannel(this)
                }
            }
        }
        val notification = NotificationCompat.Builder(context, channelId).apply {
            setGroup(GROUP_KEY)
            setContentTitle(ContextCompat.getString(context, R.string.downloading))
            setContentText(offlineVideo.name)
            setSmallIcon(android.R.drawable.stat_sys_download)
            setProgress(offlineVideo.maxProgress, offlineVideo.progress, false)
            setOngoing(true)
            setContentIntent(
                PendingIntent.getActivity(
                    context,
                    offlineVideo.id,
                    Intent(context, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        action = MainActivity.INTENT_OPEN_DOWNLOADS_TAB
                    },
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )
            )
            addAction(android.R.drawable.ic_delete, ContextCompat.getString(context, R.string.stop), WorkManager.getInstance(context).createCancelPendingIntent(id))
        }.build()
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            ForegroundInfo(offlineVideo.id, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC)
        } else {
            ForegroundInfo(offlineVideo.id, notification)
        }
    }

    private suspend fun getFirstVariantPlaylistUrl(networkLibrary: String?, masterUrl: String): String? {
        val masterPlaylist = playerRepository.loadTextFromUrl(networkLibrary, masterUrl)
            ?.takeIf { it.isNotBlank() }
            ?: return null
        return masterPlaylist
            .lineSequence()
            .map { it.trim() }
            .firstOrNull { it.isNotBlank() && !it.startsWith("#") && it.substringBefore('?').endsWith(".m3u8") }
            ?.let { resolvePlaylistUrl(masterUrl, it) }
    }

    private fun resolvePlaylistUrl(baseUrl: String, url: String): String {
        return runCatching { URI(baseUrl).resolve(url).toString() }.getOrElse { url }
    }

    companion object {
        const val GROUP_KEY = "com.xtrakick.app.DOWNLOADS"

        const val KEY_VIDEO_ID = "KEY_VIDEO_ID"
        const val KEY_FORCE_CHAT_REDOWNLOAD = "forceChatRedownload"

        // Serialized across worker instances: the provider rejects concurrent creates.
        val documentCreationMutex = Mutex()

        // Per-video work chains: downloads run in parallel, not in one shared queue.
        fun workName(videoId: Int) = "download-$videoId"
    }
}
