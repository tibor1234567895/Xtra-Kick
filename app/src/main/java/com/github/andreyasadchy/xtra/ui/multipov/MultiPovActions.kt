package com.github.andreyasadchy.xtra.ui.multipov

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Shared MultiPOV entry points for raid UI and other non-list surfaces.
 * Stream cards open normally; MultiPOV is started from the player menu.
 */
object MultiPovActions {

    fun isEnabled(fragment: Fragment): Boolean {
        return fragment.context?.prefs()?.getBoolean(C.MULTIPOV_ENABLED, true) == true
    }

    fun isMultiPovOpen(fragment: Fragment): Boolean {
        val activity = fragment.activity as? MainActivity ?: return false
        return activity.multiPovFragment != null ||
            activity.supportFragmentManager.findFragmentById(R.id.playerContainer) is MultiPovFragment
    }

    fun addRaidAsPov(fragment: Fragment, stream: Stream): Boolean {
        if (!isEnabled(fragment)) return false
        val activity = fragment.activity as? MainActivity ?: return false
        val multiWasOpen = isMultiPovOpen(fragment)
        val added = activity.addToMultiPov(stream)
        // Fragment already toasts when adding into an open session; toast when MultiPOV was just opened.
        if (added && !multiWasOpen) {
            toastAdded(fragment, stream.channelName ?: stream.channelLogin.orEmpty())
        }
        return added
    }

    fun showRaidDestinationChooser(fragment: Fragment, stream: Stream, onSwitch: () -> Unit) {
        if (!isEnabled(fragment)) {
            onSwitch()
            return
        }
        if (isMultiPovOpen(fragment)) {
            addRaidAsPov(fragment, stream)
            return
        }
        MaterialAlertDialogBuilder(fragment.requireContext())
            .setTitle(stream.channelName ?: stream.channelLogin)
            .setItems(
                arrayOf(
                    fragment.getString(R.string.multipov_raid_switch),
                    fragment.getString(R.string.multipov_raid_add),
                )
            ) { _, which ->
                when (which) {
                    0 -> onSwitch()
                    1 -> addRaidAsPov(fragment, stream)
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun toastAdded(fragment: Fragment, channelLabel: String) {
        Toast.makeText(
            fragment.requireContext(),
            fragment.getString(R.string.multipov_added, channelLabel),
            Toast.LENGTH_SHORT,
        ).show()
    }
}
