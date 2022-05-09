package com.ssafy.movie_search.present.views

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.andback.pocketfridge.present.config.BaseFragment
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentMovieBinding
import com.ssafy.movie_search.domain.model.Movie

class MovieFragment : BaseFragment<FragmentMovieBinding>(R.layout.fragment_movie) {
    lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    fun initView() {
        movieAdapter = MovieAdapter()

        binding.rvMovieF.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayout.VERTICAL))
        }

        // TODO: 테스트를 위해 임시 데이터를 넣어둠. 
        movieAdapter.setList(
            arrayListOf(Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"),
                Movie(null, "제목 : 아이", "출시 : 2021", "평점 : 0.00"))
        )
    }
}