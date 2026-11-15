package com.xtrakick.app.ui.common

import android.os.Bundle
import androidx.savedstate.SavedStateRegistry
import com.xtrakick.app.util.MAX_SAFE_SAVED_STATE_BYTES
import com.xtrakick.app.util.SAVED_STATE_FILE_KEY
import com.xtrakick.app.util.getParcelSize
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BaseStateActivityTrimTest {
    @Test fun stateWrittenAfterSuperRestoresEveryProviderBeforeOnCreate() {
        val first = Robolectric.buildActivity(ProviderActivity::class.java).setup()
        val state = Bundle()
        first.get().saveStateForTest(state)
        assertTrue(first.get().oversizedPayloadSaved)
        assertTrue(state.getParcelSize() in 0..MAX_SAFE_SAVED_STATE_BYTES)
        assertNotNull(state.getString(SAVED_STATE_FILE_KEY))
        first.pause().stop().destroy()

        val restored = Robolectric.buildActivity(ProviderActivity::class.java).setup(state)
        assertEquals(400_000, restored.get().restoredBytes)
        assertEquals("player", restored.get().restoredDestination)
        restored.pause().stop().destroy()
    }

    class ProviderActivity : BaseStateActivity() {
        var oversizedPayloadSaved = false
        var restoredBytes = 0
        var restoredDestination: String? = null
        fun saveStateForTest(outState: Bundle) { onSaveInstanceState(outState) }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            restoredBytes = savedStateRegistry.consumeRestoredStateForKey("test.oversized")?.getByteArray("blob")?.size ?: 0
            restoredDestination = savedStateRegistry.consumeRestoredStateForKey("test.navigation")?.getString("destination")
            savedStateRegistry.registerSavedStateProvider("test.oversized", SavedStateRegistry.SavedStateProvider {
                oversizedPayloadSaved = true
                Bundle().apply { putByteArray("blob", ByteArray(400_000)) }
            })
            savedStateRegistry.registerSavedStateProvider("test.navigation", SavedStateRegistry.SavedStateProvider {
                Bundle().apply { putString("destination", "player") }
            })
        }
    }
}
