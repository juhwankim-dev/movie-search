package com.ssafy.movie_search.present.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ssafy.movie_search.data.model.RecentSearchEntity
import com.ssafy.movie_search.domain.usecase.recent_search.ReadRecentSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecentSearchViewModel @Inject constructor(
    private val readRecentSearchListUseCase: ReadRecentSearchListUseCase
) : ViewModel() {
    private val recentSearchList: LiveData<List<RecentSearchEntity>> = readRecentSearchListUseCase.invoke()

    fun readRecentSearchList(): LiveData<List<RecentSearchEntity>> {
        return recentSearchList
    }
}