package com.xtrakick.app.ui.channel.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.ChannelPanel
import com.xtrakick.app.repository.KickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
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

    private var isLoading = false

    fun loadAbout(channelId: String?, channelLogin: String?) {
        if ((description.value == null || team.value == null || socialMedias.value == null || panels.value == null) && !isLoading) {
            isLoading = true
            viewModelScope.launch {
                try {
                    if (channelLogin.isNullOrBlank()) {
                        // Kick has no public about lookup by numeric id; render empty instead
                        // of querying an API that cannot answer.
                        setEmpty()
                        return@launch
                    }
                    val kickChannel = runCatching { kickRepository.getChannel(channelLogin) }.getOrNull()
                    if (kickChannel != null) {
                        val user = kickChannel.user
                        description.value = user?.bio.orEmpty()
                        socialMedias.value = user?.let { buildKickSocialMedias(it) } ?: emptyList()
                    } else {
                        setEmpty()
                    }
                    team.value = null to null
                    originalName.value = null
                    panels.value = emptyList()
                } catch (e: Exception) {

                }
                isLoading = false
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
        ).mapNotNull { (title, url) ->
            url?.trim()?.takeIf { it.isNotBlank() }?.let {
                title to normalizeSocialUrl(title, it)
            }
        }
    }

    private fun normalizeSocialUrl(title: String, value: String): String {
        val url = value.trim()
        if (url.startsWith("http://", true) || url.startsWith("https://", true)) {
            return url
        }
        if (url.contains('/') || url.contains('.')) {
            return "https://$url"
        }
        val cleaned = url.removePrefix("@")
        return when (title) {
            "Instagram" -> "https://www.instagram.com/$cleaned"
            "Twitter" -> "https://x.com/$cleaned"
            "YouTube" -> "https://www.youtube.com/$cleaned"
            "Discord" -> "https://discord.gg/$cleaned"
            "TikTok" -> "https://www.tiktok.com/@$cleaned"
            "Facebook" -> "https://www.facebook.com/$cleaned"
            else -> "https://$url"
        }
    }
}
