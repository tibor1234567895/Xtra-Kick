package com.xtrakick.app.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.SystemClock
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import org.json.JSONArray
import java.security.KeyStore
import java.util.concurrent.ConcurrentHashMap
import javax.crypto.AEADBadTagException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

/**
 * SharedPreferences wrapper that uses Android Keystore AES-256-GCM with a fresh IV per write.
 * During a Keystore outage, fallback values and removals use the same backing store.
 *
 * Replaces deprecated Jetpack `EncryptedSharedPreferences` with zero external dependencies
 * and zero deprecation warnings on API 26+.
 */
internal class KeystoreTokenPrefs internal constructor(
    private val delegate: SharedPreferences,
    private var secretKey: SecretKey?,
    private val loadKey: (() -> SecretKey)? = null,
    private val elapsedRealtime: () -> Long = SystemClock::elapsedRealtime,
) : SharedPreferences {

    private val storeLock = Any()
    private var nextKeyAttempt = 0L
    private val listenerWrappers =
        ConcurrentHashMap<SharedPreferences.OnSharedPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener>()

    // Maps pref key -> (raw ciphertext from backing prefs, decrypted typed payload) so repeated
    // reads avoid Android Keystore IPC while auto-invalidating whenever ciphertext changes.
    private val decryptCache = HashMap<String, Pair<String, String>>()

    override fun getAll(): MutableMap<String, *> = synchronized(storeLock) {
        recoverKeyIfNeeded()
        val result = LinkedHashMap<String, Any?>()
        for ((key, raw) in delegate.all) {
            (raw as? String)?.let { decryptCached(key, it) }?.let { payload ->
                result[key] = decodeTypedValue(payload)
            }
        }
        result
    }

    override fun getString(key: String?, defValue: String?): String? =
        readTyped(key, TYPE_STRING) ?: defValue

    override fun getStringSet(key: String?, defValues: MutableSet<String>?): MutableSet<String>? =
        readTyped(key, TYPE_STRING_SET)?.let(::parseStringSet) ?: defValues

    override fun getInt(key: String?, defValue: Int): Int =
        readTyped(key, TYPE_INT)?.toIntOrNull() ?: defValue

    override fun getLong(key: String?, defValue: Long): Long =
        readTyped(key, TYPE_LONG)?.toLongOrNull() ?: defValue

    override fun getFloat(key: String?, defValue: Float): Float =
        readTyped(key, TYPE_FLOAT)?.toFloatOrNull() ?: defValue

    override fun getBoolean(key: String?, defValue: Boolean): Boolean =
        readTyped(key, TYPE_BOOLEAN)?.toBooleanStrictOrNull() ?: defValue

    override fun contains(key: String?): Boolean {
        if (key == null || key == MIGRATED_KEY || key.startsWith(LEGACY_TINK_PREFIX)) return false
        return delegate.contains(key)
    }

    override fun edit(): SharedPreferences.Editor = EditorImpl(delegate.edit())

    override fun registerOnSharedPreferenceChangeListener(
        listener: SharedPreferences.OnSharedPreferenceChangeListener?,
    ) {
        if (listener == null) return
        val wrapper = listenerWrappers.computeIfAbsent(listener) {
            SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                listener.onSharedPreferenceChanged(this@KeystoreTokenPrefs, key)
            }
        }
        delegate.registerOnSharedPreferenceChangeListener(wrapper)
    }

    override fun unregisterOnSharedPreferenceChangeListener(
        listener: SharedPreferences.OnSharedPreferenceChangeListener?,
    ) {
        if (listener == null) return
        val wrapper = listenerWrappers.remove(listener) ?: return
        delegate.unregisterOnSharedPreferenceChangeListener(wrapper)
    }

    private fun readTyped(key: String?, prefix: String): String? = synchronized(storeLock) {
        if (key == null || key == MIGRATED_KEY) return null
        recoverKeyIfNeeded()
        val encoded = delegate.getString(key, null) ?: return null
        val payload = decryptCached(key, encoded) ?: return null
        if (payload.startsWith(prefix)) payload.substring(prefix.length) else null
    }

    private fun decryptCached(key: String, encoded: String): String? {
        decryptCache[key]?.let { (cachedEncoded, cachedPayload) ->
            if (cachedEncoded == encoded) return cachedPayload
        }
        val decrypted = decryptPayload(encoded) ?: return null
        decryptCache[key] = encoded to decrypted
        return decrypted
    }

    private fun encryptPayload(plaintext: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val iv = cipher.iv
        require(iv.size == GCM_IV_BYTES) { "Unexpected GCM IV length: ${iv.size}" }
        val ciphertext = cipher.doFinal(plaintext.toByteArray(Charsets.UTF_8))
        val combined = ByteArray(iv.size + ciphertext.size)
        System.arraycopy(iv, 0, combined, 0, iv.size)
        System.arraycopy(ciphertext, 0, combined, iv.size, ciphertext.size)
        return VALUE_PREFIX + Base64.encodeToString(combined, Base64.NO_WRAP)
    }

    private fun decryptWithKey(combined: ByteArray, key: SecretKey): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, key, GCMParameterSpec(GCM_TAG_BITS, combined, 0, GCM_IV_BYTES))
        return String(cipher.doFinal(combined, GCM_IV_BYTES, combined.size - GCM_IV_BYTES), Charsets.UTF_8)
    }

    private fun decryptPayload(encoded: String): String? {
        if (encoded.startsWith(FALLBACK_PREFIX)) return encoded.removePrefix(FALLBACK_PREFIX)
        val key = secretKey
        if (key == null || !encoded.startsWith(VALUE_PREFIX)) return null
        val combined = try {
            Base64.decode(encoded.substring(VALUE_PREFIX.length), Base64.NO_WRAP)
        } catch (_: IllegalArgumentException) {
            return null
        }
        if (combined.size <= GCM_IV_BYTES) return null

        return try {
            decryptWithKey(combined, key)
        } catch (_: AEADBadTagException) {
            null
        } catch (_: Exception) {
            secretKey = null
            recoverKeyIfNeeded()
            val recovered = secretKey ?: return null
            try {
                decryptWithKey(combined, recovered)
            } catch (_: AEADBadTagException) {
                null
            } catch (_: Exception) {
                secretKey = null
                DiagnosticLogger.w("tokenPrefs", "Keystore decrypt failed after key reload")
                null
            }
        }
    }

    private fun decodeTypedValue(payload: String): Any? = when {
        payload.startsWith(TYPE_STRING) -> payload.substring(TYPE_STRING.length)
        payload.startsWith(TYPE_LONG) -> payload.substring(TYPE_LONG.length).toLongOrNull()
        payload.startsWith(TYPE_INT) -> payload.substring(TYPE_INT.length).toIntOrNull()
        payload.startsWith(TYPE_BOOLEAN) -> payload.substring(TYPE_BOOLEAN.length).toBooleanStrictOrNull()
        payload.startsWith(TYPE_FLOAT) -> payload.substring(TYPE_FLOAT.length).toFloatOrNull()
        payload.startsWith(TYPE_STRING_SET) -> parseStringSet(payload.substring(TYPE_STRING_SET.length))
        else -> null
    }

    private fun parseStringSet(rawJson: String): MutableSet<String>? = runCatching {
        val array = JSONArray(rawJson)
        LinkedHashSet<String>(array.length()).apply {
            for (i in 0 until array.length()) add(array.getString(i))
        }
    }.getOrNull()

    @SuppressLint("ApplySharedPref")
    internal fun migrateLegacy(legacy: SharedPreferences): Boolean {
        if (!delegate.getBoolean(MIGRATED_KEY, false)) {
            val backingEditor = delegate.edit().putBoolean(MIGRATED_KEY, true)
            val editor = EditorImpl(backingEditor)
            for ((key, value) in legacy.all) {
                if (contains(key)) continue
                when (value) {
                    is String -> editor.putString(key, value)
                    is Long -> editor.putLong(key, value)
                    is Int -> editor.putInt(key, value)
                    is Boolean -> editor.putBoolean(key, value)
                    is Float -> editor.putFloat(key, value)
                    is Set<*> -> @Suppress("UNCHECKED_CAST") editor.putStringSet(key, value as MutableSet<String>)
                }
            }
            if (!editor.commit()) return false
        }
        return legacy.all.isEmpty() || legacy.edit().clear().commit()
    }

    @SuppressLint("ApplySharedPref")
    internal fun encryptFallbackValues(): Unit = synchronized(storeLock) {
        if (secretKey == null) return
        val fallbackValues = delegate.all.mapNotNull { (key, raw) ->
            (raw as? String)?.takeIf { it.startsWith(FALLBACK_PREFIX) }?.let { key to it.removePrefix(FALLBACK_PREFIX) }
        }
        if (fallbackValues.isEmpty()) return
        val editor = delegate.edit()
        for ((key, payload) in fallbackValues) {
            editor.putString(key, encryptPayload(payload))
        }
        editor.commit()
    }

    private fun recoverKeyIfNeeded() {
        val loader = loadKey ?: return
        if (secretKey != null || elapsedRealtime() < nextKeyAttempt) return
        nextKeyAttempt = elapsedRealtime() + KEY_RETRY_INTERVAL_MS
        runCatching {
            secretKey = loader()
            encryptPayload("")
            encryptFallbackValues()
        }.onFailure {
            secretKey = null
            DiagnosticLogger.w("tokenPrefs", "Keystore unavailable; retrying during future access")
        }
    }

    private inner class EditorImpl(
        private val delegateEditor: SharedPreferences.Editor,
    ) : SharedPreferences.Editor {

        private var cleared = false
        private val removedKeys = HashSet<String>()
        private val pendingValues = LinkedHashMap<String, String>()

        override fun putString(key: String?, value: String?): SharedPreferences.Editor = apply {
            if (key == null) return@apply
            if (value == null) remove(key) else putEncrypted(key, TYPE_STRING + value)
        }

        override fun putStringSet(key: String?, values: MutableSet<String>?): SharedPreferences.Editor = apply {
            if (key == null) return@apply
            if (values == null) {
                remove(key)
            } else {
                val array = JSONArray()
                values.forEach(array::put)
                putEncrypted(key, TYPE_STRING_SET + array.toString())
            }
        }

        override fun putInt(key: String?, value: Int): SharedPreferences.Editor = apply {
            if (key != null) putEncrypted(key, TYPE_INT + value)
        }

        override fun putLong(key: String?, value: Long): SharedPreferences.Editor = apply {
            if (key != null) putEncrypted(key, TYPE_LONG + value)
        }

        override fun putFloat(key: String?, value: Float): SharedPreferences.Editor = apply {
            if (key != null) putEncrypted(key, TYPE_FLOAT + value)
        }

        override fun putBoolean(key: String?, value: Boolean): SharedPreferences.Editor = apply {
            if (key != null) putEncrypted(key, TYPE_BOOLEAN + value)
        }

        override fun remove(key: String?): SharedPreferences.Editor = apply {
            if (key != null) {
                removedKeys.add(key)
                pendingValues.remove(key)
                delegateEditor.remove(key)
            }
        }

        override fun clear(): SharedPreferences.Editor = apply {
            cleared = true
            delegateEditor.clear()
            if (delegate.getBoolean(MIGRATED_KEY, false)) {
                delegateEditor.putBoolean(MIGRATED_KEY, true)
            }
        }

        override fun commit(): Boolean = synchronized(storeLock) {
            writePendingValues()
            delegateEditor.commit().also { evictCache() }
        }

        override fun apply() {
            synchronized(storeLock) {
                writePendingValues()
                delegateEditor.apply()
                evictCache()
            }
        }

        private fun putEncrypted(key: String, typedPayload: String) {
            removedKeys.add(key)
            pendingValues[key] = typedPayload
        }

        private fun writePendingValues() {
            if (pendingValues.isEmpty()) return
            recoverKeyIfNeeded()
            val encrypted = secretKey?.let {
                runCatching { pendingValues.mapValues { entry -> encryptPayload(entry.value) } }.getOrElse {
                    secretKey = null
                    nextKeyAttempt = elapsedRealtime() + KEY_RETRY_INTERVAL_MS
                    DiagnosticLogger.w("tokenPrefs", "Keystore write failed; retrying during future access")
                    null
                }
            }
            for ((key, payload) in pendingValues) {
                delegateEditor.putString(key, encrypted?.getValue(key) ?: FALLBACK_PREFIX + payload)
            }
            pendingValues.clear()
        }

        private fun evictCache() {
            if (cleared) decryptCache.clear() else removedKeys.forEach(decryptCache::remove)
        }
    }

    companion object {
        private const val ANDROID_KEYSTORE = "AndroidKeyStore"
        private const val KEY_ALIAS = "xtrakick_token_prefs_aes256_gcm_v1"
        private const val TRANSFORMATION = "AES/GCM/NoPadding"
        private const val GCM_IV_BYTES = 12
        private const val GCM_TAG_BITS = 128
        private const val VALUE_PREFIX = "v1:"
        private const val FALLBACK_PREFIX = "fallback:"
        private const val KEY_RETRY_INTERVAL_MS = 5_000L
        private const val MIGRATED_KEY = "__xtrakick_token_prefs_migrated"
        private const val LEGACY_TINK_PREFIX = "__androidx_security_crypto_"

        private const val TYPE_STRING = "S:"
        private const val TYPE_LONG = "L:"
        private const val TYPE_INT = "I:"
        private const val TYPE_BOOLEAN = "B:"
        private const val TYPE_FLOAT = "F:"
        private const val TYPE_STRING_SET = "SS:"

        @SuppressLint("ApplySharedPref")
        fun create(context: Context, prefsName: String): KeystoreTokenPrefs {
            val backing = context.applicationContext.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
            if (backing.all.keys.any { it.startsWith(LEGACY_TINK_PREFIX) }) {
                backing.edit().clear().commit()
            }
            return KeystoreTokenPrefs(backing, null, ::getOrCreateKey)
        }

        private fun getOrCreateKey(): SecretKey {
            val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
            (keyStore.getKey(KEY_ALIAS, null) as? SecretKey)?.let { return it }

            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE)
            val spec = KeyGenParameterSpec.Builder(
                KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT,
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(256)
                .setRandomizedEncryptionRequired(true)
                .build()
            keyGenerator.init(spec)
            return keyGenerator.generateKey()
        }
    }
}
