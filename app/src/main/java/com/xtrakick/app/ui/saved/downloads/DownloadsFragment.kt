package com.xtrakick.app.ui.saved.downloads

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.google.android.material.snackbar.Snackbar
import com.xtrakick.app.R
import com.xtrakick.app.databinding.CommonRecyclerViewLayoutBinding
import com.xtrakick.app.databinding.StorageSelectionBinding
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.ui.common.PagedListFragment
import com.xtrakick.app.ui.common.Scrollable
import com.xtrakick.app.ui.download.StreamDownloadWorker
import com.xtrakick.app.ui.download.VideoDownloadWorker
import com.xtrakick.app.ui.saved.LeftoverFilesUi
import com.xtrakick.app.ui.settings.SettingsViewModel
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.File

@AndroidEntryPoint
class DownloadsFragment : PagedListFragment(), Scrollable {

    private var _binding: CommonRecyclerViewLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DownloadsViewModel by viewModels()
    private val settingsViewModel: SettingsViewModel by activityViewModels()
    private val leftoverUi by lazy { LeftoverFilesUi(this, settingsViewModel) }
    private lateinit var pagingAdapter: PagingDataAdapter<OfflineVideo, out RecyclerView.ViewHolder>
    override var enableNetworkCheck = false
    private var fileResultLauncher: ActivityResultLauncher<Intent>? = null
    private var chatFileResultLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fileResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let {
                    viewModel.selectedVideo?.let { video ->
                        requireContext().contentResolver.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                        viewModel.moveToSharedStorage(it, video)
                    }
                }
            }
        }
        chatFileResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let {
                    viewModel.selectedVideo?.let { video ->
                        requireContext().contentResolver.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                        viewModel.updateChatUrl(it, video)
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CommonRecyclerViewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagingAdapter = DownloadsAdapter(this, {
            if (it.live) {
                val channelLogin = it.channelLogin
                if (!channelLogin.isNullOrBlank()) {
                    viewModel.checkLiveDownloadStatus(channelLogin)
                }
            } else {
                viewModel.checkDownloadStatus(it.id)
            }
        }, {
            if (it.live) {
                if (it.status != OfflineVideo.STATUS_PENDING) {
                    it.channelLogin?.let { channelLogin ->
                        WorkManager.getInstance(requireContext()).cancelUniqueWork(channelLogin)
                    }
                } else {
                    viewModel.finishDownload(it)
                }
            } else {
                WorkManager.getInstance(requireContext()).cancelAllWorkByTag(it.id.toString())
            }
        }, {
            if (it.live) {
                val channelLogin = it.channelLogin
                if (!channelLogin.isNullOrBlank()) {
                    WorkManager.getInstance(requireContext()).enqueueUniqueWork(
                        channelLogin,
                        ExistingWorkPolicy.REPLACE,
                        OneTimeWorkRequestBuilder<StreamDownloadWorker>()
                            .setInputData(workDataOf(StreamDownloadWorker.KEY_VIDEO_ID to it.id))
                            .setConstraints(
                                Constraints.Builder()
                                    .setRequiredNetworkType(
                                        if (requireContext().prefs().getBoolean(AppConstants.DOWNLOAD_WIFI_ONLY, false)) {
                                            NetworkType.UNMETERED
                                        } else {
                                            NetworkType.CONNECTED
                                        }
                                    )
                                    .build()
                            )
                            .build()
                    )
                    viewModel.checkLiveDownloadStatus(channelLogin)
                }
            } else {
                WorkManager.getInstance(requireContext()).enqueueUniqueWork(
                    VideoDownloadWorker.workName(it.id),
                    ExistingWorkPolicy.REPLACE,
                    OneTimeWorkRequestBuilder<VideoDownloadWorker>()
                        .setInputData(workDataOf(VideoDownloadWorker.KEY_VIDEO_ID to it.id))
                        .addTag(it.id.toString())
                        .setConstraints(
                            Constraints.Builder()
                                .setRequiredNetworkType(
                                    if (requireContext().prefs().getBoolean(AppConstants.DOWNLOAD_WIFI_ONLY, false)) {
                                        NetworkType.UNMETERED
                                    } else {
                                        NetworkType.CONNECTED
                                    }
                                )
                                .build()
                        )
                        .build()
                )
                viewModel.checkDownloadStatus(it.id)
            }
        }, {
            // convertVideo
            val convert = getString(R.string.convert)
            requireActivity().getAlertDialogBuilder()
                .setTitle(convert)
                .setMessage(getString(R.string.convert_message))
                .setPositiveButton(convert) { _, _ -> viewModel.convertToFile(it) }
                .setNegativeButton(getString(android.R.string.cancel), null)
                .show()
        }, {
            // moveVideo
            if (it.url?.toUri()?.scheme == ContentResolver.SCHEME_CONTENT) {
                val storage = requireContext().getExternalFilesDirs(".downloads").mapIndexedNotNull { index, file ->
                    file?.absolutePath?.let { path ->
                        if (index == 0) {
                            getString(R.string.internal_storage) to path
                        } else {
                            path.substringBefore("/Android/data", "").takeIf { it.isNotBlank() }?.let {
                                it.substringAfterLast(File.separatorChar) to path
                            }
                        }
                    }
                }
                val binding = StorageSelectionBinding.inflate(layoutInflater).apply {
                    storageSpinner.visibility = View.GONE
                    if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                        appStorageLayout.visibility = View.VISIBLE
                        storage.forEachIndexed { index, pair ->
                            radioGroup.addView(
                                RadioButton(requireContext()).apply {
                                    id = index
                                    text = pair.first
                                }
                            )
                        }
                        radioGroup.check(
                            if (storage.size == 1) {
                                0
                            } else {
                                requireContext().prefs().getInt(AppConstants.DOWNLOAD_STORAGE, 0)
                            }
                        )
                    } else {
                        noStorageDetected.apply {
                            visibility = View.VISIBLE
                            layoutParams = layoutParams.apply {
                                width = ViewGroup.LayoutParams.WRAP_CONTENT
                            }
                        }
                    }
                }
                requireActivity().getAlertDialogBuilder()
                    .setView(binding.root)
                    .setPositiveButton(getString(android.R.string.ok)) { _, _ ->
                        val checked = binding.radioGroup.checkedRadioButtonId
                        storage.getOrNull(checked)?.let { storage ->
                            requireContext().prefs().edit { putInt(AppConstants.DOWNLOAD_STORAGE, checked) }
                            viewModel.moveToAppStorage(storage.second, it)
                        }
                    }
                    .setNegativeButton(getString(android.R.string.cancel), null)
                    .show()
            } else {
                viewModel.selectedVideo = it
                fileResultLauncher?.launch(Intent(Intent.ACTION_OPEN_DOCUMENT_TREE))
            }
        }, {
            // updateChatUrl
            viewModel.selectedVideo = it
            chatFileResultLauncher?.launch(Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "*/*"
            })
        }, {
            // redownloadChat
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.redownloadChat(it)
                WorkManager.getInstance(requireContext()).enqueueUniqueWork(
                    VideoDownloadWorker.workName(it.id),
                    ExistingWorkPolicy.REPLACE,
                    OneTimeWorkRequestBuilder<VideoDownloadWorker>()
                        .setInputData(workDataOf(
                            VideoDownloadWorker.KEY_VIDEO_ID to it.id,
                            VideoDownloadWorker.KEY_FORCE_CHAT_REDOWNLOAD to true,
                        ))
                        .addTag(it.id.toString())
                        .setConstraints(
                            Constraints.Builder()
                                .setRequiredNetworkType(
                                    if (requireContext().prefs().getBoolean(AppConstants.DOWNLOAD_WIFI_ONLY, false)) {
                                        NetworkType.UNMETERED
                                    } else {
                                        NetworkType.CONNECTED
                                    }
                                )
                                .build()
                        )
                        .build()
                )
                viewModel.checkDownloadStatus(it.id)
            }
        }, {
            // shareVideo
            it.url?.let { videoUrl ->
                val uri = if (videoUrl.endsWith(".m3u8")) {
                    videoUrl.substringBefore("%2F").toUri()
                } else {
                    videoUrl.toUri()
                }
                startActivity(Intent.createChooser(Intent().apply {
                    action = Intent.ACTION_SEND
                    setDataAndType(uri, requireContext().contentResolver.getType(uri))
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
                    it.name?.let { putExtra(Intent.EXTRA_TITLE, it) }
                }, null))
            }
        }, {
            // openInFolder
            openDownloadInFolder(it)
        }, {
            // deleteVideo
            val delete = getString(R.string.delete)
            val checkBox = CheckBox(requireContext()).apply {
                text = getString(R.string.keep_files)
                isChecked = false
            }
            val checkBoxView = LinearLayout(requireContext()).apply {
                addView(checkBox)
                val padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, resources.displayMetrics).toInt()
                setPadding(padding, 0, padding, 0)
            }
            requireActivity().getAlertDialogBuilder()
                .setTitle(delete)
                .setMessage(getString(R.string.are_you_sure))
                .setView(checkBoxView)
                .setPositiveButton(delete) { _, _ ->
                    viewModel.delete(it, checkBox.isChecked)
                    if (checkBox.isChecked) {
                        Snackbar.make(binding.root, getString(R.string.leftover_files_kept), Snackbar.LENGTH_LONG)
                            .setAction(R.string.leftover_files_delete) { leftoverUi.open() }
                            .show()
                    }
                }
                .setNegativeButton(getString(android.R.string.cancel), null)
                .show()
        }, {
            // fileMissing: files were deleted outside the app (e.g. in a file
            // explorer). Never open a blank player; offer entry removal instead.
            requireActivity().getAlertDialogBuilder()
                .setTitle(getString(R.string.delete))
                .setMessage(getString(R.string.download_unavailable))
                .setPositiveButton(getString(R.string.delete)) { _, _ ->
                    viewModel.delete(it, false)
                }
                .setNegativeButton(getString(android.R.string.cancel), null)
                .show()
        })
        with(binding) {
            pagingAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                    pagingAdapter.unregisterAdapterDataObserver(this)
                    pagingAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                            if (positionStart == 0) {
                                recyclerView.smoothScrollToPosition(0)
                            }
                        }
                    })
                }
            })
            recyclerView.adapter = pagingAdapter
            (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                if (activity?.findViewById<LinearLayout>(R.id.navBarContainer)?.isVisible == false) {
                    val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                    recyclerView.updatePadding(bottom = insets.bottom)
                }
                WindowInsetsCompat.CONSUMED
            }
        }
    }

    override fun initialize() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.flow.collectLatest { pagingData ->
                    pagingAdapter.submitData(pagingData)
                }
            }
        }
        initializeAdapter(binding, pagingAdapter, enableSwipeRefresh = false, enableScrollTopButton = false)
    }

    override fun scrollToTop() {
        binding.recyclerView.scrollToPosition(0)
    }

    private fun openDownloadInFolder(video: OfflineVideo) {
        val context = requireContext()
        val urlStr = video.url
        if (urlStr.isNullOrBlank()) {
            Toast.makeText(context, getString(R.string.download_unavailable), Toast.LENGTH_SHORT).show()
            return
        }
        val urlUri = runCatching { urlStr.toUri() }.getOrNull()
        if (urlUri == null) {
            Toast.makeText(context, getString(R.string.download_unavailable), Toast.LENGTH_SHORT).show()
            return
        }
        // SAF shared storage: open the tree folder in the system Files app,
        // fallback to viewing the document itself.
        if (urlUri.scheme == ContentResolver.SCHEME_CONTENT) {
            val treeUri = video.downloadPath?.toUri()?.takeIf { it.scheme == ContentResolver.SCHEME_CONTENT }
            val folderUri = treeUri?.let { tree ->
                val treeId = runCatching { DocumentsContract.getTreeDocumentId(tree) }.getOrNull()
                if (treeId != null) {
                    runCatching { DocumentsContract.buildDocumentUriUsingTree(tree, treeId) }.getOrNull()
                } else {
                    tree
                }
            }
            val candidates = buildList {
                folderUri?.let {
                    add(Intent(Intent.ACTION_VIEW).setDataAndType(it, DocumentsContract.Document.MIME_TYPE_DIR))
                }
                val mime = runCatching { context.contentResolver.getType(urlUri) }.getOrNull()
                    ?: if (urlStr.endsWith(".m3u8")) "application/x-mpegURL" else "video/*"
                add(Intent(Intent.ACTION_VIEW).setDataAndType(urlUri, mime))
            }
            for (intent in candidates) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                try {
                    startActivity(Intent.createChooser(intent, getString(R.string.open_in_folder)))
                    return
                } catch (_: Exception) {
                    // try next fallback
                }
            }
            Toast.makeText(context, getString(R.string.no_file_explorer), Toast.LENGTH_SHORT).show()
            return
        }
        // App-private File path: external explorers cannot browse it (scoped storage),
        // so expose the file via FileProvider ("Open with…"). Folder reveal via file://
        // is attempted first for OEM file managers that still handle it.
        try {
            val file = File(urlStr)
            val target = if (file.isFile || file.exists()) file else file.parentFile ?: file
            val folder = target.takeIf { it.isDirectory } ?: target.parentFile ?: target
            runCatching {
                val folderIntent = Intent(Intent.ACTION_VIEW).setDataAndType(
                    android.net.Uri.fromFile(folder),
                    DocumentsContract.Document.MIME_TYPE_DIR
                )
                startActivity(Intent.createChooser(folderIntent, getString(R.string.open_in_folder)))
                return
            }
            val openFile = if (target.isDirectory) {
                target.listFiles()?.firstOrNull { it.isFile } ?: target
            } else {
                target
            }
            if (!openFile.exists()) {
                Toast.makeText(context, getString(R.string.download_unavailable), Toast.LENGTH_SHORT).show()
                return
            }
            val contentUri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.downloads-file-provider",
                openFile
            )
            val mime = runCatching { context.contentResolver.getType(contentUri) }.getOrNull()
                ?: if (openFile.name.endsWith(".m3u8")) "application/x-mpegURL" else "video/*"
            val viewFile = Intent(Intent.ACTION_VIEW)
                .setDataAndType(contentUri, mime)
                .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(Intent.createChooser(viewFile, getString(R.string.open_in_folder)))
        } catch (_: Exception) {
            Toast.makeText(context, getString(R.string.no_file_explorer), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNetworkRestored() {
    }

    override fun onIntegrityDialogCallback(callback: String?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
