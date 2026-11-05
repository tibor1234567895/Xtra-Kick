package com.xtrakick.app.util

import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.os.Bundle
import android.provider.DocumentsContract
import com.xtrakick.app.model.ui.OfflineVideo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowContentResolver
import java.io.File

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class DownloadStorageAvailabilityTest {
    private val context = RuntimeEnvironment.getApplication()

    @Test fun duplicateContainerMergeRetainsTheSourceWhenTheDestinationCannotBeOpened() = runBlocking {
        val video = OfflineVideo(name = "Video", videoId = "1")
        val provider = DuplicateProvider(DownloadStorage.containerNameFor(video)).apply { failDestination = true }
        register(provider)
        DownloadStorage.containerDoc(context, provider.treeUri, video)
        assertTrue("The duplicate is the only surviving copy", provider.hasSource())
        provider.failDestination = false
        DownloadStorage.containerDoc(context, provider.treeUri, video)
        assertFalse(provider.hasSource())
        assertEquals("media data", provider.destination.readText())
    }

    @Test fun aNullSharedStorageStreamDoesNotCountAsAnAvailableDownload() {
        register(AssetProvider())
        assertFalse(DownloadStorage.exists(context, "content://availability.test/video.mp4"))
    }

    @Test fun sharedPlaylistsRequireBothInitializationAndFirstMediaAssets() {
        val root = File(context.cacheDir, "shared-availability").apply { mkdirs() }
        val playlist = File(root, "video.m3u8").apply {
            writeText("#EXTM3U\n#EXT-X-MAP:URI=\"content://availability.test/init.mp4\"\n#EXTINF:1,\ncontent://availability.test/asset.ts\n")
        }
        val init = File(root, "init.mp4").apply { writeText("init") }
        val asset = File(root, "asset.ts").apply { writeText("media") }
        val provider = AssetProvider().apply {
            files["content://availability.test/video.m3u8"] = playlist
            files["content://availability.test/init.mp4"] = init
        }
        register(provider)
        assertFalse(DownloadStorage.exists(context, "content://availability.test/video.m3u8"))
        provider.files["content://availability.test/asset.ts"] = asset
        assertTrue(DownloadStorage.exists(context, "content://availability.test/video.m3u8"))
        provider.files.remove("content://availability.test/init.mp4")
        assertFalse(DownloadStorage.exists(context, "content://availability.test/video.m3u8"))
    }

    @Test fun localPlaylistsRequireMediaEvenWhenTheInitializationFileExists() {
        val root = File(context.cacheDir, "local-availability").apply { mkdirs() }
        val playlist = File(root, "video.m3u8").apply {
            writeText("#EXTM3U\n#EXT-X-MAP:URI=\"init.mp4\"\n#EXTINF:1,\nasset.ts\n")
        }
        val init = File(root, "init.mp4").apply { writeText("init") }
        assertFalse(DownloadStorage.exists(context, playlist.path))
        File(root, "asset.ts").writeText("media")
        assertTrue(DownloadStorage.exists(context, playlist.path))
        init.delete()
        assertFalse(DownloadStorage.exists(context, playlist.path))
    }

    private fun register(provider: AssetProvider) {
        provider.attachInfo(context, ProviderInfo().apply { authority = "availability.test" })
        ShadowContentResolver.registerProviderInternal("availability.test", provider)
    }

    open class AssetProvider : ContentProvider() {
        val files = mutableMapOf<String, File>()
        override fun onCreate() = true
        override fun openFile(uri: Uri, mode: String): ParcelFileDescriptor? =
            files[uri.toString()]?.let { ParcelFileDescriptor.open(it, ParcelFileDescriptor.parseMode(mode)) }
        override fun getType(uri: Uri) = "application/octet-stream"
        override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? = null
        override fun insert(uri: Uri, values: ContentValues?): Uri? = null
        override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0
        override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0
    }

    class DuplicateProvider(private val canonical: String) : AssetProvider() {
        val treeUri: Uri = Uri.parse("content://availability.test/tree/root")
        val destination = File(RuntimeEnvironment.getApplication().cacheDir, "merged-asset.mp4")
        var failDestination = false
        private data class Entry(val parent: String?, val name: String, val mime: String)
        private val directoryType = DocumentsContract.Document.MIME_TYPE_DIR
        private val entries = linkedMapOf(
            "root" to Entry(null, "root", directoryType),
            "root/$canonical" to Entry("root", canonical, directoryType),
            "root/$canonical (1)" to Entry("root", "$canonical (1)", directoryType),
            "root/$canonical (1)/asset.mp4" to Entry("root/$canonical (1)", "asset.mp4", "video/mp4")
        )
        private val sourceId = "root/$canonical (1)/asset.mp4"

        init {
            val source = File(RuntimeEnvironment.getApplication().cacheDir, "duplicate-asset.mp4").apply { writeText("media data") }
            files[documentUri(sourceId).toString()] = source
        }

        fun hasSource() = sourceId in entries
        private fun documentUri(id: String): Uri = DocumentsContract.buildDocumentUriUsingTree(treeUri, id)

        override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor {
            val id = DocumentsContract.getDocumentId(uri)
            val selected = if (uri.lastPathSegment == "children") entries.filterValues { it.parent == id } else entries.filterKeys { it == id }
            val columns = projection ?: arrayOf(DocumentsContract.Document.COLUMN_DOCUMENT_ID, DocumentsContract.Document.COLUMN_DISPLAY_NAME,
                DocumentsContract.Document.COLUMN_MIME_TYPE, DocumentsContract.Document.COLUMN_FLAGS, DocumentsContract.Document.COLUMN_SIZE)
            return MatrixCursor(columns).apply {
                selected.forEach { (key, entry) -> addRow(columns.map { column -> when (column) {
                    DocumentsContract.Document.COLUMN_DOCUMENT_ID -> key
                    DocumentsContract.Document.COLUMN_DISPLAY_NAME -> entry.name
                    DocumentsContract.Document.COLUMN_MIME_TYPE -> entry.mime
                    DocumentsContract.Document.COLUMN_FLAGS -> 0
                    DocumentsContract.Document.COLUMN_SIZE -> 10L
                    else -> null
                } }) }
            }
        }

        @Suppress("DEPRECATION")
        override fun call(method: String, arg: String?, extras: Bundle?): Bundle {
            val uri = requireNotNull(extras?.getParcelable<Uri>("uri"))
            val id = DocumentsContract.getDocumentId(uri)
            return Bundle().apply {
                when (method) {
                    "android:createDocument" -> {
                        val name = requireNotNull(extras.getString(DocumentsContract.Document.COLUMN_DISPLAY_NAME))
                        val createdId = "$id/$name"
                        entries[createdId] = Entry(id, name, "video/mp4")
                        val created = documentUri(createdId)
                        if (!failDestination) files[created.toString()] = destination
                        putParcelable("uri", created)
                    }
                    "android:deleteDocument" -> { entries.remove(id); files.remove(uri.toString()) }
                    else -> error("Unexpected document operation: $method")
                }
            }
        }
    }
}
