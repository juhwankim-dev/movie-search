package com.ssafy.movie_search.present.utils

import com.ssafy.movie_search.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Naver-Client-Id", BuildConfig.X_NAVER_CLIENT_ID)
            .addHeader("X-Naver-Client-Secret", BuildConfig.X_NAVER_CLIENT_SECRET)
            .build()

        return chain.proceed(request)
    }
}