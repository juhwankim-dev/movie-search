package com.ssafy.movie_search.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ssafy.movie_search.data.db.dao.RecentSearchDao
import com.ssafy.movie_search.data.model.RecentSearchEntity

@Database(entities = [RecentSearchEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun recentSearchDao(): RecentSearchDao
}