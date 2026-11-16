package com.xtrakick.app.ui.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentDropsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DropsFragment : Fragment(R.layout.fragment_drops) {

    private var _binding: FragmentDropsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDropsBinding.bind(view)

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            binding.toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
            }
            WindowInsetsCompat.CONSUMED
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val pagerAdapter = DropsPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.drops_tab_active)
                1 -> getString(R.string.drops_tab_upcoming)
                2 -> getString(R.string.drops_tab_claimed)
                3 -> getString(R.string.drops_tab_expired)
                else -> ""
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class DropsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> DropsTabFragment.newInstance(DropsTabFragment.TAB_ACTIVE)
            1 -> DropsTabFragment.newInstance(DropsTabFragment.TAB_UPCOMING)
            2 -> DropsTabFragment.newInstance(DropsTabFragment.TAB_CLAIMED)
            3 -> DropsTabFragment.newInstance(DropsTabFragment.TAB_EXPIRED)
            else -> DropsTabFragment.newInstance(DropsTabFragment.TAB_ACTIVE)
        }
    }
}
