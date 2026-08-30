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
import android.util.JsonReader
import android.util.JsonToken
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
import com.xtrakick.app.model.chat.Badge
import com.xtrakick.app.model.chat.CheerEmote
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.ChatBadge
import com.xtrakick.app.model.chat.ChatEmote
import com.xtrakick.app.model.chat.VideoChatMessage
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore
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
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.StringReader
import java.net.URI
import java.time.Instant
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

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
            val from = offlineVideo.fromTime!!
            val to = offlineVideo.toTime!!
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
                }).let { if (it < 0) -it else it }
            }
            val toIndex = if (to in relativeStartTimes.last()..totalDuration) {
                relativeStartTimes.lastIndex
            } else {
                val max = to + targetDuration
                relativeStartTimes.binarySearch(comparison = { time ->
                    when {
                        time > max -> 1
                        time < to -> -1
                        else -> 0
                    }
                }).let { if (it < 0) -it else it }
            }
            val urlPath = playlistUrl.substringBeforeLast('/') + "/"
            val remainingSegments = ArrayList<Segment>()
            if (offlineVideo.progress < offlineVideo.maxProgress) {
                for (i in fromIndex + offlineVideo.progress..toIndex) {
                    val segment = playlist.segments[i]
                    remainingSegments.add(segment.copy(uri = segment.uri.replace("-unmuted", "-muted")))
                }
            }
            val requestSemaphore = Semaphore(context.prefs().getInt(AppConstants.DOWNLOAD_CONCURRENT_LIMIT, 10))
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
                        FileOutputStream(fileUri).use { output ->
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
                runBlocking {
                    val segmentIds = generateSequence(0) { it + 1 }.iterator()
                    remainingSegments.map {
                        val id = segmentIds.next()
                        launch {
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
                                        okHttpClient.newCall(Request.Builder().url(urlPath + it.uri).build()).execute().use { response ->
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
                    val downloadedTracks = mutableListOf<String>()
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
                    runBlocking {
                        val segmentIds = generateSequence(0) { it + 1 }.iterator()
                        remainingSegments.map {
                            val id = segmentIds.next()
                            launch {
                                requestSemaphore.withPermit {
                                    val fileUri = (videoDirectoryUri + "%2F" + it.uri).toUri()
                                    try {
                                        context.contentResolver.openOutputStream(fileUri)!!
                                    } catch (e: IllegalArgumentException) {
                                        null
                                    }.use { outputStream ->
                                        if (outputStream == null || !downloadedTracks.contains(it.uri)) {
                                            when {
                                                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                                    val response = suspendCoroutine { continuation ->
                                                        httpEngine!!.get().newUrlRequestBuilder(urlPath + it.uri, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                                    }
                                                    if (outputStream != null) {
                                                        outputStream
                                                    } else {
                                                        DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", it.uri)
                                                        context.contentResolver.openOutputStream(fileUri)!!
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
                                                        DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", it.uri)
                                                        context.contentResolver.openOutputStream(fileUri)!!
                                                    }.use {
                                                        it.write(response)
                                                    }
                                                }
                                                else -> {
                                                    okHttpClient.newCall(Request.Builder().url(urlPath + it.uri).build()).execute().use { response ->
                                                        if (outputStream != null) {
                                                            outputStream
                                                        } else {
                                                            DocumentsContract.createDocument(context.contentResolver, videoDirectoryUri.toUri(), "", it.uri)
                                                            context.contentResolver.openOutputStream(fileUri)!!
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
                    val downloadedTracks = mutableListOf<String>()
                    val playlists = File(directory).listFiles { it.extension == "m3u8" && it.path != playlistFileUri }
                    playlists?.forEach { file ->
                        val p = PlaylistUtils.parseMediaPlaylist(file.inputStream())
                        p.segments.forEach { downloadedTracks.add(it.uri.substringAfterLast("%2F").substringAfterLast("/")) }
                    }
                    runBlocking {
                        val segmentIds = generateSequence(0) { it + 1 }.iterator()
                        remainingSegments.map {
                            val id = segmentIds.next()
                            launch {
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
                                                okHttpClient.newCall(Request.Builder().url(urlPath + it.uri).build()).execute().use { response ->
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
            val chatJob = runBlocking {
                launch {
                    startChatJob(path, forceChatRedownload)
                }
            }
            jobs.joinAll()
            chatJob.join()
        } else {
            val path = offlineVideo.downloadPath!!
            val isShared = path.toUri().scheme == ContentResolver.SCHEME_CONTENT
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
            val chatJob = runBlocking {
                launch {
                    startChatJob(path, forceChatRedownload)
                }
            }
            jobs.join()
            chatJob.join()
        }
        if (offlineVideo.progress < offlineVideo.maxProgress || offlineVideo.downloadChat && offlineVideo.chatProgress < offlineVideo.maxChatProgress) {
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

    private suspend fun startChatJob(path: String, forceChatRedownload: Boolean) {
        if ((offlineVideo.downloadChat || forceChatRedownload) && offlineVideo.chatProgress < offlineVideo.maxChatProgress) {
            offlineVideo.videoId?.let { videoId ->
                val isShared = path.toUri().scheme == ContentResolver.SCHEME_CONTENT
                val startTimeSeconds = (offlineVideo.sourceStartPosition!! / 1000).toInt()
                val requestedDurationSeconds = offlineVideo.fromTime?.let { from ->
                    offlineVideo.toTime?.let { to -> ((to - from).coerceAtLeast(0L) / 1000L).toInt() }
                } ?: 0
                val durationSeconds = maxOf((offlineVideo.duration!! / 1000).toInt(), requestedDurationSeconds)
                val requestedEndTimeSeconds = offlineVideo.toTime?.let { (it / 1000L).toInt() } ?: 0
                val endTimeSeconds = maxOf(startTimeSeconds + durationSeconds, requestedEndTimeSeconds + 120)
                val fileName = "${videoId}${offlineVideo.quality ?: ""}${offlineVideo.downloadDate}_chat.json"
                val hasExistingChatFile = !offlineVideo.chatUrl.isNullOrBlank()
                val resumed = false
                val savedOffset = if (resumed) offlineVideo.chatOffsetSeconds else 0
                val latestSavedMessages = mutableListOf<VideoChatMessage>()
                val savedChatEmotes = hashSetOf<String>()
                val savedBadges = hashSetOf<Pair<String, String>>()
                val savedEmotes = hashSetOf<String>()
                val existingChatFileUri = offlineVideo.chatUrl
                val existingChatFileAccessible = if (hasExistingChatFile) {
                    canOpenChatFile(existingChatFileUri!!, isShared)
                } else {
                    false
                }
                val fileUri = if (resumed || (forceChatRedownload && existingChatFileAccessible)) {
                    val fileUri = existingChatFileUri!!
                    if (resumed) {
                        if (isShared) {
                            context.contentResolver.openFileDescriptor(fileUri.toUri(), "rw")!!.use {
                                FileOutputStream(it.fileDescriptor).use { output ->
                                    output.channel.truncate(offlineVideo.chatBytes)
                                }
                            }
                        } else {
                            FileOutputStream(fileUri).use { output ->
                                output.channel.truncate(offlineVideo.chatBytes)
                            }
                        }
                    }
                    if (resumed) {
                        if (isShared) {
                            context.contentResolver.openOutputStream(fileUri.toUri(), "wa")!!.bufferedWriter()
                        } else {
                            FileOutputStream(fileUri, true).bufferedWriter()
                        }.use { fileWriter ->
                            fileWriter.write("}")
                        }
                        if (isShared) {
                            context.contentResolver.openInputStream(fileUri.toUri())?.bufferedReader()
                        } else {
                            FileInputStream(File(fileUri)).bufferedReader()
                        }?.use { fileReader ->
                            try {
                                JsonReader(fileReader).use { reader ->
                                    reader.isLenient = true
                                    var token: JsonToken
                                    do {
                                        token = reader.peek()
                                        when (token) {
                                            JsonToken.END_DOCUMENT -> {}
                                            JsonToken.BEGIN_OBJECT -> {
                                                reader.beginObject()
                                                while (reader.hasNext()) {
                                                    when (reader.peek()) {
                                                        JsonToken.NAME -> {
                                                            when (reader.nextName()) {
                                                                "comments" -> {
                                                                    reader.beginArray()
                                                                    while (reader.hasNext()) {
                                                                        readMessageObject(reader)?.let {
                                                                            if (it.offsetSeconds == savedOffset) {
                                                                                latestSavedMessages.add(it)
                                                                            }
                                                                        }
                                                                    }
                                                                    reader.endArray()
                                                                }
                                                                "chatEmotes" -> {
                                                                    reader.beginArray()
                                                                    while (reader.hasNext()) {
                                                                        reader.beginObject()
                                                                        var id: String? = null
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName()) {
                                                                                "id" -> id = reader.nextString()
                                                                                else -> reader.skipValue()
                                                                            }
                                                                        }
                                                                        if (!id.isNullOrBlank()) {
                                                                            savedChatEmotes.add(id)
                                                                        }
                                                                        reader.endObject()
                                                                    }
                                                                    reader.endArray()
                                                                }
                                                                "ChatBadges" -> {
                                                                    reader.beginArray()
                                                                    while (reader.hasNext()) {
                                                                        reader.beginObject()
                                                                        var setId: String? = null
                                                                        var version: String? = null
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName()) {
                                                                                "setId" -> setId = reader.nextString()
                                                                                "version" -> version = reader.nextString()
                                                                                else -> reader.skipValue()
                                                                            }
                                                                        }
                                                                        if (!setId.isNullOrBlank() && !version.isNullOrBlank()) {
                                                                            savedBadges.add(Pair(setId, version))
                                                                        }
                                                                        reader.endObject()
                                                                    }
                                                                    reader.endArray()
                                                                }
                                                                "cheerEmotes" -> {
                                                                    reader.beginArray()
                                                                    while (reader.hasNext()) {
                                                                        reader.beginObject()
                                                                        var name: String? = null
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName()) {
                                                                                "name" -> name = reader.nextString()
                                                                                else -> reader.skipValue()
                                                                            }
                                                                        }
                                                                        if (!name.isNullOrBlank()) {
                                                                            savedEmotes.add(name)
                                                                        }
                                                                        reader.endObject()
                                                                    }
                                                                    reader.endArray()
                                                                }
                                                                "emotes" -> {
                                                                    reader.beginArray()
                                                                    while (reader.hasNext()) {
                                                                        reader.beginObject()
                                                                        var name: String? = null
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName()) {
                                                                                "name" -> name = reader.nextString()
                                                                                else -> reader.skipValue()
                                                                            }
                                                                        }
                                                                        if (!name.isNullOrBlank()) {
                                                                            savedEmotes.add(name)
                                                                        }
                                                                        reader.endObject()
                                                                    }
                                                                    reader.endArray()
                                                                }
                                                                else -> reader.skipValue()
                                                            }
                                                        }
                                                        else -> reader.skipValue()
                                                    }
                                                }
                                                reader.endObject()
                                            }
                                            else -> reader.skipValue()
                                        }
                                    } while (token != JsonToken.END_DOCUMENT)
                                }
                            } catch (_: Exception) {
                                // Resume data is best-effort; if the partial file is malformed, continue with a fresh parse state.
                            }
                        }
                    }
                    fileUri
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
                val badgeList = emptyList<ChatBadge>()
                val cheerEmoteList = emptyList<CheerEmote>()
                val emoteList = emptyList<Emote>()
                if (!resumed) {
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
                }
                if (isShared) {
                    context.contentResolver.openOutputStream(fileUri.toUri(), if (resumed) "wa" else "w")!!.bufferedWriter()
                } else {
                    FileOutputStream(fileUri, resumed).bufferedWriter()
                }.use { fileWriter ->
                    JsonWriter(fileWriter).use { writer ->
                        var position = if (resumed) offlineVideo.chatBytes else 0L
                        if (!resumed) {
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
                        }
                        val downloadedComments = mutableListOf<JsonObject>()
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
                        val actualStartTimeMs = offlineVideo.uploadDate ?: 0L
                        val fetchStartTimeMs = actualStartTimeMs + startTimeSeconds.times(1000L)
                        var chatStartTime = formatIso8601Utc(fetchStartTimeMs)
                        val seenStartTimes = mutableSetOf<String>()
                        val writtenMessageIds = mutableSetOf<String>()
                        var lastOffsetSeconds: Int? = null
                        var page = 0
                        val targetEndTimeMs = actualStartTimeMs + endTimeSeconds.times(1000L)
                        val historyPollIntervalMs = 5_000L
                        var scannedToEnd = false
                        loop@ do {
                            val requestStartTime = chatStartTime
                            val requestStartTimeMs = KickApiHelper.parseIso8601DateUTC(requestStartTime) ?: fetchStartTimeMs
                            if (!seenStartTimes.add(requestStartTime)) {
                                Log.w(
                                    "OfflineChatDownload",
                                    "stop duplicateStartTime videoId=$videoId page=${page + 1} startTime=$requestStartTime last=${lastOffsetSeconds ?: -1} target=$endTimeSeconds"
                                )
                                break@loop
                            }
                            val response = kickRepository.getChatHistory(chatSourceId, requestStartTime, null)
                            val messages = response.messages
                            page += 1
                            if (messages.isEmpty()) {
                                val pollStartTimeMs = requestStartTimeMs + historyPollIntervalMs
                                if (pollStartTimeMs <= targetEndTimeMs) {
                                    val pollStartTime = formatIso8601Utc(pollStartTimeMs)
                                    if (!seenStartTimes.contains(pollStartTime)) {
                                        chatStartTime = pollStartTime
                                        continue@loop
                                    }
                                } else {
                                    scannedToEnd = true
                                }
                                Log.w(
                                    "OfflineChatDownload",
                                    "stop emptyPage videoId=$videoId page=$page chatId=$chatSourceId startTime=$chatStartTime " +
                                        "cursor=${response.cursor ?: "-"} last=${lastOffsetSeconds ?: -1} target=$endTimeSeconds"
                                )
                                offlineRepository.updateVideo(offlineVideo.apply {
                                    chatProgress = offlineVideo.maxChatProgress
                                })
                                break@loop
                            }
                            val messageObjects = messages.mapNotNull { message ->
                                val offsetSeconds = getKickChatOffsetSeconds(message, actualStartTimeMs)
                                    ?: return@mapNotNull null
                                if (offsetSeconds !in startTimeSeconds..endTimeSeconds) {
                                    return@mapNotNull null
                                }
                                message.id?.takeIf { it.isNotBlank() }?.let { id ->
                                    if (!writtenMessageIds.add(id)) {
                                        return@mapNotNull null
                                    }
                                }
                                createKickChatCommentJson(message, actualStartTimeMs)
                            }
                            val comments = if (resumed && seenStartTimes.size == 1) {
                                writer.beginObject().also { position += 1 }
                                val list = mutableListOf<JsonObject>()
                                messageObjects.forEach { json ->
                                    StringReader(json.toString()).use { string ->
                                        JsonReader(string).use { reader ->
                                            readMessageObject(reader)?.let {
                                                it.offsetSeconds?.let { offset ->
                                                    if ((offset == savedOffset && !latestSavedMessages.contains(it)) || offset > savedOffset) {
                                                        list.add(json)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                list
                            } else messageObjects
                            if (comments.isNotEmpty()) {
                                downloadedComments.addAll(comments)
                            }
                            if (downloadEmotes) {
                                val words = hashSetOf<String>()
                                val emoteIds = hashSetOf<String>()
                                val badges = hashSetOf<Badge>()
                                messageObjects.mapNotNull { json ->
                                    StringReader(json.toString()).use { string ->
                                        JsonReader(string).use { reader ->
                                            readMessageObject(reader)
                                        }
                                    }
                                }.forEach { message ->
                                    message.emotes?.mapNotNull { it.id }?.let { emoteIds.addAll(it) }
                                    message.badges?.let { badges.addAll(it) }
                                    message.message?.split(" ").orEmpty().forEach { word ->
                                        words.add(word)
                                    }
                                }
                                val chatEmotes = mutableListOf<ChatEmote>()
                                val ChatBadges = mutableListOf<ChatBadge>()
                                val cheerEmotes = mutableListOf<CheerEmote>()
                                val emotes = mutableListOf<Emote>()
                                emoteIds.forEach {
                                    if (savedChatEmotes.add(it)) {
                                        chatEmotes.add(ChatEmote(
                                            id = it,
                                            url1x = "https://files.kick.com/emotes/$it/fullsize",
                                            url2x = "https://files.kick.com/emotes/$it/fullsize",
                                            url3x = "https://files.kick.com/emotes/$it/fullsize",
                                            url4x = "https://files.kick.com/emotes/$it/fullsize"
                                        ))
                                    }
                                }
                                badges.forEach {
                                    val pair = Pair(it.setId, it.version)
                                    if (savedBadges.add(pair)) {
                                        val badge = badgeList.find { badge -> badge.setId == it.setId && badge.version == it.version }
                                        if (badge != null) {
                                            ChatBadges.add(badge)
                                        }
                                    }
                                }
                                words.forEach { word ->
                                    if (savedEmotes.add(word)) {
                                        val bitsCount = word.takeLastWhile { it.isDigit() }
                                        val cheerEmote = if (bitsCount.isNotEmpty()) {
                                            val bitsName = word.substringBeforeLast(bitsCount)
                                            cheerEmoteList.findLast { it.name.equals(bitsName, true) && it.minBits <= bitsCount.toInt() }
                                        } else null
                                        if (cheerEmote != null) {
                                            cheerEmotes.add(cheerEmote)
                                        } else {
                                            val emote = emoteList.find { it.name == word }
                                            if (emote != null) {
                                                emotes.add(emote)
                                            }
                                        }
                                    }
                                }
                                if (chatEmotes.isNotEmpty()) {
                                    writer.name("chatEmotes".also { position += it.length + 4 })
                                    writer.beginArray().also { position += 1 }
                                    val last = chatEmotes.lastOrNull()
                                    chatEmotes.forEach { emote ->
                                        val url = when (emoteQuality) {
                                            "4" -> emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x
                                            "3" -> emote.url3x ?: emote.url2x ?: emote.url1x
                                            "2" -> emote.url2x ?: emote.url1x
                                            else -> emote.url1x
                                        }!!
                                        val response = when {
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
                                        writer.beginObject().also { position += 1 }
                                        writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                        writer.name("id".also { position += it.length + 4 }).value(emote.id.also { position += it.toString().toByteArray().size + it.toString().count { c -> c == '"' || c == '\\' } + 2 })
                                        writer.endObject().also { position += 1 }
                                        if (emote != last) {
                                            position += 1
                                        }
                                    }
                                    writer.endArray().also { position += 1 }
                                }
                                if (ChatBadges.isNotEmpty()) {
                                    writer.name("ChatBadges".also { position += it.length + 4 })
                                    writer.beginArray().also { position += 1 }
                                    val last = ChatBadges.lastOrNull()
                                    ChatBadges.forEach { badge ->
                                        val url = when (emoteQuality) {
                                            "4" -> badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x
                                            "3" -> badge.url3x ?: badge.url2x ?: badge.url1x
                                            "2" -> badge.url2x ?: badge.url1x
                                            else -> badge.url1x
                                        }!!
                                        val response = when {
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
                                        writer.beginObject().also { position += 1 }
                                        writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                        writer.name("setId".also { position += it.length + 4 }).value(badge.setId.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                        writer.name("version".also { position += it.length + 4 }).value(badge.version.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                        writer.endObject().also { position += 1 }
                                        if (badge != last) {
                                            position += 1
                                        }
                                    }
                                    writer.endArray().also { position += 1 }
                                }
                                if (cheerEmotes.isNotEmpty()) {
                                    writer.name("cheerEmotes".also { position += it.length + 4 })
                                    writer.beginArray().also { position += 1 }
                                    val last = cheerEmotes.lastOrNull()
                                    cheerEmotes.forEach { cheerEmote ->
                                        val url = when (emoteQuality) {
                                            "4" -> cheerEmote.url4x ?: cheerEmote.url3x ?: cheerEmote.url2x ?: cheerEmote.url1x
                                            "3" -> cheerEmote.url3x ?: cheerEmote.url2x ?: cheerEmote.url1x
                                            "2" -> cheerEmote.url2x ?: cheerEmote.url1x
                                            else -> cheerEmote.url1x
                                        }!!
                                        val response = when {
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
                                        writer.beginObject().also { position += 1 }
                                        writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                        writer.name("name".also { position += it.length + 4 }).value(cheerEmote.name.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 })
                                        writer.name("minBits".also { position += it.length + 4 }).value(cheerEmote.minBits.also { position += it.toString().length })
                                        cheerEmote.color?.let { value -> writer.name("color".also { position += it.length + 4 }).value(value.also { position += it.toByteArray().size + it.count { c -> c == '"' || c == '\\' } + 2 }) }
                                        writer.endObject().also { position += 1 }
                                        if (cheerEmote != last) {
                                            position += 1
                                        }
                                    }
                                    writer.endArray().also { position += 1 }
                                }
                                if (emotes.isNotEmpty()) {
                                    writer.name("emotes".also { position += it.length + 4 })
                                    writer.beginArray().also { position += 1 }
                                    val last = emotes.lastOrNull()
                                    emotes.forEach { emote ->
                                        val url = when (emoteQuality) {
                                            "4" -> emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x
                                            "3" -> emote.url3x ?: emote.url2x ?: emote.url1x
                                            "2" -> emote.url2x ?: emote.url1x
                                            else -> emote.url1x
                                        }!!
                                        val response = when {
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
                                        writer.beginObject().also { position += 1 }
                                        writer.name("data".also { position += it.length + 3 }).value(Base64.encodeToString(response, Base64.NO_WRAP or Base64.NO_PADDING).also { position += it.toByteArray().size + 2 })
                                        writer.name("name".also { position += it.length + 4 }).value(emote.name.also { position += it.toString().toByteArray().size + it.toString().count { c -> c == '"' || c == '\\' } + 2 })
                                        writer.name("isZeroWidth".also { position += it.length + 4 }).value(emote.isOverlayEmote.also { position += it.toString().length })
                                        writer.endObject().also { position += 1 }
                                        if (emote != last) {
                                            position += 1
                                        }
                                    }
                                    writer.endArray().also { position += 1 }
                                }
                            }
                            lastOffsetSeconds = messages.lastOrNull()?.let { getKickChatOffsetSeconds(it, actualStartTimeMs) }
                            if (lastOffsetSeconds != null) {
                                offlineRepository.updateVideo(offlineVideo.apply {
                                    chatProgress = (lastOffsetSeconds - startTimeSeconds).coerceIn(0, offlineVideo.maxChatProgress)
                                    chatBytes = position
                                    chatOffsetSeconds = lastOffsetSeconds
                                })
                            }
                            val pollStartTimeMs = requestStartTimeMs + historyPollIntervalMs
                            if (pollStartTimeMs > targetEndTimeMs) {
                                scannedToEnd = true
                                break@loop
                            }
                            val pollStartTime = formatIso8601Utc(pollStartTimeMs)
                            val nextStartTime = pollStartTime.takeIf { !seenStartTimes.contains(it) }
                            if (nextStartTime == null) {
                                Log.w(
                                    "OfflineChatDownload",
                                    "stop noNextStart videoId=$videoId page=$page requestStart=$requestStartTime " +
                                        "pollStart=$pollStartTime last=${lastOffsetSeconds ?: -1} target=$endTimeSeconds"
                                )
                                break@loop
                            }
                            chatStartTime = nextStartTime
                        } while (lastOffsetSeconds?.let { it < endTimeSeconds } != false)
                        if (scannedToEnd || lastOffsetSeconds?.let { it >= endTimeSeconds } == true) {
                            offlineRepository.updateVideo(offlineVideo.apply {
                                chatProgress = offlineVideo.maxChatProgress
                            })
                        } else {
                            Log.w(
                                "OfflineChatDownload",
                                "incomplete chat download videoId=$videoId chatId=$chatSourceId " +
                                    "start=$startTimeSeconds end=$endTimeSeconds last=${lastOffsetSeconds ?: -1} " +
                                    "pages=$page written=${writtenMessageIds.size} progress=${offlineVideo.chatProgress}/${offlineVideo.maxChatProgress}"
                            )
                        }
                        if (downloadedComments.isNotEmpty()) {
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

    private fun createKickChatCommentJson(message: KickMessage, startTimeMs: Long): JsonObject? {
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

    private fun canOpenChatFile(fileUri: String, isShared: Boolean): Boolean {
        return runCatching {
            if (isShared) {
                context.contentResolver.openInputStream(fileUri.toUri())?.close() != null
            } else {
                File(fileUri).exists()
            }
        }.getOrDefault(false)
    }

    private fun readMessageObject(reader: JsonReader): VideoChatMessage? {
        var chatMessage: VideoChatMessage? = null
        reader.beginObject()
        val message = StringBuilder()
        var id: String? = null
        var offsetSeconds: Int? = null
        var userId: String? = null
        var userLogin: String? = null
        var userName: String? = null
        var color: String? = null
        val emotesList = mutableListOf<ChatEmote>()
        val badgesList = mutableListOf<Badge>()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextString()
                "commenter" -> {
                    when (reader.peek()) {
                        JsonToken.BEGIN_OBJECT -> {
                            reader.beginObject()
                            while (reader.hasNext()) {
                                when (reader.nextName()) {
                                    "id" -> userId = reader.nextString()
                                    "login" -> userLogin = reader.nextString()
                                    "displayName" -> userName = reader.nextString()
                                    else -> reader.skipValue()
                                }
                            }
                            reader.endObject()
                        }
                        else -> reader.skipValue()
                    }
                }
                "contentOffsetSeconds" -> offsetSeconds = reader.nextInt()
                "message" -> {
                    reader.beginObject()
                    while (reader.hasNext()) {
                        when (reader.nextName()) {
                            "fragments" -> {
                                reader.beginArray()
                                while (reader.hasNext()) {
                                    reader.beginObject()
                                    var emoteId: String? = null
                                    var fragmentText: String? = null
                                    while (reader.hasNext()) {
                                        when (reader.nextName()) {
                                            "emote" -> {
                                                when (reader.peek()) {
                                                    JsonToken.BEGIN_OBJECT -> {
                                                        reader.beginObject()
                                                        while (reader.hasNext()) {
                                                            when (reader.nextName()) {
                                                                "emoteID" -> emoteId = reader.nextString()
                                                                else -> reader.skipValue()
                                                            }
                                                        }
                                                        reader.endObject()
                                                    }
                                                    else -> reader.skipValue()
                                                }
                                            }
                                            "text" -> fragmentText = reader.nextString()
                                            else -> reader.skipValue()
                                        }
                                    }
                                    if (fragmentText != null && !emoteId.isNullOrBlank()) {
                                        emotesList.add(ChatEmote(
                                            id = emoteId,
                                            begin = message.codePointCount(0, message.length),
                                            end = message.codePointCount(0, message.length) + fragmentText.lastIndex
                                        ))
                                    }
                                    message.append(fragmentText)
                                    reader.endObject()
                                }
                                reader.endArray()
                            }
                            "userBadges" -> {
                                reader.beginArray()
                                while (reader.hasNext()) {
                                    reader.beginObject()
                                    var set: String? = null
                                    var version: String? = null
                                    while (reader.hasNext()) {
                                        when (reader.nextName()) {
                                            "setID" -> set = reader.nextString()
                                            "version" -> version = reader.nextString()
                                            else -> reader.skipValue()
                                        }
                                    }
                                    if (!set.isNullOrBlank() && !version.isNullOrBlank()) {
                                        badgesList.add(
                                            Badge(set, version)
                                        )
                                    }
                                    reader.endObject()
                                }
                                reader.endArray()
                            }
                            "userColor" -> {
                                when (reader.peek()) {
                                    JsonToken.STRING -> color = reader.nextString()
                                    else -> reader.skipValue()
                                }
                            }
                            else -> reader.skipValue()
                        }
                    }
                    chatMessage = VideoChatMessage(
                        id = id,
                        offsetSeconds = offsetSeconds,
                        userId = userId,
                        userLogin = userLogin,
                        userName = userName,
                        message = message.toString(),
                        color = color,
                        emotes = emotesList,
                        badges = badgesList,
                        fullMsg = null
                    )
                    reader.endObject()
                }
                else -> reader.skipValue()
            }
        }
        reader.endObject()
        return chatMessage
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
    }
}
