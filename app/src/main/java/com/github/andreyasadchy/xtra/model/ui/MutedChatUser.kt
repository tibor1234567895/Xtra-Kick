package com.github.andreyasadchy.xtra.model.ui

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "muted_chat_users")
class MutedChatUser(
    var userId: String? = null,
    var userLogin: String? = null,
    var userName: String? = null,
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}
