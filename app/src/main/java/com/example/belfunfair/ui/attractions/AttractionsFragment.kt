package com.example.belfunfair.ui.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.databinding.FragmentAttractionsBinding

class AttractionsFragment : Fragment() {

    private var _binding: FragmentAttractionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val attractionsViewModel =
            ViewModelProvider(this).get(AttractionsViewModel::class.java)

        _binding = FragmentAttractionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.attractionsTitle
        attractionsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}