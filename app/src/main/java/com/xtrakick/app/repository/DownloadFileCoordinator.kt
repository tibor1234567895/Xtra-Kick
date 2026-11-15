package com.xtrakick.app.repository

import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Mutex

/** Excludes file writers until a deletion has cancelled and drained the active owner. */
internal class DownloadFileCoordinator {
    private class Entry {
        val mutex = Mutex()
        var references = 0
        var deleting = false
        var owner: Job? = null
    }

    private val entries = mutableMapOf<String, Entry>()

    suspend fun <T> use(key: String, deleting: Boolean, wait: Boolean, block: suspend () -> T): T? {
        val entry = synchronized(entries) {
            entries.getOrPut(key, ::Entry).also { it.references++ }
        }
        var locked = false
        try {
            if (deleting) {
                val owner = synchronized(entries) {
                    if (entry.deleting) return null
                    entry.deleting = true
                    entry.owner
                }
                owner?.cancel()
            }
            if (wait || deleting) {
                entry.mutex.lock()
                locked = true
            } else {
                locked = entry.mutex.tryLock()
                if (!locked) return null
            }
            currentCoroutineContext().ensureActive()
            val job = currentCoroutineContext()[Job]
            synchronized(entries) {
                if (entry.deleting && !deleting) return null
                entry.owner = job
            }
            return block()
        } finally {
            synchronized(entries) {
                if (locked) entry.owner = null
            }
            if (locked) entry.mutex.unlock()
            synchronized(entries) {
                entry.references--
                if (entry.references == 0) entries.remove(key)
            }
        }
    }
}
