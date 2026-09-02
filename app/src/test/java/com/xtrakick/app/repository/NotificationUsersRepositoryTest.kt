package com.xtrakick.app.repository

import com.xtrakick.app.db.NotificationUsersDao
import com.xtrakick.app.model.NotificationUser
import com.xtrakick.app.util.FcmSyncManager
import dagger.Lazy
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import okhttp3.OkHttpClient
import java.util.concurrent.Executors
import kotlinx.serialization.json.Json

@Config(application = android.app.Application::class)
@RunWith(RobolectricTestRunner::class)
class NotificationUsersRepositoryTest {

    private class FakeNotificationUsersDao : NotificationUsersDao {
        val rows = mutableListOf<NotificationUser>()

        override fun getAll(): List<NotificationUser> = rows.toList()

        override fun getByUserId(id: String): NotificationUser? =
            rows.firstOrNull { it.channelId == id }

        override fun getByKeys(keys: List<String>): List<NotificationUser> =
            rows.filter { it.channelId in keys }

        override fun insert(item: NotificationUser) {
            rows.removeAll { it.channelId == item.channelId }
            rows.add(item)
        }

        override fun insertList(items: List<NotificationUser>) {
            items.forEach { insert(it) }
        }

        override fun deleteAll() {
            rows.clear()
        }

        override fun delete(item: NotificationUser) {
            rows.removeAll { it.channelId == item.channelId }
        }

        override fun deleteByKeys(keys: List<String>): Int {
            val count = rows.count { it.channelId in keys }
            rows.removeAll { it.channelId in keys }
            return count
        }
    }

    private lateinit var dao: FakeNotificationUsersDao
    private lateinit var repository: NotificationUsersRepository

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        dao = FakeNotificationUsersDao()
        val json = Json { ignoreUnknownKeys = true }
        val okHttpClient = OkHttpClient()
        val executor = Executors.newSingleThreadExecutor()

        val authRepository = AuthRepository(
            httpEngine = null,
            cronetEngine = null,
            cronetExecutor = executor,
            okHttpClient = okHttpClient,
            json = json,
        )
        val kickOfficialApiClient = KickOfficialApiClient(
            context = context,
            okHttpClient = okHttpClient,
            json = json,
        )
        val kickRepository = KickRepository(
            context = context,
            okHttpClient = okHttpClient,
            cronetEngine = null,
            cronetExecutor = executor,
            json = json,
            authRepository = authRepository,
            kickOfficialApiClient = kickOfficialApiClient,
        )
        val fcmSyncManager = FcmSyncManager(context, dao)
        repository = NotificationUsersRepository(
            notificationUsersDao = dao,
            kickRepository = kickRepository,
            fcmSyncManager = Lazy { fcmSyncManager },
        )
    }

    @Test
    fun isNotificationEnabledReturnsFalseWhenEmpty() = runBlocking {
        assertFalse(repository.isNotificationEnabled(emptyList()))
        assertFalse(repository.isNotificationEnabled(null, "", "   "))
    }

    @Test
    fun isNotificationEnabledDirectNumericMatch() = runBlocking {
        dao.insert(NotificationUser("12345"))

        assertTrue(repository.isNotificationEnabled("12345"))
        assertTrue(repository.isNotificationEnabled(listOf("12345", "some_slug")))
        assertFalse(repository.isNotificationEnabled("99999"))
    }

    @Test
    fun isNotificationEnabledMatchesAnyCandidateKeyWhenChannelOrUserOrSlugIsStored() = runBlocking {
        // Channel ID stored
        dao.insert(NotificationUser("668"))
        assertTrue(repository.isNotificationEnabled(listOf("668", "676", "xqc")))

        // User ID stored instead
        dao.deleteAll()
        dao.insert(NotificationUser("676"))
        assertTrue(repository.isNotificationEnabled(listOf("668", "676", "xqc")))

        // Slug stored instead
        dao.deleteAll()
        dao.insert(NotificationUser("xqc"))
        assertTrue(repository.isNotificationEnabled(listOf("668", "676", "xqc")))
    }

    @Test
    fun isNotificationEnabledDirectSlugMatchCaseInsensitive() = runBlocking {
        dao.insert(NotificationUser("teststreamer"))

        assertTrue(repository.isNotificationEnabled("teststreamer"))
        assertTrue(repository.isNotificationEnabled("TestStreamer"))
        assertTrue(repository.isNotificationEnabled(listOf("TESTSTREAMER", "12345")))
        assertFalse(repository.isNotificationEnabled("otherstreamer"))
    }

    @Test
    fun enableNotificationsForChannelStoresCanonicalNumericKeyAndCleansDuplicates() = runBlocking {
        dao.insert(NotificationUser("testslug"))

        val canonical = repository.enableNotificationsForChannel("testslug", "67890")
        assertEquals("67890", canonical)

        val rows = dao.getAll()
        assertEquals(1, rows.size)
        assertEquals("67890", rows.first().channelId)
    }

    @Test
    fun disableNotificationsForChannelRemovesAllMatchingKeys() = runBlocking {
        dao.insert(NotificationUser("testslug"))
        dao.insert(NotificationUser("67890"))
        dao.insert(NotificationUser("otherchannel"))

        repository.disableNotificationsForChannel("testslug", "67890")

        val remaining = dao.getAll()
        assertEquals(1, remaining.size)
        assertEquals("otherchannel", remaining.first().channelId)
        assertFalse(repository.isNotificationEnabled("testslug", "67890"))
    }

    @Test
    fun enableNotificationsForChannelsBulkInsertsOnlyMissingRows() = runBlocking {
        dao.insert(NotificationUser("11111"))
        dao.insert(NotificationUser("otherchannel"))

        val count = repository.enableNotificationsForChannels(
            listOf(
                listOf("11111", "channel_a"),
                listOf("22222"),
                listOf("33333"),
                listOf(null, "", "   "),
            )
        )

        assertEquals(2, count)
        val ids = dao.getAll().map { it.channelId }.toSet()
        assertTrue(ids.containsAll(setOf("11111", "22222", "33333", "otherchannel")))
        assertTrue(repository.isNotificationEnabled("22222"))
    }
}
