package com.github.andreyasadchy.xtra.model.ui

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vod_bookmark_ignored_users")
class VodBookmarkIgnoredUser(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val userId: String,
)
