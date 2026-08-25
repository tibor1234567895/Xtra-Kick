package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource.LoadResult
import com.xtrakick.app.util.AppConstants

internal object KickSearchLoadStrategy {

    fun useLegacySearch(legacyEnabled: Boolean): Boolean = legacyEnabled

    fun <T : Any> shouldTryNextApi(
        apiPref: String?,
        legacyEnabled: Boolean,
        result: LoadResult.Page<Int, T>
    ): Boolean {
        if (apiPref == AppConstants.KICK && !legacyEnabled) {
            return false
        }
        return result.data.isEmpty() && result.nextKey == null
    }
}
