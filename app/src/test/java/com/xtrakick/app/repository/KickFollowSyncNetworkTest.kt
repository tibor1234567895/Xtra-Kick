package com.xtrakick.app.repository

import android.webkit.CookieManager
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.tokenPrefs
import java.io.IOException
import java.util.concurrent.Executors
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class KickFollowSyncNetworkTest {
    private val context = RuntimeEnvironment.getApplication()
    private val executor = Executors.newSingleThreadExecutor()
    private val json = Json { ignoreUnknownKeys = true }
    private val requests = mutableListOf<Request>()
    private var websiteAccount = "1"
    private var oauthAccount = 1
    private var page = """{"channels":[{"channel_slug":"streamer"}],"nextCursor":null}"""
    private var pages: Map<String?, String>? = null
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        requests += request
        val body = when (request.url.encodedPath) {
            "/api/v1/user" -> """{"id":$websiteAccount}"""
            "/public/v1/users" -> """{"data":[{"user_id":$oauthAccount,"name":"owner"}]}"""
            "/api/v2/channels/followed-page" -> pages?.get(request.url.queryParameter("cursor")) ?: page
            else -> throw IOException("Unexpected endpoint ${request.url.encodedPath}")
        }
        Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("fixture")
            .body(body.toResponseBody("application/json".toMediaType())).build()
    }.build()

    private fun repository(): KickRepository {
        context.tokenPrefs().edit().clear().putString(AppConstants.KICK_ACCESS_TOKEN, "fixture-token")
            .putLong(AppConstants.KICK_ACCESS_TOKEN_EXPIRES_AT, Long.MAX_VALUE).commit()
        CookieManager.getInstance().removeAllCookies(null)
        return KickRepository(context, client, null, executor, json,
            AuthRepository(null, null, executor, client, json), KickOfficialApiClient(context, client, json))
    }

    @After
    fun close() {
        context.tokenPrefs().edit().clear().commit()
        CookieManager.getInstance().removeAllCookies(null)
        executor.shutdownNow()
    }

    @Test
    fun validatesWebsiteIdentityBeforeAndAfterCompleteSnapshot() = runBlocking {
        assertEquals(listOf("streamer"), repository().getFollowedChannelsForSync("OkHttp", "1").map { it.login })
        assertEquals(2, requests.count { it.url.encodedPath == "/api/v1/user" })
        assertFalse(requests.any { it.url.encodedPath == "/api/v2/channels/followed" })
    }

    @Test
    fun followsNumericCursorAndAcceptsOmittedCursorOnLastPage() = runBlocking {
        pages = mapOf(
            null to """{"channels":[{"channel_slug":"one"}],"nextCursor":20}""",
            "20" to """{"channels":[{"channel_slug":"two"}]}""",
        )
        assertEquals(listOf("one", "two"), repository().getFollowedChannelsForSync("OkHttp", "1").map { it.login })
        assertEquals(listOf(null, "20"), requests.filter { it.url.encodedPath.endsWith("/followed-page") }.map { it.url.queryParameter("cursor") })
    }

    @Test
    fun mismatchedWebsiteSessionUsesVerifiedOauthAndFullListEndpoint() = runBlocking {
        websiteAccount = "2"
        assertEquals(1, repository().getFollowedChannelsForSync("OkHttp", "1").size)
        assertTrue(requests.any { it.url.encodedPath == "/public/v1/users" })
        assertEquals(null, requests.single { it.url.encodedPath == "/api/v2/channels/followed-page" }.header("Cookie"))
    }

    @Test
    fun mismatchedOauthIdentityAndIncompletePagesFailClosed() {
        websiteAccount = "2"
        oauthAccount = 2
        val repository = repository()
        assertThrows(IOException::class.java) { runBlocking { repository.getFollowedChannelsForSync("OkHttp", "1") } }
        assertFalse(requests.any { it.url.encodedPath == "/api/v2/channels/followed-page" })
        websiteAccount = "1"
        page = """{"data":[]}"""
        assertThrows(IOException::class.java) { runBlocking { repository.getFollowedChannelsForSync("OkHttp", "1") } }
    }
}
