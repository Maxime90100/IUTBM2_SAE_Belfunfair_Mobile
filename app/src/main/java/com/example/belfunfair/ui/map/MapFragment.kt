package com.example.belfunfair.ui.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.databinding.FragmentMapBinding
import com.example.belfunfair.ui.map.MapViewModel


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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}