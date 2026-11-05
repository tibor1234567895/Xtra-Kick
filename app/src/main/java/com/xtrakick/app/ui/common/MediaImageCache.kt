package com.xtrakick.app.ui.common

import java.io.File
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.StandardCopyOption.ATOMIC_MOVE
import java.nio.file.StandardCopyOption.REPLACE_EXISTING
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

private val imageWriteLocks = Array(32) { Mutex() }

internal fun CoroutineScope.cacheMediaImage(
    filesDir: String,
    directory: String,
    id: String?,
    url: String?,
    download: suspend (String, OutputStream) -> Unit,
): String? {
    if (id.isNullOrBlank() || url.isNullOrBlank()) return null
    val target = runCatching {
        val root = File(filesDir).canonicalFile
        val parent = File(root, directory).canonicalFile
        require(parent.parentFile == root)
        File(parent, id).canonicalFile.also { require(it.parentFile == parent) }
    }.getOrNull() ?: return null

    launch(Dispatchers.IO) {
        imageWriteLocks[(target.path.hashCode() and Int.MAX_VALUE) % imageWriteLocks.size].withLock {
            var temporary: File? = null
            try {
                check(target.parentFile?.let { it.isDirectory || it.mkdirs() } == true)
                val staged = File.createTempFile(".media-image-", ".tmp", target.parentFile)
                temporary = staged
                staged.outputStream().use { stream ->
                    download(url, stream)
                    stream.fd.sync()
                }
                ensureActive()
                Files.move(staged.toPath(), target.toPath(), ATOMIC_MOVE, REPLACE_EXISTING)
            } catch (_: Exception) {
                ensureActive()
            } finally {
                temporary?.delete()
            }
        }
    }
    return target.path
}
