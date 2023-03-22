package com.example.belfunfair.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.databinding.FragmentMapBinding


class MapFragment : Fragment() {

    private var _mapViewModel: MapViewModel? = null
    private var _binding: FragmentMapBinding? = null
    private lateinit var _jsInterface: JavaScriptInterface

    private val mapViewModel get() = _mapViewModel!!
    private val binding get() = _binding!!
    private val jsInterface get() = _jsInterface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        _jsInterface = JavaScriptInterface(this.requireContext(), this);
        initModel()
        return binding.root
    }

    @SuppressLint("JavascriptInterface")
    private fun initModel(){
        _mapViewModel = ViewModelProvider(this)[MapViewModel::class.java]

        val title: TextView = binding.mapTitle
        mapViewModel.title.observe(viewLifecycleOwner) { title.text = it }

        val map: WebView = binding.map
        setWebViewSettings(map)

        map.addJavascriptInterface(jsInterface, "Android")
        map.loadUrl("file:///android_asset/map/map.html")
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebViewSettings(webView: WebView){
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.domStorageEnabled = true
        webSettings.builtInZoomControls = true;
        webSettings.loadWithOverviewMode = true;
        webSettings.useWideViewPort = false;
    }
    fun setAttractions(list: ArrayList<Any>) {
        activity?.runOnUiThread {
            val attractions: TextView = binding.mapAttractions
            attractions.text = list.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}