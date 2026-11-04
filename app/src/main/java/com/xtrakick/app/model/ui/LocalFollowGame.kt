package com.xtrakick.app.model.ui

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_follows_games")
class LocalFollowGame(
    var gameId: String? = null,
    var gameSlug: String? = null,
    var gameName: String? = null,
    var boxArt: String? = null,
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}
