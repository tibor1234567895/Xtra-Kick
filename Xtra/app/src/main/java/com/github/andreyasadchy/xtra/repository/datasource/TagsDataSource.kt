package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Tag
import com.github.andreyasadchy.xtra.repository.GraphQLRepository

class TagsDataSource(
    private val getGameTags: Boolean,
    private val query: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val enableIntegrity: Boolean,
    private val networkLibrary: String?,
) : PagingSource<Int, Tag>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Tag> {
        return LoadResult.Page(
            data = emptyList(),
            prevKey = null,
            nextKey = null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Tag>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
