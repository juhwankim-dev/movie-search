package com.ssafy.movie_search.data.repository.RecentSearch

import androidx.lifecycle.LiveData
import com.ssafy.movie_search.data.db.dao.RecentSearchDao
import com.ssafy.movie_search.data.model.RecentSearchEntity
import javax.inject.Inject

class RecentSearchLocalDataSourceImpl @Inject constructor(
    private val dao: RecentSearchDao
): RecentSearchLocalDataSource {
    override fun writeRecentSearch(recentSearchEntity: RecentSearchEntity) {
        return dao.write(recentSearchEntity)
    }

    override fun readRecentSearchList(): LiveData<List<RecentSearchEntity>> {
        return dao.readAll()
    }

    override fun deleteLastItemIfOver10() {
        return dao.deleteLastItemIfOver10()
    }
}