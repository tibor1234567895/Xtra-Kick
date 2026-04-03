package com.github.andreyasadchy.xtra

import android.app.Application
import android.os.Bundle
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.webkit.CookieManager
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.network.NetworkClient
import coil3.network.NetworkFetcher
import coil3.network.NetworkHeaders
import coil3.network.NetworkRequest
import coil3.network.NetworkResponse
import coil3.network.NetworkResponseBody
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import coil3.util.DebugLogger
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.HttpEngineUtils
import com.github.andreyasadchy.xtra.util.WebSocketRuntime
import com.github.andreyasadchy.xtra.util.coil.CacheControlCacheStrategy
import com.github.andreyasadchy.xtra.util.getByteArrayCronetCallback
import com.github.andreyasadchy.xtra.util.prefs
import dagger.Lazy
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import okio.Buffer
import okio.buffer
import okio.source
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UploadDataProviders
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine


@HiltAndroidApp
class XtraApp : Application(), Configuration.Provider, SingletonImageLoader.Factory {

    companion object {
        lateinit var INSTANCE: Application
        var showUnexpectedLogoutNoticeThisProcess = false
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        showUnexpectedLogoutNoticeThisProcess = AuthStateHelper.hasPendingUnexpectedLogoutNotice(this)
        var startedActivities = 0
        registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {
                override fun onActivityStarted(activity: android.app.Activity) {
                    startedActivities += 1
                    WebSocketRuntime.isAppInForeground = startedActivities > 0
                }

                override fun onActivityStopped(activity: android.app.Activity) {
                    startedActivities = (startedActivities - 1).coerceAtLeast(0)
                    WebSocketRuntime.isAppInForeground = startedActivities > 0
                }

                override fun onActivityCreated(activity: android.app.Activity, savedInstanceState: Bundle?) {}
                override fun onActivityResumed(activity: android.app.Activity) {}
                override fun onActivityPaused(activity: android.app.Activity) {}
                override fun onActivitySaveInstanceState(activity: android.app.Activity, outState: Bundle) {}
                override fun onActivityDestroyed(activity: android.app.Activity) {}
            }
        )
    }

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    @Inject
    @JvmField
    var httpEngine: Lazy<HttpEngine>? = null

    @Inject
    @JvmField
    var cronetEngine: Lazy<CronetEngine>? = null

    @Inject
    lateinit var cronetExecutor: ExecutorService

    @Inject
    lateinit var okHttpClient: OkHttpClient

    private fun kickStreamThumbnailHeaders(): Map<String, String> {
        val cookies = linkedSetOf<String>()
        fun collectCookies(url: String) {
            CookieManager.getInstance()
                .getCookie(url)
                ?.split(';')
                ?.map { it.trim() }
                ?.filter { it.isNotBlank() }
                ?.forEach(cookies::add)
        }
        collectCookies("https://kick.com")
        collectCookies("https://stream.kick.com")
        val authCookie = cookies.firstOrNull { it.startsWith("auth-token=", ignoreCase = true) }
            ?.substringAfter('=', "")
            ?.takeIf { it.isNotBlank() }
        return buildMap {
            put("Referer", "https://kick.com/")
            put("Origin", "https://kick.com")
            put("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            if (cookies.isNotEmpty()) {
                put("Cookie", cookies.joinToString("; "))
            }
            authCookie?.let { put("Authorization", "Bearer $it") }
                ?: AuthStateHelper.getKickBearerToken(this@XtraApp)?.let { put("Authorization", it) }
        }
    }

    private fun applyKickStreamThumbnailHeaders(
        requestBuilder: okhttp3.Request.Builder,
        url: String,
    ): okhttp3.Request.Builder {
        if (!url.contains("://stream.kick.com/", ignoreCase = true)) {
            return requestBuilder
        }
        kickStreamThumbnailHeaders().forEach { (name, value) ->
            requestBuilder.header(name, value)
        }
        return requestBuilder
    }

    @OptIn(ExperimentalCoilApi::class)
    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context).apply {
            if (BuildConfig.DEBUG) {
                logger(DebugLogger())
            }
            components {
                val networkLibrary = prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                when {
                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                        add(NetworkFetcher.Factory(
                            networkClient = {
                                object : NetworkClient {
                                    override suspend fun <T> executeRequest(request: NetworkRequest, block: suspend (NetworkResponse) -> T): T {
                                        val requestBody = request.body?.let {
                                            val buffer = Buffer()
                                            it.writeTo(buffer)
                                            buffer.readByteArray()
                                        }
                                        val isKickStreamThumbnail = request.url.contains("://stream.kick.com/", ignoreCase = true)
                                        val requestMillis = System.currentTimeMillis()
                                        val response = suspendCoroutine { continuation ->
                                            httpEngine!!.get().newUrlRequestBuilder(request.url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                                                request.headers.asMap().forEach { entry ->
                                                    entry.value.forEach {
                                                        addHeader(entry.key, it)
                                                    }
                                                }
                                                if (isKickStreamThumbnail) {
                                                    kickStreamThumbnailHeaders().forEach { (name, value) ->
                                                        addHeader(name, value)
                                                    }
                                                }
                                                requestBody?.let {
                                                    setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(requestBody), cronetExecutor)
                                                }
                                                setHttpMethod(request.method)
                                            }.build().start()
                                        }
                                        val responseMillis = System.currentTimeMillis()
                                        return block(
                                            NetworkResponse(
                                                code = response.first.httpStatusCode,
                                                requestMillis = requestMillis,
                                                responseMillis = responseMillis,
                                                headers = NetworkHeaders.Builder().apply {
                                                    response.first.headers.asList.forEach {
                                                        add(it.key, it.value)
                                                    }
                                                }.build(),
                                                body = response.second.inputStream().source().buffer().let(::NetworkResponseBody),
                                            )
                                        )
                                    }
                                }
                            },
                            cacheStrategy = { CacheControlCacheStrategy() }
                        ))
                    }
                    networkLibrary == "Cronet" && cronetEngine != null -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            add(NetworkFetcher.Factory(
                                networkClient = {
                                    object : NetworkClient {
                                        override suspend fun <T> executeRequest(request: NetworkRequest, block: suspend (NetworkResponse) -> T): T {
                                            val cronetRequest = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                            val isKickStreamThumbnail = request.url.contains("://stream.kick.com/", ignoreCase = true)
                                            cronetEngine!!.get().newUrlRequestBuilder(request.url, cronetRequest.callback, cronetExecutor).apply {
                                                request.headers.asMap().forEach { entry ->
                                                    entry.value.forEach {
                                                        addHeader(entry.key, it)
                                                    }
                                                }
                                                if (isKickStreamThumbnail) {
                                                    kickStreamThumbnailHeaders().forEach { (name, value) ->
                                                        addHeader(name, value)
                                                    }
                                                }
                                                request.body?.let {
                                                    val buffer = Buffer()
                                                    it.writeTo(buffer)
                                                    setUploadDataProvider(UploadDataProviders.create(buffer.readByteArray()), cronetExecutor)
                                                }
                                                setHttpMethod(request.method)
                                            }.build().start()
                                            val requestMillis = System.currentTimeMillis()
                                            val response = cronetRequest.future.get()
                                            val responseMillis = System.currentTimeMillis()
                                            return block(
                                                NetworkResponse(
                                                    code = response.urlResponseInfo.httpStatusCode,
                                                    requestMillis = requestMillis,
                                                    responseMillis = responseMillis,
                                                    headers = NetworkHeaders.Builder().apply {
                                                        response.urlResponseInfo.allHeadersAsList.forEach {
                                                            add(it.key, it.value)
                                                        }
                                                    }.build(),
                                                    body = (response.responseBody as ByteArray).inputStream().source().buffer().let(::NetworkResponseBody),
                                                )
                                            )
                                        }
                                    }
                                },
                                cacheStrategy = { CacheControlCacheStrategy() }
                            ))
                        } else {
                            add(NetworkFetcher.Factory(
                                networkClient = {
                                    object : NetworkClient {
                                        override suspend fun <T> executeRequest(request: NetworkRequest, block: suspend (NetworkResponse) -> T): T {
                                            val requestBody = request.body?.let {
                                                val buffer = Buffer()
                                                it.writeTo(buffer)
                                                buffer.readByteArray()
                                            }
                                            val isKickStreamThumbnail = request.url.contains("://stream.kick.com/", ignoreCase = true)
                                            val requestMillis = System.currentTimeMillis()
                                            val response = suspendCoroutine { continuation ->
                                                cronetEngine!!.get().newUrlRequestBuilder(request.url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                                                    request.headers.asMap().forEach { entry ->
                                                    entry.value.forEach {
                                                        addHeader(entry.key, it)
                                                    }
                                                }
                                                if (isKickStreamThumbnail) {
                                                    kickStreamThumbnailHeaders().forEach { (name, value) ->
                                                        addHeader(name, value)
                                                    }
                                                }
                                                requestBody?.let {
                                                    setUploadDataProvider(UploadDataProviders.create(requestBody), cronetExecutor)
                                                }
                                                setHttpMethod(request.method)
                                                }.build().start()
                                            }
                                            val responseMillis = System.currentTimeMillis()
                                            return block(
                                                NetworkResponse(
                                                    code = response.first.httpStatusCode,
                                                    requestMillis = requestMillis,
                                                    responseMillis = responseMillis,
                                                    headers = NetworkHeaders.Builder().apply {
                                                        response.first.allHeadersAsList.forEach {
                                                            add(it.key, it.value)
                                                        }
                                                    }.build(),
                                                    body = response.second.inputStream().source().buffer().let(::NetworkResponseBody),
                                                )
                                            )
                                        }
                                    }
                                },
                                cacheStrategy = { CacheControlCacheStrategy() }
                            ))
                        }
                    }
                    else -> {
                        val coilClient = okHttpClient.newBuilder()
                            .addNetworkInterceptor(Interceptor { chain ->
                                val request = chain.request()
                                val url = request.url.toString()
                                if (url.contains("://stream.kick.com/", ignoreCase = true)) {
                                    chain.proceed(applyKickStreamThumbnailHeaders(request.newBuilder(), url).build())
                                } else {
                                    chain.proceed(request)
                                }
                            })
                            .build()
                        add(OkHttpNetworkFetcherFactory(
                            callFactory = { coilClient },
                            cacheStrategy = { CacheControlCacheStrategy() }
                        ))
                    }
                }
            }
        }.build()
    }
}
