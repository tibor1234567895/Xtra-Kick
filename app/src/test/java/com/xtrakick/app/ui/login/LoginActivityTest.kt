package com.xtrakick.app.ui.login

import android.app.Application
import android.webkit.WebView
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ActivityLoginBinding
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class LoginActivityTest {
    @Test fun retryCreatesANewWebViewAfterRendererExit() {
        val activity = Robolectric.buildActivity(LoginActivity::class.java).get().apply { setTheme(R.style.DarkTheme) }
        val binding = ActivityLoginBinding.inflate(activity.layoutInflater)
        LoginActivity::class.java.getDeclaredField("binding").apply { isAccessible = true }.set(activity, binding)
        val showLogin = LoginActivity::class.java.getDeclaredMethod("showKickLoginInWebView", String::class.java)
            .apply { isAccessible = true }

        showLogin.invoke(activity, "https://kick.com/first")
        val firstView = binding.webViewContainer.getChildAt(0) as WebView
        assertTrue(firstView.webViewClient.onRenderProcessGone(firstView, null))
        assertNull(firstView.parent)
        assertEquals(0, binding.webViewContainer.childCount)

        val retryUrl = "https://kick.com/retry"
        showLogin.invoke(activity, retryUrl)
        val retryView = binding.webViewContainer.getChildAt(0) as WebView
        assertNotSame(firstView, retryView)
        assertEquals(retryUrl, Shadows.shadowOf(retryView).lastLoadedUrl)
    }
}
