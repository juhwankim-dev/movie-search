package com.ssafy.movie_search.data.repository

import androidx.lifecycle.LiveData
import com.ssafy.movie_search.data.model.RecentSearchEntity
import com.ssafy.movie_search.data.repository.RecentSearch.RecentSearchLocalDataSource
import com.ssafy.movie_search.domain.repository.RecentSearchRepository
import javax.inject.Inject

class RecentSearchRepositoryImpl @Inject constructor(
    private val recentSearchLocalDataSource: RecentSearchLocalDataSource
): RecentSearchRepository {
    override fun writeRecentSearch(recentSearchEntity: RecentSearchEntity) {
        recentSearchLocalDataSource.deleteLastItemIfOver10()
        recentSearchLocalDataSource.writeRecentSearch(recentSearchEntity)
    }

    override fun readRecentSearchList(): LiveData<List<RecentSearchEntity>> {
        return recentSearchLocalDataSource.readRecentSearchList()
    }
}