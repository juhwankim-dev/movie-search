package com.ssafy.movie_search.present.views

import android.os.Bundle
import android.view.View
import com.andback.pocketfridge.present.config.BaseFragment
import com.google.android.material.chip.Chip
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentRecentSearchBinding

class RecentSearchFragment : BaseFragment<FragmentRecentSearchBinding>(R.layout.fragment_recent_search) {
    var test = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEvent()
    }

    private fun initEvent() {
        binding.btnRecentSearchFTemp.setOnClickListener {
            binding.cgRecentSearchF.addView(Chip(requireContext()).apply {
                text = "${test++}번 chip"

                setOnClickListener {
                    showToastMessage("$text")
                }
            })
        }
    }
}