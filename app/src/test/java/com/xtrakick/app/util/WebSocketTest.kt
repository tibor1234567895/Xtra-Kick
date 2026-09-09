package com.xtrakick.app.util

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.EOFException
import java.io.IOException
import java.nio.ByteBuffer
import java.util.zip.Deflater
import java.util.zip.Inflater
import java.net.Socket

class WebSocketTest {
    @Test
    fun outgoingCompressedMessagesCanBeDecodedByOnePersistentInflater() = runBlocking {
        val socket = socket(byteArrayOf())
        val output = ByteArrayOutputStream()
        WebSocket::class.java.getDeclaredField("socket").apply { isAccessible = true; set(socket, Socket()) }
        WebSocket::class.java.getDeclaredField("outputStream").apply { isAccessible = true; set(socket, output) }
        WebSocket::class.java.getDeclaredField("useCompression").apply { isAccessible = true; set(socket, true) }
        val inflater = Inflater(true)
        try {
            for (message in listOf("hello ".repeat(2000), "different ".repeat(2000))) {
                output.reset()
                socket.write(message)
                val frame = ByteBuffer.wrap(output.toByteArray())
                assertEquals(0xc1, frame.get().toInt() and 0xff)
                val sizeByte = frame.get().toInt() and 0x7f
                val size = when (sizeByte) {
                    126 -> frame.short.toInt() and 0xffff
                    127 -> frame.long.toInt()
                    else -> sizeByte
                }
                val mask = ByteArray(4).also(frame::get)
                val compressed = ByteArray(size) { (frame.get().toInt() xor mask[it % 4].toInt()).toByte() }
                inflater.setInput(compressed + byteArrayOf(0, 0, -1, -1))
                val decoded = ByteArrayOutputStream()
                val buffer = ByteArray(8192)
                while (!inflater.needsInput()) {
                    val count = inflater.inflate(buffer)
                    decoded.write(buffer, 0, count)
                }
                assertEquals(message, decoded.toString("UTF-8"))
            }
        } finally {
            inflater.end()
        }
    }

    @Test
    fun handshakeReaderLeavesFirstFrameUntouched() {
        val input = ByteArrayInputStream("Upgrade: websocket\r\n\r\n".toByteArray() + byteArrayOf(0x81.toByte()))
        assertEquals("Upgrade: websocket", WebSocket.readHandshakeLine(input))
        assertEquals("", WebSocket.readHandshakeLine(input))
        assertEquals(129, input.read())
    }

    @Test
    fun compressedMessageCanSpanFrames() = runBlocking {
        val deflater = Deflater(Deflater.DEFAULT_COMPRESSION, true)
        val compressed = try {
            deflater.setInput("hello hello hello".toByteArray())
            val buffer = ByteArray(100)
            val size = deflater.deflate(buffer, 0, buffer.size, Deflater.SYNC_FLUSH)
            buffer.copyOf(size - 4)
        } finally {
            deflater.end()
        }
        val split = compressed.size / 2
        val frames = byteArrayOf(0x41, split.toByte()) + compressed.copyOfRange(0, split) +
            byteArrayOf(0x80.toByte(), (compressed.size - split).toByte()) + compressed.copyOfRange(split, compressed.size)
        val messages = mutableListOf<String>()
        val socket = socket(frames, messages)
        WebSocket::class.java.getDeclaredField("useCompression").apply { isAccessible = true; set(socket, true) }
        socket.readNextFrame()
        socket.readNextFrame()
        assertEquals(listOf("hello hello hello"), messages)
    }

    private fun socket(bytes: ByteArray, messages: MutableList<String> = mutableListOf()): WebSocket {
        val socket = WebSocket("wss://example.com", null, object : WebSocket.Listener {
            override suspend fun onMessage(webSocket: WebSocket, message: String) {
                messages.add(message)
            }
        })
        WebSocket::class.java.getDeclaredField("inputStream").apply {
            isAccessible = true
            set(socket, ByteArrayInputStream(bytes))
        }
        return socket
    }

    @Test
    fun rejectsOversizedLengthBeforeAllocatingPayload() {
        val frame = byteArrayOf(0x81.toByte(), 127) + ByteBuffer.allocate(8).putLong(1L shl 32).array()
        assertThrows(IOException::class.java) { runBlocking { socket(frame).readNextFrame() } }
    }

    @Test
    fun rejectsTruncatedLength() {
        assertThrows(EOFException::class.java) {
            runBlocking { socket(byteArrayOf(0x81.toByte(), 126, 0)).readNextFrame() }
        }
    }

    @Test
    fun rejectsTruncatedPayload() {
        assertThrows(EOFException::class.java) {
            runBlocking { socket(byteArrayOf(0x81.toByte(), 3, 65)).readNextFrame() }
        }
    }

    @Test
    fun rejectsMaskedServerFrame() {
        assertThrows(IOException::class.java) {
            runBlocking { socket(byteArrayOf(0x81.toByte(), 0x80.toByte())).readNextFrame() }
        }
    }

    @Test
    fun deliversFragmentedTextOnce() = runBlocking {
        val messages = mutableListOf<String>()
        val socket = socket(byteArrayOf(1, 1, 65, 0x80.toByte(), 1, 66), messages)
        socket.readNextFrame()
        assertEquals(emptyList<String>(), messages)
        socket.readNextFrame()
        assertEquals(listOf("AB"), messages)
    }
}
