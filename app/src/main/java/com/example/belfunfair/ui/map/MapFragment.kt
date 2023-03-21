package com.example.belfunfair.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.R
import com.example.belfunfair.databinding.FragmentMapBinding


class MapFragment : Fragment() {

    private var _mapViewModel: MapViewModel? = null
    private var _binding: FragmentMapBinding? = null

    private val mapViewModel get() = _mapViewModel!!
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        initModel()
        return binding.root
    }

    private fun initModel(){
        _mapViewModel = ViewModelProvider(this)[MapViewModel::class.java]

        val title: TextView = binding.mapTitle
        mapViewModel.title.observe(viewLifecycleOwner) { title.text = it }

        //val map: ImageView = binding.map

        val webView: WebView = binding.webview
        val svg = resources.openRawResource(R.raw.map).bufferedReader().use { it.readText() }
        val html = """
            <html>
                <head>
                    <style>
                        svg{height:100%; width:100%;}
                    </style>
                </head>
                <body>
                    <h1>Map</h1>
                    <div style="position:absolute; top:0; left:0;">
                        $svg
                    </div>
                </body>
            </html>
        """.trimIndent()
        webView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}