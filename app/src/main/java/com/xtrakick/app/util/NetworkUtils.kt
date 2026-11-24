package com.xtrakick.app.util

import android.net.http.HttpEngine
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import java.util.concurrent.atomic.AtomicLong
import kotlin.coroutines.EmptyCoroutineContext
import android.net.http.UrlResponseInfo
import android.os.Build
import android.os.ext.SdkExtensions
import dagger.Lazy
import okhttp3.OkHttpClient
import okhttp3.Request
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.ensureActive
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import okhttp3.internal.closeQuietly
import org.chromium.net.CronetEngine
import org.chromium.net.CronetException
import org.chromium.net.UrlRequest as CronetUrlRequest
import org.chromium.net.UrlResponseInfo as CronetUrlResponseInfo
import java.util.concurrent.ExecutorService
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.OutputStream
import java.nio.ByteBuffer
import java.nio.channels.Channels
import java.nio.channels.WritableByteChannel
import java.util.concurrent.TimeUnit
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

// Ported from https://github.com/crackededed/Xtra (NetworkUtils.kt), merged with the
// fork's original updater progress callback:
// - inactivity based timeouts for Cronet / Android HttpEngine requests (the deadline
//   resets whenever body bytes arrive, so long transfers are not cut off while stalled
//   connections do not hang forever)
// - progress reporting interceptors / callbacks
// - a coroutine cancellable wrapper around OkHttp Call.execute()
object NetworkUtils {
    internal suspend fun <T> awaitDownloadRequest(
        timeoutMs: Long = DEFAULT_TIMEOUT_MS,
        start: (Continuation<T>, () -> Unit) -> (() -> Unit),
    ): T = coroutineScope {
        val deferred = CompletableDeferred<T>()
        val deadline = AtomicLong(System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMs))
        val callback = object : Continuation<T> {
            override val context = EmptyCoroutineContext
            override fun resumeWith(result: Result<T>) {
                result.fold(deferred::complete, deferred::completeExceptionally)
            }
        }
        ensureActive()
        val cancel = start(callback) {
            deadline.set(System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMs))
        }
        val timeout = launch {
            while (isActive && !deferred.isCompleted) {
                val remaining = TimeUnit.NANOSECONDS.toMillis(deadline.get() - System.nanoTime())
                if (remaining <= 0L) {
                    cancel()
                    break
                }
                delay(remaining.coerceAtLeast(1L))
            }
        }
        try {
            deferred.await()
        } finally {
            timeout.cancel()
            // Keep the documented TLS cancellation grace, then await the concrete
            // request's terminal callback before a caller can close its output.
            withContext(NonCancellable) {
                if (!deferred.isCompleted) {
                    delay(2_000L)
                    if (!deferred.isCompleted) cancel()
                    deferred.join()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun downloadHttpEngine(
        engine: HttpEngine, url: String, executor: ExecutorService,
        range: String? = null, output: OutputStream? = null,
        onContentLength: ((Long) -> Unit)? = null,
    ): Pair<UrlResponseInfo, ByteArray> = awaitDownloadRequest { continuation, touch ->
        val request = engine.newUrlRequestBuilder(url, executor,
            HttpEngineUtils.byteArrayUrlCallback(continuation, ProgressListener { touch() }, output, onContentLength))
            .apply { if (range != null) addHeader("Range", range) }.build()
        val cancel: () -> Unit = { request.cancel() }
        request.start()
        cancel
    }

    suspend fun downloadCronet(
        engine: CronetEngine, url: String, executor: ExecutorService,
        range: String? = null, output: OutputStream? = null,
        onContentLength: ((Long) -> Unit)? = null,
    ): Pair<CronetUrlResponseInfo, ByteArray> = awaitDownloadRequest { continuation, touch ->
        val request = engine.newUrlRequestBuilder(url,
            ByteArrayCronetUrlCallback(continuation, ProgressListener { touch() }, output, onContentLength), executor)
            .apply { if (range != null) addHeader("Range", range) }.build()
        val cancel: () -> Unit = { request.cancel() }
        request.start()
        cancel
    }

    // With cancelCallOnCancellation = false the HTTP call finishes normally even when
    // the coroutine is cancelled; the caller's result is discarded. Used by downloads
    // whose segment writes are idempotent so that stopping a download does not
    // abruptly tear down many TLS connections at once.
    suspend fun <T> Call.useCancellable(cancelCallOnCancellation: Boolean = true, block: suspend (Response) -> T): T = coroutineScope {
        val call = this@useCancellable
        val cancellationWatcher = if (cancelCallOnCancellation) {
            launch(start = CoroutineStart.UNDISPATCHED) {
                try {
                    awaitCancellation()
                } finally {
                    call.cancel()
                }
            }
        } else null
        try {
            withContext(Dispatchers.IO) { call.execute().use { block(it) } }
        } catch (error: Exception) {
            ensureActive()
            throw error
        } finally {
            cancellationWatcher?.cancel()
        }
    }

    private const val BYTE_BUFFER_CAPACITY = 32 * 1024
    private const val DEFAULT_TIMEOUT_MS = 20_000L

    fun interface ProgressListener {
        fun update(bytesRead: Int)
    }

    // Byte-array Cronet callback with redirect following and optional progress
    // reporting. Unlike the apihelpers ByteArrayCronetCallback, this exposes the
    // bytes read so far so callers can show download progress.
    class ByteArrayCronetUrlCallback(
        private val continuation: Continuation<Pair<CronetUrlResponseInfo, ByteArray>>,
        private val progressListener: ProgressListener? = null,
        private val output: OutputStream? = null,
        private val onContentLength: ((Long) -> Unit)? = null,
    ) : CronetUrlRequest.Callback() {
        private lateinit var mResponseBodyStream: ByteArrayOutputStream
        private lateinit var mResponseBodyChannel: WritableByteChannel
        private var bytesRead = 0

        override fun onRedirectReceived(request: CronetUrlRequest, info: CronetUrlResponseInfo, newLocationUrl: String) {
            request.followRedirect()
        }

        override fun onResponseStarted(request: CronetUrlRequest, info: CronetUrlResponseInfo) {
            onContentLength?.invoke(info.allHeaders.entries.firstOrNull { it.key.equals("Content-Length", true) }
                ?.value?.firstOrNull()?.toLongOrNull() ?: -1L)
            mResponseBodyStream = ByteArrayOutputStream()
            mResponseBodyChannel = Channels.newChannel(output ?: mResponseBodyStream)
            request.read(ByteBuffer.allocateDirect(BYTE_BUFFER_CAPACITY))
        }

        override fun onReadCompleted(request: CronetUrlRequest, info: CronetUrlResponseInfo, byteBuffer: ByteBuffer) {
            byteBuffer.flip()
            val count = byteBuffer.remaining()
            try {
                mResponseBodyChannel.write(byteBuffer)
            } catch (error: IOException) {
                request.cancel()
                return
            }
            bytesRead += count
            byteBuffer.clear()
            progressListener?.update(bytesRead)
            request.read(byteBuffer)
        }

        override fun onSucceeded(request: CronetUrlRequest, info: CronetUrlResponseInfo) {
            continuation.resume(Pair(info, mResponseBodyStream.toByteArray()))
        }

        override fun onFailed(request: CronetUrlRequest, info: CronetUrlResponseInfo?, error: CronetException) {
            continuation.resumeWithException(error)
        }

        override fun onCanceled(request: CronetUrlRequest, info: CronetUrlResponseInfo?) {
            continuation.resumeWithException(IOException("The request was canceled!"))
        }
    }

    suspend fun Call.executeAsync(): Response =
        suspendCancellableCoroutine { continuation ->
            continuation.invokeOnCancellation {
                this.cancel()
            }
            this.enqueue(
                object : Callback {
                    override fun onFailure(
                        call: Call,
                        e: okio.IOException,
                    ) {
                        continuation.resumeWithException(e)
                    }

                    override fun onResponse(
                        call: Call,
                        response: Response,
                    ) {
                        continuation.resume(response) { _, value, _ ->
                            value.closeQuietly()
                        }
                    }
                },
            )
        }

    /**
     * Typed [Any] on purpose; guard use sites with `http is HttpEngine`. A suspend function keeps
     * locals across suspension points and restores them with a cast to their declared type on every
     * resume. A local declared as [HttpEngine] therefore throws NoClassDefFoundError after an OkHttp
     * or Cronet suspension on devices without the class (b223, Android 10-13).
     */
    fun resolveHttpEngine(networkLibrary: String?, httpEngine: Lazy<HttpEngine>?): Any? {
        if (networkLibrary != "HttpEngine" || !HttpEngineAvailability.isAvailable) return null
        return runCatching { httpEngine?.get() }.getOrNull()
    }

    fun resolveCronetEngine(networkLibrary: String?, cronetEngine: Lazy<CronetEngine>?): CronetEngine? {
        if (networkLibrary != "Cronet") return null
        return runCatching { cronetEngine?.get() }.getOrNull()
    }

    /**
     * Small-file GET across the three engines. Preserves current behavior:
     * no timeout, follow redirects, OkHttp fallback. Cancellable.
     */
    suspend fun fetchBytesRaw(
        httpEngine: Lazy<HttpEngine>?,
        cronetEngine: Lazy<CronetEngine>?,
        executor: ExecutorService,
        okHttp: OkHttpClient,
        networkLibrary: String?,
        url: String,
    ): Pair<Int, ByteArray> {
        val http = resolveHttpEngine(networkLibrary, httpEngine)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 &&
            http is HttpEngine) {
            val response = withTimeout(DEFAULT_TIMEOUT_MS) {
                suspendCancellableCoroutine { continuation ->
                    val request = http.newUrlRequestBuilder(
                        url,
                        executor,
                        HttpEngineUtils.byteArrayUrlCallback(continuation)
                    ).build()
                    continuation.invokeOnCancellation { request.cancel() }
                    request.start()
                }
            }
            return response.first.httpStatusCode to response.second
        }
        val cronet = resolveCronetEngine(networkLibrary, cronetEngine)
        if (cronet != null) {
            val response = withTimeout(DEFAULT_TIMEOUT_MS) {
                suspendCancellableCoroutine { continuation ->
                    val request = cronet.newUrlRequestBuilder(
                        url,
                        getByteArrayCronetCallback(continuation),
                        executor
                    ).build()
                    continuation.invokeOnCancellation { request.cancel() }
                    request.start()
                }
            }
            return response.first.httpStatusCode to response.second
        }
        return okHttp.newCall(Request.Builder().url(url).build()).useCancellable { response ->
            response.code to response.body.bytes()
        }
    }
}
