package com.xtrakick.app.ui.channel.videos

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.ui.Bookmark
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.repository.BookmarksRepository
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.PlayerRepository
import com.xtrakick.app.ui.common.cacheMediaImage
import com.xtrakick.app.repository.SortChannelRepository
import com.xtrakick.app.repository.datasource.ChannelVideosDataSource
import com.xtrakick.app.ui.channel.ChannelPagerFragmentArgs
import com.xtrakick.app.ui.common.VideosSortDialog
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChannelVideosViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val sortChannelRepository: SortChannelRepository,
    private val playerRepository: PlayerRepository,
    private val bookmarksRepository: BookmarksRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = ChannelPagerFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val filter = MutableStateFlow<Filter?>(null)
    val sortText = MutableStateFlow<CharSequence?>(null)
    val positions = playerRepository.loadVideoPositions()
    val bookmarks = bookmarksRepository.loadBookmarksFlow()

    val sort: String
        get() = filter.value?.sort ?: VideosSortDialog.SORT_TIME
    val period: String
        get() = filter.value?.period ?: VideosSortDialog.PERIOD_ALL
    val type: String
        get() = filter.value?.type ?: VideosSortDialog.VIDEO_TYPE_ALL

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest { filter ->
        val selectedSort = filter?.sort ?: VideosSortDialog.SORT_TIME
        val selectedPeriod = filter?.period ?: VideosSortDialog.PERIOD_ALL
        val selectedType = filter?.type ?: VideosSortDialog.VIDEO_TYPE_ALL
        Pager(
            PagingConfig(pageSize = 30, prefetchDistance = 3, initialLoadSize = 30)
        ) {
            ChannelVideosDataSource(
                channelId = args.channelId,
                channelLogin = args.channelLogin,
                clipPeriod = when (selectedPeriod) {
                    VideosSortDialog.PERIOD_DAY -> "day"
                    VideosSortDialog.PERIOD_WEEK -> "week"
                    VideosSortDialog.PERIOD_MONTH -> "month"
                    VideosSortDialog.PERIOD_ALL -> "all"
                    else -> "all"
                },
                clipBroadcastTypes = when (selectedType) {
                    VideosSortDialog.VIDEO_TYPE_ALL -> "all"
                    VideosSortDialog.VIDEO_TYPE_ARCHIVE -> "archive"
                    VideosSortDialog.VIDEO_TYPE_HIGHLIGHT -> "highlight"
                    VideosSortDialog.VIDEO_TYPE_UPLOAD -> "upload"
                    else -> "all"
                },
                clipSort = when (selectedSort) {
                    VideosSortDialog.SORT_TIME -> "time"
                    VideosSortDialog.SORT_VIEWS -> "views"
                    else -> "time"
                },
                kickRepository = kickRepository,
            )
        }.flow
    }.cachedIn(viewModelScope)

    suspend fun getSortChannel(id: String): SortChannel? {
        return sortChannelRepository.getById(id)
    }

    suspend fun saveSortChannel(item: SortChannel) {
        sortChannelRepository.save(item)
    }

    suspend fun deleteSortChannel(item: SortChannel) {
        sortChannelRepository.delete(item)
    }

    fun setFilter(sort: String?, period: String?, type: String?) {
        filter.value = Filter(sort, period, type)
    }

    class Filter(
        val sort: String?,
        val period: String?,
        val type: String?,
    )

    fun saveBookmark(filesDir: String, video: Video, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        viewModelScope.launch {
            val item = video.id?.let { bookmarksRepository.getBookmarkByVideoId(it) }
            if (item != null) {
                bookmarksRepository.deleteBookmark(item)
            } else {
                val downloadedThumbnail = viewModelScope.cacheMediaImage(filesDir, "thumbnails", video.id, video.thumbnail) { url, output ->
                    playerRepository.downloadTo(networkLibrary, url, output)
                }
                val downloadedLogo = viewModelScope.cacheMediaImage(filesDir, "profile_pics", video.channelId, video.channelLogo) { url, output ->
                    playerRepository.downloadTo(networkLibrary, url, output)
                }
                val userTypes = video.channelId?.let {
                    if (kickPublicApiHeaders.isNotEmpty()) {
                        try {
                            kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = listOf(it)
                            ).data.firstOrNull()?.let {
                                User(
                                    channelId = it.channelId,
                                    channelLogin = it.channelLogin,
                                    channelName = it.channelName,
                                    type = it.type,
                                    broadcasterType = it.broadcasterType,
                                    profileImageUrl = it.profileImageUrl,
                                    createdAt = it.createdAt,
                                )
                            }
                        } catch (e: Exception) {
                            null
                        }
                    } else null
                }
                bookmarksRepository.saveBookmark(
                    Bookmark(
                        videoId = video.id,
                        userId = video.channelId,
                        userLogin = video.channelLogin,
                        userName = video.channelName,
                        userType = userTypes?.type,
                        userBroadcasterType = userTypes?.broadcasterType,
                        userLogo = downloadedLogo,
                        gameId = video.gameId,
                        gameSlug = video.gameSlug,
                        gameName = video.gameName,
                        title = video.title,
                        createdAt = video.uploadDate,
                        thumbnail = downloadedThumbnail,
                        type = video.type,
                        duration = video.duration,
                        animatedPreviewURL = video.animatedPreviewURL
                    )
                )
            }
        }
    }
}
