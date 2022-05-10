package com.ssafy.movie_search.domain.model

data class Movie(
    val webLink: String,
    val imageUrl: String?,
    val title: String,
    val year: String,
    val rating: String
)
