package com.xtrakick.app.ui.saved.bookmarks

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.io.File
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class BookmarkThumbnailTest {
    @get:Rule val folder = TemporaryFolder()

    @Test
    fun failedRefreshPreservesExistingArtAndSuccessAdvertisesACompleteNewFile() {
        val directory = folder.newFolder("thumbnails")
        val old = File(directory, "bookmark-42-old.image").apply { writeText("existing artwork") }
        val bitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888)
        val png = ByteArrayOutputStream().use { output ->
            assertTrue(bitmap.compress(Bitmap.CompressFormat.PNG, 100, output))
            output.toByteArray()
        }

        assertNull(writeBookmarkThumbnail(directory, 42, 404, png))
        assertNull(writeBookmarkThumbnail(directory, 42, 200, "not an image".toByteArray()))
        assertTrue(directory.listFiles().orEmpty().contentEquals(arrayOf(old)))

        val saved = checkNotNull(writeBookmarkThumbnail(directory, 42, 200, png))
        assertNotEquals(old.path, saved)
        assertArrayEquals(png, File(saved).readBytes())
        assertTrue(old.isFile)
    }
}
