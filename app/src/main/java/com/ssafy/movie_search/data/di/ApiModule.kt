package com.ssafy.movie_search.data.di

import com.ssafy.movie_search.data.api.MovieApi
import com.ssafy.movie_search.present.utils.RetrofitUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideMovieApiInterface(): MovieApi {
        return RetrofitUtil.movieService
    }
}