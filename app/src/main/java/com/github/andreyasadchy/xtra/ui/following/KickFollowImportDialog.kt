package com.github.andreyasadchy.xtra.ui.following

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.CookieManager
import android.webkit.ConsoleMessage
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogKickFollowImportBinding
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import com.github.andreyasadchy.xtra.util.getAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@AndroidEntryPoint
class KickFollowImportDialog : DialogFragment() {

    interface CallbackListener {
        fun onKickFollowImportFinished(importedCount: Int)
    }

    @Inject
    lateinit var localFollowsChannel: LocalFollowChannelRepository

    @Inject
    lateinit var helixRepository: HelixRepository

    private var _binding: DialogKickFollowImportBinding? = null
    private val binding get() = _binding!!
    private var listener: CallbackListener? = null
    private var importCompleted = false
    private var importAttempted = false
    private var waitingForManualLogin = false
    private val logTag = "KickFollowImport"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? CallbackListener
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogKickFollowImportBinding.inflate(layoutInflater)
        seedKickAuthCookie()
        with(binding.webView) {
            CookieManager.getInstance().setAcceptCookie(true)
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = false
            settings.setSupportMultipleWindows(false)
            settings.userAgentString = settings.userAgentString
                .replace("; wv", "")
                .replace("Version/4.0 ", "")
            addJavascriptInterface(ImportBridge(), "KickFollowImportBridge")
            webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                    Log.i(logTag, "console: ${consoleMessage.message()} @${consoleMessage.sourceId()}:${consoleMessage.lineNumber()}")
                    return super.onConsoleMessage(consoleMessage)
                }
            }
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    return false
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    Log.i(logTag, "page finished: $url waitingForManualLogin=$waitingForManualLogin importAttempted=$importAttempted")
                    handleResolvedPage(url)
                }
            }
            loadUrl(KICK_HOME_URL)
        }
        return requireContext().getAlertDialogBuilder()
            .setTitle(R.string.import_kick_followed_title)
            .setView(binding.root)
            .setNegativeButton(android.R.string.cancel, null)
            .create()
    }

    override fun onDestroy() {
        _binding?.webView?.apply {
            removeJavascriptInterface("KickFollowImportBridge")
            loadUrl("about:blank")
            stopLoading()
            destroy()
        }
        _binding = null
        super.onDestroy()
    }

    private fun seedKickAuthCookie() {
        val token = AuthStateHelper.getKickBearerToken(requireContext())
            ?.removePrefix("Bearer ")
            ?.takeIf { it.isNotBlank() }
            ?: return
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setCookie("https://kick.com", "auth-token=$token; Path=/; Secure")
        CookieManager.getInstance().flush()
    }

    private fun updateStatus(message: String, loading: Boolean) {
        if (_binding == null) return
        Log.i(logTag, "status: $message")
        binding.statusText.text = message
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

    private fun getKickCookieHeader(): String? {
        return CookieManager.getInstance().getCookie("https://kick.com")?.takeIf { it.isNotBlank() }
            ?: CookieManager.getInstance().getCookie("https://web.kick.com")?.takeIf { it.isNotBlank() }
    }

    private fun loadKickPage(url: String) {
        val webView = _binding?.webView ?: return
        val currentUrl = webView.url
        if (currentUrl.equals(url, ignoreCase = true)) {
            return
        }
        webView.loadUrl(url)
    }

    private fun handleResolvedPage(url: String) {
        Log.i(logTag, "resolved page: url=$url waitingForManualLogin=$waitingForManualLogin importAttempted=$importAttempted")
        val resolution = KickFollowImportResolver.resolve(
            url = url,
            waitingForManualLogin = waitingForManualLogin,
            importAttempted = importAttempted,
            importCompleted = importCompleted,
            kickCookieHeader = getKickCookieHeader(),
        ) ?: return
        waitingForManualLogin = resolution.waitingForManualLogin
        if (waitingForManualLogin) {
            updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
        }
        resolution.navigateTo?.let { destination ->
            if (!waitingForManualLogin) {
                updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
            }
            loadKickPage(destination)
            return
        }
        if (!resolution.shouldAttemptImport) {
            return
        }
        importAttempted = true
        updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
        startDomScrapeImport()
    }

    private fun startDomScrapeImport() {
        val currentUrl = _binding?.webView?.url.orEmpty()
        if (!KickFollowImportResolver.isKickFollowingUrl(currentUrl)) {
            Log.w(logTag, "dom scrape blocked on unexpected url=$currentUrl")
            importAttempted = false
            updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
            return
        }
        Log.i(logTag, "dom scrape import starting on $currentUrl")
        updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
        _binding?.webView?.evaluateJavascript(DOM_SCRAPE_SCRIPT, null)
    }

    private fun completeImport(importedCount: Int) {
        importCompleted = true
        val messageId = if (importedCount > 0) {
            R.string.import_kick_followed_success
        } else {
            R.string.import_kick_followed_empty
        }
        if (importedCount > 0) {
            Toast.makeText(requireContext(), getString(messageId, importedCount), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), getString(messageId), Toast.LENGTH_LONG).show()
        }
        listener?.onKickFollowImportFinished(importedCount)
        dismissAllowingStateLoss()
    }

    private inner class ImportBridge {
        @JavascriptInterface
        fun onImport(payload: String?) {
            Log.i(logTag, "onImport payloadLength=${payload?.length ?: 0}")
            if (payload.isNullOrBlank()) {
                handleImportError(IllegalStateException("empty payload"))
                return
            }
            lifecycleScope.launch {
                runCatching {
                    val seen = HashSet<String>()
                    var imported = 0
                    val channels = JSONObject(payload).optJSONArray("channels") ?: return@runCatching 0
                    for (index in 0 until channels.length()) {
                        val channel = channels.optJSONObject(index) ?: continue
                        val login = channel.optString("channel_slug").takeIf { it.isNotBlank() } ?: continue
                        if (!seen.add(login)) continue
                        val name = channel.optString("user_username").takeIf { it.isNotBlank() } ?: login
                        val profilePicture = channel.optString("profile_picture").takeIf { it.isNotBlank() }
                        localFollowsChannel.upsertLocalFollow(null, login, name, profilePicture)
                        imported++
                    }
                    enrichImportedFollows(seen.toList())
                    imported
                }.onSuccess { importedCount ->
                    completeImport(importedCount)
                }.onFailure {
                    handleImportError(it)
                }
            }
        }

        @JavascriptInterface
        fun onError(message: String?) {
            Log.w(logTag, "onError: $message")
            handleImportError(IllegalStateException(message ?: "unknown import error"))
        }

        @JavascriptInterface
        fun onStatus(message: String?) {
            Log.i(logTag, "bridge status: ${message ?: ""}")
        }
    }

    private fun handleImportError(error: Throwable) {
        lifecycleScope.launch {
            val message = error.message?.take(160) ?: getString(R.string.connection_error)
            Log.w(logTag, "handleImportError: $message")
            importAttempted = false
            if (message.contains("(401)", ignoreCase = true) || message.contains(" 401 ", ignoreCase = true)) {
                waitingForManualLogin = true
                updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
                loadKickPage(KICK_FOLLOWING_URL)
            } else {
                updateStatus(getString(R.string.import_kick_followed_error, message), loading = false)
            }
        }
    }

    private suspend fun enrichImportedFollows(logins: List<String>) {
        val normalizedLogins = logins
            .map { it.trim().lowercase() }
            .filter { it.isNotBlank() }
            .distinct()
        if (normalizedLogins.isEmpty()) {
            return
        }
        val headers = KickApiHelper.getHelixHeaders(requireContext())
        if (headers[C.HEADER_TOKEN].isNullOrBlank()) {
            Log.i(logTag, "skip imported follow id enrichment: missing auth token")
            return
        }
        val networkLibrary = requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        normalizedLogins.chunked(100).forEach { chunk ->
            val response = helixRepository.getUsers(
                networkLibrary = networkLibrary,
                headers = headers,
                logins = chunk,
            )
            response.data.forEach { user ->
                val login = user.channelLogin?.takeIf { it.isNotBlank() } ?: return@forEach
                val channelId = user.channelId?.takeIf { it.isNotBlank() }
                val name = user.channelName?.takeIf { it.isNotBlank() }
                val profileImageUrl = user.profileImageUrl?.takeIf { it.isNotBlank() }
                localFollowsChannel.upsertLocalFollow(channelId, login, name, profileImageUrl)
            }
        }
        Log.i(logTag, "enriched imported follows with broadcaster ids count=${normalizedLogins.size}")
    }

    companion object {
        private val DOM_SCRAPE_SCRIPT = """
            (async function() {
              try {
                const sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
                const reserved = new Set([
                  '',
                  'following',
                  'categories',
                  'channels',
                  'search',
                  'messages',
                  'dashboard',
                  'subscriptions',
                  'rewards',
                  'drops',
                  'settings',
                  'login',
                  'signup',
                  'discover',
                  'browse'
                ]);
                const getSectionRoot = () => {
                  const nodes = Array.from(document.querySelectorAll('h1,h2,h3,h4,h5,h6,div,span,p,strong'));
                  const heading = nodes.find((node) => (node.textContent || '').trim().toLowerCase() === 'followed channels');
                  if (!heading) return document.body;
                  let current = heading;
                  for (let i = 0; i < 4 && current.parentElement; i++) {
                    current = current.parentElement;
                  }
                  return current || document.body;
                };
                const pickName = (anchor) => {
                  const textCandidates = Array.from(anchor.querySelectorAll('span,div,p,h1,h2,h3,h4,h5,h6'))
                    .map((node) => (node.textContent || '').trim())
                    .filter((text) => text.length >= 2);
                  textCandidates.push((anchor.textContent || '').trim());
                  return textCandidates
                    .filter((text) => !text.includes('\n'))
                    .sort((a, b) => b.length - a.length)[0] || null;
                };
                const collectChannels = () => {
                  const root = getSectionRoot();
                  const anchors = Array.from(root.querySelectorAll('a[href]'));
                  const seen = new Set();
                  const channels = [];
                  for (const anchor of anchors) {
                    const rawHref = anchor.getAttribute('href') || '';
                    const href = new URL(rawHref, window.location.origin);
                    if (href.origin !== window.location.origin) continue;
                    const parts = href.pathname.split('/').filter(Boolean);
                    if (parts.length !== 1) continue;
                    const slug = parts[0].trim();
                    if (!slug || reserved.has(slug.toLowerCase())) continue;
                    if (seen.has(slug.toLowerCase())) continue;
                    if (anchor.closest('nav,header,footer,[role="navigation"]')) continue;
                    const image = anchor.querySelector('img');
                    const name = pickName(anchor) || slug;
                    seen.add(slug.toLowerCase());
                    channels.push({
                      channel_slug: slug,
                      user_username: name,
                      profile_picture: image ? (image.currentSrc || image.src || '') : ''
                    });
                  }
                  return channels;
                };
                let best = [];
                let stablePasses = 0;
                for (let pass = 0; pass < 18; pass++) {
                  const channels = collectChannels();
                  if (channels.length > best.length) {
                    best = channels;
                    stablePasses = 0;
                  } else {
                    stablePasses++;
                  }
                  window.KickFollowImportBridge.onStatus('dom scrape pass ' + pass + ' count=' + channels.length);
                  const scroller = document.scrollingElement || document.documentElement || document.body;
                  if (scroller) {
                    scroller.scrollTop = scroller.scrollHeight;
                  }
                  window.scrollTo(0, document.body.scrollHeight);
                  if (stablePasses >= 3) break;
                  await sleep(600);
                }
                if (!best.length) {
                  throw new Error('No followed channels found in WebView DOM');
                }
                window.KickFollowImportBridge.onImport(JSON.stringify({ channels: best }));
              } catch (error) {
                const message = error && error.message ? error.message : String(error);
                window.KickFollowImportBridge.onError(message);
              }
            })();
        """.trimIndent()
    }
}
