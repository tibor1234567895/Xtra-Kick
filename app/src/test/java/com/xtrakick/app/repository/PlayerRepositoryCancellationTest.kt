package com.xtrakick.app.repository

import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.net.ServerSocket
import java.io.File
import java.io.IOException
import java.util.zip.DeflaterOutputStream
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class PlayerRepositoryCancellationTest {
    @Test fun successfulTextFetchPreservesHeadersAndResponseCharset() = runBlocking {
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            assertEquals("Xtra-test", chain.request().header("User-Agent"))
            Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(200).message("OK")
                .body("caf\u00e9".toByteArray(Charsets.ISO_8859_1).toResponseBody("text/plain; charset=iso-8859-1".toMediaType())).build()
        }.build()
        withRepository(client) { repository ->
            assertEquals("caf\u00e9", repository.loadTextFromUrl("OkHttp", "https://example.invalid/playlist", mapOf("User-Agent" to "Xtra-test")))
        }
    }

    @Test fun cosmeticsRequestEscapesAndDeduplicatesIds() = runBlocking {
        val paintId = "paint\"with\\escapes\n"
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val body = Buffer().also { chain.request().body!!.writeTo(it) }.readUtf8()
            val query = Json.parseToJsonElement(body).jsonObject["query"]!!.jsonPrimitive.content
            assertTrue(query.startsWith("{ cosmetics(list: [${JsonPrimitive(paintId)},\"badge\"])"))
            Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(200).message("OK")
                .body("""{"data":{"cosmetics":{"paints":[],"badges":[]}}}""".toResponseBody("application/json".toMediaType())).build()
        }.build()
        withRepository(client) { repository ->
            assertEquals(setOf("paints", "badges"), repository.loadStvCosmetics(listOf(paintId, paintId, ""), listOf("badge"))!!.keys)
        }
    }

    @Test fun activeEmoteFetchStillFallsBackToTheDiskCacheOnNetworkFailure() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val cache = File(context.cacheDir, "emote_responses/global.stv").apply { parentFile!!.mkdirs() }
        DeflaterOutputStream(cache.outputStream()).use {
            it.write("""{"emotes":[{"name":"cat","data":{"host":{"url":"//example.invalid/cat","files":[{"name":"1x.webp","format":"WEBP"}]}}}]}""".toByteArray())
        }
        val client = OkHttpClient.Builder().addInterceptor { throw IOException("offline") }.build()
        try {
            withRepository(client) { repository ->
                val emote = repository.loadGlobalStvEmotes("OkHttp", true).single()
                assertEquals("cat", emote.name)
                assertEquals("https://example.invalid/cat/1x.webp", emote.url1x)
            }
        } finally {
            cache.delete()
        }
    }

    @Test
    fun cancellingTextFetchAbortsItsHttpCall() = checkCancellation { repository ->
        repository.loadTextFromUrl("OkHttp", "https://example.invalid/playlist.m3u8")
    }

    @Test
    fun cancellingGlobalEmoteFetchDoesNotWaitForTheOfflineFallback() = checkCancellation { repository ->
        repository.loadGlobalStvEmotes("OkHttp", true)
    }

    @Test
    fun cancellingCosmeticsFetchAbortsItsHttpCall() = checkCancellation { repository ->
        repository.loadStvCosmetics(listOf("paint"), listOf("badge"))
    }

    @Test
    fun cancellingPresenceAbortsItsHttpCall() = checkCancellation { repository ->
        repository.sendStvPresence("OkHttp", "user", "channel", null, false)
    }

    private fun checkCancellation(fetch: suspend (PlayerRepository) -> Unit) = runBlocking {
        ServerSocket(0).use { server ->
            val started = CompletableDeferred<Unit>()
            val release = CountDownLatch(1)
            val peer = thread(isDaemon = true) {
                server.accept().use { socket ->
                    val reader = socket.getInputStream().bufferedReader()
                    while (!reader.readLine().isNullOrEmpty()) { }
                    started.complete(Unit)
                    release.await(5, TimeUnit.SECONDS)
                }
            }
            val client = OkHttpClient.Builder().addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().url("http://127.0.0.1:${server.localPort}/").build())
            }.build()
            try {
                withRepository(client) { repository ->
                    val request = async { fetch(repository) }
                    try {
                        withTimeout(3_000) { started.await() }
                        withTimeout(1_000) { request.cancelAndJoin() }
                    } finally {
                        release.countDown()
                        request.cancelAndJoin()
                    }
                }
            } finally {
                release.countDown()
                peer.join(1_000)
            }
        }
    }

    private suspend fun <T> withRepository(client: OkHttpClient, block: suspend (PlayerRepository) -> T): T {
        val executor = Executors.newSingleThreadExecutor()
        val context = RuntimeEnvironment.getApplication()
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        val json = Json { ignoreUnknownKeys = true }
        val auth = AuthRepository(null, null, executor, client, json)
        val kick = KickRepository(context, client, null, executor, json, auth, KickOfficialApiClient(context, client, json))
        val repository = PlayerRepository(context, null, null, executor, client, json, kick,
            KickPublicApiRepository(null, null, executor, client, json), database.recentEmotes(), database.videoPositions())
        try {
            return block(repository)
        } finally {
            database.close()
            client.connectionPool.evictAll()
            client.dispatcher.executorService.shutdownNow()
            executor.shutdownNow()
        }
    }
}
