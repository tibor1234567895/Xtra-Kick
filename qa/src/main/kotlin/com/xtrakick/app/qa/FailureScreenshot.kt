package com.xtrakick.app.qa

import android.os.Build
import android.util.Log
import java.io.File
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

internal fun failureScreenshot(app: TestApp): TestRule = object : TestWatcher() {
    override fun failed(e: Throwable, description: Description) {
        if (Build.HARDWARE !in setOf("ranchu", "goldfish")) return
        runCatching {
            check(app.device.takeScreenshot(File(app.instrumentation.context.cacheDir, "qa-failure.png")))
        }.onFailure {
            Log.w("XtraKickQa", "Could not capture UI for ${description.methodName}", it)
        }
    }
}
