package com.xtrakick.app.di

import android.app.Application
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import androidx.annotation.OptIn
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.HttpEngineAvailability
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.ConnectionPool
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import org.chromium.net.CronetEngine
import org.chromium.net.CronetProvider
import org.chromium.net.QuicOptions
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.X509TrustManager

@RequiresApi(Build.VERSION_CODES.S)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
private object HttpEngineLoader {
    fun build(application: Application): HttpEngine {
        return HttpEngine.Builder(application).apply {
            addQuicHint("7tv.io", 443, 443)
            addQuicHint("cdn.7tv.app", 443, 443)
        }.build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesHttpEngine(application: Application): HttpEngine? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || !HttpEngineAvailability.isAvailable) {
            return null
        }
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7) {
                HttpEngineLoader.build(application)
            } else {
                null
            }
        } catch (t: Throwable) {
            DiagnosticLogger.w("AppModule", "Failed to initialize HttpEngine", t)
            null
        }
    }

    @Singleton
    @Provides
    @OptIn(QuicOptions.Experimental::class)
    fun providesCronetEngine(application: Application): CronetEngine? {
        return try {
            if (CronetProvider.getAllProviders(application).any { it.isEnabled }) {
                CronetEngine.Builder(application).apply {
                    val userAgent = "Cronet/" + defaultUserAgent.substringAfter("Cronet/", "").substringBefore(')')
                    setUserAgent(userAgent)
                    setQuicOptions(QuicOptions.builder().setHandshakeUserAgent(userAgent).build())
                    addQuicHint("7tv.io", 443, 443)
                    addQuicHint("cdn.7tv.app", 443, 443)
                }.build()
            } else {
                null
            }
        } catch (t: Throwable) {
            DiagnosticLogger.w("AppModule", "Failed to initialize CronetEngine", t)
            null
        }
    }

    @Singleton
    @Provides
    fun providesCronetExecutor(): ExecutorService {
        return Executors.newCachedThreadPool()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(application: Application): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            fastFallback(true)
            dispatcher(Dispatcher().apply {
                maxRequests = 64
                maxRequestsPerHost = 20
            })
            connectionPool(ConnectionPool(16, 5, TimeUnit.MINUTES))
            applyDebugLogging(application)
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun providesTrustManager(): X509TrustManager? = null

    @Singleton
    @Provides
    fun providesJsonInstance(): Json {
        return Json { ignoreUnknownKeys = true }
    }
}
