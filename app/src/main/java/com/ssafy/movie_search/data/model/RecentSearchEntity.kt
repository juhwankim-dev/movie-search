package com.ssafy.movie_search.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssafy.movie_search.present.utils.RECENT_SEARCH_TABLE

@Entity(tableName = RECENT_SEARCH_TABLE)
data class RecentSearchEntity(
    var keyword: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int = 0
}
