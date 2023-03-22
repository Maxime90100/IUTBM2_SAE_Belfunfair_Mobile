package com.example.belfunfair.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.databinding.FragmentMapBinding
import com.example.belfunfair.ui.attractions.AttractionsExpandableListData


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

    @SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
    private fun initModel(){
        _mapViewModel = ViewModelProvider(this)[MapViewModel::class.java]

        val title: TextView = binding.mapTitle
        mapViewModel.title.observe(viewLifecycleOwner) { title.text = it }

        val map: WebView = binding.map
        map.settings.javaScriptEnabled = true
        map.settings.javaScriptCanOpenWindowsAutomatically = true
        map.settings.domStorageEnabled = true

        map.addJavascriptInterface(JavaScriptInterface(this.context), "Android")
        map.loadUrl("file:///android_asset/map/map.html")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}