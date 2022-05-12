package com.ssafy.movie_search.data.repository.Movie

import com.ssafy.movie_search.data.model.MovieResponse
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getMovieList(keyword: String): Single<MovieResponse>
}