package com.xtrakick.app.util

import android.content.Context
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import androidx.core.net.toUri
import androidx.documentfile.provider.DocumentFile
import com.xtrakick.app.model.ui.OfflineVideo
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.json.JSONObject
import java.io.File

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
                                runCatching {
                                    val dest = canonical.createFile(file.type ?: "*/*", targetName)
                                    if (dest != null) {
                                        resolver.openInputStream(file.uri)?.use { input ->
                                            resolver.openOutputStream(dest.uri, "wt")?.use { output ->
                                                input.copyTo(output)
                                            }
                                        }
                                        file.delete()
                                    }
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
                // readability instead. Playlists additionally require at least
                // the init/first segment to be openable.
                if (urlStr.endsWith(".m3u8")) {
                    existsPlaylistSAF(context, uri)
                } else {
                    context.contentResolver.openInputStream(uri)?.use { it.read() } != -1
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

    private fun existsPlaylistFile(playlistFile: File): Boolean {
        return runCatching {
            val playlist = playlistFile.inputStream().use {
                com.xtrakick.app.util.m3u8.PlaylistUtils.parseMediaPlaylist(it)
            }
            val dir = playlistFile.parentFile ?: return@runCatching false
            val first = playlist.initSegmentUri?.substringAfterLast("%2F")?.substringAfterLast("/")
                ?: playlist.segments.firstOrNull()?.uri?.substringAfterLast("%2F")?.substringAfterLast("/")
                ?: return@runCatching false
            File(dir, android.net.Uri.decode(first)).exists()
        }.getOrDefault(false)
    }

    private fun existsPlaylistSAF(context: Context, playlistUri: android.net.Uri): Boolean {
        val playlist = context.contentResolver.openInputStream(playlistUri)?.use {
            com.xtrakick.app.util.m3u8.PlaylistUtils.parseMediaPlaylist(it)
        } ?: return false
        val candidates = listOfNotNull(
            playlist.initSegmentUri,
            playlist.segments.firstOrNull()?.uri
        )
        if (candidates.isEmpty()) return false
        return candidates.any { segUri ->
            runCatching {
                context.contentResolver.openInputStream(segUri.toUri())?.use { it.read() } != -1
            }.getOrDefault(false)
        }
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
