package com.xtrakick.app.ui.channel

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.ui.channel.about.ChannelAboutFragment
import com.xtrakick.app.ui.channel.clips.ChannelClipsFragment
import com.xtrakick.app.ui.channel.suggested.ChannelSuggestedFragment
import com.xtrakick.app.ui.channel.videos.ChannelVideosFragment
import com.xtrakick.app.ui.chat.ChatFragment
import kotlin.math.max

class ChannelPagerAdapter(
    private val fragment: Fragment,
    private val args: ChannelPagerFragmentArgs,
    private val tabs: List<String>,
) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (tabs.getOrNull(position)) {
            "0" -> ChannelSuggestedFragment().apply { arguments = fragment.arguments }
            "1" -> ChannelVideosFragment().apply { arguments = fragment.arguments }
            "2" -> ChannelClipsFragment().apply { arguments = fragment.arguments }
            "3" -> ChatFragment.newInstance(
                channelId = args.channelId,
                channelLogin = args.channelLogin,
                channelName = args.channelName,
                streamId = args.streamId,
                source = AppConstants.KICK,
            )
            "4" -> ChannelAboutFragment().apply { arguments = fragment.arguments }
            else -> ChannelVideosFragment().apply { arguments = fragment.arguments }
        }
    }

    override fun getItemCount(): Int = max(tabs.size, 1)
}
