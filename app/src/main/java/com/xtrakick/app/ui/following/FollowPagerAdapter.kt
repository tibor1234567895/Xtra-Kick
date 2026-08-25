package com.xtrakick.app.ui.following

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xtrakick.app.ui.following.channels.FollowedChannelsFragment
import com.xtrakick.app.ui.following.games.FollowedGamesFragment
import com.xtrakick.app.ui.following.streams.FollowedStreamsFragment
import kotlin.math.max

class FollowPagerAdapter(
    fragment: Fragment,
    private val tabs: List<String>,
) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (tabs.getOrNull(position)) {
            "0" -> FollowedGamesFragment()
            "1" -> FollowedStreamsFragment()
            "2" -> FollowedChannelsFragment()
            else -> FollowedStreamsFragment()
        }
    }

    override fun getItemCount(): Int = max(tabs.size, 1)
}
