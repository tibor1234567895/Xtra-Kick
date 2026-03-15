package com.github.andreyasadchy.xtra.ui.following

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.CookieManager
import android.webkit.ConsoleMessage
import android.webkit.ValueCallback
import android.webkit.WebResourceRequest
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogKickFollowImportBinding
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.util.AuthStateHelper
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
                    resolveActualPageUrl(view) { actualUrl ->
                        handleResolvedPage(view, callbackUrl = url, actualUrl = actualUrl ?: url)
                    }
                }
            }
            loadUrl("https://kick.com/following")
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

    private fun isKickLoginUrl(url: String): Boolean {
        return url.startsWith("https://kick.com/login", ignoreCase = true) ||
            url.startsWith("https://id.kick.com/", ignoreCase = true)
    }

    private fun shouldAttemptImport(url: String): Boolean {
        return url.startsWith("https://kick.com", ignoreCase = true) && !isKickLoginUrl(url)
    }

    private fun handleResolvedPage(view: WebView, callbackUrl: String, actualUrl: String) {
        Log.i(logTag, "resolved page: callback=$callbackUrl actual=$actualUrl waitingForManualLogin=$waitingForManualLogin importAttempted=$importAttempted")
        if (waitingForManualLogin && isKickLoginUrl(actualUrl)) {
            updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
            return
        }
        if (waitingForManualLogin && actualUrl.startsWith("https://kick.com", ignoreCase = true) && !isKickLoginUrl(actualUrl)) {
            waitingForManualLogin = false
            importAttempted = false
            if (!actualUrl.startsWith("https://kick.com/following", ignoreCase = true)) {
                view.loadUrl("https://kick.com/following")
                return
            }
        }
        if (!importCompleted && !importAttempted && shouldAttemptImport(actualUrl)) {
            importAttempted = true
            updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
            Log.i(logTag, "starting in-page import for actual=$actualUrl")
            view.evaluateJavascript(IMPORT_SCRIPT, null)
        }
    }

    private fun resolveActualPageUrl(webView: WebView, callback: (String?) -> Unit) {
        webView.evaluateJavascript(
            "(function(){try{return window.location.href || document.location.href || ''}catch(e){return ''}})();",
            ValueCallback { rawValue ->
                callback(rawValue?.trim()?.removeSurrounding("\"")?.takeIf { it.isNotBlank() })
            }
        )
    }

    private inner class ImportBridge {
        @android.webkit.JavascriptInterface
        fun onImport(payload: String?) {
            Log.i(logTag, "onImport payloadLength=${payload?.length ?: 0}")
            if (payload.isNullOrBlank()) {
                onError("empty payload")
                return
            }
            lifecycleScope.launch {
                val importedCount = runCatching {
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
                    imported
                }.getOrElse {
                    handleImportError(it)
                    return@launch
                }
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
        }

        @android.webkit.JavascriptInterface
        fun onError(message: String?) {
            Log.w(logTag, "onError: $message")
            handleImportError(IllegalStateException(message ?: "unknown import error"))
        }

        @android.webkit.JavascriptInterface
        fun onStatus(message: String?) {
            Log.i(logTag, "bridge status: ${message ?: ""}")
        }
    }

    private fun handleImportError(error: Throwable) {
        lifecycleScope.launch {
            importAttempted = false
            val message = error.message?.take(160) ?: getString(R.string.connection_error)
            Log.w(logTag, "handleImportError: $message")
            if (message.contains("(401)", ignoreCase = true) || message.contains(" 401 ", ignoreCase = true)) {
                waitingForManualLogin = true
                updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
                _binding?.webView?.loadUrl("https://kick.com/login")
            } else {
                updateStatus(getString(R.string.import_kick_followed_error, message), loading = false)
            }
        }
    }

    companion object {
        private val IMPORT_SCRIPT = """
            (async function() {
              const RESERVED = new Set([
                'following', 'followed', 'login', 'signup', 'register', 'search', 'categories',
                'category', 'videos', 'video', 'clips', 'clip', 'subscriptions', 'creator-dashboard',
                'drops', 'settings', 'team', 'teams', 'tags', 'directory', 'api'
              ]);

              function sleep(ms) {
                return new Promise(resolve => setTimeout(resolve, ms));
              }

              function getCookie(name) {
                const prefix = name + '=';
                const parts = document.cookie ? document.cookie.split('; ') : [];
                for (const part of parts) {
                  if (part.startsWith(prefix)) {
                    return decodeURIComponent(part.substring(prefix.length));
                  }
                }
                return null;
              }

              function normalizeSlug(href) {
                try {
                  const url = new URL(href, window.location.origin);
                  if (url.origin !== window.location.origin) return null;
                  const parts = url.pathname.split('/').filter(Boolean);
                  if (parts.length !== 1) return null;
                  const slug = parts[0].trim();
                  if (!slug) return null;
                  if (RESERVED.has(slug.toLowerCase())) return null;
                  return slug;
                } catch (e) {
                  return null;
                }
              }

              function pickDisplayName(anchor, slug) {
                const candidates = Array.from(anchor.querySelectorAll('h1,h2,h3,h4,strong,b,span,div,p'))
                  .map(node => (node.textContent || '').trim().replace(/\s+/g, ' '))
                  .filter(Boolean)
                  .filter(text =>
                    text.length >= 2 &&
                    !/watching|live|hours?|minutes?|views?/i.test(text) &&
                    text.toLowerCase() !== slug.toLowerCase()
                  );
                return candidates[0] || slug;
              }

              function scrapeChannelsFromDom() {
                const map = new Map();
                const anchors = Array.from(document.querySelectorAll('a[href]'));
                for (const anchor of anchors) {
                  const slug = normalizeSlug(anchor.href);
                  if (!slug) continue;
                  const text = (anchor.textContent || '').trim().replace(/\s+/g, ' ');
                  const image = anchor.querySelector('img');
                  if (!image && text.length < 2) continue;
                  const profilePicture = image && image.src ? image.src : null;
                  const existing = map.get(slug);
                  if (existing) continue;
                  map.set(slug, {
                    channel_slug: slug,
                    user_username: pickDisplayName(anchor, slug),
                    profile_picture: profilePicture
                  });
                }
                return Array.from(map.values());
              }

              async function clickChannelsTabIfPresent() {
                const candidates = Array.from(document.querySelectorAll('button, a, [role="tab"]'));
                const tab = candidates.find(node => {
                  const text = (node.textContent || '').trim().replace(/\s+/g, ' ');
                  return /^channels$/i.test(text);
                });
                if (tab) {
                  window.KickFollowImportBridge.onStatus('clicking Channels tab');
                  tab.click();
                  await sleep(1500);
                }
              }

              async function scrapeWithScroll() {
                await clickChannelsTabIfPresent();
                let best = [];
                let stableIterations = 0;
                for (let i = 0; i < 12; i++) {
                  const items = scrapeChannelsFromDom();
                  window.KickFollowImportBridge.onStatus('dom scrape count=' + items.length + ' step=' + i);
                  if (items.length > best.length) {
                    best = items;
                    stableIterations = 0;
                  } else {
                    stableIterations++;
                  }
                  window.scrollTo(0, document.body.scrollHeight);
                  await sleep(1000);
                  if (stableIterations >= 2) break;
                }
                return best;
              }

              try {
                window.KickFollowImportBridge.onStatus('starting import on ' + window.location.href);
                const authToken = getCookie('auth-token');
                window.KickFollowImportBridge.onStatus('auth-token cookie present=' + (!!authToken));
                const results = [];
                let cursor = null;
                for (let page = 0; page < 200; page++) {
                  const url = new URL('/api/v2/channels/followed', window.location.origin);
                  if (cursor !== null && cursor !== undefined && String(cursor).length > 0) {
                    url.searchParams.set('cursor', String(cursor));
                  }
                  window.KickFollowImportBridge.onStatus('fetch ' + url.toString());
                  const headers = { 'Accept': 'application/json' };
                  if (authToken) {
                    headers['Authorization'] = 'Bearer ' + authToken;
                  }
                  const response = await fetch(url.toString(), {
                    credentials: 'include',
                    headers
                  });
                  if (!response.ok) {
                    if (response.status === 401 && page === 0) {
                      window.KickFollowImportBridge.onStatus('api blocked with 401, falling back to DOM scrape');
                      const domChannels = await scrapeWithScroll();
                      if (domChannels.length > 0) {
                        window.KickFollowImportBridge.onImport(JSON.stringify({ channels: domChannels }));
                        return;
                      }
                    }
                    throw new Error('HTTP ' + response.status + ' for ' + url.pathname + url.search);
                  }
                  const payload = await response.json();
                  const channels = Array.isArray(payload.channels) ? payload.channels : [];
                  results.push(...channels);
                  const nextCursor = payload.nextCursor;
                  if (nextCursor === null || nextCursor === undefined || nextCursor === '' || String(nextCursor) === String(cursor) || channels.length === 0) {
                    break;
                  }
                  cursor = nextCursor;
                }
                window.KickFollowImportBridge.onImport(JSON.stringify({ channels: results }));
              } catch (error) {
                const message = error && error.message ? error.message : String(error);
                window.KickFollowImportBridge.onError(message);
              }
            })();
        """.trimIndent()
    }
}
