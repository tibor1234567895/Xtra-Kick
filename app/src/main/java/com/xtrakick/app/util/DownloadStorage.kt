package com.xtrakick.app.util

import android.content.Context
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.OpenableColumns
import androidx.core.net.toUri
import androidx.documentfile.provider.DocumentFile
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.util.m3u8.MediaPlaylist
import com.xtrakick.app.util.m3u8.PlaylistUtils
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.io.InputStream

object DownloadStorage {

    private const val MAX_SEGMENT_LEN = 80
    const val INFO_FILE_NAME = "info.json"

    /**
     * Serializes container find-or-create + duplicate merges. Without this,
     * the parallel video + chat jobs (and concurrent segment writers) each
     * miss the other's just-created folder and the provider auto-renames the
     * loser to "Name (1)" — the double-folder mess.
     */
    private val containerMutex = Mutex()

    /** Locked find-or-create of the per-VOD container under a SAF tree. */
    suspend fun containerDoc(context: Context, treeUri: Uri, video: OfflineVideo): DocumentFile {
        return containerMutex.withLock {
            mergeDuplicateContainersSAF(context, treeUri, containerNameFor(video))
        }
    }

    /** Locked find-or-create of the per-VOD container under an app-private root. */
    suspend fun containerFile(rootPath: String, video: OfflineVideo): File {
        return containerMutex.withLock {
            mergeDuplicateContainersFile(File(rootPath), containerNameFor(video))
        }
    }

    private val DUPLICATE_SUFFIX = Regex(" \\(\\d+\\)$")

    /** Strips provider auto-rename suffixes ("Name (1)") for duplicate detection. */
    fun normalizeContainerName(name: String): String {
        return name.replace(DUPLICATE_SUFFIX, "").trim().ifBlank { name }
    }

    /** True when [name] is [canonical] or a provider-renamed duplicate of it. */
    fun isSameContainer(name: String, canonical: String): Boolean {
        if (name == canonical) return true
        return normalizeContainerName(name) == canonical
    }

    /**
     * Merges provider-renamed duplicates ("Name (1)", "Name (2)") into the
     * canonical [File] container under [root]. Files with colliding names are
     * kept (first wins). Emptied duplicates are deleted. Returns canonical dir.
     */
    private fun mergeDuplicateContainersFile(root: File, canonicalName: String): File {
        val canonical = File(root, canonicalName)
        if (!canonical.exists()) canonical.mkdirs()
        val siblings = root.listFiles()?.filter {
            it.isDirectory && it.name != canonicalName && isSameContainer(it.name, canonicalName)
        }.orEmpty()
        siblings.forEach { dupe ->
            dupe.listFiles()?.forEach { file ->
                if (file.isFile) {
                    val target = File(canonical, file.name)
                    if (!target.exists()) {
                        runCatching { file.renameTo(target) }
                    }
                }
            }
            runCatching {
                if (dupe.listFiles()?.isEmpty() == true) dupe.delete()
            }
        }
        return canonical
    }

    /**
     * SAF mirror of [mergeDuplicateContainersFile]: merges "Name (N)" dirs into
     * the canonical container under [treeUri]. Returns the canonical DocumentFile.
     */
    private fun mergeDuplicateContainersSAF(context: Context, treeUri: Uri, canonicalName: String): DocumentFile {
        val rootDoc = DocumentFile.fromTreeUri(context, treeUri)
            ?: throw java.io.IOException("Cannot access shared storage root: $treeUri")
        val canonical = SafStorageUtils.getOrCreateDirectory(context, treeUri, canonicalName)
        val resolver = context.contentResolver
        runCatching {
            rootDoc.listFiles()
                .filter { it.isDirectory && it.name != canonicalName && it.name?.let { n -> isSameContainer(n, canonicalName) } == true }
                .forEach { dupe ->
                    dupe.listFiles().forEach { file ->
                        if (file.isFile) {
                            val targetName = file.name ?: return@forEach
                            if (canonical.findFile(targetName) == null) {
                                var destination: DocumentFile? = null
                                runCatching {
                                    val dest = canonical.createFile(file.type ?: "*/*", targetName)
                                        ?: throw IOException("Cannot create recovered download")
                                    destination = dest
                                    (resolver.openInputStream(file.uri)
                                        ?: throw IOException("Cannot read duplicate download")).use { input ->
                                        (resolver.openOutputStream(dest.uri, "wt")
                                            ?: throw IOException("Cannot write recovered download")).use { output ->
                                            input.copyTo(output)
                                        }
                                    }
                                    file.delete()
                                }.onFailure {
                                    // Only this attempt's new target is disposable; retain the source for retry.
                                    destination?.let { runCatching { it.delete() } }
                                }
                            }
                        }
                    }
                    runCatching {
                        if (dupe.listFiles().isEmpty()) dupe.delete()
                    }
                }
        }
        return canonical
    }

    /** True when the downloadable file still exists (externally deleted files return false). */
    fun exists(context: Context, urlStr: String?): Boolean {
        if (urlStr.isNullOrBlank()) return false
        return if (isContentUri(urlStr)) {
            runCatching {
                val uri = urlStr.toUri()
                // DocumentFile.exists() can lie for provider rows whose backing
                // file was deleted via raw path (stale msd: entries), so prove
                // readability instead. Playlists require the first media asset
                // and any declared initialization asset to be openable.
                if (urlStr.endsWith(".m3u8")) {
                    existsPlaylistSAF(context, uri)
                } else {
                    context.contentResolver.openInputStream(uri)?.use { it.read() != -1 } == true
                }
            }.getOrDefault(false)
        } else {
            runCatching {
                val file = File(urlStr)
                if (!file.exists()) return@runCatching false
                if (urlStr.endsWith(".m3u8")) existsPlaylistFile(file) else true
            }.getOrDefault(false)
        }
    }

    internal fun isPlaylist(context: Context, url: String): Boolean {
        if (url.endsWith(".m3u8", ignoreCase = true)) return true
        if (!isContentUri(url)) return false
        val uri = url.toUri()
        val type = runCatching { context.contentResolver.getType(uri)?.lowercase() }.getOrNull()
        if (type == "application/x-mpegurl" || type == "application/vnd.apple.mpegurl" ||
            type == "audio/mpegurl" || type == "audio/x-mpegurl") return true
        return runCatching {
            context.contentResolver.query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)
                ?.use { it.moveToFirst() && it.getString(0)?.endsWith(".m3u8", ignoreCase = true) == true } == true
        }.getOrDefault(false)
    }

    fun isOutputIntact(context: Context, urlStr: String?): Boolean {
        if (urlStr.isNullOrBlank()) return false
        if (!isPlaylist(context, urlStr)) return isAssetReadable(context, urlStr)
        return if (isContentUri(urlStr)) {
            runCatching { existsPlaylistSAF(context, urlStr.toUri(), complete = true) }.getOrDefault(false)
        } else existsPlaylistFile(File(urlStr), complete = true)
    }

    internal fun isAssetReadable(
        context: Context,
        url: String,
        minimumBytes: Long = 1L,
        knownSizes: Map<String, Long> = emptyMap(),
    ): Boolean {
        if (!isContentUri(url)) return File(url).let { it.isFile && it.length() >= minimumBytes }
        val uri = url.toUri()
        if (knownSizes.isNotEmpty()) {
            val listedSize = runCatching { DocumentsContract.getDocumentId(uri) }.getOrNull()?.let(knownSizes::get)
            if (listedSize != null) return listedSize >= minimumBytes
        }
        return runCatching {
            context.contentResolver.openAssetFileDescriptor(uri, "r")?.use { afd ->
                val length = afd.length
                if (length >= 0L) return@use length >= minimumBytes
                afd.createInputStream().use { hasAtLeastBytes(it, minimumBytes) }
            } == true
        }.getOrDefault(false)
    }

    private fun hasAtLeastBytes(input: InputStream, minimumBytes: Long): Boolean {
        var remaining = minimumBytes
        val buffer = ByteArray(8 * 1024)
        while (remaining > 0L) {
            val skipped = if (remaining > buffer.size) input.skip(remaining - 1L) else 0L
            if (skipped > 0L) {
                remaining -= skipped
            } else {
                val read = input.read(buffer, 0, minOf(remaining, buffer.size.toLong()).toInt())
                if (read == -1) return false
                remaining -= read
            }
        }
        return true
    }

    private val STALE_METADATA_AUTHORITIES = setOf(
        "com.android.providers.downloads.documents",
        "com.android.providers.media.documents",
    )

    private fun isMediaStoreDocId(docId: String): Boolean =
        docId.startsWith("msd:", ignoreCase = true) || docId.startsWith("msf:", ignoreCase = true)

    internal fun childDocumentSizes(
        context: Context,
        anchorUri: Uri,
        parentDocId: String? = null,
    ): Map<String, Long> = runCatching {
        if (anchorUri.authority in STALE_METADATA_AUTHORITIES) return@runCatching emptyMap()
        val docId = parentDocId ?: DocumentsContract.getDocumentId(anchorUri)
        if (isMediaStoreDocId(docId)) return@runCatching emptyMap()
        val childrenUri = if (DocumentsContract.isTreeUri(anchorUri)) {
            DocumentsContract.buildChildDocumentsUriUsingTree(anchorUri, docId)
        } else {
            DocumentsContract.buildChildDocumentsUri(requireNotNull(anchorUri.authority), docId)
        }
        buildMap {
            context.contentResolver.query(
                childrenUri,
                arrayOf(DocumentsContract.Document.COLUMN_DOCUMENT_ID, DocumentsContract.Document.COLUMN_SIZE),
                null, null, null,
            )?.use { cursor ->
                val idIdx = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DOCUMENT_ID)
                val sizeIdx = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_SIZE)
                if (idIdx < 0 || sizeIdx < 0) return@use
                while (cursor.moveToNext()) {
                    val childId = cursor.getString(idIdx) ?: continue
                    if (isMediaStoreDocId(childId)) continue
                    if (!cursor.isNull(sizeIdx)) {
                        val size = cursor.getLong(sizeIdx)
                        if (size >= 0L) put(childId, size)
                    }
                }
            }
        }
    }.getOrDefault(emptyMap())

    private fun existsPlaylistFile(playlistFile: File, complete: Boolean = false): Boolean {
        return runCatching {
            val playlist = playlistFile.inputStream().use(PlaylistUtils::parseMediaPlaylist)
            val dir = playlistFile.parentFile ?: return@runCatching false
            playlistAssetsExist(playlist, complete) { uri, minimumBytes ->
                PlaylistUtils.localAssetFile(dir, PlaylistUtils.localAssetName(uri))
                    ?.let { it.isFile && it.length() >= minimumBytes } == true
            }
        }.getOrDefault(false)
    }

    private fun existsPlaylistSAF(context: Context, playlistUri: Uri, complete: Boolean = false): Boolean {
        val playlist = context.contentResolver.openInputStream(playlistUri)
            ?.use(PlaylistUtils::parseMediaPlaylist) ?: return false
        val parent = runCatching { DocumentsContract.getDocumentId(playlistUri).substringBeforeLast('/', "") }
            .getOrDefault("")
        val childSizes = if (complete && parent.isNotEmpty()) {
            childDocumentSizes(context, playlistUri, parent)
        } else emptyMap()
        val firstSegment = playlist.segments.firstOrNull()?.uri
        return playlistAssetsExist(playlist, complete) { uri, minimumBytes ->
            runCatching {
                val asset = uri.toUri()
                val target = if (asset.scheme == null) {
                    check(parent.isNotEmpty())
                    val assetId = "$parent/${PlaylistUtils.localAssetName(uri)}"
                    if (DocumentsContract.isTreeUri(playlistUri)) {
                        DocumentsContract.buildDocumentUriUsingTree(playlistUri, assetId)
                    } else {
                        DocumentsContract.buildDocumentUri(requireNotNull(playlistUri.authority), assetId)
                    }
                } else asset
                val sizes = if (uri == playlist.initSegmentUri || uri == firstSegment) emptyMap() else childSizes
                isAssetReadable(context, target.toString(), minimumBytes, sizes)
            }.getOrDefault(false)
        }
    }

    private inline fun playlistAssetsExist(
        playlist: MediaPlaylist, complete: Boolean, exists: (String, Long) -> Boolean,
    ): Boolean {
        val first = playlist.segments.firstOrNull()?.uri ?: return false
        val sizes = if (complete) PlaylistUtils.requiredAssetSizes(playlist.segments) else emptyMap()
        if (playlist.initSegmentUri?.let { !exists(it, sizes[it] ?: 1L) } == true) return false
        if (!complete) return exists(first, 1L)
        val checked = hashSetOf(playlist.initSegmentUri)
        return playlist.segments.all { !checked.add(it.uri) || exists(it.uri, sizes[it.uri] ?: 1L) }
    }

    /** Deletes [dir] only when it is an empty per-VOD container, never a storage root. */
    fun deleteIfEmptyContainer(dir: File, rootPath: String?) {
        if (!dir.exists() || !dir.isDirectory) return
        if (rootPath != null) {
            val root = runCatching { File(rootPath).canonicalPath }.getOrNull()
            val self = runCatching { dir.canonicalPath }.getOrNull()
            if (root != null && self == root) return
            if (dir.name == ".downloads") return
        }
        runCatching {
            if (dir.listFiles()?.isEmpty() == true) dir.delete()
        }
    }

    fun sanitizeSegment(raw: String?, fallback: String): String {
        var s = raw?.trim().orEmpty()
        if (s.isBlank()) return fallback
        s = s.replace(Regex("[\\\\/:*?\"<>|\\x00-\\x1F]"), "_")
        s = s.replace(Regex("\\s+"), " ").trim()
        s = s.trimEnd('.', ' ')
        if (s.isBlank()) return fallback
        if (s.length > MAX_SEGMENT_LEN) s = s.take(MAX_SEGMENT_LEN).trimEnd('.', ' ', '_')
        if (s.isBlank()) return fallback
        return s
    }

    fun containerNameFor(video: OfflineVideo): String {
        val idPart = video.clipId?.takeIf { it.isNotBlank() }
            ?: video.videoId?.takeIf { it.isNotBlank() }
            ?: video.channelLogin?.takeIf { it.isNotBlank() }
            ?: "video"
        val datePart = video.downloadDate?.toString() ?: "nodate"
        val titlePart = video.name?.takeIf { it.isNotBlank() }?.let { sanitizeSegment(it, "") }
            ?.takeIf { it.isNotBlank() }
        val raw = if (titlePart != null) {
            "${titlePart}_${idPart}_${datePart}"
        } else {
            "${sanitizeSegment(video.channelLogin ?: idPart, "video")}_${idPart}_${datePart}"
        }
        return sanitizeSegment(raw, "${idPart}_${datePart}")
    }

    fun singleFileNameFor(video: OfflineVideo, extension: String): String {
        val ext = extension.substringAfterLast(".").substringBefore("?").takeIf { it.isNotBlank() } ?: "mp4"
        val idPart = video.clipId?.takeIf { it.isNotBlank() }
            ?: video.videoId?.takeIf { it.isNotBlank() }
            ?: video.channelLogin?.takeIf { it.isNotBlank() }
            ?: "video"
        val quality = video.quality ?: ""
        val title = video.name?.takeIf { it.isNotBlank() }?.let { sanitizeSegment(it, "") }
        val base = if (!title.isNullOrBlank()) "${title}_${idPart}${quality}" else "$idPart$quality${video.downloadDate ?: ""}"
        return "${sanitizeSegment(base, "${idPart}${quality}")}.$ext"
    }

    fun isContentUri(s: String?): Boolean {
        if (s.isNullOrBlank()) return false
        return runCatching { s.toUri().scheme == "content" }.getOrDefault(false)
    }

    fun containerOfUrl(urlStr: String?, downloadPathStr: String?): String? {
        if (urlStr.isNullOrBlank()) return downloadPathStr
        return if (isContentUri(urlStr)) {
            val parent = urlStr.substringBeforeLast("%2F", "")
            if (parent.isNotBlank() && parent != urlStr) parent else downloadPathStr
        } else {
            runCatching { File(urlStr).parent ?: downloadPathStr }.getOrNull() ?: downloadPathStr
        }
    }

    fun ensureContainerFile(rootPath: String, video: OfflineVideo): File {
        val dir = File(rootPath, containerNameFor(video))
        if (!dir.exists()) dir.mkdirs()
        return dir
    }

    fun ensureContainerDoc(context: Context, treeUri: Uri, video: OfflineVideo): DocumentFile {
        return SafStorageUtils.getOrCreateDirectory(context, treeUri, containerNameFor(video))
    }

    fun buildInfoJson(video: OfflineVideo, appVersion: String): String {
        val o = JSONObject()
        o.put("schema", 1)
        o.put("appVersion", appVersion)
        o.put("sourceUrl", video.sourceUrl)
        o.put("sourceStartPosition", video.sourceStartPosition)
        o.put("name", video.name)
        o.put("channelId", video.channelId)
        o.put("channelLogin", video.channelLogin)
        o.put("channelName", video.channelName)
        o.put("channelLogo", video.channelLogo)
        o.put("gameId", video.gameId)
        o.put("gameSlug", video.gameSlug)
        o.put("gameName", video.gameName)
        o.put("duration", video.duration)
        o.put("uploadDate", video.uploadDate)
        o.put("downloadDate", video.downloadDate)
        o.put("fromTime", video.fromTime)
        o.put("toTime", video.toTime)
        o.put("type", video.type)
        o.put("videoId", video.videoId)
        o.put("clipId", video.clipId)
        o.put("quality", video.quality)
        o.put("downloadChat", video.downloadChat)
        o.put("chatUrl", video.chatUrl)
        o.put("playlistToFile", video.playlistToFile)
        o.put("live", video.live)
        return o.toString(2)
    }

    fun writeInfoJsonToDir(dir: File, json: String) {
        runCatching {
            if (!dir.exists()) dir.mkdirs()
            File(dir, INFO_FILE_NAME).writeText(json)
        }
    }

    /**
     * Finds a direct child of [dirUri] by display name without creating it.
     * Needed because a subfolder document URI is not a tree URI, so
     * DocumentFile lookups cannot list it — but child enumeration via the
     * owning [treeUri] works for any dir in that tree.
     */
    fun findFileInDir(context: Context, treeUri: Uri, dirUri: Uri, displayName: String): Uri? = runCatching {
        val childrenUri = DocumentsContract.buildChildDocumentsUriUsingTree(
            treeUri, DocumentsContract.getDocumentId(dirUri)
        )
        context.contentResolver.query(
            childrenUri,
            arrayOf(
                DocumentsContract.Document.COLUMN_DOCUMENT_ID,
                DocumentsContract.Document.COLUMN_DISPLAY_NAME
            ),
            null, null, null
        )?.use { cursor ->
            val idIdx = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DOCUMENT_ID)
            val nameIdx = cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DISPLAY_NAME)
            while (cursor.moveToNext()) {
                if (cursor.getString(nameIdx) == displayName) {
                    return@runCatching DocumentsContract.buildDocumentUriUsingTree(
                        treeUri, cursor.getString(idIdx)
                    )
                }
            }
            null
        }
    }.getOrNull()

    fun scanFileIfPublic(context: Context, absolutePath: String?) {
        if (absolutePath.isNullOrBlank()) return
        val file = runCatching { File(absolutePath) }.getOrNull() ?: return
        if (!file.exists() || file.isDirectory) return
        val publicRoot = runCatching { Environment.getExternalStorageDirectory().absolutePath }.getOrNull() ?: return
        if (!absolutePath.startsWith(publicRoot)) return
        if (absolutePath.contains("/Android/data/") || absolutePath.contains("/.downloads/")) return
        runCatching {
            MediaScannerConnection.scanFile(context, arrayOf(absolutePath), arrayOf("video/mp4"), null)
        }
    }
}
