package com.github.andreyasadchy.xtra.ui.player

import android.content.SharedPreferences
import com.github.andreyasadchy.xtra.util.C
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LiveLatencySettingsTest {

    @Test
    fun applyPresetWritesConcreteBalancedValues() {
        val prefs = FakeSharedPreferences()

        LiveLatencySettings.applyPreset(prefs, LiveLatencySettings.PROFILE_BALANCED)

        assertEquals(LiveLatencySettings.PROFILE_BALANCED, prefs.getString(C.PLAYER_LATENCY_PROFILE, null))
        assertEquals("3500", prefs.getString(C.PLAYER_BUFFER_MIN, null))
        assertEquals("9000", prefs.getString(C.PLAYER_BUFFER_MAX, null))
        assertEquals("500", prefs.getString(C.PLAYER_BUFFER_PLAYBACK, null))
        assertEquals("1000", prefs.getString(C.PLAYER_BUFFER_REBUFFER, null))
        assertEquals("1100", prefs.getString(C.PLAYER_LIVE_TARGET_OFFSET, null))
        assertEquals("1.0", prefs.getString(C.PLAYER_LIVE_MIN_SPEED, null))
        assertEquals("1.18", prefs.getString(C.PLAYER_LIVE_MAX_SPEED, null))
    }

    @Test
    fun materializeProfileValuesOnlyFillsMissingKeys() {
        val prefs = FakeSharedPreferences(
            mutableMapOf(
                C.PLAYER_LATENCY_PROFILE to LiveLatencySettings.PROFILE_LOWEST,
                C.PLAYER_BUFFER_MIN to "7777",
                C.PLAYER_BUFFER_MAX to ""
            )
        )

        val changed = LiveLatencySettings.materializeProfileValues(prefs)

        assertTrue(changed)
        assertEquals("7777", prefs.getString(C.PLAYER_BUFFER_MIN, null))
        assertEquals("6000", prefs.getString(C.PLAYER_BUFFER_MAX, null))
        assertEquals("250", prefs.getString(C.PLAYER_BUFFER_PLAYBACK, null))
        assertEquals("700", prefs.getString(C.PLAYER_BUFFER_REBUFFER, null))
        assertEquals("850", prefs.getString(C.PLAYER_LIVE_TARGET_OFFSET, null))
        assertEquals("1.0", prefs.getString(C.PLAYER_LIVE_MIN_SPEED, null))
        assertEquals("1.25", prefs.getString(C.PLAYER_LIVE_MAX_SPEED, null))
    }

    @Test
    fun resolveNormalizesSpeedOverrides() {
        val prefs = FakeSharedPreferences(
            mutableMapOf(
                C.PLAYER_LATENCY_PROFILE to LiveLatencySettings.PROFILE_BALANCED,
                C.PLAYER_LIVE_MIN_SPEED to "1.3",
                C.PLAYER_LIVE_MAX_SPEED to "1.1"
            )
        )

        val config = LiveLatencySettings.resolve(prefs)

        assertEquals(1.1f, config.minPlaybackSpeed)
        assertEquals(1.3f, config.maxPlaybackSpeed)
    }

    @Test
    fun shouldForceLiveEdgeSyncOnlyWhenOffsetIsMateriallyHigh() {
        val config = LiveLatencySettings.preset(LiveLatencySettings.PROFILE_LOWEST)

        assertFalse(LiveLatencySettings.shouldForceLiveEdgeSync(config, null))
        assertFalse(LiveLatencySettings.shouldForceLiveEdgeSync(config, config.targetOffsetMs + 4_000L))
        assertTrue(LiveLatencySettings.shouldForceLiveEdgeSync(config, config.targetOffsetMs + 4_001L))
    }

    @Test
    fun stablePresetUsesConcretePlaybackSpeedBounds() {
        val config = LiveLatencySettings.preset(LiveLatencySettings.PROFILE_STABLE)

        assertEquals(1.0f, config.minPlaybackSpeed)
        assertEquals(1.05f, config.maxPlaybackSpeed)
    }
}

private class FakeSharedPreferences(
    private val values: MutableMap<String, Any?> = mutableMapOf()
) : SharedPreferences {

    override fun getAll(): MutableMap<String, *> = values.toMutableMap()

    override fun getString(key: String?, defValue: String?): String? {
        return (values[key] as? String) ?: defValue
    }

    @Suppress("UNCHECKED_CAST")
    override fun getStringSet(key: String?, defValues: MutableSet<String>?): MutableSet<String>? {
        return ((values[key] as? Set<String>)?.toMutableSet()) ?: defValues
    }

    override fun getInt(key: String?, defValue: Int): Int {
        return values[key] as? Int ?: defValue
    }

    override fun getLong(key: String?, defValue: Long): Long {
        return values[key] as? Long ?: defValue
    }

    override fun getFloat(key: String?, defValue: Float): Float {
        return values[key] as? Float ?: defValue
    }

    override fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return values[key] as? Boolean ?: defValue
    }

    override fun contains(key: String?): Boolean = values.containsKey(key)

    override fun edit(): SharedPreferences.Editor = Editor(values)

    override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener?) = Unit

    override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener?) = Unit

    private class Editor(
        private val values: MutableMap<String, Any?>
    ) : SharedPreferences.Editor {
        private val updates = mutableMapOf<String, Any?>()
        private val removals = mutableSetOf<String>()
        private var clearAll = false

        override fun putString(key: String?, value: String?): SharedPreferences.Editor = apply {
            updates[key.orEmpty()] = value
        }

        override fun putStringSet(key: String?, values: MutableSet<String>?): SharedPreferences.Editor = apply {
            updates[key.orEmpty()] = values?.toSet()
        }

        override fun putInt(key: String?, value: Int): SharedPreferences.Editor = apply {
            updates[key.orEmpty()] = value
        }

        override fun putLong(key: String?, value: Long): SharedPreferences.Editor = apply {
            updates[key.orEmpty()] = value
        }

        override fun putFloat(key: String?, value: Float): SharedPreferences.Editor = apply {
            updates[key.orEmpty()] = value
        }

        override fun putBoolean(key: String?, value: Boolean): SharedPreferences.Editor = apply {
            updates[key.orEmpty()] = value
        }

        override fun remove(key: String?): SharedPreferences.Editor = apply {
            removals += key.orEmpty()
        }

        override fun clear(): SharedPreferences.Editor = apply {
            clearAll = true
        }

        override fun commit(): Boolean {
            if (clearAll) {
                values.clear()
            }
            removals.forEach(values::remove)
            updates.forEach { (key, value) -> values[key] = value }
            return true
        }

        override fun apply() {
            commit()
        }
    }
}
