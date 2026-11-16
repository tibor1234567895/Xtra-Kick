package com.xtrakick.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.R
import com.xtrakick.app.model.kick.KickCollectible
import com.xtrakick.app.model.kick.KickUserLevel
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
class CollectiblesViewModel @Inject constructor(
    private val rewardsRepository: KickRewardsRepository,
) : ViewModel() {

    data class UiState(
        val isLoading: Boolean = false,
        val collectibles: List<KickCollectible> = emptyList(),
        val userLevel: KickUserLevel? = null,
        /** String resource of the last load failure; null while data is shown. */
        val errorRes: Int? = null,
    )

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        loadCollectibles()
    }

    fun loadCollectibles() {
        if (_state.value.isLoading) return
        _state.value = _state.value.copy(isLoading = true, errorRes = null)

        viewModelScope.launch {
            try {
                val collectibles: List<KickCollectible>
                val userLevel: KickUserLevel?
                withContext(Dispatchers.IO) {
                    collectibles = rewardsRepository.getCollectibles()
                    userLevel = runCatching { rewardsRepository.getUserLevel() }.getOrNull()
                }
                _state.value = UiState(isLoading = false, collectibles = collectibles, userLevel = userLevel)
            } catch (_: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorRes = if (rewardsRepository.canAttemptClaims()) {
                        R.string.collectibles_load_failed
                    } else {
                        R.string.collectibles_login_required
                    },
                )
            }
        }
    }
}
