package com.xtrakick.app.repository

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = android.app.Application::class)
class KickOfficialApiClientTest {

    private lateinit var client: KickOfficialApiClient

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        client = KickOfficialApiClient(
            context = context,
            okHttpClient = OkHttpClient(),
            json = Json { ignoreUnknownKeys = true },
        )
    }

    @Test
    fun `getChannels rejects mixing broadcasterUserIds and slugs`() {
        assertThrows(IllegalArgumentException::class.java) {
            runBlocking {
                client.getChannels(
                    accessToken = "mock-token",
                    broadcasterUserIds = listOf(123L),
                    slugs = listOf("channel_slug"),
                )
            }
        }
    }

    @Test
    fun `getChannels rejects more than 50 broadcasterUserIds`() {
        val tooManyIds = (1..51L).toList()
        assertThrows(IllegalArgumentException::class.java) {
            runBlocking {
                client.getChannels(
                    accessToken = "mock-token",
                    broadcasterUserIds = tooManyIds,
                )
            }
        }
    }

    @Test
    fun `getChannels rejects more than 50 slugs`() {
        val tooManySlugs = (1..51).map { "slug_$it" }
        assertThrows(IllegalArgumentException::class.java) {
            runBlocking {
                client.getChannels(
                    accessToken = "mock-token",
                    slugs = tooManySlugs,
                )
            }
        }
    }
}
