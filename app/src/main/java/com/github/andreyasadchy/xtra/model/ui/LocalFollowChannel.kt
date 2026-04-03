package com.github.andreyasadchy.xtra.model.ui

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_follows")
class LocalFollowChannel(
    var userId: String? = null,
    var userLogin: String? = null,
    var userName: String? = null,
    var channelLogo: String? = null,
    var sourceMask: Int = 1,
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}
