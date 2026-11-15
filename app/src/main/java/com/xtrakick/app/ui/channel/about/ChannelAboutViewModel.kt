package com.xtrakick.app.ui.channel.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.ChannelPanel
import com.xtrakick.app.repository.KickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import javax.inject.Inject

@HiltViewModel
class ChannelAboutViewModel @Inject constructor(
    private val kickRepository: KickRepository,
) : ViewModel() {

    val description = MutableStateFlow<String?>(null)
    val socialMedias = MutableStateFlow<List<Pair<String?, String?>>?>(null)
    val team = MutableStateFlow<Pair<String?, String?>?>(null)
    val originalName = MutableStateFlow<String?>(null)
    val panels = MutableStateFlow<List<ChannelPanel>?>(null)

    private var loadJob: Job? = null
    private var loaded = false
    private var requestedLogin: String? = null
    private var panelsEnabled = false

    fun loadAbout(channelLogin: String?, showPanels: Boolean = true) {
        val sameRequest = requestedLogin == channelLogin && panelsEnabled == showPanels
        if (sameRequest && (loaded || loadJob?.isActive == true)) return
        loadJob?.cancel()
        requestedLogin = channelLogin
        panelsEnabled = showPanels
        loaded = false
        if (!showPanels) panels.value = emptyList()
        loadJob = viewModelScope.launch {
            try {
                if (channelLogin.isNullOrBlank()) {
                    setEmpty()
                    return@launch
                }
                val user = kickRepository.getChannel(channelLogin).user
                description.value = user?.bio.orEmpty()
                socialMedias.value = user?.let { buildKickSocialMedias(it) } ?: emptyList()
                team.value = null to null
                originalName.value = null
                panels.value = if (showPanels) {
                    kickRepository.getChannelLinks(channelLogin).sortedBy { it.order }.map { panel ->
                        ChannelPanel(
                            title = panel.title,
                            description = panel.description,
                            imageUrl = panel.image?.imageUrl?.toHttpUrlOrNull()?.toString(),
                            linkUrl = panel.link?.toHttpUrlOrNull()?.toString(),
                        )
                    }
                } else emptyList()
                loaded = true
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                panels.value = emptyList()
            }
        }
    }

    private fun setEmpty() {
        description.value = ""
        socialMedias.value = emptyList()
        team.value = null to null
        originalName.value = null
        panels.value = emptyList()
    }

    private fun buildKickSocialMedias(user: com.xtrakick.app.model.kick.KickUser): List<Pair<String?, String?>> {
        return listOf(
            "Instagram" to user.instagram,
            "Twitter" to user.twitter,
            "YouTube" to user.youtube,
            "Discord" to user.discord,
            "TikTok" to user.tiktok,
            "Facebook" to user.facebook,
            "Club" to user.club,
        ).mapNotNull { (title, url) ->
            url?.trim()?.takeIf { it.isNotBlank() }?.let {
                normalizeSocialUrl(title, it)?.let { normalized -> title to normalized }
            }
        }
    }

    companion object {
        internal fun normalizeSocialUrl(title: String, value: String): String? {
            val url = value.trim()
            if (url.startsWith("http://", true) || url.startsWith("https://", true)) {
                return url.toHttpUrlOrNull()?.toString()
            }
            if (url.contains(':')) return null
            if (url.contains('/') || url.contains('.')) {
                return "https://$url".toHttpUrlOrNull()?.toString()
            }
            val cleaned = url.removePrefix("@")
            return when (title) {
                "Instagram" -> "https://www.instagram.com/$cleaned"
                "Twitter" -> "https://x.com/$cleaned"
                "YouTube" -> "https://www.youtube.com/$cleaned"
                "Discord" -> "https://discord.gg/$cleaned"
                "TikTok" -> "https://www.tiktok.com/@$cleaned"
                "Facebook" -> "https://www.facebook.com/$cleaned"
                "Club" -> "https://club.com/$cleaned"
                else -> "https://$url"
            }.toHttpUrlOrNull()?.toString()
        }
    }
}
