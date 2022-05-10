package com.ssafy.movie_search.present.utils

import com.ssafy.movie_search.data.api.MovieApi
import com.ssafy.movie_search.present.config.ApplicationClass

class RetrofitUtil {
    companion object {
        val movieService = ApplicationClass.retrofit.create(MovieApi::class.java)
    }
}