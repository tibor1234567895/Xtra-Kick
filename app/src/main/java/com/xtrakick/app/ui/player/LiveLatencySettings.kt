package com.xtrakick.app.ui.player

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import kotlin.math.roundToInt
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultLoadControl
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.util.AppConstants

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

    const val MIN_SAFE_FORWARD_BUFFER_MS = 750L
    const val REBUFFER_GRACE_PERIOD_MS = 5_000L
    const val CATCHUP_DRIFT_THRESHOLD_MS = 500L
    const val CATCHUP_TARGET_MARGIN_MS = 150L

    private val rawLatencyKeys = listOf(
        AppConstants.PLAYER_BUFFER_MIN,
        AppConstants.PLAYER_BUFFER_MAX,
        AppConstants.PLAYER_BUFFER_PLAYBACK,
        AppConstants.PLAYER_BUFFER_REBUFFER,
        AppConstants.PLAYER_LIVE_TARGET_OFFSET,
        AppConstants.PLAYER_LIVE_MIN_SPEED,
        AppConstants.PLAYER_LIVE_MAX_SPEED
    )

    fun resolve(prefs: SharedPreferences): LiveLatencyConfig {
        migrateLegacyOverrides(prefs)
        val defaults = defaultsForProfile(prefs.getString(AppConstants.PLAYER_LATENCY_PROFILE, DEFAULT_PROFILE))

        val minBufferMs = readIntOverride(prefs, AppConstants.PLAYER_BUFFER_MIN, defaults.minBufferMs)
        val maxBufferMs = readIntOverride(prefs, AppConstants.PLAYER_BUFFER_MAX, defaults.maxBufferMs)
        val playbackBufferMs = readIntOverride(prefs, AppConstants.PLAYER_BUFFER_PLAYBACK, defaults.playbackBufferMs)
        val rebufferMs = readIntOverride(prefs, AppConstants.PLAYER_BUFFER_REBUFFER, defaults.rebufferMs)
        val targetOffsetMs = readLongOverride(prefs, AppConstants.PLAYER_LIVE_TARGET_OFFSET, defaults.targetOffsetMs)
        val minPlaybackSpeed = readFloatOverride(prefs, AppConstants.PLAYER_LIVE_MIN_SPEED, defaults.minPlaybackSpeed)
        val maxPlaybackSpeed = readFloatOverride(prefs, AppConstants.PLAYER_LIVE_MAX_SPEED, defaults.maxPlaybackSpeed)
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
            putString(AppConstants.PLAYER_LATENCY_PROFILE, profile)
            putString(AppConstants.PLAYER_BUFFER_MIN, config.minBufferMs.toString())
            putString(AppConstants.PLAYER_BUFFER_MAX, config.maxBufferMs.toString())
            putString(AppConstants.PLAYER_BUFFER_PLAYBACK, config.playbackBufferMs.toString())
            putString(AppConstants.PLAYER_BUFFER_REBUFFER, config.rebufferMs.toString())
            putString(AppConstants.PLAYER_LIVE_TARGET_OFFSET, config.targetOffsetMs.toString())
            putString(AppConstants.PLAYER_LIVE_MIN_SPEED, config.minPlaybackSpeed?.toString().orEmpty())
            putString(AppConstants.PLAYER_LIVE_MAX_SPEED, config.maxPlaybackSpeed?.toString().orEmpty())
        }
    }

    fun materializeProfileValues(prefs: SharedPreferences): Boolean {
        val missingKeys = rawLatencyKeys.filter { prefs.getString(it, null).isNullOrBlank() }
        if (missingKeys.isEmpty()) {
            return false
        }
        val profile = prefs.getString(AppConstants.PLAYER_LATENCY_PROFILE, DEFAULT_PROFILE) ?: DEFAULT_PROFILE
        val config = preset(profile)
        debugLog(prefs, "Materializing latency profile '$profile' into raw settings for keys=${missingKeys.joinToString()}")
        prefs.edit {
            putString(AppConstants.PLAYER_LATENCY_PROFILE, profile)
            if (AppConstants.PLAYER_BUFFER_MIN in missingKeys) putString(AppConstants.PLAYER_BUFFER_MIN, config.minBufferMs.toString())
            if (AppConstants.PLAYER_BUFFER_MAX in missingKeys) putString(AppConstants.PLAYER_BUFFER_MAX, config.maxBufferMs.toString())
            if (AppConstants.PLAYER_BUFFER_PLAYBACK in missingKeys) putString(AppConstants.PLAYER_BUFFER_PLAYBACK, config.playbackBufferMs.toString())
            if (AppConstants.PLAYER_BUFFER_REBUFFER in missingKeys) putString(AppConstants.PLAYER_BUFFER_REBUFFER, config.rebufferMs.toString())
            if (AppConstants.PLAYER_LIVE_TARGET_OFFSET in missingKeys) putString(AppConstants.PLAYER_LIVE_TARGET_OFFSET, config.targetOffsetMs.toString())
            if (AppConstants.PLAYER_LIVE_MIN_SPEED in missingKeys) putString(AppConstants.PLAYER_LIVE_MIN_SPEED, config.minPlaybackSpeed?.toString().orEmpty())
            if (AppConstants.PLAYER_LIVE_MAX_SPEED in missingKeys) putString(AppConstants.PLAYER_LIVE_MAX_SPEED, config.maxPlaybackSpeed?.toString().orEmpty())
        }
        return true
    }

    @UnstableApi
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

    /**
     * Calculates the proportional playback speed for IVS live latency catch-up.
     * Returns null if catch-up should NOT engage (forward buffer too small,
     * in cooldown grace period, or within target margin).
     */
    fun calculateIvsCatchupSpeed(
        latencyMs: Long,
        targetOffsetMs: Long,
        forwardBufferMs: Long,
        isInGracePeriod: Boolean,
        maxSpeedLimit: Float = 1.18f,
        isCurrentlyCatchingUp: Boolean = false
    ): Float? {
        if (isInGracePeriod || forwardBufferMs < MIN_SAFE_FORWARD_BUFFER_MS) {
            return null
        }
        val targetMargin = targetOffsetMs + CATCHUP_TARGET_MARGIN_MS
        val driftThreshold = targetOffsetMs + CATCHUP_DRIFT_THRESHOLD_MS

        if (isCurrentlyCatchingUp && latencyMs <= targetMargin) {
            return null
        }
        if (!isCurrentlyCatchingUp && latencyMs <= driftThreshold) {
            return null
        }

        val drift = (latencyMs - targetOffsetMs).coerceAtLeast(0L)
        // Responsive proportional speedup: scales smoothly up to maxSpeedLimit (e.g. 1.18x-1.25x)
        // so streams 2-3s behind catch up within 8-12 seconds instead of taking over 40 seconds.
        val speedBump = (drift.toFloat() / 1500f * 0.12f)
        val calculated = (1.04f + speedBump).coerceIn(1.04f, maxSpeedLimit.coerceIn(1.04f, 1.25f))
        return (calculated * 100f).roundToInt() / 100f
    }

    private fun migrateLegacyOverrides(prefs: SharedPreferences) {
        if (prefs.getBoolean(MIGRATION_KEY, false)) {
            return
        }
        val edit = prefs.edit()
        removeIfLegacyDefault(prefs, edit, AppConstants.PLAYER_BUFFER_MIN, "15000")
        removeIfLegacyDefault(prefs, edit, AppConstants.PLAYER_BUFFER_MAX, "50000")
        removeIfLegacyDefault(prefs, edit, AppConstants.PLAYER_BUFFER_PLAYBACK, "2000")
        removeIfLegacyDefault(prefs, edit, AppConstants.PLAYER_BUFFER_REBUFFER, "2000")
        removeIfLegacyDefault(prefs, edit, AppConstants.PLAYER_LIVE_TARGET_OFFSET, "2000")
        edit.putBoolean(MIGRATION_KEY, true)
        edit.apply()
    }

    private fun defaultsForProfile(profile: String?): LiveLatencyDefaults {
        return when (profile) {
            PROFILE_LOWEST -> LiveLatencyDefaults(
                minBufferMs = 2_500,
                maxBufferMs = 8_000,
                playbackBufferMs = 500,
                rebufferMs = 1_000,
                targetOffsetMs = 1_000,
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
                minBufferMs = 4_000,
                maxBufferMs = 15_000,
                playbackBufferMs = 800,
                rebufferMs = 1_500,
                targetOffsetMs = 1_600,
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

    private fun debugLog(prefs: SharedPreferences, message: String) {
        if (!BuildConfig.DEBUG || !prefs.getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)) {
            return
        }
        try {
            Log.d(TAG, message)
        } catch (_: RuntimeException) {
            // Android Log is not mocked in plain JVM unit tests.
        }
    }
}
