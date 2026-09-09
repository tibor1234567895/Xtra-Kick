package com.xtrakick.app.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class KickOAuthCallbackActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = intent.data
        if (intent.action == Intent.ACTION_VIEW && callback?.scheme == "https" &&
            callback.host in setOf("localhost", "127.0.0.1") && callback.path?.startsWith("/callback") == true
        ) {
            // Forward only the callback URI. External extras must never request local logout.
            startActivity(Intent(this, LoginActivity::class.java).setData(callback))
        }
        finish()
    }
}
