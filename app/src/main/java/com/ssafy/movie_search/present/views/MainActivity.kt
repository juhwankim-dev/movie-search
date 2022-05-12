package com.ssafy.movie_search.present.views

import android.os.Bundle
import com.andback.pocketfridge.present.config.BaseActivity
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.ActivityMainBinding
import com.ssafy.movie_search.present.utils.PageSet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //초기 실행화면 설정
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fl_main)

        if(currentFragment == null){
            val fragment = MovieFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_main, fragment)
                .commit()
        }
    }

    fun onChangeFragement(p: PageSet) {
        when (p) {
            PageSet.MOVIE -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_main, MovieFragment())
                .commit()
            PageSet.WEB_VIEW -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_main, WebViewFragment())
                .commit()
            PageSet.RECENT_SERACH -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_main, RecentSearchFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}