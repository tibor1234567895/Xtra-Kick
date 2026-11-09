package com.xtrakick.app.ui.game

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.LocalFollowGame
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowGameRepository
import com.xtrakick.app.util.KickApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class GamePagerViewModel @Inject constructor(
    private val kickRepository: KickRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val localFollowsGame: LocalFollowGameRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val args = GamePagerFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val _isFollowing = MutableStateFlow<Boolean?>(null)
    val isFollowing: StateFlow<Boolean?> = _isFollowing
    val follow = MutableStateFlow<Pair<Boolean, String?>?>(null)
    private var updatedLocalGame = false

    private val _game = MutableStateFlow<Game?>(null)
    val game: StateFlow<Game?> = _game

    fun loadGame(networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        val initialSlug = KickApiHelper.resolveEffectiveCategorySlug(args.gameSlug, args.gameName)
        val initialSanitizedId = KickApiHelper.sanitizeGameId(args.gameId, initialSlug)
        if (_game.value == null) {
            if (!initialSlug.isNullOrBlank() || !args.gameName.isNullOrBlank() || !args.boxArt.isNullOrBlank()) {
                _game.value = Game(
                    gameId = initialSanitizedId,
                    gameSlug = initialSlug,
                    gameName = args.gameName,
                    boxArtUrl = args.boxArt
                )
            }
        }
        viewModelScope.launch {
            val slug = initialSlug
                ?: kickRepository.resolveCategorySlug(initialSanitizedId, args.gameName)
            if (!slug.isNullOrBlank()) {
                val subcategory = try {
                    kickRepository.getSubcategory(slug)
                } catch (_: Exception) {
                    null
                }
                if (subcategory != null) {
                    val fetchedGame = kickRepository.toGame(subcategory)
                    _game.value = Game(
                        gameId = fetchedGame.gameId ?: initialSanitizedId ?: _game.value?.gameId,
                        gameSlug = fetchedGame.gameSlug ?: slug,
                        gameName = fetchedGame.gameName ?: args.gameName ?: _game.value?.gameName,
                        boxArtUrl = fetchedGame.boxArtUrl ?: args.boxArt ?: _game.value?.boxArtUrl,
                        viewersCount = fetchedGame.viewersCount,
                        broadcastersCount = fetchedGame.broadcastersCount,
                        tags = fetchedGame.tags,
                    )
                    syncFollowedGame(fetchedGame, slug)
                    return@launch
                }
            }
            if (_game.value == null) {
                val queryId = initialSanitizedId.takeIf { slug.isNullOrBlank() }
                _game.value = try {
                    kickPublicApiRepository.getGames(
                        networkLibrary = networkLibrary,
                        headers = kickPublicApiHeaders,
                        ids = queryId?.let { listOf(it) },
                        names = if (queryId.isNullOrBlank()) args.gameName?.let { listOf(it) } else null
                    ).data.firstOrNull()?.let {
                        Game(
                            gameId = it.id,
                            gameName = it.name,
                            boxArtUrl = it.boxArtUrl
                        )
                    }
                } catch (e: Exception) {
                    null
                }
            }
        }
    }

    private suspend fun syncFollowedGame(game: Game, slug: String) {
        val targetId = KickApiHelper.sanitizeGameId(game.gameId ?: args.gameId, slug)
            ?: kickRepository.getCachedCategoryId(slug, game.gameName)
        val existingFollow = localFollowsGame.getFollowByIdOrSlug(targetId, slug) ?: return
        var followChanged = false
        val freshBoxArt = game.boxArtUrl
        if (!freshBoxArt.isNullOrBlank() && existingFollow.boxArt != freshBoxArt) {
            existingFollow.boxArt?.takeIf { it.startsWith("/") }?.let { File(it).delete() }
            existingFollow.boxArt = freshBoxArt
            followChanged = true
        }
        if (!game.gameName.isNullOrBlank() && existingFollow.gameName != game.gameName) {
            existingFollow.gameName = game.gameName
            followChanged = true
        }
        if (existingFollow.gameSlug.isNullOrBlank() && !slug.isNullOrBlank()) {
            existingFollow.gameSlug = slug
            followChanged = true
        }
        if (existingFollow.gameId.isNullOrBlank() && !targetId.isNullOrBlank()) {
            existingFollow.gameId = targetId
            followChanged = true
        }
        if (followChanged) {
            localFollowsGame.updateFollow(existingFollow)
        }
    }

    fun isFollowingGame(gameId: String?, gameSlug: String?, gameName: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>) {
        if (_isFollowing.value == null) {
            viewModelScope.launch {
                try {
                    val effectiveSlug = KickApiHelper.resolveEffectiveCategorySlug(gameSlug, gameName)
                    val effectiveId = KickApiHelper.sanitizeGameId(gameId ?: _game.value?.gameId, effectiveSlug)
                    _isFollowing.value = localFollowsGame.getFollowByIdOrSlug(effectiveId, effectiveSlug) != null
                } catch (e: Exception) {

                }
            }
        }
    }

    fun saveFollowGame(gameId: String?, gameSlug: String?, gameName: String?, gameBoxArt: String?, setting: Int, filesDir: String, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            try {
                val effectiveSlug = KickApiHelper.resolveEffectiveCategorySlug(gameSlug, gameName)
                val sanitizedParamId = KickApiHelper.sanitizeGameId(gameId, effectiveSlug)
                val effectiveId = _game.value?.gameId
                    ?: sanitizedParamId
                    ?: kickRepository.getCachedCategoryId(effectiveSlug, gameName ?: _game.value?.gameName)
                val effectiveName = gameName ?: _game.value?.gameName
                val effectiveBoxArt = gameBoxArt?.takeIf { it.isNotBlank() }
                    ?: _game.value?.boxArtUrl

                if (!effectiveId.isNullOrBlank() || !effectiveSlug.isNullOrBlank()) {
                    localFollowsGame.saveFollow(
                        LocalFollowGame(
                            gameId = effectiveId,
                            gameSlug = effectiveSlug,
                            gameName = effectiveName,
                            boxArt = effectiveBoxArt
                        )
                    )
                    _isFollowing.value = true
                    follow.value = Pair(true, null)
                }
            } catch (e: Exception) {

            }
        }
    }

    fun deleteFollowGame(gameId: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            try {
                val effectiveSlug = KickApiHelper.resolveEffectiveCategorySlug(args.gameSlug, args.gameName)
                val effectiveId = KickApiHelper.sanitizeGameId(gameId ?: _game.value?.gameId, effectiveSlug)
                val followItem = localFollowsGame.getFollowByIdOrSlug(effectiveId, effectiveSlug)
                if (followItem != null) {
                    localFollowsGame.deleteFollow(followItem)
                    _isFollowing.value = false
                    follow.value = Pair(false, null)
                }
            } catch (e: Exception) {

            }
        }
    }

    fun updateLocalGame(filesDir: String, gameId: String?, gameName: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>) {
        if (!updatedLocalGame) {
            updatedLocalGame = true
            val slug = KickApiHelper.resolveEffectiveCategorySlug(args.gameSlug, gameName)
            val id = KickApiHelper.sanitizeGameId(gameId ?: _game.value?.gameId, slug)
            if (slug.isNullOrBlank() && id.isNullOrBlank()) return

            viewModelScope.launch {
                val follow = localFollowsGame.getFollowByIdOrSlug(id, slug) ?: return@launch
                val currentLoadedGame = _game.value
                if (currentLoadedGame?.boxArtUrl != null && !slug.isNullOrBlank()) {
                    syncFollowedGame(currentLoadedGame, slug)
                } else if (!slug.isNullOrBlank()) {
                    val sub = runCatching { kickRepository.getSubcategory(slug) }.getOrNull()
                    if (sub != null) {
                        syncFollowedGame(kickRepository.toGame(sub), slug)
                    }
                }
            }
        }
    }
}
