package com.xtrakick.app.util

import android.app.Application
import androidx.room.Room
import com.xtrakick.app.db.AppDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withTimeout
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class FcmSyncManagerTest {
    @Test fun subscriptionAndUnsubscriptionShareTheSameSerializationBoundary() = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        try {
            val manager = FcmSyncManager(context, database.notificationsDao())
            val mutex = FcmSyncManager::class.java.getDeclaredField("subscriptionMutex")
                .apply { isAccessible = true }.get(manager) as Mutex
            mutex.lock()
            val sync = async { manager.syncSubscriptions("test-token") }
            val unsubscribe = async { manager.unsubscribe("test-token") }
            delay(50)
            assertFalse(sync.isCompleted)
            assertFalse(unsubscribe.isCompleted)
            mutex.unlock()
            withTimeout(2000) {
                // Debug operations leave the production subscription store alone.
                assertFalse(sync.await())
                assertFalse(unsubscribe.await())
            }
        } finally { database.close() }
    }
}
