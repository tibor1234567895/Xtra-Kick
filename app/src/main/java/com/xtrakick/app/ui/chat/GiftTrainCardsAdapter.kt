package com.xtrakick.app.ui.chat

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R

/** Renders the per-giftee cards inside the gift train banner. */
class GiftTrainCardsAdapter : RecyclerView.Adapter<GiftTrainCardsAdapter.GifteeViewHolder>() {

    private var gifterName: String? = null
    private var gifterColor: Int = Color.WHITE
    private var giftees: List<String> = emptyList()

    fun submit(gifterName: String?, giftees: List<String>, gifterColor: Int) {
        this.gifterName = gifterName
        this.gifterColor = gifterColor
        this.giftees = giftees
        notifyDataSetChanged()
    }

    class GifteeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.giftTrainCardText)
        val accent: View = view.findViewById(R.id.giftTrainCardAccent)
        val icon: ImageView = view.findViewById(R.id.giftTrainCardIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifteeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gift_train, parent, false)
        return GifteeViewHolder(view)
    }

    override fun getItemCount(): Int = giftees.size

    override fun onBindViewHolder(holder: GifteeViewHolder, position: Int) {
        val context = holder.text.context
        val giftee = giftees[position]
        val gifter = gifterName ?: context.getString(R.string.kick_gift_train_someone)
        val full = context.getString(R.string.kick_gifted_sub_to, gifter, giftee)
        holder.accent.setBackgroundColor(gifterColor)
        holder.icon.imageTintList = ColorStateList.valueOf(gifterColor)
        holder.text.text = SpannableStringBuilder(full).apply {
            highlight(gifter, gifterColor)
            highlight(giftee, Color.WHITE)
        }
    }

    private fun SpannableStringBuilder.highlight(name: String, color: Int) {
        val start = indexOf(name)
        if (start < 0) return
        val end = start + name.length
        setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        setSpan(ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}
