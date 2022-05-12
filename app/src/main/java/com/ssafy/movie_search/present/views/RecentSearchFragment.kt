package com.ssafy.movie_search.present.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.andback.pocketfridge.present.config.BaseFragment
import com.google.android.material.chip.Chip
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentRecentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentSearchFragment : BaseFragment<FragmentRecentSearchBinding>(R.layout.fragment_recent_search) {
    private val viewModel: RecentSearchViewModel by viewModels()

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
                            showToastMessage("$text")
                        }
                    })
                }
            }
        }
    }
}