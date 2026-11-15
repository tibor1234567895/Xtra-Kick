package com.xtrakick.app.util

import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.AtomicFile
import android.util.Size
import android.util.SizeF
import java.io.File
import java.io.Serializable
import java.util.UUID

/** Builds argument bundles without relying on the deprecated AndroidX pair helper. */
fun bundleOf(vararg pairs: Pair<String, Any?>): Bundle = Bundle().apply {
    pairs.forEach { (key, value) ->
        when (value) {
            null -> putString(key, null)
            is Boolean -> putBoolean(key, value)
            is Byte -> putByte(key, value)
            is Char -> putChar(key, value)
            is Short -> putShort(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is Double -> putDouble(key, value)
            is String -> putString(key, value)
            is CharSequence -> putCharSequence(key, value)
            is Bundle -> putBundle(key, value)
            is Parcelable -> putParcelable(key, value)
            is ArrayList<*> -> when {
                value.all { it == null || it is String } -> putStringArrayList(key, value.filterIsInstance<String>().toCollection(ArrayList()))
                value.all { it == null || it is CharSequence } -> putCharSequenceArrayList(key, value.filterIsInstance<CharSequence>().toCollection(ArrayList()))
                value.all { it == null || it is Parcelable } -> putParcelableArrayList(key, value.filterIsInstance<Parcelable>().toCollection(ArrayList()))
                value.all { it == null || it is Int } -> putIntegerArrayList(key, value.filterIsInstance<Int>().toCollection(ArrayList()))
                else -> putSerializable(key, value)
            }
            is Array<*> -> when {
                value.all { it == null || it is String } -> putStringArray(key, value.filterIsInstance<String>().toTypedArray())
                value.all { it == null || it is CharSequence } -> putCharSequenceArray(key, value.filterIsInstance<CharSequence>().toTypedArray())
                value.all { it == null || it is Parcelable } -> putParcelableArray(key, value.filterIsInstance<Parcelable>().toTypedArray())
                else -> putSerializable(key, value)
            }
            is Serializable -> putSerializable(key, value)
            is IBinder -> putBinder(key, value)
            is Size -> putSize(key, value)
            is SizeF -> putSizeF(key, value)
            is BooleanArray -> putBooleanArray(key, value)
            is ByteArray -> putByteArray(key, value)
            is CharArray -> putCharArray(key, value)
            is ShortArray -> putShortArray(key, value)
            is IntArray -> putIntArray(key, value)
            is LongArray -> putLongArray(key, value)
            is FloatArray -> putFloatArray(key, value)
            is DoubleArray -> putDoubleArray(key, value)
            else -> error("Unsupported Bundle value for key '$key': ${value::class.java.name}")
        }
    }
}

const val MAX_SAFE_SAVED_STATE_BYTES = 250_000

/**
 * Returns the byte size of this [Bundle] when serialized to a [android.os.Parcel].
 * Returns -1 if measuring fails.
 */
fun Bundle.getParcelSize(): Int {
    val parcel = android.os.Parcel.obtain()
    return try {
        writeToParcel(parcel, 0)
        parcel.dataSize()
    } catch (_: Throwable) {
        -1
    } finally {
        parcel.recycle()
    }
}

internal const val SAVED_STATE_FILE_KEY = "com.xtrakick.app.saved_state_file"
private const val SAVED_STATE_RETENTION_MS = 30L * 24 * 60 * 60 * 1000

/** Writes a complete snapshot before replacing it with a small Binder-safe reference. */
fun saveOversizedInstanceState(context: Context, state: Bundle): Boolean {
    if (state.getParcelSize() <= MAX_SAFE_SAVED_STATE_BYTES) return false
    val parcel = android.os.Parcel.obtain()
    var target: AtomicFile? = null
    var output: java.io.FileOutputStream? = null
    try {
        parcel.writeBundle(state)
        val bytes = parcel.marshall()
        val directory = File(context.noBackupFilesDir, "saved-state").apply { mkdirs() }
        val token = UUID.randomUUID().toString()
        target = AtomicFile(File(directory, "$token.bin"))
        output = target.startWrite()
        output.write(bytes)
        target.finishWrite(output)
        output = null
        state.clear()
        state.putString(SAVED_STATE_FILE_KEY, token)
        val cutoff = System.currentTimeMillis() - SAVED_STATE_RETENTION_MS
        directory.listFiles()?.forEach { file ->
            if (file.extension == "bin" && file.lastModified() < cutoff) file.delete()
        }
        return true
    } catch (error: Exception) {
        target?.failWrite(output)
        DiagnosticLogger.w("SavedState", "Could not persist oversized instance state; retaining the original", error)
        return false
    } finally {
        parcel.recycle()
    }
}

/** Expands the same Bundle before AndroidX and later lifecycle callbacks consume it. */
fun restoreOversizedInstanceState(context: Context, state: Bundle): Boolean {
    val token = state.getString(SAVED_STATE_FILE_KEY) ?: return false
    if (!Regex("[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}").matches(token)) {
        state.remove(SAVED_STATE_FILE_KEY)
        return false
    }
    val file = File(context.noBackupFilesDir, "saved-state/$token.bin")
    val parcel = android.os.Parcel.obtain()
    try {
        val bytes = AtomicFile(file).readFully()
        parcel.unmarshall(bytes, 0, bytes.size)
        parcel.setDataPosition(0)
        val restored = parcel.readBundle(context.classLoader) ?: return false
        state.clear()
        state.putAll(restored)
        file.setLastModified(System.currentTimeMillis())
        return true
    } catch (error: Exception) {
        state.remove(SAVED_STATE_FILE_KEY)
        DiagnosticLogger.w("SavedState", "Could not restore saved instance state", error)
        return false
    } finally {
        parcel.recycle()
    }
}
