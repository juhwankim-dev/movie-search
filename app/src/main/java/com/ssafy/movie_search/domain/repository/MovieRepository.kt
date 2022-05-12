package com.ssafy.movie_search.domain.repository

import com.ssafy.movie_search.domain.model.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getMovieList(keyword: String): Single<List<Movie>>
}