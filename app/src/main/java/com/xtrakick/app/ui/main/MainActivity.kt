package com.xtrakick.app.ui.main

import android.app.ActivityOptions
import android.app.PictureInPictureParams
import android.app.admin.DevicePolicyManager
import android.content.ActivityNotFoundException
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInstaller
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.content.IntentSanitizer
import androidx.core.content.edit
import androidx.core.content.res.use
import androidx.core.net.toUri
import androidx.core.os.LocaleListCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.withStarted
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.xtrakick.app.R
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.KickApp
import com.xtrakick.app.databinding.ActivityMainBinding
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.common.IntegrityDialog
import com.xtrakick.app.ui.common.Scrollable
import com.xtrakick.app.ui.game.GameMediaFragmentDirections
import com.xtrakick.app.ui.game.GamePagerFragmentDirections
import com.xtrakick.app.ui.games.GamesFragmentDirections
import com.xtrakick.app.ui.multipov.MultiPovFragment
import com.xtrakick.app.ui.multipov.MultiPovSessionStore
import com.xtrakick.app.ui.multipov.multiPovKey
import com.xtrakick.app.ui.player.IvsPlayerFragment
import com.xtrakick.app.ui.player.KickLivePlayback
import com.xtrakick.app.ui.player.Media3Fragment
import com.xtrakick.app.ui.player.PlayerFragment
import com.xtrakick.app.ui.top.TopStreamsFragmentDirections
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickOAuthConfig
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.applyTheme
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import com.google.android.material.color.MaterialColors
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        const val KEY_VIDEO = "video"

        const val INTENT_INSTALL_UPDATE = "com.xtrakick.app.INSTALL_UPDATE"
        const val INTENT_LIVE_NOTIFICATION = "com.xtrakick.app.LIVE_NOTIFICATION"
        const val INTENT_OPEN_DOWNLOADS_TAB = "com.xtrakick.app.OPEN_DOWNLOADS_TAB"
        const val INTENT_OPEN_DOWNLOADED_VIDEO = "com.xtrakick.app.OPEN_DOWNLOADED_VIDEO"
        const val INTENT_OPEN_PLAYER = "com.xtrakick.app.OPEN_PLAYER"
        const val INTENT_START_AUDIO_ONLY = "com.xtrakick.app.START_AUDIO_ONLY"
        const val INTENT_PLAY_PAUSE_PLAYER = "com.xtrakick.app.PLAY_PAUSE_PLAYER"
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController
    var playerFragment: PlayerFragment? = null
        private set
    var multiPovFragment: MultiPovFragment? = null
        private set
    private var launchingSettings = false
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            lifecycleScope.launch {
                viewModel.checkNetworkStatus.value = true
            }
        }

        override fun onLost(network: Network) {
            lifecycleScope.launch {
                viewModel.checkNetworkStatus.value = true
            }
        }
    }
    private val pipActionReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                INTENT_START_AUDIO_ONLY -> {
                    playerFragment?.startAudioOnly()
                    moveTaskToBack(false)
                }
                INTENT_PLAY_PAUSE_PLAYER -> {
                    playerFragment?.playPause()
                }
            }
        }
    }
    private lateinit var prefs: SharedPreferences
    var settingsResultLauncher: ActivityResultLauncher<Intent>? = null
    var loginResultLauncher: ActivityResultLauncher<Intent>? = null
    var logoutResultLauncher: ActivityResultLauncher<Intent>? = null

    private fun logPlayerShell(message: String) {
        if (BuildConfig.DEBUG && prefs.getBoolean(AppConstants.DEBUG_PLAYER_SHELL_LOGS, false)) {
            Log.d(TAG, message)
        }
    }

    //Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = prefs()
        logLaunchShape("onCreate", intent)
        if (isDuplicateLauncherTask(intent)) {
            DiagnosticLogger.w(TAG, "Finishing duplicate launcher task taskId=$taskId flags=${intent?.flags}")
            finish()
            return
        }
        migrateSettings()
        // The updater flags an update when the release asset is newer than the last check time.
        // CI re-uploads the APK without bumping versionCode, so detect (re)installs instead:
        // anything published before the install moment is the build being installed, i.e. seen.
        val lastInstallTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0)).lastUpdateTime
        } else {
            @Suppress("DEPRECATION")
            packageManager.getPackageInfo(packageName, 0).lastUpdateTime
        }
        if (tokenPrefs().getLong(AppConstants.UPDATE_LAST_INSTALL_TIME, 0L) != lastInstallTime) {
            tokenPrefs().edit {
                putLong(AppConstants.UPDATE_LAST_INSTALL_TIME, lastInstallTime)
                putLong(AppConstants.UPDATE_LAST_CHECKED, lastInstallTime)
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.integrity.collectLatest {
                    if (it != null &&
                        it != "done" &&
                        prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
                        prefs.getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true)
                    ) {
                        IntegrityDialog.show(supportFragmentManager, it)
                        viewModel.integrity.value = "done"
                    }
                }
            }
        }
        applyTheme()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        maybeShowUnexpectedLogoutNotice()
        setNavBarColor(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        val ignoreCutouts = prefs.getBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = if (ignoreCutouts) {
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime())
            } else {
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime() or WindowInsetsCompat.Type.displayCutout())
            }
            binding.navHostFragment.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                rightMargin = insets.right
            }
            binding.navBarContainer.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                rightMargin = insets.right
            }
            windowInsets
        }
        settingsResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            launchingSettings = false
            if (result.resultCode == RESULT_OK) {
                recreate()
            }
        }
        loginResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                restartActivity()
            }
        }
        logoutResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            restartActivity()
        }

        var initialized = savedInstanceState != null
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        val isNetworkAvailableOnCreate = networkCapabilities != null
                && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        viewModel.isNetworkAvailable.value = isNetworkAvailableOnCreate
        if (isNetworkAvailableOnCreate) {
            viewModel.startKickValidationIfNeeded(this)
        } else if (!initialized) {
            initialized = true
            Toast.makeText(this, R.string.no_connection, Toast.LENGTH_SHORT).show()
        }
        initNavigation()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.checkNetworkStatus.collectLatest {
                    if (it) {
                        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
                        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                        val isNetworkAvailable = networkCapabilities != null
                                && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                                && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                        if (viewModel.isNetworkAvailable.value != isNetworkAvailable) {
                            viewModel.isNetworkAvailable.value = isNetworkAvailable
                            if (initialized) {
                                Toast.makeText(this@MainActivity, if (isNetworkAvailable) R.string.connection_restored else R.string.no_connection, Toast.LENGTH_SHORT).show()
                            } else {
                                initialized = true
                            }
                            if (isNetworkAvailable) {
                                viewModel.startKickValidationIfNeeded(this@MainActivity)
                                if (!KickApiHelper.checkedUpdates &&
                                    prefs.getBoolean(AppConstants.UPDATE_CHECK_ENABLED, false) &&
                                    (prefs.getString(AppConstants.UPDATE_CHECK_FREQUENCY, "7")?.toIntOrNull() ?: 7) * 86400000 + tokenPrefs().getLong(AppConstants.UPDATE_LAST_CHECKED, 0) < System.currentTimeMillis()
                                ) {
                                    viewModel.checkUpdates(
                                        prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                        prefs.getString(AppConstants.UPDATE_URL, null) ?: "https://api.github.com/repos/tibor1234567895/Xtra-Kick/releases/tags/latest",
                                        tokenPrefs().getLong(AppConstants.UPDATE_LAST_CHECKED, 0)
                                    )
                                }
                            }
                        }
                        viewModel.checkNetworkStatus.value = false
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.updateUrl.collectLatest {
                    if (it != null) {
                        getAlertDialogBuilder()
                            .setTitle(getString(R.string.update_available))
                            .setMessage(getString(R.string.update_message))
                            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                                if (BuildConfig.DEBUG || prefs.getBoolean(AppConstants.UPDATE_USE_BROWSER, false)) {
                                    try {
                                        val intent = Intent(Intent.ACTION_VIEW, it.toUri()).apply {
                                            addCategory(Intent.CATEGORY_BROWSABLE)
                                        }
                                        startActivity(intent)
                                        tokenPrefs().edit {
                                            putLong(AppConstants.UPDATE_LAST_CHECKED, System.currentTimeMillis())
                                        }
                                    } catch (e: ActivityNotFoundException) {
                                        Toast.makeText(this@MainActivity, R.string.no_browser_found, Toast.LENGTH_LONG).show()
                                    }
                                } else {
                                    viewModel.downloadUpdate(prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), it)
                                }
                            }
                            .setNegativeButton(getString(R.string.no)) { _, _ ->
                                tokenPrefs().edit {
                                    putLong(AppConstants.UPDATE_LAST_CHECKED, System.currentTimeMillis())
                                }
                            }
                            .show()
                    }
                }
            }
        }
        connectivityManager.registerNetworkCallback(
            NetworkRequest.Builder().apply {
                addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                addCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                removeCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN)
            }.build(), networkCallback
        )
        ContextCompat.registerReceiver(
            this,
            pipActionReceiver,
            IntentFilter().apply {
                addAction(INTENT_START_AUDIO_ONLY)
                addAction(INTENT_PLAY_PAUSE_PLAYER)
            },
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
        restorePlayerFragment()
        handleIntent(intent)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.video.collectLatest { pair ->
                    val video = pair?.first
                    val offset = pair?.second
                    if (video != null) {
                        if (!video.id.isNullOrBlank()) {
                            playerFragment?.let {
                                it.minimize()
                                it.close()
                                closePlayer()
                            }
                            startVideo(video, offset, offset != null)
                            if (prefs.getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                                video.id.toLongOrNull()?.let { id ->
                                    viewModel.savePosition(id, offset ?: 0)
                                }
                            }
                        }
                        viewModel.video.value = null
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clip.collectLatest { clip ->
                    if (clip != null) {
                        if (!clip.id.isNullOrBlank()) {
                            startClip(clip)
                        }
                        viewModel.clip.value = null
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.user.collectLatest { user ->
                    if (user != null) {
                        if (!user.channelId.isNullOrBlank() || !user.channelLogin.isNullOrBlank()) {
                            playerFragment?.minimize()
                            navController.navigate(
                                ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                                    channelId = user.channelId,
                                    channelLogin = user.channelLogin,
                                    channelName = user.channelName,
                                    channelLogo = user.channelLogo,
                                )
                            )
                        }
                        viewModel.user.value = null
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.game.collectLatest { pair ->
                    if (pair != null) {
                        val game = pair.first
                        val tag = pair.second
                        if (game != null) {
                            playerFragment?.minimize()
                            navController.navigate(
                                if (prefs.getBoolean(AppConstants.UI_GAMEPAGER, true)) {
                                    GamePagerFragmentDirections.actionGlobalGamePagerFragment(
                                        gameId = game.gameId,
                                        gameSlug = game.gameSlug,
                                        gameName = game.gameName,
                                        boxArt = game.boxArt,
                                        tags = tag?.let { arrayOf(it) },
                                    )
                                } else {
                                    GameMediaFragmentDirections.actionGlobalGameMediaFragment(
                                        gameId = game.gameId,
                                        gameSlug = game.gameSlug,
                                        gameName = game.gameName,
                                        boxArt = game.boxArt,
                                        tags = tag?.let { arrayOf(it) },
                                    )
                                }
                            )
                        }
                        viewModel.game.value = null
                    }
                }
            }
        }
        if (prefs.getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false)) {
            WorkManager.getInstance(this).enqueueUniquePeriodicWork(
                "live_notifications",
                ExistingPeriodicWorkPolicy.KEEP,
                PeriodicWorkRequestBuilder<LiveNotificationWorker>(15, TimeUnit.MINUTES)
                    .setConstraints(
                        Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .build()
                    )
                    .build()
            )
        }
    }

    private fun setNavBarColor(isPortrait: Boolean) {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                window.isNavigationBarContrastEnforced = !isPortrait || !binding.navBarContainer.isVisible
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                @Suppress("DEPRECATION")
                window.navigationBarColor = if (isPortrait && binding.navBarContainer.isVisible) {
                    Color.TRANSPARENT
                } else {
                    val isLightTheme = obtainStyledAttributes(intArrayOf(androidx.appcompat.R.attr.isLightTheme)).use {
                        it.getBoolean(0, false)
                    }
                    ContextCompat.getColor(this, if (!isLightTheme) R.color.darkScrim else R.color.lightScrim)
                }
            }
            else -> {
                val isLightTheme = obtainStyledAttributes(intArrayOf(androidx.appcompat.R.attr.isLightTheme)).use {
                    it.getBoolean(0, false)
                }
                @Suppress("DEPRECATION")
                if (!isLightTheme) {
                    window.navigationBarColor = if (isPortrait && binding.navBarContainer.isVisible) {
                        Color.TRANSPARENT
                    } else {
                        ContextCompat.getColor(this, R.color.darkScrim)
                    }
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setNavBarColor(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
    }

    override fun onResume() {
        super.onResume()
        launchingSettings = false
        logPlayerShell("onResume restoring existing playerFragment=${playerFragment?.javaClass?.simpleName}")
        restorePlayerFragment()
    }

    private fun maybeShowUnexpectedLogoutNotice() {
        if (!KickApp.showUnexpectedLogoutNoticeThisProcess) {
            return
        }
        KickApp.showUnexpectedLogoutNoticeThisProcess = false
        AuthStateHelper.clearUnexpectedLogoutNotice(this)
        if (!AuthStateHelper.isKickLoggedIn(this)) {
            Toast.makeText(this, R.string.token_expired, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.unregisterNetworkCallback(networkCallback)
        unregisterReceiver(pipActionReceiver)
        if (isFinishing) {
            playerFragment?.close()
        }
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        logLaunchShape("onNewIntent", intent)
        handleIntent(intent)
    }

    private fun isDuplicateLauncherTask(intent: Intent?): Boolean {
        return !isTaskRoot &&
            intent?.action == Intent.ACTION_MAIN &&
            intent.hasCategory(Intent.CATEGORY_LAUNCHER)
    }

    private fun logLaunchShape(source: String, intent: Intent?) {
        // Lifecycle shape is useful in logcat while debugging launch tasks, but is not an
        // "important warning" for diagnostic file export (it dominated prior exports).
        DiagnosticLogger.i(
            TAG,
            "$source taskId=$taskId isTaskRoot=$isTaskRoot action=${intent?.action} " +
                "categories=${intent?.categories?.joinToString(",") ?: "-"} flags=${intent?.flags ?: 0} " +
                "dataHost=${intent?.data?.host ?: "-"}"
        )
    }

    private fun restartActivity() {
        finish()
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            },
            ActivityOptions.makeCustomAnimation(this, 0, 0).toBundle()
        )
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S &&
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
            packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE) &&
            prefs.getBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, true)
        ) {
            try {
                if (multiPovFragment?.canEnterPictureInPicture() == true) {
                    multiPovFragment?.enterFocusedPip()
                } else if (playerFragment?.canEnterPictureInPicture() == true) {
                    enterPictureInPictureMode(PictureInPictureParams.Builder().build())
                }
            } catch (e: IllegalStateException) {
                //device doesn't support PIP
            }
        }
    }

    private fun handleIntent(intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_VIEW -> {
                val url = intent.data?.toString()
                if (url != null) {
                    when {
                        url.contains("kick.com/videos/") || url.contains("kick.com/video/") -> {
                            val id = url.substringAfter("kick.com/videos/", "")
                                .ifEmpty { url.substringAfter("kick.com/video/", "") }
                                .takeIf { it.isNotBlank() }?.let { it.substringBefore("?", it.substringBefore("/")) }
                            val offset = url.substringAfter("?t=", "").takeIf { it.isNotBlank() }?.let { (KickApiHelper.getDuration(it) ?: 0) * 1000 }
                            if (!id.isNullOrBlank()) {
                                viewModel.loadVideo(
                                    id,
                                    offset,
                                    prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    KickApiHelper.getKickWebHeaders(this),
                                    KickApiHelper.getKickPublicApiHeaders(this),
                                    prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                )
                            }
                        }
                        url.contains("/clip/") -> {
                            val id = url.substringAfter("/clip/").takeIf { it.isNotBlank() }?.let { it.substringBefore("?", it.substringBefore("/")) }
                            if (!id.isNullOrBlank()) {
                                viewModel.loadClip(
                                    id,
                                    prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    KickApiHelper.getKickWebHeaders(this),
                                    KickApiHelper.getKickPublicApiHeaders(this),
                                    prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                )
                            }
                        }
                        url.contains("clips.kick.com/") -> {
                            val id = url.substringAfter("clips.kick.com/").takeIf { it.isNotBlank() }?.let { it.substringBefore("?", it.substringBefore("/")) }
                            if (!id.isNullOrBlank()) {
                                viewModel.loadClip(
                                    id,
                                    prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    KickApiHelper.getKickPublicApiHeaders(this),
                                    KickApiHelper.getKickWebHeaders(this),
                                    prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                )
                            }
                        }
                        url.contains("kick.com/category/") || url.contains("kick.com/categories/") -> {
                            val pathPrefix = if (url.contains("kick.com/category/")) "kick.com/category/" else "kick.com/categories/"
                            val slug = url.substringAfter(pathPrefix).takeIf { it.isNotBlank() }?.let { it.substringBefore("?", it.substringBefore("/")) }
                            val tag = url.substringAfter("?tl=", "").takeIf { it.isNotBlank() }?.substringBefore("&")
                            if (!slug.isNullOrBlank()) {
                                viewModel.loadGame(
                                    gameSlug = slug,
                                    tag = tag?.let { Uri.decode(it) },
                                    networkLibrary = prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    kickWebHeaders = KickApiHelper.getKickWebHeaders(this),
                                    kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(this),
                                    enableIntegrity = prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                )
                            }
                        }
                        url.contains("kick.com/tags/") -> {
                            val tag = url.substringAfter("kick.com/tags/").takeIf { it.isNotBlank() }?.let { it.substringBefore("?", it.substringBefore("/")) }
                            if (!tag.isNullOrBlank()) {
                                playerFragment?.minimize()
                                navController.navigate(
                                    TopStreamsFragmentDirections.actionGlobalTopFragment(
                                        tags = arrayOf(Uri.decode(tag))
                                    )
                                )
                            }
                        }
                        url.contains("kick.com/directory/all") -> {
                            playerFragment?.minimize()
                            navController.navigate(
                                TopStreamsFragmentDirections.actionGlobalTopFragment()
                            )
                        }
                        url.contains("kick.com/directory") -> {
                            playerFragment?.minimize()
                            navController.navigate(
                                GamesFragmentDirections.actionGlobalGamesFragment()
                            )
                        }
                        else -> {
                            val login = url.substringAfter("kick.com/").takeIf { it.isNotBlank() }?.let { it.substringBefore("?", it.substringBefore("/")) }
                            if (!login.isNullOrBlank()) {
                                viewModel.loadUser(
                                    login,
                                    prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    KickApiHelper.getKickWebHeaders(this),
                                    KickApiHelper.getKickPublicApiHeaders(this),
                                    prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                )
                            }
                        }
                    }
                }
            }
            INTENT_INSTALL_UPDATE -> {
                val extras = intent.extras
                if (extras?.getInt(PackageInstaller.EXTRA_STATUS) == PackageInstaller.STATUS_PENDING_USER_ACTION) {
                    val rawIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        extras.getParcelable(Intent.EXTRA_INTENT, Intent::class.java)
                    } else {
                        @Suppress("DEPRECATION")
                        extras.getParcelable(Intent.EXTRA_INTENT)
                    }
                    rawIntent?.takeIf(::isSystemInstallerIntent)?.let { verifiedIntent ->
                        tokenPrefs().edit {
                            putLong(AppConstants.UPDATE_LAST_CHECKED, System.currentTimeMillis())
                        }
                        val sanitized = IntentSanitizer.Builder()
                            .allowAnyComponent()
                            .build()
                            .sanitizeByFiltering(verifiedIntent)
                        try {
                            startActivity(sanitized)
                        } catch (e: Exception) {
                            DiagnosticLogger.e(TAG, "install confirmation activity launch failed", e)
                            // Debug builds target a different applicationId than release;
                            // PackageInstaller cannot hand off the confirmation dialog.
                            // Open the release page in the browser so the user can install manually.
                            runCatching {
                                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/tibor1234567895/Xtra-Kick/releases/latest")))
                            }
                        }
                    }
                }
            }
            INTENT_LIVE_NOTIFICATION -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(KEY_VIDEO, Stream::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra(KEY_VIDEO)
                }?.let {
                    startStream(it)
                }
            }
            INTENT_OPEN_DOWNLOADS_TAB -> {
                binding.navBar.selectedItemId = if (prefs.getBoolean(AppConstants.UI_SAVEDPAGER, true)) {
                    R.id.savedPagerFragment
                } else {
                    R.id.savedMediaFragment
                }
            }
            INTENT_OPEN_DOWNLOADED_VIDEO -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(KEY_VIDEO, OfflineVideo::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra(KEY_VIDEO)
                }?.let {
                    startOfflineVideo(it)
                }
            }
            INTENT_OPEN_PLAYER -> {
                multiPovFragment?.maximize()
                playerFragment?.maximize() //TODO if was closed need to reopen
            }
        }
    }

    /**
     * MainActivity is exported (it is the launcher), so any app can send it an
     * [INTENT_INSTALL_UPDATE] intent carrying an arbitrary [Intent.EXTRA_INTENT] and have us
     * start it with our own identity — an intent-redirection hole that can reach our own
     * non-exported components.
     *
     * The legitimate value is written by PackageInstaller into the FLAG_MUTABLE PendingIntent
     * committed in MainViewModel, and always resolves to the platform's install-confirmation
     * activity. Requiring a system target is therefore lossless and blocks the redirect.
     */
    private fun isSystemInstallerIntent(candidate: Intent): Boolean {
        val resolved = packageManager.resolveActivity(candidate, PackageManager.MATCH_DEFAULT_ONLY)
        val appInfo = resolved?.activityInfo?.applicationInfo ?: return false
        val systemFlags = ApplicationInfo.FLAG_SYSTEM or ApplicationInfo.FLAG_UPDATED_SYSTEM_APP
        return appInfo.flags and systemFlags != 0
    }

//Navigation listeners

    fun startStream(stream: Stream, resolvedUrl: String? = null, forceStandardLiveEngine: Boolean = false) {
        closeMultiPovInternal()
        val effectiveResolvedUrl = when {
            !resolvedUrl.isNullOrBlank() -> resolvedUrl
            stream.source == AppConstants.KICK -> null
            else -> stream.playbackUrl
        }
        startPlayer(createStreamFragment(stream, effectiveResolvedUrl, forceStandardLiveEngine))
    }

    fun startMultiPov(
        streams: List<Stream>,
        resolvedUrls: Map<String, String> = emptyMap(),
        focusedKey: String? = null,
    ) {
        if (isFinishing || isDestroyed) return
        if (!prefs.getBoolean(AppConstants.MULTIPOV_ENABLED, true)) {
            streams.firstOrNull()?.let { stream ->
                startStream(stream, resolvedUrls[stream.multiPovKey()])
            }
            return
        }
        if (streams.isEmpty()) return
        playerFragment?.close()
        playerFragment = null
        closeMultiPovInternal()
        val fragment = MultiPovFragment.newInstance(
            streams = streams,
            resolvedUrls = resolvedUrls,
            focusedKey = focusedKey,
        )
        multiPovFragment = fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.playerContainer, fragment)
            .commit()
        viewModel.isPlayerOpened = true
        viewModel.isMultiPovOpened = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            setPictureInPictureParams(PictureInPictureParams.Builder().setAutoEnterEnabled(false).build())
        }
    }

    fun addToMultiPov(stream: Stream, resolvedUrl: String? = null): Boolean {
        val existing = multiPovFragment
            ?: supportFragmentManager.findFragmentById(R.id.playerContainer) as? MultiPovFragment
        if (existing != null) {
            multiPovFragment = existing
            return existing.addStream(stream, resolvedUrl)
        }
        val key = stream.multiPovKey()
        val urls = buildMap {
            if (!resolvedUrl.isNullOrBlank()) put(key, resolvedUrl)
            else stream.playbackUrl?.takeIf { it.isNotBlank() }?.let { put(key, it) }
        }
        startMultiPov(listOf(stream), urls)
        return true
    }

    fun expandMultiPovFocus(stream: Stream, resolvedUrl: String?) {
        closeMultiPovInternal()
        startStream(stream, resolvedUrl)
    }

    fun closeMultiPov() {
        closeMultiPovInternal()
        viewModel.isPlayerOpened = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            setPictureInPictureParams(PictureInPictureParams.Builder().setAutoEnterEnabled(false).build())
        }
    }

    fun resumeMultiPovSession(): Boolean {
        if (!prefs.getBoolean(AppConstants.MULTIPOV_ENABLED, true)) return false
        val session = MultiPovSessionStore.load(prefs) ?: return false
        val streams = session.toStreams()
        if (streams.isEmpty()) return false
        prefs.edit {
            if (session.streamQuality.isNotBlank()) {
                putString(AppConstants.MULTIPOV_QUALITY, session.streamQuality)
                putString(AppConstants.MULTIPOV_SECONDARY_QUALITY, session.streamQuality)
            }
            putBoolean(AppConstants.MULTIPOV_BANDWIDTH_SAVING, session.bandwidthSaving)
        }
        startMultiPov(streams = streams, focusedKey = session.focusedKey)
        return true
    }

    private fun closeMultiPovInternal() {
        val fragment = multiPovFragment
            ?: supportFragmentManager.findFragmentById(R.id.playerContainer) as? MultiPovFragment
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss()
        }
        multiPovFragment = null
        viewModel.isMultiPovOpened = false
    }

    fun launchSettings() {
        launchingSettings = true
        settingsResultLauncher?.launch(Intent(this, com.xtrakick.app.ui.settings.SettingsActivity::class.java))
    }

    fun isLaunchingSettings(): Boolean = launchingSettings

    fun startVideo(video: Video, offset: Long?, ignoreSavedPosition: Boolean = false) {
        closeMultiPovInternal()
        val fragment = Media3Fragment.newInstance(video, offset, ignoreSavedPosition)
        startPlayer(fragment)
    }

    fun startClip(clip: Clip) {
        closeMultiPovInternal()
        val fragment = Media3Fragment.newInstance(clip)
        startPlayer(fragment)
    }

    fun startOfflineVideo(video: OfflineVideo) {
        closeMultiPovInternal()
        val fragment = Media3Fragment.newInstance(video)
        startPlayer(fragment)
    }

    private fun createStreamFragment(stream: Stream, resolvedUrl: String?, forceStandardLiveEngine: Boolean): PlayerFragment {
        return if (KickLivePlayback.shouldUseIvs(
                streamSource = stream.source,
                enginePreference = prefs.getString(AppConstants.PLAYER_KICK_LIVE_ENGINE, KickLivePlayback.ENGINE_IVS),
                forceStandardEngine = forceStandardLiveEngine
            )
        ) {
            IvsPlayerFragment.newInstance(stream, resolvedUrl, forceStandardLiveEngine)
        } else {
            createModernPlayerFragment(stream, resolvedUrl, forceStandardLiveEngine)
        }
    }

    private fun createModernPlayerFragment(stream: Stream, resolvedUrl: String?, forceStandardLiveEngine: Boolean): PlayerFragment {
        return Media3Fragment.newInstance(stream, resolvedUrl, forceStandardLiveEngine)
    }

//Player methods

    private fun startPlayer(fragment: PlayerFragment) {
        if (isFinishing || isDestroyed) {
            logPlayerShell(
                "startPlayer ignored finishing=$isFinishing destroyed=$isDestroyed " +
                    "fragment=${fragment.javaClass.simpleName}"
            )
            return
        }
        logPlayerShell(
            "startPlayer fragment=${fragment.javaClass.simpleName} replacing=${playerFragment?.javaClass?.simpleName}"
        )
        closeMultiPovInternal()
        playerFragment?.close()
        playerFragment = fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.playerContainer, fragment)
            .commit()
        viewModel.isPlayerOpened = true
        viewModel.isMultiPovOpened = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE) &&
            prefs.getBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, true)
        ) {
            setPictureInPictureParams(PictureInPictureParams.Builder().setAutoEnterEnabled(true).build())
        }
    }

    fun closePlayer() {
        val containerFragment = supportFragmentManager.findFragmentById(R.id.playerContainer)
        if (containerFragment != null) {
            supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .remove(containerFragment)
                .commit()
        }
        playerFragment = null
        multiPovFragment = null
        viewModel.isPlayerOpened = false
        viewModel.isMultiPovOpened = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            setPictureInPictureParams(PictureInPictureParams.Builder().setAutoEnterEnabled(false).build())
        }
        viewModel.sleepTimer?.cancel()
        viewModel.sleepTimerEndTime = 0L
    }

    private fun restorePlayerFragment() {
        if (multiPovFragment == null) {
            multiPovFragment =
                supportFragmentManager.findFragmentById(R.id.playerContainer) as? MultiPovFragment
            if (multiPovFragment != null) {
                viewModel.isMultiPovOpened = true
                viewModel.isPlayerOpened = true
                logPlayerShell("restorePlayerFragment found MultiPovFragment")
            }
        }
        if (playerFragment == null) {
            playerFragment = supportFragmentManager.findFragmentById(R.id.playerContainer) as? PlayerFragment
            logPlayerShell("restorePlayerFragment found=${playerFragment?.javaClass?.simpleName}")
        } else {
            val fragment = playerFragment
            logPlayerShell(
                "restorePlayerFragment existing=${fragment?.javaClass?.simpleName} " +
                    "viewReady=${fragment?.view != null} isPlayerOpened=${viewModel.isPlayerOpened}"
            )
            if (
                viewModel.isPlayerOpened &&
                fragment?.view != null &&
                fragment.secondViewIsHidden() &&
                prefs.getBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, true)
            ) {
                logPlayerShell("restorePlayerFragment maximizing existing player")
                fragment.maximize()
            }
        }
    }

    fun setSleepTimer(duration: Long) {
        viewModel.sleepTimer?.cancel()
        viewModel.sleepTimerEndTime = 0L
        if (duration > 0L) {
            viewModel.sleepTimer = Timer().apply {
                schedule(duration) {
                    lifecycleScope.launch {
                        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                            playerFragment?.let {
                                it.minimize()
                                it.close()
                                closePlayer()
                            }
                            if (prefs.getBoolean(AppConstants.SLEEP_TIMER_LOCK, false)) {
                                if ((getSystemService(POWER_SERVICE) as PowerManager).isInteractive) {
                                    try {
                                        (getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager).lockNow()
                                    } catch (e: SecurityException) {

                                    }
                                }
                            }
                        } else {
                            withStarted {
                                playerFragment?.let {
                                    it.minimize()
                                    it.close()
                                    closePlayer()
                                }
                            }
                        }
                    }
                }
            }
            viewModel.sleepTimerEndTime = System.currentTimeMillis() + duration
        }
    }

    fun getSleepTimerTimeLeft(): Long {
        return viewModel.sleepTimerEndTime - System.currentTimeMillis()
    }

    fun downloadStream(filesDir: String, id: String?, title: String?, startedAt: String?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?, downloadPath: String, quality: String, downloadChat: Boolean, downloadChatEmotes: Boolean, wifiOnly: Boolean) {
        viewModel.downloadStream(prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), filesDir, id, title, startedAt, channelId, channelLogin, channelName, channelLogo, thumbnail, gameId, gameSlug, gameName, downloadPath, quality, downloadChat, downloadChatEmotes, wifiOnly)
    }

    fun downloadVideo(filesDir: String, id: String?, title: String?, uploadDate: String?, type: String?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?, url: String, downloadPath: String, quality: String, from: Long, to: Long, downloadChat: Boolean, downloadChatEmotes: Boolean, playlistToFile: Boolean, wifiOnly: Boolean) {
        viewModel.downloadVideo(prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), filesDir, id, title, uploadDate, type, channelId, channelLogin, channelName, channelLogo, thumbnail, gameId, gameSlug, gameName, url, downloadPath, quality, from, to, downloadChat, downloadChatEmotes, playlistToFile, wifiOnly)
    }

    fun downloadClip(filesDir: String, clipId: String?, title: String?, uploadDate: String?, duration: Double?, videoId: String?, vodOffset: Int?, channelId: String?, channelLogin: String?, channelName: String?, channelLogo: String?, thumbnail: String?, gameId: String?, gameSlug: String?, gameName: String?, url: String, downloadPath: String, quality: String, downloadChat: Boolean, downloadChatEmotes: Boolean, wifiOnly: Boolean) {
        viewModel.downloadClip(prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), filesDir, clipId, title, uploadDate, duration, videoId, vodOffset, channelId, channelLogin, channelName, channelLogo, thumbnail, gameId, gameSlug, gameName, url, downloadPath, quality, downloadChat, downloadChatEmotes, wifiOnly)
    }

    fun popFragment() {
        navController.navigateUp()
    }

    private fun initNavigation() {
        navController = (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
        val tabList = prefs.getString(AppConstants.UI_NAVIGATION_TAB_LIST, null).let { tabPref ->
            val defaultTabs = AppConstants.DEFAULT_NAVIGATION_TAB_LIST.split(',')
            if (tabPref != null) {
                val list = tabPref.split(',').filter { item ->
                    defaultTabs.find { it.first() == item.first() } != null
                }.toMutableList()
                defaultTabs.forEachIndexed { index, item ->
                    if (list.find { it.first() == item.first() } == null) {
                        list.add(index, item)
                    }
                }
                list
            } else defaultTabs
        }
        navController.setGraph(navController.navInflater.inflate(R.navigation.nav_graph).also {
            val startOnFollowed = prefs.getString(AppConstants.UI_STARTONFOLLOWED, "1")?.toIntOrNull() ?: 1
            val isLoggedIn = com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(this)
            val defaultItem = tabList.find { it.split(':')[1] != "0" }?.split(':')[0] ?: "1"
            when {
                (isLoggedIn && startOnFollowed < 2) || (!isLoggedIn && startOnFollowed == 0) || defaultItem == "2" -> {
                    if (prefs.getBoolean(AppConstants.UI_FOLLOWPAGER, true)) {
                        it.setStartDestination(R.id.followPagerFragment)
                    } else {
                        it.setStartDestination(R.id.followMediaFragment)
                    }
                }
                defaultItem == "0" -> it.setStartDestination(R.id.rootGamesFragment)
                defaultItem == "3" -> {
                    if (prefs.getBoolean(AppConstants.UI_SAVEDPAGER, true)) {
                        it.setStartDestination(R.id.savedPagerFragment)
                    } else {
                        it.setStartDestination(R.id.savedMediaFragment)
                    }
                }
            }
        }, null)
        binding.navBar.apply {
            if (!prefs.getBoolean(AppConstants.UI_THEME_BOTTOM_NAV_COLOR, true) && prefs.getBoolean(AppConstants.UI_THEME_MATERIAL3, true)) {
                setBackgroundColor(MaterialColors.getColor(this, com.google.android.material.R.attr.colorSurface))
            }
            if (tabList.any { it.split(':')[2] != "0" }) {
                tabList.forEach {
                    val split = it.split(':')
                    val key = split[0]
                    val enabled = split[2] != "0"
                    if (enabled) {
                        when (key) {
                            "0" -> menu.add(Menu.NONE, R.id.rootGamesFragment, Menu.NONE, R.string.games).setIcon(R.drawable.ic_games_black_24dp)
                            "1" -> menu.add(Menu.NONE, R.id.rootTopFragment, Menu.NONE, R.string.popular).setIcon(R.drawable.ic_trending_up_black_24dp)
                            "2" -> {
                                if (prefs.getBoolean(AppConstants.UI_FOLLOWPAGER, true)) {
                                    menu.add(Menu.NONE, R.id.followPagerFragment, Menu.NONE, R.string.following).setIcon(R.drawable.ic_favorite_black_24dp)
                                } else {
                                    menu.add(Menu.NONE, R.id.followMediaFragment, Menu.NONE, R.string.following).setIcon(R.drawable.ic_favorite_black_24dp)
                                }
                            }
                            "3" -> {
                                if (prefs.getBoolean(AppConstants.UI_SAVEDPAGER, true)) {
                                    menu.add(Menu.NONE, R.id.savedPagerFragment, Menu.NONE, R.string.saved).setIcon(R.drawable.ic_file_download_black_24dp)
                                } else {
                                    menu.add(Menu.NONE, R.id.savedMediaFragment, Menu.NONE, R.string.saved).setIcon(R.drawable.ic_file_download_black_24dp)
                                }
                            }
                        }
                    }
                }
            } else {
                binding.navBarContainer.visibility = View.GONE
            }
            setupWithNavController(navController)
            setOnItemSelectedListener {
                NavigationUI.onNavDestinationSelected(it, navController)
                return@setOnItemSelectedListener true
            }
            setOnItemReselectedListener {
                if (!navController.popBackStack(it.itemId, false)) {
                    val currentFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)?.childFragmentManager?.fragments?.getOrNull(0)
                    if (currentFragment is Scrollable) {
                        currentFragment.scrollToTop()
                    }
                }
            }
        }
    }

    @OptIn(UnstableApi::class)
    private fun migrateSettings() {
        val version = prefs.getInt(AppConstants.SETTINGS_VERSION, 0).let {
            if (it == 0 && !prefs.getBoolean(AppConstants.FIRST_LAUNCH2, true)) {
                when {
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH9, true) -> 8
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH8, true) -> 7
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH7, true) -> 6
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH6, true) -> 5
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH5, true) -> 4
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH3, true) -> 3
                    !prefs.getBoolean(AppConstants.FIRST_LAUNCH1, true) -> 2
                    else -> 1
                }
            } else {
                it
            }
        }
        if (version < 1) {
            prefs.edit {
                val width = resources.displayMetrics.widthPixels
                val height = resources.displayMetrics.heightPixels
                val chatWidth = ((if (height > width) height else width) * (30 / 100f)).toInt()
                putInt(AppConstants.LANDSCAPE_CHAT_WIDTH, chatWidth)
                if (resources.getBoolean(R.bool.isTablet)) {
                    putString(AppConstants.PORTRAIT_COLUMN_COUNT, "2")
                    putString(AppConstants.LANDSCAPE_COLUMN_COUNT, "3")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    putString(AppConstants.THEME, "4")
                }
            }
        }
        if (version < 3) {
            val langPref = prefs.getString(AppConstants.UI_LANGUAGE, "")
            if (!langPref.isNullOrBlank() && langPref != "auto") {
                AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(langPref))
            }
        }
        if (version < 4) {
            // Stop seeding Twitch client IDs into GQL prefs. Clear known Twitch defaults when no token.
            prefs.edit {
                val knownTwitchClientIds = setOf(
                    "kd1unb4b3q4t58fwlpcbzcbnm76a8fp",
                    "ue6666qo983tsx6so1t0vnawi233wa",
                )
                val currentClientId = prefs().getString(AppConstants.GQL_CLIENT_ID2, null)
                if (currentClientId in knownTwitchClientIds && prefs().getString(AppConstants.GQL_TOKEN2, null).isNullOrBlank()) {
                    remove(AppConstants.GQL_CLIENT_ID2)
                }
            }
        }
        if (version < 5) {
            prefs.edit {
                if (prefs.getString(AppConstants.PLAYER_PROXY, "1")?.toIntOrNull() == 0) {
                    putBoolean(AppConstants.PLAYER_STREAM_PROXY, true)
                }
            }
        }
        if (version < 6) {
            prefs.edit {
                when {
                    MediaCodecSelector.DEFAULT.getDecoderInfos(MimeTypes.VIDEO_H265, false, false).none { it.hardwareAccelerated } -> {
                        putString(AppConstants.TOKEN_SUPPORTED_CODECS, "h264")
                    }
                    MediaCodecSelector.DEFAULT.getDecoderInfos(MimeTypes.VIDEO_AV1, false, false).none { it.hardwareAccelerated } -> {
                        putString(AppConstants.TOKEN_SUPPORTED_CODECS, "h265,h264")
                    }
                }
            }
        }
        if (version < 7) {
            prefs.edit {
                if (prefs.getString(AppConstants.UI_CUTOUTMODE, "0") == "1") {
                    putBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, true)
                }
            }
        }
        if (version < 8) {
            tokenPrefs().edit {
                putString(AppConstants.USER_ID, prefs.getString(AppConstants.USER_ID, null))
                putString(AppConstants.USERNAME, prefs.getString(AppConstants.USERNAME, null))
                putString(AppConstants.TOKEN, prefs.getString(AppConstants.TOKEN, null))
                putString(AppConstants.GQL_TOKEN2, prefs.getString(AppConstants.GQL_TOKEN2, null))
                putString(AppConstants.GQL_HEADERS, prefs.getString(AppConstants.GQL_HEADERS, null))
                putLong(AppConstants.INTEGRITY_EXPIRATION, prefs.getLong(AppConstants.INTEGRITY_EXPIRATION, 0))
            }
            prefs.edit {
                remove(AppConstants.USER_ID)
                remove(AppConstants.USERNAME)
                remove(AppConstants.TOKEN)
                remove(AppConstants.GQL_TOKEN)
                remove(AppConstants.GQL_TOKEN2)
                remove(AppConstants.GQL_HEADERS)
                remove(AppConstants.INTEGRITY_EXPIRATION)
            }
        }
        if (version < 9) {
            prefs.edit {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                    putBoolean(AppConstants.CHAT_USE_WEBP, false)
                    putString(AppConstants.CHAT_IMAGE_LIBRARY, "1")
                }
            }
        }
        if (version < 10) {
            viewModel.deleteOldImages()
            prefs.edit {
                prefs.getString(AppConstants.PLAYER_BACKGROUND_PLAYBACK, "0")?.let {
                    if (it == "1") {
                        putBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, false)
                    } else if (it == "2") {
                        putBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, false)
                        putBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO, false)
                    }
                }
            }
        }
        if (version < 11) {
            prefs.edit {
                val tabs = prefs.getStringSet(AppConstants.UI_NAVIGATION_TABS, null)?.toSortedSet()
                val defaultPage = prefs.getString(AppConstants.UI_DEFAULT_PAGE, null)
                if (tabs != null || defaultPage != null) {
                    val set = tabs ?: setOf("0", "1", "2", "3")
                    val default = defaultPage ?: "1"
                    val list = "0:${if (default == "0") "1" else "0"}:${if (set.contains("0")) "1" else "0"}," +
                            "1:${if (default == "1") "1" else "0"}:${if (set.contains("1")) "1" else "0"}," +
                            "2:${if (default == "2") "1" else "0"}:${if (set.contains("2")) "1" else "0"}," +
                            "3:${if (default == "3") "1" else "0"}:${if (set.contains("3")) "1" else "0"}"
                    putString(AppConstants.UI_NAVIGATION_TAB_LIST, list)
                }
                val defaultFollowPage = prefs.getString(AppConstants.UI_FOLLOW_DEFAULT_PAGE, null)
                if (defaultFollowPage != null) {
                    val list = "0:${if (defaultFollowPage == "3") "1" else "0"}:1," +
                            "1:${if (defaultFollowPage == "0") "1" else "0"}:1," +
                            "2:${if (defaultFollowPage == "2") "1" else "0"}:1"
                    putString(AppConstants.UI_FOLLOWING_TABS, list)
                }
                val defaultSavedPage = prefs.getString(AppConstants.UI_SAVED_DEFAULT_PAGE, null)
                if (defaultSavedPage != null) {
                    val list = "0:${if (defaultSavedPage == "0") "1" else "0"}:1," +
                            "1:${if (defaultSavedPage == "1") "1" else "0"}:1"
                    putString(AppConstants.UI_SAVED_TABS, list)
                }
            }
        }
        if (version < 12) {
            prefs.edit {
                if (!prefs.getBoolean("ui_theme_rounded_corners", true)) {
                    putString(AppConstants.UI_THEME_ROUNDED_CORNERS, "2")
                }
                putInt(AppConstants.SETTINGS_VERSION, 12)
            }
        }
        if (version < 13) {
            val currentKickRedirect = prefs.getString(AppConstants.KICK_REDIRECT_URI, null)
            val currentKickScopes = prefs.getString(AppConstants.KICK_SCOPES, null)
            val legacyUserId = tokenPrefs().getString(AppConstants.USER_ID, null)
            val legacyUserLogin = tokenPrefs().getString(AppConstants.USERNAME, null)
            val currentKickUserId = tokenPrefs().getString(AppConstants.KICK_USER_ID, null)
            val currentKickUserLogin = tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)
            prefs.edit {
                if (currentKickRedirect.isNullOrBlank() || currentKickRedirect == "https://localhost/callback") {
                    putString(AppConstants.KICK_REDIRECT_URI, KickOAuthConfig.DEFAULT_REDIRECT_URI)
                }
                if (currentKickScopes.isNullOrBlank()) {
                    putString(AppConstants.KICK_SCOPES, "user:read chat:write")
                }
                putString(AppConstants.API_LOGIN, AppConstants.KICK)
                putInt(AppConstants.SETTINGS_VERSION, 13)
            }
            tokenPrefs().edit {
                if (currentKickUserId.isNullOrBlank()) {
                    putString(AppConstants.KICK_USER_ID, legacyUserId)
                }
                if (currentKickUserLogin.isNullOrBlank()) {
                    putString(AppConstants.KICK_USER_LOGIN, legacyUserLogin)
                }
                remove(AppConstants.TOKEN)
                remove(AppConstants.GQL_HEADERS)
                remove(AppConstants.GQL_TOKEN)
                remove(AppConstants.GQL_TOKEN2)
                remove(AppConstants.GQL_TOKEN_WEB)
                remove(AppConstants.INTEGRITY_EXPIRATION)
            }
        }
        if (version < 14) {
            prefs.edit {
                val currentKickRedirect = prefs.getString(AppConstants.KICK_REDIRECT_URI, null)
                if (currentKickRedirect.isNullOrBlank() || currentKickRedirect == "https://localhost/callback") {
                    putString(AppConstants.KICK_REDIRECT_URI, KickOAuthConfig.DEFAULT_REDIRECT_URI)
                }
                remove(AppConstants.KICK_CLIENT_SECRET)
                putInt(AppConstants.SETTINGS_VERSION, 14)
            }
        }
        if (version < 15) {
            prefs.edit {
                putBoolean(AppConstants.CHAT_SHOW_CLEARMSG, true)
                putInt(AppConstants.SETTINGS_VERSION, 15)
            }
        }
        if (version < 16) {
            // Releases built before the fork rename shipped the upstream update check URL and
            // it got persisted on those installs. Drop it so the built-in default applies again.
            prefs.edit {
                if (prefs.getString(AppConstants.UPDATE_URL, null)?.contains("crackededed") == true) {
                    remove(AppConstants.UPDATE_URL)
                }
                putInt(AppConstants.SETTINGS_VERSION, 16)
            }
        }
    }
}
