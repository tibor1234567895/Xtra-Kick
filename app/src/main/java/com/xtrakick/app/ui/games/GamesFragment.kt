package com.xtrakick.app.ui.games

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentGamesBinding
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.Tag
import com.xtrakick.app.ui.common.GamesAdapter
import com.xtrakick.app.ui.common.PagedListFragment
import com.xtrakick.app.ui.common.Scrollable
import com.xtrakick.app.ui.login.LoginActivity
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.ui.search.SearchPagerFragmentDirections
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GamesFragment : PagedListFragment(), Scrollable, GamesSortDialog.OnFilter {

    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!
    private val args: GamesFragmentArgs by navArgs()
    private val viewModel: GamesViewModel by viewModels()
    private lateinit var pagingAdapter: PagingDataAdapter<Game, out RecyclerView.ViewHolder>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val activity = requireActivity() as MainActivity
            val isLoggedIn = com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())
            val navController = findNavController()
            val appBarConfiguration = AppBarConfiguration(setOf(R.id.rootGamesFragment, R.id.rootTopFragment, R.id.followPagerFragment, R.id.followMediaFragment, R.id.savedPagerFragment, R.id.savedMediaFragment))
            toolbar.setupWithNavController(navController, appBarConfiguration)
            toolbar.menu.findItem(R.id.login).title = if (isLoggedIn) getString(R.string.log_out) else getString(R.string.log_in)
            toolbar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.search -> {
                        findNavController().navigate(SearchPagerFragmentDirections.actionGlobalSearchPagerFragment())
                        true
                    }
                    R.id.settings -> {
                        activity.launchSettings()
                        true
                    }
                    R.id.login -> {
                        if (isLoggedIn) {
                            activity.getAlertDialogBuilder().apply {
                                setTitle(getString(R.string.logout_title))
                                requireContext().tokenPrefs().getString(AppConstants.USERNAME, null)?.let { setMessage(getString(R.string.logout_msg, it)) }
                                setNegativeButton(getString(R.string.no), null)
                                setPositiveButton(getString(R.string.yes)) { _, _ -> activity.logoutResultLauncher?.launch(Intent(activity, LoginActivity::class.java).putExtra(AppConstants.LOGIN_LOGOUT_ONLY, true)) }
                            }.show()
                        } else {
                            activity.loginResultLauncher?.launch(Intent(activity, LoginActivity::class.java))
                        }
                        true
                    }
                    else -> false
                }
            }
            if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                recyclerViewLayout.recyclerView.let {
                    appBar.setLiftOnScrollTargetView(it)
                    it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            appBar.isLifted = recyclerView.canScrollVertically(-1)
                        }
                    })
                    it.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
                        appBar.isLifted = it.canScrollVertically(-1)
                    }
                }
            } else {
                appBar.setLiftable(false)
                appBar.background = null
            }
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    topMargin = insets.top
                }
                if (activity.findViewById<LinearLayout>(R.id.navBarContainer)?.isVisible == false) {
                    val systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                    recyclerViewLayout.recyclerView.updatePadding(bottom = systemBars.bottom)
                }
                WindowInsetsCompat.CONSUMED
            }
        }
        pagingAdapter = GamesAdapter(this) { addTag(it) }
        setAdapter(binding.recyclerViewLayout.recyclerView, pagingAdapter)
    }

    override fun initialize() {
        viewLifecycleOwner.lifecycleScope.launch {
            if (viewModel.filter.value == null) {
                viewModel.setFilter(viewModel.tags.ifEmpty { args.tags })
                viewModel.filtersText.value = if (viewModel.tags.isNotEmpty()) {
                    buildString {
                        append(
                            resources.getQuantityString(
                                R.plurals.tags,
                                viewModel.tags.size,
                                viewModel.tags.mapNotNull { it.name }.joinToString()
                            )
                        )
                    }
                } else null
            }
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.flow.collectLatest { pagingData ->
                    pagingAdapter.submitData(pagingData)
                }
            }
        }
        val enableScrollTopButton = !args.tags.isNullOrEmpty()
        initializeAdapter(binding.recyclerViewLayout, pagingAdapter, enableScrollTopButton = enableScrollTopButton)
        if (enableScrollTopButton && requireContext().prefs().getBoolean(AppConstants.UI_SCROLLTOP, true)) {
            binding.recyclerViewLayout.scrollTop.setOnClickListener {
                scrollToTop()
                it.visibility = View.GONE
            }
        }
        with(binding) {
            sortBar.root.visibility = View.VISIBLE
            sortBar.root.setOnClickListener {
                val tags = viewModel.tags.mapNotNull { tag ->
                    if (tag.id != null && tag.name != null) {
                        tag.id to tag.name
                    } else null
                }.toMap()
                GamesSortDialog.newInstance(
                    tagIds = tags.keys.toTypedArray(),
                    tagNames = tags.values.toTypedArray(),
                ).show(childFragmentManager, null)
            }
            sortBar.sortText.visibility = View.GONE
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.filtersText.collectLatest {
                        if (it != null) {
                            sortBar.filtersText.visibility = View.VISIBLE
                            sortBar.filtersText.text = it
                        } else {
                            sortBar.filtersText.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    private fun addTag(tag: Tag) {
        viewLifecycleOwner.lifecycleScope.launch {
            val tags = viewModel.tags.plus(tag).sortedBy { it.id }.toTypedArray()
            viewModel.setFilter(tags)
            viewModel.filtersText.value = buildString {
                append(
                    resources.getQuantityString(
                        R.plurals.tags,
                        viewModel.tags.size,
                        viewModel.tags.mapNotNull { it.name }.joinToString()
                    )
                )
            }
        }
    }

    override fun onChange(tags: Array<Tag>) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.setFilter(tags)
            viewModel.filtersText.value = if (viewModel.tags.isNotEmpty()) {
                buildString {
                    append(
                        resources.getQuantityString(
                            R.plurals.tags,
                            viewModel.tags.size,
                            viewModel.tags.mapNotNull { it.name }.joinToString()
                        )
                    )
                }
            } else null
        }
    }

    override fun scrollToTop() {
        with(binding) {
            appBar.setExpanded(true, true)
            recyclerViewLayout.recyclerView.scrollToPosition(0)
        }
    }

    override fun onNetworkRestored() {
        pagingAdapter.retry()
    }

    override fun onIntegrityDialogCallback(callback: String?) {
        if (callback == "refresh") {
            pagingAdapter.refresh()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
