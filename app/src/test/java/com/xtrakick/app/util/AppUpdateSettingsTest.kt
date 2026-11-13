package com.xtrakick.app.util

import android.app.Application
import android.view.ContextThemeWrapper
import androidx.preference.ListPreference
import androidx.preference.PreferenceManager
import com.xtrakick.app.R
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class)
class AppUpdateSettingsTest {
    private val context = ContextThemeWrapper(RuntimeEnvironment.getApplication(), R.style.BaseDarkTheme)

    @Before
    @After
    fun clearPreferences() {
        context.prefs().edit().clear().commit()
    }

    @Test
    fun openingUpdateSettingsPersistsDailyDefault() {
        val manager = PreferenceManager(context)
        val screen = manager.inflateFromResource(context, R.xml.update_preferences, null)
        assertEquals("1", screen.findPreference<ListPreference>(AppConstants.UPDATE_CHECK_FREQUENCY)?.value)
        assertEquals("1", context.prefs().getString(AppConstants.UPDATE_CHECK_FREQUENCY, null))
    }

    @Test
    fun openingUpdateSettingsPreservesAnExplicitFrequency() {
        context.prefs().edit().putString(AppConstants.UPDATE_CHECK_FREQUENCY, "7").commit()
        val manager = PreferenceManager(context)
        val screen = manager.inflateFromResource(context, R.xml.update_preferences, null)
        assertEquals("7", screen.findPreference<ListPreference>(AppConstants.UPDATE_CHECK_FREQUENCY)?.value)
    }
}
