package com.github.andreyasadchy.xtra.ui.channel.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.andreyasadchy.xtra.model.ui.ChannelPanel
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChannelAboutViewModel @Inject constructor(
    private val graphQLRepository: GraphQLRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)

    val description = MutableStateFlow<String?>(null)
    val socialMedias = MutableStateFlow<List<Pair<String?, String?>>?>(null)
    val team = MutableStateFlow<Pair<String?, String?>?>(null)
    val originalName = MutableStateFlow<String?>(null)
    val panels = MutableStateFlow<List<ChannelPanel>?>(null)

    private var isLoading = false

    fun loadAbout(channelId: String?, channelLogin: String?, networkLibrary: String?, gqlHeaders: Map<String, String>, enableIntegrity: Boolean) {
        if ((description.value == null || team.value == null || socialMedias.value == null || panels.value == null) && !isLoading) {
            isLoading = true
            viewModelScope.launch {
                try {
                    channelLogin?.let { login ->
                        val kickChannel = runCatching { kickRepository.getChannel(login) }.getOrNull()
                        if (kickChannel != null) {
                            val user = kickChannel.user
                            description.value = user?.bio.orEmpty()
                            socialMedias.value = user?.let { buildKickSocialMedias(it) } ?: emptyList()
                            team.value = null to null
                            originalName.value = null
                            panels.value = emptyList()
                        } else {
                            description.value = ""
                            socialMedias.value = emptyList()
                            team.value = null to null
                            originalName.value = null
                            panels.value = emptyList()
                        }
                        isLoading = false
                        return@launch
                    }
                    val queryId = channelId.takeIf { channelLogin.isNullOrBlank() }
                    val queryLogin = channelLogin.takeIf { queryId.isNullOrBlank() }
                    val response = graphQLRepository.loadQueryUserAbout(networkLibrary, gqlHeaders, queryId, queryLogin)
                    if (enableIntegrity && integrity.value == null) {
                        response.errors?.find { it.message == "failed integrity check" }?.let {
                            integrity.value = "refresh"
                            isLoading = false
                            return@launch
                        }
                    }
                    response.data!!.user?.let { user ->
                        description.value = user.description
                        socialMedias.value = user.channel?.socialMedias?.map {
                            it.title to it.url
                        }
                        team.value = user.primaryTeam?.name to user.primaryTeam?.displayName
                        originalName.value = user.subscriptionProducts?.find { it?.tier == "1000" }?.name?.takeIf { it != channelLogin }
                        panels.value = user.panels?.mapNotNull { item ->
                            item?.onDefaultPanel?.let {
                                ChannelPanel(
                                    title = it.title,
                                    imageUrl = it.imageURL,
                                    linkUrl = it.linkURL,
                                    description = it.description,
                                )
                            }
                        }
                    }
                } catch (e: Exception) {

                }
                isLoading = false
            }
        }
    }

    private fun buildKickSocialMedias(user: com.github.andreyasadchy.xtra.model.kick.KickUser): List<Pair<String?, String?>> {
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
