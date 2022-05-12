package com.ssafy.movie_search.domain.usecase.recent_search

import com.ssafy.movie_search.data.model.RecentSearchEntity
import com.ssafy.movie_search.domain.repository.RecentSearchRepository
import javax.inject.Inject

class WriteRecentSearchUseCase @Inject constructor(
    private val recentSearchRepository: RecentSearchRepository
) {
    operator fun invoke(recentSearchEntity: RecentSearchEntity)
        = recentSearchRepository.writeRecentSearch(recentSearchEntity)
}