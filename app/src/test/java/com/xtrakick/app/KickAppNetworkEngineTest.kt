package com.xtrakick.app

import android.content.Context
import android.content.ContextWrapper
import android.net.http.HttpEngine
import android.os.Build
import dagger.Lazy
import org.chromium.net.CronetEngine
import org.chromium.net.UrlRequest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.HttpEngineAvailability
import com.xtrakick.app.util.prefs
import java.net.URL
import java.net.URLConnection
import java.net.URLStreamHandlerFactory
import java.util.concurrent.Executor

@RunWith(RobolectricTestRunner::class)
class KickAppNetworkEngineTest {

    @Test
    fun isCronetAvailableReturnsFalseWhenUnsetOrNull() {
        val app = KickApp()
        app.cronetEngine = null
        assertFalse(app.isCronetAvailable())

        @Suppress("UNCHECKED_CAST")
        app.cronetEngine = Lazy { null as Any? as CronetEngine }
        assertFalse(app.isCronetAvailable())
    }

    @Test
    fun isCronetAvailableReturnsFalseWhenCronetThrowsUnsatisfiedLinkError() {
        val app = KickApp()
        app.cronetEngine = Lazy {
            throw UnsatisfiedLinkError("Cannot load native Cronet library on x86_64")
        }
        assertFalse(app.isCronetAvailable())
    }

    @Test
    @Suppress("DEPRECATION")
    fun isCronetAvailableReturnsTrueWhenCronetEngineInstantiated() {
        val app = KickApp()
        val dummyCronet = object : CronetEngine() {
            override fun newUrlRequestBuilder(url: String, callback: UrlRequest.Callback, executor: Executor): UrlRequest.Builder = throw UnsupportedOperationException()
            override fun openConnection(url: URL): URLConnection = throw UnsupportedOperationException()
            @Deprecated("Deprecated in Java")
            override fun createURLStreamHandlerFactory(): URLStreamHandlerFactory = throw UnsupportedOperationException()
            override fun shutdown() {}
            override fun getVersionString(): String = "1.0"
            override fun startNetLogToFile(fileName: String, logAll: Boolean) {}
            override fun stopNetLog() {}
            @Deprecated("Deprecated in Java")
            override fun getGlobalMetricsDeltas(): ByteArray = ByteArray(0)
        }
        app.cronetEngine = Lazy { dummyCronet }
        assertTrue(app.isCronetAvailable())
    }

    @Test
    fun isHttpEngineAvailableReturnsFalseWhenUnsetOrNull() {
        val app = KickApp()
        app.httpEngine = null
        assertFalse(app.isHttpEngineAvailable())

        @Suppress("UNCHECKED_CAST")
        app.httpEngine = Lazy { null as Any? as HttpEngine }
        assertFalse(app.isHttpEngineAvailable())
    }

    @Test
    fun isHttpEngineAvailableReturnsFalseWhenThrowsException() {
        val app = KickApp()
        app.httpEngine = Lazy {
            throw IllegalStateException("HttpEngine failed to initialize")
        }
        assertFalse(app.isHttpEngineAvailable())
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.R])
    fun isHttpEngineAvailableReturnsFalseOnAndroidR() {
        HttpEngineAvailability.resetForTests()
        val app = KickApp()
        assertFalse(app.isHttpEngineAvailable())
    }

    @Test
    fun isHttpEngineAvailableReturnsFalseWhenHttpEngineThrowsNoClassDefFoundError() {
        val app = KickApp()
        app.httpEngine = Lazy {
            throw NoClassDefFoundError("android.net.http.HttpEngine")
        }
        assertFalse(app.isHttpEngineAvailable())
    }

    private fun createTestKickApp(context: Context): KickApp {
        val app = KickApp()
        val method = ContextWrapper::class.java.getDeclaredMethod("attachBaseContext", Context::class.java)
        method.isAccessible = true
        method.invoke(app, context)
        app.okHttpClient = okhttp3.OkHttpClient()
        return app
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.R])
    fun newImageLoaderConstructsCleanlyOnAndroidREvenWhenHttpEngineSelected() {
        HttpEngineAvailability.resetForTests()
        val context = RuntimeEnvironment.getApplication()
        context.prefs().edit().putString(AppConstants.NETWORK_LIBRARY, "HttpEngine").commit()
        val app = createTestKickApp(context)
        val imageLoader = app.newImageLoader(context)
        assertNotNull(imageLoader)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.R])
    fun newImageLoaderDoesNotThrowWhenHttpEngineClassIsMissing() {
        HttpEngineAvailability.resetForTests()
        val context = RuntimeEnvironment.getApplication()
        context.prefs().edit().putString(AppConstants.NETWORK_LIBRARY, "HttpEngine").commit()
        val app = createTestKickApp(context).apply {
            httpEngine = Lazy {
                throw NoClassDefFoundError("android.net.http.HttpEngine")
            }
        }
        val imageLoader = app.newImageLoader(context)
        assertNotNull(imageLoader)
    }
}
