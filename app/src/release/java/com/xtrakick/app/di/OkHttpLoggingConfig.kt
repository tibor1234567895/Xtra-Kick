package com.xtrakick.app.di

import android.app.Application
import okhttp3.OkHttpClient

internal fun OkHttpClient.Builder.applyDebugLogging(application: Application) = Unit
