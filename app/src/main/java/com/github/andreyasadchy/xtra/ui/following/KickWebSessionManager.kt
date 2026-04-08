package com.github.andreyasadchy.xtra.ui.following

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.webkit.CookieManager
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KickWebSessionManager @Inject constructor(
    @param:ApplicationContext private val context: Context,
) {

    private val logTag = "KickWebSessionMgr"

    private fun isDebugLoggingEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(C.DEBUG_KICK_FOLLOW_IMPORT_LOGS, false)
    }

    private fun debugLogI(message: String) {
        if (isDebugLoggingEnabled()) {
            Log.i(logTag, message)
        }
    }

    private fun debugLogW(message: String) {
        if (isDebugLoggingEnabled()) {
            Log.w(logTag, message)
        }
    }

    fun seedKickAuthCookie(): Boolean {
        val token = AuthStateHelper.getKickBearerToken(context)
            ?.removePrefix("Bearer ")
            ?.takeIf { it.isNotBlank() }
            ?: run {
                debugLogW("seedKickAuthCookie: no stored Kick token")
                return false
            }
        debugLogI("seedKickAuthCookie: seeding auth-token cookie")
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setCookie("https://kick.com", "auth-token=$token; Path=/; Secure")
        CookieManager.getInstance().flush()
        val seeded = CookieManager.getInstance().getCookie("https://kick.com")
        debugLogI("seedKickAuthCookie: cookieHeaderPresent=${!seeded.isNullOrBlank()}")
        return true
    }

    fun getKickCookieHeader(): String? {
        val kickCookie = CookieManager.getInstance().getCookie("https://kick.com")?.takeIf { it.isNotBlank() }
        if (!kickCookie.isNullOrBlank()) {
            debugLogI("getKickCookieHeader: using kick.com cookies")
            return kickCookie
        }
        val webCookie = CookieManager.getInstance().getCookie("https://web.kick.com")?.takeIf { it.isNotBlank() }
        debugLogI("getKickCookieHeader: using web.kick.com cookies=${!webCookie.isNullOrBlank()}")
        return webCookie
    }

    fun hasKickWebsiteSession(): Boolean {
        val hasSession = KickFollowImportResolver.hasKickWebsiteSession(getKickCookieHeader(), isDebugLoggingEnabled())
        debugLogI("hasKickWebsiteSession=$hasSession")
        return hasSession
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun configureImportWebView(webView: WebView) {
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
            allowFileAccess = false
            allowContentAccess = false
            javaScriptCanOpenWindowsAutomatically = false
            setSupportMultipleWindows(false)
            mediaPlaybackRequiresUserGesture = true
            useWideViewPort = true
            loadWithOverviewMode = false
            builtInZoomControls = false
            displayZoomControls = false
            textZoom = 100
            userAgentString = userAgentString
                .replace("; wv", "")
                .replace("Version/4.0 ", "")
        }
        if (webView.layoutParams == null) {
            webView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
        }
        webView.setBackgroundColor(Color.WHITE)
        webView.isVerticalScrollBarEnabled = true
        webView.isFocusable = true
        webView.isFocusableInTouchMode = true
        webView.descendantFocusability = ViewGroup.FOCUS_AFTER_DESCENDANTS
        webView.requestFocus(View.FOCUS_DOWN)
        webView.requestFocusFromTouch()
        webView.setPadding(0, 0, 0, 0)
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webView.setInitialScale(0)
        webView.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_UP) {
                view.requestFocusFromTouch()
            }
            false
        }
        debugLogI(
            "configureImportWebView: js=${webView.settings.javaScriptEnabled} dom=${webView.settings.domStorageEnabled} layout=${webView.layoutParams.width}x${webView.layoutParams.height}",
        )
    }
}
