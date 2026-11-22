package com.xtrakick.app.model.chat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "recent_emotes",
    indices = [
        Index(value = ["used_at"]),
    ],
)
class RecentEmote(
    @PrimaryKey
    val name: String,
    @ColumnInfo(name = "used_at")
    val usedAt: Long,
) {

    companion object {
        const val MAX_SIZE = 50
    }
}
