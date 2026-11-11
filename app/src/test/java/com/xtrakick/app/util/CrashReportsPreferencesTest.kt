package com.xtrakick.app.util

import android.app.Application
import androidx.preference.PreferenceManager
import com.xtrakick.app.R
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.File

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class CrashReportsPreferencesTest {
    private val context: Application get() = RuntimeEnvironment.getApplication()
    private val dir: File get() = File(context.noBackupFilesDir, "crash-reports")

    @Before
    fun resetPreferences() {
        context.prefs().edit().clear().commit()
        CrashReports.clear(context)
        CrashReports.enqueue(dir, CrashReports.report(RuntimeException(), "1.0", 1, 35))
    }

    @Test
    fun reportingDefaultsOnBeforeAndAfterOpeningSettings() {
        CrashReports.maybeSend(context, 0)
        assertTrue(CrashReports.pendingFiles(dir).isNotEmpty())
        PreferenceManager.setDefaultValues(context, R.xml.advanced_preferences, true)
        assertTrue(context.prefs().getBoolean(AppConstants.CRASH_REPORTS_ENABLED, false))
        CrashReports.maybeSend(context, 0)
        assertTrue(CrashReports.pendingFiles(dir).isNotEmpty())
    }

    @Test
    fun settingsDoNotOverrideAnExistingCrashReportingOptOut() {
        context.prefs().edit().putBoolean(AppConstants.CRASH_REPORTS_ENABLED, false).commit()
        PreferenceManager.setDefaultValues(context, R.xml.advanced_preferences, true)
        assertFalse(context.prefs().getBoolean(AppConstants.CRASH_REPORTS_ENABLED, true))
        CrashReports.maybeSend(context, 0)
        assertTrue(CrashReports.pendingFiles(dir).isEmpty())
    }

    @Test
    fun settingsDoNotOverrideTheUsageStatisticsOptOut() {
        context.prefs().edit().putBoolean(AppConstants.USAGE_STATS_ENABLED, false).commit()
        PreferenceManager.setDefaultValues(context, R.xml.advanced_preferences, true)
        assertFalse(context.prefs().getBoolean(AppConstants.USAGE_STATS_ENABLED, true))
        CrashReports.maybeSend(context, 0)
        assertTrue(CrashReports.pendingFiles(dir).isEmpty())
    }
}
