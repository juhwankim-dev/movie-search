package com.ssafy.movie_search.present.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssafy.movie_search.domain.model.Movie
import com.ssafy.movie_search.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MovieSharedViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
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

    private fun showError() {
        // TODO: 에러 처리
    }

    fun onSearchClick() {
        getMovieList(keyword.value.toString())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}