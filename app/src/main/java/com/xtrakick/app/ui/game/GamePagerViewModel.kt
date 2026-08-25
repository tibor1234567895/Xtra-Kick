package com.xtrakick.app.ui.game

import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.LocalFollowGame
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.LocalFollowGameRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class GamePagerViewModel @Inject constructor(
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val localFollowsGame: LocalFollowGameRepository,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
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
        if (_game.value == null) {
            if (!args.gameSlug.isNullOrBlank() || !args.gameName.isNullOrBlank() || !args.boxArt.isNullOrBlank()) {
                _game.value = Game(
                    gameId = args.gameId,
                    gameName = args.gameName,
                    boxArtUrl = args.boxArt
                )
                return
            }
            viewModelScope.launch {
                val queryId = args.gameId.takeIf { args.gameSlug.isNullOrBlank() }
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

    fun isFollowingGame(gameId: String?, gameSlug: String?, gameName: String?, setting: Int, networkLibrary: String?, kickWebHeaders: Map<String, String>) {
        if (_isFollowing.value == null) {
            viewModelScope.launch {
                try {
                    _isFollowing.value = gameId?.let { localFollowsGame.getFollowByGameId(it) } != null
                } catch (e: Exception) {

                }
            }
        }
    }

    fun saveFollowGame(gameId: String?, gameSlug: String?, gameName: String?, gameBoxArt: String?, setting: Int, filesDir: String, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, enableIntegrity: Boolean) {
        viewModelScope.launch {
            try {
                if (!gameId.isNullOrBlank()) {
                    File(filesDir, "box_art").mkdir()
                    val path = filesDir + File.separator + "box_art" + File.separator + gameId
                    val remoteBoxArt = gameBoxArt?.takeIf { it.isNotBlank() } ?: try {
                        if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                            kickPublicApiRepository.getGames(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = listOf(gameId)
                            ).data.firstOrNull()?.boxArtUrl
                        } else null
                    } catch (_: Exception) {
                        null
                    }?.takeIf { !it.isNullOrBlank() }?.let { KickApiHelper.getTemplateUrl(it, "game") }
                    viewModelScope.launch(Dispatchers.IO) {
                        try {
                            remoteBoxArt?.let {
                                when {
                                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                        val response = suspendCoroutine { continuation ->
                                            httpEngine.get().newUrlRequestBuilder(it, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                        }
                                        if (response.first.httpStatusCode in 200..299) {
                                            FileOutputStream(path).use {
                                                it.write(response.second)
                                            }
                                        }
                                    }
                                    networkLibrary == "Cronet" && cronetEngine != null -> {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                            val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                            cronetEngine.get().newUrlRequestBuilder(it, request.callback, cronetExecutor).build().start()
                                            val response = request.future.get()
                                            if (response.urlResponseInfo.httpStatusCode in 200..299) {
                                                FileOutputStream(path).use {
                                                    it.write(response.responseBody as ByteArray)
                                                }
                                            }
                                        } else {
                                            val response = suspendCoroutine { continuation ->
                                                cronetEngine.get().newUrlRequestBuilder(it, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                            }
                                            if (response.first.httpStatusCode in 200..299) {
                                                FileOutputStream(path).use {
                                                    it.write(response.second)
                                                }
                                            }
                                        }
                                    }
                                    else -> {
                                        okHttpClient.newCall(Request.Builder().url(it).build()).execute().use { response ->
                                            if (response.isSuccessful) {
                                                FileOutputStream(path).use { outputStream ->
                                                    response.body.byteStream().use { inputStream ->
                                                        inputStream.copyTo(outputStream)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (e: Exception) {

                        }
                    }
                    localFollowsGame.saveFollow(
                        LocalFollowGame(
                            gameId,
                            gameSlug,
                            gameName,
                            path.takeIf { File(it).exists() } ?: remoteBoxArt
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
                if (gameId != null) {
                    localFollowsGame.getFollowByGameId(gameId)?.let { localFollowsGame.deleteFollow(it) }
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
            if (!args.gameSlug.isNullOrBlank()) {
                return
            }
            if (!gameId.isNullOrBlank()) {
                viewModelScope.launch {
                    File(filesDir, "box_art").mkdir()
                    val path = filesDir + File.separator + "box_art" + File.separator + gameId
                    val remoteBoxArt = try {
                        if (!kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
                            kickPublicApiRepository.getGames(
                                networkLibrary = networkLibrary,
                                headers = kickPublicApiHeaders,
                                ids = listOf(gameId)
                            ).data.firstOrNull()?.boxArtUrl
                        } else null
                    } catch (_: Exception) {
                        null
                    }?.takeIf { !it.isNullOrBlank() }?.let { KickApiHelper.getTemplateUrl(it, "game") }
                    viewModelScope.launch(Dispatchers.IO) {
                        try {
                            remoteBoxArt?.let {
                                when {
                                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                                        val response = suspendCoroutine { continuation ->
                                            httpEngine.get().newUrlRequestBuilder(it, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                                        }
                                        if (response.first.httpStatusCode in 200..299) {
                                            FileOutputStream(path).use {
                                                it.write(response.second)
                                            }
                                        }
                                    }
                                    networkLibrary == "Cronet" && cronetEngine != null -> {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                            val request = UrlRequestCallbacks.forByteArrayBody(RedirectHandlers.alwaysFollow())
                                            cronetEngine.get().newUrlRequestBuilder(it, request.callback, cronetExecutor).build().start()
                                            val response = request.future.get()
                                            if (response.urlResponseInfo.httpStatusCode in 200..299) {
                                                FileOutputStream(path).use {
                                                    it.write(response.responseBody as ByteArray)
                                                }
                                            }
                                        } else {
                                            val response = suspendCoroutine { continuation ->
                                                cronetEngine.get().newUrlRequestBuilder(it, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                                            }
                                            if (response.first.httpStatusCode in 200..299) {
                                                FileOutputStream(path).use {
                                                    it.write(response.second)
                                                }
                                            }
                                        }
                                    }
                                    else -> {
                                        okHttpClient.newCall(Request.Builder().url(it).build()).execute().use { response ->
                                            if (response.isSuccessful) {
                                                FileOutputStream(path).use { outputStream ->
                                                    response.body.byteStream().use { inputStream ->
                                                        inputStream.copyTo(outputStream)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (e: Exception) {

                        }
                    }
                    localFollowsGame.getFollowByGameId(gameId)?.let {
                        localFollowsGame.updateFollow(it.apply {
                            this.gameName = gameName
                            boxArt = path.takeIf { File(it).exists() } ?: remoteBoxArt ?: boxArt
                        })
                    }
                }
            }
        }
    }
}
