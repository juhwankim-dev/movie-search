package com.ssafy.movie_search.data.repository.Movie

import com.ssafy.movie_search.data.api.MovieApi
import com.ssafy.movie_search.data.model.MovieResponse
import io.reactivex.Single
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi
): MovieRemoteDataSource{
    override fun getMovieList(keyword: String): Single<MovieResponse> {
        return movieApi.getMovieList(keyword)
    }
}