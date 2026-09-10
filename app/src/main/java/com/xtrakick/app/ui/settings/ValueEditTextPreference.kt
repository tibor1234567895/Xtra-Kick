package com.xtrakick.app.ui.settings

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceViewHolder
import com.xtrakick.app.R
import com.xtrakick.app.ui.player.formatHoldToSpeedLabel

/** EditTextPreference holding a speed list; pins a compact "min–max · N" summary right. */
class ValueEditTextPreference(context: Context, attrs: AttributeSet?) : EditTextPreference(context, attrs) {

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        (holder.findViewById(R.id.value) as? TextView)?.text = compactSpeedListSummary(text)
    }
}

internal fun compactSpeedListSummary(raw: String?): String? {
    val speeds = raw?.split(Regex("[,\\s]+"))
        ?.mapNotNull { it.toFloatOrNull()?.takeIf { speed -> speed > 0f } }
        ?.distinct()
        ?.sorted()
        .orEmpty()
    if (speeds.isEmpty()) return raw?.takeIf { it.isNotBlank() }
    if (speeds.size == 1) return formatHoldToSpeedLabel(speeds.single())
    return "${formatHoldToSpeedLabel(speeds.first())}–${formatHoldToSpeedLabel(speeds.last())} · ${speeds.size}"
}
