package com.example.faceup.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.faceup.R
import com.example.faceup.databinding.FragmentHomePageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomePage : Fragment() {

    private var _binding : FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private val navArgs : HomePageArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nama = navArgs.name.toString()
        binding.tvName.text = nama
        setBottomNav()
    }

    private fun setBottomNav(){
        val navBar = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
        navBar?.visibility = View.VISIBLE
    }

}