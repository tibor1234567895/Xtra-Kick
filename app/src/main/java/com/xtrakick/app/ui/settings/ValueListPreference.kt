package com.xtrakick.app.ui.settings

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.preference.ListPreference
import androidx.preference.PreferenceViewHolder
import com.xtrakick.app.R

/** ListPreference that pins the current entry to the right edge instead of under the title. */
class ValueListPreference(context: Context, attrs: AttributeSet?) : ListPreference(context, attrs) {

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        (holder.findViewById(R.id.value) as? TextView)?.text = entry
    }
}
