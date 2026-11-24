package com.xtrakick.app.util

import android.content.Context
import android.content.SharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

@RunWith(RobolectricTestRunner::class)
class KeystoreTokenPrefsTest {

    private fun testSecretKey(): SecretKey =
        KeyGenerator.getInstance("AES").apply { init(256) }.generateKey()

    @Test
    fun roundTripsAllSupportedTypesAndNeverStoresPlaintext() {
        val context = RuntimeEnvironment.getApplication()
        val backing = context.getSharedPreferences("test_secure_prefs", Context.MODE_PRIVATE)
        backing.edit().clear().commit()
        val secure = KeystoreTokenPrefs(backing, testSecretKey())

        assertTrue(
            secure.edit()
                .putString("access_token", "secret-kick-token-123")
                .putLong("expires_at", 1_799_999_999L)
                .putInt("version", 7)
                .putBoolean("google_session", true)
                .putFloat("ratio", 1.5f)
                .putStringSet("scopes", mutableSetOf("user:read", "chat:write"))
                .commit(),
        )

        // Raw backing store must contain only encrypted "v1:" values, never plaintext.
        val rawToken = backing.getString("access_token", null)!!
        assertTrue(rawToken.startsWith("v1:"))
        assertFalse(rawToken.contains("secret-kick-token-123"))

        // Re-writing the same value must produce a distinct ciphertext (fresh random IV).
        secure.edit().putString("access_token_copy", "secret-kick-token-123").commit()
        assertNotEquals(rawToken, backing.getString("access_token_copy", null))

        assertEquals("secret-kick-token-123", secure.getString("access_token", null))
        assertEquals(1_799_999_999L, secure.getLong("expires_at", 0L))
        assertEquals(7, secure.getInt("version", 0))
        assertTrue(secure.getBoolean("google_session", false))
        assertEquals(1.5f, secure.getFloat("ratio", 0f), 0.0001f)
        assertEquals(setOf("user:read", "chat:write"), secure.getStringSet("scopes", null))

        val all = secure.all
        assertEquals("secret-kick-token-123", all["access_token"])
        assertEquals(1_799_999_999L, all["expires_at"])

        // Overwrite and null removal must bypass/evict decrypt cache immediately.
        secure.edit().putString("access_token", "rotated-token-456").commit()
        assertEquals("rotated-token-456", secure.getString("access_token", null))

        // Null putString removes key, matching Android SharedPreferences contract.
        secure.edit().putString("access_token", null).commit()
        assertFalse(secure.contains("access_token"))
        assertNull(secure.getString("access_token", null))

        secure.edit().clear().commit()
        assertTrue(secure.all.isEmpty())
    }

    @Test
    fun corruptedCiphertextReturnsDefaultWithoutThrowing() {
        val context = RuntimeEnvironment.getApplication()
        val backing = context.getSharedPreferences("test_corrupt_prefs", Context.MODE_PRIVATE)
        backing.edit().clear().commit()
        val secure = KeystoreTokenPrefs(backing, testSecretKey())

        backing.edit()
            .putString("tampered", "v1:AAAA_not_valid_gcm_ciphertext_AAAA")
            .putString("plaintext_legacy", "raw-value")
            .commit()

        assertEquals("fallback", secure.getString("tampered", "fallback"))
        assertEquals("fallback", secure.getString("plaintext_legacy", "fallback"))
        assertEquals(42L, secure.getLong("tampered", 42L))
    }

    @Test
    fun logoutDuringKeystoreOutageSurvivesRecoveryAndStaleLegacyData() {
        val context = RuntimeEnvironment.getApplication()
        val legacy = context.getSharedPreferences("test_legacy_outage", Context.MODE_PRIVATE)
        val backing = context.getSharedPreferences("test_secure_outage", Context.MODE_PRIVATE)
        legacy.edit().clear().putString(AppConstants.KICK_ACCESS_TOKEN, "legacy-token").commit()
        backing.edit().clear().commit()
        val key = testSecretKey()
        val initial = KeystoreTokenPrefs(backing, key)
        assertTrue(initial.migrateLegacy(legacy))
        assertEquals("legacy-token", initial.getString(AppConstants.KICK_ACCESS_TOKEN, null))

        val unavailable = KeystoreTokenPrefs(backing, null)
        assertNull(unavailable.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertTrue(AuthStateHelper.hasUnreadableKickSession(unavailable))
        assertTrue(unavailable.edit().remove(AppConstants.KICK_ACCESS_TOKEN).putLong("last_check", 42L).commit())
        assertFalse(AuthStateHelper.hasUnreadableKickSession(unavailable))
        legacy.edit().putString(AppConstants.KICK_ACCESS_TOKEN, "stale-token").commit()

        val recovered = KeystoreTokenPrefs(backing, key)
        recovered.encryptFallbackValues()
        assertTrue(recovered.migrateLegacy(legacy))
        assertNull(recovered.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertTrue(legacy.all.isEmpty())
        assertEquals(42L, recovered.getLong("last_check", 0L))
        assertTrue(backing.getString("last_check", null)!!.startsWith("v1:"))
    }

    @Test
    fun sameStoreRecoversItsKeyAndEncryptsFallbackAndPendingWrites() {
        val context = RuntimeEnvironment.getApplication()
        val backing = context.getSharedPreferences("test_secure_in_process_recovery", Context.MODE_PRIVATE)
        backing.edit().clear().commit()
        val key = testSecretKey()
        KeystoreTokenPrefs(backing, key).edit().putString(AppConstants.KICK_ACCESS_TOKEN, "saved-token").commit()
        var available = false
        var elapsed = 0L
        val store = KeystoreTokenPrefs(backing, null, loadKey = {
            check(available)
            key
        }, elapsedRealtime = { elapsed })

        assertTrue(AuthStateHelper.hasUnreadableKickSession(store))
        store.edit().putLong("last_check", 42).commit()
        assertTrue(backing.getString("last_check", null)!!.startsWith("fallback:"))
        val pending = store.edit().putString("new_value", "pending")

        available = true
        elapsed += 10_000L
        pending.commit()
        assertFalse(AuthStateHelper.hasUnreadableKickSession(store))
        assertEquals("saved-token", store.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertEquals(42L, store.getLong("last_check", 0L))
        assertEquals("pending", store.getString("new_value", null))
        assertTrue(backing.getString("last_check", null)!!.startsWith("v1:"))
        assertTrue(backing.getString("new_value", null)!!.startsWith("v1:"))
    }

    @Test
    fun readPathKeystoreFailureRecoversImmediatelyWhenKeystoreIsHealthyAndBacksOffWhenDown() {
        val context = RuntimeEnvironment.getApplication()
        val backing = context.getSharedPreferences("test_read_recovery", Context.MODE_PRIVATE)
        backing.edit().clear().commit()
        val realKey = testSecretKey()
        KeystoreTokenPrefs(backing, realKey).edit().putString(AppConstants.KICK_ACCESS_TOKEN, "live-token").commit()

        val brokenKey = object : SecretKey {
            override fun getAlgorithm(): String = "AES"
            override fun getFormat(): String? = null
            override fun getEncoded(): ByteArray? = null
        }

        // Case 1: keystore2 restarted in background and is already healthy -> zero-outage immediate recovery.
        var immediateLoads = 0
        val healthyStore = KeystoreTokenPrefs(
            backing,
            brokenKey,
            loadKey = {
                immediateLoads++
                realKey
            },
            elapsedRealtime = { 0L },
        )
        assertEquals("live-token", healthyStore.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertEquals(1, immediateLoads)

        // Case 2: Keystore is still down -> single immediate attempt, then 5s backoff before recovery.
        var available = false
        var elapsed = 0L
        var outageLoads = 0
        val outageStore = KeystoreTokenPrefs(
            backing,
            brokenKey,
            loadKey = {
                outageLoads++
                check(available)
                realKey
            },
            elapsedRealtime = { elapsed },
        )
        assertNull(outageStore.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertEquals(1, outageLoads)
        // Immediate retry within 5s window respects backoff.
        assertNull(outageStore.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertEquals(1, outageLoads)
        available = true
        elapsed += 10_000L
        assertEquals("live-token", outageStore.getString(AppConstants.KICK_ACCESS_TOKEN, null))
        assertEquals(2, outageLoads)
    }

    @Test
    fun listenerReceivesWrapperInstanceOnChange() {
        val context = RuntimeEnvironment.getApplication()
        val backing = context.getSharedPreferences("test_listener_prefs", Context.MODE_PRIVATE)
        backing.edit().clear().commit()
        val secure = KeystoreTokenPrefs(backing, testSecretKey())

        var observedPrefs: SharedPreferences? = null
        var observedKey: String? = null
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
            observedPrefs = prefs
            observedKey = key
        }
        secure.registerOnSharedPreferenceChangeListener(listener)
        secure.edit().putString("token", "abc").commit()

        assertEquals(secure, observedPrefs)
        assertEquals("token", observedKey)
        secure.unregisterOnSharedPreferenceChangeListener(listener)
    }
}
