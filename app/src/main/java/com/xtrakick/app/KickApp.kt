package com.xtrakick.app

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.webkit.CookieManager
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatDelegate
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.gif.AnimatedImageDecoder
import coil3.gif.GifDecoder
import coil3.network.NetworkClient
import coil3.network.NetworkFetcher
import coil3.network.NetworkHeaders
import coil3.network.NetworkRequest
import coil3.network.NetworkResponse
import coil3.network.NetworkResponseBody
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import coil3.svg.SvgDecoder
import coil3.video.VideoFrameDecoder
import coil3.disk.directory
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.DiagnosticCoilLogger
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.NetworkUtils
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.LegacyAnimatedWebpDecoder
import com.xtrakick.app.util.WebSocketRuntime
import com.xtrakick.app.util.coil.CacheControlCacheStrategy
import com.xtrakick.app.util.getByteArrayCronetCallback
import com.xtrakick.app.util.UsagePing
import com.xtrakick.app.util.CrashReports
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.chat.StvCdnHealth
import com.xtrakick.app.repository.NotificationUsersRepository
import dagger.Lazy
import dagger.hilt.android.HiltAndroidApp
import okhttp3.Call
import okhttp3.ConnectionPool
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import okhttp3.Protocol
import okio.Buffer
import okio.buffer
import okio.source
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.UploadDataProviders
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout


@HiltAndroidApp
class KickApp : Application(), Configuration.Provider, SingletonImageLoader.Factory {

    internal enum class KickImageHostTier {
        AUTHENTICATED_THUMBNAIL,
        PUBLIC_CDN,
    }

    companion object {
        lateinit var INSTANCE: Application
        var showUnexpectedLogoutNoticeThisProcess = false
        private const val IMAGE_REQUEST_TIMEOUT_MS = 30_000L

        internal fun classifyKickImageUrl(url: String): KickImageHostTier? {
            val parsed = url.toHttpUrlOrNull() ?: return null
            if (!parsed.scheme.equals("https", ignoreCase = true)) return null
            return when {
                parsed.host.equals("stream.kick.com", ignoreCase = true) ||
                    parsed.host.equals("images.kick.com", ignoreCase = true) -> KickImageHostTier.AUTHENTICATED_THUMBNAIL
                parsed.host.equals("ext.cdn.kick.com", ignoreCase = true) ||
                    parsed.host.equals("files.kick.com", ignoreCase = true) -> KickImageHostTier.PUBLIC_CDN
                else -> null
            }
        }

        internal fun canFollowKickImageRedirect(originalUrl: String, newLocationUrl: String?): Boolean {
            if (classifyKickImageUrl(originalUrl) != KickImageHostTier.AUTHENTICATED_THUMBNAIL) {
                return true
            }
            if (newLocationUrl.isNullOrBlank()) return false
            return classifyKickImageUrl(newLocationUrl) == KickImageHostTier.AUTHENTICATED_THUMBNAIL
        }
    }

    // Below Android 13, AppCompat applies stored app locales to activity contexts only,
    // so string lookups going through the application context (chat notices, widgets,
    // notifications) would ignore the user's language choice. Wrap the base context once
    // here; on 13+ the framework already localizes the app context via localeConfig.
    @android.annotation.SuppressLint("RestrictedApi")
    override fun attachBaseContext(base: Context) {
        val wrapped = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            val appLocales = AppCompatDelegate.getApplicationLocales()
            val primary = if (!appLocales.isEmpty) {
                appLocales[0]
            } else {
                val tags = androidx.core.app.AppLocalesStorageHelper.readLocales(base)
                val stored = androidx.core.os.LocaleListCompat.forLanguageTags(tags)
                if (stored.isEmpty) null else stored[0]
            }
            if (primary != null) {
                android.content.res.Configuration(base.resources.configuration).apply { setLocale(primary) }
                    .let(base::createConfigurationContext)
            } else {
                base
            }
        } else {
            base
        }
        super.attachBaseContext(wrapped)
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        DiagnosticLogger.init(this)
        val previousUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                runCatching { CrashReports.capture(this, throwable) }
                runCatching {
                    DiagnosticLogger.updateAppState(WebSocketRuntime.isAppInForeground)
                    DiagnosticLogger.logCrash(throwable)
                }
                runCatching { UsagePing.noteCrash(this) }
            } finally {
                previousUncaughtExceptionHandler?.uncaughtException(thread, throwable)
                    ?: kotlin.system.exitProcess(10)
            }
        }
        runCatching {
            val media3LogLevel = if (BuildConfig.DEBUG && prefs().getBoolean(AppConstants.DEBUG_PLAYER_BUFFER_LOGS, false)) {
                androidx.media3.common.util.Log.LOG_LEVEL_INFO
            } else {
                androidx.media3.common.util.Log.LOG_LEVEL_ERROR
            }
            androidx.media3.common.util.Log.setLogLevel(media3LogLevel)
        }
        showUnexpectedLogoutNoticeThisProcess = AuthStateHelper.hasPendingUnexpectedLogoutNotice(this)
        // One-time re-key of legacy login-keyed notification rows (issues #44/#58); no-op
        // when there is nothing to migrate. Fire-and-forget: must not delay cold start.
        CoroutineScope(Dispatchers.IO).launch {
            runCatching { notificationUsersRepository.get().migrateLegacyKeys() }
                .onFailure { android.util.Log.w("KickApp", "notification key migration failed", it) }
        }
        CrashReports.maybeSend(this, delayMillis = 15_000L)
        var startedActivities = 0
        var userAgentWarmedUp = false
        registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {
                override fun onActivityStarted(activity: android.app.Activity) {
                    startedActivities += 1
                    WebSocketRuntime.isAppInForeground = startedActivities > 0
                    DiagnosticLogger.updateAppState(WebSocketRuntime.isAppInForeground)
                    if (!userAgentWarmedUp) {
                        userAgentWarmedUp = true
                        android.os.Looper.myQueue().addIdleHandler {
                            runCatching { WebSettings.getDefaultUserAgent(this@KickApp) }
                            false
                        }
                    }
                    if (startedActivities == 1) {
                        UsagePing.noteSessionStarted(activity)
                        CrashReports.maybeSend(activity.applicationContext, delayMillis = 3_000L)
                        UsagePing.maybeSend(activity.applicationContext, delayMillis = 3_000L)
                    }
                }

                override fun onActivityStopped(activity: android.app.Activity) {
                    startedActivities = (startedActivities - 1).coerceAtLeast(0)
                    WebSocketRuntime.isAppInForeground = startedActivities > 0
                    DiagnosticLogger.updateAppState(WebSocketRuntime.isAppInForeground)
                }

                override fun onActivityCreated(activity: android.app.Activity, savedInstanceState: Bundle?) {}
                override fun onActivityResumed(activity: android.app.Activity) {
                    DiagnosticLogger.updateAppState(WebSocketRuntime.isAppInForeground, activity.javaClass.simpleName)
                }
                override fun onActivityPaused(activity: android.app.Activity) {}
                override fun onActivitySaveInstanceState(activity: android.app.Activity, outState: Bundle) {}
                override fun onActivityDestroyed(activity: android.app.Activity) {}
            }
        )
    }

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    lateinit var notificationUsersRepository: Lazy<NotificationUsersRepository>

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

    fun isCronetAvailable(): Boolean = try {
        cronetEngine?.get() != null
    } catch (_: Throwable) {
        false
    }

    fun isHttpEngineAvailable(): Boolean = try {
        NetworkUtils.resolveHttpEngine("HttpEngine", httpEngine) != null
    } catch (_: Throwable) {
        false
    }

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
        val cookieHeader = cookies.joinToString("; ")
        val sessionToken = AuthStateHelper.extractKickSessionToken(cookieHeader)
        val authCookie = cookies.firstOrNull { it.startsWith("auth-token=", ignoreCase = true) }
            ?.substringAfter('=', "")
            ?.takeIf { it.isNotBlank() }
        return buildMap {
            put("Referer", "https://kick.com/")
            put("Origin", "https://kick.com")
            put("User-Agent", "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36")
            if (cookies.isNotEmpty()) {
                put("Cookie", cookieHeader)
            }
            sessionToken?.let { put("Authorization", "Bearer $it") }
                ?: authCookie?.let { put("Authorization", "Bearer $it") }
                ?: AuthStateHelper.getKickBearerToken(this@KickApp)?.let { put("Authorization", it) }
        }
    }

    private val kickCdnHeaders: Map<String, String> by lazy {
        mapOf(
            "Referer" to "https://kick.com/",
            "User-Agent" to "Mozilla/5.0 (Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Mobile Safari/537.36"
        )
    }

    private fun kickImageHeaders(url: String): Map<String, String>? {
        return when (classifyKickImageUrl(url)) {
            KickImageHostTier.AUTHENTICATED_THUMBNAIL -> kickStreamThumbnailHeaders()
            KickImageHostTier.PUBLIC_CDN -> kickCdnHeaders
            null -> null
        }
    }

    @kotlin.OptIn(ExperimentalCoilApi::class)
    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context).apply {
            // Coil 3 ships with disk caching disabled unless configured. Without this, every
            // successful emote/image load dies with the process and each app start refetches
            // everything from the wire — brutal under a throttling image CDN. The 7TV CDN
            // marks emote files immutable with a 1-year max-age, so CacheControlCacheStrategy
            // persists them for as long as the LRU eviction allows.
            diskCache {
                coil3.disk.DiskCache.Builder()
                    .directory(context.cacheDir.resolve("image_cache"))
                    .build()
            }
            if (BuildConfig.DEBUG && prefs().getBoolean(AppConstants.DEBUG_NETWORK_LOGS, false)) {
                logger(DiagnosticCoilLogger(coil3.util.Logger.Level.Debug))
            } else {
                logger(DiagnosticCoilLogger(coil3.util.Logger.Level.Error))
            }
            components {
                add(SvgDecoder.Factory())
                add(VideoFrameDecoder.Factory())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    add(AnimatedImageDecoder.Factory())
                } else {
                    add(LegacyAnimatedWebpDecoder())
                    add(GifDecoder.Factory())
                }
                val networkLibrary = prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
                val http = NetworkUtils.resolveHttpEngine(networkLibrary, httpEngine)
                val cronet = NetworkUtils.resolveCronetEngine(networkLibrary, cronetEngine)
                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                        SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 &&
                        http is HttpEngine -> {
                        add(NetworkFetcher.Factory(
                            networkClient = {
                                object : NetworkClient {
                                    override suspend fun <T> executeRequest(request: NetworkRequest, block: suspend (NetworkResponse) -> T): T {
                                        val requestBody = request.body?.let {
                                            val buffer = Buffer()
                                            it.writeTo(buffer)
                                            buffer.readByteArray()
                                        }
                                        val requestMillis = System.currentTimeMillis()
                                        val response = withTimeout(IMAGE_REQUEST_TIMEOUT_MS) {
                                            suspendCancellableCoroutine { continuation ->
                                                val urlRequest = http.newUrlRequestBuilder(
                                                    request.url,
                                                    cronetExecutor,
                                                    HttpEngineUtils.byteArrayUrlCallback(
                                                        continuation = continuation,
                                                        shouldFollowRedirect = { newLocationUrl ->
                                                            canFollowKickImageRedirect(request.url, newLocationUrl)
                                                        },
                                                    ),
                                                ).apply {
                                                    request.headers.asMap().forEach { entry ->
                                                        entry.value.forEach {
                                                            addHeader(entry.key, it)
                                                        }
                                                    }
                                                    kickImageHeaders(request.url)?.forEach { (name, value) ->
                                                        addHeader(name, value)
                                                    }
                                                    requestBody?.let {
                                                        setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(requestBody), cronetExecutor)
                                                    }
                                                    setHttpMethod(request.method)
                                                }.build()
                                                continuation.invokeOnCancellation { urlRequest.cancel() }
                                                urlRequest.start()
                                            }
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
                    cronet != null -> {
                        add(NetworkFetcher.Factory(
                            networkClient = {
                                object : NetworkClient {
                                    override suspend fun <T> executeRequest(request: NetworkRequest, block: suspend (NetworkResponse) -> T): T {
                                        val requestBody = request.body?.let {
                                            val buffer = Buffer()
                                            it.writeTo(buffer)
                                            buffer.readByteArray()
                                        }
                                        val requestMillis = System.currentTimeMillis()
                                        val response = withTimeout(IMAGE_REQUEST_TIMEOUT_MS) {
                                            suspendCancellableCoroutine { continuation ->
                                                val urlRequest = cronet.newUrlRequestBuilder(
                                                    request.url,
                                                    getByteArrayCronetCallback(
                                                        continuation = continuation,
                                                        shouldFollowRedirect = { newLocationUrl ->
                                                            canFollowKickImageRedirect(request.url, newLocationUrl)
                                                        },
                                                    ),
                                                    cronetExecutor,
                                                ).apply {
                                                    request.headers.asMap().forEach { entry ->
                                                        entry.value.forEach {
                                                            addHeader(entry.key, it)
                                                        }
                                                    }
                                                    kickImageHeaders(request.url)?.forEach { (name, value) ->
                                                        addHeader(name, value)
                                                    }
                                                    requestBody?.let {
                                                        setUploadDataProvider(UploadDataProviders.create(requestBody), cronetExecutor)
                                                    }
                                                    setHttpMethod(request.method)
                                                }.build()
                                                continuation.invokeOnCancellation { urlRequest.cancel() }
                                                urlRequest.start()
                                            }
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
                    else -> {
                        val coilClient = okHttpClient.newBuilder()
                            .addNetworkInterceptor(Interceptor { chain ->
                                val request = chain.request()
                                val extraHeaders = kickImageHeaders(request.url.toString())
                                if (extraHeaders != null) {
                                    val newReq = request.newBuilder()
                                    extraHeaders.forEach { (name, value) ->
                                        newReq.header(name, value)
                                    }
                                    chain.proceed(newReq.build())
                                } else if (request.header("Cookie") != null || request.header("Authorization") != null) {
                                    chain.proceed(
                                        request.newBuilder()
                                            .removeHeader("Cookie")
                                            .removeHeader("Authorization")
                                            .build()
                                    )
                                } else {
                                    chain.proceed(request)
                                }
                            })
                            .build()
                        // Keep CDN stalls off the multiplexed connections other images use.
                        val stvClient = coilClient.newBuilder()
                            .dispatcher(StvCdnHealth.DEFAULT.createDispatcher())
                            .connectionPool(ConnectionPool())
                            .protocols(listOf(Protocol.HTTP_1_1))
                            .build()
                        val imageCalls = Call.Factory { request ->
                            val client = if (request.url.host == StvCdnHealth.CDN_HOST) stvClient else coilClient
                            client.newCall(request)
                        }
                        add(OkHttpNetworkFetcherFactory(
                            callFactory = { imageCalls },
                            cacheStrategy = { CacheControlCacheStrategy() }
                        ))
                    }
                }
            }
        }.build()
    }
}
