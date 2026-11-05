package com.xtrakick.app.util

import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowContentResolver

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class SafStorageUtilsTest {
    @Test fun aDirectoryIsDeletedOnlyAfterItsProviderConfirmsItIsEmpty() {
        val context = RuntimeEnvironment.getApplication()
        val provider = DirectoryProvider().apply {
            attachInfo(context, ProviderInfo().apply { authority = "directory.test" })
        }
        ShadowContentResolver.registerProviderInternal("directory.test", provider)
        for (directory in listOf(
            Uri.parse("content://directory.test/document/root%2FVOD"),
            Uri.parse("content://directory.test/tree/root/document/root%2FVOD")
        )) {
            provider.children = 1
            val before = provider.deletes
            SafStorageUtils.deleteIfEmptyDirectory(context, directory)
            assertEquals(before, provider.deletes)
            provider.children = null
            SafStorageUtils.deleteIfEmptyDirectory(context, directory)
            assertEquals(before, provider.deletes)
            provider.children = 0
            SafStorageUtils.deleteIfEmptyDirectory(context, directory)
            assertEquals(before + 1, provider.deletes)
        }
    }

    class DirectoryProvider : ContentProvider() {
        var children: Int? = 0
        var deletes = 0
        override fun onCreate() = true
        override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? =
            children?.let { count -> MatrixCursor(arrayOf(DocumentsContract.Document.COLUMN_DOCUMENT_ID)).apply {
                repeat(count) { addRow(arrayOf("child-$it")) }
            } }
        override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
            check(method == "android:deleteDocument")
            deletes++
            return Bundle()
        }
        override fun getType(uri: Uri) = DocumentsContract.Document.MIME_TYPE_DIR
        override fun insert(uri: Uri, values: ContentValues?): Uri? = null
        override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0
        override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0
    }
}
