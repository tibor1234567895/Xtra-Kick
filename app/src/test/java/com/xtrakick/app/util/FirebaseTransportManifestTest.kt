package com.xtrakick.app.util

import android.app.Application
import android.content.ComponentName
import android.content.pm.PackageManager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class, sdk = [31])
@RunWith(RobolectricTestRunner::class)
class FirebaseTransportManifestTest {
    @Test
    fun legacyAlarmReceiverIsAbsentAndJobSchedulerRemainsAvailable() {
        val context = RuntimeEnvironment.getApplication()
        val packageName = "com.google.android.datatransport.runtime.scheduling.jobscheduling"

        assertThrows(PackageManager.NameNotFoundException::class.java) {
            context.packageManager.getReceiverInfo(
                ComponentName(context, "$packageName.AlarmManagerSchedulerBroadcastReceiver"), 0,
            )
        }
        val service = context.packageManager.getServiceInfo(
            ComponentName(context, "$packageName.JobInfoSchedulerService"), 0,
        )
        assertEquals("android.permission.BIND_JOB_SERVICE", service.permission)
    }
}
