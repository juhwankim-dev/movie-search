package com.ssafy.movie_search.domain.repository

import androidx.lifecycle.LiveData
import com.ssafy.movie_search.data.model.RecentSearchEntity

interface RecentSearchRepository {
    fun writeRecentSearch(recentSearchEntity: RecentSearchEntity)
    fun readRecentSearchList(): LiveData<List<RecentSearchEntity>>
}