package com.xtrakick.app.ui.notifications

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentNotificationChannelsBinding
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.notifications.NotificationChannelsViewModel.ChannelUi
import com.xtrakick.app.util.getAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotificationChannelsFragment : Fragment() {

    private var _binding: FragmentNotificationChannelsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NotificationChannelsViewModel by viewModels()
    private lateinit var adapter: NotificationChannelsAdapter

    // Toggle waiting on the Android 13 notification permission prompt; the row must
    // not be enabled until the permission is actually granted.
    private var pendingEnableEntry: ChannelUi? = null
    private val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        val entry = pendingEnableEntry
        pendingEnableEntry = null
        if (entry != null) {
            if (granted) {
                viewModel.setEnabled(entry, true)
            } else {
                // Nothing was enabled: re-render so the switch snaps back to off.
                viewModel.refresh()
                Toast.makeText(requireContext(), R.string.live_notification_channels_permission_denied, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotificationChannelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NotificationChannelsAdapter(onOpen = ::openChannel, onToggle = ::onToggleChannel)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            binding.toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
            }
            if (activity?.findViewById<LinearLayout>(R.id.navBarContainer)?.isVisible == false) {
                binding.recyclerView.updatePadding(bottom = insets.bottom)
            }
            WindowInsetsCompat.CONSUMED
        }
        val navController = findNavController()
        binding.toolbar.setupWithNavController(navController, AppBarConfiguration(setOf()))
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_enable_all -> {
                    viewModel.enableAll()
                    true
                }
                R.id.action_disable_all -> {
                    requireActivity().getAlertDialogBuilder()
                        .setTitle(getString(R.string.live_notification_channels_disable_all))
                        .setMessage(getString(R.string.live_notification_channels_disable_all_message))
                        .setPositiveButton(getString(R.string.yes)) { _, _ -> viewModel.disableAll() }
                        .setNegativeButton(getString(android.R.string.cancel), null)
                        .show()
                    true
                }
                else -> false
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.channels.collect { channels ->
                        binding.progressBar.isVisible = channels == null
                        binding.emptyText.isVisible = channels?.isEmpty() == true
                        binding.recyclerView.isVisible = channels?.isNotEmpty() == true
                        channels?.let { adapter.submitList(it) }
                    }
                }
                launch {
                    viewModel.updateError.collect { message ->
                        message?.let {
                            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                            viewModel.consumeUpdateError()
                        }
                    }
                }
            }
        }
    }

    private fun onToggleChannel(entry: ChannelUi, enabled: Boolean) {
        if (enabled && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            pendingEnableEntry = entry
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            return
        }
        viewModel.setEnabled(entry, enabled)
    }

    private fun openChannel(entry: ChannelUi) {
        findNavController().navigate(
            ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                channelId = entry.id.takeIf { it.all(Char::isDigit) },
                channelLogin = entry.login ?: entry.name,
                channelName = entry.name ?: entry.login,
                channelLogo = entry.logoUrl,
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
