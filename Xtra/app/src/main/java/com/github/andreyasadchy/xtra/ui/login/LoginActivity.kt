package com.github.andreyasadchy.xtra.ui.login

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.lifecycleScope
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.ActivityLoginBinding
import com.github.andreyasadchy.xtra.repository.AuthRepository
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickPkceHelper
import com.github.andreyasadchy.xtra.util.applyTheme
import com.github.andreyasadchy.xtra.util.prefs
import com.github.andreyasadchy.xtra.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.net.URLEncoder
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var authRepository: AuthRepository

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyTheme()
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
        binding.webView.visibility = View.GONE
        binding.secondaryWebView.visibility = View.GONE
        binding.textZoom.visibility = View.GONE
        binding.codeText.visibility = View.GONE
        binding.copyCode.visibility = View.GONE
        binding.openUrl.visibility = View.GONE
        binding.next.visibility = View.GONE
        binding.havingTrouble.visibility = View.VISIBLE
        binding.havingTrouble.setOnClickListener { startKickLogin() }

        if (intent.getBooleanExtra(C.LOGIN_LOGOUT_ONLY, false)) {
            logoutAndFinish()
            return
        }

        if (!handleKickCallback(intent)) {
            startKickLogin()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleKickCallback(intent)
    }

    private fun handleKickCallback(intent: Intent): Boolean {
        val uri = intent.data ?: return false
        val isValidCallback = uri.scheme == "https" &&
                (uri.host == "localhost" || uri.host == "127.0.0.1") &&
                uri.path == "/callback"
        if (!isValidCallback) return false

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

        val clientId = prefs().getString(C.KICK_CLIENT_ID, null)
        val clientSecret = prefs().getString(C.KICK_CLIENT_SECRET, null)
        val redirectUri = prefs().getString(C.KICK_REDIRECT_URI, "https://localhost/callback")
        if (clientId.isNullOrBlank() || redirectUri.isNullOrBlank()) {
            Toast.makeText(this, R.string.kick_oauth_not_configured, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
            return true
        }

        binding.progressBar.visibility = View.VISIBLE
        lifecycleScope.launch {
            try {
                val body = formBody(
                    "grant_type" to "authorization_code",
                    "client_id" to clientId,
                    "client_secret" to clientSecret,
                    "code" to code,
                    "redirect_uri" to redirectUri,
                    "code_verifier" to verifier,
                )
                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                val tokenResponse = authRepository.exchangeKickAuthorizationCode(networkLibrary, body)
                val accessToken = tokenResponse.accessToken?.takeIf { it.isNotBlank() }
                    ?: throw IllegalStateException("missing access token")
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
                    // Keep legacy user identity for untouched code paths.
                    putString(C.USER_ID, user?.id)
                    putString(C.USERNAME, loginName)
                }
                setResult(RESULT_OK)
            } catch (e: Exception) {
                Toast.makeText(this@LoginActivity, R.string.connection_error, Toast.LENGTH_LONG).show()
            }
            finish()
        }
        return true
    }

    private fun startKickLogin() {
        val clientId = prefs().getString(C.KICK_CLIENT_ID, null)
        val redirectUri = prefs().getString(C.KICK_REDIRECT_URI, "https://localhost/callback")
        val scopes = prefs().getString(C.KICK_SCOPES, "user:read chat:write")
        if (clientId.isNullOrBlank() || redirectUri.isNullOrBlank() || scopes.isNullOrBlank()) {
            Toast.makeText(this, R.string.kick_oauth_not_configured, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
            return
        }

        val verifier = KickPkceHelper.generateCodeVerifier()
        val state = KickPkceHelper.generateState()
        val challenge = KickPkceHelper.codeChallenge(verifier)
        tokenPrefs().edit {
            putString(C.KICK_PKCE_VERIFIER, verifier)
            putString(C.KICK_AUTH_STATE, state)
        }
        val url = KickPkceHelper.buildAuthorizeUrl(
            clientId = clientId,
            redirectUri = redirectUri,
            scopes = scopes,
            state = state,
            codeChallenge = challenge,
        )
        try {
            startActivity(Intent(Intent.ACTION_VIEW, url.toUri()))
            finish()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.no_browser_found, Toast.LENGTH_LONG).show()
        }
    }

    private fun logoutAndFinish() {
        lifecycleScope.launch {
            try {
                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                val clientId = prefs().getString(C.KICK_CLIENT_ID, null)
                val clientSecret = prefs().getString(C.KICK_CLIENT_SECRET, null)
                val accessToken = tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null)
                val refreshToken = tokenPrefs().getString(C.KICK_REFRESH_TOKEN, null)
                if (!clientId.isNullOrBlank()) {
                    if (!accessToken.isNullOrBlank()) {
                        authRepository.revokeKickToken(
                            networkLibrary,
                            formBody(
                                "client_id" to clientId,
                                "client_secret" to clientSecret,
                                "token" to accessToken,
                            ),
                        )
                    }
                    if (!refreshToken.isNullOrBlank()) {
                        authRepository.revokeKickToken(
                            networkLibrary,
                            formBody(
                                "client_id" to clientId,
                                "client_secret" to clientSecret,
                                "token" to refreshToken,
                                "token_type_hint" to "refresh_token",
                            ),
                        )
                    }
                }
            } catch (e: Exception) {

            }
            AuthStateHelper.clearKickAuth(this@LoginActivity)
            AuthStateHelper.clearLegacyTwitchAuth(this@LoginActivity)
            setResult(RESULT_OK)
            finish()
        }
    }

    private fun formBody(vararg pairs: Pair<String, String?>): String {
        return pairs.filter { !it.second.isNullOrBlank() }.joinToString("&") {
            "${URLEncoder.encode(it.first, Charsets.UTF_8.name())}=${URLEncoder.encode(it.second, Charsets.UTF_8.name())}"
        }
    }
}
