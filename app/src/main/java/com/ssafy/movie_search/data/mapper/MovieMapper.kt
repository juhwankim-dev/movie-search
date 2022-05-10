package com.ssafy.movie_search.data.mapper

import com.ssafy.movie_search.data.model.MovieEntity
import com.ssafy.movie_search.domain.model.Movie

object MovieMapper {
    operator fun invoke(entity: MovieEntity): Movie {
        return Movie(
            webLink = entity.link,
            imageUrl = entity.image,
            title = entity.title.replace("<b>", "").replace("</b>",""),
            year = entity.pubDate,
            rating = entity.userRating
        )
    }
}