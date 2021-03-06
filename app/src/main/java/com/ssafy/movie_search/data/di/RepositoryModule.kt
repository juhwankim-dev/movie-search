package com.ssafy.movie_search.data.di

import com.ssafy.movie_search.data.repository.Movie.MovieRemoteDataSource
import com.ssafy.movie_search.data.repository.MovieRepositoryImpl
import com.ssafy.movie_search.data.repository.RecentSearch.RecentSearchLocalDataSource
import com.ssafy.movie_search.data.repository.RecentSearchRepositoryImpl
import com.ssafy.movie_search.domain.repository.MovieRepository
import com.ssafy.movie_search.domain.repository.RecentSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRecentSearchRepository(recentSearchLocalDataSource: RecentSearchLocalDataSource): RecentSearchRepository {
        return RecentSearchRepositoryImpl(recentSearchLocalDataSource)
    }
}