package com.ssafy.movie_search.present.views

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.andback.pocketfridge.present.config.BaseFragment
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentMovieBinding
import com.ssafy.movie_search.present.utils.PageSet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(R.layout.fragment_movie) {
    private val viewModel: MovieViewModel by viewModels()
    lateinit var movieAdapter: MovieAdapter
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
        initEvent()
    }

    private fun initView() {
        movieAdapter = MovieAdapter()

        binding.rvMovieF.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayout.VERTICAL))
        }

        binding.btnMovieFRecentSearch.setOnClickListener {
            mainActivity.onChangeFragement(PageSet.RECENT_SERACH)
        }
    }

    private fun initViewModel() {
        binding.vm = viewModel

        with(viewModel) {
            movieList.observe(viewLifecycleOwner) {
                movieAdapter.setList(it)
            }

            toastMsg.observe(viewLifecycleOwner) {
                showToastMessage(it)
            }

            isLoading.observe(viewLifecycleOwner) {
                binding.lottieMovieF.apply {
                    if(it) {
                        playAnimation()
                        visibility = View.VISIBLE
                    } else {
                        pauseAnimation()
                        visibility = View.INVISIBLE
                    }
                }
            }
        }
    }

    private fun initEvent() {
        movieAdapter.setItemClickListener(object: MovieAdapter.ItemClickListener{
            override fun onClick(link: String) {
                setFragmentResult("webLink", bundleOf("webLink" to link))
                mainActivity.onChangeFragement(PageSet.WEB_VIEW)
            }
        })

        setFragmentResultListener("searchedKeyword") { _, bundle ->
            var searchedKeyword = bundle.getSerializable("searchedKeyword").toString()
            viewModel.search(searchedKeyword)
        }
    }
}