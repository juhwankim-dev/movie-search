package com.ssafy.movie_search.data.di

import android.content.Context
import androidx.room.Room
import com.ssafy.movie_search.data.db.AppDatabase
import com.ssafy.movie_search.data.db.dao.RecentSearchDao
import com.ssafy.movie_search.data.repository.RecentSearch.RecentSearchLocalDataSource
import com.ssafy.movie_search.data.repository.RecentSearch.RecentSearchLocalDataSourceImpl
import com.ssafy.movie_search.present.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRecentSearchDao(appDatabase: AppDatabase): RecentSearchDao {
        return appDatabase.recentSearchDao()
    }

    @Provides
    @Singleton
    fun provideRecentSearchLocalDataSource(recentSearchDao: RecentSearchDao): RecentSearchLocalDataSource {
        return RecentSearchLocalDataSourceImpl(recentSearchDao)
    }
}