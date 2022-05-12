package com.ssafy.movie_search.data.api

import com.ssafy.movie_search.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("v1/search/movie.json")
    fun getMovieList(
        @Query("query") query: String,
        @Query("start") start: Int = 1,
        @Query("display") display: Int = 10
    ): Single<MovieResponse>
}