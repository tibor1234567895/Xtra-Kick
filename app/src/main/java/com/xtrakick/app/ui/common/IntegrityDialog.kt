package com.xtrakick.app.ui.common

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.RenderProcessGoneDetail
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.core.content.edit
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.webkit.WebViewClientCompat
import com.xtrakick.app.databinding.DialogIntegrityBinding
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.bundleOf
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import org.json.JSONObject

class IntegrityDialog : DialogFragment() {

    interface CallbackListener {
        fun onIntegrityDialogCallback(callback: String?)
    }

    private var _binding: DialogIntegrityBinding? = null
    private val binding get() = _binding!!
    private var listener: CallbackListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? CallbackListener
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogIntegrityBinding.inflate(layoutInflater)
        val context = requireContext()
        val builder = context.getAlertDialogBuilder()
            .setView(binding.root)
        val token = KickApiHelper.getKickWebHeaders(context, true)[AppConstants.HEADER_TOKEN]?.removePrefix("OAuth ")
        if (!token.isNullOrBlank()) {
            CookieManager.getInstance().setCookie("https://kick.com", "auth-token=$token")
        }
        with(binding.webView) {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.builtInZoomControls = true
            settings.displayZoomControls = false
            webChromeClient = WebChromeClient()
            webViewClient = object : WebViewClientCompat() {

                override fun shouldInterceptRequest(view: WebView, webViewRequest: WebResourceRequest): WebResourceResponse? {
                    val host = webViewRequest.url.host.orEmpty()
                    val isKickOrigin = webViewRequest.url.scheme.equals("https", ignoreCase = true) &&
                        (host.equals("kick.com", ignoreCase = true) || host.endsWith(".kick.com", ignoreCase = true))
                    if (isKickOrigin && !webViewRequest.requestHeaders.entries.firstOrNull { it.key.equals("Client-Integrity", true) }?.value.isNullOrBlank()) {
                        context.tokenPrefs().edit {
                            putLong(AppConstants.INTEGRITY_EXPIRATION, System.currentTimeMillis() + 57600000)
                            putString(AppConstants.GQL_HEADERS, JSONObject(
                                if (context.prefs().getBoolean(AppConstants.GET_ALL_GQL_HEADERS, false)) {
                                    webViewRequest.requestHeaders
                                } else {
                                    webViewRequest.requestHeaders.filterKeys {
                                        it.equals(AppConstants.HEADER_TOKEN, true) ||
                                                it.equals(AppConstants.HEADER_CLIENT_ID, true) ||
                                                it.equals("Client-Integrity", true) ||
                                                it.equals("X-Device-Id", true)
                                    }
                                }
                            ).toString())
                        }
                        listener?.onIntegrityDialogCallback(requireArguments().getString(KEY_CALLBACK))
                        dismiss()
                    }
                    return super.shouldInterceptRequest(view, webViewRequest)
                }

                override fun onRenderProcessGone(view: WebView, detail: RenderProcessGoneDetail): Boolean {
                    _binding?.webView?.let { webView ->
                        (webView.parent as? ViewGroup)?.removeView(webView)
                        runCatching { webView.destroy() }
                    }
                    dismissAllowingStateLoss()
                    return true
                }
            }
            loadUrl("https://kick.com/login")
        }
        return builder.create()
    }

    override fun onDismiss(dialog: DialogInterface) {
        _binding?.webView?.loadUrl("about:blank")
        super.onDismiss(dialog)
    }

    override fun onDestroyView() {
        _binding?.webView?.let { webView ->
            (webView.parent as? ViewGroup)?.removeView(webView)
            runCatching { webView.destroy() }
        }
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val KEY_CALLBACK = "callback"

        fun show(fragmentManager: FragmentManager, callback: String? = null) {
            IntegrityDialog().apply {
                arguments = bundleOf(KEY_CALLBACK to callback)
                show(fragmentManager, null)
            }
        }
    }
}
