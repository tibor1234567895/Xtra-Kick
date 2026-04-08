package com.github.andreyasadchy.xtra.ui.following

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.webkit.ConsoleMessage
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebChromeClient
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogKickFollowImportBinding
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayInputStream
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class KickFollowImportDialog : DialogFragment() {

    interface CallbackListener {
        fun onKickFollowImportFinished(importedCount: Int)
    }

    @Inject
    lateinit var importer: KickFollowImporter

    @Inject
    lateinit var webSessionManager: KickWebSessionManager

    private var _binding: DialogKickFollowImportBinding? = null
    private val binding get() = _binding!!
    private var listener: CallbackListener? = null
    private var importCompleted = false
    private var importAttempted = false
    private var waitingForManualLogin = false
    private var awaitingFollowingPage = false
    private var manualLoginFallbackTriggered = false
    private var lastManualHelperInjectAtMs = 0L
    private val logTag = "KickFollowImport"

    private fun isDebugLoggingEnabled(): Boolean {
        return BuildConfig.DEBUG && requireContext().prefs().getBoolean(C.DEBUG_KICK_FOLLOW_IMPORT_LOGS, false)
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? CallbackListener
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogKickFollowImportBinding.inflate(layoutInflater)
        debugLogI("onCreateDialog: starting import flow")
        val tokenSeeded = webSessionManager.seedKickAuthCookie()
        debugLogI("onCreateDialog: seedKickAuthCookie=$tokenSeeded")
        binding.cancelButton.setOnClickListener {
            dismissAllowingStateLoss()
        }
        with(binding.webView) {
            webSessionManager.configureImportWebView(this)
            addJavascriptInterface(ImportBridge(), "KickFollowImportBridge")
            webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                  debugLogI("console: ${consoleMessage.message()} @${consoleMessage.sourceId()}:${consoleMessage.lineNumber()}")
                    return super.onConsoleMessage(consoleMessage)
                }
            }
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    return false
                }

                override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
                val requestUrl = request?.url?.toString().orEmpty()
                if (shouldBlockKickMediaRequest(requestUrl)) {
                    debugLogI("blocked media request in import webview: $requestUrl")
                    return WebResourceResponse("text/plain", "utf-8", ByteArrayInputStream(ByteArray(0)))
                }
                return super.shouldInterceptRequest(view, request)
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                val activeUrl = view.url.orEmpty()
                debugLogI("page finished: callbackUrl=$url activeUrl=$activeUrl waitingForManualLogin=$waitingForManualLogin importAttempted=$importAttempted bindingActive=${_binding != null}")
                logRenderedPageState(view, url)
                if (activeUrl.isNotBlank() && !activeUrl.equals(url, ignoreCase = true)) {
                  debugLogI("skip stale onPageFinished callback: callbackUrl=$url activeUrl=$activeUrl")
                  return
                }
                handleResolvedPage(if (activeUrl.isNotBlank()) activeUrl else url)
                }
            }
            val hasExistingSession = webSessionManager.hasKickWebsiteSession()
              debugLogI("onCreateDialog: hasKickWebsiteSession=$hasExistingSession")
            updateStatus(
                if (hasExistingSession) {
                    getString(R.string.import_kick_followed_status_reusing)
                } else {
                    getString(R.string.import_kick_followed_status_checking)
                },
                loading = true,
            )
            awaitingFollowingPage = true
            loadUrl(KICK_FOLLOWING_URL)
        }
        return Dialog(requireContext()).apply {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            setContentView(binding.root)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.let { window ->
            val metrics = resources.displayMetrics
            window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
            window.setLayout(
              WindowManager.LayoutParams.MATCH_PARENT,
              WindowManager.LayoutParams.MATCH_PARENT,
            )
            window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
            )
            debugLogI("onStart: dialog layout=${metrics.widthPixels}x${metrics.heightPixels}")
            binding.webView.post {
                debugLogI("onStart: webView size measured=${binding.webView.measuredWidth}x${binding.webView.measuredHeight} layout=${binding.webView.width}x${binding.webView.height}",
                )
            }
        }
    }

    override fun onDestroy() {
        debugLogI("onDestroy: tearing down import dialog")
        _binding?.webView?.apply {
            removeJavascriptInterface("KickFollowImportBridge")
            loadUrl("about:blank")
            stopLoading()
            destroy()
        }
        _binding = null
        super.onDestroy()
    }

    private fun updateStatus(message: String, loading: Boolean) {
        if (_binding == null) return
        debugLogI("status: $message")
        binding.statusText.text = message
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

    private fun loadKickPage(url: String) {
        val webView = _binding?.webView ?: return
        awaitingFollowingPage = KickFollowImportResolver.isKickFollowingUrl(url)
        val currentUrl = webView.url
        if (currentUrl.equals(url, ignoreCase = true)) {
            debugLogI("loadKickPage: forcing reload for $url")
        } else {
            debugLogI("loadKickPage: navigating from=${currentUrl ?: "<empty>"} to=$url")
        }
        webView.stopLoading()
        webView.loadUrl(url)
    }

    private fun logRenderedPageState(webView: WebView, pageFinishedUrl: String) {
      webView.evaluateJavascript(
        """
        (function() {
          try {
          var active = document.activeElement;
          var activeTag = active ? active.tagName : '';
          var activeId = active ? (active.id || '') : '';
          var bodyText = (document.body && document.body.innerText ? document.body.innerText : '').trim();
          return JSON.stringify({
            href: location.href,
            title: document.title,
            readyState: document.readyState,
            visibility: document.visibilityState,
            bodyLength: bodyText.length,
            bodySnippet: bodyText.substring(0, 120),
            activeTag: activeTag,
            activeId: activeId,
            pageFinishedUrl: '$pageFinishedUrl'
          });
          } catch (e) {
          return 'render_state_error:' + (e && e.message ? e.message : String(e));
          }
        })();
        """.trimIndent(),
      ) { result ->
        debugLogI("render-state=$result")
      }
    }

    private fun handleResolvedPage(url: String) {
        debugLogI("resolved page: url=$url waitingForManualLogin=$waitingForManualLogin importAttempted=$importAttempted")
        if (KickFollowImportResolver.isKickFollowingUrl(url)) {
            awaitingFollowingPage = false
          manualLoginFallbackTriggered = false
        } else if (
            awaitingFollowingPage &&
            !waitingForManualLogin &&
            !importAttempted &&
            (KickFollowImportResolver.isKickHomeUrl(url) || KickFollowImportResolver.isKickLoginUrl(url))
        ) {
          debugLogI("following page redirected to $url, requiring manual website login")
          awaitingFollowingPage = false
          waitingForManualLogin = true
          updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
          if (!KickFollowImportResolver.isKickHomeUrl(url)) {
            debugLogI("manual login mode started on non-home url=$url, navigating to home for login button")
            loadKickPage(KICK_HOME_URL)
          }
          prepareManualLoginUi(url)
            return
        }
        if (waitingForManualLogin && !KickFollowImportResolver.isKickFollowingUrl(url)) {
            handleManualLoginProgress(url, reason = "resolved:$url", allowFallbackToLoginPage = false)
            return
        }
        val resolution = KickFollowImportResolver.resolve(
            url = url,
            waitingForManualLogin = waitingForManualLogin,
            importAttempted = importAttempted,
            importCompleted = importCompleted,
            kickCookieHeader = webSessionManager.getKickCookieHeader(),
          debugLogging = isDebugLoggingEnabled(),
        ) ?: return
        waitingForManualLogin = resolution.waitingForManualLogin
        if (waitingForManualLogin) {
            updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
            prepareManualLoginUi(url)
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
            debugLogW("dom scrape blocked on unexpected url=$currentUrl")
            importAttempted = false
            updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
            return
        }
        debugLogI("dom scrape import starting on $currentUrl")
        updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
        _binding?.webView?.evaluateJavascript(DOM_SCRAPE_SCRIPT) { result ->
          debugLogI("DOM_SCRAPE_SCRIPT result=${result?.take(200)}")
        }
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
            debugLogI("onImport payloadLength=${payload?.length ?: 0}")
            if (payload.isNullOrBlank()) {
                handleImportError(IllegalStateException("empty payload"))
                return
            }
            lifecycleScope.launch {
                runCatching {
                    importer.importPayload(payload)
                }.onSuccess { importedCount ->
                    completeImport(importedCount)
                }.onFailure {
                    handleImportError(it)
                }
            }
        }

        @JavascriptInterface
        fun onError(message: String?) {
            debugLogW("onError: $message")
            handleImportError(IllegalStateException(message ?: "unknown import error"))
        }

        @JavascriptInterface
        fun onStatus(message: String?) {
          val status = message ?: ""
          debugLogI("bridge status: $status")
          val normalized = status.lowercase()
          if (
            waitingForManualLogin &&
            normalized.contains("manual login input not found")
          ) {
            val currentUrl = _binding?.webView?.url.orEmpty()
            handleManualLoginProgress(
              currentUrl,
              reason = "status:$normalized",
              allowFallbackToLoginPage = true,
            )
          }
        }
    }

      private fun handleManualLoginProgress(
        currentUrl: String,
        reason: String,
        allowFallbackToLoginPage: Boolean,
      ) {
        val webView = _binding?.webView ?: return
        if (!waitingForManualLogin || importAttempted || importCompleted) {
          return
        }
        webView.evaluateJavascript(MANUAL_LOGIN_STATE_SCRIPT) { rawState ->
          if (_binding == null || !waitingForManualLogin || importAttempted || importCompleted) {
            return@evaluateJavascript
          }
          val state = rawState
            ?.trim()
            ?.trim('"')
            ?.replace("\\\\\"", "\"")
            .orEmpty()
          debugLogI("manual-login-probe[$reason]: state=$state url=$currentUrl")
          if (state.contains("LIKELY_LOGGED_IN", ignoreCase = true)) {
            waitingForManualLogin = false
            awaitingFollowingPage = true
            manualLoginFallbackTriggered = false
            updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
            debugLogI("manual-login-probe[$reason]: detected completed login, continuing import flow")
            loadKickPage(KICK_FOLLOWING_URL)
            return@evaluateJavascript
          }
          val shouldFallbackToLoginPage =
            allowFallbackToLoginPage &&
              !manualLoginFallbackTriggered &&
              KickFollowImportResolver.isKickHomeUrl(currentUrl)
          if (shouldFallbackToLoginPage) {
            manualLoginFallbackTriggered = true
            updateStatus(getString(R.string.import_kick_followed_status_loading), loading = true)
            debugLogI("manual-login-probe[$reason]: fallback to direct login page $KICK_LOGIN_URL")
            loadKickPage(KICK_LOGIN_URL)
            return@evaluateJavascript
          }
          updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
          prepareManualLoginUi(currentUrl)
        }
      }

    private fun prepareManualLoginUi(url: String) {
        val webView = _binding?.webView ?: return
        val now = System.currentTimeMillis()
        if (now - lastManualHelperInjectAtMs < 1000L) {
          debugLogI("prepareManualLoginUi: throttled helper injection")
          return
        }
        lastManualHelperInjectAtMs = now
        resetWebViewViewportForLogin()
        webView.requestFocus(View.FOCUS_DOWN)
        webView.requestFocusFromTouch()
        webView.postDelayed({
        resetWebViewViewportForLogin()
            webView.requestFocusFromTouch()
            webView.evaluateJavascript(
                MANUAL_LOGIN_HELPER_SCRIPT.replace("__URL__", url.replace("\\", "\\\\").replace("'", "\\'")),
          ) { result ->
            debugLogI("MANUAL_LOGIN_HELPER_SCRIPT result=${result?.take(200)}")
          }
        }, 250L)
    }

    private fun resetWebViewViewportForLogin() {
      val webView = _binding?.webView ?: return
      webView.scrollTo(0, 0)
      webView.post {
        webView.scrollTo(0, 0)
        webView.evaluateJavascript(
          "window.scrollTo(0,0);document.documentElement.scrollTop=0;document.body.scrollTop=0;(function(){document.querySelectorAll('video').forEach(function(v){try{v.pause();v.muted=true;}catch(_){}});})();",
          null,
        )
      }
    }

    private fun shouldBlockKickMediaRequest(url: String): Boolean {
        if (url.isBlank()) return false
        val lower = url.lowercase()
      return lower.contains("/ivs/") ||
        lower.contains("amazon-ivs") ||
        lower.endsWith(".m3u8") ||
            lower.contains(".m3u8?") ||
            lower.endsWith(".ts") ||
        lower.contains(".ts?") ||
        lower.endsWith(".mp4") ||
        lower.contains(".mp4?")
    }

    private fun handleImportError(error: Throwable) {
        lifecycleScope.launch {
            val message = error.message?.take(160) ?: getString(R.string.connection_error)
            debugLogW("handleImportError: $message")
            importAttempted = false
            val needsWebsiteLogin =
              message.contains("(401)", ignoreCase = true) ||
                message.contains(" 401 ", ignoreCase = true) ||
                message.contains("redirected before channels", ignoreCase = true) ||
                message.contains("No followed channels found", ignoreCase = true)
            if (needsWebsiteLogin) {
                waitingForManualLogin = true
                updateStatus(getString(R.string.import_kick_followed_status_sign_in), loading = false)
              resetWebViewViewportForLogin()
              loadKickPage(KICK_HOME_URL)
            } else {
                updateStatus(getString(R.string.import_kick_followed_error, message), loading = false)
            }
        }
    }

    companion object {
        private val MANUAL_LOGIN_STATE_SCRIPT = """
            (function() {
              try {
                const normalize = (value) => (value || '').replace(/\s+/g, ' ').trim().toLowerCase();
                const hasLoginForm = !!document.querySelector('input[type="password"],input[name="email"],input[name="username"],button[type="submit"]');
                const hasLoginCta = Array.from(document.querySelectorAll('button,a,[role="button"]')).some((node) => {
                  const text = normalize(node.textContent);
                  const aria = normalize(node.getAttribute('aria-label'));
                  const testId = normalize(node.getAttribute('data-testid'));
                  return testId === 'login' || text === 'log in' || text === 'login' || text === 'sign in' || aria.includes('log in') || aria.includes('sign in');
                });
                if (!hasLoginCta && !hasLoginForm) {
                  return 'LIKELY_LOGGED_IN';
                }
                return 'NEEDS_LOGIN';
              } catch (error) {
                return 'PROBE_ERROR';
              }
            })();
        """.trimIndent()

        private val MANUAL_LOGIN_HELPER_SCRIPT = """
            (function() {
              try {
                if (window.__kickImportManualHelperRunning) {
                  return;
                }
                window.__kickImportManualHelperRunning = true;
                const currentUrl = '__URL__';
                const status = (message) => {
                  try {
                    if (window.KickFollowImportBridge && typeof window.KickFollowImportBridge.onStatus === 'function') {
                      window.KickFollowImportBridge.onStatus('manual ' + message);
                    }
                  } catch (_) {}
                };
                const normalize = (value) => (value || '').replace(/\s+/g, ' ').trim().toLowerCase();
                const textMatches = (node, variants) => variants.some((value) => normalize(node.textContent).includes(value));
                const clickNode = (node) => {
                  if (!node) return false;
                  if (typeof node.scrollIntoView === 'function') {
                    node.scrollIntoView({ block: 'center', inline: 'center' });
                  }
                  node.dispatchEvent(new MouseEvent('mouseover', { bubbles: true, cancelable: true, view: window }));
                  node.dispatchEvent(new MouseEvent('mousedown', { bubbles: true, cancelable: true, view: window }));
                  node.dispatchEvent(new MouseEvent('mouseup', { bubbles: true, cancelable: true, view: window }));
                  node.click();
                  status('clicked ' + (node.tagName || 'node'));
                  return true;
                };
                const clickIfFound = (selector, predicate) => {
                  const nodes = Array.from(document.querySelectorAll(selector));
                  const target = nodes.find(predicate);
                  if (!target) return false;
                  return clickNode(target);
                };
                const cookieSelectors = [
                  'button',
                  '[role="button"]',
                  'button[mode]',
                  '[data-testid*="cookie"]',
                ].join(',');
                const findLoginInput = () => document.querySelector(
                  'input[type="email"],input[name="email"],input[name="username"],input[autocomplete="username"],input[placeholder*="Email" i],input[placeholder*="Username" i]'
                );
                const hasLoginForm = () => !!document.querySelector('button[type="submit"],input[type="password"],input[name="email"],input[name="username"]');
                const ensureReadableInputs = () => {
                  if (!document.getElementById('kick-import-input-visibility-style')) {
                    const style = document.createElement('style');
                    style.id = 'kick-import-input-visibility-style';
                    style.textContent = [
                      'input[type="email"],input[type="text"],input[type="password"],input[name="email"],input[name="username"] {',
                      '  color: #ffffff !important;',
                      '  -webkit-text-fill-color: #ffffff !important;',
                      '  caret-color: #ffffff !important;',
                      '  opacity: 1 !important;',
                      '}',
                      'input::placeholder {',
                      '  color: #9ca3af !important;',
                      '  opacity: 1 !important;',
                      '}'
                    ].join('\n');
                    if (document.head) {
                      document.head.appendChild(style);
                    }
                  }
                  document.querySelectorAll('input[type="email"],input[type="text"],input[type="password"],input[name="email"],input[name="username"]').forEach((node) => {
                    node.style.setProperty('color', '#ffffff', 'important');
                    node.style.setProperty('-webkit-text-fill-color', '#ffffff', 'important');
                    node.style.setProperty('caret-color', '#ffffff', 'important');
                  });
                };
                let loginClickCount = 0;
                const tryAdvance = () => {
                  ensureReadableInputs();
                  clickIfFound(cookieSelectors, (node) => {
                    const label = normalize(node.textContent);
                    const aria = normalize(node.getAttribute('aria-label'));
                    return [
                      'accept',
                      'accept all',
                      'allow all',
                      'allow all cookies',
                    ].some((value) => label === value || label.includes(value) || aria.includes(value));
                  });
                  clickIfFound('button[data-testid="login"]', () => true);
                  if (!hasLoginForm()) {
                    const clicked = clickIfFound('button[data-testid="login"],button,[role="button"],a', (node) => {
                      if (node.dataset && node.dataset.testid === 'login') {
                        return true;
                      }
                      return textMatches(node, ['log in', 'login', 'sign in', 'signin']);
                    });
                    if (clicked) {
                      loginClickCount += 1;
                      status('clicked login trigger ' + loginClickCount);
                    }
                  }
                  const focusTarget = findLoginInput();
                  if (focusTarget) {
                    status('login input found');
                    focusTarget.removeAttribute('readonly');
                    focusTarget.focus();
                    clickNode(focusTarget);
                    if (typeof focusTarget.setSelectionRange === 'function') {
                      const value = focusTarget.value || '';
                      focusTarget.setSelectionRange(value.length, value.length);
                    }
                    return true;
                  }
                  return false;
                };
                let attempts = 0;
                const timer = window.setInterval(() => {
                  attempts += 1;
                  const readyForTyping = tryAdvance();
                  if (readyForTyping || attempts >= 12) {
                    window.clearInterval(timer);
                    window.__kickImportManualHelperRunning = false;
                    status(readyForTyping ? 'ready for typing' : 'login input not found');
                  }
                }, 500);
                tryAdvance();
              } catch (error) {
                window.__kickImportManualHelperRunning = false;
                console.log(error && error.message ? error.message : String(error));
              }
            })();
        """.trimIndent()

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
                  'browse',
                  'popular',
                  'saved'
                ]);
                const normalize = (value) => (value || '').replace(/\s+/g, ' ').trim().toLowerCase();
                const extractSlug = (rawHref) => {
                  if (!rawHref) return null;
                  let href;
                  try {
                    href = new URL(rawHref, window.location.origin);
                  } catch (_) {
                    return null;
                  }
                  if (href.origin !== window.location.origin) return null;
                  const path = href.pathname.replace(/^\/+|\/+$/g, '');
                  if (!path || path.includes('/')) return null;
                  const slug = decodeURIComponent(path).trim();
                  if (!slug) return null;
                  if (reserved.has(slug.toLowerCase())) return null;
                  return slug;
                };
                const getSectionRoot = () => {
                  const nodes = Array.from(document.querySelectorAll('h1,h2,h3,h4,h5,h6,div,span,p,strong'));
                  const heading = nodes.find((node) => (node.textContent || '').trim().toLowerCase() === 'followed channels');
                  if (!heading) return document.body || document.documentElement || null;
                  let current = heading;
                  for (let i = 0; i < 4 && current.parentElement; i++) {
                    current = current.parentElement;
                  }
                  return current || null;
                };
                const findScrollContainer = (root) => {
                  const candidates = [document.scrollingElement, document.documentElement, document.body].filter(Boolean);
                  if (root) {
                    const nested = Array.from(root.querySelectorAll('*')).filter((node) => {
                      if (!node || typeof node !== 'object') return false;
                      if (!('scrollHeight' in node) || !('clientHeight' in node)) return false;
                      if (node.scrollHeight <= node.clientHeight + 8) return false;
                      let overflowY = '';
                      try {
                        overflowY = (window.getComputedStyle(node).overflowY || '').toLowerCase();
                      } catch (_) {
                        overflowY = '';
                      }
                      return overflowY === 'auto' || overflowY === 'scroll';
                    });
                    candidates.push(...nested);
                  }
                  return candidates
                    .filter((node) => node && node.scrollHeight > node.clientHeight + 8)
                    .sort((a, b) => b.scrollHeight - a.scrollHeight)[0] || null;
                };
                const clickLoadMore = () => {
                  const controls = Array.from(document.querySelectorAll('button,a,[role="button"]'));
                  const target = controls.find((node) => {
                    const text = normalize(node.textContent);
                    return text.includes('load more') || text.includes('show more') || text.includes('view more');
                  });
                  if (target && typeof target.click === 'function') {
                    target.click();
                    return true;
                  }
                  return false;
                };
                const scrollForward = (scroller) => {
                  if (!scroller) {
                    const doc = document.scrollingElement || document.documentElement || document.body;
                    const before = window.scrollY || (doc ? doc.scrollTop : 0) || 0;
                    const target = Math.max(
                      before,
                      (doc && doc.scrollHeight ? doc.scrollHeight : 0),
                      (document.body && document.body.scrollHeight ? document.body.scrollHeight : 0)
                    );
                    window.scrollTo(0, target);
                    const after = window.scrollY || (doc ? doc.scrollTop : 0) || 0;
                    return after > before + 2;
                  }
                  const maxTop = Math.max(0, scroller.scrollHeight - scroller.clientHeight);
                  const beforeTop = scroller.scrollTop;
                  if (maxTop <= beforeTop + 2) {
                    const nudgeUp = Math.max(0, maxTop - Math.max(120, Math.floor((scroller.clientHeight || 500) * 0.3)));
                    scroller.scrollTop = nudgeUp;
                    scroller.scrollTop = maxTop;
                    return false;
                  }
                  if (typeof scroller.scrollTo === 'function') {
                    scroller.scrollTo(0, maxTop);
                  } else {
                    scroller.scrollTop = maxTop;
                  }
                  const afterTop = scroller.scrollTop;
                  if (afterTop <= beforeTop + 2) {
                    return false;
                  }
                  return true;
                };
                const collectVisibleChannels = (root) => {
                  if (!root) return [];
                  const anchors = Array.from(root.querySelectorAll('a[href]'));
                  const channels = [];
                  for (const anchor of anchors) {
                    const slug = extractSlug(anchor.getAttribute('href') || '');
                    if (!slug) continue;
                    if (anchor.closest('nav,header,footer,[role="navigation"]')) continue;
                    const image = anchor.querySelector('img');
                    channels.push({
                      channel_slug: slug,
                      user_username: slug,
                      profile_picture: image ? (image.currentSrc || image.src || '') : ''
                    });
                  }
                  return channels;
                };
                const collected = new Map();
                let stagnantPasses = 0;
                let stuckAtBottomPasses = 0;
                let tailMode = false;
                for (let pass = 0; pass < 80; pass++) {
                  const onFollowingRoute = (window.location && window.location.pathname || '').toLowerCase().startsWith('/following/channels');
                  if (!onFollowingRoute) {
                    const partial = Array.from(collected.values());
                    if (partial.length > 0) {
                      window.KickFollowImportBridge.onImport(JSON.stringify({ channels: partial }));
                      return;
                    }
                    window.KickFollowImportBridge.onStatus('dom scrape aborted: route=' + (window.location && window.location.href));
                    throw new Error('Following page redirected before channels were collected');
                  }
                  const root = getSectionRoot();
                  const visibleChannels = collectVisibleChannels(root);
                  let addedThisPass = 0;
                  for (const channel of visibleChannels) {
                    const key = (channel.channel_slug || '').toLowerCase();
                    if (!key || reserved.has(key)) continue;
                    if (!collected.has(key)) {
                      collected.set(key, channel);
                      addedThisPass += 1;
                    } else {
                      const current = collected.get(key);
                      if (current && !current.profile_picture && channel.profile_picture) {
                        current.profile_picture = channel.profile_picture;
                      }
                    }
                  }
                  if (addedThisPass == 0) {
                    stagnantPasses += 1;
                  } else {
                    stagnantPasses = 0;
                    if (addedThisPass > 0 && addedThisPass < 20) {
                      tailMode = true;
                    }
                  }
                  window.KickFollowImportBridge.onStatus('dom scrape pass ' + pass + ' visible=' + visibleChannels.length + ' added=' + addedThisPass + ' total=' + collected.size);
                  if (pass % 2 === 1 || addedThisPass === 0) {
                    clickLoadMore();
                  }
                  const scroller = findScrollContainer(root);
                  const moved = scrollForward(scroller);
                  if (!moved) {
                    stuckAtBottomPasses += 1;
                  } else {
                    stuckAtBottomPasses = 0;
                  }
                  const requiredStagnantPasses = tailMode ? 3 : 6;
                  if (collected.size > 0 && stagnantPasses >= requiredStagnantPasses && stuckAtBottomPasses >= 2) {
                    break;
                  }
                  if (addedThisPass > 0) {
                    await sleep(120);
                  } else if (moved) {
                    await sleep(170);
                  } else {
                    await sleep(280);
                  }
                }
                const allChannels = Array.from(collected.values());
                if (!allChannels.length) {
                  throw new Error('No followed channels found in WebView DOM');
                }
                window.KickFollowImportBridge.onStatus('dom scrape complete total=' + allChannels.length);
                window.KickFollowImportBridge.onImport(JSON.stringify({ channels: allChannels }));
              } catch (error) {
                const message = error && error.message ? error.message : String(error);
                window.KickFollowImportBridge.onError(message);
              }
            })();
        """.trimIndent()
    }
}


