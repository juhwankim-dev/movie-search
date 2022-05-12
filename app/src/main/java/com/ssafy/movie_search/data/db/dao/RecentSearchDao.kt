package com.ssafy.movie_search.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ssafy.movie_search.data.model.RecentSearchEntity
import com.ssafy.movie_search.present.utils.RECENT_SEARCH_TABLE

@Dao
interface RecentSearchDao {
    @Insert()
    fun write(recentSearchEntity: RecentSearchEntity)

    @Query("SELECT * FROM $RECENT_SEARCH_TABLE")
    fun readAll(): LiveData<List<RecentSearchEntity>>

    @Query("DELETE FROM $RECENT_SEARCH_TABLE WHERE id IN (SELECT id FROM $RECENT_SEARCH_TABLE ORDER BY id ASC LIMIT 1) AND 10 = (SELECT COUNT(*) FROM $RECENT_SEARCH_TABLE)")
    fun deleteLastItemIfOver10()
}