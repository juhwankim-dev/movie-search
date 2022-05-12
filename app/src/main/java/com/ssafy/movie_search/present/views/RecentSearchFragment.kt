package com.ssafy.movie_search.present.views

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.andback.pocketfridge.present.config.BaseFragment
import com.google.android.material.chip.Chip
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentRecentSearchBinding
import com.ssafy.movie_search.present.utils.PageSet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentSearchFragment : BaseFragment<FragmentRecentSearchBinding>(R.layout.fragment_recent_search) {
    private val viewModel: RecentSearchViewModel by viewModels()
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }

    private fun initViewModel() {
        with(viewModel) {
            readRecentSearchList().observe(viewLifecycleOwner) { searchList ->
                for(i in searchList.lastIndex downTo 0) {
                    binding.cgRecentSearchF.addView(Chip(requireContext()).apply {
                        text = "${searchList[i].keyword}"

                        setOnClickListener {
                            setFragmentResult("searchedKeyword", bundleOf("searchedKeyword" to text))
                            mainActivity.onChangeFragement(PageSet.MOVIE)
                        }
                    })
                }
            }
        }
    }
}