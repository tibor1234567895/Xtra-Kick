package com.xtrakick.app.ui.saved

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.ProviderInfo
import android.content.res.AssetFileDescriptor
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.provider.DocumentsContract
import android.provider.DocumentsContract.Document
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.repository.OfflineRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowContentResolver
import java.io.File

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class SavedPagerViewModelTest {
    @Test
    fun missingInputStreamSkipsTheFileAndImportsTheNextPlaylist() = verifyImport("r")

    @Test
    fun missingOutputStreamSkipsTheFileAndImportsTheNextPlaylist() = verifyImport("w")

    private fun verifyImport(missingMode: String) = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val playlist = File.createTempFile("playlist", ".m3u8", context.cacheDir).apply {
            writeText("#EXTM3U\n#EXTINF:1,\nsegment.ts\n#EXT-X-ENDLIST\n")
        }
        val provider = PlaylistProvider(playlist, missingMode).apply {
            attachInfo(context, ProviderInfo().apply { authority = "saved.null.test" })
        }
        ShadowContentResolver.registerProviderInternal("saved.null.test", provider)
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        try {
            val repository = OfflineRepository(database.videos(), database.localFollowsChannel(), database.bookmarks())
            val model = SavedPagerViewModel(context, repository)

            model.saveFolders("content://saved.null.test/tree/primary%3AVideos")
            model.viewModelScope.coroutineContext[Job]!!.children.toList().joinAll()

            val imported = repository.getAllVideos()
            assertEquals(1, provider.missingOpens)
            assertEquals(1, imported.size)
            assertTrue(imported.single().url?.endsWith("valid.m3u8") == true)
        } finally {
            database.close()
            playlist.delete()
        }
    }

    private class PlaylistProvider(private val playlist: File, private val missingMode: String) : ContentProvider() {
        var missingOpens = 0

        override fun onCreate() = true

        override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor =
            MatrixCursor(arrayOf(Document.COLUMN_DOCUMENT_ID, Document.COLUMN_MIME_TYPE)).apply {
                if (DocumentsContract.getDocumentId(uri) == "primary:Videos") {
                    addRow(arrayOf("primary:Videos/download", Document.MIME_TYPE_DIR))
                } else {
                    addRow(arrayOf("primary:Videos/download/missing.m3u8", "application/vnd.apple.mpegurl"))
                    addRow(arrayOf("primary:Videos/download/valid.m3u8", "application/vnd.apple.mpegurl"))
                }
            }

        override fun openAssetFile(uri: Uri, mode: String): AssetFileDescriptor? {
            if (uri.toString().endsWith("missing.m3u8") && mode == missingMode) {
                missingOpens++
                return null
            }
            return AssetFileDescriptor(
                ParcelFileDescriptor.open(playlist, ParcelFileDescriptor.parseMode(mode)),
                0, AssetFileDescriptor.UNKNOWN_LENGTH,
            )
        }

        override fun getType(uri: Uri) = "application/vnd.apple.mpegurl"
        override fun insert(uri: Uri, values: ContentValues?): Uri? = null
        override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0
        override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0
    }
}
