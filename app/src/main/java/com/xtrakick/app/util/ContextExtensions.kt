package com.xtrakick.app.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.DialogInterface
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.view.KeyEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.res.use
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.preference.PreferenceManager
import com.xtrakick.app.R
import com.google.android.material.color.DynamicColors
import com.google.android.material.color.DynamicColorsOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.chromium.net.CronetException
import org.chromium.net.UrlResponseInfo
import org.chromium.net.apihelpers.ByteArrayCronetCallback
import org.chromium.net.apihelpers.CronetRequestCompletionListener
import java.io.IOException
import java.util.Locale
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun Context.prefs(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

private const val LEGACY_TOKEN_PREFS_NAME = "prefs2"
private const val TOKEN_PREFS_NAME = "prefs2_secure"
private val tokenPrefsLock = Any()

@Volatile
private var tokenPrefsInstance: SharedPreferences? = null

/**
 * Encrypted at-rest store for credentials (OAuth access/refresh tokens, proxy password).
 *
 * Legacy plaintext values are migrated once. All edits use the same backing store,
 * so changes made during a Keystore outage survive recovery.
 */
fun Context.tokenPrefs(): SharedPreferences {
    tokenPrefsInstance?.let { return it }
    synchronized(tokenPrefsLock) {
        tokenPrefsInstance?.let { return it }
        val app = applicationContext
        val instance = KeystoreTokenPrefs.create(app, TOKEN_PREFS_NAME)
        val legacy = app.getSharedPreferences(LEGACY_TOKEN_PREFS_NAME, Context.MODE_PRIVATE)
        if (instance.migrateLegacy(legacy)) app.deleteSharedPreferences(LEGACY_TOKEN_PREFS_NAME)
        tokenPrefsInstance = instance
        return instance
    }
}

fun Context.getProxyPassword(): String? {
    val secure = tokenPrefs()
    val existing = secure.getString(AppConstants.PROXY_PASSWORD, null)
    if (existing != null) return existing
    val legacyPrefs = prefs()
    val legacy = legacyPrefs.getString(AppConstants.PROXY_PASSWORD, null) ?: return null
    secure.edit().putString(AppConstants.PROXY_PASSWORD, legacy).apply()
    legacyPrefs.edit().remove(AppConstants.PROXY_PASSWORD).apply()
    return legacy
}

fun Context.setProxyPassword(value: String?) {
    tokenPrefs().edit().apply {
        if (value.isNullOrEmpty()) remove(AppConstants.PROXY_PASSWORD) else putString(AppConstants.PROXY_PASSWORD, value)
    }.apply()
    prefs().edit().remove(AppConstants.PROXY_PASSWORD).apply()
}

/**
 * Reads a boolean preference safely, handling legacy/backup corruptions where a boolean
 * value was mistakenly stored or restored as a String (avoiding ClassCastException).
 */
fun SharedPreferences.safeGetBoolean(key: String, defValue: Boolean): Boolean =
    try {
        getBoolean(key, defValue)
    } catch (_: ClassCastException) {
        runCatching { getString(key, null) }.getOrNull()?.toBooleanStrictOrNull() ?: defValue
    }

private val MATERIAL3_THEMES = arrayOf(
    // Dark (0)
    arrayOf(
        intArrayOf(R.style.DarkThemeSmallCornersReducedPaddingCompactText, R.style.DarkThemeSmallCornersReducedPadding, R.style.DarkThemeSmallCornersCompactText, R.style.DarkThemeSmallCorners),
        intArrayOf(R.style.DarkThemeNoCornersReducedPaddingCompactText, R.style.DarkThemeNoCornersReducedPadding, R.style.DarkThemeNoCornersCompactText, R.style.DarkThemeNoCorners),
        intArrayOf(R.style.DarkThemeReducedPaddingCompactText, R.style.DarkThemeReducedPadding, R.style.DarkThemeCompactText, R.style.DarkTheme),
    ),
    // Amoled (1)
    arrayOf(
        intArrayOf(R.style.AmoledThemeSmallCornersReducedPaddingCompactText, R.style.AmoledThemeSmallCornersReducedPadding, R.style.AmoledThemeSmallCornersCompactText, R.style.AmoledThemeSmallCorners),
        intArrayOf(R.style.AmoledThemeNoCornersReducedPaddingCompactText, R.style.AmoledThemeNoCornersReducedPadding, R.style.AmoledThemeNoCornersCompactText, R.style.AmoledThemeNoCorners),
        intArrayOf(R.style.AmoledThemeReducedPaddingCompactText, R.style.AmoledThemeReducedPadding, R.style.AmoledThemeCompactText, R.style.AmoledTheme),
    ),
    // Light (2)
    arrayOf(
        intArrayOf(R.style.LightThemeSmallCornersReducedPaddingCompactText, R.style.LightThemeSmallCornersReducedPadding, R.style.LightThemeSmallCornersCompactText, R.style.LightThemeSmallCorners),
        intArrayOf(R.style.LightThemeNoCornersReducedPaddingCompactText, R.style.LightThemeNoCornersReducedPadding, R.style.LightThemeNoCornersCompactText, R.style.LightThemeNoCorners),
        intArrayOf(R.style.LightThemeReducedPaddingCompactText, R.style.LightThemeReducedPadding, R.style.LightThemeCompactText, R.style.LightTheme),
    ),
    // Blue (3)
    arrayOf(
        intArrayOf(R.style.BlueThemeSmallCornersReducedPaddingCompactText, R.style.BlueThemeSmallCornersReducedPadding, R.style.BlueThemeSmallCornersCompactText, R.style.BlueThemeSmallCorners),
        intArrayOf(R.style.BlueThemeNoCornersReducedPaddingCompactText, R.style.BlueThemeNoCornersReducedPadding, R.style.BlueThemeNoCornersCompactText, R.style.BlueThemeNoCorners),
        intArrayOf(R.style.BlueThemeReducedPaddingCompactText, R.style.BlueThemeReducedPadding, R.style.BlueThemeCompactText, R.style.BlueTheme),
    ),
)

fun Activity.applyTheme() {
    // On Android 15, wrong language is used when multiple languages are set in device settings
    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.VANILLA_ICE_CREAM) {
        val lang = AppCompatDelegate.getApplicationLocales()
        resources.configuration.setLocale(
            if (!lang.isEmpty) {
                Locale.forLanguageTag(lang.toLanguageTags())
            } else {
                Locale.getDefault()
            }
        )
    }
    val theme = if (prefs().getBoolean(AppConstants.UI_THEME_FOLLOW_SYSTEM, false)) {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> prefs().getString(AppConstants.UI_THEME_DARK_ON, "0") ?: "0"
            else -> prefs().getString(AppConstants.UI_THEME_DARK_OFF, "2") ?: "2"
        }
    } else {
        prefs().getString(AppConstants.THEME, "0") ?: "0"
    }
    if (prefs().getBoolean(AppConstants.UI_THEME_MATERIAL3, true)) {
        val reducedPadding = prefs().getBoolean(AppConstants.UI_THEME_REDUCED_PADDING, false)
        val compactText = prefs().getBoolean(AppConstants.UI_THEME_COMPACT_TEXT, false)
        val themeIndex = when (theme) {
            "1", "6" -> 1
            "2", "5" -> 2
            "3" -> 3
            else -> 0
        }
        val cornerIndex = when (prefs().getString(AppConstants.UI_THEME_ROUNDED_CORNERS, "0")) {
            "1" -> 0
            "2" -> 1
            else -> 2
        }
        val modifierIndex = when {
            reducedPadding && compactText -> 0
            reducedPadding -> 1
            compactText -> 2
            else -> 3
        }
        setTheme(MATERIAL3_THEMES[themeIndex][cornerIndex][modifierIndex])
        if (theme == "4" || theme == "6" || theme == "5") {
            DynamicColors.applyToActivityIfAvailable(
                this,
                DynamicColorsOptions.Builder().apply {
                    setThemeOverlay(
                        when (theme) {
                            "4" -> R.style.DarkDynamicOverlay
                            "6" -> R.style.AmoledDynamicOverlay
                            "5" -> R.style.LightDynamicOverlay
                            else -> R.style.DarkDynamicOverlay
                        }
                    )
                }.build()
            )
        }
    } else {
        setTheme(
            when (theme) {
                "4" -> R.style.AppCompatDarkTheme
                "6" -> R.style.AppCompatAmoledTheme
                "5" -> R.style.AppCompatLightTheme
                "1" -> R.style.AppCompatAmoledTheme
                "2" -> R.style.AppCompatLightTheme
                "3" -> R.style.AppCompatBlueTheme
                else -> R.style.AppCompatDarkTheme
            }
        )
    }
    val isLightTheme = obtainStyledAttributes(intArrayOf(androidx.appcompat.R.attr.isLightTheme)).use {
        it.getBoolean(0, false)
    }
    WindowInsetsControllerCompat(window, window.decorView).run {
        isAppearanceLightStatusBars = isLightTheme
        isAppearanceLightNavigationBars = isLightTheme
    }
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}

/**
 * Consumes KEYCODE_CALL / KEYCODE_ENDCALL so unhandled call-button events never reach
 * PhoneFallbackEventHandler, which throws SecurityException on Android 12 because
 * third-party apps may no longer send the CLOSE_SYSTEM_DIALOGS broadcast.
 */
val callKeyEventGuardListener = DialogInterface.OnKeyListener { _, keyCode, _ ->
    keyCode == KeyEvent.KEYCODE_CALL || keyCode == KeyEvent.KEYCODE_ENDCALL
}

fun Context.getAlertDialogBuilder(): AlertDialog.Builder {
    return if (prefs().getBoolean(AppConstants.UI_THEME_MATERIAL3, true)) {
        GuardedMaterialAlertDialogBuilder(this)
    } else {
        GuardedAlertDialogBuilder(this)
    }
}

private class GuardedMaterialAlertDialogBuilder(context: Context) : MaterialAlertDialogBuilder(context) {
    override fun create(): AlertDialog =
        super.create().also { it.setOnKeyListener(callKeyEventGuardListener) }
}

private class GuardedAlertDialogBuilder(context: Context) : AlertDialog.Builder(context) {
    override fun create(): AlertDialog =
        super.create().also { it.setOnKeyListener(callKeyEventGuardListener) }
}

fun getByteArrayCronetCallback(
    continuation: Continuation<Pair<UrlResponseInfo, ByteArray>>,
    shouldFollowRedirect: (String?) -> Boolean = { true },
): ByteArrayCronetCallback {
    return object : ByteArrayCronetCallback() {
        override fun shouldFollowRedirect(info: UrlResponseInfo?, newLocationUrl: String?): Boolean {
            return shouldFollowRedirect(newLocationUrl)
        }
    }.also {
        it.addCompletionListener(object : CronetRequestCompletionListener<ByteArray> {
            override fun onFailed(info: UrlResponseInfo?, exception: CronetException) {
                continuation.resumeWithException(exception)
            }

            override fun onCanceled(info: UrlResponseInfo?) {
                continuation.resumeWithException(IOException("The request was canceled!"))
            }

            override fun onSucceeded(info: UrlResponseInfo, body: ByteArray) {
                continuation.resume(Pair(info, body))
            }
        })
    }
}

fun isPersistedUriGranted(
    permUri: String,
    hasRead: Boolean,
    hasWrite: Boolean,
    targetUri: String?,
    needRead: Boolean = true,
    needWrite: Boolean = false
): Boolean {
    if (targetUri.isNullOrBlank()) return false
    val permNormalized = permUri.trimEnd('/')
    val targetNormalized = targetUri.trimEnd('/')
    val matches = permNormalized.equals(targetNormalized, ignoreCase = true) ||
        permNormalized.replace("%2f", "/", ignoreCase = true).replace("%2F", "/") ==
        targetNormalized.replace("%2f", "/", ignoreCase = true).replace("%2F", "/")
    return matches &&
        (!needRead || hasRead) &&
        (!needWrite || hasWrite)
}

fun Context.hasPersistedUriPermission(
    uriString: String?,
    read: Boolean = true,
    write: Boolean = false
): Boolean {
    if (uriString.isNullOrBlank()) return false
    return runCatching {
        contentResolver.persistedUriPermissions.any { perm ->
            isPersistedUriGranted(
                permUri = perm.uri.toString(),
                hasRead = perm.isReadPermission,
                hasWrite = perm.isWritePermission,
                targetUri = uriString,
                needRead = read,
                needWrite = write
            )
        }
    }.getOrDefault(false)
}

fun Context.findActivity(): Activity? {
    var ctx: Context? = this
    while (ctx is ContextWrapper) {
        if (ctx is Activity) return ctx
        ctx = ctx.baseContext
    }
    return null
}
