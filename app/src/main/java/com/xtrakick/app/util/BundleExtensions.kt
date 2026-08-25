package com.xtrakick.app.util

import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import java.io.Serializable

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
