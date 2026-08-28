package com.xtrakick.app.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
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

fun Context.tokenPrefs(): SharedPreferences = getSharedPreferences("prefs2", Context.MODE_PRIVATE)

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

fun Context.getAlertDialogBuilder(): AlertDialog.Builder {
    return if (prefs().getBoolean(AppConstants.UI_THEME_MATERIAL3, true)) {
        MaterialAlertDialogBuilder(this)
    } else {
        AlertDialog.Builder(this)
    }
}

fun getByteArrayCronetCallback(continuation: Continuation<Pair<UrlResponseInfo, ByteArray>>): ByteArrayCronetCallback {
    return object : ByteArrayCronetCallback() {
        override fun shouldFollowRedirect(info: UrlResponseInfo?, newLocationUrl: String?): Boolean {
            return true
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