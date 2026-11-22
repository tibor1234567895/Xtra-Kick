package com.xtrakick.app.model.ui

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "muted_chat_users",
    indices = [
        Index(value = ["userId"]),
        Index(value = ["userLogin"]),
    ],
)
class MutedChatUser(
    var userId: String? = null,
    var userLogin: String? = null,
    var userName: String? = null,
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}
