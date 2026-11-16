package com.xtrakick.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.R
import com.xtrakick.app.model.kick.KickDropCampaignFull
import com.xtrakick.app.model.kick.KickDropRewardItem
import com.xtrakick.app.repository.KickRewardsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DropsViewModel @Inject constructor(
    private val rewardsRepository: KickRewardsRepository,
) : ViewModel() {

    private val _campaigns = MutableStateFlow<List<KickDropCampaignFull>>(emptyList())
    val campaigns: StateFlow<List<KickDropCampaignFull>> = _campaigns.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    /** String resource of the last load failure; null while showing data. */
    private val _errorRes = MutableStateFlow<Int?>(null)
    val errorRes: StateFlow<Int?> = _errorRes.asStateFlow()

    init {
        loadCampaigns()
    }

    fun loadCampaigns() {
        if (_isLoading.value) return
        _isLoading.value = true
        _errorRes.value = null

        viewModelScope.launch {
            try {
                val list = withContext(Dispatchers.IO) {
                    rewardsRepository.getAllDropCampaigns()
                }
                _campaigns.value = list
            } catch (_: Exception) {
                _errorRes.value = if (rewardsRepository.canAttemptClaims()) {
                    R.string.drops_load_failed
                } else {
                    R.string.drops_login_required
                }
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun claimReward(
        campaign: KickDropCampaignFull,
        reward: KickDropRewardItem,
        onComplete: (success: Boolean) -> Unit,
    ) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    rewardsRepository.claimDropReward(reward.id, campaign.id)
                }
                loadCampaigns()
                onComplete(true)
            } catch (_: Exception) {
                onComplete(false)
            }
        }
    }
}
