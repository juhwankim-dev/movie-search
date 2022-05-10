package com.ssafy.movie_search.present.views

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.andback.pocketfridge.present.config.BaseFragment
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentMovieBinding

class MovieFragment : BaseFragment<FragmentMovieBinding>(R.layout.fragment_movie) {
    private val viewModel: MovieSharedViewModel by activityViewModels()
    lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    private fun initView() {
        movieAdapter = MovieAdapter()

        binding.rvMovieF.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayout.VERTICAL))
        }

        binding.btnMovieFRecentSearch.setOnClickListener {
            (context as MainActivity).startRecentSearchFragment()
        }
    }

    private fun initViewModel() {
        binding.vm = viewModel

        with(viewModel) {
            movieList.observe(viewLifecycleOwner) {
                movieAdapter.setList(it)
            }
        }
    }
}