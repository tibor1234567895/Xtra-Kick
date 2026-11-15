package com.xtrakick.app.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xtrakick.app.util.restoreOversizedInstanceState
import com.xtrakick.app.util.saveOversizedInstanceState

/**
 * Keeps large AndroidX state in private storage rather than discarding navigation or exceeding Binder's limit.
 */
abstract class BaseStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState?.let { restoreOversizedInstanceState(this, it) }
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveOversizedInstanceState(this, outState)
    }
}
