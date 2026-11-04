package com.xtrakick.app.ui.settings

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.xtrakick.app.di.DatabaseModule
import com.xtrakick.app.util.prefs
import java.io.File
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class SettingsBackupRestoreTest {
    private val context = RuntimeEnvironment.getApplication()
    private val database = DatabaseModule().buildDatabase(context, "database")

    @After fun cleanup() { database.close() }

    private fun stagedDatabase(marker: String): File {
        val file = File.createTempFile("restore-test", ".db", context.cacheDir)
        val staged = DatabaseModule().buildDatabase(context, file.path)
        try {
            staged.openHelper.writableDatabase.execSQL("CREATE TABLE marker (value TEXT)")
            staged.openHelper.writableDatabase.execSQL("INSERT INTO marker VALUES (?)", arrayOf(marker))
        } finally { staged.close() }
        return file
    }

    @Test fun malformedDatabaseCannotChangePreferencesOrCloseTheLiveDatabase() {
        context.prefs().edit().putString("sentinel", "old").commit()
        val bad = File.createTempFile("bad-restore", ".db", context.cacheDir).apply { writeBytes(ByteArray(8192) { 65 }) }
        var closed = false
        assertThrows(Exception::class.java) {
            SettingsBackupRestore.apply(context, database, context.prefs(), mapOf("sentinel" to "new"), bad) { closed = true }
        }
        assertFalse(closed)
        assertEquals("old", context.prefs().getString("sentinel", null))
        assertTrue(database.isOpen)
    }

    @Test fun validSqliteWithoutTheRoomSchemaIsRejected() {
        val file = File.createTempFile("wrong-schema", ".db", context.cacheDir)
        SQLiteDatabase.openOrCreateDatabase(file, null).use {
            it.execSQL("CREATE TABLE wrong_table (id INTEGER)")
            it.version = 36
        }
        assertThrows(Exception::class.java) { SettingsBackupRestore.validateDatabase(context, file, 36) }
    }

    @Test fun newerBackupIsRejectedBeforeReplacement() {
        val file = stagedDatabase("future")
        SQLiteDatabase.openDatabase(file.path, null, SQLiteDatabase.OPEN_READWRITE).use { it.version = 37 }
        assertThrows(IllegalArgumentException::class.java) { SettingsBackupRestore.validateDatabase(context, file, 36) }
    }

    @Test fun stagedBackupUsesTheLiveMigrationsAndKeepsItsData() {
        val file = stagedDatabase("kept")
        SQLiteDatabase.openDatabase(file.path, null, SQLiteDatabase.OPEN_READWRITE).use {
            it.execSQL("DROP TABLE muted_chat_users")
            it.execSQL("DELETE FROM room_master_table")
            it.version = 35
        }
        SettingsBackupRestore.validateDatabase(context, file, 36)
        SQLiteDatabase.openDatabase(file.path, null, SQLiteDatabase.OPEN_READONLY).use {
            assertEquals(36, it.version)
            it.rawQuery("SELECT value FROM marker", null).use { row ->
                assertTrue(row.moveToFirst())
                assertEquals("kept", row.getString(0))
            }
        }
    }

    @Test fun failedPreferenceApplicationRollsBackTheDatabaseAndPreferences() {
        database.openHelper.writableDatabase.execSQL("CREATE TABLE marker (value TEXT)")
        database.openHelper.writableDatabase.execSQL("INSERT INTO marker VALUES ('old')")
        context.prefs().edit().putString("sentinel", "old").commit()
        val staged = stagedDatabase("new")
        var closed = false
        assertThrows(IllegalStateException::class.java) {
            SettingsBackupRestore.apply(context, database, context.prefs(), mapOf("bad" to Any()), staged) { closed = true }
        }
        assertTrue(closed)
        assertEquals("old", context.prefs().getString("sentinel", null))
        SQLiteDatabase.openDatabase(context.getDatabasePath("database").path, null, SQLiteDatabase.OPEN_READONLY).use {
            it.rawQuery("SELECT value FROM marker", null).use { row ->
                assertTrue(row.moveToFirst())
                assertEquals("old", row.getString(0))
            }
        }
    }

    @Test fun preferenceXmlIsFullyParsedBeforeApplication() {
        val values = SettingsBackupRestore.readPreferences("""
            <map><string name="text">hello</string><boolean name="flag" value="true"/><int name="count" value="3"/>
            <long name="time" value="4"/><float name="speed" value="1.5"/><set name="tags"><string>a</string><string>b</string></set></map>
        """.trimIndent().byteInputStream())
        assertEquals(setOf("a", "b"), values["tags"])
        assertEquals(true, values["flag"])
        assertEquals(3, values["count"])
        assertEquals(4L, values["time"])
        SettingsBackupRestore.replacePreferences(context.prefs(), values)
        assertEquals("hello", context.prefs().getString("text", null))
        for (xml in listOf("<maple/>", "<map><boolean name='flag' value='nonsense'/></map>", "<map><string name='x'>unfinished")) {
            assertThrows(Exception::class.java) { SettingsBackupRestore.readPreferences(xml.byteInputStream()) }
            assertEquals("hello", context.prefs().getString("text", null))
        }
    }

    @Test fun failedAtomicCopyPreservesTheOriginalFile() {
        val target = File(context.cacheDir, "atomic-original").apply { writeText("original") }
        assertThrows(Exception::class.java) { SettingsBackupRestore.replaceDatabase(target, File(context.cacheDir, "does-not-exist")) }
        assertEquals("original", target.readText())
    }
}
