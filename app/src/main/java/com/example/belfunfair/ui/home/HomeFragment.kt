package com.example.belfunfair.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.belfunfair.MainActivity
import com.example.belfunfair.R
import com.example.belfunfair.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _homeViewModel: HomeViewModel? = null
    private var _binding: FragmentHomeBinding? = null

    private val homeViewModel get() = _homeViewModel!!
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initModel()
        return binding.root
    }

    private fun initModel(){
        _homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val title: TextView = binding.homeTitle
        homeViewModel.title.observe(viewLifecycleOwner) { title.text = it }

        val date: TextView = binding.homeDate
        homeViewModel.date.observe(viewLifecycleOwner) { date.text = it }

        val description: TextView = binding.homeDescription
        homeViewModel.description.observe(viewLifecycleOwner) { description.text = it }

        val imageLogo: ImageView = binding.homeImageLogo
        val imageCarrousel: ImageView = binding.homeImageCarrousel
        val imageLion: ImageView = binding.homeImageLion
        val isDarkMode = context?.let { MainActivity().isDarkMode(it) } ?: false
        if (isDarkMode) {
            imageLogo.setImageResource(R.drawable.image_logo_belfunfair_dark)
            imageCarrousel.setImageResource(R.drawable.image_carrousel_night)
            imageLion.setImageResource(R.drawable.image_lion_belfort_night)
        } else {
            imageLogo.setImageResource(R.drawable.image_logo_belfunfair_light)
            imageCarrousel.setImageResource(R.drawable.image_carrousel_day)
            imageLion.setImageResource(R.drawable.image_lion_belfort_day)
        }

        val switch: SwitchCompat = binding.switchLight
        // Open app with system Light Mode
        switch.isChecked = isDarkMode
        // Switch Light Mode in app
        switch.setOnCheckedChangeListener { _, isChecked ->
            val mode: Int = if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mode)
            val toastMessage = if (isChecked) "Dark Theme" else "Light Theme"
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
