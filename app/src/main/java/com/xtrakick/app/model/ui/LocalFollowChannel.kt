package com.xtrakick.app.model.ui

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtrakick.app.util.AppConstants

@Entity(tableName = "local_follows")
class LocalFollowChannel(
    var userId: String? = null,
    var userLogin: String? = null,
    var userName: String? = null,
    var channelLogo: String? = null,
    var sourceMask: Int = 1,
) {

    val isKickFollow: Boolean
        get() = (sourceMask and AppConstants.FOLLOW_SOURCE_MASK_KICK) != 0

    val isLocalOnlyFollow: Boolean
        get() = (sourceMask and AppConstants.FOLLOW_SOURCE_MASK_KICK) == 0

    @PrimaryKey(autoGenerate = true)
    var id = 0
}
