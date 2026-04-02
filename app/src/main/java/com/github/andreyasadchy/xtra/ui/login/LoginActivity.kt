package com.github.andreyasadchy.xtra.ui.login

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.lifecycleScope
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.ActivityLoginBinding
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendExchangeRequest
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendRevokeRequest
import com.github.andreyasadchy.xtra.repository.AuthRepository
import com.github.andreyasadchy.xtra.repository.KickAuthRequestException
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickOAuthConfig
import com.github.andreyasadchy.xtra.util.KickPkceHelper
import com.github.andreyasadchy.xtra.util.applyTheme
import com.github.andreyasadchy.xtra.util.prefs
import com.github.andreyasadchy.xtra.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private data class PendingKickCallback(
        val code: String,
        val verifier: String,
        val redirectUri: String,
        val configuredScopes: String,
        val backendBaseUrl: String,
    )

    @Inject
    lateinit var authRepository: AuthRepository

    private lateinit var binding: ActivityLoginBinding
    private var callbackHandled = false
    private var pendingKickCallback: PendingKickCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyTheme()

        if (intent.getBooleanExtra(C.LOGIN_LOGOUT_ONLY, false)) {
            logoutAndFinish()
            return
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            binding.root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
                leftMargin = insets.left
                rightMargin = insets.right
                bottomMargin = insets.bottom
            }
            windowInsets
        }

        binding.secondaryWebView.visibility = View.GONE
        binding.textZoom.visibility = View.GONE
        binding.codeText.visibility = View.GONE
        binding.copyCode.visibility = View.GONE
        binding.openUrl.visibility = View.GONE
        binding.next.visibility = View.GONE
        binding.havingTrouble.setOnClickListener { startKickLoginExternal() }
        binding.openUrl.setOnClickListener { startKickLoginExternal() }
        binding.next.setOnClickListener { retryPendingKickCallback() }

        configureWebView()

        if (!tryHandleKickCallback(intent.data)) {
            startKickLogin()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        tryHandleKickCallback(intent.data)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun configureWebView() {
        binding.webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
            allowFileAccess = false
            allowContentAccess = false
            javaScriptCanOpenWindowsAutomatically = false
            setSupportMultipleWindows(false)
            // Strip the "wv" (WebView) flag and "Version/4.0" from the user agent so
            // Google's OAuth service does not reject the request with disallowed_useragent.
            userAgentString = userAgentString
                .replace("; wv", "")
                .replace("Version/4.0 ", "")
        }
        binding.webView.isFocusable = true
        binding.webView.isFocusableInTouchMode = true
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return request?.url?.let(::tryHandleKickCallback) == true
            }

            @Suppress("OVERRIDE_DEPRECATION")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return !url.isNullOrBlank() && tryHandleKickCallback(Uri.parse(url))
            }
        }
    }

    private fun tryHandleKickCallback(uri: Uri?): Boolean {
        if (callbackHandled || uri == null || !isKickCallbackUri(uri)) {
            return false
        }
        callbackHandled = true

        val error = uri.getQueryParameter("error")
        if (!error.isNullOrBlank()) {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            finish()
            return true
        }

        val code = uri.getQueryParameter("code")
        val state = uri.getQueryParameter("state")
        val expectedState = tokenPrefs().getString(C.KICK_AUTH_STATE, null)
        val verifier = tokenPrefs().getString(C.KICK_PKCE_VERIFIER, null)

        if (code.isNullOrBlank() || state.isNullOrBlank() || verifier.isNullOrBlank() || state != expectedState) {
            Toast.makeText(this, R.string.connection_error, Toast.LENGTH_LONG).show()
            finish()
            return true
        }

        val clientId = KickOAuthConfig.getClientId(this)
        val backendBaseUrl = KickOAuthConfig.getBackendBaseUrl(this)
        val redirectUri = KickOAuthConfig.getRedirectUri(this)
        val configuredScopes = KickOAuthConfig.getConfiguredScopes(this)

        if (clientId.isNullOrBlank() || backendBaseUrl.isNullOrBlank()) {
            Toast.makeText(this, R.string.kick_oauth_not_configured, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
            return true
        }

        if (!KickOAuthConfig.hasRequiredScopes(configuredScopes)) {
            Toast.makeText(this, R.string.kick_oauth_scope_missing, Toast.LENGTH_LONG).show()
            finish()
            return true
        }

        pendingKickCallback = PendingKickCallback(
            code = code,
            verifier = verifier,
            redirectUri = redirectUri,
            configuredScopes = configuredScopes,
            backendBaseUrl = backendBaseUrl,
        )
        exchangePendingKickCallback(requireNotNull(pendingKickCallback))
        return true
    }

    private fun isKickCallbackUri(uri: Uri): Boolean {
        val customScheme = uri.scheme == "xtra" && uri.host == "kick-auth" && uri.path == "/callback"
        val localhostCompat = uri.scheme == "https" &&
            (uri.host == "localhost" || uri.host == "127.0.0.1") &&
            uri.path == "/callback"
        return customScheme || localhostCompat
    }

    private fun startKickLogin() {
        callbackHandled = false
        pendingKickCallback = null
        val url = prepareKickLoginUrl() ?: return
        showKickLoginInWebView(url)
    }

    private fun startKickLoginExternal() {
        callbackHandled = false
        pendingKickCallback = null
        val url = prepareKickLoginUrl() ?: return
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.kick_browser_fallback_webview, Toast.LENGTH_SHORT).show()
            showKickLoginInWebView(url)
        }
    }

    private fun prepareKickLoginUrl(): String? {
        val clientId = KickOAuthConfig.getClientId(this)
        val backendBaseUrl = KickOAuthConfig.getBackendBaseUrl(this)
        val redirectUri = KickOAuthConfig.getRedirectUri(this)
        val scopesRaw = KickOAuthConfig.getConfiguredScopes(this)
        val scopes = KickOAuthConfig.normalizeScopes(scopesRaw)

        if (clientId.isNullOrBlank() || backendBaseUrl.isNullOrBlank()) {
            Toast.makeText(this, R.string.kick_oauth_not_configured, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
            return null
        }

        if (!KickOAuthConfig.hasRequiredScopes(scopes)) {
            Toast.makeText(this, R.string.kick_oauth_scope_missing, Toast.LENGTH_LONG).show()
            finish()
            return null
        }

        val verifier = KickPkceHelper.generateCodeVerifier()
        val state = KickPkceHelper.generateState()
        val challenge = KickPkceHelper.codeChallenge(verifier)
        tokenPrefs().edit {
            putString(C.KICK_PKCE_VERIFIER, verifier)
            putString(C.KICK_AUTH_STATE, state)
        }

        prefs().edit {
            putString(C.KICK_SCOPES, scopes)
            putString(C.KICK_REDIRECT_URI, redirectUri)
        }

        val url = KickPkceHelper.buildAuthorizeUrl(
            clientId = clientId,
            redirectUri = redirectUri,
            scopes = scopes,
            state = state,
            codeChallenge = challenge,
        )

        return url
    }

    private fun showKickLoginInWebView(url: String) {
        binding.progressBar.visibility = View.GONE
        binding.webView.visibility = View.VISIBLE
        binding.secondaryWebView.visibility = View.GONE
        binding.codeText.visibility = View.GONE
        binding.copyCode.visibility = View.GONE
        binding.openUrl.visibility = View.GONE
        binding.next.visibility = View.GONE
        binding.havingTrouble.visibility = View.VISIBLE
        binding.webView.loadUrl(url)
    }

    private fun showKickExchangeLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.webView.visibility = View.GONE
        binding.secondaryWebView.visibility = View.GONE
        binding.codeText.visibility = View.GONE
        binding.copyCode.visibility = View.GONE
        binding.openUrl.visibility = View.GONE
        binding.next.visibility = View.GONE
        binding.havingTrouble.visibility = View.GONE
    }

    private fun showKickBackendOfflineError() {
        binding.progressBar.visibility = View.GONE
        binding.webView.visibility = View.GONE
        binding.secondaryWebView.visibility = View.GONE
        binding.copyCode.visibility = View.GONE
        binding.codeText.text = getString(R.string.kick_oauth_backend_unreachable)
        binding.codeText.visibility = View.VISIBLE
        binding.openUrl.text = getString(R.string.open_browser_login_recommended)
        binding.openUrl.visibility = View.VISIBLE
        binding.next.text = getString(R.string.retry)
        binding.next.visibility = View.VISIBLE
        binding.havingTrouble.visibility = View.GONE
    }

    private fun retryPendingKickCallback() {
        pendingKickCallback?.let(::exchangePendingKickCallback) ?: startKickLogin()
    }

    private fun exchangePendingKickCallback(callback: PendingKickCallback) {
        showKickExchangeLoading()
        lifecycleScope.launch {
            try {
                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                val tokenResponse = authRepository.exchangeKickAuthorizationCode(
                    networkLibrary = networkLibrary,
                    backendBaseUrl = callback.backendBaseUrl,
                    request = KickBackendExchangeRequest(
                        code = callback.code,
                        codeVerifier = callback.verifier,
                        redirectUri = callback.redirectUri,
                    ),
                )
                val accessToken = tokenResponse.accessToken?.takeIf { it.isNotBlank() }
                    ?: throw IllegalStateException("missing access token")
                val grantedScopes = tokenResponse.scope ?: callback.configuredScopes
                if (!KickOAuthConfig.hasRequiredScopes(grantedScopes)) {
                    throw IllegalStateException("missing scopes")
                }
                val refreshToken = tokenResponse.refreshToken
                val expiresAt = (System.currentTimeMillis() / 1000L) + (tokenResponse.expiresIn ?: 0L)
                val userResponse = authRepository.getKickCurrentUser(networkLibrary, accessToken)
                val user = userResponse.data.firstOrNull()
                val loginName = user?.name ?: user?.channelSlug ?: user?.id

                AuthStateHelper.clearLegacyTwitchAuth(this@LoginActivity)
                tokenPrefs().edit {
                    putString(C.KICK_ACCESS_TOKEN, accessToken)
                    putString(C.KICK_REFRESH_TOKEN, refreshToken)
                    putLong(C.KICK_ACCESS_TOKEN_EXPIRES_AT, expiresAt)
                    putString(C.KICK_TOKEN_TYPE, tokenResponse.tokenType)
                    putString(C.KICK_USER_ID, user?.id)
                    putString(C.KICK_USER_LOGIN, loginName)
                    remove(C.KICK_AUTH_STATE)
                    remove(C.KICK_PKCE_VERIFIER)
                    putString(C.USER_ID, user?.id)
                    putString(C.USERNAME, loginName)
                }
                pendingKickCallback = null
                Toast.makeText(this@LoginActivity, getString(R.string.login_success_toast, loginName ?: ""), Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
                finish()
            } catch (e: Exception) {
                when {
                    e is IllegalStateException && e.message == "missing scopes" -> {
                        Toast.makeText(this@LoginActivity, R.string.kick_oauth_scope_missing, Toast.LENGTH_LONG).show()
                        finish()
                    }
                    KickAuthRequestException.isBackendUnavailable(e) -> {
                        showKickBackendOfflineError()
                    }
                    else -> {
                        Toast.makeText(this@LoginActivity, R.string.connection_error, Toast.LENGTH_LONG).show()
                        finish()
                    }
                }
            }
        }
    }

    private fun logoutAndFinish() {
        lifecycleScope.launch {
            try {
                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                val backendBaseUrl = KickOAuthConfig.getBackendBaseUrl(this@LoginActivity)
                val accessToken = tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null)
                val refreshToken = tokenPrefs().getString(C.KICK_REFRESH_TOKEN, null)

                if (!backendBaseUrl.isNullOrBlank()) {
                    if (!accessToken.isNullOrBlank()) {
                        authRepository.revokeKickToken(
                            networkLibrary = networkLibrary,
                            backendBaseUrl = backendBaseUrl,
                            request = KickBackendRevokeRequest(
                                token = accessToken,
                                tokenTypeHint = "access_token",
                            ),
                        )
                    }
                    if (!refreshToken.isNullOrBlank()) {
                        authRepository.revokeKickToken(
                            networkLibrary = networkLibrary,
                            backendBaseUrl = backendBaseUrl,
                            request = KickBackendRevokeRequest(
                                token = refreshToken,
                                tokenTypeHint = "refresh_token",
                            ),
                        )
                    }
                }
            } catch (e: Exception) {

            }
            AuthStateHelper.clearUnexpectedLogoutNotice(this@LoginActivity)
            AuthStateHelper.clearKickAuth(this@LoginActivity)
            AuthStateHelper.clearLegacyTwitchAuth(this@LoginActivity)
            Toast.makeText(this@LoginActivity, R.string.logout_success_toast, Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK)
            finish()
        }
    }
}
