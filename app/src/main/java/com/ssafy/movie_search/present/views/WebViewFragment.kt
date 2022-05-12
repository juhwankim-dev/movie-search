package com.ssafy.movie_search.present.views

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.setFragmentResultListener
import com.andback.pocketfridge.present.config.BaseFragment
import com.ssafy.movie_search.R
import com.ssafy.movie_search.databinding.FragmentWebViewBinding

class WebViewFragment : BaseFragment<FragmentWebViewBinding>(R.layout.fragment_web_view) {
    private lateinit var url: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("webLink") { _, bundle ->
            url = bundle.getSerializable("webLink").toString()

            binding.wvWebViewF.webViewClient = WebViewClient()
            binding.wvWebViewF.settings.javaScriptEnabled = true // to load mobile version
            binding.wvWebViewF.loadUrl(url)
        }
    }
}