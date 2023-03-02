package com.example.belfunfair.ui.attractions

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.databinding.FragmentAttractionsBinding

class AttractionsFragment : Fragment() {

    private var _attractionsViewModel: AttractionsViewModel? = null
    private var _binding: FragmentAttractionsBinding? = null

    private val attractionsViewModel get() = _attractionsViewModel!!
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAttractionsBinding.inflate(inflater, container, false)
        initModel()
        return binding.root
    }

    private fun initModel(){
        _attractionsViewModel = ViewModelProvider(this)[AttractionsViewModel::class.java]

        val title: TextView = binding.attractionsTitle
        attractionsViewModel.title.observe(viewLifecycleOwner) { title.text = it }

        val listView: ListView = binding.attractionsList
        val list: Array<Manege> = attractionsViewModel.attractions.value ?: emptyArray()
        val arrayAdapter: ArrayAdapter<Manege>? = this.context?.let { ArrayAdapter(it, R.layout.simple_list_item_1, list) }
        listView.adapter = arrayAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}