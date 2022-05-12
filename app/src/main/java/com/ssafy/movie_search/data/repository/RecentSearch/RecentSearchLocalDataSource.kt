package com.ssafy.movie_search.data.repository.RecentSearch

import androidx.lifecycle.LiveData
import com.ssafy.movie_search.data.model.RecentSearchEntity

interface RecentSearchLocalDataSource {
    fun writeRecentSearch(recentSearchEntity: RecentSearchEntity)
    fun readRecentSearchList(): LiveData<List<RecentSearchEntity>>
    fun deleteLastItemIfOver10()
}