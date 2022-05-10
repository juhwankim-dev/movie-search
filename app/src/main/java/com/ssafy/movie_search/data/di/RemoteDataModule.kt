package com.ssafy.movie_search.data.di

import com.ssafy.movie_search.data.api.MovieApi
import com.ssafy.movie_search.data.repository.Movie.MovieRemoteDataSource
import com.ssafy.movie_search.data.repository.Movie.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(movieApi: MovieApi): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieApi)
    }
}