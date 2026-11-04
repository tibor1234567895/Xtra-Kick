package com.xtrakick.app.util

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.net.Inet4Address
import java.net.Inet6Address
import java.net.InetAddress
import java.net.Socket
import java.net.SocketAddress
import java.net.SocketException

class DualStackSocketConnectorTest {

    private val ipv6Public1 = InetAddress.getByName("2606:4700::6812:14de") as Inet6Address
    private val ipv6Public2 = InetAddress.getByName("2606:4700::6812:15de") as Inet6Address
    private val ipv6DocGlassWire = InetAddress.getByName("2001:db8::1") as Inet6Address
    private val ipv6LinkLocal = InetAddress.getByName("fe80::1") as Inet6Address
    private val ipv6Loopback = InetAddress.getByName("::1") as Inet6Address
    private val ipv6Ula1 = InetAddress.getByName("fc00::1") as Inet6Address
    private val ipv6Ula2 = InetAddress.getByName("fd12:3456:789a::1") as Inet6Address
    private val ipv6Discard = InetAddress.getByName("100::1") as Inet6Address
    private val ipv6Benchmarking = InetAddress.getByName("2001:2::1") as Inet6Address

    private val ipv4Public1 = InetAddress.getByName("104.18.20.222") as Inet4Address
    private val ipv4Public2 = InetAddress.getByName("104.18.21.222") as Inet4Address

    @Before
    fun setUp() {
        DualStackSocketConnector.clearCache()
    }

    @Test
    fun identifiesNonRoutableIpv6AddressesCorrectly() {
        // GlassWire documentation prefix MUST be rejected
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6DocGlassWire))

        // Link-local, loopback, ULA, discard, benchmark MUST be rejected
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6LinkLocal))
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Loopback))
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Ula1))
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Ula2))
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Discard))
        assertFalse(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Benchmarking))

        // Genuine routable global IPv6 MUST be accepted
        assertTrue(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Public1))
        assertTrue(DualStackSocketConnector.isRoutableGlobalIpv6Address(ipv6Public2))
    }

    @Test
    fun ordersIpv4FirstWhenNoRoutableIpv6OnDevice() {
        val candidates = listOf(ipv6Public1, ipv6Public2, ipv4Public1, ipv4Public2)
        val ordered = DualStackSocketConnector.orderCandidateAddresses(
            host = "realtime.us-east-1.platform.kick.com",
            addresses = candidates,
            hasRoutableIpv6 = false
        )

        // Without routable IPv6, IPv4 must be first and interleaved: [v4_1, v6_1, v4_2, v6_2]
        assertEquals(listOf(ipv4Public1, ipv6Public1, ipv4Public2, ipv6Public2), ordered)
    }

    @Test
    fun ordersIpv6FirstInterleavedWhenRoutableIpv6Present() {
        val candidates = listOf(ipv6Public1, ipv6Public2, ipv4Public1, ipv4Public2)
        val ordered = DualStackSocketConnector.orderCandidateAddresses(
            host = "realtime.us-east-1.platform.kick.com",
            addresses = candidates,
            hasRoutableIpv6 = true
        )

        // With routable IPv6, IPv6 must be first and interleaved: [v6_1, v4_1, v6_2, v4_2]
        assertEquals(listOf(ipv6Public1, ipv4Public1, ipv6Public2, ipv4Public2), ordered)
    }

    @Test
    fun ordersIpv4FirstWhenRecentIpv6FailureRecorded() {
        val host = "realtime.us-east-1.platform.kick.com"
        val candidates = listOf(ipv6Public1, ipv4Public1)

        DualStackSocketConnector.markIpv6Failure(host)

        val ordered = DualStackSocketConnector.orderCandidateAddresses(
            host = host,
            addresses = candidates,
            hasRoutableIpv6 = true
        )

        // Recent failure forces IPv4 first even if device has routable IPv6
        assertEquals(listOf(ipv4Public1, ipv6Public1), ordered)
    }

    @Test
    fun ipv6FailureExpiresAfterPenaltyWindow() {
        val host = "realtime.us-east-1.platform.kick.com"
        val baseTime = 1_000_000L

        DualStackSocketConnector.markIpv6Failure(host, baseTime)
        assertTrue(DualStackSocketConnector.hasRecentIpv6Failure(host, baseTime + 1000L))
        assertTrue(DualStackSocketConnector.hasRecentIpv6Failure(host, baseTime + DualStackSocketConnector.IPV6_FAILURE_PENALTY_MS - 1L))

        // After penalty window, failure expires
        assertFalse(DualStackSocketConnector.hasRecentIpv6Failure(host, baseTime + DualStackSocketConnector.IPV6_FAILURE_PENALTY_MS + 1L))
    }

    @Test
    fun singleCandidateConnectsDirectly() = runBlocking {
        val socket = TestSocket()
        val connected = DualStackSocketConnector.connect(
            host = "example.com",
            port = 443,
            addressResolver = { listOf(ipv4Public1) },
            socketFactory = { socket },
            hasRoutableIpv6Provider = { false }
        )

        assertEquals(socket, connected)
        assertTrue(socket.isConnected)
    }

    @Test
    fun happyEyeballsFallsBackToIpv4WhenIpv6Hangs() = runBlocking {
        val candidates = listOf(ipv6Public1, ipv4Public1)
        val socketsCreated = mutableListOf<TestSocket>()

        val winner = DualStackSocketConnector.connect(
            host = "realtime.us-east-1.platform.kick.com",
            port = 443,
            totalTimeoutMs = 5000,
            attemptDelayMs = 50L, // Fast 50ms attempt delay for tests
            addressResolver = { candidates },
            hasRoutableIpv6Provider = { true },
            socketFactory = {
                val s = TestSocket { target ->
                    if (target == ipv6Public1) {
                        // Simulate hanging IPv6 (like GlassWire dropping SYN packets)
                        delay(2000L)
                    } else {
                        // Fast IPv4 connection
                        delay(10L)
                    }
                }
                socketsCreated.add(s)
                s
            }
        )

        val winningTestSocket = winner as TestSocket
        assertEquals(ipv4Public1, winningTestSocket.connectedAddress)
        assertTrue(winningTestSocket.isConnected)

        // Sockets: IPv6 socket was created and later closed; IPv4 won
        val ipv6Socket = socketsCreated.first { it.attemptedAddress == ipv6Public1 }
        assertTrue(ipv6Socket.isClosed)

        // Winning with IPv4 after IPv6 failed marks IPv6 as failing for this host
        assertTrue(DualStackSocketConnector.hasRecentIpv6Failure("realtime.us-east-1.platform.kick.com"))
    }

    @Test
    fun happyEyeballsPicksIpv6ImmediatelyWhenHealthy() = runBlocking {
        val candidates = listOf(ipv6Public1, ipv4Public1)
        val socketsCreated = mutableListOf<TestSocket>()

        val winner = DualStackSocketConnector.connect(
            host = "realtime.us-east-1.platform.kick.com",
            port = 443,
            totalTimeoutMs = 5000,
            attemptDelayMs = 100L,
            addressResolver = { candidates },
            hasRoutableIpv6Provider = { true },
            socketFactory = {
                val s = TestSocket { _ ->
                    // Fast healthy IPv6 connection (10ms < 100ms delay)
                    delay(10L)
                }
                socketsCreated.add(s)
                s
            }
        )

        val winningTestSocket = winner as TestSocket
        assertEquals(ipv6Public1, winningTestSocket.connectedAddress)
        assertTrue(winningTestSocket.isConnected)

        // Only IPv6 was ever created, IPv4 was never started!
        assertEquals(1, socketsCreated.size)
        assertEquals(ipv6Public1, socketsCreated[0].attemptedAddress)
    }

    @Test
    fun happyEyeballsFailsWhenAllCandidatesFail() {
        val candidates = listOf(ipv6Public1, ipv4Public1)
        val expected = SocketException("Connection refused")

        try {
            runBlocking {
                DualStackSocketConnector.connect(
                    host = "realtime.us-east-1.platform.kick.com",
                    port = 443,
                    totalTimeoutMs = 5000,
                    attemptDelayMs = 50L,
                    addressResolver = { candidates },
                    hasRoutableIpv6Provider = { true },
                    socketFactory = {
                        TestSocket { _ -> throw expected }
                    }
                )
            }
            org.junit.Assert.fail("Expected exception was not thrown")
        } catch (e: Exception) {
            assertEquals("Connection refused", e.message)
        }
    }

    private class TestSocket(
        private val onConnectHook: suspend (InetAddress) -> Unit = {}
    ) : Socket() {
        var connectedAddress: InetAddress? = null
        var attemptedAddress: InetAddress? = null
        private var closed = false
        private var connected = false

        override fun connect(endpoint: SocketAddress?, timeout: Int) {
            val inetSocketAddress = endpoint as? java.net.InetSocketAddress
            val target = inetSocketAddress?.address
            attemptedAddress = target
            runBlocking {
                onConnectHook(target ?: throw IOException("No address"))
            }
            synchronized(this) {
                if (closed) throw SocketException("Socket closed")
                connected = true
                connectedAddress = target
            }
        }

        override fun isConnected(): Boolean = synchronized(this) { connected }

        override fun isClosed(): Boolean = synchronized(this) { closed }

        override fun close() {
            synchronized(this) {
                closed = true
                connected = false
            }
        }
    }
}
