package com.ssafy.movie_search.present.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.movie_search.data.model.RecentSearchEntity
import com.ssafy.movie_search.domain.model.Movie
import com.ssafy.movie_search.domain.usecase.GetMovieListUseCase
import com.ssafy.movie_search.domain.usecase.recent_search.WriteRecentSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val writeRecentSearchUseCase: WriteRecentSearchUseCase
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val keyword = MutableLiveData<String>()

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> get() = _movieList

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private fun getMovieList(keyword: String) {
        _isLoading.value = false
        compositeDisposable.add(
            getMovieListUseCase(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _isLoading.value = false
                        _movieList.value = it
                    },
                    {
                        _isLoading.value = false
                        showError()
                    },
                )
        )
    }

    fun writeRecentSearch(recentSearchEntity: RecentSearchEntity) {
        writeRecentSearchUseCase.invoke(recentSearchEntity)
    }

    private fun showError() {
        // TODO: 에러 처리
    }

    fun onSearchClick() {
        search(keyword.value.toString())
    }

    fun search(keyword: String) {
        getMovieList(keyword)
        viewModelScope.launch(Dispatchers.IO) {
            writeRecentSearch(RecentSearchEntity(keyword))
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}