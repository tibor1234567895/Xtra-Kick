package com.xtrakick.app.ui.settings

import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.util.AtomicFile
import android.util.Xml
import com.xtrakick.app.db.AppDatabase
import com.xtrakick.app.di.DatabaseModule
import java.io.File
import java.io.InputStream
import org.xmlpull.v1.XmlPullParser

internal object SettingsBackupRestore {
    fun readPreferences(input: InputStream): Map<String, Any> {
        val parser = Xml.newPullParser().apply { setInput(input, "utf-8") }
        parser.nextTag()
        parser.require(XmlPullParser.START_TAG, null, "map")
        val values = linkedMapOf<String, Any>()
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            val type = parser.name
            val name = requireNotNull(parser.getAttributeValue(null, "name"))
            require(name.isNotBlank() && name !in values) { "Invalid preference key" }
            val value = parser.getAttributeValue(null, "value")
            values[name] = when (type) {
                "string" -> parser.nextText()
                "set" -> buildSet {
                    while (parser.nextTag() == XmlPullParser.START_TAG) {
                        parser.require(XmlPullParser.START_TAG, null, "string")
                        add(parser.nextText())
                    }
                    parser.require(XmlPullParser.END_TAG, null, "set")
                }
                else -> {
                    val parsed = when (type) {
                        "boolean" -> requireNotNull(value).toBooleanStrict()
                        "int" -> requireNotNull(value).toInt()
                        "long" -> requireNotNull(value).toLong()
                        "float" -> requireNotNull(value).toFloat().also { require(it.isFinite()) }
                        else -> error("Unsupported preference type")
                    }
                    parser.nextTag()
                    parser.require(XmlPullParser.END_TAG, null, type)
                    parsed
                }
            }
        }
        parser.require(XmlPullParser.END_TAG, null, "map")
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            require(parser.eventType != XmlPullParser.START_TAG) { "Unexpected preference content" }
        }
        return values
    }

    fun validateDatabase(context: Context, file: File, currentVersion: Int) {
        require(file.length() >= 4096) { "Backup database is too small" }
        SQLiteDatabase.openDatabase(file.path, null, SQLiteDatabase.OPEN_READONLY).use { sqlite ->
            require(sqlite.version in 9..currentVersion) { "Unsupported backup database version" }
            sqlite.rawQuery("PRAGMA quick_check", null).use { result ->
                require(result.moveToFirst() && result.getString(0) == "ok" && !result.moveToNext()) { "Invalid backup database" }
            }
        }
        // Use the live migrations and Room schema validation on the staged copy.
        val staged = DatabaseModule().buildDatabase(context, file.path)
        try {
            staged.openHelper.writableDatabase.query("PRAGMA wal_checkpoint(TRUNCATE)").use { result ->
                check(result.moveToFirst() && result.getInt(0) == 0) { "Cannot checkpoint staged database" }
            }
        } finally {
            staged.close()
        }
    }

    fun replacePreferences(prefs: SharedPreferences, values: Map<String, *>) {
        val editor = prefs.edit().clear()
        values.forEach { (name, value) ->
            when (value) {
                is String -> editor.putString(name, value)
                is Boolean -> editor.putBoolean(name, value)
                is Int -> editor.putInt(name, value)
                is Long -> editor.putLong(name, value)
                is Float -> editor.putFloat(name, value)
                is Set<*> -> editor.putStringSet(name, value.map { it as String }.toSet())
                else -> error("Unsupported preference value")
            }
        }
        check(editor.commit()) { "Cannot save restored preferences" }
    }

    fun replaceDatabase(target: File, prepared: File) {
        val atomic = AtomicFile(target)
        val output = atomic.startWrite()
        try {
            prepared.inputStream().use { it.copyTo(output) }
            atomic.finishWrite(output)
        } catch (error: Throwable) {
            atomic.failWrite(output)
            throw error
        }
    }

    fun apply(
        context: Context,
        database: AppDatabase,
        prefs: SharedPreferences,
        newPreferences: Map<String, Any>?,
        preparedDatabase: File?,
        onDatabaseClosed: () -> Unit,
    ) {
        if (preparedDatabase != null) validateDatabase(context, preparedDatabase, database.openHelper.readableDatabase.version)
        val oldPreferences = prefs.all
        val safetyDir = File(context.filesDir, "backup-before-restore").apply { check(isDirectory || mkdirs()) }
        check(prefs.edit().commit())
        File("${context.applicationInfo.dataDir}/shared_prefs/${context.packageName}_preferences.xml")
            .takeIf { it.exists() }?.copyTo(File(safetyDir, "preferences.xml"), overwrite = true)
        val target = context.getDatabasePath("database")
        val savedDatabase = File(safetyDir, "database")
        if (preparedDatabase != null) {
            database.openHelper.writableDatabase.query("PRAGMA wal_checkpoint(FULL)").use { result ->
                check(result.moveToFirst() && result.getInt(0) == 0) { "Cannot checkpoint current database" }
            }
            database.close()
            onDatabaseClosed()
            target.copyTo(savedDatabase, overwrite = true)
        }
        try {
            if (preparedDatabase != null) {
                File(target.path + "-shm").delete()
                File(target.path + "-wal").delete()
                replaceDatabase(target, preparedDatabase)
            }
            if (newPreferences != null) replacePreferences(prefs, newPreferences)
        } catch (error: Throwable) {
            try {
                if (preparedDatabase != null) replaceDatabase(target, savedDatabase)
                replacePreferences(prefs, oldPreferences)
            } catch (rollbackError: Throwable) {
                error.addSuppressed(rollbackError)
            }
            throw error
        }
    }
}
