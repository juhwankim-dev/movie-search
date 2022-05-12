package com.ssafy.movie_search.domain.usecase

import com.ssafy.movie_search.domain.model.Movie
import com.ssafy.movie_search.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(keyword: String): Single<List<Movie>> = movieRepository.getMovieList(keyword)
}