package com.xtrakick.app.util

import android.os.Build
import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedWriter
import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.Socket
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.security.MessageDigest
import java.util.Timer
import java.util.zip.Deflater
import java.util.zip.Inflater
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.SSLSocket
import javax.net.ssl.X509TrustManager
import kotlin.concurrent.schedule
import kotlin.coroutines.cancellation.CancellationException
import kotlin.random.Random
import kotlin.math.min
import com.xtrakick.app.util.chat.WebSocketDisconnectUtils

class WebSocket(
    private val url: String,
    private val trustManager: X509TrustManager?,
    private val listener: Listener,
    private val headers: Map<String, String>? = null,
    private val sendPings: Boolean = false,
) {
    @Volatile private var socket: Socket? = null
    private var inputStream: InputStream? = null
    private var outputStream: OutputStream? = null
    private var pingTimer: Timer? = null
    private var pongTimer: Timer? = null
    private var messageBytes: ByteArrayOutputStream? = null
    private val inflater = Inflater(true)
    private var serverNoContextTakeover = false
    private var useCompression = false
    private var nextFrameCompressed = false
    private var connectionAttempt = 0
    private var delayReconnect = false
    private var isConnected = false
    private val writeLock = Any()

    suspend fun start() = withContext(Dispatchers.IO) {
        val cancellationWatcher = launch(start = CoroutineStart.UNDISPATCHED) {
            try {
                awaitCancellation()
            } finally {
                runCatching { socket?.close() }
            }
        }
        try {
            while (isActive) {
                try {
                    connectionAttempt += 1
                    val error = connect()
                    if (error) {
                        close()
                        return@withContext
                    }
                    connectionAttempt = 0
                    var end = false
                    while (!end) {
                        end = readNextFrame()
                    }
                } catch (e: CancellationException) {
                    ensureActive()
                } catch (e: SSLHandshakeException) {
                    listener.onDisconnect(this@WebSocket, e.toString(), e.stackTraceToString())
                    close()
                    return@withContext
                } catch (e: Exception) {
                    if (socket?.isClosed != true) {
                        listener.onDisconnect(this@WebSocket, e.toString(), e.stackTraceToString())
                    }
                }
                close()
                if (connectionAttempt >= 20) {
                    return@withContext
                }
                if (delayReconnect) {
                    delayReconnect = false
                    delay(60000)
                    WebSocketRuntime.onReconnectScheduled(connectionAttempt, 60000, "rate_limited")
                } else {
                    val delayMs = reconnectDelayMs(connectionAttempt)
                    WebSocketRuntime.onReconnectScheduled(connectionAttempt, delayMs, "retry")
                    delay(delayMs)
                }
            }
        } finally {
            withContext(NonCancellable) { close() }
            cancellationWatcher.cancel()
        }
    }

    suspend fun connect(): Boolean = withContext(Dispatchers.IO) {
        val urlWithoutScheme = url.substringAfter("://")
        val host = urlWithoutScheme.substringBefore("/")
        val path = urlWithoutScheme.substringAfter('/', "")
        val socketFactory = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> SSLSocketFactory.getDefault()
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> SSLContext.getDefault().socketFactory
            else -> {
                val sslContext = SSLContext.getInstance("TLSv1.3")
                sslContext.init(null, arrayOf(trustManager), null)
                sslContext.socketFactory
            }
        }
        val transport = Socket()
        socket = transport
        ensureActive()
        transport.connect(InetSocketAddress(host, 443), 20_000)
        val tlsSocket = (socketFactory as SSLSocketFactory).createSocket(transport, host, 443, true) as SSLSocket
        socket = tlsSocket
        ensureActive()
        tlsSocket.sslParameters = tlsSocket.sslParameters.apply {
            endpointIdentificationAlgorithm = "HTTPS"
        }
        tlsSocket.soTimeout = 20_000
        tlsSocket.startHandshake()
        inputStream = socket?.inputStream
        outputStream = socket?.outputStream
        val handshakeInput = requireNotNull(inputStream)
        val writer = BufferedWriter(OutputStreamWriter(outputStream))
        val key = Base64.encodeToString(Random.nextBytes(16), Base64.NO_WRAP)
        writer.write("GET /$path HTTP/1.1\r\n")
        writer.write("Host: $host\r\n")
        writer.write("Upgrade: websocket\r\n")
        writer.write("Connection: Upgrade\r\n")
        writer.write("Sec-WebSocket-Key: $key\r\n")
        writer.write("Sec-WebSocket-Version: 13\r\n")
        writer.write("Sec-WebSocket-Extensions: permessage-deflate\r\n")
        headers?.forEach {
            writer.write("${it.key}: ${it.value}\r\n")
        }
        writer.write("\r\n")
        writer.flush()
        useCompression = false
        messageBytes = null
        inflater.reset()
        serverNoContextTakeover = false
        var validated = false
        var line = readHandshakeLine(handshakeInput)
        if (line == null) {
            listener.onDisconnect(this@WebSocket, "Connection closed before websocket handshake completed")
            return@withContext true
        }
        if (!line.startsWith("HTTP/1.1 101", true)) {
            listener.onDisconnect(this@WebSocket, line)
            if (line.startsWith("HTTP/1.1 429", true)) {
                delayReconnect = true
                throw IOException("WebSocket handshake rate limited")
            } else if (WebSocketDisconnectUtils.isTransientGatewayFailure(line)) {
                throw IOException("Transient WebSocket handshake failure")
            } else {
                return@withContext true
            }
        }
        line = readHandshakeLine(handshakeInput)
        var headerCount = 0
        while (!line.isNullOrBlank()) {
            if (++headerCount > 100) throw IOException("Too many WebSocket handshake headers")
            when {
                line.startsWith("Sec-WebSocket-Accept", true) -> {
                    val messageDigest = MessageDigest.getInstance("SHA-1")
                    messageDigest.update((key + ACCEPT_UUID).toByteArray())
                    val acceptString = Base64.encodeToString(messageDigest.digest(), Base64.NO_WRAP)
                    if (line.substringAfter(": ") == acceptString) {
                        validated = true
                    }
                }
                line.startsWith("Sec-WebSocket-Extensions", true) -> {
                    serverNoContextTakeover = line.contains("server_no_context_takeover", true)
                    useCompression = line.substringAfter(": ").split(", ").find {
                        it.startsWith("permessage-deflate", true)
                    } != null
                }
            }
            line = readHandshakeLine(handshakeInput)
        }
        if (!validated) {
            listener.onDisconnect(this@WebSocket, "")
            return@withContext true
        }
        if (sendPings) {
            startPingTimer()
        }
        tlsSocket.soTimeout = 0
        setConnectedState(true)
        listener.onConnect(this@WebSocket)
        return@withContext false
    }

    private suspend fun startPingTimer() = withContext(Dispatchers.IO) {
        pingTimer?.cancel()
        pingTimer = Timer().apply {
            schedule(270000) {
                if (socket?.isClosed == false) {
                    launch {
                        writeControlFrame(OPCODE_PING, byteArrayOf())
                        startPongTimer()
                    }
                }
            }
        }
    }

    private suspend fun startPongTimer() = withContext(Dispatchers.IO) {
        pongTimer?.cancel()
        pongTimer = Timer().apply {
            schedule(10000) {
                try {
                    socket?.close()
                } catch (e: Exception) {

                }
            }
        }
    }

    suspend fun readNextFrame(): Boolean = withContext(Dispatchers.IO) {
        val currentInput = inputStream ?: return@withContext true
        val firstByte = currentInput.read()
        if (firstByte < 0) {
            return@withContext true
        }
        val isFinalFrame = firstByte and FIN_BIT != 0
        val compressed = useCompression && firstByte and COMPRESSED_BIT != 0
        val opcode = firstByte and OPCODE
        val isControlFrame = firstByte and OPCODE_CONTROL_FRAME != 0
        val secondByte = currentInput.read()
        if (secondByte < 0) {
            return@withContext true
        }
        val lengthBytes = secondByte and LENGTH
        val length = when (lengthBytes) {
            LENGTH_SHORT -> {
                val size = 2
                val array = ByteArray(size)
                DataInputStream(currentInput).readFully(array)
                ByteBuffer.wrap(array).short.toInt() and 0xffff
            }
            LENGTH_LONG -> {
                val size = 8
                val array = ByteArray(size)
                DataInputStream(currentInput).readFully(array)
                val longLength = ByteBuffer.wrap(array).long
                if (longLength < 0 || longLength > MAX_MESSAGE_BYTES) {
                    throw IOException("WebSocket frame exceeds size limit")
                }
                longLength.toInt()
            }
            else -> lengthBytes
        }
        if (length > MAX_MESSAGE_BYTES || (isControlFrame && (!isFinalFrame || length > 125))) {
            throw IOException("Invalid WebSocket frame size")
        }
        if (secondByte and MASKED_BIT != 0) throw IOException("Masked server frame")
        val data = ByteArray(length)
        DataInputStream(currentInput).readFully(data)
        if (isControlFrame) {
            when (opcode) {
                OPCODE_PING -> {
                    writeControlFrame(OPCODE_PONG, data)
                }
                OPCODE_PONG -> {
                    if (sendPings) {
                        pingTimer?.cancel()
                        pongTimer?.cancel()
                        startPingTimer()
                    }
                }
                OPCODE_CLOSE -> {
                    val code = data.copyOf(2)
                    writeControlFrame(OPCODE_CLOSE, code)
                    close()
                }
            }
        } else {
            when (opcode) {
                OPCODE_TEXT, OPCODE_CONTINUATION -> {
                    if (opcode == OPCODE_TEXT) {
                        if (messageBytes != null) throw IOException("Unexpected text frame during fragmented message")
                        messageBytes = ByteArrayOutputStream()
                        nextFrameCompressed = compressed
                    } else if (messageBytes == null || compressed) {
                        throw IOException("Invalid WebSocket continuation")
                    }
                    val accumulator = requireNotNull(messageBytes)
                    if (accumulator.size().toLong() + data.size > MAX_MESSAGE_BYTES) {
                        throw IOException("WebSocket message exceeds size limit")
                    }
                    accumulator.write(data)
                    if (isFinalFrame) {
                        val completeMessage = if (nextFrameCompressed) inflateMessage(accumulator.toByteArray()) else accumulator.toByteArray()
                        nextFrameCompressed = false
                        messageBytes = null
                        listener.onMessage(this@WebSocket, completeMessage.decodeToString())
                    }
                }
            }
        }
        return@withContext false
    }

    private fun inflateMessage(data: ByteArray): ByteArray {
        inflater.setInput(data + byteArrayOf(0, 0, -1, -1))
        val output = ByteArrayOutputStream()
        val buffer = ByteArray(8192)
        while (!inflater.needsInput()) {
            val count = inflater.inflate(buffer)
            if (output.size().toLong() + count > MAX_MESSAGE_BYTES) throw IOException("WebSocket message exceeds size limit")
            output.write(buffer, 0, count)
            if (count == 0 && !inflater.needsInput()) throw IOException("Invalid compressed WebSocket message")
        }
        if (serverNoContextTakeover) inflater.reset()
        return output.toByteArray()
    }

    private suspend fun writeControlFrame(opcode: Int, data: ByteArray) = withContext(Dispatchers.IO) {
        val output = ByteArrayOutputStream()
        val firstByte = FIN_BIT or opcode
        output.write(firstByte)
        val dataSize = data.size
        val secondByte = MASKED_BIT or dataSize
        output.write(secondByte)
        val maskKey = Random.nextBytes(4)
        output.write(maskKey)
        if (dataSize > 0) {
            val maskedData = data.mapIndexed { index, byte ->
                (byte.toInt() xor maskKey[index % 4].toInt()).toByte()
            }.toByteArray()
            output.write(maskedData)
        }
        synchronized(writeLock) {
            if (socket?.isClosed == false) outputStream?.let { output.writeTo(it) }
        }
    }

    suspend fun write(message: String) = withContext(Dispatchers.IO) {
        val output = ByteArrayOutputStream()
        var firstByte = FIN_BIT or OPCODE_TEXT
        val messageBytes = message.toByteArray()
        val data = if (useCompression && messageBytes.size >= MINIMUM_DEFLATE_SIZE) {
            firstByte = firstByte or COMPRESSED_BIT
            val compressedStream = ByteArrayOutputStream()
            val deflater = Deflater(Deflater.DEFAULT_COMPRESSION, true)
            try {
                deflater.setInput(messageBytes)
                val buffer = ByteArray(8192)
                do {
                    val count = deflater.deflate(buffer, 0, buffer.size, Deflater.SYNC_FLUSH)
                    compressedStream.write(buffer, 0, count)
                } while (count == buffer.size)
                compressedStream.toByteArray().let { it.copyOf(it.size - 4) }
            } finally {
                deflater.end()
            }
        } else {
            messageBytes
        }
        output.write(firstByte)
        val dataSize = data.size
        when {
            dataSize <= LENGTH_BYTE_MAX -> {
                val secondByte = MASKED_BIT or dataSize
                output.write(secondByte)
            }
            dataSize <= LENGTH_SHORT_MAX -> {
                val secondByte = MASKED_BIT or LENGTH_SHORT
                output.write(secondByte)
                val sizeBytes = ByteBuffer.allocate(2).putShort(dataSize.toShort()).array()
                output.write(sizeBytes)
            }
            else -> {
                val secondByte = MASKED_BIT or LENGTH_LONG
                output.write(secondByte)
                val sizeBytes = ByteBuffer.allocate(8).putLong(dataSize.toLong()).array()
                output.write(sizeBytes)
            }
        }
        val maskKey = Random.nextBytes(4)
        output.write(maskKey)
        val maskedData = ByteArray(data.size) { index -> (data[index].toInt() xor maskKey[index % 4].toInt()).toByte() }
        output.write(maskedData)
        synchronized(writeLock) {
            if (socket?.isClosed == false) outputStream?.let { output.writeTo(it) }
        }
    }

    suspend fun disconnect() = withContext(Dispatchers.IO) {
        pingTimer?.cancel()
        pongTimer?.cancel()
        pingTimer = null
        pongTimer = null
        if (socket?.isClosed == false) {
            try {
                val currentSocket = socket
                writeControlFrame(OPCODE_CLOSE, ByteBuffer.allocate(2).putShort(1000).array())
                delay(5000)
                currentSocket?.close()
            } catch (e: Exception) {

            }
        }
        setConnectedState(false)
        socket = null
        inputStream = null
        outputStream = null
    }

    private suspend fun close() = withContext(Dispatchers.IO) {
        pingTimer?.cancel()
        pongTimer?.cancel()
        pingTimer = null
        pongTimer = null
        try {
            socket?.close()
        } catch (e: Exception) {

        }
        setConnectedState(false)
        socket = null
        inputStream = null
        outputStream = null
    }

    private fun setConnectedState(connected: Boolean) {
        if (isConnected == connected) {
            return
        }
        isConnected = connected
        if (connected) {
            WebSocketRuntime.onConnected()
        } else {
            WebSocketRuntime.onDisconnected()
        }
    }

    private fun reconnectDelayMs(attempt: Int): Long {
        val retryAttempt = attempt.coerceAtLeast(1)
        val baseDelayMs = if (WebSocketRuntime.isAppInForeground) {
            BASE_RECONNECT_DELAY_MS
        } else {
            BACKGROUND_BASE_RECONNECT_DELAY_MS
        }
        val maxDelayMs = if (WebSocketRuntime.isAppInForeground) {
            MAX_RECONNECT_DELAY_MS
        } else {
            BACKGROUND_MAX_RECONNECT_DELAY_MS
        }
        val baseDelay = min(maxDelayMs, baseDelayMs shl (retryAttempt - 1))
        val jitter = Random.nextLong(MAX_RECONNECT_JITTER_MS + 1)
        return min(maxDelayMs, baseDelay + jitter)
    }

    interface Listener {
        suspend fun onConnect(webSocket: WebSocket) {}
        suspend fun onMessage(webSocket: WebSocket, message: String) {}
        suspend fun onDisconnect(webSocket: WebSocket, message: String, fullMsg: String? = null) {}
    }

    companion object {
        internal fun readHandshakeLine(input: InputStream): String? {
            val line = ByteArrayOutputStream()
            while (line.size() < 8192) {
                val byte = input.read()
                if (byte == -1) {
                    if (line.size() == 0) return null
                    throw IOException("Truncated WebSocket handshake")
                }
                if (byte == 10) return line.toString("US-ASCII").removeSuffix("\r")
                line.write(byte)
            }
            throw IOException("WebSocket handshake line exceeds size limit")
        }

        private const val ACCEPT_UUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"
        private const val MAX_MESSAGE_BYTES = 8 * 1024 * 1024
        private const val FIN_BIT = 128
        private const val COMPRESSED_BIT = 64
        private const val OPCODE = 15
        private const val OPCODE_CONTROL_FRAME = 8
        private const val MASKED_BIT = 128
        private const val LENGTH = 127
        private const val LENGTH_SHORT = 126
        private const val LENGTH_LONG = 127
        private const val LENGTH_BYTE_MAX = 125
        private const val LENGTH_SHORT_MAX = 0xffff
        private const val OPCODE_CONTINUATION = 0x0
        private const val OPCODE_TEXT = 0x1
        private const val OPCODE_CLOSE = 0x8
        private const val OPCODE_PING = 0x9
        private const val OPCODE_PONG = 0xa
        private const val MINIMUM_DEFLATE_SIZE = 1024
        private const val BASE_RECONNECT_DELAY_MS = 1000L
        private const val MAX_RECONNECT_DELAY_MS = 30000L
        private const val BACKGROUND_BASE_RECONNECT_DELAY_MS = 4000L
        private const val BACKGROUND_MAX_RECONNECT_DELAY_MS = 60000L
        private const val MAX_RECONNECT_JITTER_MS = 1000L
    }
}
