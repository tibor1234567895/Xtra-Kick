package com.xtrakick.app.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StoragePermissionTest {

    private val treeUri = "content://com.android.externalstorage.documents/tree/primary%3ADownload"

    @Test
    fun returnsFalseWhenTargetUriIsNullOrEmpty() {
        assertFalse(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = true, targetUri = null))
        assertFalse(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = true, targetUri = ""))
        assertFalse(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = true, targetUri = "   "))
    }

    @Test
    fun matchesUriExactAndNormalizedTrailingSlash() {
        assertTrue(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = true, targetUri = treeUri))
        assertTrue(isPersistedUriGranted("$treeUri/", hasRead = true, hasWrite = true, targetUri = treeUri))
        assertTrue(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = true, targetUri = "$treeUri/"))
    }

    @Test
    fun validatesReadAndWriteFlagsCorrectly() {
        assertTrue(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = false, targetUri = treeUri, needRead = true, needWrite = false))
        assertFalse(isPersistedUriGranted(treeUri, hasRead = true, hasWrite = false, targetUri = treeUri, needRead = true, needWrite = true))

        assertFalse(isPersistedUriGranted(treeUri, hasRead = false, hasWrite = true, targetUri = treeUri, needRead = true, needWrite = false))
        assertTrue(isPersistedUriGranted(treeUri, hasRead = false, hasWrite = true, targetUri = treeUri, needRead = false, needWrite = true))
    }
}
