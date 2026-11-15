package com.xtrakick.app.util

import android.app.Application
import android.os.Bundle
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.File

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class)
class SavedInstanceStateTrimTest {
    private val context = RuntimeEnvironment.getApplication()

    @Test fun smallStateStaysInline() {
        val state = Bundle().apply { putString("destination", "player") }
        assertFalse(saveOversizedInstanceState(context, state))
        assertEquals("player", state.getString("destination"))
        assertFalse(restoreOversizedInstanceState(context, state))
    }

    @Test fun completeRegistryAndUnrelatedStateSurviveParcelRoundTrip() {
        val payload = ByteArray(400_000) { (it % 251).toByte() }
        val state = Bundle().apply {
            putString("application", "preserved")
            putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", Bundle().apply {
                putBundle("navigation", Bundle().apply { putString("destination", "player") })
                putByteArray("largeProvider", payload)
            })
        }
        assertTrue(saveOversizedInstanceState(context, state))
        assertTrue(state.getParcelSize() < MAX_SAFE_SAVED_STATE_BYTES)
        val parcel = android.os.Parcel.obtain()
        val restored = try {
            parcel.writeBundle(state)
            parcel.setDataPosition(0)
            parcel.readBundle(context.classLoader)!!
        } finally { parcel.recycle() }
        assertTrue(restoreOversizedInstanceState(context, restored))
        assertEquals("preserved", restored.getString("application"))
        val registry = restored.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key")!!
        assertEquals("player", registry.getBundle("navigation")!!.getString("destination"))
        assertArrayEquals(payload, registry.getByteArray("largeProvider"))
        assertTrue(restoreOversizedInstanceState(context, state))
    }

    @Test fun failedPersistenceKeepsTheOriginalStateIntact() {
        val state = Bundle().apply { putByteArray("data", ByteArray(400_000)) }
        val directory = File(context.noBackupFilesDir, "saved-state")
        directory.deleteRecursively()
        directory.writeText("not a directory")
        try {
            assertFalse(saveOversizedInstanceState(context, state))
            assertEquals(400_000, state.getByteArray("data")!!.size)
        } finally { directory.delete() }
    }

    @Test fun missingOrInvalidSnapshotDoesNotCrashOrReadOutsidePrivateDirectory() {
        for (token in listOf("../outside", "00000000-0000-0000-0000-000000000000")) {
            val state = Bundle().apply { putString(SAVED_STATE_FILE_KEY, token); putString("keep", "value") }
            assertFalse(restoreOversizedInstanceState(context, state))
            assertNull(state.getString(SAVED_STATE_FILE_KEY))
            assertEquals("value", state.getString("keep"))
        }
    }
}
