package com.ssafy.movie_search.domain.usecase.recent_search

import androidx.lifecycle.LiveData
import com.ssafy.movie_search.data.model.RecentSearchEntity
import com.ssafy.movie_search.domain.repository.RecentSearchRepository
import javax.inject.Inject

class ReadRecentSearchListUseCase @Inject constructor(
    private val recentSearchRepository: RecentSearchRepository
) {
    operator fun invoke(): LiveData<List<RecentSearchEntity>>
        = recentSearchRepository.readRecentSearchList()
}