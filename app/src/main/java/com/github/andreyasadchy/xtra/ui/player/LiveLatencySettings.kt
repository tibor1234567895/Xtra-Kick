package com.github.andreyasadchy.xtra.ui.player

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.DefaultLoadControl
import com.github.andreyasadchy.xtra.util.C

data class LiveLatencyConfig(
    val minBufferMs: Int,
    val maxBufferMs: Int,
    val playbackBufferMs: Int,
    val rebufferMs: Int,
    val targetOffsetMs: Long,
    val minPlaybackSpeed: Float?,
    val maxPlaybackSpeed: Float?
)

private data class LiveLatencyDefaults(
    val minBufferMs: Int,
    val maxBufferMs: Int,
    val playbackBufferMs: Int,
    val rebufferMs: Int,
    val targetOffsetMs: Long,
    val minPlaybackSpeed: Float?,
    val maxPlaybackSpeed: Float?
)

object LiveLatencySettings {
    private const val TAG = "LiveLatencySettings"
    private const val MIGRATION_KEY = "player_latency_profile_migrated_v1"
    private const val LIVE_EDGE_SYNC_TOLERANCE_MS = 4_000L
    const val PROFILE_LOWEST = "lowest"
    const val PROFILE_BALANCED = "balanced"
    const val PROFILE_STABLE = "stable"
    const val DEFAULT_PROFILE = PROFILE_BALANCED

    private val rawLatencyKeys = listOf(
        C.PLAYER_BUFFER_MIN,
        C.PLAYER_BUFFER_MAX,
        C.PLAYER_BUFFER_PLAYBACK,
        C.PLAYER_BUFFER_REBUFFER,
        C.PLAYER_LIVE_TARGET_OFFSET,
        C.PLAYER_LIVE_MIN_SPEED,
        C.PLAYER_LIVE_MAX_SPEED
    )

    fun resolve(prefs: SharedPreferences): LiveLatencyConfig {
        migrateLegacyOverrides(prefs)
        val defaults = defaultsForProfile(prefs.getString(C.PLAYER_LATENCY_PROFILE, DEFAULT_PROFILE))

        val minBufferMs = readIntOverride(prefs, C.PLAYER_BUFFER_MIN, defaults.minBufferMs)
        val maxBufferMs = readIntOverride(prefs, C.PLAYER_BUFFER_MAX, defaults.maxBufferMs)
        val playbackBufferMs = readIntOverride(prefs, C.PLAYER_BUFFER_PLAYBACK, defaults.playbackBufferMs)
        val rebufferMs = readIntOverride(prefs, C.PLAYER_BUFFER_REBUFFER, defaults.rebufferMs)
        val targetOffsetMs = readLongOverride(prefs, C.PLAYER_LIVE_TARGET_OFFSET, defaults.targetOffsetMs)
        val minPlaybackSpeed = readFloatOverride(prefs, C.PLAYER_LIVE_MIN_SPEED, defaults.minPlaybackSpeed)
        val maxPlaybackSpeed = readFloatOverride(prefs, C.PLAYER_LIVE_MAX_SPEED, defaults.maxPlaybackSpeed)
        val normalizedSpeeds = normalizeSpeeds(minPlaybackSpeed, maxPlaybackSpeed)

        return LiveLatencyConfig(
            minBufferMs = minBufferMs,
            maxBufferMs = maxBufferMs.coerceAtLeast(minBufferMs),
            playbackBufferMs = playbackBufferMs,
            rebufferMs = rebufferMs,
            targetOffsetMs = targetOffsetMs.coerceAtLeast(250L),
            minPlaybackSpeed = normalizedSpeeds.first,
            maxPlaybackSpeed = normalizedSpeeds.second
        )
    }

    fun preset(profile: String?): LiveLatencyConfig {
        val defaults = defaultsForProfile(profile)
        return LiveLatencyConfig(
            minBufferMs = defaults.minBufferMs,
            maxBufferMs = defaults.maxBufferMs,
            playbackBufferMs = defaults.playbackBufferMs,
            rebufferMs = defaults.rebufferMs,
            targetOffsetMs = defaults.targetOffsetMs,
            minPlaybackSpeed = defaults.minPlaybackSpeed,
            maxPlaybackSpeed = defaults.maxPlaybackSpeed
        )
    }

    fun applyPreset(prefs: SharedPreferences, profile: String) {
        val config = preset(profile)
        prefs.edit {
            putString(C.PLAYER_LATENCY_PROFILE, profile)
            putString(C.PLAYER_BUFFER_MIN, config.minBufferMs.toString())
            putString(C.PLAYER_BUFFER_MAX, config.maxBufferMs.toString())
            putString(C.PLAYER_BUFFER_PLAYBACK, config.playbackBufferMs.toString())
            putString(C.PLAYER_BUFFER_REBUFFER, config.rebufferMs.toString())
            putString(C.PLAYER_LIVE_TARGET_OFFSET, config.targetOffsetMs.toString())
            putString(C.PLAYER_LIVE_MIN_SPEED, config.minPlaybackSpeed?.toString().orEmpty())
            putString(C.PLAYER_LIVE_MAX_SPEED, config.maxPlaybackSpeed?.toString().orEmpty())
        }
    }

    fun materializeProfileValues(prefs: SharedPreferences): Boolean {
        val missingKeys = rawLatencyKeys.filter { prefs.getString(it, null).isNullOrBlank() }
        if (missingKeys.isEmpty()) {
            return false
        }
        val profile = prefs.getString(C.PLAYER_LATENCY_PROFILE, DEFAULT_PROFILE) ?: DEFAULT_PROFILE
        val config = preset(profile)
        debugLog("Materializing latency profile '$profile' into raw settings for keys=${missingKeys.joinToString()}")
        prefs.edit {
            putString(C.PLAYER_LATENCY_PROFILE, profile)
            if (C.PLAYER_BUFFER_MIN in missingKeys) putString(C.PLAYER_BUFFER_MIN, config.minBufferMs.toString())
            if (C.PLAYER_BUFFER_MAX in missingKeys) putString(C.PLAYER_BUFFER_MAX, config.maxBufferMs.toString())
            if (C.PLAYER_BUFFER_PLAYBACK in missingKeys) putString(C.PLAYER_BUFFER_PLAYBACK, config.playbackBufferMs.toString())
            if (C.PLAYER_BUFFER_REBUFFER in missingKeys) putString(C.PLAYER_BUFFER_REBUFFER, config.rebufferMs.toString())
            if (C.PLAYER_LIVE_TARGET_OFFSET in missingKeys) putString(C.PLAYER_LIVE_TARGET_OFFSET, config.targetOffsetMs.toString())
            if (C.PLAYER_LIVE_MIN_SPEED in missingKeys) putString(C.PLAYER_LIVE_MIN_SPEED, config.minPlaybackSpeed?.toString().orEmpty())
            if (C.PLAYER_LIVE_MAX_SPEED in missingKeys) putString(C.PLAYER_LIVE_MAX_SPEED, config.maxPlaybackSpeed?.toString().orEmpty())
        }
        return true
    }

    fun toLoadControl(config: LiveLatencyConfig): DefaultLoadControl {
        return DefaultLoadControl.Builder().apply {
            setBufferDurationsMs(
                config.minBufferMs,
                config.maxBufferMs,
                config.playbackBufferMs,
                config.rebufferMs
            )
        }.build()
    }

    fun toLiveConfiguration(config: LiveLatencyConfig): MediaItem.LiveConfiguration {
        return MediaItem.LiveConfiguration.Builder().apply {
            config.minPlaybackSpeed?.let { setMinPlaybackSpeed(it) }
            config.maxPlaybackSpeed?.let { setMaxPlaybackSpeed(it) }
            setTargetOffsetMs(config.targetOffsetMs)
        }.build()
    }

    fun shouldForceLiveEdgeSync(config: LiveLatencyConfig, liveOffsetMs: Long?): Boolean {
        return liveOffsetMs != null && liveOffsetMs > config.targetOffsetMs + LIVE_EDGE_SYNC_TOLERANCE_MS
    }

    fun sameLoadControlConfig(first: LiveLatencyConfig, second: LiveLatencyConfig): Boolean {
        return first.minBufferMs == second.minBufferMs &&
            first.maxBufferMs == second.maxBufferMs &&
            first.playbackBufferMs == second.playbackBufferMs &&
            first.rebufferMs == second.rebufferMs
    }

    fun describe(config: LiveLatencyConfig): String {
        return "min=${config.minBufferMs} max=${config.maxBufferMs} playback=${config.playbackBufferMs} " +
            "rebuffer=${config.rebufferMs} target=${config.targetOffsetMs} " +
            "minSpeed=${config.minPlaybackSpeed ?: "off"} maxSpeed=${config.maxPlaybackSpeed ?: "off"}"
    }

    private fun migrateLegacyOverrides(prefs: SharedPreferences) {
        if (prefs.getBoolean(MIGRATION_KEY, false)) {
            return
        }
        val edit = prefs.edit()
        removeIfLegacyDefault(prefs, edit, C.PLAYER_BUFFER_MIN, "15000")
        removeIfLegacyDefault(prefs, edit, C.PLAYER_BUFFER_MAX, "50000")
        removeIfLegacyDefault(prefs, edit, C.PLAYER_BUFFER_PLAYBACK, "2000")
        removeIfLegacyDefault(prefs, edit, C.PLAYER_BUFFER_REBUFFER, "2000")
        removeIfLegacyDefault(prefs, edit, C.PLAYER_LIVE_TARGET_OFFSET, "2000")
        edit.putBoolean(MIGRATION_KEY, true)
        edit.apply()
    }

    private fun defaultsForProfile(profile: String?): LiveLatencyDefaults {
        return when (profile) {
            PROFILE_LOWEST -> LiveLatencyDefaults(
                minBufferMs = 2_000,
                maxBufferMs = 6_000,
                playbackBufferMs = 250,
                rebufferMs = 700,
                targetOffsetMs = 850,
                minPlaybackSpeed = 1.00f,
                maxPlaybackSpeed = 1.25f
            )
            PROFILE_STABLE -> LiveLatencyDefaults(
                minBufferMs = 15_000,
                maxBufferMs = 50_000,
                playbackBufferMs = 2_000,
                rebufferMs = 2_000,
                targetOffsetMs = 2_000,
                minPlaybackSpeed = 1.00f,
                maxPlaybackSpeed = 1.05f
            )
            else -> LiveLatencyDefaults(
                minBufferMs = 3_500,
                maxBufferMs = 9_000,
                playbackBufferMs = 500,
                rebufferMs = 1_000,
                targetOffsetMs = 1_100,
                minPlaybackSpeed = 1.00f,
                maxPlaybackSpeed = 1.18f
            )
        }
    }

    private fun removeIfLegacyDefault(
        prefs: SharedPreferences,
        edit: SharedPreferences.Editor,
        key: String,
        legacyValue: String
    ) {
        if (prefs.getString(key, null)?.trim() == legacyValue) {
            edit.remove(key)
        }
    }

    private fun readIntOverride(prefs: SharedPreferences, key: String, default: Int): Int {
        val value = prefs.getString(key, null)?.trim()
        return if (value.isNullOrEmpty()) default else value.toIntOrNull() ?: default
    }

    private fun readLongOverride(prefs: SharedPreferences, key: String, default: Long): Long {
        val value = prefs.getString(key, null)?.trim()
        return if (value.isNullOrEmpty()) default else value.toLongOrNull() ?: default
    }

    private fun readFloatOverride(prefs: SharedPreferences, key: String, default: Float?): Float? {
        if (!prefs.contains(key)) {
            return default
        }
        val value = prefs.getString(key, null)?.trim()
        if (value.isNullOrEmpty()) {
            return null
        }
        return value.toFloatOrNull() ?: default
    }

    private fun normalizeSpeeds(minSpeed: Float?, maxSpeed: Float?): Pair<Float?, Float?> {
        return when {
            minSpeed != null && maxSpeed != null && minSpeed > maxSpeed -> maxSpeed to minSpeed
            else -> minSpeed to maxSpeed
        }
    }

    private fun debugLog(message: String) {
        try {
            Log.d(TAG, message)
        } catch (_: RuntimeException) {
            // Android Log is not mocked in plain JVM unit tests.
        }
    }
}
