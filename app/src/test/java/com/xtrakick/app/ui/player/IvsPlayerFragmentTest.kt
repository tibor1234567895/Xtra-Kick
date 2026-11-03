package com.xtrakick.app.ui.player

import android.app.Application
import android.content.ContextWrapper
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.SurfaceHolder
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentHostCallback
import com.xtrakick.app.ui.main.MainActivity
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class IvsPlayerFragmentTest {

    @Test
    fun activityPipExitDoesNotDiscardStateNeededByThePlayersStopHandler() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).get()
        val fragment = IvsPlayerFragment()
        val pipState = PlayerFragment::class.java.getDeclaredField("wasInPictureInPictureMode").apply {
            isAccessible = true
            setBoolean(fragment, true)
        }
        MainActivity::class.java.getDeclaredField("playerFragment").apply {
            isAccessible = true
            set(activity, fragment)
        }

        activity.onPictureInPictureModeChanged(false, Configuration())

        assertTrue(pipState.getBoolean(fragment))
    }

    @Test
    fun genuinePipDismissalIsNotMistakenForScreenLockWhenNoUserLeaveHintWasDelivered() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).get()
        val fragment = IvsPlayerFragment()
        val host = object : FragmentHostCallback<MainActivity>(activity, Handler(Looper.getMainLooper()), 0) {
            override fun onGetHost() = activity
        }
        Fragment::class.java.getDeclaredField("mHost").apply {
            isAccessible = true
            set(fragment, host)
        }
        PlayerFragment::class.java.superclass!!.getDeclaredField("componentContext").apply {
            isAccessible = true
            set(fragment, ContextWrapper(activity))
        }
        PlayerFragment::class.java.getDeclaredField("wasInPictureInPictureMode").apply {
            isAccessible = true
            setBoolean(fragment, true)
        }
        PlayerFragment::class.java.getDeclaredField("pipEnteredAtMs").apply {
            isAccessible = true
            setLong(fragment, SystemClock.uptimeMillis())
        }
        SystemClock.sleep(1_000)
        val screenLocked = PlayerFragment::class.java.getDeclaredMethod("isScreenLockedOrOff").apply {
            isAccessible = true
        }

        assertFalse(screenLocked.invoke(fragment) as Boolean)
        val screenOff = PlayerFragment::class.java.getDeclaredField("isScreenOff").apply {
            isAccessible = true
            setBoolean(fragment, true)
        }
        assertTrue(screenLocked.invoke(fragment) as Boolean)
        screenOff.setBoolean(fragment, false)
        fragment.clearPipDismissState()
        assertTrue(screenLocked.invoke(fragment) as Boolean)
    }

    @Test
    fun closeWithoutViewStillClearsSurfaceCallbackAndCanBeRepeated() {
        val fragment = IvsPlayerFragment()
        val callbackField = IvsPlayerFragment::class.java.getDeclaredField("surfaceHolderCallback").apply {
            isAccessible = true
        }
        callbackField.set(fragment, object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) = Unit
            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit
            override fun surfaceDestroyed(holder: SurfaceHolder) = Unit
        })

        fragment.close()

        assertNull(callbackField.get(fragment))
        fragment.close()
    }
}
