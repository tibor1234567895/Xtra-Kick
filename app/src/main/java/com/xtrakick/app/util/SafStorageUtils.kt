package com.xtrakick.app.util

import android.content.Context
import android.net.Uri
import android.provider.DocumentsContract
import androidx.documentfile.provider.DocumentFile
import java.io.IOException

object SafStorageUtils {

    /**
     * Resolves a user-friendly display path for an SAF tree URI.
     * E.g. "Download/Xtra-kick-backup/VODs" or "VODs".
     * Prevents displaying raw document IDs like "msd:1000119659".
     */
    fun getDisplayPath(context: Context, uri: Uri): String {
        val docId = runCatching { DocumentsContract.getTreeDocumentId(uri) }.getOrNull()
        if (docId != null) {
            if (docId.startsWith("primary:", ignoreCase = true)) {
                val subPath = Uri.decode(docId.substringAfter("primary:"))
                if (subPath.isNotBlank()) return subPath
            }
            val rawPath = docId
                .substringAfterLast("raw:/storage/emulated/0/")
                .substringAfterLast("raw:")
            if (rawPath.contains("/") && !rawPath.startsWith("msd:", ignoreCase = true)) {
                return Uri.decode(rawPath)
            }
        }
        val docFileName = runCatching {
            DocumentFile.fromTreeUri(context, uri)?.name
        }.getOrNull()
        if (!docFileName.isNullOrBlank()) {
            return docFileName
        }
        val raw = uri.path?.substringAfter("/tree/")?.removeSuffix(":").orEmpty()
        val decoded = Uri.decode(raw)
            .substringAfterLast("primary:")
            .substringAfterLast("raw:/storage/emulated/0/")
            .substringAfterLast("raw:")
        return decoded.ifBlank { raw }
    }

    /**
     * Finds or creates a file directly inside a tree URI.
     * Returns the Document URI of the file.
     */
    fun getOrCreateFile(context: Context, treeUri: Uri, displayName: String, mimeType: String = "*/*"): Uri {
        val rootDoc = DocumentFile.fromTreeUri(context, treeUri)
            ?: throw IOException("Cannot access shared storage root: $treeUri")
        val existing = rootDoc.findFile(displayName)
        if (existing != null && existing.isFile) {
            return existing.uri
        }
        val created = rootDoc.createFile(mimeType, displayName)
            ?: throw IOException("Failed to create file $displayName in $treeUri")
        return created.uri
    }

    /**
     * Finds or creates a subdirectory inside a tree URI.
     * Returns the DocumentFile representing the subdirectory.
     */
    fun getOrCreateDirectory(context: Context, treeUri: Uri, dirName: String): DocumentFile {
        val rootDoc = DocumentFile.fromTreeUri(context, treeUri)
            ?: throw IOException("Cannot access shared storage root: $treeUri")
        val existing = rootDoc.findFile(dirName)
        if (existing != null && existing.isDirectory) {
            return existing
        }
        return rootDoc.createDirectory(dirName)
            ?: throw IOException("Failed to create directory $dirName in $treeUri")
    }

    /**
     * Finds or creates a file inside a DocumentFile directory.
     * Returns the Document URI of the file.
     */
    fun getOrCreateFileInDir(dirDoc: DocumentFile, displayName: String, mimeType: String = "*/*"): Uri {
        val existing = dirDoc.findFile(displayName)
        if (existing != null && existing.isFile) {
            return existing.uri
        }
        val created = dirDoc.createFile(mimeType, displayName)
            ?: throw IOException("Failed to create file $displayName in ${dirDoc.uri}")
        return created.uri
    }
}
