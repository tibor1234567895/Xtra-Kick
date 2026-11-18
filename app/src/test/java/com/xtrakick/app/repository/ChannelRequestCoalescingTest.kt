package com.xtrakick.app.repository

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ChannelRequestCoalescingTest {
    @Test
    fun activeWaiterRetriesAfterOwnerIsCanceled() = runBlocking {
        val requests = mutableMapOf<String, CompletableDeferred<String>>()
        val owner = async(start = CoroutineStart.UNDISPATCHED) {
            coalesceChannelRequest(requests, "channel") { awaitCancellation() }
        }
        val waiter = async(start = CoroutineStart.UNDISPATCHED) {
            coalesceChannelRequest(requests, "channel") { "retried" }
        }
        owner.cancelAndJoin()
        assertEquals("retried", waiter.await())
        assertTrue(requests.isEmpty())
    }

    @Test
    fun cancelingWaiterDoesNotCancelOwnerOrStartAnotherFetch() = runBlocking {
        val requests = mutableMapOf<String, CompletableDeferred<String>>()
        val response = CompletableDeferred<String>()
        val owner = async(start = CoroutineStart.UNDISPATCHED) {
            coalesceChannelRequest(requests, "channel") { response.await() }
        }
        val waiter = async(start = CoroutineStart.UNDISPATCHED) {
            coalesceChannelRequest(requests, "channel") { error("Duplicate fetch") }
        }
        waiter.cancelAndJoin()
        response.complete("original")
        assertEquals("original", owner.await())
        assertTrue(requests.isEmpty())
    }
}
