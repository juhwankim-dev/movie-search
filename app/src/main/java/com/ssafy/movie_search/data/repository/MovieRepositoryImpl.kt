package com.ssafy.movie_search.data.repository

import com.ssafy.movie_search.data.mapper.MovieMapper
import com.ssafy.movie_search.data.repository.Movie.MovieRemoteDataSource
import com.ssafy.movie_search.domain.model.Movie
import com.ssafy.movie_search.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {
    override fun getMovieList(keyword: String): Single<List<Movie>> {
        return movieRemoteDataSource.getMovieList(keyword).map { response ->
            response.movies.map { MovieMapper(it) }
        }
    }
}