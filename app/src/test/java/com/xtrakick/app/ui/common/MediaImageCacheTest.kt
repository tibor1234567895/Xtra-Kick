package com.xtrakick.app.ui.common

import java.io.File
import java.io.IOException
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class MediaImageCacheTest {
    @get:Rule val temporary = TemporaryFolder()

    @Test
    fun returnsTheCachePathWhileDownloadContinuesInTheOwningScope() = runBlocking {
        val root = temporary.newFolder()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        val started = CompletableDeferred<Unit>()
        val release = CompletableDeferred<Unit>()
        try {
            val path = scope.cacheMediaImage(root.path, "thumbnails", "video", "https://example.invalid/image") { url, output ->
                assertEquals("https://example.invalid/image", url)
                started.complete(Unit)
                release.await()
                output.write("image".toByteArray())
            }
            assertEquals(File(root, "thumbnails/video").canonicalPath, path)
            withTimeout(2000) { started.await() }
            release.complete(Unit)
            withTimeout(2000) { scope.coroutineContext.job.children.toList().joinAll() }
            assertEquals("image", File(path!!).readText())
        } finally {
            scope.cancel()
        }
    }

    @Test
    fun failedWriteRestoresThePreviousCachedImage() = runBlocking {
        val root = temporary.newFolder()
        val target = File(root, "thumbnails/video").apply { parentFile!!.mkdirs(); writeText("old") }
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        try {
            scope.cacheMediaImage(root.path, "thumbnails", "video", "image") { _, output ->
                output.write("partial".toByteArray())
                throw IOException("connection failed")
            }
            withTimeout(2000) { scope.coroutineContext.job.children.toList().joinAll() }
            assertEquals("old", target.readText())
        } finally {
            scope.cancel()
        }
    }

    @Test
    fun cancellingTheOwnerRollsBackThePartialImage() = runBlocking {
        val root = temporary.newFolder()
        val target = File(root, "profile_pics/channel").apply { parentFile!!.mkdirs(); writeText("old") }
        val started = CompletableDeferred<Unit>()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        scope.cacheMediaImage(root.path, "profile_pics", "channel", "image") { _, output ->
            output.write("partial".toByteArray())
            started.complete(Unit)
            awaitCancellation()
        }
        withTimeout(2000) {
            started.await()
            scope.coroutineContext.job.cancelAndJoin()
        }
        assertEquals("old", target.readText())
    }

    @Test
    fun rejectsEscapingPathsAndMissingImageInputsWithoutStartingDownloads() = runBlocking {
        val root = temporary.newFolder()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        var calls = 0
        try {
            for ((directory, id) in listOf("thumbnails" to "../escape", "../escape" to "video", "thumbnails" to "nested/video")) {
                assertNull(scope.cacheMediaImage(root.path, directory, id, "image") { _, _ -> calls++ })
            }
            assertNull(scope.cacheMediaImage(root.path, "thumbnails", null, "image") { _, _ -> calls++ })
            assertNull(scope.cacheMediaImage(root.path, "thumbnails", "video", " ") { _, _ -> calls++ })
            assertEquals(0, calls)
            assertEquals(emptyList<String>(), root.listFiles()!!.map { it.name })
        } finally {
            scope.cancel()
        }
    }

    @Test
    fun concurrentWritesToTheSameImageCannotInterleave() = runBlocking {
        val root = temporary.newFolder()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        val started = CompletableDeferred<Unit>()
        val release = CompletableDeferred<Unit>()
        val calls = AtomicInteger()
        try {
            scope.cacheMediaImage(root.path, "thumbnails", "video", "first") { _, output ->
                calls.incrementAndGet()
                started.complete(Unit)
                release.await()
                output.write("first".toByteArray())
            }
            withTimeout(2000) { started.await() }
            scope.cacheMediaImage(root.path, "thumbnails", "video", "second") { _, output ->
                calls.incrementAndGet()
                output.write("second".toByteArray())
            }
            delay(25)
            assertEquals(1, calls.get())
            release.complete(Unit)
            withTimeout(2000) { scope.coroutineContext.job.children.toList().joinAll() }
            assertEquals(2, calls.get())
            assertEquals("second", File(root, "thumbnails/video").readText())
        } finally {
            release.complete(Unit)
            scope.cancel()
        }
    }
}
