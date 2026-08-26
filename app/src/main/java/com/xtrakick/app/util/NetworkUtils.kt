package com.xtrakick.app.util

import org.chromium.net.CronetException
import org.chromium.net.UrlRequest
import org.chromium.net.UrlResponseInfo
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.channels.Channels
import java.nio.channels.WritableByteChannel
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

// Ported from https://github.com/crackededed/Xtra (NetworkUtils.kt), trimmed to
// what the app updater needs: progress reporting for in-app APK downloads.
object NetworkUtils {

    fun interface ProgressListener {
        fun update(bytesRead: Int)
    }

    // Byte-array Cronet callback with redirect following and optional progress
    // reporting. Unlike the apihelpers ByteArrayCronetCallback, this exposes the
    // bytes read so far so callers can show download progress.
    class ByteArrayCronetUrlCallback(
        private val continuation: Continuation<Pair<UrlResponseInfo, ByteArray>>,
        private val progressListener: ProgressListener? = null,
    ) : UrlRequest.Callback() {
        private lateinit var mResponseBodyStream: ByteArrayOutputStream
        private lateinit var mResponseBodyChannel: WritableByteChannel

        override fun onRedirectReceived(request: UrlRequest, info: UrlResponseInfo, newLocationUrl: String) {
            request.followRedirect()
        }

        override fun onResponseStarted(request: UrlRequest, info: UrlResponseInfo) {
            mResponseBodyStream = ByteArrayOutputStream()
            mResponseBodyChannel = Channels.newChannel(mResponseBodyStream)
            request.read(ByteBuffer.allocateDirect(32 * 1024))
        }

        override fun onReadCompleted(request: UrlRequest, info: UrlResponseInfo, byteBuffer: ByteBuffer) {
            byteBuffer.flip()
            mResponseBodyChannel.write(byteBuffer)
            byteBuffer.clear()
            progressListener?.update(mResponseBodyStream.size())
            request.read(byteBuffer)
        }

        override fun onSucceeded(request: UrlRequest, info: UrlResponseInfo) {
            continuation.resume(Pair(info, mResponseBodyStream.toByteArray()))
        }

        override fun onFailed(request: UrlRequest, info: UrlResponseInfo?, error: CronetException) {
            continuation.resumeWithException(error)
        }

        override fun onCanceled(request: UrlRequest, info: UrlResponseInfo?) {
            continuation.resumeWithException(IOException("The request was canceled!"))
        }
    }
}
