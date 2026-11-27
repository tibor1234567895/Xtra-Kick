package com.xtrakick.app.ui.main

import android.app.Application
import android.app.Dialog
import android.content.ComponentName
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageInstaller
import android.content.pm.Signature
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.provider.Settings
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
import com.xtrakick.app.util.UpdateInstallException
import com.xtrakick.app.util.apkSigners
import com.xtrakick.app.util.clearPendingInstallConfirmationForTests
import com.xtrakick.app.util.clearPendingUpdateDownload
import com.xtrakick.app.util.consumePendingUpdateDownloadIfPermitted
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.isSystemInstallerIntent
import com.xtrakick.app.util.observeAppUpdateResults
import com.xtrakick.app.util.savePendingUpdateDownload
import com.xtrakick.app.util.verifyAppUpdate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertFalse
import org.junit.Assert.assertThrows
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
import java.io.File

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
        // Simulate a fresh process where only the persisted URI backup exists.
        clearPendingInstallConfirmationForTests()
        val activity = Robolectric.buildActivity(InstallerObserverActivity::class.java).setup().get()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertEquals(component, Shadows.shadowOf(activity).nextStartedActivity?.component)
        assertFalse(activity.packageManager.getReceiverInfo(ComponentName(activity, AppUpdateResultReceiver::class.java), 0).exported)

        val confirmWithParcelable = Intent(confirmIntent).putExtra("oem_bundle", Bundle().apply { putString("k", "v") })
        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION, confirmWithParcelable, sessionId)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val startedInProcess = Shadows.shadowOf(activity).nextStartedActivity
        assertEquals(component, startedInProcess?.component)
        assertEquals("v", startedInProcess?.getBundleExtra("oem_bundle")?.getString("k"))

        installer.abandonSession(sessionId)
        installerResult(PackageInstaller.STATUS_PENDING_USER_ACTION, confirmIntent, sessionId)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        assertNull(Shadows.shadowOf(activity).nextStartedActivity)

        installerResult(PackageInstaller.STATUS_FAILURE, sessionId = sessionId)
        assertNull(Shadows.shadowOf(activity).nextStartedActivity)
    }

    @Test fun apkSignersFallsBackToLegacySignaturesWhenSigningInfoIsNullOnAndroid13() {
        val signature = Signature(ByteArray(32) { it.toByte() })
        @Suppress("DEPRECATION")
        val archiveInfo = PackageInfo().apply {
            signingInfo = null
            signatures = arrayOf(signature)
        }

        assertEquals(setOf(signature), apkSigners(archiveInfo))
    }

    @Test
    @Config(sdk = [26, 27, 28, 29, 30, 31, 32, 33])
    @Suppress("DEPRECATION")
    fun updateArchiveVerificationRequiresNewerVersionAndMatchingSignerOnOlderAndroid() {
        val context = RuntimeEnvironment.getApplication()
        val manager = Shadows.shadowOf(context.packageManager)
        val signature = Signature(byteArrayOf(1, 2, 3))
        val installed = manager.getInternalMutablePackageInfo(context.packageName).apply {
            versionCode = 10
            signatures = arrayOf(signature)
        }
        val archive = File.createTempFile("update-verification", ".apk", context.cacheDir)
        try {
            val candidate = PackageInfo().apply {
                packageName = installed.packageName
                versionCode = 11
                signatures = arrayOf(signature)
            }
            manager.setPackageArchiveInfo(archive.absolutePath, candidate)
            verifyAppUpdate(context, archive)

            candidate.signatures = arrayOf(Signature(byteArrayOf(4, 5, 6)))
            manager.setPackageArchiveInfo(archive.absolutePath, candidate)
            val wrongSigner = assertThrows(UpdateInstallException::class.java) { verifyAppUpdate(context, archive) }
            assertTrue(wrongSigner.message.orEmpty().contains("signing certificate"))

            candidate.signatures = arrayOf(signature)
            candidate.versionCode = 10
            manager.setPackageArchiveInfo(archive.absolutePath, candidate)
            val sameVersion = assertThrows(UpdateInstallException::class.java) { verifyAppUpdate(context, archive) }
            assertTrue(sameVersion.message.orEmpty().contains("not newer"))
        } finally {
            archive.delete()
        }
    }

    @Test fun isSystemInstallerIntentAllowsUnknownSourcesOnlyForOwnPackage() {
        val activity = Robolectric.buildActivity(InstallerObserverActivity::class.java).get()
        val settingsComponent = ComponentName("com.android.settings", "com.android.settings.Settings\$ManageExternalSourcesActivity")
        val appInfo = ApplicationInfo().apply {
            packageName = settingsComponent.packageName
            flags = ApplicationInfo.FLAG_SYSTEM
        }
        val activityInfo = ActivityInfo().apply {
            packageName = settingsComponent.packageName
            name = settingsComponent.className
            applicationInfo = appInfo
        }
        val packageInfo = PackageInfo().apply {
            packageName = settingsComponent.packageName
            applicationInfo = appInfo
            activities = arrayOf(activityInfo)
        }
        Shadows.shadowOf(RuntimeEnvironment.getApplication().packageManager).apply {
            installPackage(packageInfo)
            addOrUpdateActivity(activityInfo)
        }

        val ownUnknownSources = Intent(
            Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
            Uri.fromParts("package", activity.packageName, null)
        ).apply { component = settingsComponent }
        val foreignUnknownSources = Intent(
            Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
            Uri.fromParts("package", "com.example.other", null)
        ).apply { component = settingsComponent }

        assertTrue(activity.isSystemInstallerIntent(ownUnknownSources))
        assertFalse(activity.isSystemInstallerIntent(foreignUnknownSources))
    }

    @Test fun pendingUpdateDownloadSurvivesProcessDeathWhenPermittedAndExpiresAfterTtl() {
        val context = RuntimeEnvironment.getApplication()
        val trustedUrl = "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/app-release.apk"
        context.clearPendingUpdateDownload()

        // Untrusted URLs are never stored.
        context.savePendingUpdateDownload("https://evil.example.com/app.apk", 123L, now = 1_000L)
        Shadows.shadowOf(context.packageManager).setCanRequestPackageInstalls(true)
        assertNull(context.consumePendingUpdateDownloadIfPermitted(now = 2_000L))

        // Without install permission, pending download stays stored until granted or cleared.
        Shadows.shadowOf(context.packageManager).setCanRequestPackageInstalls(false)
        context.savePendingUpdateDownload(trustedUrl, 13_872_636L, now = 1_000L)
        assertNull(context.consumePendingUpdateDownloadIfPermitted(now = 2_000L))

        // Once permission is granted in a recreated process, pending download is consumed once.
        Shadows.shadowOf(context.packageManager).setCanRequestPackageInstalls(true)
        assertEquals(trustedUrl to 13_872_636L, context.consumePendingUpdateDownloadIfPermitted(now = 2_000L))
        assertNull(context.consumePendingUpdateDownloadIfPermitted(now = 3_000L))

        // Expired entries past TTL are cleared and ignored.
        context.savePendingUpdateDownload(trustedUrl, 13_872_636L, now = 1_000L)
        assertNull(context.consumePendingUpdateDownloadIfPermitted(now = 1_000L + 11 * 60 * 1000L))
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
