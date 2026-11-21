package com.xtrakick.app.ui.main

import android.app.Application
import android.app.Dialog
import android.content.ComponentName
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageInstaller
import android.os.Bundle
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.core.content.IntentCompat
import androidx.fragment.app.DialogFragment
import androidx.preference.PreferenceManager
import com.xtrakick.app.R
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.ui.common.BaseStateActivity
import com.xtrakick.app.ui.player.IvsPlayerService
import com.xtrakick.app.ui.player.MediaButtonReceiver
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AppUpdateResultReceiver
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.isSystemInstallerIntent
import com.xtrakick.app.util.observeAppUpdateResults
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.shadows.ShadowIntent

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33], application = Application::class, shadows = [MainActivityIntentTest.Android13Intent::class])
class MainActivityIntentTest {
    @Test(expected = AssertionError::class)
    fun android13GuardRejectsTheUnsafePlatformApi() {
        Intent().getParcelableExtra(MainActivity.KEY_VIDEO, Stream::class.java)
    }

    @Test fun liveNotificationWithoutVideoDoesNotCrash() {
        handleIntent(Intent(MainActivity.INTENT_LIVE_NOTIFICATION))
    }

    @Test fun downloadedVideoWithoutVideoDoesNotCrash() {
        handleIntent(Intent(MainActivity.INTENT_OPEN_DOWNLOADED_VIDEO))
    }

    @Test fun installerWithoutConfirmationIntentDoesNotCrash() {
        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION)
        val activity = Robolectric.buildActivity(InstallerObserverActivity::class.java).setup().get()
        assertNull(Shadows.shadowOf(activity).nextStartedActivity)
    }

    @Test fun installerConfirmationCanStartInAFreshProcess() {
        val component = ComponentName("com.android.packageinstaller", "com.android.packageinstaller.InstallStart")
        val confirmIntent = Intent("android.content.pm.action.CONFIRM_INSTALL").apply {
            this.component = component
        }
        val appInfo = ApplicationInfo().apply {
            packageName = component.packageName
            flags = ApplicationInfo.FLAG_SYSTEM
        }
        val activityInfo = ActivityInfo().apply {
            packageName = component.packageName
            name = component.className
            applicationInfo = appInfo
        }
        val packageInfo = PackageInfo().apply {
            packageName = component.packageName
            applicationInfo = appInfo
            activities = arrayOf(activityInfo)
        }
        Shadows.shadowOf(RuntimeEnvironment.getApplication().packageManager).apply {
            installPackage(packageInfo)
            addOrUpdateActivity(activityInfo)
        }
        val installer = RuntimeEnvironment.getApplication().packageManager.packageInstaller
        val sessionId = installer.createSession(PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL))
        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION, confirmIntent, sessionId)
        val activity = Robolectric.buildActivity(InstallerObserverActivity::class.java).setup().get()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(component, Shadows.shadowOf(activity).nextStartedActivity?.component)
        assertFalse(activity.packageManager.getReceiverInfo(ComponentName(activity, AppUpdateResultReceiver::class.java), 0).exported)

        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION, confirmIntent, sessionId)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(component, Shadows.shadowOf(activity).nextStartedActivity?.component)

        installer.abandonSession(sessionId)
        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION, confirmIntent, sessionId)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertNull(Shadows.shadowOf(activity).nextStartedActivity)

        installerResult(PackageInstaller.STATUS_FAILURE, sessionId = sessionId)
        assertNull(Shadows.shadowOf(activity).nextStartedActivity)
    }

    @Test fun isSystemInstallerIntentRejectsUriGrantsAndChooserPayloads() {
        val activity = Robolectric.buildActivity(InstallerObserverActivity::class.java).get()
        val chooserIntent = Intent(Intent.ACTION_CHOOSER).apply { `package` = "android" }
        val dataIntent = Intent("android.content.pm.action.CONFIRM_INSTALL").apply {
            `package` = "android"
            data = android.net.Uri.parse("content://com.github.andreyasadchy.xtrakick.test.diagnostic-file-provider/diagnostics/xtrakick-diagnostics.log")
        }
        val flagIntent = Intent("android.content.pm.action.CONFIRM_INSTALL").apply {
            `package` = "android"
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        org.junit.Assert.assertFalse(activity.isSystemInstallerIntent(chooserIntent))
        org.junit.Assert.assertFalse(activity.isSystemInstallerIntent(dataIntent))
        org.junit.Assert.assertFalse(activity.isSystemInstallerIntent(flagIntent))
    }

    @Test fun unexpectedParcelableTypesAreIgnored() {
        handleIntent(Intent(MainActivity.INTENT_LIVE_NOTIFICATION).putExtra(MainActivity.KEY_VIDEO, OfflineVideo()))
        handleIntent(Intent(MainActivity.INTENT_OPEN_DOWNLOADED_VIDEO).putExtra(MainActivity.KEY_VIDEO, Stream()))
        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION, Stream())
        val activity = Robolectric.buildActivity(InstallerObserverActivity::class.java).setup().get()
        assertNull(Shadows.shadowOf(activity).nextStartedActivity)
    }

    @Test fun notificationPayloadSurvivesIntentParcelRoundTrip() {
        val intent = roundTrip(Intent(MainActivity.INTENT_LIVE_NOTIFICATION).putExtra(
            MainActivity.KEY_VIDEO,
            Stream(channelId = "123", channelLogin = "channel", title = "Live title", tags = listOf("English")),
        ))

        val stream = IntentCompat.getParcelableExtra(intent, MainActivity.KEY_VIDEO, Stream::class.java)
        assertNotNull(stream)
        assertEquals("123", stream?.channelId)
        assertEquals("channel", stream?.channelLogin)
        assertEquals("Live title", stream?.title)
        assertEquals(listOf("English"), stream?.tags)
    }

    @Test fun downloadPayloadSurvivesIntentParcelRoundTrip() {
        val intent = roundTrip(Intent(MainActivity.INTENT_OPEN_DOWNLOADED_VIDEO).putExtra(
            MainActivity.KEY_VIDEO,
            OfflineVideo(url = "/storage/download.mp4", name = "Recording", lastWatchPosition = 12_000L),
        ))

        val video = IntentCompat.getParcelableExtra(intent, MainActivity.KEY_VIDEO, OfflineVideo::class.java)
        assertNotNull(video)
        assertEquals("/storage/download.mp4", video?.url)
        assertEquals("Recording", video?.name)
        assertEquals(12_000L, video?.lastWatchPosition)
    }

    @Test fun mediaButtonReceiverReadsAndroid13KeyEventsSafely() {
        val context = RuntimeEnvironment.getApplication()
        MediaButtonReceiver().onReceive(context, roundTrip(Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT, KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY),
        )))
    }

    @Test fun mediaButtonServiceReadsAndroid13KeyEventsSafely() {
        val service = Robolectric.buildService(IvsPlayerService::class.java).get()
        val result = service.onStartCommand(roundTrip(Intent(Intent.ACTION_MEDIA_BUTTON).putExtra(
            Intent.EXTRA_KEY_EVENT, KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY),
        )), 0, 1)

        assertEquals(android.app.Service.START_STICKY, result)
    }

    @Test fun callKeyEventsAreConsumedByBaseActivity() {
        val activity = Robolectric.buildActivity(TestBaseStateActivity::class.java).setup().get()
        val callDown = KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_CALL)
        val callUp = KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_CALL)
        val endCallDown = KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENDCALL)
        val endCallUp = KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENDCALL)

        assertTrue("KEYCODE_CALL down should be consumed", activity.dispatchKeyEvent(callDown))
        assertTrue("KEYCODE_CALL up should be consumed", activity.dispatchKeyEvent(callUp))
        assertTrue("KEYCODE_ENDCALL down should be consumed", activity.dispatchKeyEvent(endCallDown))
        assertTrue("KEYCODE_ENDCALL up should be consumed", activity.dispatchKeyEvent(endCallUp))
    }

    @Test fun guardedAlertDialogConsumesCallKeys() {
        val activity = Robolectric.buildActivity(TestBaseStateActivity::class.java).setup().get()
        activity.setTheme(R.style.DarkTheme)
        val dialog = activity.getAlertDialogBuilder().setTitle("call-key-guard").create()
        dialog.show()

        assertTrue("KEYCODE_CALL should be consumed by guarded dialog",
            dialog.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_CALL)))
        assertTrue("KEYCODE_ENDCALL should be consumed by guarded dialog",
            dialog.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENDCALL)))
    }

    @Test fun guardedAlertDialogConsumesCallKeysOnPlainThemeBranch() {
        val activity = Robolectric.buildActivity(TestBaseStateActivity::class.java).setup().get()
        activity.setTheme(R.style.AppCompatDarkTheme)
        PreferenceManager.getDefaultSharedPreferences(activity).edit()
            .putBoolean(AppConstants.UI_THEME_MATERIAL3, false).apply()
        val dialog = activity.getAlertDialogBuilder().setTitle("call-key-guard").create()
        dialog.show()

        assertTrue("Plain-theme dialog should consume KEYCODE_CALL",
            dialog.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_CALL)))
    }

    @Test fun dialogFragmentGuardConsumesCallKeys() {
        val activity = Robolectric.buildActivity(TestBaseStateActivity::class.java).setup().get()
        val fragment = GuardTestDialogFragment()
        fragment.show(activity.supportFragmentManager, "call-key-guard")
        activity.supportFragmentManager.executePendingTransactions()
        val dialog = fragment.dialog ?: throw AssertionError("DialogFragment dialog was not created")

        assertTrue("KEYCODE_CALL should be consumed by guarded DialogFragment",
            dialog.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_CALL)))
    }

    class GuardTestDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = Dialog(requireContext())
    }

    class TestBaseStateActivity : BaseStateActivity()

    class InstallerObserverActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            observeAppUpdateResults()
        }
    }

    private fun handleIntent(intent: Intent) {
        val activity = Robolectric.buildActivity(MainActivity::class.java).get()
        MainActivity::class.java.getDeclaredMethod("handleIntent", Intent::class.java).apply {
            isAccessible = true
        }.invoke(activity, intent)
    }

    private fun installerResult(status: Int, confirmation: Parcelable? = null, sessionId: Int = 42) {
        val result = Intent(AppUpdateResultReceiver.ACTION_INSTALL_RESULT).apply {
            putExtra(PackageInstaller.EXTRA_SESSION_ID, sessionId)
            putExtra(PackageInstaller.EXTRA_STATUS, status)
            putExtra(Intent.EXTRA_INTENT, confirmation)
        }
        AppUpdateResultReceiver().onReceive(RuntimeEnvironment.getApplication(), result)
    }

    private fun roundTrip(intent: Intent): Intent {
        val parcel = Parcel.obtain()
        return try {
            intent.writeToParcel(parcel, 0)
            parcel.setDataPosition(0)
            Intent.CREATOR.createFromParcel(parcel).apply { setExtrasClassLoader(Stream::class.java.classLoader) }
        } finally {
            parcel.recycle()
        }
    }

    @Implements(Intent::class)
    class Android13Intent : ShadowIntent() {
        // AndroidX deliberately avoids this Android 13 API (b/232589966).
        @Implementation(minSdk = 33, maxSdk = 33)
        fun <T : Parcelable> getParcelableExtra(name: String, clazz: Class<T>): T? {
            throw AssertionError("Unsafe Android 13 typed Parcelable read: $name (${clazz.name})")
        }
    }
}
