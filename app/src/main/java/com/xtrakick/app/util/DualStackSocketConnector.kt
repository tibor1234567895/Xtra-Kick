package com.xtrakick.app.util

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import java.io.IOException
import java.net.Inet6Address
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.NetworkInterface
import java.net.Socket
import java.net.SocketException
import java.net.SocketTimeoutException
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap

/**
 * Dual-stack TCP socket connector implementing Happy Eyeballs v2 (RFC 8305).
 *
 * Resolves candidate addresses, interleaves IPv6 and IPv4, filters non-routable documentation
 * prefixes (e.g. 2001:db8::/32 created by local VPN monitors like GlassWire), and races connections
 * with a 250ms head start for the preferred family so broken IPv6 paths fall back to IPv4
 * seamlessly in ~280ms instead of hanging for 20 seconds.
 */
object DualStackSocketConnector {

    internal const val DEFAULT_CONNECT_TIMEOUT_MS = 20_000
    internal const val DEFAULT_ATTEMPT_DELAY_MS = 250L
    internal const val IPV6_FAILURE_PENALTY_MS = 10 * 60 * 1000L // 10 minutes (RFC 8305)

    private val ipv6FailureCache = ConcurrentHashMap<String, Long>()

    @Volatile
    private var lastRoutableCheckTimeMs: Long = 0L

    @Volatile
    private var cachedHasRoutableIpv6: Boolean = false

    /**
     * Connects a TCP socket to [host]:[port] using Happy Eyeballs Dual-Stack.
     */
    suspend fun connect(
        host: String,
        port: Int = 443,
        totalTimeoutMs: Int = DEFAULT_CONNECT_TIMEOUT_MS,
        attemptDelayMs: Long = DEFAULT_ATTEMPT_DELAY_MS,
        onSocketStarted: ((Socket) -> Unit)? = null,
        addressResolver: (String) -> List<InetAddress> = { InetAddress.getAllByName(it).toList() },
        socketFactory: () -> Socket = { Socket() },
        hasRoutableIpv6Provider: () -> Boolean = { hasRoutableGlobalIpv6() },
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Socket = withContext(dispatcher) {
        val allAddresses = addressResolver(host)
        if (allAddresses.isEmpty()) {
            throw SocketException("No addresses found for host: $host")
        }

        val orderedCandidates = orderCandidateAddresses(
            host = host,
            addresses = allAddresses,
            hasRoutableIpv6 = hasRoutableIpv6Provider()
        )

        if (orderedCandidates.size == 1) {
            val singleSocket = socketFactory()
            onSocketStarted?.invoke(singleSocket)
            try {
                singleSocket.connect(InetSocketAddress(orderedCandidates[0], port), totalTimeoutMs)
                return@withContext singleSocket
            } catch (e: Exception) {
                runCatching { singleSocket.close() }
                throw e
            }
        }

        raceConnections(
            host = host,
            candidates = orderedCandidates,
            port = port,
            totalTimeoutMs = totalTimeoutMs,
            attemptDelayMs = attemptDelayMs,
            onSocketStarted = onSocketStarted,
            socketFactory = socketFactory
        )
    }

    /**
     * Orders candidate IP addresses per RFC 8305:
     * - If local device lacks routable global IPv6, IPv4 is placed first.
     * - If IPv6 recently failed/timed out for this host, IPv4 is placed first.
     * - Otherwise, IPv6 is placed first, interleaved with IPv4.
     */
    internal fun orderCandidateAddresses(
        host: String,
        addresses: List<InetAddress>,
        hasRoutableIpv6: Boolean,
        nowMs: Long = System.currentTimeMillis()
    ): List<InetAddress> {
        val (ipv6List, ipv4List) = addresses.partition { it is Inet6Address }
        if (ipv6List.isEmpty()) return ipv4List
        if (ipv4List.isEmpty()) return ipv6List

        val hasRecentIpv6Failure = hasRecentIpv6Failure(host, nowMs)
        val preferIpv4 = !hasRoutableIpv6 || hasRecentIpv6Failure

        val firstList = if (preferIpv4) ipv4List else ipv6List
        val secondList = if (preferIpv4) ipv6List else ipv4List

        val result = mutableListOf<InetAddress>()
        val maxLen = maxOf(firstList.size, secondList.size)
        for (i in 0 until maxLen) {
            if (i < firstList.size) result.add(firstList[i])
            if (i < secondList.size) result.add(secondList[i])
        }
        return result
    }

    private suspend fun raceConnections(
        host: String,
        candidates: List<InetAddress>,
        port: Int,
        totalTimeoutMs: Int,
        attemptDelayMs: Long,
        onSocketStarted: ((Socket) -> Unit)?,
        socketFactory: () -> Socket
    ): Socket = coroutineScope {
        val winner = CompletableDeferred<Socket>()
        val activeSockets = ConcurrentHashMap.newKeySet<Socket>()
        val exceptions = Collections.synchronizedList(mutableListOf<Throwable>())
        val jobs = mutableListOf<Job>()
        val perAttemptTimeoutMs = totalTimeoutMs.coerceAtLeast(5_000)

        val launcherJob = launch {
            for ((index, addr) in candidates.withIndex()) {
                if (winner.isCompleted) break

                val attemptJob = launch {
                    val s = socketFactory()
                    activeSockets.add(s)
                    onSocketStarted?.invoke(s)
                    try {
                        s.connect(InetSocketAddress(addr, port), perAttemptTimeoutMs)
                        if (winner.complete(s)) {
                            activeSockets.remove(s)
                            handleConnectionSuccess(host, addr)
                        } else {
                            activeSockets.remove(s)
                            runCatching { s.close() }
                        }
                    } catch (e: Throwable) {
                        activeSockets.remove(s)
                        runCatching { s.close() }
                        exceptions.add(e)
                        if (addr is Inet6Address) {
                            markIpv6Failure(host)
                        }
                    }
                }
                jobs.add(attemptJob)

                // Give preferred address attemptDelayMs head start before launching next candidate in parallel
                if (index < candidates.lastIndex && !winner.isCompleted) {
                    withTimeoutOrNull(attemptDelayMs) {
                        attemptJob.join()
                    }
                }
            }
        }

        // Watcher: if all candidate connection jobs complete without a winner, fail immediately
        val watcherJob = launch {
            launcherJob.join()
            jobs.joinAll()
            if (!winner.isCompleted) {
                val lastEx = exceptions.lastOrNull() ?: SocketException("All connection attempts to $host failed")
                winner.completeExceptionally(lastEx)
            }
        }

        try {
            val resultSocket = withTimeout(totalTimeoutMs.toLong()) {
                winner.await()
            }
            launcherJob.cancel()
            watcherJob.cancel()
            jobs.forEach { it.cancel() }
            for (s in activeSockets) {
                runCatching { s.close() }
            }
            resultSocket
        } catch (e: Throwable) {
            launcherJob.cancel()
            watcherJob.cancel()
            jobs.forEach { it.cancel() }
            for (s in activeSockets) {
                runCatching { s.close() }
            }
            val lastEx = exceptions.lastOrNull()
            if (e is TimeoutCancellationException) {
                val msg = "Connection to $host timed out after ${totalTimeoutMs}ms" +
                    (lastEx?.message?.let { ": $it" } ?: "")
                throw SocketTimeoutException(msg).apply { if (lastEx != null) initCause(lastEx) }
            } else if (lastEx is IOException) {
                throw lastEx
            } else if (e is CancellationException) {
                throw e
            } else {
                throw IOException("Failed to connect to $host: ${e.message}", e)
            }
        }
    }

    private fun handleConnectionSuccess(host: String, connectedAddress: InetAddress) {
        if (connectedAddress is Inet6Address) {
            clearIpv6Failure(host)
        }
    }

    internal fun markIpv6Failure(host: String, nowMs: Long = System.currentTimeMillis()) {
        ipv6FailureCache[host] = nowMs
    }

    internal fun clearIpv6Failure(host: String) {
        ipv6FailureCache.remove(host)
    }

    internal fun hasRecentIpv6Failure(host: String, nowMs: Long = System.currentTimeMillis()): Boolean {
        val lastFailure = ipv6FailureCache[host] ?: return false
        if (nowMs - lastFailure < IPV6_FAILURE_PENALTY_MS) {
            return true
        }
        ipv6FailureCache.remove(host)
        return false
    }

    internal fun clearCache() {
        ipv6FailureCache.clear()
        lastRoutableCheckTimeMs = 0L
    }

    /**
     * Checks if the host device has any active, non-loopback network interface with a
     * routable global IPv6 address.
     */
    fun hasRoutableGlobalIpv6(): Boolean {
        val now = System.currentTimeMillis()
        if (now - lastRoutableCheckTimeMs < 5_000L) {
            return cachedHasRoutableIpv6
        }
        val result = try {
            val interfaces = NetworkInterface.getNetworkInterfaces() ?: return false
            var found = false
            for (nif in interfaces) {
                if (!nif.isUp || nif.isLoopback) continue
                val addrs = nif.inetAddresses ?: continue
                for (addr in addrs) {
                    if (addr is Inet6Address && isRoutableGlobalIpv6Address(addr)) {
                        found = true
                        break
                    }
                }
                if (found) break
            }
            found
        } catch (e: Exception) {
            true // If interface inspection fails, rely on Happy Eyeballs race
        }
        cachedHasRoutableIpv6 = result
        lastRoutableCheckTimeMs = now
        return result
    }

    /**
     * Rejects non-routable, link-local, multicast, documentation, or benchmarking IPv6 addresses.
     */
    fun isRoutableGlobalIpv6Address(address: Inet6Address): Boolean {
        if (address.isLoopbackAddress ||
            address.isLinkLocalAddress ||
            address.isSiteLocalAddress ||
            address.isMulticastAddress
        ) {
            return false
        }
        val bytes = address.address ?: return false
        if (bytes.size != 16) return false

        // Documentation prefix 2001:db8::/32 (RFC 3849) - used by GlassWire, NetGuard, etc.
        if (bytes[0] == 0x20.toByte() && bytes[1] == 0x01.toByte() &&
            bytes[2] == 0x0d.toByte() && bytes[3] == 0xb8.toByte()
        ) {
            return false
        }

        // Unique Local Address fc00::/7 (RFC 4193)
        if ((bytes[0].toInt() and 0xfe) == 0xfc) {
            return false
        }

        // Discard prefix 100::/64 (RFC 6666)
        if (bytes[0] == 0x01.toByte() && bytes[1] == 0x00.toByte()) {
            return false
        }

        // Benchmarking prefix 2001:2::/48 (RFC 5180)
        if (bytes[0] == 0x20.toByte() && bytes[1] == 0x01.toByte() &&
            bytes[2] == 0x00.toByte() && bytes[3] == 0x02.toByte()
        ) {
            return false
        }

        return true
    }
}
