package com.ssafy.movie_search.data.model

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("actor")
    val actor: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pubDate")
    val pubDate: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userRating")
    val userRating: String
)
