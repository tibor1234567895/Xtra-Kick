package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource.LoadResult
import com.github.andreyasadchy.xtra.util.C

internal object KickSearchLoadStrategy {

    fun useLegacySearch(legacyEnabled: Boolean): Boolean = legacyEnabled

    fun <T : Any> shouldTryNextApi(
        apiPref: String?,
        legacyEnabled: Boolean,
        result: LoadResult.Page<Int, T>
    ): Boolean {
        if (apiPref == C.KICK && !legacyEnabled) {
            return false
        }
        return result.data.isEmpty() && result.nextKey == null
    }
}
