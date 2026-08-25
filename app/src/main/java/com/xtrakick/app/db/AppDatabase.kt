package com.xtrakick.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xtrakick.app.model.NotificationUser
import com.xtrakick.app.model.ShownNotification
import com.xtrakick.app.model.VideoPosition
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.model.ui.Bookmark
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.LocalFollowGame
import com.xtrakick.app.model.ui.MutedChatUser
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.model.ui.SavedFilter
import com.xtrakick.app.model.ui.RecentSearch
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.model.ui.SortGame
import com.xtrakick.app.model.ui.VodBookmarkIgnoredUser

@Database(
    entities = [OfflineVideo::class, RecentEmote::class, VideoPosition::class, LocalFollowChannel::class, LocalFollowGame::class, Bookmark::class, VodBookmarkIgnoredUser::class, SortChannel::class, SortGame::class, ShownNotification::class, NotificationUser::class, SavedFilter::class, RecentSearch::class, MutedChatUser::class],
    version = 36
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun videos(): VideosDao
    abstract fun recentEmotes(): RecentEmotesDao
    abstract fun videoPositions(): VideoPositionsDao
    abstract fun localFollowsChannel(): LocalFollowsChannelDao
    abstract fun localFollowsGame(): LocalFollowsGameDao
    abstract fun bookmarks(): BookmarksDao
    abstract fun vodBookmarkIgnoredUsers(): VodBookmarkIgnoredUsersDao
    abstract fun mutedChatUsers(): MutedChatUsersDao
    abstract fun sortChannelDao(): SortChannelDao
    abstract fun sortGameDao(): SortGameDao
    abstract fun shownNotificationsDao(): ShownNotificationsDao
    abstract fun notificationsDao(): NotificationUsersDao
    abstract fun savedFiltersDao(): SavedFiltersDao
    abstract fun recentSearchDao(): RecentSearchDao
}
