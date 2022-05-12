package com.ssafy.movie_search.present.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ssafy.movie_search.R

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("bindImageUrl")
    fun bindImageUrl(view: ImageView, src: String){
        Glide.with(view.context)
            .load(src)
            .error(R.drawable.ic_no_image)
            .into(view)
    }
}