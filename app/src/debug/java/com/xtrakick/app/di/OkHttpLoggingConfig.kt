package com.xtrakick.app.di

import android.app.Application
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal fun OkHttpClient.Builder.applyDebugLogging(application: Application) {
    if (application.prefs().getBoolean(AppConstants.DEBUG_NETWORK_LOGS, false)) {
        addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
    }
}
