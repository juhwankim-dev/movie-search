package com.ssafy.movie_search.present.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.movie_search.databinding.ItemMovieListBinding
import com.ssafy.movie_search.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var itemClickListener: ItemClickListener
    private val movieList: ArrayList<Movie> = ArrayList()

    inner class MovieViewHolder(private val binding: ItemMovieListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindInfo(movie: Movie) {
            binding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var binding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.apply {
            bindInfo(movieList[position])

            itemView.setOnClickListener{
                itemClickListener.onClick(movieList[position].webLink)
            }
        }
    }

    override fun getItemCount(): Int = movieList.size

    fun setList(list: List<Movie>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onClick(link: String)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}