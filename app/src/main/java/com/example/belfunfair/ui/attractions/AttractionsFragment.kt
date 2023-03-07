package com.example.belfunfair.ui.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.databinding.FragmentAttractionsBinding
import com.example.belfunfair.adapter.ExpandableListAdapter

import android.widget.Toast
import com.example.belfunfair.ui.attractions.AttractionsExpandableListData.data


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

        setExpandableList()
    }

    private fun setExpandableList(){
        val expandableListView = binding.attractionsExpendableList
        val listData = data
        val titleList = ArrayList(listData.keys)
        val adapter = this.context?.let { ExpandableListAdapter(it, titleList as ArrayList<String>, listData) }
        expandableListView.setAdapter(adapter)
        adapter?.setListeners(expandableListView, listData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}